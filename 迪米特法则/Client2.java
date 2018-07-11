import java.util.*;
class Teacher {
	//老师发命令
	public void commond(GroupLeader groupLeader) {
		groupLeader.countGirls();
	}
}

class GroupLeader {
	private List<Girl> listGirls;
	//传递全班女生进来
	public GroupLeader(List<Girl> _listGirls) {
		this.listGirls = _listGirls;
	}
	//清查女生数量
	public void countGirls() {
		System.out.println("女生数量是： " + this.listGirls.size());
	}
}

public class Client2 {
	public static void main(String[] args) {
		//产生一个女生群体
		List<Girl> listGirls = new ArrayList<Girl>();
		//初始化女生
		for(int i = 0; i < 20; i++) {
			listGirls.add(new Girl());
		}
		Teacher teacher = new Teacher();
		//发命令
		teacher.commond(new GroupLeader(listGirls));
	}
}