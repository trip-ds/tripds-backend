package com.ssafy.tripds.streetlight.model.service;

import com.ssafy.tripds.streetlight.model.dto.CoordinateDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightDto;

import java.util.List;

public interface StreetlightService {

    List<StreetlightDto> getNearbyStreetLights(CoordinateDto coordinateDto);

}
