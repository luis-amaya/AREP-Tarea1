package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Http Service that makes the consult to an URL/Relative API Makes the
 * connection ang gets a response
 */
public abstract class HttpStockService {

    private static final String USER_AGENT = "Mozilla/5.0";
    // private static final String GET_URL =
    // "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=MFK3ZEHY8ZA3Q9AE";

    /**
     * 
     * @return
     * @throws IOException
     */
    public String TimeSeriesDaily() throws IOException {

        String responseStr = "None";
        URL obj = new URL(getURL());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        // The following invocation perform the connection implicitly before getting the
        // code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code : " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            responseStr = response.toString();
            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return responseStr;
    }

    /**
     * Resolves the requests, must keep in mind the resolutions provided by the API
     * 
     * @return the URL that should be used to search the stock
     */
    abstract public String getURL();

    /**
     * Set the stock symbol that's going to be used to search
     * 
     * @param stock Symbol to search
     */
    abstract public void setStock(String stock);

}
