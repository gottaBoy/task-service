/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.TreePanelConfig;

public class TabViewSideBarConfig
extends TreePanelConfig {
    public static final String TAG_TABVIEWSIDEBAR = "SRFEXTABVIEWSIDEBAR";
    public static final String TAG_FIRSTASROOT = "FIRSTASROOT";
    protected boolean bFirstAsRoot = true;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_FIRSTASROOT, (boolean)true) == 0) {
            this.setFirstAsRoot(TabViewSideBarConfig.GetValue((String)strValue, (boolean)this.bFirstAsRoot));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getFirstAsRoot() {
        return this.bFirstAsRoot;
    }

    public void setFirstAsRoot(boolean bFirstAsRoot) {
        this.bFirstAsRoot = bFirstAsRoot;
    }
}

