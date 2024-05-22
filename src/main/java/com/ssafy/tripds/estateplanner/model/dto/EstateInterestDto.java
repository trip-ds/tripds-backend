package com.ssafy.tripds.estateplanner.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstateInterestDto {
    private Long id;
    private String registerNumber;
    private Long memberId;
}
