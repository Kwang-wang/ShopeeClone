package com.shopeeClone.shopeeClone.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopeeClone.shopeeClone.converter.AddressConverter;
import com.shopeeClone.shopeeClone.dto.AddressDTO;
import com.shopeeClone.shopeeClone.dto.DistrictDTO;
import com.shopeeClone.shopeeClone.entity.AddressEntity;
import com.shopeeClone.shopeeClone.entity.DistrictEntity;
import com.shopeeClone.shopeeClone.entity.ProvinceEntity;
import com.shopeeClone.shopeeClone.entity.WardEntity;
import com.shopeeClone.shopeeClone.exeption.ValidateException;
import com.shopeeClone.shopeeClone.repository.address.AddressRepository;
import com.shopeeClone.shopeeClone.repository.address.DistrictRepository;
import com.shopeeClone.shopeeClone.repository.address.ProvinceRepository;
import com.shopeeClone.shopeeClone.repository.address.WardRepository;
import com.shopeeClone.shopeeClone.service.AddressService;
import com.shopeeClone.shopeeClone.utils.validate;


@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private WardRepository wardRepository;
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private AddressConverter addressConverter;
	
	@Override
	public AddressDTO create(AddressDTO dto) {
		AddressEntity addressEntity  = addressConverter.toEntity(dto);
		ProvinceEntity provinceEntity = findProvince(dto.getProvinceName());
		WardEntity wardEntity = findWard(dto.getWardName());
		DistrictEntity districtEntity = findDistrict(dto.getDistrictName());
		addressEntity.setProvince(provinceEntity);
		addressEntity.setDistrict(districtEntity);
		addressEntity.setWard(wardEntity);
		
		addressRepository.save(addressEntity);
		
		return addressConverter.toDto(addressEntity);
	}
	
	private ProvinceEntity findProvince(String name) {
		ProvinceEntity provinceEntity = provinceRepository.findByName(name)
                .orElseThrow(() -> new ValidateException("Province not found"));
       return provinceEntity;
	}
	
	private DistrictEntity findDistrict(String name) {
		DistrictEntity districtEntity = districtRepository.findByName(name)
                .orElseThrow(() -> new ValidateException("district not found"));
       return districtEntity;
	}
	
	private WardEntity findWard(String name) {
		WardEntity wardEntity = wardRepository.findByName(name)
                .orElseThrow(() -> new ValidateException("ward not found"));
       return wardEntity;
	}
	
	@Override
	public List<AddressDTO> getAll() {
		
		List<AddressEntity> addressEntities = addressRepository.findAll();
		List<AddressDTO> addressDTOs = new ArrayList<AddressDTO>();
		for (AddressEntity addressEntity : addressEntities) {
			AddressDTO addressDTO = addressConverter.toDto(addressEntity);
			addressDTOs.add(addressDTO);
		}
		return addressDTOs;
	}

	@Override
	public void delete(String id) {
		Long id1 = validate.validateId(id);
		AddressEntity addressEntity = addressRepository.findById(id1).orElseThrow(() -> new ValidateException("khong thay dia chi"));
		
		addressRepository.delete(addressEntity);
	}

	@Override
	public AddressDTO update(AddressDTO dto, String id) {
		ProvinceEntity provinceEntity = findProvince(dto.getProvinceName());
		WardEntity wardEntity = findWard(dto.getWardName());
		DistrictEntity districtEntity = findDistrict(dto.getDistrictName());
		
		Long id1 = validate.validateId(id);
		AddressEntity addressEntity = addressRepository.findById(id1).orElseThrow(() -> new ValidateException("khong thay dia chi"));
		
		addressEntity.setDescription(dto.getDescription());
		addressEntity.setDistrict(districtEntity);
		addressEntity.setProvince(provinceEntity);
		addressEntity.setWard(wardEntity);
		return addressConverter.toDto(addressEntity);
	}


}
