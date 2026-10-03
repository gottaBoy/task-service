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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSSubDEViewDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSubDEViewDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSubDE;
import net.ibizsys.pscore.srv.config.entity.PSSubDEBase;
import net.ibizsys.pscore.srv.config.entity.PSSubDEView;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.entity.PSSubSysBase;
import net.ibizsys.pscore.srv.config.service.PSSubAppViewService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubDEViewServiceBase
extends PSCoreSysServiceBase<PSSubDEView> {
    private static final Log log = LogFactory.getLog(PSSubDEViewServiceBase.class);
    public static final String DATASET_CURSUBSYS = "CurSubSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSubDEViewDEModel pSSubDEViewDEModel;
    private PSSubDEViewDAO pSSubDEViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSubDEViewService";
    }

    public PSSubDEViewDEModel getPSSubDEViewDEModel() {
        if (this.pSSubDEViewDEModel == null) {
            try {
                this.pSSubDEViewDEModel = (PSSubDEViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSubDEViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubDEViewDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubDEViewDEModel();
    }

    public PSSubDEViewDAO getPSSubDEViewDAO() {
        if (this.pSSubDEViewDAO == null) {
            try {
                this.pSSubDEViewDAO = (PSSubDEViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSubDEViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubDEViewDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubDEViewDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSUBSYS, (boolean)true) == 0) {
            return this.fetchCurSubSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSubSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSUBSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSubDEView pSSubDEView, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBDEVIEW_PSSUBDE_PSSUBDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubDEService", (SessionFactory)this.getSessionFactory());
            PSSubDE pSSubDE = (PSSubDE)iService.getDEModel().createEntity();
            pSSubDE.set("PSSUBDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubDE);
            } else {
                iService.get(pSSubDE);
            }
            this.onFillParentInfo_PSSubDE(pSSubDEView, pSSubDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBDEVIEW_PSSUBSYS_PSSUBSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysService", (SessionFactory)this.getSessionFactory());
            PSSubSys pSSubSys = (PSSubSys)iService.getDEModel().createEntity();
            pSSubSys.set("PSSUBSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSys);
            } else {
                iService.get(pSSubSys);
            }
            this.onFillParentInfo_PSSubSys(pSSubDEView, pSSubSys);
            return;
        }
        super.onFillParentInfo(pSSubDEView, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSubDE(PSSubDEView pSSubDEView, PSSubDE pSSubDE) throws Exception {
        pSSubDEView.setPSSubDEId(pSSubDE.getPSSubDEId());
        pSSubDEView.setPSSubDEName(pSSubDE.getPSSubDEName());
    }

    protected void onFillParentInfo_PSSubSys(PSSubDEView pSSubDEView, PSSubSys pSSubSys) throws Exception {
        pSSubDEView.setPSSubSysId(pSSubSys.getPSSubSysId());
        pSSubDEView.setPSSubSysName(pSSubSys.getPSSubSysName());
    }

    protected boolean onFillEntityKeyValue(PSSubDEView pSSubDEView, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSubDEView.get("PSSUBSYSID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSubDEView.get("PSDEVIEWBASEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSubDEView.set(this.getPSSubDEViewDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSubDEView pSSubDEView, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSubDEView, bl);
        this.onFillEntityFullInfo_PSSubDE(pSSubDEView, bl);
        this.onFillEntityFullInfo_PSSubSys(pSSubDEView, bl);
    }

    protected void onFillEntityFullInfo_PSSubDE(PSSubDEView pSSubDEView, boolean bl) throws Exception {
        if (pSSubDEView.isPSSubDEIdDirty()) {
            if (pSSubDEView.getPSSubDEId() != null) {
                if (pSSubDEView.getPSSubDEId() == null || pSSubDEView.getPSSubDEName() == null) {
                    PSSubDE pSSubDE = pSSubDEView.getPSSubDE();
                    pSSubDEView.setPSSubDEName(pSSubDE.getPSSubDEName());
                }
            } else {
                pSSubDEView.setPSSubDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubSys(PSSubDEView pSSubDEView, boolean bl) throws Exception {
        if (pSSubDEView.isPSSubSysIdDirty()) {
            if (pSSubDEView.getPSSubSysId() != null) {
                if (pSSubDEView.getPSSubSysId() == null || pSSubDEView.getPSSubSysName() == null) {
                    PSSubSys pSSubSys = pSSubDEView.getPSSubSys();
                    pSSubDEView.setPSSubSysName(pSSubSys.getPSSubSysName());
                }
            } else {
                pSSubDEView.setPSSubSysName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSubDEView pSSubDEView, boolean bl) throws Exception {
        super.onWriteBackParent(pSSubDEView, bl);
    }

    public ArrayList<PSSubDEView> selectByPSSubDE(PSSubDEBase pSSubDEBase) throws Exception {
        return this.selectByPSSubDE(pSSubDEBase, "", -1);
    }

    public ArrayList<PSSubDEView> selectByPSSubDE(PSSubDEBase pSSubDEBase, String string) throws Exception {
        return this.selectByPSSubDE(pSSubDEBase, string, -1);
    }

    public ArrayList<PSSubDEView> selectByPSSubDE(PSSubDEBase pSSubDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBDEID", (Object)pSSubDEBase.getPSSubDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubDEView> selectByPSSubSys(PSSubSysBase pSSubSysBase) throws Exception {
        return this.selectByPSSubSys(pSSubSysBase, "", -1);
    }

    public ArrayList<PSSubDEView> selectByPSSubSys(PSSubSysBase pSSubSysBase, String string) throws Exception {
        return this.selectByPSSubSys(pSSubSysBase, string, -1);
    }

    public ArrayList<PSSubDEView> selectByPSSubSys(PSSubSysBase pSSubSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSID", (Object)pSSubSysBase.getPSSubSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSubDE(PSSubDE pSSubDE) throws Exception {
    }

    public void resetPSSubDE(PSSubDE pSSubDE) throws Exception {
        ArrayList<PSSubDEView> arrayList = this.selectByPSSubDE(pSSubDE);
        for (PSSubDEView pSSubDEView : arrayList) {
            PSSubDEView pSSubDEView2 = (PSSubDEView)this.getDEModel().createEntity();
            pSSubDEView2.setPSSubDEViewId(pSSubDEView.getPSSubDEViewId());
            pSSubDEView2.setPSSubDEId(null);
            this.update(pSSubDEView2);
        }
    }

    public void removeByPSSubDE(PSSubDE pSSubDE) throws Exception {
        final PSSubDE pSSubDE2 = pSSubDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubDEViewServiceBase.this.onBeforeRemoveByPSSubDE(pSSubDE2);
                PSSubDEViewServiceBase.this.internalRemoveByPSSubDE(pSSubDE2);
                PSSubDEViewServiceBase.this.onAfterRemoveByPSSubDE(pSSubDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubDE(PSSubDE pSSubDE) throws Exception {
    }

    protected void internalRemoveByPSSubDE(PSSubDE pSSubDE) throws Exception {
        ArrayList<PSSubDEView> arrayList = this.selectByPSSubDE(pSSubDE);
        this.onBeforeRemoveByPSSubDE(pSSubDE, arrayList);
        for (PSSubDEView pSSubDEView : arrayList) {
            this.remove(pSSubDEView);
        }
        this.onAfterRemoveByPSSubDE(pSSubDE, arrayList);
    }

    protected void onAfterRemoveByPSSubDE(PSSubDE pSSubDE) throws Exception {
    }

    protected void onBeforeRemoveByPSSubDE(PSSubDE pSSubDE, ArrayList<PSSubDEView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubDE(PSSubDE pSSubDE, ArrayList<PSSubDEView> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    public void resetPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSSubDEView> arrayList = this.selectByPSSubSys(pSSubSys);
        for (PSSubDEView pSSubDEView : arrayList) {
            PSSubDEView pSSubDEView2 = (PSSubDEView)this.getDEModel().createEntity();
            pSSubDEView2.setPSSubDEViewId(pSSubDEView.getPSSubDEViewId());
            pSSubDEView2.setPSSubSysId(null);
            this.update(pSSubDEView2);
        }
    }

    public void removeByPSSubSys(PSSubSys pSSubSys) throws Exception {
        final PSSubSys pSSubSys2 = pSSubSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubDEViewServiceBase.this.onBeforeRemoveByPSSubSys(pSSubSys2);
                PSSubDEViewServiceBase.this.internalRemoveByPSSubSys(pSSubSys2);
                PSSubDEViewServiceBase.this.onAfterRemoveByPSSubSys(pSSubSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    protected void internalRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSSubDEView> arrayList = this.selectByPSSubSys(pSSubSys);
        this.onBeforeRemoveByPSSubSys(pSSubSys, arrayList);
        for (PSSubDEView pSSubDEView : arrayList) {
            this.remove(pSSubDEView);
        }
        this.onAfterRemoveByPSSubSys(pSSubSys, arrayList);
    }

    protected void onAfterRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSys(PSSubSys pSSubSys, ArrayList<PSSubDEView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSys(PSSubSys pSSubSys, ArrayList<PSSubDEView> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubDEView pSSubDEView) throws Exception {
        PSSubAppViewService pSSubAppViewService = (PSSubAppViewService)ServiceGlobal.getService(PSSubAppViewService.class, (SessionFactory)this.getSessionFactory());
        pSSubAppViewService.testRemoveByPSSubDEView(pSSubDEView);
        pSSubAppViewService.resetPSSubDEView(pSSubDEView);
        super.onBeforeRemove(pSSubDEView);
    }

    protected void replaceParentInfo(PSSubDEView pSSubDEView, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSubDEView, cloneSession);
        if (pSSubDEView.getPSSubDEId() != null && (iEntity = cloneSession.getEntity("PSSUBDE", (Object)pSSubDEView.getPSSubDEId())) != null) {
            this.onFillParentInfo_PSSubDE(pSSubDEView, (PSSubDE)iEntity);
        }
        if (pSSubDEView.getPSSubSysId() != null && (iEntity = cloneSession.getEntity("PSSUBSYS", (Object)pSSubDEView.getPSSubSysId())) != null) {
            this.onFillParentInfo_PSSubSys(pSSubDEView, (PSSubSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubDEView pSSubDEView, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSubDEView, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSubDEView, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSubDEView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSSubDEView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubDEId(bl, pSSubDEView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubDEName(bl, pSSubDEView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubDEViewId(bl, pSSubDEView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubDEViewName(bl, pSSubDEView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysId(bl, pSSubDEView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysName(bl, pSSubDEView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewType(bl, pSSubDEView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSubDEView, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEView.isCodeNameDirty() && !bl2 : !pSSubDEView.isCodeNameDirty()) {
            return null;
        }
        String string = pSSubDEView.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSubDEView, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEView.isMemoDirty() : !pSSubDEView.isMemoDirty()) {
            return null;
        }
        String string = pSSubDEView.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSubDEView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEView.isPSDEViewBaseIdDirty() && !bl2 : !pSSubDEView.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSSubDEView.getPSDEViewBaseId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSSubDEView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubDEId(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEView.isPSSubDEIdDirty() : !pSSubDEView.isPSSubDEIdDirty()) {
            return null;
        }
        String string = pSSubDEView.getPSSubDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubDEId_Default(pSSubDEView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubDEName(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEView.isPSSubDENameDirty() : !pSSubDEView.isPSSubDENameDirty()) {
            return null;
        }
        String string = pSSubDEView.getPSSubDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubDEName_Default(pSSubDEView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubDEViewId(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEView.isPSSubDEViewIdDirty() && !bl2 : !pSSubDEView.isPSSubDEViewIdDirty()) {
            return null;
        }
        String string = pSSubDEView.getPSSubDEViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubDEViewId_Default(pSSubDEView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubDEViewName(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEView.isPSSubDEViewNameDirty() && !bl2 : !pSSubDEView.isPSSubDEViewNameDirty()) {
            return null;
        }
        String string = pSSubDEView.getPSSubDEViewName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEVIEWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubDEViewName_Default(pSSubDEView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEVIEWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysId(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEView.isPSSubSysIdDirty() && !bl2 : !pSSubDEView.isPSSubSysIdDirty()) {
            return null;
        }
        String string = pSSubDEView.getPSSubSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysId_Default(pSSubDEView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysName(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEView.isPSSubSysNameDirty() && !bl2 : !pSSubDEView.isPSSubSysNameDirty()) {
            return null;
        }
        String string = pSSubDEView.getPSSubSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysName_Default(pSSubDEView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewType(boolean bl, PSSubDEView pSSubDEView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubDEView.isViewTypeDirty() : !pSSubDEView.isViewTypeDirty()) {
            return null;
        }
        String string = pSSubDEView.getViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewType_Default(pSSubDEView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSubDEView pSSubDEView, boolean bl) throws Exception {
        super.onSyncEntity(pSSubDEView, bl);
    }

    protected void onSyncIndexEntities(PSSubDEView pSSubDEView, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSubDEView, bl);
    }

    public Object getDataContextValue(PSSubDEView pSSubDEView, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSubDEView, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSubDEView pSSubDEView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSubDEView, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSSubDEView pSSubDEView) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSubDEView)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubDEView pSSubDEView) throws Exception {
        super.onUpdateParent(pSSubDEView);
    }

    @Override
    protected void exportCurXmlModel(PSSubDEView pSSubDEView, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBDEVIEW");
        if (!bl) {
            super.exportCurXmlModel(pSSubDEView, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSubDEView pSSubDEView, PSSystem pSSystem) throws Exception {
        PSSubDEView pSSubDEView2 = new PSSubDEView();
        pSSubDEView2.setPSSubSysId(pSSubDEView.getPSSubSysId());
        pSSubDEView2.setPSDEViewBaseId(pSSubDEView.getPSDEViewBaseId());
        if (this.selectOne(pSSubDEView2, true)) {
            return pSSubDEView2.getPSSubDEViewId();
        }
        return super.getEntityFolderKeyValue(pSSubDEView, pSSystem);
    }
}

