package testLuloApi.request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testLuloApi.utilities.BaseRequest;
import testLuloApi.utilities.ResponseManager;

public class EmployeeRequest extends BaseRequest {

    public void searchAllEmployees(String url){
        final var response = getRequest()
                .get(url);
        validateResponse(response);
        System.out.println(response.getBody().asString());
        ResponseManager.setResponse(response);
    }

    public void createEmployee(String payload,String url){
       /* getRequest()
                .body(payload)
                .log().all() // Loguea toda la solicitud (encabezados, cuerpo, etc.)
                .post(url);*/
        RequestSpecification customRequest = io.restassured.RestAssured.given()
                .header("Content-Type", "application/json")
                .cookie("humans_21909", "1");
        final var response = customRequest.body(payload).post(url);
        validateResponse(response);
        System.out.println(response.getBody().asString());
        ResponseManager.setResponse(response);
    }


    public static void validateResponse(Response response){
        String responseBody = response.getBody().asString();
        String contentType = response.getContentType();
        int statusCode = response.getStatusCode();
        if (contentType.contains("application/json")) {
            try {
                ResponseManager.setResponse(response);
            } catch (Exception e) {
                throw new RuntimeException("Error parsing JSON: " + e.getMessage());
            }
        } else if (contentType.contains("text/html")) {
            if (statusCode == 429) {
                throw new RuntimeException("Error 429: Too Many Requests" );
            } else {
                throw new RuntimeException("Unexpected HTML response: " + responseBody);
            }
        } else {
            throw new RuntimeException("Error: Unexpected content type " + contentType);
        }
    }
}
