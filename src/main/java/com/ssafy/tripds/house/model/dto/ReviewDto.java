package com.ssafy.tripds.house.model.dto;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("reviewType")
public record ReviewDto(
//        String roadName,
        String ageCategory,
        String authorEmailId,
        String residencePeriod,
        String transportRating,
        String complexRating,
        String facilityRating,
        String content,
        String createDate
) {
}
