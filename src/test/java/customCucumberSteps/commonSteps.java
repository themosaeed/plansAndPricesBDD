package customCucumberSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class commonSteps {


    @When("I Select {string}")
    public void selectMarket(String market){
        Hooks.subscriptionPage.switchMarket(market);
    }


    @And("I Change {string}")
    public void changeLanguage(String Language){
        Hooks.subscriptionPage.switchLanguage(Language);
    }


}
