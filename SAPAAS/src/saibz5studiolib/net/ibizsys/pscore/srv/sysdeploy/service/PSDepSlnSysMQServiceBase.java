/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdeploy.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysMQDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysMQDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnMQInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnMQInstBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysMQ;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysMQServiceBase
extends PSCoreSysServiceBase<PSDepSlnSysMQ> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysMQServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnSysMQDEModel pSDepSlnSysMQDEModel;
    private PSDepSlnSysMQDAO pSDepSlnSysMQDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysMQService";
    }

    public PSDepSlnSysMQDEModel getPSDepSlnSysMQDEModel() {
        if (this.pSDepSlnSysMQDEModel == null) {
            try {
                this.pSDepSlnSysMQDEModel = (PSDepSlnSysMQDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysMQDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysMQDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnSysMQDEModel();
    }

    public PSDepSlnSysMQDAO getPSDepSlnSysMQDAO() {
        if (this.pSDepSlnSysMQDAO == null) {
            try {
                this.pSDepSlnSysMQDAO = (PSDepSlnSysMQDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysMQDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysMQDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnSysMQDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSlnSysMQ pSDepSlnSysMQ, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSMQ_PSDEPSLNMQINST_PSDEPSLNMQINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnMQInstService", (SessionFactory)this.getSessionFactory());
            PSDepSlnMQInst pSDepSlnMQInst = (PSDepSlnMQInst)iService.getDEModel().createEntity();
            pSDepSlnMQInst.set("PSDEPSLNMQINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnMQInst);
            } else {
                iService.get(pSDepSlnMQInst);
            }
            this.onFillParentInfo_PSDepSlnMQInst(pSDepSlnSysMQ, pSDepSlnMQInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSMQ_PSDEPSLNSYS_PSDEPSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSys pSDepSlnSys = (PSDepSlnSys)iService.getDEModel().createEntity();
            pSDepSlnSys.set("PSDEPSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnSys);
            } else {
                iService.get(pSDepSlnSys);
            }
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysMQ, pSDepSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSMQ_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSln);
            } else {
                iService.get(pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnSysMQ, pSDepSln);
            return;
        }
        super.onFillParentInfo(pSDepSlnSysMQ, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnMQInst(PSDepSlnSysMQ pSDepSlnSysMQ, PSDepSlnMQInst pSDepSlnMQInst) throws Exception {
        pSDepSlnSysMQ.setPSDepSlnMQInstId(pSDepSlnMQInst.getPSDepSlnMQInstId());
        pSDepSlnSysMQ.setPSDepSlnMQInstName(pSDepSlnMQInst.getPSDepSlnMQInstName());
    }

    protected void onFillParentInfo_PSDepSlnSys(PSDepSlnSysMQ pSDepSlnSysMQ, PSDepSlnSys pSDepSlnSys) throws Exception {
        pSDepSlnSysMQ.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
        pSDepSlnSysMQ.setPSDepSlnSysName(pSDepSlnSys.getPSDepSlnSysName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnSysMQ pSDepSlnSysMQ, PSDepSln pSDepSln) throws Exception {
        pSDepSlnSysMQ.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnSysMQ.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillEntityFullInfo(PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnSysMQ, bl);
        this.onFillEntityFullInfo_PSDepSlnMQInst(pSDepSlnSysMQ, bl);
        this.onFillEntityFullInfo_PSDepSlnSys(pSDepSlnSysMQ, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnSysMQ, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnMQInst(PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnSys(PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnSysMQ, bl);
    }

    public ArrayList<PSDepSlnSysMQ> selectByPSDepSlnMQInst(PSDepSlnMQInstBase pSDepSlnMQInstBase) throws Exception {
        return this.selectByPSDepSlnMQInst(pSDepSlnMQInstBase, "", -1);
    }

    public ArrayList<PSDepSlnSysMQ> selectByPSDepSlnMQInst(PSDepSlnMQInstBase pSDepSlnMQInstBase, String string) throws Exception {
        return this.selectByPSDepSlnMQInst(pSDepSlnMQInstBase, string, -1);
    }

    public ArrayList<PSDepSlnSysMQ> selectByPSDepSlnMQInst(PSDepSlnMQInstBase pSDepSlnMQInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNMQINSTID", (Object)pSDepSlnMQInstBase.getPSDepSlnMQInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnMQInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnMQInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysMQ> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, "", -1);
    }

    public ArrayList<PSDepSlnSysMQ> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, string, -1);
    }

    public ArrayList<PSDepSlnSysMQ> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNSYSID", (Object)pSDepSlnSysBase.getPSDepSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysMQ> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnSysMQ> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnSysMQ> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNID", (Object)pSDepSlnBase.getPSDepSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnMQInst(PSDepSlnMQInst pSDepSlnMQInst) throws Exception {
        ArrayList<PSDepSlnSysMQ> arrayList = this.selectByPSDepSlnMQInst(pSDepSlnMQInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNMQINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnMQInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSMQ_PSDEPSLNMQINST_PSDEPSLNMQINSTID", "", iDataEntityModel.getName(), "PSDEPSLNSYSMQ", iDataEntityModel.getDataInfo(pSDepSlnMQInst), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnMQInst(PSDepSlnMQInst pSDepSlnMQInst) throws Exception {
        ArrayList<PSDepSlnSysMQ> arrayList = this.selectByPSDepSlnMQInst(pSDepSlnMQInst);
        for (PSDepSlnSysMQ pSDepSlnSysMQ : arrayList) {
            PSDepSlnSysMQ pSDepSlnSysMQ2 = (PSDepSlnSysMQ)this.getDEModel().createEntity();
            pSDepSlnSysMQ2.setPSDepSlnSysMQId(pSDepSlnSysMQ.getPSDepSlnSysMQId());
            pSDepSlnSysMQ2.setPSDepSlnMQInstId(null);
            this.update(pSDepSlnSysMQ2);
        }
    }

    public void removeByPSDepSlnMQInst(PSDepSlnMQInst pSDepSlnMQInst) throws Exception {
        final PSDepSlnMQInst pSDepSlnMQInst2 = pSDepSlnMQInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysMQServiceBase.this.onBeforeRemoveByPSDepSlnMQInst(pSDepSlnMQInst2);
                PSDepSlnSysMQServiceBase.this.internalRemoveByPSDepSlnMQInst(pSDepSlnMQInst2);
                PSDepSlnSysMQServiceBase.this.onAfterRemoveByPSDepSlnMQInst(pSDepSlnMQInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnMQInst(PSDepSlnMQInst pSDepSlnMQInst) throws Exception {
    }

    protected void internalRemoveByPSDepSlnMQInst(PSDepSlnMQInst pSDepSlnMQInst) throws Exception {
        ArrayList<PSDepSlnSysMQ> arrayList = this.selectByPSDepSlnMQInst(pSDepSlnMQInst);
        this.onBeforeRemoveByPSDepSlnMQInst(pSDepSlnMQInst, arrayList);
        for (PSDepSlnSysMQ pSDepSlnSysMQ : arrayList) {
            this.remove(pSDepSlnSysMQ);
        }
        this.onAfterRemoveByPSDepSlnMQInst(pSDepSlnMQInst, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnMQInst(PSDepSlnMQInst pSDepSlnMQInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnMQInst(PSDepSlnMQInst pSDepSlnMQInst, ArrayList<PSDepSlnSysMQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnMQInst(PSDepSlnMQInst pSDepSlnMQInst, ArrayList<PSDepSlnSysMQ> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysMQ> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSMQ_PSDEPSLNSYS_PSDEPSLNSYSID", "", iDataEntityModel.getName(), "PSDEPSLNSYSMQ", iDataEntityModel.getDataInfo(pSDepSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysMQ> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        for (PSDepSlnSysMQ pSDepSlnSysMQ : arrayList) {
            PSDepSlnSysMQ pSDepSlnSysMQ2 = (PSDepSlnSysMQ)this.getDEModel().createEntity();
            pSDepSlnSysMQ2.setPSDepSlnSysMQId(pSDepSlnSysMQ.getPSDepSlnSysMQId());
            pSDepSlnSysMQ2.setPSDepSlnSysId(null);
            this.update(pSDepSlnSysMQ2);
        }
    }

    public void removeByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        final PSDepSlnSys pSDepSlnSys2 = pSDepSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysMQServiceBase.this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysMQServiceBase.this.internalRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysMQServiceBase.this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysMQ> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
        for (PSDepSlnSysMQ pSDepSlnSysMQ : arrayList) {
            this.remove(pSDepSlnSysMQ);
        }
        this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysMQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysMQ> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSysMQ> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnSysMQ pSDepSlnSysMQ : arrayList) {
            PSDepSlnSysMQ pSDepSlnSysMQ2 = (PSDepSlnSysMQ)this.getDEModel().createEntity();
            pSDepSlnSysMQ2.setPSDepSlnSysMQId(pSDepSlnSysMQ.getPSDepSlnSysMQId());
            pSDepSlnSysMQ2.setPSDepSlnId(null);
            this.update(pSDepSlnSysMQ2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysMQServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnSysMQServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnSysMQServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSysMQ> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnSysMQ pSDepSlnSysMQ : arrayList) {
            this.remove(pSDepSlnSysMQ);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnSysMQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnSysMQ> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnSysMQ pSDepSlnSysMQ) throws Exception {
        super.onBeforeRemove(pSDepSlnSysMQ);
    }

    protected void replaceParentInfo(PSDepSlnSysMQ pSDepSlnSysMQ, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnSysMQ, cloneSession);
        if (pSDepSlnSysMQ.getPSDepSlnMQInstId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNMQINST", (Object)pSDepSlnSysMQ.getPSDepSlnMQInstId())) != null) {
            this.onFillParentInfo_PSDepSlnMQInst(pSDepSlnSysMQ, (PSDepSlnMQInst)iEntity);
        }
        if (pSDepSlnSysMQ.getPSDepSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYS", (Object)pSDepSlnSysMQ.getPSDepSlnSysId())) != null) {
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysMQ, (PSDepSlnSys)iEntity);
        }
        if (pSDepSlnSysMQ.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnSysMQ.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnSysMQ, (PSDepSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnSysMQ, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSlnSysMQ, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnSysMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnMQInstId(bl, pSDepSlnSysMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysId(bl, pSDepSlnSysMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysMQId(bl, pSDepSlnSysMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysMQName(bl, pSDepSlnSysMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnSysMQ, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysMQ.isMemoDirty() : !pSDepSlnSysMQ.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnSysMQ.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSlnSysMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysMQ.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnSysMQ.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysMQ.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSlnSysMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnMQInstId(boolean bl, PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysMQ.isPSDepSlnMQInstIdDirty() && !bl2 : !pSDepSlnSysMQ.isPSDepSlnMQInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysMQ.getPSDepSlnMQInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMQINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnMQInstId_Default(pSDepSlnSysMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMQINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysId(boolean bl, PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysMQ.isPSDepSlnSysIdDirty() && !bl2 : !pSDepSlnSysMQ.isPSDepSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysMQ.getPSDepSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysId_Default(pSDepSlnSysMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysMQId(boolean bl, PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysMQ.isPSDepSlnSysMQIdDirty() && !bl2 : !pSDepSlnSysMQ.isPSDepSlnSysMQIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysMQ.getPSDepSlnSysMQId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSMQID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysMQId_Default(pSDepSlnSysMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSMQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysMQName(boolean bl, PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysMQ.isPSDepSlnSysMQNameDirty() && !bl2 : !pSDepSlnSysMQ.isPSDepSlnSysMQNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysMQ.getPSDepSlnSysMQName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSMQNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysMQName_Default(pSDepSlnSysMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSMQNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnSysMQ, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnSysMQ pSDepSlnSysMQ, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnSysMQ, bl);
    }

    public Object getDataContextValue(PSDepSlnSysMQ pSDepSlnSysMQ, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnSysMQ, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnSysMQ pSDepSlnSysMQ, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnSysMQ, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMQINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnMQInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMQINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnMQInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSMQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysMQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSMQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysMQName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnMQInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMQINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnMQInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMQINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysMQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSMQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysMQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSMQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDepSlnSysMQ pSDepSlnSysMQ) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnSysMQ)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnSysMQ pSDepSlnSysMQ) throws Exception {
        super.onUpdateParent(pSDepSlnSysMQ);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnSysMQ pSDepSlnSysMQ, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNSYSMQ");
        if (!bl) {
            pSDepSlnSysMQ.setCreateDate(null);
            pSDepSlnSysMQ.setCreateMan(null);
            pSDepSlnSysMQ.setPSDepSlnSysMQId(null);
            pSDepSlnSysMQ.setUpdateDate(null);
            pSDepSlnSysMQ.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnSysMQ, xmlNode, bl);
        }
    }
}

