package com.ssafy.tripds.cctv.controller;

import com.ssafy.tripds.cctv.model.dto.CctvDto;
import com.ssafy.tripds.cctv.model.dto.CctvSearchDto;
import com.ssafy.tripds.cctv.model.dto.CctvCoordinateDto;
import com.ssafy.tripds.cctv.model.service.CctvService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cctv")
public class CctvController {

    private final CctvService cctvService;

    @GetMapping("/nearby")
    public ResponseEntity<?> getNearbyCctv(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("distance") double distance) {

        CctvCoordinateDto cctvCoordinateDto = new CctvCoordinateDto(latitude, longitude, distance);
        List<CctvDto> cctvDtoList = cctvService.getNearbyCctv(cctvCoordinateDto);

        return new ResponseEntity<>(cctvDtoList, HttpStatus.OK);
    }
  
    @GetMapping("/map")
    public ResponseEntity<?> getCctvFromMap(
            @RequestParam("swLat") double swLat,
            @RequestParam("swLng") double swLng,
            @RequestParam("neLat") double neLat,
            @RequestParam("neLng") double neLng) {

        CctvSearchDto cctvSearchDto = new CctvSearchDto(swLat, swLng, neLat, neLng);
        List<CctvDto> cctvDtoList = cctvService.getCctvFromMap(cctvSearchDto);

        return new ResponseEntity<>(cctvDtoList, HttpStatus.OK);
    }
}
