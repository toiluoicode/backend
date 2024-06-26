package com.example.demo.Controller;

import com.example.demo.DTO.QueryDTO;
import com.example.demo.Service.DatabaseService;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Documented;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "connectDB")
public class ConnectionController {
    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/db")
    public ResponseEntity<?> Connect (@RequestParam(name = "connectionString" , required = true) String URL){
        if ( URL != null)
        {
          databaseService.Connect(URL);

            return ResponseEntity.status(201).body("{\"message\": \"success\"}");
        }
        return ResponseEntity.status(201).body("{\"message\": \"failed\"}");
    }
    @GetMapping("/in")
    public String Print (HttpServletResponse response) throws JRException, FileNotFoundException {
        // Lấy dữ liệu từ MongoDB
        List<Map> documents = databaseService.findAllDocuments("TTTN");
        System.out.println(documents);
        // Chuyển đổi List<Document> thành JRBeanCollectionDataSource
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(documents);

        // Nạp file JRXML template
        InputStream reportInput = new FileInputStream("C:\\Users\\ACER\\JaspersoftWorkspace\\MyReports\\PCDXN.jrxml");
//        // Biên dịch template
        JasperReport jasperReport = JasperCompileManager.compileReport(reportInput);
//
        // Điền dữ liệu vào báo cáo
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\ACER\\helo.pdf");
        return "ing";
    }
    @GetMapping("/execute")
    public String PrintQuery (HttpServletResponse response,@RequestBody QueryDTO query) throws JRException, FileNotFoundException {
    String queryString = query.getQuery();
    List<Map> documents = databaseService.excutequery(queryString,"TTTN");
    System.out.println(documents.get(0).get("_id"));
    Object id = documents.get(0).get("_id");
    String idReport = id.toString();
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(documents);
    InputStream reportInput = new FileInputStream("C:\\Users\\ACER\\JaspersoftWorkspace\\MyReports\\test.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(reportInput);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
    JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\ACER\\"+idReport+".pdf");
//    System.out.println(jasperPrint);
    return  documents.toString();
    }
    @GetMapping("/execute1")
      public String PrintQuery1 (HttpServletResponse response,@RequestBody QueryDTO query) throws JRException, FileNotFoundException {
        String queryString = query.getQuery();
        String collection =query.getCollection();
        String form = query.getForm();
        System.out.println(query.getCollection());
        List<Map> documents = databaseService.excutequery(queryString,collection);
        Object id = documents.get(0).get("_id");
        String idReport = id.toString();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(documents);
        InputStream reportInput = new FileInputStream("C:\\Users\\ACER\\JaspersoftWorkspace\\MyReports\\"+form+".jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(reportInput);
        String link = "C:\\Users\\ACER\\"+idReport+".pdf";
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, link);
        return  link;
    }
    @GetMapping("checkDatabase")
    public Set<String> CollectionNames (){
        return databaseService.getMongoTemplate().getCollectionNames();
    }
}
