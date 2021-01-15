package wordCount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class WordCounter {

	public static void main(String[] args) throws 
	 FileNotFoundException ,IOException{
		
		FileInputStream fl = new FileInputStream("readwords.txt");
		Scanner fileInput = new Scanner(fl);
		
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer>count = new ArrayList<Integer>();
		while(fileInput.hasNext()) {
			String next=fileInput.next();
			if(words.contains(next)) {
				int idx = words.indexOf(next);
				count.set(idx, count.get(idx)+1);
			}else {
				words.add(next);
				count.add(1);
			}
		}
		
		fileInput.close();
		fl.close();
		
		for(int i=0; i< words.size(); i++) {
			System.out.println(words.get(i) +"occurred"+count.get(i)+"times");
		}
	}

}
