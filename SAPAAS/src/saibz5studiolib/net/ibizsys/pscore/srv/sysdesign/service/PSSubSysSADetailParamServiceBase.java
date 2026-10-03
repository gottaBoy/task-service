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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADetailParamDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADetailParamDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetailBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetailParam;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysSADetailParamServiceBase
extends PSCoreSysServiceBase<PSSubSysSADetailParam> {
    private static final Log log = LogFactory.getLog(PSSubSysSADetailParamServiceBase.class);
    private PSSubSysSADetailParamDEModel pSSubSysSADetailParamDEModel;
    private PSSubSysSADetailParamDAO pSSubSysSADetailParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailParamService";
    }

    public PSSubSysSADetailParamDEModel getPSSubSysSADetailParamDEModel() {
        if (this.pSSubSysSADetailParamDEModel == null) {
            try {
                this.pSSubSysSADetailParamDEModel = (PSSubSysSADetailParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADetailParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADetailParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubSysSADetailParamDEModel();
    }

    public PSSubSysSADetailParamDAO getPSSubSysSADetailParamDAO() {
        if (this.pSSubSysSADetailParamDAO == null) {
            try {
                this.pSSubSysSADetailParamDAO = (PSSubSysSADetailParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADetailParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADetailParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubSysSADetailParamDAO();
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

    protected void onFillParentInfo(PSSubSysSADetailParam pSSubSysSADetailParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADETAILPARAM_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADetail pSSubSysSADetail = (PSSubSysSADetail)iService.getDEModel().createEntity();
            pSSubSysSADetail.set("PSSUBSYSSADETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSysSADetail);
            } else {
                iService.get(pSSubSysSADetail);
            }
            this.onFillParentInfo_PSSubSysSADetail(pSSubSysSADetailParam, pSSubSysSADetail);
            return;
        }
        super.onFillParentInfo(pSSubSysSADetailParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSubSysSADetail(PSSubSysSADetailParam pSSubSysSADetailParam, PSSubSysSADetail pSSubSysSADetail) throws Exception {
        pSSubSysSADetailParam.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
        pSSubSysSADetailParam.setPSSubSysSADetailName(pSSubSysSADetail.getPSSubSysSADetailName());
    }

    protected void onFillEntityFullInfo(PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSubSysSADetailParam, bl);
        this.onFillEntityFullInfo_PSSubSysSADetail(pSSubSysSADetailParam, bl);
    }

    protected void onFillEntityFullInfo_PSSubSysSADetail(PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl) throws Exception {
        super.onWriteBackParent(pSSubSysSADetailParam, bl);
    }

    public ArrayList<PSSubSysSADetailParam> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase) throws Exception {
        return this.selectByPSSubSysSADetail(pSSubSysSADetailBase, "", -1);
    }

    public ArrayList<PSSubSysSADetailParam> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase, String string) throws Exception {
        return this.selectByPSSubSysSADetail(pSSubSysSADetailBase, string, -1);
    }

    public ArrayList<PSSubSysSADetailParam> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSADETAILID", (Object)pSSubSysSADetailBase.getPSSubSysSADetailId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysSADetailCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysSADetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADetailParam> selectTempByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase) throws Exception {
        return this.selectTempByPSSubSysSADetail(pSSubSysSADetailBase, "");
    }

    public ArrayList<PSSubSysSADetailParam> selectTempByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSADETAILID", (Object)pSSubSysSADetailBase.getPSSubSysSADetailId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSubSysSADetailCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSubSysSADetailCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    public void resetPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSSubSysSADetailParam> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail);
        for (PSSubSysSADetailParam pSSubSysSADetailParam : arrayList) {
            PSSubSysSADetailParam pSSubSysSADetailParam2 = (PSSubSysSADetailParam)this.getDEModel().createEntity();
            pSSubSysSADetailParam2.setPSSubSysSADetailParamId(pSSubSysSADetailParam.getPSSubSysSADetailParamId());
            pSSubSysSADetailParam2.setPSSubSysSADetailId(null);
            this.update(pSSubSysSADetailParam2);
        }
    }

    public void resetTempPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSSubSysSADetailParam> arrayList = this.selectTempByPSSubSysSADetail(pSSubSysSADetail);
        for (PSSubSysSADetailParam pSSubSysSADetailParam : arrayList) {
            PSSubSysSADetailParam pSSubSysSADetailParam2 = (PSSubSysSADetailParam)this.getDEModel().createEntity();
            pSSubSysSADetailParam2.setPSSubSysSADetailParamId(pSSubSysSADetailParam.getPSSubSysSADetailParamId());
            pSSubSysSADetailParam2.setPSSubSysSADetailId(null);
            this.updateTemp(pSSubSysSADetailParam2);
        }
    }

    public void removeByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        final PSSubSysSADetail pSSubSysSADetail2 = pSSubSysSADetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADetailParamServiceBase.this.onBeforeRemoveByPSSubSysSADetail(pSSubSysSADetail2);
                PSSubSysSADetailParamServiceBase.this.internalRemoveByPSSubSysSADetail(pSSubSysSADetail2);
                PSSubSysSADetailParamServiceBase.this.onAfterRemoveByPSSubSysSADetail(pSSubSysSADetail2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    protected void internalRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSSubSysSADetailParam> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail);
        this.onBeforeRemoveByPSSubSysSADetail(pSSubSysSADetail, arrayList);
        for (PSSubSysSADetailParam pSSubSysSADetailParam : arrayList) {
            this.remove(pSSubSysSADetailParam);
        }
        this.onAfterRemoveByPSSubSysSADetail(pSSubSysSADetail, arrayList);
    }

    protected void onAfterRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail, ArrayList<PSSubSysSADetailParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail, ArrayList<PSSubSysSADetailParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubSysSADetailParam pSSubSysSADetailParam) throws Exception {
        super.onBeforeRemove(pSSubSysSADetailParam);
    }

    public void removeTempByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        final PSSubSysSADetail pSSubSysSADetail2 = pSSubSysSADetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADetailParamServiceBase.this.onBeforeRemoveTempByPSSubSysSADetail(pSSubSysSADetail2);
                PSSubSysSADetailParamServiceBase.this.internalRemoveTempByPSSubSysSADetail(pSSubSysSADetail2);
                PSSubSysSADetailParamServiceBase.this.onAfterRemoveTempByPSSubSysSADetail(pSSubSysSADetail2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    protected void internalRemoveTempByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSSubSysSADetailParam> arrayList = this.selectTempByPSSubSysSADetail(pSSubSysSADetail);
        this.onBeforeRemoveTempByPSSubSysSADetail(pSSubSysSADetail, arrayList);
        for (PSSubSysSADetailParam pSSubSysSADetailParam : arrayList) {
            this.removeTemp(pSSubSysSADetailParam);
        }
        this.onAfterRemoveTempByPSSubSysSADetail(pSSubSysSADetail, arrayList);
    }

    protected void onAfterRemoveTempByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail, ArrayList<PSSubSysSADetailParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail, ArrayList<PSSubSysSADetailParam> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSubSysSADetailParam pSSubSysSADetailParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSubSysSADetailParam, cloneSession);
        if (pSSubSysSADetailParam.getPSSubSysSADetailId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADETAIL", (Object)pSSubSysSADetailParam.getPSSubSysSADetailId())) != null) {
            this.onFillParentInfo_PSSubSysSADetail(pSSubSysSADetailParam, (PSSubSysSADetail)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSubSysSADetailParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ArrayFlag(bl, pSSubSysSADetailParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamTag(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamTag2(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADetailId(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADetailParamId(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADetailParamName(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSubSysSADetailParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSubSysSADetailParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ArrayFlag(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isArrayFlagDirty() : !pSSubSysSADetailParam.isArrayFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysSADetailParam.getArrayFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArrayFlag_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isCodeNameDirty() && !bl2 : !pSSubSysSADetailParam.isCodeNameDirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSubSysSADetailParam, bl2, bl3);
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
                string3 = "PSSUBSYSSADETAILID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADetailParamDEModel(), "CODENAME", string3, pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isMemoDirty() : !pSSubSysSADetailParam.isMemoDirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isOrderValueDirty() : !pSSubSysSADetailParam.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSubSysSADetailParam.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamTag(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isParamTagDirty() : !pSSubSysSADetailParam.isParamTagDirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getParamTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamTag_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamTag2(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isParamTag2Dirty() : !pSSubSysSADetailParam.isParamTag2Dirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getParamTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamTag2_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysSADetailId(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isPSSubSysSADetailIdDirty() : !pSSubSysSADetailParam.isPSSubSysSADetailIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getPSSubSysSADetailId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADetailId_Default(pSSubSysSADetailParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADetailParamId(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isPSSubSysSADetailParamIdDirty() && !bl2 : !pSSubSysSADetailParam.isPSSubSysSADetailParamIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getPSSubSysSADetailParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADetailParamId_Default(pSSubSysSADetailParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADetailParamName(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isPSSubSysSADetailParamNameDirty() && !bl2 : !pSSubSysSADetailParam.isPSSubSysSADetailParamNameDirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getPSSubSysSADetailParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADetailParamName_Default(pSSubSysSADetailParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILPARAMNAME");
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
                string3 = "PSSUBSYSSADETAILID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADetailParamDEModel(), "PSSUBSYSSADETAILPARAMNAME", string3, pSSubSysSADetailParam, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSUBSYSSADETAILPARAMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isStdDataTypeDirty() : !pSSubSysSADetailParam.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSubSysSADetailParam.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isUserCatDirty() : !pSSubSysSADetailParam.isUserCatDirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isUserTagDirty() : !pSSubSysSADetailParam.isUserTagDirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isUserTag2Dirty() : !pSSubSysSADetailParam.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isUserTag3Dirty() : !pSSubSysSADetailParam.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetailParam.isUserTag4Dirty() : !pSSubSysSADetailParam.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSubSysSADetailParam.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSubSysSADetailParam, bl2, bl3);
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

    protected void onSyncEntity(PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl) throws Exception {
        super.onSyncEntity(pSSubSysSADetailParam, bl);
    }

    protected void onSyncIndexEntities(PSSubSysSADetailParam pSSubSysSADetailParam, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSubSysSADetailParam, bl);
    }

    public Object getDataContextValue(PSSubSysSADetailParam pSSubSysSADetailParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSubSysSADetailParam, string, iDataContextParam)) != null) {
            return object;
        }
        PSSubSysSADetail pSSubSysSADetail = pSSubSysSADetailParam.getPSSubSysSADetail();
        if (pSSubSysSADetail != null && pSSubSysSADetail.contains(string)) {
            return pSSubSysSADetail.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSubSysSADetailParam pSSubSysSADetailParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSubSysSADetailParam, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailParamName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSubSysSADetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADetailParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADETAILPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADetailParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADETAILPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSubSysSADetailParam pSSubSysSADetailParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSubSysSADetailParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubSysSADetailParam pSSubSysSADetailParam) throws Exception {
        super.onUpdateParent(pSSubSysSADetailParam);
    }

    @Override
    protected void exportCurXmlModel(PSSubSysSADetailParam pSSubSysSADetailParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBSYSSADETAILPARAM");
        if (!bl) {
            pSSubSysSADetailParam.setCreateDate(null);
            pSSubSysSADetailParam.setCreateMan(null);
            pSSubSysSADetailParam.setPSSubSysSADetailParamId(null);
            pSSubSysSADetailParam.setUpdateDate(null);
            pSSubSysSADetailParam.setUpdateMan(null);
            pSSubSysSADetailParam.setPSSubSysSADetailId(null);
            pSSubSysSADetailParam.setPSSubSysSADetailName(null);
            super.exportCurXmlModel(pSSubSysSADetailParam, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSubSysSADetailParam pSSubSysSADetailParam, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSubSysSADetailParam, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSUBSYSSADETAIL#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSUBSYSSADETAILPARAM_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADETAILNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAIL", (boolean)true) == 0) {
            iEntity.set("PSSUBSYSSADETAILID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSUBSYSSADETAILID"};
    }

    @Override
    public String getModelV2Tag(PSSubSysSADetailParam pSSubSysSADetailParam) {
        if (!StringHelper.isNullOrEmpty((String)pSSubSysSADetailParam.getCodeName())) {
            return pSSubSysSADetailParam.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSubSysSADetailParam.getPSSubSysSADetailParamName())) {
            return pSSubSysSADetailParam.getPSSubSysSADetailParamName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSubSysSADetailParam.getCodeName())) {
            return pSSubSysSADetailParam.getCodeName();
        }
        return super.getModelV2Tag(pSSubSysSADetailParam);
    }

    @Override
    public boolean setModelV2Tag(PSSubSysSADetailParam pSSubSysSADetailParam, String string) {
        pSSubSysSADetailParam.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSUBSYSSADETAILPARAMNAME", "");
        map.put("CODENAME", "");
        map.put("PSSUBSYSSADETAILID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSubSysSADetailParam pSSubSysSADetailParam, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSubSysSADetailParam.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSubSysSADetailParam, true);
        pSSubSysSADetailParam.set("CODENAME", string);
        if (this.select(pSSubSysSADetailParam, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSubSysSADetailParam, true);
        return super.getModelV2Entity(pSSubSysSADetailParam, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSubSysSADetailParam pSSubSysSADetailParam, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSubSysSADetailParam, objectNode, string, string2, n);
    }
}

