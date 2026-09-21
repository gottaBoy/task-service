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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEGEIUpdateDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEGEIUpdateDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
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

public abstract class PSDEGEIUpdateServiceBase
extends PSCoreSysServiceBase<PSDEGEIUpdate> {
    private static final Log log = LogFactory.getLog(PSDEGEIUpdateServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEGEIUpdateDEModel pSDEGEIUpdateDEModel;
    private PSDEGEIUpdateDAO pSDEGEIUpdateDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService";
    }

    public PSDEGEIUpdateDEModel getPSDEGEIUpdateDEModel() {
        if (this.pSDEGEIUpdateDEModel == null) {
            try {
                this.pSDEGEIUpdateDEModel = (PSDEGEIUpdateDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEGEIUpdateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGEIUpdateDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEGEIUpdateDEModel();
    }

    public PSDEGEIUpdateDAO getPSDEGEIUpdateDAO() {
        if (this.pSDEGEIUpdateDAO == null) {
            try {
                this.pSDEGEIUpdateDAO = (PSDEGEIUpdateDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEGEIUpdateDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGEIUpdateDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEGEIUpdateDAO();
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

    protected void onFillParentInfo(PSDEGEIUpdate pSDEGEIUpdate, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGEIUPDATE_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSACHandler);
            } else {
                iService.get((IEntity)pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSDEGEIUpdate, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGEIUPDATE_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDEGEIUpdate, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGEIUPDATE_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEGrid);
            } else {
                iService.get((IEntity)pSDEGrid);
            }
            this.onFillParentInfo_PSDEGrid(pSDEGEIUpdate, pSDEGrid);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEGEIUpdate, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEGEIUPDATE_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", string2);
            return this.onSyncDER1NData_PSDEGrid(pSDEGrid, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSDEGEIUpdate pSDEGEIUpdate, PSACHandler pSACHandler) throws Exception {
        pSDEGEIUpdate.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEGEIUpdate.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSDEAction(PSDEGEIUpdate pSDEGEIUpdate, PSDEAction pSDEAction) throws Exception {
        pSDEGEIUpdate.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGEIUpdate.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEGrid(PSDEGEIUpdate pSDEGEIUpdate, PSDEGrid pSDEGrid) throws Exception {
        pSDEGEIUpdate.setPSDEGridId(pSDEGrid.getPSDEGridId());
        pSDEGEIUpdate.setPSDEGridName(pSDEGrid.getPSDEGridName());
    }

    protected String onSyncDER1NData_PSDEGrid(PSDEGrid pSDEGrid, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEGrid(pSDEGrid);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEGEIUpdate> arrayList = this.selectByPSDEGrid(pSDEGrid);
            for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEGEIUpdate, (String)"PSDEGEIUPDATEID", (String)""))) continue;
                this.remove((IEntity)pSDEGEIUpdate);
            }
        }
        return null;
    }

    protected void onFillEntityFullInfo(PSDEGEIUpdate pSDEGEIUpdate, boolean bl) throws Exception {
        if (bl && pSDEGEIUpdate.getCustomMode() == null) {
            pSDEGEIUpdate.setCustomMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEGEIUpdate, bl);
        this.onFillEntityFullInfo_PSACHandler(pSDEGEIUpdate, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDEGEIUpdate, bl);
        this.onFillEntityFullInfo_PSDEGrid(pSDEGEIUpdate, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSDEGEIUpdate pSDEGEIUpdate, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDEGEIUpdate pSDEGEIUpdate, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEGrid(PSDEGEIUpdate pSDEGEIUpdate, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEGEIUpdate pSDEGEIUpdate, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEGEIUpdate, bl);
    }

    public ArrayList<PSDEGEIUpdate> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEGEIUpdate> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEGEIUpdate> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGEIUpdate> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGEIUpdate> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGEIUpdate> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGEIUpdate> selectByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, "", -1);
    }

    public ArrayList<PSDEGEIUpdate> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, string, -1);
    }

    public ArrayList<PSDEGEIUpdate> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDID", (Object)pSDEGridBase.getPSDEGridId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEGridCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEGridCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIUpdate> selectTempByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectTempByPSDEGrid(pSDEGridBase, "");
    }

    public ArrayList<PSDEGEIUpdate> selectTempByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDID", (Object)pSDEGridBase.getPSDEGridId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEGridCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEGridCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEGEIUpdate> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGEIUPDATE_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSDEGEIUPDATE", iDataEntityModel.getDataInfo((IEntity)pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEGEIUpdate> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            PSDEGEIUpdate pSDEGEIUpdate2 = (PSDEGEIUpdate)this.getDEModel().createEntity();
            pSDEGEIUpdate2.setPSDEGEIUpdateId(pSDEGEIUpdate.getPSDEGEIUpdateId());
            pSDEGEIUpdate2.setPSACHandlerId(null);
            this.update(pSDEGEIUpdate2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIUpdateServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSDEGEIUpdateServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSDEGEIUpdateServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEGEIUpdate> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            this.remove((IEntity)pSDEGEIUpdate);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEGEIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEGEIUpdate> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGEIUpdate> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGEIUPDATE_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSDEGEIUPDATE", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGEIUpdate> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            PSDEGEIUpdate pSDEGEIUpdate2 = (PSDEGEIUpdate)this.getDEModel().createEntity();
            pSDEGEIUpdate2.setPSDEGEIUpdateId(pSDEGEIUpdate.getPSDEGEIUpdateId());
            pSDEGEIUpdate2.setPSDEActionId(null);
            this.update(pSDEGEIUpdate2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIUpdateServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDEGEIUpdateServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDEGEIUpdateServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGEIUpdate> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            this.remove((IEntity)pSDEGEIUpdate);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGEIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGEIUpdate> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    public void resetPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIUpdate> arrayList = this.selectByPSDEGrid(pSDEGrid);
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            PSDEGEIUpdate pSDEGEIUpdate2 = (PSDEGEIUpdate)this.getDEModel().createEntity();
            pSDEGEIUpdate2.setPSDEGEIUpdateId(pSDEGEIUpdate.getPSDEGEIUpdateId());
            pSDEGEIUpdate2.setPSDEGridId(null);
            this.update(pSDEGEIUpdate2);
        }
    }

    public void resetTempPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIUpdate> arrayList = this.selectTempByPSDEGrid(pSDEGrid);
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            PSDEGEIUpdate pSDEGEIUpdate2 = (PSDEGEIUpdate)this.getDEModel().createEntity();
            pSDEGEIUpdate2.setPSDEGEIUpdateId(pSDEGEIUpdate.getPSDEGEIUpdateId());
            pSDEGEIUpdate2.setPSDEGridId(null);
            this.updateTemp((IEntity)pSDEGEIUpdate2);
        }
    }

    public void removeByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIUpdateServiceBase.this.onBeforeRemoveByPSDEGrid(pSDEGrid2);
                PSDEGEIUpdateServiceBase.this.internalRemoveByPSDEGrid(pSDEGrid2);
                PSDEGEIUpdateServiceBase.this.onAfterRemoveByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIUpdate> arrayList = this.selectByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveByPSDEGrid(pSDEGrid, arrayList);
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            this.remove((IEntity)pSDEGEIUpdate);
        }
        this.onAfterRemoveByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIUpdate> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIUDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGEIUpdate(pSDEGEIUpdate);
        ((PSDEGEIUDetailServiceBase)pSCoreSysServiceBase).removeByPSDEGEIUpdate(pSDEGEIUpdate);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGEIUpdate(pSDEGEIUpdate);
        super.onBeforeRemove(pSDEGEIUpdate);
    }

    protected void onBeforeRemoveTemp(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIUDetailServiceBase)pSCoreSysServiceBase).removeTempByPSDEGEIUpdate(pSDEGEIUpdate);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).resetTempPSDEGEIUpdate(pSDEGEIUpdate);
        super.onBeforeRemoveTemp((IEntity)pSDEGEIUpdate);
    }

    public void removeTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIUpdateServiceBase.this.onBeforeRemoveTempByPSDEGrid(pSDEGrid2);
                PSDEGEIUpdateServiceBase.this.internalRemoveTempByPSDEGrid(pSDEGrid2);
                PSDEGEIUpdateServiceBase.this.onAfterRemoveTempByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIUpdate> arrayList = this.selectTempByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveTempByPSDEGrid(pSDEGrid, arrayList);
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            this.removeTemp((IEntity)pSDEGEIUpdate);
        }
        this.onAfterRemoveTempByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIUpdate> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        this.getRelatedDataTempMajor_PSDEGEIUDetail(pSDEGEIUpdate);
        super.getRelatedDataTempMajor((IEntity)pSDEGEIUpdate);
    }

    protected void getRelatedDataTempMajor_PSDEGEIUDetail(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUDetail> arrayList = null;
        String string = pSDEGEIUpdate.getPSDEGEIUpdateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEGEIUDetailService.selectByPSDEGEIUpdate(pSDEGEIUpdate) : pSDEGEIUDetailService.selectTempByPSDEGEIUpdate(pSDEGEIUpdate);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            pSDEGEIUDetailService.getTempMajor(pSDEGEIUDetail);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEGEIUpdate pSDEGEIUpdate, PSDEGEIUpdate pSDEGEIUpdate2) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.updateRelatedDataTempMajor_removePSDEGEIUDetail(pSDEGEIUpdate, pSDEGEIUpdate2);
        this.updateRelatedDataTempMajor_updatePSDEGEIUDetail(pSDEGEIUpdate, pSDEGEIUpdate2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEGEIUpdate, (IEntity)pSDEGEIUpdate2);
    }

    protected ArrayList<PSDEGEIUDetail> updateRelatedDataTempMajor_removePSDEGEIUDetail(PSDEGEIUpdate pSDEGEIUpdate, PSDEGEIUpdate pSDEGEIUpdate2) throws Exception {
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUDetail> arrayList = pSDEGEIUDetailService.selectTempByPSDEGEIUpdate(pSDEGEIUpdate);
        ArrayList<PSDEGEIUDetail> arrayList2 = pSDEGEIUDetailService.selectByPSDEGEIUpdate(pSDEGEIUpdate2);
        HashMap<String, PSDEGEIUDetail> hashMap = new HashMap<String, PSDEGEIUDetail>();
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList2) {
            hashMap.put(pSDEGEIUDetail.getPSDEGEIUDetailId(), pSDEGEIUDetail);
        }
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            Object object = pSDEGEIUDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEGEIUDetail pSDEGEIUDetail : hashMap.values()) {
            pSDEGEIUDetailService.remove((IEntity)pSDEGEIUDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEGEIUDetail(PSDEGEIUpdate pSDEGEIUpdate, PSDEGEIUpdate pSDEGEIUpdate2, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            pSDEGEIUDetailService.updateTempMajor(pSDEGEIUDetail);
        }
    }

    protected void replaceParentInfo(PSDEGEIUpdate pSDEGEIUpdate, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEGEIUpdate, cloneSession);
        if (pSDEGEIUpdate.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEGEIUpdate.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSDEGEIUpdate, (PSACHandler)iEntity);
        }
        if (pSDEGEIUpdate.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGEIUpdate.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDEGEIUpdate, (PSDEAction)iEntity);
        }
        if (pSDEGEIUpdate.getPSDEGridId() != null && (iEntity = cloneSession.getEntity("PSDEGRID", (Object)pSDEGEIUpdate.getPSDEGridId())) != null) {
            this.onFillParentInfo_PSDEGrid(pSDEGEIUpdate, (PSDEGrid)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEGEIUpdate pSDEGEIUpdate, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEGEIUpdate, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BusyIndicator(bl, pSDEGEIUpdate, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelState(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGEIUpdateId(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGEIUpdateName(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridId(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEGEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEGEIUpdate, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isBusyIndicatorDirty() : !pSDEGEIUpdate.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDEGEIUpdate.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isCodeNameDirty() && !bl2 : !pSDEGEIUpdate.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEGEIUpdate.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
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
                string3 = "PSDEGRIDID";
                String string4 = this.checkFieldDupRule(this.getPSDEGEIUpdateDEModel(), "CODENAME", string3, pSDEGEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isCustomCodeDirty() : !pSDEGEIUpdate.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEGEIUpdate.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isCustomModeDirty() : !pSDEGEIUpdate.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEGEIUpdate.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isMemoDirty() : !pSDEGEIUpdate.isMemoDirty()) {
            return null;
        }
        String string = pSDEGEIUpdate.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelState(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isModelStateDirty() : !pSDEGEIUpdate.isModelStateDirty()) {
            return null;
        }
        Integer n = pSDEGEIUpdate.getModelState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelState_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isPSACHandlerIdDirty() : !pSDEGEIUpdate.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEGEIUpdate.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isPSDEActionIdDirty() : !pSDEGEIUpdate.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGEIUpdate.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEGEIUpdateId(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isPSDEGEIUpdateIdDirty() && !bl2 : !pSDEGEIUpdate.isPSDEGEIUpdateIdDirty()) {
            return null;
        }
        String string = pSDEGEIUpdate.getPSDEGEIUpdateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIUPDATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGEIUpdateId_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIUPDATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGEIUpdateName(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isPSDEGEIUpdateNameDirty() && !bl2 : !pSDEGEIUpdate.isPSDEGEIUpdateNameDirty()) {
            return null;
        }
        String string = pSDEGEIUpdate.getPSDEGEIUpdateName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIUPDATENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGEIUpdateName_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIUPDATENAME");
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
                string3 = "PSDEGRIDID";
                String string4 = this.checkFieldDupRule(this.getPSDEGEIUpdateDEModel(), "PSDEGEIUPDATENAME", string3, pSDEGEIUpdate, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEGEIUPDATENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridId(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isPSDEGridIdDirty() && !bl2 : !pSDEGEIUpdate.isPSDEGridIdDirty()) {
            return null;
        }
        String string = pSDEGEIUpdate.getPSDEGridId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridId_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isUserTagDirty() : !pSDEGEIUpdate.isUserTagDirty()) {
            return null;
        }
        String string = pSDEGEIUpdate.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEGEIUpdate pSDEGEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUpdate.isUserTag2Dirty() : !pSDEGEIUpdate.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEGEIUpdate.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEGEIUpdate, bl2, bl3);
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

    protected void onSyncEntity(PSDEGEIUpdate pSDEGEIUpdate, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEGEIUpdate, bl);
    }

    protected void onSyncIndexEntities(PSDEGEIUpdate pSDEGEIUpdate, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEGEIUpdate, bl);
    }

    public Object getDataContextValue(PSDEGEIUpdate pSDEGEIUpdate, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEGEIUpdate, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEGrid pSDEGrid = pSDEGEIUpdate.getPSDEGrid();
        if (pSDEGrid != null && pSDEGrid.contains(string)) {
            return pSDEGrid.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEGEIUpdate pSDEGEIUpdate, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEGEIUpdate, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEGEIUPDATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGEIUpdateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGEIUPDATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGEIUpdateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEGEIUpdateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGEIUPDATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGEIUpdateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGEIUPDATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEGEIUpdate)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        super.onUpdateParent((IEntity)pSDEGEIUpdate);
    }

    @Override
    protected void exportCurXmlModel(PSDEGEIUpdate pSDEGEIUpdate, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEGEIUPDATE");
        if (!bl) {
            pSDEGEIUpdate.setCreateDate(null);
            pSDEGEIUpdate.setCreateMan(null);
            pSDEGEIUpdate.setPSDEGEIUpdateId(null);
            pSDEGEIUpdate.setUpdateDate(null);
            pSDEGEIUpdate.setUpdateMan(null);
            pSDEGEIUpdate.setPSDEGridId(null);
            pSDEGEIUpdate.setPSDEGridName(null);
            super.exportCurXmlModel(pSDEGEIUpdate, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEGEIUpdate pSDEGEIUpdate, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEGEIUDetail(pSDEGEIUpdate, xmlNode);
        super.onExportRelatedXmlModel(pSDEGEIUpdate, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEGEIUDetail(PSDEGEIUpdate pSDEGEIUpdate, XmlNode xmlNode) throws Exception {
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUDetail> arrayList = null;
        String string = pSDEGEIUpdate.getPSDEGEIUpdateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEGEIUDetailService.selectByPSDEGEIUpdate(pSDEGEIUpdate) : pSDEGEIUDetailService.selectTempByPSDEGEIUpdate(pSDEGEIUpdate);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEGEIDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
                pSDEGEIUDetailService.exportXmlModel(pSDEGEIUDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEGEIUpdate pSDEGEIUpdate, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEGEIDETAILS");
        this.importRelatedXmlModel_PSDEGEIUDetail(pSDEGEIUpdate, xmlNode2);
        super.onImportRelatedXmlModel(pSDEGEIUpdate, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEGEIUDetail(PSDEGEIUpdate pSDEGEIUpdate, XmlNode xmlNode) throws Exception {
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEGEIUpdate.getPSDEGEIUpdateId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEGEIUDetailService.removeByPSDEGEIUpdate(pSDEGEIUpdate);
        } else {
            pSDEGEIUDetailService.removeTempByPSDEGEIUpdate(pSDEGEIUpdate);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEGEIUDetail pSDEGEIUDetail = new PSDEGEIUDetail();
                pSDEGEIUDetailService.fillParentInfo((IEntity)pSDEGEIUDetail, "DER1N", "DER1N_PSDEGEIUDETAIL_PSDEGEIUPDATE_PSDEGEIUPDATEID", pSDEGEIUpdate.getPSDEGEIUpdateId());
                pSDEGEIUDetailService.importXmlModel(pSDEGEIUDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEGEIUpdate pSDEGEIUpdate, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEGEIUpdate, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEGRID#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEGEIUPDATE_PSDEGRID_PSDEGRIDID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEGRID", (boolean)true) == 0) {
            iEntity.set("PSDEGRIDID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEGRIDID"};
    }

    @Override
    public String getModelV2Tag(PSDEGEIUpdate pSDEGEIUpdate) {
        if (!StringHelper.isNullOrEmpty((String)pSDEGEIUpdate.getPSDEGEIUpdateName())) {
            return pSDEGEIUpdate.getPSDEGEIUpdateName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEGEIUpdate.getCodeName())) {
            return pSDEGEIUpdate.getCodeName();
        }
        return super.getModelV2Tag(pSDEGEIUpdate);
    }

    @Override
    public boolean setModelV2Tag(PSDEGEIUpdate pSDEGEIUpdate, String string) {
        pSDEGEIUpdate.setPSDEGEIUpdateName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEGEIUPDATENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEGRIDID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEGEIUpdate pSDEGEIUpdate, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEGEIUpdate.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEGEIUpdate, true);
        pSDEGEIUpdate.set("PSDEGEIUPDATENAME", string);
        if (this.select(pSDEGEIUpdate, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEGEIUpdate, true);
        return super.getModelV2Entity(pSDEGEIUpdate, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEGEIUpdate pSDEGEIUpdate, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEGEIUpdate, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEGEIUDETAIL_PSDEGEIUPDATE_PSDEGEIUPDATEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEGEIUpdate pSDEGEIUpdate, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEGEIUpdate, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEGEIUpdate pSDEGEIUpdate, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEGEIUDETAIL_PSDEGEIUPDATE_PSDEGEIUPDATEID")) {
            Object object;
            PSDEGEIUDetail pSDEGEIUDetail2;
            Object object2;
            Object object3;
            Object object4;
            PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEGEIUDetail> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEGEIUPDATE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEGEIUDETAIL", (Object)pSDEGEIUpdate.getPSDEGEIUpdateId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSDEGEIUDetail2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSDEGEIUDetail2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEGEIUDetail>();
                object4 = pSDEGEIUDetailService.selectByPSDEGEIUpdate(pSDEGEIUpdate);
                object3 = StringHelper.format((String)"PSDEGEIUPDATE#%1$s", (Object)pSDEGEIUpdate.getPSDEGEIUpdateId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSDEGEIUDetail2 = object2.next();
                    object = pSDEGEIUDetailService.getModelV2ResScope((IEntity)pSDEGEIUDetail2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEGEIUDetail)PSModelV2Helper.toJSONObject((IEntity)pSDEGEIUDetail2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSDEGEIUDetailService.getModelV2Name(false);
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
                        if (objectNode.has("psdegridcolname")) {
                            string = objectNode.get("psdegridcolname").asText();
                        }
                        if (objectNode2.has("psdegridcolname")) {
                            string2 = objectNode2.get("psdegridcolname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSDEGEIUDetail pSDEGEIUDetail2 : arrayList) {
                    object = new PSDEGEIUDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSDEGEIUDetail2, false);
                    object3.add((JsonNode)pSDEGEIUDetailService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEGEIUpdate, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUDetail> arrayList = pSDEGEIUDetailService.selectByPSDEGEIUpdate(pSDEGEIUpdate);
        String string = StringHelper.format((String)"PSDEGEIUPDATE#%1$s", (Object)pSDEGEIUpdate.getPSDEGEIUpdateId());
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            String string2 = pSDEGEIUDetailService.getModelV2ResScope((IEntity)pSDEGEIUDetail);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEGEIUDetailService.emptyModelV2(pSDEGEIUDetail);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEGEIUpdate.getPSDEGEIUpdateId());
        pSDEGEIUDetailService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEGEIUDetailService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEGEIUDETAIL WHERE PSDEGEIUPDATEID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEGEIUpdate);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEGEIUDetailService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEGEIUpdate pSDEGEIUpdate, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEGEIUDetail pSDEGEIUDetail = new PSDEGEIUDetail();
        pSDEGEIUDetail.set("PSDEGEIUPDATEID", pSDEGEIUpdate.getPSDEGEIUpdateId());
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEGEIUDetailService.getModelV2Entity(pSDEGEIUDetail, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEGEIUpdate, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEGEIUpdate pSDEGEIUpdate, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEGEIUDetailService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEGEIUDetail pSDEGEIUDetail = new PSDEGEIUDetail();
                pSDEGEIUDetail.setPSDEGEIUpdateId(pSDEGEIUpdate.getPSDEGEIUpdateId());
                pSDEGEIUDetail.setPSDEGEIUpdateName(pSDEGEIUpdate.getPSDEGEIUpdateName());
                pSDEGEIUDetailService.compileModelV2(pSDEGEIUDetail, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEGEIUDetail pSDEGEIUDetail = new PSDEGEIUDetail();
                    pSDEGEIUDetail.setPSDEGEIUpdateId(pSDEGEIUpdate.getPSDEGEIUpdateId());
                    pSDEGEIUDetail.setPSDEGEIUpdateName(pSDEGEIUpdate.getPSDEGEIUpdateName());
                    pSDEGEIUDetailService.compileModelV2(pSDEGEIUDetail, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEGEIUpdate, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEGEIUpdate pSDEGEIUpdate, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEGEIUDETAIL_PSDEGEIUPDATE_PSDEGEIUPDATEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEGEIDetails(pSDEGEIUpdate, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEGEIUpdate, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEGEIDetails(PSDEGEIUpdate pSDEGEIUpdate, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEGEIUDETAIL", true), (boolean)false) == 0) {
            PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEGEIUDetail pSDEGEIUDetail = new PSDEGEIUDetail();
            pSDEGEIUDetail.setPSDEGEIUDetailId(pSMOSFile.getPSModelId());
            if (!pSDEGEIUDetailService.get((IEntity)pSDEGEIUDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEGEIUDetail.getPSDEGEIUpdateId(), (String)pSDEGEIUpdate.getPSDEGEIUpdateId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEGEIUDetailService.exportModelV2(pSDEGEIUDetail);
            pSDEGEIUDetail.reset();
            if (!pSDEGEIUDetailService.setModelV2ResScope((IEntity)pSDEGEIUDetail, "PSDEGEIUPDATE", pSDEGEIUpdate.getPSDEGEIUpdateId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEGEIUDetailService.importModelV2(pSDEGEIUDetail, objectNode);
            SessionFactoryManager.commit();
            return pSDEGEIUDetailService.getFile((IEntity)pSDEGEIUDetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEGEIUpdate pSDEGEIUpdate, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEGEIDetails(pSDEGEIUpdate, list);
        super.onFillPasteHelps(pSDEGEIUpdate, list);
    }

    protected void onFillPasteHelps_PSDEGEIDetails(PSDEGEIUpdate pSDEGEIUpdate, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEGEIUDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEGEIUDETAIL_PSDEGEIUPDATE_PSDEGEIUPDATEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6a21\u5f0f]\u7684[\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6210\u5458]");
        list.add(pSHelpSection);
    }
}

