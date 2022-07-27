package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.CarDTO;
import com.scorpion.easycar.datatransfer.CustomerDTO;
import com.scorpion.easycar.repository.CarRepo;
import com.scorpion.easycar.service.CustomerCarsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CustomerCarsServiceImpl implements CustomerCarsService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CarDTO> getAllCars() {
        return modelMapper.map(carRepo.findAll(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllCarsSortedByPassengerCount() {
        return modelMapper.map(carRepo.findAllByOrderByPassengerCount(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllCarsSortedByTransmissionType() {
        return modelMapper.map(carRepo.findAllByOrderByTransmissionType(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllCarsSortedByBrand() {
        return modelMapper.map(carRepo.findAllByOrderByBrand(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllCarsSortedByType() {
        return modelMapper.map(carRepo.findAllByOrderByCarType(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllCarsSortedByPrice() {
        return modelMapper.map(carRepo.findAllByOrderByDailyRate(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllCarsSortedByFuelType() {
        return modelMapper.map(carRepo.findAllByOrderByFuelType(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
