package api.azure.customer.service;

import api.azure.customer.entity.CustomerEntity;
import azure.customer.openapi.model.CustomerRequest;
import azure.customer.openapi.model.CustomerResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<CustomerResponse> getAll();
    Optional<CustomerResponse> getById(UUID id);
    CustomerResponse createCustomer(CustomerRequest customerRequest);
}
