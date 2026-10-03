/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.PSTaskServerEnvImpl
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService
 *  net.sf.json.JSONObject
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
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class CreateDevSlnSysDepInstPSDCBKTaskImpl
extends DevSlnSysPSDCBKTaskImplBase {
    private static final Log log = LogFactory.getLog(CreateDevSlnSysDepInstPSDCBKTaskImpl.class);

    protected String onRun() throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
        psDevSlnSysService.get(psDevSlnSys);
        PSDevSlnSysDepInstService psDevSlnSysDepInstService = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysDepInst psDevSlnSysDepInst = new PSDevSlnSysDepInst();
        psDevSlnSysDepInst.setPSDevSlnSysDepInstId(this.getTaskParam2());
        psDevSlnSysDepInstService.get(psDevSlnSysDepInst);
        PSDevSlnSysDepInst psDevSlnSysDepInst2 = new PSDevSlnSysDepInst();
        psDevSlnSysDepInst2.setPSDevSlnSysDepInstId(this.getTaskParam2());
        psDevSlnSysDepInst2.setDepInstState(DevSysStateCodeListModel.CREATING);
        psDevSlnSysDepInstService.sysUpdate(psDevSlnSysDepInst2, false);
        PSSysModelInst psSysModelInst = psDevSlnSys.getPSSysModelInst();
        PSDBServer psDBServer = psSysModelInst.getPSDBServer();
        String strOwnerId = StringHelper.Format((String)"%1$s|%2$s", (Object)psDevSlnSysDepInstService.getDEModel().getName(), (Object)psDevSlnSysDepInst.getPSDevSlnSysDepInstId());
        boolean bBackupFlag = false;
        try {
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$spsdevslnsysdepinst_publish.py %3$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.getTaskParam2()) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$spsdevslnsysdepinst_publish.py %3$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.getTaskParam2());
            String strRet = this.runBat(strCmd, true);
            if (StringHelper.IsNullOrEmpty((String)strRet)) {
                throw new Exception("\u8c03\u7528\u53d1\u751f\u9519\u8bef\uff0c\u6ca1\u6709\u8fd4\u56de\u5185\u5bb9");
            }
            JSONObject jo = null;
            try {
                strRet = strRet.trim();
                jo = JSONObjectHelper.fromString2((String)strRet);
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.Format((String)"\u8c03\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            if (jo.optInt("ret", 1) != 0) {
                throw new Exception(jo.optString("info", "\u672a\u77e5\u9519\u8bef"));
            }
            psDevSlnSysDepInst2.reset();
            psDevSlnSysDepInst2.setPSDevSlnSysDepInstId(this.getTaskParam2());
            psDevSlnSysDepInst2.setBeginBackupTime(DateHelper.getCurTime());
            psDevSlnSysDepInst2.setBackupState(DBInstBStateCodeListModel.CREATING);
            psDevSlnSysDepInstService.sysUpdate(psDevSlnSysDepInst2, false);
            bBackupFlag = true;
            String strBackupFile = StringHelper.Format((String)"%1$sdb.sql", (Object)PSTaskServerEnvImpl.getCurrent().createTempFolder());
            String strBackupZipFile = StringHelper.Format((String)"%1$s.7z", (Object)strBackupFile);
            String strNasFolder = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysdepbk%2$s%4$s%2$s%5$s%2$s", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysDepInst.getPSDevSlnSysDepInstId());
            String strNasFile = StringHelper.Format((String)"%1$s%2$s%3$s%2$ssysdepbk%2$s%4$s%2$s%5$s%2$sdb.sql.7z", (Object)PSTaskServerEnvImpl.getCurrent().getBackupFolder(), (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysDepInst.getPSDevSlnSysDepInstId());
            File nasfile = new File(strNasFolder);
            nasfile.mkdirs();
            String strNasFile2 = StringHelper.Format((String)"%3$s%2$ssysdepbk%2$s%4$s%2$s%5$s%2$sdb.sql.7z", (Object)"", (Object)File.separator, (Object)psDevSlnSys.getPSDevCenterId(), (Object)psDevSlnSys.getPSDevSlnSysId(), (Object)psDevSlnSysDepInst.getPSDevSlnSysDepInstId());
            if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5b9e\u73b0"));
            }
            strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$smysqldump.exe -h %7$s  %3$s  -u %4$s -p%5$s --add-drop-table --set-gtid-purged=OFF --default-character-set=utf8|%1$s%2$ssed%2$ssed.exe -e \"s/DEFINER[ ]*=[ ]*[^*]*\\*/\\*/\" > \"%8$s\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)psSysModelInst.getDBName(), (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName(), (Object)psDBServer.getIPAddr(), (Object)strBackupFile);
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
            file = new File(strNasFile);
            if (!file.exists() || file.length() == 0L) {
                throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u5b58\u653e\u5230NAS");
            }
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get(psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
                psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSys2.setActionOwner(null);
                psDevSlnSys2.setCurAction("NONE");
                psDevSlnSysService.sysUpdate(psDevSlnSys2, false);
            }
            psDevSlnSysDepInst2.reset();
            psDevSlnSysDepInst2.setPSDevSlnSysDepInstId(this.getTaskParam2());
            psDevSlnSysDepInst2.setDepInstState(DevSysStateCodeListModel.ONLINE);
            psDevSlnSysDepInst2.setEndBackupTime(DateHelper.getCurTime());
            psDevSlnSysDepInst2.setBackupState(DBInstBStateCodeListModel.CREATED);
            psDevSlnSysDepInst2.setBackupFilePath(strNasFile2);
            psDevSlnSysDepInst2.setBackupSize(Integer.valueOf((int)file.length()));
            psDevSlnSysDepInstService.sysUpdate(psDevSlnSysDepInst2, false);
            return "\u521b\u5efa\u6210\u529f";
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf\u90e8\u7f72\u5b9e\u4f8b[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getTaskParam(), (Object)ex.getMessage()), (Throwable)ex);
            try {
                psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSysService.get(psDevSlnSys);
                if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                    PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
                    psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                    psDevSlnSys2.setActionOwner(null);
                    psDevSlnSys2.setCurAction("NONE");
                    psDevSlnSysService.sysUpdate(psDevSlnSys2, false);
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            try {
                psDevSlnSysDepInst2.reset();
                psDevSlnSysDepInst2.setPSDevSlnSysDepInstId(this.getTaskParam2());
                psDevSlnSysDepInst2.setDepInstState(DevSysStateCodeListModel.CREATEFAILED);
                if (bBackupFlag) {
                    psDevSlnSysDepInst2.setEndBackupTime(DateHelper.getCurTime());
                    psDevSlnSysDepInst2.setBackupState(DBInstBStateCodeListModel.FAILED);
                }
                psDevSlnSysDepInstService.sysUpdate(psDevSlnSysDepInst2, false);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }
}
