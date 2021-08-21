package net.sophy.api.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication @RequiredArgsConstructor
public class CustomerApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.deleteAll();
		customerRepository.save(new Customer("Alice", "Smith"));
		customerRepository.save(new Customer("Bob", "Smith"));
		customerRepository.save(new Customer("Tom", "Cruise"));

		System.out.println("Customers found with findAll()");

		for (Customer customer: customerRepository.findAll()) {
			System.out.println("customer = " + customer);
		}

		System.out.println();

		System.out.println("Tom 이라는 이름으로 찾기");
		Customer customerTom = customerRepository.findByFirstName("Tom");
		System.out.println(customerTom);



		System.out.println("Smith라는 이름으로 찾기");
		for (Customer customer: customerRepository.findByLastName("Smith")) {
			System.out.println("customer = " + customer);
		}
	}
}
