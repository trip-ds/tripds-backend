package com.ssafy.tripds.streetlight.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StreetlightSearchDto {
    private Double swLat;
    private Double swLng;
    private Double neLat;
    private Double neLng;
}