package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.RentResponseDTO;
import com.scorpion.easycar.datatransfer.RentalDTO;
import com.scorpion.easycar.repository.RentResponseRepo;
import com.scorpion.easycar.service.CustomerNotificationsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CustomerNotificationsServiceImpl implements CustomerNotificationsService {

    @Autowired
    private RentResponseRepo rentResponseRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RentResponseDTO> getAllUnseenResponses(String customerId) {
        return modelMapper.map(rentResponseRepo.findAllUnseenResponsesByCustomerId(customerId), new TypeToken<List<RentResponseDTO>>(){}.getType());
    }

    @Override
    public void makeResponseSeen(String id) {
        rentResponseRepo.makeResponseSeen(id);
    }
}
