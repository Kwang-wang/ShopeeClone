package com.shopeeClone.shopeeClone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopeeClone.shopeeClone.converter.RoleConverter;
import com.shopeeClone.shopeeClone.dto.RoleDTO;
import com.shopeeClone.shopeeClone.entity.RoleEntity;
import com.shopeeClone.shopeeClone.exeption.ValidateException;
import com.shopeeClone.shopeeClone.repository.RoleRepository;
import com.shopeeClone.shopeeClone.service.RoleService;
	
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Override
	public RoleDTO createRole(RoleDTO roleDto) {
		// Validate
		String code = roleDto.getCode();
		validateCode(code);
		// Logic
		// dto -> entity
		RoleEntity newRoleEntity = roleConverter.toEntity(roleDto);
		roleRepository.save(newRoleEntity);
		
		// entity -> dto
		RoleDTO newRoleDto = roleConverter.toDto(newRoleEntity);
		
		return newRoleDto;
	}

	private void validateCode(String code) {
		if (code == null || code.isEmpty()) { // null, ""
			// Bắn lỗi
			throw new ValidateException("Code không được để trống");
		}
		Optional<RoleEntity> roleEntity = roleRepository.findByCode(code);
		if (roleEntity.isPresent()) {
			throw new ValidateException("Role đã tồn tại");
		}
	}

	@Override
	public List<RoleDTO> getAll() {
		List<RoleEntity> roleEntities = roleRepository.findAll();
		List<RoleDTO> roleDtos = roleConverter.toDto(roleEntities);
		return roleDtos;
	}
	
	@Override
	public RoleDTO updateRole(Long roleId, RoleDTO roleDTO) {
		// Validate
		String code = roleDTO.getCode();
		validateCode(code);
		
		// Logic
		// Lấy entity mà muốn update
		RoleEntity roleEntity = getRoleEntityById(roleId);
		
		// Set dữ liệu mới cho entity
		roleEntity.setName(roleDTO.getName());
		roleEntity.setCode(roleDTO.getCode());
		
		roleRepository.save(roleEntity);
		
		return roleConverter.toDto(roleEntity);
	}

	private RoleEntity getRoleEntityById(Long id) {
		RoleEntity roleEntity = roleRepository.findById(id)
				.orElseThrow(() -> new ValidateException("Không tìm thấy role"));
		return roleEntity;
	}
	
	@Override
	public void deleteById(Long roleId) {
		RoleEntity roleEntity = getRoleEntityById(roleId);
		roleRepository.delete(roleEntity);
	}
	
	
}
