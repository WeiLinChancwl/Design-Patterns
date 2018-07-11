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
	public GamePlayer(IGamePlayer _gamePlayer, String _name) throws Exception{
		if(_gamePlayer == null) {
			throw new Exception("不能创建真实角色");
		} else {
			this.name = _name;
		}
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

class GamePlayerProxy implements IGamePlayer {
	private IGamePlayer gamePlayer = null;
	public GamePlayerProxy(String name) {
		try {
			gamePlayer = new GamePlayer(this, name);
		} catch(Exception e) {
			// ToDo 异常处理
		}
	}
	//代练杀怪
	public void killBoss() {
		this.gamePlayer.killBoss();
	}
	//代练登录
	public void login(String user, String password) {
		this.gamePlayer.login(user, password);
	}
	public void upgrade() {
		this.gamePlayer.upgrade();
	}
}

public class Client2 {
	public static void main(String[] args) {
		//定义一个代练者
		IGamePlayer proxy = new GamePlayerProxy("张三");
		//开始打游戏，记下时间戳
		System.out.println("开始时间是: 2009-8-25 10:45");
		proxy.login("zhangsan", "password");
		//开始杀怪
		proxy.killBoss();
		//升级
		proxy.upgrade();
		//记录结束游戏时间
		System.out.println("结束时间是: 2009-8-26 03:40");
	}
}