/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.Web.ListItemCollection
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.Web.ListItemCollection;
import SA.SRFramework.WebEx.UI.EditableControlConfig;
import SA.SRFramework.WebEx.UI.ListFillerConfig;
import org.w3c.dom.Node;

public abstract class ListControlConfig
extends EditableControlConfig {
    protected ListItemCollection listItemCollection = new ListItemCollection();
    public static final String TAG_SELECTEDVALUE = "SELECTEDVALUE";
    public static final String TAG_SELECTCHANGEDJSCODE = "SELECTCHANGEDJSCODE";
    protected String strSelectedValue = "";
    protected String dataTextField = "";
    protected String dataValueField = "";
    protected String dataTextFormatString = "";
    protected String strSelectChangedJSCode = "";
    protected ListFillerConfig listFillerConfig = new ListFillerConfig();

    public ListItemCollection getListItems() {
        return this.listItemCollection;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXLISTFILLER", (boolean)true) == 0) {
            this.listFillerConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_SELECTEDVALUE, (boolean)true) == 0) {
            this.strSelectedValue = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SELECTCHANGEDJSCODE, (boolean)true) == 0) {
            this.strSelectChangedJSCode = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getSelectedValue() {
        return this.strSelectedValue;
    }

    public void setSelectedValue(String strSelectedValue) {
        this.strSelectedValue = strSelectedValue;
    }

    public void setDataTextField(String dataTextField) {
        this.dataTextField = dataTextField;
    }

    public void setDataValueField(String dataValueField) {
        this.dataValueField = dataValueField;
    }

    public boolean DataBind(Object objDataSource) {
        DataTable dt;
        block12: {
            block11: {
                if (objDataSource != null) break block11;
                return false;
            }
            dt = null;
            if (objDataSource instanceof DataTable) {
                dt = (DataTable)objDataSource;
            } else if (objDataSource instanceof DataSet) {
                DataSet ds = (DataSet)objDataSource;
                dt = ds.getTable(0);
            }
            if (dt != null) break block12;
            return false;
        }
        try {
            this.listItemCollection.Clear();
            int nRowCount = dt.GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                DataRow dr = dt.GetRow(i);
                ListItem listItem = new ListItem();
                listItem.setText(dr.Get(this.dataTextField).toString());
                listItem.setValue(dr.Get(this.dataValueField).toString());
                this.listItemCollection.Add(listItem);
                ++i;
            }
            if (this.listFillerConfig.getEmptySupported()) {
                ListItem listItem = new ListItem();
                listItem.setText(this.listFillerConfig.getEmptyText());
                listItem.setValue("");
                if (this.listFillerConfig.getEmptyAtFirst()) {
                    this.listItemCollection.Insert(0, listItem);
                } else {
                    this.listItemCollection.Add(listItem);
                }
            }
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ListFillerConfig getListFillerConfig() {
        return this.listFillerConfig;
    }

    public String getSelectChangedJSCode() {
        return this.strSelectChangedJSCode;
    }

    public void setSelectChangedJSCode(String strSelectChangedJSCode) {
        this.strSelectChangedJSCode = strSelectChangedJSCode;
    }
}

