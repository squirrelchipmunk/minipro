package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

public class PhoneDBManager {

		public static void initPhoneDB(List<Person> pList ,BufferedReader br) throws IOException {
			while(true) {	//PhoneDB 시작 상태로 pList 초기화
				String line = br.readLine();		
				if(line == null) 
					break;
				addPerson(line, pList);
			}
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
			Writer fw = new FileWriter("C:\\javaStudy\\file\\phoneDB.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for(Person p : pList) {
				bw.write( p.getName()+","+p.getHp()+","+p.getCompany() );
				bw.newLine();
			}
			bw.close();
		}
	
		public static void insertPerson(List<Person> pList) throws IOException {
			Scanner sc = new Scanner(System.in);	
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
		}
		
		public static void deletePerson(List<Person> pList) throws IOException {
			Scanner sc = new Scanner(System.in);	
			System.out.println("<3.삭제>");
			System.out.print(">번호 : ");
			int no = Integer.parseInt(sc.nextLine())-1;
			
			pList.remove(no);
			writeDB(pList);
			System.out.println("[삭제되었습니다.]");
		}
}
