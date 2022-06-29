package ex99;

public class Main01 {

	public static void main(String[] args) {
		// 메서드를 사용하는 방법
		TestCls tc = new TestCls();
		tc.mo();
		tc.m2();
		
		////////////////////////////////////////
		TestInter ti = new TestCls();	// 다형성
		ti.mo();
//		ti.m2();	// TestInter는 m2() 메서드를 모르기때문에 사용할 수 없다.
		
		////////////////////////////////////////
		kkk(new TestCls());
		
		////////////////////////////////////////
		// 익명 구현 객체
		TestInter ti2 = new TestInter() {	// 익명 구현 객체
			
			@Override
			public void mo() {
				System.out.println("익명 구현 객체로 구현된 메서드2");
			}
		};
		ti2.mo();
		
		kkk(new TestInter() {

			@Override
			public void mo() {
				System.out.println("메서드의 매개변수로 익명 구현 객체를 이용해 구현한 메서드3");
			}
			
		});
		
	}
	
	private static void kkk(TestInter ti) {
		ti.mo();
	}

}
