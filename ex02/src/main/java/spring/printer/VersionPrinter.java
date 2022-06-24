package spring.printer;

public class VersionPrinter {
	
	private int majorVersion;
	private int minerVersion;
	
	public VersionPrinter() {}
	
	public VersionPrinter(int majorVersion, int minerVersion) {
		this.majorVersion = majorVersion;
		this.minerVersion = minerVersion;
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	public void setMinerVersion(int minerVersion) {
		this.minerVersion = minerVersion;
	}

	public void print() {
		System.out.printf("이 프로그램 버전은 %d.%d 입니다. \n\n", majorVersion, minerVersion);
	}
}
