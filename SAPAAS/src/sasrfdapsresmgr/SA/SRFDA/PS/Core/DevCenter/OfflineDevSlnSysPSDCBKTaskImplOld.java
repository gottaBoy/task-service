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
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.DevSlnSysPSDCBKTaskImplBase;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class OfflineDevSlnSysPSDCBKTaskImplOld
extends DevSlnSysPSDCBKTaskImplBase {
    private static final Log log = LogFactory.getLog(OfflineDevSlnSysPSDCBKTaskImplOld.class);

    protected String onRun() throws Exception {
        PSSysModelInstService psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
        psDevSlnSysBak.setPSDevSlnSysBakId(this.getTaskParam2());
        psDevSlnSysBakService.get((IEntity)psDevSlnSysBak);
        PSDevSlnSysBak psDevSlnSysBak2 = new PSDevSlnSysBak();
        psDevSlnSysBak2.setPSDevSlnSysBakId(this.getTaskParam2());
        psDevSlnSysBak2.setBeginBackupTime(DateHelper.getCurTime());
        psDevSlnSysBak2.setBackupState(DBInstBStateCodeListModel.CREATING);
        psDevSlnSysBakService.sysUpdate((IEntity)psDevSlnSysBak2, false);
        PSSysModelInst psSysModelInst = psDevSlnSys.getPSSysModelInst();
        PSDBServer psDBServer = psSysModelInst.getPSDBServer();
        String strOwnerId = StringHelper.Format((String)"%1$s|%2$s", (Object)psDevSlnSysBakService.getDEModel().getName(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
        try {
            String strBackupFile = StringHelper.Format((String)"%1$sdb.sql", (Object)PSTaskServerEnvImpl.getCurrent().createTempFolder());
            String strBackupZipFile = StringHelper.Format((String)"%1$s.7z", (Object)strBackupFile);
            String strNasFolder = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$s", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
            String strNasFile = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$sdb.sql.7z", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
            File nasfile = new File(strNasFolder);
            nasfile.mkdirs();
            String strNasFile2 = StringHelper.Format((String)"%3$s%2$ssysbk%2$s%4$s%2$s%5$s%2$sdb.sql.7z", (Object)"", (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId());
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
            File file2 = new File(strBackupZipFile);
            if (!file2.exists() || file2.length() == 0L) {
                throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u5b58\u653e\u5230NAS");
            }
            PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
            psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSys2.setDevSysState(Integer.valueOf(35));
            psDevSlnSysService.update((IEntity)psDevSlnSys2);
            PSSysModelInst psSysModelInst2 = new PSSysModelInst();
            psSysModelInst2.setPSSysModelInstId(psDevSlnSys2.getPSSysModelInstId());
            psSysModelInst2.setInstState("35");
            psSysModelInstService.update((IEntity)psSysModelInst2);
            if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5b9e\u73b0"));
            }
            String strCmd2 = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$smysql.exe -h %7$s %3$s -u %4$s -p%5$s -e\"DROP DATABASE IF EXISTS %3$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)psSysModelInst.getDBName(), (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName(), (Object)psDBServer.getIPAddr());
            String strRet = this.runBat(strCmd2, true);
            log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u547d\u4ee4:%1$s\r\n\u8fd4\u56de%2$s", (Object)strCmd2, (Object)strRet));
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            this.runCreateMySQLDBCmd(psDBServer, psSysModelInst);
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get((IEntity)psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                psDevSlnSys2 = new PSDevSlnSys();
                psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSys2.setActionOwner(null);
                psDevSlnSys2.setCurAction("NONE");
                psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, false);
            }
            psDevSlnSysBak.reset();
            psDevSlnSysBak2.setPSDevSlnSysBakId(this.getTaskParam2());
            psDevSlnSysBak2.setEndBackupTime(DateHelper.getCurTime());
            psDevSlnSysBak2.setBackupState(DBInstBStateCodeListModel.CREATED);
            psDevSlnSysBak2.setBackupFilePath(strNasFile2);
            psDevSlnSysBak2.setBackupSize(Integer.valueOf((int)file2.length()));
            psDevSlnSysBakService.sysUpdate((IEntity)psDevSlnSysBak2, false);
            return "\u79bb\u7ebf\u6210\u529f";
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u79bb\u7ebf\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getTaskParam(), (Object)ex.getMessage()), (Throwable)ex);
            try {
                psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSysService.get((IEntity)psDevSlnSys);
                if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                    PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
                    psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                    psDevSlnSys2.setActionOwner(null);
                    psDevSlnSys2.setCurAction("NONE");
                    psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, false);
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
                psDevSlnSysBakService.sysUpdate((IEntity)psDevSlnSysBak2, false);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }
}

