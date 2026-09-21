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

import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PF.PSPFStyleGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFViewTemplImpl;
import SA.SRFDA.PS.Data.PSPFViewTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewTemplGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFViewTempl, IPSPFViewTempl> {
    private static final Log log = LogFactory.getLog(PSPFViewTemplGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSPFViewTempl GetObject(String strPSPFViewTemplId) {
        return null;
    }

    @Override
    protected IPSPFViewTempl OnCreateModelHelper(PSPFViewTempl vt) throws Exception {
        PSPFViewTemplImpl iPSPFViewTempl = new PSPFViewTemplImpl();
        iPSPFViewTempl.init(this.iDAGlobalHelper, this.getPSPF(), this.getPSPFStyle(), vt);
        return iPSPFViewTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFViewTempl obj) {
        return false;
    }

    @Override
    protected IPSPFViewTempl registerModel(PSPFViewTempl vt) throws Exception {
        IPSPFViewTempl iPSPFViewTempl = (IPSPFViewTempl)this.InternalGetModelHelper(vt.getPSPFVIEWTEMPLID());
        if (iPSPFViewTempl != null) {
            return iPSPFViewTempl;
        }
        this.setModel(vt.getPSPFVIEWTEMPLID(), vt, null);
        return (IPSPFViewTempl)this.FindModelHelper(vt.getPSPFVIEWTEMPLID());
    }

    @Override
    protected Vector<PSPFViewTempl> getAllModels() throws Exception {
        Vector<PSPFViewTempl> list = new Vector<PSPFViewTempl>();
        CallResult callResult = this.iPSModelHelper.getPSPFViewTemplsByPFStyle(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u524d\u7aef\u6837\u5f0f\u89c6\u56fe\u6a21\u7248\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
    protected String getObjectId(PSPFViewTempl vt) {
        return vt.getPSPFVIEWTEMPLID();
    }
}

