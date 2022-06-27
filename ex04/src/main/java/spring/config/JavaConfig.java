package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;
import spring.service.MemberRegisterService;

@Configuration		// 스프링 설정 파일이다.
public class JavaConfig {
	
	// <bean id="memberDao" class="spring.dao.MemberDao"></bean>
	
	// 자바 설정은 빈을 메서드로 등록
	@Bean	// 스프링 컨테이너에 빈을 등록
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	// <bean id="memberRegSvc" class="spring.service.MemberRegisterService"></bean>
	@Bean
	public MemberRegisterService memberRegSvc() {		// 생성자로 의존주입 받았던 경우
		return new MemberRegisterService(memberDao());	// Dao 객체 주입
	}
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {		// setter로 의존 주입 받았던 경우
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setDao(memberDao());	// 수동 주입
//		infoPrinter.setPrinter(printer());	// 자동 주입
		
		return infoPrinter;
	}
}
