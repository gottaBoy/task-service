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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDERTAWIDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDERTAWIDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERTAW;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERTAWBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERTAWI;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERTAWIServiceBase
extends PSCoreSysServiceBase<PSDERTAWI> {
    private static final Log log = LogFactory.getLog(PSDERTAWIServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VALID = "VALID";
    private PSDERTAWIDEModel pSDERTAWIDEModel;
    private PSDERTAWIDAO pSDERTAWIDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWIService";
    }

    public PSDERTAWIDEModel getPSDERTAWIDEModel() {
        if (this.pSDERTAWIDEModel == null) {
            try {
                this.pSDERTAWIDEModel = (PSDERTAWIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDERTAWIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERTAWIDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDERTAWIDEModel();
    }

    public PSDERTAWIDAO getPSDERTAWIDAO() {
        if (this.pSDERTAWIDAO == null) {
            try {
                this.pSDERTAWIDAO = (PSDERTAWIDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDERTAWIDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERTAWIDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDERTAWIDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALID, (boolean)true) == 0) {
            return this.fetchValid(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALID, (boolean)true) == 0) {
            return this.fetchTempValid(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALID, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDERTAWI pSDERTAWI, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERTAWI_PSDERTAW_PSDERTAWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWService", (SessionFactory)this.getSessionFactory());
            PSDERTAW pSDERTAW = (PSDERTAW)iService.getDEModel().createEntity();
            pSDERTAW.set("PSDERTAWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDERTAW);
            } else {
                iService.get((IEntity)pSDERTAW);
            }
            this.onFillParentInfo_PSDERTAW(pSDERTAWI, pSDERTAW);
            return;
        }
        super.onFillParentInfo((IEntity)pSDERTAWI, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDERTAW(PSDERTAWI pSDERTAWI, PSDERTAW pSDERTAW) throws Exception {
        pSDERTAWI.setPSDERTAWId(pSDERTAW.getPSDERTAWId());
        pSDERTAWI.setPSDERTAWName(pSDERTAW.getPSDERTAWName());
    }

    protected void onFillEntityFullInfo(PSDERTAWI pSDERTAWI, boolean bl) throws Exception {
        if (bl && pSDERTAWI.getValidFlag() == null) {
            pSDERTAWI.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDERTAWI, bl);
        this.onFillEntityFullInfo_PSDERTAW(pSDERTAWI, bl);
    }

    protected void onFillEntityFullInfo_PSDERTAW(PSDERTAWI pSDERTAWI, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDERTAWI pSDERTAWI, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDERTAWI, bl);
    }

    public ArrayList<PSDERTAWI> selectByPSDERTAW(PSDERTAWBase pSDERTAWBase) throws Exception {
        return this.selectByPSDERTAW(pSDERTAWBase, "", -1);
    }

    public ArrayList<PSDERTAWI> selectByPSDERTAW(PSDERTAWBase pSDERTAWBase, String string) throws Exception {
        return this.selectByPSDERTAW(pSDERTAWBase, string, -1);
    }

    public ArrayList<PSDERTAWI> selectByPSDERTAW(PSDERTAWBase pSDERTAWBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERTAWID", (Object)pSDERTAWBase.getPSDERTAWId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERTAWCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERTAWCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDERTAWI> selectTempByPSDERTAW(PSDERTAWBase pSDERTAWBase) throws Exception {
        return this.selectTempByPSDERTAW(pSDERTAWBase, "");
    }

    public ArrayList<PSDERTAWI> selectTempByPSDERTAW(PSDERTAWBase pSDERTAWBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERTAWID", (Object)pSDERTAWBase.getPSDERTAWId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDERTAWCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDERTAWCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
    }

    public void resetPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
        ArrayList<PSDERTAWI> arrayList = this.selectByPSDERTAW(pSDERTAW);
        for (PSDERTAWI pSDERTAWI : arrayList) {
            PSDERTAWI pSDERTAWI2 = (PSDERTAWI)this.getDEModel().createEntity();
            pSDERTAWI2.setPSDERTAWIId(pSDERTAWI.getPSDERTAWIId());
            pSDERTAWI2.setPSDERTAWId(null);
            this.update(pSDERTAWI2);
        }
    }

    public void resetTempPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
        ArrayList<PSDERTAWI> arrayList = this.selectTempByPSDERTAW(pSDERTAW);
        for (PSDERTAWI pSDERTAWI : arrayList) {
            PSDERTAWI pSDERTAWI2 = (PSDERTAWI)this.getDEModel().createEntity();
            pSDERTAWI2.setPSDERTAWIId(pSDERTAWI.getPSDERTAWIId());
            pSDERTAWI2.setPSDERTAWId(null);
            this.updateTemp((IEntity)pSDERTAWI2);
        }
    }

    public void removeByPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
        final PSDERTAW pSDERTAW2 = pSDERTAW;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERTAWIServiceBase.this.onBeforeRemoveByPSDERTAW(pSDERTAW2);
                PSDERTAWIServiceBase.this.internalRemoveByPSDERTAW(pSDERTAW2);
                PSDERTAWIServiceBase.this.onAfterRemoveByPSDERTAW(pSDERTAW2);
            }
        });
    }

    protected void onBeforeRemoveByPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
    }

    protected void internalRemoveByPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
        ArrayList<PSDERTAWI> arrayList = this.selectByPSDERTAW(pSDERTAW);
        this.onBeforeRemoveByPSDERTAW(pSDERTAW, arrayList);
        for (PSDERTAWI pSDERTAWI : arrayList) {
            this.remove((IEntity)pSDERTAWI);
        }
        this.onAfterRemoveByPSDERTAW(pSDERTAW, arrayList);
    }

    protected void onAfterRemoveByPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
    }

    protected void onBeforeRemoveByPSDERTAW(PSDERTAW pSDERTAW, ArrayList<PSDERTAWI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDERTAW(PSDERTAW pSDERTAW, ArrayList<PSDERTAWI> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDERTAWI pSDERTAWI) throws Exception {
        super.onBeforeRemove(pSDERTAWI);
    }

    public void removeTempByPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
        final PSDERTAW pSDERTAW2 = pSDERTAW;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERTAWIServiceBase.this.onBeforeRemoveTempByPSDERTAW(pSDERTAW2);
                PSDERTAWIServiceBase.this.internalRemoveTempByPSDERTAW(pSDERTAW2);
                PSDERTAWIServiceBase.this.onAfterRemoveTempByPSDERTAW(pSDERTAW2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
    }

    protected void internalRemoveTempByPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
        ArrayList<PSDERTAWI> arrayList = this.selectTempByPSDERTAW(pSDERTAW);
        this.onBeforeRemoveTempByPSDERTAW(pSDERTAW, arrayList);
        for (PSDERTAWI pSDERTAWI : arrayList) {
            this.removeTemp((IEntity)pSDERTAWI);
        }
        this.onAfterRemoveTempByPSDERTAW(pSDERTAW, arrayList);
    }

    protected void onAfterRemoveTempByPSDERTAW(PSDERTAW pSDERTAW) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDERTAW(PSDERTAW pSDERTAW, ArrayList<PSDERTAWI> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDERTAW(PSDERTAW pSDERTAW, ArrayList<PSDERTAWI> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDERTAWI pSDERTAWI, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDERTAWI, cloneSession);
        if (pSDERTAWI.getPSDERTAWId() != null && (iEntity = cloneSession.getEntity("PSDERTAW", (Object)pSDERTAWI.getPSDERTAWId())) != null) {
            this.onFillParentInfo_PSDERTAW(pSDERTAWI, (PSDERTAW)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDERTAWI pSDERTAWI, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDERTAWI, bl);
    }

    protected void onCheckEntity(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bl, pSDERTAWI, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemLabel(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERTAWId(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERTAWIId(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERTAWIName(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReplaceValue(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Url(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value(bl, pSDERTAWI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDERTAWI, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isContentDirty() : !pSDERTAWI.isContentDirty()) {
            return null;
        }
        String string = pSDERTAWI.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSDERTAWI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isDefaultFlagDirty() : !pSDERTAWI.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDERTAWI.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSDERTAWI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemLabel(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isItemLabelDirty() : !pSDERTAWI.isItemLabelDirty()) {
            return null;
        }
        String string = pSDERTAWI.getItemLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemLabel_Default((IEntity)pSDERTAWI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isMemoDirty() : !pSDERTAWI.isMemoDirty()) {
            return null;
        }
        String string = pSDERTAWI.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDERTAWI, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isOrderValueDirty() : !pSDERTAWI.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDERTAWI.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDERTAWI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERTAWId(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isPSDERTAWIdDirty() : !pSDERTAWI.isPSDERTAWIdDirty()) {
            return null;
        }
        String string = pSDERTAWI.getPSDERTAWId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERTAWId_Default((IEntity)pSDERTAWI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERTAWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERTAWIId(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isPSDERTAWIIdDirty() && !bl2 : !pSDERTAWI.isPSDERTAWIIdDirty()) {
            return null;
        }
        String string = pSDERTAWI.getPSDERTAWIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERTAWIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERTAWIId_Default((IEntity)pSDERTAWI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERTAWIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERTAWIName(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isPSDERTAWINameDirty() && !bl2 : !pSDERTAWI.isPSDERTAWINameDirty()) {
            return null;
        }
        String string = pSDERTAWI.getPSDERTAWIName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERTAWINAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERTAWIName_Default((IEntity)pSDERTAWI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERTAWINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDERTAWID";
                String string4 = this.checkFieldDupRule(this.getPSDERTAWIDEModel(), "PSDERTAWINAME", string3, pSDERTAWI, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDERTAWINAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReplaceValue(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isReplaceValueDirty() : !pSDERTAWI.isReplaceValueDirty()) {
            return null;
        }
        Integer n = pSDERTAWI.getReplaceValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ReplaceValue_Default((IEntity)pSDERTAWI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPLACEVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Url(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isUrlDirty() : !pSDERTAWI.isUrlDirty()) {
            return null;
        }
        String string = pSDERTAWI.getUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Url_Default((IEntity)pSDERTAWI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("URL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isUserTagDirty() : !pSDERTAWI.isUserTagDirty()) {
            return null;
        }
        String string = pSDERTAWI.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDERTAWI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isUserTag2Dirty() : !pSDERTAWI.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDERTAWI.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDERTAWI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isValidFlagDirty() && !bl2 : !pSDERTAWI.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDERTAWI.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDERTAWI, bl2, bl3);
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

    protected EntityFieldError onCheckField_Value(boolean bl, PSDERTAWI pSDERTAWI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAWI.isValueDirty() : !pSDERTAWI.isValueDirty()) {
            return null;
        }
        String string = pSDERTAWI.getValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Value_Default((IEntity)pSDERTAWI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDERTAWI pSDERTAWI, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDERTAWI, bl);
    }

    protected void onSyncIndexEntities(PSDERTAWI pSDERTAWI, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDERTAWI, bl);
    }

    public Object getDataContextValue(PSDERTAWI pSDERTAWI, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDERTAWI, string, iDataContextParam)) != null) {
            return object;
        }
        PSDERTAW pSDERTAW = pSDERTAWI.getPSDERTAW();
        if (pSDERTAW != null && pSDERTAW.contains(string)) {
            return pSDERTAW.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDERTAWI pSDERTAWI, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDERTAWI, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERTAWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERTAWId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERTAWIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERTAWIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERTAWINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERTAWIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERTAWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERTAWName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPLACEVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReplaceValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"URL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Url_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Value_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMLABEL", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_PSDERTAWId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERTAWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERTAWIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERTAWIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERTAWIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERTAWINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERTAWName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERTAWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReplaceValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_Url_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("URL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Value_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDERTAWI pSDERTAWI) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDERTAWI)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDERTAWI pSDERTAWI) throws Exception {
        super.onUpdateParent((IEntity)pSDERTAWI);
    }

    @Override
    protected void exportCurXmlModel(PSDERTAWI pSDERTAWI, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDERTAWI");
        if (!bl) {
            pSDERTAWI.setCreateDate(null);
            pSDERTAWI.setCreateMan(null);
            pSDERTAWI.setPSDERTAWIId(null);
            pSDERTAWI.setPSDERTAWName(null);
            pSDERTAWI.setUpdateDate(null);
            pSDERTAWI.setUpdateMan(null);
            pSDERTAWI.setPSDERTAWId(null);
            pSDERTAWI.setPSDERTAWName(null);
            super.exportCurXmlModel(pSDERTAWI, xmlNode, bl);
        }
    }
}

