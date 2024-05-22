package com.ssafy.tripds.house.model.mapper;

import com.ssafy.tripds.house.model.dto.HouseDealDto;
import com.ssafy.tripds.house.model.dto.HouseDealShortSummaryDto;
import com.ssafy.tripds.house.model.dto.HouseDealSummaryDto;
import com.ssafy.tripds.house.model.dto.HouseSummaryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HouseMapper {
    List<HouseDealSummaryDto> findOneRoomDealListSummary(Map params);
    List<HouseDealSummaryDto> findOfficetelDealListSummary(Map params);
    HouseDealShortSummaryDto findOneRoomDealSummary(String roadName);
    HouseDealShortSummaryDto findOfficetelDealSummary(String roadName);
    HouseDealDto findDealList(String roadName);
    HouseSummaryDto findSummary(String roadName);
}
