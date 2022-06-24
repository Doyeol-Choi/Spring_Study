package spring.printer;

import java.util.Collection;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberListPrinter {
	
	private MemberDao dao;
	private MemberPrinter printer;
	
	
	
	public MemberListPrinter(MemberDao dao, MemberPrinter printer) {
		// 생성자를 통해 주입받는 객체가 두개 이상인 상황
		this.dao = dao;
		this.printer = printer;
	}

	public void printAll() {	// 모든 회원 출력 => 두개의 객체를 주입 받아야 사용가능
		 Collection<Member> members = dao.selectAll();
		 
		 for(Member m:members) {
			 printer.print(m);
		 }
	}
}
