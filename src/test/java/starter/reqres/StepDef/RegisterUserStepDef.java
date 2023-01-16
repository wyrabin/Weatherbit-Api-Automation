package starter.reqres.StepDef;

import Utils.ReqresResponses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ReqresAPI;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Register with email and password")
    public void registerWithEmailAndPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST+"/RegisterUser.json");
        reqresAPI.registerUser(json);
    }

    @When("Send request register new user")
    public void sendRequestRegisterNewUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("Response body page should be {string} and {string}")
    public void responseBodyPageShouldBeAnd(String email, String password) {
        SerenityRest.then()
                .body(ReqresResponses.EMAIL, equalTo(email))
                .body(ReqresResponses.PASSWORD, equalTo(password));
    }
}
