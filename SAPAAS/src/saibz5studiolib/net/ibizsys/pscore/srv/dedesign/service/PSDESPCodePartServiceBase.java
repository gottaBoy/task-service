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
import net.ibizsys.pscore.srv.dedesign.dao.PSDESPCodePartDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDESPCodePartDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESPCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESPCodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESPCodePart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProc;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProcBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESPCodePartServiceBase
extends PSCoreSysServiceBase<PSDESPCodePart> {
    private static final Log log = LogFactory.getLog(PSDESPCodePartServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDESPCodePartDEModel pSDESPCodePartDEModel;
    private PSDESPCodePartDAO pSDESPCodePartDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDESPCodePartService";
    }

    public PSDESPCodePartDEModel getPSDESPCodePartDEModel() {
        if (this.pSDESPCodePartDEModel == null) {
            try {
                this.pSDESPCodePartDEModel = (PSDESPCodePartDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDESPCodePartDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESPCodePartDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDESPCodePartDEModel();
    }

    public PSDESPCodePartDAO getPSDESPCodePartDAO() {
        if (this.pSDESPCodePartDAO == null) {
            try {
                this.pSDESPCodePartDAO = (PSDESPCodePartDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDESPCodePartDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESPCodePartDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDESPCodePartDAO();
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

    protected void onFillParentInfo(PSDESPCodePart pSDESPCodePart, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESPCODEPART_PSDESPCODE_PSDESPCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESPCodeService", (SessionFactory)this.getSessionFactory());
            PSDESPCode pSDESPCode = (PSDESPCode)iService.getDEModel().createEntity();
            pSDESPCode.set("PSDESPCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDESPCode);
            } else {
                iService.get((IEntity)pSDESPCode);
            }
            this.onFillParentInfo_Psdespcode(pSDESPCodePart, pSDESPCode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESPCODEPART_PSDESYSPROC_PSDESYSPROCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESysProcService", (SessionFactory)this.getSessionFactory());
            PSDESysProc pSDESysProc = (PSDESysProc)iService.getDEModel().createEntity();
            pSDESysProc.set("PSDESYSPROCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDESysProc);
            } else {
                iService.get((IEntity)pSDESysProc);
            }
            this.onFillParentInfo_Psdesysproc(pSDESPCodePart, pSDESysProc);
            return;
        }
        super.onFillParentInfo((IEntity)pSDESPCodePart, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psdespcode(PSDESPCodePart pSDESPCodePart, PSDESPCode pSDESPCode) throws Exception {
        pSDESPCodePart.setPSDESPCodeId(pSDESPCode.getPSDESPCodeId());
        pSDESPCodePart.setPSDESPCodeName(pSDESPCode.getPSDESPCodeName());
    }

    protected void onFillParentInfo_Psdesysproc(PSDESPCodePart pSDESPCodePart, PSDESysProc pSDESysProc) throws Exception {
        pSDESPCodePart.setPSDESysProcId(pSDESysProc.getPSDESysProcId());
        pSDESPCodePart.setPSDESysProcName(pSDESysProc.getPSDESysProcName());
    }

    protected void onFillEntityFullInfo(PSDESPCodePart pSDESPCodePart, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDESPCodePart, bl);
        this.onFillEntityFullInfo_Psdespcode(pSDESPCodePart, bl);
        this.onFillEntityFullInfo_Psdesysproc(pSDESPCodePart, bl);
    }

    protected void onFillEntityFullInfo_Psdespcode(PSDESPCodePart pSDESPCodePart, boolean bl) throws Exception {
        if (pSDESPCodePart.isPSDESPCodeIdDirty()) {
            if (pSDESPCodePart.getPSDESPCodeId() != null) {
                if (pSDESPCodePart.getPSDESPCodeId() == null || pSDESPCodePart.getPSDESPCodeName() == null) {
                    PSDESPCode pSDESPCode = pSDESPCodePart.getPsdespcode();
                    pSDESPCodePart.setPSDESPCodeName(pSDESPCode.getPSDESPCodeName());
                }
            } else {
                pSDESPCodePart.setPSDESPCodeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Psdesysproc(PSDESPCodePart pSDESPCodePart, boolean bl) throws Exception {
        if (pSDESPCodePart.isPSDESysProcIdDirty()) {
            if (pSDESPCodePart.getPSDESysProcId() != null) {
                if (pSDESPCodePart.getPSDESysProcId() == null || pSDESPCodePart.getPSDESysProcName() == null) {
                    PSDESysProc pSDESysProc = pSDESPCodePart.getPsdesysproc();
                    pSDESPCodePart.setPSDESysProcName(pSDESysProc.getPSDESysProcName());
                }
            } else {
                pSDESPCodePart.setPSDESysProcName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDESPCodePart pSDESPCodePart, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDESPCodePart, bl);
    }

    public ArrayList<PSDESPCodePart> selectByPsdespcode(PSDESPCodeBase pSDESPCodeBase) throws Exception {
        return this.selectByPsdespcode(pSDESPCodeBase, "", -1);
    }

    public ArrayList<PSDESPCodePart> selectByPsdespcode(PSDESPCodeBase pSDESPCodeBase, String string) throws Exception {
        return this.selectByPsdespcode(pSDESPCodeBase, string, -1);
    }

    public ArrayList<PSDESPCodePart> selectByPsdespcode(PSDESPCodeBase pSDESPCodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESPCODEID", (Object)pSDESPCodeBase.getPSDESPCodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsdespcodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsdespcodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESPCodePart> selectByPsdesysproc(PSDESysProcBase pSDESysProcBase) throws Exception {
        return this.selectByPsdesysproc(pSDESysProcBase, "", -1);
    }

    public ArrayList<PSDESPCodePart> selectByPsdesysproc(PSDESysProcBase pSDESysProcBase, String string) throws Exception {
        return this.selectByPsdesysproc(pSDESysProcBase, string, -1);
    }

    public ArrayList<PSDESPCodePart> selectByPsdesysproc(PSDESysProcBase pSDESysProcBase, String string, int n) throws Exception {
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

    public void testRemoveByPsdespcode(PSDESPCode pSDESPCode) throws Exception {
    }

    public void resetPsdespcode(PSDESPCode pSDESPCode) throws Exception {
        ArrayList<PSDESPCodePart> arrayList = this.selectByPsdespcode(pSDESPCode);
        for (PSDESPCodePart pSDESPCodePart : arrayList) {
            PSDESPCodePart pSDESPCodePart2 = (PSDESPCodePart)this.getDEModel().createEntity();
            pSDESPCodePart2.setPSDESPCodePartId(pSDESPCodePart.getPSDESPCodePartId());
            pSDESPCodePart2.setPSDESPCodeId(null);
            this.update(pSDESPCodePart2);
        }
    }

    public void removeByPsdespcode(PSDESPCode pSDESPCode) throws Exception {
        final PSDESPCode pSDESPCode2 = pSDESPCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESPCodePartServiceBase.this.onBeforeRemoveByPsdespcode(pSDESPCode2);
                PSDESPCodePartServiceBase.this.internalRemoveByPsdespcode(pSDESPCode2);
                PSDESPCodePartServiceBase.this.onAfterRemoveByPsdespcode(pSDESPCode2);
            }
        });
    }

    protected void onBeforeRemoveByPsdespcode(PSDESPCode pSDESPCode) throws Exception {
    }

    protected void internalRemoveByPsdespcode(PSDESPCode pSDESPCode) throws Exception {
        ArrayList<PSDESPCodePart> arrayList = this.selectByPsdespcode(pSDESPCode);
        this.onBeforeRemoveByPsdespcode(pSDESPCode, arrayList);
        for (PSDESPCodePart pSDESPCodePart : arrayList) {
            this.remove((IEntity)pSDESPCodePart);
        }
        this.onAfterRemoveByPsdespcode(pSDESPCode, arrayList);
    }

    protected void onAfterRemoveByPsdespcode(PSDESPCode pSDESPCode) throws Exception {
    }

    protected void onBeforeRemoveByPsdespcode(PSDESPCode pSDESPCode, ArrayList<PSDESPCodePart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsdespcode(PSDESPCode pSDESPCode, ArrayList<PSDESPCodePart> arrayList) throws Exception {
    }

    public void testRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
    }

    public void resetPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
        ArrayList<PSDESPCodePart> arrayList = this.selectByPsdesysproc(pSDESysProc);
        for (PSDESPCodePart pSDESPCodePart : arrayList) {
            PSDESPCodePart pSDESPCodePart2 = (PSDESPCodePart)this.getDEModel().createEntity();
            pSDESPCodePart2.setPSDESPCodePartId(pSDESPCodePart.getPSDESPCodePartId());
            pSDESPCodePart2.setPSDESysProcId(null);
            this.update(pSDESPCodePart2);
        }
    }

    public void removeByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
        final PSDESysProc pSDESysProc2 = pSDESysProc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESPCodePartServiceBase.this.onBeforeRemoveByPsdesysproc(pSDESysProc2);
                PSDESPCodePartServiceBase.this.internalRemoveByPsdesysproc(pSDESysProc2);
                PSDESPCodePartServiceBase.this.onAfterRemoveByPsdesysproc(pSDESysProc2);
            }
        });
    }

    protected void onBeforeRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
    }

    protected void internalRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
        ArrayList<PSDESPCodePart> arrayList = this.selectByPsdesysproc(pSDESysProc);
        this.onBeforeRemoveByPsdesysproc(pSDESysProc, arrayList);
        for (PSDESPCodePart pSDESPCodePart : arrayList) {
            this.remove((IEntity)pSDESPCodePart);
        }
        this.onAfterRemoveByPsdesysproc(pSDESysProc, arrayList);
    }

    protected void onAfterRemoveByPsdesysproc(PSDESysProc pSDESysProc) throws Exception {
    }

    protected void onBeforeRemoveByPsdesysproc(PSDESysProc pSDESysProc, ArrayList<PSDESPCodePart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsdesysproc(PSDESysProc pSDESysProc, ArrayList<PSDESPCodePart> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDESPCodePart pSDESPCodePart) throws Exception {
        super.onBeforeRemove(pSDESPCodePart);
    }

    protected void replaceParentInfo(PSDESPCodePart pSDESPCodePart, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDESPCodePart, cloneSession);
        if (pSDESPCodePart.getPSDESPCodeId() != null && (iEntity = cloneSession.getEntity("PSDESPCODE", (Object)pSDESPCodePart.getPSDESPCodeId())) != null) {
            this.onFillParentInfo_Psdespcode(pSDESPCodePart, (PSDESPCode)iEntity);
        }
        if (pSDESPCodePart.getPSDESysProcId() != null && (iEntity = cloneSession.getEntity("PSDESYSPROC", (Object)pSDESPCodePart.getPSDESysProcId())) != null) {
            this.onFillParentInfo_Psdesysproc(pSDESPCodePart, (PSDESysProc)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDESPCodePart pSDESPCodePart, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDESPCodePart, bl);
    }

    protected void onCheckEntity(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodePART(bl, pSDESPCodePart, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DangerCode(bl, pSDESPCodePart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDESPCodePart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDESPCodePart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESPCodeId(bl, pSDESPCodePart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESPCodeName(bl, pSDESPCodePart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESPCodePartId(bl, pSDESPCodePart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESPCodePartName(bl, pSDESPCodePart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESysProcId(bl, pSDESPCodePart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESysProcName(bl, pSDESPCodePart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDESPCodePart, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodePART(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCodePart.isCodePARTDirty() && !bl2 : !pSDESPCodePart.isCodePARTDirty()) {
            return null;
        }
        String string = pSDESPCodePart.getCodePART();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPART");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodePART_Default((IEntity)pSDESPCodePart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPART");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DangerCode(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCodePart.isDangerCodeDirty() && !bl2 : !pSDESPCodePart.isDangerCodeDirty()) {
            return null;
        }
        Integer n = pSDESPCodePart.getDangerCode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DANGERCODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DangerCode_Default((IEntity)pSDESPCodePart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DANGERCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCodePart.isMemoDirty() : !pSDESPCodePart.isMemoDirty()) {
            return null;
        }
        String string = pSDESPCodePart.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDESPCodePart, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCodePart.isOrderValueDirty() && !bl2 : !pSDESPCodePart.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDESPCodePart.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDESPCodePart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESPCodeId(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCodePart.isPSDESPCodeIdDirty() && !bl2 : !pSDESPCodePart.isPSDESPCodeIdDirty()) {
            return null;
        }
        String string = pSDESPCodePart.getPSDESPCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESPCodeId_Default((IEntity)pSDESPCodePart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDESPCodeName(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCodePart.isPSDESPCodeNameDirty() && !bl2 : !pSDESPCodePart.isPSDESPCodeNameDirty()) {
            return null;
        }
        String string = pSDESPCodePart.getPSDESPCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESPCodeName_Default((IEntity)pSDESPCodePart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDESPCodePartId(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCodePart.isPSDESPCodePartIdDirty() && !bl2 : !pSDESPCodePart.isPSDESPCodePartIdDirty()) {
            return null;
        }
        String string = pSDESPCodePart.getPSDESPCodePartId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODEPARTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESPCodePartId_Default((IEntity)pSDESPCodePart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODEPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESPCodePartName(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCodePart.isPSDESPCodePartNameDirty() && !bl2 : !pSDESPCodePart.isPSDESPCodePartNameDirty()) {
            return null;
        }
        String string = pSDESPCodePart.getPSDESPCodePartName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODEPARTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESPCodePartName_Default((IEntity)pSDESPCodePart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODEPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESysProcId(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCodePart.isPSDESysProcIdDirty() && !bl2 : !pSDESPCodePart.isPSDESysProcIdDirty()) {
            return null;
        }
        String string = pSDESPCodePart.getPSDESysProcId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESysProcId_Default((IEntity)pSDESPCodePart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDESysProcName(boolean bl, PSDESPCodePart pSDESPCodePart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESPCodePart.isPSDESysProcNameDirty() && !bl2 : !pSDESPCodePart.isPSDESysProcNameDirty()) {
            return null;
        }
        String string = pSDESPCodePart.getPSDESysProcName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESysProcName_Default((IEntity)pSDESPCodePart, bl2, bl3);
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

    protected void onSyncEntity(PSDESPCodePart pSDESPCodePart, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDESPCodePart, bl);
    }

    protected void onSyncIndexEntities(PSDESPCodePart pSDESPCodePart, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDESPCodePart, bl);
    }

    public Object getDataContextValue(PSDESPCodePart pSDESPCodePart, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDESPCodePart, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDESPCodePart pSDESPCodePart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDESPCodePart, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODEPART", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodePART_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DANGERCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DangerCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESPCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESPCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESPCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESPCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESPCODEPARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESPCodePartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESPCODEPARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESPCodePartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESYSPROCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESysProcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESYSPROCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESysProcName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodePART_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEPART", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_DangerCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDESPCodePartId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESPCODEPARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESPCodePartName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESPCODEPARTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDESPCodePart pSDESPCodePart) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDESPCodePart)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDESPCodePart pSDESPCodePart) throws Exception {
        super.onUpdateParent((IEntity)pSDESPCodePart);
    }

    @Override
    protected void exportCurXmlModel(PSDESPCodePart pSDESPCodePart, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDESPCODEPART");
        if (!bl) {
            pSDESPCodePart.setCreateDate(null);
            pSDESPCodePart.setCreateMan(null);
            pSDESPCodePart.setDangerCode(null);
            pSDESPCodePart.setPSDESPCodePartId(null);
            pSDESPCodePart.setUpdateDate(null);
            pSDESPCodePart.setUpdateMan(null);
            super.exportCurXmlModel(pSDESPCodePart, xmlNode, bl);
        }
    }
}

