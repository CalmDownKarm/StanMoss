import java.util.ArrayList;
import java.util.Hashtable;

public class Kgram_Array {
	private ArrayList<kgram> list = new ArrayList<kgram>();
	final private int kgramlen = 10; 
	/*
	 *constructor that creates kgrams from the document
	 *@param foo string concatenated string which contains the document text 
	 */
	public Kgram_Array(String foo){
		for(int i=0;i<foo.length()-kgramlen;i++){
			kgram temp = new kgram(foo,i,kgramlen);
			list.add(temp);
		}
			
	}
	public void printarray(){
		for(int i = 0;i<list.size();i++)
			System.out.println(list.get(i));
	}
	public int getSize(){
		return list.size();
	}
	public kgram getKgram(int index){
		return list.get(index);
	}
	
}


