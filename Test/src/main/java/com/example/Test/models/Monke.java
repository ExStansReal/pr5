package com.example.Test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Monke {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public String getChena() {
        return chena;
    }

    public void setChena(String chena) {
        this.chena = chena;
    }

    public Integer getRost() {
        return rost;
    }

    public void setRost(Integer rost) {
        this.rost = rost;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    @NotEmpty(message = "Имя не может быть пустым!")
    @Size(message = "Имя не может быть меньше или больше", min = 3, max = 50)
    String name;
    @NotEmpty(message = "Описание не может быть пустым!")
    @Size(message = "Описание не может быть меньше или больше", min = 3, max = 1000)
    String opisanie;
    @NotEmpty(message = "Цена не может быть пустой!")
    @Min(message = "Цена не может быть отрицательным",value = 0)
    @Max(message = "Цена не может быть больше 1000000",value = 1000000)
    String chena;

    public Monke(String name, String opisanie, String chena, Integer rost, Integer weight) {
        this.name = name;
        this.opisanie = opisanie;
        this.chena = chena;
        this.rost = rost;
        this.weight = weight;
    }
    @NotEmpty(message = "Рост не может быть пустой!")
    @Min(message = "Ромт не может быть отрицательным",value = 0)
    @Max(message = "Рост не может быть больше 200",value = 200)
    Integer rost;


    @Min(message = "Вес не может быть меньше 10",value = 10)
    @Max(message = "Вес не может быть больше 500",value = 500)
    @NotEmpty(message = "Вес не может быть пустым!")
    Integer weight;

    public Monke() {

    }
}
