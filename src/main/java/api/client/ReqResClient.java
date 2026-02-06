package api.client;

import api.base.BaseApi;
import api.dto.SingleUserResponseDTO;
import api.dto.UserDTO;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReqResClient extends BaseApi {


    public UserDTO createUser(String name, String job) {
        Response response =
                given().spec(requestSpec).body("""
                        {
                          "name": "%s",
                          "job": "%s"
                        }
                        """
                        .formatted(name, job)).post("/users");

        response.then().statusCode(201);
        return response.as(UserDTO.class);
    }

    public UserDTO getUserById(String userId) {
        return given()
                .spec(requestSpec)
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(200)
                .extract()
                .as(SingleUserResponseDTO.class)
                .getData();
    }

}
