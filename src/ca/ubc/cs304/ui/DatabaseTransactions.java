package ca.ubc.cs304.ui;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.AbstractTable;
import ca.ubc.cs304.model.OrderAnalysis;

import java.math.BigDecimal;
import java.util.ArrayList;

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

    public void handleUpdate(int custID, String attr, String newValue) {
        // TODO: call update in dbConnectionHandler
        System.out.println("in handleUpdate()");
    }

    public void handleDisplay(String tableName) {
        // TODO: call displayTable in dbConnectionHandler
    }

    public ArrayList<OrderAnalysis> handleSelectionQuery(BigDecimal minSubTotal) {
        // TODO: call corresponding method in dbConnectionHandler
        System.out.println("in handleSelectionQuery()");
        ArrayList<OrderAnalysis> results = dbHandler.selectionQuery(minSubTotal);
        System.out.println("returning selection query results");
        return results;
    }

    public void handleProjJoinQuery() {
        // TODO: call corresponding method in dbConnectionHandler
    }

    public void handleAggrGroupByQuery() {
        // TODO: call corresponding method in dbConnectionHandler
    }

    public void handleAggrHavingQuery() {
        // TODO: call corresponding method in dbConnectionHandler
    }

    public void handleNestedAggrGroupByQuery() {
        // TODO: call corresponding method in dbConnectionHandler
    }

    public void handleDivisionQuery() {
        // TODO: call corresponding method in dbConnectionHandler
    }
}
