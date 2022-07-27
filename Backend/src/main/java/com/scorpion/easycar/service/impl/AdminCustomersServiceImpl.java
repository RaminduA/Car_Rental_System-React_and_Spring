package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.CustomerDTO;
import com.scorpion.easycar.entity.Customer;
import com.scorpion.easycar.repository.CustomerRepo;
import com.scorpion.easycar.service.AdminCustomersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AdminCustomersServiceImpl implements AdminCustomersService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO getCustomer(String id){
        if(customerRepo.findById(id).isPresent()){
            return modelMapper.map(customerRepo.findById(id).get(), CustomerDTO.class);
        }else{
            throw new RuntimeException("Customer Not Found...");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers(){
        return modelMapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public void saveCustomer(CustomerDTO dto){
        if(!customerRepo.existsById(dto.getId())){
            customerRepo.save(modelMapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("Customer Already Exists");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto){
        if(customerRepo.existsById(dto.getId())){
            customerRepo.save(modelMapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("No Such Customer To Update");
        }
    }

    @Override
    public void deleteCustomer(String id){
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else{
            throw new RuntimeException("No Such Customer To Delete");
        }
    }
}