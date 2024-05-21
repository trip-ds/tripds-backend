package com.ssafy.tripds.cctv.model.dto;

import lombok.Data;

@Data
public class CctvDto {
    private Long id;
    private String district;
    private String address;
    private Double latitude;
    private Double longitude;
    private Integer cctvCount;
}
