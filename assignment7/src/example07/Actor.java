package example07;


public class Actor extends Thread {
	private RoundBuffer rb;
	boolean producer;
	
	public Actor(RoundBuffer B, boolean producer){
		rb = B;
		this.producer = producer;
	
	}
	
	public void run() {
		while(true) {
			if(producer)
				rb.put(Thread.currentThread().getName());
			else
				rb.get();
		}
	}
	
	public static void main(String[] args) {
		RoundBuffer rb = new RoundBuffer();
				
		Actor a = new Actor(rb, true);
		a.start();
		
		Actor a2 = new Actor(rb, false);
		a2.start();
		
	}
	
	
}
