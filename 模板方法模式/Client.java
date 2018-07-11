abstract class HummerModel {
	public abstract void start(); //发动
	public abstract void stop(); //停下
	public abstract void alarm(); //喇叭响声
	public abstract void engineBoom(); //引擎声响
	//开动起来
	public void run() {
		this.start();
		this.engineBoom();
		this.alarm();
		this.stop();
	}
}

class HummerH1Model extends HummerModel {
	//H1型号的悍马车鸣笛
	public void alarm() {
		System.out.println("悍马H1鸣笛");
	}
	public void engineBoom() {
		System.out.println("悍马H1引擎声。。。");
	}
	public void start() {
		System.out.println("悍马H1发动");
	}
	public void stop() {
		System.out.println("悍马H1停车");
	}
	
}

class HummerH2Model extends HummerModel {
	//H1型号的悍马车鸣笛
	public void alarm() {
		System.out.println("悍马H2鸣笛");
	}
	public void engineBoom() {
		System.out.println("悍马H2引擎声。。。");
	}
	public void start() {
		System.out.println("悍马H2发动");
	}
	public void stop() {
		System.out.println("悍马H2停车");
	}
}

public class Client {
	public static void main(String[] args) {
		HummerModel h1 = new HummerH1Model();
		h1.run();
	}
}
