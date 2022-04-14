package com.emrekaraman.enocaproject.business.abstracts;

import com.emrekaraman.enocaproject.business.dtos.CompanyAddDto;
import com.emrekaraman.enocaproject.core.utilities.DataResult;
import com.emrekaraman.enocaproject.core.utilities.Result;
import com.emrekaraman.enocaproject.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public interface CompanyService {

    DataResult<List<Company>> getAll();
    DataResult<Company> add(CompanyAddDto companyAddDto);
    DataResult<Company> update(CompanyAddDto companyAddDto);
    Result deleteById(Long id);
}
