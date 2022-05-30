package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.MemberService;
import hello.core.order.AppConfig;

public class SingletonTest {
	
	@Test
	@DisplayName("스프링 없는 순수한 DI 컨테이너")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		//1. 조회 :호출할 때마다 객체 생성
		MemberService memberService1 = appConfig.memberService();
		MemberService memberService2 = appConfig.memberService();
		
		Assertions.assertThat(memberService1).isNotSameAs(memberService2);
		
	}

}
