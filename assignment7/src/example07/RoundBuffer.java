package example07;

import java.util.ArrayList;

public class RoundBuffer {

	ArrayList<String> b;// = {"s1","s2","s3","s4","s5"};
	int capacity = 10;
	
	public RoundBuffer() {
		System.out.println("hi, i'm supposed to be a random buffer");
		b = new ArrayList<String>();
	}

	public synchronized void put(String value) {
		System.out.println("putting element..");
		if (b.size() < capacity){
			b.add(value);
			System.out.println("notifying that value.. "+ value + " .. is added ");
			notify();
		}
		else{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

	public synchronized String get() {
		System.out.println("removing first element..");
		if (b.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;			
		}
		notify();
		System.out.println("notifying that the element is removed.." + b.remove(0));
		return b.remove(0);
		
		
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
