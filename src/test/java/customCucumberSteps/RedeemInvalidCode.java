package customCucumberSteps;

import com.shaft.driver.SHAFT;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.RedeemGiftPage;
import pages.SubscriptionPage;

public class RedeemInvalidCode {
    private SHAFT.GUI.WebDriver driver;
    private SubscriptionPage subscriptionPage;
    private RedeemGiftPage redeemGiftPage;

    @Before
    public void init(){
        driver = new SHAFT.GUI.WebDriver();
        subscriptionPage = new SubscriptionPage(driver);
        redeemGiftPage = new RedeemGiftPage(driver);
        subscriptionPage.openPortal();
    }

    @Given("I Navigate to STC  Website")
    public void navigateToSubPage(){
        subscriptionPage.openPortal();
    }

    @When("I Change page to redeem code page")
    public void moveToRedeemCodePage(){
        subscriptionPage.moveToRedeemGiftPage();
    }

    @And("I enter invalid redeem code")
    public void enterInvalidRedeemCode(){
        redeemGiftPage.inputInvalidRedeemCode();
    }

    @Then("I Should see an error message")
    public void validateRedeemCodeErrorMsg(){
        driver.assertThat().element(RedeemGiftPage.redeemCodeErrorMessage()).exists().perform();
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
