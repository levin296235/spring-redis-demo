package cn.springmvc.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DataElement {

	public static void main(String[] args) {
//		List<String> list  = new ArrayList<String>();
//		list.add("hello");
		
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		System.out.println("size="+stack.size());
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println("取完后的数量：" + stack.size());  
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer("NO1");
		queue.offer("NO2");
		queue.offer("NO3");
		queue.offer("NO4");
		System.out.println("初始数量" + queue.size());  
	    String str;  
        while((str=queue.poll())!=null){  
            System.out.println(str);  
        }
        
        System.out.println("取出后数量" + queue.size());
	}
}
