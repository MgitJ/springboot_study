package hello.hellospring.service;

import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//직접 스프링 빈 등록하기
@Configuration
public class springConfig {

/*
    private DataSource dataSource;

    @Autowired
    public springConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }*/


   /* private EntityManager em;

    @Autowired
    public springConfig(EntityManager em) {
        this.em = em;
    }*/

    private final MemberRepository memberRepository;

    @Autowired
    public springConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean //bean을 직접 등록한다.
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

   /* @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
      //  return new JdbcMemberRepository(dataSource);
      //  return new JdbcTemplateMemberRepository(dataSource);
      //  return new JpaMemberRepository(em);
    }*/
}
