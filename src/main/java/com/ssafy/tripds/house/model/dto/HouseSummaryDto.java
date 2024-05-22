package com.ssafy.tripds.house.model.dto;

import org.apache.ibatis.type.Alias;

@Alias("houseSummaryType")
public record HouseSummaryDto(
        String roadName,
        Integer buildYear,
        Double height,
        Integer households,
        Double buildingArea,
        Double floorArea,
        Double siteArea,
        Integer floorsMin,
        Integer floorsMax,
        Integer passengerElevatorCnt
) {
}
