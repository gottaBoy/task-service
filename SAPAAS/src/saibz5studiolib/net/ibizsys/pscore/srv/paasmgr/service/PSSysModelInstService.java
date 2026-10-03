/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.RemoteCallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.RemoteService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.RemoteCallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.RemoteService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTS;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysModelInstService
extends PSSysModelInstServiceBase {
    private static final Log log = LogFactory.getLog(PSSysModelInstService.class);
    private static Random random = new Random();
    public static final String BACKUPEXT = "_bak";

    @Override
    protected RemoteCallResult executeRemoteCall(String string, IEntity iEntity) throws Exception {
        String string2 = (String)iEntity.get("PSDEVCENTERTSID");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception("\u5f53\u524d\u7cfb\u7edf\u672a\u914d\u7f6e\u4efb\u52a1\u670d\u52a1\u5668");
        }
        PSDevCenterTS pSDevCenterTS = new PSDevCenterTS();
        pSDevCenterTS.setPSDevCenterTSId(string2);
        PSDevCenterTSService pSDevCenterTSService = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class);
        pSDevCenterTSService.get(pSDevCenterTS);
        String string3 = pSDevCenterTS.getPSTaskServer().getServerUrl();
        string3 = string3 + "saps/remoteapi.jsp";
        RemoteService remoteService = new RemoteService();
        remoteService.init(string3, this.getDEModel().getName(), WebContext.getCurrent().getCurUserId());
        RemoteCallResult remoteCallResult = remoteService.executeAction(string, iEntity);
        if (remoteCallResult.isError()) {
            throw new Exception(remoteCallResult.getErrorInfo());
        }
        return remoteCallResult;
    }

    public void clearLock(int n) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            return;
        }
        if (StringHelper.compare((String)this.getDAO().getRealDBDialect().getDBType(), (String)"MYSQL5", (boolean)true) != 0) {
            return;
        }
        final int n2 = n;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                String string = StringHelper.format((String)"select trx_mysql_thread_id from information_schema.innodb_trx");
                ArrayList<IEntity> arrayList = PSSysModelInstService.this.getDAO().executeRawSelectSql(null, string, null);
                if (arrayList.size() == 0) {
                    return;
                }
                HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
                for (IEntity iEntity : arrayList) {
                    hashMap.put(DataObject.getIntegerValue((IDataObject)iEntity, (String)"trx_mysql_thread_id", (int)0), "");
                }
                arrayList = PSSysModelInstService.this.getDAO().executeRawSelectSql(null, "show  processlist", null);
                if (arrayList.size() == 0) {
                    return;
                }
                for (IEntity iEntity : arrayList) {
                    int n;
                    int n22 = DataObject.getIntegerValue((IDataObject)iEntity, (String)"id", (int)-1);
                    if (!hashMap.containsKey(n22) || (n = DataObject.getIntegerValue((IDataObject)iEntity, (String)"time", (int)999)) <= n2) continue;
                    log.warn((Object)StringHelper.format((String)"\u6e05\u9664\u6570\u636e\u5e93\u8d85\u65f6\u4e8b\u7269\u8fdb\u7a0b[%1$s|%2$s|%3$s]", (Object)n22, (Object)iEntity.get("host"), (Object)iEntity.get("user")));
                    PSSysModelInstService.this.getDAO().executeRawSql(null, StringHelper.format((String)"kill %1$s", (Object)n22), null);
                }
            }
        }, false);
    }

    public PSSysModelInst alloc(final PSDevSlnSys pSDevSlnSys) throws Exception {
        final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenter pSDevCenter;
                SelectCond selectCond = new SelectCond();
                selectCond.set("INSTSTATE", (Object)"20");
                PSDevSln pSDevSln = pSDevSlnSys.getPSDevSln();
                PSDevCenter pSDevCenter2 = pSDevCenter = pSDevSln == null ? null : pSDevSln.getPSDevCenter();
                if (pSDevCenter != null) {
                    selectCond.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
                }
                if (pSDevCenter != null && !StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvrDomainId())) {
                    selectCond.set("PSSVRDOMAINID", (Object)pSDevCenter.getPSSvrDomainId());
                }
                selectCond.set("SYSTYPE", (Object)"DEVSYS");
                String string = DataObject.getStringValue((Object)pSDevSlnSys.get("srcpssysmodelinstid"));
                String string2 = DataObject.getStringValue((Object)pSDevSlnSys.get("dstpssysmodelinstid"));
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    selectCond.set("INSTSTATE", (Object)"10");
                } else if (pSDevSlnSys.getMainPSDevSlnSys() != null) {
                    selectCond.set("PSDBSERVERID", (Object)pSDevSlnSys.getMainPSDevSlnSys().getPSSysModelInst().getPSDBServerId());
                    selectCond.set("INSTSTATE", (Object)"10");
                }
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    selectCond.set("PSSYSMODELINSTID", (Object)string2);
                }
                selectCond.setMaxRowCount(100);
                PSSysModelInst pSSysModelInst = null;
                do {
                    pSSysModelInst = null;
                    ArrayList<PSSysModelInst> arrayList = PSSysModelInstService.this.select((ISelectCond)selectCond);
                    if (arrayList.size() == 0) {
                        if (pSDevSlnSys.getMainPSDevSlnSys() != null) {
                            selectCond.remove("PSDBSERVERID");
                            arrayList = PSSysModelInstService.this.select((ISelectCond)selectCond);
                        }
                        if (arrayList.size() == 0) {
                            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u5e94\u7528\u4e2d\u5fc3\u65e0\u53ef\u7528\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\uff0c\u8bf7\u8054\u7cfb\u4e2d\u5fc3\u7ba1\u7406\u5458\u786e\u8ba4"));
                        }
                    }
                    int n = random.nextInt(100) % arrayList.size();
                    pSSysModelInst = (PSSysModelInst)arrayList.get(n);
                    PSSysModelInstService.this.get(pSSysModelInst);
                } while (StringHelper.compare((String)pSSysModelInst.getInstState(), (String)((String)selectCond.get("INSTSTATE")), (boolean)false) != 0);
                pSSysModelInst.setPSDevCenterId(pSDevSlnSys.getPSDevSln().getPSDevCenterId());
                pSSysModelInst.setPSDevCenterName(pSDevSlnSys.getPSDevSln().getPSDevCenterName());
                String string3 = StringHelper.format((String)"[\u5f00\u53d1\u7cfb\u7edf]%1$s\\%2$s", (Object)pSDevSlnSys.getPSDevSlnName(), (Object)pSDevSlnSys.getPSDevSlnSysName());
                pSSysModelInst.setRefInfo(string3);
                pSSysModelInst.setInstState("15");
                PSSysModelInstService.this.update(pSSysModelInst);
                int n = -1;
                pSDevSlnSys.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
                pSDevSlnSys.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
                if (n != -1) {
                    pSSysModelInst.setModelVer(n);
                }
                pSSysModelInst.setInstState("30");
                PSSysModelInstService.this.update(pSSysModelInst);
                callResult.setUserObject((Object)pSSysModelInst);
            }
        }, true);
        return (PSSysModelInst)callResult.getUserObject();
    }

    @Override
    protected void onCreateDraft(PSSysModelInst pSSysModelInst) throws Exception {
        PSDBServer pSDBServer = pSSysModelInst.getPSDBServer();
        if (pSDBServer == null) {
            String domainId = pSSysModelInst.getPSSvrDomainId();
            if (StringHelper.isNullOrEmpty(domainId)) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u670d\u52a1\u57df\u6807\u8bc6\uff0c\u65e0\u6cd5\u5efa\u7acb\u6a21\u578b\u4ed3\u5e93"));
            }
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSSVRDOMAINID", domainId);
            selectCond.set("BACKUPMODE", (Object)0);
            selectCond.set("VALIDFLAG", (Object)1);
            PSDBServerService serverService = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDBServer> servers = serverService.select((ISelectCond)selectCond);
            if (servers.size() == 0) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u83b7\u53d6\u6570\u636e\u5e93\u670d\u52a1\u5668\uff0c\u65e0\u6cd5\u5efa\u7acb\u6a21\u578b\u4ed3\u5e93"));
            }
            int n = random.nextInt(100) % servers.size();
            pSDBServer = servers.get(n);
        }
        PSSysModelInst original = new PSSysModelInst();
        pSSysModelInst.copyTo((IDataObject)original, false);
        String domainCode = "";
        if (pSDBServer.getPSSvrDomain() != null && StringHelper.isNullOrEmpty((String)(domainCode = pSDBServer.getPSSvrDomain().getDomainCode()))) {
            domainCode = "";
        }
        String dbName = "s" + domainCode + KeyValueHelper.genUniqueId((String)KeyValueHelper.genGuidEx()).substring(0, 9);
        pSSysModelInst.setPSSvrDomainId(pSDBServer.getPSSvrDomainId());
        pSSysModelInst.setPSSvrDomainName(pSDBServer.getPSSvrDomainName());
        pSSysModelInst.setPSDBServerId(pSDBServer.getPSDBServerId());
        pSSysModelInst.setPSDBServerName(pSDBServer.getPSDBServerName());
        pSSysModelInst.setDBType(pSDBServer.getDBType());
        pSSysModelInst.setInstState("35");
        pSSysModelInst.setPSSysModelInstName(dbName);
        pSSysModelInst.setConnStr(StringHelper.format((String)pSDBServer.getDBUrl(), (Object)dbName));
        pSSysModelInst.setSysType("DEVSYS");
        pSSysModelInst.setDBName(dbName);
        pSSysModelInst.setUserName(dbName);
        pSSysModelInst.setPassWD(this.calcPassword());
        pSSysModelInst.setPSDevCenterId(original.getPSDevCenterId());
        pSSysModelInst.setPSDevCenterName(original.getPSDevCenterName());
        pSSysModelInst.setRefInfo(original.getRefInfo());
        this.create(pSSysModelInst);
    }

    @Override
    protected void onCreateBackup(PSSysModelInst pSSysModelInst) throws Exception {
        Object object;
        String string;
        PSSysModelInst pSSysModelInst2 = new PSSysModelInst();
        pSSysModelInst2.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        this.get(pSSysModelInst2);
        String string2 = pSSysModelInst.getPSSysModelInstId();
        String string3 = string2 + BACKUPEXT;
        pSSysModelInst.reset();
        pSSysModelInst.setPSSysModelInstId(string3);
        if (this.get(pSSysModelInst, true)) {
            return;
        }
        PSDBServerBase pSDBServerBase = null;
        if (pSDBServerBase == null) {
            string = pSSysModelInst2.getPSSvrDomainId();
            if (StringHelper.isNullOrEmpty((String)string)) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u670d\u52a1\u57df\u6807\u8bc6\uff0c\u65e0\u6cd5\u5efa\u7acb\u5907\u4efd\u6a21\u578b\u4ed3\u5e93"));
            }
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSSVRDOMAINID", (Object)string);
            selectCond.set("BACKUPMODE", (Object)1);
            selectCond.set("VALIDFLAG", (Object)1);
            PSDBServerService pSDBServerService = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDBServer> arrayList = pSDBServerService.select((ISelectCond)selectCond);
            if (arrayList.size() == 0) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u83b7\u53d6\u6570\u636e\u5e93\u670d\u52a1\u5668\uff0c\u65e0\u6cd5\u5efa\u7acb\u5907\u4efd\u6a21\u578b\u4ed3\u5e93"));
            }
            int n = random.nextInt(100) % arrayList.size();
            pSDBServerBase = (PSDBServer)arrayList.get(n);
        }
        string = "b" + pSSysModelInst2.getDBName();
        pSSysModelInst.setPSSysModelInstId(string3);
        pSSysModelInst.setPSSvrDomainId(pSDBServerBase.getPSSvrDomainId());
        pSSysModelInst.setPSSvrDomainName(pSDBServerBase.getPSSvrDomainName());
        pSSysModelInst.setPSDBServerId(pSDBServerBase.getPSDBServerId());
        pSSysModelInst.setPSDBServerName(pSDBServerBase.getPSDBServerName());
        pSSysModelInst.setDBType(pSDBServerBase.getDBType());
        pSSysModelInst.setInstState("35");
        pSSysModelInst.setPSSysModelInstName(string + "[\u5907\u4efd]");
        pSSysModelInst.setConnStr(StringHelper.format((String)pSDBServerBase.getDBUrl(), (Object)string));
        pSSysModelInst.setSysType("DEVSYS");
        pSSysModelInst.setDBName(string);
        pSSysModelInst.setUserName(string);
        object = this.calcPassword();
        pSSysModelInst.setPassWD((String)object);
        pSSysModelInst.setPSDevCenterId(pSSysModelInst2.getPSDevCenterId());
        pSSysModelInst.setPSDevCenterName(pSSysModelInst2.getPSDevCenterName());
        pSSysModelInst.setRefInfo(pSSysModelInst2.getRefInfo());
        pSSysModelInst.setParam(pSSysModelInst2.getPSSysModelInstId());
        pSSysModelInst.setParam5(1);
        this.create(pSSysModelInst);
    }

    protected String calcPassword() {
        String string = KeyValueHelper.genUniqueId((String)KeyValueHelper.genGuidEx()).substring(0, 8);
        String string2 = "";
        for (int i = 0; i < 8; ++i) {
            int n = random.nextInt(100) % 7;
            string2 = n == 0 ? string2 + "@" : (n >= 4 ? string2 + string.substring(i, i + 1).toUpperCase() : string2 + string.substring(i, i + 1));
        }
        return string2;
    }
}
