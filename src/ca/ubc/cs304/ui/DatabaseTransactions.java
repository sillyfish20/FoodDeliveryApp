package ca.ubc.cs304.ui;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.AbstractTable;

public class DatabaseTransactions {
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";
    private static final int INVALID_INPUT = Integer.MIN_VALUE;
    private static final int EMPTY_INPUT = 0;
    private DatabaseConnectionHandler dbHandler = null;

    public DatabaseTransactions(DatabaseConnectionHandler dbConnHandler) {
        this.dbHandler = dbConnHandler;
    }

    /**
     * This class handles input received from UI interface (insert, delete, update, display etc.)
     * and delegates to DatabaseConnectionHandler to handle sending the SQL query
     */

    public void handleInsert(AbstractTable table) {
        dbHandler.insert(table);
    }

    public void handleDelete(int id) {

    }

    public void handleUpdate(AbstractTable tableModel) {

    }

    public void handleDisplay(String tableName) {

    }


    // TODO: Add more methods for handling sending queries to databaseConnectionHandler?
}
