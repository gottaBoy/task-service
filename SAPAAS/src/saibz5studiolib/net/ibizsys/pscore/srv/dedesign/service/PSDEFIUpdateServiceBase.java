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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFIUpdateDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFIUpdateDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFIUpdateServiceBase
extends PSCoreSysServiceBase<PSDEFIUpdate> {
    private static final Log log = LogFactory.getLog(PSDEFIUpdateServiceBase.class);
    public static final String DATASET_CURFORM = "CurForm";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFIUpdateDEModel pSDEFIUpdateDEModel;
    private PSDEFIUpdateDAO pSDEFIUpdateDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService";
    }

    public PSDEFIUpdateDEModel getPSDEFIUpdateDEModel() {
        if (this.pSDEFIUpdateDEModel == null) {
            try {
                this.pSDEFIUpdateDEModel = (PSDEFIUpdateDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFIUpdateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFIUpdateDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFIUpdateDEModel();
    }

    public PSDEFIUpdateDAO getPSDEFIUpdateDAO() {
        if (this.pSDEFIUpdateDAO == null) {
            try {
                this.pSDEFIUpdateDAO = (PSDEFIUpdateDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFIUpdateDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFIUpdateDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFIUpdateDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURFORM, (boolean)true) == 0) {
            return this.fetchCurForm(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURFORM, (boolean)true) == 0) {
            return this.fetchTempCurForm(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurForm(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURFORM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurForm(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURFORM, true);
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

    protected void onFillParentInfo(PSDEFIUpdate pSDEFIUpdate, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIUPDATE_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSACHandler);
            } else {
                iService.get(pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSDEFIUpdate, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIUPDATE_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDEFIUpdate, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIUPDATE_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEFIUpdate, pSDEForm);
            return;
        }
        super.onFillParentInfo(pSDEFIUpdate, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFIUPDATE_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", string2);
            return this.onSyncDER1NData_PSDEForm(pSDEForm, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSDEFIUpdate pSDEFIUpdate, PSACHandler pSACHandler) throws Exception {
        pSDEFIUpdate.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEFIUpdate.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSDEAction(PSDEFIUpdate pSDEFIUpdate, PSDEAction pSDEAction) throws Exception {
        pSDEFIUpdate.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEFIUpdate.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEFIUpdate pSDEFIUpdate, PSDEForm pSDEForm) throws Exception {
        pSDEFIUpdate.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEFIUpdate.setPSDEFormName(pSDEForm.getPSDEFormName());
        pSDEFIUpdate.setPSDEId(pSDEForm.getPSDEId());
    }

    protected String onSyncDER1NData_PSDEForm(PSDEForm pSDEForm, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEForm(pSDEForm);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEFIUpdate> arrayList = this.selectByPSDEForm(pSDEForm);
            for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEFIUpdate, (String)"PSDEFIUPDATEID", (String)""))) continue;
                this.remove(pSDEFIUpdate);
            }
        }
        return null;
    }

    protected void onFillEntityFullInfo(PSDEFIUpdate pSDEFIUpdate, boolean bl) throws Exception {
        if (bl && pSDEFIUpdate.getCustomMode() == null) {
            pSDEFIUpdate.setCustomMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSDEFIUpdate, bl);
        this.onFillEntityFullInfo_PSACHandler(pSDEFIUpdate, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDEFIUpdate, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEFIUpdate, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSDEFIUpdate pSDEFIUpdate, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDEFIUpdate pSDEFIUpdate, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEFIUpdate pSDEFIUpdate, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFIUpdate pSDEFIUpdate, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFIUpdate, bl);
    }

    public ArrayList<PSDEFIUpdate> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEFIUpdate> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEFIUpdate> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSACHANDLERID", (Object)pSACHandlerBase.getPSACHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSACHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSACHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFIUpdate> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEFIUpdate> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEFIUpdate> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFIUpdate> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEFIUpdate> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEFIUpdate> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFIUpdate> selectTempByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectTempByPSDEForm(pSDEFormBase, "");
    }

    public ArrayList<PSDEFIUpdate> selectTempByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFormCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEFIUpdate> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIUPDATE_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSDEFIUPDATE", iDataEntityModel.getDataInfo(pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEFIUpdate> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            PSDEFIUpdate pSDEFIUpdate2 = (PSDEFIUpdate)this.getDEModel().createEntity();
            pSDEFIUpdate2.setPSDEFIUpdateId(pSDEFIUpdate.getPSDEFIUpdateId());
            pSDEFIUpdate2.setPSACHandlerId(null);
            this.update(pSDEFIUpdate2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIUpdateServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSDEFIUpdateServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSDEFIUpdateServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEFIUpdate> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            this.remove(pSDEFIUpdate);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEFIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEFIUpdate> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEFIUpdate> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIUPDATE_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSDEFIUPDATE", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEFIUpdate> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            PSDEFIUpdate pSDEFIUpdate2 = (PSDEFIUpdate)this.getDEModel().createEntity();
            pSDEFIUpdate2.setPSDEFIUpdateId(pSDEFIUpdate.getPSDEFIUpdateId());
            pSDEFIUpdate2.setPSDEActionId(null);
            this.update(pSDEFIUpdate2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIUpdateServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDEFIUpdateServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDEFIUpdateServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEFIUpdate> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            this.remove(pSDEFIUpdate);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEFIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEFIUpdate> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIUpdate> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            PSDEFIUpdate pSDEFIUpdate2 = (PSDEFIUpdate)this.getDEModel().createEntity();
            pSDEFIUpdate2.setPSDEFIUpdateId(pSDEFIUpdate.getPSDEFIUpdateId());
            pSDEFIUpdate2.setPSDEFormId(null);
            this.update(pSDEFIUpdate2);
        }
    }

    public void resetTempPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIUpdate> arrayList = this.selectTempByPSDEForm(pSDEForm);
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            PSDEFIUpdate pSDEFIUpdate2 = (PSDEFIUpdate)this.getDEModel().createEntity();
            pSDEFIUpdate2.setPSDEFIUpdateId(pSDEFIUpdate.getPSDEFIUpdateId());
            pSDEFIUpdate2.setPSDEFormId(null);
            this.updateTemp(pSDEFIUpdate2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIUpdateServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEFIUpdateServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEFIUpdateServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIUpdate> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            this.remove(pSDEFIUpdate);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIUpdate> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFIUpdate(pSDEFIUpdate);
        ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).removeByPSDEFIUpdate(pSDEFIUpdate);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFIUpdate(pSDEFIUpdate);
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).resetPSDEFIUpdate(pSDEFIUpdate);
        super.onBeforeRemove(pSDEFIUpdate);
    }

    protected void onBeforeRemoveTemp(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).removeTempByPSDEFIUpdate(pSDEFIUpdate);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).resetTempPSDEFIUpdate(pSDEFIUpdate);
        super.onBeforeRemoveTemp(pSDEFIUpdate);
    }

    public void removeTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIUpdateServiceBase.this.onBeforeRemoveTempByPSDEForm(pSDEForm2);
                PSDEFIUpdateServiceBase.this.internalRemoveTempByPSDEForm(pSDEForm2);
                PSDEFIUpdateServiceBase.this.onAfterRemoveTempByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIUpdate> arrayList = this.selectTempByPSDEForm(pSDEForm);
        this.onBeforeRemoveTempByPSDEForm(pSDEForm, arrayList);
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            this.removeTemp(pSDEFIUpdate);
        }
        this.onAfterRemoveTempByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIUpdate> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        this.getRelatedDataTempMajor_PSDEFIUDetail(pSDEFIUpdate);
        super.getRelatedDataTempMajor(pSDEFIUpdate);
    }

    protected void getRelatedDataTempMajor_PSDEFIUDetail(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUDetail> arrayList = null;
        String string = pSDEFIUpdate.getPSDEFIUpdateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFIUDetailService.selectByPSDEFIUpdate(pSDEFIUpdate) : pSDEFIUDetailService.selectTempByPSDEFIUpdate(pSDEFIUpdate);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            pSDEFIUDetailService.getTempMajor(pSDEFIUDetail);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEFIUpdate pSDEFIUpdate, PSDEFIUpdate pSDEFIUpdate2) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.updateRelatedDataTempMajor_removePSDEFIUDetail(pSDEFIUpdate, pSDEFIUpdate2);
        this.updateRelatedDataTempMajor_updatePSDEFIUDetail(pSDEFIUpdate, pSDEFIUpdate2, arrayList);
        super.updateRelatedDataTempMajor(pSDEFIUpdate, pSDEFIUpdate2);
    }

    protected ArrayList<PSDEFIUDetail> updateRelatedDataTempMajor_removePSDEFIUDetail(PSDEFIUpdate pSDEFIUpdate, PSDEFIUpdate pSDEFIUpdate2) throws Exception {
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUDetail> arrayList = pSDEFIUDetailService.selectTempByPSDEFIUpdate(pSDEFIUpdate);
        ArrayList<PSDEFIUDetail> arrayList2 = pSDEFIUDetailService.selectByPSDEFIUpdate(pSDEFIUpdate2);
        HashMap<String, PSDEFIUDetail> hashMap = new HashMap<String, PSDEFIUDetail>();
        for (PSDEFIUDetail pSDEFIUDetail : arrayList2) {
            hashMap.put(pSDEFIUDetail.getPSDEFIUDetailId(), pSDEFIUDetail);
        }
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            Object object = pSDEFIUDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFIUDetail pSDEFIUDetail : hashMap.values()) {
            pSDEFIUDetailService.remove(pSDEFIUDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFIUDetail(PSDEFIUpdate pSDEFIUpdate, PSDEFIUpdate pSDEFIUpdate2, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            pSDEFIUDetailService.updateTempMajor(pSDEFIUDetail);
        }
    }

    protected void replaceParentInfo(PSDEFIUpdate pSDEFIUpdate, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFIUpdate, cloneSession);
        if (pSDEFIUpdate.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEFIUpdate.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSDEFIUpdate, (PSACHandler)iEntity);
        }
        if (pSDEFIUpdate.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEFIUpdate.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDEFIUpdate, (PSDEAction)iEntity);
        }
        if (pSDEFIUpdate.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEFIUpdate.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEFIUpdate, (PSDEForm)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFIUpdate pSDEFIUpdate, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFIUpdate, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BusyIndicator(bl, pSDEFIUpdate, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelState(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFIUpdateId(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFIUpdateName(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFIUpdate, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isBusyIndicatorDirty() : !pSDEFIUpdate.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDEFIUpdate.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BUSYINDICATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isCodeNameDirty() && !bl2 : !pSDEFIUpdate.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEFIUpdate, bl2, bl3);
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
                string3 = "PSDEFORMID";
                String string4 = this.checkFieldDupRule(this.getPSDEFIUpdateDEModel(), "CODENAME", string3, pSDEFIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isCustomCodeDirty() : !pSDEFIUpdate.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isCustomModeDirty() : !pSDEFIUpdate.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEFIUpdate.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isDynaModelFlagDirty() : !pSDEFIUpdate.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEFIUpdate.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isMemoDirty() : !pSDEFIUpdate.isMemoDirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEFIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelState(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isModelStateDirty() : !pSDEFIUpdate.isModelStateDirty()) {
            return null;
        }
        Integer n = pSDEFIUpdate.getModelState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelState_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isPSACHandlerIdDirty() : !pSDEFIUpdate.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSACHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isPSDEActionIdDirty() : !pSDEFIUpdate.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFIUpdateId(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isPSDEFIUpdateIdDirty() && !bl2 : !pSDEFIUpdate.isPSDEFIUpdateIdDirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getPSDEFIUpdateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIUPDATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFIUpdateId_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIUPDATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFIUpdateName(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isPSDEFIUpdateNameDirty() && !bl2 : !pSDEFIUpdate.isPSDEFIUpdateNameDirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getPSDEFIUpdateName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIUPDATENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFIUpdateName_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIUPDATENAME");
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
                string3 = "PSDEFORMID";
                String string4 = this.checkFieldDupRule(this.getPSDEFIUpdateDEModel(), "PSDEFIUPDATENAME", string3, pSDEFIUpdate, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFIUPDATENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isPSDEFormIdDirty() && !bl2 : !pSDEFIUpdate.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getPSDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isPSDynaInstIdDirty() : !pSDEFIUpdate.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEFIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isUserTagDirty() : !pSDEFIUpdate.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEFIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFIUpdate pSDEFIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUpdate.isUserTag2Dirty() : !pSDEFIUpdate.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFIUpdate.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEFIUpdate, bl2, bl3);
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

    protected void onSyncEntity(PSDEFIUpdate pSDEFIUpdate, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFIUpdate, bl);
    }

    protected void onSyncIndexEntities(PSDEFIUpdate pSDEFIUpdate, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFIUpdate, bl);
    }

    public Object getDataContextValue(PSDEFIUpdate pSDEFIUpdate, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFIUpdate, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEForm pSDEForm = pSDEFIUpdate.getPSDEForm();
        if (pSDEForm != null && pSDEForm.contains(string)) {
            return pSDEForm.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFIUpdate pSDEFIUpdate, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFIUpdate, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIUPDATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIUpdateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIUPDATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIUpdateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ModelState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSACHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSACHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSACHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSACHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFIUpdateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIUPDATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFIUpdateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIUPDATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEFIUpdate pSDEFIUpdate) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFIUpdate)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        super.onUpdateParent(pSDEFIUpdate);
    }

    @Override
    protected void exportCurXmlModel(PSDEFIUpdate pSDEFIUpdate, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFIUPDATE");
        if (!bl) {
            pSDEFIUpdate.setPSDEFormId(null);
            pSDEFIUpdate.setPSDEFormName(null);
            pSDEFIUpdate.setPSDEId(null);
            super.exportCurXmlModel(pSDEFIUpdate, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEFIUpdate pSDEFIUpdate, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEFIUDetail(pSDEFIUpdate, xmlNode);
        super.onExportRelatedXmlModel(pSDEFIUpdate, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEFIUDetail(PSDEFIUpdate pSDEFIUpdate, XmlNode xmlNode) throws Exception {
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUDetail> arrayList = null;
        String string = pSDEFIUpdate.getPSDEFIUpdateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFIUDetailService.selectByPSDEFIUpdate(pSDEFIUpdate) : pSDEFIUDetailService.selectTempByPSDEFIUpdate(pSDEFIUpdate);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEFIDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
                pSDEFIUDetailService.exportXmlModel(pSDEFIUDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEFIUpdate pSDEFIUpdate, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEFIDETAILS");
        this.importRelatedXmlModel_PSDEFIUDetail(pSDEFIUpdate, xmlNode2);
        super.onImportRelatedXmlModel(pSDEFIUpdate, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEFIUDetail(PSDEFIUpdate pSDEFIUpdate, XmlNode xmlNode) throws Exception {
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEFIUpdate.getPSDEFIUpdateId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEFIUDetailService.removeByPSDEFIUpdate(pSDEFIUpdate);
        } else {
            pSDEFIUDetailService.removeTempByPSDEFIUpdate(pSDEFIUpdate);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFIUDetail pSDEFIUDetail = new PSDEFIUDetail();
                pSDEFIUDetailService.fillParentInfo(pSDEFIUDetail, "DER1N", "DER1N_PSDEFIUDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID", pSDEFIUpdate.getPSDEFIUpdateId());
                pSDEFIUDetailService.importXmlModel(pSDEFIUDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFIUpdate pSDEFIUpdate, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFIUpdate, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFORM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFIUPDATE_PSDEFORM_PSDEFORMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFORM", (boolean)true) == 0) {
            iEntity.set("PSDEFORMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEFORMID"};
    }

    @Override
    public String getModelV2Tag(PSDEFIUpdate pSDEFIUpdate) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFIUpdate.getPSDEFIUpdateName())) {
            return pSDEFIUpdate.getPSDEFIUpdateName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFIUpdate.getCodeName())) {
            return pSDEFIUpdate.getCodeName();
        }
        return super.getModelV2Tag(pSDEFIUpdate);
    }

    @Override
    public boolean setModelV2Tag(PSDEFIUpdate pSDEFIUpdate, String string) {
        pSDEFIUpdate.setPSDEFIUpdateName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEFIUPDATENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEFORMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFIUpdate pSDEFIUpdate, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFIUpdate.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFIUpdate, true);
        pSDEFIUpdate.set("PSDEFIUPDATENAME", string);
        if (this.select(pSDEFIUpdate, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEFIUpdate, true);
        return super.getModelV2Entity(pSDEFIUpdate, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFIUpdate pSDEFIUpdate, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEFIUpdate, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEFIUDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEFIUpdate pSDEFIUpdate, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEFIUpdate, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEFIUpdate pSDEFIUpdate, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFIUDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID")) {
            PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFIUPDATE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFIUDETAIL", (Object)pSDEFIUpdate.getPSDEFIUpdateId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEFIUPDATE#%1$s", (Object)pSDEFIUpdate.getPSDEFIUpdateId());
                for (PSDEFIUDetail detail : pSDEFIUDetailService.selectByPSDEFIUpdate(pSDEFIUpdate)) {
                    String detailScope = pSDEFIUDetailService.getModelV2ResScope(detail);
                    if (StringHelper.compare((String)scope, (String)detailScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(detail, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSDEFIUDetailService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeformdetailname")) {
                            string = objectNode.get("psdeformdetailname").asText();
                        }
                        if (objectNode2.has("psdeformdetailname")) {
                            string2 = objectNode2.get("psdeformdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode detailNode : arrayList) {
                    PSDEFIUDetail detail = new PSDEFIUDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)detail, detailNode, false);
                    output.add((JsonNode)pSDEFIUDetailService.exportModelV2(detail, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEFIUpdate, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUDetail> arrayList = pSDEFIUDetailService.selectByPSDEFIUpdate(pSDEFIUpdate);
        String string = StringHelper.format((String)"PSDEFIUPDATE#%1$s", (Object)pSDEFIUpdate.getPSDEFIUpdateId());
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            String string2 = pSDEFIUDetailService.getModelV2ResScope(pSDEFIUDetail);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEFIUDetailService.emptyModelV2(pSDEFIUDetail);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEFIUpdate.getPSDEFIUpdateId());
        pSDEFIUDetailService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEFIUDetailService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFIUDETAIL WHERE PSDEFIUPDATEID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEFIUpdate);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEFIUDetailService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEFIUpdate pSDEFIUpdate, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEFIUDetail pSDEFIUDetail = new PSDEFIUDetail();
        pSDEFIUDetail.set("PSDEFIUPDATEID", pSDEFIUpdate.getPSDEFIUpdateId());
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEFIUDetailService.getModelV2Entity(pSDEFIUDetail, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEFIUpdate, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEFIUpdate pSDEFIUpdate, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEFIUDetailService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEFIUDetail pSDEFIUDetail = new PSDEFIUDetail();
                pSDEFIUDetail.setPSDEFIUpdateId(pSDEFIUpdate.getPSDEFIUpdateId());
                pSDEFIUDetail.setPSDEFIUpdateName(pSDEFIUpdate.getPSDEFIUpdateName());
                pSDEFIUDetailService.compileModelV2(pSDEFIUDetail, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEFIUDetail pSDEFIUDetail = new PSDEFIUDetail();
                    pSDEFIUDetail.setPSDEFIUpdateId(pSDEFIUpdate.getPSDEFIUpdateId());
                    pSDEFIUDetail.setPSDEFIUpdateName(pSDEFIUpdate.getPSDEFIUpdateName());
                    pSDEFIUDetailService.compileModelV2(pSDEFIUDetail, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEFIUpdate, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEFIUpdate pSDEFIUpdate, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFIUDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFIDetails(pSDEFIUpdate, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEFIUpdate, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEFIDetails(PSDEFIUpdate pSDEFIUpdate, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFIUDETAIL", true), (boolean)false) == 0) {
            PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFIUDetail pSDEFIUDetail = new PSDEFIUDetail();
            pSDEFIUDetail.setPSDEFIUDetailId(pSMOSFile.getPSModelId());
            if (!pSDEFIUDetailService.get(pSDEFIUDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFIUDetail.getPSDEFIUpdateId(), (String)pSDEFIUpdate.getPSDEFIUpdateId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFIUDetailService.exportModelV2(pSDEFIUDetail);
            pSDEFIUDetail.reset();
            if (!pSDEFIUDetailService.setModelV2ResScope(pSDEFIUDetail, "PSDEFIUPDATE", pSDEFIUpdate.getPSDEFIUpdateId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFIUDetailService.importModelV2(pSDEFIUDetail, objectNode);
            SessionFactoryManager.commit();
            return pSDEFIUDetailService.getFile(pSDEFIUDetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEFIUpdate pSDEFIUpdate, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEFIDetails(pSDEFIUpdate, list);
        super.onFillPasteHelps(pSDEFIUpdate, list);
    }

    protected void onFillPasteHelps_PSDEFIDetails(PSDEFIUpdate pSDEFIUpdate, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFIUDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEFIUDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u8868\u5355\u9879\u66f4\u65b0]\u7684[\u8868\u5355\u9879\u66f4\u65b0\u6210\u5458]");
        list.add(pSHelpSection);
    }
}
