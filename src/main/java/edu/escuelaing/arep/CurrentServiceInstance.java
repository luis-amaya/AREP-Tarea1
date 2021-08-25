package edu.escuelaing.arep;

/**
 * Singleton instance to handle the service
 * 
 */
public class CurrentServiceInstance {
    private static CurrentServiceInstance _instance = new CurrentServiceInstance();
    private HttpStockService service;

    /**
     * Set the type of service
     */
    private CurrentServiceInstance() {
        service = new AlphaHttpStockService();
    }

    /**
     * Returns an instance of the service
     * 
     * @return the instance of the service
     */
    public static CurrentServiceInstance getInstance() {
        return _instance;
    }

    /**
     * Returns the type of service
     * 
     * @return Type of service (HttpStockService)
     */
    public HttpStockService getService() {
        return service;
    }
}
