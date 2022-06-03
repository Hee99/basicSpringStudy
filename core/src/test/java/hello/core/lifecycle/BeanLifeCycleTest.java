package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
	
	@Test
	public void lifeCycleTest() {
		//close가능한 ApplicationContext의 하위 클래스 사용
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCyCleConfig.class);
		NetworkClient client = ac.getBean(NetworkClient.class);
		ac.close();
	}
	
	@Configuration
	static class LifeCyCleConfig {
//		@Bean(initMethod = "init", destroyMethod = "close")
		@Bean
		public NetworkClient networkClient() {
			NetworkClient networkClient = new NetworkClient();
			networkClient.setUrl("http://hello-spring.dev");
			return networkClient;
		}
	}

}
