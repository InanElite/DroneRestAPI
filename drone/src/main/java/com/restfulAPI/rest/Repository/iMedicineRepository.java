package com.restfulAPI.rest.Repository;

import com.restfulAPI.rest.Entity.Medication;

import org.springframework.data.repository.CrudRepository;

public interface iMedicineRepository extends CrudRepository<Medication,Integer> {
    Medication findByCode(String serialNumber);
}
