package starter.Weatherbit;

import Utils.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class WeatherbitAPI {

    // Declare Endpoint
    public static String GET_CURRENT_WEATHER_DATA = Constant.BASE_URL + "/current";
    public static String GET_FORECAST_WEATHER_DATA = Constant.BASE_URL +"/forecast/hourly";

    @Step("Get current weather data")
    public void getWeatherData(Double lat, Double lon, String key) {
        SerenityRest.given()
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("key", key)
                .log().all();
    }

    @Step("Get forecast weather data")
    public void getForecastWeatherData(int postal_code, String key){
        SerenityRest.given()
                .queryParam("postal_code", postal_code)
                .queryParam("key", key)
                .log().all();
    }
}
