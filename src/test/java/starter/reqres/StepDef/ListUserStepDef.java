package starter.reqres.StepDef;

import Utils.ReqresResponses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.jruby.embed.variable.Constant;
import starter.ReqresAPI;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class ListUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Latihan
    @Given("Get list user with page {int}")
    public void getListUserWithPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate json schema list user")
    public void validateJsonSchemaListUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/listUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Tugas 1 Get List User
    @Given("Get list all user")
    public void getListAllUser() {
        reqresAPI.getListAllUsers();
    }

    @When("Send request get list all user")
    public void sendRequestGetListAllUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_ALL_USERS);
    }

    @And("Response body page should be all page")
    public void responseBodyPageShouldBeAllPage() {
        SerenityRest.then();
    }


    //Tugas2 Get List User
    @Given("Get list user by {int}")
    public void getListUserById(int id) {
        reqresAPI.getUserById(id);
    }

    @When("Send request get list user by id")
    public void sendRequestGetListUserById() {
        SerenityRest.when().get(ReqresAPI.GET_USER_ID);
    }

    @And("Response body page should be {int} user")
    public void responseBodyPageShouldBeIdUser(int id) {
        SerenityRest.then().body(ReqresResponses.DATA_ID, equalTo(id));
    }

    @And("Validate json schema user id")
    public void validateJsonSchemaUserId() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/ListUserIdSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Tugas 3 Get List User

    @Given("Get user by {int}")
    public void getUserById(int id) {
        reqresAPI.getUserById(id);
    }

    @When("Send request get user by id")
    public void sendRequestGetUserById() {
        SerenityRest.when().get(ReqresAPI.GET_USER_ID);
    }


    //Tugas 4 Get List User
    @Given("Ge list user by {int}")
    public void geListUserByEmail(int email) {
        reqresAPI.getUserByEmail(email);
    }

    @When("Send request get list user by email")
    public void sendRequestGetListUserByEmail() {
        SerenityRest.when().get(ReqresAPI.GET_USER_EMAIL);
    }

}
