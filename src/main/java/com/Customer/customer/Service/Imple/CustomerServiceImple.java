package com.Customer.customer.Service.Imple;

import com.Customer.customer.Repository.CustomerRepository;
import com.Customer.customer.RequestDto.CustomerRequest;
import com.Customer.customer.ResponsDto.CustomerResponse;
import com.Customer.customer.Service.CustomerService;
import com.Customer.customer.entities.Customer;
import com.Customer.customer.entities.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImple implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void createCustomer(CustomerRequest customerRequest) {
        Customer customer=new Customer();
        Employee employee =new Employee();
        employee.setId(customerRequest.getEmployeeId());
        customer.setEmployee(employee);
        BeanUtils.copyProperties(customerRequest,customer);
        customerRepository.save(customer);
    }

    @Override
    public boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<CustomerResponse> customerResponseList=new ArrayList<>();
        List<Customer> customerList=customerRepository.findAll();
        for (Customer customer:customerList) {
            CustomerResponse customerResponse =new CustomerResponse();
            customerResponse.setEmployeeId(customer.getEmployee().getId());
            customerResponse.setEmployeeName(customer.getEmployee().getName());
            BeanUtils.copyProperties(customer,customerResponse);
            customerResponseList.add(customerResponse);
        }
        return customerResponseList;
    }
    public CustomerResponse getCustomerById(Long id){
        CustomerResponse customerResponse=new CustomerResponse();
        Customer customer=customerRepository.findById(id).get();
        customerResponse.setEmployeeName(customer.getEmployee().getName());
        customerResponse.setEmployeeId(customer.getEmployee().getId());
        BeanUtils.copyProperties(customer,customerResponse);
        return customerResponse;
    }



    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    @Override
    public void saveImportCsvFile(MultipartFile multipartFile) {
       // List<Customer> customerList=new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            String line;
            while((line=bufferedReader.readLine()) !=null) {
                String[] data = line.split(",");
                Customer customer=new Customer();
                customer.setName(data[0]);
                Employee employee=new Employee();
                employee.setId(Long.parseLong(data[1]));
                customer.setEmployee(employee);
                customerRepository.save(customer);
                //customerList.add(customer);

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
           System.out.println(e +"not save");
        }
        //return customerList;
    }

//    @Override
//    public void saveListOfCustomer(List<Customer> customerList) {
//        for (Customer customer :customerList) {
//            CustomerRequest customerRequest = new CustomerRequest();
//            customerRequest.setEmployeeId(customer.getEmployee().getId());
//            BeanUtils.copyProperties(customer,customerRequest);
//            customerRepository.
//        }
//    }


}
