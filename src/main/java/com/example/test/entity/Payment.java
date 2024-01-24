package com.example.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
@Entity
@Getter
@Setter
public class Payment {
    @Id
    private String userId;    //회원아이디
    private String category; //소득구분
    private int pay;         //(총)급여
    private int calculate;   //산출세액
    private int preminmPay;  //보험료납입금액
    private int medicalPay;  //의료비납입금액
    private int educationPay;//교육비납입금액
    private int erpPay;      //퇴직연금납입금
    private int donatePay;   //기부금납입금액
    private int totalPay;    //총납임금액
}
