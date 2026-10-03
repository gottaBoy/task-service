/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DevCenter.PSSysRunSessionDCBKTaskImplBase
 *  SA.SRFDA.PS.Core.PSTaskServerEnvImpl
 *  SA.SRFDA.PS.Core.Util.SSHCmd
 *  SA.SRFDA.PS.Core.Workspace.IPSWorkspace
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.Version
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.config.entity.PSSysModelVer
 *  net.ibizsys.pscore.srv.config.service.PSSysModelVerService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.PSSysRunSessionDCBKTaskImplBase;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Util.SSHCmd;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspace;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.Version;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSSysModelVer;
import net.ibizsys.pscore.srv.config.service.PSSysModelVerService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class DevSlnSysPSDCBKTaskImplBase
extends PSSysRunSessionDCBKTaskImplBase {
    private static final Log log = LogFactory.getLog(DevSlnSysPSDCBKTaskImplBase.class);

    protected void runCreateMySQLDBCmd(PSDBServer psDBServer, PSSysModelInst psSysModelInst) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)psDBServer.getUserName()) || StringHelper.Compare((String)psDBServer.getUserName(), (String)"#", (boolean)true) == 0) {
            String strToolFolder = PSTaskServerEnvImpl.getCurrent().getToolFolder();
            String strCmd = StringHelper.Format((String)"mysql.exe -h %4$s -u%1$s -p%2$s -e \"create database %3$s DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci\"", (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName(), (Object)psDBServer.getIPAddr());
            String strRet = this.runBat(strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$s%3$s", (Object)strToolFolder, (Object)File.separator, (Object)strCmd), true);
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            strCmd = StringHelper.Format((String)"mysql.exe -h %5$s -u%1$s -p%2$s -e \"CREATE USER '%3$s'@'%%' IDENTIFIED BY '%4$s'\"", (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName(), (Object)psSysModelInst.getPassWD(), (Object)psDBServer.getIPAddr());
            strRet = this.runBat(strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$s%3$s", (Object)strToolFolder, (Object)File.separator, (Object)strCmd), true);
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            strCmd = StringHelper.Format((String)"mysql.exe -h %4$s -u%1$s -p%2$s -e \"GRANT ALL PRIVILEGES ON %3$s.* TO '%3$s'@'%%' WITH GRANT OPTION\"", (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName(), (Object)psDBServer.getIPAddr());
            strRet = this.runBat(strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$s%3$s", (Object)strToolFolder, (Object)File.separator, (Object)strCmd), true);
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
        } else {
            String strCmd = StringHelper.Format((String)"mysql -u%1$s -p%2$s -e \"create database %3$s DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci\"", (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName());
            String strRet = SSHCmd.runRemoteScript2((String)psDBServer.getIPAddr(), (int)22, (String)psDBServer.getUserName(), (String)psDBServer.getPasswd(), (String)strCmd);
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            strCmd = StringHelper.Format((String)"mysql -u%1$s -p%2$s -e \"CREATE USER '%3$s'@'%%' IDENTIFIED BY '%4$s'\"", (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName(), (Object)psSysModelInst.getPassWD());
            strRet = SSHCmd.runRemoteScript2((String)psDBServer.getIPAddr(), (int)22, (String)psDBServer.getUserName(), (String)psDBServer.getPasswd(), (String)strCmd);
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            strCmd = StringHelper.Format((String)"mysql -u%1$s -p%2$s -e \"GRANT ALL PRIVILEGES ON %3$s.* TO '%3$s'@'%%' WITH GRANT OPTION\"", (Object)psDBServer.getDBUserName(), (Object)psDBServer.getDBPasswd(), (Object)psSysModelInst.getDBName());
            strRet = SSHCmd.runRemoteScript2((String)psDBServer.getIPAddr(), (int)22, (String)psDBServer.getUserName(), (String)psDBServer.getPasswd(), (String)strCmd);
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
        }
    }

    protected void updatePSSysModelInstVer(PSDevSlnSys psDevSlnSys) throws Exception {
        this.updatePSSysModelInstVer(psDevSlnSys, -1, -1);
    }

    protected void updatePSSysModelInstVer(PSDevSlnSys psDevSlnSys, int nCurVersion) throws Exception {
        this.updatePSSysModelInstVer(psDevSlnSys, nCurVersion, -1);
    }

    protected void updatePSSysModelInstVer(PSDevSlnSys psDevSlnSys, int nCurVersion, int nTargetVer) throws Exception {
        PSSysModelInstService psSysModelInstService;
        PSSysModelVer psSysModelVer;
        PSSysModelInst psSysModelInst;
        block25: {
            psSysModelInst = psDevSlnSys.getPSSysModelInst();
            if (nCurVersion == -1) {
                nCurVersion = psDevSlnSys.getModelInstVer();
            }
            if (nTargetVer == -1) {
                nTargetVer = Version.MODEL;
            }
            psSysModelVer = new PSSysModelVer();
            PSSysModelVerService psSysModelVerService = (PSSysModelVerService)ServiceGlobal.getService(PSSysModelVerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psSysModelVer.setDBType(psSysModelInst.getDBType());
            psSysModelVer.setSysType("DEVSYS");
            psSysModelVer.setModelVer(Integer.valueOf(nTargetVer));
            if (!psSysModelVerService.select(psSysModelVer, true)) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u5e93\u6a21\u578b\u7248\u672c[%1$s]", (Object)nTargetVer));
            }
            int nCurModelVer = DataObject.getIntegerValue((Object)nCurVersion, (Integer)psSysModelInst.getModelVer());
            if (nCurModelVer >= psSysModelVer.getModelVer()) {
                this.sendStudioConsole(null, "WARN", StringHelper.Format((String)"\u6a21\u578b\u4ed3\u5e93\u5f53\u524d\u7248\u672c[%1$s]\uff0c\u76ee\u6807\u7248\u672c[%2$s]\uff0c\u5ffd\u7565\u5347\u7ea7", (Object)nCurModelVer, (Object)psSysModelVer.getModelVer()));
                return;
            }
            this.sendStudioConsole(null, "INFO", StringHelper.Format((String)"\u6a21\u578b\u4ed3\u5e93\u5f53\u524d\u7248\u672c[%1$s]\uff0c\u76ee\u6807\u7248\u672c[%2$s]\uff0c\u5f00\u59cb\u5347\u7ea7", (Object)nCurModelVer, (Object)psSysModelVer.getModelVer()));
            DevSlnSysPSDCBKTaskImplBase.fillPSSysModelVer(this.getDAGlobalHelper(), psSysModelVer);
            PSSysModelVer curPSSysModelVer = new PSSysModelVer();
            curPSSysModelVer.setDBType(psSysModelInst.getDBType());
            curPSSysModelVer.setModelVer(Integer.valueOf(nCurModelVer));
            curPSSysModelVer.setSysType("DEVSYS");
            if (!psSysModelVerService.select(curPSSysModelVer, true)) {
                log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b\u7248\u672c[%1$s][%2$s]", (Object)psSysModelInst.getDBType(), (Object)nCurModelVer));
                curPSSysModelVer = null;
            }
            if (curPSSysModelVer != null) {
                DevSlnSysPSDCBKTaskImplBase.fillPSSysModelVer(this.getDAGlobalHelper(), curPSSysModelVer);
            }
            HashMap<String, String> lastSqlMap = new HashMap<String, String>();
            if (curPSSysModelVer != null) {
                ArrayList<String> modelList = new ArrayList<String>();
                if (!StringHelper.IsNullOrEmpty((String)curPSSysModelVer.getModelSql())) {
                    modelList.add(curPSSysModelVer.getModelSql());
                }
                if (!StringHelper.IsNullOrEmpty((String)curPSSysModelVer.getModelSql2())) {
                    modelList.add(curPSSysModelVer.getModelSql2());
                }
                if (!StringHelper.IsNullOrEmpty((String)curPSSysModelVer.getModelSql3())) {
                    modelList.add(curPSSysModelVer.getModelSql3());
                }
                for (String strModel : modelList) {
                    String[] sqls;
                    strModel = strModel.replace("\r\n", "\n");
                    String[] stringArray = sqls = StringHelper.Split((String)strModel, (String)"/**\u5206\u5272\u7ebf**/");
                    int n = sqls.length;
                    int n2 = 0;
                    while (n2 < n) {
                        String strSql = stringArray[n2];
                        if (!StringHelper.IsNullOrEmpty((String)(strSql = strSql.trim()))) {
                            lastSqlMap.put(strSql, "");
                        }
                        ++n2;
                    }
                }
            }
            try {
                SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psSysModelInst.getPSSysModelInstId());
                PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
                ArrayList<String> modelList2 = new ArrayList<String>();
                ArrayList<String> modelList = new ArrayList<String>();
                if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getModelSql())) {
                    modelList.add(psSysModelVer.getModelSql());
                }
                if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getModelSql2())) {
                    modelList.add(psSysModelVer.getModelSql2());
                }
                if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getModelSql3())) {
                    modelList.add(psSysModelVer.getModelSql3());
                }
                if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getModelSql4())) {
                    modelList.add(psSysModelVer.getModelSql4());
                }
                for (String strModel : modelList) {
                    String[] sqls;
                    strModel = strModel.replace("\r\n", "\n");
                    String[] stringArray = sqls = StringHelper.Split((String)strModel, (String)"/**\u5206\u5272\u7ebf**/");
                    int n = sqls.length;
                    int n3 = 0;
                    while (n3 < n) {
                        String strSql = stringArray[n3];
                        if (!StringHelper.IsNullOrEmpty((String)(strSql = strSql.trim())) && !lastSqlMap.containsKey(strSql)) {
                            modelList2.add(strSql);
                        }
                        ++n3;
                    }
                }
                long nLastTime = 0L;
                int nIndex = 0;
                int nTotalSize = modelList2.size();
                if (nTotalSize <= 0) break block25;
                for (String strSql : modelList2) {
                    PSSysModelInstGlobal.active((String)psSysModelInst.getPSSysModelInstId());
                    log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u6a21\u578b\u4ee3\u7801[%1$s/%2$s]", (Object)(++nIndex), (Object)nTotalSize));
                    try {
                        psSystemService.executeRaw(strSql, null);
                    }
                    catch (Exception ex) {
                        log.error((Object)StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u5f02\u5e38\uff1a%1$s\r\n%2$s", (Object)ex.getMessage(), (Object)strSql));
                    }
                    if (System.currentTimeMillis() - nLastTime <= 5000L) continue;
                    int nPercent = nIndex * 100 / nTotalSize;
                    this.sendStudioConsole(null, "INFO", StringHelper.Format((String)"\u6a21\u578b\u4ed3\u5e93\u5347\u7ea7\u8fdb\u5ea6[%1$02d%%]", (Object)nPercent));
                    nLastTime = System.currentTimeMillis();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
                throw ex;
            }
        }
        PSSysModelInst psSysModelInst3 = new PSSysModelInst();
        psSysModelInst3.setPSSysModelInstId(psSysModelInst.getPSSysModelInstId());
        psSysModelInst3.setModelVer(psSysModelVer.getModelVer());
        psSysModelInstService.update(psSysModelInst3, false);
        this.sendStudioConsole(null, "INFO", StringHelper.Format((String)"\u6a21\u578b\u4ed3\u5e93\u5f53\u524d\u7248\u672c[%1$s]\uff0c\u5347\u7ea7\u5b8c\u6210", (Object)psSysModelVer.getModelVer()));
    }

    public static void fillPSSysModelVer(ISRFDAGlobalHelper iDAGlobalHelper, PSSysModelVer psSysModelVer) throws Exception {
        if (StringHelper.Compare((String)psSysModelVer.getModelSql(), (String)"/*FROMFILE*/", (boolean)true) != 0) {
            return;
        }
        String strSysModelFolder = iDAGlobalHelper.getWebExConfig().GetValue("SRFPS", "SYSMODELFOLDER", null);
        strSysModelFolder = String.valueOf(strSysModelFolder) + StringHelper.Format((String)"%1$s%2$s%1$s", (Object)File.separator, (Object)psSysModelVer.getModelVer());
        psSysModelVer.setModelSql(DevSlnSysPSDCBKTaskImplBase.readFile(String.valueOf(strSysModelFolder) + "1.sql"));
        psSysModelVer.setModelSql2(DevSlnSysPSDCBKTaskImplBase.readFile(String.valueOf(strSysModelFolder) + "2.sql"));
        psSysModelVer.setModelSql3(DevSlnSysPSDCBKTaskImplBase.readFile(String.valueOf(strSysModelFolder) + "3.sql"));
        psSysModelVer.setModelSql4(DevSlnSysPSDCBKTaskImplBase.readFile(String.valueOf(strSysModelFolder) + "4.sql"));
    }

    static String readFile(String strFilePath) throws Exception {
        StringBuffer sb;
        String strError;
        block16: {
            strError = null;
            sb = new StringBuffer();
            InputStreamReader reader = null;
            try {
                try {
                    int nLength;
                    FileInputStream fis = new FileInputStream(strFilePath);
                    reader = new InputStreamReader((InputStream)fis, "UTF-8");
                    char[] buf = new char[4096];
                    while ((nLength = reader.read(buf)) != -1) {
                        sb.append(new String(buf, 0, nLength));
                    }
                }
                catch (Exception e) {
                    log.error((Object)e);
                    strError = e.toString();
                    if (reader != null) {
                        try {
                            reader.close();
                        }
                        catch (IOException e1) {
                            strError = e1.toString();
                        }
                    }
                    break block16;
                }
            }
            catch (Throwable throwable) {
                if (reader != null) {
                    try {
                        reader.close();
                    }
                    catch (IOException e1) {
                        strError = e1.toString();
                    }
                }
                throw throwable;
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e1) {
                    strError = e1.toString();
                }
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strError)) {
            throw new Exception(strError);
        }
        return sb.toString();
    }

    protected void sendStateChangedConsole(PSDevSlnSys psDevSlnSys, int nCurState) throws Exception {
        if (nCurState == 30) {
            this.sendStudioConsole(null, "INFO", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u8fdb\u5165\u72b6\u6001[%2$s]\uff0c\u7cfb\u7edf\u6062\u590d\u6b63\u5e38\u8bbf\u95ee\uff0c\u8bf7\u5173\u95ed\u5f53\u524d\u5de5\u5177\u540e\u91cd\u65b0\u8fdb\u5165", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeListText(String.format("%1$s", nCurState), true)));
        } else {
            this.sendStudioConsole(null, "WARN", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u8fdb\u5165\u72b6\u6001[%2$s]\uff0c\u7cfb\u7edf\u6682\u505c\u5916\u90e8\u4f7f\u7528", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeListText(String.format("%1$s", nCurState), true)));
        }
    }

    protected IPSWorkspace getPSWorkspace(PSDevSlnSys psDevSlnSys) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getPSDCWorkspaceId())) {
            try {
                return this.getPSModelStorage().getPSDCWorkspace(psDevSlnSys.getPSDCWorkspaceId());
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u7ed1\u5b9a\u751f\u4ea7\u7ebf\u5f02\u5e38\uff0c%2$s", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)ex.getMessage()));
            }
        }
        return null;
    }

    protected File backupPSDevSlnSysModel(PSDevSlnSys psDevSlnSys, String strNasFile, String strNasFile2) throws Exception {
        String strCmd;
        String strBackupFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
        String strFolder = StringHelper.Format((String)"%1$sMODEL2", (Object)strBackupFolder);
        String strBackupZipFile = StringHelper.Format((String)"%1$sMODEL2.7z", (Object)strBackupFolder);
        PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
        psModelV2Helper.init(null, psDevSlnSys.getPSSysModelInstId());
        File folder = new File(strFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        psModelV2Helper.backup(strFolder);
        if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
            strCmd = StringHelper.Format((String)"7za a %3$s %4$s%2$s*", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupZipFile, (Object)strFolder);
            this.runBat(strCmd, true);
            File file = new File(strBackupZipFile);
            if (!file.exists() || file.length() == 0L) {
                throw new Exception("\u5907\u4efd\u5931\u8d25\uff0c\u65e0\u6cd5\u751f\u6210\u538b\u7f29\u6587\u4ef6");
            }
            strCmd = StringHelper.Format((String)"cp -rf %1$s %2$s", (Object)strBackupZipFile, (Object)strNasFile);
            this.runBat(strCmd, true);
        } else {
            strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$s7-Zip%2$s7z.exe a \"%3$s\" \"%4$s%2$s*\"", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strBackupZipFile, (Object)strFolder);
            this.runBat(strCmd, true);
            File file = new File(strBackupZipFile);
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
        return file;
    }
}
