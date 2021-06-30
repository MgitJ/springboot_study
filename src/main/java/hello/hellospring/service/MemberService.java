package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional // jpa를 쓸때 항상 transaction이 있어야함.
public class MemberService {

    private final MemberRepository memberRepository;

    // 직접 new 하지 않고 외부에서 MemberRepository 넣어주는 것을 DI라고 한다.
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입
     * @param member
     * @return
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 no
        // command(ctrl) + option(alt) + v: return을 자동으로 해준다.
        // Optional로 감싸면 그 안에 멤머객체가 있는 것이라, Optional에 여러 method가 있고 그것을 쓸 수 있다.
        // null의 가능성이 있으면 감싸서 반환해서 쓰는거지.
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    //ctrl+alt+shift+T ++ extract method  : 선택한거 함수로 만들어준다.
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                     .ifPresent(m->{
                             throw new IllegalStateException("이미 존재하는 회원입니다.");
                    });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memderId) {
        return memberRepository.findById(memderId);
    }
}
