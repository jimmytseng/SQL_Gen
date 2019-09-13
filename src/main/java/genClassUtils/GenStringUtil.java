package genClassUtils;

public class GenStringUtil {
    public static String firstToUpper(String originText){
    	int len = originText.length();
    	String s = "";
    	if(len<1){
    		throw new IllegalArgumentException();   	
    	}else{
    		if(!originText.substring(0, 1).matches("[a-zA-Z]"))
    		throw new IllegalArgumentException();  
    		s = originText.toUpperCase().charAt(0) + originText.substring(1);
    	}
    	return s;
    }
    
    public static String firstToLower(String originText){
    	int len = originText.length();
    	String s = "";
    	if(len<1){
    		throw new IllegalArgumentException();   	
    	}else{
    		if(!originText.substring(0, 1).matches("[a-zA-Z]"))
    		throw new IllegalArgumentException();  
    		s = originText.toLowerCase().charAt(0) + originText.substring(1);
    	}
    	return s;
    }
    
    
    public static void main(String args[]){
    	String temp = "a";
    	System.out.println(GenStringUtil.firstToUpper(temp));	
    }
}
