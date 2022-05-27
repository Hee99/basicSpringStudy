package hello.core.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

//구성정보 작성하는 클래스에 지정하는 어노테이션
@Configuration
public class AppConfig {

	//spring컨테이너에 등록하는 어노테이션
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
		//return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
}
