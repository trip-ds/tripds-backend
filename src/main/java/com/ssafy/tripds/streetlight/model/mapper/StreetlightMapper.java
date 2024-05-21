package com.ssafy.tripds.streetlight.model.mapper;

import com.ssafy.tripds.streetlight.model.dto.StreetlightCoordinateDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface StreetlightMapper {
    List<StreetlightDto> getNearbyStreetLights(StreetlightCoordinateDto streetlightCoordinateDto) throws SQLException;
    List<StreetlightDto> getStreetlightFromMap(StreetlightSearchDto streetlightSearchDto) throws  SQLException;
}
