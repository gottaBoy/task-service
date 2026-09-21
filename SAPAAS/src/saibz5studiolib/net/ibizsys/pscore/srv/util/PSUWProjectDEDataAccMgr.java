/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.security.DEDataAccMgr
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.web.WebContext;

public class PSUWProjectDEDataAccMgr
extends DEDataAccMgr {
    protected void onInit() throws Exception {
        super.onInit();
    }

    protected CallResult internalTest(IWebContext iWebContext, String string, IEntity iEntity, String string2, boolean bl) throws Exception {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        if (StringHelper.compare((String)string2, (String)"NONE", (boolean)true) == 0) {
            return callResult;
        }
        if (StringHelper.compare((String)string2, (String)"DENY", (boolean)true) == 0) {
            callResult.setRetCode(2);
            return callResult;
        }
        callResult.setUserObject((Object)"CACHE");
        if (WebContext.isDCAdmin(iWebContext)) {
            return callResult;
        }
        callResult.setRetCode(2);
        return callResult;
    }
}

