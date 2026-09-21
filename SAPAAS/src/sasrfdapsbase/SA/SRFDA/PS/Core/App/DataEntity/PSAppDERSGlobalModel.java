/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDERSImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppDERS;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDERSGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppDERS, IPSAppDERS> {
    private static final Log log = LogFactory.getLog(PSAppDERSGlobalModel.class);

    @Override
    protected PSAppDERS GetObject(String strPSAppDERSId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSAppDERS psAppDERS = new PSAppDERS();
        CallResult callResult = this.iPSModelHelper.getPSAppDERS(strPSAppDERSId, psAppDERS);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppDERSId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        return psAppDERS;
    }

    @Override
    protected IPSAppDERS OnCreateModelHelper(PSAppDERS vt, String strPSAppDERSId) throws Exception {
        if (StringHelper.Compare((String)strPSAppDERSId, (String)vt.getPSAPPDERSID(), (boolean)false) == 0) {
            PSAppDERSImpl iPSAppDERS = new PSAppDERSImpl();
            iPSAppDERS.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
            return iPSAppDERS;
        }
        return (IPSAppDERS)this.FindModelHelper(vt.getPSAPPDERSID());
    }

    @Override
    protected Boolean TestObjectRenew(PSAppDERS obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppDERS vt) {
        return vt.getPSAPPDERSID();
    }

    @Override
    protected IPSAppDERS registerModel(PSAppDERS vt) throws Exception {
        IPSAppDERS iPSAppDERS = (IPSAppDERS)this.InternalGetModelHelper(vt.getPSAPPDERSID());
        if (iPSAppDERS != null) {
            return iPSAppDERS;
        }
        this.setModel(vt.getPSAPPDERSID(), vt, null);
        iPSAppDERS = (IPSAppDERS)this.FindModelHelper(vt.getPSAPPDERSID());
        return iPSAppDERS;
    }

    @Override
    protected Vector<PSAppDERS> getAllModels() throws Exception {
        Vector<PSAppDERS> list = new Vector<PSAppDERS>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppDERSs(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5168\u90e8\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40018, objObjectId);
    }
}

