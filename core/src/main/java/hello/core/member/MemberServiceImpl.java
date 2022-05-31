package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

	//private final MemberRepository memberRepository = new MemoryMemberRepository();
	private MemberRepository memberRepository;

	//의존관계 자동주입하는 어노테이션(스프링 빈에서 memberRepository 찾아와 등록해줌)
	//ac.getBean(MemberRepository.class)코드와 유사하게 작동
	@Autowired
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
	
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
