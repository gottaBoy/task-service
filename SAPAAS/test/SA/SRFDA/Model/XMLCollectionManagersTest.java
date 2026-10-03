package SA.SRFDA.Model;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import junit.framework.TestCase;
import org.w3c.dom.Node;

public class XMLCollectionManagersTest extends TestCase {
    private Node parse(String xml) throws Exception {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder()
            .parse(new ByteArrayInputStream(xml.getBytes("UTF-8"))).getDocumentElement();
    }

    public void testValueFuncLoadsTypedChild() throws Exception {
        ValueFuncMgr mgr = new ValueFuncMgr();
        assertTrue(mgr.LoadConfig(parse(
            "<root><SRFDAVALUEFUNC ID=\"func\" OBJECT=\"example.Func\"/></root>")));
        assertEquals(1, mgr.size());
        assertEquals("func", mgr.get(0).getID());
        assertEquals("example.Func", mgr.get(0).getObject());
    }

    public void testValueRuleLoadsTypedChildAndIndex() throws Exception {
        ValueRuleMgr mgr = new ValueRuleMgr();
        assertTrue(mgr.LoadConfig(parse(
            "<root><SRFDAVALUERULE ID=\"rule\" RULE=\"true\"/></root>")));
        assertEquals(1, mgr.size());
        assertSame(mgr.get(0), mgr.FindRuleConfig("RULE"));
        assertEquals("true", mgr.get(0).getRule());
    }

    public void testDGColRenderLoadsTypedChildAndLookup() throws Exception {
        DGColRenderMgr mgr = new DGColRenderMgr();
        assertTrue(mgr.LoadConfig(parse(
            "<root><SRFDADGCOLRENDER ID=\"render\" OBJECT=\"example.Render\"/></root>")));
        assertEquals(1, mgr.size());
        assertSame(mgr.get(0), mgr.FindDGColRenderConfig("RENDER"));
        assertEquals("example.Render", mgr.get(0).getObject());
    }
}
