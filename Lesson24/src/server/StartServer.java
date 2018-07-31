package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class StartServer {

	public static void main(String[] args) {

		try {
			//create the registry on port 1099
			LocateRegistry.createRegistry(1099);
			
			//instantiate the StockServerImpl and bind it
			//to the registry under the name QuoteService
			StockServerImpl ssi = new StockServerImpl();
			Naming.rebind("rmi://localhost:1099/QuoteService", ssi);
			
		} catch (MalformedURLException e1) {
			System.out.println(e1.getMessage());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
