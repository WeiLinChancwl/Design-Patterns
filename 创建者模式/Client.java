import java.util.*;
abstract class CarModel {
	private ArrayList<String> sequence = new ArrayList<String>();
	protected abstract void start();
	protected abstract void stop();
	protected abstract void alarm();
	protected abstract void engineBoom();
	final public void run() {
		for(int i=0; i<this.sequence.size(); i++) {
			String actionName = this.sequence.get(i);
			if(actionName.equalsIgnoreCase("start")) {
				this.start();
			}else if(actionName.equalsIgnoreCase("stop")) {
				this.stop();
			}else if(actionName.equalsIgnoreCase("alarm")) {
				this.alarm();
			}else if(actionName.equalsIgnoreCase("engine boom")) {
				this.engineBoom();
			}
		}
	}

	final public void setSequence(ArrayList<String> sequence) {
		this.sequence = sequence;
	}
}

class BenzModel extends CarModel {
	protected void alarm() {
		System.out.println("奔驰车的喇叭声。。。");
	}
	protected void engineBoom() {
		System.out.println("奔驰车的引擎声。。");
	}
	protected void start() {
		System.out.println("奔驰车跑起来");
	}
	protected void stop() {
		System.out.println("奔驰车停车");
	}
}

class BMWModel extends CarModel {
	protected void alarm() {
		System.out.println("宝马车的喇叭声音。。。");
	}
	protected void engineBoom() {
		System.out.println("宝马车的引擎声。。");
	}
	protected void start() {
		System.out.println("宝马车跑起来");
	}
	protected void stop() {
		System.out.println("宝马车停车");
	}
}

abstract class CarBuilder {
	public abstract void setSequence(ArrayList<String> sequence);
	public abstract CarModel getCarModel();
}

class BenzBuilder extends CarBuilder {
	private BenzModel benz = new BenzModel();
	public CarModel getCarModel() {
		return this.benz;
	}
	public void setSequence(ArrayList<String> sequence) {
		this.benz.setSequence(sequence);
	}
}

class BMWBuilder extends CarBuilder {
	private BMWModel bmw = new BMWModel();
	public CarModel getCarModel() {
		return this.bmw;
	}
	public void setSequence(ArrayList<String> sequence) {
		this.bmw.setSequence(sequence);
	}
}

class Director {
	private ArrayList<String> sequence = new ArrayList<String>();
	private BenzBuilder benzBuilder = new BenzBuilder();
	private BMWBuilder bmwBuilder = new BMWBuilder();

	public BenzModel getABenzModel() {
		this.sequence.clear();
		this.sequence.add("start");
		this.sequence.add("stop");
		this.benzBuilder.setSequence(this.sequence);
		return (BenzModel)this.benzBuilder.getCarModel();
	}

	public BenzModel getBBenzModel() {
		this.sequence.clear();
		this.sequence.add("engine boom");
		this.sequence.add("start");
		this.sequence.add("stop");
		this.benzBuilder.setSequence(this.sequence);
		return (BenzModel)this.benzBuilder.getCarModel();
	}

	public BMWModel getCBMWModel() {
		this.sequence.clear();
		this.sequence.add("alarm");
		this.sequence.add("start");
		this.sequence.add("stop");
		this.bmwBuilder.setSequence(this.sequence);
		return (BMWModel)this.bmwBuilder.getCarModel();
	}

	public BMWModel getDBMWModel() {
		this.sequence.clear();
		this.sequence.add("start");
		this.bmwBuilder.setSequence(this.sequence);
		return (BMWModel)this.bmwBuilder.getCarModel();
	}
}

public class Client {
	public static void main(String[] args) {
		Director director = new Director();
		for(int i = 0; i < 10000; i++) {
			director.getABenzModel().run();
		}
		for(int i = 0; i < 1000000; i++) {
			director.getBBenzModel().run();
		}
		for(int i = 0; i < 10000000; i++) {
			director.getCBMWModel().run();
		}
	}
}