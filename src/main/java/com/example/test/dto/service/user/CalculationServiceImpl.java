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

    }

    //계산식
    @Override
    public void result(ReturnTax returnTax) {

    }
}
