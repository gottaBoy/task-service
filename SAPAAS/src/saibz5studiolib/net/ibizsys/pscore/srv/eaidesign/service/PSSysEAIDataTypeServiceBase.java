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
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
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
package net.ibizsys.pscore.srv.eaidesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
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
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
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
import net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDataTypeDAO;
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDataTypeDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataType;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataTypeItem;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAISchemeBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeItemService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeItemServiceBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementAttrService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementAttrServiceBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIDataTypeServiceBase
extends PSCoreSysServiceBase<PSSysEAIDataType> {
    private static final Log log = LogFactory.getLog(PSSysEAIDataTypeServiceBase.class);
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysEAIDataTypeDEModel pSSysEAIDataTypeDEModel;
    private PSSysEAIDataTypeDAO pSSysEAIDataTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeService";
    }

    public PSSysEAIDataTypeDEModel getPSSysEAIDataTypeDEModel() {
        if (this.pSSysEAIDataTypeDEModel == null) {
            try {
                this.pSSysEAIDataTypeDEModel = (PSSysEAIDataTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDataTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDataTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysEAIDataTypeDEModel();
    }

    public PSSysEAIDataTypeDAO getPSSysEAIDataTypeDAO() {
        if (this.pSSysEAIDataTypeDAO == null) {
            try {
                this.pSSysEAIDataTypeDAO = (PSSysEAIDataTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDataTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDataTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysEAIDataTypeDAO();
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

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchTempCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysEAIDataType pSSysEAIDataType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDATATYPE_PSSYSEAISCHEME_PSSYSEAISCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService", (SessionFactory)this.getSessionFactory());
            PSSysEAIScheme pSSysEAIScheme = (PSSysEAIScheme)iService.getDEModel().createEntity();
            pSSysEAIScheme.set("PSSYSEAISCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIScheme);
            } else {
                iService.get((IEntity)pSSysEAIScheme);
            }
            this.onFillParentInfo_PSSysEAIScheme(pSSysEAIDataType, pSSysEAIScheme);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysEAIDataType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysEAIScheme(PSSysEAIDataType pSSysEAIDataType, PSSysEAIScheme pSSysEAIScheme) throws Exception {
        pSSysEAIDataType.setPSSysEAISchemeId(pSSysEAIScheme.getPSSysEAISchemeId());
        pSSysEAIDataType.setPSSysEAISchemeName(pSSysEAIScheme.getPSSysEAISchemeName());
    }

    protected void onFillEntityFullInfo(PSSysEAIDataType pSSysEAIDataType, boolean bl) throws Exception {
        if (bl) {
            if (pSSysEAIDataType.getCodeName() == null) {
                pSSysEAIDataType.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DataType", 25));
            }
            if (pSSysEAIDataType.getValidFlag() == null) {
                pSSysEAIDataType.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysEAIDataType, bl);
        this.onFillEntityFullInfo_PSSysEAIScheme(pSSysEAIDataType, bl);
    }

    protected void onFillEntityFullInfo_PSSysEAIScheme(PSSysEAIDataType pSSysEAIDataType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysEAIDataType pSSysEAIDataType, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysEAIDataType, bl);
    }

    public ArrayList<PSSysEAIDataType> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase) throws Exception {
        return this.selectByPSSysEAIScheme(pSSysEAISchemeBase, "", -1);
    }

    public ArrayList<PSSysEAIDataType> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase, String string) throws Exception {
        return this.selectByPSSysEAIScheme(pSSysEAISchemeBase, string, -1);
    }

    public ArrayList<PSSysEAIDataType> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAISCHEMEID", (Object)pSSysEAISchemeBase.getPSSysEAISchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAISchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAISchemeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSysEAIDataType> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAISCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEAIScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIDATATYPE_PSSYSEAISCHEME_PSSYSEAISCHEMEID", "", iDataEntityModel.getName(), "PSSYSEAIDATATYPE", iDataEntityModel.getDataInfo((IEntity)pSSysEAIScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSysEAIDataType> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme);
        for (PSSysEAIDataType pSSysEAIDataType : arrayList) {
            PSSysEAIDataType pSSysEAIDataType2 = (PSSysEAIDataType)this.getDEModel().createEntity();
            pSSysEAIDataType2.setPSSysEAIDataTypeId(pSSysEAIDataType.getPSSysEAIDataTypeId());
            pSSysEAIDataType2.setPSSysEAISchemeId(null);
            this.update(pSSysEAIDataType2);
        }
    }

    public void removeByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        final PSSysEAIScheme pSSysEAIScheme2 = pSSysEAIScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDataTypeServiceBase.this.onBeforeRemoveByPSSysEAIScheme(pSSysEAIScheme2);
                PSSysEAIDataTypeServiceBase.this.internalRemoveByPSSysEAIScheme(pSSysEAIScheme2);
                PSSysEAIDataTypeServiceBase.this.onAfterRemoveByPSSysEAIScheme(pSSysEAIScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
    }

    protected void internalRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSysEAIDataType> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme);
        this.onBeforeRemoveByPSSysEAIScheme(pSSysEAIScheme, arrayList);
        for (PSSysEAIDataType pSSysEAIDataType : arrayList) {
            this.remove((IEntity)pSSysEAIDataType);
        }
        this.onAfterRemoveByPSSysEAIScheme(pSSysEAIScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme, ArrayList<PSSysEAIDataType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme, ArrayList<PSSysEAIDataType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIDataTypeItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIDataType(pSSysEAIDataType);
        ((PSSysEAIDataTypeItemServiceBase)pSCoreSysServiceBase).removeByPSSysEAIDataType(pSSysEAIDataType);
        pSCoreSysServiceBase = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIDataType(pSSysEAIDataType);
        pSCoreSysServiceBase = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIDataType(pSSysEAIDataType);
        super.onBeforeRemove(pSSysEAIDataType);
    }

    protected void onBeforeRemoveTemp(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        pSSysEAIDataTypeItemService.removeTempByPSSysEAIDataType(pSSysEAIDataType);
        super.onBeforeRemoveTemp((IEntity)pSSysEAIDataType);
    }

    protected void getRelatedDataTempMajor(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        this.getRelatedDataTempMajor_PSSysEAIDataTypeItem(pSSysEAIDataType);
        super.getRelatedDataTempMajor((IEntity)pSSysEAIDataType);
    }

    protected void getRelatedDataTempMajor_PSSysEAIDataTypeItem(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDataTypeItem> arrayList = null;
        String string = pSSysEAIDataType.getPSSysEAIDataTypeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysEAIDataTypeItemService.selectByPSSysEAIDataType(pSSysEAIDataType) : pSSysEAIDataTypeItemService.selectTempByPSSysEAIDataType(pSSysEAIDataType);
        for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : arrayList) {
            pSSysEAIDataTypeItemService.getTempMajor(pSSysEAIDataTypeItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysEAIDataType pSSysEAIDataType, PSSysEAIDataType pSSysEAIDataType2) throws Exception {
        ArrayList<PSSysEAIDataTypeItem> arrayList = this.updateRelatedDataTempMajor_removePSSysEAIDataTypeItem(pSSysEAIDataType, pSSysEAIDataType2);
        this.updateRelatedDataTempMajor_updatePSSysEAIDataTypeItem(pSSysEAIDataType, pSSysEAIDataType2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSysEAIDataType, (IEntity)pSSysEAIDataType2);
    }

    protected ArrayList<PSSysEAIDataTypeItem> updateRelatedDataTempMajor_removePSSysEAIDataTypeItem(PSSysEAIDataType pSSysEAIDataType, PSSysEAIDataType pSSysEAIDataType2) throws Exception {
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDataTypeItem> arrayList = pSSysEAIDataTypeItemService.selectTempByPSSysEAIDataType(pSSysEAIDataType);
        ArrayList<PSSysEAIDataTypeItem> arrayList2 = pSSysEAIDataTypeItemService.selectByPSSysEAIDataType(pSSysEAIDataType2);
        HashMap<String, PSSysEAIDataTypeItem> hashMap = new HashMap<String, PSSysEAIDataTypeItem>();
        for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : arrayList2) {
            hashMap.put(pSSysEAIDataTypeItem.getPSSysEAIDataTypeItemId(), pSSysEAIDataTypeItem);
        }
        for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : arrayList) {
            Object object = pSSysEAIDataTypeItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : hashMap.values()) {
            pSSysEAIDataTypeItemService.remove((IEntity)pSSysEAIDataTypeItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysEAIDataTypeItem(PSSysEAIDataType pSSysEAIDataType, PSSysEAIDataType pSSysEAIDataType2, ArrayList<PSSysEAIDataTypeItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : arrayList) {
            pSSysEAIDataTypeItemService.updateTempMajor(pSSysEAIDataTypeItem);
        }
    }

    protected void replaceParentInfo(PSSysEAIDataType pSSysEAIDataType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysEAIDataType, cloneSession);
        if (pSSysEAIDataType.getPSSysEAISchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSEAISCHEME", (Object)pSSysEAIDataType.getPSSysEAISchemeId())) != null) {
            this.onFillParentInfo_PSSysEAIScheme(pSSysEAIDataType, (PSSysEAIScheme)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysEAIDataType pSSysEAIDataType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysEAIDataType, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysEAIDataType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIDataTypeTag(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIDataTypeTag2(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableEnum(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncMaxValue(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncMinValue(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxStrLength(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxValue(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinStrLength(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinValue(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDataTypeId(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDataTypeName(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAISchemeId(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegExpCode(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysEAIDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysEAIDataType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isCodeNameDirty() && !bl2 : !pSSysEAIDataType.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysEAIDataType, bl2, bl3);
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
                string3 = "PSSYSEAISCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIDataTypeDEModel(), "CODENAME", string3, pSSysEAIDataType, bl2, bl3);
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

    protected EntityFieldError onCheckField_EAIDataTypeTag(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isEAIDataTypeTagDirty() : !pSSysEAIDataType.isEAIDataTypeTagDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getEAIDataTypeTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIDataTypeTag_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIDATATYPETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EAIDataTypeTag2(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isEAIDataTypeTag2Dirty() : !pSSysEAIDataType.isEAIDataTypeTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getEAIDataTypeTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIDataTypeTag2_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIDATATYPETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableEnum(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isEnableEnumDirty() : !pSSysEAIDataType.isEnableEnumDirty()) {
            return null;
        }
        Integer n = pSSysEAIDataType.getEnableEnum();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableEnum_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEENUM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncMaxValue(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isIncMaxValueDirty() : !pSSysEAIDataType.isIncMaxValueDirty()) {
            return null;
        }
        Integer n = pSSysEAIDataType.getIncMaxValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncMaxValue_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCMAXVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncMinValue(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isIncMinValueDirty() : !pSSysEAIDataType.isIncMinValueDirty()) {
            return null;
        }
        Integer n = pSSysEAIDataType.getIncMinValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncMinValue_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCMINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxStrLength(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isMaxStrLengthDirty() : !pSSysEAIDataType.isMaxStrLengthDirty()) {
            return null;
        }
        Integer n = pSSysEAIDataType.getMaxStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxStrLength_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXSTRLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxValue(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isMaxValueDirty() : !pSSysEAIDataType.isMaxValueDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getMaxValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaxValue_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isMemoDirty() : !pSSysEAIDataType.isMemoDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysEAIDataType, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinStrLength(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isMinStrLengthDirty() : !pSSysEAIDataType.isMinStrLengthDirty()) {
            return null;
        }
        Integer n = pSSysEAIDataType.getMinStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinStrLength_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINSTRLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinValue(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isMinValueDirty() : !pSSysEAIDataType.isMinValueDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getMinValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinValue_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isPrecision2Dirty() : !pSSysEAIDataType.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSSysEAIDataType.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDataTypeId(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isPSSysEAIDataTypeIdDirty() && !bl2 : !pSSysEAIDataType.isPSSysEAIDataTypeIdDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getPSSysEAIDataTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDATATYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDataTypeId_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDATATYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDataTypeName(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isPSSysEAIDataTypeNameDirty() && !bl2 : !pSSysEAIDataType.isPSSysEAIDataTypeNameDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getPSSysEAIDataTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDATATYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDataTypeName_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDATATYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAISchemeId(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isPSSysEAISchemeIdDirty() && !bl2 : !pSSysEAIDataType.isPSSysEAISchemeIdDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getPSSysEAISchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAISCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAISchemeId_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAISCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RegExpCode(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isRegExpCodeDirty() : !pSSysEAIDataType.isRegExpCodeDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getRegExpCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegExpCode_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGEXPCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isStdDataTypeDirty() && !bl2 : !pSSysEAIDataType.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSysEAIDataType.getStdDataType();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STDDATATYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default((IEntity)pSSysEAIDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STDDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isUserCatDirty() : !pSSysEAIDataType.isUserCatDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysEAIDataType, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isUserTagDirty() : !pSSysEAIDataType.isUserTagDirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysEAIDataType, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isUserTag2Dirty() : !pSSysEAIDataType.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysEAIDataType, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isUserTag3Dirty() : !pSSysEAIDataType.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysEAIDataType, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isUserTag4Dirty() : !pSSysEAIDataType.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysEAIDataType.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysEAIDataType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysEAIDataType pSSysEAIDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDataType.isValidFlagDirty() && !bl2 : !pSSysEAIDataType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysEAIDataType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysEAIDataType, bl2, bl3);
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

    protected void onSyncEntity(PSSysEAIDataType pSSysEAIDataType, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysEAIDataType, bl);
    }

    protected void onSyncIndexEntities(PSSysEAIDataType pSSysEAIDataType, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysEAIDataType, bl);
    }

    public Object getDataContextValue(PSSysEAIDataType pSSysEAIDataType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysEAIDataType, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysEAIScheme pSSysEAIScheme = pSSysEAIDataType.getPSSysEAIScheme();
        if (pSSysEAIScheme != null && pSSysEAIScheme.contains(string)) {
            return pSSysEAIScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysEAIDataType pSSysEAIDataType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysEAIDataType, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"EAIDATATYPETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIDataTypeTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIDATATYPETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIDataTypeTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEENUM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableEnum_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCMAXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncMaxValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCMINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncMinValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXSTRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxStrLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINSTRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinStrLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDATATYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDataTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDATATYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDataTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAISchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGEXPCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegExpCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_EAIDataTypeTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIDATATYPETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EAIDataTypeTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIDATATYPETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableEnum_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IncMaxValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IncMinValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxStrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAXVALUE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_MinStrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MinValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINVALUE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysEAIDataTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDATATYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDataTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDATATYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAISchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAISCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAISchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAISCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RegExpCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGEXPCODE", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSSysEAIDataType pSSysEAIDataType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysEAIDataType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        super.onUpdateParent((IEntity)pSSysEAIDataType);
    }

    protected void onCopyDetails(PSSysEAIDataType pSSysEAIDataType, Object object) throws Exception {
        PSSysEAIDataType pSSysEAIDataType2 = new PSSysEAIDataType();
        pSSysEAIDataType2.set("PSSYSEAIDATATYPEID", object);
        String string = DataObject.getStringValue((Object)pSSysEAIDataType.get("PSSYSEAIDATATYPEID"));
        super.onCopyDetails((IEntity)pSSysEAIDataType, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysEAIDataType pSSysEAIDataType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSEAIDATATYPE");
        if (!bl) {
            pSSysEAIDataType.setCreateDate(null);
            pSSysEAIDataType.setCreateMan(null);
            pSSysEAIDataType.setPSSysEAIDataTypeId(null);
            pSSysEAIDataType.setUpdateDate(null);
            pSSysEAIDataType.setUpdateMan(null);
            super.exportCurXmlModel(pSSysEAIDataType, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysEAIDataType pSSysEAIDataType, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysEAIDataTypeItem(pSSysEAIDataType, xmlNode);
        super.onExportRelatedXmlModel(pSSysEAIDataType, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysEAIDataTypeItem(PSSysEAIDataType pSSysEAIDataType, XmlNode xmlNode) throws Exception {
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDataTypeItem> arrayList = null;
        String string = pSSysEAIDataType.getPSSysEAIDataTypeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysEAIDataTypeItemService.selectByPSSysEAIDataType(pSSysEAIDataType, "ORDER BY ORDERVALUE ASC") : pSSysEAIDataTypeItemService.selectTempByPSSysEAIDataType(pSSysEAIDataType, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSEAIDATATYPEITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : arrayList) {
                pSSysEAIDataTypeItem.set("ORDERVALUE", null);
                pSSysEAIDataTypeItemService.exportXmlModel(pSSysEAIDataTypeItem, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysEAIDataType pSSysEAIDataType, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSEAIDATATYPEITEMS");
        this.importRelatedXmlModel_PSSysEAIDataTypeItem(pSSysEAIDataType, xmlNode2);
        super.onImportRelatedXmlModel(pSSysEAIDataType, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysEAIDataTypeItem(PSSysEAIDataType pSSysEAIDataType, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysEAIDataType.getPSSysEAIDataTypeId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysEAIDataTypeItemService.removeByPSSysEAIDataType(pSSysEAIDataType);
        } else {
            pSSysEAIDataTypeItemService.removeTempByPSSysEAIDataType(pSSysEAIDataType);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysEAIDataTypeItem pSSysEAIDataTypeItem = new PSSysEAIDataTypeItem();
                pSSysEAIDataTypeItem.setOrderValue(n);
                n += 100;
                pSSysEAIDataTypeItemService.fillParentInfo((IEntity)pSSysEAIDataTypeItem, "DER1N", "DER1N_PSSYSEAIDATATYPEITEM_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID", pSSysEAIDataType.getPSSysEAIDataTypeId());
                pSSysEAIDataTypeItemService.importXmlModel(pSSysEAIDataTypeItem, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysEAIDataType pSSysEAIDataType, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysEAIDataType, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSEAISCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSEAIDATATYPE_PSSYSEAISCHEME_PSSYSEAISCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAISCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSEAISCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSEAISCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysEAIDataType pSSysEAIDataType) {
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDataType.getCodeName())) {
            return pSSysEAIDataType.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDataType.getCodeName())) {
            return pSSysEAIDataType.getCodeName();
        }
        return super.getModelV2Tag(pSSysEAIDataType);
    }

    @Override
    public boolean setModelV2Tag(PSSysEAIDataType pSSysEAIDataType, String string) {
        pSSysEAIDataType.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSEAISCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysEAIDataType pSSysEAIDataType, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysEAIDataType.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysEAIDataType, true);
        pSSysEAIDataType.set("CODENAME", string);
        if (this.select(pSSysEAIDataType, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysEAIDataType, true);
        return super.getModelV2Entity(pSSysEAIDataType, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysEAIDataType pSSysEAIDataType, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysEAIDataType, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSYSEAIDATATYPEITEM_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysEAIDataType pSSysEAIDataType, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysEAIDataType, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysEAIDataType pSSysEAIDataType, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSEAIDATATYPEITEM_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID")) {
            Object object;
            PSSysEAIDataTypeItem pSSysEAIDataTypeItem2;
            Object object2;
            Object object3;
            Object object4;
            PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysEAIDataTypeItem> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSEAIDATATYPE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSEAIDATATYPEITEM", (Object)pSSysEAIDataType.getPSSysEAIDataTypeId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysEAIDataTypeItem2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysEAIDataTypeItem2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysEAIDataTypeItem>();
                object4 = pSSysEAIDataTypeItemService.selectByPSSysEAIDataType(pSSysEAIDataType);
                object3 = StringHelper.format((String)"PSSYSEAIDATATYPE#%1$s", (Object)pSSysEAIDataType.getPSSysEAIDataTypeId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysEAIDataTypeItem2 = object2.next();
                    object = pSSysEAIDataTypeItemService.getModelV2ResScope((IEntity)pSSysEAIDataTypeItem2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysEAIDataTypeItem)PSModelV2Helper.toJSONObject((IEntity)pSSysEAIDataTypeItem2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysEAIDataTypeItemService.getModelV2Name(false);
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
                        if (objectNode.has("pssyseaidatatypeitemname")) {
                            string = objectNode.get("pssyseaidatatypeitemname").asText();
                        }
                        if (objectNode2.has("pssyseaidatatypeitemname")) {
                            string2 = objectNode2.get("pssyseaidatatypeitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem2 : arrayList) {
                    object = new PSSysEAIDataTypeItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysEAIDataTypeItem2, false);
                    object3.add((JsonNode)pSSysEAIDataTypeItemService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysEAIDataType, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDataTypeItem> arrayList = pSSysEAIDataTypeItemService.selectByPSSysEAIDataType(pSSysEAIDataType);
        String string = StringHelper.format((String)"PSSYSEAIDATATYPE#%1$s", (Object)pSSysEAIDataType.getPSSysEAIDataTypeId());
        for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : arrayList) {
            String string2 = pSSysEAIDataTypeItemService.getModelV2ResScope((IEntity)pSSysEAIDataTypeItem);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSysEAIDataTypeItemService.emptyModelV2(pSSysEAIDataTypeItem);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysEAIDataType.getPSSysEAIDataTypeId());
        pSSysEAIDataTypeItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSysEAIDataTypeItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSEAIDATATYPEITEM WHERE PSSYSEAIDATATYPEID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysEAIDataType);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysEAIDataTypeItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysEAIDataType pSSysEAIDataType, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysEAIDataTypeItem pSSysEAIDataTypeItem = new PSSysEAIDataTypeItem();
        pSSysEAIDataTypeItem.set("PSSYSEAIDATATYPEID", pSSysEAIDataType.getPSSysEAIDataTypeId());
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysEAIDataTypeItemService.getModelV2Entity(pSSysEAIDataTypeItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysEAIDataType, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysEAIDataType pSSysEAIDataType, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSysEAIDataTypeItemService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSysEAIDataTypeItem pSSysEAIDataTypeItem = new PSSysEAIDataTypeItem();
                pSSysEAIDataTypeItem.setPSSysEAIDataTypeId(pSSysEAIDataType.getPSSysEAIDataTypeId());
                pSSysEAIDataTypeItem.setPSSysEAIDataTypeName(pSSysEAIDataType.getPSSysEAIDataTypeName());
                pSSysEAIDataTypeItemService.compileModelV2(pSSysEAIDataTypeItem, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSysEAIDataTypeItem pSSysEAIDataTypeItem = new PSSysEAIDataTypeItem();
                    pSSysEAIDataTypeItem.setPSSysEAIDataTypeId(pSSysEAIDataType.getPSSysEAIDataTypeId());
                    pSSysEAIDataTypeItem.setPSSysEAIDataTypeName(pSSysEAIDataType.getPSSysEAIDataTypeName());
                    pSSysEAIDataTypeItemService.compileModelV2(pSSysEAIDataTypeItem, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysEAIDataType, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysEAIDataType pSSysEAIDataType, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSEAIDATATYPEITEM_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysEAIDataTypeItems(pSSysEAIDataType, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysEAIDataType, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysEAIDataTypeItems(PSSysEAIDataType pSSysEAIDataType, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSEAIDATATYPEITEM", true), (boolean)false) == 0) {
            PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysEAIDataTypeItem pSSysEAIDataTypeItem = new PSSysEAIDataTypeItem();
            pSSysEAIDataTypeItem.setPSSysEAIDataTypeItemId(pSMOSFile.getPSModelId());
            if (!pSSysEAIDataTypeItemService.get((IEntity)pSSysEAIDataTypeItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysEAIDataTypeItem.getPSSysEAIDataTypeId(), (String)pSSysEAIDataType.getPSSysEAIDataTypeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysEAIDataTypeItemService.exportModelV2(pSSysEAIDataTypeItem);
            pSSysEAIDataTypeItem.reset();
            if (!pSSysEAIDataTypeItemService.setModelV2ResScope((IEntity)pSSysEAIDataTypeItem, "PSSYSEAIDATATYPE", pSSysEAIDataType.getPSSysEAIDataTypeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysEAIDataTypeItemService.importModelV2(pSSysEAIDataTypeItem, objectNode);
            SessionFactoryManager.commit();
            return pSSysEAIDataTypeItemService.getFile((IEntity)pSSysEAIDataTypeItem);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysEAIDataType pSSysEAIDataType, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysEAIDataTypeItems(pSSysEAIDataType, list);
        super.onFillPasteHelps(pSSysEAIDataType, list);
    }

    protected void onFillPasteHelps_PSSysEAIDataTypeItems(PSSysEAIDataType pSSysEAIDataType, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSEAIDATATYPEITEM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSEAIDATATYPEITEM_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u96c6\u6210\u6570\u636e\u7c7b\u578b]\u7684[\u96c6\u6210\u6570\u636e\u7c7b\u578b\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysEAIDataType pSSysEAIDataType, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DataType");
    }
}

