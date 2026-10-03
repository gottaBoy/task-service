/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.PSTaskServerEnvImpl
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.DevSlnSysPSDCBKTaskImplBase;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class BackupDevSlnSysPSDCBKTaskImpl
extends DevSlnSysPSDCBKTaskImplBase {
    private static final Log log = LogFactory.getLog(BackupDevSlnSysPSDCBKTaskImpl.class);

    protected String onRun() throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
        psDevSlnSysService.get(psDevSlnSys);
        PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
        psDevSlnSysBak.setPSDevSlnSysBakId(this.getTaskParam2());
        psDevSlnSysBakService.get(psDevSlnSysBak);
        PSDevSlnSysBak psDevSlnSysBak2 = new PSDevSlnSysBak();
        psDevSlnSysBak2.setPSDevSlnSysBakId(this.getTaskParam2());
        psDevSlnSysBak2.setBeginBackupTime(DateHelper.getCurTime());
        psDevSlnSysBak2.setBackupState(DBInstBStateCodeListModel.CREATING);
        psDevSlnSysBakService.sysUpdate(psDevSlnSysBak2, false);
        PSSysModelInst psSysModelInst = psDevSlnSys.getPSSysModelInst();
        PSDBServer psDBServer = psSysModelInst.getPSDBServer();
        String strOwnerId = StringHelper.Format((String)"%1$s|%2$s", (Object)psDevSlnSysBakService.getDEModel().getName(), (Object)this.getTaskParam2());
        this.setStudioConsoleId(this.getTaskParam());
        try {
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) != 0) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u6240\u6709\u8005\u4e0d\u4e3a\u5f53\u524d\u4efb\u52a1\uff0c\u65e0\u6cd5\u5907\u4efd\u6a21\u578b", (Object)psDevSlnSys.getPSDevSlnSysName()));
            }
            PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
            psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.MAINTAIN);
            psDevSlnSysService.sysUpdate(psDevSlnSys2, true);
            PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
            this.sendStateChangedConsole(psDevSlnSys, DevSysStateCodeListModel.MAINTAIN);
            String strNasFile = "";
            String strNasFile2 = "";
            String strNasFolder = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$s", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
            File nasfile = new File(strNasFolder);
            nasfile.mkdirs();
            if (StringHelper.Compare((String)psDevSlnSysBak.getBackupMode(), (String)"V2", (boolean)false) == 0) {
                this.updatePSSysModelInstVer(psDevSlnSys);
                String strBackupFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
                String strFolder = StringHelper.Format((String)"%1$sMODEL2", (Object)strBackupFolder);
                String strBackupZipFile = StringHelper.Format((String)"%1$sMODEL2.7z", (Object)strBackupFolder);
                strNasFile = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$sMODEL2.7z", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
                strNasFile2 = StringHelper.Format((String)"%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$sMODEL2.7z", (Object)"", (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
                PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
                psModelV2Helper.init(null, psDevSlnSys.getPSSysModelInstId());
                File folder = new File(strFolder);
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                psModelV2Helper.backup(strFolder);
                if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
                    String strCmd = StringHelper.Format((String)"7za a %3$s %4$s%2$s*", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupZipFile, (Object)strFolder);
                    this.runBat(strCmd, true);
                    File file = new File(strBackupZipFile);
                    if (!file.exists() || file.length() == 0L) {
                        throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u751f\u6210\u538b\u7f29\u6587\u4ef6");
                    }
                    strCmd = StringHelper.Format((String)"cp -rf %1$s %2$s", (Object)strBackupZipFile, (Object)strNasFile);
                    this.runBat(strCmd, true);
                } else {
                    String strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$s7-Zip%2$s7z.exe a \"%3$s\" \"%4$s%2$s*\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupZipFile, (Object)strFolder);
                    this.runBat(strCmd, true);
                    File file = new File(strBackupZipFile);
                    if (!file.exists() || file.length() == 0L) {
                        throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u751f\u6210\u538b\u7f29\u6587\u4ef6");
                    }
                    strCmd = StringHelper.Format((String)"cmd.exe /c copy \"%1$s\" \"%2$s\" /Y", (Object)strBackupZipFile, (Object)strNasFile);
                    this.runBat(strCmd, true);
                }
            } else {
                String strBackupFile = StringHelper.Format((String)"%1$sdb.sql", (Object)PSTaskServerEnvImpl.getCurrent().createTempFolder());
                String strBackupZipFile = StringHelper.Format((String)"%1$s.7z", (Object)strBackupFile);
                strNasFile = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$sdb.sql.7z", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
                strNasFile2 = StringHelper.Format((String)"%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$sdb.sql.7z", (Object)"", (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
                if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
                    throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5b9e\u73b0"));
                }
                String strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$smysqldump.exe -h %7$s  %3$s  -u %4$s -p%5$s --add-drop-table --set-gtid-purged=OFF --default-character-set=utf8|%1$s%2$ssed%2$ssed.exe -e \"s/DEFINER[ ]*=[ ]*[^*]*\\*/\\*/\" > \"%8$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)psSysModelInst.getDBName(), (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName(), (Object)psDBServer.getIPAddr(), (Object)strBackupFile);
                this.runBat(strCmd, true);
                File file = new File(strBackupFile);
                if (!file.exists() || file.length() == 0L) {
                    throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u751f\u6210\u5907\u4efd\u6587\u4ef6");
                }
                strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$s7-Zip%2$s7z.exe a \"%3$s.7z\" \"%3$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupFile);
                this.runBat(strCmd, true);
                file = new File(strBackupZipFile);
                if (!file.exists() || file.length() == 0L) {
                    throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u751f\u6210\u538b\u7f29\u6587\u4ef6");
                }
                strCmd = StringHelper.Format((String)"cmd.exe /c copy \"%1$s\" \"%2$s\" /Y", (Object)strBackupZipFile, (Object)strNasFile);
                this.runBat(strCmd, true);
            }
            File file = new File(strNasFile);
            if (!file.exists() || file.length() == 0L) {
                throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u5b58\u653e\u5230NAS");
            }
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get(psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                PSDevSlnSys psDevSlnSys22 = new PSDevSlnSys();
                psDevSlnSys22.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSys22.setActionOwner(null);
                psDevSlnSys22.setDevSysState(DevSysStateCodeListModel.ONLINE);
                psDevSlnSys22.setCurAction("NONE");
                psDevSlnSysService.sysUpdate(psDevSlnSys22, true);
                PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys22);
                this.sendStateChangedConsole(psDevSlnSys, DevSysStateCodeListModel.ONLINE);
            }
            psDevSlnSysBak.reset();
            psDevSlnSysBak2.setPSDevSlnSysBakId(this.getTaskParam2());
            psDevSlnSysBak2.setEndBackupTime(DateHelper.getCurTime());
            psDevSlnSysBak2.setBackupState(DBInstBStateCodeListModel.CREATED);
            psDevSlnSysBak2.setBackupFilePath(strNasFile2);
            psDevSlnSysBak2.setBackupSize(Integer.valueOf((int)file.length()));
            psDevSlnSysBakService.sysUpdate(psDevSlnSysBak2, false);
            this.sendStudioConsole(null, "INFO", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5907\u4efd\u6a21\u578b\u4ed3\u5e93\u6210\u529f", (Object)psDevSlnSys.getPSDevSlnSysName()));
            return "\u5907\u4efd\u6210\u529f";
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5907\u4efd\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getTaskParam(), (Object)ex.getMessage()), (Throwable)ex);
            this.sendStudioConsole(null, "ERROR", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5907\u4efd\u6a21\u578b\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)ex.getMessage()));
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
                psDevSlnSysBak.reset();
                psDevSlnSysBak2.setPSDevSlnSysBakId(this.getTaskParam2());
                psDevSlnSysBak2.setEndBackupTime(DateHelper.getCurTime());
                psDevSlnSysBak2.setBackupState(DBInstBStateCodeListModel.FAILED);
                psDevSlnSysBakService.sysUpdate(psDevSlnSysBak2, false);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }
}
