/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class DPEventConfig
extends XMLConfig {
    public static final String TAG_DPEVENT = "SRFEXDPEVENT";
    public static final String TAG_FORMITEM = "FORMITEM";
    public static final String TAG_EVENT = "EVENT";
    protected String strFormItem = "";
    protected String strEvent = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_FORMITEM, (boolean)true) == 0) {
            this.strFormItem = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EVENT, (boolean)true) == 0) {
            this.strEvent = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getFormItem() {
        return this.strFormItem;
    }

    public void setFormItem(String strFormItem) {
        this.strFormItem = strFormItem;
    }

    public String getEvent() {
        return this.strEvent;
    }

    public void setEvent(String strEvent) {
        this.strEvent = strEvent;
    }
}

