package com.ssafy.tripds.member.model.service;


import com.ssafy.tripds.member.model.dto.MemberDto;

import java.sql.SQLException;
import java.util.Map;

public interface MemberService {
    int signup(MemberDto memberDto);
    Map<String, Object> login(MemberDto memberDto);
    MemberDto userInfo(String email);
    int updateMember(MemberDto memberDto);
    void saveRefreshToken(String email, String refreshToken) throws Exception;
    Object getRefreshToken(String email) throws Exception;
    void deleRefreshToken(String userId) throws Exception;
}
