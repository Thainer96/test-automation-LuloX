package testLuloApi.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import testLuloApi.utilities.ResponseManager;

import static org.junit.Assert.assertEquals;

public class CommonStepDefinition {

    @Then("se verifica el status code sea {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        ResponseManager.verifyStatusCode(expectedStatusCode);
    }

    @And("the response status should be {string}")
    public void theResponseStatusShouldBe(String expectedStatus) {
        ResponseManager.verifyStatusText(expectedStatus);
    }

    @And("the value of Json {string} is different null")
    public void theValueOfJsonIsDifferentNull(String propertyJson) {
        ResponseManager.isPropertyNull(propertyJson);
    }

    @And("se cerifica que el respose time sea menor de {int} ms")
    public void verifyResponseTime(int maxResponseTime) {
        ResponseManager.verifyResponseTime(maxResponseTime);
    }
}
