package com.example.test.dto.service.user;

import com.example.test.dto.request.JoinRequest;
import com.example.test.dto.request.LoginRequest;
import com.example.test.entity.Payment;
import com.example.test.entity.ReturnTax;
import com.example.test.entity.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface CalculationService {

    //계산에 필요한 결과값 저장
    void save(Payment payment);

    //계산식
    void result(ReturnTax returnTax);
}
