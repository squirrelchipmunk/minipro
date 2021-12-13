package com.javaex.ex01;

import java.util.List;
import java.util.Scanner;

public class PhoneView {

	public static void viewStart() {
		System.out.println("****************************************");
		System.out.println("*          전화번호 관리 프로그램            *");
		System.out.println("****************************************");
	}
	
	public static void viewMenu() {
		System.out.println("\n1.리스트\t2.등록\t3.삭제\t4.검색\t5.종료");
		System.out.println("------------------------------------");
		System.out.print(">메뉴번호: ");
	}
	
	public static void viewEnd() {
		System.out.println("\n****************************************");
		System.out.println("*               감사합니다                *");
		System.out.println("****************************************");
	}
	
	
	
	// 전체 Person 출력
	public static void printPerson(List<Person> pList) {
		System.out.println("<1.리스트>");
		for(int i=0;i<pList.size();i++) {
			System.out.print((i+1));
			pList.get(i).showInfo();
		}
	}
	
	// 키워드를 포함하는 Person 출력
	public static void searchPerson(List<Person> pList) {
		Scanner sc = new Scanner(System.in);
		System.out.println("<4.검색>");
		System.out.print("이름: ");
		String keyword = sc.nextLine();
		
		for(int i=0;i<pList.size();i++) {
			if(pList.get(i).getName().contains(keyword)) {
				System.out.print((i+1));
				pList.get(i).showInfo();
			}
		}
		
	}
	


}
