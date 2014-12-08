package cviceni2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;


interface Printer1 { void print(String msg);  }
interface MyCollection {
	void add(Object o);
//	Object get(int i);
//	void remove(Object o);
//	void remove(int i);
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
		GenericPrinter gp2 = new GenericPrinter();
		TimestampPrinter tsp = new TimestampPrinter();
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



