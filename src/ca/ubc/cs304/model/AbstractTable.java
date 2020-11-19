package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractTable {
    // abstract table model
    String[] tables = {"Serves", "RestaurantLocation", "AreaCode", "Transactions", "Receipt", "RequestsOrder", "MakesOrder",
            "PicksUpOrder", "DeliversTo", "OrderDestination", "RequestsAddress", "AddressDestination",
            "MembershipInfo", "TrialRange"};

    public static Object[] getTableRowData(String table, ResultSet rs) throws SQLException {
        Object[] tableRow = {};
        switch (table) {
            case "Customer":
                tableRow = Customer.getTableRows(rs);
                break;
            case "Vendor":
                tableRow = Vendor.getVendorRows(rs);
                break;
            case "ManagesRestaurant":
                tableRow = ManagesRestaurant.getManagesRestRows(rs);
                break;
            case "Drivers":
                tableRow = Drivers.getDriversRows(rs);
                break;
            case "Drivers_Vehicle":
                tableRow = DriversVehicle.getVehicleRows(rs);
                break;
            case "Food":
                tableRow = Food.getFoodRow(rs);
                break;
            case "Serves":
                tableRow = Serves.getServesRow(rs);
                break;
        }
        return tableRow;
    }

}
