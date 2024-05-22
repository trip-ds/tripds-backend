package com.ssafy.tripds.house.controller;

import com.ssafy.tripds.house.model.dto.HouseDealSummaryDto;
import com.ssafy.tripds.house.model.dto.ReviewWriteDto;
import com.ssafy.tripds.house.model.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/house")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping("/deal/list-summary")
    public ResponseEntity<?> getDealListSummary(
            @RequestParam("residenceType") String residenceType,
            @RequestParam("topLat") Double topLat,
            @RequestParam("leftLng") Double leftLng,
            @RequestParam("bottomLat") Double bottomLat,
            @RequestParam("rightLng") Double rightLng
    ) {
        List<HouseDealSummaryDto> list = houseService.getDealListSummary(residenceType, topLat, leftLng, bottomLat, rightLng);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/summary")
    public ResponseEntity<?> getSummary(@RequestParam("roadName") String roadName) {
        return new ResponseEntity<>(houseService.getSummary(roadName), HttpStatus.OK);
    }

    @GetMapping("/deal/summary")
    public ResponseEntity<?> getDealSummary(
            @RequestParam("residenceType") String residenceType,
            @RequestParam("roadName") String roadName) {
        return new ResponseEntity<>(houseService.getDealSummary(residenceType, roadName), HttpStatus.OK);
    }

    @GetMapping("/deal/list")
    public ResponseEntity<?> getDealList(@RequestParam("roadName") String roadName) {
        return new ResponseEntity<>(houseService.getDealList(roadName), HttpStatus.OK);
    }

    @GetMapping("/review/summary")
    public ResponseEntity<?> getReviewSummary(@RequestParam("roadName") String roadName) {
        return new ResponseEntity<>(houseService.getReviewSummary(roadName), HttpStatus.OK);
    }

    @GetMapping("/review/list")
    public ResponseEntity<?> getReviewList(@RequestParam("roadName") String roadName) {
        return new ResponseEntity<>(houseService.getReviewList(roadName), HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<?> registerReview(ReviewWriteDto reviewWriteDto) {
        houseService.registerReview(reviewWriteDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
