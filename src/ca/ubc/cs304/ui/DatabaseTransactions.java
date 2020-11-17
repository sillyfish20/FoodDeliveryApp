package ca.ubc.cs304.ui;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.AbstractTable;

public class DatabaseTransactions {
    private DatabaseConnectionHandler dbHandler;

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
        dbHandler.deleteDriver(id);
    }

    public void handleUpdate(AbstractTable tableModel) {

    }

    public void handleDisplay(String tableName) {

    }


    // TODO: Add more methods for handling sending queries to databaseConnectionHandler?
}
