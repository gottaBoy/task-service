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

import SA.SRFDA.PS.Core.App.IPSAppLogic;
import SA.SRFDA.PS.Core.App.PSAppLogicImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppLogic;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppLogicGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppLogic, IPSAppLogic> {
    private static final Log log = LogFactory.getLog(PSAppLogicGlobalModel.class);

    @Override
    protected PSAppLogic GetObject(String strPSAppLogicId) {
        PSAppLogic psAppLogic = new PSAppLogic();
        CallResult callResult = this.iPSModelHelper.getPSAppLogic(strPSAppLogicId, psAppLogic);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u903b\u8f91[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppLogicId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppLogic.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppLogic;
    }

    @Override
    protected IPSAppLogic OnCreateModelHelper(PSAppLogic vt) throws Exception {
        PSAppLogicImpl iPSAppLogic = new PSAppLogicImpl();
        iPSAppLogic.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppLogic;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppLogic obj) {
        return false;
    }

    @Override
    protected IPSAppLogic registerModel(PSAppLogic vt) throws Exception {
        IPSAppLogic iPSAppLogic = (IPSAppLogic)this.InternalGetModelHelper(vt.getPSAPPLOGICID());
        if (iPSAppLogic != null) {
            return iPSAppLogic;
        }
        this.setModel(vt.getPSAPPLOGICID(), vt, null);
        return (IPSAppLogic)this.FindModelHelper(vt.getPSAPPLOGICID());
    }

    @Override
    protected Vector<PSAppLogic> getAllModels() throws Exception {
        Vector<PSAppLogic> list = new Vector<PSAppLogic>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppLogics(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u903b\u8f91\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppLogic psAppLogic : list) {
            this.setModel(psAppLogic.getPSAPPLOGICID(), psAppLogic, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSAppLogic vt) {
        return vt.getPSAPPLOGICID();
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
        return PSApplicationException.create(this.getPSApplication(), 40022, objObjectId);
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

