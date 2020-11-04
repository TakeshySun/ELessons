package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    static Properties pro = new Properties();

    public static String getProperties(String key) throws Exception {
        // load data from prop.File
        File src = new File("src/main/resources/config.properties");
        FileInputStream fis = new FileInputStream(src);
        pro.load(fis);

        return pro.get(key).toString();
    }


}
