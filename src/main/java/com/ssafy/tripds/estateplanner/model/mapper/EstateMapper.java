package com.ssafy.tripds.estateplanner.model.mapper;

import com.ssafy.tripds.estateplanner.model.dto.EstateInterestDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface EstateMapper {
    int insertEstateInterest(EstateInterestDto estateInterestDto) throws SQLException;

}
