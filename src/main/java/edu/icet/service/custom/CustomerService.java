package edu.icet.service.custom;

import edu.icet.model.dto.customer.CustomerDto;

import java.util.List;

public interface CustomerService {
    void add(CustomerDto customerDto);
    List<CustomerDto> getAll();
    void update(CustomerDto customerDto);
    CustomerDto searchByNic(String nic);
    CustomerDto searchByTpNo(String tpNo);
    CustomerDto searchById(Integer id);
}
