package com.ssafy.tripds.house.model.service;

import com.ssafy.tripds.house.model.dto.HouseDealDto;
import com.ssafy.tripds.house.model.dto.HouseDealShortSummaryDto;
import com.ssafy.tripds.house.model.dto.HouseDealSummaryDto;
import com.ssafy.tripds.house.model.dto.HouseSummaryDto;
import com.ssafy.tripds.house.model.dto.ReviewSummaryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseService {
    List<HouseDealSummaryDto> getDealListSummary(String residenceType, Double topLat, Double leftLng, Double bottomLat, Double rightLng);

    HouseSummaryDto getSummary(String roadName);

    HouseDealShortSummaryDto getDealSummary(String residenceType, String roadName);

    HouseDealDto getDealList(String roadName);

    ReviewSummaryDto getReviewSummary(String roadName);
}
