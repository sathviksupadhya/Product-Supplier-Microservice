package com.SupplierService.supplierMicroservice.service;

import com.SupplierService.supplierMicroservice.dto.SupplierDto;
import com.SupplierService.supplierMicroservice.entity.Supplier;
import com.SupplierService.supplierMicroservice.repo.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;

    // Service for Supplier Microservice
    public Optional<Supplier> getSupplierById(Long supplierId) {
        return supplierRepo.findById(supplierId);
    }
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    // Update supplier details
    public Supplier updateSupplier(Long supplierId, Supplier supplierDetails) {
        Supplier supplier = supplierRepo.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id " + supplierId));

        supplier.setName(supplierDetails.getName());
        supplier.setContactInfo(supplierDetails.getContactInfo());
        supplier.setAddress(supplierDetails.getAddress());
       // supplier.setLastUpdated(LocalDateTime.now()); // Update timestamp

        return supplierRepo.save(supplier);
    }

    public void deleteSupplier(Long supplierId) {
        if (!supplierRepo.existsById(supplierId)) {
            throw new RuntimeException("Supplier not found with ID: " + supplierId);
        }
        supplierRepo.deleteById(supplierId);
    }
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

}
