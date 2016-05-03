

//TODO ADD A FILE REFERENCE 
public class kgram {
	private int Hash;
	private String k;
	public int position;
	private static int kgramlen=10;
	public kgram(){//Default constructor
		k="";
		setPosition(-1);
	}/*
	constructor 
	@param foo string of the document text
	@param pos position of the kgram in the document
	
	*/
	public kgram(String foo, int pos){
		setPosition(pos);
		k = foo.substring(pos,pos+kgramlen);
		Hash = -1;
	}
	public kgram(String foo, int pos, int kgramlen){//Parameterized constructor
		setPosition(pos);
		kgram.kgramlen = kgramlen;
		k = foo.substring(pos,pos+kgram.kgramlen);
	}
	public int getK(){
		return kgramlen;
	}
	@Override
	public String toString(){
		return k; 
	}
	@Override
	public int hashCode(/*kgram prev*/){
		int hash=0;
		int b = 5;
		int ka = k.length();
		//if(position==0){
			for (int i =0;i<ka;i++)
				hash+=k.charAt(i)*Math.pow(b,ka-i-1);
			Hash = hash;
		//}
		//else{
		//	hash=(int) ((prev.Hash-prev.k.charAt(0)*Math.pow(b, ka-1))+b*k.charAt(ka));
		//}
		return hash;
	}
	@Override
	public boolean equals(Object o){//Override Equals for the hash function
		if(o instanceof kgram){
			kgram temp = (kgram) o;
			return(this.k.equals(temp.k));
		}
		else
			return false;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
}
