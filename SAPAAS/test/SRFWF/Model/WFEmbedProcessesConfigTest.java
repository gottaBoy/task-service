package SRFWF.Model;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import junit.framework.TestCase;

public class WFEmbedProcessesConfigTest extends TestCase {
    public void testLoadsEmbedProcessWithParent() throws Exception {
        WFProcessConfig parent = new WFProcessConfig();
        WFEmbedProcessesConfig processes = new WFEmbedProcessesConfig(parent);
        ByteArrayInputStream xml = new ByteArrayInputStream(
            "<root><SRFEXWFPROCESS ID=\"nested\" NAME=\"Nested\"/></root>".getBytes("UTF-8"));

        assertTrue(processes.LoadConfig(
            DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml).getDocumentElement()));
        assertEquals(1, processes.size());
        assertEquals("nested", processes.get(0).getID());
        assertSame(parent, processes.get(0).getParentProcessConfig());
    }

    public void testLoadsProcessParameter() throws Exception {
        WFParamsConfig params = new WFParamsConfig(new WFProcessConfig());
        ByteArrayInputStream xml = new ByteArrayInputStream(
            "<root><SRFEXWFPARAM NAME=\"key\" VALUE=\"value\"/></root>".getBytes("UTF-8"));

        assertTrue(params.LoadConfig(
            DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml).getDocumentElement()));
        assertEquals(1, params.size());
        assertEquals("key", params.get(0).getName());
        assertEquals("value", params.get(0).getValue());
    }
}
