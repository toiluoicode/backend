package com.example.demo.Models;

public class Report {
    private String maNhom;

    private String tenNhom;

    private int ghichu;

    public Report(String maNhom, String tenNhom, int ghichu) {
        this.maNhom = maNhom;
        this.tenNhom = tenNhom;
        this.ghichu = ghichu;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public int getGhichu() {
        return ghichu;
    }

    public void setGhichu(int ghichu) {
        this.ghichu = ghichu;
    }
}
