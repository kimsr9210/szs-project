package com.example.test.dto.repository;

import com.example.test.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository<Payment, String> {
    //SPRING JPA : 구현클래스를 작성할 필요없이 인터페이스 만으로 데이터베이스에 접근
    //JpaRepository<Entity.class, Entity 식별자 pk 타입>

    //스프링 데이터 JPA가 리포지토리(인터페이스)를 보고 스프링 빈을 자동으로 만들어서 객체를 (프로시라는 기술이 있음) 생성해서 스프링 빈을 올림
    //우리는 그걸 인젝션 해서 사용함
    //기본적인 메소드 CRUD는 JpaRepository여기에 다 있음

    //select m from Member m where m.name = ? jap가 이렇게 짜줌 이게 sql로 번역이 되서 실행됨

}
