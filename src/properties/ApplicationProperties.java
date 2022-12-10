package properties;

import java.io.*;
import java.util.Properties;

public class ApplicationProperties {

    private static String filePath = System.getProperty("user.dir") +File.separator+ "BankingSystem/properties" + File.separator + "config" + ".properties";

    public Properties properties = new Properties();

    public void loadProperties()
    {
        try(InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
