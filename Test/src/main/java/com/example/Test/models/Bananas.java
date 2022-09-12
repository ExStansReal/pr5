package com.example.Test.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Bananas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Данные не могут быть пустыми!")
    @Size(message = "Поле не может быть меньше или больше", min = 0, max = 100)
    String name,opisanie,companiyaPostavki;

    public Bananas(String name, String opisanie, String companiyaPostavki, Integer cost, Integer colZakazov) {
        this.name = name;
        this.opisanie = opisanie;
        this.companiyaPostavki = companiyaPostavki;
        Cost = cost;
        this.colZakazov = colZakazov;
    }
    @NotNull(message = "Цена не может быть пустой!")
    @Min(message = "Цена не может быть отрицательным",value = 0)
    @Max(message = "Цена не может быть больше 50000",value = 50000)
    Integer Cost;
    @NotNull(message = "Колличество заказов не может быть пустой!")
    @Min(message = "Колличество заказов не может быть отрицательным",value = 0)
    @Max(message = "Колличество заказов не может быть больше 500",value = 500)
    Integer colZakazov;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public String getCompaniyaPostavki() {
        return companiyaPostavki;
    }

    public Integer getCost() {
        return Cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public void setCompaniyaPostavki(String companiyaPostavki) {
        this.companiyaPostavki = companiyaPostavki;
    }

    public void setCost(Integer cost) {
        Cost = cost;
    }

    public void setColZakazov(Integer colZakazov) {
        this.colZakazov = colZakazov;
    }

    public Integer getColZakazov() {
        return colZakazov;
    }

    public Bananas() {

    }
}
