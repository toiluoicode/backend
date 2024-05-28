package com.example.demo.Controller;

import com.example.demo.Models.GroupReport;
import com.example.demo.Models.Report;
import com.example.demo.Service.GroupReportServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Report")
public class ReportController {
    @Autowired
    GroupReportServiceImp groupReportServiceImp;
    @GetMapping("/findAll")
    public List<GroupReport> groupReports (){
        return this.groupReportServiceImp.findAll();
    }
    @PostMapping("/add")
    public String Add (@RequestBody GroupReport groupReport){
        this.groupReportServiceImp.addGroupReport(groupReport);
        return "success";
    }
    @PostMapping("/addReport/{id}")
    public ResponseEntity<?> addReport (@PathVariable int id , @RequestBody Report report){
        boolean check = this.groupReportServiceImp.addReport(id,report);
        if(check){
            return ResponseEntity.status(200).body("{\"message\": \"success\"}");
        }else {
            return ResponseEntity.status(404).body("{\"message\": \"fails\"}");
        }
    }
    @PutMapping("/updateReport/{Id}/{IdReport}")
    public ResponseEntity<?> updatedeleteReport (@PathVariable int Id , @PathVariable String IdReport,@RequestBody Report updateReport){
        boolean check = this.groupReportServiceImp.updateReport(Id,IdReport,updateReport);
        if(check){
            return ResponseEntity.status(200).body("{\"message\": \"success\"}");
        }else {
            return ResponseEntity.status(404).body("{\"message\": \"fails\"}");
        }
    }
    @DeleteMapping("/deleteReport/{Id}/{IdReport}")
    public ResponseEntity<?> deleteReport (@PathVariable int Id , @PathVariable String IdReport){
        boolean check = this.groupReportServiceImp.deleteReport(Id,IdReport);
        if(check){
            return ResponseEntity.status(200).body("{\"message\": \"success\"}");
        }else {
            return ResponseEntity.status(404).body("{\"message\": \"fails\"}");
        }
    }

}
