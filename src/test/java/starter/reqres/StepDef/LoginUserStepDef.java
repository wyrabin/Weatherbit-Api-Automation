package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ReqresAPI;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Login with valid email and password")
    public void loginWithValidEmailAndPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST +"/RequestLogin.json");
        reqresAPI.loginUser(json);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @And("Validate user get token")
    public void validateUserGetToken() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA+"/LoginUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @Given("Login with valid email and empty password")
    public void loginWithValidEmailAndEmptyPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST +"/WithoutPass.json");
        reqresAPI.loginUser(json);

    }
}
