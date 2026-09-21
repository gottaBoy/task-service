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

import SA.SRFDA.PS.Core.PF.IPSPFUIActionTempl;
import SA.SRFDA.PS.Core.PF.PSPFStyleGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFUIActionTemplImpl;
import SA.SRFDA.PS.Data.PSPFUIActionTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFUIActionTemplGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFUIActionTempl, IPSPFUIActionTempl> {
    private static final Log log = LogFactory.getLog(PSPFUIActionTemplGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSPFUIActionTempl GetObject(String strPSPFUIActionTemplId) {
        return null;
    }

    @Override
    protected IPSPFUIActionTempl OnCreateModelHelper(PSPFUIActionTempl vt) throws Exception {
        PSPFUIActionTemplImpl iPSPFUIActionTempl = new PSPFUIActionTemplImpl();
        iPSPFUIActionTempl.init(this.iDAGlobalHelper, this.getPSPF(), this.getPSPFStyle(), vt);
        return iPSPFUIActionTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFUIActionTempl obj) {
        return false;
    }

    @Override
    protected IPSPFUIActionTempl registerModel(PSPFUIActionTempl vt) throws Exception {
        IPSPFUIActionTempl iPSPFUIActionTempl = (IPSPFUIActionTempl)this.InternalGetModelHelper(vt.getPSPFUATEMPLID());
        if (iPSPFUIActionTempl != null) {
            return iPSPFUIActionTempl;
        }
        this.setModel(vt.getPSPFUATEMPLID(), vt, null);
        return (IPSPFUIActionTempl)this.FindModelHelper(vt.getPSPFUATEMPLID());
    }

    @Override
    protected Vector<PSPFUIActionTempl> getAllModels() throws Exception {
        Vector<PSPFUIActionTempl> list = new Vector<PSPFUIActionTempl>();
        CallResult callResult = this.iPSModelHelper.getPSPFUIActionTemplsByPFStyle(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u524d\u7aef\u6837\u5f0f\u754c\u9762\u884c\u4e3a\u6a21\u7248\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
    protected String getObjectId(PSPFUIActionTempl vt) {
        return vt.getPSPFUATEMPLID();
    }
}

