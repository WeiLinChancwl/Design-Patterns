import java.util.*;
import java.text.NumberFormat; 
interface IBook {
	//书籍名称
	public String getName();
	//书籍售价
	public int getPrice();
	//书籍作者
	public String getAuthor();
}

class NovelBook implements IBook {
	private String name;
	private int price;
	private String author;
	public NovelBook(String _name, int _price, String _author) {
		this.name = _name;
		this.price = _price;
		this.author = _author;
	}
	public String getAuthor()  {
		return this.author;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
}

class OffNovelBook extends NovelBook {
	public OffNovelBook(String _name, int _price, String _author) {
		super(_name, _price, _author);
	}
	//覆写销售价格
	@Override
	public int getPrice() {
		int selfPrice = super.getPrice();
		int offPrice = 0;
		if(selfPrice > 4000) {//原价大于40元，打9折
			offPrice = selfPrice * 90 / 100;
		}else {
			offPrice = selfPrice * 80 / 100;
		}
		return offPrice;
	}
}

// class NovelBookTest extends TestCase {
// 	private String name = "平凡的世界";
// 	private int price = 6000;
// 	private String author = "路遥";
// 	private IBook novelBook = new NovelBook(name, price, author);
// 	//测试getPrice方法
// 	public void testGetPrice() {
// 		super.assertEquals(this.price, this.novelBook.getPrice());
// 	}
// }

// class OffNovelBookTest extends TestCase {
// 	private IBook below40NovelBook = new OffNovelBook("平凡的世界", 3000, "路遥");
// 	private IBook above40NovelBook = new OffNovelBook("平凡的世界", 6000, "路遥");
// 	public void testGetPriceBelow40() {
// 		super.assertEquals(2400, this.below40NovelBook.getPrice());
// 	}
// 	public void testGetPriceAbove40() {
// 		super.assertEquals(5400, this.above40NovelBook.getPrice());
// 	}
// }

interface IcomputerBook extends IBook {
	//计算机书籍是有一个范围的
	public String getScope();
}

class ComputerBook implements IcomputerBook {
	private String name;
	private String scope;
	private String author;
	private int price;
	public ComputerBook(String _name, int _price, String _author, String _scope) {
		this.name = _name;
		this.price = _price;
		this.author = _author;
		this.scope = _scope;
	}
	public String getScope() {
		return this.scope;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
}

public class BookStore {
	private final static ArrayList<IBook> bookList = new ArrayList<IBook>();
	//static静态模块初始化数据，实际项目中一般是由持久层完成
	static { 
		bookList.add(new OffNovelBook("天龙八部", 3200, "金庸"));
		bookList.add(new OffNovelBook("巴黎圣母院", 5600, "雨果"));
		bookList.add(new OffNovelBook("悲惨世界", 3500, "雨果"));
		bookList.add(new OffNovelBook("金瓶梅", 4300, "兰陵笑先生"));
		bookList.add(new ComputerBook("Think in Java", 4300, "Bruce Eckel", "编程语言"));
	}
	//模拟书店买书
	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		formatter.setMaximumFractionDigits(2);
		System.out.println("--------书店卖出去的书籍记录如下:--------");
		for(IBook book : bookList) {
			System.out.println("书籍名称: " + book.getName() + "\t书籍作者:" +
				book.getAuthor() + "\t书籍价格:" + formatter.format(book.getPrice()/100.0)
					+"元");
		}
	}
}