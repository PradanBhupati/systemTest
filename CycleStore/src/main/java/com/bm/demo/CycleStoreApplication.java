package com.bm.demo;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bm.factory.CycleFactory;

@SpringBootApplication
public class CycleStoreApplication {
 static int size=5;
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(CycleStoreApplication.class, args);
		List<String> comp = systemInput();
		String date = datePicker();
		comp.add(5,date);
		process(comp);
	}

	//to process the user defiend value and generate receipt
	public static void process(List<String> comp) throws ParseException {
		CycleFactory factory=null;
		factory.assembleyFactory(comp);
	}

	//to insert componenet details in console
	public static List<String> systemInput(){
		Scanner scn=new Scanner(System.in);
		System.out.println("Choose Components for Cycle Assembley");
		List<String> comp=new ArrayList<String>();
		System.out.println("Choose Frame Type:{Steel, Aluminium, Carbonfiber}");
		comp.add(0,scn.nextLine());
		//		do {
		//			System.out.println("Choose Frame Type:{Steel, Aluminium, Carbonfiber}");
		//			comp.add(0,scn.nextLine());
		//		} while (!comp.get(0).equalsIgnoreCase("Steel"));
		System.out.println("Choose Handel-Bar Type:{NormalBreak,DiscBreak, 4Gear(with disc break),6Gear(with disc break)}");
		comp.add(1,scn.nextLine());
		System.out.println("Choose Seating Type:{Plastic, Foam, Leather }");
		comp.add(2,scn.nextLine());
		System.out.println("Choose Wheel Type:{Plain(Regular tyer), Tubeless}");
		comp.add(3,scn.nextLine());
		System.out.println("Choose Chain Type:{Steel(Regular Chain),AntiJunk}");
		comp.add(4,scn.nextLine());
		return comp;

	}
	//to insert date of purchase in console
	public static String datePicker() throws ParseException {
		Scanner scn=new Scanner(System.in);
		//Enter Date of purchase
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		System.out.println("Enter DAte OF purchase in dd/MM/yyyy format:");
//		Date date = formatter.parse(scn.nextLine());
		String date=scn.nextLine();
		return date;
	}
	
	

}
