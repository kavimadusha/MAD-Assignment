package com.example.servicestation;

public class UserHelperClass3 {

    String Garage_Name,Description,Address,Phone_Number,Owner_Details,No_of_employees;

    public UserHelperClass3(){

    }

    public UserHelperClass3(String garage_Name, String description, String address, String phone_Number, String owner_Details, String no_of_employees) {
        Garage_Name = garage_Name;
        Description = description;
        Address = address;
        Phone_Number = phone_Number;
        Owner_Details = owner_Details;
        No_of_employees = no_of_employees;
    }

    public String getGarage_Name() {
        return Garage_Name;
    }

    public void setGarage_Name(String garage_Name) {
        Garage_Name = garage_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getOwner_Details() {
        return Owner_Details;
    }

    public void setOwner_Details(String owner_Details) {
        Owner_Details = owner_Details;
    }

    public String getNo_of_employees() {
        return No_of_employees;
    }

    public void setNo_of_employees(String no_of_employees) {
        No_of_employees = no_of_employees;
    }
}

