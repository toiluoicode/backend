package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "connect")
public class Connect {
    @Id
    private String maKN;
    private String TenKN;
    private String URL;
    private String User;
    private String Password;

    public Connect(String MaKN, String tenKN, String URL, String user, String password) {
        this.maKN = MaKN;
        this.TenKN = tenKN;
        this.URL = URL;
        this.User = user;
        this.Password = password;
    }
    public Connect(){

    }
    @JsonProperty("MaKN")
    public String getMaKN() {
        return maKN;
    }

    public void setMaKN(String maKN) {
        this.maKN = maKN;
    }

    @JsonProperty("TenKN")
    public String getTenKN() {
        return TenKN;
    }

    public void setTenKN(String tenKN) {
        TenKN = tenKN;
    }
    @JsonProperty("URL")
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    @JsonProperty("User")
    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }
    @JsonProperty("Password")
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
