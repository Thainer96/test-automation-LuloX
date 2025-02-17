package testLuloApi.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import jsonProcess.BodyJsonManager;
import testLuloApi.models.employee.CreateEmployeeResponse;
import testLuloApi.models.employee.SingleEmployeeResponse;
import testLuloApi.models.employees.EmployeesResponse;
import testLuloApi.request.EmployeeRequest;
import testLuloApi.utilities.ResponseManager;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class EmployeeStepDefinition {
    private final EmployeeRequest employeeRequest = new EmployeeRequest();
    private SingleEmployeeResponse singleEmployeeResponse;
    private EmployeesResponse employeesResponse;

    private CreateEmployeeResponse createEmployeeResponse;
    private final BodyJsonManager bodyJsonManager = new BodyJsonManager();

    @Given("I send a GET request to {string}")
    public void iSendAGETRequestTo(String url) {
        employeeRequest.searchAllEmployees(url);
        employeesResponse = ResponseManager.getResponseBody(EmployeesResponse.class);
        System.out.println(employeesResponse);
    }

    @And("the response should contain {int} employees")
    public void theResponseShouldContainEmployees(int expectedEmployeeCount) {
        assertEquals(expectedEmployeeCount, employeesResponse.data().size());
    }


    @Given("I send a GET request to {string} with employee {string}")
    public void iSendAGETRequestToWithEmployee(String url, String idEmployee) {
        employeeRequest.searchAllEmployees(url+idEmployee);
        singleEmployeeResponse = ResponseManager.getResponseBody(SingleEmployeeResponse.class);
        System.out.println(singleEmployeeResponse);
    }


    @Given("a user build to payload {string}")
    public void aUserBuildToPayload(String bodyName, DataTable featureData) {
        Map<String, Object> data = new HashMap<>();
        featureData.asMaps(String.class, Object.class).forEach(row -> row.forEach(data::put));
        String bodyBuild = bodyJsonManager.buildBodyWithData(bodyName, data);
        employeeRequest.createEmployee(bodyBuild,"http://dummy.restapiexample.com/api/v1/create");
        createEmployeeResponse = ResponseManager.getResponseBody(CreateEmployeeResponse.class);
        System.out.println(createEmployeeResponse);
    }
}
