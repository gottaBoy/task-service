/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.BaseXYDataHelper;
import SA.SRFramework.Data.DataItem;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;

public abstract class BaseXYZDataHelper
extends BaseXYDataHelper {
    protected String dataZField = "";
    protected String dataZFormatString = "";
    protected String dataZDefault = "";

    public void setDataZField(String value) {
        this.dataZField = value;
    }

    public void setDataZFormatString(String value) {
        this.dataZFormatString = value;
    }

    public String getDataZField() {
        return this.dataZField;
    }

    public String getDataZFormatString() {
        return this.dataZFormatString;
    }

    @Override
    protected void OnFillRow(DataItem dataItem, DataRow dr) throws Exception {
        super.OnFillRow(dataItem, dr);
        Object objValue = this.dataZDefault;
        if (StringHelper.StringLength(this.dataZField) != 0 && !dr.IsDBNull(this.dataZField)) {
            objValue = dr.Get(this.dataZField);
        }
        if (StringHelper.StringLength(this.dataZFormatString) != 0) {
            dataItem.setZ(String.format(this.dataZFormatString, objValue));
        } else {
            dataItem.setZ(objValue.toString());
        }
    }

    public String getDataZDefault() {
        return this.dataZDefault;
    }

    public void setDataZDefault(String value) {
        this.dataZDefault = value;
    }
}

