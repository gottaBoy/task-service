/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.UI;

import SA.SRFDA.Web.UI.FormDesignerConfig;
import SA.SRFramework.Utility.StringHelper;

public class SearchFormDesignerConfig
extends FormDesignerConfig {
    public static final String TAG_DEFGROUPSPMODE = "DEFGROUPSPMODE";
    protected boolean bDEFGroupSPMode = false;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DEFGROUPSPMODE, (boolean)true) == 0) {
            this.setDEFGroupSPMode(SearchFormDesignerConfig.GetValue((String)strValue, (boolean)this.bDEFGroupSPMode));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean isDEFGroupSPMode() {
        return this.bDEFGroupSPMode;
    }

    public void setDEFGroupSPMode(boolean bDEFGroupSPMode) {
        this.bDEFGroupSPMode = bDEFGroupSPMode;
    }
}

