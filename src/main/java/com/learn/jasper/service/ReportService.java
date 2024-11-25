package com.learn.jasper.service;

import com.learn.jasper.repository.Employee;
import com.learn.jasper.repository.EmployeeDto;
import com.learn.jasper.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    private final EmployeeRepository  employeeRepository;

    public ReportService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public byte[] employeeJasperReportInBytes(String fileType) throws Exception {
        String template = "reports/emp222.jrxml";
//        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> dataSource = EmployeeDto.getEmployeeList();



//1. Create Required Parameters
        Map<String, Object> parameters = new HashMap<>();
        FileInputStream leafBannerStream = new FileInputStream(ResourceUtils.getFile("classpath:reports/logo.jpg").getAbsolutePath());
        parameters.put("companyName", "BLACK STAR TECHNOLOGIES");
        parameters.put("address", "Address: Raheja Mind Space Entrance Gate, HITEC City, Hyderabad -500081");
        parameters.put("header", "Employees Salary Report");
        parameters.put("logo", leafBannerStream);
        parameters.put("createdBy","Satya Kaveti");

        //2. Create SubReport Data & assign it to Parameters
        List<UserDto>  userDtos = UserDto.getDat();
        JasperReport subReport = JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:reports/supreport.jrxml").getAbsolutePath());
        JRBeanCollectionDataSource subDatasource = new JRBeanCollectionDataSource(userDtos);
        Map<String, Object> subParameters = new HashMap<>();
        subParameters.put("header", "User Accounts - Sub Report");
        //add to main report parameters
        parameters.put("subReport",subReport);
        parameters.put("subDatasource",subDatasource);
        parameters.put("subParameters",subParameters);
        //2.Create DataSource
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataSource);
        //3.Compile .jrmxl template, stored in JasperReport object
        String path = ResourceUtils.getFile("classpath:" + template).getAbsolutePath();
        JasperReport jasperReport = JasperCompileManager.compileReport(path);
        //4.Fill Report - by passing complied .jrxml object, paramters, datasource
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanCollectionDataSource);
        //5.Export Report - by using JasperExportManager
        ReportTypeEnum reportType = ReportTypeEnum.valueOf(fileType);
        return this.exportJasperReportBytes(jasperPrint, reportType);
    }


    //jasperReportsUtil
    public byte[] exportJasperReportBytes(JasperPrint jasperPrint, ReportTypeEnum reportType) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        switch (reportType) {
            case CSV:
                // Export to CSV
                JRCsvExporter csvExporter = new JRCsvExporter();
                csvExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                csvExporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
                csvExporter.exportReport();
                break;
            case XLSX:
                // Export to XLSX
                JRXlsxExporter xlsxExporter = new JRXlsxExporter();
                xlsxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
                xlsxExporter.exportReport();
                break;
            case HTML:
                // Export to HTML
                HtmlExporter htmlExporter = new HtmlExporter();
                htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(outputStream));
                htmlExporter.exportReport();
                break;
            case XML:
                // Export to XML
                JRXmlExporter xmlExporter = new JRXmlExporter();
                xmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                xmlExporter.setExporterOutput(new SimpleXmlExporterOutput(outputStream));
                xmlExporter.exportReport();
                break;
            case DOC:
                // Export to DOCX (RTF format)
                JRRtfExporter docxExporter = new JRRtfExporter();
                docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                docxExporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
                docxExporter.exportReport();
                break;
            case PDF:
                // Export to PDF by default
                JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                break;
        }
        return outputStream.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        Integer count = 0;
        List<String> strings = new ArrayList<>();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        while (true){
            EmployeeDto idn = new EmployeeDto(1l, "John Doe", 50000.0, "New York");
            System.out.println(count);
            employeeDtos.add(idn);

        }
    }
}
