package com.ssafy.tripds.cctv.controller;

import com.ssafy.tripds.cctv.model.dto.CctvDto;
import com.ssafy.tripds.cctv.model.dto.CoordinateDto;
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

        CoordinateDto coordinateDto = new CoordinateDto(latitude, longitude, distance);
        List<CctvDto> cctvDtoList = cctvService.getNearbyCctv(coordinateDto);

        return new ResponseEntity<>(cctvDtoList, HttpStatus.OK);
    }
}
