package edu.escuelaing.arep;

public class AlphaHttpStockService extends HttpStockService {

    String stock = "fb";
    @Override
    public String getURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stock+"&apikey=MFK3ZEHY8ZA3Q9AE";
    }

    @Override
    public void setStock(String stock) {
        this.stock = stock;
        
    }

}
