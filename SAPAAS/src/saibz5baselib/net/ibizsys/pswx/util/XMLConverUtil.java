/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.xml.bind.JAXBContext
 *  javax.xml.bind.JAXBException
 *  javax.xml.bind.Unmarshaller
 */
package net.ibizsys.pswx.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLConverUtil {
    private static final ThreadLocal<Map<Class<?>, Unmarshaller>> uMapLocal = new ThreadLocal<Map<Class<?>, Unmarshaller>>(){

        @Override
        protected Map<Class<?>, Unmarshaller> initialValue() {
            return new HashMap();
        }
    };

    public static <T> T convertToObject(Class<T> clazz, String xml) {
        return XMLConverUtil.convertToObject(clazz, new StringReader(xml));
    }

    public static <T> T convertToObject(Class<T> clazz, InputStream inputStream) {
        return XMLConverUtil.convertToObject(clazz, new InputStreamReader(inputStream));
    }

    public static <T> T convertToObject(Class<T> clazz, Reader reader) {
        try {
            Map<Class<?>, Unmarshaller> uMap = uMapLocal.get();
            if (!uMap.containsKey(clazz)) {
                JAXBContext jaxbContext = JAXBContext.newInstance((Class[])new Class[]{clazz});
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                uMap.put(clazz, unmarshaller);
            }
            return (T)uMap.get(clazz).unmarshal(reader);
        }
        catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> convertToMap(String xml) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        try {
            NodeList childNodes;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);
            Element root = document.getDocumentElement();
            if (root != null && (childNodes = root.getChildNodes()) != null && childNodes.getLength() > 0) {
                int i = 0;
                while (i < childNodes.getLength()) {
                    Node node = childNodes.item(i);
                    if (node != null && node.getNodeType() == 1) {
                        map.put(node.getNodeName(), node.getTextContent());
                    }
                    ++i;
                }
            }
        }
        catch (DOMException e) {
            e.printStackTrace();
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}

