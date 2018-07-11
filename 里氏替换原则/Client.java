import java.util.*;

abstract class AbstractGun {
	//
	public abstract void shoot();
}

class Handgun extends AbstractGun {
	@Override
	public void shoot() {
		System.out.println("手枪射击");
	}
}

class Rifle extends AbstractGun {
	public void shoot() {
		System.out.println("步枪射击");
	}
}

class MachineGun extends AbstractGun {
	public void shoot() {
		System.out.println("机枪射击");
	}
}

class ToyGun extends AbstractGun {
	public void shoot() {

	}
}

class AUG extends Rifle {
	public void zoomOut() {
		System.out.println("通过望远镜来看敌人...");
	}
	public void shoot() {
		System.out.println("AUG射击");
	}
}

class Snipper {
	public void killEnemy(AUG aug) {
		aug.zoomOut();
		aug.shoot();
	}
}

class Soldier {
	private AbstractGun gun;
	public void setGun(AbstractGun _gun) {
		this.gun = _gun;
	}
	public void killEnemy() {
		System.out.println("士兵开始杀敌人");
		gun.shoot();
	}
}

class Father {
	public Collection doSomething(HashMap map) {
		System.out.println("父类被执行...");
		return map.values();
	}
}

class Son extends Father {
	//放大参数类型，重载
	public Collection doSomething(Map map) {
		System.out.println("子类被执行");
		return map.values();
	}

}

public class Client {
	public static void invoker() {
		//父类存在的地方，子类就应该能够存在
		Son f = new Son();
		HashMap map = new HashMap();
		f.doSomething(map);
	}

	public static void main(String[] args) {
		invoker();
	}
}