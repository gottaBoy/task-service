/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.Version
 *  net.ibizsys.pscore.srv.config.entity.PSSysModelVer
 *  net.ibizsys.pscore.srv.config.service.PSSysModelVerService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.Web.Utility.GlobalHelperEx;
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
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.Version;
import net.ibizsys.pscore.srv.config.entity.PSSysModelVer;
import net.ibizsys.pscore.srv.config.service.PSSysModelVerService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysModelInstHelper {
    public static int MODELVER_NEW = -2;
    public static int MODELVER_NEW_NOFK = -3;
    public static int MODELVER_NEW_NOFK_NOVIEW = -4;
    private static final Log log = LogFactory.getLog(PSSysModelInstHelper.class);

    public static PSSysModelInst updateVersion(String strPSSysModelInstId, int nCurVersion) throws Exception {
        return PSSysModelInstHelper.updateVersion(strPSSysModelInstId, nCurVersion, -1);
    }

    public static PSSysModelInst updateVersion(String strPSSysModelInstId, int nCurVersion, int nTargetVer) throws Exception {
        PSSysModelInstService psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSysModelInst psSysModelInst = new PSSysModelInst();
        psSysModelInst.setPSSysModelInstId(strPSSysModelInstId);
        psSysModelInstService.get(psSysModelInst);
        if (nTargetVer == -1) {
            nTargetVer = Version.MODEL;
        }
        ISRFDAGlobalHelper iSRFDAGlobalHelper = GlobalHelperEx.getInstance();
        PSSysModelVer psSysModelVer = new PSSysModelVer();
        PSSysModelVerService psSysModelVerService = (PSSysModelVerService)ServiceGlobal.getService(PSSysModelVerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psSysModelVer.setDBType(psSysModelInst.getDBType());
        psSysModelVer.setSysType("DEVSYS");
        psSysModelVer.setModelVer(Integer.valueOf(nTargetVer));
        if (!psSysModelVerService.select(psSysModelVer, true)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u5e93\u6a21\u578b\u7248\u672c"));
        }
        int nCurModelVer = nCurVersion;
        boolean bNewMode = false;
        boolean bNoFK = false;
        boolean bNoView = false;
        if (nCurVersion == -2 || nCurVersion == -3 || nCurVersion == -4) {
            bNewMode = true;
            if (nCurVersion == -3) {
                bNoFK = true;
            }
            if (nCurVersion == -4) {
                bNoFK = true;
                bNoView = true;
            }
        } else {
            if (nCurModelVer <= 0) {
                nCurModelVer = psSysModelInst.getModelVer();
            }
            if (nCurModelVer == psSysModelVer.getModelVer()) {
                return psSysModelInst;
            }
        }
        PSSysModelInstHelper.fillPSSysModelVer(iSRFDAGlobalHelper, psSysModelVer);
        PSSysModelVer curPSSysModelVer = null;
        if (!bNewMode) {
            curPSSysModelVer = new PSSysModelVer();
            curPSSysModelVer.setDBType(psSysModelInst.getDBType());
            curPSSysModelVer.setModelVer(Integer.valueOf(nCurModelVer));
            curPSSysModelVer.setSysType("DEVSYS");
            if (!psSysModelVerService.select(curPSSysModelVer, true)) {
                log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b\u7248\u672c[%1$s][%2$s]", (Object)psSysModelInst.getDBType(), (Object)nCurModelVer));
                curPSSysModelVer = null;
            }
            if (curPSSysModelVer != null) {
                PSSysModelInstHelper.fillPSSysModelVer(iSRFDAGlobalHelper, curPSSysModelVer);
            }
        }
        HashMap<Object, String> lastSqlMap = null;
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
            lastSqlMap = new HashMap<Object, String>();
            for (String strModel : modelList) {
                strModel = strModel.replace("\r\n", "\n");
                String[] sqls = StringHelper.Split((String)strModel, (String)"/**\u5206\u5272\u7ebf**/");
                String[] stringArray = sqls;
                int n = sqls.length;
                int n2 = 0;
                while (n2 < n) {
                    Object strSql = stringArray[n2];
                    if (!StringHelper.IsNullOrEmpty((String)(strSql = ((String)strSql).trim()))) {
                        lastSqlMap.put(strSql, "");
                    }
                    ++n2;
                }
            }
        }
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psSysModelInst.getPSSysModelInstId());
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        ArrayList<String> modelList2 = new ArrayList<String>();
        ArrayList<String> modelList = new ArrayList<String>();
        if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getModelSql())) {
            modelList.add(psSysModelVer.getModelSql());
        }
        if (lastSqlMap != null && !StringHelper.IsNullOrEmpty((String)psSysModelVer.getModelSql2())) {
            modelList.add(psSysModelVer.getModelSql2());
        }
        if (!bNoFK && !StringHelper.IsNullOrEmpty((String)psSysModelVer.getModelSql3())) {
            modelList.add(psSysModelVer.getModelSql3());
        }
        if (!bNoView && !StringHelper.IsNullOrEmpty((String)psSysModelVer.getModelSql4())) {
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
                if (!(StringHelper.IsNullOrEmpty((String)(strSql = strSql.trim())) || lastSqlMap != null && lastSqlMap.containsKey(strSql) || bNewMode && strSql.indexOf("DROP VIEW") == 0)) {
                    modelList2.add(strSql);
                }
                ++n3;
            }
        }
        int nIndex = 0;
        int nTotalSize = modelList2.size();
        for (String strSql : modelList2) {
            PSSysModelInstGlobal.active((String)psSysModelInst.getPSSysModelInstId());
            log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u6a21\u578b\u4ee3\u7801[%1$s/%2$s]", (Object)(++nIndex), (Object)nTotalSize));
            try {
                psSystemService.executeRaw(strSql, null);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u5f02\u5e38\uff1a%1$s\r\n%2$s", (Object)ex.getMessage(), (Object)strSql));
            }
        }
        PSSysModelInst psSysModelInst3 = new PSSysModelInst();
        psSysModelInst3.setPSSysModelInstId(psSysModelInst.getPSSysModelInstId());
        psSysModelInst3.setModelVer(psSysModelVer.getModelVer());
        psSysModelInstService.sysUpdate(psSysModelInst3, false);
        return psSysModelInst3;
    }

    public static void fillPSSysModelVer(ISRFDAGlobalHelper iDAGlobalHelper, PSSysModelVer psSysModelVer) throws Exception {
        if (StringHelper.Compare((String)psSysModelVer.getModelSql(), (String)"/*FROMFILE*/", (boolean)true) != 0) {
            return;
        }
        String strSysModelFolder = iDAGlobalHelper.getWebExConfig().GetValue("SRFPS", "SYSMODELFOLDER", null);
        strSysModelFolder = String.valueOf(strSysModelFolder) + StringHelper.Format((String)"%1$s%2$s%1$s", (Object)File.separator, (Object)psSysModelVer.getModelVer());
        psSysModelVer.setModelSql(PSSysModelInstHelper.readFile(String.valueOf(strSysModelFolder) + "1.sql"));
        psSysModelVer.setModelSql2(PSSysModelInstHelper.readFile(String.valueOf(strSysModelFolder) + "2.sql"));
        psSysModelVer.setModelSql3(PSSysModelInstHelper.readFile(String.valueOf(strSysModelFolder) + "3.sql"));
        psSysModelVer.setModelSql4(PSSysModelInstHelper.readFile(String.valueOf(strSysModelFolder) + "4.sql"));
    }

    public static String readFile(String strFilePath) throws Exception {
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
                    e.printStackTrace();
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

    public static PSSysModelInst online(String strPSSysModelInstId) throws Exception {
        PSSysModelInstService psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSysModelInst psSysModelInst = new PSSysModelInst();
        psSysModelInst.setPSSysModelInstId(strPSSysModelInstId);
        if (!psSysModelInstService.get(psSysModelInst, true)) {
            throw new Exception(StringHelper.Format((String)"\u6a21\u578b\u4ed3\u5e93[%1$s]\u4e0d\u5b58\u5728", (Object)strPSSysModelInstId));
        }
        boolean bBackupMode = DataObject.getBoolValue((Integer)psSysModelInst.getParam5(), (boolean)false);
        if (!bBackupMode && StringHelper.Compare((String)psSysModelInst.getInstState(), (String)"35", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u6a21\u578b\u4ed3\u5e93[%1$s]\u672a\u5904\u4e8e\u79bb\u7ebf\u72b6\u6001", (Object)psSysModelInst.getPSSysModelInstName()));
        }
        PSSysModelInstHelper.createDatabase(psSysModelInst);
        PSSysModelInstHelper.updateVersion(psSysModelInst.getPSSysModelInstId(), bBackupMode ? MODELVER_NEW_NOFK_NOVIEW : MODELVER_NEW_NOFK);
        psSysModelInst.reset();
        psSysModelInst.setPSSysModelInstId(strPSSysModelInstId);
        psSysModelInst.setInstState("30");
        psSysModelInstService.sysUpdate(psSysModelInst, true);
        return psSysModelInst;
    }

    private static void createDatabase(PSSysModelInst psSysModelInst) throws Exception {
        String strSQL;
        SessionFactory sessionFactory = PSSysModelInstGlobal.getDBServerSessionFactory((String)psSysModelInst.getPSDBServerId());
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        try {
            strSQL = StringHelper.Format((String)"DROP DATABASE IF EXISTS %1$s;", (Object)psSysModelInst.getDBName());
            psSystemService.executeRaw(strSQL, null);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            throw new Exception("\u79fb\u9664\u6a21\u578b\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38");
        }
        try {
            strSQL = StringHelper.Format((String)"CREATE DATABASE  %1$s DEFAULT CHARSET utf8 COLLATE utf8_general_ci;", (Object)psSysModelInst.getDBName());
            psSystemService.executeRaw(strSQL, null);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            throw new Exception("\u5efa\u7acb\u6a21\u578b\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38");
        }
        if (StringHelper.Compare((String)psSysModelInst.getUserName(), (String)"root", (boolean)true) != 0) {
            try {
                strSQL = StringHelper.Format((String)"CREATE USER '%1$s'@'localhost' IDENTIFIED BY '%2$s';", (Object)psSysModelInst.getUserName(), (Object)psSysModelInst.getPassWD());
                psSystemService.executeRaw(strSQL, null);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            try {
                strSQL = StringHelper.Format((String)"CREATE USER '%1$s'@'%%' IDENTIFIED BY '%2$s';", (Object)psSysModelInst.getUserName(), (Object)psSysModelInst.getPassWD());
                psSystemService.executeRaw(strSQL, null);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            try {
                strSQL = StringHelper.Format((String)"GRANT ALL PRIVILEGES ON `%3$s`.* to '%1$s'@'%%';", (Object)psSysModelInst.getUserName(), (Object)psSysModelInst.getPassWD(), (Object)psSysModelInst.getDBName());
                psSystemService.executeRaw(strSQL, null);
            }
            catch (Exception ex) {
                log.error((Object)ex);
                throw new Exception("\u5efa\u7acb\u6a21\u578b\u4ed3\u5e93\u7528\u6237\u6743\u9650\u53d1\u751f\u5f02\u5e38");
            }
            try {
                strSQL = StringHelper.Format((String)"GRANT ALL PRIVILEGES ON `%3$s`.* to '%1$s'@'localhost';", (Object)psSysModelInst.getUserName(), (Object)psSysModelInst.getPassWD(), (Object)psSysModelInst.getDBName());
                psSystemService.executeRaw(strSQL, null);
            }
            catch (Exception ex) {
                log.error((Object)ex);
                throw new Exception("\u5efa\u7acb\u6a21\u578b\u4ed3\u5e93\u7528\u6237\u6743\u9650\u53d1\u751f\u5f02\u5e38");
            }
            try {
                strSQL = StringHelper.Format((String)"FLUSH PRIVILEGES;");
                psSystemService.executeRaw(strSQL, null);
            }
            catch (Exception ex) {
                log.error((Object)ex);
                throw new Exception("\u5237\u65b0\u6a21\u578b\u4ed3\u5e93\u7528\u6237\u6743\u9650\u53d1\u751f\u5f02\u5e38");
            }
        }
    }

    public static PSSysModelInst offline(String strPSSysModelInstId) throws Exception {
        PSSysModelInstService psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSysModelInst psSysModelInst = new PSSysModelInst();
        psSysModelInst.setPSSysModelInstId(strPSSysModelInstId);
        if (psSysModelInstService.get(psSysModelInst, true)) {
            PSSysModelInstHelper.dropDatabase(psSysModelInst);
            psSysModelInst.reset();
            psSysModelInst.setPSSysModelInstId(strPSSysModelInstId);
            psSysModelInst.setInstState("35");
            psSysModelInstService.sysUpdate(psSysModelInst, true);
        }
        return psSysModelInst;
    }

    private static void dropDatabase(PSSysModelInst psSysModelInst) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getDBServerSessionFactory((String)psSysModelInst.getPSDBServerId());
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        try {
            String strSQL = StringHelper.Format((String)"DROP DATABASE IF EXISTS %1$s;", (Object)psSysModelInst.getDBName());
            psSystemService.executeRaw(strSQL, null);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            throw new Exception("\u79fb\u9664\u6a21\u578b\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38");
        }
    }
}
