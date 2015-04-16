package com.darren.test.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jParse implements XmlParse {

    public void createXml(String path) {
        try {
            Document document = DocumentHelper.createDocument();
            Element employees = document.addElement("employees");
            Element employee = employees.addElement("employee");
            Element name = employee.addElement("name");
            name.setText("Darren");
            Element sex = employee.addElement("sex");
            sex.setText("man");
            Element age = employee.addElement("age");
            age.setText("25");
            Writer fileWriter = new FileWriter(path);
            XMLWriter xmlWriter = new XMLWriter(fileWriter);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public void parseXml(String path) {
        try {
            File inputXml = new File(path);
            SAXReader saxReader = new SAXReader();

            Document document = saxReader.read(inputXml);
            Element employees = document.getRootElement();
            Iterator<Element> employeeElements = employees.elementIterator();
            while (employeeElements.hasNext()) {
                Element employee = (Element) employeeElements.next();

                Iterator<Element> nodeElements = employee.elementIterator();
                while (nodeElements.hasNext()) {
                    Element node = (Element) nodeElements.next();
                    System.out.println(node.getName() + ":" + node.getText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
