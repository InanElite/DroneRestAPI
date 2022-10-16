package com.restfulAPI.rest.Service;

import com.restfulAPI.rest.Entity.Drone;
import com.restfulAPI.rest.Entity.DroneMedication;
import com.restfulAPI.rest.Entity.Medication;
import com.restfulAPI.rest.Repository.iDroneMedicationRepository;
import com.restfulAPI.rest.Repository.iDroneRepository;
import com.restfulAPI.rest.dto.DroneDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DroneService implements iDroneService{

    @Autowired
    iDroneRepository droneRepo;

    @Autowired
    iDroneMedicationRepository droneMedicationRepo;

    @Override
    public DroneDto getDrone(Integer droneId) {
        Optional<Drone> drone = droneRepo.findById(droneId);

        DroneDto dto = null;
        if(drone.isPresent()){
            dto = new DroneDto();
            BeanUtils.copyProperties(drone.get(), dto);
        }

        return dto;
    }

    @Override
    public DroneDto getDroneBySerialNumber(String serialNumber){
        Drone drone = droneRepo.findBySerialNumber(serialNumber);

        DroneDto dto = null;
        //if(drone.isPresent()){
            dto = new DroneDto();
            BeanUtils.copyProperties(drone, dto);
        //}

        return dto;
    }

    @Override
    public String updateDrone(DroneDto droneDto) {
        String message = "";
        Optional<Drone> flightOpt = droneRepo.findById(droneDto.getId());
        if(flightOpt.isPresent())
        {
            droneDto.setState("LOADING");

            Drone drone = new Drone();
            BeanUtils.copyProperties(droneDto,drone);

            drone = droneRepo.save(drone);

            BeanUtils.copyProperties(drone, droneDto);
            message = "Drone with Serial Number: "+ droneDto.getSerialNumber() +" is Updated Successfully";
        }
        else{
            //todo throw exception
            message = "Drone With Serial Number: " + droneDto.getSerialNumber() + " not found";

        }
        return message;
    }

    @Override
    public void createDroneMedication(Integer Did, Integer Mid) {
        DroneMedication droneMedication = new DroneMedication(Did,Mid,false);
        droneMedication = droneMedicationRepo.save(droneMedication);
    }

    @Override
    public DroneDto createDrone(DroneDto droneDto){

        if(droneRepo.count() < 11) {
            Drone drone = new Drone();
            BeanUtils.copyProperties(droneDto, drone);
            drone = droneRepo.save(drone);

            BeanUtils.copyProperties(drone, droneDto);
        }
        else{droneDto = null;}

        return droneDto;
    }

    @Override
    public List<DroneDto> getAllDronesByState(String state) {
        Iterable<Drone> itreable = droneRepo.findAllByState(state);

        List <DroneDto> drones = StreamSupport.stream(itreable.spliterator(), false).map(drone ->{
            DroneDto dto = new DroneDto();
            BeanUtils.copyProperties(drone, dto);
            return dto;
        }).collect(Collectors.toList());
        return drones;
    }

    @Override
    public DroneDto getBatteryLevel(String serialNumber) {
        Drone drone = droneRepo.findBySerialNumber(serialNumber);

        DroneDto dto = new DroneDto();
        BeanUtils.copyProperties(drone, dto);

        return dto;
    }

//    public void preloadMedicationData() {
//        Medication m1 = new Medication(1,"Paracetamol",80,"MedCod001");
//        Medication m2 = new Medication(2,"Metformin",120,"MedCod002");
//        Medication m3 = new Medication(3,"Losartan",90,"MedCod003");
//        Medication m4 = new Medication(4,"Antibiotics",100,"MedCod004");
//        Medication m5 = new Medication(5,"Albuterol",50,"MedCod005");
//        Medication m6 = new Medication(6,"Gaviscon",60,"MedCod006");
//        Medication m7 = new Medication(7,"Antihistamines",110,"MedCod007");
//        Medication m8 = new Medication(8,"Gabapentin",130,"MedCod008");
//        Medication m9 = new Medication(9,"Omeprazole",150,"MedCod009");
//        Medication m10 = new Medication(10,"Abraxane",50,"MedCod010");
//
//
//    }
}
