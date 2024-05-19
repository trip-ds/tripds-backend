package com.ssafy.tripds.member.controller;

import com.ssafy.tripds.member.model.dto.MemberDto;
import com.ssafy.tripds.member.model.service.MemberService;
import com.ssafy.tripds.util.JWTUtil;
import io.swagger.v3.oas.annotations.Hidden;
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

    @GetMapping("/logout/{email}")
    @Hidden
    public ResponseEntity<?> removeToken(@PathVariable ("email") @Parameter(description = "로그아웃 할 회원의 아이디.", required = true) String email) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            memberService.deleRefreshToken(email);
            status = HttpStatus.OK;
        } catch (Exception e) {
            log.error("로그아웃 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
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

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deleteUser(
            @PathVariable("email") @Parameter(description = "인증할 회원의 아이디.", required = true) String email) {

        int updateMember = memberService.deleteMember(email);

        return new ResponseEntity<>(updateMember, HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody MemberDto memberDto, HttpServletRequest request)
            throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        String token = request.getHeader("refreshToken");
        log.debug("token : {}, memberDto : {}", token, memberDto);
        if (jwtUtil.checkToken(token)) {
            if (token.equals(memberService.getRefreshToken(memberDto.getEmail()))) {
                String accessToken = jwtUtil.createAccessToken(memberDto.getEmail());
                log.debug("token : {}", accessToken);
                log.debug("정상적으로 access token 재발급!!!");
                resultMap.put("access-token", accessToken);
                status = HttpStatus.CREATED;
            }
        } else {
            log.debug("refresh token 도 사용 불가!!!!!!!");
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
