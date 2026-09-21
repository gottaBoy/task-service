/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.DGModelColumnsConfig;
import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class DataGridModelConfig
extends XMLConfig {
    public static final String TAG_DATAGRIDMODEL = "SRFDADATAGRIDMODEL";
    protected DGModelColumnsConfig dataGridColumnsConfig = new DGModelColumnsConfig();
    protected DGModelMainQueryConfig mainQueryConfig = new DGModelMainQueryConfig();
    public static final String TAG_SORTFIELD = "SORTFIELD";
    public static final String TAG_SORTDESC = "SORTDESC";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    protected String strSortField = "";
    protected boolean bSortDesc = false;
    protected int nPageSize = 20;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_SORTFIELD, (boolean)true) == 0) {
            this.strSortField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SORTDESC, (boolean)true) == 0) {
            this.bSortDesc = StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PAGESIZE, (boolean)true) == 0) {
            this.nPageSize = DataGridModelConfig.GetValue((String)strValue, (int)this.nPageSize);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFDADGMODELCOLUMNS", (boolean)true) == 0) {
            this.dataGridColumnsConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDADGMODELMAINQUERY", (boolean)true) == 0) {
            this.mainQueryConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DGModelColumnsConfig getColumnsConfig() {
        return this.dataGridColumnsConfig;
    }

    public DGModelMainQueryConfig getMainQueryConfig() {
        return this.mainQueryConfig;
    }

    public void setSortField(String strSortField) {
        this.strSortField = strSortField;
    }

    public String getSortField() {
        return this.strSortField;
    }

    public void setSortDesc(boolean bSortDesc) {
        this.bSortDesc = bSortDesc;
    }

    public boolean getSortDesc() {
        return this.bSortDesc;
    }

    public void setPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
    }

    public int getPageSize() {
        return this.nPageSize;
    }
}

