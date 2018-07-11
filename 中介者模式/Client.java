import java.util.*;
class Purchase {
	//采购IBM电脑
	public void buyIBMcomputer(int number) {
		//访问库存
		Stock stock = new Stock();
		//访问销售
		Sale sale = new Sale();
		//电脑销售的情况
		int saleStatus = sale.getSaleStatus();
		if(saleStatus > 80) { //销售情况良好
			System.out.println("采购IBM电脑: " + number + "台");
			stock.increase(number);
		} else { //销售情况不好
			int buyNumber = number / 2; //折半采购
			System.out.println("采购IBM电脑: " + buyNumber + "台");
		}
	}

	//不再采购IBM电脑
	public void refuseBuyIBM() {
		System.out.println("不再采购IBM电脑");
	}	
}

class Stock { //库存管理
	//刚开始有100台电脑
	private static int COMPUTER_NUMBER = 100;
	//库存增加
	public void increase(int number) {
		COMPUTER_NUMBER = COMPUTER_NUMBER + number;
		System.out.println("库存数量为：" + COMPUTER_NUMBER);
	}
	//库存降低
	public void decrease(int number) {
		COMPUTER_NUMBER = COMPUTER_NUMBER - number;
		System.out.println("库存数量为:" + COMPUTER_NUMBER);
	}
	//获得库存数量
	public int getStockNumber() {
		return COMPUTER_NUMBER;
	}
	//存货压力大了，就要通知采购人员不要采购，销售人员要尽快销售
	public void clearStock() {
		Purchase purchase = new Purchase();
		Sale sale = new Sale();
		System.out.println("清理存货数量为： " + COMPUTER_NUMBER);
		//要求折价销售
		sale.offSale();
		//要求采购人员不要采购
		purchase.refuseBuyIBM();
	}
}

class Sale {
	public void sellIBMComputer(int number) {
		//访问库存
		Stock stock = new Stock();
		//访问采购
		Purchase purchase = new Purchase();
		if(stock.getStockNumber() < number) { //库存数量不够销售
			purchase.buyIBMcomputer(number);
		}
		System.out.println("销售IBM电脑" + number + "台");
		stock.decrease(number);
	}

	//反馈销售情况，0~100之间变化，0代表根本就没人卖，100代表非常畅销，出一个卖一个
	public int getSaleStatus() {
		Random rand = new Random(System.currentTimeMillis());
		int saleStatus = rand.nextInt(100);
		System.out.println("IBM电脑的销售情况为： " + saleStatus);
		return saleStatus;
	}

	//折价处理
	public void offSale() {
		//库房有多少就卖多少
		Stock stock = new Stock();
		System.out.println("折价销售IBM电脑" + stock.getStockNumber() + "台");
	}
}

public class Client {
	public static void main(String[] args) {
		//采购人员采购电脑
		System.out.println("-----采购人员采购电脑-----");
		Purchase purchase = new Purchase();
		purchase.buyIBMcomputer(100);
		//销售人员销售电脑
		System.out.println("\n-----销售人员销售电脑-----");
		Sale sale = new Sale();
		sale.sellIBMComputer(1);
		//库房管理人员管理库存
		System.out.println("\n-----库房管理人员清库处理-----");
		Stock stock = new Stock();
		stock.clearStock();
	}
}