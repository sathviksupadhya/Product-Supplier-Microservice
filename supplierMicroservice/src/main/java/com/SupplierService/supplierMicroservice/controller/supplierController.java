package com.SupplierService.supplierMicroservice.controller;

import com.SupplierService.supplierMicroservice.entity.Supplier;
import com.SupplierService.supplierMicroservice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class supplierController {
    @Autowired
    private SupplierService supplierService;

    //get supplier by id
    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long supplierId) {
        Supplier supplier = supplierService.getSupplierById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + supplierId));

        return ResponseEntity.ok(supplier);
    }

    // Get all suppliers
    @GetMapping
    public ResponseEntity<Iterable<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }


    // Update supplier details
    @PutMapping("/{supplierId}")
    public ResponseEntity<Supplier> updateSupplier(
            @PathVariable Long supplierId,
            @RequestBody Supplier supplierDetails) {
        try {
            Supplier updatedSupplier = supplierService.updateSupplier(supplierId, supplierDetails);
            return ResponseEntity.ok(updatedSupplier);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Add a new supplier
    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierService.createSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupplier);
    }

    // Delete a supplier
    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long supplierId) {
        supplierService.deleteSupplier(supplierId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
