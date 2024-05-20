package com.ssafy.tripds.streetlight.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoordinateDto {
    private double longitude; // 경도
    private double latitude; // 위도
    private long radius; // 변경
}
