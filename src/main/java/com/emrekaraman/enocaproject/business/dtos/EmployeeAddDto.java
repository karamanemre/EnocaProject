package com.emrekaraman.enocaproject.business.dtos;
import com.emrekaraman.enocaproject.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAddDto {

    private Long id;
    private String name;
    private String surname;
    private Company company;
}
