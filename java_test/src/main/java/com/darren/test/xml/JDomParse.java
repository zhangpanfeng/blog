package com.darren.test.xml;

import java.io.FileOutputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class JDomParse implements XmlParse {

    public void createXml(String path) {
        try {
            Element root = new Element("employees");
            Document document = new Document(root);
            Element employee = new Element("employee");
            root.addContent(employee);
            Element name = new Element("name");
            name.setText("Darren");
            employee.addContent(name);
            Element sex = new Element("sex");
            sex.setText("man");
            employee.addContent(sex);
            Element age = new Element("age");
            age.setText("25");
            employee.addContent(age);
            XMLOutputter XMLOut = new XMLOutputter();
            XMLOut.output(document, new FileOutputStream(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public void parseXml(String path) {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document document = builder.build(path);
            Element root = document.getRootElement();
            List<Element> employeeList = root.getChildren("employee");
            for (Element employee : employeeList) {
                List<Element> employeeInfo = employee.getChildren();
                for (Element info : employeeInfo) {
                    System.out.println(info.getName() + ":" + info.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
