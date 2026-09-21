/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.wf;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.dataentity.wf.PSDEWFImpl;
import net.ibizsys.model.entity.PSWFDE;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEWFGlobalModel
extends PSDataEntityGlobalModelBase<String, PSWFDE, IPSDEWF> {
    private static final Log log = LogFactory.getLog(PSDEWFGlobalModel.class);

    @Override
    protected PSWFDE getObject(String strPSWFDEId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6d41\u7a0b\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFDEId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEWF onCreateModelHelper(PSWFDE vt) throws Exception {
        PSDEWFImpl iPSWFDE = new PSDEWFImpl();
        iPSWFDE.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSWFDE;
    }

    @Override
    protected Boolean testObjectRenew(PSWFDE obj) {
        return false;
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
    protected Vector<PSWFDE> getAllModels() throws Exception {
        Vector<PSWFDE> psWFDEList = new Vector<PSWFDE>();
        CallResult callResult = this.getPSModelQueryHelper().getPSWFDEs(this.getPSDataEntity().getId(), psWFDEList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6d41\u7a0b\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psWFDEList;
    }

    @Override
    protected IPSDEWF registerModel(PSWFDE vt) throws Exception {
        IPSDEWF iPSDEWF = (IPSDEWF)this.internalGetModelHelper(vt.getPSWFDEID());
        if (iPSDEWF != null) {
            return iPSDEWF;
        }
        this.setModel(vt.getPSWFID(), vt, null);
        this.setModel(vt.getPSWFDEID(), vt, null);
        return (IPSDEWF)this.findModelHelper(vt.getPSWFDEID());
    }

    @Override
    protected String getObjectId(PSWFDE vt) {
        return vt.getPSWFDEID();
    }
}

