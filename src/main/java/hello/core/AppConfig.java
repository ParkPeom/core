package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDisCountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 애플리케이션의 실제 동작에 필요한 구현 객체를 만든다
// 객체의 생성 과 연결은 AppConfig 가 담당한다. DIP 완성
public class AppConfig { // IOC 컨테이너

    // 생성자 주입 = 인젝션
    public MemberService memberService(){
        // 생성자를 통해서 메모리멤버리포지토리를 생성한다.
        return new MemberServiceImpl(MemberRepository());
    }

    // ctrl + alt + m
    // 역할 과 구현 클래스를 확실히 나누었다.
    private MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    // 생성자 주입 = 인젝션 -> 디펜덴시 -> 의존관계주입
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository() , new FixDisCountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        // return new FixDisCountPolicy();
        return new RateDiscountPolicy();
    }
}
