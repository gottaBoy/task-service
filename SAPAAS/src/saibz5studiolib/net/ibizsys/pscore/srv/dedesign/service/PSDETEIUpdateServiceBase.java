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
import net.ibizsys.pscore.srv.dedesign.dao.PSDETEIUpdateDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETEIUpdateDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETEIUpdateServiceBase
extends PSCoreSysServiceBase<PSDETEIUpdate> {
    private static final Log log = LogFactory.getLog(PSDETEIUpdateServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDETEIUpdateDEModel pSDETEIUpdateDEModel;
    private PSDETEIUpdateDAO pSDETEIUpdateDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService";
    }

    public PSDETEIUpdateDEModel getPSDETEIUpdateDEModel() {
        if (this.pSDETEIUpdateDEModel == null) {
            try {
                this.pSDETEIUpdateDEModel = (PSDETEIUpdateDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETEIUpdateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETEIUpdateDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDETEIUpdateDEModel();
    }

    public PSDETEIUpdateDAO getPSDETEIUpdateDAO() {
        if (this.pSDETEIUpdateDAO == null) {
            try {
                this.pSDETEIUpdateDAO = (PSDETEIUpdateDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDETEIUpdateDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETEIUpdateDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDETEIUpdateDAO();
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

    protected void onFillParentInfo(PSDETEIUpdate pSDETEIUpdate, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETEIUPDATE_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDETEIUpdate, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETEIUPDATE_PSDETREENODE_PSDETREENODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService", (SessionFactory)this.getSessionFactory());
            PSDETreeNode pSDETreeNode = (PSDETreeNode)iService.getDEModel().createEntity();
            pSDETreeNode.set("PSDETREENODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeNode);
            } else {
                iService.get(pSDETreeNode);
            }
            this.onFillParentInfo_PSDETreeNode(pSDETEIUpdate, pSDETreeNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETEIUPDATE_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeView);
            } else {
                iService.get(pSDETreeView);
            }
            this.onFillParentInfo_PSDETreeView(pSDETEIUpdate, pSDETreeView);
            return;
        }
        super.onFillParentInfo(pSDETEIUpdate, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDETEIUPDATE_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", string2);
            return this.onSyncDER1NData_PSDETreeView(pSDETreeView, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEAction(PSDETEIUpdate pSDETEIUpdate, PSDEAction pSDEAction) throws Exception {
        pSDETEIUpdate.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDETEIUpdate.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDETreeNode(PSDETEIUpdate pSDETEIUpdate, PSDETreeNode pSDETreeNode) throws Exception {
        pSDETEIUpdate.setPSDEId(pSDETreeNode.getPSDEId());
        pSDETEIUpdate.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
        pSDETEIUpdate.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
        if (pSDETreeNode.getPSDETreeView() != null) {
            this.onFillParentInfo_PSDETreeView(pSDETEIUpdate, pSDETreeNode.getPSDETreeView());
        }
    }

    protected void onFillParentInfo_PSDETreeView(PSDETEIUpdate pSDETEIUpdate, PSDETreeView pSDETreeView) throws Exception {
        pSDETEIUpdate.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
        pSDETEIUpdate.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
    }

    protected String onSyncDER1NData_PSDETreeView(PSDETreeView pSDETreeView, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDETreeView(pSDETreeView);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDETEIUpdate> arrayList = this.selectByPSDETreeView(pSDETreeView);
            for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDETEIUpdate, (String)"PSDETEIUPDATEID", (String)""))) continue;
                this.remove(pSDETEIUpdate);
            }
        }
        return null;
    }

    protected void onFillEntityFullInfo(PSDETEIUpdate pSDETEIUpdate, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDETEIUpdate, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDETEIUpdate, bl);
        this.onFillEntityFullInfo_PSDETreeNode(pSDETEIUpdate, bl);
        this.onFillEntityFullInfo_PSDETreeView(pSDETEIUpdate, bl);
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDETEIUpdate pSDETEIUpdate, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeNode(PSDETEIUpdate pSDETEIUpdate, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeView(PSDETEIUpdate pSDETEIUpdate, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDETEIUpdate pSDETEIUpdate, boolean bl) throws Exception {
        super.onWriteBackParent(pSDETEIUpdate, bl);
    }

    public ArrayList<PSDETEIUpdate> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDETEIUpdate> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDETEIUpdate> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETEIUpdate> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectByPSDETreeNode(pSDETreeNodeBase, "", -1);
    }

    public ArrayList<PSDETEIUpdate> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        return this.selectByPSDETreeNode(pSDETreeNodeBase, string, -1);
    }

    public ArrayList<PSDETEIUpdate> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREENODEID", (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETreeNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETreeNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETEIUpdate> selectTempByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectTempByPSDETreeNode(pSDETreeNodeBase, "");
    }

    public ArrayList<PSDETEIUpdate> selectTempByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREENODEID", (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETEIUpdate> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, "", -1);
    }

    public ArrayList<PSDETEIUpdate> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, string, -1);
    }

    public ArrayList<PSDETEIUpdate> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREEVIEWID", (Object)pSDETreeViewBase.getPSDETreeViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETreeViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETreeViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETEIUpdate> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectTempByPSDETreeView(pSDETreeViewBase, "");
    }

    public ArrayList<PSDETEIUpdate> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREEVIEWID", (Object)pSDETreeViewBase.getPSDETreeViewId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeViewCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeViewCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETEIUPDATE_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSDETEIUPDATE", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            PSDETEIUpdate pSDETEIUpdate2 = (PSDETEIUpdate)this.getDEModel().createEntity();
            pSDETEIUpdate2.setPSDETEIUpdateId(pSDETEIUpdate.getPSDETEIUpdateId());
            pSDETEIUpdate2.setPSDEActionId(null);
            this.update(pSDETEIUpdate2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUpdateServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDETEIUpdateServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDETEIUpdateServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            this.remove(pSDETEIUpdate);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    public void resetPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectByPSDETreeNode(pSDETreeNode);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            PSDETEIUpdate pSDETEIUpdate2 = (PSDETEIUpdate)this.getDEModel().createEntity();
            pSDETEIUpdate2.setPSDETEIUpdateId(pSDETEIUpdate.getPSDETEIUpdateId());
            pSDETEIUpdate2.setPSDETreeNodeId(null);
            this.update(pSDETEIUpdate2);
        }
    }

    public void resetTempPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectTempByPSDETreeNode(pSDETreeNode);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            PSDETEIUpdate pSDETEIUpdate2 = (PSDETEIUpdate)this.getDEModel().createEntity();
            pSDETEIUpdate2.setPSDETEIUpdateId(pSDETEIUpdate.getPSDETEIUpdateId());
            pSDETEIUpdate2.setPSDETreeNodeId(null);
            this.updateTemp(pSDETEIUpdate2);
        }
    }

    public void removeByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUpdateServiceBase.this.onBeforeRemoveByPSDETreeNode(pSDETreeNode2);
                PSDETEIUpdateServiceBase.this.internalRemoveByPSDETreeNode(pSDETreeNode2);
                PSDETEIUpdateServiceBase.this.onAfterRemoveByPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectByPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveByPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            this.remove(pSDETEIUpdate);
        }
        this.onAfterRemoveByPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    public void resetPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectByPSDETreeView(pSDETreeView);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            PSDETEIUpdate pSDETEIUpdate2 = (PSDETEIUpdate)this.getDEModel().createEntity();
            pSDETEIUpdate2.setPSDETEIUpdateId(pSDETEIUpdate.getPSDETEIUpdateId());
            pSDETEIUpdate2.setPSDETreeViewId(null);
            this.update(pSDETEIUpdate2);
        }
    }

    public void resetTempPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            PSDETEIUpdate pSDETEIUpdate2 = (PSDETEIUpdate)this.getDEModel().createEntity();
            pSDETEIUpdate2.setPSDETEIUpdateId(pSDETEIUpdate.getPSDETEIUpdateId());
            pSDETEIUpdate2.setPSDETreeViewId(null);
            this.updateTemp(pSDETEIUpdate2);
        }
    }

    public void removeByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUpdateServiceBase.this.onBeforeRemoveByPSDETreeView(pSDETreeView2);
                PSDETEIUpdateServiceBase.this.internalRemoveByPSDETreeView(pSDETreeView2);
                PSDETEIUpdateServiceBase.this.onAfterRemoveByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            this.remove(pSDETEIUpdate);
        }
        this.onAfterRemoveByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETEIUDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDETEIUpdate(pSDETEIUpdate);
        ((PSDETEIUDetailServiceBase)pSCoreSysServiceBase).removeByPSDETEIUpdate(pSDETEIUpdate);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPSDETEIUpdate(pSDETEIUpdate);
        super.onBeforeRemove(pSDETEIUpdate);
    }

    protected void onBeforeRemoveTemp(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETEIUDetailServiceBase)pSCoreSysServiceBase).removeTempByPSDETEIUpdate(pSDETEIUpdate);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).resetTempPSDETEIUpdate(pSDETEIUpdate);
        super.onBeforeRemoveTemp(pSDETEIUpdate);
    }

    public void removeTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUpdateServiceBase.this.onBeforeRemoveTempByPSDETreeNode(pSDETreeNode2);
                PSDETEIUpdateServiceBase.this.internalRemoveTempByPSDETreeNode(pSDETreeNode2);
                PSDETEIUpdateServiceBase.this.onAfterRemoveTempByPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectTempByPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveTempByPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            this.removeTemp(pSDETEIUpdate);
        }
        this.onAfterRemoveTempByPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
    }

    public void removeTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUpdateServiceBase.this.onBeforeRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETEIUpdateServiceBase.this.internalRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETEIUpdateServiceBase.this.onAfterRemoveTempByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETEIUpdate> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveTempByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            this.removeTemp(pSDETEIUpdate);
        }
        this.onAfterRemoveTempByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        this.getRelatedDataTempMajor_PSDETEIUDetail(pSDETEIUpdate);
        super.getRelatedDataTempMajor(pSDETEIUpdate);
    }

    protected void getRelatedDataTempMajor_PSDETEIUDetail(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUDetail> arrayList = null;
        String string = pSDETEIUpdate.getPSDETEIUpdateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETEIUDetailService.selectByPSDETEIUpdate(pSDETEIUpdate) : pSDETEIUDetailService.selectTempByPSDETEIUpdate(pSDETEIUpdate);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            pSDETEIUDetailService.getTempMajor(pSDETEIUDetail);
        }
    }

    protected void updateRelatedDataTempMajor(PSDETEIUpdate pSDETEIUpdate, PSDETEIUpdate pSDETEIUpdate2) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.updateRelatedDataTempMajor_removePSDETEIUDetail(pSDETEIUpdate, pSDETEIUpdate2);
        this.updateRelatedDataTempMajor_updatePSDETEIUDetail(pSDETEIUpdate, pSDETEIUpdate2, arrayList);
        super.updateRelatedDataTempMajor(pSDETEIUpdate, pSDETEIUpdate2);
    }

    protected ArrayList<PSDETEIUDetail> updateRelatedDataTempMajor_removePSDETEIUDetail(PSDETEIUpdate pSDETEIUpdate, PSDETEIUpdate pSDETEIUpdate2) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUDetail> arrayList = pSDETEIUDetailService.selectTempByPSDETEIUpdate(pSDETEIUpdate);
        ArrayList<PSDETEIUDetail> arrayList2 = pSDETEIUDetailService.selectByPSDETEIUpdate(pSDETEIUpdate2);
        HashMap<String, PSDETEIUDetail> hashMap = new HashMap<String, PSDETEIUDetail>();
        for (PSDETEIUDetail pSDETEIUDetail : arrayList2) {
            hashMap.put(pSDETEIUDetail.getPSDETEIUDetailId(), pSDETEIUDetail);
        }
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            Object object = pSDETEIUDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDETEIUDetail pSDETEIUDetail : hashMap.values()) {
            pSDETEIUDetailService.remove(pSDETEIUDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDETEIUDetail(PSDETEIUpdate pSDETEIUpdate, PSDETEIUpdate pSDETEIUpdate2, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            pSDETEIUDetailService.updateTempMajor(pSDETEIUDetail);
        }
    }

    protected void replaceParentInfo(PSDETEIUpdate pSDETEIUpdate, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDETEIUpdate, cloneSession);
        if (pSDETEIUpdate.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDETEIUpdate.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDETEIUpdate, (PSDEAction)iEntity);
        }
        if (pSDETEIUpdate.getPSDETreeNodeId() != null && (iEntity = cloneSession.getEntity("PSDETREENODE", (Object)pSDETEIUpdate.getPSDETreeNodeId())) != null) {
            this.onFillParentInfo_PSDETreeNode(pSDETEIUpdate, (PSDETreeNode)iEntity);
        }
        if (pSDETEIUpdate.getPSDETreeViewId() != null && (iEntity = cloneSession.getEntity("PSDETREEVIEW", (Object)pSDETEIUpdate.getPSDETreeViewId())) != null) {
            this.onFillParentInfo_PSDETreeView(pSDETEIUpdate, (PSDETreeView)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDETEIUpdate pSDETEIUpdate, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDETEIUpdate, bl);
    }

    protected void onCheckEntity(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BusyIndicator(bl, pSDETEIUpdate, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETEIUpdateId(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETEIUpdateName(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeId(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDETEIUpdate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDETEIUpdate, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isBusyIndicatorDirty() : !pSDETEIUpdate.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDETEIUpdate.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default(pSDETEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isCodeNameDirty() && !bl2 : !pSDETEIUpdate.isCodeNameDirty()) {
            return null;
        }
        String string = pSDETEIUpdate.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDETEIUpdate, bl2, bl3);
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
                string3 = "PSDETREENODEID";
                String string4 = this.checkFieldDupRule(this.getPSDETEIUpdateDEModel(), "CODENAME", string3, pSDETEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isCustomCodeDirty() : !pSDETEIUpdate.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDETEIUpdate.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDETEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isCustomModeDirty() : !pSDETEIUpdate.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDETEIUpdate.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDETEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isMemoDirty() : !pSDETEIUpdate.isMemoDirty()) {
            return null;
        }
        String string = pSDETEIUpdate.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDETEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isPSDEActionIdDirty() : !pSDETEIUpdate.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDETEIUpdate.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSDETEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETEIUpdateId(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isPSDETEIUpdateIdDirty() && !bl2 : !pSDETEIUpdate.isPSDETEIUpdateIdDirty()) {
            return null;
        }
        String string = pSDETEIUpdate.getPSDETEIUpdateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETEIUPDATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETEIUpdateId_Default(pSDETEIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETEIUPDATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETEIUpdateName(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isPSDETEIUpdateNameDirty() && !bl2 : !pSDETEIUpdate.isPSDETEIUpdateNameDirty()) {
            return null;
        }
        String string = pSDETEIUpdate.getPSDETEIUpdateName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETEIUPDATENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETEIUpdateName_Default(pSDETEIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETEIUPDATENAME");
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
                string3 = "PSDETREENODEID";
                String string4 = this.checkFieldDupRule(this.getPSDETEIUpdateDEModel(), "PSDETEIUPDATENAME", string3, pSDETEIUpdate, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDETEIUPDATENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeId(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isPSDETreeNodeIdDirty() : !pSDETEIUpdate.isPSDETreeNodeIdDirty()) {
            return null;
        }
        String string = pSDETEIUpdate.getPSDETreeNodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeId_Default(pSDETEIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isPSDETreeViewIdDirty() && !bl2 : !pSDETEIUpdate.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSDETEIUpdate.getPSDETreeViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREEVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default(pSDETEIUpdate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isUserTagDirty() : !pSDETEIUpdate.isUserTagDirty()) {
            return null;
        }
        String string = pSDETEIUpdate.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDETEIUpdate, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDETEIUpdate pSDETEIUpdate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUpdate.isUserTag2Dirty() : !pSDETEIUpdate.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDETEIUpdate.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDETEIUpdate, bl2, bl3);
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

    protected void onSyncEntity(PSDETEIUpdate pSDETEIUpdate, boolean bl) throws Exception {
        super.onSyncEntity(pSDETEIUpdate, bl);
    }

    protected void onSyncIndexEntities(PSDETEIUpdate pSDETEIUpdate, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDETEIUpdate, bl);
    }

    public Object getDataContextValue(PSDETEIUpdate pSDETEIUpdate, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDETEIUpdate, string, iDataContextParam)) != null) {
            return object;
        }
        PSDETreeNode pSDETreeNode = pSDETEIUpdate.getPSDETreeNode();
        if (pSDETreeNode != null && pSDETreeNode.contains(string)) {
            return pSDETreeNode.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDETEIUpdate pSDETEIUpdate, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDETEIUpdate, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETEIUPDATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETEIUpdateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETEIUPDATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETEIUpdateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDETEIUpdateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETEIUPDATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETEIUpdateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETEIUPDATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDETEIUpdate pSDETEIUpdate) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDETEIUpdate)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        super.onUpdateParent(pSDETEIUpdate);
    }

    @Override
    protected void exportCurXmlModel(PSDETEIUpdate pSDETEIUpdate, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETEIUPDATE");
        if (!bl) {
            pSDETEIUpdate.setCreateDate(null);
            pSDETEIUpdate.setCreateMan(null);
            pSDETEIUpdate.setPSDETEIUpdateId(null);
            pSDETEIUpdate.setUpdateDate(null);
            pSDETEIUpdate.setUpdateMan(null);
            pSDETEIUpdate.setPSDEId(null);
            pSDETEIUpdate.setPSDETreeNodeId(null);
            pSDETEIUpdate.setPSDETreeViewId(null);
            pSDETEIUpdate.setPSDETreeViewName(null);
            super.exportCurXmlModel(pSDETEIUpdate, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDETEIUpdate pSDETEIUpdate, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDETEIUDetail(pSDETEIUpdate, xmlNode);
        super.onExportRelatedXmlModel(pSDETEIUpdate, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDETEIUDetail(PSDETEIUpdate pSDETEIUpdate, XmlNode xmlNode) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUDetail> arrayList = null;
        String string = pSDETEIUpdate.getPSDETEIUpdateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETEIUDetailService.selectByPSDETEIUpdate(pSDETEIUpdate) : pSDETEIUDetailService.selectTempByPSDETEIUpdate(pSDETEIUpdate);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDETEIUDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
                pSDETEIUDetailService.exportXmlModel(pSDETEIUDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDETEIUpdate pSDETEIUpdate, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDETEIUDETAILS");
        this.importRelatedXmlModel_PSDETEIUDetail(pSDETEIUpdate, xmlNode2);
        super.onImportRelatedXmlModel(pSDETEIUpdate, xmlNode);
    }

    protected void importRelatedXmlModel_PSDETEIUDetail(PSDETEIUpdate pSDETEIUpdate, XmlNode xmlNode) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDETEIUpdate.getPSDETEIUpdateId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDETEIUDetailService.removeByPSDETEIUpdate(pSDETEIUpdate);
        } else {
            pSDETEIUDetailService.removeTempByPSDETEIUpdate(pSDETEIUpdate);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDETEIUDetail pSDETEIUDetail = new PSDETEIUDetail();
                pSDETEIUDetailService.fillParentInfo(pSDETEIUDetail, "DER1N", "DER1N_PSDETEIUDETAIL_PSDETEIUPDATE_PSDETEIUPDATEID", pSDETEIUpdate.getPSDETEIUpdateId());
                pSDETEIUDetailService.importXmlModel(pSDETEIUDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDETEIUpdate pSDETEIUpdate, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDETEIUpdate, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREENODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDETREENODE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREEVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREENODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETEIUPDATE_PSDETREENODE_PSDETREENODEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREEVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETEIUPDATE_PSDETREEVIEW_PSDETREEVIEWID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREENODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREENODENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREEVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREEVIEWNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDETREENODE", (boolean)true) == 0) {
            iEntity.set("PSDETREENODEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEW", (boolean)true) == 0) {
            iEntity.set("PSDETREEVIEWID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDETREENODEID", "PSDETREEVIEWID"};
    }

    @Override
    public String getModelV2Tag(PSDETEIUpdate pSDETEIUpdate) {
        if (!StringHelper.isNullOrEmpty((String)pSDETEIUpdate.getPSDETEIUpdateName())) {
            return pSDETEIUpdate.getPSDETEIUpdateName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDETEIUpdate.getCodeName())) {
            return pSDETEIUpdate.getCodeName();
        }
        return super.getModelV2Tag(pSDETEIUpdate);
    }

    @Override
    public boolean setModelV2Tag(PSDETEIUpdate pSDETEIUpdate, String string) {
        pSDETEIUpdate.setPSDETEIUpdateName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDETEIUPDATENAME", "");
        map.put("CODENAME", "");
        map.put("PSDETREENODEID", "");
        map.put("PSDETREEVIEWID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDETEIUpdate pSDETEIUpdate, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDETEIUpdate.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDETEIUpdate, true);
        pSDETEIUpdate.set("PSDETEIUPDATENAME", string);
        if (this.select(pSDETEIUpdate, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDETEIUpdate, true);
        return super.getModelV2Entity(pSDETEIUpdate, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDETEIUpdate pSDETEIUpdate, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDETEIUpdate.getPSDETreeNodeId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDETEIUpdate.getPSDETreeViewId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdetreeviewid")) {
            objectNode.put("psdetreeviewid", "<PSDETREEVIEW>");
        }
        return super.testCompileCurModelV2(pSDETEIUpdate, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDETEIUpdate pSDETEIUpdate, String string, Map<String, String> map) throws Exception {
        if (PSDETEIUpdateServiceBase.isSimpleImportExportMode()) {
            map.put("PSDETREENODEID", "");
            map.put("PSDETREEVIEWID", "");
        }
        return super.onFillModelV2(objectNode, pSDETEIUpdate, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDETEIUDETAIL_PSDETEIUPDATE_PSDETEIUPDATEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDETEIUpdate pSDETEIUpdate, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDETEIUpdate, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDETEIUpdate pSDETEIUpdate, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETEIUDETAIL_PSDETEIUPDATE_PSDETEIUPDATEID")) {
            PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETEIUPDATE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETEIUDETAIL", (Object)pSDETEIUpdate.getPSDETEIUpdateId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String detailJson : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)detailJson)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(detailJson));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String resScope = StringHelper.format((String)"PSDETEIUPDATE#%1$s", (Object)pSDETEIUpdate.getPSDETEIUpdateId());
                for (PSDETEIUDetail detail : pSDETEIUDetailService.selectByPSDETEIUpdate(pSDETEIUpdate)) {
                    String detailScope = pSDETEIUDetailService.getModelV2ResScope(detail);
                    if (StringHelper.compare(resScope, detailScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(detail, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode detailsNode = objectNode.putArray(pSDETEIUDetailService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdetreenodecolname")) {
                            string = objectNode.get("psdetreenodecolname").asText();
                        }
                        if (objectNode2.has("psdetreenodecolname")) {
                            string2 = objectNode2.get("psdetreenodecolname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode detailNode : arrayList) {
                    PSDETEIUDetail detail = new PSDETEIUDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)detail, detailNode, false);
                    detailsNode.add((JsonNode)pSDETEIUDetailService.exportModelV2(detail, string));
                }
            }
        }
        super.onExportCurModelV2(pSDETEIUpdate, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUDetail> arrayList = pSDETEIUDetailService.selectByPSDETEIUpdate(pSDETEIUpdate);
        String string = StringHelper.format((String)"PSDETEIUPDATE#%1$s", (Object)pSDETEIUpdate.getPSDETEIUpdateId());
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            String string2 = pSDETEIUDetailService.getModelV2ResScope(pSDETEIUDetail);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDETEIUDetailService.emptyModelV2(pSDETEIUDetail);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDETEIUpdate.getPSDETEIUpdateId());
        pSDETEIUDetailService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDETEIUDetailService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETEIUDETAIL WHERE PSDETEIUPDATEID = ?", sqlParamList);
        super.onEmptyModelV2(pSDETEIUpdate);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSDETEIUDetailService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDETEIUpdate pSDETEIUpdate, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDETEIUDetail pSDETEIUDetail = new PSDETEIUDetail();
        pSDETEIUDetail.set("PSDETEIUPDATEID", pSDETEIUpdate.getPSDETEIUpdateId());
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDETEIUDetailService.getModelV2Entity(pSDETEIUDetail, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDETEIUpdate, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDETEIUpdate pSDETEIUpdate, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDETEIUDetailService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDETEIUDetail pSDETEIUDetail = new PSDETEIUDetail();
                pSDETEIUDetail.setPSDETEIUpdateId(pSDETEIUpdate.getPSDETEIUpdateId());
                pSDETEIUDetail.setPSDETEIUpdateName(pSDETEIUpdate.getPSDETEIUpdateName());
                pSDETEIUDetail.setPSDETreeNodeId(pSDETEIUpdate.getPSDETreeNodeId());
                pSDETEIUDetailService.compileModelV2(pSDETEIUDetail, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDETEIUDetail pSDETEIUDetail = new PSDETEIUDetail();
                    pSDETEIUDetail.setPSDETEIUpdateId(pSDETEIUpdate.getPSDETEIUpdateId());
                    pSDETEIUDetail.setPSDETEIUpdateName(pSDETEIUpdate.getPSDETEIUpdateName());
                    pSDETEIUDetail.setPSDETreeNodeId(pSDETEIUpdate.getPSDETreeNodeId());
                    pSDETEIUDetailService.compileModelV2(pSDETEIUDetail, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDETEIUpdate, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDETEIUpdate pSDETEIUpdate, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDETEIUDETAIL_PSDETEIUPDATE_PSDETEIUPDATEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDETEIUDetails(pSDETEIUpdate, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDETEIUpdate, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDETEIUDetails(PSDETEIUpdate pSDETEIUpdate, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDETEIUDETAIL", true), (boolean)false) == 0) {
            PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDETEIUDetail pSDETEIUDetail = new PSDETEIUDetail();
            pSDETEIUDetail.setPSDETEIUDetailId(pSMOSFile.getPSModelId());
            if (!pSDETEIUDetailService.get(pSDETEIUDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDETEIUDetail.getPSDETEIUpdateId(), (String)pSDETEIUpdate.getPSDETEIUpdateId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDETEIUDetailService.exportModelV2(pSDETEIUDetail);
            pSDETEIUDetail.reset();
            if (!pSDETEIUDetailService.setModelV2ResScope(pSDETEIUDetail, "PSDETEIUPDATE", pSDETEIUpdate.getPSDETEIUpdateId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDETEIUDetailService.importModelV2(pSDETEIUDetail, objectNode);
            SessionFactoryManager.commit();
            return pSDETEIUDetailService.getFile(pSDETEIUDetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDETEIUpdate pSDETEIUpdate, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDETEIUDetails(pSDETEIUpdate, list);
        super.onFillPasteHelps(pSDETEIUpdate, list);
    }

    protected void onFillPasteHelps_PSDETEIUDetails(PSDETEIUpdate pSDETEIUpdate, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDETEIUDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDETEIUDETAIL_PSDETEIUPDATE_PSDETEIUPDATEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6811\u8868\u7f16\u8f91\u9879\u66f4\u65b0\u6a21\u5f0f]\u7684[\u6811\u8868\u7f16\u8f91\u9879\u66f4\u65b0\u6210\u5458]");
        list.add(pSHelpSection);
    }
}

