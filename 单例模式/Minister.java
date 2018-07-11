class Emperor {
	private static final Emperor emperor = new Emperor();
	private Emperor() {

	}
	public static Emperor getInstance() {
		return emperor;
	}

	public static void say() {
		System.out.println("我就是皇帝某某某。。。");
	}
}

public class Minister {
	public static void main(String[] args) {
		for(int day = 0; day < 3; day++) {
			Emperor emperor = Emperor.getInstance();
			emperor.say();
		}
	}
}