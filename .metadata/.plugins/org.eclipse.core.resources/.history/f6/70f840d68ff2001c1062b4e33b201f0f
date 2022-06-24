package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main03 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appContext.xml");
		
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		Greeter g3 = ctx.getBean("greeter1", Greeter.class);
		
		// 주소 비교
		System.out.println("(g1 == g2) : " + (g1==g2));
		System.out.println("(g2 == g3) : " + (g2==g3));
		
		ctx.close();
	}

}
