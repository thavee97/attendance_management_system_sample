package com.Customer.customer.Service;

import com.Customer.customer.RequestDto.AddressRequest;
import com.Customer.customer.ResponsDto.AddressResponse;

import java.util.List;

public interface AddressService {
    public void createAddress(AddressRequest addressRequest);

    public List<AddressResponse> getAllAddress();

    public AddressResponse getAddressById(Long id);

    public void updateAddress(AddressRequest addressRequest);

    public void deleteById(Long id);


}
