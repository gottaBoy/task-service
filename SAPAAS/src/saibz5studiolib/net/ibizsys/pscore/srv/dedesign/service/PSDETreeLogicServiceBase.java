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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDETreeLogicDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeLogicDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeColBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeLogicServiceBase
extends PSCoreSysServiceBase<PSDETreeLogic> {
    private static final Log log = LogFactory.getLog(PSDETreeLogicServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDETreeLogicDEModel pSDETreeLogicDEModel;
    private PSDETreeLogicDAO pSDETreeLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicService";
    }

    public PSDETreeLogicDEModel getPSDETreeLogicDEModel() {
        if (this.pSDETreeLogicDEModel == null) {
            try {
                this.pSDETreeLogicDEModel = (PSDETreeLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDETreeLogicDEModel();
    }

    public PSDETreeLogicDAO getPSDETreeLogicDAO() {
        if (this.pSDETreeLogicDAO == null) {
            try {
                this.pSDETreeLogicDAO = (PSDETreeLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDETreeLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDETreeLogicDAO();
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

    protected void onFillParentInfo(PSDETreeLogic pSDETreeLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREELOGIC_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDETreeLogic, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREELOGIC_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDETreeLogic, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREELOGIC_PSDETREECOL_PSDETREECOLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService", (SessionFactory)this.getSessionFactory());
            PSDETreeCol pSDETreeCol = (PSDETreeCol)iService.getDEModel().createEntity();
            pSDETreeCol.set("PSDETREECOLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeCol);
            } else {
                iService.get(pSDETreeCol);
            }
            this.onFillParentInfo_PSDETreeCol(pSDETreeLogic, pSDETreeCol);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREELOGIC_PSDETREENODE_PSDETREENODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService", (SessionFactory)this.getSessionFactory());
            PSDETreeNode pSDETreeNode = (PSDETreeNode)iService.getDEModel().createEntity();
            pSDETreeNode.set("PSDETREENODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeNode);
            } else {
                iService.get(pSDETreeNode);
            }
            this.onFillParentInfo_PSDETreeNode(pSDETreeLogic, pSDETreeNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREELOGIC_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeView);
            } else {
                iService.get(pSDETreeView);
            }
            this.onFillParentInfo_PSDETreeView(pSDETreeLogic, pSDETreeView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREELOGIC_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSDETreeLogic, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREELOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDETreeLogic, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREELOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewLogic pSSysViewLogic = (PSSysViewLogic)iService.getDEModel().createEntity();
            pSSysViewLogic.set("PSSYSVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewLogic);
            } else {
                iService.get(pSSysViewLogic);
            }
            this.onFillParentInfo_PSSysViewLogic(pSDETreeLogic, pSSysViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREELOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSDETreeLogic, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSDETreeLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDETREELOGIC_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", string2);
            return this.onSyncDER1NData_PSDETreeView(pSDETreeView, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDETreeLogic pSDETreeLogic, PSDataEntity pSDataEntity) throws Exception {
        pSDETreeLogic.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDETreeLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDELogic(PSDETreeLogic pSDETreeLogic, PSDELogic pSDELogic) throws Exception {
        pSDETreeLogic.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDETreeLogic.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDETreeCol(PSDETreeLogic pSDETreeLogic, PSDETreeCol pSDETreeCol) throws Exception {
        pSDETreeLogic.setPSDETreeColId(pSDETreeCol.getPSDETreeColId());
        pSDETreeLogic.setPSDETreeColName(pSDETreeCol.getPSDETreeColName());
    }

    protected void onFillParentInfo_PSDETreeNode(PSDETreeLogic pSDETreeLogic, PSDETreeNode pSDETreeNode) throws Exception {
        pSDETreeLogic.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
        pSDETreeLogic.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
    }

    protected void onFillParentInfo_PSDETreeView(PSDETreeLogic pSDETreeLogic, PSDETreeView pSDETreeView) throws Exception {
        pSDETreeLogic.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
        pSDETreeLogic.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
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
            ArrayList<PSDETreeLogic> arrayList = this.selectByPSDETreeView(pSDETreeView);
            for (PSDETreeLogic pSDETreeLogic : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDETreeLogic, (String)"PSDETREELOGICID", (String)""))) continue;
                this.remove(pSDETreeLogic);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEUIAction(PSDETreeLogic pSDETreeLogic, PSDEUIAction pSDEUIAction) throws Exception {
        pSDETreeLogic.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDETreeLogic.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDETreeLogic pSDETreeLogic, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDETreeLogic.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDETreeLogic.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysViewLogic(PSDETreeLogic pSDETreeLogic, PSSysViewLogic pSSysViewLogic) throws Exception {
        pSDETreeLogic.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
        pSDETreeLogic.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSDETreeLogic pSDETreeLogic, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDETreeLogic.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDETreeLogic.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
        if (bl && pSDETreeLogic.getValidFlag() == null) {
            pSDETreeLogic.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDETreeLogic, bl);
        this.onFillEntityFullInfo_PSDE(pSDETreeLogic, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDETreeLogic, bl);
        this.onFillEntityFullInfo_PSDETreeCol(pSDETreeLogic, bl);
        this.onFillEntityFullInfo_PSDETreeNode(pSDETreeLogic, bl);
        this.onFillEntityFullInfo_PSDETreeView(pSDETreeLogic, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSDETreeLogic, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDETreeLogic, bl);
        this.onFillEntityFullInfo_PSSysViewLogic(pSDETreeLogic, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSDETreeLogic, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
        if (pSDETreeLogic.isPSDEIdDirty()) {
            if (pSDETreeLogic.getPSDEId() != null) {
                if (pSDETreeLogic.getPSDEId() == null || pSDETreeLogic.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDETreeLogic.getPSDE();
                    pSDETreeLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDETreeLogic.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeCol(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeNode(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeView(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewLogic(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSDETreeLogic, bl);
    }

    public ArrayList<PSDETreeLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeLogic> selectByPSDETreeCol(PSDETreeColBase pSDETreeColBase) throws Exception {
        return this.selectByPSDETreeCol(pSDETreeColBase, "", -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDETreeCol(PSDETreeColBase pSDETreeColBase, String string) throws Exception {
        return this.selectByPSDETreeCol(pSDETreeColBase, string, -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDETreeCol(PSDETreeColBase pSDETreeColBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREECOLID", (Object)pSDETreeColBase.getPSDETreeColId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETreeColCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETreeColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeLogic> selectTempByPSDETreeCol(PSDETreeColBase pSDETreeColBase) throws Exception {
        return this.selectTempByPSDETreeCol(pSDETreeColBase, "");
    }

    public ArrayList<PSDETreeLogic> selectTempByPSDETreeCol(PSDETreeColBase pSDETreeColBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREECOLID", (Object)pSDETreeColBase.getPSDETreeColId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeColCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeLogic> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectByPSDETreeNode(pSDETreeNodeBase, "", -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        return this.selectByPSDETreeNode(pSDETreeNodeBase, string, -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeLogic> selectTempByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectTempByPSDETreeNode(pSDETreeNodeBase, "");
    }

    public ArrayList<PSDETreeLogic> selectTempByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREENODEID", (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeLogic> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, "", -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, string, -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeLogic> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectTempByPSDETreeView(pSDETreeViewBase, "");
    }

    public ArrayList<PSDETreeLogic> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREEVIEWID", (Object)pSDETreeViewBase.getPSDETreeViewId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeViewCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUIACTIONID", (Object)pSDEUIActionBase.getPSDEUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, "", -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, string, -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWLOGICID", (Object)pSSysViewLogicBase.getPSSysViewLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDETreeLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREELOGIC_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDETREELOGIC", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSDEId(null);
            this.update(pSDETreeLogic2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDETreeLogicServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDETreeLogicServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.remove(pSDETreeLogic);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREELOGIC_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDETREELOGIC", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSDELogicId(null);
            this.update(pSDETreeLogic2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDETreeLogicServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDETreeLogicServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.remove(pSDETreeLogic);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDETreeCol(pSDETreeCol, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETREECOL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDETreeCol);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREELOGIC_PSDETREECOL_PSDETREECOLID", "", iDataEntityModel.getName(), "PSDETREELOGIC", iDataEntityModel.getDataInfo(pSDETreeCol), arrayList.get(0)));
        }
    }

    public void resetPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDETreeCol(pSDETreeCol);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSDETreeColId(null);
            this.update(pSDETreeLogic2);
        }
    }

    public void resetTempPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectTempByPSDETreeCol(pSDETreeCol);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSDETreeColId(null);
            this.updateTemp(pSDETreeLogic2);
        }
    }

    public void removeByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        final PSDETreeCol pSDETreeCol2 = pSDETreeCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveByPSDETreeCol(pSDETreeCol2);
                PSDETreeLogicServiceBase.this.internalRemoveByPSDETreeCol(pSDETreeCol2);
                PSDETreeLogicServiceBase.this.onAfterRemoveByPSDETreeCol(pSDETreeCol2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
    }

    protected void internalRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDETreeCol(pSDETreeCol);
        this.onBeforeRemoveByPSDETreeCol(pSDETreeCol, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.remove(pSDETreeLogic);
        }
        this.onAfterRemoveByPSDETreeCol(pSDETreeCol, arrayList);
    }

    protected void onAfterRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDETreeNode(pSDETreeNode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETREENODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDETreeNode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREELOGIC_PSDETREENODE_PSDETREENODEID", "", iDataEntityModel.getName(), "PSDETREELOGIC", iDataEntityModel.getDataInfo(pSDETreeNode), arrayList.get(0)));
        }
    }

    public void resetPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDETreeNode(pSDETreeNode);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSDETreeNodeId(null);
            this.update(pSDETreeLogic2);
        }
    }

    public void resetTempPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectTempByPSDETreeNode(pSDETreeNode);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSDETreeNodeId(null);
            this.updateTemp(pSDETreeLogic2);
        }
    }

    public void removeByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveByPSDETreeNode(pSDETreeNode2);
                PSDETreeLogicServiceBase.this.internalRemoveByPSDETreeNode(pSDETreeNode2);
                PSDETreeLogicServiceBase.this.onAfterRemoveByPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveByPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.remove(pSDETreeLogic);
        }
        this.onAfterRemoveByPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    public void resetPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDETreeView(pSDETreeView);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSDETreeViewId(null);
            this.update(pSDETreeLogic2);
        }
    }

    public void resetTempPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSDETreeViewId(null);
            this.updateTemp(pSDETreeLogic2);
        }
    }

    public void removeByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveByPSDETreeView(pSDETreeView2);
                PSDETreeLogicServiceBase.this.internalRemoveByPSDETreeView(pSDETreeView2);
                PSDETreeLogicServiceBase.this.onAfterRemoveByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.remove(pSDETreeLogic);
        }
        this.onAfterRemoveByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREELOGIC_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDETREELOGIC", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSDEUIActionId(null);
            this.update(pSDETreeLogic2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSDETreeLogicServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSDETreeLogicServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.remove(pSDETreeLogic);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREELOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDETREELOGIC", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSSysPFPluginId(null);
            this.update(pSDETreeLogic2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDETreeLogicServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDETreeLogicServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.remove(pSDETreeLogic);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREELOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", "", iDataEntityModel.getName(), "PSDETREELOGIC", iDataEntityModel.getDataInfo(pSSysViewLogic), arrayList.get(0)));
        }
    }

    public void resetPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSSysViewLogicId(null);
            this.update(pSDETreeLogic2);
        }
    }

    public void removeByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDETreeLogicServiceBase.this.internalRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDETreeLogicServiceBase.this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.remove(pSDETreeLogic);
        }
        this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREELOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDETREELOGIC", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            PSDETreeLogic pSDETreeLogic2 = (PSDETreeLogic)this.getDEModel().createEntity();
            pSDETreeLogic2.setPSDETreeLogicId(pSDETreeLogic.getPSDETreeLogicId());
            pSDETreeLogic2.setPSSysViewPanelId(null);
            this.update(pSDETreeLogic2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDETreeLogicServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDETreeLogicServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.remove(pSDETreeLogic);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDETreeLogic pSDETreeLogic) throws Exception {
        super.onBeforeRemove(pSDETreeLogic);
    }

    public void removeTempByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        final PSDETreeCol pSDETreeCol2 = pSDETreeCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveTempByPSDETreeCol(pSDETreeCol2);
                PSDETreeLogicServiceBase.this.internalRemoveTempByPSDETreeCol(pSDETreeCol2);
                PSDETreeLogicServiceBase.this.onAfterRemoveTempByPSDETreeCol(pSDETreeCol2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectTempByPSDETreeCol(pSDETreeCol);
        this.onBeforeRemoveTempByPSDETreeCol(pSDETreeCol, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.removeTemp(pSDETreeLogic);
        }
        this.onAfterRemoveTempByPSDETreeCol(pSDETreeCol, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeCol(PSDETreeCol pSDETreeCol, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeCol(PSDETreeCol pSDETreeCol, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    public void removeTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveTempByPSDETreeNode(pSDETreeNode2);
                PSDETreeLogicServiceBase.this.internalRemoveTempByPSDETreeNode(pSDETreeNode2);
                PSDETreeLogicServiceBase.this.onAfterRemoveTempByPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectTempByPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveTempByPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.removeTemp(pSDETreeLogic);
        }
        this.onAfterRemoveTempByPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    public void removeTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeLogicServiceBase.this.onBeforeRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETreeLogicServiceBase.this.internalRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETreeLogicServiceBase.this.onAfterRemoveTempByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveTempByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            this.removeTemp(pSDETreeLogic);
        }
        this.onAfterRemoveTempByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeLogic> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDETreeLogic pSDETreeLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDETreeLogic, cloneSession);
        if (pSDETreeLogic.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDETreeLogic.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDETreeLogic, (PSDataEntity)iEntity);
        }
        if (pSDETreeLogic.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDETreeLogic.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDETreeLogic, (PSDELogic)iEntity);
        }
        if (pSDETreeLogic.getPSDETreeColId() != null && (iEntity = cloneSession.getEntity("PSDETREECOL", (Object)pSDETreeLogic.getPSDETreeColId())) != null) {
            this.onFillParentInfo_PSDETreeCol(pSDETreeLogic, (PSDETreeCol)iEntity);
        }
        if (pSDETreeLogic.getPSDETreeNodeId() != null && (iEntity = cloneSession.getEntity("PSDETREENODE", (Object)pSDETreeLogic.getPSDETreeNodeId())) != null) {
            this.onFillParentInfo_PSDETreeNode(pSDETreeLogic, (PSDETreeNode)iEntity);
        }
        if (pSDETreeLogic.getPSDETreeViewId() != null && (iEntity = cloneSession.getEntity("PSDETREEVIEW", (Object)pSDETreeLogic.getPSDETreeViewId())) != null) {
            this.onFillParentInfo_PSDETreeView(pSDETreeLogic, (PSDETreeView)iEntity);
        }
        if (pSDETreeLogic.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDETreeLogic.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSDETreeLogic, (PSDEUIAction)iEntity);
        }
        if (pSDETreeLogic.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDETreeLogic.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDETreeLogic, (PSSysPFPlugin)iEntity);
        }
        if (pSDETreeLogic.getPSSysViewLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWLOGIC", (Object)pSDETreeLogic.getPSSysViewLogicId())) != null) {
            this.onFillParentInfo_PSSysViewLogic(pSDETreeLogic, (PSSysViewLogic)iEntity);
        }
        if (pSDETreeLogic.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDETreeLogic.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSDETreeLogic, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDETreeLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AttrName(bl, pSDETreeLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstLogicType(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg2(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventNames(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam2(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeColId(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeLogicId(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeLogicName(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeId(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewLogicId(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timer(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TriggerType(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDETreeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDETreeLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AttrName(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isAttrNameDirty() : !pSDETreeLogic.isAttrNameDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getAttrName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrName_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isCustomCodeDirty() : !pSDETreeLogic.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstLogicType(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isDstLogicTypeDirty() && !bl2 : !pSDETreeLogic.isDstLogicTypeDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getDstLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTLOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstLogicType_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTLOGICTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EventArg(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isEventArgDirty() : !pSDETreeLogic.isEventArgDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getEventArg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTARG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EventArg2(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isEventArg2Dirty() : !pSDETreeLogic.isEventArg2Dirty()) {
            return null;
        }
        String string = pSDETreeLogic.getEventArg2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg2_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTARG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EventNames(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isEventNamesDirty() : !pSDETreeLogic.isEventNamesDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getEventNames();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventNames_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTNAMES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicParam(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isLogicParamDirty() : !pSDETreeLogic.isLogicParamDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getLogicParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicParam2(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isLogicParam2Dirty() : !pSDETreeLogic.isLogicParam2Dirty()) {
            return null;
        }
        String string = pSDETreeLogic.getLogicParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam2_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isMemoDirty() : !pSDETreeLogic.isMemoDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isOrderValueDirty() : !pSDETreeLogic.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDETreeLogic.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSDEIdDirty() : !pSDETreeLogic.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSDELogicIdDirty() : !pSDETreeLogic.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSDENameDirty() : !pSDETreeLogic.isPSDENameDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETreeColId(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSDETreeColIdDirty() : !pSDETreeLogic.isPSDETreeColIdDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSDETreeColId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeColId_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREECOLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeLogicId(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSDETreeLogicIdDirty() && !bl2 : !pSDETreeLogic.isPSDETreeLogicIdDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSDETreeLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREELOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeLogicId_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeLogicName(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSDETreeLogicNameDirty() && !bl2 : !pSDETreeLogic.isPSDETreeLogicNameDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSDETreeLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREELOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeLogicName_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREELOGICNAME");
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
                string3 = "PSDETREEVIEWID";
                String string4 = this.checkFieldDupRule(this.getPSDETreeLogicDEModel(), "PSDETREELOGICNAME", string3, pSDETreeLogic, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDETREELOGICNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeId(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSDETreeNodeIdDirty() : !pSDETreeLogic.isPSDETreeNodeIdDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSDETreeNodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeId_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSDETreeViewIdDirty() && !bl2 : !pSDETreeLogic.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSDETreeViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREEVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSDEUIActionIdDirty() : !pSDETreeLogic.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSSysPFPluginIdDirty() : !pSDETreeLogic.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewLogicId(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSSysViewLogicIdDirty() : !pSDETreeLogic.isPSSysViewLogicIdDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSSysViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewLogicId_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isPSSysViewPanelIdDirty() : !pSDETreeLogic.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Timer(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isTimerDirty() : !pSDETreeLogic.isTimerDirty()) {
            return null;
        }
        Integer n = pSDETreeLogic.getTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timer_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TriggerType(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isTriggerTypeDirty() && !bl2 : !pSDETreeLogic.isTriggerTypeDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getTriggerType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRIGGERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TriggerType_Default(pSDETreeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRIGGERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isUserCatDirty() : !pSDETreeLogic.isUserCatDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isUserTagDirty() : !pSDETreeLogic.isUserTagDirty()) {
            return null;
        }
        String string = pSDETreeLogic.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isUserTag2Dirty() : !pSDETreeLogic.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDETreeLogic.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isUserTag3Dirty() : !pSDETreeLogic.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDETreeLogic.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isUserTag4Dirty() : !pSDETreeLogic.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDETreeLogic.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDETreeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDETreeLogic pSDETreeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeLogic.isValidFlagDirty() && !bl2 : !pSDETreeLogic.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDETreeLogic.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDETreeLogic, bl2, bl3);
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

    protected void onSyncEntity(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSDETreeLogic, bl);
    }

    protected void onSyncIndexEntities(PSDETreeLogic pSDETreeLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDETreeLogic, bl);
    }

    public Object getDataContextValue(PSDETreeLogic pSDETreeLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDETreeLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSDETreeView pSDETreeView = pSDETreeLogic.getPSDETreeView();
        if (pSDETreeView != null && pSDETreeView.contains(string)) {
            return pSDETreeView.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDETreeLogic pSDETreeLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDETreeLogic, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ATTRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DSTLOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstLogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTARG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventArg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTARG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventArg2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTNAMES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventNames_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicParam2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREECOLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREECOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeColName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeLogicName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Timer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TRIGGERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TriggerType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AttrName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_DstLogicType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTLOGICTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EventArg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTARG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EventArg2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTARG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EventNames_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTNAMES", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDETreeColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREECOLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeColName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREECOLNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREELOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSDETREELOGICNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSDEUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Timer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TriggerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TRIGGERTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected boolean onMergeChild(String string, String string2, PSDETreeLogic pSDETreeLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDETreeLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDETreeLogic pSDETreeLogic) throws Exception {
        super.onUpdateParent(pSDETreeLogic);
    }

    @Override
    protected void exportCurXmlModel(PSDETreeLogic pSDETreeLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETREELOGIC");
        if (!bl) {
            pSDETreeLogic.setCreateDate(null);
            pSDETreeLogic.setCreateMan(null);
            pSDETreeLogic.setPSDETreeLogicId(null);
            pSDETreeLogic.setUpdateDate(null);
            pSDETreeLogic.setUpdateMan(null);
            pSDETreeLogic.setPSDETreeColId(null);
            pSDETreeLogic.setPSDETreeNodeId(null);
            pSDETreeLogic.setPSDETreeViewId(null);
            pSDETreeLogic.setPSDETreeViewName(null);
            super.exportCurXmlModel(pSDETreeLogic, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDETreeLogic pSDETreeLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDETreeLogic, string);
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
            return "DER1N_PSDETREELOGIC_PSDETREEVIEW_PSDETREEVIEWID";
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
    public String getModelV2Tag(PSDETreeLogic pSDETreeLogic) {
        if (!StringHelper.isNullOrEmpty((String)pSDETreeLogic.getPSDETreeLogicName())) {
            return pSDETreeLogic.getPSDETreeLogicName();
        }
        return super.getModelV2Tag(pSDETreeLogic);
    }

    @Override
    public boolean setModelV2Tag(PSDETreeLogic pSDETreeLogic, String string) {
        pSDETreeLogic.setPSDETreeLogicName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDETREELOGICNAME", "");
        map.put("PSDETREELOGICNAME", "");
        map.put("PSDETREEVIEWID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDETreeLogic pSDETreeLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDETreeLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDETreeLogic, true);
        pSDETreeLogic.set("PSDETREELOGICNAME", string);
        if (this.select(pSDETreeLogic, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDETreeLogic, true);
        return super.getModelV2Entity(pSDETreeLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDETreeLogic pSDETreeLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDETreeLogic, objectNode, string, string2, n);
    }
}

