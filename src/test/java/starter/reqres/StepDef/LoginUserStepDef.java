package starter.reqres.StepDef;

import Utils.Constant;
import Utils.ReqresResponses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.ReqresAPI;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Login with valid json")
    public void loginWithValidEmailAndPassword() {
        File json = new File(Constant.JSON_REQUEST+"/LoginRequest.json");
        reqresAPI.loginUser(json);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @And("Response body page should be {string}")
    public void responseBodyPageShouldBeAndLogin(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate user get token")
    public void validateUserGetToken() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA+"/LoginUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @Given("Login with valid email and empty password")
    public void loginWithValidEmailAndEmptyPassword() {
        File json = new File(Constant.JSON_REQUEST+"/WithoutPass.json");
        reqresAPI.loginUser(json);

    }
}
