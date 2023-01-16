package starter.reqres.StepDef;

import Utils.ReqresResponses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
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


    @And("Response body page should be {int} and {string}")
    public void responseBodyPageShouldBeIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Response body page should be error {string}")
    public void responseBodyPageShouldBeError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }

    @And("Validate user get id and token")
    public void validateUserGetIdAndToken() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA+"/GetIdToken.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate user get error massage")
    public void validateUserGetErrorMassage() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA+"/GetErrorSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Register with email and null password")
    public void registerWithEmailAndNullPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST+"/EmptyPass.json");
        reqresAPI.registerUser(json);
    }
}
