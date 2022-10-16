package com.restfulAPI.rest.Loader;

import com.restfulAPI.rest.Entity.Medication;
import com.restfulAPI.rest.Repository.iMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private iMedicineRepository iMedRepo;

    @Autowired
    public DataLoader(iMedicineRepository iMedRepo){
        this.iMedRepo = iMedRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(iMedRepo.count() < 1) {
            iMedRepo.save(new Medication(1, "Paracetamol", 80, "MedCod001"));
            iMedRepo.save(new Medication(2, "Metformin", 120, "MedCod002"));
            iMedRepo.save(new Medication(3, "Losartan", 90, "MedCod003"));
            iMedRepo.save(new Medication(4, "Antibiotics", 100, "MedCod004"));
            iMedRepo.save(new Medication(5, "Albuterol", 50, "MedCod005"));
            iMedRepo.save(new Medication(6, "Gaviscon", 60, "MedCod006"));
            iMedRepo.save(new Medication(7, "Antihistamines", 110, "MedCod007"));
            iMedRepo.save(new Medication(8, "Gabapentin", 130, "MedCod008"));
            iMedRepo.save(new Medication(9, "Omeprazole", 150, "MedCod009"));
            iMedRepo.save(new Medication(10, "Abraxane", 50, "MedCod010"));
        }
    }
}
