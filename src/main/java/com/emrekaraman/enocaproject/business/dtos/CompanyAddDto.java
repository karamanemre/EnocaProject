package com.emrekaraman.enocaproject.business.dtos;
import com.emrekaraman.enocaproject.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAddDto {

    private Long id;
    private String name;
}
