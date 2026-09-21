/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.PSTaskServerEnvImpl
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.BackupDevSlnSysPSDCBKTaskImpl;
import SA.SRFDA.PS.Core.DevCenter.DevSlnSysPSDCBKTaskImplBase;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class RestoreDevSlnSysPSDCBKTaskImpl
extends DevSlnSysPSDCBKTaskImplBase {
    private static final Log log = LogFactory.getLog(BackupDevSlnSysPSDCBKTaskImpl.class);

    protected String onRun() throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        this.setStudioConsoleId(this.getTaskParam());
        PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
        psDevSlnSysBak.setPSDevSlnSysBakId(this.getTaskParam2());
        psDevSlnSysBakService.get((IEntity)psDevSlnSysBak);
        PSDevSlnSysBak realDevSlnSysBak = psDevSlnSysBak;
        if (DataObject.getBoolValue((Integer)psDevSlnSysBak.getLinkFlag(), (boolean)false)) {
            PSDevSlnSysBakLinkService psDevSlnSysBakLinkService = (PSDevSlnSysBakLinkService)ServiceGlobal.getService(PSDevSlnSysBakLinkService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysBakLink psDevSlnSysBakLink = new PSDevSlnSysBakLink();
            psDevSlnSysBakLink.setPSDevSlnSysBakLinkId(psDevSlnSysBak.getPSDevSlnSysBakId());
            if (!psDevSlnSysBakLinkService.get((IEntity)psDevSlnSysBakLink, true)) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd[%1$s]\u65e0\u6cd5\u83b7\u53d6\u5907\u4efd\u94fe\u63a5", (Object)psDevSlnSysBak.getPSDevSlnSysBakName()));
            }
            if (DataObject.getIntegerValue((Object)psDevSlnSysBakLink.getLinkState(), (Integer)30) != 30) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd[%1$s]\u5f15\u7528\u7684\u5907\u4efd\u94fe\u63a5\u65e0\u6548", (Object)psDevSlnSysBak.getPSDevSlnSysBakName()));
            }
            if (psDevSlnSysBakLink.getBeginTime() != null && System.currentTimeMillis() < psDevSlnSysBakLink.getBeginTime().getTime()) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd[%1$s]\u5f15\u7528\u7684\u5907\u4efd\u94fe\u63a5\u65e0\u6548\uff0c\u4e0d\u5728\u6388\u6743\u5f00\u59cb\u65f6\u95f4\u8303\u56f4\u5185", (Object)psDevSlnSysBak.getPSDevSlnSysBakName()));
            }
            if (psDevSlnSysBakLink.getEndTime() != null && System.currentTimeMillis() > psDevSlnSysBakLink.getEndTime().getTime()) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd[%1$s]\u5f15\u7528\u7684\u5907\u4efd\u94fe\u63a5\u65e0\u6548\uff0c\u4e0d\u5728\u6388\u6743\u7ed3\u675f\u65f6\u95f4\u8303\u56f4\u5185", (Object)psDevSlnSysBak.getPSDevSlnSysBakName()));
            }
            realDevSlnSysBak = psDevSlnSysBakLink.getPSDevSlnSysBak();
        }
        PSSysModelInst psSysModelInst = psDevSlnSys.getPSSysModelInst();
        PSDBServer psDBServer = psSysModelInst.getPSDBServer();
        String strOwnerId = StringHelper.Format((String)"%1$s|%2$s", (Object)psDevSlnSysBakService.getDEModel().getName(), (Object)this.getTaskParam2());
        try {
            String strTempFolder;
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) != 0) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u6240\u6709\u8005\u4e0d\u4e3a\u5f53\u524d\u4efb\u52a1\uff0c\u65e0\u6cd5\u6062\u590d\u6a21\u578b", (Object)psDevSlnSys.getPSDevSlnSysName()));
            }
            PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
            psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.MAINTAIN);
            psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
            PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
            this.sendStateChangedConsole(psDevSlnSys, DevSysStateCodeListModel.MAINTAIN);
            if (StringHelper.Compare((String)realDevSlnSysBak.getBackupMode(), (String)"V2", (boolean)false) == 0) {
                strTempFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
                String strBackupFolder = StringHelper.Format((String)"%1$sMODEL2", (Object)strTempFolder);
                String strBackupZipFile = StringHelper.Format((String)"%1$sMODEL2.7z", (Object)strTempFolder);
                String strNasFile = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)realDevSlnSysBak.getBackupFilePath());
                if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
                    String strCmd = StringHelper.Format((String)"cp -rf %1$s %2$s", (Object)strNasFile, (Object)strBackupZipFile);
                    this.runBat(strCmd, true);
                    File file = new File(strBackupZipFile);
                    if (!file.exists() || file.length() == 0L) {
                        throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u5907\u4efd\u6587\u4ef6");
                    }
                    strCmd = StringHelper.Format((String)"7za x -y -o%3$s %4$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupFolder, (Object)strBackupZipFile);
                    this.runBat(strCmd, true);
                    file = new File(strBackupFolder);
                    if (!file.exists() || file.length() == 0L) {
                        throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u89e3\u538b\u5907\u4efd\u6587\u4ef6");
                    }
                    this.updatePSSysModelInstVer(psDevSlnSys);
                    SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId());
                    PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
                    psSystemService.executeResetSysModel(psDevSlnSys.getPSSysModelInstId());
                    PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
                    psModelV2Helper.init(null, psDevSlnSys.getPSSysModelInstId());
                    psModelV2Helper.restore(strBackupFolder);
                } else {
                    String strCmd = StringHelper.Format((String)"cmd.exe /c copy \"%1$s\" \"%2$s\" /Y", (Object)strNasFile, (Object)strBackupZipFile);
                    this.runBat(strCmd, true);
                    File file = new File(strBackupZipFile);
                    if (!file.exists() || file.length() == 0L) {
                        throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u5907\u4efd\u6587\u4ef6");
                    }
                    strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$s7-Zip%2$s7z.exe x -y -o\"%3$s\" \"%4$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupFolder, (Object)strBackupZipFile);
                    this.runBat(strCmd, true);
                    file = new File(strBackupFolder);
                    if (!file.exists() || file.length() == 0L) {
                        throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u89e3\u538b\u5907\u4efd\u6587\u4ef6");
                    }
                    this.updatePSSysModelInstVer(psDevSlnSys);
                    SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId());
                    PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
                    psSystemService.executeResetSysModel(psDevSlnSys.getPSSysModelInstId());
                    PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
                    psModelV2Helper.init(null, psDevSlnSys.getPSSysModelInstId());
                    psModelV2Helper.restore(strBackupFolder);
                }
            } else {
                strTempFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
                String strBackupFile = StringHelper.Format((String)"%1$sdb.sql", (Object)strTempFolder);
                String strBackupZipFile = StringHelper.Format((String)"%1$s.7z", (Object)strBackupFile);
                String strNasFile = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)realDevSlnSysBak.getBackupFilePath());
                if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
                    throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5b9e\u73b0"));
                }
                String strCmd = StringHelper.Format((String)"cmd.exe /c copy \"%1$s\" \"%2$s\" /Y", (Object)strNasFile, (Object)strBackupZipFile);
                this.runBat(strCmd, true);
                File file = new File(strBackupZipFile);
                if (!file.exists() || file.length() == 0L) {
                    throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u5907\u4efd\u6587\u4ef6");
                }
                strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$s7-Zip%2$s7z.exe x -y -o\"%3$s\" \"%4$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strTempFolder, (Object)strBackupZipFile);
                this.runBat(strCmd, true);
                file = new File(strBackupFile);
                if (!file.exists() || file.length() == 0L) {
                    throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u89e3\u538b\u5907\u4efd\u6587\u4ef6");
                }
                strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$smysql.exe -h %7$s %3$s -u %4$s -p%5$s --default-character-set=utf8  < \"%8$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)psSysModelInst.getDBName(), (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName(), (Object)psDBServer.getIPAddr(), (Object)strBackupFile);
                String strRet = this.runBat(strCmd, true);
                log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u547d\u4ee4:%1$s\r\n\u8fd4\u56de%2$s", (Object)strCmd, (Object)strRet));
                if (strRet.indexOf("ERROR ") != -1) {
                    throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
                }
                this.updatePSSysModelInstVer(psDevSlnSys, realDevSlnSysBak.getModelVer());
            }
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get((IEntity)psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                psDevSlnSys2 = new PSDevSlnSys();
                psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSys2.setActionOwner(null);
                psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.ONLINE);
                psDevSlnSys2.setCurAction("NONE");
                psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, false);
                this.sendStateChangedConsole(psDevSlnSys, DevSysStateCodeListModel.ONLINE);
            }
            psDevSlnSysService.rebindSystem(psDevSlnSys);
            PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys);
            this.sendStudioConsole(null, "INFO", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6062\u590d\u6a21\u578b\u4ed3\u5e93\u6210\u529f", (Object)psDevSlnSys.getPSDevSlnSysName()));
            return "\u6062\u590d\u6210\u529f";
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6062\u590d\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getTaskParam(), (Object)ex.getMessage()), (Throwable)ex);
            this.sendStudioConsole(null, "ERROR", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6062\u590d\u6a21\u578b\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)ex.getMessage()));
            try {
                psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSysService.get((IEntity)psDevSlnSys);
                if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                    PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
                    psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                    psDevSlnSys2.setActionOwner(null);
                    psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.ONLINE);
                    psDevSlnSys2.setCurAction("NONE");
                    psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
                    PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
                    this.sendStateChangedConsole(psDevSlnSys, DevSysStateCodeListModel.ONLINE);
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }
}

