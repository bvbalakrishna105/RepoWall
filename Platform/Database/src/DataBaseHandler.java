/**
 * *************************************************************************
 */
/*!
 *
 *
 *  $Version:   $ 0.1
 *  $Date:      $ 2014-08-30
 *  $Author:    $ Venkata Balakrushna Beesetti
 *
 *  \b Company:
 *
 *       RakutWall Pvt.Ltd
 *
 *  (C) Copyright 2011 by RakutWall Pvt. Ltd. All rights reserved.
 *  This is unpublished proprietary source code of Leica. The copyright notice
 *  does not evidence any actual or intended publication.
 *
 */
/**
 * *************************************************************************
 */
package Database.src;

import java.sql.*;

public class DataBaseHandler implements DataBaseOperations{

    public DataBaseHandler() {
    }

    public boolean connectDataBase(String dbConnection, String userName, String passWord, String dbDriver) {

        try {
            Class.forName(dbDriver);
            Connection con = DriverManager.getConnection(dbConnection, userName, passWord);

            if (con != null) {
                Statement st = con.createStatement();
                String sql = "select * from test";
                st.executeQuery(sql);
            } else {
                return false;
            }
        } catch (Exception ee) {
            ee.getStackTrace();
        }

        return true;
    }
    
    public void createTable(String tableName){
        
    }
    
    public void insertIntoTable(String tableName){
        
    }
    
    public String selectFromTable(String tableName){
        return "";
    }
}
