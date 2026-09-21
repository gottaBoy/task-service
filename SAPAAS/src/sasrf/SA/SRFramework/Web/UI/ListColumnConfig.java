/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.ParamConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ListColumnConfig
extends XMLConfig {
    protected static String ITEMPARAMS = "ITEMPARAMS";
    protected static String ITEMPARAM = "ITEMPARAM";
    protected static String ORDERID = "ORDERID";
    protected static String COLUMNNAME = "COLUMNNAME";
    protected static String ITEMFORMAT = "ITEMFORMAT";
    protected static String VALUEFORMAT = "VALUEFORMAT";
    protected static String USERCOLUMN = "USERCOLUMN";
    protected static String DBFIELD = "DBFIELD";
    protected static String ALIGN = "ALIGN";
    protected static String TRIMLEN = "TRIMLEN";
    protected static String SHOWORDER = "SHOWORDER";
    protected static String WIDTH = "WIDTH";
    protected static String CELLSTYLE = "CELLSTYLE";
    protected int nOrderId = -1;
    protected int nShowOrder = -1;
    protected int nWidth = 100;
    protected String strColumnName = "";
    protected String strItemFormat = "%1$s";
    protected boolean bManual = false;
    protected String strDBField = "";
    protected String strAlign = "";
    protected int nTrimLen = 0;
    protected String strUserColumn = "";
    protected String strCellStyle = "";
    protected ArrayList itemParamList = new ArrayList();

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(ITEMPARAMS) == 0) {
            this.OnLoadItemParams(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void OnLoadItemParams(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            ParamConfig item;
            Node childNode = nodes.item(i);
            if (childNode.getNodeName().compareToIgnoreCase(ITEMPARAM) == 0 && (item = new ParamConfig()).LoadConfig(childNode)) {
                this.itemParamList.add(item);
            }
            ++i;
        }
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(ORDERID) == 0) {
            this.nOrderId = ListColumnConfig.GetValue(strValue, this.nOrderId);
            return;
        }
        if (strName.compareToIgnoreCase(SHOWORDER) == 0) {
            this.nShowOrder = ListColumnConfig.GetValue(strValue, this.nShowOrder);
            return;
        }
        if (strName.compareToIgnoreCase(WIDTH) == 0) {
            this.nWidth = ListColumnConfig.GetValue(strValue, this.nWidth);
            return;
        }
        if (strName.compareToIgnoreCase(COLUMNNAME) == 0) {
            this.strColumnName = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(VALUEFORMAT) == 0 || strName.compareToIgnoreCase(ITEMFORMAT) == 0) {
            this.strItemFormat = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(CELLSTYLE) == 0) {
            this.strCellStyle = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(USERCOLUMN) == 0) {
            this.strUserColumn = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(DBFIELD) == 0) {
            this.strDBField = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(ALIGN) == 0) {
            this.strAlign = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(TRIMLEN) == 0) {
            this.nTrimLen = ListColumnConfig.GetValue(strValue, 0);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getOrderId() {
        return this.nOrderId;
    }

    public int getShowOrder() {
        return this.nShowOrder;
    }

    public int getWidth() {
        return this.nWidth;
    }

    public String getColumnName() {
        return this.strColumnName;
    }

    public String getItemFormat() {
        return this.strItemFormat;
    }

    public String getDBField() {
        return this.strDBField;
    }

    public boolean getManual() {
        return StringHelper.StringLength(this.strUserColumn) != 0;
    }

    public String getUserColumn() {
        return this.strUserColumn;
    }

    public ArrayList getItemParams() {
        return this.itemParamList;
    }

    public String getAlign() {
        return this.strAlign;
    }

    public int getTrimLen() {
        return this.nTrimLen;
    }

    public String getCellStyle() {
        return this.strCellStyle;
    }
}

