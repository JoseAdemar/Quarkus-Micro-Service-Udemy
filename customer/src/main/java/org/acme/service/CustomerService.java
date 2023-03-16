package org.acme.service;

import org.acme.dto.CustomerDTO;
import org.acme.entity.CustomerEntity;
import org.acme.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public List<CustomerDTO> findAllCustomer() {
        List<CustomerDTO> customers = new ArrayList<>();
        customerRepository.findAll().stream().forEach(item -> {
            customers.add(mapCustomerEntityToDTO(item));
        });
        return customers;
    }

    public void createNewCustomer(CustomerDTO customerDTO){
        customerRepository.persist(mapCustomerDtoToEntity(customerDTO));
    }

    public void changeCustomer(Long id, CustomerDTO customerDTO){
        CustomerEntity customer = customerRepository.findById(id);

        customer.setName(customerDTO.getName());
        customer.setAge(customerDTO.getAge());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());

        customerRepository.persist(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapCustomerEntityToDTO(CustomerEntity customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setAddress(customer.getAddress());
        customerDTO.setName(customer.getName());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }

    private CustomerEntity mapCustomerDtoToEntity(CustomerDTO customer) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setAddress(customer.getAddress());
        customerEntity.setName(customer.getName());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setEmail(customer.getEmail());
        return customerEntity;
    }


}
