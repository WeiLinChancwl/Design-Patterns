import java.io.*;
abstract class HummerModel {
	protected abstract void start();
	protected abstract void stop();
	protected abstract void alarm();
	protected abstract void engineBoom();
	final public void run() {
		this.start();
		this.engineBoom();
		if(this.isAlarm()) {
			this.alarm();
		}
		this.stop();
	}
	protected boolean isAlarm() {
		return true;
	}
}

class HummerH1Model extends HummerModel {
	private boolean alarmFlag = true;
	protected void alarm() {
		System.out.println("悍马H1鸣笛。。。");
	}
	protected void engineBoom() {
		System.out.println("悍马H1引擎声音。。");
	}
	protected void start() {
		System.out.println("悍马H1发动");
	}
	protected void stop() {
		System.out.println("悍马H1停车");
	}
	protected boolean isAlarm() {
		return this.alarmFlag;
	}
	public void setAlarm(boolean isAlarm) {
		this.alarmFlag = isAlarm;
	}
}

class HummerH2Model extends HummerModel {
	private boolean alarmFlag = false;
	protected void alarm() {
		System.out.println("悍马H2鸣笛。。。");
	}
	protected void engineBoom() {
		System.out.println("悍马H2引擎声音。。");
	}
	protected void start() {
		System.out.println("悍马H2发动");
	}
	protected void stop() {
		System.out.println("悍马H2停车");
	}
	protected boolean isAlarm() {
		return this.alarmFlag;
	}
	public void setAlarm(boolean isAlarm) {
		this.alarmFlag = alarmFlag;
	}
}

public class Client2 {
	public static void main(String[] args) throws IOException{
		System.out.println("------H1型号悍马-----");
		System.out.println("H1型号的悍马是否需要喇叭声响? 0-不需要 1-需要");
		String type = (new BufferedReader(new InputStreamReader(System.in))).readLine();
		HummerH1Model h1 = new HummerH1Model();
		if(type.equals("0")) {
			h1.setAlarm(false);
		}
		h1.run();
		System.out.println("\n------H2型号悍马-----");
		HummerH2Model h2 = new HummerH2Model();
		h2.run();
	}
}