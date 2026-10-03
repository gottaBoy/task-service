package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DEFHelper.DEFHelperMgr;
import SA.SRFDA.Ctrl.FormCtrlHelper.FormCtrlWriterMgr;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterMgr;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import junit.framework.TestCase;
import org.w3c.dom.Node;

public class XMLCollectionManagersTest extends TestCase {
    private Node parse(String xml) throws Exception {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder()
            .parse(new ByteArrayInputStream(xml.getBytes("UTF-8"))).getDocumentElement();
    }

    public void testToolbarItemWriterLoadsTypedChild() throws Exception {
        ToolbarItemWriterMgr mgr = new ToolbarItemWriterMgr();
        assertTrue(mgr.LoadConfig(parse(
            "<root><SRFDATOOLBARITEMWRITER ID=\"toolbar\" OBJECT=\"example.Toolbar\"/></root>")));
        assertEquals(1, mgr.size());
        assertEquals("toolbar", mgr.get(0).getID());
        assertEquals("example.Toolbar", mgr.get(0).getObject());
    }

    public void testFormCtrlWriterLoadsTypedChild() throws Exception {
        FormCtrlWriterMgr mgr = new FormCtrlWriterMgr();
        assertTrue(mgr.LoadConfig(parse(
            "<root><SRFDAFORMCTRLWRITER ID=\"form\" OBJECT=\"example.Form\"/></root>")));
        assertEquals(1, mgr.size());
        assertEquals("form", mgr.get(0).getID());
        assertEquals("example.Form", mgr.get(0).getObject());
    }

    public void testDEFHelperLoadsTypedChildAndIndex() throws Exception {
        DEFHelperMgr mgr = new DEFHelperMgr();
        assertTrue(mgr.LoadConfig(parse(
            "<root><SRFDADEFHELPER ID=\"field\" OBJECT=\"example.Helper\"/></root>")));
        assertEquals(1, mgr.size());
        assertSame(mgr.get(0), mgr.FindDEFHelper("FIELD"));
        assertEquals("example.Helper", mgr.get(0).getObject());
    }
}
