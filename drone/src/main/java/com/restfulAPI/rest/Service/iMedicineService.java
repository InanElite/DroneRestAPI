package com.restfulAPI.rest.Service;

import com.restfulAPI.rest.dto.MedicationDto;

import java.util.List;

public interface iMedicineService {
    void preloadMedicationData();

    MedicationDto getMedicationBySerialNumber(String serialNumber);

    MedicationDto getMedicationBySerialNumber2(String serialNumber);
}
