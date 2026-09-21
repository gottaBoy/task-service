/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.security.DEDataAccMgr
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 */
package net.ibizsys.pscore.srv.util;

import java.util.ArrayList;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.ibizsys.pscore.srv.web.WebContext;

public class PSDevSlnSysDEDataAccMgr
extends DEDataAccMgr {
    private boolean bPSDevSlnSysMode = false;
    private PSDevSlnService psDevSlnService = null;
    private PSDevSlnUserService psDevSlnUserService = null;
    private PSDevSlnDEModel psDevSlnDEModel = null;

    protected void onInit() throws Exception {
        super.onInit();
        if (StringHelper.compare((String)this.getDEModel().getName(), (String)"PSDEVSLNSYS", (boolean)true) == 0) {
            this.bPSDevSlnSysMode = true;
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
        if (this.bPSDevSlnSysMode) {
            if (this.psDevSlnService == null) {
                this.psDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class);
                this.psDevSlnUserService = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class);
                this.psDevSlnDEModel = (PSDevSlnDEModel)this.psDevSlnService.getDEModel();
            }
            callResult.setUserObject((Object)"CACHE");
            if (WebContext.isDCAdmin(iWebContext)) {
                return callResult;
            }
            if (StringHelper.compare((String)string2, (String)"CREATE", (boolean)true) == 0) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(DataObject.getStringValue((Object)iEntity.get("PSDEVSLNID")));
                return iWebContext.getUserPrivilegeMgr().testDataAccessAction(iWebContext, (IDataEntityModel)this.psDevSlnDEModel, (IEntity)pSDevSln, "UPDATE");
            }
            String string3 = DataObject.getStringValue((Object)(iEntity = this.getFullEntity(iWebContext, iEntity, bl)).get("PSDEVSLNID"), null);
            if (StringHelper.isNullOrEmpty((String)string3)) {
                throw new Exception("\u5e94\u7528\u5f00\u53d1\u65b9\u6848\u65e0\u6548");
            }
            Integer n = null;
            PSDevSln pSDevSln = new PSDevSln();
            pSDevSln.setPSDevSlnId(string3);
            this.psDevSlnService.get((IEntity)pSDevSln);
            if (StringHelper.compare((String)pSDevSln.getAdminPSDevUserId(), (String)string, (boolean)true) == 0) {
                n = 2;
            } else {
                String string4 = DataObject.getStringValue((Object)iEntity.get("PSDEVSLNSYSID"));
                String string5 = DataObject.getStringValue((Object)iEntity.get("PPSDEVSLNSYSID"));
                n = 0;
                ArrayList<PSDevSlnUser> arrayList = this.psDevSlnUserService.selectByPSDevSln(pSDevSln);
                for (PSDevSlnUser pSDevSlnUser : arrayList) {
                    if (StringHelper.compare((String)pSDevSlnUser.getPSDevUserObjId(), (String)string, (boolean)true) != 0) continue;
                    if (DataObject.getIntegerValue((Object)pSDevSlnUser.getAllSysFlag(), (Integer)0) == 1) {
                        n = 1;
                        break;
                    }
                    if (StringHelper.compare((String)string4, (String)pSDevSlnUser.getPSDevSlnSysId(), (boolean)false) == 0) {
                        n = 1;
                        break;
                    }
                    if (StringHelper.compare((String)string5, (String)pSDevSlnUser.getPSDevSlnSysId(), (boolean)false) != 0) continue;
                    n = 1;
                    break;
                }
            }
            if (n == 0) {
                callResult.setRetCode(2);
                return callResult;
            }
            if (StringHelper.compare((String)string2, (String)"READ", (boolean)true) == 0) {
                return callResult;
            }
            if (n != 2) {
                callResult.setRetCode(2);
                return callResult;
            }
            return callResult;
        }
        return super.internalTest(iWebContext, string, iEntity, string2, bl);
    }
}

