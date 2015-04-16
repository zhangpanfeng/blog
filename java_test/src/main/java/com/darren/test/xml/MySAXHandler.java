package com.darren.test.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXHandler extends DefaultHandler {

    // 一般将正式解析前的一些初始化工作放到这里面
    public void startDocument() throws SAXException {
        System.out.println("文档开始打印了");
    }

    // 收尾工作放在endDocument中
    public void endDocument() throws SAXException {
        System.out.println("文档打印结束了");
    }

    // XML解析器遇到XML里面的tag时就会调用这个函数。经常在这个函数内是通过qName俩进行判断而操作一些数据
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("employees")) {
            return;
        }
        if (qName.equals("employee")) {
            return;
        }
        System.out.print(qName + ":");
    }

    // 这个方法与startElement()相对应，解析完一个tag节点后，执行这个方法
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    // 回调方法。解析器执行完startElement()后，解析完节点的内容后就会执行这个方法，并且参数ch[]就是节点的内容
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (value.startsWith("\n")) {
            return;
        }

        System.out.println(value);
    }
}