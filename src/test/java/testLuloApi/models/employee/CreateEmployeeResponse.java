package testLuloApi.models.employee;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateEmployeeResponse(
        @JsonProperty("status") String status,
        @JsonProperty("data") EmployeeData data,
        @JsonProperty("message") String message
) {
    public record EmployeeData(
            @JsonProperty("name") String name,
            @JsonProperty("salary") String salary,
            @JsonProperty("age") String age,
            @JsonProperty("id") int id
    ) {}
}
