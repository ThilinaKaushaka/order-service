package edu.icet.service.custom.impl;

import edu.icet.model.dto.customer.CustomerDto;
import edu.icet.model.entity.customer.CustomerEntity;
import edu.icet.repository.custom.CustomerDao;
import edu.icet.service.custom.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;
    private final ModelMapper mapper;

    @Override
    public void add(CustomerDto customerDto) {
        customerDao.save(mapper.map(customerDto, CustomerEntity.class));
    }


    @Override
    public List<CustomerDto> getAll() {
        List<CustomerDto>list=new ArrayList<>();
        customerDao.findAll().forEach(customerEntity -> list.add(mapper.map(customerEntity, CustomerDto.class)));
        return list;
    }

    @Override
    public void update(CustomerDto customerDto) {
        add(customerDto);
    }

    @Override
    public CustomerDto searchByNic(String nic) {
        return mapper.map(customerDao.findByNic(nic), CustomerDto.class);
    }

    @Override
    public CustomerDto searchByTpNo(String tpNo) {
        return mapper.map(customerDao.findByTpNo(tpNo), CustomerDto.class);
    }

    @Override
    public CustomerDto searchById(Integer id) {
        return mapper.map(customerDao.findById(id), CustomerDto.class);
    }
}
