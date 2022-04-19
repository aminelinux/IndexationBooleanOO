package com.indexation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Document {
	
	private File file;
	private FileInputStream input;
	private InputStreamReader isReader;
	private BufferedReader reader;
	private StringBuffer sb;
	private String str;
	private String[] words;
	private ArrayList<String> root = new ArrayList<>() ;
	private Map<String,Integer> key = new HashMap<>();
	private ArrayList<Map<String,Integer>> l = new ArrayList<Map<String,Integer>>();
	private Map<Map<String,Integer>,String> docName = new HashMap<>();
	private Scanner sc;
	/**
	 * Constructor
	 */
	public Document() {}
	
	
	
	private File getFile() {
		return file;
	}



	private void setFile(File file) {
		this.file = file;
	}



	private FileInputStream getInput() {
		return input;
	}



	private void setInput(FileInputStream input) {
		this.input = input;
	}



	private InputStreamReader getIsReader() {
		return isReader;
	}



	private void setIsReader(InputStreamReader isReader) {
		this.isReader = isReader;
	}



	private BufferedReader getReader() {
		return reader;
	}



	private void setReader(BufferedReader reader) {
		this.reader = reader;
	}



	private StringBuffer getSb() {
		return sb;
	}



	private void setSb(StringBuffer sb) {
		this.sb = sb;
	}



	private String getStr() {
		return str;
	}



	private void setStr(String str) {
		this.str = str;
	}



	private String[] getWords() {
		return words;
	}



	private void setWords(String[] words) {
		this.words = words;
	}



	private ArrayList<String> getRoot() {
		return root;
	}



	private void setRoot(ArrayList<String> root) {
		this.root = root;
	}



	public Map<String, Integer> getKey() {
		return key;
	}



	private Map<Map<String, Integer>, String> getDocName() {
		return docName;
	}



	private void setDocName(Map<Map<String, Integer>, String> docName) {
		this.docName = docName;
	}



	private Scanner getSc() {
		return sc;
	}



	private void setSc(Scanner sc) {
		this.sc = sc;
	}


	/**
	 * save the root of files that are needed to index as a string 
	 */
	public void fileRoot() {
		sc = new Scanner(System.in);
		boolean t=true;
		System.out.println("Donner le cible du document txt sinon Tapez q pour quitter");
		while(t) {
			if(sc.hasNext()) {
					String str = sc.next();
					if(!str.equals("q")) {
						//add the root String to the root ArrayList
						root.add(str);
						System.out.println("Donner le cible du document txt sinon Tapez q pour quitter");
					}
					else {
						t=false;	
						System.out.println(root.size() + " On etait ajouter avec succes");
					}
			}
		}
	}
	/**
	 * get the file to memory throught File inputstream to work on them
	 * @param i
	 * @throws IOException
	 */
	private void getFileToString(String i) throws IOException {
			//get file from i location
			file = new File(i);
			try {
				//Creates a FileInputStream by opening a connection to an actual file
				input = new FileInputStream(this.getFile());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Creates an InputStreamReader that uses the default charset.
			isReader = new InputStreamReader(this.getInput());
			//Creates a buffering character-input stream that uses a default-sizedinput buffer.
			reader = new BufferedReader(this.getIsReader());
			sb = new StringBuffer();
			str = new String();
			while((str = this.getReader().readLine()) != null) {
				sb.append(this.getStr());
			}			
	}
	/**
	 * word extraction from a specific Document
	 * @throws IOException
	 */
	public void extractWords() throws IOException {
		//loop through ArrayList of file location
		for(String x : root) {
			getFileToString(x);
			System.out.println(x);
		// get string to table of strings with specific regex
		words = this.getSb().toString().split("[^A-Za-z0-9]");
		//word to get occ
		for(String w : this.getWords()) {
			int occ =0;
			//if the words is already processed go to next iteration
			if(this.getKey().containsKey(w)) continue;
			for(String wc : words) {
				//if w equals to wc occ ++
				occ++;				
			}
			this.getKey().put(w, occ);
			System.out.println(this.getKey().size());
		}
		//add file to a hashMap Vector and init the old hashMap for next file
		
		this.getDocName().put(key, x);
		System.out.println(this.getDocName().size());
		key = new HashMap<>();
		}
	}
	
}
