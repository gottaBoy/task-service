/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSSysCss;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.PSSysCssImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCssGlobalModel
extends PSSystemGlobalModelBase<String, PSSysCss, IPSSysCss> {
    private static final Log log = LogFactory.getLog(PSSysCssGlobalModel.class);

    @Override
    protected PSSysCss getObject(String strPSSysCssId) {
        PSSysCss psSysCss = new PSSysCss();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysCss(strPSSysCssId, psSysCss);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6837\u5f0f\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysCssId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysCss;
    }

    @Override
    protected IPSSysCss onCreateModelHelper(PSSysCss vt) throws Exception {
        PSSysCssImpl iPSSysCss = null;
        iPSSysCss = new PSSysCssImpl();
        iPSSysCss.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSysCss;
    }

    @Override
    protected Boolean testObjectRenew(PSSysCss obj) {
        return false;
    }

    @Override
    protected IPSSysCss registerModel(PSSysCss vt) throws Exception {
        IPSSysCss iIPSSysCss = (IPSSysCss)this.internalGetModelHelper(vt.getPSSYSCSSID());
        if (iIPSSysCss != null) {
            return iIPSSysCss;
        }
        this.setModel(vt.getPSSYSCSSID(), vt, null);
        return (IPSSysCss)this.findModelHelper(vt.getPSSYSCSSID());
    }

    @Override
    protected Vector<PSSysCss> getAllModels() throws Exception {
        Vector<PSSysCss> list = new Vector<PSSysCss>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysCsses(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6837\u5f0f\u8868\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysCss vt) {
        return vt.getPSSYSCSSID();
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }
}

