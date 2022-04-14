package com.emrekaraman.enocaproject.business.abstracts;

import com.emrekaraman.enocaproject.business.dtos.CompanyAddDto;
import com.emrekaraman.enocaproject.business.dtos.EmployeeAddDto;
import com.emrekaraman.enocaproject.core.utilities.DataResult;
import com.emrekaraman.enocaproject.core.utilities.Result;
import com.emrekaraman.enocaproject.entities.Company;
import com.emrekaraman.enocaproject.entities.Employee;

import java.util.List;

public interface EmployeeService {

    DataResult<List<Employee>> getAll();
    DataResult<Employee> add(EmployeeAddDto employeeAddDto);
    DataResult<Employee> update(EmployeeAddDto employeeAddDto);
    Result deleteById(Long id);
}
