package com.ssafy.tripds.cctv.model.mapper;

import com.ssafy.tripds.cctv.model.dto.CctvDto;
import com.ssafy.tripds.cctv.model.dto.CoordinateDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface CctvMapper {
    List<CctvDto> getNearbyCctv(CoordinateDto coordinateDto) throws SQLException;
}
