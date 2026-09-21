/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.UI.DPItemConfig;
import java.util.ArrayList;

public class DPRawItemConfig
extends DPItemConfig {
    public static final String TAG_DPRAWITEM = "SRFEXDPRAWITEM";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_CUSTOM = "CUSTOM";
    protected String strContent = "";
    protected String strCustom = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_CONTENT, (String)strName, (boolean)true) == 0) {
            this.setContent(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_CUSTOM, (String)strName, (boolean)true) == 0) {
            this.setCustom(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getContent() {
        return this.strContent;
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    public String getCustom() {
        return this.strCustom;
    }

    public void setCustom(String strCustom) {
        this.strCustom = strCustom;
    }

    @Override
    protected void OnGetFormCtrlConfig(ArrayList list) {
        if (!StringHelper.IsNullOrEmpty((String)this.strCustom)) {
            if (StringHelper.IsNullOrEmpty((String)this.getID())) {
                this.setID(Helper.GenGuid());
            }
            list.add(this);
        }
    }
}

