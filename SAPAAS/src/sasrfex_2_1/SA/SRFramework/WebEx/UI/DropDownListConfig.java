/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ListControlConfig;

public class DropDownListConfig
extends ListControlConfig {
    public static final String TAG_DROPDOWNLIST = "SRFEXDROPDOWNLIST";
    public static final String TAG_CONTAINER = "CONTAINER";
    protected boolean bContainer = true;

    public DropDownListConfig() {
        this.strCssClass = "sx-select";
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CONTAINER, (boolean)true) == 0) {
            this.bContainer = XMLConfig.GetValue((String)strValue, (boolean)this.bContainer);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean isContainer() {
        return this.bContainer;
    }

    public void setContainer(boolean bContainer) {
        this.bContainer = bContainer;
    }
}

