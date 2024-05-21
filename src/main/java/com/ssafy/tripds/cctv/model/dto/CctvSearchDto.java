package com.ssafy.tripds.cctv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CctvSearchDto {
    private double swLat;
    private double swLng;
    private double neLat;
    private double neLng;
}
