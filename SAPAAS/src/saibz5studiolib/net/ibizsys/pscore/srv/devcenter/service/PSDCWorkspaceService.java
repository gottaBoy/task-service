/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.sql.Timestamp;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceAction;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceActionService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCWorkspaceService
extends PSDCWorkspaceServiceBase {
    private static final Log log = LogFactory.getLog(PSDCWorkspaceService.class);

    @Override
    protected boolean isUpdateModelKeeper(PSDCWorkspace pSDCWorkspace) throws Exception {
        return PSCoreEntityKeeperGlobal.getCurrent(this.getSessionFactory()).isPSDCWorkspaceEnabled();
    }

    @Override
    protected void onUpdateModelKeeper(PSDCWorkspace pSDCWorkspace) throws Exception {
        final String string = pSDCWorkspace.getPSDCWorkspaceId();
        SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
                    pSDCWorkspace.setPSDCWorkspaceId(string);
                    PSDCWorkspaceService.this.get(pSDCWorkspace);
                    PSCoreEntityKeeperGlobal.getCurrent(PSDCWorkspaceService.this.getSessionFactory()).updatePSDCWorkspace(pSDCWorkspace);
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
            }

            public void rollback() {
            }
        });
    }

    @Override
    protected void onRemoveModelKeeper(PSDCWorkspace pSDCWorkspace) throws Exception {
        final String string = pSDCWorkspace.getPSDCWorkspaceId();
        SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSCoreEntityKeeperGlobal.getCurrent(PSDCWorkspaceService.this.getSessionFactory()).resetPSDCWorkspace(string);
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
            }

            public void rollback() {
            }
        });
    }

    @Override
    protected void onAssign(PSDCWorkspace pSDCWorkspace) throws Exception {
        PSDCWorkspace pSDCWorkspace2 = new PSDCWorkspace();
        pSDCWorkspace2.setPSDCWorkspaceId(pSDCWorkspace.getPSDCWorkspaceId());
        this.get(pSDCWorkspace2);
        if (!StringHelper.isNullOrEmpty((String)pSDCWorkspace2.getPSDevSlnId())) {
            throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u5df2\u7ecf\u5206\u914d\u5230\u5f00\u53d1\u65b9\u6848[%2$s],\u65e0\u6cd5\u518d\u6b21\u5206\u914d", (Object)pSDCWorkspace2.getPSDCWorkspaceName(), (Object)pSDCWorkspace2.getPSDevSlnName()));
        }
        this.update(pSDCWorkspace, true);
    }

    @Override
    protected void onUnassign(PSDCWorkspace pSDCWorkspace) throws Exception {
        this.get(pSDCWorkspace);
        if (StringHelper.isNullOrEmpty((String)pSDCWorkspace.getPSDevSlnId())) {
            return;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDCWorkspace.getPSDevSlnSysId())) {
            throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u5df2\u7ecf\u88ab\u5f00\u53d1\u7cfb\u7edf[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u53d6\u6d88\u5206\u914d", (Object)pSDCWorkspace.getPSDCWorkspaceName(), (Object)pSDCWorkspace.getPSDevSlnSysName()));
        }
        String string = pSDCWorkspace.getPSDCWorkspaceId();
        pSDCWorkspace.reset();
        pSDCWorkspace.setPSDCWorkspaceId(string);
        pSDCWorkspace.setPSDevSlnId(null);
        pSDCWorkspace.setPSDevSlnName(null);
        this.update(pSDCWorkspace);
    }

    @Override
    protected void onInstallSys(PSDCWorkspace pSDCWorkspace) throws Exception {
        PSDCWorkspace pSDCWorkspace2 = new PSDCWorkspace();
        pSDCWorkspace2.setPSDCWorkspaceId(pSDCWorkspace.getPSDCWorkspaceId());
        this.get(pSDCWorkspace2);
        if (!StringHelper.isNullOrEmpty((String)pSDCWorkspace2.getCurAction()) && StringHelper.compare((String)pSDCWorkspace2.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u8fdb\u884c\u7cfb\u7edf\u5b89\u88c5", (Object)pSDCWorkspace2.getPSDCWorkspaceName(), (Object)DCWorkspaceLogTypeCodeListModel.getInstance().getCodeItem(pSDCWorkspace2.getCurAction()).getText()));
        }
        if (!StringHelper.isNullOrEmpty((String)pSDCWorkspace2.getPSDevSlnSysId())) {
            throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u5df2\u7ecf\u5b89\u88c5\u5f00\u53d1\u7cfb\u7edf[%2$s]\uff0c\u65e0\u6cd5\u518d\u6b21\u5b89\u88c5", (Object)pSDCWorkspace2.getPSDCWorkspaceName(), (Object)pSDCWorkspace2.getPSDevSlnSysName()));
        }
        PSDevSlnSys pSDevSlnSys = null;
        if (StringHelper.isNullOrEmpty((String)pSDCWorkspace.getPSDevSlnSysId())) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u8981\u5b89\u88c5\u5230\u751f\u4ea7\u7ebf\u7684\u5f00\u53d1\u7cfb\u7edf"));
        }
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnSysId(pSDCWorkspace.getPSDevSlnSysId());
        pSCoreSysServiceBase.get(pSDevSlnSys);
        if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)30) != 35) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6ca1\u6709\u5904\u4e8e[\u79bb\u7ebf]\u72b6\u6001\uff0c\u65e0\u6cd5\u8fdb\u884c\u5b89\u88c5", (Object)pSDevSlnSys.getPSDevSlnSysName()));
        }
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSysModelInstId())) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u672a\u6307\u5b9a\u6a21\u578b\u4ed3\u5e93\uff0c\u65e0\u6cd5\u8fdb\u884c\u5b89\u88c5", (Object)pSDevSlnSys.getPSDevSlnSysName()));
        }
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getCurAction()) && StringHelper.compare((String)pSDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u8fdb\u884c\u5b89\u88c5", (Object)pSDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(pSDevSlnSys.getCurAction()).getText()));
        }
        pSCoreSysServiceBase = (PSDCWorkspaceActionService)ServiceGlobal.getService(PSDCWorkspaceActionService.class, (SessionFactory)this.getSessionFactory());
        PSDCWorkspaceAction pSDCWorkspaceAction = new PSDCWorkspaceAction();
        pSDCWorkspaceAction.setPSDCWorkspaceActionName(StringHelper.format((String)"\u751f\u4ea7\u7ebf\u4f5c\u4e1a[%1$s]#\u7cfb\u7edf\u5b89\u88c5[%2$s]", (Object)DateHelper.getCurTimeString(), (Object)pSDevSlnSys.getPSDevSlnSysName()));
        pSDCWorkspaceAction.setPSDCWorkspaceId(pSDCWorkspace2.getPSDCWorkspaceId());
        pSDCWorkspaceAction.setPSDCWorkspaceName(pSDCWorkspace2.getPSDCWorkspaceName());
        pSDCWorkspaceAction.setActionState(BackendActionStateCodeListModel.NOTCREATED);
        pSDCWorkspaceAction.setActionType("INSTALLSYS");
        pSDCWorkspaceAction.setPSDevSlnSysId(pSDCWorkspace.getPSDevSlnSysId());
        pSDCWorkspaceAction.setPSDevCenterId(pSDCWorkspace2.getPSDevCenterId());
        pSDCWorkspaceAction.setPSDevCenterName(pSDCWorkspace2.getPSDevCenterName());
        pSDCWorkspaceAction.setActionParam(pSDCWorkspace.getActionParam());
        pSDCWorkspaceAction.setActionParam2(pSDCWorkspace.getActionParam2());
        pSDCWorkspaceAction.setActionParam3(pSDCWorkspace.getActionParam3());
        pSDCWorkspaceAction.setActionParam4(pSDCWorkspace.getActionParam4());
        pSCoreSysServiceBase.create(pSDCWorkspaceAction);
        final PSDCWorkspaceActionService actionService = (PSDCWorkspaceActionService)pSCoreSysServiceBase;
        final PSDCWorkspaceAction pendingAction = pSDCWorkspaceAction;
        SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    actionService.executeAction("X2_ADDDCBKTASK", pendingAction);
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
            }

            public void rollback() {
            }
        });
    }

    @Override
    protected void onUninstallSys(PSDCWorkspace pSDCWorkspace) throws Exception {
        PSDCWorkspace pSDCWorkspace2 = new PSDCWorkspace();
        pSDCWorkspace2.setPSDCWorkspaceId(pSDCWorkspace.getPSDCWorkspaceId());
        this.get(pSDCWorkspace2);
        if (!StringHelper.isNullOrEmpty((String)pSDCWorkspace2.getCurAction()) && StringHelper.compare((String)pSDCWorkspace2.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u8fdb\u884c\u7cfb\u7edf\u5378\u8f7d", (Object)pSDCWorkspace2.getPSDCWorkspaceName(), (Object)DCWorkspaceLogTypeCodeListModel.getInstance().getCodeItem(pSDCWorkspace2.getCurAction()).getText()));
        }
        PSDevSlnSys pSDevSlnSys = null;
        if (StringHelper.isNullOrEmpty((String)pSDCWorkspace2.getPSDevSlnSysId())) {
            throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u672a\u5b89\u88c5\u5f00\u53d1\u7cfb\u7edf\uff0c\u65e0\u6cd5\u5378\u8f7d", (Object)pSDCWorkspace2.getPSDCWorkspaceName()));
        }
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnSysId(pSDCWorkspace2.getPSDevSlnSysId());
        pSCoreSysServiceBase.get(pSDevSlnSys);
        if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6ca1\u6709\u5904\u4e8e[\u8fde\u7ebf]\u72b6\u6001\uff0c\u65e0\u6cd5\u8fdb\u884c\u5378\u8f7d", (Object)pSDevSlnSys.getPSDevSlnSysName()));
        }
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSysModelInstId())) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u672a\u6307\u5b9a\u6a21\u578b\u4ed3\u5e93\uff0c\u65e0\u6cd5\u8fdb\u884c\u5b89\u88c5", (Object)pSDevSlnSys.getPSDevSlnSysName()));
        }
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getCurAction()) && StringHelper.compare((String)pSDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u8fdb\u884c\u5378\u8f7d", (Object)pSDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(pSDevSlnSys.getCurAction()).getText()));
        }
        pSCoreSysServiceBase = (PSDCWorkspaceActionService)ServiceGlobal.getService(PSDCWorkspaceActionService.class, (SessionFactory)this.getSessionFactory());
        PSDCWorkspaceAction pSDCWorkspaceAction = new PSDCWorkspaceAction();
        pSDCWorkspaceAction.setPSDCWorkspaceActionName(StringHelper.format((String)"\u751f\u4ea7\u7ebf\u4f5c\u4e1a[%1$s]#\u7cfb\u7edf\u5378\u8f7d[%2$s]", (Object)DateHelper.getCurTimeString(), (Object)pSDevSlnSys.getPSDevSlnSysName()));
        pSDCWorkspaceAction.setPSDCWorkspaceId(pSDCWorkspace2.getPSDCWorkspaceId());
        pSDCWorkspaceAction.setPSDCWorkspaceName(pSDCWorkspace2.getPSDCWorkspaceName());
        pSDCWorkspaceAction.setActionState(BackendActionStateCodeListModel.NOTCREATED);
        pSDCWorkspaceAction.setActionType("UNINSTALLSYS");
        pSDCWorkspaceAction.setPSDevSlnSysId(pSDCWorkspace2.getPSDevSlnSysId());
        pSDCWorkspaceAction.setPSDevCenterId(pSDCWorkspace2.getPSDevCenterId());
        pSDCWorkspaceAction.setPSDevCenterName(pSDCWorkspace2.getPSDevCenterName());
        pSDCWorkspaceAction.setActionParam(pSDCWorkspace.getActionParam());
        pSDCWorkspaceAction.setActionParam2(pSDCWorkspace.getActionParam2());
        pSDCWorkspaceAction.setActionParam3(pSDCWorkspace.getActionParam3());
        pSDCWorkspaceAction.setActionParam4(pSDCWorkspace.getActionParam4());
        pSCoreSysServiceBase.create(pSDCWorkspaceAction);
        final PSDCWorkspaceActionService actionService = (PSDCWorkspaceActionService)pSCoreSysServiceBase;
        final PSDCWorkspaceAction pendingAction = pSDCWorkspaceAction;
        SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    actionService.executeAction("X2_ADDDCBKTASK", pendingAction);
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
            }

            public void rollback() {
            }
        });
    }

    @Override
    protected void onBeforeCreate(PSDCWorkspace pSDCWorkspace) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevCenterHelper.testCreate(pSDCWorkspace.getPSDevCenter(), "WORKSPACECNT", false);
        }
        super.onBeforeCreate(pSDCWorkspace);
    }

    @Override
    protected void onAfterCreate(PSDCWorkspace pSDCWorkspace) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevCenterHelper.updatetPSDCResRep(pSDCWorkspace.getPSDevCenter(), "WORKSPACECNT");
        }
        super.onAfterCreate(pSDCWorkspace);
    }

    @Override
    protected void onBeforeRemove(PSDCWorkspace pSDCWorkspace) throws Exception {
        PSDCWorkspace pSDCWorkspace2;
        if (this.isMajorSessionFactory() && !StringHelper.isNullOrEmpty((String)(pSDCWorkspace2 = (PSDCWorkspace)this.getLast(pSDCWorkspace)).getPSDevSlnSysId())) {
            throw new Exception(StringHelper.format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u5df2\u5b89\u88c5\u7cfb\u7edf\uff0c\u65e0\u6cd5\u5220\u9664"));
        }
        super.onBeforeRemove(pSDCWorkspace);
    }

    @Override
    protected void onAfterRemove(PSDCWorkspace pSDCWorkspace) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDCWorkspace pSDCWorkspace2 = (PSDCWorkspace)this.getLast(pSDCWorkspace);
            PSDevCenterHelper.updatetPSDCResRep(pSDCWorkspace2.getPSDevCenter(), "WORKSPACECNT");
            if (!StringHelper.isNullOrEmpty((String)pSDCWorkspace2.getPSWorkspaceId())) {
                PSWorkspaceService pSWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)this.getSessionFactory());
                PSWorkspace pSWorkspace = new PSWorkspace();
                pSWorkspace.setPSWorkspaceId(pSDCWorkspace2.getPSWorkspaceId());
                if (pSWorkspaceService.checkKey(pSWorkspace) == 1) {
                    pSWorkspace.setPSDevCenterId(null);
                    pSWorkspace.setPSDevCenterName(null);
                    pSWorkspace.setWorkspaceState(40);
                    pSWorkspace.setPSDCWorkspaceId(null);
                    pSWorkspaceService.sysUpdate(pSWorkspace, false);
                }
            }
        }
        super.onAfterRemove(pSDCWorkspace);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        if (this.isMajorSessionFactory()) {
            return true;
        }
        return super.isPrepareLastForRemove();
    }

    @Override
    protected void onRawUninstallSys(PSDCWorkspace pSDCWorkspace) throws Exception {
        this.get(pSDCWorkspace);
    }

    @Override
    protected void onTranslate(Map<String, Object> map) throws Exception {
        int n;
        super.onTranslate(map);
        Timestamp timestamp = DataTypeHelper.getTimestampValue((Object)map.get("EXPIREDTIME".toLowerCase()));
        if (timestamp != null && timestamp.getTime() < System.currentTimeMillis() && (n = DataTypeHelper.getIntegerValue((Object)map.get("RESSTATE".toLowerCase()), (Integer)20).intValue()) == 20) {
            map.put("RESSTATE".toLowerCase(), 41);
        }
    }
}
