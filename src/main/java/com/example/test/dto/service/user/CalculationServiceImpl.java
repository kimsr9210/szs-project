package com.example.test.dto.service.user;

import com.example.test.dto.repository.CalculationRepository;
import com.example.test.entity.Payment;
import com.example.test.entity.ReturnTax;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService{
    //private final CalculationRepository calculationRepository;
    
    //계산에 필요한 값저장
    @Override
    public void save(Payment payment) {
        
        //임시 데이터
        payment.setCalculate(600000);
        payment.setPreminmPay(100000);
        payment.setMedicalPay(700000);
        payment.setEducationPay(200000);
        payment.setErpPay(1333333);
        payment.setDonatePay(15000);
    }

    //계산식
    @Override
    public void result(ReturnTax returnTax) {

    }
}
