package hello.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration
@ComponentScan( //@Component 어노테이션 붙은 모든 클래스를 spring bean으로 등록해줌
		//basePackages = "hello.core", 
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
		//AppConfig 및 테스트를 위해 만든 모든 TestConfig 등 설정정보가 등록되므로 현재는 테스트를 위해 제외함
)
public class AutoAppConfig {
	
//	@Autowired
//	MemberRepository memberRepository;
//	@Autowired
//	DiscountPolicy discountPolicy;
	
//	@Bean
//	OrderService orderService() {
//		return new OrderServiceImpl(memberRepository, discountPolicy);
//	}
	
//	@Bean(name = "memoryMemberRepository")
//	MemberRepository mebmerRepository() {
//		return new MemoryMemberRepository();
//	} 
	

}
