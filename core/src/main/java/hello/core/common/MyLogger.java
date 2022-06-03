package hello.core.common;


import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request") //request bean으로 설정 : HTTP요청 당 하나씩 생성되고 HTTP요청 끝날 때 소멸
public class MyLogger {
	
	private String uuid;
	private String requestURL;

	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
	
	public void log(String message) {
		System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
	}

	@PostConstruct
	public void init() {
		uuid = UUID.randomUUID().toString();
		System.out.println("[" + uuid + "] request scope bean create:" + this);
	}
	
	@PreDestroy
	public void close() {
		System.out.println("[" + uuid + "] request scope bean close:" + this);
	}
	
}
