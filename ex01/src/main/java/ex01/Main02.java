package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main02 {

	public static void main(String[] args) {
		// 스프링으로 자바 객체 제어하기
		
		// 1. 스프링 설정 파일 읽어오기
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appContext.xml");
		
		// 2. 스프링이 만든 객체 읽어오기
		Greeter g = ctx.getBean("greeter", Greeter.class);
		
		// 3. 가져온 객체 이용하기
		String msg = g.greet("스프링");
		
		System.out.println(msg);
		
		ctx.close();
	}

}
