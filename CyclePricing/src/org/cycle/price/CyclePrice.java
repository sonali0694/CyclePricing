package org.cycle.price;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

import org.calculate.price.CalculatePrice;

public class CyclePrice {
	public static void main(String args[])  {
		CalculatePrice cp= new CalculatePrice();
		//((CalculatePrice) cp).calculate();
		try{
			int flag=cp.calculate();
			if(flag==0) {
				System.out.println("Date of Pricing is not valid!!!");
			}
			
		}
		catch (FileNotFoundException e) {
			   e.printStackTrace();
			  } catch (IOException e) {
			   e.printStackTrace();
			  } catch (ParseException e) {
			   e.printStackTrace();
			  }
				catch (java.text.ParseException e) {
				e.printStackTrace();
			}
	}

}
