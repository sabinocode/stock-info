package org.vanilla.stocks;

public class Stock {

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

	/**
	 * Creates a new Stock object.
	 * @param shortName the stocks name
	 * @param companyName the companies name of the stock
	 * @param dateChecked the last date the stock was updated
	 * @param currPrice the current price of the stock
	 * @param divYield the div yield of the stock
	 * @param peRatio the peRatio of the stock
	 */
	public Stock(String shortName, String companyName, String dateChecked, String currPrice,
			String divYield, String peRatio) {
		this.shortName = shortName;
		this.companyName = companyName;
		this.dateChecked = dateChecked;
		this.currPrice = currPrice;
		this.divYield = divYield;
		this.peRatio = peRatio;
	}
	
	/**
	 * Returns the stock name.
	 * @return shortName the name of the stock
	 */
	public String getShortName() {
		return shortName + "\"";
	}
	
	/**
	 * Returns the company's name.
	 * @return companyName the name of the company
	 */
	public String getCompanyName() {
		return companyName + "\"";
	}
	
	/**
	 * Returns the last date checked
	 * @return dateChecked the date of the stock information being shown.
	 */
	public String getDateChecked() {
		return dateChecked + "\"";
	}
	
	/**
	 * Returns the current price of the stock.
	 * @return currPrice the current price of the stock
	 */
	public String getCurrentPrice() {
		return currPrice;
	}
	
	/**
	 * Returns the div yield percentage.
	 * @return divYield the div yield percentage
	 */
	public String getDivYield() {
		return divYield;
	}
	
	/**
	 * Returns the PE Ratio of the stock.
	 * @return peRatio the PE Ratio of the stock
	 */
	public String getPERatio() {
		return peRatio;
	}
}
