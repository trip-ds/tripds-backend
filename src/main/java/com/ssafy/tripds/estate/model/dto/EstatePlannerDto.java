package com.ssafy.tripds.estate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstatePlannerDto {
    private Long id;
    private String registerNumber;
    private Long memberId;
}
