package spring.printer;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberInfoPrinter {
	
	private MemberDao dao;
	private MemberPrinter printer;
	
	public void setDao(MemberDao dao) {		// setter 메서드를 통해서도 객체를 주입 받을 수 있다.
		this.dao = dao;
	}

	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	public void printMemberInfo(String email) {
		Member m = dao.selectByEmail(email);
		
		if(m == null) {
			System.out.println("데이터 없음");
			return;
		}
		printer.print(m);
		System.out.println();
	}
	
}
