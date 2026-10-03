/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRefBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysRefLink;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysRefService
extends PSDevSlnSysRefServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysRefService.class);

    @Override
    protected void onBeforeCreate(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && pSDevSlnSysRef.isLinkFlagDirty() && !DataObject.getBoolValue((Integer)pSDevSlnSysRef.getLinkFlag(), (boolean)false)) {
            this.getPSDevSlnSys(pSDevSlnSysRef);
        }
        super.onBeforeCreate(pSDevSlnSysRef);
    }

    @Override
    protected void onBeforeUpdate(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && pSDevSlnSysRef.isLinkFlagDirty() && !DataObject.getBoolValue((Integer)pSDevSlnSysRef.getLinkFlag(), (boolean)false)) {
            this.getPSDevSlnSys(pSDevSlnSysRef);
        }
        super.onBeforeUpdate(pSDevSlnSysRef);
    }

    @Override
    protected void onAfterCreate(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && pSDevSlnSysRef.isLinkFlagDirty()) {
            if (!DataObject.getBoolValue((Integer)pSDevSlnSysRef.getLinkFlag(), (boolean)false)) {
                this.syncPSSysModelInst(pSDevSlnSysRef);
            } else {
                this.createWithToken(pSDevSlnSysRef);
            }
        }
        super.onAfterCreate(pSDevSlnSysRef);
    }

    @Override
    protected void onAfterUpdate(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && pSDevSlnSysRef.isLinkFlagDirty() && !DataObject.getBoolValue((Integer)pSDevSlnSysRef.getLinkFlag(), (boolean)false)) {
            this.syncPSSysModelInst(pSDevSlnSysRef);
        }
        super.onAfterUpdate(pSDevSlnSysRef);
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        PSDevSlnSys pSDevSlnSys = this.getPSDevSlnSys(pSDevSlnSysRef);
        super.onBeforeRemove(pSDevSlnSysRef);
    }

    protected void syncPSSysModelInst(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        PSDevSlnSysRef pSDevSlnSysRef2 = new PSDevSlnSysRef();
        pSDevSlnSysRef2.setPSDevSlnSysRefId(pSDevSlnSysRef.getPSDevSlnSysRefId());
        this.get(pSDevSlnSysRef2);
        PSDevSlnSysSrv pSDevSlnSysSrv = pSDevSlnSysRef2.getRefPSDevSlnSysSrv();
        PSDevSlnSys pSDevSlnSys = pSDevSlnSysRef2.getRefPSDevSlnSys();
        PSDevSlnSys pSDevSlnSys2 = this.getPSDevSlnSys(pSDevSlnSysRef);
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(pSDevSlnSys2.getPSSysModelInst());
        PSSysRef pSSysRef = new PSSysRef();
        pSSysRef.setSessionFactory(sessionFactory);
        pSSysRef.setPSSystemId(pSDevSlnSys2.getPSSystemId());
        pSSysRef.setPSSystemName(pSDevSlnSys2.getPSDevSlnSysName());
        pSSysRef.setRealSysId(pSDevSlnSysRef2.getRefMode());
        pSSysRef.setPSDevSlnSysId(pSDevSlnSysRef2.getRefPSDevSlnSysId());
        pSSysRef.setPSDevSlnSysName(pSDevSlnSysRef2.getRefPSDevSlnSysName());
        pSSysRef.setPSSysRefName(pSDevSlnSysRef2.getPSDevSlnSysRefName());
        pSSysRef.setOrderValue(pSDevSlnSysRef2.getOrderValue());
        if (StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"ETLSOURCE", (boolean)false) == 0 || StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"ETLMODEL", (boolean)false) == 0 || StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"CLOUDHUBSUBAPP", (boolean)false) == 0 || StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"ETLEXTRACT", (boolean)false) == 0 || StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"ETLTRANSFORM", (boolean)false) == 0 || StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"ETLLOAD", (boolean)false) == 0 || StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"USER", (boolean)false) == 0 || StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"USER2", (boolean)false) == 0 || StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"USER3", (boolean)false) == 0 || StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"USER4", (boolean)false) == 0) {
            pSSysRef.setSysRefType(pSDevSlnSysRef.getUsage());
        } else if (StringHelper.compare((String)pSDevSlnSysRef.getUsage(), (String)"CLOUD", (boolean)false) == 0) {
            pSSysRef.setSysRefType("DEVSYSCLOUD");
            pSSysRef.setPSDevSlnSysSrvId(pSDevSlnSysRef2.getRefPSDevSlnSysSrvId());
            pSSysRef.setPSDevSlnSysSrvName(pSDevSlnSysRef2.getRefPSDevSlnSysSrvName());
        } else {
            pSSysRef.setSysRefType("DEVSYS");
            pSSysRef.setPSDevSlnSysSrvId(pSDevSlnSysRef2.getRefPSDevSlnSysSrvId());
            pSSysRef.setPSDevSlnSysSrvName(pSDevSlnSysRef2.getRefPSDevSlnSysSrvName());
        }
        pSSysRef.setSFFWFlag(0);
        pSSysRef.setRefParam(pSDevSlnSysRef2.getRefParam());
        pSSysRef.setRefParam2(pSDevSlnSysRef2.getRefParam2());
        pSSysRef.setSysCodeName(pSDevSlnSysRef2.getSysCodeName());
        pSSysRef.setSysPkgName(pSDevSlnSysRef2.getSysPkgName());
        if (pSDevSlnSysSrv != null) {
            pSSysRef.setSrvCodeName(pSDevSlnSysSrv.getCodeName());
        } else {
            pSSysRef.setSrvCodeName(null);
        }
        if (pSDevSlnSys != null) {
            String string = null;
            if (StringHelper.compare((String)pSDevSlnSys.getVCType(), (String)"TRUNK", (boolean)true) == 0) {
                string = "TRUNK";
            } else if (StringHelper.compare((String)pSDevSlnSys.getVCType(), (String)"BRANCH", (boolean)true) == 0) {
                string = StringHelper.format((String)"B_%1$s", (Object)pSDevSlnSys.getSysVer());
            } else if (StringHelper.compare((String)pSDevSlnSys.getVCType(), (String)"TAG", (boolean)true) == 0) {
                string = StringHelper.format((String)"T_%1$s", (Object)pSDevSlnSys.getSysVer());
            }
            pSSysRef.setSysVCName(string);
            pSSysRef.setDevSlnCodeName(pSDevSlnSys.getPSDevSln().getCodeName());
            pSSysRef.setDCDomainName(pSDevSlnSys.getPSDevSln().getPSDevCenter().getDomainName());
            pSSysRef.setSysName(pSDevSlnSys.getPSDevSlnSysName());
            pSSysRef.setValidFlag(1);
        } else {
            pSSysRef.setSysVCName(null);
            pSSysRef.setDevSlnCodeName(null);
            pSSysRef.setDCDomainName(null);
            pSSysRef.setSysName(null);
            pSSysRef.setValidFlag(0);
        }
        pSSysRef.setVersion(1);
        pSSysRef.save();
    }

    protected PSDevSlnSys getPSDevSlnSys(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        PSDevSlnSysRef pSDevSlnSysRef2;
        PSDevSlnSys pSDevSlnSys;
        Object object;
        String string = pSDevSlnSysRef.getPSDevSlnSysId();
        if (StringHelper.isNullOrEmpty((String)string) && (object = (PSDevSlnSysRef)this.getLast(pSDevSlnSysRef)) != null) {
            string = ((PSDevSlnSysRefBase)object).getPSDevSlnSysId();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u6807\u8bc6");
        }
        object = pSDevSlnSysRef.getRefPSDevSlnSysSrvId();
        String string2 = pSDevSlnSysRef.getUsage();
        if (StringHelper.isNullOrEmpty((String)object) && (pSDevSlnSysRef2 = (PSDevSlnSysRef)this.getLast(pSDevSlnSysRef)) != null) {
            object = pSDevSlnSysRef2.getRefPSDevSlnSysSrvId();
        }
        if (StringHelper.isNullOrEmpty((String)string2) && (pSDevSlnSysRef2 = (PSDevSlnSysRef)this.getLast(pSDevSlnSysRef)) != null) {
            string2 = pSDevSlnSysRef2.getUsage();
        }
        if (StringHelper.compare((String)string2, (String)"CLOUD", (boolean)false) != 0 && StringHelper.compare((String)string2, (String)"ETLMODEL", (boolean)false) != 0 && StringHelper.compare((String)string2, (String)"ETLSOURCE", (boolean)false) != 0 && StringHelper.compare((String)string2, (String)"CLOUDHUBSUBAPP", (boolean)false) != 0 && StringHelper.compare((String)string2, (String)"ETLEXTRACT", (boolean)false) != 0 && StringHelper.compare((String)string2, (String)"ETLTRANSFORM", (boolean)false) != 0 && StringHelper.compare((String)string2, (String)"ETLLOAD", (boolean)false) != 0 && StringHelper.compare((String)string2, (String)"USER", (boolean)false) != 0 && StringHelper.compare((String)string2, (String)"USER2", (boolean)false) != 0 && StringHelper.compare((String)string2, (String)"USER3", (boolean)false) != 0 && StringHelper.compare((String)string2, (String)"USER4", (boolean)false) != 0 && StringHelper.isNullOrEmpty((String)object)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f15\u7528\u5f00\u53d1\u7cfb\u7edf\u670d\u52a1\u6807\u8bc6");
        }
        pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnSysId(string);
        pSDevSlnSys.setSessionFactory(this.getSessionFactory());
        pSDevSlnSys.get();
        if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u8c03\u6574\u7cfb\u7edf\u5f15\u7528", (Object)pSDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(pSDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.isNullOrEmpty((String)object)) {
            PSDevSlnSysSrv pSDevSlnSysSrv = new PSDevSlnSysSrv();
            pSDevSlnSysSrv.setPSDevSlnSysSrvId((String)object);
            pSDevSlnSysSrv.setSessionFactory(this.getSessionFactory());
            pSDevSlnSysSrv.get();
            pSDevSlnSysRef.setSysCodeName(pSDevSlnSysSrv.getSysCodeName());
            pSDevSlnSysRef.setSysPkgName(pSDevSlnSysSrv.getPKGCodeName());
        } else {
            pSDevSlnSysRef.setSysCodeName(null);
            pSDevSlnSysRef.setSysPkgName(null);
        }
        return pSDevSlnSys;
    }

    protected void createWithToken(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSysRef.getLinkCode())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf\u5f15\u7528\u94fe\u63a5\u4ee3\u7801");
        }
        if (pSDevSlnSysRef.getPSDevSlnSys() == null) {
            throw new Exception("\u65e0\u6548\u7684\u5f00\u53d1\u7cfb\u7edf");
        }
        PSDevSlnSysSrvService pSDevSlnSysSrvService = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnSysSrv pSDevSlnSysSrv = new PSDevSlnSysSrv();
        pSDevSlnSysSrv.setEnableLink(1);
        pSDevSlnSysSrv.setAccessToken(pSDevSlnSysRef.getLinkCode());
        if (!pSDevSlnSysSrvService.select(pSDevSlnSysSrv, true)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u67e5\u8be2\u5230\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1\u4f53\u7cfb\uff0c\u94fe\u63a5\u4ee3\u7801\u4e3a[%1$s]", (Object)pSDevSlnSysRef.getLinkCode()));
        }
        if (StringHelper.compare((String)pSDevSlnSysRef.getPSDevSlnSysId(), (String)pSDevSlnSysSrv.getPSDevSlnSysId(), (boolean)true) == 0) {
            throw new Exception(StringHelper.format((String)"\u4e0d\u80fd\u5efa\u7acb\u5f53\u524d\u7cfb\u7edf\u7684\u670d\u52a1\u4f53\u7cfb\u94fe\u63a5"));
        }
        try {
            PSDevSlnSysRefLink pSDevSlnSysRefLink = new PSDevSlnSysRefLink();
            pSDevSlnSysRefLink.setPSDevSlnSysRefLinkId(pSDevSlnSysRef.getPSDevSlnSysRefId());
            pSDevSlnSysRefLink.setPSDevSlnSysRefLinkName(StringHelper.format((String)"%1$s[%2$s]", (Object)pSDevSlnSysRef.getPSDevSlnSysName(), (Object)pSDevSlnSysRef.getPSDevSlnSysRefName()));
            pSDevSlnSysRefLink.setLinkReqMsg(pSDevSlnSysRef.getLinkReqMsg());
            pSDevSlnSysRefLink.setLinkState(10);
            pSDevSlnSysRefLink.setLinkPSDevCenterId(pSDevSlnSysRef.getPSDevSlnSys().getPSDevCenterId());
            pSDevSlnSysRefLink.setLinkPSDevCenterName(pSDevSlnSysRef.getPSDevSlnSys().getPSDevCenterName());
            pSDevSlnSysRefLink.setValidFlag(1);
            pSDevSlnSysRefLink.setPSDevSlnSysId(pSDevSlnSysSrv.getPSDevSlnSysId());
            pSDevSlnSysRefLink.setPSDevSlnSysName(pSDevSlnSysSrv.getPSDevSlnSysName());
            pSDevSlnSysRefLink.setPSDevSlnSysSrvId(pSDevSlnSysSrv.getPSDevSlnSysSrvId());
            pSDevSlnSysRefLink.setPSDevSlnSysSrvName(pSDevSlnSysSrv.getPSDevSlnSysSrvName());
            pSDevSlnSysRefLink.setPSDevSlnSysRefId(pSDevSlnSysRef.getPSDevSlnSysRefId());
            pSDevSlnSysRefLink.setPSDevSlnSysRefName(pSDevSlnSysRef.getPSDevSlnSysRefName());
            pSDevSlnSysRefLink.setAccessToken(pSDevSlnSysRef.getLinkCode());
            pSDevSlnSysRefLink.setSessionFactory(this.getSessionFactory());
            pSDevSlnSysRefLink.create();
        }
        catch (Exception exception) {
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u670d\u52a1\u4f53\u7cfb\u94fe\u63a5\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    @Override
    protected void onUpdateLinkState(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        this.update(pSDevSlnSysRef);
        if (DataObject.getBoolValue((Integer)pSDevSlnSysRef.getLinkFlag(), (boolean)false) && DataObject.getIntegerValue((Object)pSDevSlnSysRef.getLinkState(), (Integer)30) == 30) {
            this.syncPSSysModelInst(pSDevSlnSysRef);
        } else {
            this.syncPSSysModelInst(pSDevSlnSysRef);
        }
    }
}

