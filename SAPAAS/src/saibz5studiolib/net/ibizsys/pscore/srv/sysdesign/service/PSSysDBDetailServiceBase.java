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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBDetailDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBDetailDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBDetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBDetailServiceBase
extends PSCoreSysServiceBase<PSSysDBDetail> {
    private static final Log log = LogFactory.getLog(PSSysDBDetailServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDBDetailDEModel pSSysDBDetailDEModel;
    private PSSysDBDetailDAO pSSysDBDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService";
    }

    public PSSysDBDetailDEModel getPSSysDBDetailDEModel() {
        if (this.pSSysDBDetailDEModel == null) {
            try {
                this.pSSysDBDetailDEModel = (PSSysDBDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDBDetailDEModel();
    }

    public PSSysDBDetailDAO getPSSysDBDetailDAO() {
        if (this.pSSysDBDetailDAO == null) {
            try {
                this.pSSysDBDetailDAO = (PSSysDBDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDBDetailDAO();
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

    protected void onFillParentInfo(PSSysDBDetail pSSysDBDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBDETAIL_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysDBDetail, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBDETAIL_PSSYSTEMDBCFG_PSSYSTEMDBCFGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService", (SessionFactory)this.getSessionFactory());
            PSSystemDBCfg pSSystemDBCfg = (PSSystemDBCfg)iService.getDEModel().createEntity();
            pSSystemDBCfg.set("PSSYSTEMDBCFGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystemDBCfg);
            } else {
                iService.get(pSSystemDBCfg);
            }
            this.onFillParentInfo_PSSystemDBCfg(pSSysDBDetail, pSSystemDBCfg);
            return;
        }
        super.onFillParentInfo(pSSysDBDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysDBDetail pSSysDBDetail, PSDataEntity pSDataEntity) throws Exception {
        pSSysDBDetail.setDBVer(pSDataEntity.getDBVer());
        pSSysDBDetail.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysDBDetail.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSystemDBCfg(PSSysDBDetail pSSysDBDetail, PSSystemDBCfg pSSystemDBCfg) throws Exception {
        pSSysDBDetail.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
        pSSysDBDetail.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
    }

    protected boolean onFillEntityKeyValue(PSSysDBDetail pSSysDBDetail, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysDBDetail.get("PSSYSTEMDBCFGID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysDBDetail.get("PSDEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSysDBDetail.set(this.getPSSysDBDetailDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysDBDetail pSSysDBDetail, boolean bl) throws Exception {
        if (bl && pSSysDBDetail.getPSSysDBDetailName() == null) {
            pSSysDBDetail.setPSSysDBDetailName((String)this.getDefaultValue(this.getWebContext(), "", "\u540d\u79f0", 25));
        }
        super.onFillEntityFullInfo(pSSysDBDetail, bl);
        this.onFillEntityFullInfo_PSDE(pSSysDBDetail, bl);
        this.onFillEntityFullInfo_PSSystemDBCfg(pSSysDBDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysDBDetail pSSysDBDetail, boolean bl) throws Exception {
        if (pSSysDBDetail.isPSDEIdDirty()) {
            if (pSSysDBDetail.getPSDEId() != null) {
                if (pSSysDBDetail.getPSDEId() == null || pSSysDBDetail.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysDBDetail.getPSDE();
                    pSSysDBDetail.setDBVer(pSDataEntity.getDBVer());
                    pSSysDBDetail.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysDBDetail.setDBVer(null);
                pSSysDBDetail.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystemDBCfg(PSSysDBDetail pSSysDBDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDBDetail pSSysDBDetail, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDBDetail, bl);
    }

    public ArrayList<PSSysDBDetail> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysDBDetail> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysDBDetail> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDBDetail> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, "", -1);
    }

    public ArrayList<PSSysDBDetail> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, string, -1);
    }

    public ArrayList<PSSysDBDetail> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMDBCFGID", (Object)pSSystemDBCfgBase.getPSSystemDBCfgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemDBCfgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemDBCfgCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDBDetail> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysDBDetail pSSysDBDetail : arrayList) {
            PSSysDBDetail pSSysDBDetail2 = (PSSysDBDetail)this.getDEModel().createEntity();
            pSSysDBDetail2.setPSSysDBDetailId(pSSysDBDetail.getPSSysDBDetailId());
            pSSysDBDetail2.setPSDEId(null);
            this.update(pSSysDBDetail2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBDetailServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysDBDetailServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysDBDetailServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDBDetail> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysDBDetail pSSysDBDetail : arrayList) {
            this.remove(pSSysDBDetail);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysDBDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysDBDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    public void resetPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSysDBDetail> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        for (PSSysDBDetail pSSysDBDetail : arrayList) {
            PSSysDBDetail pSSysDBDetail2 = (PSSysDBDetail)this.getDEModel().createEntity();
            pSSysDBDetail2.setPSSysDBDetailId(pSSysDBDetail.getPSSysDBDetailId());
            pSSysDBDetail2.setPSSystemDBCfgId(null);
            this.update(pSSysDBDetail2);
        }
    }

    public void removeByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBDetailServiceBase.this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSysDBDetailServiceBase.this.internalRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSysDBDetailServiceBase.this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void internalRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSysDBDetail> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
        for (PSSysDBDetail pSSysDBDetail : arrayList) {
            this.remove(pSSysDBDetail);
        }
        this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSysDBDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSysDBDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDBDetail pSSysDBDetail) throws Exception {
        super.onBeforeRemove(pSSysDBDetail);
    }

    protected void replaceParentInfo(PSSysDBDetail pSSysDBDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysDBDetail, cloneSession);
        if (pSSysDBDetail.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysDBDetail.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysDBDetail, (PSDataEntity)iEntity);
        }
        if (pSSysDBDetail.getPSSystemDBCfgId() != null && (iEntity = cloneSession.getEntity("PSSYSTEMDBCFG", (Object)pSSysDBDetail.getPSSystemDBCfgId())) != null) {
            this.onFillParentInfo_PSSystemDBCfg(pSSysDBDetail, (PSSystemDBCfg)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDBDetail pSSysDBDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDBDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDBDetail pSSysDBDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysDBDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysDBDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysDBDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBDetailId(bl, pSSysDBDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBDetailName(bl, pSSysDBDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgId(bl, pSSysDBDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubDBVer(bl, pSSysDBDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDBDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDBDetail pSSysDBDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBDetail.isMemoDirty() : !pSSysDBDetail.isMemoDirty()) {
            return null;
        }
        String string = pSSysDBDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysDBDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysDBDetail pSSysDBDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBDetail.isPSDEIdDirty() && !bl2 : !pSSysDBDetail.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysDBDetail.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysDBDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysDBDetail pSSysDBDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBDetail.isPSDENameDirty() && !bl2 : !pSSysDBDetail.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysDBDetail.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysDBDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBDetailId(boolean bl, PSSysDBDetail pSSysDBDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBDetail.isPSSysDBDetailIdDirty() && !bl2 : !pSSysDBDetail.isPSSysDBDetailIdDirty()) {
            return null;
        }
        String string = pSSysDBDetail.getPSSysDBDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBDetailId_Default(pSSysDBDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBDetailName(boolean bl, PSSysDBDetail pSSysDBDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBDetail.isPSSysDBDetailNameDirty() && !bl2 : !pSSysDBDetail.isPSSysDBDetailNameDirty()) {
            return null;
        }
        String string = pSSysDBDetail.getPSSysDBDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBDetailName_Default(pSSysDBDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemDBCfgId(boolean bl, PSSysDBDetail pSSysDBDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBDetail.isPSSystemDBCfgIdDirty() : !pSSysDBDetail.isPSSystemDBCfgIdDirty()) {
            return null;
        }
        String string = pSSysDBDetail.getPSSystemDBCfgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgId_Default(pSSysDBDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubDBVer(boolean bl, PSSysDBDetail pSSysDBDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBDetail.isPubDBVerDirty() && !bl2 : !pSSysDBDetail.isPubDBVerDirty()) {
            return null;
        }
        Integer n = pSSysDBDetail.getPubDBVer();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBDBVER");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_PubDBVer_Default(pSSysDBDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBDBVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDBDetail pSSysDBDetail, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDBDetail, bl);
    }

    protected void onSyncIndexEntities(PSSysDBDetail pSSysDBDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDBDetail, bl);
    }

    public Object getDataContextValue(PSSysDBDetail pSSysDBDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysDBDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSSysDBDetail.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSSystemDBCfg pSSystemDBCfg = pSSysDBDetail.getPSSystemDBCfg();
        if (pSSystemDBCfg != null && pSSystemDBCfg.contains(string)) {
            return pSSystemDBCfg.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDBDetail pSSysDBDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDBDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MATCHFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MatchFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemDBCfgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemDBCfgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBDBVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubDBVer_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DBVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MatchFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemDBCfgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMDBCFGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemDBCfgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMDBCFGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubDBVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSSysDBDetail pSSysDBDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDBDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDBDetail pSSysDBDetail) throws Exception {
        super.onUpdateParent(pSSysDBDetail);
    }

    @Override
    protected void exportCurXmlModel(PSSysDBDetail pSSysDBDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDBDETAIL");
        if (!bl) {
            pSSysDBDetail.setPubDBVer(null);
            super.exportCurXmlModel(pSSysDBDetail, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysDBDetail pSSysDBDetail, PSSystem pSSystem) throws Exception {
        PSSysDBDetail pSSysDBDetail2 = new PSSysDBDetail();
        pSSysDBDetail2.setPSSystemDBCfgId(pSSysDBDetail.getPSSystemDBCfgId());
        pSSysDBDetail2.setPSDEId(pSSysDBDetail.getPSDEId());
        if (this.selectOne(pSSysDBDetail2, true)) {
            return pSSysDBDetail2.getPSSysDBDetailId();
        }
        return super.getEntityFolderKeyValue(pSSysDBDetail, pSSystem);
    }
}

