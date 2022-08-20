package com.example.demo;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class WordService {
	
	public String getArrayFormString(int grid,String words[]) {
		
		char[][] arr=new char[grid][grid];
	     for(int i=0;i<grid;i++) {
	    	 for(int j=0;j<grid;j++) {
	    		 arr[i][j]='*';
	    	 }
	     }
	     
	     for(String word : words) {
	    	 fill1(arr,word);
	     }
	     
	    String toReturn=""; 
	     for(int i=0;i<grid;i++) {
	    	 for(int j=0;j<grid;j++) {
	    		 toReturn=toReturn+arr[i][j];
	    	 }
	    	 toReturn+="\r\n";
	     } 
		
	     return toReturn;
	}
	
	public static void fill1(char[][] arr , String word) {
		int index[]= provideIndex(arr);
		String start="fillVerticalLtR";
		  switch(start) {
		  case "fillVerticalLtR":
			 boolean result = fillHorizontalLtR(arr,index,word);
			 if(result) {
				 break;
			 }
		  case "fillVerticalRtL":
			  result = fillHorizontalRtL(arr,index,word);
			 if(result) {
			   break;
			  }
			 
		  case "fillVerticalTopToBottm":
			  result = fillVerticalTopToBottm(arr,index,word);
			 if(result) {
			   break;
			  }
			 
		  case "fillVerticalBottomToTop":
			  result = fillVerticalBottomToTop(arr,index,word);
			   break;
			  
		  }
		
	}
	
	private static boolean fillHorizontalRtL(char[][] arr, int[] index, String word) {
		boolean made = true;
		int X = index[0];
		int Y = index[1];
		int count=1;
		int indexlenghtAvaliable= Y-(word.length()-1);
		if(indexlenghtAvaliable<0) {
			made=false;
			return made;
		}
		for(int i=Y;count<=word.length() && i>=0 ;i--) {
			if(arr[X][i]!='*'){
				made = false;
				break;
			}
			count++;
		}
		if(!made) {
			return false;
		}else {
			for (char ch : word.toCharArray()) {
				arr[X][Y] = ch;
				Y--;
			}	
		}

		return made;
			
	}

	public static boolean fillHorizontalLtR(char[][] arr, int index[], String word) {
		boolean made = true;
		int X = index[0];
		int Y = index[1];
		System.out.println(X+"-"+Y);
		int indexlenghtAvaliable= Y+(word.length()-1);
		if(indexlenghtAvaliable>arr.length-1) {
			made=false;
			return made;
		}
		for(int i=Y;i<word.length() && i<arr.length ;i++) {
			if(arr[X][i]!='*'){
				made = false;
				break;
			}
		}
		if(!made) {
			return false;
		}else {
			for (char ch : word.toCharArray()) {
				arr[X][Y] = ch;
				Y++;
			}	
		}

		return made;
	}
	
	
	public static boolean fillVerticalTopToBottm(char[][] arr, int index[], String word) {
		boolean made = true;
		int X = index[0];
		int Y = index[1];
		System.out.println(X+"-"+Y);
		int indexlenghtAvaliable= X+(word.length()-1);
		if(indexlenghtAvaliable>arr.length-1) {
			made=false;
			return made;
		}
		for(int i=Y;i<word.length() && i<arr.length ;i++) {
			if(arr[X][i]!='*'){
				made = false;
				break;
			}
		}
		if(!made) {
			return false;
		}else {
			for (char ch : word.toCharArray()) {
				arr[X][Y] = ch;
				X++;
			}	
		}

		return made;
	}
	
	public static boolean fillVerticalBottomToTop(char[][] arr, int index[], String word) {
		boolean made = true;
		int X = index[0];
		int Y = index[1];
		System.out.println(X+"-"+Y);
		int indexlenghtAvaliable= X-(word.length()-1);
		if(indexlenghtAvaliable<0) {
			made=false;
			return made;
		}
		for(int i=Y;i<word.length() && i<arr.length ;i++) {
			if(arr[X][i]!='*'){
				made = false;
				break;
			}
		}
		if(!made) {
			return false;
		}else {
			for (char ch : word.toCharArray()) {
				arr[X][Y] = ch;
				X++;
			}	
		}

		return made;
	}
	
	public static void print(char[][] arr) {
		for(int i=0;i<6;i++) {
	    	 for(int j=0;j<6;j++) {
	    		 System.out.print(arr[i][j]);
	    	 }
	    	 System.out.println();
	     }
	}
	
	
	public static int[] provideIndex(char[][] arr) {
		Random rand= new Random();
		int index[]= new int[2];
		int X = rand.nextInt(6);
		int Y = rand.nextInt(6);
			if(arr[X][Y] !='*') {
				provideIndex(arr);
			}else {
				index[0]=X;
				index[1]=Y;
				return index;
			}
			return index;
	}
	

}
