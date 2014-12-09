package example07;

import java.util.Random;

public class Launcher {

	public static void main(String[] args) {
		
		RoundBuffer buffer = new RoundBuffer();
		Random rand = new Random();
		

		for (int i = 0; i <100; i++){
			char c = (char)(rand.nextInt(26) + 'a');
			String rand_str = Character.toString(c); 
			buffer.put(rand_str);
			
		}
		buffer.printMe();
		int length1 = buffer.length();
		System.out.println(buffer.get(4));
		System.out.println(length1);
		
	}

}
