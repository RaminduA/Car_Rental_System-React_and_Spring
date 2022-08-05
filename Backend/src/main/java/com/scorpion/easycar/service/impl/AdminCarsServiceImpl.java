package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.CarDTO;
import com.scorpion.easycar.datatransfer.CustomerDTO;
import com.scorpion.easycar.entity.Car;
import com.scorpion.easycar.entity.Driver;
import com.scorpion.easycar.repository.CarRepo;
import com.scorpion.easycar.service.AdminCarsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminCarsServiceImpl implements AdminCarsService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarDTO getCar(String id) {
        if(carRepo.findById(id).isPresent()){
            return modelMapper.map(carRepo.findById(id).get(), CarDTO.class);
        }else{
            throw new RuntimeException("Car Not Found...");
        }
    }

    @Override
    public List<CarDTO> getAllCars() {
        return modelMapper.map(carRepo.findAll(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public String getCarId() {
        Car top = carRepo.findTopByOrderByIdDesc();
        if(top!=null){
            Integer index = Integer.getInteger(top.getId().split("-")[1]);
            ++index;
            return index<10 ? "CAR-00000"+index : index<100 ? "CAR-0000"+index : index<1000 ? "CAR-000"+index : index<10000 ? "CAR-00"+index : index<100000 ? "CAR-0"+index : "CAR-"+index;
        }
        return "CAR-000001";
    }

    @Override
    public void saveCar(CarDTO dto) {
        if(!carRepo.existsById(dto.getId())){
            carRepo.save(modelMapper.map(dto, Car.class));
        }else{
            throw new RuntimeException("Car Already Exists");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if(carRepo.existsById(dto.getId())){
            carRepo.save(modelMapper.map(dto, Car.class));
        }else{
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public void deleteCar(String id) {
        if(carRepo.existsById(id)){
            carRepo.deleteById(id);
        }else{
            throw new RuntimeException("No Such Car To Delete");
        }
    }

    @Override
    public void updateStatus(String status, String id) {
        if(carRepo.existsById(id)){
            carRepo.updateStatus(status, id);
        }else{
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public List<CarDTO> getAllByStatus(String status) {
        return modelMapper.map(carRepo.getAllByStatus(status), new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public int getCountByStatus(String status) {
        return carRepo.getCountByStatus(status);
    }

    @Override
    public void updatePictures(byte[] frontView, byte[] rearView, byte[] lateralView, byte[] interiorView, byte[] displayPicture, String id){
        if(carRepo.existsById(id)){
            carRepo.updatePictures(modelMapper.map(frontView,String.class), modelMapper.map(rearView,String.class), modelMapper.map(lateralView,String.class), modelMapper.map(interiorView,String.class), modelMapper.map(displayPicture,String.class), id);
        }else{
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public void updateFrontView(byte[] frontView, String id){
        if(carRepo.existsById(id)){
            carRepo.updateFrontView(modelMapper.map(frontView,String.class), id);
        }else{
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public void updateRearView(byte[] rearView, String id){
        if(carRepo.existsById(id)){
            carRepo.updateRearView(modelMapper.map(rearView,String.class), id);
        }else{
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public void updateLateralView(byte[] lateralView, String id){
        if(carRepo.existsById(id)){
            carRepo.updateLateralView(modelMapper.map(lateralView,String.class), id);
        }else{
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public void updateInteriorView(byte[] interiorView, String id){
        if(carRepo.existsById(id)){
            carRepo.updateInteriorView(modelMapper.map(interiorView,String.class), id);
        }else{
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public void updateDisplayPicture(byte[] displayPicture, String id){
        if(carRepo.existsById(id)){
            carRepo.updateDisplayPicture(modelMapper.map(displayPicture,String.class), id);
        }else{
            throw new RuntimeException("No Such Car To Update");
        }
    }
}
