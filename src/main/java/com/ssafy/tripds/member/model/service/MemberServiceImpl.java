package com.ssafy.tripds.member.model.service;

import com.ssafy.tripds.member.model.dto.MemberDto;
import com.ssafy.tripds.member.model.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public MemberDto login(MemberDto memberDto) throws Exception {
        return memberMapper.login(memberDto);
    }
}
