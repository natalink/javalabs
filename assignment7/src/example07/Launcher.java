package example07;

public class Launcher {

	public static void main(String[] args) {
		
		RoundBuffer buffer = new RoundBuffer();
		buffer.printMe();
		
		buffer.put("s1");
		buffer.put("s2");
		buffer.put("s3");
		buffer.put("s4");
		buffer.put("s5");
		buffer.printMe();
		
		int length1 = buffer.length();
		for(int i=0;i<length1;i++){
			System.out.println(i);
			buffer.get(i);
		}
		
		buffer.printMe();
	}

}
