package Hello.core;


import Hello.core.discount.DiscountPolicy;
import Hello.core.discount.FixDiscountPolicy;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import Hello.core.member.MemoryMemberRepository;
import Hello.core.order.OrderService;
import Hello.core.order.OrderSeviceImpl;

// 애플리케이션 전체를 설정하고 구성한다. 생성자를 통해 어떤 구현 객체를 주입할지 결정하는 곳 - 다른 곳은 실행에만 집중
public class AppConfig {

    // 메서드명을 통해 역할 보여주기

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());     // 생성자 주입
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderSeviceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }



}
