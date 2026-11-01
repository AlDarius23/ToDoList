package com.example.mytodolist;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
@Entity(tableName = "tasks")
public class Task {
    @PrimaryKey(autoGenerate = true)
    int id;
    String titlu;
    String descriere;
    boolean terminat = false;
    int durata;
    LocalDate dataIncepere;
    LocalDate dataTerminare;
    Nivel urgenta;

    public Task(int id, String titlu) {
        this.id = id;
        this.titlu = titlu;
    }

    public Task(int id, String titlu, String descriere, boolean terminat, int durata, LocalDate data_incepere, LocalDate data_terminare, Nivel urgenta) {
        this.id = id;
        this.titlu = titlu;
        this.descriere = descriere;
        this.terminat = terminat;
        this.durata = durata;
        this.dataIncepere = data_incepere;
        this.dataTerminare = data_terminare;
        this.urgenta = urgenta;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public boolean isTerminat() {
        return terminat;
    }

    public void setTerminat(boolean terminat) {
        this.terminat = terminat;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Nivel getUrgenta() {
        return urgenta;
    }

    public void setUrgenta(Nivel urgenta) {
        this.urgenta = urgenta;
    }

    public LocalDate getData_terminare() {
        return dataTerminare;
    }

    public void setData_terminare(LocalDate data_terminare) {
        this.dataTerminare = data_terminare;
    }

    public LocalDate getData_incepere() {
        return dataIncepere;
    }

    public void setData_incepere(LocalDate data_incepere) {
        this.dataIncepere = data_incepere;
    }
}
