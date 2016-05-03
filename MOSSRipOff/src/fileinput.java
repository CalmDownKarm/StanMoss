//takes a file as input, selects kgrams and hashes them

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class fileinput {
    
    private List<String> raw_data = new ArrayList<String>();
    private List<String> keywords = new ArrayList<String>(Arrays.asList("main","cout","cin","endl","std","auto","break","case","char","const","continue","default","do","double","else","enum","extern","float","for","goto","if","int","long","register","return","short","signed","sizeof","static","struct","switch","typedef","union","unsigned","void","volatile","while","asm","bool","catch","class","const_cast","delete","dynamic_cast","explicit","false","friend","inline","mutable","namespace","new","operator","private","protected","public","reinterpret_cast","static_cast","template","this","throw","true","try","typeid","typename","virtual","using","wchar_t","include","define","undef","if","ifdef","ifndef","error","__FILE__","__LINE__","__DATE__","__TIME__","__TIMESTAMP__","pragma","macro operator","macro operator"));
    private List<Character> symbols = Arrays.asList(new Character[]{'#','{','}','(',')','[',']',';','*','<','>','=','&',',','+','-','/','!','%','.','?',':','^'});
    private static List<Integer> positions = new ArrayList<Integer>();
    
    
    private void read_file(String file_address){
        try{
	    String line = null;
	    InputStream raw_file = new FileInputStream(file_address);
	    BufferedReader line_reader = new BufferedReader(new InputStreamReader(raw_file));
	    while ((line = line_reader.readLine()) != null)
		raw_data.add(line);  
	    raw_file.close();
	   }catch(IOException e){
	      System.out.print("File not found");
	   }
    }
    
    public List<String> get_formatedcode(String file_address){
    	raw_data.clear();
    	read_file(file_address);
    	remove_comments();
    	remove_blank_lines();
    	identify_keywords();
    	formate_code();
    	replace_identifires();
    	remove_whitespaces();
    	return raw_data;
    }
    
    public void remove_whitespaces(){
	//remove whitespace
    	for(int j = 0;j<raw_data.size();j++)
    		raw_data.set(j, raw_data.get(j).replaceAll("\\s+",""));
    }
    
    public void remove_blank_lines(){
	//remove blank lines
    	for(int j = 0;j<raw_data.size();j++){
    		if(raw_data.get(j).trim().isEmpty()){
    			raw_data.remove(j--);
    		}
    	}
    }
    
    public void remove_comments(){
	//single line comments
    	for(int i = 0; i<raw_data.size();i++){
    		if(raw_data.get(i).contains("//"))
    			raw_data.set(i,raw_data.get(i).replace(raw_data.get(i).substring(raw_data.get(i).indexOf("//")),""));	
    	}
	
	//multiline comments
    	for(int i = 0; i<raw_data.size();i++){
    		if(raw_data.get(i).contains("/*")){
    			if(raw_data.get(i).contains("*/"))
    				raw_data.set(i,raw_data.get(i).replace(raw_data.get(i).substring(raw_data.get(i).indexOf("/*"),raw_data.get(i).indexOf("*/")+2),""));
    			else
    			{
    				raw_data.set(i,raw_data.get(i).replace(raw_data.get(i).substring(raw_data.get(i).indexOf("/*")),""));
    				int temp = i+1;
    				while(!raw_data.get(temp).contains("*/")){
    					raw_data.remove(temp);
    				}
    				raw_data.set(temp,raw_data.get(temp).replace(raw_data.get(temp).substring(0,raw_data.get(temp).indexOf("*/")+2),""));
    			}
    		}
    	}
    }
    
    public void identify_keywords(){
	// identify name of classes and structures
	for(int i = 0; i<raw_data.size();i++){
	    if(raw_data.get(i).contains("class")){
		if(raw_data.get(i).contains("{"))
		    keywords.add(raw_data.get(i).substring(raw_data.get(i).indexOf("class")+5, raw_data.get(i).indexOf("{")));
		else
		    keywords.add(raw_data.get(i).substring(raw_data.get(i).indexOf("class")+5));
	    }
	    if(raw_data.get(i).contains("struct")){
		if(raw_data.get(i).contains("{"))
		    keywords.add(raw_data.get(i).substring(raw_data.get(i).indexOf("struct")+6, raw_data.get(i).indexOf("{")));
		else
		    keywords.add(raw_data.get(i).substring(raw_data.get(i).indexOf("struct")+6));
	    }
	}
	
	
	//remove white spaces 
	for(int i =0 ;i<keywords.size();i++)
	    keywords.set(i, keywords.get(i).replaceAll("\\s+",""));	
    }
    
    public void formate_code(){
	//adding spaces before and after symbols
	int index;
	Boolean temp;
	
	for(int i=0;i<raw_data.size();i++){
	    temp = position_of_symbols(raw_data.get(i),symbols);
	    if(temp){
		Collections.sort(positions);
		for(int j=0; j<positions.size();j++){
		    index = positions.get(j); 
		    raw_data.set(i,raw_data.get(i).substring(0,index)+" "+raw_data.get(i).charAt(index)+" "+raw_data.get(i).substring(index+1));
		    for(int k = j+1 ; k<positions.size();k++){
			positions.set(k, positions.get(k)+2);
		    }
		}
	    } 
	}
	
	for(int i=0;i<raw_data.size();i++){
	    if(raw_data.get(i).contains("\"")){
		String[] temp1 = raw_data.get(i).split("\"");
		temp1[1]=temp1[1].replaceAll("\\s+","");
		temp1[1]="\""+temp1[1]+"\"";
		raw_data.set(i,Arrays.toString(temp1));
		raw_data.set(i,raw_data.get(i).substring(1, raw_data.get(i).length()-1).replaceAll(",", ""));
	    }
	}
	
    }
    
    public void replace_identifires(){
	for(int i=0; i<raw_data.size();i++){
	    String[] temp = raw_data.get(i).split(" ");
	    String join = "";
	    for(int j=0;j<temp.length;j++){
		if(!(temp[j].equals(" ") || temp[j].equals(""))){
		    if(stringContainsStringFromList(temp[j],keywords))
			continue;
		    else
		    {
			if(temp[j].charAt(0)=='"' && temp[j].charAt(temp[j].length()-1)=='"' || temp[j].charAt(0)=='\'' && temp[j].charAt(temp[j].length()-1)=='\'')
			    continue;
			else{
			    if(stringContainscharacterFromList(temp[j],symbols))
				continue;
			    else{
				temp[j] = "V";
			    }
			}
		    }
		}
	    }
	    for(int j=0;j<temp.length;j++){
		join = join + temp[j];
	    }
	    raw_data.set(i,join);
	}
    }
    
    private boolean stringContainscharacterFromList(String inputString, List<Character> items) {
	for(int i=0 ; i<items.size();i++){
	    if(inputString.length()>1)
		return false;
	    else{
		if(inputString.charAt(0)==items.get(i))
		    return true;
	    }	
	}
	return false;
    }

    private static Boolean stringContainsStringFromList(String inputString, List<String> items){
	for(int i=0 ; i<items.size();i++){
	    if(inputString.equals(items.get(i)))
		return true;
	}
	return false;
    }
      
    
    
    private static Boolean position_of_symbols(String inputString, List<Character> items)
    {
        positions.clear();
    	for(int i =0; i < items.size(); i++)
        {	
            for(int j=0;j<inputString.length();j++){
        	if(inputString.charAt(j) == items.get(i))
                {
            		positions.add(j);
                }
            }
    	    
        }
        if(positions.isEmpty())
            return false;
        else
            return true;
    }
    
}
