package example07;

import java.util.ArrayList;

public class RoundBuffer {

	ArrayList<String> b;// = {"s1","s2","s3","s4","s5"};
	
	public RoundBuffer() {
		System.out.println("hi, i'm supposed to be a random buffer");
		b = new ArrayList<String>();
	}

	public void put(String value) {
		b.add(value);
	}

	public String get(int index) {
		return b.remove(index);
	}
	
	public void printMe() {
		System.out.println("Printing array...");
		for (int i=0;i<b.size();i++) {
			System.out.println(b.get(i));	
		}
		System.out.println("------");
	}
	
	public int length() {
		return b.size();
	}

}
