package com.restfulAPI.rest.Controller;

import com.restfulAPI.rest.Service.iMedicineService;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicineController {
    @Autowired
    iMedicineService medicineService;

    public void preload(){
        medicineService.preloadMedicationData();
    }
}
