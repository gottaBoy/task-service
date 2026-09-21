/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSystemApplication;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSApplicationGlobalModel
extends PSSystemGlobalModelBase<String, PSSystemApplication, IPSApplication> {
    private static final Log log = LogFactory.getLog(PSApplicationGlobalModel.class);

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem) {
        return super.Init(iDAGlobalHelper, iPSSystem);
    }

    @Override
    protected PSSystemApplication GetObject(String strPSSystemApplicationId) {
        PSSystemApplication psSystemApplication = new PSSystemApplication();
        CallResult callResult = this.iPSModelHelper.getPSSystemApplication(strPSSystemApplicationId, psSystemApplication);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u524d\u7aef\u5e94\u7528[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSystemApplicationId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSSystemUtil().log(1, this.getPSSystem(), strInfo);
            return null;
        }
        if (!psSystemApplication.isVALIDFLAGNull() && !psSystemApplication.getVALIDFLAG()) {
            String strInfo = StringHelper.Format((String)"\u6307\u5b9a\u524d\u7aef\u5e94\u7528[%1$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)strPSSystemApplicationId);
            log.error((Object)strInfo);
            this.getPSSystemUtil().log(1, this.getPSSystem(), strInfo);
            return null;
        }
        return psSystemApplication;
    }

    @Override
    protected IPSApplication OnCreateModelHelper(PSSystemApplication vt) throws Exception {
        PSApplicationImpl iPSSystemApplication = new PSApplicationImpl();
        iPSSystemApplication.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSystemApplication;
    }

    @Override
    protected Boolean TestObjectRenew(PSSystemApplication obj) {
        return false;
    }

    @Override
    protected IPSApplication registerModel(PSSystemApplication vt) throws Exception {
        IPSApplication iPSApplication = (IPSApplication)this.InternalGetModelHelper(vt.getPSSYSAPPID());
        if (iPSApplication != null) {
            return iPSApplication;
        }
        this.setModel(vt.getPSSYSAPPID(), vt, null);
        return (IPSApplication)this.FindModelHelper(vt.getPSSYSAPPID());
    }

    @Override
    protected Vector<PSSystemApplication> getAllModels() throws Exception {
        Vector<PSSystemApplication> list2 = new Vector<PSSystemApplication>();
        CallResult callResult = this.iPSModelHelper.getAllPSSystemApplications(this.iPSSystem.getId(), list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5e94\u7528\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSSystemApplication> list = new Vector<PSSystemApplication>();
        for (PSSystemApplication psSystemApplication : list2) {
            if (!psSystemApplication.isVALIDFLAGNull() && !psSystemApplication.getVALIDFLAG()) continue;
            psSystemApplication.setVALIDFLAG(true);
            list.add(psSystemApplication);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSystemApplication vt) {
        return vt.getPSSYSAPPID();
    }
}

