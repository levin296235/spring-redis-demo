package cn.springmvc.test;

public class PolyDemo09{	
	public static void main(String[] args){
		A a1 = new A();	
		A a2 = new B();	
		B b = new B(); 
		C c = new C();
		D d = new D();
		
		System.out.println("⑴ " + a1.show(b));
		System.out.println("⑵ " + a1.show(c)); 
		System.out.println("⑶ " + a1.show(d));	
		System.out.println("⑷ " + a2.show(b)); 
		System.out.println("⑸ " + a2.show(c));
		System.out.println("⑹ " + a2.show(d)); 
		System.out.println("⑺ " + b.show(b)); 
		System.out.println("⑻ " + b.show(c)); 
		System.out.println("⑼ " + b.show(d));	
	
	}
}

class A {	
public String show(D obj) {
return ("A and D");
}	
public String show(A obj) {
return ("A and A");
}
}

class B extends A {
public String show(B obj) {
return ("B and B");
}
public String show(A obj) {
return ("B and A");
}

}

class C extends B {
}

class D extends B {
}