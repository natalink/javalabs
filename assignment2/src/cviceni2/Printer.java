package cviceni2;

import java.util.Date;

interface Printer1 { void print(String msg);  }

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
		System.out.println("class TypePrinter");
	}
}

class Logger {
	public void addPrinter(Printer1 p){
		//???????????????????????????????????????WHAT SHALL I DO HERE?
		
	}
	public void log(int level, String msg){
		
	}
	public void setLevel(int level){}
}

class Printer {
	static void u(GenericPrinter b) {
		b.print("blah-blah"); 
	}

	public static void main(String[] args){
		GenericPrinter gp2 = new GenericPrinter();
		TimestampPrinter tsp = new TimestampPrinter();
		TypePrinter tp = new TypePrinter();
//		u(gp2);
		u(tsp);
//		u(tp);
		
	}
	
}



