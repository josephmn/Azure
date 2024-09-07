package api.azure.customer.service.impl;

import api.azure.customer.entity.CustomerEntity;
import api.azure.customer.repository.CustomerRepository;
import api.azure.customer.service.CustomerService;
import api.azure.customer.utils.AppUtils;
import azure.customer.openapi.model.CustomerRequest;
import azure.customer.openapi.model.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> getAll() {
        List<CustomerEntity> customers = (List<CustomerEntity>) customerRepository.findAll();
        return customers.stream()
                .map(AppUtils::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerResponse> getById(UUID id) {
        Optional<CustomerEntity> customer = customerRepository.findById(id);
        return customer.map(AppUtils::entityToResponse);
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        CustomerEntity entity = AppUtils.requestToEntity(customerRequest);
        CustomerEntity savedCustomer = customerRepository.save(entity);
        return AppUtils.entityToResponse(savedCustomer);
    }
}
