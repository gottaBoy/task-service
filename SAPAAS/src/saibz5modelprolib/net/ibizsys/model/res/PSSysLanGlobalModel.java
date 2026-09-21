/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSSysLan
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSAppLan;
import net.ibizsys.model.res.IPSSysLan;
import net.ibizsys.model.res.PSSysLanImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysLanGlobalModel
extends PSSystemGlobalModelBase<String, PSAppLan, IPSSysLan> {
    private static final Log log = LogFactory.getLog(PSSysLanGlobalModel.class);

    @Override
    protected PSAppLan getObject(String strPSAppLanId) {
        return null;
    }

    @Override
    protected IPSSysLan onCreateModelHelper(PSAppLan vt) throws Exception {
        PSSysLanImpl iPSAppLan = new PSSysLanImpl();
        iPSAppLan.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSAppLan;
    }

    @Override
    protected Boolean testObjectRenew(PSAppLan obj) {
        return false;
    }

    @Override
    protected IPSSysLan registerModel(PSAppLan vt) throws Exception {
        IPSSysLan iPSAppLan = (IPSSysLan)this.internalGetModelHelper(vt.getPSLANGUAGEID());
        if (iPSAppLan != null) {
            return iPSAppLan;
        }
        this.setModel(vt.getPSLANGUAGEID(), vt, null);
        return (IPSSysLan)this.findModelHelper(vt.getPSLANGUAGEID());
    }

    @Override
    protected Vector<PSAppLan> getAllModels() throws Exception {
        Vector<PSAppLan> list = new Vector<PSAppLan>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysLans(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u8bed\u8a00\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        PSAppLan psAppLan = new PSAppLan();
        psAppLan.setPSAPPLANID("ZH_CN");
        psAppLan.setPSLANGUAGEID("ZH_CN");
        psAppLan.setPSAPPLANNAME("\u7b80\u4f53\u4e2d\u6587");
        psAppLan.setPSLANGUAGENAME("\u7b80\u4f53\u4e2d\u6587");
        list.add(psAppLan);
        HashMap<String, PSAppLan> psAppLanMap = new HashMap<String, PSAppLan>();
        for (PSAppLan psAppLan2 : list) {
            if (psAppLanMap.containsKey(psAppLan2.getPSLANGUAGEID())) continue;
            psAppLanMap.put(psAppLan2.getPSLANGUAGEID(), psAppLan2);
            this.setModel(psAppLan2.getPSLANGUAGEID(), psAppLan2, null);
        }
        list.clear();
        list.addAll(psAppLanMap.values());
        return list;
    }

    @Override
    protected String getObjectId(PSAppLan vt) {
        return vt.getPSLANGUAGEID();
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
}

