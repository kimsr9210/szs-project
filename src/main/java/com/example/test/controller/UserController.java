package com.example.test.controller;

import com.example.test.dto.request.JoinRequest;
import com.example.test.dto.request.LoginRequest;
import com.example.test.dto.service.user.UserService;
import com.example.test.entity.UserInfo;
import com.example.test.jwt.util.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/szs")
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public String signup(@RequestBody JoinRequest joinRequest) {

        // loginId 중복 체크
        if (userService.checkUserIdDuplicate(joinRequest.getUserId())) {
            return "로그인 아이디가 중복됩니다.";
        }

        userService.join(joinRequest);
        return "회원가입이 완료되었습니다.";
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        // 로그인 시도
        UserInfo user = userService.login(loginRequest);

        // 정보가 없는 경우 응답
        if (user == null) {
            return "User 정보가 없음";
        }

        // 로그인 성공 > Jwt Token 발급
        long expireTimeMs = 1000 * 60 * 60;     // Jwt Token 유효시간 = 60분

        String jwtToken = JwtTokenUtil.createToken(user.getUserId(), expireTimeMs);
        return jwtToken;
    }

    // 회원정보 가져오기
    @GetMapping("/me")
    public String info(HttpServletRequest request) {

        String auth = request.getHeader("Authorization");
        // 토큰이 만료되었는지 체크
        if (JwtTokenUtil.isExpired(auth)) {
            return "만료된 토큰입니다.";
        };

        // 로그인 정보 가져오기
        String userId = JwtTokenUtil.getLoginId(auth);
        return userId;
    }

    // 스크랩
    @GetMapping("/scrap")
    public String userInfo(Authentication auth) {
        //계산에 필요한 결과값들을 DB에 저장도 해야함
        return "";
    }
}
