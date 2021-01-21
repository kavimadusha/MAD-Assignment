package com.example.servicestation;

public class UserHelperClass {

    String Email_address,Username,Phone_Number,Password,Confirm_Password;

    public UserHelperClass() {
    }

    public UserHelperClass(String email_address, String username, String phone_Number, String password, String confirm_Password) {
        Email_address = email_address;
        Username = username;
        Phone_Number = phone_Number;
        Password = password;
        Confirm_Password = confirm_Password;
    }

    public String getEmail_address() {
        return Email_address;
    }

    public void setEmail_address(String email_address) {
        Email_address = email_address;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirm_Password() {
        return Confirm_Password;
    }

    public void setConfirm_Password(String confirm_Password) {
        Confirm_Password = confirm_Password;
    }
}

