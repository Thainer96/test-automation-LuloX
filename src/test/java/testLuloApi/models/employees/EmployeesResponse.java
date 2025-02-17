package testLuloApi.models.employees;

import com.fasterxml.jackson.annotation.JsonProperty;
import testLuloApi.models.employee.EmployeeResponse;

import java.util.List;

public record EmployeesResponse(
        @JsonProperty("status") String status,
        @JsonProperty("data") List<EmployeeResponse> data,
        @JsonProperty("message") String message
) {}
