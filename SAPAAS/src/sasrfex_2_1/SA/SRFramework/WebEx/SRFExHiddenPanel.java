/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.UI.HiddenConfig;
import SA.SRFramework.WebEx.UI.HiddenPanelConfig;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExHiddenPanel
extends SRFExControl {
    protected HiddenPanelConfig hiddenPanelConfig = null;
    private static final Log log = LogFactory.getLog(SRFExHiddenPanel.class);

    public HiddenPanelConfig getHiddenPanelConfig() {
        return this.hiddenPanelConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.hiddenPanelConfig = null;
        if (this.config != null && this.config instanceof HiddenPanelConfig) {
            this.hiddenPanelConfig = (HiddenPanelConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        if (this.hiddenPanelConfig != null) {
            ArrayList controls = this.hiddenPanelConfig.getControls();
            int i = 0;
            while (i < controls.size()) {
                Object objControl = controls.get(i);
                SRFExControl childControl = this.CreateHidden(objControl);
                if (childControl != null) {
                    childControl.setConfig((XMLConfig)controls.get(i));
                    this.AddControl(childControl);
                }
                ++i;
            }
        }
    }

    protected SRFExControl CreateHidden(Object objControl) {
        if (objControl == null) {
            return null;
        }
        if (objControl instanceof HiddenConfig) {
            return new SRFExHidden();
        }
        return null;
    }
}

