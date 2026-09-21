/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.search.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.search.dao.PSSysSearchDocDAO;
import net.ibizsys.pscore.srv.search.demodel.PSSysSearchDocDEModel;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchField;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchSchemeBase;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEServiceBase;
import net.ibizsys.pscore.srv.search.service.PSSysSearchFieldService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchFieldServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchDocServiceBase
extends PSCoreSysServiceBase<PSSysSearchDoc> {
    private static final Log log = LogFactory.getLog(PSSysSearchDocServiceBase.class);
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysSearchDocDEModel pSSysSearchDocDEModel;
    private PSSysSearchDocDAO pSSysSearchDocDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.search.service.PSSysSearchDocService";
    }

    public PSSysSearchDocDEModel getPSSysSearchDocDEModel() {
        if (this.pSSysSearchDocDEModel == null) {
            try {
                this.pSSysSearchDocDEModel = (PSSysSearchDocDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.search.demodel.PSSysSearchDocDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchDocDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSearchDocDEModel();
    }

    public PSSysSearchDocDAO getPSSysSearchDocDAO() {
        if (this.pSSysSearchDocDAO == null) {
            try {
                this.pSSysSearchDocDAO = (PSSysSearchDocDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.search.dao.PSSysSearchDocDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchDocDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSearchDocDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchCurScheme(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysSearchDoc pSSysSearchDoc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysSearchScheme pSSysSearchScheme = (PSSysSearchScheme)iService.getDEModel().createEntity();
            pSSysSearchScheme.set("PSSYSSEARCHSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSearchScheme);
            } else {
                iService.get((IEntity)pSSysSearchScheme);
            }
            this.onFillParentInfo_PSSysSearchScheme(pSSysSearchDoc, pSSysSearchScheme);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysSearchDoc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysSearchScheme(PSSysSearchDoc pSSysSearchDoc, PSSysSearchScheme pSSysSearchScheme) throws Exception {
        pSSysSearchDoc.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
        pSSysSearchDoc.setPSSysSearchSchemeName(pSSysSearchScheme.getPSSysSearchSchemeName());
    }

    protected void onFillEntityFullInfo(PSSysSearchDoc pSSysSearchDoc, boolean bl) throws Exception {
        if (bl && pSSysSearchDoc.getValidFlag() == null) {
            pSSysSearchDoc.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysSearchDoc, bl);
        this.onFillEntityFullInfo_PSSysSearchScheme(pSSysSearchDoc, bl);
    }

    protected void onFillEntityFullInfo_PSSysSearchScheme(PSSysSearchDoc pSSysSearchDoc, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSearchDoc pSSysSearchDoc, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysSearchDoc, bl);
    }

    public ArrayList<PSSysSearchDoc> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase) throws Exception {
        return this.selectByPSSysSearchScheme(pSSysSearchSchemeBase, "", -1);
    }

    public ArrayList<PSSysSearchDoc> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase, String string) throws Exception {
        return this.selectByPSSysSearchScheme(pSSysSearchSchemeBase, string, -1);
    }

    public ArrayList<PSSysSearchDoc> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHSCHEMEID", (Object)pSSysSearchSchemeBase.getPSSysSearchSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchSchemeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSSysSearchDoc> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEARCHSCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSearchScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "", iDataEntityModel.getName(), "PSSYSSEARCHDOC", iDataEntityModel.getDataInfo((IEntity)pSSysSearchScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSSysSearchDoc> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme);
        for (PSSysSearchDoc pSSysSearchDoc : arrayList) {
            PSSysSearchDoc pSSysSearchDoc2 = (PSSysSearchDoc)this.getDEModel().createEntity();
            pSSysSearchDoc2.setPSSysSearchDocId(pSSysSearchDoc.getPSSysSearchDocId());
            pSSysSearchDoc2.setPSSysSearchSchemeId(null);
            this.update(pSSysSearchDoc2);
        }
    }

    public void removeByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        final PSSysSearchScheme pSSysSearchScheme2 = pSSysSearchScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchDocServiceBase.this.onBeforeRemoveByPSSysSearchScheme(pSSysSearchScheme2);
                PSSysSearchDocServiceBase.this.internalRemoveByPSSysSearchScheme(pSSysSearchScheme2);
                PSSysSearchDocServiceBase.this.onAfterRemoveByPSSysSearchScheme(pSSysSearchScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
    }

    protected void internalRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSSysSearchDoc> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme);
        this.onBeforeRemoveByPSSysSearchScheme(pSSysSearchScheme, arrayList);
        for (PSSysSearchDoc pSSysSearchDoc : arrayList) {
            this.remove((IEntity)pSSysSearchDoc);
        }
        this.onAfterRemoveByPSSysSearchScheme(pSSysSearchScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme, ArrayList<PSSysSearchDoc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme, ArrayList<PSSysSearchDoc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchDoc(pSSysSearchDoc);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchDoc(pSSysSearchDoc);
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).removeByPSSysSearchDoc(pSSysSearchDoc);
        pSCoreSysServiceBase = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchDoc(pSSysSearchDoc);
        pSCoreSysServiceBase = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchDoc(pSSysSearchDoc);
        super.onBeforeRemove(pSSysSearchDoc);
    }

    protected void replaceParentInfo(PSSysSearchDoc pSSysSearchDoc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysSearchDoc, cloneSession);
        if (pSSysSearchDoc.getPSSysSearchSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHSCHEME", (Object)pSSysSearchDoc.getPSSysSearchSchemeId())) != null) {
            this.onFillParentInfo_PSSysSearchScheme(pSSysSearchDoc, (PSSysSearchScheme)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSearchDoc pSSysSearchDoc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysSearchDoc, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysSearchDoc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultMode(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DocParams(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DocTag(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DocTag2(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDocId(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDocName(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchSchemeId(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Replicas(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Shards(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysSearchDoc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysSearchDoc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isCodeNameDirty() && !bl2 : !pSSysSearchDoc.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSSEARCHSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysSearchDocDEModel(), "CODENAME", string3, pSSysSearchDoc, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultMode(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isDefaultModeDirty() : !pSSysSearchDoc.isDefaultModeDirty()) {
            return null;
        }
        Integer n = pSSysSearchDoc.getDefaultMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultMode_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DocParams(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isDocParamsDirty() : !pSSysSearchDoc.isDocParamsDirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getDocParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DocParams_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DocTag(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isDocTagDirty() : !pSSysSearchDoc.isDocTagDirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getDocTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DocTag_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DocTag2(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isDocTag2Dirty() : !pSSysSearchDoc.isDocTag2Dirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getDocTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DocTag2_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isLogicNameDirty() : !pSSysSearchDoc.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isMemoDirty() : !pSSysSearchDoc.isMemoDirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysSearchDoc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSearchDocId(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isPSSysSearchDocIdDirty() && !bl2 : !pSSysSearchDoc.isPSSysSearchDocIdDirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getPSSysSearchDocId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDOCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDocId_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDOCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDocName(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isPSSysSearchDocNameDirty() && !bl2 : !pSSysSearchDoc.isPSSysSearchDocNameDirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getPSSysSearchDocName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDOCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDocName_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDOCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSSEARCHSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysSearchDocDEModel(), "PSSYSSEARCHDOCNAME", string3, pSSysSearchDoc, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSEARCHDOCNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchSchemeId(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isPSSysSearchSchemeIdDirty() && !bl2 : !pSSysSearchDoc.isPSSysSearchSchemeIdDirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getPSSysSearchSchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHSCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchSchemeId_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Replicas(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isReplicasDirty() : !pSSysSearchDoc.isReplicasDirty()) {
            return null;
        }
        Integer n = pSSysSearchDoc.getReplicas();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Replicas_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPLICAS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Shards(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isShardsDirty() : !pSSysSearchDoc.isShardsDirty()) {
            return null;
        }
        Integer n = pSSysSearchDoc.getShards();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Shards_Default((IEntity)pSSysSearchDoc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHARDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isUserCatDirty() : !pSSysSearchDoc.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysSearchDoc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isUserTagDirty() : !pSSysSearchDoc.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysSearchDoc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isUserTag2Dirty() : !pSSysSearchDoc.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysSearchDoc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isUserTag3Dirty() : !pSSysSearchDoc.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysSearchDoc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isUserTag4Dirty() : !pSSysSearchDoc.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSearchDoc.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysSearchDoc, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysSearchDoc pSSysSearchDoc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDoc.isValidFlagDirty() && !bl2 : !pSSysSearchDoc.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchDoc.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysSearchDoc, bl2, bl3);
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

    protected void onSyncEntity(PSSysSearchDoc pSSysSearchDoc, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysSearchDoc, bl);
    }

    protected void onSyncIndexEntities(PSSysSearchDoc pSSysSearchDoc, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysSearchDoc, bl);
    }

    public Object getDataContextValue(PSSysSearchDoc pSSysSearchDoc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysSearchDoc, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysSearchScheme pSSysSearchScheme = pSSysSearchDoc.getPSSysSearchScheme();
        if (pSSysSearchScheme != null && pSSysSearchScheme.contains(string)) {
            return pSSysSearchScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSearchDoc pSSysSearchDoc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysSearchDoc, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPLICAS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Replicas_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHARDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Shards_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DefaultMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DocParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DocTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DocTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysSearchDocId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDocName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSSYSSEARCHDOCNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Replicas_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Shards_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysSearchDoc pSSysSearchDoc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysSearchDoc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        super.onUpdateParent((IEntity)pSSysSearchDoc);
    }

    @Override
    protected void exportCurXmlModel(PSSysSearchDoc pSSysSearchDoc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSEARCHDOC");
        if (!bl) {
            pSSysSearchDoc.setCreateDate(null);
            pSSysSearchDoc.setCreateMan(null);
            pSSysSearchDoc.setPSSysSearchDocId(null);
            pSSysSearchDoc.setPSSysSearchSchemeName(null);
            pSSysSearchDoc.setUpdateDate(null);
            pSSysSearchDoc.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSearchDoc, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSearchDoc pSSysSearchDoc, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSearchDoc, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSSEARCHSCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHSCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSSEARCHSCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSSEARCHSCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysSearchDoc pSSysSearchDoc) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchDoc.getPSSysSearchDocName())) {
            return pSSysSearchDoc.getPSSysSearchDocName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchDoc.getCodeName())) {
            return pSSysSearchDoc.getCodeName();
        }
        return super.getModelV2Tag(pSSysSearchDoc);
    }

    @Override
    public boolean setModelV2Tag(PSSysSearchDoc pSSysSearchDoc, String string) {
        pSSysSearchDoc.setPSSysSearchDocName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSSEARCHDOCNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSSEARCHSCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSearchDoc pSSysSearchDoc, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSearchDoc.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSearchDoc, true);
        pSSysSearchDoc.set("PSSYSSEARCHDOCNAME", string);
        if (this.select(pSSysSearchDoc, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSearchDoc, true);
        return super.getModelV2Entity(pSSysSearchDoc, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSearchDoc pSSysSearchDoc, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysSearchDoc, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysSearchDoc pSSysSearchDoc, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSEARCHDOC#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSSEARCHFIELD", (Object)pSSysSearchDoc.getPSSysSearchDocId()))).exists()) {
            PSSysSearchFieldService pSSysSearchFieldService = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysSearchFieldService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysSearchField pSSysSearchField = new PSSysSearchField();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysSearchField, objectNode, false);
                String string6 = pSSysSearchFieldService.getModelV2Tag(pSSysSearchField);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSSEARCHFIELD", (Object)pSSysSearchField.getPSSysSearchFieldId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysSearchFieldService.exportModelV2(pSSysSearchField, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysSearchDoc, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysSearchDoc pSSysSearchDoc, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID")) {
            Object object;
            PSSysSearchField pSSysSearchField2;
            Object object2;
            Object object3;
            Object object4;
            PSSysSearchFieldService pSSysSearchFieldService = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysSearchField> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSEARCHDOC#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSSEARCHFIELD", (Object)pSSysSearchDoc.getPSSysSearchDocId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysSearchField2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysSearchField2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysSearchField>();
                object4 = pSSysSearchFieldService.selectByPSSysSearchDoc(pSSysSearchDoc);
                object3 = StringHelper.format((String)"PSSYSSEARCHDOC#%1$s", (Object)pSSysSearchDoc.getPSSysSearchDocId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysSearchField2 = object2.next();
                    object = pSSysSearchFieldService.getModelV2ResScope((IEntity)pSSysSearchField2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysSearchField)PSModelV2Helper.toJSONObject((IEntity)pSSysSearchField2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysSearchFieldService.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("pssyssearchfieldname")) {
                            string = objectNode.get("pssyssearchfieldname").asText();
                        }
                        if (objectNode2.has("pssyssearchfieldname")) {
                            string2 = objectNode2.get("pssyssearchfieldname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysSearchField pSSysSearchField2 : arrayList) {
                    object = new PSSysSearchField();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysSearchField2, false);
                    object3.add((JsonNode)pSSysSearchFieldService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysSearchDoc, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        super.onEmptyModelV2(pSSysSearchDoc);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysSearchFieldService pSSysSearchFieldService = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysSearchFieldService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysSearchDoc pSSysSearchDoc, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysSearchField pSSysSearchField = new PSSysSearchField();
        pSSysSearchField.set("PSSYSSEARCHDOCID", pSSysSearchDoc.getPSSysSearchDocId());
        PSSysSearchFieldService pSSysSearchFieldService = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysSearchFieldService.getModelV2Entity(pSSysSearchField, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysSearchDoc, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysSearchDoc pSSysSearchDoc, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysSearchDocServiceBase.isSimpleImportExportMode("")) {
            PSSysSearchFieldService pSSysSearchFieldService = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysSearchFieldService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysSearchField pSSysSearchField = new PSSysSearchField();
                    pSSysSearchField.setPSSysSearchDocId(pSSysSearchDoc.getPSSysSearchDocId());
                    pSSysSearchField.setPSSysSearchDocName(pSSysSearchDoc.getPSSysSearchDocName());
                    pSSysSearchFieldService.compileModelV2(pSSysSearchField, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysSearchField pSSysSearchField = new PSSysSearchField();
                        pSSysSearchField.setPSSysSearchDocId(pSSysSearchDoc.getPSSysSearchDocId());
                        pSSysSearchField.setPSSysSearchDocName(pSSysSearchDoc.getPSSysSearchDocName());
                        pSSysSearchFieldService.compileModelV2(pSSysSearchField, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysSearchDoc, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysSearchDoc pSSysSearchDoc, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysSearchFields(pSSysSearchDoc, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysSearchDoc, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysSearchFields(PSSysSearchDoc pSSysSearchDoc, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSSEARCHFIELD", true), (boolean)false) == 0) {
            PSSysSearchFieldService pSSysSearchFieldService = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
            PSSysSearchField pSSysSearchField = new PSSysSearchField();
            pSSysSearchField.setPSSysSearchFieldId(pSMOSFile.getPSModelId());
            if (!pSSysSearchFieldService.get((IEntity)pSSysSearchField, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysSearchField.getPSSysSearchDocId(), (String)pSSysSearchDoc.getPSSysSearchDocId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysSearchFieldService.exportModelV2(pSSysSearchField);
            pSSysSearchField.reset();
            if (!pSSysSearchFieldService.setModelV2ResScope((IEntity)pSSysSearchField, "PSSYSSEARCHDOC", pSSysSearchDoc.getPSSysSearchDocId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysSearchFieldService.importModelV2(pSSysSearchField, objectNode);
            SessionFactoryManager.commit();
            return pSSysSearchFieldService.getFile((IEntity)pSSysSearchField);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysSearchDoc pSSysSearchDoc, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysSearchFields(pSSysSearchDoc, list);
        super.onFillPasteHelps(pSSysSearchDoc, list);
    }

    protected void onFillPasteHelps_PSSysSearchFields(PSSysSearchDoc pSSysSearchDoc, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSSEARCHFIELD");
        pSHelpSection.setSectionParam2("DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5168\u6587\u68c0\u7d22\u6587\u6863]\u7684[\u5168\u6587\u68c0\u7d22\u5c5e\u6027]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        ArrayList arrayList;
        SelectField selectField;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        PSMOSFile pSMOSFile2;
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u68c0\u7d22\u5c5e\u6027>", "DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "PSSYSSEARCHDOCID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysSearchDocServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u68c0\u7d22\u5c5e\u6027>");
            } else if (PSSysSearchDocServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyssearchfields");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID|PSSYSSEARCHDOCID");
            pSMOSFile2.setFileTag3("PSSYSSEARCHFIELD");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "PSSYSSEARCHDOCID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "PSSYSSEARCHDOCID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysSearchDocServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u68c0\u7d22\u5b9e\u4f53>", "DER1N_PSSYSSEARCHDE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "PSSYSSEARCHDOCID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysSearchDocServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u68c0\u7d22\u5b9e\u4f53>");
            } else if (PSSysSearchDocServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyssearchdes");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSSEARCHDE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID|PSSYSSEARCHDOCID");
            pSMOSFile2.setFileTag3("PSSYSSEARCHDE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSSEARCHDE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "PSSYSSEARCHDOCID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSEARCHDE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "PSSYSSEARCHDOCID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysSearchDocServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        PSMOSFile pSMOSFile2;
        ArrayList arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSSysSearchDocServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u68c0\u7d22\u5c5e\u6027>", (boolean)false) == 0 || PSSysSearchDocServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysSearchFields", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "PSSYSSEARCHDOCID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysSearchDocServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u68c0\u7d22\u5b9e\u4f53>", (boolean)false) == 0 || PSSysSearchDocServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysSearchDEs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSEARCHDE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "PSSYSSEARCHDOCID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (arrayList2.size() > 0) {
            return PSMOSFileUtil.append(arrayList2.toArray(new PSMOSFile[arrayList2.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", (boolean)false) == 0) {
            if (PSSysSearchDocServiceBase.getMOSVer() == 1) {
                return "<\u68c0\u7d22\u5c5e\u6027>";
            }
            if (PSSysSearchDocServiceBase.getMOSVer() == 2) {
                return "pssyssearchfields";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHDE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", (boolean)false) == 0) {
            if (PSSysSearchDocServiceBase.getMOSVer() == 1) {
                return "<\u68c0\u7d22\u5b9e\u4f53>";
            }
            if (PSSysSearchDocServiceBase.getMOSVer() == 2) {
                return "pssyssearchdes";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}

