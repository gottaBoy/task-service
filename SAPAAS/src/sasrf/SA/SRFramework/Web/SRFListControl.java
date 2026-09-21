/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.Web.ListItemCollection;
import SA.SRFramework.Web.SRFWebControl;

public abstract class SRFListControl
extends SRFWebControl {
    protected ListItemCollection listItemCollection = new ListItemCollection();
    protected boolean autoPostBack = false;
    protected String dataTextField = "";
    protected String dataValueField = "";
    protected Object dataSource = null;
    protected String dataTextFormatString = "";
    protected String strSelectValue = "";

    public ListItemCollection getItems() {
        return this.listItemCollection;
    }

    public void setAutoPostBack(boolean autoPostBack) {
        this.autoPostBack = autoPostBack;
    }

    public void setDataTextField(String dataTextField) {
        this.dataTextField = dataTextField;
    }

    public void setDataValueField(String dataValueField) {
        this.dataValueField = dataValueField;
    }

    public void setDataSource(Object dataSource) {
        this.dataSource = dataSource;
    }

    public void DataBind() throws Exception {
        DataTable dt = null;
        if (this.dataSource == null) {
            throw new Exception("Invalid DataSource");
        }
        if (this.dataSource.getClass().getName() == DataTable.class.getName()) {
            dt = (DataTable)this.dataSource;
        } else if (this.dataSource.getClass().getName() == DataSet.class.getName()) {
            DataSet ds = (DataSet)this.dataSource;
            dt = ds.getTable(0);
        }
        if (dt == null) {
            throw new Exception("Invalid DataSource");
        }
        int nRowCount = dt.GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            DataRow dr = dt.GetRow(i);
            ListItem listItem = new ListItem();
            if (StringHelper.StringLength(this.dataTextFormatString) != 0) {
                listItem.setText(String.format(this.dataTextFormatString, dr.Get(this.dataTextField)));
            } else {
                listItem.setText(dr.Get(this.dataTextField).toString());
            }
            listItem.setValue(dr.Get(this.dataValueField).toString());
            this.listItemCollection.Add(listItem);
            ++i;
        }
    }

    public void setDataTextFormatString(String dataTextFormatString) {
        this.dataTextFormatString = dataTextFormatString;
    }

    public boolean getAutoPostBack() {
        return this.autoPostBack;
    }

    public String getDataTextField() {
        return this.dataTextField;
    }

    public String getDataValueField() {
        return this.dataValueField;
    }

    public String getDataTextFormatString() {
        return this.dataTextFormatString;
    }

    public ListItem getSelectedItem() {
        if (StringHelper.StringLength(this.strSelectValue) == 0) {
            return null;
        }
        return this.listItemCollection.FindByValue(this.strSelectValue);
    }

    public String getSelectedValue() {
        return this.strSelectValue;
    }

    public void setSelectedValue(String value) {
        this.strSelectValue = value;
    }

    @Override
    protected boolean OnReadFromViewStates() {
        String strKey = String.valueOf(this.getUniqueID()) + "_LC";
        Object objValue = this.getPage().getViewStates().Get(strKey);
        if (objValue != null) {
            this.listItemCollection.fromString((String)objValue);
        }
        return false;
    }

    @Override
    protected boolean OnWriteToViewStates() {
        String strListString = this.listItemCollection.toString();
        String strKey = String.valueOf(this.getUniqueID()) + "_LC";
        this.getPage().getViewStates().Set(strKey, strListString);
        return false;
    }
}

