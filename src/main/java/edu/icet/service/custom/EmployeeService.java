package edu.icet.service.custom;

import edu.icet.model.dto.employee.EmployeeDto;
import edu.icet.service.SuperService;

import java.util.List;

public interface EmployeeService extends SuperService {
    void  add(EmployeeDto employeeDto);
    void update(EmployeeDto employeeDto);
    EmployeeDto readById(Integer id);
    List<EmployeeDto> getAll();
    void disable(Integer id);
}
