package com.ssafy.tripds.member.model.service;


import com.ssafy.tripds.member.model.dto.MemberDto;

public interface MemberService {
    MemberDto login(MemberDto memberDto) throws Exception;
}
