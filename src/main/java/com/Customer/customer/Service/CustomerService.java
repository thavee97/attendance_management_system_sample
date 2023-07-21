package com.Customer.customer.Service;

import com.Customer.customer.RequestDto.CustomerRequest;
import com.Customer.customer.ResponsDto.CustomerResponse;
import com.Customer.customer.entities.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CustomerService {

    public void createCustomer(CustomerRequest customerRequest);

    public boolean existsById(Long id);

    public List<CustomerResponse> getAllCustomers();

    public CustomerResponse getCustomerById(Long id);

    public void deleteCustomer(Long id);
    public void saveImportCsvFile(MultipartFile multipartFile);
   // public void saveListOfCustomer(List<Customer> customerList);

}
