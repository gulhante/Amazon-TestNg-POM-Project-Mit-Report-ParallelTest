package utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    public static Properties properties;   //Create Properties instance

    static{
        String filePath="configuration.properties";  //path of the configuration file
        try {
            FileInputStream fis=new FileInputStream(filePath);
            // fis dosyayolunu tanimladigimiz configuration.properties dosyasini okudu
            properties=new Properties();
            properties.load(fis); // fis'in okudugu bilgileri properties'e yukledi
            //close the file
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
