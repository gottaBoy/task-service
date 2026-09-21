/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Util.CmdHelper;
import SA.SRFDA.PS.Core.Util.PSSysModelInstHelper;
import SA.SRFDA.PS.Core.Workspace.IPSDCWorkspace;
import SA.SRFDA.PS.Core.Workspace.PSWorkspacePeriod;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysHelper {
    private static final Log log = LogFactory.getLog(PSDevSlnSysHelper.class);
    private static boolean bCloudMode = false;

    public static boolean isCloudMode() {
        return bCloudMode;
    }

    public static void setCloudMode(boolean bCloudMode) {
        PSDevSlnSysHelper.bCloudMode = bCloudMode;
    }

    public static PSDevSlnSysBak backup(String strPSDevSlnSysId) throws Exception {
        return PSDevSlnSysHelper.backup(strPSDevSlnSysId, false);
    }

    public static PSDevSlnSysBak backup(String strPSDevSlnSysId, boolean bOffline) throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        int nDevSysState = DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30);
        if (nDevSysState != 31) {
            if (DataObject.getIntegerValue((Object)nDevSysState, (Integer)30) != 30) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u8fdb\u884c\u5907\u4efd", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
            }
            if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u8fdb\u884c\u5907\u4efd", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
            }
        }
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e3a\u5171\u4eab\u7cfb\u7edf\uff0c\u65e0\u6cd5\u8fdb\u884c\u5907\u4efd", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
        psDevSlnSysBak.setPSDevSlnSysBakName(StringHelper.Format((String)"\u5907\u4efd[%1$s]", (Object)DateHelper.getCurTimeString()));
        psDevSlnSysBak.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDevSlnSysBak.setPSDevCenterName(psDevSlnSys.getPSDevCenterName());
        psDevSlnSysBak.setBackupMode("V2");
        psDevSlnSysBak.setBackupState(Integer.valueOf(10));
        psDevSlnSysBak.setOfflineFlag(Integer.valueOf(bOffline ? 1 : 0));
        psDevSlnSysBak.setModelVer(psDevSlnSys.getModelInstVer());
        psDevSlnSysBak.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSysBak.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDevSlnSysBak.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDevSlnSysBak.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDevSlnSysBakService.create((IEntity)psDevSlnSysBak, false);
        return PSDevSlnSysHelper.backup(psDevSlnSysBak, bOffline, null);
    }

    public static PSDevSlnSys offline(String strPSDevSlnSysId, String strPSDCWorkspaceId) throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
        if (!psDevSlnSysService.get((IEntity)psDevSlnSys, true)) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728", (Object)strPSDevSlnSysId));
        }
        int nDevSysState = DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30);
        if (nDevSysState == 35) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u518d\u6b21\u79bb\u7ebf", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (StringHelper.IsNullOrEmpty((String)psDevSlnSys.getPSSysModelInstId())) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u672a\u6307\u5b9a\u6a21\u578b\u4ed3\u5e93\uff0c\u65e0\u6cd5\u8fdb\u884c\u79bb\u7ebf", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getPSDCWorkspaceId()) && !StringHelper.IsNullOrEmpty((String)strPSDCWorkspaceId) && StringHelper.Compare((String)psDevSlnSys.getPSDCWorkspaceId(), (String)strPSDCWorkspaceId, (boolean)false) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u751f\u4ea7\u7ebf\u4e0d\u4e00\u81f4\uff0c\u65e0\u6cd5\u8fdb\u884c\u79bb\u7ebf", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
            psDevSlnSys2.reset();
            psDevSlnSys2.setPSDevSlnSysId(strPSDevSlnSysId);
            if (nDevSysState != 31) {
                psDevSlnSys2.setDevSysState(Integer.valueOf(35));
            }
            psDevSlnSys2.setPSDCWorkspaceId(null);
            psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
            return psDevSlnSys2;
        }
        PSSysModelInstService psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        if (!PSDevSlnSysHelper.isCloudMode()) {
            PSSysModelInst backupPSSysModelInst = new PSSysModelInst();
            backupPSSysModelInst.setPSSysModelInstId(psDevSlnSys.getPSSysModelInstId());
            psSysModelInstService.createBackup(backupPSSysModelInst);
            PSSysModelInstHelper.online(backupPSSysModelInst.getPSSysModelInstId());
        }
        PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
        psDevSlnSysBak.setPSDevSlnSysBakName(StringHelper.Format((String)"\u79bb\u7ebf\u5907\u4efd[%1$s]", (Object)DateHelper.getCurTimeString()));
        psDevSlnSysBak.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDevSlnSysBak.setPSDevCenterName(psDevSlnSys.getPSDevCenterName());
        psDevSlnSysBak.setBackupMode("V2");
        psDevSlnSysBak.setBackupState(Integer.valueOf(10));
        psDevSlnSysBak.setBackupTime(DateHelper.getCurTime());
        psDevSlnSysBak.setOfflineFlag(Integer.valueOf(1));
        psDevSlnSysBak.setModelVer(psDevSlnSys.getModelInstVer());
        psDevSlnSysBak.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSysBak.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDevSlnSysBak.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDevSlnSysBak.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDevSlnSysBakService.create((IEntity)psDevSlnSysBak, true);
        psDevSlnSysBak = PSDevSlnSysHelper.backup(psDevSlnSysBak, true, strPSDCWorkspaceId);
        if (PSDevSlnSysHelper.isCloudMode()) {
            PSDevSlnSysHelper.exportModel(psDevSlnSys);
        }
        if (!PSDevSlnSysHelper.isCloudMode()) {
            PSDevSlnSysHelper.restoreBKInst(psDevSlnSys.getPSDevSlnSysId(), psDevSlnSysBak.getPSDevSlnSysBakId());
        }
        PSSysModelInstHelper.offline(psDevSlnSys.getPSSysModelInstId());
        if (!PSDevSlnSysHelper.isCloudMode()) {
            try {
                PSSysModelInstHelper.offline(String.valueOf(psDevSlnSys.getPSSysModelInstId()) + "_bak");
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u79bb\u7ebf\u5907\u4efd\u5b9e\u4f8b[%1$s]\u53d1\u751f\u5f02\u5e38,%2$s", (Object)(String.valueOf(psDevSlnSys.getPSSysModelInstId()) + "_bak"), (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        psDevSlnSys2.reset();
        psDevSlnSys2.setPSDevSlnSysId(strPSDevSlnSysId);
        if (nDevSysState != 31) {
            psDevSlnSys2.setDevSysState(Integer.valueOf(35));
        }
        psDevSlnSys2.setPSDCWorkspaceId(null);
        psDevSlnSys2.setLastActiveTime(new Timestamp(System.currentTimeMillis()));
        psDevSlnSys2.setOfflineTime(null);
        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
        return psDevSlnSys2;
    }

    public static PSDevSlnSysBak backup(PSDevSlnSysBak psDevSlnSysBak, boolean bOffline, String strPSDCWorkspaceId) throws Exception {
        PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnSysBakService.get((IEntity)psDevSlnSysBak);
        String strPSDevSlnSysBakId = psDevSlnSysBak.getPSDevSlnSysBakId();
        String strPSDevSlnSysId = psDevSlnSysBak.getPSDevSlnSysId();
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDevSlnSysBak psDevSlnSysBak2 = new PSDevSlnSysBak();
        try {
            psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
            psDevSlnSysService.get((IEntity)psDevSlnSys);
            int nDevSysState = DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30);
            if (nDevSysState != 30 && nDevSysState != 31) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u8fdb\u884c\u5907\u4efd", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
            }
            psDevSlnSysBak2.setPSDevSlnSysBakId(strPSDevSlnSysBakId);
            psDevSlnSysBak2.setBeginBackupTime(DateHelper.getCurTime());
            psDevSlnSysBak2.setBackupState(DBInstBStateCodeListModel.CREATING);
            psDevSlnSysBakService.sysUpdate((IEntity)psDevSlnSysBak2, false);
            String strNasFile = "";
            String strNasFile2 = "";
            String strNasFolder = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$s", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
            File nasfile = new File(strNasFolder);
            nasfile.mkdirs();
            if (StringHelper.Compare((String)psDevSlnSysBak.getBackupMode(), (String)"V2", (boolean)false) == 0) {
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
                    CmdHelper.getInstance().executeBat(strCmd);
                    File file = new File(strBackupZipFile);
                    if (!file.exists() || file.length() == 0L) {
                        throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u751f\u6210\u538b\u7f29\u6587\u4ef6");
                    }
                    strCmd = StringHelper.Format((String)"cp -rf %1$s %2$s", (Object)strBackupZipFile, (Object)strNasFile);
                    CmdHelper.getInstance().executeBat(strCmd);
                } else {
                    String strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$s7-Zip%2$s7z.exe a \"%3$s\" \"%4$s%2$s*\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupZipFile, (Object)strFolder);
                    CmdHelper.getInstance().executeBat(strCmd);
                    File file = new File(strBackupZipFile);
                    if (!file.exists() || file.length() == 0L) {
                        throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u751f\u6210\u538b\u7f29\u6587\u4ef6");
                    }
                    strCmd = StringHelper.Format((String)"cmd.exe /c copy \"%1$s\" \"%2$s\" /Y", (Object)strBackupZipFile, (Object)strNasFile);
                    CmdHelper.getInstance().executeBat(strCmd);
                }
            } else {
                PSSysModelInst psSysModelInst = psDevSlnSys.getPSSysModelInst();
                PSDBServer psDBServer = psSysModelInst.getPSDBServer();
                String strBackupFile = StringHelper.Format((String)"%1$sdb.sql", (Object)PSTaskServerEnvImpl.getCurrent().createTempFolder());
                String strBackupZipFile = StringHelper.Format((String)"%1$s.7z", (Object)strBackupFile);
                strNasFolder = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$s", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
                strNasFile = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$sdb.sql.7z", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
                strNasFile2 = StringHelper.Format((String)"%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$sdb.sql.7z", (Object)"", (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
                if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
                    throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5b9e\u73b0"));
                }
                String strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$smysqldump.exe -h %7$s  %3$s  -u %4$s -p%5$s --add-drop-table --set-gtid-purged=OFF --default-character-set=utf8|%1$s%2$ssed%2$ssed.exe -e \"s/DEFINER[ ]*=[ ]*[^*]*\\*/\\*/\" > \"%8$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)psSysModelInst.getDBName(), (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName(), (Object)psDBServer.getIPAddr(), (Object)strBackupFile);
                CmdHelper.getInstance().executeBat(strCmd);
                File file = new File(strBackupFile);
                if (!file.exists() || file.length() == 0L) {
                    throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u751f\u6210\u5907\u4efd\u6587\u4ef6");
                }
                strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$s7-Zip%2$s7z.exe a \"%3$s.7z\" \"%3$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupFile);
                CmdHelper.getInstance().executeBat(strCmd);
                file = new File(strBackupZipFile);
                if (!file.exists() || file.length() == 0L) {
                    throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u751f\u6210\u538b\u7f29\u6587\u4ef6");
                }
                strCmd = StringHelper.Format((String)"cmd.exe /c copy \"%1$s\" \"%2$s\" /Y", (Object)strBackupZipFile, (Object)strNasFile);
                CmdHelper.getInstance().executeBat(strCmd);
            }
            File file = new File(strNasFile);
            if (!file.exists() || file.length() == 0L) {
                throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u5b58\u653e\u5230NAS");
            }
            psDevSlnSysBak2.reset();
            psDevSlnSysBak2.setPSDevSlnSysBakId(strPSDevSlnSysBakId);
            psDevSlnSysBak2.setEndBackupTime(DateHelper.getCurTime());
            psDevSlnSysBak2.setBackupState(DBInstBStateCodeListModel.CREATED);
            psDevSlnSysBak2.setBackupFilePath(strNasFile2);
            psDevSlnSysBak2.setBackupSize(Integer.valueOf((int)file.length()));
            psDevSlnSysBakService.sysUpdate((IEntity)psDevSlnSysBak2, true);
            return psDevSlnSysBak2;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5907\u4efd\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strPSDevSlnSysId, (Object)ex.getMessage()), (Throwable)ex);
            try {
                psDevSlnSysBak2.reset();
                psDevSlnSysBak2.setPSDevSlnSysBakId(strPSDevSlnSysBakId);
                psDevSlnSysBak2.setEndBackupTime(DateHelper.getCurTime());
                psDevSlnSysBak2.setBackupState(DBInstBStateCodeListModel.FAILED);
                psDevSlnSysBakService.sysUpdate((IEntity)psDevSlnSysBak2, false);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }

    public static void restore(String strPSDevSlnSysId, String strPSDevSlnSysBakId) throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
        psDevSlnSysBak.setPSDevSlnSysBakId(strPSDevSlnSysBakId);
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
        try {
            PSDevSlnSysHelper.restore(psSysModelInst, psDevSlnSys.getModelInstVer(), realDevSlnSysBak);
            psDevSlnSysService.rebindSystem(psDevSlnSys);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6062\u590d\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strPSDevSlnSysId, (Object)ex.getMessage()), (Throwable)ex);
            throw ex;
        }
    }

    public static void restoreBKInst(String strPSDevSlnSysId, String strPSDevSlnSysBakId) throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
        psDevSlnSysBak.setPSDevSlnSysBakId(strPSDevSlnSysBakId);
        psDevSlnSysBakService.get((IEntity)psDevSlnSysBak);
        PSDevSlnSysBak realDevSlnSysBak = psDevSlnSysBak;
        PSSysModelInstService psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSysModelInst backupPSSysModelInst = new PSSysModelInst();
        backupPSSysModelInst.setPSSysModelInstId(String.valueOf(psDevSlnSys.getPSSysModelInstId()) + "_bak");
        psSysModelInstService.get((IEntity)backupPSSysModelInst);
        PSSysModelInst psSysModelInst = psDevSlnSys.getPSSysModelInst();
        try {
            PSDevSlnSysHelper.restore(backupPSSysModelInst, PSSysModelInstHelper.MODELVER_NEW_NOFK_NOVIEW, realDevSlnSysBak);
            PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
            psModelV2Helper.init(null, psSysModelInst.getPSSysModelInstId());
            Map srcCountMap = psModelV2Helper.count();
            PSModelV2Helper psModelV2Helper2 = new PSModelV2Helper();
            psModelV2Helper2.init(null, backupPSSysModelInst.getPSSysModelInstId());
            Map backupCountMap = psModelV2Helper2.count();
            for (Map.Entry entry : srcCountMap.entrySet()) {
                Integer nBKCnt = (Integer)backupCountMap.get(entry.getKey());
                if (nBKCnt == null) {
                    if (entry.getValue() == null || (Integer)entry.getValue() == 0) continue;
                    throw new Exception(StringHelper.Format((String)"\u5907\u4efd\u5b9e\u4f8b\u7f3a\u5931\u6a21\u578b[%1$s]\u6570\u636e", entry.getKey()));
                }
                if (nBKCnt.equals(entry.getValue())) continue;
                throw new Exception(StringHelper.Format((String)"\u5907\u4efd\u5b9e\u4f8b\u6a21\u578b[%1$s]\u6570\u636e\u4e0d\u4e00\u81f4\uff0c%2$s|%3$s", entry.getKey(), entry.getValue(), (Object)nBKCnt));
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6062\u590d\u5907\u4efd\u5b9e\u4f8b[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strPSDevSlnSysId, (Object)ex.getMessage()), (Throwable)ex);
            throw ex;
        }
    }

    public static PSDevSlnSys online(String strPSDevSlnSysId, String strPSDCWorkspaceId) throws Exception {
        int nDevSysState;
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
        if (!psDevSlnSysService.get((IEntity)psDevSlnSys, true)) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728", (Object)strPSDevSlnSysId));
        }
        IPSDCWorkspace iPSDCWorkspace = null;
        PSWorkspacePeriod psWorkspacePeriod = null;
        if (!StringHelper.IsNullOrEmpty((String)strPSDCWorkspaceId)) {
            iPSDCWorkspace = PSObjectFactory.getPSModelStorage().getPSDCWorkspace(strPSDCWorkspaceId, true);
            if (iPSDCWorkspace == null) {
                throw new Exception(StringHelper.Format((String)"\u6307\u5b9a\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u65e0\u6548"));
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDCWorkspace.getPSDevCenterId()) && StringHelper.Compare((String)iPSDCWorkspace.getPSDevCenterId(), (String)psDevSlnSys.getPSDevCenterId(), (boolean)false) != 0) {
                log.error((Object)StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]\u4e2d\u5fc3\u4e0e\u5f00\u53d1\u7cfb\u7edf[%2$s]\u4e2d\u5fc3\u4e0d\u4e00\u81f4", (Object)iPSDCWorkspace.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId()));
                throw new Exception(StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u4e2d\u5fc3\u4e0e\u5f00\u53d1\u7cfb\u7edf\u4e2d\u5fc3\u4e0d\u4e00\u81f4"));
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDCWorkspace.getPSDevSlnId()) && StringHelper.Compare((String)iPSDCWorkspace.getPSDevSlnId(), (String)psDevSlnSys.getPSDevSlnId(), (boolean)false) != 0) {
                throw new Exception(StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u9884\u5206\u914d\u5f00\u53d1\u65b9\u6848\u4e0e\u5f00\u53d1\u7cfb\u7edf\u65b9\u6848\u4e0d\u4e00\u81f4"));
            }
            try {
                psWorkspacePeriod = iPSDCWorkspace.calcPSWorkspacePeriod(null, true);
                if (psWorkspacePeriod == null) {
                    throw new Exception(StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u5df2\u5931\u6548"));
                }
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u53ef\u7528\u65f6\u95f4\u6bb5\uff0c%1$s", (Object)ex.getMessage()), ex);
            }
            if (psWorkspacePeriod.isNextMode()) {
                throw new Exception(StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u672a\u5728\u53ef\u7528\u65f6\u95f4\u6bb5\uff0c\u4e0b\u4e00\u4e2a\u53ef\u7528\u65f6\u95f4\u5468\u671f[%1$s]\u81f3[%2$s]", (Object)DateHelper.toDateTimeString((Date)psWorkspacePeriod.getBeginTime()), (Object)DateHelper.toDateTimeString((Date)psWorkspacePeriod.getEndTime())));
            }
        }
        if ((nDevSysState = DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30).intValue()) == 30) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u518d\u6b21\u8fde\u7ebf", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(Integer.toString(nDevSysState)).getText()));
        }
        if (StringHelper.IsNullOrEmpty((String)psDevSlnSys.getPSSysModelInstId())) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u672a\u6307\u5b9a\u6a21\u578b\u4ed3\u5e93\uff0c\u65e0\u6cd5\u8fdb\u884c\u8fde\u7ebf", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getPSDCWorkspaceId()) && !StringHelper.IsNullOrEmpty((String)strPSDCWorkspaceId) && StringHelper.Compare((String)psDevSlnSys.getPSDCWorkspaceId(), (String)strPSDCWorkspaceId, (boolean)false) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u751f\u4ea7\u7ebf\u4e0d\u4e00\u81f4\uff0c\u65e0\u6cd5\u8fdb\u884c\u8fde\u7ebf", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
            psDevSlnSys2.reset();
            psDevSlnSys2.setPSDevSlnSysId(strPSDevSlnSysId);
            if (nDevSysState != 31) {
                psDevSlnSys2.setDevSysState(Integer.valueOf(30));
            }
            psDevSlnSys2.setPSDCWorkspaceId(strPSDCWorkspaceId);
            psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, false);
            return psDevSlnSys2;
        }
        PSSysModelInstHelper.online(psDevSlnSys.getPSSysModelInstId());
        ArrayList psDevSlnSysBakList = null;
        if (!PSDevSlnSysHelper.isCloudMode()) {
            PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            SelectCond selectCond = new SelectCond();
            selectCond.set("OFFLINEFLAG", (Object)1);
            selectCond.set("BACKUPSTATE", (Object)30);
            selectCond.set("PSDEVSLNSYSID", (Object)psDevSlnSys.getPSDevSlnSysId());
            selectCond.setOrderInfo("ORDER BY BACKUPTIME DESC");
            selectCond.setMaxRowCount(1);
            psDevSlnSysBakList = psDevSlnSysBakService.select((ISelectCond)selectCond);
        }
        if (psDevSlnSysBakList != null && psDevSlnSysBakList.size() > 0) {
            PSDevSlnSysHelper.restore(psDevSlnSys.getPSDevSlnSysId(), ((PSDevSlnSysBak)psDevSlnSysBakList.get(0)).getPSDevSlnSysBakId());
        } else {
            String strGitPath = "";
            if (psDevSlnSys.getModelPSDevCenterSVN() != null) {
                strGitPath = psDevSlnSys.getModelPSDevCenterSVN().getGitPath();
            }
            if (!StringHelper.IsNullOrEmpty((String)strGitPath)) {
                PSDevSlnSysHelper.importModel(psDevSlnSys);
            } else {
                psDevSlnSysService.rebindSystem(psDevSlnSys);
            }
        }
        if (!PSDevSlnSysHelper.isCloudMode()) {
            PSSysModelInstHelper.offline(String.valueOf(psDevSlnSys.getPSSysModelInstId()) + "_bak");
        }
        psDevSlnSys2.reset();
        psDevSlnSys2.setPSDevSlnSysId(strPSDevSlnSysId);
        if (nDevSysState != 31) {
            psDevSlnSys2.setDevSysState(Integer.valueOf(30));
        }
        psDevSlnSys2.setPSDCWorkspaceId(strPSDCWorkspaceId);
        psDevSlnSys2.setLastActiveTime(new Timestamp(System.currentTimeMillis()));
        try {
            if (!StringHelper.IsNullOrEmpty((String)strPSDCWorkspaceId)) {
                iPSDCWorkspace = PSObjectFactory.getPSModelStorage().getPSDCWorkspace(strPSDCWorkspaceId, true);
                if (iPSDCWorkspace == null) {
                    throw new Exception(StringHelper.Format((String)"\u6307\u5b9a\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u65e0\u6548"));
                }
                psWorkspacePeriod = iPSDCWorkspace.calcPSWorkspacePeriod(null, true);
                if (psWorkspacePeriod == null) {
                    throw new Exception(StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u5df2\u5931\u6548"));
                }
                if (psWorkspacePeriod.isNextMode()) {
                    psWorkspacePeriod = null;
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        if (psWorkspacePeriod != null) {
            psDevSlnSys2.setOfflineTime(psWorkspacePeriod.getEndTime());
        } else {
            psDevSlnSys2.setOfflineTime(null);
        }
        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
        return psDevSlnSys2;
    }

    private static void restore(PSSysModelInst psSysModelInst, int nCurVersion, PSDevSlnSysBak psDevSlnSysBak) throws Exception {
        boolean bBKMode = DataObject.getBoolValue((Integer)psSysModelInst.getParam5(), (boolean)false);
        String strPSSysModelInstId = psSysModelInst.getPSSysModelInstId();
        PSDBServer psDBServer = psSysModelInst.getPSDBServer();
        if (StringHelper.Compare((String)psDevSlnSysBak.getBackupMode(), (String)"V2", (boolean)false) == 0) {
            String strTempFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
            String strBackupFolder = StringHelper.Format((String)"%1$sMODEL2", (Object)strTempFolder);
            String strBackupZipFile = StringHelper.Format((String)"%1$sMODEL2.7z", (Object)strTempFolder);
            String strNasFile = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSysBak.getBackupFilePath());
            if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
                String strCmd = StringHelper.Format((String)"cp -rf %1$s %2$s", (Object)strNasFile, (Object)strBackupZipFile);
                CmdHelper.getInstance().executeBat(strCmd);
                File file = new File(strBackupZipFile);
                if (!file.exists() || file.length() == 0L) {
                    throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u5907\u4efd\u6587\u4ef6");
                }
                strCmd = StringHelper.Format((String)"7za x -y -o%3$s %4$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupFolder, (Object)strBackupZipFile);
                CmdHelper.getInstance().executeBat(strCmd);
                file = new File(strBackupFolder);
                if (!file.exists() || file.length() == 0L) {
                    throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u89e3\u538b\u5907\u4efd\u6587\u4ef6");
                }
                PSSysModelInstHelper.updateVersion(strPSSysModelInstId, nCurVersion);
                SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)strPSSysModelInstId);
                PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
                psSystemService.executeResetSysModel(strPSSysModelInstId);
                PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
                psModelV2Helper.init(null, strPSSysModelInstId);
                psModelV2Helper.restore(strBackupFolder);
            } else {
                String strCmd = StringHelper.Format((String)"cmd.exe /c copy \"%1$s\" \"%2$s\" /Y", (Object)strNasFile, (Object)strBackupZipFile);
                CmdHelper.getInstance().executeBat(strCmd);
                File file = new File(strBackupZipFile);
                if (!file.exists() || file.length() == 0L) {
                    throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u5907\u4efd\u6587\u4ef6");
                }
                strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$s7-Zip%2$s7z.exe x -y -o\"%3$s\" \"%4$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupFolder, (Object)strBackupZipFile);
                CmdHelper.getInstance().executeBat(strCmd);
                file = new File(strBackupFolder);
                if (!file.exists() || file.length() == 0L) {
                    throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u89e3\u538b\u5907\u4efd\u6587\u4ef6");
                }
                PSSysModelInstHelper.updateVersion(strPSSysModelInstId, nCurVersion);
                SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)strPSSysModelInstId);
                PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
                psSystemService.executeResetSysModel(strPSSysModelInstId);
                PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
                psModelV2Helper.init(null, strPSSysModelInstId);
                psModelV2Helper.restore(strBackupFolder);
            }
        } else {
            String strTempFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
            String strBackupFile = StringHelper.Format((String)"%1$sdb.sql", (Object)strTempFolder);
            String strBackupZipFile = StringHelper.Format((String)"%1$s.7z", (Object)strBackupFile);
            String strNasFile = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSysBak.getBackupFilePath());
            if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5b9e\u73b0"));
            }
            String strCmd = StringHelper.Format((String)"cmd.exe /c copy \"%1$s\" \"%2$s\" /Y", (Object)strNasFile, (Object)strBackupZipFile);
            CmdHelper.getInstance().executeBat(strCmd);
            File file = new File(strBackupZipFile);
            if (!file.exists() || file.length() == 0L) {
                throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u5907\u4efd\u6587\u4ef6");
            }
            strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$s7-Zip%2$s7z.exe x -y -o\"%3$s\" \"%4$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strTempFolder, (Object)strBackupZipFile);
            CmdHelper.getInstance().executeBat(strCmd);
            file = new File(strBackupFile);
            if (!file.exists() || file.length() == 0L) {
                throw new Exception("\u6062\u590d\u5931\u8d25\uff0c\u65e0\u6cd5\u89e3\u538b\u5907\u4efd\u6587\u4ef6");
            }
            strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$smysql.exe -h %7$s %3$s -u %4$s -p%5$s --default-character-set=utf8  < \"%8$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)psSysModelInst.getDBName(), (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName(), (Object)psDBServer.getIPAddr(), (Object)strBackupFile);
            CmdHelper.Result ret = CmdHelper.getInstance().executeBat(strCmd);
            log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u547d\u4ee4:%1$s\r\n\u8fd4\u56de%2$s", (Object)strCmd, (Object)ret.getInfo()));
            if (!StringHelper.IsNullOrEmpty((String)ret.getErrorInfo()) && ret.getErrorInfo().indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ret.getErrorInfo()));
            }
            PSSysModelInstHelper.updateVersion(strPSSysModelInstId, psDevSlnSysBak.getModelVer());
        }
    }

    private static void importModel(PSDevSlnSys psDevSlnSys) throws Exception {
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
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenterService psDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenter psDevCenter = new PSDevCenter();
        psDevCenter.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDevCenterService.get((IEntity)psDevCenter);
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
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
        String strRootModelFile = String.valueOf(strModelFolder) + File.separator + "PSSYSTEM.json";
        File rootModelFile = new File(strRootModelFile);
        if (rootModelFile.exists()) {
            PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
            psModelV2Helper.init(psDevSlnSys.getPSSystemId(), psDevSlnSys.getPSSysModelInstId(), psDevSlnSys.getCodeName());
            psModelV2Helper.compile(String.valueOf(strFolder) + "MODEL2", strModelFolder, false);
            PSSysModelInstGlobal.active((String)psDevSlnSys.getPSSysModelInstId());
            psSystemService.executeResetSysModel(psDevSlnSys.getPSSysModelInstId());
            psModelV2Helper.import2(String.valueOf(strFolder) + "MODEL2" + File.separator + "DATAS");
        }
        PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSysService.rebindSystem(psDevSlnSys2);
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(psDevSlnSys.getPSSystemId());
        psSystemService.initModel((IEntity)psSystem);
    }

    protected static void exportModel(PSDevSlnSys psDevSlnSys) throws Exception {
        String strResult;
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
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenterService psDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenter psDevCenter = new PSDevCenter();
        psDevCenter.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDevCenterService.get((IEntity)psDevCenter);
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
    }
}

