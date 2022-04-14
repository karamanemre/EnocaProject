package com.emrekaraman.enocaproject.api;

import com.emrekaraman.enocaproject.business.abstracts.CompanyService;
import com.emrekaraman.enocaproject.business.dtos.CompanyAddDto;
import com.emrekaraman.enocaproject.core.utilities.DataResult;
import com.emrekaraman.enocaproject.core.utilities.Result;
import com.emrekaraman.enocaproject.entities.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companycontroller")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Company>>> getAll(){
        return ResponseEntity.ok(companyService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<Company>> add(@RequestBody CompanyAddDto companyAddDto){
        return ResponseEntity.ok(companyService.add(companyAddDto));
    }

    @PutMapping("/update")
    public ResponseEntity<DataResult<Company>> update(@RequestBody CompanyAddDto companyAddDto){
        DataResult<Company> result = companyService.update(companyAddDto);
        if (!result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deletebyid")
    public ResponseEntity<Result> deleteById(@RequestParam(name = "id") Long id){
        Result result = companyService.deleteById(id);
        if (!result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }
}
