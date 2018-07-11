class Product {//产品类
	
	public void dosomething() {

	}
}

abstract class Builder {//抽象建造者
	
	public abstract void setPart();
	public abstract Product buildProduct();
}

class ConcreteProduct extends Builder {
	private Product product = new Product();
	public void setPart() {

	}
	public Product buildProduct() {
		return product;
	}
}

class Director {
	private Builder builder = new ConcreteProduct();
	public Product getAProduct() {
		builder.setPart();
		return builder.buildProduct();
	}
}
