package com.example.test.dto.service.user;

import com.example.test.dto.request.JoinRequest;
import com.example.test.dto.request.LoginRequest;
import com.example.test.entity.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean checkUserIdDuplicate(String userId);

    void join(JoinRequest req);

    UserInfo login(LoginRequest req);

    UserInfo getLoginUserByUserId(String userId);
}
