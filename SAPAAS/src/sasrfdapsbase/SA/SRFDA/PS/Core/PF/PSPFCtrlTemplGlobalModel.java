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

import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.PSPFCtrlTemplImpl;
import SA.SRFDA.PS.Core.PF.PSPFStyleGlobalModelBase;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFCtrlTempl, IPSPFCtrlTempl> {
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSPFCtrlTempl GetObject(String strPSPFCtrlTemplId) {
        return null;
    }

    @Override
    protected IPSPFCtrlTempl OnCreateModelHelper(PSPFCtrlTempl vt) throws Exception {
        PSPFCtrlTemplImpl iPSPFCtrlTempl = new PSPFCtrlTemplImpl();
        iPSPFCtrlTempl.init(this.iDAGlobalHelper, this.getPSPF(), this.getPSPFStyle(), vt);
        return iPSPFCtrlTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFCtrlTempl obj) {
        return false;
    }

    @Override
    protected IPSPFCtrlTempl registerModel(PSPFCtrlTempl vt) throws Exception {
        IPSPFCtrlTempl iPSPFCtrlTempl = (IPSPFCtrlTempl)this.InternalGetModelHelper(vt.getPSPFCTRLTEMPLID());
        if (iPSPFCtrlTempl != null) {
            return iPSPFCtrlTempl;
        }
        this.setModel(vt.getPSPFCTRLTEMPLID(), vt, null);
        return (IPSPFCtrlTempl)this.FindModelHelper(vt.getPSPFCTRLTEMPLID());
    }

    @Override
    protected Vector<PSPFCtrlTempl> getAllModels() throws Exception {
        Vector<PSPFCtrlTempl> list = new Vector<PSPFCtrlTempl>();
        CallResult callResult = this.iPSModelHelper.getPSPFCtrlTemplsByPFStyle(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u524d\u7aef\u6837\u5f0f\u90e8\u4ef6\u6a21\u7248\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
    protected String getObjectId(PSPFCtrlTempl vt) {
        return vt.getPSPFCTRLTEMPLID();
    }
}

