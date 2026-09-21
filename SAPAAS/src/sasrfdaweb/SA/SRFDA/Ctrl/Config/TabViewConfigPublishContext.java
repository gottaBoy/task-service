/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DAConfigPublishContext
 *  SA.SRFDA.Ctrl.Data.PP.PPEVTabView
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.ITabViewConfigPublishContext;
import SA.SRFDA.Ctrl.DAConfigPublishContext;
import SA.SRFDA.Ctrl.Data.PP.PPEVTabView;
import SA.SRFramework.Utility.StringHelper;

public class TabViewConfigPublishContext
extends DAConfigPublishContext
implements ITabViewConfigPublishContext {
    private String strDERGroupId = "";
    private PPEVTabView ppEVTabView = null;
    private boolean bPublishForm = true;

    @Override
    public String getDERGroupId() {
        if (!StringHelper.IsNullOrEmpty((String)this.strDERGroupId)) {
            return this.strDERGroupId;
        }
        if (this.getPPEVTabView() != null) {
            return this.getPPEVTabView().getDERGROUPID();
        }
        return this.strDERGroupId;
    }

    @Override
    public PPEVTabView getPPEVTabView() {
        return this.ppEVTabView;
    }

    @Override
    public boolean isPublishForm() {
        return this.bPublishForm;
    }

    public void setDERGroupId(String strDERGroupId) {
        this.strDERGroupId = strDERGroupId;
    }

    public void setPPEVTabView(PPEVTabView ppEVTabView) {
        this.ppEVTabView = ppEVTabView;
    }

    public void setPublishForm(boolean bPublishForm) {
        this.bPublishForm = bPublishForm;
    }
}

