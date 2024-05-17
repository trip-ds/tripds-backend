package com.ssafy.tripds.member.controller;

import com.ssafy.tripds.member.model.dto.MemberDto;
import com.ssafy.tripds.member.model.service.MemberService;
import com.ssafy.tripds.util.JWTUtil;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final JWTUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(MemberDto memberDto){
        log.debug("sign up user = {}", memberDto);

        int result = memberService.signup(memberDto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody @Parameter(description = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) MemberDto memberDto) {
        log.debug("login user : {}", memberDto);
        Map<String, Object> login = memberService.login(memberDto);
        HttpStatus status = (HttpStatus) login.get("status");

        return new ResponseEntity<>(login, status);
    }

    @GetMapping("/info/{email}")
    public ResponseEntity<?> getInfo(
            @PathVariable("email") @Parameter(description = "인증할 회원의 아이디.", required = true) String email) {

        MemberDto memberDto = memberService.userInfo(email);

        return new ResponseEntity<>(memberDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(
            @RequestBody @Parameter(description = "수정할 회원 정보", required = true) MemberDto memberDto) {

        int updateMember = memberService.updateMember(memberDto);

        return new ResponseEntity<>(updateMember, HttpStatus.OK);
    }
}
