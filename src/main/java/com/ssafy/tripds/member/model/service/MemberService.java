package com.ssafy.tripds.member.model.service;


import com.ssafy.tripds.member.model.dto.MemberDto;

import java.sql.SQLException;

public interface MemberService {
    int signup(MemberDto memberDto) throws Exception;
    MemberDto login(MemberDto memberDto) throws Exception;
    MemberDto userInfo(String email) throws Exception;
    int updateMember(MemberDto memberDto) throws Exception;
    void saveRefreshToken(String email, String refreshToken) throws Exception;
    Object getRefreshToken(String email) throws Exception;
    void deleRefreshToken(String userId) throws Exception;
}
