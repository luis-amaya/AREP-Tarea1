package edu.escuelaing.arep;

public class IEXAPISHttpStockService extends HttpStockService{

    String stock = "fb";

    @Override
    public String getURL() {
        return "https://cloud.iexapis.com/stable/tops?token=pk_71ae7dfce7db48c2a7ccb8eeb1b001f9&symbols="+ stock;
    }

    @Override
    public void setStock(String stock) {
        this.stock = stock;
        
    }
    
}
