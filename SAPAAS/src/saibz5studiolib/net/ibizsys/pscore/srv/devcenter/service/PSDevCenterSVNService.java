/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import java.util.Random;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSGitUser;
import net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService;
import net.ibizsys.pscore.srv.util.IPSDCSVNOwnerListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevCenterSVNService
extends PSDevCenterSVNServiceBase {
    private static final Log log = LogFactory.getLog(PSDevCenterSVNService.class);
    private static Random random = new Random();

    @Override
    protected void onBeforeCreate(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && StringHelper.compare((String)pSDevCenterSVN.getSVNType(), (String)"GIT", (boolean)true) == 0 && StringHelper.isNullOrEmpty((String)pSDevCenterSVN.getPSSVNInstRepoId()) && StringHelper.isNullOrEmpty((String)pSDevCenterSVN.getPSGitUserId())) {
            PSGitUserService pSGitUserService = (PSGitUserService)ServiceGlobal.getService(PSGitUserService.class, (SessionFactory)this.getSessionFactory());
            SelectCond selectCond = new SelectCond();
            selectCond.set("VALIDFLAG", (Object)1);
            selectCond.set("GITPATH", (Object)pSDevCenterSVN.getGitRepo());
            selectCond.setMaxRowCount(10);
            ArrayList arrayList = pSGitUserService.select((ISelectCond)selectCond);
            if (arrayList.size() == 0) {
                throw new Exception("\u5f53\u524d\u7cfb\u7edf\u6ca1\u7528\u53ef\u7528\u7684GIT\u8d26\u6237");
            }
            PSGitUser pSGitUser = null;
            int n = random.nextInt(arrayList.size());
            pSGitUser = n < 0 || n >= arrayList.size() ? (PSGitUser)arrayList.get(0) : (PSGitUser)arrayList.get(n);
            pSDevCenterSVN.setPSGitUserId(pSGitUser.getPSGitUserId());
            pSDevCenterSVN.setPSGitUserName(pSGitUser.getPSGitUserName());
        }
        super.onBeforeCreate(pSDevCenterSVN);
    }

    @Override
    protected void onAfterCreate(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterCreate(pSDevCenterSVN);
    }

    @Override
    protected void onAfterUpdate(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && (pSDevCenterSVN.isResStateDirty() || pSDevCenterSVN.isExpriedTimeDirty())) {
            PSDevCenterSVN pSDevCenterSVN2 = (PSDevCenterSVN)this.getLast(pSDevCenterSVN);
            if (pSDevCenterSVN.isResStateDirty() && DataTypeHelper.compare((int)9, (Object)pSDevCenterSVN.getResState(), (Object)pSDevCenterSVN2.getResState()) != 0L || pSDevCenterSVN.isExpriedTimeDirty() && DataTypeHelper.compare((int)5, (Object)pSDevCenterSVN.getExpriedTime(), (Object)pSDevCenterSVN2.getExpriedTime()) != 0L) {
                boolean bl = DataObject.getBoolValue((Integer)pSDevCenterSVN2.getRefFlag(), (boolean)false);
                if (pSDevCenterSVN.isRefFlagDirty()) {
                    bl = DataObject.getBoolValue((Integer)pSDevCenterSVN.getRefFlag(), (boolean)false);
                }
                if (bl) {
                    IService iService;
                    String string = pSDevCenterSVN2.getRefObjType();
                    if (pSDevCenterSVN.isRefObjTypeDirty()) {
                        string = pSDevCenterSVN.getRefObjType();
                    }
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        string = "PSDEVSLNSYS";
                    }
                    if ((iService = DEModelGlobal.getDEModel((String)string).getService(this.getSessionFactory())) instanceof IPSDCSVNOwnerListener) {
                        ((IPSDCSVNOwnerListener)iService).onPSDCSVNChanged(pSDevCenterSVN, pSDevCenterSVN2);
                    } else {
                        log.warn((Object)StringHelper.format((String)"\u8d44\u6e90\u5f15\u7528\u7c7b\u578b[%1$s]\u6ca1\u6709\u5b9a\u4e49\u8d44\u6e90\u53d8\u5316\u4fa6\u542c\u63a5\u53e3", (Object)string));
                    }
                }
            }
        }
        super.onAfterUpdate(pSDevCenterSVN);
    }

    @Override
    protected void onAfterRemove(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterRemove(pSDevCenterSVN);
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected void onBind(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        PSDevCenterSVN pSDevCenterSVN2 = new PSDevCenterSVN();
        pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        this.get(pSDevCenterSVN2);
        if (!(StringHelper.isNullOrEmpty((String)pSDevCenterSVN2.getRefObjType()) && StringHelper.isNullOrEmpty((String)pSDevCenterSVN2.getRefObjId()) || StringHelper.compare((String)pSDevCenterSVN2.getRefObjType(), (String)pSDevCenterSVN.getRefObjType(), (boolean)false) == 0 && StringHelper.compare((String)pSDevCenterSVN2.getRefObjId(), (String)pSDevCenterSVN.getRefObjId(), (boolean)false) == 0)) {
            throw new Exception(StringHelper.format((String)"\u4ee3\u7801\u7248\u672c\u5e93[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)pSDevCenterSVN2.getPSDevCenterSVNName(), (Object)pSDevCenterSVN2.getRefObjName()));
        }
        pSDevCenterSVN2.reset();
        pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevCenterSVN2.setRefFlag(1);
        pSDevCenterSVN2.setRefObjId(pSDevCenterSVN.getRefObjId());
        pSDevCenterSVN2.setRefObjName(pSDevCenterSVN.getRefObjName());
        pSDevCenterSVN2.setRefObjType(pSDevCenterSVN.getRefObjType());
        this.update(pSDevCenterSVN2);
    }

    @Override
    protected void onUnbind(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        PSDevCenterSVN pSDevCenterSVN2 = new PSDevCenterSVN();
        pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        this.get(pSDevCenterSVN2);
        if (!(StringHelper.isNullOrEmpty((String)pSDevCenterSVN2.getRefObjType()) && StringHelper.isNullOrEmpty((String)pSDevCenterSVN2.getRefObjId()) || StringHelper.compare((String)pSDevCenterSVN2.getRefObjType(), (String)pSDevCenterSVN.getRefObjType(), (boolean)false) == 0 && StringHelper.compare((String)pSDevCenterSVN2.getRefObjId(), (String)pSDevCenterSVN.getRefObjId(), (boolean)false) == 0)) {
            throw new Exception(StringHelper.format((String)"\u4ee3\u7801\u7248\u672c\u5e93[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u89e3\u9664\u4f7f\u7528", (Object)pSDevCenterSVN2.getPSDevCenterSVNName(), (Object)pSDevCenterSVN2.getRefObjName()));
        }
        pSDevCenterSVN2.reset();
        pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevCenterSVN2.setRefFlag(0);
        pSDevCenterSVN2.setRefObjId(null);
        pSDevCenterSVN2.setRefObjName(null);
        pSDevCenterSVN2.setRefObjType(null);
        this.update(pSDevCenterSVN2);
    }
}

