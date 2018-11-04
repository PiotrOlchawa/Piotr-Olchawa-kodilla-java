package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StroredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //when
        String sqlProcedureCall ="CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        //then
        String sqlCheckTable = "SELECT COUNT(*) as HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany =-1;
        if(rs.next()) {
            howMany=rs.getInt("HOW_MANY");
        }
        assertEquals(0,howMany);
    }
    @Test
    public void testUpdateBestSellers() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER=FALSE ";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //when
        String sqlProcedureCall ="CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);

        //then
        String sqlCheckTable = "SELECT COUNT(*) as HOW_MANY FROM BOOKS WHERE BESTSELLER=FALSE ";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany =-1;
        if(rs.next()) {
            howMany=rs.getInt("HOW_MANY");
        }
        assertTrue(howMany>0);
    }
}