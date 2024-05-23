package com.ssafy.tripds.estate.controller;

import com.ssafy.tripds.estate.model.service.EstateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estate")
@RequiredArgsConstructor
@Slf4j
public class EstateController {

    private final EstateService estateService;

    @GetMapping("/detail/{registerNumber}")
    public ResponseEntity<?> getEstateDetail(@PathVariable("registerNumber") String registerNumber){
        return new ResponseEntity<>(estateService.getEstateDetail(registerNumber), HttpStatus.OK);
    }
}
