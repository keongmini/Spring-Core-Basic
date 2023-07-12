package Hello.core;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import Hello.core.order.Order;
import Hello.core.order.OrderService;
import Hello.core.order.OrderSeviceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderSeviceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "mamerA", Grade.VIP);
        memberService.join(member); // 메모리 객체에 저장

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
