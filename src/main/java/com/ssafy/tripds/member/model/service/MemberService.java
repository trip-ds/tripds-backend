package com.ssafy.tripds.member.model.service;


import com.ssafy.tripds.member.model.dto.MemberDto;

public interface MemberService {
    MemberDto login(MemberDto memberDto) throws Exception;
    MemberDto userInfo(String email) throws Exception;
    void saveRefreshToken(String email, String refreshToken) throws Exception;
    Object getRefreshToken(String email) throws Exception;
    void deleRefreshToken(String userId) throws Exception;
}
