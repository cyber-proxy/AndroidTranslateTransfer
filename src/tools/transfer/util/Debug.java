package tools.transfer.util;

public class Debug {
	
	public static void print(String strParam) {
		System.out.println(strParam);
	}
	
	public static void print(String[] strParam) {
		for (String string : strParam) {
			System.out.print(string+"\t");
		}
		System.out.print("\n");
	}
	
	public static void print(int strParam) {
		System.out.println(strParam);
	}
	
	public static void print(long strParam) {
		System.out.println(strParam);
	}
	
	public static void print(Object strParam) {
		System.out.println(strParam);
	}
	
	public static void print(Integer strParam) {
		System.out.println(strParam);
	}
	
	public static void print(Exception e) {
		if (e instanceof Exception && e != null) {
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
		}
	}


}
