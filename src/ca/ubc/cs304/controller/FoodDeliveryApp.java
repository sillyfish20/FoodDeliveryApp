package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.delegates.LoginWindowDelegate;
import ca.ubc.cs304.ui.DatabaseTransactions;
import ca.ubc.cs304.ui.DatabaseAppUI;
import ca.ubc.cs304.ui.LoginWindow;

/**
 * This is the main controller class that will orchestrate everything.
 */
public class FoodDeliveryApp implements LoginWindowDelegate{
	private DatabaseConnectionHandler dbHandler;
	private LoginWindow loginWindow = null;
	private DatabaseAppUI databaseAppUI = null;
	public static DatabaseTransactions dbTransactions = null;

	public FoodDeliveryApp() {
		dbHandler = new DatabaseConnectionHandler();
	}
	
	private void start() {
		loginWindow = new LoginWindow();
		databaseAppUI = new DatabaseAppUI();
		loginWindow.showFrame(this);
	}
	
	/**
	 * LoginWindowDelegate Implementation
	 * 
     * connects to Oracle database with supplied username and password
     */ 
	public void login(String username, String password) {
		boolean didConnect = dbHandler.login(username, password);

		if (didConnect) {
			// Once connected, remove login window and start text transaction flow
			loginWindow.dispose();
			startAppUI();
		} else {
			loginWindow.handleLoginFailed();

			if (loginWindow.hasReachedMaxLoginAttempts()) {
				loginWindow.dispose();
				System.out.println("You have exceeded your number of allowed attempts");
				System.exit(-1);
			}
		}
	}

	// initiates the DatabaseTransaction and GUI
	private void startAppUI() {
		dbTransactions = new DatabaseTransactions(dbHandler);
		databaseAppUI.showFrame();
	}

	/**
	 * Main method called at launch time
	 */
	public static void main(String args[]) {
		FoodDeliveryApp foodDeliveryApp = new FoodDeliveryApp();
		foodDeliveryApp.start();
	}
}
