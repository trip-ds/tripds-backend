package com.ssafy.tripds.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private Integer age;
    private String address;
    private Date createdAt;
    private String refreshToken;
}
