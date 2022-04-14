package com.emrekaraman.enocaproject.api;

import com.emrekaraman.enocaproject.business.abstracts.EmployeeService;
import com.emrekaraman.enocaproject.business.dtos.CompanyAddDto;
import com.emrekaraman.enocaproject.business.dtos.EmployeeAddDto;
import com.emrekaraman.enocaproject.core.utilities.DataResult;
import com.emrekaraman.enocaproject.core.utilities.Result;
import com.emrekaraman.enocaproject.entities.Company;
import com.emrekaraman.enocaproject.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeecontroller")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Employee>>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<Employee>> add(@RequestBody EmployeeAddDto employeeAddDto){
        return ResponseEntity.ok(employeeService.add(employeeAddDto));
    }

    @PutMapping("/update")
    public ResponseEntity<DataResult<Employee>> update(@RequestBody EmployeeAddDto employeeAddDto){
        DataResult<Employee> result = employeeService.update(employeeAddDto);
        if (!result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deletebyid")
    public ResponseEntity<Result> deleteById(@RequestParam(name = "id") Long id){
        Result result = employeeService.deleteById(id);
        if (!result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }
}
