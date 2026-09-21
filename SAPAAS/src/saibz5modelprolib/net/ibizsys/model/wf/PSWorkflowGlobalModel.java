/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSWorkflow;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.model.wf.PSWorkflowImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkflowGlobalModel
extends PSSystemGlobalModelBase<String, PSWorkflow, IPSWorkflow> {
    private static final Log log = LogFactory.getLog(PSWorkflowGlobalModel.class);

    @Override
    protected PSWorkflow getObject(String strPSWorkflowId) {
        PSWorkflow psWorkflow = new PSWorkflow();
        CallResult callResult = this.getPSModelQueryHelper().getPSWorkflow(strPSWorkflowId, psWorkflow);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5de5\u4f5c\u6d41[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWorkflowId, (Object)callResult.getErrorInfo()));
            return null;
        }
        String strPSDynaInstId = psWorkflow.getParamStringValue("PSDYNAINSTID", null);
        if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            if (StringHelper.compare((String)strPSDynaInstId, (String)this.getPSDynaInstId(), (boolean)false) != 0) {
                String strInfo = StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5de5\u4f5c\u6d41[%1$s]\u53d1\u751f\u9519\u8bef\uff0c\u9519\u8bef\u7684\u52a8\u6001\u5b9e\u4f8b[%2$s]\uff0c\u5f53\u524d\u5b9e\u4f8b[%3$s]", (Object)strPSWorkflowId, (Object)strPSDynaInstId, (Object)this.getPSDynaInstId());
                log.warn((Object)strInfo);
                return null;
            }
        } else if (!StringHelper.isNullOrEmpty((String)strPSDynaInstId)) {
            String strInfo = StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5de5\u4f5c\u6d41[%1$s]\u53d1\u751f\u9519\u8bef\uff0c\u9519\u8bef\u7684\u52a8\u6001\u5b9e\u4f8b[%2$s]\uff0c\u5f53\u524d\u5b9e\u4f8b[%3$s]", (Object)strPSWorkflowId, (Object)strPSDynaInstId, (Object)this.getPSDynaInstId());
            log.warn((Object)strInfo);
            return null;
        }
        return psWorkflow;
    }

    @Override
    protected IPSWorkflow onCreateModelHelper(PSWorkflow vt) throws Exception {
        PSWorkflowImpl iPSWorkflow = new PSWorkflowImpl();
        iPSWorkflow.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSWorkflow;
    }

    @Override
    protected Boolean testObjectRenew(PSWorkflow obj) {
        return false;
    }

    @Override
    protected IPSWorkflow registerModel(PSWorkflow vt) throws Exception {
        IPSWorkflow iPSWorkflow = (IPSWorkflow)this.internalGetModelHelper(vt.getPSWORKFLOWID());
        if (iPSWorkflow != null) {
            return iPSWorkflow;
        }
        this.setModel(vt.getPSWORKFLOWID(), vt, null);
        return (IPSWorkflow)this.findModelHelper(vt.getPSWORKFLOWID());
    }

    @Override
    protected String getObjectId(PSWorkflow vt) {
        return vt.getPSWORKFLOWID();
    }
}

