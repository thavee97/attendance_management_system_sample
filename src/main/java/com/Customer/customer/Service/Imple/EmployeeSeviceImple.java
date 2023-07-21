package com.Customer.customer.Service.Imple;

import com.Customer.customer.Repository.EmployeeRepository;
import com.Customer.customer.RequestDto.EmployeeRequest;
import com.Customer.customer.ResponsDto.EmployeeResponse;
import com.Customer.customer.Service.EmployeeService;
import com.Customer.customer.entities.Address;
import com.Customer.customer.entities.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeSeviceImple implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {


        Employee employee =new Employee();
        Address address=new Address();
        address.setId(employeeRequest.getAddressid());
        employee.setAddress(address);
        BeanUtils.copyProperties(employeeRequest,employee);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        List<EmployeeResponse> employeeResponselist=new ArrayList<>();
        List<Employee> employeelist =employeeRepository.findAll();
        for(Employee employee:employeelist){
            EmployeeResponse employeeResponse=new EmployeeResponse();

             employeeResponse.setAddressid(employee.getAddress().getId());

            employeeResponse.setAddcity(employee.getAddress().getCity());

            BeanUtils.copyProperties(employee,employeeResponse);
            employeeResponselist.add(employeeResponse);
        }

        return employeeResponselist;
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).get();

        EmployeeResponse employeeResponse = new EmployeeResponse();
        //employeeResponse.setId(employee.getId());

        employeeResponse.setAddressid(employee.getAddress().getId());
        employeeResponse.setAddcity(employee.getAddress().getCity());
        BeanUtils.copyProperties(employee,employeeResponse);
        return employeeResponse;
    }

    @Override
    public boolean existsById(Long id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public void updateEmployee(EmployeeRequest employeeRequest) {
        Employee employee=employeeRepository.findById(employeeRequest.getId()).get();
       // employee.setId(employeeRequest.getId());
        Address address=new Address();
        address.setId(employeeRequest.getAddressid());
        employee.setAddress(address);
        BeanUtils.copyProperties(employeeRequest,employee);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeebyid(Long id) {
        employeeRepository.deleteById(id);
    }
}
