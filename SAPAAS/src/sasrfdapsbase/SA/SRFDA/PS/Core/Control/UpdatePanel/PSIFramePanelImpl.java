/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.UpdatePanel;

import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlImpl;
import SA.SRFDA.PS.Core.Control.UpdatePanel.IPSIFramePanel;
import SA.SRFDA.PS.Core.Control.UpdatePanel.IPSIFramePanelParam;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

@PSModelIgnoreMeta
public class PSIFramePanelImpl
extends PSControlImpl
implements IPSIFramePanel {
    protected IPSIFramePanelParam iPSIFramePanelParam = null;
    private int nTimer = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSControlContainer(iPSControlContainer);
        this.setName(strName);
        if (iPSControlParam != null) {
            this.iPSIFramePanelParam = (IPSIFramePanelParam)iPSControlParam;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.iPSIFramePanelParam.getPSDEId()) && StringHelper.Compare((String)this.iPSIFramePanelParam.getPSDEId(), (String)this.getPSDataEntity().getId(), (boolean)true) != 0) {
            this.setPSDataEntity(this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.iPSIFramePanelParam.getPSDEId()));
        }
        super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    protected void onInit() throws Exception {
        if (this.iPSIFramePanelParam.getTimer() != null && this.iPSIFramePanelParam.getTimer() > 0) {
            this.nTimer = this.iPSIFramePanelParam.getTimer();
        }
        super.onInit();
    }

    @Override
    protected String onGetControlType() {
        return "IFRAMEPANEL";
    }

    @Override
    public String getModelScope() {
        return "VIEW";
    }

    @Override
    public int getTimer() {
        return this.nTimer;
    }

    @Override
    public String getModelType() {
        return "PSIFRAMEPANEL";
    }
}

