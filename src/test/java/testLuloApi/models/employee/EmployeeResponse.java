package testLuloApi.models.employee;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmployeeResponse(
            @JsonProperty("id") int id,
            @JsonProperty("employee_name") String employee_name,
            @JsonProperty("employee_salary") int employee_salary,
            @JsonProperty("employee_age") int employee_age,
            @JsonProperty("profile_image") String profile_image
    ) {}
