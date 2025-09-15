package Utility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class ApiUtils {
    static String URL = ConfigReader.get("api_url");
    // Overloaded method: without payload (GET, DELETE)
    public static Response sendRequest(String method, String endpoint) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .request(method, URL+endpoint)
                .then()
                .extract().response();
    }

    // Overloaded method: with payload (POST, PUT, PATCH)
    public static Response sendRequest(String method, String endpoint, String payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .request(method, URL+endpoint)
                .then()
                .extract().response();
    }
}