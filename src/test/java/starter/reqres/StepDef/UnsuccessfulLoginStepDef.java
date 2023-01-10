package starter.reqres.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.ReqresAPI;

import java.io.File;

public class UnsuccessfulLoginStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Login with email and empty password")
    public void loginWithEmailAndEmptyPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST +"/EmptyPass.json");
        reqresAPI.unsuccessfulLogin(json);
    }
}
