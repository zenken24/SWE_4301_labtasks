package org.lab4;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.StringReader;
import java.lang.reflect.Field;
import org.xml.sax.InputSource;

public class XMLDeserializer {

    public static <T> void deserializeAndPrint(String xml, Class<T> clazz) throws Exception {
        // Parse XML (DOM)
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new InputSource(new StringReader(xml)));
        Element root = doc.getDocumentElement();
        
        System.out.println("\n--- Deserialization Results ---");
        System.out.println("Class: " + clazz.getName());

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            String value = null;

            NodeList nodes = root.getElementsByTagName(fieldName);
            if (nodes.getLength() > 0) {
                value = nodes.item(0).getTextContent();
            }

            System.out.println(fieldName + ": " + (value != null ? value.trim() : "null"));
        }
    }
}