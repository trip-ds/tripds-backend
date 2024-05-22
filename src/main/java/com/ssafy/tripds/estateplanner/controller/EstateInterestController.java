package com.ssafy.tripds.estateplanner.controller;

import com.ssafy.tripds.estateplanner.model.dto.EstateInterestDto;
import com.ssafy.tripds.estateplanner.model.dto.EstateInterestParamDto;
import com.ssafy.tripds.estateplanner.model.service.EstateService;
import com.ssafy.tripds.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estate/interest")
@RequiredArgsConstructor
@Slf4j
public class EstateInterestController {

    private final MemberService memberService;
    private final EstateService estateService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertInterest(@RequestBody EstateInterestParamDto estateInterestParamDto){
        Long memberId = memberService.userInfo(estateInterestParamDto.getEmail()).getId();
        String registerNumber = estateInterestParamDto.getRegisterNumber();

        log.debug("member id = {}", memberId);
        log.debug("register number = {}", registerNumber);

        EstateInterestDto estateInterestDto = EstateInterestDto.builder()
                .registerNumber(registerNumber)
                .memberId(memberId)
                .build();

        int result = estateService.insertEstateInterest(estateInterestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
