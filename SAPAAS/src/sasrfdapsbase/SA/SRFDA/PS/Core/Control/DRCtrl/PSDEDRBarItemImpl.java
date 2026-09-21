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

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBar;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarGroup;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarItem;
import SA.SRFDA.PS.Core.Control.DRCtrl.PSDEDRCtrlItemImpl;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRBarItemImpl
extends PSDEDRCtrlItemImpl
implements IPSDEDRBarItem {
    private static final Log log = LogFactory.getLog(PSDEDRBarItemImpl.class);
    protected IPSDEDRBarGroup iPSDEDRBarGroup;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDRBar iPSDEDRBar, IPSDEDRBarGroup iPSDEDRBarGroup, IPSDEDRDetail iPSDEDRDetail) throws Exception {
        this.iPSDEDRBarGroup = iPSDEDRBarGroup;
        super.init(iDAGlobalHelper, iPSDEDRBar, iPSDEDRDetail);
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u680f\u9879\u5206\u7ec4", dumpref=true, from="IPSDEDRBar")
    public IPSDEDRBarGroup getPSDEDRBarGroup() {
        return this.iPSDEDRBarGroup;
    }

    @Override
    public String getModelType() {
        return "PSDEDRBARITEM";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEDRBarGroup().getModelId(), (Object)this.getId());
    }
}

