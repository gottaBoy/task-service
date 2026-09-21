/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BasePanelConfig
extends BaseControlConfig {
    private static final Log log = LogFactory.getLog(BasePanelConfig.class);
    protected BasePanelConfig parentPanelConfig = null;
    public static final String TAG_RESOURCEID = "RESOURCEID";
    public static final String TAG_BORDER = "BORDER";
    protected String strResourceId = null;
    protected boolean bBorder = true;

    public String getResourceId() {
        return this.strResourceId;
    }

    public void setResourceId(String strResourceId) {
        this.strResourceId = strResourceId;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_RESOURCEID, (boolean)true) == 0) {
            this.strResourceId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BORDER, (boolean)true) == 0) {
            this.bBorder = BasePanelConfig.GetValue((String)strValue, (boolean)this.bBorder);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    protected BaseControlConfig CreateControl(String strName) {
        return null;
    }

    public BasePanelConfig getParentPanel() {
        return this.parentPanelConfig;
    }

    public void setParentPanel(BasePanelConfig parentPanelConfig) {
        this.parentPanelConfig = parentPanelConfig;
    }

    public boolean isBorder() {
        return this.bBorder;
    }

    @Override
    public void setBorder(boolean border) {
        this.bBorder = border;
    }
}

