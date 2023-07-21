package com.Customer.customer.Controller;

import com.Customer.customer.RequestDto.CustomerRequest;
import com.Customer.customer.ResponsDto.CustomerResponse;
import com.Customer.customer.Service.CustomerService;
import com.Customer.customer.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/createCsv")
    public ResponseEntity<String> saveImportCsvFile(@RequestParam MultipartFile multipartFile){
        customerService.saveImportCsvFile(multipartFile);
        return new ResponseEntity<String>("customer imported",HttpStatus.OK);
    }
    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerRequest customerRequest)
    {
        customerService.createCustomer(customerRequest);
        return new ResponseEntity<String>("New Customer is created",HttpStatus.OK);
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        List<CustomerResponse> customerResponseList=customerService.getAllCustomers();
        return new ResponseEntity<List<CustomerResponse>>(customerResponseList,HttpStatus.OK);
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long id){
        if(!customerService.existsById(id)) {
            String error_msg="This id is not found";
            return  ResponseEntity.ok(error_msg);
        }
        CustomerResponse customerResponse = customerService.getCustomerById(id);
        return  ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerRequest customerRequest){
        if(!customerService.existsById(customerRequest.getId()))
        {
            return new ResponseEntity<String>("Customer not avaliable",HttpStatus.BAD_REQUEST);
        }
        if(!employeeService.existsById(customerRequest.getEmployeeId()))
        {
            return new ResponseEntity<String>("Employee not avaliable",HttpStatus.BAD_REQUEST);
        }

        customerService.createCustomer(customerRequest);
        return new ResponseEntity<String>("Customer Updated",HttpStatus.OK);
    }
    @DeleteMapping("/DeleteCustomerById/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        if(!customerService.existsById(id)){
            return new ResponseEntity<String>("This id not found",HttpStatus.BAD_REQUEST);
        }

        customerService.deleteCustomer(id);
        return new  ResponseEntity<String>("Customer deleted",HttpStatus.OK);
    }

}
