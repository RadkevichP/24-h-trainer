package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

public interface StockServer extends Remote {
	public String getQuote(String symbol) throws RemoteException;

	public Set<String> getNasdaqSymbols() throws RemoteException;

}
