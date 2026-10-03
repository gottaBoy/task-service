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
import net.ibizsys.pscore.srv.dedesign.dao.PSDESADetailParamDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDESADetailParamDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetailParam;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESADetailParamServiceBase
extends PSCoreSysServiceBase<PSDESADetailParam> {
    private static final Log log = LogFactory.getLog(PSDESADetailParamServiceBase.class);
    private PSDESADetailParamDEModel pSDESADetailParamDEModel;
    private PSDESADetailParamDAO pSDESADetailParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDESADetailParamService";
    }

    public PSDESADetailParamDEModel getPSDESADetailParamDEModel() {
        if (this.pSDESADetailParamDEModel == null) {
            try {
                this.pSDESADetailParamDEModel = (PSDESADetailParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDESADetailParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESADetailParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDESADetailParamDEModel();
    }

    public PSDESADetailParamDAO getPSDESADetailParamDAO() {
        if (this.pSDESADetailParamDAO == null) {
            try {
                this.pSDESADetailParamDAO = (PSDESADetailParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDESADetailParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESADetailParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDESADetailParamDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSDESADetailParam pSDESADetailParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESADETAILPARAM_PSDESADETAIL_PSDESADETAILID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService", (SessionFactory)this.getSessionFactory());
            PSDESADetail pSDESADetail = (PSDESADetail)iService.getDEModel().createEntity();
            pSDESADetail.set("PSDESADETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDESADetail);
            } else {
                iService.get(pSDESADetail);
            }
            this.onFillParentInfo_PSDESADetail(pSDESADetailParam, pSDESADetail);
            return;
        }
        super.onFillParentInfo(pSDESADetailParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDESADetail(PSDESADetailParam pSDESADetailParam, PSDESADetail pSDESADetail) throws Exception {
        pSDESADetailParam.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
        pSDESADetailParam.setPSDESADetailName(pSDESADetail.getPSDESADetailName());
    }

    protected void onFillEntityFullInfo(PSDESADetailParam pSDESADetailParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDESADetailParam, bl);
        this.onFillEntityFullInfo_PSDESADetail(pSDESADetailParam, bl);
    }

    protected void onFillEntityFullInfo_PSDESADetail(PSDESADetailParam pSDESADetailParam, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDESADetailParam pSDESADetailParam, boolean bl) throws Exception {
        super.onWriteBackParent(pSDESADetailParam, bl);
    }

    public ArrayList<PSDESADetailParam> selectByPSDESADetail(PSDESADetailBase pSDESADetailBase) throws Exception {
        return this.selectByPSDESADetail(pSDESADetailBase, "", -1);
    }

    public ArrayList<PSDESADetailParam> selectByPSDESADetail(PSDESADetailBase pSDESADetailBase, String string) throws Exception {
        return this.selectByPSDESADetail(pSDESADetailBase, string, -1);
    }

    public ArrayList<PSDESADetailParam> selectByPSDESADetail(PSDESADetailBase pSDESADetailBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESADETAILID", (Object)pSDESADetailBase.getPSDESADetailId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDESADetailCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDESADetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESADetailParam> selectTempByPSDESADetail(PSDESADetailBase pSDESADetailBase) throws Exception {
        return this.selectTempByPSDESADetail(pSDESADetailBase, "");
    }

    public ArrayList<PSDESADetailParam> selectTempByPSDESADetail(PSDESADetailBase pSDESADetailBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESADETAILID", (Object)pSDESADetailBase.getPSDESADetailId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDESADetailCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDESADetailCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
    }

    public void resetPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
        ArrayList<PSDESADetailParam> arrayList = this.selectByPSDESADetail(pSDESADetail);
        for (PSDESADetailParam pSDESADetailParam : arrayList) {
            PSDESADetailParam pSDESADetailParam2 = (PSDESADetailParam)this.getDEModel().createEntity();
            pSDESADetailParam2.setPSDESADetailParamId(pSDESADetailParam.getPSDESADetailParamId());
            pSDESADetailParam2.setPSDESADetailId(null);
            this.update(pSDESADetailParam2);
        }
    }

    public void resetTempPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
        ArrayList<PSDESADetailParam> arrayList = this.selectTempByPSDESADetail(pSDESADetail);
        for (PSDESADetailParam pSDESADetailParam : arrayList) {
            PSDESADetailParam pSDESADetailParam2 = (PSDESADetailParam)this.getDEModel().createEntity();
            pSDESADetailParam2.setPSDESADetailParamId(pSDESADetailParam.getPSDESADetailParamId());
            pSDESADetailParam2.setPSDESADetailId(null);
            this.updateTemp(pSDESADetailParam2);
        }
    }

    public void removeByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
        final PSDESADetail pSDESADetail2 = pSDESADetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailParamServiceBase.this.onBeforeRemoveByPSDESADetail(pSDESADetail2);
                PSDESADetailParamServiceBase.this.internalRemoveByPSDESADetail(pSDESADetail2);
                PSDESADetailParamServiceBase.this.onAfterRemoveByPSDESADetail(pSDESADetail2);
            }
        });
    }

    protected void onBeforeRemoveByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
    }

    protected void internalRemoveByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
        ArrayList<PSDESADetailParam> arrayList = this.selectByPSDESADetail(pSDESADetail);
        this.onBeforeRemoveByPSDESADetail(pSDESADetail, arrayList);
        for (PSDESADetailParam pSDESADetailParam : arrayList) {
            this.remove(pSDESADetailParam);
        }
        this.onAfterRemoveByPSDESADetail(pSDESADetail, arrayList);
    }

    protected void onAfterRemoveByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
    }

    protected void onBeforeRemoveByPSDESADetail(PSDESADetail pSDESADetail, ArrayList<PSDESADetailParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDESADetail(PSDESADetail pSDESADetail, ArrayList<PSDESADetailParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDESADetailParam pSDESADetailParam) throws Exception {
        super.onBeforeRemove(pSDESADetailParam);
    }

    public void removeTempByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
        final PSDESADetail pSDESADetail2 = pSDESADetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailParamServiceBase.this.onBeforeRemoveTempByPSDESADetail(pSDESADetail2);
                PSDESADetailParamServiceBase.this.internalRemoveTempByPSDESADetail(pSDESADetail2);
                PSDESADetailParamServiceBase.this.onAfterRemoveTempByPSDESADetail(pSDESADetail2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
    }

    protected void internalRemoveTempByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
        ArrayList<PSDESADetailParam> arrayList = this.selectTempByPSDESADetail(pSDESADetail);
        this.onBeforeRemoveTempByPSDESADetail(pSDESADetail, arrayList);
        for (PSDESADetailParam pSDESADetailParam : arrayList) {
            this.removeTemp(pSDESADetailParam);
        }
        this.onAfterRemoveTempByPSDESADetail(pSDESADetail, arrayList);
    }

    protected void onAfterRemoveTempByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDESADetail(PSDESADetail pSDESADetail, ArrayList<PSDESADetailParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDESADetail(PSDESADetail pSDESADetail, ArrayList<PSDESADetailParam> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDESADetailParam pSDESADetailParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDESADetailParam, cloneSession);
        if (pSDESADetailParam.getPSDESADetailId() != null && (iEntity = cloneSession.getEntity("PSDESADETAIL", (Object)pSDESADetailParam.getPSDESADetailId())) != null) {
            this.onFillParentInfo_PSDESADetail(pSDESADetailParam, (PSDESADetail)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDESADetailParam pSDESADetailParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDESADetailParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ArrayFlag(bl, pSDESADetailParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamTag(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamTag2(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESADetailId(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESADetailParamId(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESADetailParamName(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDESADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDESADetailParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ArrayFlag(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isArrayFlagDirty() : !pSDESADetailParam.isArrayFlagDirty()) {
            return null;
        }
        Integer n = pSDESADetailParam.getArrayFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArrayFlag_Default(pSDESADetailParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARRAYFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isCodeNameDirty() && !bl2 : !pSDESADetailParam.isCodeNameDirty()) {
            return null;
        }
        String string = pSDESADetailParam.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDESADetailParam, bl2, bl3);
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
                string3 = "PSDESADETAILID";
                String string4 = this.checkFieldDupRule(this.getPSDESADetailParamDEModel(), "CODENAME", string3, pSDESADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isMemoDirty() : !pSDESADetailParam.isMemoDirty()) {
            return null;
        }
        String string = pSDESADetailParam.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDESADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isOrderValueDirty() : !pSDESADetailParam.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDESADetailParam.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDESADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamTag(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isParamTagDirty() : !pSDESADetailParam.isParamTagDirty()) {
            return null;
        }
        String string = pSDESADetailParam.getParamTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamTag_Default(pSDESADetailParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamTag2(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isParamTag2Dirty() : !pSDESADetailParam.isParamTag2Dirty()) {
            return null;
        }
        String string = pSDESADetailParam.getParamTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamTag2_Default(pSDESADetailParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESADetailId(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isPSDESADetailIdDirty() : !pSDESADetailParam.isPSDESADetailIdDirty()) {
            return null;
        }
        String string = pSDESADetailParam.getPSDESADetailId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESADetailId_Default(pSDESADetailParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESADETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESADetailParamId(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isPSDESADetailParamIdDirty() && !bl2 : !pSDESADetailParam.isPSDESADetailParamIdDirty()) {
            return null;
        }
        String string = pSDESADetailParam.getPSDESADetailParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESADETAILPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESADetailParamId_Default(pSDESADetailParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESADETAILPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESADetailParamName(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isPSDESADetailParamNameDirty() && !bl2 : !pSDESADetailParam.isPSDESADetailParamNameDirty()) {
            return null;
        }
        String string = pSDESADetailParam.getPSDESADetailParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESADETAILPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESADetailParamName_Default(pSDESADetailParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESADETAILPARAMNAME");
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
                string3 = "PSDESADETAILID";
                String string4 = this.checkFieldDupRule(this.getPSDESADetailParamDEModel(), "PSDESADETAILPARAMNAME", string3, pSDESADetailParam, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDESADETAILPARAMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isStdDataTypeDirty() : !pSDESADetailParam.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSDESADetailParam.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default(pSDESADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isUserCatDirty() : !pSDESADetailParam.isUserCatDirty()) {
            return null;
        }
        String string = pSDESADetailParam.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDESADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isUserTagDirty() : !pSDESADetailParam.isUserTagDirty()) {
            return null;
        }
        String string = pSDESADetailParam.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDESADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isUserTag2Dirty() : !pSDESADetailParam.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDESADetailParam.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDESADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isUserTag3Dirty() : !pSDESADetailParam.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDESADetailParam.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDESADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDESADetailParam pSDESADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetailParam.isUserTag4Dirty() : !pSDESADetailParam.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDESADetailParam.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDESADetailParam, bl2, bl3);
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

    protected void onSyncEntity(PSDESADetailParam pSDESADetailParam, boolean bl) throws Exception {
        super.onSyncEntity(pSDESADetailParam, bl);
    }

    protected void onSyncIndexEntities(PSDESADetailParam pSDESADetailParam, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDESADetailParam, bl);
    }

    public Object getDataContextValue(PSDESADetailParam pSDESADetailParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDESADetailParam, string, iDataContextParam)) != null) {
            return object;
        }
        PSDESADetail pSDESADetail = pSDESADetailParam.getPSDESADetail();
        if (pSDESADetail != null && pSDESADetail.contains(string)) {
            return pSDESADetail.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDESADetailParam pSDESADetailParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDESADetailParam, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ARRAYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ArrayFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ParamTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ParamTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESADETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDESADetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESADETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDESADetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESADETAILPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDESADetailParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESADETAILPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDESADetailParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ArrayFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_ParamTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESADetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESADETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESADetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESADETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESADetailParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESADETAILPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESADetailParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESADETAILPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSDESADetailParam pSDESADetailParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDESADetailParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDESADetailParam pSDESADetailParam) throws Exception {
        super.onUpdateParent(pSDESADetailParam);
    }

    @Override
    protected void exportCurXmlModel(PSDESADetailParam pSDESADetailParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDESADETAILPARAM");
        if (!bl) {
            pSDESADetailParam.setCreateDate(null);
            pSDESADetailParam.setCreateMan(null);
            pSDESADetailParam.setPSDESADetailParamId(null);
            pSDESADetailParam.setUpdateDate(null);
            pSDESADetailParam.setUpdateMan(null);
            pSDESADetailParam.setPSDESADetailId(null);
            pSDESADetailParam.setPSDESADetailName(null);
            super.exportCurXmlModel(pSDESADetailParam, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDESADetailParam pSDESADetailParam, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDESADetailParam, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESADETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDESADETAIL#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESADETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDESADETAILPARAM_PSDESADETAIL_PSDESADETAILID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESADETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESADETAILNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDESADETAIL", (boolean)true) == 0) {
            iEntity.set("PSDESADETAILID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDESADETAILID"};
    }

    @Override
    public String getModelV2Tag(PSDESADetailParam pSDESADetailParam) {
        if (!StringHelper.isNullOrEmpty((String)pSDESADetailParam.getCodeName())) {
            return pSDESADetailParam.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDESADetailParam.getPSDESADetailParamName())) {
            return pSDESADetailParam.getPSDESADetailParamName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDESADetailParam.getCodeName())) {
            return pSDESADetailParam.getCodeName();
        }
        return super.getModelV2Tag(pSDESADetailParam);
    }

    @Override
    public boolean setModelV2Tag(PSDESADetailParam pSDESADetailParam, String string) {
        pSDESADetailParam.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDESADETAILPARAMNAME", "");
        map.put("CODENAME", "");
        map.put("PSDESADETAILID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDESADetailParam pSDESADetailParam, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDESADetailParam.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDESADetailParam, true);
        pSDESADetailParam.set("CODENAME", string);
        if (this.select(pSDESADetailParam, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDESADetailParam, true);
        return super.getModelV2Entity(pSDESADetailParam, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDESADetailParam pSDESADetailParam, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDESADetailParam, objectNode, string, string2, n);
    }
}

