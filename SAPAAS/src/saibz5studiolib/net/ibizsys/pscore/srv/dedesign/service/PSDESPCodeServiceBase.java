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
import net.ibizsys.pscore.srv.dedesign.dao.PSDESPCodeDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDESPCodeDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESPCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProc;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProcBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESPCodePartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESPCodePartServiceBase;
import net.ibizsys.pscore.srv.def.service.PSDBProcParamService;
import net.ibizsys.pscore.srv.def.service.PSDBProcParamServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESPCodeServiceBase
extends PSCoreSysServiceBase<PSDESPCode> {
    private static final Log log = LogFactory.getLog(PSDESPCodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDESPCodeDEModel pSDESPCodeDEModel;
    private PSDESPCodeDAO pSDESPCodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDESPCodeService";
    }

    public PSDESPCodeDEModel getPSDESPCodeDEModel() {
        if (this.pSDESPCodeDEModel == null) {
            try {
                this.pSDESPCodeDEModel = (PSDESPCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDESPCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESPCodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDESPCodeDEModel();
    }

    public PSDESPCodeDAO getPSDESPCodeDAO() {
        if (this.pSDESPCodeDAO == null) {
            try {
                this.pSDESPCodeDAO = (PSDESPCodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDESPCodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESPCodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDESPCodeDAO();
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

    protected void onFillParentInfo(PSDESPCode pSDESPCode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESPCODE_PSDESYSPROC_PSDESYSPROCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESysProcService", (SessionFactory)this.getSessionFactory());
            PSDESysProc pSDESysProc = (PSDESysProc)iService.getDEModel().createEntity();
            pSDESysProc.set("PSDESYSPROCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDESysProc);
            } else {
                iService.get((IEntity)pSDESysProc);
            }
            this.onFillParentInfo_Psdesysproc(pSDESPCode, pSDESysProc);
            return;
        }
        super.onFillParentInfo((IEntity)pSDESPCode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psdesysproc(PSDESPCode pSDESPCode, PSDESysProc pSDESysProc) throws Exception {
        pSDESPCode.setPSDEId(pSDESysProc.getPSDEId());
        pSDESPCode.setPSDESysProcId(pSDESysProc.getPSDESysProcId());
        pSDESPCode.setPSDESysProcName(pSDESysProc.getPSDESysProcName());
        pSDESPCode.setSYSPROCType(pSDESysProc.getSysProcType());
    }

    protected void onFillEntityFullInfo(PSDESPCode pSDESPCode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDESPCode, bl);
        this.onFillEntityFullInfo_Psdesysproc(pSDESPCode, bl);
    }

    protected void onFillEntityFullInfo_Psdesysproc(PSDESPCode pSDESPCode, boolean bl) throws Exception {
        if (pSDESPCode.isPSDESysProcIdDirty()) {
            if (pSDESPCode.getPSDESysProcId() != null) {
                if (pSDESPCode.getPSDESysProcId() == null || pSDESPCode.getPSDESysProcName() == null) {
                    PSDESysProc pSDESysProc = pSDESPCode.getPsdesysproc();
                    pSDESPCode.setPSDEId(pSDESysProc.getPSDEId());
                    pSDESPCode.setPSDESysProcName(pSDESysProc.getPSDESysProcName());
                    pSDESPCode.setSYSPROCType(pSDESysProc.getSysProcType());
                }
            } else {
                pSDESPCode.setPSDEId(null);
                pSDESPCode.setPSDESysProcName(null);
                pSDESPCode.setSYSPROCType(null);
            }
        }
    }

    protected void onWriteBackParent(PSDESPCode pSDESPCode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDESPCode, bl);
    }

    public ArrayList<PSDESPCode> selectByPsdesysproc(PSDESysProcBase pSDESysProcBase) throws Exception {
        return this.selectByPsdesysproc(pSDESysProcBase, "", -1);
    }

    public ArrayList<PSDESPCode> selectByPsdesysproc(PSDESysProcBase pSDESysProcBase, String string) throws Exception {
        return this.selectByPsdesysproc(pSDESysProcBase, string, -1);
    }

    public ArrayList<PSDESPCode> selectByPsdesysproc(PSDESysProcBase pSDESysProcBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESYSPROCID", (Object)pSDESysProcBase.getPSDESysProcId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsdesysprocCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsdesysprocCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
    }

    public void resetPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
        ArrayList<PSDESPCode> arrayList = this.selectByPsdesysproc(pSDESysProc);
        for (PSDESPCode pSDESPCode : arrayList) {
            PSDESPCode pSDESPCode2 = (PSDESPCode)this.getDEModel().createEntity();
            pSDESPCode2.setPSDESPCodeId(pSDESPCode.getPSDESPCodeId());
            pSDESPCode2.setPSDESysProcId(null);
            this.update(pSDESPCode2);
        }
    }

    public void removeByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
        final PSDESysProc pSDESysProc2 = pSDESysProc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESPCodeServiceBase.this.onBeforeRemoveByPsdesysproc(pSDESysProc2);
                PSDESPCodeServiceBase.this.internalRemoveByPsdesysproc(pSDESysProc2);
                PSDESPCodeServiceBase.this.onAfterRemoveByPsdesysproc(pSDESysProc2);
            }
        });
    }

    protected void onBeforeRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
    }

    protected void internalRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
        ArrayList<PSDESPCode> arrayList = this.selectByPsdesysproc(pSDESysProc);
        this.onBeforeRemoveByPsdesysproc(pSDESysProc, arrayList);
        for (PSDESPCode pSDESPCode : arrayList) {
            this.remove((IEntity)pSDESPCode);
        }
        this.onAfterRemoveByPsdesysproc(pSDESysProc, arrayList);
    }

    protected void onAfterRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
    }

    protected void onBeforeRemoveByPsdesysproc(PSDESysProc pSDESysProc, ArrayList<PSDESPCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsdesysproc(PSDESysProc pSDESysProc, ArrayList<PSDESPCode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDESPCode pSDESPCode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDBProcParamService)ServiceGlobal.getService(PSDBProcParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDBProcParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDESPCode(pSDESPCode);
        ((PSDBProcParamServiceBase)pSCoreSysServiceBase).removeByPSDESPCode(pSDESPCode);
        pSCoreSysServiceBase = (PSDESPCodePartService)ServiceGlobal.getService(PSDESPCodePartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESPCodePartServiceBase)pSCoreSysServiceBase).testRemoveByPsdespcode(pSDESPCode);
        ((PSDESPCodePartServiceBase)pSCoreSysServiceBase).removeByPsdespcode(pSDESPCode);
        super.onBeforeRemove(pSDESPCode);
    }

    protected void replaceParentInfo(PSDESPCode pSDESPCode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDESPCode, cloneSession);
        if (pSDESPCode.getPSDESysProcId() != null && (iEntity = cloneSession.getEntity("PSDESYSPROC", (Object)pSDESPCode.getPSDESysProcId())) != null) {
            this.onFillParentInfo_Psdesysproc(pSDESPCode, (PSDESysProc)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDESPCode pSDESPCode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDESPCode, bl);
    }

    protected void onCheckEntity(boolean bl, PSDESPCode pSDESPCode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CompileFlag(bl, pSDESPCode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FULLCode(bl, pSDESPCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDESPCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESPCodeId(bl, pSDESPCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESPCodeName(bl, pSDESPCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESysProcId(bl, pSDESPCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESysProcName(bl, pSDESPCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCode(bl, pSDESPCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDESPCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDESPCode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CompileFlag(boolean bl, PSDESPCode pSDESPCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCode.isCompileFlagDirty() && !bl2 : !pSDESPCode.isCompileFlagDirty()) {
            return null;
        }
        Integer n = pSDESPCode.getCompileFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COMPILEFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_CompileFlag_Default((IEntity)pSDESPCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COMPILEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FULLCode(boolean bl, PSDESPCode pSDESPCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCode.isFULLCodeDirty() : !pSDESPCode.isFULLCodeDirty()) {
            return null;
        }
        String string = pSDESPCode.getFULLCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FULLCode_Default((IEntity)pSDESPCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDESPCode pSDESPCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCode.isMemoDirty() : !pSDESPCode.isMemoDirty()) {
            return null;
        }
        String string = pSDESPCode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDESPCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDESPCodeId(boolean bl, PSDESPCode pSDESPCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCode.isPSDESPCodeIdDirty() && !bl2 : !pSDESPCode.isPSDESPCodeIdDirty()) {
            return null;
        }
        String string = pSDESPCode.getPSDESPCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESPCodeId_Default((IEntity)pSDESPCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESPCodeName(boolean bl, PSDESPCode pSDESPCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCode.isPSDESPCodeNameDirty() && !bl2 : !pSDESPCode.isPSDESPCodeNameDirty()) {
            return null;
        }
        String string = pSDESPCode.getPSDESPCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESPCodeName_Default((IEntity)pSDESPCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESysProcId(boolean bl, PSDESPCode pSDESPCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCode.isPSDESysProcIdDirty() && !bl2 : !pSDESPCode.isPSDESysProcIdDirty()) {
            return null;
        }
        String string = pSDESPCode.getPSDESysProcId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESysProcId_Default((IEntity)pSDESPCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESysProcName(boolean bl, PSDESPCode pSDESPCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCode.isPSDESysProcNameDirty() && !bl2 : !pSDESPCode.isPSDESysProcNameDirty()) {
            return null;
        }
        String string = pSDESPCode.getPSDESysProcName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESysProcName_Default((IEntity)pSDESPCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCode(boolean bl, PSDESPCode pSDESPCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCode.isUserCodeDirty() : !pSDESPCode.isUserCodeDirty()) {
            return null;
        }
        String string = pSDESPCode.getUserCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCode_Default((IEntity)pSDESPCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDESPCode pSDESPCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCode.isUserParamsDirty() : !pSDESPCode.isUserParamsDirty()) {
            return null;
        }
        String string = pSDESPCode.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDESPCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDESPCode pSDESPCode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDESPCode, bl);
    }

    protected void onSyncIndexEntities(PSDESPCode pSDESPCode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDESPCode, bl);
    }

    public Object getDataContextValue(PSDESPCode pSDESPCode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDESPCode, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDESPCode pSDESPCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDESPCode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"COMPILEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CompileFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FULLCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESPCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESPCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESPCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESPCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESYSPROCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESysProcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESYSPROCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESysProcName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSPROCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SYSPROCType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CompileFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_FULLCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PSDESPCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESPCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESPCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESPCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESysProcId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESYSPROCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESysProcName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESYSPROCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SYSPROCType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSPROCTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_UserCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDESPCode pSDESPCode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDESPCode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDESPCode pSDESPCode) throws Exception {
        super.onUpdateParent((IEntity)pSDESPCode);
    }

    @Override
    protected void exportCurXmlModel(PSDESPCode pSDESPCode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDESPCODE");
        if (!bl) {
            pSDESPCode.setCompileFlag(null);
            pSDESPCode.setCreateDate(null);
            pSDESPCode.setCreateMan(null);
            pSDESPCode.setPSDESPCodeId(null);
            pSDESPCode.setUpdateDate(null);
            pSDESPCode.setUpdateMan(null);
            super.exportCurXmlModel(pSDESPCode, xmlNode, bl);
        }
    }
}

