/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import java.util.Vector;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.dataentity.wf.PSDEWFImpl;
import net.ibizsys.model.entity.PSWFDE;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFDEGlobalModel
extends PSGlobalModelBase<String, PSWFDE, IPSDEWF> {
    private static final Log log = LogFactory.getLog(PSWFDEGlobalModel.class);
    protected IPSWorkflow iPSWorkflow = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWorkflow iPSWorkflow) throws Exception {
        this.iPSWorkflow = iPSWorkflow;
        super.init(iPSModelStorageContext);
    }

    @Override
    protected PSWFDE getObject(String strPSWFDEId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u6d41\u7a0b\u5b9e\u4f53[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFDEId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEWF onCreateModelHelper(PSWFDE vt) throws Exception {
        PSDEWFImpl iPSWFDE = new PSDEWFImpl();
        IPSDataEntity iPSDataEntity = this.getPSWorkflow().getPSSystem().getPSDataEntity(vt.getPSDEID());
        iPSWFDE.init(this.getPSModelStorageContext(), iPSDataEntity, vt);
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
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSWFDE> getAllModels() throws Exception {
        Vector<PSWFDE> psDEDataSetList = new Vector<PSWFDE>();
        CallResult callResult = this.getPSModelQueryHelper().getPSWFDEsByWF(this.getPSWorkflow().getId(), psDEDataSetList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6d41\u7a0b\u5168\u90e8\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataSetList;
    }

    @Override
    protected IPSDEWF registerModel(PSWFDE vt) throws Exception {
        IPSDEWF iPSDEWF = (IPSDEWF)this.internalGetModelHelper(vt.getPSWFDEID());
        if (iPSDEWF != null) {
            return iPSDEWF;
        }
        this.setModel(vt.getPSWFDEID(), vt, null);
        return (IPSDEWF)this.findModelHelper(vt.getPSWFDEID());
    }

    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    protected void setPSWorkflow(IPSWorkflow iPSWorkflow) {
        this.iPSWorkflow = iPSWorkflow;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSWorkflow()).getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSWFDE vt) {
        return vt.getPSWFDEID();
    }
}

