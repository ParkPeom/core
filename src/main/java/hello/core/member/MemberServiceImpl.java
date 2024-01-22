package hello.core.member;

public class MemberServiceImpl implements  MemberService {

    // MemberServiceImpl를 모르고 메모리멤버리포지토리가 할당된다.
    // 이제 dip 를 지키며 추상화에만 의존하게 된다.
    // 생성자를 통해서 생성 = 생성자 주입
    private final MemberRepository memberRepository;


    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
