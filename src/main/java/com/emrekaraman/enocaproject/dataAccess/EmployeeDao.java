package com.emrekaraman.enocaproject.dataAccess;

import com.emrekaraman.enocaproject.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Long> {
}
