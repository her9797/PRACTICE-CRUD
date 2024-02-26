package com.revaluper.crud.report.model.dao;

import com.revaluper.crud.report.model.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {

    List<ReportDTO> findAllReport();

    void modifyReport(ReportDTO reportDTO);

    void insert(ReportDTO reportDTO);

    void delete(ReportDTO reportDTO);
}
