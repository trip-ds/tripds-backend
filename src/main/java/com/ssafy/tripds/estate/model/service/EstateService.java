package com.ssafy.tripds.estate.model.service;

import com.ssafy.tripds.estate.model.dto.EstateDto;
import com.ssafy.tripds.estate.model.dto.EstateInterestDto;
import com.ssafy.tripds.estate.model.dto.EstatePlannerDto;

import java.util.List;

public interface EstateService {
    // 관심 부동산
    int insertEstateInterest(EstateInterestDto estateInterestDto);
    List<String> selectEstateInterestByMemberId(Long memberId);
    List<EstateDto> getEstateInfoByRegisterNumbers(List<String> registerNumberList);

    // 부동산 플래너
    int insertEstatePlanner(EstatePlannerDto estatePlannerDto);
}
