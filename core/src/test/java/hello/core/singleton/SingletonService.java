package hello.core.singleton;

public class SingletonService {
	
	private static final SingletonService instance = new SingletonService();
	
	//static영역에 선언된 자기자신의 인스턴스를 리턴하는 메소드 생성함 
	public static SingletonService getInstance() {
		return instance;
	}
	
	//생성자 사용하지 못하도록 private으로 설정
	private SingletonService() {
		
	};
	
	public void logic() {
		System.out.println("싱글톤 객체 로직 호출");
	}

}
