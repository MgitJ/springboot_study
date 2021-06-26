package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원이 repository에 저장
    Optional<Member> findById(Long id); //저장소에서 찾아올 수 있는
    Optional<Member> findByName(String name);
    List<Member> findAll(); //모든 회원 리스트 반환
}
