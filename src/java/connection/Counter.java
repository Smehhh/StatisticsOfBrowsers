package connection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BURNERON
 */
public class Counter {
    private List<Browser> browsers = new ArrayList<>();
    private long total;

    public List<Browser> getBrowsers() {
        return browsers;
    }

    public void setBrowsers(List<Browser> browsers) {
        this.browsers = browsers;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
}
