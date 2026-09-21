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
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSModelSFCodeDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSModelSFCodeDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelSFCode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelSFCodeServiceBase
extends PSCoreSysServiceBase<PSModelSFCode> {
    private static final Log log = LogFactory.getLog(PSModelSFCodeServiceBase.class);
    public static final String DATASET_CURMODEL = "CurModel";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_LOCATECODE = "LocateCode";
    private PSModelSFCodeDEModel pSModelSFCodeDEModel;
    private PSModelSFCodeDAO pSModelSFCodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSModelSFCodeService";
    }

    public PSModelSFCodeDEModel getPSModelSFCodeDEModel() {
        if (this.pSModelSFCodeDEModel == null) {
            try {
                this.pSModelSFCodeDEModel = (PSModelSFCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSModelSFCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelSFCodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelSFCodeDEModel();
    }

    public PSModelSFCodeDAO getPSModelSFCodeDAO() {
        if (this.pSModelSFCodeDAO == null) {
            try {
                this.pSModelSFCodeDAO = (PSModelSFCodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSModelSFCodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelSFCodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelSFCodeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURMODEL, (boolean)true) == 0) {
            return this.fetchCurModel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_LOCATECODE, (boolean)true) == 0) {
            this.locateCode((PSModelSFCode)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurModel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMODEL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void locateCode(PSModelSFCode pSModelSFCode) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_LOCATECODE, 0, (IEntity)pSModelSFCode, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSModelSFCode, ACTION_LOCATECODE);
        final PSModelSFCode pSModelSFCode2 = pSModelSFCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSModelSFCodeServiceBase.this.getService(), PSModelSFCodeServiceBase.ACTION_LOCATECODE, 40, (IEntity)pSModelSFCode2, null).getResult() != 1) {
                    PSModelSFCodeServiceBase.this.onLocateCode(pSModelSFCode2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_LOCATECODE, 99, (IEntity)pSModelSFCode, null);
        }
    }

    protected void onLocateCode(PSModelSFCode pSModelSFCode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[LocateCode]");
    }

    protected void onFillParentInfo(PSModelSFCode pSModelSFCode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELSFCODE_PSSFCODETYPE_PSSFCODETYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService", (SessionFactory)this.getSessionFactory());
            PSSFCodeType pSSFCodeType = (PSSFCodeType)iService.getDEModel().createEntity();
            pSSFCodeType.set("PSSFCODETYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFCodeType);
            } else {
                iService.get((IEntity)pSSFCodeType);
            }
            this.onFillParentInfo_PSSFCodeType(pSModelSFCode, pSSFCodeType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELSFCODE_PSSYSSFPUB_PSSYSSFPUBID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            PSSysSFPub pSSysSFPub = (PSSysSFPub)iService.getDEModel().createEntity();
            pSSysSFPub.set("PSSYSSFPUBID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPub);
            } else {
                iService.get((IEntity)pSSysSFPub);
            }
            this.onFillParentInfo_PSSysSFPub(pSModelSFCode, pSSysSFPub);
            return;
        }
        super.onFillParentInfo((IEntity)pSModelSFCode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFCodeType(PSModelSFCode pSModelSFCode, PSSFCodeType pSSFCodeType) throws Exception {
        pSModelSFCode.setPSSFCodeTypeId(pSSFCodeType.getPSSFCodeTypeId());
        pSModelSFCode.setPSSFCodeTypeName(pSSFCodeType.getPSSFCodeTypeName());
    }

    protected void onFillParentInfo_PSSysSFPub(PSModelSFCode pSModelSFCode, PSSysSFPub pSSysSFPub) throws Exception {
        pSModelSFCode.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
        pSModelSFCode.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
    }

    protected void onFillEntityFullInfo(PSModelSFCode pSModelSFCode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSModelSFCode, bl);
        this.onFillEntityFullInfo_PSSFCodeType(pSModelSFCode, bl);
        this.onFillEntityFullInfo_PSSysSFPub(pSModelSFCode, bl);
    }

    protected void onFillEntityFullInfo_PSSFCodeType(PSModelSFCode pSModelSFCode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPub(PSModelSFCode pSModelSFCode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSModelSFCode pSModelSFCode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSModelSFCode, bl);
    }

    public ArrayList<PSModelSFCode> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase) throws Exception {
        return this.selectByPSSFCodeType(pSSFCodeTypeBase, "", -1);
    }

    public ArrayList<PSModelSFCode> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase, String string) throws Exception {
        return this.selectByPSSFCodeType(pSSFCodeTypeBase, string, -1);
    }

    public ArrayList<PSModelSFCode> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFCODETYPEID", (Object)pSSFCodeTypeBase.getPSSFCodeTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCodeTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCodeTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelSFCode> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, "", -1);
    }

    public ArrayList<PSModelSFCode> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, string, -1);
    }

    public ArrayList<PSModelSFCode> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPUBID", (Object)pSSysSFPubBase.getPSSysSFPubId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPubCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPubCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
    }

    public void resetPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        ArrayList<PSModelSFCode> arrayList = this.selectByPSSFCodeType(pSSFCodeType);
        for (PSModelSFCode pSModelSFCode : arrayList) {
            PSModelSFCode pSModelSFCode2 = (PSModelSFCode)this.getDEModel().createEntity();
            pSModelSFCode2.setPSModelSFCodeId(pSModelSFCode.getPSModelSFCodeId());
            pSModelSFCode2.setPSSFCodeTypeId(null);
            this.update(pSModelSFCode2);
        }
    }

    public void removeByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        final PSSFCodeType pSSFCodeType2 = pSSFCodeType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelSFCodeServiceBase.this.onBeforeRemoveByPSSFCodeType(pSSFCodeType2);
                PSModelSFCodeServiceBase.this.internalRemoveByPSSFCodeType(pSSFCodeType2);
                PSModelSFCodeServiceBase.this.onAfterRemoveByPSSFCodeType(pSSFCodeType2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
    }

    protected void internalRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        ArrayList<PSModelSFCode> arrayList = this.selectByPSSFCodeType(pSSFCodeType);
        this.onBeforeRemoveByPSSFCodeType(pSSFCodeType, arrayList);
        for (PSModelSFCode pSModelSFCode : arrayList) {
            this.remove((IEntity)pSModelSFCode);
        }
        this.onAfterRemoveByPSSFCodeType(pSSFCodeType, arrayList);
    }

    protected void onAfterRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
    }

    protected void onBeforeRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType, ArrayList<PSModelSFCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType, ArrayList<PSModelSFCode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    public void resetPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSModelSFCode> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        for (PSModelSFCode pSModelSFCode : arrayList) {
            PSModelSFCode pSModelSFCode2 = (PSModelSFCode)this.getDEModel().createEntity();
            pSModelSFCode2.setPSModelSFCodeId(pSModelSFCode.getPSModelSFCodeId());
            pSModelSFCode2.setPSSysSFPubId(null);
            this.update(pSModelSFCode2);
        }
    }

    public void removeByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        final PSSysSFPub pSSysSFPub2 = pSSysSFPub;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelSFCodeServiceBase.this.onBeforeRemoveByPSSysSFPub(pSSysSFPub2);
                PSModelSFCodeServiceBase.this.internalRemoveByPSSysSFPub(pSSysSFPub2);
                PSModelSFCodeServiceBase.this.onAfterRemoveByPSSysSFPub(pSSysSFPub2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void internalRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSModelSFCode> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        this.onBeforeRemoveByPSSysSFPub(pSSysSFPub, arrayList);
        for (PSModelSFCode pSModelSFCode : arrayList) {
            this.remove((IEntity)pSModelSFCode);
        }
        this.onAfterRemoveByPSSysSFPub(pSSysSFPub, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSModelSFCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSModelSFCode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelSFCode pSModelSFCode) throws Exception {
        super.onBeforeRemove(pSModelSFCode);
    }

    protected void replaceParentInfo(PSModelSFCode pSModelSFCode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSModelSFCode, cloneSession);
        if (pSModelSFCode.getPSSFCodeTypeId() != null && (iEntity = cloneSession.getEntity("PSSFCODETYPE", (Object)pSModelSFCode.getPSSFCodeTypeId())) != null) {
            this.onFillParentInfo_PSSFCodeType(pSModelSFCode, (PSSFCodeType)iEntity);
        }
        if (pSModelSFCode.getPSSysSFPubId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPUB", (Object)pSModelSFCode.getPSSysSFPubId())) != null) {
            this.onFillParentInfo_PSSysSFPub(pSModelSFCode, (PSSysSFPub)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelSFCode pSModelSFCode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSModelSFCode, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeMode(bl, pSModelSFCode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodePath(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodePkgName(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomFlag(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjFolder(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjName(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelSFCodeId(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelSFCodeName(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelType(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeTypeId(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubId(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubCode(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCode(bl, pSModelSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSModelSFCode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeMode(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isCodeModeDirty() : !pSModelSFCode.isCodeModeDirty()) {
            return null;
        }
        String string = pSModelSFCode.getCodeMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeMode_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodePath(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isCodePathDirty() : !pSModelSFCode.isCodePathDirty()) {
            return null;
        }
        String string = pSModelSFCode.getCodePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodePath_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodePkgName(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isCodePkgNameDirty() : !pSModelSFCode.isCodePkgNameDirty()) {
            return null;
        }
        String string = pSModelSFCode.getCodePkgName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodePkgName_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomFlag(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isCustomFlagDirty() : !pSModelSFCode.isCustomFlagDirty()) {
            return null;
        }
        Integer n = pSModelSFCode.getCustomFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomFlag_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isMemoDirty() : !pSModelSFCode.isMemoDirty()) {
            return null;
        }
        String string = pSModelSFCode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSModelSFCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PrjFolder(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isPrjFolderDirty() : !pSModelSFCode.isPrjFolderDirty()) {
            return null;
        }
        String string = pSModelSFCode.getPrjFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjFolder_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrjName(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isPrjNameDirty() : !pSModelSFCode.isPrjNameDirty()) {
            return null;
        }
        String string = pSModelSFCode.getPrjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjName_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isPSModelIdDirty() : !pSModelSFCode.isPSModelIdDirty()) {
            return null;
        }
        String string = pSModelSFCode.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isPSModelNameDirty() : !pSModelSFCode.isPSModelNameDirty()) {
            return null;
        }
        String string = pSModelSFCode.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelSFCodeId(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isPSModelSFCodeIdDirty() && !bl2 : !pSModelSFCode.isPSModelSFCodeIdDirty()) {
            return null;
        }
        String string = pSModelSFCode.getPSModelSFCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSFCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelSFCodeId_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSFCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelSFCodeName(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isPSModelSFCodeNameDirty() : !pSModelSFCode.isPSModelSFCodeNameDirty()) {
            return null;
        }
        String string = pSModelSFCode.getPSModelSFCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelSFCodeName_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSFCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelType(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isPSModelTypeDirty() : !pSModelSFCode.isPSModelTypeDirty()) {
            return null;
        }
        String string = pSModelSFCode.getPSModelType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelType_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFCodeTypeId(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isPSSFCodeTypeIdDirty() : !pSModelSFCode.isPSSFCodeTypeIdDirty()) {
            return null;
        }
        String string = pSModelSFCode.getPSSFCodeTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeTypeId_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubId(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isPSSysSFPubIdDirty() : !pSModelSFCode.isPSSysSFPubIdDirty()) {
            return null;
        }
        String string = pSModelSFCode.getPSSysSFPubId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubId_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubCode(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isPubCodeDirty() : !pSModelSFCode.isPubCodeDirty()) {
            return null;
        }
        String string = pSModelSFCode.getPubCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubCode_Default((IEntity)pSModelSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCode(boolean bl, PSModelSFCode pSModelSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSFCode.isUserCodeDirty() : !pSModelSFCode.isUserCodeDirty()) {
            return null;
        }
        String string = pSModelSFCode.getUserCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCode_Default((IEntity)pSModelSFCode, bl2, bl3);
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

    protected void onSyncEntity(PSModelSFCode pSModelSFCode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSModelSFCode, bl);
    }

    protected void onSyncIndexEntities(PSModelSFCode pSModelSFCode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSModelSFCode, bl);
    }

    public Object getDataContextValue(PSModelSFCode pSModelSFCode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSModelSFCode, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelSFCode pSModelSFCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSModelSFCode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodePkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELSFCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelSFCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELSFCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelSFCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubCode_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodePkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEPKGNAME", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_CustomFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PrjFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJFOLDER", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelSFCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELSFCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelSFCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELSFCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCodeTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCodeTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected boolean onMergeChild(String string, String string2, PSModelSFCode pSModelSFCode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSModelSFCode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelSFCode pSModelSFCode) throws Exception {
        super.onUpdateParent((IEntity)pSModelSFCode);
    }

    @Override
    protected void exportCurXmlModel(PSModelSFCode pSModelSFCode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELSFCODE");
        if (!bl) {
            pSModelSFCode.setCodePath(null);
            pSModelSFCode.setCodePkgName(null);
            pSModelSFCode.setCreateDate(null);
            pSModelSFCode.setCreateMan(null);
            pSModelSFCode.setPrjName(null);
            pSModelSFCode.setPSModelSFCodeId(null);
            pSModelSFCode.setPSModelSFCodeName(null);
            pSModelSFCode.setPSSFCodeTypeId(null);
            pSModelSFCode.setPSSFCodeTypeName(null);
            pSModelSFCode.setPSSysSFPubId(null);
            pSModelSFCode.setPSSysSFPubName(null);
            pSModelSFCode.setPubCode(null);
            pSModelSFCode.setUpdateDate(null);
            pSModelSFCode.setUpdateMan(null);
            super.exportCurXmlModel(pSModelSFCode, xmlNode, bl);
        }
    }
}

