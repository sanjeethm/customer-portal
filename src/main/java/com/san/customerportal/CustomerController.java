package com.san.customerportal;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustomerController {
	private CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@PostMapping
	public Customer save(@RequestParam String firstName,
						 @RequestParam String lastName,
						 @RequestParam Integer age) {
		final Customer customer = new Customer().setFirstName(firstName).setLastName(lastName).setAge(age);
		return customerRepository.save(customer);
	}

	@GetMapping("{id}")
	public Customer getOne(@PathVariable Long id) {
		final Customer jpaCustomer = customerRepository.getOne(id);
		// wrapping in a new Customer object b/c the JPA implementation may not be serializable
		return new Customer()
				.setAge(jpaCustomer.getAge())
				.setLastName(jpaCustomer.getLastName())
				.setFirstName(jpaCustomer.getFirstName())
				.setId(jpaCustomer.getId());
	}
}

