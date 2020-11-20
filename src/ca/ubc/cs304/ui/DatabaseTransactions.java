package ca.ubc.cs304.ui;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.AbstractTable;
import ca.ubc.cs304.model.CustomerAnalysis;
import ca.ubc.cs304.model.OrderAnalysis;

import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DatabaseTransactions {
    private DatabaseConnectionHandler dbHandler;

    public DatabaseTransactions(DatabaseConnectionHandler dbConnHandler) {
        this.dbHandler = dbConnHandler;
    }

    /**
     * This class handles delegating DML and SQL query functions
     * to DatabaseConnectionHandler, which handles sending the actual SQL query.
     * This is the class that the UI communicates with.
     */

    public void handleInsert(AbstractTable table) {
        dbHandler.insert(table);
    }

    public void handleDelete(int id) {
        dbHandler.deleteDriver(id);
    }

    public void handleUpdate(int custID, String attr, String newValue) {
        dbHandler.updateCustomer(custID, attr, newValue);
    }

    public DefaultTableModel handleDisplay(String tableName) {
        return dbHandler.displayTable(tableName);
    }

    public ArrayList<OrderAnalysis> handleSelectionQuery(BigDecimal minSubTotal) {
        return dbHandler.selectionQuery(minSubTotal);
    }

    public ArrayList<CustomerAnalysis> handleProjJoinQuery(BigDecimal minSubTotal) {
        return dbHandler.projectionJoinQuery(minSubTotal);
    }

    public ArrayList<OrderAnalysis> handleAggrGroupByQuery() {
        return dbHandler.aggWithGroupbyQuery();
    }

    public ArrayList<Integer> handleAggrHavingQuery() {
        return dbHandler.AggWithHavingQuery();
    }

    public ArrayList<Integer> handleNestedAggrGroupByQuery() {
        return dbHandler.nestedAggrGroupByQuery();
    }

    public ArrayList<CustomerAnalysis> handleDivisionQuery() {
         return dbHandler.divisionQuery();
    }

    public void closeConnection(){
        dbHandler.close();
        System.out.println("Connection is closed");
    }
}
