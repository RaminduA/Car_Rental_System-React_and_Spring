package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.CustomerDTO;
import com.scorpion.easycar.entity.Account;
import com.scorpion.easycar.entity.Admin;
import com.scorpion.easycar.entity.Customer;
import com.scorpion.easycar.entity.Driver;
import com.scorpion.easycar.repository.AccountRepo;
import com.scorpion.easycar.repository.AdminRepo;
import com.scorpion.easycar.repository.CustomerRepo;
import com.scorpion.easycar.repository.DriverRepo;
import com.scorpion.easycar.service.LoginRegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginRegisterServiceImpl implements LoginRegisterService {

    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String loginUser(String username, String password) {
        Account account = accountRepo.findByUsernameAndPassword(username, password);
        if(account!=null){
            Admin admin = adminRepo.findByAccount_Id(account.getId());
            Customer customer = customerRepo.findByAccount_Id(account.getId());
            Driver driver = driverRepo.findByAccount_Id(account.getId());

            if(admin!=null){
                return "Admin";
            }else if(customer!=null){
                return "Customer";
            }else if(driver!=null){
                return "Driver";
            }else{
                throw new RuntimeException("Invalid Account");
            }

        }else{
            throw new RuntimeException("Account Does Not Exist");
        }
    }

    @Override
    public String getCustomerId() {
        Customer top = customerRepo.findTopByOrderByIdDesc();
        if(top!=null){
            Integer index = Integer.getInteger(top.getId().split("-")[1]);
            ++index;
            return index<10 ? "CUS-00000"+index : index<100 ? "CUS-0000"+index : index<1000 ? "CUS-000"+index : index<10000 ? "CUS-00"+index : index<100000 ? "CUS-0"+index : "CUS-"+index;
        }
        return "CUS-000001";
    }

    @Override
    public String getAccountId() {
        Account top = accountRepo.findTopByOrderByIdDesc();
        if(top!=null){
            Integer index = Integer.getInteger(top.getId().split("-")[1]);
            ++index;
            return index<10 ? "ACC-00000"+index : index<100 ? "ACC-0000"+index : index<1000 ? "ACC-000"+index : index<10000 ? "ACC-00"+index : index<100000 ? "ACC-0"+index : "ACC-"+index;
        }
        return "ACC-000001";
    }

    @Override
    public void registerCustomer(CustomerDTO dto) {
        if(!customerRepo.existsById(dto.getId())){
            accountRepo.save(modelMapper.map(dto.getAccount(), Account.class));
            customerRepo.save(modelMapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("Customer Already Exists");
        }
    }
}
