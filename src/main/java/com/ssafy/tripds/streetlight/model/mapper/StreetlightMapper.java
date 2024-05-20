package com.ssafy.tripds.streetlight.model.mapper;

import com.ssafy.tripds.streetlight.model.dto.CoordinateDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface StreetlightMapper {
    List<StreetlightDto> getNearbyStreetLights(CoordinateDto coordinateDto) throws SQLException;
}
