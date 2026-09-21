/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.UI.HiddenConfig
 */
package SA.SRFDA.Web.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.HiddenConfig;

public class QueryDesignerConfig
extends HiddenConfig {
    public static final String TAG_DEFORMITEM = "DEFORMITEM";
    public static final String TAG_DESIGNDGCOLUMN = "DESIGNDGCOLUMN";
    public static final String TAG_EXTSELECT = "EXTSELECT";
    public static final String TAG_EXTCOLUMN = "EXTCOLUMN";
    protected String strDEFormItem = "";
    protected boolean bDesignDGColumn = true;
    protected boolean bExtSelect = false;
    protected boolean bExtColumn = false;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_DEFORMITEM, (String)strName, (boolean)true) == 0) {
            this.strDEFormItem = strValue;
            return;
        }
        if (StringHelper.Compare((String)TAG_DESIGNDGCOLUMN, (String)strName, (boolean)true) == 0) {
            this.bDesignDGColumn = QueryDesignerConfig.GetValue((String)strValue, (boolean)this.bDesignDGColumn);
            return;
        }
        if (StringHelper.Compare((String)TAG_EXTSELECT, (String)strName, (boolean)true) == 0) {
            this.bExtSelect = QueryDesignerConfig.GetValue((String)strValue, (boolean)this.bExtSelect);
            return;
        }
        if (StringHelper.Compare((String)TAG_EXTCOLUMN, (String)strName, (boolean)true) == 0) {
            this.bExtColumn = QueryDesignerConfig.GetValue((String)strValue, (boolean)this.bExtColumn);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDEFormItem() {
        return this.strDEFormItem;
    }

    public void setDEFormItem(String strDEFormItem) {
        this.strDEFormItem = strDEFormItem;
    }

    public boolean getDesignDGColumn() {
        return this.bDesignDGColumn;
    }

    public void setDesignDGColumn(boolean isDesignDGColumn) {
        this.bDesignDGColumn = isDesignDGColumn;
    }

    public boolean getExtSelect() {
        return this.bExtSelect;
    }

    public void setExtSelect(boolean extSelect) {
        this.bExtSelect = extSelect;
    }

    public boolean isExtColumn() {
        return this.bExtColumn;
    }

    public void setExtColumn(boolean bExtColumn) {
        this.bExtColumn = bExtColumn;
    }
}

