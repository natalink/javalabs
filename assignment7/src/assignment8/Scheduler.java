package assignment8;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Scheduler {

	static Hashtable<Integer, String> table;
	
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
	
	static List<String> list_table = new ArrayList<String>(); 
	private static void listPriorities() {
		
		System.out.println(table);
		
		for (Object key: table.keySet().toArray()) {
			Object value = table.get(key);
			String priormessage = key + ":" + value;
			list_table.add(priormessage);
		} 
		System.out.println(list_table);
	} 
	
	
	private static void priorIncreasingly(){
		System.out.println("Increasingly priority sort: ");
		List<Integer>keys =  new ArrayList<>(table.keySet());
		Collections.sort(keys);		
		for(Integer key: keys) {
			Object value = table.get(key);
			System.out.println("Priority: " + key + " Message: " + value);

		} 
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(args[0]);
		table = new Hashtable<Integer, String>();		
	    List<String> text = readFromFile("schedule.txt");
	    
	    for (String s : text){
	    	StringTokenizer tokenizer = new StringTokenizer(s, ":"); 
	    	
	    	while (tokenizer.hasMoreElements()){
	    		Integer pri = Integer.parseInt(tokenizer.nextElement().toString());
	    		String msg = tokenizer.nextElement().toString();
	    		table.put(pri, msg);
	    		
	    	} 
	    }
	    if(args[0].equals("-a")) { 
	    	int prior = Integer.parseInt(args[1]);
	    	String msg = args[2];
	    	if (table.containsKey(prior)){
	    		System.out.println("This priority is already in the file: " + prior + "Can't add it");
	    		
	        }
	    	else{
	    		String filename = "schedule.txt";
	    		FileWriter fw = new FileWriter(filename, true);
	    		System.out.println("adding priority "+ prior+ ", message: " + msg+ " To the file: " + filename);
	    		fw.write(prior + ":" + msg);
	    		fw.close();
	    	}
	    
	    }
	    if(args[0].equals("-l")) {
	    	System.out.println("Next is the list of messages and their priorities: ");
	    	listPriorities();
	    }
	    if(args[0].equals("-r")) {
	    	priorIncreasingly();
	    }
	    if(args[0].equals("-d")) {
	    	File inFile = new File("schedule.txt");
	    	File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
	    	PrintWriter printwriter = new PrintWriter(new FileWriter(tempFile));
	    	Scanner in = new Scanner(System.in);
	    	System.out.println("Next is the list of messages and their priorities: ");
	        listPriorities();
	    	for (int i=1; i< table.size(); i++){
	    		System.out.println(i + "--->" + list_table.get(i));
	    	}
	        System.out.println("Please, spicify the number you wannna delete: ");
	        int j = in.nextInt();
	        System.out.println("U are about to delete " + list_table.get(j) );
	        System.out.println("The newfile will contain only: ");
	        for (int i = 1; i < table.size() ; i++){
	        	if (i != j){
	        		System.out.println(list_table.get(i));
	        		table.remove(table.get(i));
	        		printwriter.println(list_table.get(i));
	        	}
	        }
	        printwriter.flush();
	        printwriter.close();
	        System.out.println("TABLE WITHOUT THE CHOSEN PRIORITY:" + table);
	        System.out.println("Success. You can find the changed data here: " + tempFile);
	     }
	        
	        
	}
}