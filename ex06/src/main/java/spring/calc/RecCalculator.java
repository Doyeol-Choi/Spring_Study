package spring.calc;

public class RecCalculator implements Calculator {
	// 재귀함수를 통해서 팩토리얼 구하는 방법	(함수 내에서 자기 자신을 다시 호출 하는것)
	// 동작 시간 측정 코드
	@Override
	public long factorial(long num) {
		
//		long start = System.currentTimeMillis();
		
		try {
			if(num==0) {
				return 1;
			} else {
				return num * factorial(num-1);			
			}
		} finally {
//			long end = System.currentTimeMillis();	
//			System.out.printf("RecCalculator.factorial(%d) 실행시간 : %d \n", num, (end-start));
		}
	}

}
