package com.restfulAPI.rest.Service;

import com.restfulAPI.rest.dto.DroneDto;

import java.util.List;

public interface iDroneService {
    public DroneDto getDrone(Integer flightId);

    public DroneDto createDrone(DroneDto droneDto);

    public List<DroneDto> getAllDronesByState(String state);

    public DroneDto getBatteryLevel(String serialNumber);
    public DroneDto getDroneBySerialNumber(String serialNumber);

    public String updateDrone(DroneDto droneDto);

    public void createDroneMedication(Integer id, Integer id1);
}
