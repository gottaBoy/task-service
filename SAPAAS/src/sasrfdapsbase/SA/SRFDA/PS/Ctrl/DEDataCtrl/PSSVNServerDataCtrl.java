/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  com.trilead.ssh2.Connection
 *  com.trilead.ssh2.SCPClient
 *  com.trilead.ssh2.Session
 *  com.trilead.ssh2.StreamGobbler
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.Util.SSHCmd;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSVNInstRepo;
import SA.SRFDA.PS.Data.PSSvrDomain;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.SCPClient;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSVNServerDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSVNServerDataCtrl.class);
    private static final Object objLock = new Object();
    public static final String CUSTOMCALL_INITREP = "INITREP";
    public static final String CUSTOMCALL_INITREP2 = "INITREP2";
    public static final String CUSTOMCALL_UPDATEAUTHZ = "UPDATEAUTHZ";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITREP, (boolean)true) == 0) {
            return this.initRep(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITREP2, (boolean)true) == 0) {
            return this.initRep2(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_UPDATEAUTHZ, (boolean)true) == 0) {
            return this.updateAuthz(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initRep(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSSVNServer psSVNServer = new SA.SRFDA.PS.Data.PSSVNServer();
            psSVNServer.proxy(dataEntity);
            this.onInitRep(psSVNServer, false);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316SVN\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult initRep2(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSSVNServer psSVNServer = new SA.SRFDA.PS.Data.PSSVNServer();
            psSVNServer.proxy(dataEntity);
            this.onInitRep(psSVNServer, true);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316SVN\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitRep(SA.SRFDA.PS.Data.PSSVNServer psSVNServer, boolean bReadOnly) throws Exception {
        String strDomainCode = this.getDomainCode(psSVNServer);
        if (!StringHelper.IsNullOrEmpty((String)strDomainCode)) {
            strDomainCode = String.valueOf(strDomainCode) + "_";
        }
        IDEDataCtrl psSVNInstRepoDataCtrl = this.GetRelatedDataCtrl("DE1904");
        int nCount = 10;
        while (nCount > 0) {
            PSSVNInstRepo psSVNInstRepo = new PSSVNInstRepo();
            String strSVNName = "";
            strSVNName = bReadOnly ? "r_" + strDomainCode + Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 8) : String.valueOf(strDomainCode) + Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 10);
            psSVNInstRepo.setPSSVNSERVERID(psSVNServer.getPSSVNSERVERID());
            psSVNInstRepo.setPSSVNSERVERNAME(psSVNServer.getPSSVNSERVERNAME());
            psSVNInstRepo.setPSSVRDOMAINID(psSVNServer.getPSSVRDOMAINID());
            psSVNInstRepo.setPSSVRDOMAINNAME(psSVNServer.getPSSVRDOMAINNAME());
            psSVNInstRepo.setREPOSTATE(20);
            psSVNInstRepo.setREADONLYMODE(bReadOnly);
            psSVNInstRepo.setPSSVNINSTREPONAME(strSVNName);
            psSVNInstRepo.setCONNSTR(StringHelper.Format((String)"%1$s%2$s", (Object)psSVNServer.getSVNURL(), (Object)strSVNName));
            CallResult callResult = psSVNInstRepoDataCtrl.Save(true, (BaseDataEntity)psSVNInstRepo);
            if (callResult.isError()) {
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)7)) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7248\u672c\u4ed3\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            String strCmd = StringHelper.Format((String)"svnadmin create %1$s%2$s", (Object)psSVNServer.getSVNROOT(), (Object)strSVNName);
            SSHCmd.runRemoteScript(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strCmd);
            strCmd = StringHelper.Format((String)"chmod  777 -R %1$s%2$s/hooks", (Object)psSVNServer.getSVNROOT(), (Object)strSVNName);
            SSHCmd.runRemoteScript(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strCmd);
            strCmd = StringHelper.Format((String)"chmod  777 -R %1$s%2$s/db", (Object)psSVNServer.getSVNROOT(), (Object)strSVNName);
            SSHCmd.runRemoteScript(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strCmd);
            if (!StringHelper.IsNullOrEmpty((String)psSVNServer.getSLAVEIPADDR())) {
                String strSlaveSVNName = strSVNName;
                if (StringHelper.Compare((String)psSVNServer.getIPADDR(), (String)psSVNServer.getSLAVEIPADDR(), (boolean)true) == 0) {
                    strSlaveSVNName = String.valueOf(strSlaveSVNName) + "_back";
                }
                strCmd = StringHelper.Format((String)"svnadmin create %1$s%2$s", (Object)psSVNServer.getSLAVESVNROOT(), (Object)strSlaveSVNName);
                SSHCmd.runRemoteScript(psSVNServer.getSLAVEIPADDR(), 22, psSVNServer.getSLAVEUSERNAME(), psSVNServer.getSLAVEPASSWD(), strCmd);
                if (!bReadOnly) {
                    String strPreRevpropChangeFile = this.createPreRevpropChangeFile();
                    PSSVNServerDataCtrl.putFileToRemote(psSVNServer.getSLAVEIPADDR(), 22, psSVNServer.getSLAVEUSERNAME(), psSVNServer.getSLAVEPASSWD(), strPreRevpropChangeFile, String.valueOf(psSVNServer.getSLAVESVNROOT()) + strSlaveSVNName + "/hooks/");
                    File file = new File(strPreRevpropChangeFile);
                    strCmd = StringHelper.Format((String)"cp -f %1$s%2$s/hooks/%3$s %1$s%2$s/hooks/pre-revprop-change", (Object)psSVNServer.getSLAVESVNROOT(), (Object)strSlaveSVNName, (Object)file.getName());
                    PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getSLAVEIPADDR(), 22, psSVNServer.getSLAVEUSERNAME(), psSVNServer.getSLAVEPASSWD(), strCmd);
                    strCmd = StringHelper.Format((String)"rm -f %1$s%2$s/hooks/%3$s", (Object)psSVNServer.getSLAVESVNROOT(), (Object)strSlaveSVNName, (Object)file.getName());
                    PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getSLAVEIPADDR(), 22, psSVNServer.getSLAVEUSERNAME(), psSVNServer.getSLAVEPASSWD(), strCmd);
                    strCmd = StringHelper.Format((String)"chmod  777 -R %1$s%2$s/hooks", (Object)psSVNServer.getSLAVESVNROOT(), (Object)strSlaveSVNName);
                    PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getSLAVEIPADDR(), 22, psSVNServer.getSLAVEUSERNAME(), psSVNServer.getSLAVEPASSWD(), strCmd);
                    strCmd = StringHelper.Format((String)"chmod  777 -R %1$s%2$s/db", (Object)psSVNServer.getSLAVESVNROOT(), (Object)strSlaveSVNName);
                    PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getSLAVEIPADDR(), 22, psSVNServer.getSLAVEUSERNAME(), psSVNServer.getSLAVEPASSWD(), strCmd);
                    strCmd = StringHelper.Format((String)"svnsync init %1$s%2$s %3$s%4$s --non-interactive --source-username %5$s --source-password %6$s --sync-username %7$s --sync-password %8$s", (Object)psSVNServer.getSLAVESVNURL(), (Object)strSlaveSVNName, (Object)psSVNServer.getSVNURL(), (Object)strSVNName, (Object)psSVNServer.getSVNUSERNAME(), (Object)psSVNServer.getSVNPASSWD(), (Object)psSVNServer.getSLAVESVNUSERNAME(), (Object)psSVNServer.getSLAVESVNPASSWD());
                    PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getSLAVEIPADDR(), 22, psSVNServer.getSLAVEUSERNAME(), psSVNServer.getSLAVEPASSWD(), strCmd);
                    String strPostCommitFile = this.createPostCommitFile(psSVNServer, strSlaveSVNName);
                    PSSVNServerDataCtrl.putFileToRemote(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strPostCommitFile, String.valueOf(psSVNServer.getSVNROOT()) + strSVNName + "/hooks/");
                    file = new File(strPostCommitFile);
                    strCmd = StringHelper.Format((String)"cp -f %1$s%2$s/hooks/%3$s %1$s%2$s/hooks/post-commit", (Object)psSVNServer.getSVNROOT(), (Object)strSVNName, (Object)file.getName());
                    PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strCmd);
                    strCmd = StringHelper.Format((String)"rm -f %1$s%2$s/hooks/%3$s", (Object)psSVNServer.getSVNROOT(), (Object)strSVNName, (Object)file.getName());
                    PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strCmd);
                    strCmd = StringHelper.Format((String)"chmod  777 -R %1$s%2$s/hooks", (Object)psSVNServer.getSVNROOT(), (Object)strSVNName, (Object)file.getName());
                    PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strCmd);
                    strCmd = StringHelper.Format((String)"chmod  777 -R %1$s%2$s/db", (Object)psSVNServer.getSVNROOT(), (Object)strSVNName, (Object)file.getName());
                    PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strCmd);
                }
            }
            --nCount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CallResult updateAuthz(BaseDataEntity dataEntity) {
        Object object = objLock;
        synchronized (object) {
            CallResult callResult = this.Get(dataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
            try {
                if (this.getTransactionManager() != null) {
                    this.getTransactionManager().Commit();
                }
                SA.SRFDA.PS.Data.PSSVNServer psSVNServer = new SA.SRFDA.PS.Data.PSSVNServer();
                psSVNServer.proxy(dataEntity);
                this.onUpdateAuthz(psSVNServer);
                return callResult;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0SVN\u4efb\u52a1\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
        }
    }

    protected void onUpdateAuthz(SA.SRFDA.PS.Data.PSSVNServer psSVNServer) throws Exception {
        boolean bReadOnly;
        Iterator strSLNCodeName;
        String strREPOName;
        CallResult callResult;
        String strSQL4;
        TreeMap<String, Boolean> repoMap = new TreeMap<String, Boolean>();
        HashMap<String, ArrayList> svnGroupMap = new HashMap<String, ArrayList>();
        int nCount = 100;
        Vector dataList = new Vector();
        CallParamList callParamList = new CallParamList();
        callParamList.AddString(psSVNServer.getPSSVNSERVERID());
        TreeMap<String, Boolean> repoMap2 = new TreeMap<String, Boolean>();
        int i = 0;
        while (i < 2) {
            strSQL4 = "select t2.*,t2.CODENAME as SLNCODENAME,t4.PSSVNINSTREPONAME,t4.READONLYMODE from t_srfpsdevsln t2 \t\tinner join t_srfpsdevcenter t3 on t3.psdevcenterid=t2.psdevcenterid \t\tinner join T_SRFPSSVNINSTREPO t4 on t4.PSSVNINSTREPOID = " + (i == 0 ? " t3.PSSVNINSTREPOID " : " t3.ROPSSVNINSTREPOID ") + "\t\tinner join t_srfpssvnserver t5 on t5.pssvnserverid = t4.pssvnserverid " + "\t\twhere t2.PSDCWORKSHOPSERVERID IS NOT NULL and t2.VCUSER IS NOT NULL and t5.pssvnserverid = ?";
            dataList.clear();
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (java.sql.Connection)this.getConnection(), (String)"", (String)strSQL4, (Vector)callParamList.GetList(), dataList, (String)"");
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5f00\u53d1\u65b9\u6848\u5de5\u7a0b\u670d\u52a1\u5668\u4ee3\u7801\u7b7e\u5165\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity item : dataList) {
                strREPOName = item.getParamStringValue("PSSVNINSTREPONAME", "");
                strSLNCodeName = item.getParamStringValue("SLNCODENAME", "");
                bReadOnly = false;
                strREPOName = StringHelper.Format((String)"%1$s:/%2$s", (Object)strREPOName, (Object)strSLNCodeName);
                repoMap2.put(strREPOName, bReadOnly);
            }
            ++i;
        }
        i = 0;
        while (i < 2) {
            boolean bReadOnly2;
            String strSQL = "select t1.*,t2.CODENAME as SLNCODENAME,t6.FULLLOGINNAME,t4.PSSVNINSTREPONAME,t4.READONLYMODE,t8.VCTYPE,t8.SYSVER,t8.MAINPSDEVSLNSYSNAME from v_psdevslnuser t1 inner join t_srfpsdevsln t2 on t1.psdevslnid = t2.psdevslnid  inner join t_srfpsdevcenter t3 on t3.psdevcenterid=t2.psdevcenterid  inner join T_SRFPSSVNINSTREPO t4 on t4.PSSVNINSTREPOID = " + (i == 0 ? " t3.PSSVNINSTREPOID " : " t3.ROPSSVNINSTREPOID ") + " INNER JOIN v_psdevuser t6 on t1.psdevuserobjid = t6.psdevuserid " + " inner join t_srfpssvnserver t5 on t5.pssvnserverid = t4.pssvnserverid" + " LEFT JOIN V_PSDEVSLNSYS t8 on t1.PSDEVSLNSYSID = t8.PSDEVSLNSYSID " + " where t6.VALIDFLAG = 1 and t5.pssvnserverid = ?";
            String strSQL2 = "select t1.*,t2.CODENAME as SLNCODENAME,t4.PSSVNINSTREPONAME,t4.READONLYMODE from v_psdevuser t1 \t\tinner join t_srfpsdevsln t2 on t1.PSDEVUSERID = t2.ADMINPSDEVUSERID \t\tinner join t_srfpsdevcenter t3 on t3.psdevcenterid=t2.psdevcenterid \t\tinner join T_SRFPSSVNINSTREPO t4 on t4.PSSVNINSTREPOID = " + (i == 0 ? " t3.PSSVNINSTREPOID " : " t3.ROPSSVNINSTREPOID ") + "\t\tinner join t_srfpssvnserver t5 on t5.pssvnserverid = t4.pssvnserverid " + "\t\twhere t1.VALIDFLAG = 1 and t5.pssvnserverid = ?";
            String strSQL3 = "select t1.*,t4.PSSVNINSTREPONAME,t4.READONLYMODE from v_psdevuser t1  inner join t_srfpsdevcenter t3 on t3.psdevcenterid=t1.psdevcenterid  inner join T_SRFPSSVNINSTREPO t4 on t4.PSSVNINSTREPOID = " + (i == 0 ? " t3.PSSVNINSTREPOID " : " t3.ROPSSVNINSTREPOID ") + " inner join t_srfpssvnserver t5 on t5.pssvnserverid = t4.pssvnserverid" + " where t1.VALIDFLAG = 1 and t1.ADMINMODE = 1 and t5.pssvnserverid = ?";
            CallResult callResult2 = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (java.sql.Connection)this.getConnection(), (String)"", (String)strSQL2, (Vector)callParamList.GetList(), dataList, (String)"");
            if (callResult2.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5f00\u53d1\u65b9\u6848\u7ba1\u7406\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
            for (BaseDataEntity item : dataList) {
                String strREPOName2 = item.getParamStringValue("PSSVNINSTREPONAME", "");
                bReadOnly2 = item.GetParamIntValue("READONLYMODE", 0) != 0;
                String strSLNCodeName2 = item.getParamStringValue("SLNCODENAME", "");
                String strFullLogicName = item.getParamStringValue("FULLLOGINNAME", "");
                if (StringHelper.IsNullOrEmpty((String)strFullLogicName)) continue;
                if (repoMap2.containsKey(strREPOName2 = StringHelper.Format((String)"%1$s:/%2$s", (Object)strREPOName2, (Object)strSLNCodeName2))) {
                    bReadOnly2 = false;
                }
                repoMap.put(strREPOName2, bReadOnly2);
                String strAdminTag = StringHelper.Format((String)(bReadOnly2 ? "u_%1$s" : "a_%1$s"), (Object)strREPOName2);
                ArrayList userList = null;
                if (!svnGroupMap.containsKey(strAdminTag)) {
                    userList = new ArrayList();
                    svnGroupMap.put(strAdminTag, userList);
                } else {
                    userList = (ArrayList)svnGroupMap.get(strAdminTag);
                }
                if (userList.contains(strFullLogicName)) continue;
                userList.add(strFullLogicName);
            }
            dataList.clear();
            callResult2 = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (java.sql.Connection)this.getConnection(), (String)"", (String)strSQL, (Vector)callParamList.GetList(), dataList, (String)"");
            if (callResult2.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5f00\u53d1\u65b9\u6848\u7cfb\u7edf\u7528\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
            for (BaseDataEntity item : dataList) {
                int nAllSysFlag = item.GetParamIntValue("ALLSYSFLAG", 0);
                int nAccMode = item.GetParamIntValue("ACCMODE", 0);
                String strREPOName3 = item.getParamStringValue("PSSVNINSTREPONAME", "");
                boolean bReadOnly3 = item.GetParamIntValue("READONLYMODE", 0) != 0;
                String strSLNCodeName3 = item.getParamStringValue("SLNCODENAME", "");
                String strSysCodeName = item.getParamStringValue("PSDEVSLNSYSNAME", "");
                String strMainSysCodeName = item.getParamStringValue("MAINPSDEVSLNSYSNAME", "");
                String strVCType = item.getParamStringValue("VCTYPE", "");
                String strSysVer = item.getParamStringValue("SYSVER", "");
                String strFullLogicName = item.getParamStringValue("FULLLOGINNAME", "");
                if (StringHelper.IsNullOrEmpty((String)strFullLogicName)) continue;
                String strREPOName2 = StringHelper.Format((String)"%1$s:/%2$s", (Object)strREPOName3, (Object)strSLNCodeName3);
                if (repoMap2.containsKey(strREPOName2)) {
                    bReadOnly3 = false;
                }
                if (nAllSysFlag == 1) {
                    strREPOName3 = StringHelper.Format((String)"%1$s:/%2$s", (Object)strREPOName3, (Object)strSLNCodeName3);
                    repoMap.put(strREPOName3, bReadOnly3);
                } else {
                    if (StringHelper.IsNullOrEmpty((String)strVCType)) {
                        strVCType = "TRUNK";
                    }
                    if (StringHelper.IsNullOrEmpty((String)strMainSysCodeName)) {
                        strMainSysCodeName = strSysCodeName;
                    }
                    if (StringHelper.Compare((String)strVCType, (String)"TRUNK", (boolean)true) == 0) {
                        strREPOName3 = StringHelper.Format((String)"%1$s:/%2$s/%3$s/trunk", (Object)strREPOName3, (Object)strSLNCodeName3, (Object)strMainSysCodeName);
                    } else if (StringHelper.Compare((String)strVCType, (String)"BRANCH", (boolean)true) == 0) {
                        strREPOName3 = StringHelper.Format((String)"%1$s:/%2$s/%3$s/b_%4$s", (Object)strREPOName3, (Object)strSLNCodeName3, (Object)strMainSysCodeName, (Object)strSysVer.toLowerCase());
                    } else if (StringHelper.Compare((String)strVCType, (String)"TAG", (boolean)true) == 0) {
                        strREPOName3 = StringHelper.Format((String)"%1$s:/%2$s/%3$s/t_%4$s", (Object)strREPOName3, (Object)strSLNCodeName3, (Object)strMainSysCodeName, (Object)strSysVer.toLowerCase());
                    }
                    repoMap.put(strREPOName3, bReadOnly3);
                }
                String strAdminTag = "";
                strAdminTag = nAccMode == 3 && !bReadOnly3 ? StringHelper.Format((String)"a_%1$s", (Object)strREPOName3) : StringHelper.Format((String)"u_%1$s", (Object)strREPOName3);
                ArrayList userList = null;
                if (!svnGroupMap.containsKey(strAdminTag)) {
                    userList = new ArrayList();
                    svnGroupMap.put(strAdminTag, userList);
                } else {
                    userList = (ArrayList)svnGroupMap.get(strAdminTag);
                }
                if (userList.contains(strFullLogicName)) continue;
                userList.add(strFullLogicName);
            }
            dataList.clear();
            callResult2 = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (java.sql.Connection)this.getConnection(), (String)"", (String)strSQL3, (Vector)callParamList.GetList(), dataList, (String)"");
            if (callResult2.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u4e2d\u5fc3\u7ba1\u7406\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
            for (BaseDataEntity item : dataList) {
                String strREPOName4 = item.getParamStringValue("PSSVNINSTREPONAME", "");
                bReadOnly2 = item.GetParamIntValue("READONLYMODE", 0) != 0;
                String strFullLogicName = item.getParamStringValue("FULLLOGINNAME", "");
                if (StringHelper.IsNullOrEmpty((String)strFullLogicName)) continue;
                if (repoMap2.containsKey(strREPOName4 = StringHelper.Format((String)"%1$s:/", (Object)strREPOName4))) {
                    bReadOnly2 = false;
                }
                repoMap.put(strREPOName4, bReadOnly2);
                String strAdminTag = StringHelper.Format((String)(bReadOnly2 ? "u_%1$s" : "a_%1$s"), (Object)strREPOName4);
                ArrayList userList = null;
                if (!svnGroupMap.containsKey(strAdminTag)) {
                    userList = new ArrayList();
                    svnGroupMap.put(strAdminTag, userList);
                } else {
                    userList = (ArrayList)svnGroupMap.get(strAdminTag);
                }
                if (userList.contains(strFullLogicName)) continue;
                userList.add(strFullLogicName);
            }
            ++i;
        }
        i = 0;
        while (i < 2) {
            strSQL4 = "select t2.*,t2.CODENAME as SLNCODENAME,t4.PSSVNINSTREPONAME,t4.READONLYMODE from t_srfpsdevsln t2 \t\tinner join t_srfpsdevcenter t3 on t3.psdevcenterid=t2.psdevcenterid \t\tinner join T_SRFPSSVNINSTREPO t4 on t4.PSSVNINSTREPOID = " + (i == 0 ? " t3.PSSVNINSTREPOID " : " t3.ROPSSVNINSTREPOID ") + "\t\tinner join t_srfpssvnserver t5 on t5.pssvnserverid = t4.pssvnserverid " + "\t\twhere t2.PSDCWORKSHOPSERVERID IS NOT NULL and t2.VCUSER IS NOT NULL and t5.pssvnserverid = ?";
            dataList.clear();
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (java.sql.Connection)this.getConnection(), (String)"", (String)strSQL4, (Vector)callParamList.GetList(), dataList, (String)"");
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5f00\u53d1\u65b9\u6848\u5de5\u7a0b\u670d\u52a1\u5668\u4ee3\u7801\u7b7e\u5165\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity item : dataList) {
                strREPOName = item.getParamStringValue("PSSVNINSTREPONAME", "");
                strSLNCodeName = item.getParamStringValue("SLNCODENAME", "");
                bReadOnly = false;
                String strFullLogicName = item.getParamStringValue("VCUSER", "");
                if (StringHelper.IsNullOrEmpty((String)strFullLogicName)) continue;
                strREPOName = StringHelper.Format((String)"%1$s:/%2$s", (Object)strREPOName, (Object)strSLNCodeName);
                repoMap.put(strREPOName, bReadOnly);
                String strAdminTag = StringHelper.Format((String)(bReadOnly ? "u_%1$s" : "a_%1$s"), (Object)strREPOName);
                ArrayList userList = null;
                if (!svnGroupMap.containsKey(strAdminTag)) {
                    userList = new ArrayList();
                    svnGroupMap.put(strAdminTag, userList);
                } else {
                    userList = (ArrayList)svnGroupMap.get(strAdminTag);
                }
                if (userList.contains(strFullLogicName)) continue;
                userList.add(strFullLogicName);
            }
            ++i;
        }
        StringBuilderEx sbGroup = new StringBuilderEx();
        sbGroup.Append("[groups]\r\n");
        sbGroup.Append("admin = psadmin\r\n");
        StringBuilderEx sbProject = new StringBuilderEx();
        sbProject.Append("\r\n[/]\r\n");
        sbProject.Append("@admin = rw\r\n");
        for (String strKey : repoMap.keySet()) {
            boolean bFirst;
            boolean bReadOnly4 = (Boolean)repoMap.get(strKey);
            sbProject.Append("\r\n[%1$s]\r\n", (Object)strKey);
            String strGroupName = StringHelper.Format((String)"g%1$s", (Object)(++nCount));
            ArrayList userList = (ArrayList)svnGroupMap.get(StringHelper.Format((String)"a_%1$s", (Object)strKey));
            if (userList != null) {
                Collections.sort(userList, new Comparator<String>(){

                    @Override
                    public int compare(String arg0, String arg1) {
                        return arg0.compareTo(arg1);
                    }
                });
                sbGroup.Append("%1$s = ", (Object)strGroupName);
                bFirst = true;
                for (String strUserName : userList) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        sbGroup.Append(",");
                    }
                    sbGroup.Append(strUserName);
                }
                sbGroup.Append("\r\n");
                if (bReadOnly4) {
                    sbProject.Append("@%1$s = r\r\n", (Object)strGroupName);
                } else {
                    sbProject.Append("@%1$s = rw\r\n", (Object)strGroupName);
                }
            }
            strGroupName = StringHelper.Format((String)"g%1$s", (Object)(++nCount));
            userList = (ArrayList)svnGroupMap.get(StringHelper.Format((String)"u_%1$s", (Object)strKey));
            if (userList == null) continue;
            Collections.sort(userList, new Comparator<String>(){

                @Override
                public int compare(String arg0, String arg1) {
                    return arg0.compareTo(arg1);
                }
            });
            sbGroup.Append("%1$s = ", (Object)strGroupName);
            bFirst = true;
            for (String strUserName : userList) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sbGroup.Append(",");
                }
                sbGroup.Append(strUserName);
            }
            sbGroup.Append("\r\n");
            sbProject.Append("@%1$s = r\r\n", (Object)strGroupName);
        }
        String strAuthZ = String.valueOf(sbGroup.toString()) + sbProject.toString();
        if (StringHelper.Compare((String)(String.valueOf(psSVNServer.getAUTHZCFG()) + "\r\n"), (String)strAuthZ, (boolean)true) == 0) {
            return;
        }
        String strAuthZFile = this.createAuthZfile(psSVNServer.getPSSVNSERVERID(), strAuthZ);
        PSSVNServerDataCtrl.putFileToRemote(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strAuthZFile, psSVNServer.getSVNROOT());
        File file = new File(strAuthZFile);
        String strCmd = StringHelper.Format((String)"cp -f %1$s%2$s %1$sauthz", (Object)psSVNServer.getSVNROOT(), (Object)file.getName());
        PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strCmd);
        strCmd = StringHelper.Format((String)"rm -f %1$s%2$s", (Object)psSVNServer.getSVNROOT(), (Object)file.getName());
        PSSVNServerDataCtrl.runRemoteScript(psSVNServer.getIPADDR(), 22, psSVNServer.getUSERNAME(), psSVNServer.getPASSWD(), strCmd);
        String strPSSvnServerId = psSVNServer.getPSSVNSERVERID();
        psSVNServer.Reset();
        psSVNServer.setPSSVNSERVERID(strPSSvnServerId);
        psSVNServer.setAUTHZCFG(strAuthZ);
        this.Save(false, psSVNServer);
    }

    protected String createAuthZfile(String strPSSvnServerId, String strContent) throws Exception {
        File fTemp = File.createTempFile("authz", "");
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(fTemp), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        writer.write(strContent);
        writer.close();
        return fTemp.getPath();
    }

    public static String putFileToRemote(String host, int nPort, String username, String password, String localFileName, String remoteDir) throws Exception {
        Connection conn;
        String msg;
        block3: {
            msg = "";
            conn = new Connection(host, nPort);
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(username, password);
            if (isAuthenticated) break block3;
            return "\u6743\u9650\u4e0d\u591f!";
        }
        SCPClient scpClient = conn.createSCPClient();
        scpClient.put(localFileName, remoteDir);
        conn.close();
        return msg;
    }

    public static List<String> runRemoteScript(String host, int nPort, String username, String password, String cmd) throws Exception {
        String line;
        ArrayList<String> result = new ArrayList<String>();
        Connection conn = new Connection(host, nPort);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(username, password);
        if (!isAuthenticated) {
            throw new RuntimeException("\u6743\u9650\u4e0d\u591f");
        }
        Session sess = conn.openSession();
        sess.execCommand(cmd);
        StreamGobbler stdout = new StreamGobbler(sess.getStdout());
        BufferedReader br = new BufferedReader(new InputStreamReader((InputStream)stdout));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            result.add(line);
        }
        sess.close();
        conn.close();
        return result;
    }

    protected String createPreRevpropChangeFile() throws Exception {
        File fTemp = File.createTempFile("pre-revprop-change", "");
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(fTemp), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        writer.write("#!/bin/sh\n");
        writer.write("\n");
        writer.write("# PRE-REVPROP-CHANGE HOOK\n");
        writer.write("#\n");
        writer.write("# The pre-revprop-change hook is invoked before a revision property\n");
        writer.write("# is added, modified or deleted.  Subversion runs this hook by invoking\n");
        writer.write("# a program (script, executable, binary, etc.) named 'pre-revprop-change'\n");
        writer.write("# (for which this file is a template), with the following ordered\n");
        writer.write("# arguments:\n");
        writer.write("#\n");
        writer.write("#   [1] REPOS-PATH   (the path to this repository)\n");
        writer.write("#   [2] REV          (the revision being tweaked)\n");
        writer.write("#   [3] USER         (the username of the person tweaking the property)\n");
        writer.write("#   [4] PROPNAME     (the property being set on the revision)\n");
        writer.write("#   [5] ACTION       (the property is being 'A'dded, 'M'odified, or 'D'eleted)\n");
        writer.write("#\n");
        writer.write("#   [STDIN] PROPVAL  ** the new property value is passed via STDIN.\n");
        writer.write("#\n");
        writer.write("# If the hook program exits with success, the propchange happens; but\n");
        writer.write("# if it exits with failure (non-zero), the propchange doesn't happen.\n");
        writer.write("# The hook program can use the 'svnlook' utility to examine the \n");
        writer.write("# existing value of the revision property.\n");
        writer.write("#\n");
        writer.write("# WARNING: unlike other hooks, this hook MUST exist for revision\n");
        writer.write("# properties to be changed.  If the hook does not exist, Subversion \n");
        writer.write("# will behave as if the hook were present, but failed.  The reason\n");
        writer.write("# for this is that revision properties are UNVERSIONED, meaning that\n");
        writer.write("# a successful propchange is destructive;  the old value is gone\n");
        writer.write("# forever.  We recommend the hook back up the old value somewhere.\n");
        writer.write("#\n");
        writer.write("# On a Unix system, the normal procedure is to have 'pre-revprop-change'\n");
        writer.write("# invoke other programs to do the real work, though it may do the\n");
        writer.write("# work itself too.\n");
        writer.write("#\n");
        writer.write("# Note that 'pre-revprop-change' must be executable by the user(s) who will\n");
        writer.write("# invoke it (typically the user httpd runs as), and that user must\n");
        writer.write("# have filesystem-level permission to access the repository.\n");
        writer.write("#\n");
        writer.write("# On a Windows system, you should name the hook program\n");
        writer.write("# 'pre-revprop-change.bat' or 'pre-revprop-change.exe',\n");
        writer.write("# but the basic idea is the same.\n");
        writer.write("#\n");
        writer.write("# The hook program typically does not inherit the environment of\n");
        writer.write("# its parent process.  For example, a common problem is for the\n");
        writer.write("# PATH environment variable to not be set to its usual value, so\n");
        writer.write("# that subprograms fail to launch unless invoked via absolute path.\n");
        writer.write("# If you're having unexpected problems with a hook program, the\n");
        writer.write("# culprit may be unusual (or missing) environment variables.\n");
        writer.write("# \n");
        writer.write("# Here is an example hook script, for a Unix /bin/sh interpreter.\n");
        writer.write("# For more examples and pre-written hooks, see those in\n");
        writer.write("# the Subversion repository at\n");
        writer.write("# http://svn.apache.org/repos/asf/subversion/trunk/tools/hook-scripts/ and\n");
        writer.write("# http://svn.apache.org/repos/asf/subversion/trunk/contrib/hook-scripts/\n");
        writer.write("\n");
        writer.write("\n");
        writer.write("REPOS=\"$1\"\n");
        writer.write("REV=\"$2\"\n");
        writer.write("USER=\"$3\"\n");
        writer.write("PROPNAME=\"$4\"\n");
        writer.write("ACTION=\"$5\"\n");
        writer.write("\n");
        writer.write("if [ \"$ACTION\" = \"M\" -a \"$PROPNAME\" = \"svn:log\" ]; then exit 0; fi\n");
        writer.write("\n");
        writer.write("echo \"Changing revision properties other than svn:log is prohibited\" >&2\n");
        writer.write("exit 0");
        writer.close();
        return fTemp.getPath();
    }

    protected String createPostCommitFile(SA.SRFDA.PS.Data.PSSVNServer psSVNServer, String strProjectName) throws Exception {
        File fTemp = File.createTempFile("post-commit", "");
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(fTemp), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        writer.write("#!/bin/sh\n");
        writer.write("\n");
        writer.write("# The post-commit hook is invoked after a commit.  Subversion runs\n");
        writer.write("# this hook by invoking a program (script, executable, binary, etc.)\n");
        writer.write("# named 'post-commit' (for which this file is a template) with the \n");
        writer.write("# following ordered arguments:\n");
        writer.write("#\n");
        writer.write("#   [1] REPOS-PATH   (the path to this repository)\n");
        writer.write("#   [2] REV          (the number of the revision just committed)\n");
        writer.write("#\n");
        writer.write("# The default working directory for the invocation is undefined, so\n");
        writer.write("# the program should set one explicitly if it cares.\n");
        writer.write("#\n");
        writer.write("# Because the commit has already completed and cannot be undone,\n");
        writer.write("# the exit code of the hook program is ignored.  The hook program\n");
        writer.write("# can use the 'svnlook' utility to help it examine the\n");
        writer.write("# newly-committed tree.\n");
        writer.write("#\n");
        writer.write("# On a Unix system, the normal procedure is to have 'post-commit'\n");
        writer.write("# invoke other programs to do the real work, though it may do the\n");
        writer.write("# work itself too.\n");
        writer.write("#\n");
        writer.write("# Note that 'post-commit' must be executable by the user(s) who will\n");
        writer.write("# invoke it (typically the user httpd runs as), and that user must\n");
        writer.write("# have filesystem-level permission to access the repository.\n");
        writer.write("#\n");
        writer.write("# On a Windows system, you should name the hook program\n");
        writer.write("# 'post-commit.bat' or 'post-commit.exe',\n");
        writer.write("# but the basic idea is the same.\n");
        writer.write("# \n");
        writer.write("# The hook program typically does not inherit the environment of\n");
        writer.write("# its parent process.  For example, a common problem is for the\n");
        writer.write("# PATH environment variable to not be set to its usual value, so\n");
        writer.write("# that subprograms fail to launch unless invoked via absolute path.\n");
        writer.write("# If you're having unexpected problems with a hook program, the\n");
        writer.write("# culprit may be unusual (or missing) environment variables.\n");
        writer.write("# \n");
        writer.write("# Here is an example hook script, for a Unix /bin/sh interpreter.\n");
        writer.write("# For more examples and pre-written hooks, see those in\n");
        writer.write("# the Subversion repository at\n");
        writer.write("# http://svn.apache.org/repos/asf/subversion/trunk/tools/hook-scripts/ and\n");
        writer.write("# http://svn.apache.org/repos/asf/subversion/trunk/contrib/hook-scripts/\n");
        writer.write("\n");
        writer.write("\n");
        writer.write("REPOS=\"$1\"\n");
        writer.write("REV=\"$2\"\n");
        writer.write("\n");
        writer.write("mailer.py commit \"$REPOS\" \"$REV\" /path/to/mailer.conf\n");
        writer.write(StringHelper.Format((String)"svnsync sync --non-interactive %1$s%2$s --username %3$s --password %4$s", (Object)psSVNServer.getSLAVESVNURL(), (Object)strProjectName, (Object)psSVNServer.getSLAVESVNUSERNAME(), (Object)psSVNServer.getSLAVESVNPASSWD()));
        writer.close();
        return fTemp.getPath();
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSSVNServerId = dataEntity.getParamStringValue("PSSVNSERVERID", "");
        this.getPSModelStorage().resetPSSVNServer(strPSSVNServerId);
        PSSVNServerService psSVNServerService = (PSSVNServerService)ServiceGlobal.getService(PSSVNServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSVNServer psSVNServer = new PSSVNServer();
        psSVNServer.setPSSVNServerId(strPSSVNServerId);
        psSVNServerService.get((IEntity)psSVNServer);
        PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSSVNServer(psSVNServer);
    }

    protected String getDomainCode(SA.SRFDA.PS.Data.PSSVNServer psSVNServer) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)psSVNServer.getPSSVRDOMAINID())) {
            return "";
        }
        IDEDataCtrl iDEDataCtrl = this.GetRelatedDataCtrl("DE1885");
        PSSvrDomain psSvrDomain = new PSSvrDomain();
        psSvrDomain.setPSSVRDOMAINID(psSVNServer.getPSSVRDOMAINID());
        CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)psSvrDomain);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u670d\u52a1\u57df\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psSvrDomain.getDOMAINCODE();
    }
}

