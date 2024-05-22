package com.ssafy.tripds.estate.model.mapper;

import com.ssafy.tripds.estate.model.dto.EstateDto;
import com.ssafy.tripds.estate.model.dto.EstateInterestDto;
import com.ssafy.tripds.estate.model.dto.EstatePlannerDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface EstateMapper {
    // 부동산 (공통) //
    List<EstateDto> getEstateInfoByRegisterNumbers(List<String> registerNumberList) throws SQLException;

    // 관심 부동산 //
    int insertEstateInterest(EstateInterestDto estateInterestDto) throws SQLException;
    List<String> selectEstateInterestByMemberId(Long memberId) throws SQLException;

    // 부동산 플래너 //
    int insertEstatePlanner(EstatePlannerDto estatePlannerDto) throws SQLException;
    List<String> selectEstatePlannerByMemberId(Long memberId) throws SQLException;
}
