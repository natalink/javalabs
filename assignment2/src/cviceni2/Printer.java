package cviceni2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


interface Printer1 { void print(String msg);  }
interface MyCollection {
	void add(Object o);
	Object get(int i);
	void remove(Object o);
	void remove(int i);
}

class CollectionImplementation implements MyCollection{
	int idx = 0;
	private Object[] arr = new Object[10];
	
	public void add(Object o){
		if(idx >= arr.length) {
			Object[] arr2 = new Object[arr.length+10];
			for(int i = 0; i < arr.length; i++){
				arr2[i] = arr[i]; 
			}
			arr = arr2;
		}
		System.out.println("Adding Object " + o);
		arr[idx] = o;
		System.out.println("Array after adding: " + Arrays.toString(arr));
		idx++;		
	}
	Integer i; 	
	public Integer get(Integer i){ 
		return i;	
	} //was not sure what to do here

	public void remove(Object o){
		List result = new LinkedList();
		System.out.println("Array before removing: " + o + Arrays.toString(arr));
		for(int idx2 = 0; idx2 < arr.length; idx2++){
			if (arr[idx2] == null || !arr[idx2].equals(o)){
				result.add(arr[idx2]);
			
			} 
		}
	
		System.out.println("RESULT:" + result);
	}

	@Override
	public void remove(int i) {
		// TODO Auto-generated method stub
		return;
	}
	
}

class GenericPrinter implements Printer1 {
        public void print(String msg){
          System.out.println("class GenericPrinter");
        }
}

class TimestampPrinter extends GenericPrinter {
	public void print(String msg){
		System.out.println("class TimestampPrinter");
		System.out.println(new java.util.Date());
	}	
}

class TypePrinter extends GenericPrinter {
	TypePrinter(){
//		System.out.println("class TypePrinter");
	}
}

class Logger {
	Printer1 myPrinter;
	public void addPrinter(Printer1 p){
		myPrinter =p;
	}
	public void log(String msg){
		myPrinter.print(msg);
	}
	public void setLevel(int level){}
}

class Printer {
	static void u(GenericPrinter b) {
		b.print("blah-blah"); 
	}

	public static void main(String[] args){
		CollectionImplementation collection = new CollectionImplementation();
		collection.add("a");
		collection.add("b");
//		System.out.println(collection.get(4));
		collection.remove("a");
		GenericPrinter gp2 = new GenericPrinter();
		Printer1 tsp = new TimestampPrinter();
		TypePrinter tp = new TypePrinter();
//		u(gp2);
//		u(tsp);
//		u(tp);
		Printer1 printer = new GenericPrinter();
		Logger logger = new Logger();
		logger.addPrinter(printer);
		logger.log("A log from Logger,why does it print GenericPrinter?");
	}
	
}



