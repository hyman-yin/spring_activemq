package spring_activemq;

public class Test {
	private static int count=0;
	
	public static void recursion(){
		count++;
		recursion();
	}
	
	public static void main(String[] args) {
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println("count: "+count);
			e.printStackTrace();
		}
	}
}
