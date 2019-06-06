package connection;

/**
 *
 * @author BURNERON
 */
public class Browser {
    private String name;
    private long requestCount;
    private double requestPercent;

    public Browser() {
    }

    public Browser(String name, long requestCount) {
        this.name = name;
        this.requestCount = requestCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }

    public double getRequestPercent() {
        return requestPercent;
    }

    public void setRequestPercent(double requestPercent) {
        this.requestPercent = requestPercent;
    }
    
    
}
