package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		Reader fr = new FileReader("C:\\javaStudy\\file\\phoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		List<Person> pList = new ArrayList<>();
		PhoneDBManager phoneDBManager = new PhoneDBManager();
		PhoneView phoneView = new PhoneView();
		
		phoneDBManager.initPersonList(pList, br);
		phoneView.viewStart();
		
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;	
		while(repeat) {
			phoneView.viewMenu();
			String menuNo = sc.nextLine();
			
			switch(menuNo) {
				case "1" :
					phoneView.printPerson(pList);
					break;
				case "2" : 
					phoneDBManager.insertPerson(pList);
					break;
					
				case "3" : 
					phoneDBManager.deletePerson(pList);
					break;
					
				case "4" : 
					phoneView.searchPerson(pList);
					break;
					
				case "5" : 
					repeat = false;
					break;
					
				default : System.out.println("[다시 입력해 주세요.]");
				
			}
		}
		phoneView.viewEnd();
		
		
		br.close();
		sc.close();
		
	}

	
	
	
	
	
	
	
	
}
