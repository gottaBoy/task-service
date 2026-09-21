/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.func.IPSAppFunc
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.func;

import java.util.Vector;
import net.ibizsys.model.app.PSApplicationException;
import net.ibizsys.model.app.PSApplicationGlobalModelBase;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.func.PSAppFuncImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSAppFunc;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppFuncGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppFunc, IPSAppFunc> {
    private static final Log log = LogFactory.getLog(PSAppFuncGlobalModel.class);

    @Override
    protected PSAppFunc getObject(String strPSAppFuncId) {
        PSAppFunc psAppFunc = new PSAppFunc();
        CallResult callResult = this.getPSModelQueryHelper().getPSAppFunc(strPSAppFuncId, psAppFunc);
        if (callResult.isError()) {
            String strInfo = StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5e94\u7528\u529f\u80fd[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppFuncId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, (IPSModelObject)this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.compare((String)this.getPSApplication().getId(), (String)psAppFunc.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppFunc;
    }

    @Override
    protected IPSAppFunc onCreateModelHelper(PSAppFunc vt) throws Exception {
        PSAppFuncImpl iPSAppFunc = new PSAppFuncImpl();
        iPSAppFunc.init(this.getPSModelStorageContext(), this.getPSApplication(), vt);
        return iPSAppFunc;
    }

    @Override
    protected Boolean testObjectRenew(PSAppFunc obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppFunc vt) {
        return vt.getPSAPPFUNCID();
    }

    @Override
    protected IPSAppFunc registerModel(PSAppFunc vt) throws Exception {
        IPSAppFunc iPSAppFunc = (IPSAppFunc)this.internalGetModelHelper(vt.getPSAPPFUNCID());
        if (iPSAppFunc != null) {
            return iPSAppFunc;
        }
        this.setModel(vt.getPSAPPFUNCID(), vt, null);
        return (IPSAppFunc)this.findModelHelper(vt.getPSAPPFUNCID());
    }

    @Override
    protected Vector<PSAppFunc> getAllModels() throws Exception {
        Vector<PSAppFunc> list = new Vector<PSAppFunc>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSAppFuncs(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5e94\u7528\u5168\u90e8\u5e94\u7528\u529f\u80fd\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppFunc psAppFunc : list) {
            this.setModel(psAppFunc.getPSAPPFUNCID(), psAppFunc, null);
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
        return PSApplicationException.create(this.getPSApplication(), 40001, objObjectId);
    }
}

