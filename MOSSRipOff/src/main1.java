import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//TODO Everything
//controls execution, creates fileinput objects, processes them and stores in a dictionary object
//reads a special document called metadata
public class main1 {

	public static void main(String[] args) {
	    	fileinput data = new fileinput();
		List<String> foo = new ArrayList<String>();
		List<String> foo1 = new ArrayList<String>();
		
		foo = data.get_formatedcode("../test_code/selectionsort.cpp");
		
		
		StringBuilder temp = new StringBuilder();
		for (String s: foo)
			temp.append(s);
		System.out.println(temp);
		
		//foo1 = data.get_formatedcode("../test_code/SwapFandV.c");
		//foo1 = data.get_formatedcode("../test_code/varchanged.c");
		foo1 = data.get_formatedcode("../test_code/selectionsortone.cpp");
		//foo1 = data.get_formatedcode("../test_code/linear.c");
		StringBuilder temp1 = new StringBuilder();
		for (String s: foo1)
			temp1.append(s);
		
		//System.out.println(temp);
		//System.out.println(temp1);
		//System.out.println(temp.toString().length());
		Kgram_Array herpaderp = new Kgram_Array(temp.toString());
		Kgram_Array herpaderp1 = new Kgram_Array(temp1.toString());
		System.out.println("number of kgrams "+herpaderp.getSize());
		herpaderp.printarray();
		System.out.println("number of kgrams second"+herpaderp1.getSize());
		//herpaderp1.printarray();
	
		Hashtable doc= new Hashtable<Integer, kgram>();
		for(int i=0;i<herpaderp.getSize();i++){
			if(doc.put(herpaderp.getKgram(i), herpaderp.getKgram(i))!=null);
				//System.out.println("hello");
		}
		double count=0;
		for(int i=0;i<herpaderp1.getSize();i++){
			if(doc.put(herpaderp1.getKgram(i), herpaderp1.getKgram(i))!=null)
				//System.out.println("cheater");
				count++;
		}
		//Populate Hash Table with First Document Code Hashes
		System.out.println(count/herpaderp1.getSize());
		System.out.println(doc.size());
		
		
		
		
		
		
		
		
		
		//herpaderp.printsize();
		//print
		//for(int i = 0;i<foo.size();i++)
		  //  System.out.println(foo.get(i));
	}

}
