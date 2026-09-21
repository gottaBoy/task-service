/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.RemoteTabPageConfig;

public class TabViewPageConfig
extends RemoteTabPageConfig {
    public static final String TAG_TABVIEWPAGE = "SRFEXTABVIEWPAGE";
    public static final String TAG_VISIBLE = "VISIBLE";
    public static final String TAG_VISIBLECONDITION = "VISIBLECONDITION";
    protected boolean bVisible = true;
    protected String strVisibleCondition = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_VISIBLE, (boolean)true) == 0) {
            this.bVisible = TabViewPageConfig.GetValue((String)strValue, (boolean)this.bVisible);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VISIBLECONDITION, (boolean)true) == 0) {
            this.strVisibleCondition = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void setVisible(boolean bVisible) {
        this.bVisible = bVisible;
    }

    @Override
    public boolean getVisible() {
        return this.bVisible;
    }

    public String getVisibleCondition() {
        return this.strVisibleCondition;
    }

    public void setVisibleCondition(String strVisibleCondition) {
        this.strVisibleCondition = strVisibleCondition;
    }
}

