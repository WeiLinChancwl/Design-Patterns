interface IGoodBodyGirl {
	public void goodLooking();
	public void niceFigure();
}

interface IGreatTemperamentGirl {
	public void greatTemperament();
}

class PettyGirl implements IGoodBodyGirl, IGreatTemperamentGirl {
	private String name;
	public PettyGirl(String _name) {
		this.name = _name;
	}
	public void goodLooking() {
		System.out.println(this.name + "---脸蛋很漂亮");
	}
	public void greatTemperament() {
		System.out.println(this.name + "---气质非常好");
	}
	public void niceFigure() {
		System.out.println(this.name + "---身材非常棒");
	}
}

abstract class AbstractSearcher {
	protected PettyGirl pettyGirl;
	public AbstractSearcher(PettyGirl _pettyGirl) {
		this.pettyGirl = _pettyGirl;
	}
	public abstract void show();
}

class Searcher extends AbstractSearcher {
	public Searcher(PettyGirl _pettyGirl) {
		super(_pettyGirl);
	}

	public void show() {
		System.out.println("------美女的信息如下-----");
		super.pettyGirl.goodLooking();
		super.pettyGirl.niceFigure();
		super.pettyGirl.greatTemperament();
	}
}

public class BetterClient2 {
	public static void main(String[] args) {
		PettyGirl yanyan = new PettyGirl("嫣嫣");
		AbstractSearcher searcher = new Searcher(yanyan);
		searcher.show();
	}
}