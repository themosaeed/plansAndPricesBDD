package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class RedeemGiftPage {
    private SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    public RedeemGiftPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public static By redeemCodeInputField(){
        return By.name("username");
    }
    public static By redeemCodeSubmitButton(){
        return By.xpath("//button[@type=\"submit\"]");
    }
    public static By redeemCodeErrorMessage(){
        return By.className("error-msg");
    }


    public RedeemGiftPage inputInvalidRedeemCode(){
        testData = new SHAFT.TestData.JSON("redeemCode.json");
        String invalidCode = testData.getTestData("invalidCode");
        driver.element().type(redeemCodeInputField(),invalidCode).click(redeemCodeSubmitButton());
        return this;
    }
}
