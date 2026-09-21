/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Mobile.UIPart.Model;

import SA.SRFDA.Mobile.UIPart.Model.MBUIPartDSItemConfig;
import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class MBUIPartDSConfig
extends CollectionXMLConfig {
    public static final String TAG_MBUIPARTDS = "SRFDAMBUIPARTDS";
    public static final String TAG_SORTFIELD = "SORTFIELD";
    public static final String TAG_SORTDESC = "SORTDESC";
    public static final String TAG_SORTABLE = "SORTABLE";
    public static final String TAG_NODEFSORT = "NODEFSORT";
    protected String strSortField = "";
    protected boolean bSortDesc = false;
    protected boolean bSortable = true;
    protected boolean bNoDefSort = false;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFDAMBUIPARTDSITEM", (boolean)true) == 0) {
            MBUIPartDSItemConfig dataGridDSItemConfig = new MBUIPartDSItemConfig();
            if (dataGridDSItemConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(dataGridDSItemConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_SORTFIELD, (boolean)true) == 0) {
            this.strSortField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SORTDESC, (boolean)true) == 0) {
            this.bSortDesc = StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SORTABLE, (boolean)true) == 0) {
            this.bSortable = StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NODEFSORT, (boolean)true) == 0) {
            this.bNoDefSort = StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public MBUIPartDSItemConfig FindDSItem(String strDSItemId) {
        int nCount = this.arrayList.size();
        int i = 0;
        while (i < nCount) {
            MBUIPartDSItemConfig dsItemConfig = (MBUIPartDSItemConfig)((Object)this.arrayList.get(i));
            if (StringHelper.Compare((String)dsItemConfig.getID(), (String)strDSItemId, (boolean)true) == 0) {
                return dsItemConfig;
            }
            ++i;
        }
        return null;
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

    public void setSortable(boolean bSortable) {
        this.bSortable = bSortable;
    }

    public boolean getSortable() {
        return this.bSortable;
    }

    public boolean getNoDefSort() {
        return this.bNoDefSort;
    }

    public void setNoDefSort(boolean bNoDefSort) {
        this.bNoDefSort = bNoDefSort;
    }
}

