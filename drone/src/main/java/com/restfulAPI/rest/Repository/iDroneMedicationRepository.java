package com.restfulAPI.rest.Repository;

import com.restfulAPI.rest.Entity.DroneMedication;
import org.springframework.data.repository.CrudRepository;

public interface iDroneMedicationRepository extends CrudRepository<DroneMedication, Integer> {

    Iterable<DroneMedication> findAllByDroneId(Integer droneId);
}
