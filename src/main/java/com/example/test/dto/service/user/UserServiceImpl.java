package com.example.test.dto.service.user;

import com.example.test.dto.repository.UserRepository;
import com.example.test.dto.request.JoinRequest;
import com.example.test.dto.request.LoginRequest;
import com.example.test.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    // Spring Security를 사용한 로그인 구현 시 사용
//    private final BCryptPasswordEncoder encoder;

    /**
     * userId 중복 체크
     * 회원가입 기능 구현 시 사용
     * 중복되면 true return
     */
    @Override
    public boolean checkUserIdDuplicate(String userId) {
        return userRepository.existsByUserId(userId);
    }

    /**
     * 회원가입 기능 2
     * 화면에서 JoinRequest(userId, password, nickname)을 입력받아 User로 변환 후 저장
     * 회원가입 1과는 달리 비밀번호를 암호화해서 저장
     * userId, nickname 중복 체크는 Controller에서 진행 => 에러 메세지 출력을 위해
     */
    @Override
    public void join(JoinRequest req) {
        log.info("join : {}", req);

        HashMap<String, String> memberJoin = new HashMap<>();
        memberJoin.put("홍길동", "860824-1655068");
        memberJoin.put("김둘리", "921108-1582816");
        memberJoin.put("마징가", "880601-2455116");
        memberJoin.put("베지터", "910411-1656116");
        memberJoin.put("손오공", "820326-2715702");

        if (memberJoin.containsKey(req.getName()) && memberJoin.containsKey(req.getRegNo())) { //이름과 주민번호가 일치하면 회원가입
            userRepository.save(req.toEntity(passwordEncoder.encode(req.getPassword())));
        } else {
            //리턴 => 회원가입 불가 메세지 발생
        }
    }

    /**
     * 로그인 기능
     * 화면에서 LoginRequest(userId, password)을 입력받아 userId와 password가 일치하면 User return
     * userId가 존재하지 않거나 password가 일치하지 않으면 null return
     */
    @Override
    public UserInfo login(LoginRequest req) {
        //Optional : null로 반환되는 대신 Optional로 감싸서 반환되는 방식을 선호
        Optional<UserInfo> optionalUser = userRepository.findByUserId(req.getUserId());

        // userId와 일치하는 User가 없으면 null return
        if (optionalUser.isEmpty()) {
            return null;
        }

        UserInfo user = optionalUser.get();
        // 찾아온 User의 password와 입력된 password가 다르면 null return
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            return null;
        }

        return user;
    }

    /**
     * userId(String)를 입력받아 User을 return 해주는 기능
     * 인증, 인가 시 사용
     * userId가 null이거나(로그인 X) userId로 찾아온 User가 없으면 null return
     * userId로 찾아온 User가 존재하면 UserInfo return
     */
    @Override
    public UserInfo getLoginUserByUserId(String userId) {
        if (userId == null) return null;

        Optional<UserInfo> optionalUser = userRepository.findByUserId(userId);
        if (optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }
}
