/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public final class XmlUtils {
    private static final Log LOG = LogFactory.getLog(XmlUtils.class);

    public static XMLReader getXmlReader() {
        try {
            return XMLReaderFactory.createXMLReader();
        }
        catch (SAXException e) {
            throw new RuntimeException("Unable to create XMLReader", e);
        }
    }

    public static List getTextForElements(String xmlAsString, final String element) {
        final ArrayList elements = new ArrayList(2);
        XMLReader reader = XmlUtils.getXmlReader();
        DefaultHandler handler = new DefaultHandler(){
            private boolean foundElement = false;
            private StringBuffer buffer = new StringBuffer();

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (localName.equals(element)) {
                    this.foundElement = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (localName.equals(element)) {
                    this.foundElement = false;
                    elements.add(this.buffer.toString());
                    this.buffer = new StringBuffer();
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (this.foundElement) {
                    this.buffer.append(ch, start, length);
                }
            }
        };
        reader.setContentHandler(handler);
        reader.setErrorHandler(handler);
        try {
            reader.parse(new InputSource(new StringReader(xmlAsString)));
        }
        catch (Exception e) {
            LOG.error((Object)e, (Throwable)e);
            return null;
        }
        return elements;
    }

    public static String getTextForElement(String xmlAsString, final String element) {
        XMLReader reader = XmlUtils.getXmlReader();
        final StringBuffer buffer = new StringBuffer();
        DefaultHandler handler = new DefaultHandler(){
            private boolean foundElement = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (localName.equals(element)) {
                    this.foundElement = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (localName.equals(element)) {
                    this.foundElement = false;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (this.foundElement) {
                    buffer.append(ch, start, length);
                }
            }
        };
        reader.setContentHandler(handler);
        reader.setErrorHandler(handler);
        try {
            reader.parse(new InputSource(new StringReader(xmlAsString)));
        }
        catch (Exception e) {
            LOG.error((Object)e, (Throwable)e);
            return null;
        }
        return buffer.toString();
    }
}

