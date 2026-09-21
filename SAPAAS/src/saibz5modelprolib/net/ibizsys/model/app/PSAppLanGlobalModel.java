/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSAppLan
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app;

import java.util.Vector;
import net.ibizsys.model.app.IPSAppLan;
import net.ibizsys.model.app.PSAppLanImpl;
import net.ibizsys.model.app.PSApplicationException;
import net.ibizsys.model.app.PSApplicationGlobalModelBase;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSAppLan;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppLanGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppLan, IPSAppLan> {
    private static final Log log = LogFactory.getLog(PSAppLanGlobalModel.class);

    @Override
    protected PSAppLan getObject(String strPSAppLanId) {
        PSAppLan psAppLan = new PSAppLan();
        CallResult callResult = this.getPSModelQueryHelper().getPSAppLan(strPSAppLanId, psAppLan);
        if (callResult.isError()) {
            String strInfo = StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u8bed\u8a00[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppLanId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, (IPSModelObject)this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.compare((String)this.getPSApplication().getId(), (String)psAppLan.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppLan;
    }

    @Override
    protected IPSAppLan onCreateModelHelper(PSAppLan vt) throws Exception {
        PSAppLanImpl iPSAppLan = new PSAppLanImpl();
        iPSAppLan.init(this.getPSModelStorageContext(), this.getPSApplication(), vt);
        return iPSAppLan;
    }

    @Override
    protected Boolean testObjectRenew(PSAppLan obj) {
        return false;
    }

    @Override
    protected IPSAppLan registerModel(PSAppLan vt) throws Exception {
        IPSAppLan iPSAppLan = (IPSAppLan)this.internalGetModelHelper(vt.getPSAPPLANID());
        if (iPSAppLan != null) {
            return iPSAppLan;
        }
        this.setModel(vt.getPSAPPLANID(), vt, null);
        return (IPSAppLan)this.findModelHelper(vt.getPSAPPLANID());
    }

    @Override
    protected Vector<PSAppLan> getAllModels() throws Exception {
        Vector<PSAppLan> list = new Vector<PSAppLan>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSAppLans(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u8bed\u8a00\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
        return this.allModelHelperList.size() > 0;
    }
}

