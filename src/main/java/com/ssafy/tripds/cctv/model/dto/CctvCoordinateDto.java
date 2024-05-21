package com.ssafy.tripds.cctv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CctvCoordinateDto {
    private double latitude;
    private double longitude;
    private double distance;
}