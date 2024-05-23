package com.ssafy.tripds.house.model.dto;

import org.apache.ibatis.type.Alias;

@Alias("reviewFormType")
public record ReviewWriteDto(
    String authorEmail,
    String residencePeriodStart,
    String residencePeriodEnd,
    String transportRating,
    String complexRating,
    String facilityRating,
    String content,
    String roadName
) {
}
