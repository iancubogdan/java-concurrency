package main.com.bogdaniancu.speech.parser;

import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXmlDomParser {

    public static final String FILENAME = "D:\\Coding\\Workspace\\Udemy\\Java Concurency\\Main app\\Java Concurency\\src\\main\\resources\\staff.xml";

    private static void processElement(Element element) {
        // Process the current element
        System.out.println("Element: " + element.getNodeName());

        // Process attributes, if any
        if (element.hasAttributes()) {
            System.out.println("Attributes:");
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                Node attribute = element.getAttributes().item(i);
                System.out.println(attribute.getNodeName() + ": " + attribute.getNodeValue());
            }
        }

        // Process child elements, if any
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);

            // Check if the node is an element (rather than text, comment, etc.)
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                // Recursively process child elements
                processElement((Element) childNode);
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(FILENAME));


        // optional, but recommended
        // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();

        System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
        System.out.println("------");

        // Get the root element
        Element rootElement = doc.getDocumentElement();

        // Process the SSML elements
        processElement(rootElement);

//        NodeList list = doc.getElementsByTagName("staff");
//        for (int temp = 0; temp < list.getLength(); temp++) {
//            Node node = list.item(temp);
//            if (node.getNodeType() == Node.ELEMENT_NODE) {
//
//                Element element = (Element) node;
//
//                // get staff's attribute
//                String id = element.getAttribute("id");
//
//                // get text
//                String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
//                String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
//                String nickname = element.getElementsByTagName("nickname").item(0).getTextContent();
//
//                NodeList salaryNodeList = element.getElementsByTagName("salary");
//                String salary = salaryNodeList.item(0).getTextContent();
//
//                // get salary's attribute
//                String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();
//
//                System.out.println("Current Element :" + node.getNodeName());
//                System.out.println("Staff Id : " + id);
//                System.out.println("First Name : " + firstname);
//                System.out.println("Last Name : " + lastname);
//                System.out.println("Nick Name : " + nickname);
//                System.out.printf("Salary [Currency] : %,.2f [%s]%n%n", Float.parseFloat(salary), currency);
//
//            }
//        }
    }
}
//https://mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/

//https://developer.amazon.com/en-US/docs/alexa/custom-skills/speech-synthesis-markup-language-ssml-reference.html