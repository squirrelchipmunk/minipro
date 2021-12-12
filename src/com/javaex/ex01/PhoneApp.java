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
		Scanner sc = new Scanner(System.in);
		Reader fr = new FileReader("C:\\javaStudy\\minipro\\phoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		List<Person> pList = new ArrayList<>();
		
		while(true) {	//PhoneDB 시작 상태로 pList 초기화
			String line = br.readLine();		
			if(line == null) 
				break;
			addPerson(line, pList);
		}
		
		System.out.println("****************************************");
		System.out.println("*          전화번호 관리 프로그램            *");
		System.out.println("****************************************");
		
		boolean repeat = true;	// 프로그램 종료 조건
		
		while(repeat) {
			System.out.println("\n1.리스트\t2.등록\t3.삭제\t4.검색\t5.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호: ");
			String menuNo = sc.nextLine();
			
			switch(menuNo) {
				case "1" :
					System.out.println("<1.리스트>");
					printPerson(pList);
					break;
					
				case "2" : 
					System.out.println("<2.등록>");
					System.out.print(">이름: ");
					String name=sc.nextLine();
					System.out.print(">휴대전화: ");
					String phone=sc.nextLine();
					System.out.print(">회사전화: ");
					String company=sc.nextLine();
					String line = name+","+phone+","+company;
					
					addPerson(line, pList);
					writeDB(pList);
					System.out.println("[등록되었습니다.]");
					break;
					
				case "3" : 
					System.out.println("<3.삭제>");
					System.out.print(">번호 : ");
					int no = Integer.parseInt(sc.nextLine())-1;
					
					pList.remove(no);
					writeDB(pList);
					System.out.println("[삭제되었습니다.]");
					break;
					
				case "4" : 
					System.out.println("<4.검색>");
					System.out.print("이름: ");
					String keyword = sc.nextLine();
					
					printPerson(pList, keyword);
					break;
					
				case "5" : 
					repeat = false;
					break;
					
				default : System.out.println("[다시 입력해 주세요.]");
			}
		}
		
		System.out.println("****************************************");
		System.out.println("*               감사합니다                *");
		System.out.println("****************************************");
		
		br.close();
		sc.close();
		
	}

	// 문자열에서 정보를 추출하여 pList에 Person 추가
	public static void addPerson(String line, List<Person> pList) {			
		String [] pArr= line.split(",");
		String name = pArr[0];
		String hp = pArr[1];
		String company = pArr[2];
		
		Person p = new Person(name, hp, company);
		pList.add(p);
	}
	
	// PhoneDB 갱신
	public static void writeDB(List<Person> pList) throws IOException {		
		Writer fw = new FileWriter("C:\\javaStudy\\minipro\\phoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Person p : pList) {
			bw.write( p.getName()+","+p.getHp()+","+p.getCompany() );
			bw.newLine();
		}
		bw.close();
	}
	
	// 전체 Person 출력
	public static void printPerson(List<Person> pList) {					
		for(int i=0;i<pList.size();i++) {
			System.out.print((i+1));
			pList.get(i).showInfo();
		}
	}
	
	// 키워드를 포함하는 Person 출력
	public static void printPerson(List<Person> pList, String keyword) {	
		for(int i=0;i<pList.size();i++) {
			if(pList.get(i).getName().contains(keyword)) {
				System.out.print((i+1));
				pList.get(i).showInfo();
			}
		}
	}
	
}
