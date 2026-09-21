/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskImplBase
 *  SA.SRFDA.PS.Core.PSTaskServerEnvImpl
 *  SA.SRFDA.PS.Core.Util.CmdHelper
 *  SA.SRFDA.PS.Core.Util.CmdHelper$Result
 *  SA.SRFDA.PS.Core.Util.PSWorkspaceHelper
 *  SA.SRFDA.PS.Core.Workspace.IPSDCWorkspace
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.SVNRepoStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceAction
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceActionService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWProject
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSUWProjectService
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskImplBase;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Util.CmdHelper;
import SA.SRFDA.PS.Core.Util.PSWorkspaceHelper;
import SA.SRFDA.PS.Core.Workspace.IPSDCWorkspace;
import java.io.File;
import java.sql.Timestamp;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.SVNRepoStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceAction;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceActionService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWProject;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWProjectService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class WorkspaceActionPSDCBKTaskImpl
extends PSDevCenterBKTaskImplBase {
    private static final Log log = LogFactory.getLog(WorkspaceActionPSDCBKTaskImpl.class);

    protected String onRun() throws Exception {
        String strPSDCWorkspaceId = this.getTaskParam();
        String strPSDCWorkspaceActionId = this.getTaskParam2();
        PSDCWorkspaceAction psDCWorkspaceAction = new PSDCWorkspaceAction();
        PSDCWorkspaceAction psDCWorkspaceAction2 = new PSDCWorkspaceAction();
        PSDCWorkspaceActionService psDCWorkspaceActionService = (PSDCWorkspaceActionService)ServiceGlobal.getService(PSDCWorkspaceActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSUWProjectService psUWProjectService = (PSUWProjectService)ServiceGlobal.getService(PSUWProjectService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        String strOwnerId = StringHelper.format((String)"%1$s|%2$s", (Object)psDCWorkspaceActionService.getDEModel().getName(), (Object)strPSDCWorkspaceActionId);
        String strPSWorkspaceId = null;
        String strPSDevSlnSysId = null;
        String strPSUWProjectId = null;
        int nLastPSDevSlnSysState = -1;
        PSUWProject psUWProject = null;
        try {
            PSDevSlnSys psDevSlnSys2;
            PSDevSlnSys psDevSlnSys;
            psDCWorkspaceAction.setPSDCWorkspaceActionId(strPSDCWorkspaceActionId);
            psDCWorkspaceActionService.get((IEntity)psDCWorkspaceAction);
            PSDCWorkspace psDCWorkspace = psDCWorkspaceAction.getPSDCWorkspace();
            if (psDCWorkspace != null) {
                if (DataObject.getIntegerValue((Object)psDCWorkspace.getWorkspaceState(), (Integer)30) != 30) {
                    throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u8fdb\u884c\u4f5c\u4e1a", (Object)psDCWorkspace.getPSDCWorkspaceName(), (Object)SVNRepoStateCodeListModel.getInstance().getCodeItem(psDCWorkspace.getWorkspaceState().toString()).getText()));
                }
                if (!StringHelper.isNullOrEmpty((String)psDCWorkspace.getCurAction()) && StringHelper.compare((String)psDCWorkspace.getCurAction(), (String)"NONE", (boolean)true) != 0 && StringHelper.compare((String)psDCWorkspace.getActionOwner(), (String)strOwnerId, (boolean)false) != 0) {
                    throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u4f5c\u4e1a\uff0c\u65e0\u6cd5\u518d\u6b21\u4f5c\u4e1a", (Object)psDCWorkspace.getPSDCWorkspaceName(), (Object)DCWorkspaceLogTypeCodeListModel.getInstance().getCodeItem(psDCWorkspace.getCurAction()).getText()));
                }
                if (psDCWorkspaceAction.getPSDCWorkspace().getPSWorkspace() != null) {
                    strPSWorkspaceId = psDCWorkspaceAction.getPSDCWorkspace().getPSWorkspace().getPSWorkspaceId();
                }
            }
            if (StringHelper.compare((String)psDCWorkspaceAction.getActionType(), (String)"INSTALLSYS", (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)psDCWorkspaceAction.getPSDevSlnSysId())) {
                    throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u8981\u5b89\u88c5\u7684\u7cfb\u7edf"));
                }
                if (StringHelper.compare((String)psDCWorkspaceAction.getActionParam(), (String)"PSUWPROJECT", (boolean)false) == 0) {
                    strPSUWProjectId = psDCWorkspaceAction.getActionParam2();
                    psUWProject = new PSUWProject();
                    psUWProject.setPSUWProjectId(strPSUWProjectId);
                    if (!psUWProjectService.get((IEntity)psUWProject, true)) {
                        log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u65b0\u5efa\u9879\u76ee\u5411\u5bfc[%1$s]", (Object)strPSUWProjectId));
                        throw new Exception(StringHelper.format((String)"\u6307\u5b9a\u65b0\u5efa\u9879\u76ee\u5411\u5bfc\u4e0d\u5b58\u5728"));
                    }
                }
                strPSDevSlnSysId = psDCWorkspaceAction.getPSDevSlnSysId();
                psDevSlnSys = new PSDevSlnSys();
                psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
                psDevSlnSysService.get((IEntity)psDevSlnSys);
                nLastPSDevSlnSysState = DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30);
                if (nLastPSDevSlnSysState != 35) {
                    throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6ca1\u6709\u5904\u4e8e[\u79bb\u7ebf]\u72b6\u6001\uff0c\u65e0\u6cd5\u8fdb\u884c\u5b89\u88c5", (Object)psDevSlnSys.getPSDevSlnSysName()));
                }
                if (!StringHelper.isNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
                    throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u8fdb\u884c\u5b89\u88c5", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
                }
                psDevSlnSys2 = new PSDevSlnSys();
                psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
                psDevSlnSys2.setCurAction("ONLINE");
                psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.MAINTAIN);
                psDevSlnSys2.setActionOwner(strOwnerId);
                EntityBase.setLastUpdateDate((IEntity)psDevSlnSys2, (Timestamp)psDevSlnSys.getUpdateDate());
                psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
                PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
            } else if (StringHelper.compare((String)psDCWorkspaceAction.getActionType(), (String)"UNINSTALLSYS", (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)psDCWorkspace.getPSDevSlnSysId())) {
                    throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u672a\u5b89\u88c5\u7cfb\u7edf", (Object)psDCWorkspace.getPSDCWorkspaceName()));
                }
                strPSDevSlnSysId = psDCWorkspace.getPSDevSlnSysId();
                psDevSlnSys = new PSDevSlnSys();
                psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
                psDevSlnSysService.get((IEntity)psDevSlnSys);
                nLastPSDevSlnSysState = DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30);
                if (nLastPSDevSlnSysState != 30) {
                    throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6ca1\u6709\u5904\u4e8e[\u8fde\u7ebf]\u72b6\u6001\uff0c\u65e0\u6cd5\u8fdb\u884c\u5378\u8f7d", (Object)psDevSlnSys.getPSDevSlnSysName()));
                }
                if (!StringHelper.isNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
                    throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u8fdb\u884c\u5378\u8f7d", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
                }
                psDevSlnSys2 = new PSDevSlnSys();
                psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
                psDevSlnSys2.setCurAction("OFFLINE");
                psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.MAINTAIN);
                psDevSlnSys2.setActionOwner(strOwnerId);
                EntityBase.setLastUpdateDate((IEntity)psDevSlnSys2, (Timestamp)psDevSlnSys.getUpdateDate());
                psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
                PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
            }
            psDCWorkspaceAction2.reset();
            psDCWorkspaceAction2.setPSDCWorkspaceActionId(strPSDCWorkspaceActionId);
            psDCWorkspaceAction2.setBeginTime(DateHelper.getCurTime());
            psDCWorkspaceAction2.setActionState(DBInstBStateCodeListModel.CREATING);
            psDCWorkspaceAction2.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psDCWorkspaceActionService.sysUpdate((IEntity)psDCWorkspaceAction2, true);
            PSWorkspaceHelper.executeDCAction((PSDCWorkspace)psDCWorkspace, (PSDCWorkspaceAction)psDCWorkspaceAction2);
            if (!StringHelper.isNullOrEmpty((String)strPSDevSlnSysId)) {
                psDevSlnSys = new PSDevSlnSys();
                psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
                psDevSlnSysService.get((IEntity)psDevSlnSys);
                if (StringHelper.compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                    psDevSlnSys2 = new PSDevSlnSys();
                    psDevSlnSys2.setPSDevSlnSysId(strPSDevSlnSysId);
                    psDevSlnSys2.setActionOwner(null);
                    psDevSlnSys2.setCurAction("NONE");
                    if (StringHelper.compare((String)psDCWorkspaceAction.getActionType(), (String)"INSTALLSYS", (boolean)true) == 0) {
                        String strSource;
                        if (psUWProject != null && !StringHelper.isNullOrEmpty((String)(strSource = psUWProject.getSource()))) {
                            int nPos = strSource.indexOf("//");
                            if (nPos != -1) {
                                strSource = strSource.substring(nPos + 2);
                            }
                            strSource = strSource.replace(".git", "");
                            String strModelFolder = StringHelper.format((String)"%1$s%2$sREPOS%2$s%3$s", (Object)PSTaskServerEnvImpl.getCurrent().getTempFolder(), (Object)File.separator, (Object)strSource);
                            String strGitPath = psUWProject.getSource();
                            String strGitBranch = "";
                            String strGitUser = "";
                            String strGitPassword = "";
                            if (StringHelper.isNullOrEmpty((String)strGitBranch)) {
                                strGitBranch = "master";
                            }
                            strGitBranch = "*" + strGitBranch;
                            File folder = new File(strModelFolder);
                            folder.mkdirs();
                            String strFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder("MODEL");
                            folder = new File(String.valueOf(strFolder) + "MODEL2");
                            if (!folder.exists()) {
                                folder.mkdirs();
                            }
                            String strCmd = "";
                            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s USR %7$s %8$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)(String.valueOf(strFolder) + "MODEL2"), (Object)strModelFolder, (Object)strGitPath, (Object)strGitBranch, (Object)strGitUser, (Object)strGitPassword) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s USR %7$s %8$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)(String.valueOf(strFolder) + "MODEL2"), (Object)strModelFolder, (Object)strGitPath, (Object)strGitBranch, (Object)strGitUser, (Object)strGitPassword);
                            CmdHelper.Result result = CmdHelper.getInstance().executeBat(strCmd);
                            PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
                            psModelV2Helper.init(psDevSlnSys.getPSSystemId(), psDevSlnSys.getPSSysModelInstId(), psDevSlnSys.getCodeName(), psDevSlnSys.getPSDevSlnSysId());
                            int nModelCount = psModelV2Helper.compile(String.valueOf(strFolder) + "MODEL2", strModelFolder, false);
                            PSSysModelInstGlobal.active((String)psDevSlnSys.getPSSysModelInstId());
                            PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
                            psSystemService.executeResetSysModel(psDevSlnSys.getPSSysModelInstId());
                            psModelV2Helper.import2(String.valueOf(strFolder) + "MODEL2" + File.separator + "DATAS");
                            PSDevSlnSys psDevSlnSys3 = new PSDevSlnSys();
                            psDevSlnSys3.setPSDevSlnSysId(strPSDevSlnSysId);
                            psDevSlnSysService.rebindSystem(psDevSlnSys3);
                            PSSystem psSystem = new PSSystem();
                            psSystem.setPSSystemId(psDevSlnSys.getPSSystemId());
                            psSystemService.initModel((IEntity)psSystem);
                        }
                        psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.ONLINE);
                    } else if (StringHelper.compare((String)psDCWorkspaceAction.getActionType(), (String)"UNINSTALLSYS", (boolean)true) == 0) {
                        psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.OFFLINE);
                    }
                    psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
                    PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)strPSWorkspaceId)) {
                PSWorkspace psWorkspace = new PSWorkspace();
                psWorkspace.setPSWorkspaceId(strPSWorkspaceId);
                psWorkspaceService.get((IEntity)psWorkspace);
                if (StringHelper.compare((String)psWorkspace.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                    psWorkspace.reset();
                    psWorkspace.setPSWorkspaceId(strPSWorkspaceId);
                    psWorkspace.setCurAction(null);
                    psWorkspace.setActionOwner(null);
                    psWorkspaceService.sysUpdate((IEntity)psWorkspace, false);
                }
            }
            psDCWorkspaceAction2.reset();
            psDCWorkspaceAction2.setPSDCWorkspaceActionId(strPSDCWorkspaceActionId);
            psDCWorkspaceAction2.setEndTime(DateHelper.getCurTime());
            psDCWorkspaceAction2.setActionState(DBInstBStateCodeListModel.CREATED);
            psDCWorkspaceActionService.sysUpdate((IEntity)psDCWorkspaceAction2, false);
            if (StringHelper.compare((String)psDCWorkspaceAction.getActionType(), (String)"INSTALLSYS", (boolean)true) == 0 && !StringHelper.isNullOrEmpty((String)psDCWorkspaceAction.getPSDCWorkspaceId())) {
                try {
                    IPSDCWorkspace iPSDCWorkspace = this.getPSModelStorage().getPSDCWorkspace(psDCWorkspaceAction.getPSDCWorkspaceId());
                    iPSDCWorkspace.logAction("DCBKTASK", "WORKSPACEACTION", psDCWorkspaceAction.getPSDCWorkspaceActionId(), 1);
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.format((String)"\u767b\u8bb0\u751f\u4ea7\u7ebf\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                }
            }
            return "\u4f5c\u4e1a\u6210\u529f";
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u751f\u4ea7\u7ebf\u4f5c\u4e1a[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getTaskParam(), (Object)ex.getMessage()), (Throwable)ex);
            try {
                if (!StringHelper.isNullOrEmpty(strPSDevSlnSysId)) {
                    PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
                    psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
                    psDevSlnSysService.get((IEntity)psDevSlnSys);
                    if (StringHelper.compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                        PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
                        psDevSlnSys2.setPSDevSlnSysId(strPSDevSlnSysId);
                        psDevSlnSys2.setActionOwner(null);
                        psDevSlnSys2.setCurAction("NONE");
                        if (nLastPSDevSlnSysState != -1) {
                            psDevSlnSys2.setDevSysState(Integer.valueOf(nLastPSDevSlnSysState));
                        } else if (StringHelper.compare((String)psDCWorkspaceAction.getActionType(), (String)"INSTALLSYS", (boolean)true) == 0) {
                            psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.OFFLINE);
                        } else if (StringHelper.compare((String)psDCWorkspaceAction.getActionType(), (String)"UNINSTALLSYS", (boolean)true) == 0) {
                            psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.ONLINE);
                        }
                        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
                        PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
                    }
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            try {
                if (!StringHelper.isNullOrEmpty((String)strPSDCWorkspaceId)) {
                    PSDCWorkspace psDCWorkspace2 = new PSDCWorkspace();
                    psDCWorkspace2.setPSDCWorkspaceId(strPSDCWorkspaceId);
                    psDCWorkspaceService.get((IEntity)psDCWorkspace2);
                    if (StringHelper.compare((String)psDCWorkspace2.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                        psDCWorkspace2.reset();
                        boolean bUpdate = false;
                        psDCWorkspace2.setPSDCWorkspaceId(strPSDCWorkspaceId);
                        if (StringHelper.compare((String)psDCWorkspaceAction.getActionType(), (String)"INSTALLSYS", (boolean)true) == 0) {
                            psDCWorkspace2.setPSDevSlnSysId(null);
                            psDCWorkspace2.setPSDevSlnSysName(null);
                            bUpdate = true;
                        }
                        if (bUpdate) {
                            psDCWorkspaceService.sysUpdate((IEntity)psDCWorkspace2, false);
                        }
                    }
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            try {
                if (!StringHelper.isNullOrEmpty(strPSWorkspaceId)) {
                    PSWorkspace psWorkspace = new PSWorkspace();
                    psWorkspace.setPSWorkspaceId(strPSWorkspaceId);
                    psWorkspaceService.get((IEntity)psWorkspace);
                    if (StringHelper.compare((String)psWorkspace.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                        psWorkspace.reset();
                        psWorkspace.setPSWorkspaceId(strPSWorkspaceId);
                        psWorkspace.setCurAction(null);
                        psWorkspace.setActionOwner(null);
                        psWorkspaceService.sysUpdate((IEntity)psWorkspace, false);
                    }
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            try {
                psDCWorkspaceAction2.reset();
                psDCWorkspaceAction2.setPSDCWorkspaceActionId(strPSDCWorkspaceActionId);
                psDCWorkspaceAction2.setEndTime(DateHelper.getCurTime());
                psDCWorkspaceAction2.setActionState(DBInstBStateCodeListModel.FAILED);
                psDCWorkspaceActionService.sysUpdate((IEntity)psDCWorkspaceAction2, false);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }
}

