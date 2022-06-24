package spring.assembler;

import spring.dao.MemberDao;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

public class Assembler {

	private MemberDao dao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		dao = new MemberDao();				// 서비스 클래스 밖
		regSvc = new MemberRegisterService(dao);	// 생성된 인스턴스를 주입
		pwdSvc = new ChangePasswordService(dao);
	}

	public MemberDao getDao() {
		return dao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
}
