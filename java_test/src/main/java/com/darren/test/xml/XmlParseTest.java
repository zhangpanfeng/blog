package com.darren.test.xml;

public class XmlParseTest {

    public static void main(String[] args) {
        // DomParse domParse = new DomParse();
        // domParse.createXml("F:\\employee.xml");
        // domParse.parseXml("F:\\employee.xml");

        // SaxParse saxParse = new SaxParse();
        // saxParse.createXml("F:\\employee.xml");
        // saxParse.parseXml("F:\\employee.xml");

        // Dom4jParse dom4jParse = new Dom4jParse();
        // dom4jParse.createXml("F:\\employee.xml");
        // dom4jParse.parseXml("F:\\employee.xml");

        JDomParse jdomParse = new JDomParse();
        jdomParse.createXml("F:\\employee.xml");
        jdomParse.parseXml("F:\\employee.xml");
    }

}
