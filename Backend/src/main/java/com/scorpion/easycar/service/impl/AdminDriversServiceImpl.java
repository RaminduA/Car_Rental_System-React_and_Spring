package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.DriverDTO;
import com.scorpion.easycar.entity.Account;
import com.scorpion.easycar.entity.Driver;
import com.scorpion.easycar.repository.DriverRepo;
import com.scorpion.easycar.service.AdminDriversService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AdminDriversServiceImpl implements AdminDriversService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DriverDTO getDriver(String id){
        if(driverRepo.findById(id).isPresent()){
            return modelMapper.map(driverRepo.findById(id).get(),DriverDTO.class);
        }else{
            throw new RuntimeException("Driver Not Found...");
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers(){
        return modelMapper.map(driverRepo.findAll(), new TypeToken<List<DriverDTO>>(){}.getType());
    }

    @Override
    public String getDriverId() {
        Driver top = driverRepo.findTopByOrderByIdDesc();
        if(top!=null){
            Integer index = Integer.getInteger(top.getId().split("-")[1]);
            ++index;
            return index<10 ? "DRI-00000"+index : index<100 ? "DRI-0000"+index : index<1000 ? "DRI-000"+index : index<10000 ? "DRI-00"+index : index<100000 ? "DRI-0"+index : "DRI-"+index;
        }
        return "DRI-000001";
    }

    @Override
    public void saveDriver(DriverDTO dto){
        if(!driverRepo.existsById(dto.getId())){
            driverRepo.save(modelMapper.map(dto, Driver.class));
        }else{
            throw new RuntimeException("Driver Already Exists");
        }
    }

    @Override
    public void updateDriver(DriverDTO dto){
        if(driverRepo.existsById(dto.getId())){
            driverRepo.save(modelMapper.map(dto, Driver.class));
        }else{
            throw new RuntimeException("No Such Driver To Update");
        }
    }

    @Override
    public void deleteDriver(String id){
        if(driverRepo.existsById(id)){
            driverRepo.deleteById(id);
        }else{
            throw new RuntimeException("No Such Driver To Delete");
        }
    }

    @Override
    public DriverDTO getDriverByAccountId(String accountId){
        Driver entity = driverRepo.findByAccount_Id(accountId);
        if(entity!=null){
            return modelMapper.map(entity, DriverDTO.class);
        }else{
            throw new RuntimeException("Driver Not Found...");
        }
    }

    @Override
    public void updateStatus(String status, String id) {
        if(driverRepo.existsById(id)){
            driverRepo.updateStatus(status, id);
        }else{
            throw new RuntimeException("No Such Driver To Update");
        }
    }

    @Override
    public List<DriverDTO> getAllAvailable() {
        return modelMapper.map(driverRepo.getAllAvailableDrivers(), new TypeToken<List<DriverDTO>>(){}.getType());
    }

    @Override
    public int getCountByStatus(String status){
        return driverRepo.getCountByStatus(status);
    }

}