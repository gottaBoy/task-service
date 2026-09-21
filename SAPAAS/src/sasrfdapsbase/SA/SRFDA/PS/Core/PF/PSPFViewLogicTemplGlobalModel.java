/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PF.PSPFStyleGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFViewLogicTemplImpl;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewLogicTemplGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFViewLogicTempl, IPSPFViewLogicTempl> {
    private static final Log log = LogFactory.getLog(PSPFViewLogicTemplGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSPFViewLogicTempl GetObject(String strPSPFViewLogicTemplId) {
        return null;
    }

    @Override
    protected IPSPFViewLogicTempl OnCreateModelHelper(PSPFViewLogicTempl vt) throws Exception {
        PSPFViewLogicTemplImpl iPSPFViewLogicTempl = new PSPFViewLogicTemplImpl();
        iPSPFViewLogicTempl.init(this.iDAGlobalHelper, this.getPSPF(), this.getPSPFStyle(), vt);
        return iPSPFViewLogicTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFViewLogicTempl obj) {
        return false;
    }

    @Override
    protected IPSPFViewLogicTempl registerModel(PSPFViewLogicTempl vt) throws Exception {
        IPSPFViewLogicTempl iPSPFViewLogicTempl = (IPSPFViewLogicTempl)this.InternalGetModelHelper(vt.getPSPFVLTEMPLID());
        if (iPSPFViewLogicTempl != null) {
            return iPSPFViewLogicTempl;
        }
        this.setModel(vt.getPSPFVLTEMPLID(), vt, null);
        return (IPSPFViewLogicTempl)this.FindModelHelper(vt.getPSPFVLTEMPLID());
    }

    @Override
    protected Vector<PSPFViewLogicTempl> getAllModels() throws Exception {
        Vector<PSPFViewLogicTempl> list = new Vector<PSPFViewLogicTempl>();
        CallResult callResult = this.iPSModelHelper.getPSPFViewLogicTemplsByPFStyle(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u524d\u7aef\u6837\u5f0f\u89c6\u56fe\u903b\u8f91\u6a21\u7248\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected String getObjectId(PSPFViewLogicTempl vt) {
        return vt.getPSPFVLTEMPLID();
    }
}

