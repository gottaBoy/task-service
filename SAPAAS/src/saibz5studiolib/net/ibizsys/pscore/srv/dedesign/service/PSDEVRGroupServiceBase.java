/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.ibizsys.paas.demodel.DEModelGlobal
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
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEVRGroupDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEVRGroupDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGrpDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEVRGrpDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEVRGrpDetailServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEVRGroupServiceBase
extends PSCoreSysServiceBase<PSDEVRGroup> {
    private static final Log log = LogFactory.getLog(PSDEVRGroupServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEVRGroupDEModel pSDEVRGroupDEModel;
    private PSDEVRGroupDAO pSDEVRGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService";
    }

    public PSDEVRGroupDEModel getPSDEVRGroupDEModel() {
        if (this.pSDEVRGroupDEModel == null) {
            try {
                this.pSDEVRGroupDEModel = (PSDEVRGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEVRGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEVRGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEVRGroupDEModel();
    }

    public PSDEVRGroupDAO getPSDEVRGroupDAO() {
        if (this.pSDEVRGroupDAO == null) {
            try {
                this.pSDEVRGroupDAO = (PSDEVRGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEVRGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEVRGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEVRGroupDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
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

    protected void onFillParentInfo(PSDEVRGroup pSDEVRGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVRGROUP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEVRGroup, pSDataEntity);
            return;
        }
        super.onFillParentInfo(pSDEVRGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEVRGroup pSDEVRGroup, PSDataEntity pSDataEntity) throws Exception {
        pSDEVRGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEVRGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillEntityFullInfo(PSDEVRGroup pSDEVRGroup, boolean bl) throws Exception {
        if (bl) {
            if (pSDEVRGroup.getCodeName() == null) {
                pSDEVRGroup.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DEVRGroup", 25));
            }
            if (pSDEVRGroup.getPSDEVRGroupName() == null) {
                pSDEVRGroup.setPSDEVRGroupName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5b9e\u4f53\u503c\u89c4\u5219\u7ec4", 25));
            }
        }
        super.onFillEntityFullInfo(pSDEVRGroup, bl);
        this.onFillEntityFullInfo_PSDE(pSDEVRGroup, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEVRGroup pSDEVRGroup, boolean bl) throws Exception {
        if (pSDEVRGroup.isPSDEIdDirty()) {
            if (pSDEVRGroup.getPSDEId() != null) {
                if (pSDEVRGroup.getPSDEId() == null || pSDEVRGroup.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEVRGroup.getPSDE();
                    pSDEVRGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEVRGroup.setPSDEName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEVRGroup pSDEVRGroup, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEVRGroup, bl);
    }

    public ArrayList<PSDEVRGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEVRGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEVRGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEVRGroup> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEVRGroup pSDEVRGroup : arrayList) {
            PSDEVRGroup pSDEVRGroup2 = (PSDEVRGroup)this.getDEModel().createEntity();
            pSDEVRGroup2.setPSDEVRGroupId(pSDEVRGroup.getPSDEVRGroupId());
            pSDEVRGroup2.setPSDEId(null);
            this.update(pSDEVRGroup2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEVRGroupServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEVRGroupServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEVRGroupServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEVRGroup> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEVRGroup pSDEVRGroup : arrayList) {
            this.remove(pSDEVRGroup);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEVRGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEVRGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEVRGroup pSDEVRGroup) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSDEVRGroup(pSDEVRGroup);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEVRGroup(pSDEVRGroup);
        pSCoreSysServiceBase = (PSDEVRGrpDetailService)ServiceGlobal.getService(PSDEVRGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEVRGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEVRGroup(pSDEVRGroup);
        ((PSDEVRGrpDetailServiceBase)pSCoreSysServiceBase).removeByPSDEVRGroup(pSDEVRGroup);
        super.onBeforeRemove(pSDEVRGroup);
    }

    protected void onBeforeRemoveTemp(PSDEVRGroup pSDEVRGroup) throws Exception {
        PSDEVRGrpDetailService pSDEVRGrpDetailService = (PSDEVRGrpDetailService)ServiceGlobal.getService(PSDEVRGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDEVRGrpDetailService.removeTempByPSDEVRGroup(pSDEVRGroup);
        super.onBeforeRemoveTemp(pSDEVRGroup);
    }

    protected void getRelatedDataTempMajor(PSDEVRGroup pSDEVRGroup) throws Exception {
        this.getRelatedDataTempMajor_PSDEVRGrpDetail(pSDEVRGroup);
        super.getRelatedDataTempMajor(pSDEVRGroup);
    }

    protected void getRelatedDataTempMajor_PSDEVRGrpDetail(PSDEVRGroup pSDEVRGroup) throws Exception {
        PSDEVRGrpDetailService pSDEVRGrpDetailService = (PSDEVRGrpDetailService)ServiceGlobal.getService(PSDEVRGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEVRGrpDetail> arrayList = null;
        String string = pSDEVRGroup.getPSDEVRGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEVRGrpDetailService.selectByPSDEVRGroup(pSDEVRGroup) : pSDEVRGrpDetailService.selectTempByPSDEVRGroup(pSDEVRGroup);
        for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList) {
            pSDEVRGrpDetailService.getTempMajor(pSDEVRGrpDetail);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEVRGroup pSDEVRGroup, PSDEVRGroup pSDEVRGroup2) throws Exception {
        ArrayList<PSDEVRGrpDetail> arrayList = this.updateRelatedDataTempMajor_removePSDEVRGrpDetail(pSDEVRGroup, pSDEVRGroup2);
        this.updateRelatedDataTempMajor_updatePSDEVRGrpDetail(pSDEVRGroup, pSDEVRGroup2, arrayList);
        super.updateRelatedDataTempMajor(pSDEVRGroup, pSDEVRGroup2);
    }

    protected ArrayList<PSDEVRGrpDetail> updateRelatedDataTempMajor_removePSDEVRGrpDetail(PSDEVRGroup pSDEVRGroup, PSDEVRGroup pSDEVRGroup2) throws Exception {
        PSDEVRGrpDetailService pSDEVRGrpDetailService = (PSDEVRGrpDetailService)ServiceGlobal.getService(PSDEVRGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEVRGrpDetail> arrayList = pSDEVRGrpDetailService.selectTempByPSDEVRGroup(pSDEVRGroup);
        ArrayList<PSDEVRGrpDetail> arrayList2 = pSDEVRGrpDetailService.selectByPSDEVRGroup(pSDEVRGroup2);
        HashMap<String, PSDEVRGrpDetail> hashMap = new HashMap<String, PSDEVRGrpDetail>();
        for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList2) {
            hashMap.put(pSDEVRGrpDetail.getPSDEVRGrpDetailId(), pSDEVRGrpDetail);
        }
        for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList) {
            Object object = pSDEVRGrpDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEVRGrpDetail pSDEVRGrpDetail : hashMap.values()) {
            pSDEVRGrpDetailService.remove(pSDEVRGrpDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEVRGrpDetail(PSDEVRGroup pSDEVRGroup, PSDEVRGroup pSDEVRGroup2, ArrayList<PSDEVRGrpDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEVRGrpDetailService pSDEVRGrpDetailService = (PSDEVRGrpDetailService)ServiceGlobal.getService(PSDEVRGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList) {
            pSDEVRGrpDetailService.updateTempMajor(pSDEVRGrpDetail);
        }
    }

    protected void replaceParentInfo(PSDEVRGroup pSDEVRGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEVRGroup, cloneSession);
        if (pSDEVRGroup.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEVRGroup.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEVRGroup, (PSDataEntity)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEVRGroup pSDEVRGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEVRGroup, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEVRGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag2(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEVRGroupId(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEVRGroupName(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEVRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEVRGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isCodeNameDirty() && !bl2 : !pSDEVRGroup.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEVRGroup.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEVRGroup, bl2, bl3);
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEVRGroupDEModel(), "CODENAME", string3, pSDEVRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupTag(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isGroupTagDirty() : !pSDEVRGroup.isGroupTagDirty()) {
            return null;
        }
        String string = pSDEVRGroup.getGroupTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag_Default(pSDEVRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTag2(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isGroupTag2Dirty() : !pSDEVRGroup.isGroupTag2Dirty()) {
            return null;
        }
        String string = pSDEVRGroup.getGroupTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag2_Default(pSDEVRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isMemoDirty() : !pSDEVRGroup.isMemoDirty()) {
            return null;
        }
        String string = pSDEVRGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEVRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isOrderValueDirty() : !pSDEVRGroup.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEVRGroup.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEVRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isPSDEIdDirty() && !bl2 : !pSDEVRGroup.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEVRGroup.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEVRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isPSDENameDirty() && !bl2 : !pSDEVRGroup.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEVRGroup.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEVRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEVRGroupId(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isPSDEVRGroupIdDirty() && !bl2 : !pSDEVRGroup.isPSDEVRGroupIdDirty()) {
            return null;
        }
        String string = pSDEVRGroup.getPSDEVRGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEVRGroupId_Default(pSDEVRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEVRGroupName(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isPSDEVRGroupNameDirty() && !bl2 : !pSDEVRGroup.isPSDEVRGroupNameDirty()) {
            return null;
        }
        String string = pSDEVRGroup.getPSDEVRGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEVRGroupName_Default(pSDEVRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVRGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEVRGroupDEModel(), "PSDEVRGROUPNAME", string3, pSDEVRGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVRGROUPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isUserCatDirty() : !pSDEVRGroup.isUserCatDirty()) {
            return null;
        }
        String string = pSDEVRGroup.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEVRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isUserParamsDirty() : !pSDEVRGroup.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEVRGroup.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDEVRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isUserTagDirty() : !pSDEVRGroup.isUserTagDirty()) {
            return null;
        }
        String string = pSDEVRGroup.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEVRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isUserTag2Dirty() : !pSDEVRGroup.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEVRGroup.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEVRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isUserTag3Dirty() : !pSDEVRGroup.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEVRGroup.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEVRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEVRGroup pSDEVRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEVRGroup.isUserTag4Dirty() : !pSDEVRGroup.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEVRGroup.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEVRGroup, bl2, bl3);
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

    protected void onSyncEntity(PSDEVRGroup pSDEVRGroup, boolean bl) throws Exception {
        super.onSyncEntity(pSDEVRGroup, bl);
    }

    protected void onSyncIndexEntities(PSDEVRGroup pSDEVRGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEVRGroup, bl);
    }

    public Object getDataContextValue(PSDEVRGroup pSDEVRGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEVRGroup, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEVRGroup pSDEVRGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEVRGroup, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"GROUPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVRGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEVRGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVRGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEVRGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_GroupTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEVRGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVRGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEVRGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVRGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEVRGroup pSDEVRGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEVRGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEVRGroup pSDEVRGroup) throws Exception {
        super.onUpdateParent(pSDEVRGroup);
    }

    @Override
    protected void exportCurXmlModel(PSDEVRGroup pSDEVRGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVRGROUP");
        if (!bl) {
            pSDEVRGroup.setCreateDate(null);
            pSDEVRGroup.setCreateMan(null);
            pSDEVRGroup.setPSDEVRGroupId(null);
            pSDEVRGroup.setUpdateDate(null);
            pSDEVRGroup.setUpdateMan(null);
            super.exportCurXmlModel(pSDEVRGroup, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEVRGroup pSDEVRGroup, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEVRGrpDetail(pSDEVRGroup, xmlNode);
        super.onExportRelatedXmlModel(pSDEVRGroup, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEVRGrpDetail(PSDEVRGroup pSDEVRGroup, XmlNode xmlNode) throws Exception {
        PSDEVRGrpDetailService pSDEVRGrpDetailService = (PSDEVRGrpDetailService)ServiceGlobal.getService(PSDEVRGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEVRGrpDetail> arrayList = null;
        String string = pSDEVRGroup.getPSDEVRGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEVRGrpDetailService.selectByPSDEVRGroup(pSDEVRGroup, "ORDER BY ORDERVALUE ASC") : pSDEVRGrpDetailService.selectTempByPSDEVRGroup(pSDEVRGroup, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEVRGRPDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEVRGrpDetail pSDEVRGrpDetail : arrayList) {
                pSDEVRGrpDetail.set("ORDERVALUE", null);
                pSDEVRGrpDetailService.exportXmlModel(pSDEVRGrpDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEVRGroup pSDEVRGroup, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEVRGRPDETAILS");
        this.importRelatedXmlModel_PSDEVRGrpDetail(pSDEVRGroup, xmlNode2);
        super.onImportRelatedXmlModel(pSDEVRGroup, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEVRGrpDetail(PSDEVRGroup pSDEVRGroup, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEVRGrpDetailService pSDEVRGrpDetailService = (PSDEVRGrpDetailService)ServiceGlobal.getService(PSDEVRGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEVRGroup.getPSDEVRGroupId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEVRGrpDetailService.removeByPSDEVRGroup(pSDEVRGroup);
        } else {
            pSDEVRGrpDetailService.removeTempByPSDEVRGroup(pSDEVRGroup);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEVRGrpDetail pSDEVRGrpDetail = new PSDEVRGrpDetail();
                pSDEVRGrpDetail.setOrderValue(n);
                n += 100;
                pSDEVRGrpDetailService.fillParentInfo(pSDEVRGrpDetail, "DER1N", "DER1N_PSDEVRGRPDETAIL_PSDEVRGROUP_PSDEVRGROUPID", pSDEVRGroup.getPSDEVRGroupId());
                pSDEVRGrpDetailService.importXmlModel(pSDEVRGrpDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEVRGroup pSDEVRGroup, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEVRGroup, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEVRGROUP_PSDATAENTITY_PSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEVRGroup pSDEVRGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSDEVRGroup.getCodeName())) {
            return pSDEVRGroup.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEVRGroup.getPSDEVRGroupName())) {
            return pSDEVRGroup.getPSDEVRGroupName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEVRGroup.getCodeName())) {
            return pSDEVRGroup.getCodeName();
        }
        return super.getModelV2Tag(pSDEVRGroup);
    }

    @Override
    public boolean setModelV2Tag(PSDEVRGroup pSDEVRGroup, String string) {
        pSDEVRGroup.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEVRGROUPNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEVRGROUPNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEVRGroup pSDEVRGroup, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEVRGroup.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEVRGroup, true);
        pSDEVRGroup.set("CODENAME", string);
        if (this.select(pSDEVRGroup, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEVRGroup, true);
        return super.getModelV2Entity(pSDEVRGroup, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEVRGroup pSDEVRGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEVRGroup, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEVRGroup pSDEVRGroup, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DEVRGroup");
        defaultValueMap.put("PSDEVRGROUPNAME", "\u5b9e\u4f53\u503c\u89c4\u5219\u7ec4");
    }
}

