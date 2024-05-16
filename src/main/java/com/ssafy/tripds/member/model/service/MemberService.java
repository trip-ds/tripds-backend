package com.ssafy.tripds.member.model.service;


import com.ssafy.tripds.member.model.dto.MemberDto;

public interface MemberService {
    MemberDto login(MemberDto memberDto) throws Exception;
    void saveRefreshToken(String userId, String refreshToken) throws Exception;
    Object getRefreshToken(String userId) throws Exception;
    void deleRefreshToken(String userId) throws Exception;
}
