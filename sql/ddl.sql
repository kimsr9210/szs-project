--회원정보 테이블
CREATE TABLE USER (
                      USER_ID VARCHAR2(100) NOT NULL PRIMARY KEY, --아이디
                      NAME VARCHAR2(20) NOT NULL, --이름
                      REG_NO VARCHAR2(20) NOT NULL PRIMARY KEY, --주민번호
                      PASSWORD(100) NOT NULL, --비밀번호
);

--기업정보 테이블
CREATE TABLE COMPANY (
                         USER_ID VARCHAR2(100) NOT NULL PRIMARY KEY, --아이디
                         COMPANY VARCHAR2(100), --회사명
                         COMPANY_NUMBER VARCHAR2(20), --사업자번호
                         WORK_START DATE, --업무시작일
                         WORK_END DATE --업무종료일
);

--납입금액 테이블
CREATE TABLE PAYMENT (
                         USER_ID VARCHAR2(100) NOT NULL PRIMARY KEY, --아이디
                         CATEGORY VARCHAR(30), --소득구분
                         PAY NUMBER , --(총)급여
                         CALCULATE NUMBER, --산출세액
                         PREMIUM_PAY NUMBER,
                         MEDICAL_PAY NUMBER,
                         EDUCATION_PAY NUMBER,
                         ERP_PAY NUMBER,
                         DONATE_PAY NUMBER,
                         TOTAL_PAY NUMBER
);


--공제금액 테이블
CREATE TABLE RETURN_TAX(
                           USER_ID VARCHAR2(100) NOT NULL PRIMARY KEY, --아이디
                           WORK_TAX NUMBER,
                           NSPECIAL_TAX NUMBER,
                           NORM_TAX NUMBER,
                           ERP_TAX NUMBER,
                           RESULT_TAX NUMBER,
                           PREMIUM_TAX NUMBER,
                           MEDICAL_TAX NUMBER,
                           EDUCATION_TAX NUMBER,
                           DONATE_TAX NUMBER,
                           SPECIAL_TAX NUMBER,
                           SPECIAL_SUM NUMBER,
                           RECEIVE_DATE DATE --지급일
);

/*
[회원정보]
회원아이디 USER_ID
이름 NAME
비밀번호 PASSWORD
주민번호 REG_NO

[기업정보] COMPANY_INFORMATION
회원아이디 USER_ID
기업명 COMPANY
사업자번호 COMPANY_NUMBER
업무시작일 WORK_START
업무종료일 WORK_END
--------------------------------------

[납입금액 테이블] PAYMENT
회원아이디 USER_ID
소득구분 CATEGORY
(총)급여 PAY
산출세액 CALCULATE
보험료납입금액 PREMIUM_PAY
의료비납입금액  MEDICAL_PAY
교육비납입금액 EDUCATION_PAY
퇴직연금납입금액 ERP_PAY
기부금납입금액 DONATE_PAY
총납임금액(?) TOTAL_PAY

---------------------------------------------

[공제금액 테이블] RETURN_TAX
회원아이디 USER_ID
근로소득세액공제금액 WORK_TAX
특별세액공제금액 SPECIAL_TAX
표준세액공제금액 NORM_TAX
퇴직연금세액공제금액 ERP_TAX
결정세액 RESULT_TAX
보험료공제금액 PREMIUM_TAX
의료비공제금액 MEDICAL_TAX
교육비공제금액 EDUCATION_TAX
기부금공제금 DONATE_TAX
특별세액공제급액합 SPECIAL_SUM
지급일 RECEIVE_DATE
*/