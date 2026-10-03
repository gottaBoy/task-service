/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.RemoteCallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import net.ibizsys.paas.core.RemoteCallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakServiceBase;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysBakService
extends PSDevSlnSysBakServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysBakService.class);

    @Override
    protected void onBeforeCreate(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        if (this.isMajorSessionFactory() && !DataObject.getBoolValue((Integer)pSDevSlnSysBak.getOfflineFlag(), (boolean)false)) {
            PSDevCenterHelper.testCreate(pSDevSlnSysBak.getPSDevCenter(), "SYSBAKCNT", false);
        }
        super.onBeforeCreate(pSDevSlnSysBak);
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        PSDevSlnSys entityBase;
        PSDevSlnSysBak pSDevSlnSysBak2 = (PSDevSlnSysBak)this.getLast(pSDevSlnSysBak);
        if (pSDevSlnSysBak2.getPSDevSlnSys() != null && DataObject.getIntegerValue((Object)(entityBase = pSDevSlnSysBak2.getPSDevSlnSys()).getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u5fc5\u987b\u5728\u72b6\u6001[%3$s]\u624d\u53ef\u5220\u9664\u5907\u4efd", (Object)entityBase.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(entityBase.getDevSysState().toString()).getText(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(Integer.toString(30)).getText()));
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSysBak2.getLinkFlag(), (boolean)false)) {
            PSDevSlnSysBakLink link = new PSDevSlnSysBakLink();
            link.setPSDevSlnSysBakLinkId(pSDevSlnSysBak2.getPSDevSlnSysBakId());
            link.setSessionFactory(this.getSessionFactory());
            if (link.get(true)) {
                link.reset();
                link.setPSDevSlnSysBakLinkId(pSDevSlnSysBak2.getPSDevSlnSysBakId());
                PSDevSlnSysBakLinkService pSDevSlnSysBakLinkService = (PSDevSlnSysBakLinkService)ServiceGlobal.getService(PSDevSlnSysBakLinkService.class, (SessionFactory)this.getSessionFactory());
                link.setSessionFactory(this.getSessionFactory());
                link.setLinkState(41);
                pSDevSlnSysBakLinkService.sysUpdate(link, false);
            }
        }
        super.onBeforeRemove(pSDevSlnSysBak);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected void onGetWithToken(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        this.get(pSDevSlnSysBak);
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSysBak.getAccessToken()) && !DataObject.getBoolValue((Integer)pSDevSlnSysBak.getLinkFlag(), (boolean)false)) {
            pSDevSlnSysBak.setAccessToken(KeyValueHelper.genGuidEx());
            this.update(pSDevSlnSysBak);
        }
    }

    @Override
    protected void onUpdateEnableLink(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        PSDevSlnSysBak pSDevSlnSysBak2 = new PSDevSlnSysBak();
        pSDevSlnSysBak2.setPSDevSlnSysBakId(pSDevSlnSysBak.getPSDevSlnSysBakId());
        this.get(pSDevSlnSysBak2);
        if (DataObject.getBoolValue((Integer)pSDevSlnSysBak.getEnableLink(), (boolean)false)) {
            if (DataObject.getBoolValue((Integer)pSDevSlnSysBak2.getLinkFlag(), (boolean)false)) {
                throw new Exception("\u94fe\u63a5\u6a21\u5f0f\u7684\u7cfb\u7edf\u6a21\u578b\u5907\u4efd\u65e0\u6cd5\u542f\u7528\u5916\u90e8\u94fe\u63a5");
            }
            if (DataObject.getIntegerValue((Object)pSDevSlnSysBak2.getBackupState(), (Integer)30) != 30) {
                throw new Exception("\u7cfb\u7edf\u6a21\u578b\u5907\u4efd\u72b6\u6001\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a[\u5df2\u5efa\u7acb]");
            }
        }
        this.update(pSDevSlnSysBak);
    }

    @Override
    protected void onCreateWithToken(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSysBak.getLinkCode())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u6a21\u578b\u5907\u4efd\u94fe\u63a5\u4ee3\u7801");
        }
        PSDevSlnSysBak pSDevSlnSysBak2 = new PSDevSlnSysBak();
        pSDevSlnSysBak2.setEnableLink(1);
        pSDevSlnSysBak2.setAccessToken(pSDevSlnSysBak.getLinkCode());
        if (!this.select(pSDevSlnSysBak2, true)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u67e5\u8be2\u5230\u6307\u5b9a\u7cfb\u7edf\u5907\u4efd\uff0c\u94fe\u63a5\u4ee3\u7801\u4e3a[%1$s]", (Object)pSDevSlnSysBak.getLinkCode()));
        }
        if (StringHelper.compare((String)pSDevSlnSysBak.getPSDevSlnSysId(), (String)pSDevSlnSysBak2.getPSDevSlnSysId(), (boolean)true) == 0) {
            throw new Exception(StringHelper.format((String)"\u4e0d\u80fd\u5efa\u7acb\u5f53\u524d\u7cfb\u7edf\u7684\u6a21\u578b\u5907\u4efd\u94fe\u63a5"));
        }
        try {
            pSDevSlnSysBak.setPSDevCenterId(pSDevSlnSysBak.getPSDevSlnSys().getPSDevCenterId());
            pSDevSlnSysBak.setPSDevCenterName(pSDevSlnSysBak.getPSDevSlnSys().getPSDevCenterName());
            pSDevSlnSysBak.setBackupState(10);
            pSDevSlnSysBak.setLinkFlag(1);
            this.create(pSDevSlnSysBak);
        }
        catch (Exception exception) {
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u6a21\u578b\u5907\u4efd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        try {
            PSDevSlnSysBakLink pSDevSlnSysBakLink = new PSDevSlnSysBakLink();
            pSDevSlnSysBakLink.setPSDevSlnSysBakLinkId(pSDevSlnSysBak.getPSDevSlnSysBakId());
            pSDevSlnSysBakLink.setPSDevSlnSysBakLinkName(StringHelper.format((String)"%1$s[%2$s]", (Object)pSDevSlnSysBak.getPSDevSlnSysName(), (Object)pSDevSlnSysBak.getPSDevSlnSysBakName()));
            pSDevSlnSysBakLink.setLinkReqMsg(pSDevSlnSysBak.getLinkReqMsg());
            pSDevSlnSysBakLink.setLinkState(10);
            pSDevSlnSysBakLink.setLinkPSDevCenterId(pSDevSlnSysBak.getPSDevCenterId());
            pSDevSlnSysBakLink.setLinkPSDevCenterName(pSDevSlnSysBak.getPSDevCenterName());
            pSDevSlnSysBakLink.setValidFlag(1);
            pSDevSlnSysBakLink.setPSDevSlnSysId(pSDevSlnSysBak2.getPSDevSlnSysId());
            pSDevSlnSysBakLink.setPSDevSlnSysName(pSDevSlnSysBak2.getPSDevSlnSysName());
            pSDevSlnSysBakLink.setPSDevSlnSysBakId(pSDevSlnSysBak2.getPSDevSlnSysBakId());
            pSDevSlnSysBakLink.setPSDevSlnSysBakName(pSDevSlnSysBak2.getPSDevSlnSysBakName());
            pSDevSlnSysBakLink.setSessionFactory(this.getSessionFactory());
            pSDevSlnSysBakLink.create();
        }
        catch (Exception exception) {
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u6a21\u578b\u5907\u4efd\u94fe\u63a5\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    @Override
    protected RemoteCallResult executeRemoteCall2(String string, IEntity iEntity, boolean bl) throws Exception {
        try {
            if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
                PSDevSlnSysBak pSDevSlnSysBak = new PSDevSlnSysBak();
                iEntity.copyTo((IDataObject)pSDevSlnSysBak, false);
                if (this.get(pSDevSlnSysBak, true)) {
                    if (DataObject.getBoolValue((Integer)pSDevSlnSysBak.getLinkFlag(), (boolean)false)) {
                        PSDevSlnSysBakLink pSDevSlnSysBakLink = new PSDevSlnSysBakLink();
                        pSDevSlnSysBakLink.setPSDevSlnSysBakLinkId(pSDevSlnSysBak.getPSDevSlnSysBakId());
                        PSDevSlnSysBakLinkService pSDevSlnSysBakLinkService = (PSDevSlnSysBakLinkService)ServiceGlobal.getService(PSDevSlnSysBakLinkService.class, (SessionFactory)this.getSessionFactory());
                        if (pSDevSlnSysBakLinkService.get(pSDevSlnSysBakLink, true) && pSDevSlnSysBakLink.getPSDevSlnSysBak() != null && pSDevSlnSysBakLink.getPSDevSlnSysBak().getPSDevSlnSys() != null && pSDevSlnSysBakLink.getPSDevSlnSysBak().getPSDevSlnSys().getPSDevCenterTS() != null && pSDevSlnSysBakLink.getPSDevSlnSysBak().getPSDevSlnSys().getPSDevCenterTS().getPSTaskServer() != null) {
                            return super.executeRemoteCall(pSDevSlnSysBakLink.getPSDevSlnSysBak().getPSDevSlnSys().getPSDevCenterTS().getPSTaskServer(), string, iEntity, bl);
                        }
                    } else if (pSDevSlnSysBak.getPSDevSlnSys() != null && pSDevSlnSysBak.getPSDevSlnSys().getPSDevCenterTS() != null && pSDevSlnSysBak.getPSDevSlnSys().getPSDevCenterTS().getPSTaskServer() != null) {
                        return super.executeRemoteCall(pSDevSlnSysBak.getPSDevSlnSys().getPSDevCenterTS().getPSTaskServer(), string, iEntity, bl);
                    }
                }
            }
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
        return super.executeRemoteCall2(string, iEntity, bl);
    }

    @Override
    protected void onAfterCreate(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevCenterHelper.updatetPSDCResRep(pSDevSlnSysBak.getPSDevCenter(), "SYSBAKCNT");
        }
        super.onAfterCreate(pSDevSlnSysBak);
    }

    @Override
    protected void onAfterRemove(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevSlnSysBak pSDevSlnSysBak2 = (PSDevSlnSysBak)this.getLast(pSDevSlnSysBak);
            PSDevCenterHelper.updatetPSDCResRep(pSDevSlnSysBak2.getPSDevCenter(), "SYSBAKCNT");
        }
        super.onAfterRemove(pSDevSlnSysBak);
    }
}
