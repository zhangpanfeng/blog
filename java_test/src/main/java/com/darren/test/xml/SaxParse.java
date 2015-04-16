package com.darren.test.xml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.helpers.AttributesImpl;

public class SaxParse implements XmlParse {

    public void createXml(String path) {
        try {
            SAXTransformerFactory sff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler th = sff.newTransformerHandler();
            Result resultXml = new StreamResult(new FileOutputStream(path));
            th.setResult(resultXml);

            Transformer transformer = th.getTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); // 编码格式是UTF-8
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // 换行
            th.startDocument(); // 开始xml文档
            AttributesImpl attr = new AttributesImpl();
            th.startElement("", "", "employees", attr); // 定义employees节点
            th.startElement("", "", "employee", attr); // 定义employee节点

            th.startElement("", "", "name", attr); // 定义name节点
            th.characters("Darren".toCharArray(), 0, "Darren".length());
            th.endElement("", "", "name"); // 结束name节点

            th.startElement("", "", "sex", attr); // 定义sex节点
            th.characters("man".toCharArray(), 0, "man".length());
            th.endElement("", "", "sex"); // 结束gender节点

            th.startElement("", "", "age", attr); // 定义age节点
            th.characters("25".toCharArray(), 0, "25".length());
            th.endElement("", "", "age"); // 结束age节点

            th.endElement("", "", "employee"); // 结束employee节点
            th.endElement("", "", "employees"); // 结束employees节点
            th.endDocument(); // 结束xml文档

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void parseXml(String path) {
        SAXParserFactory saxfac = SAXParserFactory.newInstance();
        try {
            SAXParser saxparser = saxfac.newSAXParser();
            InputStream is = new FileInputStream(path);
            saxparser.parse(is, new MySAXHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
