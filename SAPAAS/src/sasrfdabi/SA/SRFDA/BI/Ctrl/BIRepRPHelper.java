/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepRP;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.IBIRepRPHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class BIRepRPHelper
extends BaseBIObject
implements IBIRepRPHelper {
    protected IBIReportExHelper iBIReportExHelper = null;
    protected BIRepRP biRepRP = null;
    protected IBIRepPanelHelper iBIRepPanelHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIReportExHelper iBIReportExHelper, BIRepRP biRepRP) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iBIReportExHelper = iBIReportExHelper;
        this.biRepRP = biRepRP;
        this.iBIRepPanelHelper = this.getBIModelStorage().FindBIRepPanel(this.biRepRP.getBIREPPANELID());
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public IBIRepPanelHelper getBIRepPanel() {
        return this.iBIRepPanelHelper;
    }

    @Override
    public String getCaption() {
        return this.biRepRP.getBIREPRPNAME();
    }
}

