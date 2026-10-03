/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.PSTaskServerEnvImpl
 *  SA.SRFDA.PS.Core.Util.CmdHelper
 *  SA.SRFDA.PS.Core.Util.CmdHelper$Result
 *  SA.SRFDA.PS.Core.Workspace.IPSWorkspace
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCSysInstAction
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService
 *  net.ibizsys.pscore.srv.util.IPSWorkspace
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.DevSlnSysPSDCBKTaskImplBase;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Util.CmdHelper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.Date;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysInstAction;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.util.IPSWorkspace;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class ImportDevSysModelPSDCBKTaskImpl
extends DevSlnSysPSDCBKTaskImplBase {
    private static final Log log = LogFactory.getLog(ImportDevSysModelPSDCBKTaskImpl.class);

    protected String onRun() throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDCSysInstActionService psDCSysInstActionService = (PSDCSysInstActionService)ServiceGlobal.getService(PSDCSysInstActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCSysInstAction psDCSysInstAction = new PSDCSysInstAction();
        PSDCSysInstAction psDCSysInstAction2 = new PSDCSysInstAction();
        String strOwnerId = StringHelper.Format((String)"%1$s|%2$s", (Object)psDCSysInstActionService.getDEModel().getName(), (Object)this.getTaskParam2());
        this.setStudioConsoleId(this.getTaskParam());
        psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
        try {
            PSSystem psSystem;
            PSDevSlnSys psDevSlnSys2;
            String strResult;
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get(psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) != 0) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u6240\u6709\u8005\u4e0d\u4e3a\u5f53\u524d\u4efb\u52a1\uff0c\u65e0\u6cd5\u5bfc\u5165\u6a21\u578b", (Object)psDevSlnSys.getPSDevSlnSysName()));
            }
            PSDevSlnSys psDevSlnSys22 = new PSDevSlnSys();
            psDevSlnSys22.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSys22.setDevSysState(DevSysStateCodeListModel.MAINTAIN);
            psDevSlnSysService.sysUpdate(psDevSlnSys22, true);
            PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys22);
            this.sendStateChangedConsole(psDevSlnSys, DevSysStateCodeListModel.MAINTAIN);
            SA.SRFDA.PS.Core.Workspace.IPSWorkspace iPSWorkspace = this.getPSWorkspace(psDevSlnSys);
            psDCSysInstAction.setPSDCSysInstActionId(this.getTaskParam2());
            psDCSysInstActionService.get(psDCSysInstAction);
            String strGitPath = "";
            String strGitBranch = "";
            String strGitUser = "";
            String strGitPassword = "";
            if (psDevSlnSys.getModelPSDevCenterSVN() != null) {
                strGitPath = psDevSlnSys.getModelPSDevCenterSVN().getGitPath();
                strGitBranch = psDevSlnSys.getModelPSDevCenterSVN().getGitBranch();
                if (psDevSlnSys.getModelPSDevCenterSVN().getPSSVNInstRepo() != null) {
                    PSSVNServer psSVNServer;
                    if (StringHelper.IsNullOrEmpty((String)strGitPath)) {
                        strGitPath = psDevSlnSys.getModelPSDevCenterSVN().getPSSVNInstRepo().getGitPath();
                    }
                    if (StringHelper.IsNullOrEmpty((String)strGitBranch)) {
                        strGitBranch = psDevSlnSys.getModelPSDevCenterSVN().getPSSVNInstRepo().getGitBranch();
                    }
                    if ((psSVNServer = psDevSlnSys.getModelPSDevCenterSVN().getPSSVNInstRepo().getPSSVNServer()) != null) {
                        strGitUser = psSVNServer.getGITUserName();
                        strGitPassword = psSVNServer.getGITPassword();
                    }
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strGitPath)) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6a21\u578b\u4ed3\u5e93\u5730\u5740"));
            }
            if (StringHelper.IsNullOrEmpty((String)strGitBranch)) {
                strGitBranch = "master";
            }
            strGitBranch = "*" + strGitBranch;
            PSDevCenterService psDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevCenter psDevCenter = new PSDevCenter();
            psDevCenter.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
            psDevCenterService.get(psDevCenter);
            psDCSysInstAction2.setPSDCSysInstActionId(this.getTaskParam2());
            psDCSysInstAction2.setBeginTime(DateHelper.getCurTime());
            psDCSysInstAction2.setActionState(BackendActionStateCodeListModel.CREATING);
            psDCSysInstActionService.sysUpdate(psDCSysInstAction2, false);
            this.updatePSSysModelInstVer(psDevSlnSys);
            String strFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder("MODEL");
            File folder = new File(String.valueOf(strFolder) + "MODEL2");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            String strModelFolder = PSTaskServerEnvImpl.getCurrent().getCodeFolder();
            strModelFolder = String.valueOf(strModelFolder) + File.separator + psDevCenter.getDomainName();
            strModelFolder = String.valueOf(strModelFolder) + File.separator + psDevSlnSys.getPSDevSlnSysId();
            folder = new File(strModelFolder = String.valueOf(strModelFolder) + File.separator + "@MODEL");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s USR %7$s %8$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)(String.valueOf(strFolder) + "MODEL2"), (Object)strModelFolder, (Object)strGitPath, (Object)strGitBranch, (Object)strGitUser, (Object)strGitPassword) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s USR %7$s %8$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)(String.valueOf(strFolder) + "MODEL2"), (Object)strModelFolder, (Object)strGitPath, (Object)strGitBranch, (Object)strGitUser, (Object)strGitPassword);
            CmdHelper.Result result = CmdHelper.getInstance().executeBat(strCmd);
            if (PSCoreSysServiceBase.isCloudMode() && result != null && !StringHelper.IsNullOrEmpty((String)(strResult = result.getInfo()))) {
                if ((strResult = strResult.trim()).indexOf("SUCCESS\r\n") == 0) {
                    strResult = strResult.substring(9);
                } else if (strResult.indexOf("FAILURE\r\n") == 0) {
                    strResult = strResult.substring(9);
                    throw new Exception(String.format("\u7b7e\u51fa\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", strResult));
                }
            }
            PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
            psModelV2Helper.init(psDevSlnSys.getPSSystemId(), psDevSlnSys.getPSSysModelInstId(), psDevSlnSys.getCodeName(), psDevSlnSys.getPSDevSlnSysId());
            if (iPSWorkspace != null) {
                psModelV2Helper.setPSWorkspace((IPSWorkspace)iPSWorkspace);
            }
            int nModelCount = psModelV2Helper.compile(String.valueOf(strFolder) + "MODEL2", strModelFolder, false);
            if (this.getPSTaskServerEnv().isBackupBeforeImportModel()) {
                String strPSDevSlnSysBakId = String.format("BK_%1$s_%2$s", psDCSysInstAction.getPSDCSysInstActionId(), String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date()));
                String strNasFile = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$sMODEL2.7z", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)strPSDevSlnSysBakId);
                String strNasFile2 = StringHelper.Format((String)"%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$sMODEL2.7z", (Object)"", (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)strPSDevSlnSysBakId);
                File nasFile = new File(strNasFile);
                nasFile.getParentFile().mkdirs();
                PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
                psDevSlnSysBak.setPSDevSlnSysBakId(strPSDevSlnSysBakId);
                psDevSlnSysBak.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
                psDevSlnSysBak.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
                psDevSlnSysBak.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
                psDevSlnSysBak.setPSDevCenterName(psDevSlnSys.getPSDevCenterName());
                psDevSlnSysBak.setPSSysModelInstId(psDevSlnSys.getPSSysModelInstId());
                psDevSlnSysBak.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
                psDevSlnSysBak.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
                psDevSlnSysBak.setBackupTime(DateHelper.getCurTime());
                psDevSlnSysBak.setModelVer(psDevSlnSys.getModelInstVer());
                psDevSlnSysBak.setBackupMode(PSTaskServerEnvImpl.getCurrent().getModelBKMode());
                psDevSlnSysBak.setPSDevSlnSysBakName(StringHelper.Format((String)"%1$s[%2$s]\u5907\u4efd", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DateHelper.toDateTimeString((Date)psDevSlnSysBak.getBackupTime())));
                psDevSlnSysBak.setMemo(String.format("%1$s--\u5907\u4efd", psDCSysInstAction.getPSDCSysInstActionName()));
                File file = this.backupPSDevSlnSysModel(psDevSlnSys, strNasFile, strNasFile2);
                psDevSlnSysBak.setEndBackupTime(DateHelper.getCurTime());
                psDevSlnSysBak.setBackupState(DBInstBStateCodeListModel.CREATED);
                psDevSlnSysBak.setBackupFilePath(strNasFile2);
                psDevSlnSysBak.setBackupSize(Integer.valueOf((int)file.length()));
                psDevSlnSysBakService.create(psDevSlnSysBak);
            }
            PSSysModelInstGlobal.active((String)psDevSlnSys.getPSSysModelInstId());
            PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
            psSystemService.executeResetSysModel(psDevSlnSys.getPSSysModelInstId());
            psModelV2Helper.import2(String.valueOf(strFolder) + "MODEL2" + File.separator + "DATAS");
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get(psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                psDevSlnSys2 = new PSDevSlnSys();
                psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSys2.setActionOwner(null);
                psDevSlnSys2.setCurAction("NONE");
                psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.ONLINE);
                psDevSlnSysService.sysUpdate(psDevSlnSys2, false);
                psDevSlnSysService.rebindSystem(psDevSlnSys2);
                psSystem = new PSSystem();
                psSystem.setPSSystemId(psDevSlnSys.getPSSystemId());
                psSystemService.initModel(psSystem);
                PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
                this.sendStateChangedConsole(psDevSlnSys, DevSysStateCodeListModel.ONLINE);
            } else {
                psDevSlnSys2 = new PSDevSlnSys();
                psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSysService.sysUpdate(psDevSlnSys2, false);
                psDevSlnSysService.rebindSystem(psDevSlnSys2);
                psSystem = new PSSystem();
                psSystem.setPSSystemId(psDevSlnSys.getPSSystemId());
                psSystemService.initModel(psSystem);
                PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
            }
            psDCSysInstAction.reset();
            psDCSysInstAction2.setPSDCSysInstActionId(this.getTaskParam2());
            psDCSysInstAction2.setEndTime(DateHelper.getCurTime());
            psDCSysInstAction2.setActionState(BackendActionStateCodeListModel.CREATED);
            psDCSysInstActionService.sysUpdate(psDCSysInstAction2, false);
            this.sendStudioConsole(null, "INFO", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5bfc\u5165\u6a21\u578b\u4ed3\u5e93\u6210\u529f", (Object)psDevSlnSys.getPSDevSlnSysName()));
            return "\u5bfc\u5165\u6210\u529f";
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5bfc\u5165\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getTaskParam(), (Object)ex.getMessage()), (Throwable)ex);
            this.sendStudioConsole(null, "ERROR", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5bfc\u5165\u6a21\u578b\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)ex.getMessage()));
            try {
                psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSysService.get(psDevSlnSys);
                if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                    PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
                    psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                    psDevSlnSys2.setActionOwner(null);
                    psDevSlnSys2.setCurAction("NONE");
                    psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.ONLINE);
                    psDevSlnSysService.sysUpdate(psDevSlnSys2, true);
                    PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
                    this.sendStateChangedConsole(psDevSlnSys, DevSysStateCodeListModel.ONLINE);
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            try {
                psDCSysInstAction.reset();
                psDCSysInstAction2.setPSDCSysInstActionId(this.getTaskParam2());
                psDCSysInstAction2.setEndTime(DateHelper.getCurTime());
                psDCSysInstAction2.setActionState(BackendActionStateCodeListModel.FAILED);
                psDCSysInstActionService.sysUpdate(psDCSysInstAction2, false);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }
}

