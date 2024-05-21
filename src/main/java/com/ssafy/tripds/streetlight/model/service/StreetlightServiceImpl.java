package com.ssafy.tripds.streetlight.model.service;

import com.ssafy.tripds.streetlight.model.dto.StreetlightCoordinateDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightSearchDto;
import com.ssafy.tripds.streetlight.model.mapper.StreetlightMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StreetlightServiceImpl implements StreetlightService{

    private final StreetlightMapper streetlightMapper;

    @Override
    public List<StreetlightDto> getNearbyStreetLights(StreetlightCoordinateDto streetlightCoordinateDto){
        try {
            return streetlightMapper.getNearbyStreetLights(streetlightCoordinateDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StreetlightDto> getStreetlightFromMap(StreetlightSearchDto streetlightSearchDto) {
        try {
            return streetlightMapper.getStreetlightFromMap(streetlightSearchDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
