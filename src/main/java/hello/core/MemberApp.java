package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        // 의존성 주입
        MemberService memberService = appConfig.memberService(); //MemberServiceImpl() 를 주게 된다.

        //MemberService memberService = new MemberServiceImpl();
        // CTRL + ALT + V
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); // 아이디 1 Long 타입 가입

        Member findMember = memberService.findMember(1L);

        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}
