package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

	//private final MemberRepository memberRepository = new MemoryMemberRepository();
	//private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	//private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	/*
	 * 문제 : 
	 * OrderServiceImpl은 discountPolicy 인터페이스에 의존하고 있다.
	 * 그런데 구체 클래스에도 함께 의존하고 있음
	 * => DIP 위만
	 * => 구체 클래스 변경 시(정책 변경 시) 클라이언트인 OrderServiceImpl의 소스코드도 변경해야함
	 * => OCP 위반  
	 * 
	 * 해결 : 추상(인터페이스)에만 의존하도록 변경
	*/

	private MemberRepository memberRepository;
	private DiscountPolicy discountPolicy;
	
	/*
	 * 문제 : 구현체가 없어 코드 실행불가 -> null pointer exception 발생
	 * 
	 * 해결 : 앱 구동방식 구성하는 Config 객체가 구현체 선택할 수 있도록 매개변수 있는 생성자 사용
	*/

	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		
		//단일책임원칙 잘 지켜짐 - 할인금액 계산하는 기능 분리되어있음
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		//최종 생성된 주문 객체 반환
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}



}
