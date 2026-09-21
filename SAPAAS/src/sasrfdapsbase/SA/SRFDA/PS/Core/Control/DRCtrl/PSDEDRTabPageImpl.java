/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRTab;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRTabPage;
import SA.SRFDA.PS.Core.Control.DRCtrl.PSDEDRCtrlItemImpl;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRTabPageImpl
extends PSDEDRCtrlItemImpl
implements IPSDEDRTabPage {
    private static final Log log = LogFactory.getLog(PSDEDRTabPageImpl.class);
    private IPSDEDRTab iPSDEDRTab = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDRTab iPSDEDRTab, IPSDEDRDetail iPSDEDRDetail) throws Exception {
        this.iPSDEDRTab = iPSDEDRTab;
        super.init(iDAGlobalHelper, iPSDEDRTab, iPSDEDRDetail);
    }

    @Override
    public String getModelType() {
        return "PSDEDRTABPAGE";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEDRCtrl().getModelId(), (Object)this.getId());
    }

    public IPSDEDRTab getPSDEDRTab() {
        return this.iPSDEDRTab;
    }
}

