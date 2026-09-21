/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.UI.DPBaseGroupConfig;

public class DPGroupConfig
extends DPBaseGroupConfig {
    public static final String TAG_DPGROUP = "SRFEXDPGROUP";
    public static final String TAG_SHOWCAPTION = "SHOWCAPTION";
    public static final String TAG_EXPANDER = "EXPANDER";
    public static final String EXPANDER_EXPAND = "EXPAND";
    public static final String EXPANDER_COLLAPSE = "COLLAPSE";
    protected boolean bShowCaption = false;
    protected String strExpander = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWCAPTION, (boolean)true) == 0) {
            this.setShowCaption(DPGroupConfig.GetValue((String)strValue, (boolean)this.bShowCaption));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EXPANDER, (boolean)true) == 0) {
            this.setExpander(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    public void setShowCaption(boolean showCaption) {
        this.bShowCaption = showCaption;
    }

    public String getExpander() {
        return this.strExpander;
    }

    public void setExpander(String strExpander) {
        this.strExpander = strExpander;
    }

    @Override
    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
        DPGroupConfig real = (DPGroupConfig)((Object)dst);
        real.setShowCaption(this.isShowCaption());
        real.setExpander(this.getExpander());
    }

    protected Object CreateCloneObject() {
        return new DPGroupConfig();
    }
}

