abstract class Product {
	public void method1 {

	}
	public abstract void method2();
}

class ConcreteProduct1 extends Product {
	public void method2() {

	}
}

class ConcreteProduct2 extends Product {
	public void method2() {

	}
}

abstract class Creator {
	public abstract <T extends Product> T createProduct(Class<T> c);
}

class ConcreteCreator extends Creator {
	public <T extends Product> T createProduct(Class<T> c) {
		Product product = null;
		try {
			product = (Product)Class.forName(c.getName()).newInstance();
		} catch(Exception e) {

		}
		return (T)product;
	}
}

public class Client {
	public static void main(String[] args) {
		Creator creator = new ConcreteCreator();
		Product product = creator.createProduct(ConcreteProduct1.class);
	}
}