package edu.escuelaing.arep;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Minimal web app example for Heroku using SparkWeb
 *
 * @author daniel
 */
public class App {

    /**
     * This main method uses SparkWeb static methods and lambda functions to create
     * a simple Hello World web app. It maps the lambda function to the /hello
     * relative URL.
     */
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        // staticFiles.location("/public/html");
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
        get("/facadealpha", "application/json", (req, res) -> facadeAlpha(req, res));
    }

    /**
     * This method Sets an HTML page, to see how the requests work on WebPage
     * 
     * @param req Request
     * @param res Response
     * @return
     */
    private static String inputDataPage(Request req, Response res) {
        String pageContent = "<!DOCTYPE html>" + "<html>" + "<body>" + "<h2>HTML Forms</h2>"
                + "<form action=\"/results\">" + "  First name:<br>"
                + "  <input type=\"text\" name=\"firstname\" value=\"Mickey\">" + "  <br>" + "  Last name:<br>"
                + "  <input type=\"text\" name=\"lastname\" value=\"Mouse\">" + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">" + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>" + "</html>";
        return pageContent;
    }

    /**
     * Sets an String with a Name and a Last Name
     * 
     * @param req Request
     * @param res Response
     * @return Returns a String with the inputs given on the inputDataPage's html
     */
    private static String resultsPage(Request req, Response res) {
        return req.queryParams("firstname") + " " + req.queryParams("lastname");
    }

    /**
     * This method reads the default port as specified by the PORT variable in the
     * environment.
     *
     * Heroku provides the port automatically so you need this to run the project on
     * Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
    }

    /**
     * Sets the query params given, to redirect to the page wqith the "JSON" content
     * 
     * @param req Request
     * @param res Response
     * @return String with the response given by the TimesSerialDaily
     */
    private static String facadeAlpha(Request req, Response res) {
        String stock = req.queryParams("st");
        System.out.println("Stock str: " + stock);
        String response = "None";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getService();
        if (stock != null && stock != "") {
            System.out.println("Setting stock to: " + stock);
            stockService.setStock(stock);
        }

        try {
            response = stockService.TimeSeriesDaily();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
}