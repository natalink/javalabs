package assignment8;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class PriorityA{
	static void addPrio{
		
	}
	static void addMsg
}

class SortDecreasinglyL{}
class SortIncreasinglyR{}
class Interactive{}


public class Scheduler {

	static List<String> readFromFile(String path){
		List<String> list = new ArrayList<String>(); //what does it do?
		File file = new File(path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			while ((text = reader.readLine()) != null){
				list.add(text);
			}
		
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
			
		}
		return list;
		
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
	    //System.out.println(readFromFile("schedule.txt"));
	    List<String> text = readFromFile("schedule.txt");
	    
	    for (String s : text){
	    	StringTokenizer tokenizer = new StringTokenizer(s);
	    	System.out.println(s);
	    	while (tokenizer.hasMoreElements()){
	    		Integer pri = Integer.parseInt(tokenizer.nextElement().toString());
	    		String msg = tokenizer.nextElement().toString();
	    		System.out.println("Pri: "+ pri + " MSG: " + msg);
	    		
	    		Hashtable table = new Hashtable();
	    		table.put(pri, msg);
	    		
	    	}
	    }
	    
//		while( (str = text.readLine()) ){
//			
//		}
	}

}
