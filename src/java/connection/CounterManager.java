package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;


public class CounterManager {

    public static Counter createCounter(String browserName) throws SQLException {

        Connection connection = DBConnection.getConnection();

        if (browserName != null) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO site_visit(name, count) VALUES(?, 1) "
                    + " ON DUPLICATE KEY UPDATE count = count + 1;"
            )) {
                statement.setString(1, browserName);
                statement.execute();
            }

        }

        Counter counter = new Counter();
        long sum = 0;

        try (Statement statement = connection.createStatement()) {
            try (ResultSet result = statement.executeQuery("SELECT name name, count count FROM site_visit")) {
                while (result.next()) {
                    long count = result.getLong("count");
                    String name = result.getString("name");

                    counter.getBrowsers().add(new Browser(name, count));
                    sum += count;
                }
            }
        }
        
        for(Browser browser : counter.getBrowsers()) {
            browser.setRequestPercent(browser.getRequestCount() * 100.0 / sum);
        }  
        counter.setTotal(sum);
        return counter;
    }
    
    public static String getBrowser(String userAgent) {
        String browser;
        if (userAgent.contains("Chrome"))
            browser = "Google Chrome or Chromium-based";
        else if (userAgent.contains("Opera") || userAgent.contains("Presto"))
            browser = "Opera";
        else if (userAgent.contains("Yandex"))
            browser = "Yandex";
        else if (userAgent.contains("Firefox"))
            browser = "Mozilla Firefox";
        else if (userAgent.contains("MSIE") || userAgent.contains("Trident"))
            browser = "Internet Explorer";
        else
            browser = "Unknown browsers";
        return browser;
    }
    
    
}
