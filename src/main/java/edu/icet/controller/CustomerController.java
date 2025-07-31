package edu.icet.controller;

import edu.icet.model.dto.customer.CustomerDto;
import edu.icet.service.custom.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    void addCustomer(@RequestBody CustomerDto customerDto){
        customerService.add(customerDto);
    }

    @PutMapping("/update")
    void updateCustomer(@RequestBody CustomerDto customerDto){
        customerService.update(customerDto);
    }

    @GetMapping("/get-all")
    List<CustomerDto> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/get-by-id")
    CustomerDto getById(@RequestParam(name = "id")Integer id){
        return customerService.searchById(id);
    }

    @GetMapping("/get-by-tp-no")
    CustomerDto getByTpNo(@RequestParam(name = "tpNo")String tpNo){
        return customerService.searchByTpNo(tpNo);
    }

    @GetMapping("/get-by-nic")
    CustomerDto getByNic(@RequestParam(name = "nic")String nic){
        return customerService.searchByNic(nic);
    }
}
