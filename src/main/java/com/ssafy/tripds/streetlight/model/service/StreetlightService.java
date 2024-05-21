package com.ssafy.tripds.streetlight.model.service;

import com.ssafy.tripds.streetlight.model.dto.StreetlightCoordinateDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightSearchDto;
import java.util.List;

public interface StreetlightService {
    List<StreetlightDto> getNearbyStreetLights(StreetlightCoordinateDto streetlightCoordinateDto);
    List<StreetlightDto> getStreetlightFromMap(StreetlightSearchDto streetlightSearchDto);
}
