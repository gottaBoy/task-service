/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ImportSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevUser
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevUserService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer
 *  net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSUAWizard3;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Random;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ImportSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSUAWizard3DataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSUAWizard3DataCtrl.class);
    private static Random random = new Random();

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSUAWizard3 psUAWizard3 = new PSUAWizard3();
            psUAWizard3.proxy(dataEntity);
            SessionFactoryManager.addRef();
            ImportSessionManager.openSession();
            try {
                PSDevCenter psDevCenter;
                PSDevCenterService psDevCenterService;
                if (!this.getPSModelStorage().isLoaded()) {
                    throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u7cfb\u7edf\u6b63\u5728\u542f\u52a8\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5\uff01"));
                }
                SimpleWebContext simpleWebContext = new SimpleWebContext();
                simpleWebContext.init(null);
                simpleWebContext.setSessionValue("SRFPERSONID", (Object)"SYSTEM");
                simpleWebContext.setSessionValue("SRFLOGINNAME", (Object)"SYSTEM");
                simpleWebContext.setSessionValue("SRFUSERNAME", (Object)"\u7cfb\u7edf\u5185\u7f6e\u7528\u6237");
                simpleWebContext.setSessionValue("SRFORGID", (Object)psUAWizard3.getPSDEVCENTERID());
                WebContext.setCurrent((IWebContext)simpleWebContext);
                JSONObject appDataJO = new JSONObject();
                appDataJO.put("psdevcenterid", (Object)psUAWizard3.getPSDEVCENTERID());
                appDataJO.put("psdevcentername", (Object)psUAWizard3.getPSDEVCENTERNAME());
                simpleWebContext.setPostValue("SRFAPPDATA", Base64Helper.encodeBytes((byte[])appDataJO.toString().getBytes()).replace("\r", "").replace("\n", ""));
                StringBuilderEx sb = new StringBuilderEx();
                if (StringHelper.Compare((String)psUAWizard3.getWIZARDMODE(), (String)"INITDC", (boolean)true) == 0) {
                    SelectCond selectCond;
                    psDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class);
                    psDevCenter = new PSDevCenter();
                    psDevCenter.setPSDevCenterId(psUAWizard3.getPSDEVCENTERID());
                    psDevCenterService.get((IEntity)psDevCenter);
                    if (psUAWizard3.getTOMCAT7ASCOUNT() > 0) {
                        sb.append("\r\n\u7533\u8bf7[Tomcat\u670d\u52a1\u5668] x %1$s\r\n", (Object)psUAWizard3.getTOMCAT7ASCOUNT());
                        selectCond = new SelectCond();
                        selectCond.set("PSSVRDOMAINID", (Object)psDevCenter.getPSSvrDomainId());
                        selectCond.set("ASSTATE", (Object)20);
                        selectCond.set("ASTYPE", (Object)"TOMCAT7");
                        selectCond.setMaxRowCount(psUAWizard3.getTOMCAT7ASCOUNT());
                        PSAppServerService psAppServerService = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class);
                        ArrayList psAppServerList = psAppServerService.select((ISelectCond)selectCond);
                        if (psAppServerList.size() < psUAWizard3.getTOMCAT7ASCOUNT()) {
                            throw new Exception("\u7533\u8bf7[Tomcat\u670d\u52a1\u5668]\u5931\u8d25\uff0c\u6570\u91cf\u4e0d\u8db3!");
                        }
                        PSDevCenterASService psDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class);
                        for (PSAppServer psAppServer : psAppServerList) {
                            PSDevCenterAS psDevCenterAS = new PSDevCenterAS();
                            psAppServer.copyTo((IDataObject)psDevCenterAS, true);
                            psDevCenterAS.setPSDevCenterASName(psAppServer.getPSAppServerName());
                            psDevCenterAS.setPSDevCenterId(psDevCenter.getPSDevCenterId());
                            psDevCenterAS.setPSDevCenterName(psDevCenter.getPSDevCenterName());
                            psDevCenterAS.setMemo(null);
                            psDevCenterAS.setRefFlag(Integer.valueOf(0));
                            psDevCenterAS.setASMode("PSAS");
                            psDevCenterASService.create((IEntity)psDevCenterAS, false);
                            psAppServer.setASState(Integer.valueOf(30));
                            psAppServer.setRefInfo(psDevCenter.getPSDevCenterName());
                            psAppServerService.update((IEntity)psAppServer, false);
                            sb.append("\u5206\u914d[Tomcat\u670d\u52a1\u5668]%1$s\r\n", (Object)psAppServer.getPSAppServerName());
                        }
                    }
                    if (psUAWizard3.getDEVSERVERCOUNT() > 0) {
                        sb.append("\r\n\u7533\u8bf7[\u4e91\u5f00\u53d1\u4e3b\u673a] x %1$s\r\n", (Object)psUAWizard3.getDEVSERVERCOUNT());
                        selectCond = new SelectCond();
                        selectCond.set("PSSVRDOMAINID", (Object)psDevCenter.getPSSvrDomainId());
                        selectCond.set("DSSTATE", (Object)20);
                        selectCond.setMaxRowCount(psUAWizard3.getDEVSERVERCOUNT());
                        PSDevServerService psDevServerService = (PSDevServerService)ServiceGlobal.getService(PSDevServerService.class);
                        ArrayList psDevServerList = psDevServerService.select((ISelectCond)selectCond);
                        if (psDevServerList.size() < psUAWizard3.getDEVSERVERCOUNT()) {
                            throw new Exception("\u7533\u8bf7[\u4e91\u5f00\u53d1\u4e3b\u673a]\u5931\u8d25\uff0c\u6570\u91cf\u4e0d\u8db3!");
                        }
                        PSDevCenterServerService psDevCenterServerService = (PSDevCenterServerService)ServiceGlobal.getService(PSDevCenterServerService.class);
                        for (PSDevServer psDevServer : psDevServerList) {
                            PSDevCenterServer psDevCenterServer = new PSDevCenterServer();
                            psDevServer.copyTo((IDataObject)psDevCenterServer, true);
                            psDevCenterServer.setPSDevCenterServerName(psDevServer.getPSDevServerName());
                            psDevCenterServer.setPSDevCenterId(psDevCenter.getPSDevCenterId());
                            psDevCenterServer.setPSDevCenterName(psDevCenter.getPSDevCenterName());
                            psDevCenterServer.setMemo(null);
                            psDevCenterServerService.create((IEntity)psDevCenterServer, false);
                            psDevServer.setDSState(Integer.valueOf(30));
                            psDevServer.setRefInfo(psDevCenter.getPSDevCenterName());
                            psDevServerService.update((IEntity)psDevServer, false);
                            sb.append("\u5206\u914d[\u4e91\u5f00\u53d1\u4e3b\u673a]%1$s\r\n", (Object)psDevServer.getPSDevServerName());
                        }
                    }
                    if (psUAWizard3.getMYSQL5INSTCOUNT() > 0) {
                        sb.append("\r\n\u7533\u8bf7[\u4e91MYSQL\u5f00\u53d1\u5b9e\u4f8b] x %1$s\r\n", (Object)psUAWizard3.getMYSQL5INSTCOUNT());
                        selectCond = new SelectCond();
                        selectCond.set("PSSVRDOMAINID", (Object)psDevCenter.getPSSvrDomainId());
                        selectCond.set("INSTSTATE", (Object)20);
                        selectCond.set("DBTYPE", (Object)"MYSQL5");
                        selectCond.setMaxRowCount(psUAWizard3.getMYSQL5INSTCOUNT());
                        PSDBDevInstService psDBDevInstService = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class);
                        ArrayList psDBDevInstList = psDBDevInstService.select((ISelectCond)selectCond);
                        if (psDBDevInstList.size() < psUAWizard3.getMYSQL5INSTCOUNT()) {
                            throw new Exception("\u7533\u8bf7[\u4e91MYSQL\u5f00\u53d1\u5b9e\u4f8b]\u5931\u8d25\uff0c\u6570\u91cf\u4e0d\u8db3!");
                        }
                        PSDevCenterDBInstService psDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class);
                        for (PSDBDevInst psDBDevInst : psDBDevInstList) {
                            PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
                            psDBDevInst.copyTo((IDataObject)psDevCenterDBInst, true);
                            psDevCenterDBInst.setPSDevCenterDBInstName(psDBDevInst.getPSDBDevInstName());
                            psDevCenterDBInst.setPSDevCenterId(psDevCenter.getPSDevCenterId());
                            psDevCenterDBInst.setPSDevCenterName(psDevCenter.getPSDevCenterName());
                            psDevCenterDBInst.setMemo(null);
                            psDevCenterDBInst.setRefCount(Integer.valueOf(0));
                            psDevCenterDBInstService.create((IEntity)psDevCenterDBInst, false);
                            psDBDevInst.setInstState(Integer.valueOf(30));
                            psDBDevInst.setRefInfo(psDevCenter.getPSDevCenterName());
                            psDBDevInstService.update((IEntity)psDBDevInst, false);
                            sb.append("\u5206\u914d[\u4e91MYSQL\u5f00\u53d1\u5b9e\u4f8b]%1$s\r\n", (Object)psDBDevInst.getPSDBDevInstName());
                        }
                    }
                }
                if (StringHelper.Compare((String)psUAWizard3.getWIZARDMODE(), (String)"INITTRAININGENV", (boolean)true) == 0) {
                    psDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class);
                    psDevCenter = new PSDevCenter();
                    psDevCenter.setPSDevCenterId(psUAWizard3.getPSDEVCENTERID());
                    psDevCenterService.get((IEntity)psDevCenter);
                    PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
                    PSDevSlnSys psDevSlnSysSrc = new PSDevSlnSys();
                    psDevSlnSysSrc.setPSDevSlnSysId(psUAWizard3.getPSDEVSLNSYSID());
                    psDevSlnSysService.get((IEntity)psDevSlnSysSrc);
                    int nDevSlnCount = psUAWizard3.getDEVSLNCOUNT();
                    if (nDevSlnCount > 99) {
                        nDevSlnCount = 99;
                    }
                    SelectCond selectCond = new SelectCond();
                    selectCond.set("PSDEVCENTERID", (Object)psDevCenter.getPSDevCenterId());
                    selectCond.set("REFFLAG", (Object)0);
                    selectCond.set("ASTYPE", (Object)"TOMCAT7");
                    selectCond.setMaxRowCount(nDevSlnCount);
                    PSDevCenterASService psDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class);
                    ArrayList psDevCenterASList = psDevCenterASService.select((ISelectCond)selectCond);
                    if (psDevCenterASList.size() < nDevSlnCount) {
                        throw new Exception("\u5e94\u7528\u4e2d\u5fc3\u670d\u52a1\u5668[Tomcat\u670d\u52a1\u5668]\u6570\u91cf\u4e0d\u8db3!");
                    }
                    selectCond.reset();
                    selectCond.set("PSDEVCENTERID", (Object)psDevCenter.getPSDevCenterId());
                    selectCond.set("REFCOUNT", (Object)0);
                    selectCond.set("DBTYPE", (Object)"MYSQL5");
                    selectCond.setMaxRowCount(nDevSlnCount);
                    PSDevCenterDBInstService psDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class);
                    ArrayList psDevCenterDBInstList = psDevCenterDBInstService.select((ISelectCond)selectCond);
                    if (psDevCenterDBInstList.size() < nDevSlnCount) {
                        throw new Exception("\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b[MySQL5]\u6570\u91cf\u4e0d\u8db3!");
                    }
                    int nUserCountPerSys = 1;
                    if (psUAWizard3.getUSERCOUNTPERSYS() > 0 && (nUserCountPerSys = psUAWizard3.getUSERCOUNTPERSYS()) > 5) {
                        nUserCountPerSys = 5;
                    }
                    PSDevSlnService psDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class);
                    PSDevSlnUserService psDevSlnUserService = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class);
                    PSDevUserService psDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class);
                    PSSysModelInstService psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class);
                    ArrayList<PSDevSln> psDevSlnList = new ArrayList<PSDevSln>();
                    int i = 0;
                    while (i < nDevSlnCount) {
                        PSDevSln psDevSln = new PSDevSln();
                        psDevSln.setPSDevSlnName(StringHelper.Format((String)"%1$s%2$02d", (Object)psUAWizard3.getDEVSLNCODENAME(), (Object)(i + 1)));
                        psDevSln.setCodeName(StringHelper.Format((String)"%1$s%2$02d", (Object)psUAWizard3.getDEVSLNCODENAME(), (Object)(i + 1)));
                        psDevSln.setLogicName(StringHelper.Format((String)"%1$s%2$02d", (Object)psUAWizard3.getDEVSLNNAME(), (Object)(i + 1)));
                        psDevSln.setPSDevCenterId(psDevCenter.getPSDevCenterId());
                        psDevSln.setPSDevCenterName(psDevCenter.getPSDevCenterName());
                        psDevSlnService.create((IEntity)psDevSln);
                        psDevSlnList.add(psDevSln);
                        sb.append("\r\n\u5efa\u7acb\u5e94\u7528\u5f00\u53d1\u65b9\u6848[%1$s]\r\n", (Object)psDevSln.getPSDevSlnName());
                        PSDevCenterAS psDevCenterAS = (PSDevCenterAS)psDevCenterASList.get(i);
                        PSDevCenterDBInst psDevCenterDBInst = (PSDevCenterDBInst)psDevCenterDBInstList.get(i);
                        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
                        psDevSlnSysSrc.copyTo((IDataObject)psDevSlnSys, false);
                        psDevSlnSys.remove("PSDEVSLNSYSID");
                        psDevSlnSys.remove("PSSYSMODELINSTID");
                        psDevSlnSys.remove("PSSYSTEMID");
                        psDevSlnSys.remove("PSDEVCENTERTSID");
                        psDevSlnSys.setPSDevSlnId(psDevSln.getPSDevSlnId());
                        psDevSlnSys.setPSDevSlnName(psDevSln.getPSDevSlnName());
                        psDevSlnSys.setPSDevCenterASId(psDevCenterAS.getPSDevCenterASId());
                        psDevSlnSys.setPSDevCenterASName(psDevCenterAS.getPSDevCenterASName());
                        psDevSlnSys.setEnableMySQL5(Integer.valueOf(1));
                        psDevSlnSys.setMySQLPSDCDBInstId(psDevCenterDBInst.getPSDevCenterDBInstId());
                        psDevSlnSys.setMySQLPSDCDBInstName(psDevCenterDBInst.getPSDevCenterDBInstName());
                        psDevSlnSys.set("srcpssysmodelinstid", (Object)psDevSlnSysSrc.getPSSysModelInstId());
                        psDevSlnSysService.create((IEntity)psDevSlnSys);
                        sb.append("\r\n\u5efa\u7acb\u5e94\u7528\u5f00\u53d1\u7cfb\u7edf[%1$s]\r\n", (Object)psDevSlnSys.getPSDevSlnSysName());
                        SessionFactoryManager.releaseAndAddRef((boolean)true);
                        ++i;
                    }
                    SessionFactoryManager.releaseAndAddRef((boolean)true);
                    i = 0;
                    while (i < nDevSlnCount) {
                        int j = 0;
                        while (j < nUserCountPerSys) {
                            PSDevUser psDevUser = new PSDevUser();
                            psDevUser.setPSDevCenterId(psDevCenter.getPSDevCenterId());
                            psDevUser.setPSDevCenterName(psDevCenter.getPSDevCenterName());
                            psDevUser.setAdminMode(Integer.valueOf(0));
                            psDevUser.setValidFlag(Integer.valueOf(1));
                            psDevUser.setPSDevUserName(StringHelper.Format((String)"%1$s%2$02d%3$s", (Object)psUAWizard3.getUSERNAME(), (Object)(i + 1), (Object)(j + 1)));
                            psDevUser.setLoginName(StringHelper.Format((String)"%1$s%2$02d%3$s", (Object)psUAWizard3.getUSERLOGINNAME(), (Object)(i + 1), (Object)(j + 1)));
                            String strPassword = this.calcPassword();
                            psDevUser.setLoginPwd(strPassword);
                            psDevUserService.create((IEntity)psDevUser);
                            sb.append("\r\n\u5efa\u7acb\u5e94\u7528\u4e2d\u5fc3\u7528\u6237[%1$s][%2$s][%3$s]\r\n", (Object)psDevUser.getPSDevUserName(), (Object)psDevUser.getFullLoginName(), (Object)strPassword);
                            SessionFactoryManager.releaseAndAddRef((boolean)true);
                            PSDevSln psDevSln = (PSDevSln)psDevSlnList.get(i);
                            PSDevSlnUser psDevSlnUser = new PSDevSlnUser();
                            psDevSlnUser.setAllSysFlag(Integer.valueOf(1));
                            psDevSlnUser.setAccMode(Integer.valueOf(3));
                            psDevSlnUser.setPSDevSlnId(psDevSln.getPSDevSlnId());
                            psDevSlnUser.setPSDevSlnName(psDevSln.getPSDevSlnName());
                            psDevSlnUser.setPSDevUserObjId(psDevUser.getPSDevUserId());
                            psDevSlnUser.setPSDevUserObjName(psDevUser.getPSDevUserName());
                            psDevSlnUserService.create((IEntity)psDevSlnUser);
                            SessionFactoryManager.releaseAndAddRef((boolean)true);
                            sb.append("\r\n\u52a0\u5165\u5e94\u7528\u4e2d\u5fc3\u7528\u6237[%1$s]\u65b9\u6848[%2$s]\r\n", (Object)psDevUser.getPSDevUserName(), (Object)psDevSln.getPSDevSlnName());
                            ++j;
                        }
                        ++i;
                    }
                }
                psUAWizard3.setACTIONRESULT(sb.toString());
                SessionFactoryManager.releaseRef((boolean)true);
                ImportSessionManager.closeSession();
            }
            catch (Exception ex) {
                ImportSessionManager.closeSession();
                SessionFactoryManager.releaseRef((boolean)false);
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
        }
        return callResult;
    }

    protected String calcPassword() {
        String strSource = Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 8);
        String strPassword = "";
        int i = 0;
        while (i < 8) {
            int nPos = random.nextInt(100) % 5;
            strPassword = nPos == 0 ? String.valueOf(strPassword) + "@" : (nPos == 2 ? String.valueOf(strPassword) + strSource.substring(i, i + 1).toUpperCase() : String.valueOf(strPassword) + strSource.substring(i, i + 1));
            ++i;
        }
        return strPassword;
    }
}

