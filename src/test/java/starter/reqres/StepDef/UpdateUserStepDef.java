package starter.reqres.StepDef;

import Utils.Constant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ReqresAPI;

import java.io.File;

public class UpdateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;


    @Given("Update user with valid json with id {int}")
    public void updateUserWithValidJsonWithId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.updateUsers(id,json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Given("Update user with invalid json with id {int}")
    public void updateUserWithInvalidJsonWithId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/Invalid.json");
        reqresAPI.updateUsers(id,json);
    }

    @Given("Update user with null name and job with id {int}")
    public void updateUserWithNullNameAndJobWithId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/NullNameJob.json");
        reqresAPI.updateUsers(id,json);
    }

    @Given("Update user with null name with id {int}")
    public void updateUserWithNullNameWithId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/NullName.json");
        reqresAPI.updateUsers(id,json);
    }
}
