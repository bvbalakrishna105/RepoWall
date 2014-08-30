
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
import java.io.File;
import javax.swing.text.View;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadDataBaseConfing {

    public ReadDataBaseConfing() {

    }

    /**
     * reading Database configuration File from settings folder
     * @return String
     */
    public String readDataBaseConfigFile() {
        String readDBConfigString = "";
        try {

            String currentPath = System.getProperty("user.dir");
            String specialDelimiter = "#";
            currentPath = currentPath.concat("\\Platform\\Settings\\config.xml");
            File fileConfig = new File(currentPath);
            if (!fileConfig.isFile()) {
                return readDBConfigString;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileConfig);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("database");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    String colonDelimiter = ":";
                    String forwardSlash = "/";
                    String dbConnectionString = eElement.getElementsByTagName("url").item(0).getTextContent();
                    String ipAddress = eElement.getElementsByTagName("ipaddress").item(0).getTextContent();
                    String portNumber = eElement.getElementsByTagName("port").item(0).getTextContent();
                    String databaseName = eElement.getElementsByTagName("databaseName").item(0).getTextContent();
                    dbConnectionString = dbConnectionString.concat(ipAddress).concat(colonDelimiter).concat(portNumber).concat(forwardSlash).concat(databaseName);

                    String dbName = eElement.getAttribute("name");
                    String dbDriver = eElement.getElementsByTagName("databasedriver").item(0).getTextContent();
                    String userName = eElement.getElementsByTagName("username").item(0).getTextContent();
                    String passWord = eElement.getElementsByTagName("password").item(0).getTextContent();

                    readDBConfigString = dbConnectionString.concat(specialDelimiter).concat(dbName);
                    readDBConfigString = readDBConfigString.concat(specialDelimiter).concat(userName).concat(specialDelimiter).concat(passWord).concat(specialDelimiter).concat(dbDriver);
                }
            }
        } catch (Exception ee) {
            ee.getStackTrace();
        }
        return readDBConfigString;
    }
}
