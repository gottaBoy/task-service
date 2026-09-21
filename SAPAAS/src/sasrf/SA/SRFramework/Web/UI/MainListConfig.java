/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Web.UI.KeyFieldConfig;
import SA.SRFramework.Web.UI.ListViewConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MainListConfig
extends ListViewConfig {
    protected static String KEYFIELDS = "KEYFIELDS";
    protected static String KEYFIELD = "KEYFIELD";
    protected static String CALLOUTSIDEFUNC = "CALLOUTSIDEFUNC";
    protected static String EXCELEXPORTERID = "EXCELEXPORTERID";
    protected ArrayList arrayKeyField = new ArrayList();
    protected String strCallOutsideFunc = "";
    protected String strExcelExporterId = "";

    public MainListConfig() {
        this.nItemCountPerPage = 0;
    }

    public ArrayList getKeyItems() {
        return this.arrayKeyField;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(KEYFIELDS) == 0) {
            this.OnLoadKeyFields(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(CALLOUTSIDEFUNC) == 0) {
            this.strCallOutsideFunc = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(EXCELEXPORTERID) == 0) {
            this.strExcelExporterId = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadKeyFields(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            KeyFieldConfig item;
            Node childNode = nodes.item(i);
            if (childNode.getNodeName().compareToIgnoreCase(KEYFIELD) == 0 && (item = new KeyFieldConfig()).LoadConfig(childNode)) {
                this.arrayKeyField.add(item);
            }
            ++i;
        }
    }

    public String getCallOutsideFunc() {
        return this.strCallOutsideFunc;
    }

    public String getExcelExporterId() {
        return this.strExcelExporterId;
    }
}

