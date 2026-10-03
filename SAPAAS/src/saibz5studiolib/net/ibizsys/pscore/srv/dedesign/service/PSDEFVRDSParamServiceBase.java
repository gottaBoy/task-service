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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFVRDSParamDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFVRDSParamDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSParamBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFVRDSParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRuleBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFVRDSParamServiceBase
extends PSCoreSysServiceBase<PSDEFVRDSParam> {
    private static final Log log = LogFactory.getLog(PSDEFVRDSParamServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFVRDSParamDEModel pSDEFVRDSParamDEModel;
    private PSDEFVRDSParamDAO pSDEFVRDSParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFVRDSParamService";
    }

    public PSDEFVRDSParamDEModel getPSDEFVRDSParamDEModel() {
        if (this.pSDEFVRDSParamDEModel == null) {
            try {
                this.pSDEFVRDSParamDEModel = (PSDEFVRDSParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFVRDSParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFVRDSParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFVRDSParamDEModel();
    }

    public PSDEFVRDSParamDAO getPSDEFVRDSParamDAO() {
        if (this.pSDEFVRDSParamDAO == null) {
            try {
                this.pSDEFVRDSParamDAO = (PSDEFVRDSParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFVRDSParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFVRDSParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFVRDSParamDAO();
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

    protected void onFillParentInfo(PSDEFVRDSParam pSDEFVRDSParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRDSPARAM_PSDEDSPARAM_PSDEDSPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamService", (SessionFactory)this.getSessionFactory());
            PSDEDSParam pSDEDSParam = (PSDEDSParam)iService.getDEModel().createEntity();
            pSDEDSParam.set("PSDEDSPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDSParam);
            } else {
                iService.get(pSDEDSParam);
            }
            this.onFillParentInfo_Psdedsparam(pSDEFVRDSParam, pSDEDSParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRDSPARAM_PSDEFVALUERULE_PSDEFVRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iService.getDEModel().createEntity();
            pSDEFValueRule.set("PSDEFVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFValueRule);
            } else {
                iService.get(pSDEFValueRule);
            }
            this.onFillParentInfo_PSDEFVR(pSDEFVRDSParam, pSDEFValueRule);
            return;
        }
        super.onFillParentInfo(pSDEFVRDSParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psdedsparam(PSDEFVRDSParam pSDEFVRDSParam, PSDEDSParam pSDEDSParam) throws Exception {
        pSDEFVRDSParam.setPSDEDSParamId(pSDEDSParam.getPSDEDSParamId());
        pSDEFVRDSParam.setPSDEDSParamName(pSDEDSParam.getPSDEDSParamName());
    }

    protected void onFillParentInfo_PSDEFVR(PSDEFVRDSParam pSDEFVRDSParam, PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDEFVRDSParam.setPSDEFVRID(pSDEFValueRule.getPSDEFValueRuleId());
        pSDEFVRDSParam.setPSDEFVRName(pSDEFValueRule.getPSDEFValueRuleName());
    }

    protected void onFillEntityFullInfo(PSDEFVRDSParam pSDEFVRDSParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDEFVRDSParam, bl);
        this.onFillEntityFullInfo_Psdedsparam(pSDEFVRDSParam, bl);
        this.onFillEntityFullInfo_PSDEFVR(pSDEFVRDSParam, bl);
    }

    protected void onFillEntityFullInfo_Psdedsparam(PSDEFVRDSParam pSDEFVRDSParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFVR(PSDEFVRDSParam pSDEFVRDSParam, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFVRDSParam pSDEFVRDSParam, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFVRDSParam, bl);
    }

    public ArrayList<PSDEFVRDSParam> selectByPsdedsparam(PSDEDSParamBase pSDEDSParamBase) throws Exception {
        return this.selectByPsdedsparam(pSDEDSParamBase, "", -1);
    }

    public ArrayList<PSDEFVRDSParam> selectByPsdedsparam(PSDEDSParamBase pSDEDSParamBase, String string) throws Exception {
        return this.selectByPsdedsparam(pSDEDSParamBase, string, -1);
    }

    public ArrayList<PSDEFVRDSParam> selectByPsdedsparam(PSDEDSParamBase pSDEDSParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDSPARAMID", (Object)pSDEDSParamBase.getPSDEDSParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsdedsparamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsdedsparamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRDSParam> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFVRDSParam> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFVRDSParam> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVRID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFVRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFVRCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPsdedsparam(PSDEDSParam pSDEDSParam) throws Exception {
        ArrayList<PSDEFVRDSParam> arrayList = this.selectByPsdedsparam(pSDEDSParam, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDSPARAM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDSParam);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVRDSPARAM_PSDEDSPARAM_PSDEDSPARAMID", "", iDataEntityModel.getName(), "PSDEFVRDSPARAM", iDataEntityModel.getDataInfo(pSDEDSParam), arrayList.get(0)));
        }
    }

    public void resetPsdedsparam(PSDEDSParam pSDEDSParam) throws Exception {
        ArrayList<PSDEFVRDSParam> arrayList = this.selectByPsdedsparam(pSDEDSParam);
        for (PSDEFVRDSParam pSDEFVRDSParam : arrayList) {
            PSDEFVRDSParam pSDEFVRDSParam2 = (PSDEFVRDSParam)this.getDEModel().createEntity();
            pSDEFVRDSParam2.setPSDEFVRDSParamId(pSDEFVRDSParam.getPSDEFVRDSParamId());
            pSDEFVRDSParam2.setPSDEDSParamId(null);
            this.update(pSDEFVRDSParam2);
        }
    }

    public void removeByPsdedsparam(PSDEDSParam pSDEDSParam) throws Exception {
        final PSDEDSParam pSDEDSParam2 = pSDEDSParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRDSParamServiceBase.this.onBeforeRemoveByPsdedsparam(pSDEDSParam2);
                PSDEFVRDSParamServiceBase.this.internalRemoveByPsdedsparam(pSDEDSParam2);
                PSDEFVRDSParamServiceBase.this.onAfterRemoveByPsdedsparam(pSDEDSParam2);
            }
        });
    }

    protected void onBeforeRemoveByPsdedsparam(PSDEDSParam pSDEDSParam) throws Exception {
    }

    protected void internalRemoveByPsdedsparam(PSDEDSParam pSDEDSParam) throws Exception {
        ArrayList<PSDEFVRDSParam> arrayList = this.selectByPsdedsparam(pSDEDSParam);
        this.onBeforeRemoveByPsdedsparam(pSDEDSParam, arrayList);
        for (PSDEFVRDSParam pSDEFVRDSParam : arrayList) {
            this.remove(pSDEFVRDSParam);
        }
        this.onAfterRemoveByPsdedsparam(pSDEDSParam, arrayList);
    }

    protected void onAfterRemoveByPsdedsparam(PSDEDSParam pSDEDSParam) throws Exception {
    }

    protected void onBeforeRemoveByPsdedsparam(PSDEDSParam pSDEDSParam, ArrayList<PSDEFVRDSParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsdedsparam(PSDEDSParam pSDEDSParam, ArrayList<PSDEFVRDSParam> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    public void resetPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFVRDSParam> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        for (PSDEFVRDSParam pSDEFVRDSParam : arrayList) {
            PSDEFVRDSParam pSDEFVRDSParam2 = (PSDEFVRDSParam)this.getDEModel().createEntity();
            pSDEFVRDSParam2.setPSDEFVRDSParamId(pSDEFVRDSParam.getPSDEFVRDSParamId());
            pSDEFVRDSParam2.setPSDEFVRID(null);
            this.update(pSDEFVRDSParam2);
        }
    }

    public void removeByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRDSParamServiceBase.this.onBeforeRemoveByPSDEFVR(pSDEFValueRule2);
                PSDEFVRDSParamServiceBase.this.internalRemoveByPSDEFVR(pSDEFValueRule2);
                PSDEFVRDSParamServiceBase.this.onAfterRemoveByPSDEFVR(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFVRDSParam> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        this.onBeforeRemoveByPSDEFVR(pSDEFValueRule, arrayList);
        for (PSDEFVRDSParam pSDEFVRDSParam : arrayList) {
            this.remove(pSDEFVRDSParam);
        }
        this.onAfterRemoveByPSDEFVR(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEFVRDSParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEFVRDSParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFVRDSParam pSDEFVRDSParam) throws Exception {
        super.onBeforeRemove(pSDEFVRDSParam);
    }

    protected void replaceParentInfo(PSDEFVRDSParam pSDEFVRDSParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFVRDSParam, cloneSession);
        if (pSDEFVRDSParam.getPSDEDSParamId() != null && (iEntity = cloneSession.getEntity("PSDEDSPARAM", (Object)pSDEFVRDSParam.getPSDEDSParamId())) != null) {
            this.onFillParentInfo_Psdedsparam(pSDEFVRDSParam, (PSDEDSParam)iEntity);
        }
        if (pSDEFVRDSParam.getPSDEFVRID() != null && (iEntity = cloneSession.getEntity("PSDEFVALUERULE", (Object)pSDEFVRDSParam.getPSDEFVRID())) != null) {
            this.onFillParentInfo_PSDEFVR(pSDEFVRDSParam, (PSDEFValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFVRDSParam pSDEFVRDSParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFVRDSParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFVRDSParam pSDEFVRDSParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDEDSParamId(bl, pSDEFVRDSParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRDSParamId(bl, pSDEFVRDSParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRDSParamName(bl, pSDEFVRDSParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRID(bl, pSDEFVRDSParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFVRDSParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDEDSParamId(boolean bl, PSDEFVRDSParam pSDEFVRDSParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRDSParam.isPSDEDSParamIdDirty() && !bl2 : !pSDEFVRDSParam.isPSDEDSParamIdDirty()) {
            return null;
        }
        String string = pSDEFVRDSParam.getPSDEDSParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSParamId_Default(pSDEFVRDSParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRDSParamId(boolean bl, PSDEFVRDSParam pSDEFVRDSParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRDSParam.isPSDEFVRDSParamIdDirty() && !bl2 : !pSDEFVRDSParam.isPSDEFVRDSParamIdDirty()) {
            return null;
        }
        String string = pSDEFVRDSParam.getPSDEFVRDSParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRDSPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRDSParamId_Default(pSDEFVRDSParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRDSPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRDSParamName(boolean bl, PSDEFVRDSParam pSDEFVRDSParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRDSParam.isPSDEFVRDSParamNameDirty() && !bl2 : !pSDEFVRDSParam.isPSDEFVRDSParamNameDirty()) {
            return null;
        }
        String string = pSDEFVRDSParam.getPSDEFVRDSParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRDSPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRDSParamName_Default(pSDEFVRDSParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRDSPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRID(boolean bl, PSDEFVRDSParam pSDEFVRDSParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRDSParam.isPSDEFVRIDDirty() && !bl2 : !pSDEFVRDSParam.isPSDEFVRIDDirty()) {
            return null;
        }
        String string = pSDEFVRDSParam.getPSDEFVRID();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRID_Default(pSDEFVRDSParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFVRDSParam pSDEFVRDSParam, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFVRDSParam, bl);
    }

    protected void onSyncIndexEntities(PSDEFVRDSParam pSDEFVRDSParam, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFVRDSParam, bl);
    }

    public Object getDataContextValue(PSDEFVRDSParam pSDEFVRDSParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFVRDSParam, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFVRDSParam pSDEFVRDSParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFVRDSParam, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRDSPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRDSParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRDSPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRDSParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRID_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEDSParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRDSParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRDSPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRDSParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRDSPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRID_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEFVRDSParam pSDEFVRDSParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFVRDSParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFVRDSParam pSDEFVRDSParam) throws Exception {
        super.onUpdateParent(pSDEFVRDSParam);
    }

    @Override
    protected void exportCurXmlModel(PSDEFVRDSParam pSDEFVRDSParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFVRDSPARAM");
        if (!bl) {
            pSDEFVRDSParam.setCreateDate(null);
            pSDEFVRDSParam.setCreateMan(null);
            pSDEFVRDSParam.setPSDEFVRDSParamId(null);
            pSDEFVRDSParam.setUpdateDate(null);
            pSDEFVRDSParam.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFVRDSParam, xmlNode, bl);
        }
    }
}

