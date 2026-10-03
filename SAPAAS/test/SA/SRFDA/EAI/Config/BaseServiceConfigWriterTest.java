package SA.SRFDA.EAI.Config;

import SA.SRFDA.Ctrl.Data.Registry;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFDA.EAI.Ctrl.ISRFEAIDataCtrl;
import SA.SRFDA.EAI.Model.EAIConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.io.StringReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilderFactory;
import junit.framework.TestCase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class BaseServiceConfigWriterTest extends TestCase {
    private static final String SPRING = "http://www.springframework.org/schema/beans";

    public void testGeneratedServiceWiresLocalDataSourceAndInstance() throws Exception {
        final IDAModelHelper modelHelper = (IDAModelHelper) Proxy.newProxyInstance(
                IDAModelHelper.class.getClassLoader(), new Class<?>[] {IDAModelHelper.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        assertEquals("GetRegistry", method.getName());
                        assertEquals("EAI", args[0]);
                        Registry registry = (Registry) args[2];
                        if ("SRFDADATASOURCE".equals(args[1])) {
                            registry.GetParams().setProperty("DRIVERNAME", "org.example.Driver");
                            registry.GetParams().setProperty("URL", "jdbc:example://localhost/db");
                            registry.GetParams().setProperty("USER", "db-user");
                            registry.GetParams().setProperty("PASSWORD", "a&b");
                        } else if ("EAIINSTANCE".equals(args[1])) {
                            registry.GetParams().setProperty("SERVICEID", "wrong-service");
                            registry.GetParams().setProperty("APPMODE", "development");
                        } else {
                            fail("Unexpected registry " + args[1]);
                        }
                        return new CallResult();
                    }
                });
        ISRFDAGlobalHelper helper = (ISRFDAGlobalHelper) Proxy.newProxyInstance(
                ISRFDAGlobalHelper.class.getClassLoader(), new Class<?>[] {ISRFDAGlobalHelper.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        assertEquals("getDAModelHelper", method.getName());
                        return modelHelper;
                    }
                });
        ISRFEAIDataCtrl dataCtrl = (ISRFEAIDataCtrl) Proxy.newProxyInstance(
                ISRFEAIDataCtrl.class.getClassLoader(), new Class<?>[] {ISRFEAIDataCtrl.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        assertEquals("GetServiceProcesses", method.getName());
                        assertEquals("service-1", args[0]);
                        return new CallResult();
                    }
                });
        DefaultConfigWriterContext context = new DefaultConfigWriterContext();
        context.setGlobalHelper(helper);
        context.setEAIDataCtrl(dataCtrl);
        context.setEAIConfig(new EAIConfig());
        context.setServiceId("service-1");
        Properties serviceParams = new Properties();
        serviceParams.setProperty("CONFIGPATH", "/tmp/eai-config");
        context.setServiceParams(serviceParams);
        EAIService service = new EAIService();
        service.setEAISERVICEID("service-1");
        service.setEAISERVICENAME("Sample");
        StringBuilder xml = new StringBuilder();
        assertFalse(new BaseServiceConfigWriter().Export(
                service, new SimpleXMLWriter(xml), context).IsError());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        Document document = factory.newDocumentBuilder().parse(
                new InputSource(new StringReader(xml.toString())));
        assertEquals("mule", document.getDocumentElement().getLocalName());
        assertEquals(4, document.getElementsByTagNameNS(SPRING, "bean").getLength());
        Element dataSource = bean(document, "SRFDADATASOURCE");
        assertEquals("com.mchange.v2.c3p0.ComboPooledDataSource", dataSource.getAttribute("class"));
        assertEquals("close", dataSource.getAttribute("destroy-method"));
        assertEquals("org.example.Driver", property(dataSource, "driverClass").getAttribute("value"));
        assertEquals("jdbc:example://localhost/db", property(dataSource, "jdbcUrl").getAttribute("value"));
        assertEquals("db-user", property(dataSource, "user").getAttribute("value"));
        assertEquals("a&b", property(dataSource, "password").getAttribute("value"));
        assertEquals("SRFDADATASOURCE", property(bean(document, "SRFDAEAIDBCALLER"),
                "dataSource").getAttribute("ref"));
        assertEquals("SRFDAEAIDBCALLER", property(bean(document, "SRFDACONTEXTHELPER"),
                "DBCallerEx").getAttribute("ref"));
        Element instance = bean(document, "EAISERVICE");
        assertEquals("SRFDACONTEXTHELPER", property(instance, "globalHelper").getAttribute("ref"));
        Element config = property(instance, "config");
        assertEquals("service-1", entry(config, "SERVICEID").getAttribute("value"));
        assertEquals(1, countEntries(config, "SERVICEID"));
        assertEquals("/tmp/eai-config", entry(config, "CONFIGPATH").getAttribute("value"));
        assertEquals("development", entry(config, "APPMODE").getAttribute("value"));
        assertEquals("Sample", document.getElementsByTagName("model").item(0)
                .getAttributes().getNamedItem("name").getNodeValue());
    }

    private static Element bean(Document document, String id) {
        NodeList beans = document.getElementsByTagNameNS(SPRING, "bean");
        for (int i = 0; i < beans.getLength(); i++) {
            Element bean = (Element) beans.item(i);
            if (id.equals(bean.getAttribute("id"))) return bean;
        }
        throw new AssertionError("Missing bean " + id);
    }

    private static Element property(Element bean, String name) {
        NodeList properties = bean.getElementsByTagNameNS(SPRING, "property");
        for (int i = 0; i < properties.getLength(); i++) {
            Element property = (Element) properties.item(i);
            if (name.equals(property.getAttribute("name"))) return property;
        }
        throw new AssertionError("Missing property " + name);
    }

    private static Element entry(Element property, String key) {
        NodeList entries = property.getElementsByTagNameNS(SPRING, "entry");
        for (int i = 0; i < entries.getLength(); i++) {
            Element entry = (Element) entries.item(i);
            if (key.equals(entry.getAttribute("key"))) return entry;
        }
        throw new AssertionError("Missing entry " + key);
    }

    private static int countEntries(Element property, String key) {
        int count = 0;
        NodeList entries = property.getElementsByTagNameNS(SPRING, "entry");
        for (int i = 0; i < entries.getLength(); i++) {
            if (key.equals(((Element) entries.item(i)).getAttribute("key"))) count++;
        }
        return count;
    }
}
