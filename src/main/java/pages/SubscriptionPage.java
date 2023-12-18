package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.python.antlr.ast.Break;

public class SubscriptionPage {

    private SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    public SubscriptionPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    private final String URL = System.getProperty("URL");
    private String currentCountry = "Bahrain";
    private String currentLang = "Arabic";

    public static By changeCountryButton() {
        return By.id("country");
    }
    public static By changeLanguageButton() {
        return By.id("translation-btn");
    }
    public static By redeemCodeButton(){return By.xpath("//button[text()=\"Click here\"]");}


    public static By selectCountry(String country){
        return By.id(country);
    }

    public static By LITEPLANPrice(String language){
        By planPrice = null;
        switch (language){
            case "English":
                planPrice = By.id("currency-lite");
                break;
            case "Arabic":
                planPrice = By.id("currency-لايت");
                break;
        }
        return planPrice;
    }
    public static By CLASSICPlanPrice(String language){
        By planPrice = null;
        switch (language){
            case "English":
                planPrice = By.id("currency-classic");
                break;
            case "Arabic":
                planPrice = By.id("currency-الأساسية");
                break;
        }
        return planPrice;
    }
    public static By PREMIUMPlanPrice(String language){
        By planPrice = null;
        switch (language){
            case "English":
                planPrice = By.id("currency-premium");
                break;
            case "Arabic":
                planPrice = By.id("currency-بريميوم");
                break;
        }
        return planPrice;
    }

    public static By LITEPLANName(String language){
        By planName = null;
        switch (language){
            case "English":
                planName = By.id("name-lite");
                break;
            case "Arabic":
                planName = By.id("name-لايت");
                break;
        }
        return planName;
    }
    public static By CLASSICPLANName(String language){
        By planName = null;
        switch (language){
            case "English":
                planName = By.id("name-classic");
                break;
            case "Arabic":
                planName = By.id("name-الأساسية");
                break;
        }
        return planName;
    }
    public static By PREMIUMPLANName(String language){
        By planName = null;
        switch (language){
            case "English":
                planName = By.id("name-premium");
                break;
            case "Arabic":
                planName = By.id("name-بريميوم");
                break;
        }
        return planName;
    }

    public static By LITEPLANVideoQuality(){
       return By.xpath("//div[text()=\"HD\"]");
    }
    public static By ClassicPLANVideoQuality(){
        return By.xpath("//div[text()=\"Full HD\"]");
    }
    public static By PremiumPLANVideoQuality(){
        return By.xpath("//div[text()=\"4K UHD\"]");
    }



    public SubscriptionPage openPortal(){
        driver.browser().navigateToURL(URL);
        return this;
    }

    public SubscriptionPage switchMarket(String country){
        driver.element().click(changeCountryButton());
        switch (country) {
            case "Bahrain": {
                currentCountry = "Bahrain";
                driver.element().click(selectCountry("bh"));
                break;
            }
            case "KSA": {
                currentCountry = "KSA";
                driver.element().click(selectCountry("sa"));
                break;
            }
            case "Kuwait": {
                currentCountry = "Kuwait";
                driver.element().click(selectCountry("kw"));
                break;
            }
        }
        return this;
    }

    public SubscriptionPage switchLanguage(String Language){
        String currentLanguge = driver.element().getText(changeLanguageButton());
        switch (Language){
            case "Arabic":
                if (currentLanguge.equals("English")){
                    currentLang = "English";
                    break;
                }else{
                    driver.element().click(changeLanguageButton());
                    currentLang = "Arabic";
                }
                break;
            case "English":
                if (currentLanguge.equals("English")){
                    driver.element().click(changeLanguageButton());
                    currentLang = "Arabic";
                }else{
                    currentLang = "English";
                    break;
                }
                break;
        }
        return this;
    }

    public String getCurrentLanguage(){
        return currentLang;
    }

    public RedeemGiftPage moveToRedeemGiftPage(){
        driver.element().click(redeemCodeButton());
        return new RedeemGiftPage(driver);
    }

    public String ExpectedCountryLitePlanPrice(){
        testData = new SHAFT.TestData.JSON("testData.json");
        String LitePrice = testData.getTestData(currentCountry+".En.prices[0]");
        switch (currentLang){
            case "English":
                LitePrice = testData.getTestData(currentCountry+".En.prices[0]");
                break;
            case "Arabic":
                LitePrice = testData.getTestData(currentCountry+".Ar.prices[0]");
                break;
        }

        return LitePrice;
    }
    public String ExpectedCountryClassicPlanPrice(){
        testData = new SHAFT.TestData.JSON("testData.json");
        String classicPrice = "English";
        switch (currentLang){
            case "English":
                classicPrice = testData.getTestData(currentCountry+".En.prices[1]");
                break;
            case "Arabic":
                classicPrice = testData.getTestData(currentCountry+".Ar.prices[1]");
                break;
        }

        return classicPrice;
    }
    public String ExpectedCountryPremiumPlanPrice(){
        testData = new SHAFT.TestData.JSON("testData.json");
        String premiumPrice = "English";
        switch (currentLang){
            case "English":
                premiumPrice = testData.getTestData(currentCountry+".En.prices[2]");
                break;
            case "Arabic":
                premiumPrice = testData.getTestData(currentCountry+".Ar.prices[2]");
                break;
        }

        return premiumPrice;
    }

    public String ExpectedCountryLitePlanVideoQuality(){
        testData = new SHAFT.TestData.JSON("testData.json");
        String liteQuality = testData.getTestData(currentCountry+".En.videoQuality[0]");
        return liteQuality;
    }
    public String ExpectedCountryClassicPlanVideoQuality(){
        testData = new SHAFT.TestData.JSON("testData.json");
        String classicQuality = testData.getTestData(currentCountry+".En.videoQuality[1]");
        return classicQuality;
    }
    public String ExpectedCountryPremiumPlanVideoQuality(){
        testData = new SHAFT.TestData.JSON("testData.json");
        String premiumQuality = testData.getTestData(currentCountry+".En.videoQuality[2]");
        return premiumQuality;
    }


}
