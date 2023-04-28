package starter.Weatherbit;

import Utils.Constant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class ForecastWeatherDataStepDef {

    @Steps
    WeatherbitAPI weatherbitAPI;

    @Given("Display all data by postal code as {int}")
    public void displayAllDataByPostalCodeAs(int postal_code) {
        weatherbitAPI.getForecastWeatherData(postal_code, Constant.KEY);
    }

    @When("Send request get forecast weather data")
    public void sendRequestGetForecastWeatherData() {
        SerenityRest.when().get(WeatherbitAPI.GET_FORECAST_WEATHER_DATA);
    }

    @And("Get value timestamp_utc and weather")
    public void getValueTimestamp_utcAndWeather() throws JsonProcessingException {
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonNode jsonNode = new ObjectMapper().readTree(responseBody);

        for (JsonNode dataEntry : jsonNode.get("data")) {
            String timestampUtc = dataEntry.get("timestamp_utc").toString();
            String weather = dataEntry.get("weather").toString();

            System.out.println("Timestamp UTC: " + timestampUtc);
            System.out.println("Weather Description: " + weather);
            System.out.println("===============================");

        }
    }
}

