package api.azure.customer.controller;

import api.azure.customer.service.CustomerService;
import azure.customer.openapi.api.CustomerApi;
import azure.customer.openapi.model.CustomerRequest;
import azure.customer.openapi.model.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<List<CustomerResponse>> getCustomer() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @Override
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        CustomerResponse createdCustomer = customerService.createCustomer(customerRequest);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
}
