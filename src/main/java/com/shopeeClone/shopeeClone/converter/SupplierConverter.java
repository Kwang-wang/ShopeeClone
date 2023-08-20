package com.shopeeClone.shopeeClone.converter;

import org.springframework.stereotype.Component;

import com.shopeeClone.shopeeClone.dto.SuppilierDTO;
import com.shopeeClone.shopeeClone.entity.SuppilierEntity;

@Component
public class SupplierConverter {

    public SuppilierDTO toDTO(SuppilierEntity supplierEntity) {
        if (supplierEntity == null) {
            return null;
        }

        SuppilierDTO supplierDTO = new SuppilierDTO();
        supplierDTO.setSupplierId(supplierEntity.getSupplierId());
        supplierDTO.setName(supplierEntity.getName());
        supplierDTO.setPhone(supplierEntity.getPhone());
        supplierDTO.setEmail(supplierEntity.getEmail());
        supplierDTO.setDescription(supplierEntity.getDescription());

        return supplierDTO;
    }

    public SuppilierEntity toEntity(SuppilierDTO supplierDTO) {
        if (supplierDTO == null) {
            return null;
        }

        SuppilierEntity supplierEntity = new SuppilierEntity();
        supplierEntity.setSupplierId(supplierDTO.getSupplierId());
        supplierEntity.setName(supplierDTO.getName());
        supplierEntity.setPhone(supplierDTO.getPhone());
        supplierEntity.setEmail(supplierDTO.getEmail());
        supplierEntity.setDescription(supplierDTO.getDescription());

        return supplierEntity;
    }
}