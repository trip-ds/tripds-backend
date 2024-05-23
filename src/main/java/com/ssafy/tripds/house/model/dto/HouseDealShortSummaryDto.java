package com.ssafy.tripds.house.model.dto;

import org.apache.ibatis.type.Alias;

@Alias("houseDealSummaryShortType")
public record HouseDealShortSummaryDto(
        String roadName,
        Double minPrice,
        Double maxPrice,
        Double minDeposit,
        Double maxDeposit,
        Double minNetArea,
        Double maxNetArea
) {
}
