package ex01;

public class Greeter {		// 자바에서 어떻게 클래스를 사용하는가??
	private String format;
	
	public String greet(String name) {	// 궁극적으로 사용하고자 하는 메서드
		return String.format(format, name);
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
