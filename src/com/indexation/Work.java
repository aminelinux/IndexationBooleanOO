package com.indexation;

import java.util.ArrayList;

public class Work {
	
	Query q;
	Document d;
	
	public Work(Query q,Document d) {
		this.q = q;
		this.d = d;
	}
	/**
	 * search for the key in the list of word given as parameter
	 * 
	 * @param ListOfwantedKey type Query 
	 */
	
	public void KeyInDocument(Query ListOfwantedKey) {
		System.out.println("");
		//Occurrence in map from text file
		int occ = 0;
		//String wkey = "";
		for(String wantedKey : ListOfwantedKey.getQ()) {
			// l mapping throw a map of key in  a file by saving  occ
			for(int i = 0;i<ListOfwantedKey.getQ().size();i++) {
				//if key in the txt file print the key and occ 
				//add 
				if(d.getKey().get(i).containsKey(wantedKey)) {
					System.out.print(wantedKey + "            ");
					
					System.out.println(d.getKey().get(i).get(wantedKey));
					occ = d.getKey().get(i).get(wantedKey);
					keyOcc.add(occ);
					//wkey = wantedKey;
				}else {
					System.out.print(wantedKey + "            ");
					System.out.println("0");
				}
			}
		}
	}
	
	
}
