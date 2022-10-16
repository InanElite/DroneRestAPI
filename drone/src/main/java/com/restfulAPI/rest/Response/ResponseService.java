package com.restfulAPI.rest.Response;

import com.restfulAPI.rest.dto.DroneDto;
import com.restfulAPI.rest.dto.MedicationDto;

import java.lang.invoke.StringConcatFactory;

public class ResponseService {

    public Response createDroneResponse(DroneDto droneDto){
        Response r = new Response();
        r.setMessage("Succesfully Created A Drone");
        r.setTypeOfData("Drone Object with ID: "+droneDto.getId() +" , Serial Number: " + droneDto.getSerialNumber());
        r.setDateTimeCreated(java.time.LocalDateTime.now());
        return r;
    }

    public Response getBatteryLevelResponse(DroneDto droneDto){
        Response r = new Response();
        r.setMessage("Successfully Retrieved Drone Battery Level");
        r.setTypeOfData("Drone Battery Level: " + droneDto.getBatteryCapacity() + "% for Drone ID: " + droneDto.getId() + " , Drone Serial Number: " + droneDto.getSerialNumber() );
        r.setDateTimeCreated(java.time.LocalDateTime.now());
        return r;
    }

    public Response getMedicationForDroneResponse(DroneDto droneDto, MedicationDto medicationDto){
        Response r = new Response();
        r.setMessage("Successfully Retrieved Medication From " +  "Drone Serial Number: " + droneDto.getSerialNumber());
        r.setTypeOfData("Medication Loaded: " + medicationDto.getName()+ " with ID: " + medicationDto.getId() + " , Medication Code: " + medicationDto.getCode());
        r.setDateTimeCreated(java.time.LocalDateTime.now());
        return r;
    }

    public Response getLoadedDroneResponse(DroneDto droneDto, MedicationDto medicationDto){
        Response r = new Response();
        r.setMessage("Successfully Loaded Medication to Drone Serial Number: " + droneDto.getSerialNumber());
        r.setTypeOfData("Medication Loaded: " + medicationDto.getName() + " with ID: " + medicationDto.getId() + " , Medication Code: "+ medicationDto.getCode());
        r.setDateTimeCreated(java.time.LocalDateTime.now());
        return r;
    }

    public Response ExceptionResponse(String a){
        Response r = new Response();
        r.setMessage(a);
        r.setTypeOfData("Data Retrieval Unsuccessful");
        r.setDateTimeCreated(java.time.LocalDateTime.now());
        return r;
    }
}
