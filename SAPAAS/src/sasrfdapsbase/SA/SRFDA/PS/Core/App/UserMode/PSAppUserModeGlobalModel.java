/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.UserMode;

import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.App.UserMode.PSAppUserModeImpl;
import SA.SRFDA.PS.Data.PSAppUserMode;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUserModeGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppUserMode, IPSAppUserMode> {
    private static final Log log = LogFactory.getLog(PSAppUserModeGlobalModel.class);

    @Override
    protected PSAppUserMode GetObject(String strPSAppUserModeId) {
        PSAppUserMode psAppUserMode = new PSAppUserMode();
        CallResult callResult = this.iPSModelHelper.getPSAppUserMode(strPSAppUserModeId, psAppUserMode);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u7528\u6237\u6a21\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppUserModeId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        return psAppUserMode;
    }

    @Override
    protected IPSAppUserMode OnCreateModelHelper(PSAppUserMode vt) throws Exception {
        PSAppUserModeImpl iPSAppUserMode = new PSAppUserModeImpl();
        iPSAppUserMode.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppUserMode;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppUserMode obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppUserMode vt) {
        return vt.getPSAPPUSERMODEID();
    }

    @Override
    protected IPSAppUserMode registerModel(PSAppUserMode vt) throws Exception {
        IPSAppUserMode iPSAppUserMode = (IPSAppUserMode)this.InternalGetModelHelper(vt.getPSAPPUSERMODEID());
        if (iPSAppUserMode != null) {
            return iPSAppUserMode;
        }
        this.setModel(vt.getPSAPPUSERMODEID(), vt, null);
        return (IPSAppUserMode)this.FindModelHelper(vt.getPSAPPUSERMODEID());
    }

    @Override
    protected Vector<PSAppUserMode> getAllModels() throws Exception {
        Vector<PSAppUserMode> list = new Vector<PSAppUserMode>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppUserModes(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u7528\u6237\u6a21\u5f0f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppUserMode psAppUserMode : list) {
            this.setModel(psAppUserMode.getPSAPPUSERMODEID(), psAppUserMode, null);
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
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40003, objObjectId);
    }
}

