package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDisCountPolicy implements  DiscountPolicy {

    private int disCountFixAcount = 1000; // 100원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return disCountFixAcount;
        } else {
            return 0;
        }
    }
}
