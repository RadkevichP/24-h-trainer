package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StockServerImpl extends UnicastRemoteObject implements StockServer {
		
	private String price = null;
	private Set<String> nasdaqSymbols = new HashSet();
	
	
	public StockServerImpl() throws RemoteException {
		super();
		//define some hard-coded NASDAQ symbols
		nasdaqSymbols.add("AAPL");
		nasdaqSymbols.add("MSFT");
		nasdaqSymbols.add("YHOO");
		nasdaqSymbols.add("AMZN");
	}
	
	@Override
	public String getQuote(String symbol) throws RemoteException {
		if(nasdaqSymbols.contains(symbol.toUpperCase())) {
			//generate random price for valid symbols
			price = (new Double(Math.random()*100).toString());
			System.out.println("Got hte price quote request for " + symbol.toUpperCase());
		}
		return price;
	}
	
	@Override
	public Set<String> getNasdaqSymbols() throws RemoteException {
		return nasdaqSymbols;
	}

}
