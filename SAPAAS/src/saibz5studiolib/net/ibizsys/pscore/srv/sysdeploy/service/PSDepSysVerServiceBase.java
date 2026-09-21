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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSysVerDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSysVerDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAPIService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAPIServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSysVerServiceBase
extends PSCoreSysServiceBase<PSDepSysVer> {
    private static final Log log = LogFactory.getLog(PSDepSysVerServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSysVerDEModel pSDepSysVerDEModel;
    private PSDepSysVerDAO pSDepSysVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService";
    }

    public PSDepSysVerDEModel getPSDepSysVerDEModel() {
        if (this.pSDepSysVerDEModel == null) {
            try {
                this.pSDepSysVerDEModel = (PSDepSysVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSysVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSysVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSysVerDEModel();
    }

    public PSDepSysVerDAO getPSDepSysVerDAO() {
        if (this.pSDepSysVerDAO == null) {
            try {
                this.pSDepSysVerDAO = (PSDepSysVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSysVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSysVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSysVerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSysVer pSDepSysVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSVER_PSDEPSYS_PSDEPSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysService", (SessionFactory)this.getSessionFactory());
            PSDepSys pSDepSys = (PSDepSys)iService.getDEModel().createEntity();
            pSDepSys.set("PSDEPSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSys);
            } else {
                iService.get((IEntity)pSDepSys);
            }
            this.onFillParentInfo_PSDepSys(pSDepSysVer, pSDepSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSVER_PSDEVSLNSYSVER_PSDEVSLNSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysVer pSDevSlnSysVer = (PSDevSlnSysVer)iService.getDEModel().createEntity();
            pSDevSlnSysVer.set("PSDEVSLNSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysVer);
            } else {
                iService.get((IEntity)pSDevSlnSysVer);
            }
            this.onFillParentInfo_PSDevSlnSysVer(pSDepSysVer, pSDevSlnSysVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSVER_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDepSysVer, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSVER_PSSAASSYSVER_PSSAASSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService", (SessionFactory)this.getSessionFactory());
            PSSaaSSysVer pSSaaSSysVer = (PSSaaSSysVer)iService.getDEModel().createEntity();
            pSSaaSSysVer.set("PSSAASSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSaaSSysVer);
            } else {
                iService.get((IEntity)pSSaaSSysVer);
            }
            this.onFillParentInfo_PSSaaSSysVer(pSDepSysVer, pSSaaSSysVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSVER_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelInst);
            } else {
                iService.get((IEntity)pSSysModelInst);
            }
            this.onFillParentInfo_PSSysModelInst(pSDepSysVer, pSSysModelInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSysVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSys(PSDepSysVer pSDepSysVer, PSDepSys pSDepSys) throws Exception {
        pSDepSysVer.setPSDepSysId(pSDepSys.getPSDepSysId());
        pSDepSysVer.setPSDepSysName(pSDepSys.getPSDepSysName());
    }

    protected void onFillParentInfo_PSDevSlnSysVer(PSDepSysVer pSDepSysVer, PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        pSDepSysVer.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
        pSDepSysVer.setPSDevSlnSysVerName(pSDevSlnSysVer.getPSDevSlnSysVerName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDepSysVer pSDepSysVer, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDepSysVer.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDepSysVer.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSSaaSSysVer(PSDepSysVer pSDepSysVer, PSSaaSSysVer pSSaaSSysVer) throws Exception {
        pSDepSysVer.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
        pSDepSysVer.setPSSaaSSysVerName(pSSaaSSysVer.getPSSaaSSysVerName());
    }

    protected void onFillParentInfo_PSSysModelInst(PSDepSysVer pSDepSysVer, PSSysModelInst pSSysModelInst) throws Exception {
        pSDepSysVer.setModelInstVer(pSSysModelInst.getModelVer());
        pSDepSysVer.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSDepSysVer.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected void onFillEntityFullInfo(PSDepSysVer pSDepSysVer, boolean bl) throws Exception {
        if (bl && pSDepSysVer.getValidFlag() == null) {
            pSDepSysVer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDepSysVer, bl);
        this.onFillEntityFullInfo_PSDepSys(pSDepSysVer, bl);
        this.onFillEntityFullInfo_PSDevSlnSysVer(pSDepSysVer, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDepSysVer, bl);
        this.onFillEntityFullInfo_PSSaaSSysVer(pSDepSysVer, bl);
        this.onFillEntityFullInfo_PSSysModelInst(pSDepSysVer, bl);
    }

    protected void onFillEntityFullInfo_PSDepSys(PSDepSysVer pSDepSysVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysVer(PSDepSysVer pSDepSysVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDepSysVer pSDepSysVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSaaSSysVer(PSDepSysVer pSDepSysVer, boolean bl) throws Exception {
        if (pSDepSysVer.isPSSaaSSysVerIdDirty()) {
            if (pSDepSysVer.getPSSaaSSysVerId() != null) {
                if (pSDepSysVer.getPSSaaSSysVerId() == null || pSDepSysVer.getPSSaaSSysVerName() == null) {
                    PSSaaSSysVer pSSaaSSysVer = pSDepSysVer.getPSSaaSSysVer();
                    pSDepSysVer.setPSSaaSSysVerName(pSSaaSSysVer.getPSSaaSSysVerName());
                }
            } else {
                pSDepSysVer.setPSSaaSSysVerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysModelInst(PSDepSysVer pSDepSysVer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSysVer pSDepSysVer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSysVer, bl);
    }

    public ArrayList<PSDepSysVer> selectByPSDepSys(PSDepSysBase pSDepSysBase) throws Exception {
        return this.selectByPSDepSys(pSDepSysBase, "", -1);
    }

    public ArrayList<PSDepSysVer> selectByPSDepSys(PSDepSysBase pSDepSysBase, String string) throws Exception {
        return this.selectByPSDepSys(pSDepSysBase, string, -1);
    }

    public ArrayList<PSDepSysVer> selectByPSDepSys(PSDepSysBase pSDepSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSYSID", (Object)pSDepSysBase.getPSDepSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSysVer> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase) throws Exception {
        return this.selectByPSDevSlnSysVer(pSDevSlnSysVerBase, "", -1);
    }

    public ArrayList<PSDepSysVer> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string) throws Exception {
        return this.selectByPSDevSlnSysVer(pSDevSlnSysVerBase, string, -1);
    }

    public ArrayList<PSDepSysVer> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSVERID", (Object)pSDevSlnSysVerBase.getPSDevSlnSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSysVer> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDepSysVer> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDepSysVer> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSysVer> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase) throws Exception {
        return this.selectByPSSaaSSysVer(pSSaaSSysVerBase, "", -1);
    }

    public ArrayList<PSDepSysVer> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase, String string) throws Exception {
        return this.selectByPSSaaSSysVer(pSSaaSSysVerBase, string, -1);
    }

    public ArrayList<PSDepSysVer> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSVERID", (Object)pSSaaSSysVerBase.getPSSaaSSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSysVer> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSDepSysVer> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSDepSysVer> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSys(PSDepSys pSDepSys) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSDepSys(pSDepSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSYSVER_PSDEPSYS_PSDEPSYSID", "", iDataEntityModel.getName(), "PSDEPSYSVER", iDataEntityModel.getDataInfo((IEntity)pSDepSys), arrayList.get(0)));
        }
    }

    public void resetPSDepSys(PSDepSys pSDepSys) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSDepSys(pSDepSys);
        for (PSDepSysVer pSDepSysVer : arrayList) {
            PSDepSysVer pSDepSysVer2 = (PSDepSysVer)this.getDEModel().createEntity();
            pSDepSysVer2.setPSDepSysVerId(pSDepSysVer.getPSDepSysVerId());
            pSDepSysVer2.setPSDepSysId(null);
            this.update(pSDepSysVer2);
        }
    }

    public void removeByPSDepSys(PSDepSys pSDepSys) throws Exception {
        final PSDepSys pSDepSys2 = pSDepSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysVerServiceBase.this.onBeforeRemoveByPSDepSys(pSDepSys2);
                PSDepSysVerServiceBase.this.internalRemoveByPSDepSys(pSDepSys2);
                PSDepSysVerServiceBase.this.onAfterRemoveByPSDepSys(pSDepSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSys(PSDepSys pSDepSys) throws Exception {
    }

    protected void internalRemoveByPSDepSys(PSDepSys pSDepSys) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSDepSys(pSDepSys);
        this.onBeforeRemoveByPSDepSys(pSDepSys, arrayList);
        for (PSDepSysVer pSDepSysVer : arrayList) {
            this.remove((IEntity)pSDepSysVer);
        }
        this.onAfterRemoveByPSDepSys(pSDepSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSys(PSDepSys pSDepSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSys(PSDepSys pSDepSys, ArrayList<PSDepSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSys(PSDepSys pSDepSys, ArrayList<PSDepSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSYSVER_PSDEVSLNSYSVER_PSDEVSLNSYSVERID", "", iDataEntityModel.getName(), "PSDEPSYSVER", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysVer), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer);
        for (PSDepSysVer pSDepSysVer : arrayList) {
            PSDepSysVer pSDepSysVer2 = (PSDepSysVer)this.getDEModel().createEntity();
            pSDepSysVer2.setPSDepSysVerId(pSDepSysVer.getPSDepSysVerId());
            pSDepSysVer2.setPSDevSlnSysVerId(null);
            this.update(pSDepSysVer2);
        }
    }

    public void removeByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        final PSDevSlnSysVer pSDevSlnSysVer2 = pSDevSlnSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysVerServiceBase.this.onBeforeRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
                PSDepSysVerServiceBase.this.internalRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
                PSDepSysVerServiceBase.this.onAfterRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer);
        this.onBeforeRemoveByPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
        for (PSDepSysVer pSDepSysVer : arrayList) {
            this.remove((IEntity)pSDepSysVer);
        }
        this.onAfterRemoveByPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSDepSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSDepSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSYSVER_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEPSYSVER", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDepSysVer pSDepSysVer : arrayList) {
            PSDepSysVer pSDepSysVer2 = (PSDepSysVer)this.getDEModel().createEntity();
            pSDepSysVer2.setPSDepSysVerId(pSDepSysVer.getPSDepSysVerId());
            pSDepSysVer2.setPSDevSlnSysId(null);
            this.update(pSDepSysVer2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysVerServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDepSysVerServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDepSysVerServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDepSysVer pSDepSysVer : arrayList) {
            this.remove((IEntity)pSDepSysVer);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDepSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDepSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    public void resetPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer);
        for (PSDepSysVer pSDepSysVer : arrayList) {
            PSDepSysVer pSDepSysVer2 = (PSDepSysVer)this.getDEModel().createEntity();
            pSDepSysVer2.setPSDepSysVerId(pSDepSysVer.getPSDepSysVerId());
            pSDepSysVer2.setPSSaaSSysVerId(null);
            this.update(pSDepSysVer2);
        }
    }

    public void removeByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        final PSSaaSSysVer pSSaaSSysVer2 = pSSaaSSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysVerServiceBase.this.onBeforeRemoveByPSSaaSSysVer(pSSaaSSysVer2);
                PSDepSysVerServiceBase.this.internalRemoveByPSSaaSSysVer(pSSaaSSysVer2);
                PSDepSysVerServiceBase.this.onAfterRemoveByPSSaaSSysVer(pSSaaSSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    protected void internalRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer);
        this.onBeforeRemoveByPSSaaSSysVer(pSSaaSSysVer, arrayList);
        for (PSDepSysVer pSDepSysVer : arrayList) {
            this.remove((IEntity)pSDepSysVer);
        }
        this.onAfterRemoveByPSSaaSSysVer(pSSaaSSysVer, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer, ArrayList<PSDepSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer, ArrayList<PSDepSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSSysModelInst(pSSysModelInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysModelInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSYSVER_PSSYSMODELINST_PSSYSMODELINSTID", "", iDataEntityModel.getName(), "PSDEPSYSVER", iDataEntityModel.getDataInfo((IEntity)pSSysModelInst), arrayList.get(0)));
        }
    }

    public void resetPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        for (PSDepSysVer pSDepSysVer : arrayList) {
            PSDepSysVer pSDepSysVer2 = (PSDepSysVer)this.getDEModel().createEntity();
            pSDepSysVer2.setPSDepSysVerId(pSDepSysVer.getPSDepSysVerId());
            pSDepSysVer2.setPSSysModelInstId(null);
            this.update(pSDepSysVer2);
        }
    }

    public void removeByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysVerServiceBase.this.onBeforeRemoveByPSSysModelInst(pSSysModelInst2);
                PSDepSysVerServiceBase.this.internalRemoveByPSSysModelInst(pSSysModelInst2);
                PSDepSysVerServiceBase.this.onAfterRemoveByPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDepSysVer> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByPSSysModelInst(pSSysModelInst, arrayList);
        for (PSDepSysVer pSDepSysVer : arrayList) {
            this.remove((IEntity)pSDepSysVer);
        }
        this.onAfterRemoveByPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDepSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDepSysVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSysVer pSDepSysVer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSysVer(pSDepSysVer);
        pSCoreSysServiceBase = (PSDepSysAPIService)ServiceGlobal.getService(PSDepSysAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSysAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSysVer(pSDepSysVer);
        pSCoreSysServiceBase = (PSDepSysAppService)ServiceGlobal.getService(PSDepSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSysVer(pSDepSysVer);
        super.onBeforeRemove(pSDepSysVer);
    }

    protected void replaceParentInfo(PSDepSysVer pSDepSysVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSysVer, cloneSession);
        if (pSDepSysVer.getPSDepSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSYS", (Object)pSDepSysVer.getPSDepSysId())) != null) {
            this.onFillParentInfo_PSDepSys(pSDepSysVer, (PSDepSys)iEntity);
        }
        if (pSDepSysVer.getPSDevSlnSysVerId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSVER", (Object)pSDepSysVer.getPSDevSlnSysVerId())) != null) {
            this.onFillParentInfo_PSDevSlnSysVer(pSDepSysVer, (PSDevSlnSysVer)iEntity);
        }
        if (pSDepSysVer.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDepSysVer.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDepSysVer, (PSDevSlnSys)iEntity);
        }
        if (pSDepSysVer.getPSSaaSSysVerId() != null && (iEntity = cloneSession.getEntity("PSSAASSYSVER", (Object)pSDepSysVer.getPSSaaSSysVerId())) != null) {
            this.onFillParentInfo_PSSaaSSysVer(pSDepSysVer, (PSSaaSSysVer)iEntity);
        }
        if (pSDepSysVer.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSDepSysVer.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_PSSysModelInst(pSDepSysVer, (PSSysModelInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSysVer pSDepSysVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSysVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDepSysVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBVersion(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysId(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysVerId(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysVerName(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysVerType(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysVerId(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysVerId(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysVerName(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysVer(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag2(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag3(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag4(bl, pSDepSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSysVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isCodeNameDirty() : !pSDepSysVer.isCodeNameDirty()) {
            return null;
        }
        String string = pSDepSysVer.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBVersion(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isDBVersionDirty() : !pSDepSysVer.isDBVersionDirty()) {
            return null;
        }
        Integer n = pSDepSysVer.getDBVersion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DBVersion_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBVERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isMemoDirty() : !pSDepSysVer.isMemoDirty()) {
            return null;
        }
        String string = pSDepSysVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSysId(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isPSDepSysIdDirty() && !bl2 : !pSDepSysVer.isPSDepSysIdDirty()) {
            return null;
        }
        String string = pSDepSysVer.getPSDepSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysId_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysVerId(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isPSDepSysVerIdDirty() && !bl2 : !pSDepSysVer.isPSDepSysVerIdDirty()) {
            return null;
        }
        String string = pSDepSysVer.getPSDepSysVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysVerId_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysVerName(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isPSDepSysVerNameDirty() && !bl2 : !pSDepSysVer.isPSDepSysVerNameDirty()) {
            return null;
        }
        String string = pSDepSysVer.getPSDepSysVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysVerName_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysVerType(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isPSDepSysVerTypeDirty() && !bl2 : !pSDepSysVer.isPSDepSysVerTypeDirty()) {
            return null;
        }
        String string = pSDepSysVer.getPSDepSysVerType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSVERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysVerType_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSVERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isPSDevSlnSysIdDirty() && !bl2 : !pSDepSysVer.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSysVer.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysVerId(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isPSDevSlnSysVerIdDirty() : !pSDepSysVer.isPSDevSlnSysVerIdDirty()) {
            return null;
        }
        String string = pSDepSysVer.getPSDevSlnSysVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysVerId_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysVerId(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isPSSaaSSysVerIdDirty() : !pSDepSysVer.isPSSaaSSysVerIdDirty()) {
            return null;
        }
        String string = pSDepSysVer.getPSSaaSSysVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysVerId_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysVerName(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isPSSaaSSysVerNameDirty() : !pSDepSysVer.isPSSaaSSysVerNameDirty()) {
            return null;
        }
        String string = pSDepSysVer.getPSSaaSSysVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysVerName_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isPSSysModelInstIdDirty() : !pSDepSysVer.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSDepSysVer.getPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isPSSystemIdDirty() : !pSDepSysVer.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDepSysVer.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysVer(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isSysVerDirty() : !pSDepSysVer.isSysVerDirty()) {
            return null;
        }
        String string = pSDepSysVer.getSysVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysVer_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isUserCatDirty() : !pSDepSysVer.isUserCatDirty()) {
            return null;
        }
        String string = pSDepSysVer.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isUserTagDirty() : !pSDepSysVer.isUserTagDirty()) {
            return null;
        }
        String string = pSDepSysVer.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isUserTag2Dirty() : !pSDepSysVer.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDepSysVer.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isUserTag3Dirty() : !pSDepSysVer.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDepSysVer.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isUserTag4Dirty() : !pSDepSysVer.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDepSysVer.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isValidFlagDirty() : !pSDepSysVer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDepSysVer.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isVerTagDirty() : !pSDepSysVer.isVerTagDirty()) {
            return null;
        }
        String string = pSDepSysVer.getVerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag2(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isVerTag2Dirty() : !pSDepSysVer.isVerTag2Dirty()) {
            return null;
        }
        String string = pSDepSysVer.getVerTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag2_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag3(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isVerTag3Dirty() : !pSDepSysVer.isVerTag3Dirty()) {
            return null;
        }
        String string = pSDepSysVer.getVerTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag3_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag4(boolean bl, PSDepSysVer pSDepSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysVer.isVerTag4Dirty() : !pSDepSysVer.isVerTag4Dirty()) {
            return null;
        }
        String string = pSDepSysVer.getVerTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag4_Default((IEntity)pSDepSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSysVer pSDepSysVer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSysVer, bl);
    }

    protected void onSyncIndexEntities(PSDepSysVer pSDepSysVer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSysVer, bl);
    }

    public Object getDataContextValue(PSDepSysVer pSDepSysVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSysVer, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSys pSDepSys = pSDepSysVer.getPSDepSys();
        if (pSDepSys != null && pSDepSys.contains(string)) {
            return pSDepSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSysVer pSDepSysVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSysVer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBVERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBVersion_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELINSTVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelInstVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSVERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysVerType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag4_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DBVersion_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ModelInstVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDepSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysVerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSVERTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSVER", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_VerTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDepSysVer pSDepSysVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSysVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSysVer pSDepSysVer) throws Exception {
        super.onUpdateParent((IEntity)pSDepSysVer);
    }

    @Override
    protected void exportCurXmlModel(PSDepSysVer pSDepSysVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSYSVER");
        if (!bl) {
            pSDepSysVer.setCreateDate(null);
            pSDepSysVer.setCreateMan(null);
            pSDepSysVer.setDBVersion(null);
            pSDepSysVer.setPSDepSysVerId(null);
            pSDepSysVer.setPSDepSysVerType(null);
            pSDepSysVer.setPSDevSlnSysId(null);
            pSDepSysVer.setPSDevSlnSysName(null);
            pSDepSysVer.setPSSysModelInstName(null);
            pSDepSysVer.setUpdateDate(null);
            pSDepSysVer.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSysVer, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSDepSysVer pSDepSysVer) throws Exception {
        return pSDepSysVer.getPSDepSysVerType();
    }
}

