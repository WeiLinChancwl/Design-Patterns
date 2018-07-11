interface IGamePlayer {
	//登录游戏
	public void login(String user, String password);
	//杀怪，网络游戏的主要特色
	public void killBoss();
	//升级
	public void upgrade();
}

class GamePlayer implements IGamePlayer {
	private String name = "";
	//通过构造函数传递名称
	public GamePlayer(String _name) {
		this.name = _name;
	}
	//打怪，最期望的就是杀老妖怪
	public void killBoss() {
		System.out.println(this.name + "在打怪!");
	}

	//登录
	public void login(String user, String password) {
		System.out.println("登录名为" + user + "的用户" + this.name + "登录成功!");
	}
	//升级
	public void upgrade() {
		System.out.println(this.name + "又升了一级!");
	}
}

public class Client {
	public static void main(String[] args) {
		//定义一个痴迷的玩家
		IGamePlayer player = new GamePlayer("张三");
		//开始打游戏，记下时间戳
		System.out.println("开始时间是: 2009-8-25 10:45");
		player.login("zhangsan", "password");
		//开始杀怪
		player.killBoss();
		//升级
		player.upgrade();
		//记录结束游戏时间
		System.out.println("结束时间是: 2009-8-26 03:40");
	}
}