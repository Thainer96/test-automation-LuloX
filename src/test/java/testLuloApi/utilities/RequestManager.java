package testLuloApi.utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestManager {
    public static void initRequest(){
            RequestSpecification defaultRequest = io.restassured.RestAssured.given()
                .header("Accept", "*/*")
                .cookie("humans_21909", "1");
        new RequestProvider().set(defaultRequest);
    }

}
