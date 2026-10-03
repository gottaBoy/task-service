package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.io.StringReader;
import java.text.ParseException;
import java.util.HashSet;
import java.util.TreeMap;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class XML2DataEntityTransformer extends StringTransformer {
    protected TreeMap<Integer, PackagePart> contentPartMap;

    protected Object doTransform(Object object, String encoding) throws TransformerException {
        String input = TransformerHelper.GetString(this, object, encoding);
        try {
            Document document = GetXMLDocument(input);
            contentPartMap = ParseContentFormat(GetConfig(TAG_CONTENTFORMAT, ""));
            BaseDataEntity entity = new BaseDataEntity();
            HashSet<String> names = new HashSet<String>();
            NodeList children = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() != Node.ELEMENT_NODE) continue;
                Element element = (Element)child;
                String name = element.getTagName();
                if (!names.add(name.toUpperCase(java.util.Locale.ROOT))) {
                    throw new IllegalArgumentException("Duplicate XML field: " + name);
                }
                for (int j = 0; j < element.getChildNodes().getLength(); j++) {
                    if (element.getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE) {
                        throw new IllegalArgumentException("Nested XML field: " + name);
                    }
                }
                PackagePart part = null;
                for (PackagePart candidate : contentPartMap.values()) {
                    if (candidate.getName().equalsIgnoreCase(name)) part = candidate;
                }
                if (!contentPartMap.isEmpty() && part == null) {
                    throw new IllegalArgumentException("Unknown XML field: " + name);
                }
                String value = element.getTextContent();
                entity.SetParamValue(name, part == null ? value : ParseValue(value, part));
            }
            if (!contentPartMap.isEmpty() && names.size() != contentPartMap.size()) {
                throw new IllegalArgumentException("Missing XML fields");
            }
            return entity;
        } catch (ParseException ex) {
            throw new TransformerException(MessageFactory.createStaticMessage("Invalid XML field"), ex);
        } catch (IllegalArgumentException ex) {
            throw new TransformerException(MessageFactory.createStaticMessage("Invalid XML entity"), ex);
        }
    }

    public static Document GetXMLDocument(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            factory.setXIncludeAware(false);
            factory.setExpandEntityReferences(false);
            javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new DefaultHandler() {
                public void fatalError(SAXParseException ex) throws SAXException {
                    throw ex;
                }
            });
            return builder.parse(new InputSource(new StringReader(xml)));
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid or unsafe XML document", ex);
        }
    }
}
