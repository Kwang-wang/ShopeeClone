package com.shopeeClone.shopeeClone.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopeeClone.shopeeClone.dto.DistrictDTO;
import com.shopeeClone.shopeeClone.dto.WardDTO;
import com.shopeeClone.shopeeClone.entity.DistrictEntity;
import com.shopeeClone.shopeeClone.entity.ProvinceEntity;
import com.shopeeClone.shopeeClone.entity.WardEntity;
import com.shopeeClone.shopeeClone.service.AddressService;
import com.shopeeClone.shopeeClone.service.DistrictService;

@RestController
@RequestMapping("admin/api/v1/districts")
public class DistrictV1Api {
	
	@Autowired
	private DistrictService districtService;
	
	@PostMapping
	public DistrictDTO create(@RequestBody DistrictDTO dto) {
		return districtService.create(dto);
	}
	
	@GetMapping
	public List<DistrictDTO> getAll(){
		return districtService.getAll();
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		districtService.delete(id);
	}
	
	@PatchMapping("{id}")
	public DistrictDTO update(@RequestBody DistrictDTO dto, @PathVariable String id) {
		return districtService.update(dto, id);
	}
}