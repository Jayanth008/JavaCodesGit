package practice1;

public class AbstrctmethodPrinting {
	public static void main(String[] args) {
		abs d=new abs() {};
		d.methodimpl();
	}
}

abstract class abs {
	void methodimpl() {
		System.out.println("printing");
	}

}

