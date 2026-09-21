/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfreminder;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class WFReminderDEDataAccMgr
extends DEDataAccMgr {
    @Override
    protected CallResult internalTest(IWebContext webContext, String strCurPersonId, IEntity dataEntity, String strAction, boolean bCache) throws Exception {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        if (StringHelper.compare(strAction, "CREATE", true) == 0) {
            return callResult;
        }
        if (StringHelper.compare(strAction, "READ", true) == 0) {
            return callResult;
        }
        callResult.setRetCode(2);
        if (StringHelper.compare(strAction, "UPDATE", true) == 0) {
            callResult.setErrorInfo("\u6d41\u7a0b\u50ac\u529e\u6570\u636e\u4e0d\u80fd\u88ab\u66f4\u65b0");
            return callResult;
        }
        if (StringHelper.compare(strAction, "DELETE", true) == 0) {
            callResult.setErrorInfo("\u6d41\u7a0b\u50ac\u529e\u6570\u636e\u4e0d\u80fd\u88ab\u5220\u9664");
            return callResult;
        }
        return callResult;
    }
}

