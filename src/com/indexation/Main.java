package com.indexation;

import java.io.IOException;

public class Main {
	
	public Main() {}
	
	public void launch() {
		Document d = new Document();
		Query q = new Query();
		Work w = new Work(q, d);
		
		d.fileRoot();
		q.getQuery();
		q.compute();
		try {
			d.extractWords();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		Main main = new Main();
		main.launch();
	}

}
