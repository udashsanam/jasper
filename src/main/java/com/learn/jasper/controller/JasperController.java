package com.learn.jasper.controller;

import com.learn.jasper.service.ReportService;
import com.learn.jasper.service.ReportTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/jasper")
public class JasperController {

    private final ReportService reportsService;

    private Logger log = LoggerFactory.getLogger(JasperController.class);

    public JasperController(ReportService reportService) {
        this.reportsService = reportService;
    }

    @GetMapping("/jasper/emp24")
    public ResponseEntity<Resource> employeeJasperReport24(@RequestParam("fileType") String fileType) throws Exception {

        ReportTypeEnum report = ReportTypeEnum.valueOf(fileType);
        log.info("Eum :"+report);
//         byte[] bytes = reportsService.employeeJasperReport24(fileType);
//        byte[] bytes = reportsService.employeeJasperReportInBytes(fileType);
        byte[] bytes = reportsService.robin(fileType);
        if (null != bytes) {
            ByteArrayResource resource = new ByteArrayResource(bytes);
            String fileName = "Employee24_JasperReport" + "_" + LocalDateTime.now() +".xlsx";
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } else {
            throw new RuntimeException("File Download Failed");
        }
    }
}
