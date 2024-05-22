package com.ssafy.tripds.estateplanner.model.mapper;

import com.ssafy.tripds.estateplanner.model.dto.EstateDto;
import com.ssafy.tripds.estateplanner.model.dto.EstateInterestDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface EstateMapper {
    int insertEstateInterest(EstateInterestDto estateInterestDto) throws SQLException;
    List<String> selectEstateInterestByMemberId(Long memberId) throws SQLException;
    List<EstateDto> getEstateInfoByRegisterNumbers(List<String> registerNumberList) throws SQLException;
}
