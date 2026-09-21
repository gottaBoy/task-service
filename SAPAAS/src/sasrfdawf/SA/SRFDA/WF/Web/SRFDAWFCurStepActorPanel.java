/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.WebEx.SRFExHidden
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.WF.Web.UI.WFCurStepActorPanelConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.WebEx.SRFExHidden;
import java.io.Writer;

public class SRFDAWFCurStepActorPanel
extends SRFExHidden {
    protected WFCurStepActorPanelConfig wfCurStepActorPanelConfig = null;

    protected XMLConfig CreateConfig() {
        return new WFCurStepActorPanelConfig();
    }

    public WFCurStepActorPanelConfig getWFCurStepActorPanelConfig() {
        return this.wfCurStepActorPanelConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.wfCurStepActorPanelConfig = null;
        if (this.config != null && this.config instanceof WFCurStepActorPanelConfig) {
            this.wfCurStepActorPanelConfig = (WFCurStepActorPanelConfig)this.config;
        }
    }

    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean IsSupportModify() {
        return false;
    }
}

