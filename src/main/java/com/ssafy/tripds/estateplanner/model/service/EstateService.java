package com.ssafy.tripds.estateplanner.model.service;

import com.ssafy.tripds.estateplanner.model.dto.EstateDto;
import com.ssafy.tripds.estateplanner.model.dto.EstateInterestDto;

import java.util.List;

public interface EstateService {
    int insertEstateInterest(EstateInterestDto estateInterestDto);
    List<String> selectEstateInterestByMemberId(Long memberId);
    List<EstateDto> getEstateInfoByRegisterNumbers(List<String> registerNumberList);
}
