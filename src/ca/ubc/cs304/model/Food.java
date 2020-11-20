package ca.ubc.cs304.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Food extends AbstractTable {
    private final int foodID;
    private final String fName;
    private final BigDecimal price;
    private final String type;

    public Food(int foodID, String fName, BigDecimal price, String type) {
        this.foodID = foodID;
        this.fName = fName;
        this.price = price;
        this.type = type;
    }

    public static Object[] getFoodRow(ResultSet rs) throws SQLException {
        int foodID = rs.getInt("FoodID");
        String fName = AbstractTable.stringTrimmer(rs.getString("Fname"));
        BigDecimal price = rs.getBigDecimal("Price").setScale(2, RoundingMode.HALF_EVEN);
        String type = AbstractTable.stringTrimmer(rs.getString("Type"));
        Object[] rows = {foodID, fName, price, type};
        return rows;
    }

    public int getFoodID() { return this.foodID; }

    public String getFoodName() { return this.fName; }

    public BigDecimal getPrice() { return this.price; }

    public String getType() { return this.type; }
}
