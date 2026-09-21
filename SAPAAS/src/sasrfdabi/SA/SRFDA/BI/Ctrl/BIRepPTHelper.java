/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepPT;
import SA.SRFDA.BI.Ctrl.Data.BIRepPanel;
import SA.SRFDA.BI.Ctrl.IBIRepPTHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Hashtable;

public class BIRepPTHelper
extends BaseBIObject
implements IBIRepPTHelper {
    protected IBIRepPanelHelper iBIRepPanelHelper = null;
    protected BIRepPT biRepPT = null;
    protected Hashtable<String, IBIRepPanelHelper> biRepPanelHelperMap = new Hashtable();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, BIRepPT biRepPT) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepPT = biRepPT;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public IBIRepPanelHelper FindBIRepPanel(BIRepPanel biRepPanel) throws Exception {
        IBIRepPanelHelper iBIRepPanelHelper = this.biRepPanelHelperMap.get(biRepPanel.getBIREPPANELID());
        if (iBIRepPanelHelper != null && iBIRepPanelHelper.getVersion() == biRepPanel.getVERSION()) {
            return iBIRepPanelHelper;
        }
        iBIRepPanelHelper = this.OnCreateBIRepPanelHelper(biRepPanel);
        iBIRepPanelHelper.Init(this.iDAGlobalHelper, this, biRepPanel);
        this.biRepPanelHelperMap.put(biRepPanel.getBIREPPANELID(), iBIRepPanelHelper);
        return iBIRepPanelHelper;
    }

    protected IBIRepPanelHelper OnCreateBIRepPanelHelper(BIRepPanel biRepPanel) throws Exception {
        return new BIRepPanelHelper();
    }

    @Override
    public String getPTModel() {
        return this.biRepPT.getPANELMODEL();
    }

    @Override
    public int getVersion() {
        return this.biRepPT.getVERSION();
    }
}

