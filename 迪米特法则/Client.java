import java.util.*;

class Teacher {
	//老师发命令，清女生
	public void commond(GroupLeader groupLeader) {
		List<Girl> listGirls = new ArrayList<Girl>();
		//初始女生
		for(int i = 0; i < 20; i++) {
			listGirls.add(new Girl());
		}
		//告诉体委开始执行清查任务
		groupLeader.countGirls(listGirls);
	}
}

class GroupLeader {
	//清查女生数量
	public void countGirls(List<Girl> listGirls) {
		System.out.println("女生数量是："+listGirls.size());
	}
}

class Girl{

}

public class Client {
	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		//老师发命令
		teacher.commond(new GroupLeader());
	}
}