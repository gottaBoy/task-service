/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupBottomConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupHeaderConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class GridExcelExportGroupConfig
extends CollectionXMLConfig {
    public static final String TAG_GRIDEXCELEXPORTGROUP = "SRFEXGRIDEXCELEXPORTGROUP";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_DBFIELD = "DBFIELD";
    public static final String TAG_SORTDIRECTION = "SORTDIRECTION";
    public static final String TAG_GROUPEXT = "GROUPEXT";
    public static final String TAG_GROUPEXT_TENDAYS = "TENDAYS";
    protected int nDataType = 25;
    protected String strDBField = "";
    protected String strSortDirection = "ASC";
    protected String strGroupExt = "";
    protected GridExcelExportGroupHeaderConfig gridExcelExportGroupHeaderConfig = null;
    protected GridExcelExportGroupBottomConfig gridExcelExportGroupBottomConfig = null;
    protected GridExcelExportGroupConfig childGridExcelExportGroupConfig = null;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)"SRFEXGRIDEXCELEXPORTGROUPHEADER", (String)strName, (boolean)true) == 0) {
            if (this.gridExcelExportGroupHeaderConfig == null) {
                this.gridExcelExportGroupHeaderConfig = new GridExcelExportGroupHeaderConfig();
            }
            this.gridExcelExportGroupHeaderConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)"SRFEXGRIDEXCELEXPORTGROUPBOTTOM", (String)strName, (boolean)true) == 0) {
            if (this.gridExcelExportGroupBottomConfig == null) {
                this.gridExcelExportGroupBottomConfig = new GridExcelExportGroupBottomConfig();
            }
            this.gridExcelExportGroupBottomConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public GridExcelExportGroupHeaderConfig getHeaderConfig() {
        return this.gridExcelExportGroupHeaderConfig;
    }

    public GridExcelExportGroupBottomConfig getBottomConfig() {
        return this.gridExcelExportGroupBottomConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATATYPE, (boolean)true) == 0) {
            this.nDataType = DataTypeHelper.FromString((String)strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DBFIELD, (boolean)true) == 0) {
            this.strDBField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SORTDIRECTION, (boolean)true) == 0) {
            this.strSortDirection = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GROUPEXT, (boolean)true) == 0) {
            this.strGroupExt = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getDataType() {
        return this.nDataType;
    }

    public void setDataType(int nDataType) {
        this.nDataType = nDataType;
    }

    public String getDBField() {
        if (StringHelper.Length((String)this.strDBField) == 0) {
            return this.getID();
        }
        return this.strDBField;
    }

    public void setDBField(String strDBField) {
        this.strDBField = strDBField;
    }

    public String getSortDirection() {
        return this.strSortDirection;
    }

    public void setSortDirection(String strSortDirection) {
        this.strSortDirection = strSortDirection;
    }

    public void setChildGroupConfig(GridExcelExportGroupConfig value) {
        this.childGridExcelExportGroupConfig = value;
    }

    public GridExcelExportGroupConfig getChildGroupConfig() {
        return this.childGridExcelExportGroupConfig;
    }

    public String getGroupExt() {
        return this.strGroupExt;
    }

    public void setGroupExt(String strGroupExt) {
        this.strGroupExt = strGroupExt;
    }
}

