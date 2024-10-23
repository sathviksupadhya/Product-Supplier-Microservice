package com.SupplierService.supplierMicroservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SupplierDto {
    @NotBlank(message="supplier name should not be blank")
    private String name;
    @NotBlank(message="supplier name should not be blank")
    private String address;
    @NotBlank(message="supplier contact info should not be null")
    private String contactInfo;
}
