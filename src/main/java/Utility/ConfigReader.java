package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    /**
     * This will load properties from config properties file
     * 
     * @return prop object of Properties
     */
    public Properties init_prop() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            
            try {
                prop.load(ip);
            } catch (IOException e) {
                System.out.println("Config Properties File Loading is Failed");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Config Properties File Location is Incorrect");
            e.printStackTrace();
        }
        return prop;
    }

}
