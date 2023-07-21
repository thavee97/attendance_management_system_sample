package com.Customer.customer.Service.Imple;

import com.Customer.customer.Repository.AddressRepository;
import com.Customer.customer.RequestDto.AddressRequest;
import com.Customer.customer.ResponsDto.AddressResponse;
import com.Customer.customer.Service.AddressService;
import com.Customer.customer.entities.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
     private AddressRepository addressRepository;


    @Override
    public void createAddress(AddressRequest addressRequest) {
        Address address=new Address();
        BeanUtils.copyProperties(addressRequest,address);
        addressRepository.save(address);
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        List<AddressResponse> addressResponseList=new ArrayList<>();
        List<Address> addressList=addressRepository.findAll();
        for(Address address:addressList ){
            AddressResponse addressResponse=new AddressResponse();
            BeanUtils.copyProperties(address,addressResponse);
            addressResponseList.add(addressResponse);

        }

        return addressResponseList;
    }

    @Override
    public AddressResponse getAddressById(Long id) {
        AddressResponse addressResponse=new AddressResponse();
        Address address=addressRepository.findById(id).get();
        BeanUtils.copyProperties(address,addressResponse);
        return addressResponse;
    }

    @Override
    public void updateAddress(AddressRequest addressRequest) {
        Address address=addressRepository.findById(addressRequest.getId()).get();
        BeanUtils.copyProperties(addressRequest,address);
        addressRepository.save(address);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

}
