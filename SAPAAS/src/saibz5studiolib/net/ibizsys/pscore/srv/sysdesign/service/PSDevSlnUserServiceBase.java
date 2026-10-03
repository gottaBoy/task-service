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
package net.ibizsys.pscore.srv.sysdesign.service;

import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObj;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObjBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnUserDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnUserDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnUserServiceBase
extends PSCoreSysServiceBase<PSDevSlnUser> {
    private static final Log log = LogFactory.getLog(PSDevSlnUserServiceBase.class);
    public static final String DATASET_CTXDC = "CtxDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnUserDEModel pSDevSlnUserDEModel;
    private PSDevSlnUserDAO pSDevSlnUserDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService";
    }

    public PSDevSlnUserDEModel getPSDevSlnUserDEModel() {
        if (this.pSDevSlnUserDEModel == null) {
            try {
                this.pSDevSlnUserDEModel = (PSDevSlnUserDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnUserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnUserDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnUserDEModel();
    }

    public PSDevSlnUserDAO getPSDevSlnUserDAO() {
        if (this.pSDevSlnUserDAO == null) {
            try {
                this.pSDevSlnUserDAO = (PSDevSlnUserDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnUserDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnUserDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnUserDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CTXDC, (boolean)true) == 0) {
            return this.fetchCurCtxDC(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurCtxDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CTXDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevSlnUser pSDevSlnUser, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSER_PSDEVSLNSYSDYNAINST_PSDEVSLNSYSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = (PSDevSlnSysDynaInst)iService.getDEModel().createEntity();
            pSDevSlnSysDynaInst.set("PSDEVSLNSYSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysDynaInst);
            } else {
                iService.get(pSDevSlnSysDynaInst);
            }
            this.onFillParentInfo_PSDevSlnSysDynaInst(pSDevSlnUser, pSDevSlnSysDynaInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSER_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnUser, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSER_PSDEVSLNTEMPL_PSDEVSLNTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService", (SessionFactory)this.getSessionFactory());
            PSDevSlnTempl pSDevSlnTempl = (PSDevSlnTempl)iService.getDEModel().createEntity();
            pSDevSlnTempl.set("PSDEVSLNTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnTempl);
            } else {
                iService.get(pSDevSlnTempl);
            }
            this.onFillParentInfo_PSDevSlnTempl(pSDevSlnUser, pSDevSlnTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSER_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnUser, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSER_PSDEVUSEROBJ_PSDEVUSEROBJID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserObjService", (SessionFactory)this.getSessionFactory());
            PSDevUserObj pSDevUserObj = (PSDevUserObj)iService.getDEModel().createEntity();
            pSDevUserObj.set("PSDEVUSEROBJID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevUserObj);
            } else {
                iService.get(pSDevUserObj);
            }
            this.onFillParentInfo_PSDevUserObj(pSDevSlnUser, pSDevUserObj);
            return;
        }
        super.onFillParentInfo(pSDevSlnUser, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnSysDynaInst(PSDevSlnUser pSDevSlnUser, PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        pSDevSlnUser.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
        pSDevSlnUser.setPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnUser pSDevSlnUser, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnUser.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnUser.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
        if (pSDevSlnSys.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnUser, pSDevSlnSys.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PSDevSlnTempl(PSDevSlnUser pSDevSlnUser, PSDevSlnTempl pSDevSlnTempl) throws Exception {
        pSDevSlnUser.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
        pSDevSlnUser.setPSDevSlnTemplName(pSDevSlnTempl.getPSDevSlnTemplName());
        if (pSDevSlnTempl.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnUser, pSDevSlnTempl.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnUser pSDevSlnUser, PSDevSln pSDevSln) throws Exception {
        pSDevSlnUser.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnUser.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSDevUserObj(PSDevSlnUser pSDevSlnUser, PSDevUserObj pSDevUserObj) throws Exception {
        pSDevSlnUser.setDevUserObjType(pSDevUserObj.getPSDevUserObjType());
        pSDevSlnUser.setPSDevUserObjId(pSDevUserObj.getPSDevUserObjectId());
        pSDevSlnUser.setPSDevUserObjName(pSDevUserObj.getPSDevUserObjName());
    }

    protected void onFillEntityFullInfo(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnUser.getAccMode() == null) {
                pSDevSlnUser.setAccMode((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDevSlnUser.getDefaultFlag() == null) {
                pSDevSlnUser.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevSlnUser, bl);
        this.onFillEntityFullInfo_PSDevSlnSysDynaInst(pSDevSlnUser, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnUser, bl);
        this.onFillEntityFullInfo_PSDevSlnTempl(pSDevSlnUser, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnUser, bl);
        this.onFillEntityFullInfo_PSDevUserObj(pSDevSlnUser, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnSysDynaInst(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnTempl(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevUserObj(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnUser, bl);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase) throws Exception {
        return this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInstBase, "", -1);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, String string) throws Exception {
        return this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInstBase, string, -1);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSDYNAINSTID", (Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnUser> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase) throws Exception {
        return this.selectByPSDevSlnTempl(pSDevSlnTemplBase, "", -1);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string) throws Exception {
        return this.selectByPSDevSlnTempl(pSDevSlnTemplBase, string, -1);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNTEMPLID", (Object)pSDevSlnTemplBase.getPSDevSlnTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnUser> selectByPSDevUserObj(PSDevUserObjBase pSDevUserObjBase) throws Exception {
        return this.selectByPSDevUserObj(pSDevUserObjBase, "", -1);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevUserObj(PSDevUserObjBase pSDevUserObjBase, String string) throws Exception {
        return this.selectByPSDevUserObj(pSDevUserObjBase, string, -1);
    }

    public ArrayList<PSDevSlnUser> selectByPSDevUserObj(PSDevUserObjBase pSDevUserObjBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVUSEROBJID", (Object)pSDevUserObjBase.getPSDevUserObjectId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevUserObjCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevUserObjCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSDYNAINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSysDynaInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNUSER_PSDEVSLNSYSDYNAINST_PSDEVSLNSYSDYNAINSTID", "", iDataEntityModel.getName(), "PSDEVSLNUSER", iDataEntityModel.getDataInfo(pSDevSlnSysDynaInst), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            PSDevSlnUser pSDevSlnUser2 = (PSDevSlnUser)this.getDEModel().createEntity();
            pSDevSlnUser2.setPSDevSlnUserId(pSDevSlnUser.getPSDevSlnUserId());
            pSDevSlnUser2.setPSDevSlnSysDynaInstId(null);
            this.update(pSDevSlnUser2);
        }
    }

    public void removeByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnUserServiceBase.this.onBeforeRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
                PSDevSlnUserServiceBase.this.internalRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
                PSDevSlnUserServiceBase.this.onAfterRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        this.onBeforeRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, arrayList);
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            this.remove(pSDevSlnUser);
        }
        this.onAfterRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<PSDevSlnUser> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<PSDevSlnUser> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNUSER_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNUSER", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            PSDevSlnUser pSDevSlnUser2 = (PSDevSlnUser)this.getDEModel().createEntity();
            pSDevSlnUser2.setPSDevSlnUserId(pSDevSlnUser.getPSDevSlnUserId());
            pSDevSlnUser2.setPSDevSlnSysId(null);
            this.update(pSDevSlnUser2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnUserServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnUserServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnUserServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            this.remove(pSDevSlnUser);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnUser> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnUser> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNUSER_PSDEVSLNTEMPL_PSDEVSLNTEMPLID", "", iDataEntityModel.getName(), "PSDEVSLNUSER", iDataEntityModel.getDataInfo(pSDevSlnTempl), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl);
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            PSDevSlnUser pSDevSlnUser2 = (PSDevSlnUser)this.getDEModel().createEntity();
            pSDevSlnUser2.setPSDevSlnUserId(pSDevSlnUser.getPSDevSlnUserId());
            pSDevSlnUser2.setPSDevSlnTemplId(null);
            this.update(pSDevSlnUser2);
        }
    }

    public void removeByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnUserServiceBase.this.onBeforeRemoveByPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnUserServiceBase.this.internalRemoveByPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnUserServiceBase.this.onAfterRemoveByPSDevSlnTempl(pSDevSlnTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void internalRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl);
        this.onBeforeRemoveByPSDevSlnTempl(pSDevSlnTempl, arrayList);
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            this.remove(pSDevSlnUser);
        }
        this.onAfterRemoveByPSDevSlnTempl(pSDevSlnTempl, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnUser> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnUser> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            PSDevSlnUser pSDevSlnUser2 = (PSDevSlnUser)this.getDEModel().createEntity();
            pSDevSlnUser2.setPSDevSlnUserId(pSDevSlnUser.getPSDevSlnUserId());
            pSDevSlnUser2.setPSDevSlnId(null);
            this.update(pSDevSlnUser2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnUserServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnUserServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnUserServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            this.remove(pSDevSlnUser);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnUser> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnUser> arrayList) throws Exception {
    }

    public void testRemoveByPSDevUserObj(PSDevUserObj pSDevUserObj) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevUserObj(pSDevUserObj, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVUSEROBJ");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevUserObj);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNUSER_PSDEVUSEROBJ_PSDEVUSEROBJID", "", iDataEntityModel.getName(), "PSDEVSLNUSER", iDataEntityModel.getDataInfo(pSDevUserObj), arrayList.get(0)));
        }
    }

    public void resetPSDevUserObj(PSDevUserObj pSDevUserObj) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevUserObj(pSDevUserObj);
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            PSDevSlnUser pSDevSlnUser2 = (PSDevSlnUser)this.getDEModel().createEntity();
            pSDevSlnUser2.setPSDevSlnUserId(pSDevSlnUser.getPSDevSlnUserId());
            pSDevSlnUser2.setPSDevUserObjId(null);
            this.update(pSDevSlnUser2);
        }
    }

    public void removeByPSDevUserObj(PSDevUserObj pSDevUserObj) throws Exception {
        final PSDevUserObj pSDevUserObj2 = pSDevUserObj;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnUserServiceBase.this.onBeforeRemoveByPSDevUserObj(pSDevUserObj2);
                PSDevSlnUserServiceBase.this.internalRemoveByPSDevUserObj(pSDevUserObj2);
                PSDevSlnUserServiceBase.this.onAfterRemoveByPSDevUserObj(pSDevUserObj2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevUserObj(PSDevUserObj pSDevUserObj) throws Exception {
    }

    protected void internalRemoveByPSDevUserObj(PSDevUserObj pSDevUserObj) throws Exception {
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevUserObj(pSDevUserObj);
        this.onBeforeRemoveByPSDevUserObj(pSDevUserObj, arrayList);
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            this.remove(pSDevSlnUser);
        }
        this.onAfterRemoveByPSDevUserObj(pSDevUserObj, arrayList);
    }

    protected void onAfterRemoveByPSDevUserObj(PSDevUserObj pSDevUserObj) throws Exception {
    }

    protected void onBeforeRemoveByPSDevUserObj(PSDevUserObj pSDevUserObj, ArrayList<PSDevSlnUser> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevUserObj(PSDevUserObj pSDevUserObj, ArrayList<PSDevSlnUser> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnUser pSDevSlnUser) throws Exception {
        super.onBeforeRemove(pSDevSlnUser);
    }

    protected void replaceParentInfo(PSDevSlnUser pSDevSlnUser, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnUser, cloneSession);
        if (pSDevSlnUser.getPSDevSlnSysDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSDYNAINST", (Object)pSDevSlnUser.getPSDevSlnSysDynaInstId())) != null) {
            this.onFillParentInfo_PSDevSlnSysDynaInst(pSDevSlnUser, (PSDevSlnSysDynaInst)iEntity);
        }
        if (pSDevSlnUser.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnUser.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnUser, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnUser.getPSDevSlnTemplId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNTEMPL", (Object)pSDevSlnUser.getPSDevSlnTemplId())) != null) {
            this.onFillParentInfo_PSDevSlnTempl(pSDevSlnUser, (PSDevSlnTempl)iEntity);
        }
        if (pSDevSlnUser.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnUser.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnUser, (PSDevSln)iEntity);
        }
        if (pSDevSlnUser.getPSDevUserObjId() != null && (iEntity = cloneSession.getEntity("PSDEVUSEROBJ", (Object)pSDevSlnUser.getPSDevUserObjId())) != null) {
            this.onFillParentInfo_PSDevUserObj(pSDevSlnUser, (PSDevUserObj)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnUser, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AccMode(bl, pSDevSlnUser, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AllSysFlag(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredTime(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstId(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnTemplId(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnUserId(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnUserName(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserObjId(bl, pSDevSlnUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnUser, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AccMode(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isAccModeDirty() && !bl2 : !pSDevSlnUser.isAccModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnUser.getAccMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACCMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AccMode_Default(pSDevSlnUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AllSysFlag(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isAllSysFlagDirty() && !bl2 : !pSDevSlnUser.isAllSysFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnUser.getAllSysFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLSYSFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AllSysFlag_Default(pSDevSlnUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLSYSFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isDefaultFlagDirty() : !pSDevSlnUser.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnUser.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSDevSlnUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredTime(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isExpiredTimeDirty() : !pSDevSlnUser.isExpiredTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnUser.getExpiredTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredTime_Default(pSDevSlnUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isMemoDirty() : !pSDevSlnUser.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnUser.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnUser, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isPSDevSlnIdDirty() && !bl2 : !pSDevSlnUser.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnUser.getPSDevSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevSlnUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstId(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isPSDevSlnSysDynaInstIdDirty() : !pSDevSlnUser.isPSDevSlnSysDynaInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnUser.getPSDevSlnSysDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstId_Default(pSDevSlnUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isPSDevSlnSysIdDirty() : !pSDevSlnUser.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnUser.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnUser, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnTemplId(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isPSDevSlnTemplIdDirty() : !pSDevSlnUser.isPSDevSlnTemplIdDirty()) {
            return null;
        }
        String string = pSDevSlnUser.getPSDevSlnTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnTemplId_Default(pSDevSlnUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnUserId(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isPSDevSlnUserIdDirty() && !bl2 : !pSDevSlnUser.isPSDevSlnUserIdDirty()) {
            return null;
        }
        String string = pSDevSlnUser.getPSDevSlnUserId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnUserId_Default(pSDevSlnUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnUserName(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isPSDevSlnUserNameDirty() : !pSDevSlnUser.isPSDevSlnUserNameDirty()) {
            return null;
        }
        String string = pSDevSlnUser.getPSDevSlnUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnUserName_Default(pSDevSlnUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserObjId(boolean bl, PSDevSlnUser pSDevSlnUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUser.isPSDevUserObjIdDirty() && !bl2 : !pSDevSlnUser.isPSDevUserObjIdDirty()) {
            return null;
        }
        String string = pSDevSlnUser.getPSDevUserObjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSEROBJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserObjId_Default(pSDevSlnUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSEROBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnUser, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnUser, bl);
    }

    public Object getDataContextValue(PSDevSlnUser pSDevSlnUser, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnUser, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSln pSDevSln = pSDevSlnUser.getPSDevSln();
        if (pSDevSln != null && pSDevSln.contains(string)) {
            return pSDevSln.get(string);
        }
        PSDevUserObj pSDevUserObj = pSDevSlnUser.getPSDevUserObj();
        if (pSDevUserObj != null && pSDevUserObj.contains(string)) {
            return pSDevUserObj.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnUser pSDevSlnUser, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnUser, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AccMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ALLSYSFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllSysFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVUSEROBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevUserObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSEROBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSEROBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AccMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AllSysFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DevUserObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVUSEROBJTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExpiredTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDevSlnTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSEROBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSEROBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnUser pSDevSlnUser) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnUser)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnUser pSDevSlnUser) throws Exception {
        Object object = pSDevSlnUser.get("PSDEVSLNID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEVSLNUSER_PSDEVSLN_PSDEVSLNID", object);
        }
        super.onUpdateParent(pSDevSlnUser);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnUser pSDevSlnUser, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNUSER");
        if (!bl) {
            pSDevSlnUser.setDevUserObjType(null);
            super.exportCurXmlModel(pSDevSlnUser, xmlNode, bl);
        }
    }
}

