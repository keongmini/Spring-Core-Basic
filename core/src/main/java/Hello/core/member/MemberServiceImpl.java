package Hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository;        // 추상화에만 의존 - DIP
    // 의존관계를 외부에서 주입 - Dependency Injection 의존성 주입

    @Autowired          // 자동 의존관계 주입 ac.getBean(MemberRepository.class) 같은 역할
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
