/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.PSTaskServerEnvImpl
 *  SA.SRFDA.PS.Core.Util.CmdHelper
 *  SA.SRFDA.PS.Core.Util.CmdHelper$Result
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCSysInstAction
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
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
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysInstAction;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class ExportDevSysModelPSDCBKTaskImpl
extends DevSlnSysPSDCBKTaskImplBase {
    private static final Log log = LogFactory.getLog(ExportDevSysModelPSDCBKTaskImpl.class);

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
            String strResult;
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get((IEntity)psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) != 0) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u6240\u6709\u8005\u4e0d\u4e3a\u5f53\u524d\u4efb\u52a1\uff0c\u65e0\u6cd5\u5bfc\u51fa\u6a21\u578b", (Object)psDevSlnSys.getPSDevSlnSysName()));
            }
            PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
            psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.MAINTAIN);
            psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
            PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
            this.sendStateChangedConsole(psDevSlnSys, DevSysStateCodeListModel.MAINTAIN);
            psDCSysInstAction.setPSDCSysInstActionId(this.getTaskParam2());
            psDCSysInstActionService.get((IEntity)psDCSysInstAction);
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
            psDevCenterService.get((IEntity)psDevCenter);
            psDCSysInstAction2.setPSDCSysInstActionId(this.getTaskParam2());
            psDCSysInstAction2.setBeginTime(DateHelper.getCurTime());
            psDCSysInstAction2.setActionState(BackendActionStateCodeListModel.CREATING);
            psDCSysInstActionService.sysUpdate((IEntity)psDCSysInstAction2, false);
            this.updatePSSysModelInstVer(psDevSlnSys);
            PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
            psModelV2Helper.init(psDevSlnSys.getPSSystemId(), psDevSlnSys.getPSSysModelInstId(), null, psDevSlnSys.getPSDevSlnSysId());
            String strFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder("MODEL");
            File folder = new File(String.valueOf(strFolder) + "MODEL");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            if (!(folder = new File(String.valueOf(strFolder) + "MODEL2")).exists()) {
                folder.mkdirs();
            }
            if (!(folder = new File(String.valueOf(strFolder) + "RES")).exists()) {
                folder.mkdirs();
            }
            psModelV2Helper.export(String.valueOf(strFolder) + "MODEL", String.valueOf(strFolder) + "RES");
            String strModelFolder = PSTaskServerEnvImpl.getCurrent().getCodeFolder();
            strModelFolder = String.valueOf(strModelFolder) + File.separator + psDevCenter.getDomainName();
            strModelFolder = String.valueOf(strModelFolder) + File.separator + psDevSlnSys.getPSDevSlnSysId();
            strModelFolder = String.valueOf(strModelFolder) + File.separator + "@MODEL";
            folder = new File(strModelFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s PUB %7$s %8$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)(String.valueOf(strFolder) + "MODEL"), (Object)strModelFolder, (Object)strGitPath, (Object)strGitBranch, (Object)strGitUser, (Object)strGitPassword) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s PUB %7$s %8$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)(String.valueOf(strFolder) + "MODEL"), (Object)strModelFolder, (Object)strGitPath, (Object)strGitBranch, (Object)strGitUser, (Object)strGitPassword);
            CmdHelper.Result result = CmdHelper.getInstance().executeBat(strCmd);
            if (PSCoreSysServiceBase.isCloudMode() && result != null && !StringHelper.IsNullOrEmpty((String)(strResult = result.getInfo()))) {
                if ((strResult = strResult.trim()).indexOf("SUCCESS\r\n") == 0) {
                    strResult = strResult.substring(9);
                } else if (strResult.indexOf("FAILURE\r\n") == 0) {
                    strResult = strResult.substring(9);
                    throw new Exception(String.format("\u7b7e\u5165\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", strResult));
                }
            }
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get((IEntity)psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                PSDevSlnSys psDevSlnSys22 = new PSDevSlnSys();
                psDevSlnSys22.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSys22.setActionOwner(null);
                psDevSlnSys22.setCurAction("NONE");
                psDevSlnSys22.setDevSysState(DevSysStateCodeListModel.ONLINE);
                psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys22, true);
                PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys22);
                this.sendStateChangedConsole(psDevSlnSys, DevSysStateCodeListModel.ONLINE);
            }
            psDCSysInstAction.reset();
            psDCSysInstAction2.setPSDCSysInstActionId(this.getTaskParam2());
            psDCSysInstAction2.setEndTime(DateHelper.getCurTime());
            psDCSysInstAction2.setActionState(BackendActionStateCodeListModel.CREATED);
            psDCSysInstActionService.sysUpdate((IEntity)psDCSysInstAction2, false);
            this.sendStudioConsole(null, "INFO", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5bfc\u51fa\u6a21\u578b\u4ed3\u5e93\u6210\u529f", (Object)psDevSlnSys.getPSDevSlnSysName()));
            return "\u5bfc\u51fa\u6210\u529f";
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getTaskParam(), (Object)ex.getMessage()), (Throwable)ex);
            this.sendStudioConsole(null, "ERROR", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5bfc\u51fa\u6a21\u578b\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)ex.getMessage()));
            try {
                psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSysService.get((IEntity)psDevSlnSys);
                if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                    PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
                    psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                    psDevSlnSys2.setActionOwner(null);
                    psDevSlnSys2.setCurAction("NONE");
                    psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.ONLINE);
                    psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
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
                psDCSysInstActionService.sysUpdate((IEntity)psDCSysInstAction2, false);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }
}

