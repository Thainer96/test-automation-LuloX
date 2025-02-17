package testLuloApi.models.employee;


import com.fasterxml.jackson.annotation.JsonProperty;


public record SingleEmployeeResponse(
        @JsonProperty("status") String status,
        @JsonProperty("data") EmployeeData data,
        @JsonProperty("message") String message
) {
    public record EmployeeData(
            @JsonProperty("id") int id,
            @JsonProperty("employee_name") String employee_name,
            @JsonProperty("employee_salary") String employee_salary,
            @JsonProperty("employee_age") String employee_age,
            @JsonProperty("profile_image") String profile_image
    ) {}
}
