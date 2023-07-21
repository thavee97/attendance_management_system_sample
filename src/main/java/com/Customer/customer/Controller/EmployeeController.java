package com.Customer.customer.Controller;

import com.Customer.customer.RequestDto.EmployeeRequest;
import com.Customer.customer.ResponsDto.EmployeeResponse;
import com.Customer.customer.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//    @PostMapping("/create")
//    public void createEmployee(@RequestBody EmployeeRequest employeeRequest){
//        employeeService.createEmployee(employeeRequest);
//    }
    @PostMapping("/createEmployee")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<String>("Employee created", HttpStatus.OK);
    }

//    @GetMapping("/getAll")
//    public List<EmployeeResponse> getAllEmployee(){
//        return employeeService.getAllEmployee();
//    }

    @GetMapping("/getAllEmployee")
   public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){
       List<EmployeeResponse> employeelist =employeeService.getAllEmployee();
        return new ResponseEntity<List<EmployeeResponse>>(employeelist,HttpStatus.OK);
   }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Long id){
        if(!employeeService.existsById(id)){
            String err_msg="This id not found";
            return ResponseEntity.ok(err_msg);
        }
        EmployeeResponse employeeResponse=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeResponse);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeRequest employeeRequest){
        if(!employeeService.existsById(employeeRequest.getId())){
            return new ResponseEntity<String>("This id is not found",HttpStatus.BAD_REQUEST);
        }
        employeeService.updateEmployee(employeeRequest);
        return new ResponseEntity<String>("updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<String> deleteEmployeebyid(@PathVariable Long id){
        if(!employeeService.existsById(id)){
            return new ResponseEntity<String>("This id not found",HttpStatus.BAD_REQUEST);
        }

        employeeService.deleteEmployeebyid(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }

}
