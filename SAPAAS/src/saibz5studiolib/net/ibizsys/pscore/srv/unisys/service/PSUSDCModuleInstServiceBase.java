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
package net.ibizsys.pscore.srv.unisys.service;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserBase;
import net.ibizsys.pscore.srv.unisys.dao.PSUSDCModuleInstDAO;
import net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModule;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleBase;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInst;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInst;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstBase;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstFuncService;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstFuncServiceBase;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstRefService;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstRefServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSDCModuleInstServiceBase
extends PSCoreSysServiceBase<PSUSDCModuleInst> {
    private static final Log log = LogFactory.getLog(PSUSDCModuleInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSUSDCModuleInstDEModel pSUSDCModuleInstDEModel;
    private PSUSDCModuleInstDAO pSUSDCModuleInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService";
    }

    public PSUSDCModuleInstDEModel getPSUSDCModuleInstDEModel() {
        if (this.pSUSDCModuleInstDEModel == null) {
            try {
                this.pSUSDCModuleInstDEModel = (PSUSDCModuleInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCModuleInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUSDCModuleInstDEModel();
    }

    public PSUSDCModuleInstDAO getPSUSDCModuleInstDAO() {
        if (this.pSUSDCModuleInstDAO == null) {
            try {
                this.pSUSDCModuleInstDAO = (PSUSDCModuleInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.unisys.dao.PSUSDCModuleInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCModuleInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUSDCModuleInstDAO();
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

    protected void onFillParentInfo(PSUSDCModuleInst pSUSDCModuleInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSDCMODULEINST_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSUSDCModuleInst, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSDCMODULEINST_PSDEVUSER_ADMINPSDEVUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserService", (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = (PSDevUser)iService.getDEModel().createEntity();
            pSDevUser.set("PSDEVUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevUser);
            } else {
                iService.get((IEntity)pSDevUser);
            }
            this.onFillParentInfo_Adminpsdevuser(pSUSDCModuleInst, pSDevUser);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSDCMODULEINST_PSUSDCMODULE_PSUSDCMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleService", (SessionFactory)this.getSessionFactory());
            PSUSDCModule pSUSDCModule = (PSUSDCModule)iService.getDEModel().createEntity();
            pSUSDCModule.set("PSUSDCMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUSDCModule);
            } else {
                iService.get((IEntity)pSUSDCModule);
            }
            this.onFillParentInfo_PSUSDCModule(pSUSDCModuleInst, pSUSDCModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSDCMODULEINST_PSUSMODULEINST_PSUSMODULEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstService", (SessionFactory)this.getSessionFactory());
            PSUSModuleInst pSUSModuleInst = (PSUSModuleInst)iService.getDEModel().createEntity();
            pSUSModuleInst.set("PSUSMODULEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUSModuleInst);
            } else {
                iService.get((IEntity)pSUSModuleInst);
            }
            this.onFillParentInfo_PSUSModuleInst(pSUSDCModuleInst, pSUSModuleInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSUSDCModuleInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSUSDCModuleInst pSUSDCModuleInst, PSDevCenter pSDevCenter) throws Exception {
        pSUSDCModuleInst.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSUSDCModuleInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_Adminpsdevuser(PSUSDCModuleInst pSUSDCModuleInst, PSDevUser pSDevUser) throws Exception {
        pSUSDCModuleInst.setAdminPSDevUserId(pSDevUser.getPSDevUserId());
        pSUSDCModuleInst.setAdminPSDevUserName(pSDevUser.getPSDevUserName());
    }

    protected void onFillParentInfo_PSUSDCModule(PSUSDCModuleInst pSUSDCModuleInst, PSUSDCModule pSUSDCModule) throws Exception {
        pSUSDCModuleInst.setPSUSDCModuleId(pSUSDCModule.getPSUSDCModuleId());
        pSUSDCModuleInst.setPSUSDCModuleName(pSUSDCModule.getPSUSDCModuleName());
    }

    protected void onFillParentInfo_PSUSModuleInst(PSUSDCModuleInst pSUSDCModuleInst, PSUSModuleInst pSUSModuleInst) throws Exception {
        pSUSDCModuleInst.setPSUSModuleInstId(pSUSModuleInst.getPSUSModuleInstId());
        pSUSDCModuleInst.setPSUSModuleInstName(pSUSModuleInst.getPSUSModuleInstName());
    }

    protected void onFillEntityFullInfo(PSUSDCModuleInst pSUSDCModuleInst, boolean bl) throws Exception {
        if (bl && pSUSDCModuleInst.getValidFlag() == null) {
            pSUSDCModuleInst.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSUSDCModuleInst, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSUSDCModuleInst, bl);
        this.onFillEntityFullInfo_Adminpsdevuser(pSUSDCModuleInst, bl);
        this.onFillEntityFullInfo_PSUSDCModule(pSUSDCModuleInst, bl);
        this.onFillEntityFullInfo_PSUSModuleInst(pSUSDCModuleInst, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSUSDCModuleInst pSUSDCModuleInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Adminpsdevuser(PSUSDCModuleInst pSUSDCModuleInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSUSDCModule(PSUSDCModuleInst pSUSDCModuleInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSUSModuleInst(PSUSDCModuleInst pSUSDCModuleInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSUSDCModuleInst pSUSDCModuleInst, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSUSDCModuleInst, bl);
    }

    public ArrayList<PSUSDCModuleInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSUSDCModuleInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSUSDCModuleInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSUSDCModuleInst> selectByAdminpsdevuser(PSDevUserBase pSDevUserBase) throws Exception {
        return this.selectByAdminpsdevuser(pSDevUserBase, "", -1);
    }

    public ArrayList<PSUSDCModuleInst> selectByAdminpsdevuser(PSDevUserBase pSDevUserBase, String string) throws Exception {
        return this.selectByAdminpsdevuser(pSDevUserBase, string, -1);
    }

    public ArrayList<PSUSDCModuleInst> selectByAdminpsdevuser(PSDevUserBase pSDevUserBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ADMINPSDEVUSERID", (Object)pSDevUserBase.getPSDevUserId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAdminpsdevuserCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAdminpsdevuserCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSUSDCModuleInst> selectByPSUSDCModule(PSUSDCModuleBase pSUSDCModuleBase) throws Exception {
        return this.selectByPSUSDCModule(pSUSDCModuleBase, "", -1);
    }

    public ArrayList<PSUSDCModuleInst> selectByPSUSDCModule(PSUSDCModuleBase pSUSDCModuleBase, String string) throws Exception {
        return this.selectByPSUSDCModule(pSUSDCModuleBase, string, -1);
    }

    public ArrayList<PSUSDCModuleInst> selectByPSUSDCModule(PSUSDCModuleBase pSUSDCModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUSDCMODULEID", (Object)pSUSDCModuleBase.getPSUSDCModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUSDCModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUSDCModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSUSDCModuleInst> selectByPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase) throws Exception {
        return this.selectByPSUSModuleInst(pSUSModuleInstBase, "", -1);
    }

    public ArrayList<PSUSDCModuleInst> selectByPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase, String string) throws Exception {
        return this.selectByPSUSModuleInst(pSUSModuleInstBase, string, -1);
    }

    public ArrayList<PSUSDCModuleInst> selectByPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUSMODULEINSTID", (Object)pSUSModuleInstBase.getPSUSModuleInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUSModuleInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUSModuleInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSDCMODULEINST_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSUSDCMODULEINST", iDataEntityModel.getDataInfo((IEntity)pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSUSDCModuleInst pSUSDCModuleInst : arrayList) {
            PSUSDCModuleInst pSUSDCModuleInst2 = (PSUSDCModuleInst)this.getDEModel().createEntity();
            pSUSDCModuleInst2.setPSUSDCModuleInstId(pSUSDCModuleInst.getPSUSDCModuleInstId());
            pSUSDCModuleInst2.setPSDevCenterId(null);
            this.update(pSUSDCModuleInst2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSDCModuleInstServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSUSDCModuleInstServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSUSDCModuleInstServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSUSDCModuleInst pSUSDCModuleInst : arrayList) {
            this.remove((IEntity)pSUSDCModuleInst);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSUSDCModuleInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSUSDCModuleInst> arrayList) throws Exception {
    }

    public void testRemoveByAdminpsdevuser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByAdminpsdevuser(pSDevUser, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVUSER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevUser);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSDCMODULEINST_PSDEVUSER_ADMINPSDEVUSERID", "", iDataEntityModel.getName(), "PSUSDCMODULEINST", iDataEntityModel.getDataInfo((IEntity)pSDevUser), arrayList.get(0)));
        }
    }

    public void resetAdminpsdevuser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByAdminpsdevuser(pSDevUser);
        for (PSUSDCModuleInst pSUSDCModuleInst : arrayList) {
            PSUSDCModuleInst pSUSDCModuleInst2 = (PSUSDCModuleInst)this.getDEModel().createEntity();
            pSUSDCModuleInst2.setPSUSDCModuleInstId(pSUSDCModuleInst.getPSUSDCModuleInstId());
            pSUSDCModuleInst2.setAdminPSDevUserId(null);
            this.update(pSUSDCModuleInst2);
        }
    }

    public void removeByAdminpsdevuser(PSDevUser pSDevUser) throws Exception {
        final PSDevUser pSDevUser2 = pSDevUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSDCModuleInstServiceBase.this.onBeforeRemoveByAdminpsdevuser(pSDevUser2);
                PSUSDCModuleInstServiceBase.this.internalRemoveByAdminpsdevuser(pSDevUser2);
                PSUSDCModuleInstServiceBase.this.onAfterRemoveByAdminpsdevuser(pSDevUser2);
            }
        });
    }

    protected void onBeforeRemoveByAdminpsdevuser(PSDevUser pSDevUser) throws Exception {
    }

    protected void internalRemoveByAdminpsdevuser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByAdminpsdevuser(pSDevUser);
        this.onBeforeRemoveByAdminpsdevuser(pSDevUser, arrayList);
        for (PSUSDCModuleInst pSUSDCModuleInst : arrayList) {
            this.remove((IEntity)pSUSDCModuleInst);
        }
        this.onAfterRemoveByAdminpsdevuser(pSDevUser, arrayList);
    }

    protected void onAfterRemoveByAdminpsdevuser(PSDevUser pSDevUser) throws Exception {
    }

    protected void onBeforeRemoveByAdminpsdevuser(PSDevUser pSDevUser, ArrayList<PSUSDCModuleInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAdminpsdevuser(PSDevUser pSDevUser, ArrayList<PSUSDCModuleInst> arrayList) throws Exception {
    }

    public void testRemoveByPSUSDCModule(PSUSDCModule pSUSDCModule) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByPSUSDCModule(pSUSDCModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUSDCMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSUSDCModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSDCMODULEINST_PSUSDCMODULE_PSUSDCMODULEID", "", iDataEntityModel.getName(), "PSUSDCMODULEINST", iDataEntityModel.getDataInfo((IEntity)pSUSDCModule), arrayList.get(0)));
        }
    }

    public void resetPSUSDCModule(PSUSDCModule pSUSDCModule) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByPSUSDCModule(pSUSDCModule);
        for (PSUSDCModuleInst pSUSDCModuleInst : arrayList) {
            PSUSDCModuleInst pSUSDCModuleInst2 = (PSUSDCModuleInst)this.getDEModel().createEntity();
            pSUSDCModuleInst2.setPSUSDCModuleInstId(pSUSDCModuleInst.getPSUSDCModuleInstId());
            pSUSDCModuleInst2.setPSUSDCModuleId(null);
            this.update(pSUSDCModuleInst2);
        }
    }

    public void removeByPSUSDCModule(PSUSDCModule pSUSDCModule) throws Exception {
        final PSUSDCModule pSUSDCModule2 = pSUSDCModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSDCModuleInstServiceBase.this.onBeforeRemoveByPSUSDCModule(pSUSDCModule2);
                PSUSDCModuleInstServiceBase.this.internalRemoveByPSUSDCModule(pSUSDCModule2);
                PSUSDCModuleInstServiceBase.this.onAfterRemoveByPSUSDCModule(pSUSDCModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSUSDCModule(PSUSDCModule pSUSDCModule) throws Exception {
    }

    protected void internalRemoveByPSUSDCModule(PSUSDCModule pSUSDCModule) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByPSUSDCModule(pSUSDCModule);
        this.onBeforeRemoveByPSUSDCModule(pSUSDCModule, arrayList);
        for (PSUSDCModuleInst pSUSDCModuleInst : arrayList) {
            this.remove((IEntity)pSUSDCModuleInst);
        }
        this.onAfterRemoveByPSUSDCModule(pSUSDCModule, arrayList);
    }

    protected void onAfterRemoveByPSUSDCModule(PSUSDCModule pSUSDCModule) throws Exception {
    }

    protected void onBeforeRemoveByPSUSDCModule(PSUSDCModule pSUSDCModule, ArrayList<PSUSDCModuleInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUSDCModule(PSUSDCModule pSUSDCModule, ArrayList<PSUSDCModuleInst> arrayList) throws Exception {
    }

    public void testRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByPSUSModuleInst(pSUSModuleInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUSMODULEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSUSModuleInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSDCMODULEINST_PSUSMODULEINST_PSUSMODULEINSTID", "", iDataEntityModel.getName(), "PSUSDCMODULEINST", iDataEntityModel.getDataInfo((IEntity)pSUSModuleInst), arrayList.get(0)));
        }
    }

    public void resetPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByPSUSModuleInst(pSUSModuleInst);
        for (PSUSDCModuleInst pSUSDCModuleInst : arrayList) {
            PSUSDCModuleInst pSUSDCModuleInst2 = (PSUSDCModuleInst)this.getDEModel().createEntity();
            pSUSDCModuleInst2.setPSUSDCModuleInstId(pSUSDCModuleInst.getPSUSDCModuleInstId());
            pSUSDCModuleInst2.setPSUSModuleInstId(null);
            this.update(pSUSDCModuleInst2);
        }
    }

    public void removeByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        final PSUSModuleInst pSUSModuleInst2 = pSUSModuleInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSDCModuleInstServiceBase.this.onBeforeRemoveByPSUSModuleInst(pSUSModuleInst2);
                PSUSDCModuleInstServiceBase.this.internalRemoveByPSUSModuleInst(pSUSModuleInst2);
                PSUSDCModuleInstServiceBase.this.onAfterRemoveByPSUSModuleInst(pSUSModuleInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
    }

    protected void internalRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInst> arrayList = this.selectByPSUSModuleInst(pSUSModuleInst);
        this.onBeforeRemoveByPSUSModuleInst(pSUSModuleInst, arrayList);
        for (PSUSDCModuleInst pSUSDCModuleInst : arrayList) {
            this.remove((IEntity)pSUSDCModuleInst);
        }
        this.onAfterRemoveByPSUSModuleInst(pSUSModuleInst, arrayList);
    }

    protected void onAfterRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
    }

    protected void onBeforeRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst, ArrayList<PSUSDCModuleInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst, ArrayList<PSUSDCModuleInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSUSDCModuleInstFuncService)ServiceGlobal.getService(PSUSDCModuleInstFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSUSDCModuleInstFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSUSDCModuleInst(pSUSDCModuleInst);
        pSCoreSysServiceBase = (PSUSDCModuleInstRefService)ServiceGlobal.getService(PSUSDCModuleInstRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSUSDCModuleInstRefServiceBase)pSCoreSysServiceBase).testRemoveByPSUSDCModuleInst(pSUSDCModuleInst);
        pSCoreSysServiceBase = (PSUSDCModuleInstRefService)ServiceGlobal.getService(PSUSDCModuleInstRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSUSDCModuleInstRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSUSDCModuleInst(pSUSDCModuleInst);
        super.onBeforeRemove(pSUSDCModuleInst);
    }

    protected void replaceParentInfo(PSUSDCModuleInst pSUSDCModuleInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSUSDCModuleInst, cloneSession);
        if (pSUSDCModuleInst.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSUSDCModuleInst.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSUSDCModuleInst, (PSDevCenter)iEntity);
        }
        if (pSUSDCModuleInst.getAdminPSDevUserId() != null && (iEntity = cloneSession.getEntity("PSDEVUSER", (Object)pSUSDCModuleInst.getAdminPSDevUserId())) != null) {
            this.onFillParentInfo_Adminpsdevuser(pSUSDCModuleInst, (PSDevUser)iEntity);
        }
        if (pSUSDCModuleInst.getPSUSDCModuleId() != null && (iEntity = cloneSession.getEntity("PSUSDCMODULE", (Object)pSUSDCModuleInst.getPSUSDCModuleId())) != null) {
            this.onFillParentInfo_PSUSDCModule(pSUSDCModuleInst, (PSUSDCModule)iEntity);
        }
        if (pSUSDCModuleInst.getPSUSModuleInstId() != null && (iEntity = cloneSession.getEntity("PSUSMODULEINST", (Object)pSUSDCModuleInst.getPSUSModuleInstId())) != null) {
            this.onFillParentInfo_PSUSModuleInst(pSUSDCModuleInst, (PSUSModuleInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSUSDCModuleInst pSUSDCModuleInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSUSDCModuleInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AdminPSDevUserId(bl, pSUSDCModuleInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AdminServiceUrl(bl, pSUSDCModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AdminUrl(bl, pSUSDCModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstType(bl, pSUSDCModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSUSDCModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSUSDCModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSDCModuleId(bl, pSUSDCModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSDCModuleInstId(bl, pSUSDCModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSDCModuleInstName(bl, pSUSDCModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleInstId(bl, pSUSDCModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSUSDCModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSUSDCModuleInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AdminPSDevUserId(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isAdminPSDevUserIdDirty() : !pSUSDCModuleInst.isAdminPSDevUserIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInst.getAdminPSDevUserId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminPSDevUserId_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINPSDEVUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AdminServiceUrl(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isAdminServiceUrlDirty() : !pSUSDCModuleInst.isAdminServiceUrlDirty()) {
            return null;
        }
        String string = pSUSDCModuleInst.getAdminServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminServiceUrl_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINSERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AdminUrl(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isAdminUrlDirty() : !pSUSDCModuleInst.isAdminUrlDirty()) {
            return null;
        }
        String string = pSUSDCModuleInst.getAdminUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminUrl_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstType(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isInstTypeDirty() && !bl2 : !pSUSDCModuleInst.isInstTypeDirty()) {
            return null;
        }
        String string = pSUSDCModuleInst.getInstType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstType_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isMemoDirty() : !pSUSDCModuleInst.isMemoDirty()) {
            return null;
        }
        String string = pSUSDCModuleInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isPSDevCenterIdDirty() : !pSUSDCModuleInst.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInst.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSDCModuleId(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isPSUSDCModuleIdDirty() : !pSUSDCModuleInst.isPSUSDCModuleIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInst.getPSUSDCModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSDCModuleId_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSDCModuleInstId(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isPSUSDCModuleInstIdDirty() && !bl2 : !pSUSDCModuleInst.isPSUSDCModuleInstIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInst.getPSUSDCModuleInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSDCModuleInstId_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSDCModuleInstName(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isPSUSDCModuleInstNameDirty() && !bl2 : !pSUSDCModuleInst.isPSUSDCModuleInstNameDirty()) {
            return null;
        }
        String string = pSUSDCModuleInst.getPSUSDCModuleInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSDCModuleInstName_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSModuleInstId(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isPSUSModuleInstIdDirty() : !pSUSDCModuleInst.isPSUSModuleInstIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInst.getPSUSModuleInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleInstId_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSUSDCModuleInst pSUSDCModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInst.isValidFlagDirty() && !bl2 : !pSUSDCModuleInst.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSUSDCModuleInst.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSUSDCModuleInst, bl2, bl3);
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

    protected void onSyncEntity(PSUSDCModuleInst pSUSDCModuleInst, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSUSDCModuleInst, bl);
    }

    protected void onSyncIndexEntities(PSUSDCModuleInst pSUSDCModuleInst, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSUSDCModuleInst, bl);
    }

    public Object getDataContextValue(PSUSDCModuleInst pSUSDCModuleInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSUSDCModuleInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSUSDCModule pSUSDCModule = pSUSDCModuleInst.getPSUSDCModule();
        if (pSUSDCModule != null && pSUSDCModule.contains(string)) {
            return pSUSDCModule.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSUSDCModuleInst pSUSDCModuleInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSUSDCModuleInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADMINPSDEVUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPSDevUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINPSDEVUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPSDevUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINSERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AdminPSDevUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINPSDEVUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AdminPSDevUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINPSDEVUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AdminServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINSERVICEURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AdminUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_InstType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSDCModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSDCModuleInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSDCModuleInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSDCModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSModuleInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSModuleInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSUSDCModuleInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        super.onUpdateParent((IEntity)pSUSDCModuleInst);
    }

    @Override
    protected void exportCurXmlModel(PSUSDCModuleInst pSUSDCModuleInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUSDCMODULEINST");
        if (!bl) {
            pSUSDCModuleInst.setAdminPSDevUserName(null);
            pSUSDCModuleInst.setCreateDate(null);
            pSUSDCModuleInst.setCreateMan(null);
            pSUSDCModuleInst.setPSDevCenterName(null);
            pSUSDCModuleInst.setPSUSDCModuleInstId(null);
            pSUSDCModuleInst.setPSUSDCModuleName(null);
            pSUSDCModuleInst.setPSUSModuleInstName(null);
            pSUSDCModuleInst.setUpdateDate(null);
            pSUSDCModuleInst.setUpdateMan(null);
            super.exportCurXmlModel(pSUSDCModuleInst, xmlNode, bl);
        }
    }
}

