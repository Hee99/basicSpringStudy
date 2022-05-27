package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.AppConfig;

public class MemberApp {
	
	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
		
		//Spring 사용하도록 전환하기
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//AppConfig가 가지고있는 구성정보를 가지고 @Bean어노테이션이 붙은 객체들을 모두 spring bean에 등록하여 관리해줌
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		//getBean(메소드명, 반환타입)
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("findMember = " + findMember.getName());
	}

}
