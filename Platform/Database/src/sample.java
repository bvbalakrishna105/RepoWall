
import Database.src.DataBaseManager;

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

public class sample {
    public static void main(String[] args) {
        DataBaseManager  dbManager = new DataBaseManager("postgresql");  
        
        if(dbManager != null){
            dbManager.setDBConfigData("postgresql");
        }
    }
}
