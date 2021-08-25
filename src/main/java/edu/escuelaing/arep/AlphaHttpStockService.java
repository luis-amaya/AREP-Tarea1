package edu.escuelaing.arep;

/**
 * Http Service to consult on Alpha Vantage API, makes a connection and gets a
 * response
 */
public class AlphaHttpStockService extends HttpStockService {

    String stock = "fb";

    @Override
    public String getURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stock
                + "&apikey=MFK3ZEHY8ZA3Q9AE";
    }

    @Override
    public void setStock(String stock) {
        this.stock = stock;

    }

}
