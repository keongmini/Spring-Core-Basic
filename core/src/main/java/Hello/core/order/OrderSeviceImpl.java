package Hello.core.order;

import Hello.core.discount.DiscountPolicy;
//import Hello.core.discount.FixDiscountPolicy;
//import Hello.core.discount.RateDiscountPolicy;
import Hello.core.member.Member;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemoryMemberRepository;

public class OrderSeviceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();        문제점: 추상과 구체 모두에 의존 -> DIP 위반
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();       문제점: fix -> rate 로 변경하는 순간 클라이언트 코드도 변경해야 함 - OCP 위반
    private DiscountPolicy discountPolicy;      // 해결: 인터페이스에만 의존하도록 변경 (final은 무조건 값이 할당되어야 하기 때문에 제거)

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
