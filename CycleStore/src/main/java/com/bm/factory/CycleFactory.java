package com.bm.factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor.STRING;

import com.bm.chain.ChainAssembley;
import com.bm.cycle.Cycle;
import com.bm.frame.Frame;
import com.bm.handel.Handel;
import com.bm.seat.Seating;
import com.bm.wheel.Wheel;

public class CycleFactory {
	static int count=0;
	private static Frame frame=null;
	private static Handel handel=null;
	private static Seating seating=null;
	private static Wheel wheel=null;
	private static ChainAssembley chainassAssembley=null;

	//Assembly module to creat object and call related methods
	public static void assembleyFactory(List<String> comp) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		Date date = formatter.parse(comp.get(5));
		if(comp.size()==6){
			frame=new Frame();
			handel=new Handel();
			seating=new Seating();
			wheel=new Wheel();
			chainassAssembley=new ChainAssembley();
			pricingFilter(date);
			calculationEngine(comp);

		}
		else {
			System.out.println("Somthing missing");
		}

	}
	//price filtering modue according to date
	public static void pricingFilter(Date date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		Date date1 = formatter.parse("01/01/2016");
		Date date2 = formatter.parse("1/11/2016");
		if(date.after(date1) && date.before(date2)) {
			wheel.setPlainTyre(200F);
		}
		else {
			wheel.setPlainTyre(230F);
		}
	}

	//price calculation module
	public static void calculationEngine(List<String> comp) {
		Float total=0f;
		System.out.println("bill no:"+count++);
		//Frame cost calculation
		if(comp.get(0).equalsIgnoreCase("Steel")) {
			total=total+frame.getSteelFrame();
			System.out.println("Frame Cost: "+frame.getSteelFrame());
		}
		else if(comp.get(0).equalsIgnoreCase("Aluminium")) {
			total=total+frame.getAluminiumFrame();
			System.out.println("Frame Cost: "+frame.getAluminiumFrame());
		}
		else {
			total=total+frame.getCarbonFiberFrame();
			System.out.println("Frame Cost: "+frame.getCarbonFiberFrame());
		}

		//HAndel bar cost calculation
		if(comp.get(1).equalsIgnoreCase("NormalBreak")) {
			total=total+handel.getHandelWithNormalBreak();
			System.out.println("HandelBar Cost: "+handel.getHandelWithNormalBreak());
		}
		else if(comp.get(1).equalsIgnoreCase("DiscBreak")) {
			total=total+handel.getHandelWithDiscBreak();
			System.out.println("HandelBar Cost: "+handel.getHandelWithDiscBreak());
		}
		else if(comp.get(1).equalsIgnoreCase("4gear")) {
			total=total+handel.getHandelWith4Gear();
			System.out.println("HandelBar Cost: "+handel.getHandelWith4Gear());
		}
		else {
			total=total+handel.getHandelWith6Gear();
			System.out.println("HandelBar Cost: "+handel.getHandelWith6Gear());
		}

		//Seating cost calculation
		if(comp.get(2).equalsIgnoreCase("plastic")) {
			total=total+seating.getPlasticSeat();
			System.out.println("Seating Cost: "+seating.getPlasticSeat());
		}
		else if(comp.get(2).equalsIgnoreCase("foam")) {
			total=total+seating.getFoamSeat();
			System.out.println("Seating Cost: "+seating.getFoamSeat());
		}
		else {
			total=total+seating.getLeatherSeat();
			System.out.println("Seating Cost: "+seating.getLeatherSeat());
		}


		//Wheel cost calculation
		if(comp.get(3).equalsIgnoreCase("plain")) {
			total=total+(wheel.getPlainTyre()*2);
			System.out.println("Wheel Cost: "+(wheel.getPlainTyre()*2)+" (2X)");
		}
		else {
			total=total+wheel.getTubelessTyre();
			System.out.println("Wheel Cost: "+(wheel.getTubelessTyre()*2)+" (2X)");
		}

		//chain aassembley calculations
		if(comp.get(4).equalsIgnoreCase("steel")) {
			total=total+chainassAssembley.getSteelChain();
			System.out.println("ChainAssembley Cost: "+chainassAssembley.getSteelChain());
		}
		else {
			total=total+chainassAssembley.getAntiJunk();
			System.out.println("ChainAssembley Cost: "+chainassAssembley.getAntiJunk());
		}
		System.out.println("--------------------------------");
		System.out.println("total cost:"+total);
		System.out.println("  *** Thank you ***");
		System.out.println();
		System.out.println();

	}

}
