package com.restfulAPI.rest.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "medication_table")
public class Medication {
    @Id
    @Column(name = "medication_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "medication_name")
    private String name;

    @Column(name = "medication_weight")
    private Integer weight;

    @Column(name = "medication_code")
    private String code;

//    @Column(name = "medication_image")
//    private byte image;

    public Medication() {
    }

    public Medication(Integer id,String name, Integer weight, String code) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.code = code;
        //this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   // public byte getImage() {
       // return image;
   // }

//    public void setImage(byte image) {
//        this.image = image;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medication)) return false;
        Medication that = (Medication) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
