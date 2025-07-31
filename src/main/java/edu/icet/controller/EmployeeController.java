package edu.icet.controller;

import edu.icet.model.dto.employee.EmployeeDto;
import edu.icet.service.custom.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {
    final EmployeeService employeeService;

    @PostMapping("/add")
    void add(@RequestBody EmployeeDto employeeDto){
        employeeService.add(employeeDto);
    }

    @PutMapping("/update")
    void update(@RequestBody EmployeeDto employeeDto){
        employeeService.update(employeeDto);
    }

    @GetMapping("/get-by-id")
    EmployeeDto findById(@RequestParam(name = "id") Integer id){
        return employeeService.readById(id);
    }

    @GetMapping("/get-all")
    List<EmployeeDto> getAll(){
        return employeeService.getAll();
    }

    @PatchMapping("/disable")
    void disable(@RequestParam(name="id")Integer id){
        employeeService.disable(id);
    }

}
