package customCucumberSteps;

import com.shaft.driver.SHAFT;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.RedeemGiftPage;
import pages.SubscriptionPage;

public class Hooks {
    public static SHAFT.GUI.WebDriver driver;
    public static SubscriptionPage subscriptionPage;
    public static RedeemGiftPage redeemGiftPage;

    @Before
    public void init(){
        driver = new SHAFT.GUI.WebDriver();
        subscriptionPage = new SubscriptionPage(driver);
        redeemGiftPage = new RedeemGiftPage(driver);
        subscriptionPage.openPortal();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
