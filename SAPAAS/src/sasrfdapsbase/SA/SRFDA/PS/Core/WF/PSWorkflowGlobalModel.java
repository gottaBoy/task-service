/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.PSWorkflowImpl;
import SA.SRFDA.PS.Data.PSWorkflow;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkflowGlobalModel
extends PSSystemGlobalModelBase<String, PSWorkflow, IPSWorkflow> {
    private static final Log log = LogFactory.getLog(PSWorkflowGlobalModel.class);

    @Override
    protected PSWorkflow GetObject(String strPSWorkflowId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5de5\u4f5c\u6d41[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWorkflowId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWorkflow OnCreateModelHelper(PSWorkflow vt) throws Exception {
        PSWorkflowImpl iPSWorkflow = new PSWorkflowImpl();
        iPSWorkflow.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSWorkflow;
    }

    @Override
    protected Boolean TestObjectRenew(PSWorkflow obj) {
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
    protected Vector<PSWorkflow> getAllModels() throws Exception {
        Vector<PSWorkflow> psDEDataSetList = new Vector<PSWorkflow>();
        CallResult callResult = this.iPSModelHelper.getAllPSWorkflows(this.getPSSystem().getId(), psDEDataSetList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5de5\u4f5c\u6d41\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataSetList;
    }

    @Override
    protected IPSWorkflow registerModel(PSWorkflow vt) throws Exception {
        IPSWorkflow iPSWorkflow = (IPSWorkflow)this.InternalGetModelHelper(vt.getPSWORKFLOWID());
        if (iPSWorkflow != null) {
            return iPSWorkflow;
        }
        this.setModel(vt.getPSWORKFLOWID(), vt, null);
        return (IPSWorkflow)this.FindModelHelper(vt.getPSWORKFLOWID());
    }

    @Override
    protected String getObjectId(PSWorkflow vt) {
        return vt.getPSWORKFLOWID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSWorkflow vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

