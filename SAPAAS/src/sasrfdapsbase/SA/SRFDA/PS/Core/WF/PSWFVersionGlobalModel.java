/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.PSWFVersionImpl;
import SA.SRFDA.PS.Data.PSWFVersion;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFVersionGlobalModel
extends PSGlobalModelBase<String, PSWFVersion, IPSWFVersion> {
    private static final Log log = LogFactory.getLog(PSWFVersionGlobalModel.class);
    protected IPSWorkflow iPSWorkflow = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWorkflow iPSWorkflow) {
        this.iPSWorkflow = iPSWorkflow;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSWFVersion GetObject(String strPSWFVersionId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u7248\u672c[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFVersionId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWFVersion OnCreateModelHelper(PSWFVersion vt) throws Exception {
        PSWFVersionImpl iPSWFVersion = new PSWFVersionImpl();
        iPSWFVersion.init(this.iDAGlobalHelper, this.getPSWorkflow(), vt);
        return iPSWFVersion;
    }

    @Override
    protected Boolean TestObjectRenew(PSWFVersion obj) {
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
        CallResult callResult = this.iPSModelHelper.getPSWFVersions(this.getPSWorkflow().getId(), psWFVersionList2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5168\u90e8\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psWFVersionList2;
    }

    @Override
    protected IPSWFVersion registerModel(PSWFVersion vt) throws Exception {
        IPSWFVersion iPSWFVersion = (IPSWFVersion)this.InternalGetModelHelper(vt.getPSWFVERSIONID());
        if (iPSWFVersion != null) {
            return iPSWFVersion;
        }
        this.setModel(vt.getPSWFVERSIONID(), vt, null);
        return (IPSWFVersion)this.FindModelHelper(vt.getPSWFVERSIONID());
    }

    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    protected void setPSWorkflow(IPSWorkflow iPSWorkflow) {
        this.iPSWorkflow = iPSWorkflow;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSWorkflow().getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSWFVersion vt) {
        return vt.getPSWFVERSIONID();
    }
}

