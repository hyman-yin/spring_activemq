package spring_activemq;

public class ParentClass {
	public static String str = "父类静态变量";
	public String str2 = "父类非静态变量";
	
	static {
		System.out.println("父类静态代码块,父类静态变量的值： "+str);
	}
	
	{
		System.out.println("父类非静态代码块，父类非静态变量的值: "+str2);
	}
	
	public ParentClass(){
		System.out.println("父类无参构造方法");
	}
	
	public ParentClass(String str2){
		System.out.println("父类有参构造方法");
	}
	
}
