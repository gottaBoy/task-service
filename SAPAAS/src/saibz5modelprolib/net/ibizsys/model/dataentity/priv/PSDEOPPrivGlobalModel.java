/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.priv.IPSDEOPPriv
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.priv;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.dataentity.priv.PSDEOPPrivImpl;
import net.ibizsys.model.entity.PSDEOPPriv;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEOPPrivGlobalModel
extends PSSystemGlobalModelBase<String, PSDEOPPriv, IPSDEOPPriv> {
    private static final Log log = LogFactory.getLog(PSDEOPPrivGlobalModel.class);

    @Override
    protected PSDEOPPriv getObject(String strPSDEOPPrivId) {
        PSDEOPPriv psDEOPPriv = new PSDEOPPriv();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEOPPriv(strPSDEOPPrivId, psDEOPPriv);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u6807\u8bc6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEOPPrivId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEOPPriv;
    }

    @Override
    protected IPSDEOPPriv onCreateModelHelper(PSDEOPPriv vt) throws Exception {
        PSDEOPPrivImpl iPSDEOPPriv = new PSDEOPPrivImpl();
        iPSDEOPPriv.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSDEOPPriv;
    }

    @Override
    protected Boolean testObjectRenew(PSDEOPPriv obj) {
        return false;
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
    protected IPSDEOPPriv registerModel(PSDEOPPriv vt) throws Exception {
        IPSDEOPPriv iPSDEOPPriv = (IPSDEOPPriv)this.internalGetModelHelper(vt.getPSDEOPPRIVID());
        if (iPSDEOPPriv != null) {
            return iPSDEOPPriv;
        }
        this.setModel(vt.getPSDEOPPRIVID(), vt, null);
        return (IPSDEOPPriv)this.findModelHelper(vt.getPSDEOPPRIVID());
    }

    @Override
    protected Vector<PSDEOPPriv> getAllModels() throws Exception {
        Vector<PSDEOPPriv> psDEOPPrivList = new Vector<PSDEOPPriv>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEOPPrivsBySystem(this.getPSSystem().getId(), psDEOPPrivList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u6807\u8bc6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEOPPrivList;
    }

    @Override
    protected String getObjectId(PSDEOPPriv vt) {
        return vt.getPSDEOPPRIVID();
    }
}

