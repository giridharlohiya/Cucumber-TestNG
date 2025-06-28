package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    /**
     * Loads properties from the config.properties file
     * 
     * @return Properties object
     */
    public Properties init_prop() {
        prop = new Properties();
        String path = "./src/test/resources/config/config.properties";
        
        try (FileInputStream ip = new FileInputStream(path)) {
            prop.load(ip);
        } catch (IOException e) {
            System.out.println("Failed to load config.properties from: " + path);
            e.printStackTrace();
        }
        
        return prop;
    }
}
