package com.Customer.customer.Service;

import com.Customer.customer.RequestDto.EmployeeRequest;
import com.Customer.customer.ResponsDto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    public void createEmployee(EmployeeRequest employeeRequest);

    public List<EmployeeResponse> getAllEmployee();

    public EmployeeResponse getEmployeeById(Long id);
    public boolean existsById(Long id);

    public void updateEmployee(EmployeeRequest employeeRequest);

    public void deleteEmployeebyid(Long id);


}
