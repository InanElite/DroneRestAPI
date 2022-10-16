package com.restfulAPI.rest.Entity;

import javax.persistence.*;

@Entity(name = "drones_medication_table")
public class DroneMedication {

    @Id
    @Column(name = "drone_medication_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "drone_id", nullable = false)
    private Integer droneId;

    @Column(name = "medication_id", nullable = false)
    private Integer medicationId;

    @Column(name = "Delivered", nullable = false)
    private Boolean medication_delivered;

    public DroneMedication() {
    }

    public DroneMedication(Integer droneId, Integer medicationId, Boolean medication_delivered) {
        this.droneId = droneId;
        this.medicationId = medicationId;
        this.medication_delivered = medication_delivered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDroneId() {
        return droneId;
    }

    public void setDroneId(Integer droneId) {
        this.droneId = droneId;
    }

    public Integer getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Integer medicationId) {
        this.medicationId = medicationId;
    }

    public Boolean getMedication_delivered() {
        return medication_delivered;
    }

    public void setMedication_delivered(Boolean medication_delivered) {
        this.medication_delivered = medication_delivered;
    }
}
