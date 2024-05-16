package com.ssafy.tripds.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String refreshToken;
}
