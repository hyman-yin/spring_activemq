package spring_activemq;

public class SubClass extends ParentClass {
	public static String str = "子类静态变量";
	public String str2 = "子类非静态变量";
	
	static {
		System.out.println("子类静态代码块,子类静态变量的值： "+str);
	}
	
	{
		System.out.println("子类非静态代码块，子类非静态变量的值: "+str2);
	}
	
	public SubClass(){
		System.out.println("子类无参构造方法");
	}
	
	public SubClass(String str2){
		System.out.println("父类有参构造方法");
	}
}
