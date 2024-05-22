package com.ssafy.tripds.house.model.dto;

import org.apache.ibatis.type.Alias;

@Alias("reviewSummaryType")
public record ReviewSummaryDto(
//        String roadName,
        Double avgRating,
        Double avgTransportRating,
        Double avgComplexRating,
        Double avgFacilityRating
) {
}
