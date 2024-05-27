package com.example.demo.Service;

import com.example.demo.Models.GroupReport;
import com.example.demo.Models.Report;
import com.example.demo.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GroupReportServiceImp implements GroupReportService {
    @Autowired
    ReportRepository reportRepository;
    @Override
    public List<GroupReport> findAll() {
       return this.reportRepository.findAll();
    }

    @Override
    public GroupReport addGroupReport(GroupReport groupReport) {
        return this.reportRepository.save(groupReport);
    }

    @Override
    public boolean addReport(int id, Report report) {
        GroupReport groupReport = this.reportRepository.findById(id);
        List<GroupReport> groupReports = new ArrayList<>();
        groupReports.add(groupReport);
        if (groupReports.size() > 0){
            groupReport.getReports().add(report);
            this.reportRepository.save(groupReport);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteReport(int Id, String IdReport) {
        GroupReport groupReport = this.reportRepository.findById(Id);
        List<GroupReport> groupReports = new ArrayList<>();
        groupReports.add(groupReport);
        if (groupReports.size() > 0){
            groupReport.getReports().remove(findIndex(groupReport.getReports(),IdReport));
            this.reportRepository.save(groupReport);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateReport(int Id, String IdReport, Report updateReport) {
        GroupReport groupReport = this.reportRepository.findById(Id);
        List<GroupReport> groupReports = new ArrayList<>();
        groupReports.add(groupReport);
        if(groupReports.size()>0){
            groupReport.getReports().set(findIndex(groupReport.getReports(),IdReport),updateReport);
            this.reportRepository.save(groupReport);
            return true;
        }else
            return false;
    }

    public int findIndex (List<Report> reports, String name){
        for(Report report : reports){
            if (report.getMaNhom().equals(name)){
                return reports.indexOf(report);
            }
        }
        return -1;
    }
//    @Override
//    public boolean saveReport(int id, Report report) {
//        GroupReport groupReport = this.reportRepository.findById(id);
//        if (groupReport != null) {
//            int index = findIndex(groupReport.getReports(), report.getMaNhom());
//            if (index == -1) {
//                groupReport.getReports().add(report);
//            } else {
//                groupReport.getReports().set(index, report);
//            }
//            this.reportRepository.save(groupReport);
//            return true;
//        }
//        return false;
//    }


}
