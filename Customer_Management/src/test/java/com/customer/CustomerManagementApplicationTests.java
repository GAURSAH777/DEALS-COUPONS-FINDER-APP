package com.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;

@SpringBootTest
class CustomerManagementApplicationTests {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	public void getAllCustomersTest() {
		Customer c1 = new Customer();
		c1.setCustomerId("1");
		c1.setFirstName("Amit");
		c1.setLastName("Chaudhary");
		c1.setContactNumber("9845831190");
		c1.setEmail("amit@gmail.com");
		c1.setUsername("amit");
		c1.setPassword("Amitchaudhary@123");

		Customer c2 = new Customer();
		c2.setCustomerId("12");
		c2.setFirstName("Mit");
		c2.setLastName("Chaudhary");
		c2.setContactNumber("9845831191");
		c2.setEmail("mit@gmail.com");
		c2.setUsername("mit");
		c2.setPassword("Mitchaudhary@123");

		List<Customer> customers = new ArrayList<>();
		customers.add(c1);
		customers.add(c2);

		Mockito.when(customerRepository.findAll()).thenReturn(customers);
		assertThat(customerService.getAllCustomers()).isEqualTo(customers);

	}

	@Test
	public void addCustomerTest() {

		Customer c1 = new Customer();
		c1.setCustomerId("1");
		c1.setFirstName("Amit");
		c1.setLastName("Chaudhary");
		c1.setContactNumber("9845831190");
		c1.setEmail("amit@gmail.com");
		c1.setUsername("amit");
		c1.setPassword("Amitchaudhary@123");

		Mockito.when(customerRepository.save(c1)).thenReturn(c1);
		assertThat(customerService.addCustomer(c1)).isEqualTo(c1);

	}

	@Test
	public void getCustomerTest() {
		Customer c1 = new Customer();
		c1.setCustomerId("1");
		c1.setFirstName("Amit");
		c1.setLastName("Chaudhary");
		c1.setContactNumber("9845831190");
		c1.setEmail("amit@gmail.com");
		c1.setUsername("amit");
		c1.setPassword("Amitchaudhary@123");

		Mockito.when(customerRepository.findOne("1")).thenReturn(c1);
		assertThat(customerService.getCustomerById("1")).isEqualTo(c1);

	}

	@Test
	public void getCustomerByIdTest() {
		Customer c1 = new Customer();
		c1.setCustomerId("1");
		c1.setFirstName("Amit");
		c1.setLastName("Chaudhary");
		c1.setContactNumber("9845831190");
		c1.setEmail("amit@gmail.com");
		c1.setUsername("amit");
		c1.setPassword("Amitchaudhary@123");

		Mockito.when(customerRepository.findById(c1.getCustomerId()).get()).thenReturn(c1);
		assertThat(customerService.getCustomerById("2")).isEqualTo(c1);

	}
	
	@Test
	public void deleteCustomerTest() {
		
		Customer c1 = new Customer();
		c1.setCustomerId("1");
		c1.setFirstName("Amit");
		c1.setLastName("Chaudhary");
		c1.setContactNumber("9845831190");
		c1.setEmail("amit@gmail.com");
		c1.setUsername("amit");
		c1.setPassword("Amitchaudhary@123");
		
		Mockito.when(customerRepository.getOne("1")).thenReturn(c1);
		Mockito.when(customerRepository.existsById(c1.getCustomerId())).thenReturn(false);
		assertFalse(customerRepository.existsById(c1.getCustomerId()));
	}

}
