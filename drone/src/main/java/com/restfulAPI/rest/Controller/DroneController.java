package com.restfulAPI.rest.Controller;

import com.restfulAPI.rest.Entity.Drone;
import com.restfulAPI.rest.Entity.Medication;
import com.restfulAPI.rest.Response.Response;
import com.restfulAPI.rest.Response.ResponseService;
import com.restfulAPI.rest.Service.iDroneService;
import com.restfulAPI.rest.Service.iMedicineService;
import com.restfulAPI.rest.dto.DroneDto;
import com.restfulAPI.rest.dto.MedicationDto;
import com.restfulAPI.rest.dto.SerialNumberAndCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DroneController {

    @Autowired
    iDroneService droneService;

    @Autowired
    iMedicineService medicineService;

    //http Get method - read operation
//    @GetMapping(path = "/drone/{id}")
//    public DroneDto getFlight(@PathVariable(name = "id") Integer droneId){
//        return droneService.getDrone(droneId);
//    }

    @GetMapping(path = "/drone")
    public DroneDto getFlight(@RequestBody DroneDto droneDto){
        return droneService.getDrone(droneDto.getId());
    }

    //http post method - create operation
//    @PostMapping(path = "/register_drone")
//    public DroneDto createFlight(@RequestBody DroneDto droneDto){
//        return droneService.createDrone(droneDto);
//    }

    @PostMapping(path = "/register_drone")
    public Response createDrone(@RequestBody DroneDto droneDto){
        String message = "";
        Response response = new Response();
        if(droneDto == null){
            message = "Drone creation not successful. Exceeded 10 drone, please Delete a pre-existing drone";
        }else{
            droneService.createDrone(droneDto);
            ResponseService r = new ResponseService();
            response = r.createDroneResponse(droneDto) ;
            message = "Drone with Serial Number: " + droneDto.getSerialNumber() + " has been created Successfully";
        }

        return response;
    }
    //@PostMapping(path="/load_drone/{droneSerialNumber}/{medicationCode}")
    @PostMapping(path="/load_drone")
    //public String loadDrone(@PathVariable(name = "droneSerialNumber") String droneSerialNumber, @PathVariable(name = "medicationCode") String medicationCode){
    public Response loadDrone(@RequestBody SerialNumberAndCode serialNumberAndCode){
        //String message = "";
        Response response = new Response();
        DroneDto droneDto = droneService.getDroneBySerialNumber(serialNumberAndCode.getSerialNumber());
        MedicationDto medDto = medicineService.getMedicationBySerialNumber(serialNumberAndCode.getCode());
        ResponseService r = new ResponseService();

        //DroneDto droneDto = droneService.getDroneBySerialNumber(droneSerialNumber);
        //MedicationDto medDto = medicineService.getMedicationBySerialNumber(medicationCode);
        if(droneDto != null && medDto != null ){
            //message="Both Drone and Medication found";
            if(droneDto.getState().equals("IDLE")){
                //message="Drone with Serial Number: "+ droneDto.getSerialNumber()+" is Idle";
                if(droneDto.getWeightLimit() > medDto.getWeight() ){
                    //message = "able to be loaded";
                    if(droneDto.getBatteryCapacity() > 24){
                       // message = "loaded";
                        droneService.createDroneMedication(droneDto.getId(),medDto.getId());
                        droneService.updateDrone(droneDto);
                        response = r.getLoadedDroneResponse(droneDto, medDto);
                    }
                    else if (droneDto.getBatteryCapacity() < 25){
                        response = r.ExceptionResponse("Battery Level below 25%, unable to load");
                    }
                }
                else{
                    response = r.ExceptionResponse("Drone with Serial Number: " + droneDto.getSerialNumber() + " medication exceeded weight limit, unable to load");
                }
            }
            else{
                response = r.ExceptionResponse("Drone with Serial Number: "+ droneDto.getSerialNumber()+" is Not Idle");
            }
        }
        else{
            response = r.ExceptionResponse("Error Drone or Medication does not exist");
        }
        return response;
    }

//    @GetMapping(path = "/getDroneMedication/{serialNumber}")
//    public MedicationDto getDroneMedication(@PathVariable(name = "serialNumber") String serialNumber){
//        return medicineService.getMedicationBySerialNumber2(serialNumber);
//    }

    @GetMapping(path = "/getDroneMedication")
    public Response getDroneMedication(@RequestBody DroneDto droneDto){
        MedicationDto medicationDto = medicineService.getMedicationBySerialNumber2(droneDto.getSerialNumber());
        ResponseService r = new ResponseService();
        Response response = r.getMedicationForDroneResponse(droneDto,medicationDto);
        return response;
    }

//    @GetMapping(path = "/allDroneState/{state}")
//    public List<DroneDto> getAllDronesByState(@PathVariable(name = "state") String state){
//        return droneService.getAllDronesByState(state);
//    }
    @GetMapping(path = "/allDroneState")
    public List<DroneDto> getAllDronesByState(@RequestBody DroneDto droneDto){

        return droneService.getAllDronesByState(droneDto.getState());
    }

//    @GetMapping(path = "/getDroneBatteryLevel/{serialNumber}")
//    public DroneDto getBatteryLevel(@PathVariable(name ="serialNumber") String serialNumber){
//        return droneService.getBatteryLevel(serialNumber);
//    }
    @GetMapping(path = "/getDroneBatteryLevel")
    public Response getBatteryLevel(@RequestBody DroneDto droneDto){
        DroneDto droneTemp = droneService.getBatteryLevel(droneDto.getSerialNumber());
        ResponseService r = new ResponseService();
        Response response = r.getBatteryLevelResponse(droneTemp);
        return response;
    }

}
