package com.example.demo.student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private Boolean express;
    private Integer distance;
    private Integer cod;
    private Integer insurefee;

    @Transient
    private Integer fee;

    public Student() {
    }

    public Student(Integer distance, Integer cod, Boolean express, Integer insurefee) {
        this.distance = distance;
        this.cod = cod;
        this.insurefee = insurefee;
        this.express = express;
    }

    public Student(Integer distance, Integer cod, Integer insurefee) {
        this.distance = distance;
        this.cod = cod;
        this.insurefee = insurefee;
    }


    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getInsurefee() {
        return insurefee;
    }

    public void setInsurefee(Integer insurefee) {
        this.insurefee = insurefee;
    }

    public Long getId() {
        return id;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getFee() {
        return Feecalculator(this.distance);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getExpress() {
        return express;
    }

    public void setExpress(Boolean express) {
        this.express = express;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", express=" + express +
                ", distance=" + distance +
                ", cod=" + cod +
                ", insurefee=" + insurefee +
                ", fee=" + fee +
                '}';
    }

    public Integer Feecalculator(Integer distance){
        Integer modifier = 0;
        if(express){
            if(distance < 5001){
                return 17000;
            }
            if(distance > 5000 && distance < 15001){
                modifier = 5;
            }
            if(distance > 15000){
                modifier = 8;
            }
        }else{
            if(distance < 10001){
                return 25000;
            }
            if(distance > 10000 && distance < 15001){
                return 33000;
            }
            if(distance > 15000 && distance < 20001){
                return 36000;
            }
            if(distance > 20000){
                return 39000;
            }
        }
        Integer feealter = (distance*modifier) + this.cod + this.insurefee;
        return feealter;
    }
}
