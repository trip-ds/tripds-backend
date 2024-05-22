package com.ssafy.tripds.estate.controller;

import com.ssafy.tripds.estate.model.dto.EstateDto;
import com.ssafy.tripds.estate.model.dto.EstatePlannerDto;
import com.ssafy.tripds.estate.model.dto.EstatePlannerParamDto;
import com.ssafy.tripds.estate.model.service.EstateService;
import com.ssafy.tripds.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estate/planner")
@RequiredArgsConstructor
@Slf4j
public class EstatePlannerController {

    private final MemberService memberService;
    private final EstateService estateService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertEstatePlanner(@RequestBody EstatePlannerParamDto estatePlannerParamDto){
        Long memberId = memberService.userInfo(estatePlannerParamDto.getEmail()).getId();
        String registerNumber = estatePlannerParamDto.getRegisterNumber();

        log.debug("member id = {}", memberId);
        log.debug("register number = {}", registerNumber);

        EstatePlannerDto estatePlannerDto = EstatePlannerDto.builder()
                .registerNumber(registerNumber)
                .memberId(memberId)
                .build();

        int result = estateService.insertEstatePlanner(estatePlannerDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/info/{email}")
    public ResponseEntity<?> getEstatePlannerInfoByEmail(@PathVariable ("email") String email){
        Long memberId = memberService.userInfo(email).getId();
        List<String> registerNumberList = estateService.selectEstatePlannerByMemberId(memberId);
        List<EstateDto> estateDtoList = estateService.getEstateInfoByRegisterNumbers(registerNumberList);

        return new ResponseEntity<>(estateDtoList, HttpStatus.OK);
    }
}
