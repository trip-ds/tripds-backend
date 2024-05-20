package com.ssafy.tripds.cctv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateDto {
    private double latitude;
    private double longitude;
    private double distance;
}