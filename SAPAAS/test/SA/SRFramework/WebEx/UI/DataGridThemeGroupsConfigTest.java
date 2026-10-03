package SA.SRFramework.WebEx.UI;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import junit.framework.TestCase;
import org.w3c.dom.Node;

public class DataGridThemeGroupsConfigTest extends TestCase {
    private Node parse(String xml) throws Exception {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder()
            .parse(new ByteArrayInputStream(xml.getBytes("UTF-8"))).getDocumentElement();
    }

    public void testThemeListLoadsTypedGroupsAndThemes() throws Exception {
        DataGridThemeListConfig list = new DataGridThemeListConfig();
        assertTrue(list.LoadConfig(parse(
            "<DATAGRIDTHEMELIST><DATAGRIDTHEMEGROUPS>"
                + "<DATAGRIDTHEMEGROUP GROUPNAME=\"first\">"
                + "<DATAGRIDTHEME THEMENAME=\"light\" ACTIVE=\"true\" URL=\"/light.css\"/>"
                + "<DATAGRIDTHEME THEMENAME=\"dark\" URL=\"/dark.css\"/>"
                + "</DATAGRIDTHEMEGROUP>"
                + "<DATAGRIDTHEMEGROUP GROUPNAME=\"second\">"
                + "<DATAGRIDTHEME THEMENAME=\"compact\"/>"
                + "</DATAGRIDTHEMEGROUP>"
                + "</DATAGRIDTHEMEGROUPS></DATAGRIDTHEMELIST>")));

        DataGridThemeGroupsConfig groups = list.GetDataGridThemeGroupsConfig();
        assertEquals(2, groups.size());
        DataGridThemeGroupConfig first = groups.get(0);
        assertEquals("first", first.getGroupName());
        assertEquals(2, first.size());
        DataGridThemeConfig light = first.get(0);
        assertEquals("light", light.getThemeName());
        assertEquals("/light.css", light.getURL());
        assertTrue(light.isActive());
        assertEquals("dark", first.get(1).getThemeName());
        assertEquals("second", groups.get(1).getGroupName());
        assertEquals("compact", groups.get(1).get(0).getThemeName());
    }

    public void testUnknownNodesAreNotAdded() throws Exception {
        DataGridThemeGroupsConfig groups = new DataGridThemeGroupsConfig();
        assertTrue(groups.LoadConfig(parse(
            "<DATAGRIDTHEMEGROUPS><OTHER/>"
                + "<DATAGRIDTHEMEGROUP GROUPNAME=\"valid\">"
                + "<OTHER/><DATAGRIDTHEME THEMENAME=\"only\"/>"
                + "</DATAGRIDTHEMEGROUP></DATAGRIDTHEMEGROUPS>")));
        assertEquals(1, groups.size());
        assertEquals(1, groups.get(0).size());
        assertEquals("only", groups.get(0).get(0).getThemeName());
    }
}
