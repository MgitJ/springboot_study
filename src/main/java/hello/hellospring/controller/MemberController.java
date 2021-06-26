package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

   /* private final MemberService memberService = new MemberService();
   *  new하면 여러 controller들이 memberService를 가져다 쓰며 여러개를 쓰게됨. 그럴필요없이
   * 공유하자!
   * */

    private final MemberService memberService;

    @Autowired //memberService를 스프링이 스프링컨테이너에 있는 memberService 를 가져다가 연결시켜줌.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
