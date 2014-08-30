
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
public class sampleDataBaseManager {

    public String m_dbConnectionString;
    public String m_dbName;
    public String m_userName;
    public String m_passWord;
    public String m_dbDriver;
    ReadDataBaseConfing mp_readDBConfig;

    public sampleDataBaseManager() {
        mp_readDBConfig = new ReadDataBaseConfing();
    }

    public sampleDataBaseManager(String dbName){
        m_dbName = dbName;
    }
    
    public void setDBConfigData() {
        if (mp_readDBConfig != null) {
            String temp = mp_readDBConfig.readDataBaseConfigFile();
            deserializationDBConfiguration(temp);
        }
    }

    public void deserializationDBConfiguration(String pathConfigString) {
        if (pathConfigString != "") {

        } else {
            System.out.println("Reading from Database Configuratio is not possible");
            return;
        }
    }
}
