package com.example.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Company {
    @Id
    private String UserId;
    private String company; //회사명
    private String companyNumber; //사업자번호
    private String workStart; //업무시작일
    private String workEnd; //업무종료일
}
