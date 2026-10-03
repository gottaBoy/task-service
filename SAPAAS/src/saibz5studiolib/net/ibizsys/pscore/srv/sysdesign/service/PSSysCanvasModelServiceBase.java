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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysCanvasModelDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCanvasModelDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCanvas;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCanvasBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCanvasModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCanvasModelServiceBase
extends PSCoreSysServiceBase<PSSysCanvasModel> {
    private static final Log log = LogFactory.getLog(PSSysCanvasModelServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysCanvasModelDEModel pSSysCanvasModelDEModel;
    private PSSysCanvasModelDAO pSSysCanvasModelDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasModelService";
    }

    public PSSysCanvasModelDEModel getPSSysCanvasModelDEModel() {
        if (this.pSSysCanvasModelDEModel == null) {
            try {
                this.pSSysCanvasModelDEModel = (PSSysCanvasModelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCanvasModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCanvasModelDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysCanvasModelDEModel();
    }

    public PSSysCanvasModelDAO getPSSysCanvasModelDAO() {
        if (this.pSSysCanvasModelDAO == null) {
            try {
                this.pSSysCanvasModelDAO = (PSSysCanvasModelDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysCanvasModelDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCanvasModelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysCanvasModelDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
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

    protected void onFillParentInfo(PSSysCanvasModel pSSysCanvasModel, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCANVASMODEL_PSSYSCANVAS_PSSYSCANVASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasService", (SessionFactory)this.getSessionFactory());
            PSSysCanvas pSSysCanvas = (PSSysCanvas)iService.getDEModel().createEntity();
            pSSysCanvas.set("PSSYSCANVASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCanvas);
            } else {
                iService.get(pSSysCanvas);
            }
            this.onFillParentInfo_PSSysCanvas(pSSysCanvasModel, pSSysCanvas);
            return;
        }
        super.onFillParentInfo(pSSysCanvasModel, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysCanvas(PSSysCanvasModel pSSysCanvasModel, PSSysCanvas pSSysCanvas) throws Exception {
        pSSysCanvasModel.setPSSysCanvasId(pSSysCanvas.getPSSysCanvasId());
        pSSysCanvasModel.setPSSysCanvasName(pSSysCanvas.getPSSysCanvasName());
    }

    protected void onFillEntityFullInfo(PSSysCanvasModel pSSysCanvasModel, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysCanvasModel, bl);
        this.onFillEntityFullInfo_PSSysCanvas(pSSysCanvasModel, bl);
    }

    protected void onFillEntityFullInfo_PSSysCanvas(PSSysCanvasModel pSSysCanvasModel, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysCanvasModel pSSysCanvasModel, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysCanvasModel, bl);
    }

    public ArrayList<PSSysCanvasModel> selectByPSSysCanvas(PSSysCanvasBase pSSysCanvasBase) throws Exception {
        return this.selectByPSSysCanvas(pSSysCanvasBase, "", -1);
    }

    public ArrayList<PSSysCanvasModel> selectByPSSysCanvas(PSSysCanvasBase pSSysCanvasBase, String string) throws Exception {
        return this.selectByPSSysCanvas(pSSysCanvasBase, string, -1);
    }

    public ArrayList<PSSysCanvasModel> selectByPSSysCanvas(PSSysCanvasBase pSSysCanvasBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCANVASID", (Object)pSSysCanvasBase.getPSSysCanvasId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCanvasCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCanvasCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCanvasModel> selectTempByPSSysCanvas(PSSysCanvasBase pSSysCanvasBase) throws Exception {
        return this.selectTempByPSSysCanvas(pSSysCanvasBase, "");
    }

    public ArrayList<PSSysCanvasModel> selectTempByPSSysCanvas(PSSysCanvasBase pSSysCanvasBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCANVASID", (Object)pSSysCanvasBase.getPSSysCanvasId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysCanvasCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysCanvasCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
    }

    public void resetPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
        ArrayList<PSSysCanvasModel> arrayList = this.selectByPSSysCanvas(pSSysCanvas);
        for (PSSysCanvasModel pSSysCanvasModel : arrayList) {
            PSSysCanvasModel pSSysCanvasModel2 = (PSSysCanvasModel)this.getDEModel().createEntity();
            pSSysCanvasModel2.setPSSysCanvasModelId(pSSysCanvasModel.getPSSysCanvasModelId());
            pSSysCanvasModel2.setPSSysCanvasId(null);
            this.update(pSSysCanvasModel2);
        }
    }

    public void resetTempPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
        ArrayList<PSSysCanvasModel> arrayList = this.selectTempByPSSysCanvas(pSSysCanvas);
        for (PSSysCanvasModel pSSysCanvasModel : arrayList) {
            PSSysCanvasModel pSSysCanvasModel2 = (PSSysCanvasModel)this.getDEModel().createEntity();
            pSSysCanvasModel2.setPSSysCanvasModelId(pSSysCanvasModel.getPSSysCanvasModelId());
            pSSysCanvasModel2.setPSSysCanvasId(null);
            this.updateTemp(pSSysCanvasModel2);
        }
    }

    public void removeByPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
        final PSSysCanvas pSSysCanvas2 = pSSysCanvas;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCanvasModelServiceBase.this.onBeforeRemoveByPSSysCanvas(pSSysCanvas2);
                PSSysCanvasModelServiceBase.this.internalRemoveByPSSysCanvas(pSSysCanvas2);
                PSSysCanvasModelServiceBase.this.onAfterRemoveByPSSysCanvas(pSSysCanvas2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
    }

    protected void internalRemoveByPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
        ArrayList<PSSysCanvasModel> arrayList = this.selectByPSSysCanvas(pSSysCanvas);
        this.onBeforeRemoveByPSSysCanvas(pSSysCanvas, arrayList);
        for (PSSysCanvasModel pSSysCanvasModel : arrayList) {
            this.remove(pSSysCanvasModel);
        }
        this.onAfterRemoveByPSSysCanvas(pSSysCanvas, arrayList);
    }

    protected void onAfterRemoveByPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCanvas(PSSysCanvas pSSysCanvas, ArrayList<PSSysCanvasModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCanvas(PSSysCanvas pSSysCanvas, ArrayList<PSSysCanvasModel> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysCanvasModel pSSysCanvasModel) throws Exception {
        super.onBeforeRemove(pSSysCanvasModel);
    }

    public void removeTempByPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
        final PSSysCanvas pSSysCanvas2 = pSSysCanvas;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCanvasModelServiceBase.this.onBeforeRemoveTempByPSSysCanvas(pSSysCanvas2);
                PSSysCanvasModelServiceBase.this.internalRemoveTempByPSSysCanvas(pSSysCanvas2);
                PSSysCanvasModelServiceBase.this.onAfterRemoveTempByPSSysCanvas(pSSysCanvas2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
    }

    protected void internalRemoveTempByPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
        ArrayList<PSSysCanvasModel> arrayList = this.selectTempByPSSysCanvas(pSSysCanvas);
        this.onBeforeRemoveTempByPSSysCanvas(pSSysCanvas, arrayList);
        for (PSSysCanvasModel pSSysCanvasModel : arrayList) {
            this.removeTemp(pSSysCanvasModel);
        }
        this.onAfterRemoveTempByPSSysCanvas(pSSysCanvas, arrayList);
    }

    protected void onAfterRemoveTempByPSSysCanvas(PSSysCanvas pSSysCanvas) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysCanvas(PSSysCanvas pSSysCanvas, ArrayList<PSSysCanvasModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysCanvas(PSSysCanvas pSSysCanvas, ArrayList<PSSysCanvasModel> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysCanvasModel pSSysCanvasModel, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysCanvasModel, cloneSession);
        if (pSSysCanvasModel.getPSSysCanvasId() != null && (iEntity = cloneSession.getEntity("PSSYSCANVAS", (Object)pSSysCanvasModel.getPSSysCanvasId())) != null) {
            this.onFillParentInfo_PSSysCanvas(pSSysCanvasModel, (PSSysCanvas)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysCanvasModel pSSysCanvasModel, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysCanvasModel, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysCanvasModel, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelType(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCanvasId(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCanvasModelId(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCanvasModelName(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SymbolName(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysCanvasModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysCanvasModel, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isMemoDirty() : !pSSysCanvasModel.isMemoDirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysCanvasModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isPSModelIdDirty() && !bl2 : !pSSysCanvasModel.isPSModelIdDirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getPSModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default(pSSysCanvasModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isPSModelNameDirty() : !pSSysCanvasModel.isPSModelNameDirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default(pSSysCanvasModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelType(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isPSModelTypeDirty() && !bl2 : !pSSysCanvasModel.isPSModelTypeDirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getPSModelType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelType_Default(pSSysCanvasModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCanvasId(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isPSSysCanvasIdDirty() : !pSSysCanvasModel.isPSSysCanvasIdDirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getPSSysCanvasId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCanvasId_Default(pSSysCanvasModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCANVASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCanvasModelId(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isPSSysCanvasModelIdDirty() && !bl2 : !pSSysCanvasModel.isPSSysCanvasModelIdDirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getPSSysCanvasModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCANVASMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCanvasModelId_Default(pSSysCanvasModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCANVASMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCanvasModelName(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isPSSysCanvasModelNameDirty() && !bl2 : !pSSysCanvasModel.isPSSysCanvasModelNameDirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getPSSysCanvasModelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCANVASMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCanvasModelName_Default(pSSysCanvasModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCANVASMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SymbolName(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isSymbolNameDirty() : !pSSysCanvasModel.isSymbolNameDirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getSymbolName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SymbolName_Default(pSSysCanvasModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYMBOLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isUserCatDirty() : !pSSysCanvasModel.isUserCatDirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysCanvasModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isUserTagDirty() : !pSSysCanvasModel.isUserTagDirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysCanvasModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isUserTag2Dirty() : !pSSysCanvasModel.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysCanvasModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isUserTag3Dirty() : !pSSysCanvasModel.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysCanvasModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysCanvasModel pSSysCanvasModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvasModel.isUserTag4Dirty() : !pSSysCanvasModel.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysCanvasModel.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysCanvasModel, bl2, bl3);
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

    protected void onSyncEntity(PSSysCanvasModel pSSysCanvasModel, boolean bl) throws Exception {
        super.onSyncEntity(pSSysCanvasModel, bl);
    }

    protected void onSyncIndexEntities(PSSysCanvasModel pSSysCanvasModel, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysCanvasModel, bl);
    }

    public Object getDataContextValue(PSSysCanvasModel pSSysCanvasModel, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysCanvasModel, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysCanvas pSSysCanvas = pSSysCanvasModel.getPSSysCanvas();
        if (pSSysCanvas != null && pSSysCanvas.contains(string)) {
            return pSSysCanvas.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysCanvasModel pSSysCanvasModel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysCanvasModel, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCANVASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCanvasId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCANVASMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCanvasModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCANVASMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCanvasModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCANVASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCanvasName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYMBOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SymbolName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSModelType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELTYPE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCanvasId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCANVASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCanvasModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCANVASMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCanvasModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCANVASMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCanvasName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCANVASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SymbolName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYMBOLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysCanvasModel pSSysCanvasModel) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysCanvasModel)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysCanvasModel pSSysCanvasModel) throws Exception {
        super.onUpdateParent(pSSysCanvasModel);
    }

    @Override
    protected void exportCurXmlModel(PSSysCanvasModel pSSysCanvasModel, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSCANVASMODEL");
        if (!bl) {
            pSSysCanvasModel.setCreateDate(null);
            pSSysCanvasModel.setCreateMan(null);
            pSSysCanvasModel.setPSSysCanvasModelId(null);
            pSSysCanvasModel.setUpdateDate(null);
            pSSysCanvasModel.setUpdateMan(null);
            pSSysCanvasModel.setPSSysCanvasId(null);
            pSSysCanvasModel.setPSSysCanvasName(null);
            super.exportCurXmlModel(pSSysCanvasModel, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysCanvasModel pSSysCanvasModel, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysCanvasModel, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCANVASID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSCANVAS#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCANVASID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCANVASMODEL_PSSYSCANVAS_PSSYSCANVASID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCANVASID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCANVASNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSCANVAS", (boolean)true) == 0) {
            iEntity.set("PSSYSCANVASID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSCANVASID"};
    }

    @Override
    public String getModelV2Tag(PSSysCanvasModel pSSysCanvasModel) {
        return super.getModelV2Tag(pSSysCanvasModel);
    }

    @Override
    public boolean setModelV2Tag(PSSysCanvasModel pSSysCanvasModel, String string) {
        return super.setModelV2Tag(pSSysCanvasModel, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSCANVASID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysCanvasModel pSSysCanvasModel, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysCanvasModel.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysCanvasModel, true);
        return super.getModelV2Entity(pSSysCanvasModel, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysCanvasModel pSSysCanvasModel, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysCanvasModel, objectNode, string, string2, n);
    }
}

