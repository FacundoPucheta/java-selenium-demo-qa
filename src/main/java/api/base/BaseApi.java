package api.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class BaseApi {
    protected RequestSpecification requestSpec;
    private static final String BASE_URL = ConfigReader.get("api.base.url");
    private static final String API_KEY = ConfigReader.get("reqres.api.key");

    protected BaseApi() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath("/api")
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", API_KEY)
                .build();
    }
}
