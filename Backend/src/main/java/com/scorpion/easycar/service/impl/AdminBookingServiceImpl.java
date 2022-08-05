package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.DriverDTO;
import com.scorpion.easycar.datatransfer.RentRequestDTO;
import com.scorpion.easycar.datatransfer.RentResponseDTO;
import com.scorpion.easycar.datatransfer.RentalDTO;
import com.scorpion.easycar.entity.RentRequest;
import com.scorpion.easycar.entity.RentResponse;
import com.scorpion.easycar.entity.Rental;
import com.scorpion.easycar.repository.DriverRepo;
import com.scorpion.easycar.repository.RentRequestRepo;
import com.scorpion.easycar.repository.RentResponseRepo;
import com.scorpion.easycar.repository.RentalRepo;
import com.scorpion.easycar.service.AdminBookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
@Transactional
public class AdminBookingServiceImpl implements AdminBookingService {

    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private RentalRepo rentalRepo;
    @Autowired
    private RentRequestRepo rentRequestRepo;
    @Autowired
    private RentResponseRepo rentResponseRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RentRequestDTO> getAllPendingRequests() {
        return modelMapper.map(rentRequestRepo.findAllPending(), new TypeToken<List<RentRequestDTO>>(){}.getType());
    }

    @Override
    public List<String> getAllDriverIds() {
        return driverRepo.getAllIds();
    }

    @Override
    public DriverDTO getDriver(String id) {
        if(driverRepo.findById(id).isPresent()){
            return modelMapper.map(driverRepo.findById(id).get(), DriverDTO.class);
        }else{
            throw new RuntimeException("Driver Not Found...");
        }
    }

    @Override
    public String getResponseId() {
        String responseId = "RES-0000001";
        RentResponse top = rentResponseRepo.findTopByOrderByIdDesc();
        if(top!=null){
            Integer index = Integer.getInteger(top.getId().split("-")[1]);
            ++index;
            responseId = index<10 ? "RES-000000"+index : index<100 ? "RES-00000"+index : index<1000 ? "RES-0000"+index : index<10000 ? "RES-000"+index : index<100000 ? "RES-00"+index : index<1000000 ? "RES-0"+index : "RES-"+index;
        }
        return responseId;
    }

    @Override
    public String getRentalId() {
        String rentalId = "REN-0000001";
        Rental top = rentalRepo.findTopByOrderByIdDesc();
        if(top!=null){
            Integer index = Integer.getInteger(top.getId().split("-")[1]);
            ++index;
            rentalId = index<10 ? "REN-000000"+index : index<100 ? "REN-00000"+index : index<1000 ? "REN-0000"+index : index<10000 ? "REN-000"+index : index<100000 ? "REN-00"+index : index<1000000 ? "REN-0"+index : "REN-"+index;
        }
        return rentalId;
    }

    @Override
    public List<RentalDTO> getDriverScheduleForTheWeek(String id) {
        String today = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int lastDate = Integer.parseInt(today.split("-")[2]) - LocalDate.now().getDayOfWeek().getValue() + 7;
        String endDate = today.substring(0, today.length()-2) + lastDate;
        return modelMapper.map(rentalRepo.findAllByDriverIdAndPickupDateBetween(id, LocalDate.parse(today, formatter), LocalDate.parse(endDate, formatter)), new TypeToken<List<RentalDTO>>(){}.getType());
    }

    @Override
    public List<RentalDTO> getDriverScheduleForTheMonth(String id) {
        String today = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String[] split = today.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int lastDate = YearMonth.of(year, month).lengthOfMonth();
        String endDate = today.substring(0, today.length()-2) + lastDate;
        return modelMapper.map(rentalRepo.findAllByDriverIdAndPickupDateBetween(id, LocalDate.parse(today, formatter), LocalDate.parse(endDate, formatter)), new TypeToken<List<RentalDTO>>(){}.getType());
    }

    @Override
    public void denyRentRequest(RentResponseDTO dto) {
        if(rentRequestRepo.findById(dto.getRentRequest().getId()).isPresent()){
            RentRequest request = rentRequestRepo.findById(dto.getRentRequest().getId()).get();
            request.setStatus("Denied");
            rentRequestRepo.save(request);
            rentResponseRepo.save(modelMapper.map(dto, RentResponse.class));
        }else{
            throw new RuntimeException("Request Not Found...");
        }
    }

    @Override
    public void acceptRentRequest(RentResponseDTO dto) {
        if(rentRequestRepo.findById(dto.getRentRequest().getId()).isPresent()){
            RentRequest request = rentRequestRepo.findById(dto.getRentRequest().getId()).get();
            request.setStatus("Accepted");
            rentRequestRepo.save(request);

            String rentalId = "REN-0000001";
            Rental top = rentalRepo.findTopByOrderByIdDesc();
            if(top!=null){
                Integer index = Integer.getInteger(top.getId().split("-")[1]);
                ++index;
                rentalId = index<10 ? "REN-000000"+index : index<100 ? "REN-00000"+index : index<1000 ? "REN-0000"+index : index<10000 ? "REN-000"+index : index<100000 ? "REN-00"+index : index<1000000 ? "REN-0"+index : "REN-"+index;
            }

            rentalRepo.save(new Rental(
                    rentalId,
                    request.getPickupVenue(),
                    request.getPickupDate(),
                    request.getDropOffVenue(),
                    request.getDropOffDate(),
                    request.getRentalType(),
                    request.getLdwSlip(),
                    "Assigned",
                    request.getCustomer(),
                    request.getCar(),
                    request.getDriver()
            ));

            rentResponseRepo.save(modelMapper.map(dto, RentResponse.class));

        }else{
            throw new RuntimeException("Rent Request Not Found...");
        }
    }

    @Override
    public void acceptRentRequestWithDifferentDriver(RentResponseDTO dto, String driverId) throws Exception {
        if(rentRequestRepo.findById(dto.getRentRequest().getId()).isPresent()){
            RentRequest request = rentRequestRepo.findById(dto.getRentRequest().getId()).get();
            request.setStatus("Accepted");
            rentRequestRepo.save(request);

            String rentalId = "REN-0000001";
            Rental top = rentalRepo.findTopByOrderByIdDesc();
            if(top!=null){
                Integer index = Integer.getInteger(top.getId().split("-")[1]);
                ++index;
                rentalId = index<10 ? "REN-000000"+index : index<100 ? "REN-00000"+index : index<1000 ? "REN-0000"+index : index<10000 ? "REN-000"+index : index<100000 ? "REN-00"+index : index<1000000 ? "REN-0"+index : "REN-"+index;
            }

            rentalRepo.save(new Rental(
                    rentalId,
                    request.getPickupVenue(),
                    request.getPickupDate(),
                    request.getDropOffVenue(),
                    request.getDropOffDate(),
                    request.getRentalType(),
                    request.getLdwSlip(),
                    "Assigned",
                    request.getCustomer(),
                    request.getCar(),
                    driverRepo.findById(driverId).orElseThrow(()->new Exception("Driver not found with ID : "+driverId))
            ));

            rentResponseRepo.save(modelMapper.map(dto, RentResponse.class));

        }else{
            throw new RuntimeException("Rent Request Not Found...");
        }
    }
}
