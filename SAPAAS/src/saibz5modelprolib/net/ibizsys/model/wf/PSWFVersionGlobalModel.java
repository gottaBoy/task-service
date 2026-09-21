/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFVersion
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
import net.ibizsys.model.entity.PSWFVersion;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.model.wf.PSWFVersionImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFVersionGlobalModel
extends PSGlobalModelBase<String, PSWFVersion, IPSWFVersion> {
    private static final Log log = LogFactory.getLog(PSWFVersionGlobalModel.class);
    protected IPSWorkflow iPSWorkflow = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWorkflow iPSWorkflow) throws Exception {
        this.iPSWorkflow = iPSWorkflow;
        super.init(iPSModelStorageContext);
    }

    @Override
    protected PSWFVersion getObject(String strPSWFVersionId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u6d41\u7a0b\u7248\u672c[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFVersionId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWFVersion onCreateModelHelper(PSWFVersion vt) throws Exception {
        PSWFVersionImpl iPSWFVersion = new PSWFVersionImpl();
        iPSWFVersion.init(this.getPSModelStorageContext(), this.getPSWorkflow(), vt);
        return iPSWFVersion;
    }

    @Override
    protected Boolean testObjectRenew(PSWFVersion obj) {
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
    protected Vector<PSWFVersion> getAllModels() throws Exception {
        Vector<PSWFVersion> psWFVersionList2 = new Vector<PSWFVersion>();
        CallResult callResult = this.getPSModelQueryHelper().getPSWFVersions(this.getPSWorkflow().getId(), psWFVersionList2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6d41\u7a0b\u5168\u90e8\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psWFVersionList2;
    }

    @Override
    protected IPSWFVersion registerModel(PSWFVersion vt) throws Exception {
        IPSWFVersion iPSWFVersion = (IPSWFVersion)this.internalGetModelHelper(vt.getPSWFVERSIONID());
        if (iPSWFVersion != null) {
            return iPSWFVersion;
        }
        this.setModel(vt.getPSWFVERSIONID(), vt, null);
        return (IPSWFVersion)this.findModelHelper(vt.getPSWFVERSIONID());
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
    protected String getObjectId(PSWFVersion vt) {
        return vt.getPSWFVERSIONID();
    }

    @Override
    public String getPSDynaInstId() {
        return ((IPSModelObjectRuntime)this.iPSWorkflow).getPSDynaInstId();
    }

    @Override
    public int getDynaModelType() {
        return ((IPSModelObjectRuntime)this.iPSWorkflow).getDynaModelType();
    }
}

