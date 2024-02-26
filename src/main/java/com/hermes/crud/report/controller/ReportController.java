package com.hermes.crud.report.controller;

import com.hermes.crud.report.model.dto.ReportDTO;
import com.hermes.crud.report.model.service.ReportService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void delete(){}

    @PostMapping("/delete")
    public String delete(ReportDTO reportDTO) {

        reportDTO.setRepNo(reportDTO.getRepNo());
        reportService.delete(reportDTO);

        return "main";
    }
}
