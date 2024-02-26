package com.revaluper.crud.report.controller;

import com.revaluper.crud.report.model.dto.ReportDTO;
import com.revaluper.crud.report.model.service.ReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yaml.snakeyaml.representer.Represent;

import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController {


    private final ReportService reportService;

    public ReportController(ReportService reportService, MessageSource messageSource) {
        this.reportService = reportService;
    }

    @GetMapping("/list")
    public String findAllReport(Model model) {

        List<ReportDTO> reportList = reportService.findAllReport();
        System.out.println("reportList : " + reportList + "\n");
        model.addAttribute("reportList", reportList);

        return "report/list";
    }


    @GetMapping("/insert")
    public void insert() {}


    @PostMapping("/insert")
    public String insert(ReportDTO reportDTO){
        System.out.println(reportDTO);
        reportService.insert(reportDTO);

        return "main";
    }

    @GetMapping("/modify")
    public void modifyReport(){}

    @PostMapping("/modify")
    public String modifyReport(int repNo, String repContent) {

        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setRepNo(repNo);
        reportDTO.setRepContent(repContent);

        reportService.modifyReport(reportDTO);

        return "main";
    }

    @GetMapping("/delete")
    public String delete(ReportDTO reportDTO) {
//        reportDTO.setRepNo(3);
        reportService.delete(reportDTO);

        return "main";
    }
}
