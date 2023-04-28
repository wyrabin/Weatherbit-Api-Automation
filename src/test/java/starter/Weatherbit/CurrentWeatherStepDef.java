package starter.Weatherbit;

import Utils.Constant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CurrentWeatherStepDef {

    @Steps
    WeatherbitAPI weatherbitAPI;

    @Given("Display all data by lat as {double} and lon as {double}")
    public void displayAllDataByLatAsAndLonAs(Double lat, Double lon) {
        weatherbitAPI.getWeatherData(lat, lon, Constant.KEY);
    }

    @When("Send request get current weather data")
    public void sendRequestGetCurrentWeatherData() {
        SerenityRest.when().get(WeatherbitAPI.GET_CURRENT_WEATHER_DATA);
    }

    @Then("Should be return status code {int}")
    public void shouldBeReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("State Code is {string}")
    public void stateCodeIs(String stateCode) {
        Response response = SerenityRest.then().body("data[0].state_code", is(equalTo(stateCode))).extract().response();
        System.out.println(response.path("data[0].state_code").toString());
    }
}
