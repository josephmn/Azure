package api.azure.customer.utils;

import api.azure.customer.entity.CustomerEntity;
import azure.customer.openapi.model.CustomerRequest;
import azure.customer.openapi.model.CustomerResponse;

import java.util.UUID;

public class AppUtils {

    public static CustomerResponse entityToResponse(CustomerEntity customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(String.valueOf(customer.getId()));
        customerResponse.setName(customer.getName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setDocumentType(customer.getDocumentType());
        customerResponse.setDocumentNumber(customer.getDocumentNumber());
        return customerResponse;
    }

    public static CustomerEntity requestToEntity(CustomerRequest response) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(UUID.randomUUID());
        customerEntity.setName(response.getName());
        customerEntity.setLastName(response.getLastName());
        customerEntity.setDocumentType(response.getDocumentType());
        customerEntity.setDocumentNumber(response.getDocumentNumber());
        return customerEntity;
    }
}
