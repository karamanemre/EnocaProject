package com.emrekaraman.enocaproject.business.concretes;

import com.emrekaraman.enocaproject.business.abstracts.CompanyService;
import com.emrekaraman.enocaproject.business.dtos.CompanyAddDto;
import com.emrekaraman.enocaproject.core.constants.Messages;
import com.emrekaraman.enocaproject.core.utilities.*;
import com.emrekaraman.enocaproject.dataAccess.CompanyDao;
import com.emrekaraman.enocaproject.entities.Company;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyManager implements CompanyService {

    private final CompanyDao companyDao;
    private final ModelMapper modelMapper;

    public CompanyManager(CompanyDao companyDao, ModelMapper modelMapper) {
        this.companyDao = companyDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult(companyDao.findAll(),Messages.SUCCESS_GET);
    }

    @Override
    public DataResult<Company> add(CompanyAddDto companyAddDto) {
        Company company = modelMapper.map(companyAddDto,Company.class);
        return new SuccessDataResult(companyDao.save(company),Messages.SUCCESS_ADDED);
    }

    @Override
    public DataResult<Company> update(CompanyAddDto companyAddDto) {
        if (!companyDao.existsById(companyAddDto.getId())) {
            return new ErrorDataResult(Messages.COMPANY_NOT_FOUND);
        }
        Company company = modelMapper.map(companyAddDto,Company.class);
        return new SuccessDataResult(companyDao.save(company));
    }

    @Override
    public Result deleteById(Long id) {
        if (!companyDao.existsById(id)) {
            return new ErrorDataResult(Messages.COMPANY_NOT_FOUND);
        }
        companyDao.deleteById(id);
        return new SuccessResult(Messages.SUCCESS_DELETED);
    }
}
