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
public class Bananas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Данные не могут быть пустыми!")
    @Size(message = "Поле не может быть меньше или больше", min = 0, max = 100)
    String name,opisanie,companiyaPostavki;

    public Bananas(String name, String opisanie, String companiyaPostavki, int cost, int colZakazov) {
        this.name = name;
        this.opisanie = opisanie;
        this.companiyaPostavki = companiyaPostavki;
        Cost = cost;
        this.colZakazov = colZakazov;
    }
    @NotEmpty(message = "Перемманая не может быть пустой!")
    @Min(message = "Переменная не может быть отрицательным",value = 0)
    @Max(message = "Переменная не может быть больше 50000",value = 50000)
    int Cost,colZakazov;

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

    public int getCost() {
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

    public void setCost(int cost) {
        Cost = cost;
    }

    public void setColZakazov(int colZakazov) {
        this.colZakazov = colZakazov;
    }

    public int getColZakazov() {
        return colZakazov;
    }

    public Bananas() {

    }
}
