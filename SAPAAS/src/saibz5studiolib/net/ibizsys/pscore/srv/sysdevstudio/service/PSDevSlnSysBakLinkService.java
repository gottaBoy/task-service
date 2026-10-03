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
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysBakLinkService
extends PSDevSlnSysBakLinkServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysBakLinkService.class);

    @Override
    protected void onUpdateLinkState(PSDevSlnSysBakLink pSDevSlnSysBakLink) throws Exception {
        PSDevSlnSysBakLink pSDevSlnSysBakLink2 = new PSDevSlnSysBakLink();
        pSDevSlnSysBakLink2.setPSDevSlnSysBakLinkId(pSDevSlnSysBakLink.getPSDevSlnSysBakLinkId());
        this.get(pSDevSlnSysBakLink2);
        PSDevSlnSysBak pSDevSlnSysBak = new PSDevSlnSysBak();
        pSDevSlnSysBak.setPSDevSlnSysBakId(pSDevSlnSysBakLink.getPSDevSlnSysBakLinkId());
        pSDevSlnSysBak.setSessionFactory(this.getSessionFactory());
        if (!pSDevSlnSysBak.get(true)) {
            throw new Exception(StringHelper.format((String)"\u6e90\u5907\u4efd\u4e0d\u5b58\u5728"));
        }
        pSDevSlnSysBak.reset();
        pSDevSlnSysBak.setPSDevSlnSysBakId(pSDevSlnSysBakLink.getPSDevSlnSysBakLinkId());
        pSDevSlnSysBak.setSessionFactory(this.getSessionFactory());
        pSDevSlnSysBak.setLinkRepMsg(pSDevSlnSysBakLink.getLinkRepMsg());
        int n = DataObject.getIntegerValue((Object)pSDevSlnSysBakLink.getLinkState(), (Integer)30);
        boolean bl = DataObject.getBoolValue((Integer)pSDevSlnSysBakLink.getValidFlag(), (boolean)true);
        if (n == 30 && bl) {
            pSDevSlnSysBak.setBackupState(30);
        } else {
            pSDevSlnSysBak.setBackupState(42);
        }
        try {
            PSDevSlnSysBakService pSDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)this.getSessionFactory());
            pSDevSlnSysBakService.sysUpdate(pSDevSlnSysBak, false);
        }
        catch (Exception exception) {
            throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u6e90\u5907\u4efd\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        this.update(pSDevSlnSysBakLink);
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysBakLink pSDevSlnSysBakLink) throws Exception {
        PSDevSlnSysBak pSDevSlnSysBak = new PSDevSlnSysBak();
        pSDevSlnSysBak.setPSDevSlnSysBakId(pSDevSlnSysBakLink.getPSDevSlnSysBakLinkId());
        pSDevSlnSysBak.setSessionFactory(this.getSessionFactory());
        if (pSDevSlnSysBak.get(true)) {
            pSDevSlnSysBak.reset();
            pSDevSlnSysBak.setPSDevSlnSysBakId(pSDevSlnSysBakLink.getPSDevSlnSysBakLinkId());
            pSDevSlnSysBak.setLinkRepMsg("\u5907\u4efd\u94fe\u63a5\u5df2\u88ab\u5220\u9664");
            pSDevSlnSysBak.setBackupState(41);
            try {
                PSDevSlnSysBakService pSDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysBakService.sysUpdate(pSDevSlnSysBak, false);
            }
            catch (Exception exception) {
                throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u6e90\u5907\u4efd\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        super.onBeforeRemove(pSDevSlnSysBakLink);
    }
}

