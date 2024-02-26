package com.revaluper.crud.report.model.service;

import com.revaluper.crud.report.model.dao.ReportMapper;
import com.revaluper.crud.report.model.dto.ReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private final ReportMapper reportMapper;

    public ReportService(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    public List<ReportDTO> findAllReport() {
        return reportMapper.findAllReport();
    }

    public void modifyReport(ReportDTO reportDTO) {
        reportMapper.modifyReport(reportDTO);
    }

    public void insert(ReportDTO reportDTO) {
        reportMapper.insert(reportDTO);
    }

    public void delete(ReportDTO reportDTO) {
        reportMapper.delete(reportDTO);
    }
}
