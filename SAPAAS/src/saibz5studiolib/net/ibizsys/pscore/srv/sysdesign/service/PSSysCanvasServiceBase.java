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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysCanvasDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCanvasDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCanvas;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCanvasModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasModelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCanvasServiceBase
extends PSCoreSysServiceBase<PSSysCanvas> {
    private static final Log log = LogFactory.getLog(PSSysCanvasServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysCanvasDEModel pSSysCanvasDEModel;
    private PSSysCanvasDAO pSSysCanvasDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasService";
    }

    public PSSysCanvasDEModel getPSSysCanvasDEModel() {
        if (this.pSSysCanvasDEModel == null) {
            try {
                this.pSSysCanvasDEModel = (PSSysCanvasDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCanvasDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCanvasDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysCanvasDEModel();
    }

    public PSSysCanvasDAO getPSSysCanvasDAO() {
        if (this.pSSysCanvasDAO == null) {
            try {
                this.pSSysCanvasDAO = (PSSysCanvasDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysCanvasDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCanvasDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysCanvasDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, true);
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

    protected void onFillParentInfo(PSSysCanvas pSSysCanvas, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCANVAS_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysCanvas, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCANVAS_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysCanvas, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysCanvas, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysCanvas pSSysCanvas, PSModule pSModule) throws Exception {
        pSSysCanvas.setPSModuleId(pSModule.getPSModuleId());
        pSSysCanvas.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSystem(PSSysCanvas pSSysCanvas, PSSystem pSSystem) throws Exception {
        pSSysCanvas.setPSSystemId(pSSystem.getPSSystemId());
        pSSysCanvas.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysCanvas pSSysCanvas, boolean bl) throws Exception {
        if (bl) {
            if (pSSysCanvas.getCanvasType() == null) {
                pSSysCanvas.setCanvasType((String)this.getDefaultValue(this.getWebContext(), "", "COMMON", 25));
            }
            if (pSSysCanvas.getCodeName() == null) {
                pSSysCanvas.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Canvas", 25));
            }
            if (pSSysCanvas.getPSSysCanvasName() == null) {
                pSSysCanvas.setPSSysCanvasName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u753b\u5e03", 25));
            }
        }
        super.onFillEntityFullInfo(pSSysCanvas, bl);
        this.onFillEntityFullInfo_PSModule(pSSysCanvas, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysCanvas, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysCanvas pSSysCanvas, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysCanvas pSSysCanvas, boolean bl) throws Exception {
        if (pSSysCanvas.isPSSystemIdDirty()) {
            if (pSSysCanvas.getPSSystemId() != null) {
                if (pSSysCanvas.getPSSystemId() == null || pSSysCanvas.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysCanvas.getPSSystem();
                    pSSysCanvas.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysCanvas.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysCanvas pSSysCanvas, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysCanvas, bl);
    }

    public ArrayList<PSSysCanvas> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysCanvas> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysCanvas> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCanvas> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysCanvas> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysCanvas> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysCanvas> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCANVAS_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSCANVAS", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysCanvas> arrayList = this.selectByPSModule(pSModule);
        for (PSSysCanvas pSSysCanvas : arrayList) {
            PSSysCanvas pSSysCanvas2 = (PSSysCanvas)this.getDEModel().createEntity();
            pSSysCanvas2.setPSSysCanvasId(pSSysCanvas.getPSSysCanvasId());
            pSSysCanvas2.setPSModuleId(null);
            this.update(pSSysCanvas2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCanvasServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysCanvasServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysCanvasServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysCanvas> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysCanvas pSSysCanvas : arrayList) {
            this.remove(pSSysCanvas);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysCanvas> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysCanvas> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCanvas> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysCanvas pSSysCanvas : arrayList) {
            PSSysCanvas pSSysCanvas2 = (PSSysCanvas)this.getDEModel().createEntity();
            pSSysCanvas2.setPSSysCanvasId(pSSysCanvas.getPSSysCanvasId());
            pSSysCanvas2.setPSSystemId(null);
            this.update(pSSysCanvas2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCanvasServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysCanvasServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysCanvasServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCanvas> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysCanvas pSSysCanvas : arrayList) {
            this.remove(pSSysCanvas);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysCanvas> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysCanvas> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysCanvas pSSysCanvas) throws Exception {
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        pSSysCanvasModelService.testRemoveByPSSysCanvas(pSSysCanvas);
        pSSysCanvasModelService.removeByPSSysCanvas(pSSysCanvas);
        super.onBeforeRemove(pSSysCanvas);
    }

    protected void onBeforeRemoveTemp(PSSysCanvas pSSysCanvas) throws Exception {
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        pSSysCanvasModelService.removeTempByPSSysCanvas(pSSysCanvas);
        super.onBeforeRemoveTemp(pSSysCanvas);
    }

    protected void getRelatedDataTempMajor(PSSysCanvas pSSysCanvas) throws Exception {
        this.getRelatedDataTempMajor_PSSysCanvasModel(pSSysCanvas);
        super.getRelatedDataTempMajor(pSSysCanvas);
    }

    protected void getRelatedDataTempMajor_PSSysCanvasModel(PSSysCanvas pSSysCanvas) throws Exception {
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCanvasModel> arrayList = null;
        String string = pSSysCanvas.getPSSysCanvasId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysCanvasModelService.selectByPSSysCanvas(pSSysCanvas) : pSSysCanvasModelService.selectTempByPSSysCanvas(pSSysCanvas);
        for (PSSysCanvasModel pSSysCanvasModel : arrayList) {
            pSSysCanvasModelService.getTempMajor(pSSysCanvasModel);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysCanvas pSSysCanvas, PSSysCanvas pSSysCanvas2) throws Exception {
        ArrayList<PSSysCanvasModel> arrayList = this.updateRelatedDataTempMajor_removePSSysCanvasModel(pSSysCanvas, pSSysCanvas2);
        this.updateRelatedDataTempMajor_updatePSSysCanvasModel(pSSysCanvas, pSSysCanvas2, arrayList);
        super.updateRelatedDataTempMajor(pSSysCanvas, pSSysCanvas2);
    }

    protected ArrayList<PSSysCanvasModel> updateRelatedDataTempMajor_removePSSysCanvasModel(PSSysCanvas pSSysCanvas, PSSysCanvas pSSysCanvas2) throws Exception {
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCanvasModel> arrayList = pSSysCanvasModelService.selectTempByPSSysCanvas(pSSysCanvas);
        ArrayList<PSSysCanvasModel> arrayList2 = pSSysCanvasModelService.selectByPSSysCanvas(pSSysCanvas2);
        HashMap<String, PSSysCanvasModel> hashMap = new HashMap<String, PSSysCanvasModel>();
        for (PSSysCanvasModel pSSysCanvasModel : arrayList2) {
            hashMap.put(pSSysCanvasModel.getPSSysCanvasModelId(), pSSysCanvasModel);
        }
        for (PSSysCanvasModel pSSysCanvasModel : arrayList) {
            Object object = pSSysCanvasModel.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysCanvasModel pSSysCanvasModel : hashMap.values()) {
            pSSysCanvasModelService.remove(pSSysCanvasModel);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysCanvasModel(PSSysCanvas pSSysCanvas, PSSysCanvas pSSysCanvas2, ArrayList<PSSysCanvasModel> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysCanvasModel pSSysCanvasModel : arrayList) {
            pSSysCanvasModelService.updateTempMajor(pSSysCanvasModel);
        }
    }

    protected void replaceParentInfo(PSSysCanvas pSSysCanvas, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysCanvas, cloneSession);
        if (pSSysCanvas.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysCanvas.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysCanvas, (PSModule)iEntity);
        }
        if (pSSysCanvas.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysCanvas.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysCanvas, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysCanvas pSSysCanvas, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysCanvas, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CanvasModel(bl, pSSysCanvas, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CanvasTag(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CanvasTag2(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CanvasTag3(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CanvasTag4(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CanvasType(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCanvasId(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCanvasName(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysCanvas, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysCanvas, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CanvasModel(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isCanvasModelDirty() : !pSSysCanvas.isCanvasModelDirty()) {
            return null;
        }
        String string = pSSysCanvas.getCanvasModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CanvasModel_Default(pSSysCanvas, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANVASMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CanvasTag(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isCanvasTagDirty() : !pSSysCanvas.isCanvasTagDirty()) {
            return null;
        }
        String string = pSSysCanvas.getCanvasTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CanvasTag_Default(pSSysCanvas, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANVASTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CanvasTag2(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isCanvasTag2Dirty() : !pSSysCanvas.isCanvasTag2Dirty()) {
            return null;
        }
        String string = pSSysCanvas.getCanvasTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CanvasTag2_Default(pSSysCanvas, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANVASTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CanvasTag3(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isCanvasTag3Dirty() : !pSSysCanvas.isCanvasTag3Dirty()) {
            return null;
        }
        String string = pSSysCanvas.getCanvasTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CanvasTag3_Default(pSSysCanvas, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANVASTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CanvasTag4(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isCanvasTag4Dirty() : !pSSysCanvas.isCanvasTag4Dirty()) {
            return null;
        }
        String string = pSSysCanvas.getCanvasTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CanvasTag4_Default(pSSysCanvas, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANVASTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CanvasType(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isCanvasTypeDirty() && !bl2 : !pSSysCanvas.isCanvasTypeDirty()) {
            return null;
        }
        String string = pSSysCanvas.getCanvasType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANVASTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CanvasType_Default(pSSysCanvas, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANVASTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isCodeNameDirty() && !bl2 : !pSSysCanvas.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysCanvas.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysCanvas, bl2, bl3);
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysCanvasDEModel(), "CODENAME", string3, pSSysCanvas, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isMemoDirty() : !pSSysCanvas.isMemoDirty()) {
            return null;
        }
        String string = pSSysCanvas.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysCanvas, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isPSModuleIdDirty() : !pSSysCanvas.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysCanvas.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysCanvas, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCanvasId(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isPSSysCanvasIdDirty() && !bl2 : !pSSysCanvas.isPSSysCanvasIdDirty()) {
            return null;
        }
        String string = pSSysCanvas.getPSSysCanvasId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCANVASID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCanvasId_Default(pSSysCanvas, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCanvasName(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isPSSysCanvasNameDirty() && !bl2 : !pSSysCanvas.isPSSysCanvasNameDirty()) {
            return null;
        }
        String string = pSSysCanvas.getPSSysCanvasName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCANVASNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCanvasName_Default(pSSysCanvas, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCANVASNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysCanvasDEModel(), "PSSYSCANVASNAME", string3, pSSysCanvas, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSCANVASNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isPSSystemIdDirty() : !pSSysCanvas.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysCanvas.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysCanvas, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isPSSystemNameDirty() : !pSSysCanvas.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysCanvas.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysCanvas, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isUserCatDirty() : !pSSysCanvas.isUserCatDirty()) {
            return null;
        }
        String string = pSSysCanvas.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysCanvas, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isUserTagDirty() : !pSSysCanvas.isUserTagDirty()) {
            return null;
        }
        String string = pSSysCanvas.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysCanvas, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isUserTag2Dirty() : !pSSysCanvas.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysCanvas.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysCanvas, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isUserTag3Dirty() : !pSSysCanvas.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysCanvas.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysCanvas, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysCanvas pSSysCanvas, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCanvas.isUserTag4Dirty() : !pSSysCanvas.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysCanvas.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysCanvas, bl2, bl3);
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

    protected void onSyncEntity(PSSysCanvas pSSysCanvas, boolean bl) throws Exception {
        super.onSyncEntity(pSSysCanvas, bl);
    }

    protected void onSyncIndexEntities(PSSysCanvas pSSysCanvas, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysCanvas, bl);
    }

    public Object getDataContextValue(PSSysCanvas pSSysCanvas, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysCanvas, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysCanvas pSSysCanvas, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysCanvas, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CANVASMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CanvasModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CANVASTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CanvasTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CANVASTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CanvasTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CANVASTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CanvasTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CANVASTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CanvasTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CANVASTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CanvasType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCANVASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCanvasId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCANVASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCanvasName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CanvasModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CANVASMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CanvasTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CANVASTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CanvasTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CANVASTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CanvasTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CANVASTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CanvasTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CANVASTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CanvasType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CANVASTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysCanvas pSSysCanvas) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysCanvas)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysCanvas pSSysCanvas) throws Exception {
        super.onUpdateParent(pSSysCanvas);
    }

    @Override
    protected void exportCurXmlModel(PSSysCanvas pSSysCanvas, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSCANVAS");
        if (!bl) {
            pSSysCanvas.setCreateDate(null);
            pSSysCanvas.setCreateMan(null);
            pSSysCanvas.setPSSysCanvasId(null);
            pSSysCanvas.setUpdateDate(null);
            pSSysCanvas.setUpdateMan(null);
            super.exportCurXmlModel(pSSysCanvas, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysCanvas pSSysCanvas, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysCanvasModel(pSSysCanvas, xmlNode);
        super.onExportRelatedXmlModel(pSSysCanvas, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysCanvasModel(PSSysCanvas pSSysCanvas, XmlNode xmlNode) throws Exception {
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCanvasModel> arrayList = null;
        String string = pSSysCanvas.getPSSysCanvasId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysCanvasModelService.selectByPSSysCanvas(pSSysCanvas) : pSSysCanvasModelService.selectTempByPSSysCanvas(pSSysCanvas);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSCANVASMODELS");
            xmlNode.addNode(xmlNode2);
            for (PSSysCanvasModel pSSysCanvasModel : arrayList) {
                pSSysCanvasModelService.exportXmlModel(pSSysCanvasModel, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysCanvas pSSysCanvas, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSCANVASMODELS");
        this.importRelatedXmlModel_PSSysCanvasModel(pSSysCanvas, xmlNode2);
        super.onImportRelatedXmlModel(pSSysCanvas, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysCanvasModel(PSSysCanvas pSSysCanvas, XmlNode xmlNode) throws Exception {
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysCanvas.getPSSysCanvasId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysCanvasModelService.removeByPSSysCanvas(pSSysCanvas);
        } else {
            pSSysCanvasModelService.removeTempByPSSysCanvas(pSSysCanvas);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysCanvasModel pSSysCanvasModel = new PSSysCanvasModel();
                pSSysCanvasModelService.fillParentInfo(pSSysCanvasModel, "DER1N", "DER1N_PSSYSCANVASMODEL_PSSYSCANVAS_PSSYSCANVASID", pSSysCanvas.getPSSysCanvasId());
                pSSysCanvasModelService.importXmlModel(pSSysCanvasModel, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysCanvas pSSysCanvas, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysCanvas, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCANVAS_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCANVAS_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSMODULE", (boolean)true) == 0) {
            iEntity.set("PSMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysCanvas pSSysCanvas) {
        if (!StringHelper.isNullOrEmpty((String)pSSysCanvas.getCodeName())) {
            return pSSysCanvas.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCanvas.getPSSysCanvasName())) {
            return pSSysCanvas.getPSSysCanvasName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCanvas.getCodeName())) {
            return pSSysCanvas.getCodeName();
        }
        return super.getModelV2Tag(pSSysCanvas);
    }

    @Override
    public boolean setModelV2Tag(PSSysCanvas pSSysCanvas, String string) {
        pSSysCanvas.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSCANVASNAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysCanvas pSSysCanvas, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysCanvas.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysCanvas, true);
        pSSysCanvas.set("CODENAME", string);
        if (this.select(pSSysCanvas, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysCanvas, true);
        return super.getModelV2Entity(pSSysCanvas, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysCanvas pSSysCanvas, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysCanvas, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSYSCANVASMODEL_PSSYSCANVAS_PSSYSCANVASID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysCanvas pSSysCanvas, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysCanvas, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysCanvas pSSysCanvas, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSCANVASMODEL_PSSYSCANVAS_PSSYSCANVASID")) {
            PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> modelNodes = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSCANVAS#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSCANVASMODEL", (Object)pSSysCanvas.getPSSysCanvasId()));
                if (file.exists()) {
                    modelNodes = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        modelNodes.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                modelNodes = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSCANVAS#%1$s", (Object)pSSysCanvas.getPSSysCanvasId());
                for (PSSysCanvasModel model : pSSysCanvasModelService.selectByPSSysCanvas(pSSysCanvas)) {
                    String modelScope = pSSysCanvasModelService.getModelV2ResScope(model);
                    if (StringHelper.compare(scope, modelScope, false) != 0) continue;
                    modelNodes.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (modelNodes != null && modelNodes.size() > 0) {
                ArrayNode childNodes = objectNode.putArray(pSSysCanvasModelService.getModelV2Name(false).toLowerCase());
                Collections.sort(modelNodes, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssyscanvasmodelname")) {
                            string = objectNode.get("pssyscanvasmodelname").asText();
                        }
                        if (objectNode2.has("pssyscanvasmodelname")) {
                            string2 = objectNode2.get("pssyscanvasmodelname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode modelNode : modelNodes) {
                    PSSysCanvasModel model = new PSSysCanvasModel();
                    PSModelV2Helper.fromJSONObject(model, modelNode, false);
                    childNodes.add(pSSysCanvasModelService.exportModelV2(model, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysCanvas, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysCanvas pSSysCanvas) throws Exception {
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCanvasModel> arrayList = pSSysCanvasModelService.selectByPSSysCanvas(pSSysCanvas);
        String string = StringHelper.format((String)"PSSYSCANVAS#%1$s", (Object)pSSysCanvas.getPSSysCanvasId());
        for (PSSysCanvasModel pSSysCanvasModel : arrayList) {
            String string2 = pSSysCanvasModelService.getModelV2ResScope(pSSysCanvasModel);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSysCanvasModelService.emptyModelV2(pSSysCanvasModel);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysCanvas.getPSSysCanvasId());
        pSSysCanvasModelService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSysCanvasModelService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSCANVASMODEL WHERE PSSYSCANVASID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysCanvas);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysCanvasModelService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysCanvas pSSysCanvas, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysCanvasModel pSSysCanvasModel = new PSSysCanvasModel();
        pSSysCanvasModel.set("PSSYSCANVASID", pSSysCanvas.getPSSysCanvasId());
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysCanvasModelService.getModelV2Entity(pSSysCanvasModel, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysCanvas, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysCanvas pSSysCanvas, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSysCanvasModelService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSysCanvasModel pSSysCanvasModel = new PSSysCanvasModel();
                pSSysCanvasModel.setPSSysCanvasId(pSSysCanvas.getPSSysCanvasId());
                pSSysCanvasModel.setPSSysCanvasName(pSSysCanvas.getPSSysCanvasName());
                pSSysCanvasModelService.compileModelV2(pSSysCanvasModel, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSysCanvasModel pSSysCanvasModel = new PSSysCanvasModel();
                    pSSysCanvasModel.setPSSysCanvasId(pSSysCanvas.getPSSysCanvasId());
                    pSSysCanvasModel.setPSSysCanvasName(pSSysCanvas.getPSSysCanvasName());
                    pSSysCanvasModelService.compileModelV2(pSSysCanvasModel, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysCanvas, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysCanvas pSSysCanvas, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSCANVASMODEL_PSSYSCANVAS_PSSYSCANVASID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysCanvasModels(pSSysCanvas, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysCanvas, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysCanvasModels(PSSysCanvas pSSysCanvas, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSCANVASMODEL", true), (boolean)false) == 0) {
            PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
            PSSysCanvasModel pSSysCanvasModel = new PSSysCanvasModel();
            pSSysCanvasModel.setPSSysCanvasModelId(pSMOSFile.getPSModelId());
            if (!pSSysCanvasModelService.get(pSSysCanvasModel, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysCanvasModel.getPSSysCanvasId(), (String)pSSysCanvas.getPSSysCanvasId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysCanvasModelService.exportModelV2(pSSysCanvasModel);
            pSSysCanvasModel.reset();
            if (!pSSysCanvasModelService.setModelV2ResScope(pSSysCanvasModel, "PSSYSCANVAS", pSSysCanvas.getPSSysCanvasId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysCanvasModelService.importModelV2(pSSysCanvasModel, objectNode);
            SessionFactoryManager.commit();
            return pSSysCanvasModelService.getFile(pSSysCanvasModel);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysCanvas pSSysCanvas, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysCanvasModels(pSSysCanvas, list);
        super.onFillPasteHelps(pSSysCanvas, list);
    }

    protected void onFillPasteHelps_PSSysCanvasModels(PSSysCanvas pSSysCanvas, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSCANVASMODEL");
        pSHelpSection.setSectionParam2("DER1N_PSSYSCANVASMODEL_PSSYSCANVAS_PSSYSCANVASID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u753b\u5e03]\u7684[\u7cfb\u7edf\u753b\u5e03\u76f8\u5173\u6a21\u578b]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysCanvas pSSysCanvas, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Canvas");
        defaultValueMap.put("PSSYSCANVASNAME", "\u753b\u5e03");
    }
}
