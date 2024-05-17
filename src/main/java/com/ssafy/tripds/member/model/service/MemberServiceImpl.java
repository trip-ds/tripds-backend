package com.ssafy.tripds.member.model.service;

import com.ssafy.tripds.member.model.dto.MemberDto;
import com.ssafy.tripds.member.model.mapper.MemberMapper;
import com.ssafy.tripds.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService{

    private final JWTUtil jwtUtil;
    private final MemberMapper memberMapper;

    @Transactional
    @Override
    public int signup(MemberDto memberDto) {
        try {
            // email 중복 체크
            MemberDto existingMember = userInfo(memberDto.getEmail());

            // 중복되면 예외 발생
            if (existingMember != null) {
                throw new IllegalStateException("이미 가입된 이메일입니다.");
            }

            return memberMapper.signup(memberDto);
        } catch (Exception e) {
            log.error("회원 가입 실패 : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Map<String, Object> login(MemberDto memberDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        HttpStatus status;

        try {
            MemberDto loginUser = memberMapper.login(memberDto);
            if (loginUser != null) {
                String accessToken = jwtUtil.createAccessToken(loginUser.getEmail());
                String refreshToken = jwtUtil.createRefreshToken(loginUser.getEmail());
                saveRefreshToken(loginUser.getEmail(), refreshToken);

                resultMap.put("access-token", accessToken);
                resultMap.put("refresh-token", refreshToken);

                status = HttpStatus.CREATED;
            } else {
                resultMap.put("message", "아이디 또는 패스워드를 확인해 주세요.");
                status = HttpStatus.UNAUTHORIZED;
            }
        } catch (Exception e) {
            log.debug("로그인 에러 발생 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        resultMap.put("status", status);
        return resultMap;
    }

    @Transactional
    @Override
    public MemberDto userInfo(String email) {
        try {
            return memberMapper.userInfo(email);
        } catch (Exception e) {
            log.error("정보조회 실패 : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateMember(MemberDto memberDto) {
        try {
            return memberMapper.updateMember(memberDto);
        } catch (Exception e) {
            log.error("회원 정보 수정 실패 : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public int deleteMember(String email) {
        try {
            return memberMapper.deleteMember(email);
        } catch (SQLException e) {
            log.error("회원 정보 삭제 실패 : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public void saveRefreshToken(String email, String refreshToken) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", email);
        map.put("token", refreshToken);
        memberMapper.saveRefreshToken(map);
    }

    @Transactional
    @Override
    public Object getRefreshToken(String email) throws Exception {
        return memberMapper.getRefreshToken(email);
    }

    @Transactional
    @Override
    public void deleRefreshToken(String email) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", email);
        map.put("token", null);
        memberMapper.deleteRefreshToken(map);
    }
}
