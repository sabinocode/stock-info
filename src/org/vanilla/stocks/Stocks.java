package org.vanilla.stocks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Stocks {

	/** The abbreviated name for the stock */
	private String shortName;
	/** The official companies name for the stock */
	private String companyName;
	/** Date checked */
	private String dateChecked;
	/** The current price of the stock. **/
	private String currPrice;
	/** Div Yield... */
	private String divYield;
	/** The P/E ratio **/
	private String peRatio;
	/** supported stocks */
	private String[] stocks = {"GOOG", "FB", "MSFT", "AAPL", "YHOO", "ORCL", "BP",
			"EMC", "DIS", "BAC", "WFC", "EBAY", "AKAM", "CSCO", "CA", "IBM",
			"HPQ", "INTC", "GULF", "XOM", "TSLA", "TGT", "WMT", "GDDY", "WIFI",
			"VNET", "AGTK", "AKAM", "BIDU", "BLNKF", "BCOR", "MEET", "TWTR", 
			"RAX", "TRON", "YAHOY"};
	
	/**
	 * Constructor: Sets the instance variables.
	 * 		Downloads the latest stock information in order to then parse it.
	 */
	public Stocks() {
		downloadCSV();
	}
	
	/**
	 * Downloads the CSV file from finance.yahoo.com.
	 * 		This is the latest stock information from Yahoo (c).
	 */
	private void downloadCSV() {
		URL website;
		Path target = new File("src/stocks.csv").toPath();
		
		String link = "http://finance.yahoo.com/d/quotes.csv?s=";
		for (int i = 0; i < stocks.length; i++) {
			link += stocks[i];
			if (i + 1 == stocks.length)	// if its at the end of the array add the final prefix.
				link += "&f=snd1l1yr";
			else
				link += "+";	// otherwise keep adding stocks to add to the .csv file.
		}
		
		try {
			website = new URL(link);
			InputStream in = website.openStream();
		    Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Searches for the specified stock name in order to get the 
	 * 		information for that stock.
	 * @param name the stock's name; example: MSFT is Microsoft's stock name.
	 * 		GOOG is Alphabet inc., and FB is Facebook Inc.
	 */
	public Stock searchForStock(String name) {
		name = "\"" + name;			// Add a " to the beginning of the name.
		String csvFile = "src/stocks.csv";	// link to .csv file.
		BufferedReader br = null;	// initialize the BufferedReader
		String line = null;			// initialize the String.
		String cvsSplitBy = "\",";	// splits every ", it finds.
		String afterDate = ",";		// splits every , it finds.
		boolean found = false;
		Stock tStock = null;

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] stockInfo = null;
				stockInfo = line.split(cvsSplitBy);
				shortName = stockInfo[0];
				companyName = stockInfo[1];
				dateChecked = stockInfo[2];
				stockInfo = line.split(afterDate);
				// shiftAmt is used because stocks with "," will process as another array object so 
				// we use shiftAmt to keep everything in check.
				int shiftAmt = stockInfo.length - 6;
				currPrice = stockInfo[3 + shiftAmt];
				divYield = stockInfo[4 + shiftAmt];
				peRatio = stockInfo[5 + shiftAmt];
				
				if (name.equalsIgnoreCase(shortName)) {
					found = true;
					tStock = new Stock(shortName, companyName, dateChecked, currPrice, divYield, peRatio);
				} 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// If stock name entered isn't in database it will return an error in the terminal.
		String returnMessage = (found) ? "": "Error: Stock not found in database.";
		System.out.println("\n" + returnMessage);
		
		return tStock;
	}
}
