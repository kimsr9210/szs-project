package com.example.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
@Entity
@Getter
@Setter
public class ReturnTax {
    @Id
    private String userId;
    private int workTax;	//근로소득세액공제금액
    private int specialTax;	//특별세액공제금액
    private int normTax;	//표준세액공제금액
    private int erpTax;		//퇴직연금세액공제금액
    private int resultTax;	//결정세액
    private int premiumTax;	//보험료공제금액
    private int medicalTax;	//의료비공제금액
    private int edutationTax;//교육비공제금액
    private int donateTax;	//기부금공제금
    private int specialSum;	//특별세액공제급액합
    private String receiveDate; //지급일

}
