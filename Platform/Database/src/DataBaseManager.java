/****************************************************************************/
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
/****************************************************************************/

package Database.src;

public class DataBaseManager {
    
    public String m_dbConnectionString;
    public String m_dbName;
    public String m_userName;
    public String m_passWord;
    public String m_dbDriver;
    ReadDataBaseConfing mp_readDBConfig;

    public DataBaseManager(String dbName) {
        m_dbConnectionString = "";
        m_dbName = dbName;
        m_userName = "";
        m_passWord = "";
        m_dbDriver = "";
        mp_readDBConfig = new ReadDataBaseConfing();
    }

    public void setDBConfigData(String dbName) {
        if (mp_readDBConfig != null) {
            String temp = mp_readDBConfig.readDataBaseConfigFile();
            deserializationDBConfiguration(temp, dbName);
        }
    }

    public void deserializationDBConfiguration(String pathConfigString, String dbName) {
        if (!pathConfigString.equals("")) {
            String[] parts = pathConfigString.split("$");
            
            String[] postgresPart = parts[0].split("#");
            if (postgresPart[1].equals(dbName)) {
                m_dbConnectionString = postgresPart[0];
                m_userName = postgresPart[2];
                m_passWord = postgresPart[3];
                m_dbDriver = postgresPart[4];
            }
            String[] mysqlPart = parts[1].split("#");
            if (mysqlPart[1].equals(dbName)) {
                m_dbConnectionString = mysqlPart[0];
                m_userName = mysqlPart[2];
                m_passWord = mysqlPart[3];
                m_dbDriver = mysqlPart[4];
            }
        } else {
            System.out.println("Reading from Database Configuratio is not possible");
            return;
        }
    }
    
}
