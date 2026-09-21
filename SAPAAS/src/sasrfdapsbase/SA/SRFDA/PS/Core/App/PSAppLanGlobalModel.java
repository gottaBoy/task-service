/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.App.PSAppLanImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppLan;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppLanGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppLan, IPSAppLan> {
    private static final Log log = LogFactory.getLog(PSAppLanGlobalModel.class);

    @Override
    protected PSAppLan GetObject(String strPSAppLanId) {
        PSAppLan psAppLan = new PSAppLan();
        CallResult callResult = this.iPSModelHelper.getPSAppLan(strPSAppLanId, psAppLan);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u8bed\u8a00[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppLanId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppLan.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppLan;
    }

    @Override
    protected IPSAppLan OnCreateModelHelper(PSAppLan vt) throws Exception {
        PSAppLanImpl iPSAppLan = new PSAppLanImpl();
        iPSAppLan.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppLan;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppLan obj) {
        return false;
    }

    @Override
    protected IPSAppLan registerModel(PSAppLan vt) throws Exception {
        IPSAppLan iPSAppLan = (IPSAppLan)this.InternalGetModelHelper(vt.getPSAPPLANID());
        if (iPSAppLan != null) {
            return iPSAppLan;
        }
        this.setModel(vt.getPSAPPLANID(), vt, null);
        return (IPSAppLan)this.FindModelHelper(vt.getPSAPPLANID());
    }

    @Override
    protected Vector<PSAppLan> getAllModels() throws Exception {
        Vector<PSAppLan> list = new Vector<PSAppLan>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppLans(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u8bed\u8a00\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppLan psAppLan : list) {
            this.setModel(psAppLan.getPSAPPLANID(), psAppLan, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSAppLan vt) {
        return vt.getPSAPPLANID();
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40006, objObjectId);
    }

    public boolean isEnableMultiLan() {
        try {
            return this.getAllModelHelperCount() > 0;
        }
        catch (Exception ex) {
            return false;
        }
    }
}

