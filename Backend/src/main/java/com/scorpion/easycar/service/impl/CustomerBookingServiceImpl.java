package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.RentRequestDTO;
import com.scorpion.easycar.entity.RentRequest;
import com.scorpion.easycar.entity.RentResponse;
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

    @Override
    public String getRequestId() {
        String requestId = "REQ-0000001";
        RentRequest top = rentRequestRepo.findTopByOrderByIdDesc();
        if(top!=null){
            Integer index = Integer.getInteger(top.getId().split("-")[1]);
            ++index;
            requestId = index<10 ? "REQ-000000"+index : index<100 ? "REQ-00000"+index : index<1000 ? "REQ-0000"+index : index<10000 ? "REQ-000"+index : index<100000 ? "REQ-00"+index : index<1000000 ? "REQ-0"+index : "REQ-"+index;
        }
        return requestId;
    }
}
