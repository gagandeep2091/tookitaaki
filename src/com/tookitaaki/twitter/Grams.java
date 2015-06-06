package com.tookitaaki.twitter;
import java.util.*;

public class Grams {
	
	private static Map<String,Integer> bigms = new HashMap<> (); 
	private static Map<String,Integer> trigms = new HashMap<> (); 
	
	public static String[] bigram(String s){
		String[] ss = s.split("\\s+");
		String[] bigrams = new String[ss.length-1];
		for(int i=1; i<ss.length ; i++)
		{
			bigrams[i-1]= ss[i-1] + " " + ss[i];
			String temp= bigrams[i-1];
			if(bigms.get(temp)==0){
				bigms.put(temp,1);
			}
			else
			bigms.put(temp,bigms.get(temp)+1);
		}
		return bigrams;
	}
	public static String[] trigram(String s){
		String[] ss = s.split("[\\s+\\.]");
		String[] trigrams = new String[ss.length-2];
		for(int i=2; i<ss.length ; i++)
		{
			trigrams[i-2]= ss[i-2] + " " + ss[i-1]+" " + ss[i];
			String temp= trigrams[i-1];
			if(trigms.get(temp)==0){
				trigms.put(temp,1);
			}
			else
				trigms.put(temp,bigms.get(temp)+1);
		}
		return trigrams;
		
	}
	
	
	
}
