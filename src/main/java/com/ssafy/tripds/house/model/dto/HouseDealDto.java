package com.ssafy.tripds.house.model.dto;

import org.apache.ibatis.type.Alias;

@Alias("houseDealType")
public record HouseDealDto(
//        String roadName,
        String contractType,
        String name,
        String contractDate,
        Double monthlyRent,
        Double deposit,
        Double price,
        Integer floor,
        Double netArea
) {
}
