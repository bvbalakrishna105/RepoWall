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

public interface DataBaseOperations {
    
    /**
     *
     * @param tableName
     */
    public void createTable(String tableName);
    
    /**
     *
     * @param tableName
     */
    public void insertIntoTable(String tableName);
    
    /**
     *
     * @param tableName
     */
    public String selectFromTable(String tableName);
       
}
