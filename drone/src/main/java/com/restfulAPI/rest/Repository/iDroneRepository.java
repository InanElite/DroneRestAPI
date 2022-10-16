package com.restfulAPI.rest.Repository;

import com.restfulAPI.rest.Entity.Drone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface iDroneRepository extends CrudRepository<Drone, Integer> {
    List<Drone> findAllByState(String state);

    Drone findBySerialNumber(String serialNumber);

}
