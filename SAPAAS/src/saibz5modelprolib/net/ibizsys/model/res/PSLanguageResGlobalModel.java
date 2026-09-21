/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSLanguageRes;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.PSLanguageResImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSLanguageResGlobalModel
extends PSSystemGlobalModelBase<String, PSLanguageRes, IPSLanguageRes> {
    private static final Log log = LogFactory.getLog(PSLanguageResGlobalModel.class);

    @Override
    protected PSLanguageRes getObject(String strPSLanguageResId) {
        return null;
    }

    @Override
    protected IPSLanguageRes onCreateModelHelper(PSLanguageRes vt) throws Exception {
        PSLanguageResImpl iPSLanguageRes = null;
        iPSLanguageRes = new PSLanguageResImpl();
        iPSLanguageRes.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSLanguageRes;
    }

    @Override
    protected Boolean testObjectRenew(PSLanguageRes obj) {
        return false;
    }

    @Override
    protected IPSLanguageRes registerModel(PSLanguageRes vt) throws Exception {
        IPSLanguageRes iIPSLanguageRes = (IPSLanguageRes)this.internalGetModelHelper(vt.getPSLANGUAGERESID());
        if (iIPSLanguageRes != null) {
            return iIPSLanguageRes;
        }
        this.setModel(vt.getPSLANGUAGERESID(), vt, null);
        IPSLanguageRes iPSLanguageRes = (IPSLanguageRes)this.findModelHelper(vt.getPSLANGUAGERESID());
        this.setModel(vt.getLANRESTAG(), vt, iPSLanguageRes);
        return iPSLanguageRes;
    }

    @Override
    protected Vector<PSLanguageRes> getAllModels() throws Exception {
        Vector<PSLanguageRes> list = new Vector<PSLanguageRes>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSLanguageReses(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u8bed\u8a00\u8d44\u6e90\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Collections.sort(list, new Comparator<PSLanguageRes>(){

            @Override
            public int compare(PSLanguageRes arg0, PSLanguageRes arg1) {
                return arg0.getLANRESTAG().compareTo(arg1.getLANRESTAG());
            }
        });
        return list;
    }

    @Override
    protected String getObjectId(PSLanguageRes vt) {
        return vt.getPSLANGUAGERESID();
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

