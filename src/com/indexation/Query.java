package com.indexation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Query {
	private String s = "";
	private String[] q;
	private StringBuffer isSB;
	private Scanner sc;
	private ArrayList<String> qList; 
	
	public Query() {}
	
	private String getS() {
		return s;
	}

	public ArrayList<String> getQ() {
		return qList;
	}


	private StringBuffer getIsSB() {
		return isSB;
	}

	//get the string given by the user 
	public void getQuery() {
		sc = new Scanner(System.in);
		System.out.println("Donner à chercher");
		if(sc.hasNextLine()) {
			s=sc.nextLine();
		}
		//System.out.println("query");
		//System.out.println(s);
	}
	//transform from immutable to mutable
	public void compute() {
		isSB.append(s);
		q = getIsSB().toString().split("\\s");
		qList = new ArrayList<String>(Arrays.asList(s));
		
		
	}
}