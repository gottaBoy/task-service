/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSSysPortlet
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSSysPortlet;
import net.ibizsys.model.res.IPSPortletTypeRuntime;
import net.ibizsys.model.res.IPSSysPortlet;
import net.ibizsys.model.res.IPSSysPortletRuntime;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPortletGlobalModel
extends PSSystemGlobalModelBase<String, PSSysPortlet, IPSSysPortlet> {
    private static final Log log = LogFactory.getLog(PSSysPortletGlobalModel.class);

    @Override
    protected PSSysPortlet getObject(String strPSSysPortletId) {
        PSSysPortlet psSysPortlet = new PSSysPortlet();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysPortlet(strPSSysPortletId, psSysPortlet);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysPortletId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysPortlet;
    }

    @Override
    protected IPSSysPortlet onCreateModelHelper(PSSysPortlet vt) throws Exception {
        IPSSysPortlet iPSSysPortlet = ((IPSPortletTypeRuntime)this.getPSModelStorageContext().getPSPortletType(vt.getPORTLETTYPE())).createPSSysPortlet(vt);
        ((IPSSysPortletRuntime)iPSSysPortlet).init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSysPortlet;
    }

    @Override
    protected Boolean testObjectRenew(PSSysPortlet obj) {
        return false;
    }

    @Override
    protected IPSSysPortlet registerModel(PSSysPortlet vt) throws Exception {
        IPSSysPortlet iIPSSysPortlet = (IPSSysPortlet)this.internalGetModelHelper(vt.getPSSYSPORTLETID());
        if (iIPSSysPortlet != null) {
            return iIPSSysPortlet;
        }
        this.setModel(vt.getPSSYSPORTLETID(), vt, null);
        return (IPSSysPortlet)this.findModelHelper(vt.getPSSYSPORTLETID());
    }

    @Override
    protected Vector<PSSysPortlet> getAllModels() throws Exception {
        Vector<PSSysPortlet> list = new Vector<PSSysPortlet>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysPortlets(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u95e8\u6237\u90e8\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysPortlet vt) {
        return vt.getPSSYSPORTLETID();
    }
}

