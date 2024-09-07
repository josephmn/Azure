package api.azure.customer.repository;

import api.azure.customer.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, UUID> {
}
