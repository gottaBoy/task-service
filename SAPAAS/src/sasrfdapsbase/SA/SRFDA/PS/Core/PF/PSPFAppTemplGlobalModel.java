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

import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.PSPFAppTemplImpl;
import SA.SRFDA.PS.Core.PF.PSPFStyleGlobalModelBase;
import SA.SRFDA.PS.Data.PSPFAppTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFAppTemplGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFAppTempl, IPSPFAppTempl> {
    private static final Log log = LogFactory.getLog(PSPFAppTemplGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSPFAppTempl GetObject(String strPSPFAppTemplId) {
        return null;
    }

    @Override
    protected IPSPFAppTempl OnCreateModelHelper(PSPFAppTempl vt) throws Exception {
        PSPFAppTemplImpl iPSPFAppTempl = new PSPFAppTemplImpl();
        iPSPFAppTempl.init(this.iDAGlobalHelper, this.getPSPF(), this.getPSPFStyle(), vt);
        return iPSPFAppTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFAppTempl obj) {
        return false;
    }

    @Override
    protected IPSPFAppTempl registerModel(PSPFAppTempl vt) throws Exception {
        IPSPFAppTempl iPSPFAppTempl = (IPSPFAppTempl)this.InternalGetModelHelper(vt.getPSPFAPPTEMPLID());
        if (iPSPFAppTempl != null) {
            return iPSPFAppTempl;
        }
        this.setModel(vt.getPSPFAPPTEMPLID(), vt, null);
        return (IPSPFAppTempl)this.FindModelHelper(vt.getPSPFAPPTEMPLID());
    }

    @Override
    protected Vector<PSPFAppTempl> getAllModels() throws Exception {
        Vector<PSPFAppTempl> list = new Vector<PSPFAppTempl>();
        CallResult callResult = this.iPSModelHelper.getPSPFAppTemplsByPFStyle(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u524d\u7aef\u6837\u5f0f\u5e94\u7528\u6a21\u7248\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
    protected String getObjectId(PSPFAppTempl vt) {
        return vt.getPSPFAPPTEMPLID();
    }
}

