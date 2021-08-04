package java8;

import java.util.function.*;

public class LambdaClass {

	public static void main(String[] args) {
		
		additionOfNum(5,6);
		
		FuncInterface x1 = (int a, int b) -> { return a+b;};
		
		FuncInterface x2 = (a,b) -> { return a+b;};
		
		FuncInterface x3 = (a,b) -> a+b;
		
		BiFunction<Integer, Integer,Integer> x4 = (a,b)->a+b;
		
		BiConsumer<Integer,Integer> x5 = (a,b)-> {System.out.println(a+b);};
  		
		System.out.println(x1.addfunc(10,20));
		
		System.out.println(x2.addfunc(20,20));
		
		System.out.println(x3.addfunc(20,30));
		
		System.out.println(x4.apply(30,30));
		
		x5.accept(30,40);
		
		Map<String,String> m1=Map.of()
		
	}
	
	private static int additionOfNum(int x,int y) {
		return x+y;
	}

}
