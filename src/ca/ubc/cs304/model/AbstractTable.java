package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * An abstraction of a table such that any subtype can be used in place of it,
 * mostly for the insert() method in DatabaseConnectionHandler
 *
 * Also contains additional static methods that help retrieve row data from the
 * ResultSet depending on the table (used for displayTable() method in dbConnHandler)
 */

public abstract class AbstractTable {

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
            case "RestaurantLocation":
                tableRow = RestaurantLocation.getResLocationRow(rs);
                break;
            case "AreaCode":
                tableRow = AreaCode.getAreaCodeRow(rs);
                break;
            case "Transactions":
                tableRow = Transaction.getTransactionRow(rs);
                break;
            case "Receipt":
                tableRow = Receipt.getReceiptRows(rs);
                break;
            case "RequestsOrder":
                tableRow = RequestsOrder.getReqOrderRows(rs);
                break;
            case "MakesOrder":
                tableRow = MakesOrder.getMakesOrderRows(rs);
                break;
            case "PicksUpOrder":
                tableRow = PicksUpOrder.getPicksUpOrdRows(rs);
                break;
            case "DeliversTo":
                tableRow = DeliversTo.getDelivToRows(rs);
                break;
            case "OrderDestination":
                tableRow = OrderDestination.getOrderDestRows(rs);
                break;
            case "RequestsAddress":
                tableRow = RequestsAddress.getReqAddressRows(rs);
                break;
            case "AddressDestination":
                tableRow = AddressDestination.getAddDestRows(rs);
                break;
            case "MembershipInfo":
                tableRow = MembershipInfo.getMemberInfoRows(rs);
                break;
            case "TrialRange":
                tableRow = TrialRange.getTrialRangeRows(rs);
                break;
        }
        return tableRow;
    }

    // static helper for trimming strings retrieved from the result set
    public static String stringTrimmer(String str) {
        if (str != null) {
            str = str.trim();
        }
        return str;
    }

}
