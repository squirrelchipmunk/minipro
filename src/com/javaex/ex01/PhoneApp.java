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
		PhoneDBManager.initPhoneDB(pList, br);
		PhoneView.viewStart();
		
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;	
		while(repeat) {
			PhoneView.viewMenu();
			
			String menuNo = sc.nextLine();
			switch(menuNo) {
				case "1" :
					PhoneView.printPerson(pList);
					break;
				case "2" : 
					PhoneDBManager.insertPerson(pList);
					break;
					
				case "3" : 
					PhoneDBManager.deletePerson(pList);
					break;
					
				case "4" : 
					PhoneView.searchPerson(pList);
					break;
					
				case "5" : 
					repeat = false;
					break;
					
				default : System.out.println("[다시 입력해 주세요.]");
			}
		}
		PhoneView.viewEnd();
		
		
		br.close();
		sc.close();
		
	}

	
	
	
	
	
	
	
	
}
