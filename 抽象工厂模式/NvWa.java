interface Human {
	//每个人种都有相应的颜色
	public void getColor();
	//人类会说话
	public void talk();
	//每个人都有性别
	public void getSex();
}

abstract class AbstractWhiteHuman implements Human {
	//白色人种的皮肤是白色的
	public void getColor() {
		System.out.println("白色人种的皮肤是白色的!");
	}
	//白色人种会说话
	public void talk() {
		System.out.println("白色人种会说话,一般说都是单字节。");
	}
}

abstract class AbstractBlackHuman implements Human {
	public void getColor() {
		System.out.println("黑色人种的皮肤是黑色的!");
	}
	public void talk() {
		System.out.println("黑色人种会说话,一般人都听不懂。");
	}
}

abstract class AbstractYellowHuman implements Human {
	public void getColor() {
		System.out.println("黄色人种的皮肤是黄色的!");
	}
	public void talk() {
		System.out.println("黄色人种会说话，一般说都是双字节。");
	}
}

class FemaleYellowHuman extends AbstractYellowHuman {
	//黄人女性
	public void getSex() {
		System.out.println("黄人女性");
	}
}

class MaleYellowHuman extends AbstractYellowHuman {
	//黄人男性
	public void getSex() {
		System.out.println("黄人男性");
	}
}

class FemaleBlackHuman extends AbstractBlackHuman {
	//黑人女性
	public void getSex() {
		System.out.println("黑人女性");
	}
}

class MaleBlackHuman extends AbstractBlackHuman {
	public void getSex() {
		System.out.println("黑人男性");
	}
}

class FemaleWhiteHuman extends AbstractWhiteHuman {
	public void getSex() {
		System.out.println("白人女性");
	}
}

class MaleWhiteHuman extends AbstractWhiteHuman {
	public void getSex() {
		System.out.println("白人男性");
	}
}

interface HumanFactory {
	public Human createYellowHuman();
	public Human createBlackHuman();
	public Human createWhiteHuman();
}

class FemaleFactory implements HumanFactory {
	public Human createBlackHuman() {
		return new FemaleBlackHuman();
	}
	public Human createYellowHuman() {
		return new FemaleYellowHuman();
	}
	public Human createWhiteHuman() {
		return new FemaleWhiteHuman();
	}
}

class MaleFactory implements HumanFactory {
	public Human createBlackHuman() {
		return new MaleBlackHuman();
	}
	public Human createYellowHuman() {
		return new MaleYellowHuman();
	}
	public Human createWhiteHuman() {
		return new MaleWhiteHuman();
	}	
}

public class NvWa {
	public static void main(String[] args) {
		HumanFactory maleHumanFactory = new MaleFactory();
		HumanFactory femaleHumanFactory = new FemaleFactory();
		Human maleYellowHuman = maleHumanFactory.createYellowHuman();
		Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
		System.out.println("---生产一个黄色女性---");
		femaleYellowHuman.talk();
		femaleYellowHuman.getColor();
		femaleYellowHuman.getSex();
		System.out.println("---生产一个黄色男性---");
		maleYellowHuman.talk();
		maleYellowHuman.getColor();
		maleYellowHuman.getSex();
	}
}