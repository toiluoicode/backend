package com.example.demo.Service;

import com.example.demo.Models.GroupReport;
import com.example.demo.Models.Report;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GroupReportService {
    List<GroupReport> findAll ();

    GroupReport addGroupReport (GroupReport groupReport);

    boolean addReport (int Id , Report report);

    boolean deleteReport (int Id , String IdReport);
}
