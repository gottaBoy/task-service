/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.PSApplicationImpl;
import net.ibizsys.model.entity.PSSystemApplication;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSApplicationGlobalModel
extends PSSystemGlobalModelBase<String, PSSystemApplication, IPSApplication> {
    private static final Log log = LogFactory.getLog(PSApplicationGlobalModel.class);

    @Override
    protected PSSystemApplication getObject(String strPSSystemApplicationId) {
        PSSystemApplication psSystemApplication = new PSSystemApplication();
        CallResult callResult = this.getPSModelQueryHelper().getPSSystemApplication(strPSSystemApplicationId, psSystemApplication);
        if (callResult.isError()) {
            String strInfo = StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5e94\u7528[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSystemApplicationId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            return null;
        }
        return psSystemApplication;
    }

    @Override
    protected IPSApplication onCreateModelHelper(PSSystemApplication vt) throws Exception {
        PSApplicationImpl iPSSystemApplication = new PSApplicationImpl();
        iPSSystemApplication.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSystemApplication;
    }

    @Override
    protected Boolean testObjectRenew(PSSystemApplication obj) {
        return false;
    }

    @Override
    protected IPSApplication registerModel(PSSystemApplication vt) throws Exception {
        IPSApplication iPSApplication = (IPSApplication)this.internalGetModelHelper(vt.getPSSYSAPPID());
        if (iPSApplication != null) {
            return iPSApplication;
        }
        this.setModel(vt.getPSSYSAPPID(), vt, null);
        return (IPSApplication)this.findModelHelper(vt.getPSSYSAPPID());
    }

    @Override
    protected Vector<PSSystemApplication> getAllModels() throws Exception {
        Vector<PSSystemApplication> list = new Vector<PSSystemApplication>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSystemApplications(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5e94\u7528\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSystemApplication vt) {
        return vt.getPSSYSAPPID();
    }
}

