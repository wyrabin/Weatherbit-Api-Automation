package starter;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static String BASE_URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static String JSON_REQUEST = DIR + "/src/test/resources/JSON/Request";
    public static String JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema";
    public static String GET_LIST_USERS = BASE_URL + "/api/users?page={page}";
    public static String GET_LIST_ALL_USERS = BASE_URL + "/api/users";
    public static String GET_USER_ID = BASE_URL + "/api/users/{id}";
    public static String GET_USER_EMAIL = BASE_URL + "/api/users?email={email}";
    public static String POST_CREATE_USER = BASE_URL + "/api/users";
    public static String PUT_UPDATE_USER = BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = BASE_URL + "/api/users/{id}";
    public static String LOGIN_USER = BASE_URL + "/api/login";
    public static String REGISTER_USER = BASE_URL + "/api/register";

    @Step("Get list User")
    public void getListUsers(int page) {
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get list all user")
    public void getListAllUsers() {
        SerenityRest.given();
    }

    @Step("Get user by id")
    public void getUserById(int id) {
        SerenityRest.given().pathParam("id", id);
    }


    @Step("Get user by email")
    public void getUserByEmail(int email) {
        SerenityRest.given().pathParam("email", email);
    }

    @Step("Post create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void updateUsers(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete user invalid param")
    public void deleteUserInvalidParam(String id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Login user")
    public void loginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Unsuccessful Login")
    public void unsuccessfulLogin(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Register user")
    public void registerUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
