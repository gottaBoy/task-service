/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DataItem;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;

public class BaseXDataHelper {
    protected String dataXField = "";
    protected Object dataSource = null;
    protected String dataXFormatString = "";
    protected String dataXDefault = "";
    protected ArrayList itemList = new ArrayList();

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
        this.itemList.clear();
        int nRowCount = dt.GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            DataRow dr = dt.GetRow(i);
            DataItem dataItem = new DataItem();
            this.OnFillRow(dataItem, dr);
            this.itemList.add(dataItem);
            ++i;
        }
    }

    protected void OnFillRow(DataItem dataItem, DataRow dr) throws Exception {
        Object objValue = this.dataXDefault;
        if (StringHelper.StringLength(this.dataXField) != 0 && !dr.IsDBNull(this.dataXField)) {
            objValue = dr.Get(this.dataXField);
        }
        if (StringHelper.StringLength(this.dataXFormatString) != 0) {
            dataItem.setX(String.format(this.dataXFormatString, objValue));
        } else {
            dataItem.setX(objValue.toString());
        }
    }

    public void setDataXFormatString(String value) {
        this.dataXFormatString = value;
    }

    public void setDataXField(String value) {
        this.dataXField = value;
    }

    public String getDataXField() {
        return this.dataXField;
    }

    public String getDataXFormatString() {
        return this.dataXFormatString;
    }

    public String getDataXDefault() {
        return this.dataXDefault;
    }

    public void setDataXDefault(String value) {
        this.dataXDefault = value;
    }
}

