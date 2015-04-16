package com.darren.test.xml;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParse implements XmlParse {
    private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public void createXml(String path) {
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            // 创建根节点
            Element root = document.createElement("employees");
            // 添加根节点
            document.appendChild(root);

            // 创建一级子节点
            Element employee = document.createElement("employee");

            // 操作一
            // 创建二级子节点
            Element name = document.createElement("name");
            // 为二级子节点添加值
            name.appendChild(document.createTextNode("Darren"));
            // 把二级子节点放到一级子节点下
            employee.appendChild(name);

            // 同操作一
            Element sex = document.createElement("sex");
            sex.appendChild(document.createTextNode("man"));
            employee.appendChild(sex);

            // 同操作一
            Element age = document.createElement("age");
            age.appendChild(document.createTextNode("25"));
            employee.appendChild(age);

            // 把一级子节点添加到根节点下
            root.appendChild(employee);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            PrintWriter pw = new PrintWriter(new FileOutputStream(path));
            StreamResult result = new StreamResult(pw);
            transformer.transform(source, result);
            System.out.println("生成XML文件成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseXml(String path) {
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(path);
            Element root = document.getDocumentElement();
            NodeList employee = root.getChildNodes();
            outPut(employee);
            System.out.println("解析XML文件成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void outPut(NodeList nodeList) {
        int length = nodeList.getLength();
        for (int i = 0; i < length; i++) {
            Node node = nodeList.item(i);
            // 叶子节点
            if (node.getChildNodes().getLength() == 1) {
                String nodeName = node.getNodeName();
                String nodeValue = node.getTextContent();
                System.out.println(nodeName + ":" + nodeValue);
            }
            // 非叶子节点
            if (node.getChildNodes().getLength() > 1) {
                NodeList subList = node.getChildNodes();
                outPut(subList);
            }
        }
    }
}
