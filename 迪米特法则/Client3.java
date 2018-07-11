import java.util.*;
class Wizard {
	private Random rand = new Random(System.currentTimeMillis());
	public int first() {
		System.out.println("执行第一个方法...");
		return rand.nextInt(100);
	}

	public int second() {
		System.out.println("执行第二个方法...");
		return rand.nextInt(100);
	}

	public int third() {
		System.out.println("执行第三个方法...");
		return rand.nextInt(100);
	}
}

class InstallSoftware {
	public void installWizard(Wizard wizard) {
		int first = wizard.first();
		//根据first返回的结果，看是否需要执行second
		if(first > 50) {
			int second = wizard.second();
			if(second > 50) {
				int third = wizard.third();
				if(third > 50) {
					wizard.first();
				}
			}
		}
	}
}

public class Client3 {
	public static void main(String[] args) {
		InstallSoftware invoker = new InstallSoftware();
		invoker.installWizard(new Wizard());
	}
}