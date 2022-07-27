package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.RentRequestDTO;
import com.scorpion.easycar.entity.RentRequest;
import com.scorpion.easycar.repository.RentRequestRepo;
import com.scorpion.easycar.service.CustomerBookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomerBookingServiceImpl implements CustomerBookingService {

    @Autowired
    private RentRequestRepo rentRequestRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void requestCarBooking(RentRequestDTO dto) {
        if(!rentRequestRepo.existsById(dto.getId())){
            rentRequestRepo.save(modelMapper.map(dto,RentRequest.class));
        }else{
            throw new RuntimeException("Request Already Exists");
        }
    }
}
