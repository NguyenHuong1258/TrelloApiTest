package utils.propertyReader;

public class PropertyReaderManager {
    private static PropertyReaderManager instance;
    private static ApiReader apiReader;

    // private constructor in singleton design pattern
    private PropertyReaderManager() {}

    public static PropertyReaderManager getInstance() {
        if(instance == null) {
            instance = new PropertyReaderManager();
        }

        return instance;
    }

    public ApiReader getApiReader(){
        return (apiReader ==null) ? new ApiReader() : apiReader;
    }
}
