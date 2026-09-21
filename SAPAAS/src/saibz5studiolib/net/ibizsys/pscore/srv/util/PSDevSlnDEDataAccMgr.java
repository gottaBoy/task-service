/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.security.DEDataAccMgr
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.util.IPSSysDevUser;
import net.ibizsys.pscore.srv.util.PSSysDevUserUserGlobal;

public class PSDevSlnDEDataAccMgr
extends DEDataAccMgr {
    private boolean bPSDevSlnMode = false;

    protected void onInit() throws Exception {
        super.onInit();
        if (StringHelper.compare((String)this.getDEModel().getName(), (String)"PSDEVSLN", (boolean)true) == 0) {
            this.bPSDevSlnMode = true;
        }
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
        if (this.bPSDevSlnMode) {
            callResult.setUserObject((Object)"CACHE");
            if (net.ibizsys.pscore.srv.web.WebContext.isDCAdmin(iWebContext)) {
                return callResult;
            }
            if (StringHelper.compare((String)string2, (String)"CREATE", (boolean)true) == 0) {
                callResult.setRetCode(2);
                return callResult;
            }
            String string3 = DataObject.getStringValue((Object)iEntity.get("PSDEVSLNID"), null);
            if (StringHelper.isNullOrEmpty((String)string3)) {
                throw new Exception("\u5f00\u53d1\u65b9\u6848\u65e0\u6548");
            }
            try {
                IPSSysDevUser iPSSysDevUser = PSSysDevUserUserGlobal.getPSSysDevUserBySln(iWebContext == null ? WebContext.getCurrent() : iWebContext, string3);
                if (StringHelper.compare((String)string2, (String)"READ", (boolean)true) != 0 && (iPSSysDevUser.getAccMode() & 2) != 2) {
                    callResult.setRetCode(2);
                    return callResult;
                }
                return callResult;
            }
            catch (Exception exception) {
                callResult.setRetCode(2);
                return callResult;
            }
        }
        return super.internalTest(iWebContext, string, iEntity, string2, bl);
    }
}

