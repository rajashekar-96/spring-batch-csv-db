package com.batchTrai.demo.Config;

import com.batchTrai.demo.Entity.Employee;
import com.batchTrai.demo.dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmployeeProcessor implements ItemProcessor<EmployeeDto, Employee> {

    @Override
    public Employee process(EmployeeDto employeeDto) throws Exception {
        return mapEmployee(employeeDto);
    }

    private Employee mapEmployee(EmployeeDto employeeDto) {
        log.info("processing employee event ", employeeDto.employeeId());
        return Employee.builder()
                .employeeId(employeeDto.employeeId())
                .fullName(employeeDto.fullName())
                .businessUnit(employeeDto.businessUnit())
                .department(employeeDto.department())
                .gender(employeeDto.gender())
                .age(employeeDto.age())
                .ethnicity(employeeDto.ethnicity())
                .jobTitle(employeeDto.jobTitle())
                .build();
    }
}
