package StepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import OrangeHRMPage.BasePage;
import org.testng.annotations.Test;


public class LoginSteps extends BasePage {

    @Test(priority = 1)
    @When("I go to OrangeHRM Home page.")
    public void iGoToOrangeHomePage() {
        try {
            loginPage.getOrangeHRMHome();
        } catch (Exception e) {
            System.out.println("Username not sent.");
        }
    }

    @Test(priority = 2)
    @And("I enter username and password.")
    public void iEnterUsernameAndPassword() {
        try {
            loginPage.systemLogin("Admin","admin123");
        } catch (Exception e) {
            System.out.println("Username not sent.");
        }
    }

    @Then("I navigate to PIM tab and click on add employee.")
    public void iNavigateToPIMTabAndClickOnAddEmployee() {
        try {
            loginPage.clickOnPIM().clickOnAddEmployee();
        } catch (Exception e) {
            System.out.println("Username not navigate to add employee tab.");
        }
    }

    @And("I enter employee details and save it.")
    public void iEnterEmployeeDetailsAndSaveIt() {
        try {
            loginPage.enterFirstNameAndLastName().fileUpload().checkBoxCreateLoginDetail().enterLoginDetail().verifySuccessMessage().verifySuccessMessageForAdd();
        } catch (Exception e) {
            System.out.println("Username not navigate to add employee tab.");
        }
    }
}

