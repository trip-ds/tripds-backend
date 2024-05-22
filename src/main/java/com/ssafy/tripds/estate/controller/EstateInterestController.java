package com.ssafy.tripds.estate.controller;

import com.ssafy.tripds.estate.model.dto.EstateDto;
import com.ssafy.tripds.estate.model.dto.EstateInterestDto;
import com.ssafy.tripds.estate.model.dto.EstateInterestParamDto;
import com.ssafy.tripds.estate.model.service.EstateService;
import com.ssafy.tripds.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estate/interest")
@RequiredArgsConstructor
@Slf4j
public class EstateInterestController {

    private final MemberService memberService;
    private final EstateService estateService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertEstateInterest(@RequestBody EstateInterestParamDto estateInterestParamDto){
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

    @GetMapping("/info/{email}")
    public ResponseEntity<?> getInterestEsateInfo(@PathVariable ("email") String email){
        Long memberId = memberService.userInfo(email).getId();
        List<String> registerNumberList = estateService.selectEstateInterestByMemberId(memberId);
        List<EstateDto> estateDtoList = estateService.getEstateInfoByRegisterNumbers(registerNumberList);

        return new ResponseEntity<>(estateDtoList, HttpStatus.OK);
    }
}
