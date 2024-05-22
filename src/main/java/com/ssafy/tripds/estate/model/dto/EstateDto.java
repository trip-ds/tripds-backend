package com.ssafy.tripds.estate.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EstateDto {
    private String registerNumber;
    private String name;
    private String roadName;
    private Short bonBun;
    private Short buBun;
    private String dongName;
    private String complexName;
    private String phone;
    private LocalDate registerDate;
    private String representativeName;
    private String xCoordinate;
    private String yCoordinate;
}
