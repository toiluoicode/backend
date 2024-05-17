package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "groupReport")
public class GroupReport {

    @Id
    private int id;
    private String groupReport;

    private List<Report> reports;

    public GroupReport(int id, String groupReport, List<Report> reports) {
        this.id = id;
        this.groupReport = groupReport;
        this.reports = reports;
    }

    public GroupReport(int id, String groupReport) {
        this.id = id;
        this.groupReport = groupReport;
    }

    public GroupReport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupReport() {
        return groupReport;
    }

    public void setGroupReport(String groupReport) {
        this.groupReport = groupReport;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
