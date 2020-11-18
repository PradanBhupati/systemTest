package com.bm.demo;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CycleStoreApplicationTests {
	private static CycleStoreApplication cyc=null;
	//to initialise object creation which is required for every test method
	@BeforeClass
	public static void init() {
		cyc=new CycleStoreApplication();
	}
	//test for price change on offer date
		@Test
	void test1() throws ParseException {
		List<String> comp = new ArrayList<String>();
		comp.add("steel");
		comp.add("normal");
		comp.add("foam");
		comp.add("plain");
		comp.add("steel");
		comp.add("02/01/2016");
		cyc.process(comp);
	}
		//test for price change after offer date
		@Test
	void test2() throws ParseException {
		List<String> comp = new ArrayList<String>();
		comp.add("steel");
		comp.add("normal");
		comp.add("foam");
		comp.add("plain");
		comp.add("steel");
		comp.add("02/01/2018");
		cyc.process(comp);
	}

		//test for multithreading to calculate 1000 entry
	@Test
	void test3() throws ParseException {
		//implement executor service to run 10 threads
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 1; i <= 1000; i++) {
			List<String> comp = new ArrayList<String>();
			comp.add("steel");
			comp.add("normal");
			comp.add("foam");
			comp.add("plain");
			comp.add("steel");
			comp.add("02/01/2016");
			cyc.process(comp);
		}
		//wait till all thread complete their task
		executor.shutdown();
		while (!executor.isTerminated()) {
		
	}

	}
}
