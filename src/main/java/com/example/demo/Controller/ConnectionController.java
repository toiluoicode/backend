package com.example.demo.Controller;

import com.example.demo.Service.DatabaseService;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Documented;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "connect")
public class ConnectionController {
    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/db")
    public String Connect (){
        databaseService.Connect("mongodb://localhost:27017/BenhVien");
        return "ramus";
    }
    @GetMapping("/in")
    public String Print () throws JRException, FileNotFoundException {
        // Lấy dữ liệu từ MongoDB
        List<Map> documents = databaseService.findAllDocuments("TTBN");
        System.out.println(documents);
        // Chuyển đổi List<Document> thành JRBeanCollectionDataSource
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(documents);

        // Nạp file JRXML template
        InputStream reportInput = new FileInputStream("C:\\Users\\ACER\\JaspersoftWorkspace\\MyReports\\hello.jrxml");
        // Biên dịch template
        JasperReport jasperReport = JasperCompileManager.compileReport(reportInput);

        // Điền dữ liệu vào báo cáo
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\ACER\\helo.pdf");
        return "ing";
    }

}
