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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDETreeNodeRSDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeNodeRSDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeRS;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeViewBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeNodeRSServiceBase
extends PSCoreSysServiceBase<PSDETreeNodeRS> {
    private static final Log log = LogFactory.getLog(PSDETreeNodeRSServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDETreeNodeRSDEModel pSDETreeNodeRSDEModel;
    private PSDETreeNodeRSDAO pSDETreeNodeRSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSService";
    }

    public PSDETreeNodeRSDEModel getPSDETreeNodeRSDEModel() {
        if (this.pSDETreeNodeRSDEModel == null) {
            try {
                this.pSDETreeNodeRSDEModel = (PSDETreeNodeRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeNodeRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeNodeRSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDETreeNodeRSDEModel();
    }

    public PSDETreeNodeRSDAO getPSDETreeNodeRSDAO() {
        if (this.pSDETreeNodeRSDAO == null) {
            try {
                this.pSDETreeNodeRSDAO = (PSDETreeNodeRSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDETreeNodeRSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeNodeRSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDETreeNodeRSDAO();
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

    protected void onFillParentInfo(PSDETreeNodeRS pSDETreeNodeRS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODERS_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDETreeNodeRS, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODERS_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSDETreeNodeRS, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODERS_PSDETREENODE_CPSDETREENODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService", (SessionFactory)this.getSessionFactory());
            PSDETreeNode pSDETreeNode = (PSDETreeNode)iService.getDEModel().createEntity();
            pSDETreeNode.set("PSDETREENODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeNode);
            } else {
                iService.get(pSDETreeNode);
            }
            this.onFillParentInfo_CPSDETreeNode(pSDETreeNodeRS, pSDETreeNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODERS_PSDETREENODE_PPSDETREENODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService", (SessionFactory)this.getSessionFactory());
            PSDETreeNode pSDETreeNode = (PSDETreeNode)iService.getDEModel().createEntity();
            pSDETreeNode.set("PSDETREENODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeNode);
            } else {
                iService.get(pSDETreeNode);
            }
            this.onFillParentInfo_PPSDETreeNode(pSDETreeNodeRS, pSDETreeNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODERS_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeView);
            } else {
                iService.get(pSDETreeView);
            }
            this.onFillParentInfo_PSDETreeView(pSDETreeNodeRS, pSDETreeView);
            return;
        }
        super.onFillParentInfo(pSDETreeNodeRS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDETREENODERS_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", string2);
            return this.onSyncDER1NData_PSDETreeView(pSDETreeView, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEAction(PSDETreeNodeRS pSDETreeNodeRS, PSDEAction pSDEAction) throws Exception {
        pSDETreeNodeRS.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDETreeNodeRS.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDER(PSDETreeNodeRS pSDETreeNodeRS, PSDER pSDER) throws Exception {
        pSDETreeNodeRS.setPSDERId(pSDER.getPSDERId());
        pSDETreeNodeRS.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_CPSDETreeNode(PSDETreeNodeRS pSDETreeNodeRS, PSDETreeNode pSDETreeNode) throws Exception {
        pSDETreeNodeRS.setCPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
        pSDETreeNodeRS.setCPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
        if (pSDETreeNode.getPSDETreeView() != null) {
            this.onFillParentInfo_PSDETreeView(pSDETreeNodeRS, pSDETreeNode.getPSDETreeView());
        }
    }

    protected void onFillParentInfo_PPSDETreeNode(PSDETreeNodeRS pSDETreeNodeRS, PSDETreeNode pSDETreeNode) throws Exception {
        pSDETreeNodeRS.setPPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
        pSDETreeNodeRS.setPPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
        if (pSDETreeNode.getPSDETreeView() != null) {
            this.onFillParentInfo_PSDETreeView(pSDETreeNodeRS, pSDETreeNode.getPSDETreeView());
        }
    }

    protected void onFillParentInfo_PSDETreeView(PSDETreeNodeRS pSDETreeNodeRS, PSDETreeView pSDETreeView) throws Exception {
        pSDETreeNodeRS.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
        pSDETreeNodeRS.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
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
            ArrayList<PSDETreeNodeRS> arrayList = this.selectByPSDETreeView(pSDETreeView);
            for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDETreeNodeRS, (String)"PSDETREENODERSID", (String)""))) continue;
                this.remove(pSDETreeNodeRS);
            }
        }
        return null;
    }

    protected void onFillEntityFullInfo(PSDETreeNodeRS pSDETreeNodeRS, boolean bl) throws Exception {
        if (bl) {
            if (pSDETreeNodeRS.getCustomMode() == null) {
                pSDETreeNodeRS.setCustomMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDETreeNodeRS.getSearchMode() == null) {
                pSDETreeNodeRS.setSearchMode((Integer)this.getDefaultValue(this.getWebContext(), "", "3", 9));
            }
            if (pSDETreeNodeRS.getValidFlag() == null) {
                pSDETreeNodeRS.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDETreeNodeRS, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDETreeNodeRS, bl);
        this.onFillEntityFullInfo_PSDER(pSDETreeNodeRS, bl);
        this.onFillEntityFullInfo_CPSDETreeNode(pSDETreeNodeRS, bl);
        this.onFillEntityFullInfo_PPSDETreeNode(pSDETreeNodeRS, bl);
        this.onFillEntityFullInfo_PSDETreeView(pSDETreeNodeRS, bl);
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDETreeNodeRS pSDETreeNodeRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDER(PSDETreeNodeRS pSDETreeNodeRS, boolean bl) throws Exception {
        if (pSDETreeNodeRS.isPSDERIdDirty()) {
            if (pSDETreeNodeRS.getPSDERId() != null) {
                if (pSDETreeNodeRS.getPSDERId() == null || pSDETreeNodeRS.getPSDERName() == null) {
                    PSDER pSDER = pSDETreeNodeRS.getPSDER();
                    pSDETreeNodeRS.setPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDETreeNodeRS.setPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CPSDETreeNode(PSDETreeNodeRS pSDETreeNodeRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSDETreeNode(PSDETreeNodeRS pSDETreeNodeRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeView(PSDETreeNodeRS pSDETreeNodeRS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDETreeNodeRS pSDETreeNodeRS, boolean bl) throws Exception {
        super.onWriteBackParent(pSDETreeNodeRS, bl);
    }

    public ArrayList<PSDETreeNodeRS> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDETreeNodeRS> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDETreeNodeRS> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNodeRS> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDETreeNodeRS> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDETreeNodeRS> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeRS> selectByCPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectByCPSDETreeNode(pSDETreeNodeBase, "", -1);
    }

    public ArrayList<PSDETreeNodeRS> selectByCPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        return this.selectByCPSDETreeNode(pSDETreeNodeBase, string, -1);
    }

    public ArrayList<PSDETreeNodeRS> selectByCPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CPSDETREENODEID", (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCPSDETreeNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCPSDETreeNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeRS> selectTempByCPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectTempByCPSDETreeNode(pSDETreeNodeBase, "");
    }

    public ArrayList<PSDETreeNodeRS> selectTempByCPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CPSDETREENODEID", (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByCPSDETreeNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByCPSDETreeNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeRS> selectByPPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectByPPSDETreeNode(pSDETreeNodeBase, "", -1);
    }

    public ArrayList<PSDETreeNodeRS> selectByPPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        return this.selectByPPSDETreeNode(pSDETreeNodeBase, string, -1);
    }

    public ArrayList<PSDETreeNodeRS> selectByPPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDETREENODEID", (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDETreeNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDETreeNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeRS> selectTempByPPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectTempByPPSDETreeNode(pSDETreeNodeBase, "");
    }

    public ArrayList<PSDETreeNodeRS> selectTempByPPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDETREENODEID", (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSDETreeNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSDETreeNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeRS> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, "", -1);
    }

    public ArrayList<PSDETreeNodeRS> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, string, -1);
    }

    public ArrayList<PSDETreeNodeRS> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNodeRS> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectTempByPSDETreeView(pSDETreeViewBase, "");
    }

    public ArrayList<PSDETreeNodeRS> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREEVIEWID", (Object)pSDETreeViewBase.getPSDETreeViewId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeViewCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeViewCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODERS_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSDETREENODERS", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            PSDETreeNodeRS pSDETreeNodeRS2 = (PSDETreeNodeRS)this.getDEModel().createEntity();
            pSDETreeNodeRS2.setPSDETreeNodeRSId(pSDETreeNodeRS.getPSDETreeNodeRSId());
            pSDETreeNodeRS2.setPSDEActionId(null);
            this.update(pSDETreeNodeRS2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRSServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDETreeNodeRSServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDETreeNodeRSServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            this.remove(pSDETreeNodeRS);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODERS_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSDETREENODERS", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPSDER(pSDER);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            PSDETreeNodeRS pSDETreeNodeRS2 = (PSDETreeNodeRS)this.getDEModel().createEntity();
            pSDETreeNodeRS2.setPSDETreeNodeRSId(pSDETreeNodeRS.getPSDETreeNodeRSId());
            pSDETreeNodeRS2.setPSDERId(null);
            this.update(pSDETreeNodeRS2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRSServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDETreeNodeRSServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDETreeNodeRSServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            this.remove(pSDETreeNodeRS);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    public void testRemoveByCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByCPSDETreeNode(pSDETreeNode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETREENODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDETreeNode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODERS_PSDETREENODE_CPSDETREENODEID", "", iDataEntityModel.getName(), "PSDETREENODERS", iDataEntityModel.getDataInfo(pSDETreeNode), arrayList.get(0)));
        }
    }

    public void resetCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByCPSDETreeNode(pSDETreeNode);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            PSDETreeNodeRS pSDETreeNodeRS2 = (PSDETreeNodeRS)this.getDEModel().createEntity();
            pSDETreeNodeRS2.setPSDETreeNodeRSId(pSDETreeNodeRS.getPSDETreeNodeRSId());
            pSDETreeNodeRS2.setCPSDETreeNodeId(null);
            this.update(pSDETreeNodeRS2);
        }
    }

    public void resetTempCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectTempByCPSDETreeNode(pSDETreeNode);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            PSDETreeNodeRS pSDETreeNodeRS2 = (PSDETreeNodeRS)this.getDEModel().createEntity();
            pSDETreeNodeRS2.setPSDETreeNodeRSId(pSDETreeNodeRS.getPSDETreeNodeRSId());
            pSDETreeNodeRS2.setCPSDETreeNodeId(null);
            this.updateTemp(pSDETreeNodeRS2);
        }
    }

    public void removeByCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRSServiceBase.this.onBeforeRemoveByCPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRSServiceBase.this.internalRemoveByCPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRSServiceBase.this.onAfterRemoveByCPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveByCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveByCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByCPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveByCPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            this.remove(pSDETreeNodeRS);
        }
        this.onAfterRemoveByCPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveByCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveByCPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    public void testRemoveByPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPPSDETreeNode(pSDETreeNode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETREENODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDETreeNode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODERS_PSDETREENODE_PPSDETREENODEID", "", iDataEntityModel.getName(), "PSDETREENODERS", iDataEntityModel.getDataInfo(pSDETreeNode), arrayList.get(0)));
        }
    }

    public void resetPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPPSDETreeNode(pSDETreeNode);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            PSDETreeNodeRS pSDETreeNodeRS2 = (PSDETreeNodeRS)this.getDEModel().createEntity();
            pSDETreeNodeRS2.setPSDETreeNodeRSId(pSDETreeNodeRS.getPSDETreeNodeRSId());
            pSDETreeNodeRS2.setPPSDETreeNodeId(null);
            this.update(pSDETreeNodeRS2);
        }
    }

    public void resetTempPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectTempByPPSDETreeNode(pSDETreeNode);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            PSDETreeNodeRS pSDETreeNodeRS2 = (PSDETreeNodeRS)this.getDEModel().createEntity();
            pSDETreeNodeRS2.setPSDETreeNodeRSId(pSDETreeNodeRS.getPSDETreeNodeRSId());
            pSDETreeNodeRS2.setPPSDETreeNodeId(null);
            this.updateTemp(pSDETreeNodeRS2);
        }
    }

    public void removeByPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRSServiceBase.this.onBeforeRemoveByPPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRSServiceBase.this.internalRemoveByPPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRSServiceBase.this.onAfterRemoveByPPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveByPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveByPPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            this.remove(pSDETreeNodeRS);
        }
        this.onAfterRemoveByPPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveByPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveByPPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    public void resetPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPSDETreeView(pSDETreeView);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            PSDETreeNodeRS pSDETreeNodeRS2 = (PSDETreeNodeRS)this.getDEModel().createEntity();
            pSDETreeNodeRS2.setPSDETreeNodeRSId(pSDETreeNodeRS.getPSDETreeNodeRSId());
            pSDETreeNodeRS2.setPSDETreeViewId(null);
            this.update(pSDETreeNodeRS2);
        }
    }

    public void resetTempPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            PSDETreeNodeRS pSDETreeNodeRS2 = (PSDETreeNodeRS)this.getDEModel().createEntity();
            pSDETreeNodeRS2.setPSDETreeNodeRSId(pSDETreeNodeRS.getPSDETreeNodeRSId());
            pSDETreeNodeRS2.setPSDETreeViewId(null);
            this.updateTemp(pSDETreeNodeRS2);
        }
    }

    public void removeByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRSServiceBase.this.onBeforeRemoveByPSDETreeView(pSDETreeView2);
                PSDETreeNodeRSServiceBase.this.internalRemoveByPSDETreeView(pSDETreeView2);
                PSDETreeNodeRSServiceBase.this.onAfterRemoveByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            this.remove(pSDETreeNodeRS);
        }
        this.onAfterRemoveByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDETreeNodeRS pSDETreeNodeRS) throws Exception {
        super.onBeforeRemove(pSDETreeNodeRS);
    }

    public void removeTempByCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRSServiceBase.this.onBeforeRemoveTempByCPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRSServiceBase.this.internalRemoveTempByCPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRSServiceBase.this.onAfterRemoveTempByCPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveTempByCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveTempByCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectTempByCPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveTempByCPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            this.removeTemp(pSDETreeNodeRS);
        }
        this.onAfterRemoveTempByCPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveTempByCPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveTempByCPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByCPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    public void removeTempByPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRSServiceBase.this.onBeforeRemoveTempByPPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRSServiceBase.this.internalRemoveTempByPPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRSServiceBase.this.onAfterRemoveTempByPPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveTempByPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectTempByPPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveTempByPPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            this.removeTemp(pSDETreeNodeRS);
        }
        this.onAfterRemoveTempByPPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveTempByPPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    public void removeTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRSServiceBase.this.onBeforeRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETreeNodeRSServiceBase.this.internalRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETreeNodeRSServiceBase.this.onAfterRemoveTempByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNodeRS> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveTempByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            this.removeTemp(pSDETreeNodeRS);
        }
        this.onAfterRemoveTempByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDETreeNodeRS pSDETreeNodeRS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDETreeNodeRS, cloneSession);
        if (pSDETreeNodeRS.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDETreeNodeRS.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDETreeNodeRS, (PSDEAction)iEntity);
        }
        if (pSDETreeNodeRS.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDETreeNodeRS.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDETreeNodeRS, (PSDER)iEntity);
        }
        if (pSDETreeNodeRS.getCPSDETreeNodeId() != null && (iEntity = cloneSession.getEntity("PSDETREENODE", (Object)pSDETreeNodeRS.getCPSDETreeNodeId())) != null) {
            this.onFillParentInfo_CPSDETreeNode(pSDETreeNodeRS, (PSDETreeNode)iEntity);
        }
        if (pSDETreeNodeRS.getPPSDETreeNodeId() != null && (iEntity = cloneSession.getEntity("PSDETREENODE", (Object)pSDETreeNodeRS.getPPSDETreeNodeId())) != null) {
            this.onFillParentInfo_PPSDETreeNode(pSDETreeNodeRS, (PSDETreeNode)iEntity);
        }
        if (pSDETreeNodeRS.getPSDETreeViewId() != null && (iEntity = cloneSession.getEntity("PSDETREEVIEW", (Object)pSDETreeNodeRS.getPSDETreeViewId())) != null) {
            this.onFillParentInfo_PSDETreeView(pSDETreeNodeRS, (PSDETreeView)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDETreeNodeRS pSDETreeNodeRS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDETreeNodeRS, bl);
    }

    protected void onCheckEntity(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ChildFilter(bl, pSDETreeNodeRS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ChildFilterDesc(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CMCreate(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CPSDETreeNodeId(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDETreeNodeId(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProcessParam(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERName(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeRSId(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeRSName(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PValueLevel(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchMode(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeFilter(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDETreeNodeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDETreeNodeRS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ChildFilter(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isChildFilterDirty() : !pSDETreeNodeRS.isChildFilterDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getChildFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChildFilter_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILDFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ChildFilterDesc(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isChildFilterDescDirty() : !pSDETreeNodeRS.isChildFilterDescDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getChildFilterDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChildFilterDesc_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILDFILTERDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CMCreate(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isCMCreateDirty() : !pSDETreeNodeRS.isCMCreateDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeRS.getCMCreate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CMCreate_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CMCREATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CPSDETreeNodeId(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isCPSDETreeNodeIdDirty() && !bl2 : !pSDETreeNodeRS.isCPSDETreeNodeIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getCPSDETreeNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPSDETREENODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CPSDETreeNodeId_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPSDETREENODEID");
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
                string3 = "PPSDETREENODEID";
                String string4 = this.checkFieldDupRule(this.getPSDETreeNodeRSDEModel(), "CPSDETREENODEID", string3, pSDETreeNodeRS, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CPSDETREENODEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isCustomCodeDirty() : !pSDETreeNodeRS.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isCustomModeDirty() : !pSDETreeNodeRS.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeRS.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isMemoDirty() : !pSDETreeNodeRS.isMemoDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isOrderValueDirty() : !pSDETreeNodeRS.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeRS.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDETreeNodeId(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isPPSDETreeNodeIdDirty() && !bl2 : !pSDETreeNodeRS.isPPSDETreeNodeIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getPPSDETreeNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDETREENODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDETreeNodeId_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDETREENODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProcessParam(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isProcessParamDirty() : !pSDETreeNodeRS.isProcessParamDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getProcessParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProcessParam_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isPSDEActionIdDirty() : !pSDETreeNodeRS.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isPSDERIdDirty() : !pSDETreeNodeRS.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERName(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isPSDERNameDirty() : !pSDETreeNodeRS.isPSDERNameDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERName_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeRSId(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isPSDETreeNodeRSIdDirty() && !bl2 : !pSDETreeNodeRS.isPSDETreeNodeRSIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getPSDETreeNodeRSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODERSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeRSId_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODERSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeRSName(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isPSDETreeNodeRSNameDirty() : !pSDETreeNodeRS.isPSDETreeNodeRSNameDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getPSDETreeNodeRSName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeRSName_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODERSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isPSDETreeViewIdDirty() : !pSDETreeNodeRS.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getPSDETreeViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PValueLevel(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isPValueLevelDirty() : !pSDETreeNodeRS.isPValueLevelDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeRS.getPValueLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PValueLevel_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PVALUELEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchMode(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isSearchModeDirty() : !pSDETreeNodeRS.isSearchModeDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeRS.getSearchMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SearchMode_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeFilter(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isTypeFilterDirty() : !pSDETreeNodeRS.isTypeFilterDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getTypeFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeFilter_Default(pSDETreeNodeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isUserCatDirty() : !pSDETreeNodeRS.isUserCatDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isUserTagDirty() : !pSDETreeNodeRS.isUserTagDirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isUserTag2Dirty() : !pSDETreeNodeRS.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isUserTag3Dirty() : !pSDETreeNodeRS.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isUserTag4Dirty() : !pSDETreeNodeRS.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDETreeNodeRS.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDETreeNodeRS pSDETreeNodeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRS.isValidFlagDirty() : !pSDETreeNodeRS.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeRS.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDETreeNodeRS, bl2, bl3);
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

    protected void onSyncEntity(PSDETreeNodeRS pSDETreeNodeRS, boolean bl) throws Exception {
        super.onSyncEntity(pSDETreeNodeRS, bl);
    }

    protected void onSyncIndexEntities(PSDETreeNodeRS pSDETreeNodeRS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDETreeNodeRS, bl);
    }

    public Object getDataContextValue(PSDETreeNodeRS pSDETreeNodeRS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDETreeNodeRS, string, iDataContextParam)) != null) {
            return object;
        }
        PSDETreeView pSDETreeView = pSDETreeNodeRS.getPSDETreeView();
        if (pSDETreeView != null && pSDETreeView.contains(string)) {
            return pSDETreeView.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDETreeNodeRS pSDETreeNodeRS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDETreeNodeRS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CHILDFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ChildFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILDFILTERDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ChildFilterDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CMCREATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CMCreate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPSDETREENODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSDETreeNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPSDETREENODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSDETreeNodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDETREENODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDETreeNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDETREENODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDETreeNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROCESSPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProcessParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODERSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeRSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODERSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeRSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PVALUELEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PValueLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeFilter_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ChildFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CHILDFILTER", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ChildFilterDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CHILDFILTERDESC", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CMCreate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CPSDETreeNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSDETREENODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CPSDETreeNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSDETREENODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSDETreeNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDETREENODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDETreeNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDETREENODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProcessParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROCESSPARAM", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeRSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODERSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeRSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODERSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PValueLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SearchMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TypeFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEFILTER", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSDETreeNodeRS pSDETreeNodeRS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDETreeNodeRS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDETreeNodeRS pSDETreeNodeRS) throws Exception {
        super.onUpdateParent(pSDETreeNodeRS);
    }

    @Override
    protected void exportCurXmlModel(PSDETreeNodeRS pSDETreeNodeRS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETREENODERS");
        if (!bl) {
            pSDETreeNodeRS.setCPSDETreeNodeId(null);
            pSDETreeNodeRS.setPPSDETreeNodeId(null);
            pSDETreeNodeRS.setPSDETreeViewId(null);
            pSDETreeNodeRS.setPSDETreeViewName(null);
            super.exportCurXmlModel(pSDETreeNodeRS, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDETreeNodeRS pSDETreeNodeRS, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDETreeNodeRS, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREEVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREEVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETREENODERS_PSDETREEVIEW_PSDETREEVIEWID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREEVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREEVIEWNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEW", (boolean)true) == 0) {
            iEntity.set("PSDETREEVIEWID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDETREEVIEWID"};
    }

    @Override
    public String getModelV2Tag(PSDETreeNodeRS pSDETreeNodeRS) {
        return super.getModelV2Tag(pSDETreeNodeRS);
    }

    @Override
    public boolean setModelV2Tag(PSDETreeNodeRS pSDETreeNodeRS, String string) {
        return super.setModelV2Tag(pSDETreeNodeRS, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDETREEVIEWID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDETreeNodeRS pSDETreeNodeRS, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDETreeNodeRS.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDETreeNodeRS, true);
        return super.getModelV2Entity(pSDETreeNodeRS, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDETreeNodeRS pSDETreeNodeRS, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDETreeNodeRS, objectNode, string, string2, n);
    }
}

