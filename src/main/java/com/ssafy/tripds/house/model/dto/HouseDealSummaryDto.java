package com.ssafy.tripds.house.model.dto;

import org.apache.ibatis.type.Alias;

@Alias("houseDealSummaryType")
public record HouseDealSummaryDto(
        String name,
        String roadName,
        Double xCoordinate,
        Double yCoordinate,
        Double avgNetArea,
        String contractType,
        Double avgMonthlyRent,
        Double avgDeposit,
        Double avgPrice,
        Integer cnt) {
}
