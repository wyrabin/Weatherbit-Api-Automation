package starter.reqres.StepDef;

import Utils.Constant;
import Utils.ReqresResponses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ReqresAPI;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/RequestUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }


    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Validate json schema create user")
    public void validateJsonSchemaCreateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/CreateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    //Tugas 1
    @Given("Post create user with invalid valid json")
    public void postCreateUserWithInvalidValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/Invalid.json");
        reqresAPI.postCreateUser(json);

    }

    //Tugas 2
    @Given("Post create user with null json")
    public void postCreateUserWithEmptyJson() {
        File json = new File(Constant.JSON_REQUEST+"/NullNameJob.json");
        reqresAPI.postCreateUser(json);

    }

    //Tugas 3
    @Given("Post create user with null name")
    public void postCreateUserWithNullName() {
        File json = new File(Constant.JSON_REQUEST+"/NullName.json");
        reqresAPI.postCreateUser(json);
    }
}
