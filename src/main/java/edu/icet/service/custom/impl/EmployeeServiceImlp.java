package edu.icet.service.custom.impl;

import edu.icet.model.dto.employee.EmployeeDto;
import edu.icet.model.entity.employee.EmployeeEntity;
import edu.icet.repository.custom.EmployeeDao;
import edu.icet.service.custom.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImlp implements EmployeeService{
    final EmployeeDao employeeDao;
    final ModelMapper mapper;

    @Override
    public void add(EmployeeDto employeeDto) {
        employeeDao.save(mapper.map(employeeDto, EmployeeEntity.class));
    }

    @Override
    public void update(EmployeeDto employeeDto) {
        employeeDao.save(mapper.map(employeeDto, EmployeeEntity.class));
    }

    @Override
    public EmployeeDto readById(Integer id) {
        return mapper.map(employeeDao.findById(id), EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<EmployeeDto> list =new ArrayList<>();
        employeeDao.findAll().forEach(employeeEntity ->list.add(mapper.map(employeeEntity, EmployeeDto.class)));
        return list;
    }

    @Override
    public void disable(Integer id) {
        employeeDao.disableEmployee(id,Date.valueOf(LocalDate.now()));
    }
}
