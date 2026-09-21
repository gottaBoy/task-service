/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.PSSysRefImpl;
import SA.SRFDA.PS.Data.PSSysRef;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysRefGlobalModel
extends PSSystemGlobalModelBase<String, PSSysRef, IPSSysRef> {
    private static final Log log = LogFactory.getLog(PSSysRefGlobalModel.class);

    @Override
    protected PSSysRef GetObject(String strPSSysRefId) {
        PSSysRef psSysRef = new PSSysRef();
        CallResult callResult = this.iPSModelHelper.getPSSysRef(strPSSysRefId, psSysRef);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5f15\u7528[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysRefId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysRef;
    }

    @Override
    protected IPSSysRef OnCreateModelHelper(PSSysRef vt) throws Exception {
        PSSysRefImpl iPSSysRef = new PSSysRefImpl();
        iPSSysRef.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysRef;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysRef obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSysRef vt) {
        return vt.getPSSYSREFID();
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
    protected IPSSysRef registerModel(PSSysRef vt) throws Exception {
        IPSSysRef iPSSysRef = (IPSSysRef)this.InternalGetModelHelper(vt.getPSSYSREFID());
        if (iPSSysRef != null) {
            return iPSSysRef;
        }
        this.setModel(vt.getPSSYSREFID(), vt, null);
        return (IPSSysRef)this.FindModelHelper(vt.getPSSYSREFID());
    }

    @Override
    protected Vector<PSSysRef> getAllModels() throws Exception {
        Vector<PSSysRef> list = new Vector<PSSysRef>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysRefs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u7cfb\u7edf\u5f15\u7528\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }
}

