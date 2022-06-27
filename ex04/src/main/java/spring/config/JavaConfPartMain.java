package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.dao.MemberDao;
import spring.service.MemberRegisterService;

@Configuration
@Import(JavaConfPartSub.class)
//@Import({JavaConf01.class, JavaConf02.class, JavaConf03.class, ....}) 3개 이상의 설정 파일을 합쳐서 배열형태로 입력
public class JavaConfPartMain {

	@Bean	
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
}
