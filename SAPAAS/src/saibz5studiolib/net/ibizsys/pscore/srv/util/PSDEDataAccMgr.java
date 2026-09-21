/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.ViewController
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.security.DEDataAccMgr
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.util.IPSSysDevUser;
import net.ibizsys.pscore.srv.util.PSSysDevUser;
import net.ibizsys.pscore.srv.util.PSSysDevUserUserGlobal;
import net.ibizsys.pscore.srv.web.WebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataAccMgr
extends DEDataAccMgr {
    private static final Log log = LogFactory.getLog(PSDEDataAccMgr.class);

    protected CallResult internalTest(IWebContext iWebContext, String string, IEntity iEntity, String string2, boolean bl) throws Exception {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        if (StringHelper.isNullOrEmpty((String)string2) || StringHelper.compare((String)string2, (String)"NONE", (boolean)true) == 0) {
            return callResult;
        }
        if (StringHelper.compare((String)string2, (String)"DENY", (boolean)true) == 0) {
            callResult.setRetCode(2);
            return callResult;
        }
        JSONObject jSONObject = WebContext.getAppData((IWebContext)iWebContext);
        if (jSONObject != null) {
            String string3 = jSONObject.optString("psdevslnsysid");
            String string4 = null;
            if (StringHelper.isNullOrEmpty((String)string3)) {
                string4 = jSONObject.optString("pssystemid");
            }
            if (!StringHelper.isNullOrEmpty((String)string3) || !StringHelper.isNullOrEmpty((String)string4)) {
                try {
                    IPSSysDevUser iPSSysDevUser = PSSysDevUserUserGlobal.getPSSysDevUser(iWebContext, string3, string4);
                    if (iPSSysDevUser == null || iPSSysDevUser == PSSysDevUser.ACCESSDENY) {
                        callResult.setRetCode(2);
                        return callResult;
                    }
                    if (!iPSSysDevUser.isShareAccMode() && (WebContext.isDCAdmin(iWebContext) || iWebContext.isSuperUser())) {
                        if (!this.testModelLock(iWebContext, string, iEntity, string2)) {
                            callResult.setRetCode(2);
                            callResult.setErrorInfo("\u5f53\u524d\u6a21\u578b\u7981\u6b62\u7528\u6237\u8fdb\u884c\u4fee\u6539");
                            return callResult;
                        }
                        return callResult;
                    }
                    if ((iPSSysDevUser.getAccMode() & 2) > 0) {
                        if (!this.testModelLock(iWebContext, string, iEntity, string2)) {
                            callResult.setRetCode(2);
                            callResult.setErrorInfo("\u5f53\u524d\u6a21\u578b\u7981\u6b62\u7528\u6237\u8fdb\u884c\u4fee\u6539");
                            return callResult;
                        }
                        return callResult;
                    }
                    if (StringHelper.compare((String)string2, (String)"READ", (boolean)true) == 0) {
                        return callResult;
                    }
                    callResult.setRetCode(2);
                    return callResult;
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                    callResult.setRetCode(2);
                    return callResult;
                }
            }
        }
        if (WebContext.isDCAdmin(iWebContext) || iWebContext.isSuperUser()) {
            return callResult;
        }
        return super.internalTest(iWebContext, string, iEntity, string2, bl);
    }

    protected boolean testModelLock(IWebContext iWebContext, String string, IEntity iEntity, String string2) throws Exception {
        if (iWebContext != null && ViewController.getCurrent() != null && StringHelper.compare((String)string2, (String)"UPDATE", (boolean)true) == 0 && this.getDEModel().getDEField("LOCKFLAG", true) != null) {
            int n;
            Object object;
            IEntity iEntity2 = iEntity;
            if (!iEntity2.isFullEntity()) {
                object = this.getDEModel().getService(ViewController.getCurrent().getSessionFactory());
                iEntity2 = this.getDEModel().createEntity();
                iEntity2.set(this.getDEModel().getKeyDEField().getName(), iEntity.get(this.getDEModel().getKeyDEField().getName()));
                if (!object.get(iEntity2, true)) {
                    iEntity2 = null;
                }
            }
            if (iEntity2 != null && (object = iEntity2.get("LOCKFLAG")) != null && ((n = ((Integer)object).intValue()) & 1) > 0) {
                int n2;
                String string3 = iWebContext.getPostValue("lockflag");
                if (string3 == null) {
                    return false;
                }
                if (!StringHelper.isNullOrEmpty((String)string3) && ((n2 = Integer.parseInt(string3)) & 1) > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

