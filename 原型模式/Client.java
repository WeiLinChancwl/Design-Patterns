import java.util.*;
class AdvTemplate { //广告信模板类
	//广告信
	private String advSubject = "xx银行国庆信用卡抽奖活动";
	//广告内容
	private String advContext = "国庆抽奖活动通知：只要刷卡就送一百万！．．．";
	//取得广告信的名称
	public String getAdvSubject() {
		return this.advSubject;
	}
	//取得广告信的内容
	public String getAdvContext() {
		return this.advContext;
	}
}

class Mail { //邮件类
	//收件人
	private String receiver;
	//邮件名称
	private String subject;
	//称谓
	private String appellation;
	//邮件内容
	private String contxt;
	//邮件的尾部，一般都是加上"xxx版权所有"等信息
	private String tail;
	//构造函数
	public Mail(AdvTemplate advTemplate) {
		this.contxt = advTemplate.getAdvContext();
		this.subject = advTemplate.getAdvSubject();
	}
	//以下为getter/setter方法
	public String getReceiver() {
		return this.receiver;
	} 
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return this.subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAppellation() {
		return this.appellation;
	}
	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}
	public String getContxt() {
		return this.contxt;
	}
	public void setContxt(String contxt) {
		this.contxt = contxt;
	} 
	public String getTail() {
		return this.tail;
	}
	public void setTail(String tail) {
		this.tail = tail;
	}
}

public class Client {
	//发送账单的数量,这个值是从数据库中获得
	private static int MAX_COUNT = 6;
	public static void main(String[] args) {
		//模拟发送邮件
		int i = 0;
		//把模板定义出来,这个是从数据库中获得
		Mail mail = new Mail(new AdvTemplate());
		mail.setTail("xx银行版权所有");
		while(i<MAX_COUNT) {
			//以下是每封邮件不同的地方
			mail.setAppellation(getRandString(5) + " 先生(女士)");
			mail.setReceiver(getRandString(5) + "@" + getRandString(8) + ".com");
			//然后发送邮件
			sendMail(mail);
			i++;
		}
	}

	//发送邮件
	public static void sendMail(Mail mail) {
		System.out.println("标题: " + mail.getSubject() + "\t收件人:" 
			+ mail.getReceiver() + "\t...发送成功");
	}
	//获得指定长度的随机字符串
	public static String getRandString(int maxLength) {
		String source = "abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSKUWXYZ";
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		for(int i = 0; i < maxLength; i++) {
			sb.append(source.charAt(rand.nextInt(source.length())));
		}
		return sb.toString();
	}
}

