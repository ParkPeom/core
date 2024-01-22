package hello.core.order;


import hello.core.discount.DiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDisCountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService{

     private final MemberRepository memberRepository;
     private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 관심사 분리가 필요하다
    //private DiscountPolicy discountPolicy = new FixDisCountPolicy(); // 인터페이스에만 의존 하도록 한다 DIP 를 지킴

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원정보 조회
        // 단일책임원칙
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 정책 조회

        return new Order(memberId , itemName , itemPrice , discountPrice); // 최종 생성된 주문 반환
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
