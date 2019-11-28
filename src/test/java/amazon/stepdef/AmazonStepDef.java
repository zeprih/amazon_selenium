package amazon.stepdef;

import amazon.pages.SwitchCase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static amazon.WebUtility.*;

public class AmazonStepDef {

    private ChromeDriver _driver = getChromeInstance();

    @Given("^User go to website amazon$")
    public void user_go_to_website_amazon() {
        redirectTo("https://www.amazon.com/");
        redirectTo("https://www.amazon.com/");
    }

    @When("^User go to page create account$")
    public void user_go_to_page_create_account() {
        waitAndClick(By.xpath("//*[@id=\"nav-signin-tooltip\"]/div/a"));
    }

    @When("^User go to page sign in$")
    public void user_go_to_page_sign_in() {
        waitAndClick(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span"));
    }

    @When("^User click button to continue$")
    public void user_click_button_to_continue() {
        waitAndClick(By.id("continue"));
    }

    @When("^User click button sign in$")
    public void user_click_button_sign_in() {
        waitAndClick(By.id("signInSubmit"));
    }

    @Then("^System display box alert error$")
    public void system_display_box_alert_error() {
        waitForElementVisible(By.id("auth-error-message-box"));
    }

    @Then("^System display link sign out$")
    public void system_display_link_sign_out() {
        mouseOver(By.id("nav-signin-tooltip"));
        waitForElementVisible(By.id("nav-item-signout"));
    }

    @When("^User input \"([^\"]*)\" to field \"([^\"]*)\"$")
    public void user_input_to_field(String value, String field) {
        waitAndFill(By.id(SwitchCase.IDforField(field)), value);
    }

    @Then("^System display form error on field \"([^\"]*)\"$")
    public void system_display_form_error_on_field(String fieldName) {
        getValueAttributeObject(By.id(SwitchCase.IDforField(fieldName))).contains("a-form-error");
    }

    @Then("^Close browser$")
    public void close_browser() {
        closeBrowser();
    }
}
