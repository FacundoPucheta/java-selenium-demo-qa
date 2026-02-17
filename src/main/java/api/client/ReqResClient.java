package api.client;

import api.config.ApiRequestSpec;
import api.dto.SingleUserResponseDTO;
import api.dto.UserDTO;

import static io.restassured.RestAssured.given;

public class ReqResClient extends ApiRequestSpec {

    public UserDTO createUser(String name, String job) {
        return given().spec(requestSpec)
                .body("""
                        {
                          "name": "%s",
                          "job": "%s"
                        }
                        """
                        .formatted(name, job))
                .post("/users")
                .then()
                .statusCode(201)
                .extract().as(UserDTO.class);
    }

    public UserDTO getUserById(String userId) {
        return given().spec(requestSpec)
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(200)
                .extract().as(SingleUserResponseDTO.class).getData();
    }
}
