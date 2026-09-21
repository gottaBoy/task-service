/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.BaseXDataHelper;
import SA.SRFramework.Data.DataItem;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;

public abstract class BaseXYDataHelper
extends BaseXDataHelper {
    protected String dataYField = "";
    protected String dataYFormatString = "";
    protected String dataYDefault = "";

    public void setDataYField(String value) {
        this.dataYField = value;
    }

    public void setDataYFormatString(String value) {
        this.dataYFormatString = value;
    }

    public String getDataYField() {
        return this.dataYField;
    }

    public String getDataYFormatString() {
        return this.dataYFormatString;
    }

    @Override
    protected void OnFillRow(DataItem dataItem, DataRow dr) throws Exception {
        super.OnFillRow(dataItem, dr);
        Object objValue = this.dataYDefault;
        if (StringHelper.StringLength(this.dataYField) != 0 && !dr.IsDBNull(this.dataYField)) {
            objValue = dr.Get(this.dataYField);
        }
        if (StringHelper.StringLength(this.dataYFormatString) != 0) {
            dataItem.setY(String.format(this.dataYFormatString, objValue));
        } else {
            dataItem.setY(objValue.toString());
        }
    }

    public String getDataYDefault() {
        return this.dataYDefault;
    }

    public void setDataYDefault(String value) {
        this.dataYDefault = value;
    }
}

