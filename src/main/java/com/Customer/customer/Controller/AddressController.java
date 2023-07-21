package com.Customer.customer.Controller;

import com.Customer.customer.RequestDto.AddressRequest;
import com.Customer.customer.ResponsDto.AddressResponse;
import com.Customer.customer.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/createAddress")
    public void createAddress(@RequestBody AddressRequest addressRequest){
        addressService.createAddress(addressRequest);
    }
    @GetMapping("/getAllAddress")
    public List<AddressResponse> getAllAddress(){
        return addressService.getAllAddress();
    }

    @GetMapping("/getAddressById/{id}")
    public AddressResponse getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PutMapping("/updateAddress")
    public void updateAddress(@RequestBody AddressRequest addressRequest){
        addressService.updateAddress(addressRequest);
    }

    @DeleteMapping("/deleteAddressById/{id}")
    public void deleteById(@PathVariable Long id){
        addressService.deleteById(id);
    }

}
