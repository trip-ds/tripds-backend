package com.ssafy.tripds.house.model.service;

import com.ssafy.tripds.house.model.dto.HouseDealDto;
import com.ssafy.tripds.house.model.dto.HouseDealShortSummaryDto;
import com.ssafy.tripds.house.model.dto.HouseDealSummaryDto;
import com.ssafy.tripds.house.model.dto.HouseSummaryDto;
import com.ssafy.tripds.house.model.mapper.HouseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseMapper houseMapper;

    @Override
    public List<HouseDealSummaryDto> getDealListSummary(String residenceType, Double topLat, Double leftLng, Double bottomLat, Double rightLng) {
        Map<String, Double> params = new HashMap<>();
        params.put("topLat", topLat);
        params.put("leftLng", leftLng);
        params.put("bottomLat", bottomLat);
        params.put("rightLng", rightLng);

        if (residenceType.equals("oneroom")) return houseMapper.findOneRoomDealListSummary(params);
        else if (residenceType.equals("officetel")) return houseMapper.findOfficetelDealListSummary(params);

        return null;
    }

    @Override
    public HouseSummaryDto getSummary(String roadName) {
        return houseMapper.findSummary(roadName);
    }

    @Override
    public HouseDealShortSummaryDto getDealSummary(String residenceType, String roadName) {
        if (residenceType.equals("oneroom")) return houseMapper.findOneRoomDealSummary(roadName);
        else if (residenceType.equals("officetel")) return houseMapper.findOfficetelDealSummary(roadName);

        return null;
    }

    @Override
    public HouseDealDto getDealList(String roadName) {
        return houseMapper.findDealList(roadName);
    }
}
