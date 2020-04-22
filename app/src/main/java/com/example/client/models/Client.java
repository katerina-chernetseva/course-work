package com.example.client.models;

public class Client {
    private String ID, FIO, phone, adress, birthdate, email, password;

    public Client(String ID, String FIO, String phone, String adress, String birthdate, String email, String password) {
        this.ID = ID;
        this.FIO = FIO;
        this.phone = phone;
        this.adress = adress;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
    }

    public Client() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
