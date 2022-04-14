package com.emrekaraman.enocaproject.business.concretes;

import com.emrekaraman.enocaproject.business.abstracts.EmployeeService;
import com.emrekaraman.enocaproject.business.dtos.EmployeeAddDto;
import com.emrekaraman.enocaproject.core.constants.Messages;
import com.emrekaraman.enocaproject.core.utilities.*;
import com.emrekaraman.enocaproject.dataAccess.EmployeeDao;
import com.emrekaraman.enocaproject.entities.Company;
import com.emrekaraman.enocaproject.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult(employeeDao.findAll(),Messages.SUCCESS_GET);
    }

    @Override
    public DataResult<Employee> add(EmployeeAddDto employeeAddDto) {
        Employee employee = modelMapper.map(employeeAddDto,Employee.class);
        return new SuccessDataResult(employeeDao.save(employee), Messages.SUCCESS_ADDED);
    }

    @Override
    public DataResult<Employee> update(EmployeeAddDto employeeAddDto) {
        Optional<Employee> result = employeeDao.findById(employeeAddDto.getId());
        if (result.isEmpty()) {
            return new ErrorDataResult(Messages.USER_NOT_FOUND);
        }
        Employee employee = modelMapper.map(employeeAddDto,Employee.class);
        return new SuccessDataResult(employeeDao.save(employee),Messages.SUCCESS_UPDATED);
    }

    @Override
    public Result deleteById(Long id) {
        if (!employeeDao.existsById(id)) {
            return new ErrorDataResult(Messages.USER_NOT_FOUND);
        }
        employeeDao.deleteById(id);
        return new SuccessResult(Messages.SUCCESS_DELETED);
    }
}
