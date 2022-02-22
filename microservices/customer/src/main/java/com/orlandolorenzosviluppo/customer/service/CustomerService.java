package com.orlandolorenzosviluppo.customer.service;

import com.orlandolorenzosviluppo.clients.fraud.FraudClient;
import com.orlandolorenzosviluppo.clients.fraud.response.FraudCheckResponse;
import com.orlandolorenzosviluppo.customer.model.Customer;
import com.orlandolorenzosviluppo.customer.repository.CustomerRepository;
import com.orlandolorenzosviluppo.customer.request.CustomerRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO: Check if email is valid

        // TODO: Check if email is not taken

        customerRepository.saveAndFlush(customer);

        // TODO: Check if fraudster
        /* FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        ); */

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }

        // TODO: Send notification
    }
}
