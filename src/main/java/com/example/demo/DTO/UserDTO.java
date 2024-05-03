package com.example.demo.DTO;

public class UserDTO {
    private String userName;

    private String password;

    private String confirmpassword;

    private String Email;

    public UserDTO(String userName, String password, String confirmpassword, String email) {
        this.userName = userName;
        this.password = password;
        this.confirmpassword = confirmpassword;
        Email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
