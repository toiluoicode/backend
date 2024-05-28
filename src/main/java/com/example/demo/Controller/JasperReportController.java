package com.example.demo.Controller;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jasper")
public class JasperReportController {
    @GetMapping("/helo")
    public String hello () throws JRException, FileNotFoundException {
        InputStream reportInput = new FileInputStream("C:\\Users\\ACER\\JaspersoftWorkspace\\MyReports\\hello.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(reportInput);
        Map<String, Object> parameters  = new HashMap<>();
        parameters .put("hello","hello");

        System.out.println(parameters.get("hello"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters , new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\ACER\\helo.pdf");
        return "hello";
    }
}
