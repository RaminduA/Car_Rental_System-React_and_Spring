package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.CustomerDTO;
import com.scorpion.easycar.entity.Customer;
import com.scorpion.easycar.repository.CustomerRepo;
import com.scorpion.easycar.service.CustomerProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void updateDisplayPicture(byte[] displayPicture, String id) {
        if(customerRepo.existsById(id)){
            customerRepo.updateDisplayPicture(modelMapper.map(displayPicture, String.class),id);
        }else{
            throw new RuntimeException("Customer Does Not Exist");
        }
    }

    @Override
    public void updatePersonalDetails(CustomerDTO dto) {
        if(customerRepo.existsById(dto.getId())){
            customerRepo.save(modelMapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("Customer Does Not Exist");
        }
    }
}
