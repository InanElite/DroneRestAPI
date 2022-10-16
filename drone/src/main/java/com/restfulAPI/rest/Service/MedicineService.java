package com.restfulAPI.rest.Service;

import com.restfulAPI.rest.Entity.Drone;
import com.restfulAPI.rest.Entity.DroneMedication;
import com.restfulAPI.rest.Entity.Medication;
import com.restfulAPI.rest.Repository.iDroneMedicationRepository;
import com.restfulAPI.rest.Repository.iDroneRepository;
import com.restfulAPI.rest.Repository.iMedicineRepository;
import com.restfulAPI.rest.dto.DroneDto;
import com.restfulAPI.rest.dto.MedicationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MedicineService implements iMedicineService{

    @Autowired
    iMedicineRepository medicineRepo;

    @Autowired
    iDroneRepository droneRepo;

    @Autowired
    iDroneMedicationRepository droneMedicationRepo;

    //@Override
//    public void preload(){
//            preloadMedicationData();
//    }

    @Override
    public void preloadMedicationData() {
        if(medicineRepo.count() < 1 ) {
            Medication m1 = new Medication(1,"Paracetamol", 80, "MedCod001");
            Medication m2 = new Medication(2,"Metformin", 120, "MedCod002");
            Medication m3 = new Medication(3,"Losartan", 90, "MedCod003");
            Medication m4 = new Medication(4,"Antibiotics", 100, "MedCod004");
            Medication m5 = new Medication(5,"Albuterol", 50, "MedCod005");
            Medication m6 = new Medication(6,"Gaviscon", 60, "MedCod006");
            Medication m7 = new Medication(7,"Antihistamines", 110, "MedCod007");
            Medication m8 = new Medication(8,"Gabapentin", 130, "MedCod008");
            Medication m9 = new Medication(9,"Omeprazole", 150, "MedCod009");
            Medication m10 = new Medication(10,"Abraxane", 50, "MedCod010");

            medicineRepo.save(m1);
            medicineRepo.save(m2);
            medicineRepo.save(m3);
            medicineRepo.save(m4);
            medicineRepo.save(m5);
            medicineRepo.save(m6);
            medicineRepo.save(m7);
            medicineRepo.save(m8);
            medicineRepo.save(m9);
            medicineRepo.save(m10);
        }
    }

    @Override
    public MedicationDto getMedicationBySerialNumber(String serialNumber){
        Medication med = medicineRepo.findByCode(serialNumber);

        MedicationDto dto = null;

        //if(drone.isPresent()){
        dto = new MedicationDto();
        BeanUtils.copyProperties(med, dto);
        //}

        return dto;
    }

    @Override
    public MedicationDto getMedicationBySerialNumber2(String serialNumber) {
        Drone drone = droneRepo.findBySerialNumber(serialNumber);
        Iterable<MedicationDto> iterable = null;
        MedicationDto dto = null;
        Integer droneId;
        if(drone != null){
            droneId = drone.getId();
            Iterable<DroneMedication> dmIterable = droneMedicationRepo.findAllByDroneId(droneId);

            List<DroneMedication> dmList = StreamSupport.stream(dmIterable.spliterator(), false).map( DroneMedication ->{
                DroneMedication dto1 = new DroneMedication();
                BeanUtils.copyProperties(DroneMedication, dto1);
                return dto1;
            }).collect(Collectors.toList());
            DroneMedication dmVar = new DroneMedication();
            for(DroneMedication dmEntity: dmList){
                if(Boolean.compare(dmEntity.getMedication_delivered(), false) == 0){
                    dmVar = dmEntity;
                    break;
                }
            }
            Optional<Medication> medDto = medicineRepo.findById(dmVar.getMedicationId());


            if(medDto.isPresent()){
                dto = new MedicationDto();
                BeanUtils.copyProperties(medDto.get(), dto);
            }
        }
//        List <MedicationDto> medDto = StreamSupport.stream(iterable.spliterator(), false).map( Medication ->{
//            MedicationDto dto = new MedicationDto();
//            BeanUtils.copyProperties(Medication, dto);
//            return dto;
//        }).collect(Collectors.toList());


        return dto;
    }
}
