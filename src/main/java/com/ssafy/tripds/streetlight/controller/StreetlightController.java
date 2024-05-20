package com.ssafy.tripds.streetlight.controller;

import com.ssafy.tripds.streetlight.model.dto.CoordinateDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightDto;
import com.ssafy.tripds.streetlight.model.service.StreetlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/light")
@RequiredArgsConstructor
@Slf4j
public class StreetlightController {

    private final StreetlightService streetlightService;

    @GetMapping("/nearby")
    public ResponseEntity<?> getNearbyStreetLights(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("radius") long radius) {

        CoordinateDto coordinateDto = new CoordinateDto(latitude, longitude, radius);
        List<StreetlightDto> streetlightDto = streetlightService.getNearbyStreetLights(coordinateDto);

        return new ResponseEntity<>(streetlightDto, HttpStatus.OK);
    }
}
