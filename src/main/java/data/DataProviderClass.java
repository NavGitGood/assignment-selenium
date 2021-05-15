package data;

import org.testng.annotations.DataProvider;
import setup.ConfigurationLoader;

public class DataProviderClass {

    @DataProvider(name = "urlProvider")
    public static Object[][] urlDP(){
        Object[][] url = new Object[1][1];
        url[0][0] = ConfigurationLoader.getPropertyValue("url");
        return url;
    }

    @DataProvider(name = "loginProvider")
    public static Object[][] loginDP(){
        Object[][] loginDetails = new Object[1][2];
        loginDetails[0][0] = ConfigurationLoader.getPropertyValue("email");
        loginDetails[0][1] = ConfigurationLoader.getPropertyValue("password");
        return loginDetails;
    }

    @DataProvider(name = "titleProvider")
    public static Object[][] titleDP(){
        Object[][] titleDetails = new Object[1][1];
        titleDetails[0][0] = ConfigurationLoader.getPropertyValue("title");
        return titleDetails;
    }

    @DataProvider(name = "shopPhoneProvider")
    public static Object[][] shopPhoneDP(){
        Object[][] shopPhone = new Object[1][1];
        shopPhone[0][0] = ConfigurationLoader.getPropertyValue("shopPhone");
        return shopPhone;
    }

    @DataProvider(name = "storeAddressProvider")
    public static Object[][] storeAddressDP(){
        Object[][] storeAddress = new Object[1][1];
        storeAddress[0][0] = ConfigurationLoader.getPropertyValue("storeAddress");
        return storeAddress;
    }

    @DataProvider(name = "storePhoneProvider")
    public static Object[][] storePhoneDP(){
        Object[][] storePhone = new Object[1][1];
        storePhone[0][0] = ConfigurationLoader.getPropertyValue("storePhone");
        return storePhone;
    }

    @DataProvider(name = "storeEmailProvider")
    public static Object[][] storeEmailDP(){
        Object[][] storeEmail = new Object[1][1];
        storeEmail[0][0] = ConfigurationLoader.getPropertyValue("storeEmail");
        return storeEmail;
    }

}
