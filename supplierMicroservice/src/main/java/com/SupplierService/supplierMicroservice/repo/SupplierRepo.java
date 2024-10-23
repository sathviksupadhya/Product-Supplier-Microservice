package com.SupplierService.supplierMicroservice.repo;

import com.SupplierService.supplierMicroservice.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {
}
