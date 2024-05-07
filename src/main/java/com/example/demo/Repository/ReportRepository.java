package com.example.demo.Repository;

import com.example.demo.Models.GroupReport;
import com.example.demo.Service.GroupReportService;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<GroupReport,Integer> {
    GroupReport findById(int id);
}
