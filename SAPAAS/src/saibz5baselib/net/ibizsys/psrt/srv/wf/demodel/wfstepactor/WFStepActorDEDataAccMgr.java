/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstepactor;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class WFStepActorDEDataAccMgr
extends DEDataAccMgr {
    @Override
    protected CallResult internalTest(IWebContext webContext, String strCurPersonId, IEntity dataEntity, String strAction, boolean bCache) throws Exception {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        if (StringHelper.compare(strAction, "READ", true) == 0) {
            return callResult;
        }
        if (StringHelper.compare(strAction, "UPDATE", true) == 0) {
            return callResult;
        }
        callResult.setRetCode(2);
        if (StringHelper.compare(strAction, "CREATE", true) == 0) {
            callResult.setErrorInfo("\u6b65\u9aa4\u64cd\u4f5c\u7528\u6237\u6570\u636e\u4e0d\u80fd\u7528\u6237\u5efa\u7acb");
            return callResult;
        }
        if (StringHelper.compare(strAction, "DELETE", true) == 0) {
            callResult.setErrorInfo("\u6b65\u9aa4\u64cd\u4f5c\u7528\u6237\u6570\u636e\u4e0d\u80fd\u7528\u6237\u5220\u9664");
            return callResult;
        }
        return callResult;
    }
}

