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

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class sample {
    public static void main(String[] args) {
        try{
            
            String  currentPath = System.getProperty("user.dir");
            currentPath = currentPath.concat("\\Platform\\Settings\\config.xml");
            File fileConfig = new File(currentPath);
            if(!fileConfig.isFile()){
                return;
            }
           
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileConfig);
            doc.getDocumentElement().normalize();
            
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            
            NodeList nList = doc.getElementsByTagName("database");
            
            System.out.println("----------------------------");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
                        String colonDelimenator = ":";
                        String forwardSlash = "/";
                        String databaseConnectionString = eElement.getElementsByTagName("url").item(0).getTextContent();                      
                        String ipAddress = eElement.getElementsByTagName("ipaddress").item(0).getTextContent();
                        String portNumber = eElement.getElementsByTagName("port").item(0).getTextContent();
                        String databaseName = eElement.getElementsByTagName("databaseName").item(0).getTextContent();
                        databaseConnectionString = databaseConnectionString.concat(ipAddress).concat(colonDelimenator).concat(portNumber).concat(forwardSlash).concat(databaseName);
                        
			System.out.println("Database : " + eElement.getAttribute("name"));
			System.out.println("databasedriver : " + eElement.getElementsByTagName("databasedriver").item(0).getTextContent());
                        System.out.println(databaseConnectionString);
                        System.out.println("username : " + eElement.getElementsByTagName("username").item(0).getTextContent());
                        System.out.println("password : " + eElement.getElementsByTagName("password").item(0).getTextContent());
		}
	}
            
        }catch(Exception ee){
            ee.getStackTrace();
        }
        
    }
    
}
