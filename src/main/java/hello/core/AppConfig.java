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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 스프링 빈을 생성해서 의존 관계를 주입하는 단계가 나누어져 있다
 */

@Configuration // 애플리케이션 구성정보를 담당
public class AppConfig {

    @Bean(name = "memberService")      // Spring 컨테이너에 등록 된다
    public MemberService memberService(){                  // 빈이름 : memberService
        return new MemberServiceImpl(memberRepository());  // 빈객체 : MemberServiceImpl
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository() ,discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        // return new FixDisCountPolicy();
        return new RateDiscountPolicy();
    }
}
