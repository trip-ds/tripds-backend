package com.ssafy.tripds.member.model.service;

import com.ssafy.tripds.member.model.dto.MemberDto;
import com.ssafy.tripds.member.model.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public int signup(MemberDto memberDto) throws Exception {
        return memberMapper.signup(memberDto);
    }

    @Override
    public MemberDto login(MemberDto memberDto) throws Exception {
        return memberMapper.login(memberDto);
    }

    @Override
    public MemberDto userInfo(String email) throws Exception {
        return memberMapper.userInfo(email);
    }

    @Override
    public void saveRefreshToken(String email, String refreshToken) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", email);
        map.put("token", refreshToken);
        memberMapper.saveRefreshToken(map);
    }

    @Override
    public Object getRefreshToken(String email) throws Exception {
        return memberMapper.getRefreshToken(email);
    }

    @Override
    public void deleRefreshToken(String email) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", email);
        map.put("token", null);
        memberMapper.deleteRefreshToken(map);
    }
}
