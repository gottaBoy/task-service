/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysRefLink;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysRefLinkServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysRefLinkService
extends PSDevSlnSysRefLinkServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysRefLinkService.class);

    @Override
    protected void onUpdateLinkState(PSDevSlnSysRefLink pSDevSlnSysRefLink) throws Exception {
        PSDevSlnSysRefLink pSDevSlnSysRefLink2 = new PSDevSlnSysRefLink();
        pSDevSlnSysRefLink2.setPSDevSlnSysRefLinkId(pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId());
        this.get((IEntity)pSDevSlnSysRefLink2);
        PSDevSlnSysRef pSDevSlnSysRef = new PSDevSlnSysRef();
        pSDevSlnSysRef.setPSDevSlnSysRefId(pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId());
        pSDevSlnSysRef.setSessionFactory(this.getSessionFactory());
        if (!pSDevSlnSysRef.get(true)) {
            throw new Exception(StringHelper.format((String)"\u6e90\u7cfb\u7edf\u5f15\u7528\u4e0d\u5b58\u5728"));
        }
        pSDevSlnSysRef.reset();
        pSDevSlnSysRef.setPSDevSlnSysRefId(pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId());
        pSDevSlnSysRef.setSessionFactory(this.getSessionFactory());
        pSDevSlnSysRef.setLinkRepMsg(pSDevSlnSysRefLink.getLinkRepMsg());
        int n = DataObject.getIntegerValue((Object)pSDevSlnSysRefLink.getLinkState(), (Integer)30);
        boolean bl = DataObject.getBoolValue((Integer)pSDevSlnSysRefLink.getValidFlag(), (boolean)true);
        if (n == 30 && bl) {
            pSDevSlnSysRef.setLinkState(30);
            pSDevSlnSysRef.setRefPSDevSlnSysId(pSDevSlnSysRefLink2.getPSDevSlnSysId());
            pSDevSlnSysRef.setRefPSDevSlnSysName(pSDevSlnSysRefLink2.getPSDevSlnSysName());
            pSDevSlnSysRef.setRefPSDevSlnSysSrvId(pSDevSlnSysRefLink2.getPSDevSlnSysSrvId());
            pSDevSlnSysRef.setRefPSDevSlnSysSrvName(pSDevSlnSysRefLink2.getPSDevSlnSysSrvName());
        } else {
            pSDevSlnSysRef.setLinkState(42);
            pSDevSlnSysRef.setRefPSDevSlnSysId(null);
            pSDevSlnSysRef.setRefPSDevSlnSysName(null);
            pSDevSlnSysRef.setRefPSDevSlnSysSrvId(null);
            pSDevSlnSysRef.setRefPSDevSlnSysSrvName(null);
        }
        try {
            PSDevSlnSysRefService pSDevSlnSysRefService = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, (SessionFactory)this.getSessionFactory());
            pSDevSlnSysRefService.updateLinkState(pSDevSlnSysRef);
        }
        catch (Exception exception) {
            throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u6e90\u5f00\u53d1\u7cfb\u7edf\u5f15\u7528\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        this.update(pSDevSlnSysRefLink);
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysRefLink pSDevSlnSysRefLink) throws Exception {
        PSDevSlnSysRef pSDevSlnSysRef = new PSDevSlnSysRef();
        pSDevSlnSysRef.setPSDevSlnSysRefId(pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId());
        pSDevSlnSysRef.setSessionFactory(this.getSessionFactory());
        if (pSDevSlnSysRef.get(true)) {
            pSDevSlnSysRef.reset();
            pSDevSlnSysRef.setPSDevSlnSysRefId(pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId());
            pSDevSlnSysRef.setLinkRepMsg("\u5f15\u7528\u94fe\u63a5\u5df2\u88ab\u5220\u9664");
            pSDevSlnSysRef.setLinkState(41);
            pSDevSlnSysRef.setRefPSDevSlnSysId(null);
            pSDevSlnSysRef.setRefPSDevSlnSysName(null);
            pSDevSlnSysRef.setRefPSDevSlnSysSrvId(null);
            pSDevSlnSysRef.setRefPSDevSlnSysSrvName(null);
            try {
                PSDevSlnSysRefService pSDevSlnSysRefService = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysRefService.updateLinkState(pSDevSlnSysRef);
            }
            catch (Exception exception) {
                throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u6e90\u5f15\u7528\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        super.onBeforeRemove(pSDevSlnSysRefLink);
    }

    @Override
    protected void onCreateWithToken(PSDevSlnSysRefLink pSDevSlnSysRefLink) throws Exception {
        this.create(pSDevSlnSysRefLink);
    }
}

