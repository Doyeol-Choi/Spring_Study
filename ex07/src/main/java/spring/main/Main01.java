package spring.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberListPrinter;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main01 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx01.xml");
		
		// SELECTALL
		MemberListPrinter listPrt = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrt.printAll();
		
		System.out.println("-----------------------------------------------------------");
		
		// SelectByEmail
		MemberInfoPrinter infoPrt = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrt.printMemberInfo("park@naver.com");
		
		// InsertMember
		MemberRegisterService regSvc = ctx.getBean("regSvc", MemberRegisterService.class);
		String delEmail = insert(regSvc);
		
		// Dao
		MemberDao dao = ctx.getBean("dao", MemberDao.class);
		
		// UpdateMember
		String email = "park@naver.com";
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		update(changePwdSvc, email, dao);
		
		// Insert / Update가 잘 되는지 확인
		listPrt.printAll();
		
		// DeleteMember
		dao.deleteMember(delEmail);
	}

	private static void update(ChangePasswordService changePwdSvc, String email, MemberDao dao) {
		String oldPwd = dao.selectByEmail(email).getPassword();	//	이메일로 기존 비밀번호 알아오기
		String newPwd = "";
		
		if(oldPwd.equals("1234")) {
			newPwd = "4321";
		} else if (oldPwd.equals("4321")) {
			newPwd = "1234";
		}
		
		changePwdSvc.changePassword(email, oldPwd, newPwd);
	}

	private static String insert(MemberRegisterService regSvc) {
		RegisterRequest rr = new RegisterRequest();
		
		// 매번 달라지는 이름과 이메일을 저장하기
		SimpleDateFormat dateFmt = new SimpleDateFormat("YYYYMMdd-HHmmss");
		String name = dateFmt.format(new Date());
		
		rr.setEmail(name+"@naver.com");
		rr.setPassword("1234");
		rr.setName(name);
		rr.setConfirmPassword("1234");
		
		regSvc.regist(rr);
		
		return rr.getEmail();
	}

}
