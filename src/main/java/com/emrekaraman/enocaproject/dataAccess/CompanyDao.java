package com.emrekaraman.enocaproject.dataAccess;

import com.emrekaraman.enocaproject.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company,Long> {
}
