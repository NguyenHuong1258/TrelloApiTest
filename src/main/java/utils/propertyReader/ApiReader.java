package utils.propertyReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApiReader {
    private Properties properties;
    private final String apiPropertyFilePath = "src/main/resources/properties/Api.properties";

    // Read and load properties file
    public ApiReader() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(apiPropertyFilePath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw  new RuntimeException("Configuration file is not found at: " + apiPropertyFilePath);
        }
    }

    //=============================================================================================

    //Get BaseURl
    public String getBaseUrl(){
        return properties.getProperty("baseUrl");
    }

    //Get key
    public String getkey(){
        return properties.getProperty("key");
    }

    //Get key
    public String getToken(){
        return properties.getProperty("token");
    }

}
