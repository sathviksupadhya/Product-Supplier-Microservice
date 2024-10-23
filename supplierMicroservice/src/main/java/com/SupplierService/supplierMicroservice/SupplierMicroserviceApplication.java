package com.SupplierService.supplierMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class SupplierMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierMicroserviceApplication.class, args);
	}

}
