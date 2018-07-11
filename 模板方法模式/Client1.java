abstract class AbstractClass {
	//基本方法
	protected abstract void doSomething();
	protected abstract void doAnything();
	//模板方法
	public void templateMethod() {
		this.doAnything();
		this.doSomething();
	}
}

class ConcreteClass1 extends AbstractClass {
	protected void doAnything() {
		//业务逻辑处理
	}
	protected void doSomething() {
		//业务逻辑处理
	}
}

class ConcreteClass2 extends AbstractClass {
	protected void doAnything() {
		//业务逻辑处理
	}
	protected void doSomething() {
		//业务逻辑处理
	}
}

public class Client1 {
	public static void main(String[] args) {
		AbstractClass class1 = new ConcreteClass1();
		AbstractClass class2 = new ConcreteClass2();
		//调用模板方法
		class1.templateMethod();
		class2.templateMethod();
	}
}