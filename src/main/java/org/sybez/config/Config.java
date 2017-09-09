package org.sybez.config;

public class Config {


	private static Config instance;
	public  Currency currencyName = Currency.грн;

	private Config() {
	}

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	public Currency getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(Currency currencyName) {
		this.currencyName = currencyName;
	}
}
