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
import net.ibizsys.pscore.srv.dedesign.dao.PSDETreeNodeColDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeNodeColDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeColBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUDetailService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCatBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyleBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeNodeColServiceBase
extends PSCoreSysServiceBase<PSDETreeNodeCol> {
    private static final Log log = LogFactory.getLog(PSDETreeNodeColServiceBase.class);
    public static final String DATASET_CURTREENODE = "CurTreeNode";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDETreeNodeColDEModel pSDETreeNodeColDEModel;
    private PSDETreeNodeColDAO pSDETreeNodeColDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService";
    }

    public PSDETreeNodeColDEModel getPSDETreeNodeColDEModel() {
        if (this.pSDETreeNodeColDEModel == null) {
            try {
                this.pSDETreeNodeColDEModel = (PSDETreeNodeColDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeNodeColDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeNodeColDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDETreeNodeColDEModel();
    }

    public PSDETreeNodeColDAO getPSDETreeNodeColDAO() {
        if (this.pSDETreeNodeColDAO == null) {
            try {
                this.pSDETreeNodeColDAO = (PSDETreeNodeColDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDETreeNodeColDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeNodeColDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDETreeNodeColDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURTREENODE, (boolean)true) == 0) {
            return this.fetchCurTreeNode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURTREENODE, (boolean)true) == 0) {
            return this.fetchTempCurTreeNode(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurTreeNode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURTREENODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurTreeNode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURTREENODE, true);
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

    protected void onFillParentInfo(PSDETreeNodeCol pSDETreeNodeCol, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSDETreeNodeCol, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDATAENTITY_REFPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_RefPSDE(pSDETreeNodeCol, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDEACMODE_REFPSDEACMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService", (SessionFactory)this.getSessionFactory());
            PSDEACMode pSDEACMode = (PSDEACMode)iService.getDEModel().createEntity();
            pSDEACMode.set("PSDEACMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEACMode);
            } else {
                iService.get(pSDEACMode);
            }
            this.onFillParentInfo_RefPSDEACMode(pSDETreeNodeCol, pSDEACMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDEDATASET_REFPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_RefPSDEDataSet(pSDETreeNodeCol, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDEFFORMITEM_PSDEFUIMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService", (SessionFactory)this.getSessionFactory());
            PSDEFUIMode pSDEFUIMode = (PSDEFUIMode)iService.getDEModel().createEntity();
            pSDEFUIMode.set("PSDEFFORMITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFUIMode);
            } else {
                iService.get(pSDEFUIMode);
            }
            this.onFillParentInfo_PSDEFUIMode(pSDETreeNodeCol, pSDEFUIMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDETreeNodeCol, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDETEIUPDATE_PSDETEIUPDATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService", (SessionFactory)this.getSessionFactory());
            PSDETEIUpdate pSDETEIUpdate = (PSDETEIUpdate)iService.getDEModel().createEntity();
            pSDETEIUpdate.set("PSDETEIUPDATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETEIUpdate);
            } else {
                iService.get(pSDETEIUpdate);
            }
            this.onFillParentInfo_PSDETEIUpdate(pSDETreeNodeCol, pSDETEIUpdate);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDETREECOL_PSDETREECOLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService", (SessionFactory)this.getSessionFactory());
            PSDETreeCol pSDETreeCol = (PSDETreeCol)iService.getDEModel().createEntity();
            pSDETreeCol.set("PSDETREECOLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeCol);
            } else {
                iService.get(pSDETreeCol);
            }
            this.onFillParentInfo_PSDETreeCol(pSDETreeNodeCol, pSDETreeCol);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDETREENODE_PSDETREENODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService", (SessionFactory)this.getSessionFactory());
            PSDETreeNode pSDETreeNode = (PSDETreeNode)iService.getDEModel().createEntity();
            pSDETreeNode.set("PSDETREENODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeNode);
            } else {
                iService.get(pSDETreeNode);
            }
            this.onFillParentInfo_PSDETreeNode(pSDETreeNodeCol, pSDETreeNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeView);
            } else {
                iService.get(pSDETreeView);
            }
            this.onFillParentInfo_PSDETreeView(pSDETreeNodeCol, pSDETreeView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDETreeNodeCol, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSDETreeNodeCol, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDEVIEWBASE_LINKPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_LinkPSDEView(pSDETreeNodeCol, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSDEVIEWBASE_PICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PickupPSDEView(pSDETreeNodeCol, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSSYSCSS_CELLPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_CellPSSysCss(pSDETreeNodeCol, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSSYSDICTCAT_PSSYSDICTCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService", (SessionFactory)this.getSessionFactory());
            PSSysDictCat pSSysDictCat = (PSSysDictCat)iService.getDEModel().createEntity();
            pSSysDictCat.set("PSSYSDICTCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDictCat);
            } else {
                iService.get(pSSysDictCat);
            }
            this.onFillParentInfo_PSSysDictCat(pSDETreeNodeCol, pSSysDictCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDETreeNodeCol, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService", (SessionFactory)this.getSessionFactory());
            PSSysEditorStyle pSSysEditorStyle = (PSSysEditorStyle)iService.getDEModel().createEntity();
            pSSysEditorStyle.set("PSSYSEDITORSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEditorStyle);
            } else {
                iService.get(pSSysEditorStyle);
            }
            this.onFillParentInfo_PSSysEditorStyle(pSDETreeNodeCol, pSSysEditorStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODECOL_PSSYSPFPLUGIN_GCRPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_GCRPSSysPFPlugin(pSDETreeNodeCol, pSSysPFPlugin);
            return;
        }
        super.onFillParentInfo(pSDETreeNodeCol, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDETREENODECOL_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", string2);
            return this.onSyncDER1NData_PSDETreeView(pSDETreeView, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSDETreeNodeCol pSDETreeNodeCol, PSCodeList pSCodeList) throws Exception {
        pSDETreeNodeCol.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSDETreeNodeCol.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_RefPSDE(PSDETreeNodeCol pSDETreeNodeCol, PSDataEntity pSDataEntity) throws Exception {
        pSDETreeNodeCol.setRefPSDEId(pSDataEntity.getPSDataEntityId());
        pSDETreeNodeCol.setRefPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_RefPSDEACMode(PSDETreeNodeCol pSDETreeNodeCol, PSDEACMode pSDEACMode) throws Exception {
        pSDETreeNodeCol.setRefPSDEACModeId(pSDEACMode.getPSDEACModeId());
        pSDETreeNodeCol.setRefPSDEACModeName(pSDEACMode.getPSDEACModeName());
    }

    protected void onFillParentInfo_RefPSDEDataSet(PSDETreeNodeCol pSDETreeNodeCol, PSDEDataSet pSDEDataSet) throws Exception {
        pSDETreeNodeCol.setRefPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDETreeNodeCol.setRefPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEFUIMode(PSDETreeNodeCol pSDETreeNodeCol, PSDEFUIMode pSDEFUIMode) throws Exception {
        pSDETreeNodeCol.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
        pSDETreeNodeCol.setPSDEFUIModeName(pSDEFUIMode.getPSDEFUIModeName());
    }

    protected void onFillParentInfo_PSDEF(PSDETreeNodeCol pSDETreeNodeCol, PSDEField pSDEField) throws Exception {
        pSDETreeNodeCol.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNodeCol.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDETEIUpdate(PSDETreeNodeCol pSDETreeNodeCol, PSDETEIUpdate pSDETEIUpdate) throws Exception {
        pSDETreeNodeCol.setPSDETEIUpdateId(pSDETEIUpdate.getPSDETEIUpdateId());
        pSDETreeNodeCol.setPSDETEIUpdateName(pSDETEIUpdate.getPSDETEIUpdateName());
    }

    protected void onFillParentInfo_PSDETreeCol(PSDETreeNodeCol pSDETreeNodeCol, PSDETreeCol pSDETreeCol) throws Exception {
        pSDETreeNodeCol.setGridColType(pSDETreeCol.getGridColType());
        pSDETreeNodeCol.setPSDETreeColId(pSDETreeCol.getPSDETreeColId());
        pSDETreeNodeCol.setPSDETreeColName(pSDETreeCol.getPSDETreeColName());
        if (pSDETreeCol.getPSDETreeView() != null) {
            this.onFillParentInfo_PSDETreeView(pSDETreeNodeCol, pSDETreeCol.getPSDETreeView());
        }
    }

    protected void onFillParentInfo_PSDETreeNode(PSDETreeNodeCol pSDETreeNodeCol, PSDETreeNode pSDETreeNode) throws Exception {
        pSDETreeNodeCol.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
        pSDETreeNodeCol.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
        if (pSDETreeNode.getPSDETreeView() != null) {
            this.onFillParentInfo_PSDETreeView(pSDETreeNodeCol, pSDETreeNode.getPSDETreeView());
        }
    }

    protected void onFillParentInfo_PSDETreeView(PSDETreeNodeCol pSDETreeNodeCol, PSDETreeView pSDETreeView) throws Exception {
        pSDETreeNodeCol.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
        pSDETreeNodeCol.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
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
            ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDETreeView(pSDETreeView);
            for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDETreeNodeCol, (String)"PSDETREENODECOLID", (String)""))) continue;
                this.remove(pSDETreeNodeCol);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDETreeNodeCol pSDETreeNodeCol, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDETreeNodeCol.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDETreeNodeCol.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSDETreeNodeCol pSDETreeNodeCol, PSDEUIAction pSDEUIAction) throws Exception {
        pSDETreeNodeCol.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDETreeNodeCol.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_LinkPSDEView(PSDETreeNodeCol pSDETreeNodeCol, PSDEViewBase pSDEViewBase) throws Exception {
        pSDETreeNodeCol.setLinkPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDETreeNodeCol.setLinkPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PickupPSDEView(PSDETreeNodeCol pSDETreeNodeCol, PSDEViewBase pSDEViewBase) throws Exception {
        pSDETreeNodeCol.setPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDETreeNodeCol.setPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_CellPSSysCss(PSDETreeNodeCol pSDETreeNodeCol, PSSysCss pSSysCss) throws Exception {
        pSDETreeNodeCol.setCellPSSysCssId(pSSysCss.getPSSysCssId());
        pSDETreeNodeCol.setCellPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDictCat(PSDETreeNodeCol pSDETreeNodeCol, PSSysDictCat pSSysDictCat) throws Exception {
        pSDETreeNodeCol.setPSSysDictCatId(pSSysDictCat.getPSSysDictCatId());
        pSDETreeNodeCol.setPSSysDictCatName(pSSysDictCat.getPSSysDictCatName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDETreeNodeCol pSDETreeNodeCol, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDETreeNodeCol.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDETreeNodeCol.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysEditorStyle(PSDETreeNodeCol pSDETreeNodeCol, PSSysEditorStyle pSSysEditorStyle) throws Exception {
        pSDETreeNodeCol.setPSSysEditorStyleId(pSSysEditorStyle.getPSSysEditorStyleId());
        pSDETreeNodeCol.setPSSysEditorStyleName(pSSysEditorStyle.getPSSysEditorStyleName());
    }

    protected void onFillParentInfo_GCRPSSysPFPlugin(PSDETreeNodeCol pSDETreeNodeCol, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDETreeNodeCol.setGCRPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDETreeNodeCol.setGCRPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillEntityFullInfo(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
        if (bl && pSDETreeNodeCol.getCustomMode() == null) {
            pSDETreeNodeCol.setCustomMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSCodeList(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_RefPSDE(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_RefPSDEACMode(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_RefPSDEDataSet(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSDEFUIMode(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSDEF(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSDETEIUpdate(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSDETreeCol(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSDETreeNode(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSDETreeView(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_LinkPSDEView(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PickupPSDEView(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_CellPSSysCss(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSSysDictCat(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_PSSysEditorStyle(pSDETreeNodeCol, bl);
        this.onFillEntityFullInfo_GCRPSSysPFPlugin(pSDETreeNodeCol, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDE(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
        if (pSDETreeNodeCol.isRefPSDEIdDirty()) {
            if (pSDETreeNodeCol.getRefPSDEId() != null) {
                if (pSDETreeNodeCol.getRefPSDEId() == null || pSDETreeNodeCol.getRefPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDETreeNodeCol.getRefPSDE();
                    pSDETreeNodeCol.setRefPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDETreeNodeCol.setRefPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDEACMode(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDEDataSet(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFUIMode(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEF(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
        if (pSDETreeNodeCol.isPSDEFIdDirty()) {
            if (pSDETreeNodeCol.getPSDEFId() != null) {
                if (pSDETreeNodeCol.getPSDEFId() == null || pSDETreeNodeCol.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNodeCol.getPSDEF();
                    pSDETreeNodeCol.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNodeCol.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDETEIUpdate(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeCol(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeNode(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeView(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LinkPSDEView(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PickupPSDEView(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CellPSSysCss(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDictCat(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
        if (pSDETreeNodeCol.isPSSysDynaModelIdDirty()) {
            if (pSDETreeNodeCol.getPSSysDynaModelId() != null) {
                if (pSDETreeNodeCol.getPSSysDynaModelId() == null || pSDETreeNodeCol.getPSSysDynaModelName() == null) {
                    PSSysDynaModel pSSysDynaModel = pSDETreeNodeCol.getPSSysDynaModel();
                    pSDETreeNodeCol.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                }
            } else {
                pSDETreeNodeCol.setPSSysDynaModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysEditorStyle(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GCRPSSysPFPlugin(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
        super.onWriteBackParent(pSDETreeNodeCol, bl);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByRefPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEACMODEID", (Object)pSDEACModeBase.getPSDEACModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEACModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEACModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase) throws Exception {
        return this.selectByPSDEFUIMode(pSDEFUIModeBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase, String string) throws Exception {
        return this.selectByPSDEFUIMode(pSDEFUIModeBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFUIMODEID", (Object)pSDEFUIModeBase.getPSDEFUIModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFUIModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFUIModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETEIUpdate(PSDETEIUpdateBase pSDETEIUpdateBase) throws Exception {
        return this.selectByPSDETEIUpdate(pSDETEIUpdateBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETEIUpdate(PSDETEIUpdateBase pSDETEIUpdateBase, String string) throws Exception {
        return this.selectByPSDETEIUpdate(pSDETEIUpdateBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETEIUpdate(PSDETEIUpdateBase pSDETEIUpdateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETEIUPDATEID", (Object)pSDETEIUpdateBase.getPSDETEIUpdateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETEIUpdateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETEIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectTempByPSDETEIUpdate(PSDETEIUpdateBase pSDETEIUpdateBase) throws Exception {
        return this.selectTempByPSDETEIUpdate(pSDETEIUpdateBase, "");
    }

    public ArrayList<PSDETreeNodeCol> selectTempByPSDETEIUpdate(PSDETEIUpdateBase pSDETEIUpdateBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETEIUPDATEID", (Object)pSDETEIUpdateBase.getPSDETEIUpdateId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETEIUpdateCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETEIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETreeCol(PSDETreeColBase pSDETreeColBase) throws Exception {
        return this.selectByPSDETreeCol(pSDETreeColBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETreeCol(PSDETreeColBase pSDETreeColBase, String string) throws Exception {
        return this.selectByPSDETreeCol(pSDETreeColBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETreeCol(PSDETreeColBase pSDETreeColBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNodeCol> selectTempByPSDETreeCol(PSDETreeColBase pSDETreeColBase) throws Exception {
        return this.selectTempByPSDETreeCol(pSDETreeColBase, "");
    }

    public ArrayList<PSDETreeNodeCol> selectTempByPSDETreeCol(PSDETreeColBase pSDETreeColBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREECOLID", (Object)pSDETreeColBase.getPSDETreeColId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeColCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectByPSDETreeNode(pSDETreeNodeBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        return this.selectByPSDETreeNode(pSDETreeNodeBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNodeCol> selectTempByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectTempByPSDETreeNode(pSDETreeNodeBase, "");
    }

    public ArrayList<PSDETreeNodeCol> selectTempByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREENODEID", (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNodeCol> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectTempByPSDETreeView(pSDETreeViewBase, "");
    }

    public ArrayList<PSDETreeNodeCol> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREEVIEWID", (Object)pSDETreeViewBase.getPSDETreeViewId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeViewCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNodeCol> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PICKUPPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPickupPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPickupPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByCellPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByCellPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByCellPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByCellPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByCellPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CELLPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCellPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCellPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase) throws Exception {
        return this.selectByPSSysDictCat(pSSysDictCatBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase, String string) throws Exception {
        return this.selectByPSSysDictCat(pSSysDictCatBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDICTCATID", (Object)pSSysDictCatBase.getPSSysDictCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDictCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDictCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEDITORSTYLEID", (Object)pSSysEditorStyleBase.getPSSysEditorStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEditorStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEditorStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeCol> selectByGCRPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByGCRPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByGCRPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByGCRPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDETreeNodeCol> selectByGCRPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GCRPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGCRPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGCRPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSCodeListId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByRefPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSDATAENTITY_REFPSDEID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByRefPSDE(pSDataEntity);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setRefPSDEId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByRefPSDE(pSDataEntity2);
                PSDETreeNodeColServiceBase.this.internalRemoveByRefPSDE(pSDataEntity2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByRefPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByRefPSDE(pSDataEntity);
        this.onBeforeRemoveByRefPSDE(pSDataEntity, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByRefPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByRefPSDEACMode(pSDEACMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEACMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSDEACMODE_REFPSDEACMODEID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSDEACMode), arrayList.get(0)));
        }
    }

    public void resetRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setRefPSDEACModeId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        final PSDEACMode pSDEACMode2 = pSDEACMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByRefPSDEACMode(pSDEACMode2);
                PSDETreeNodeColServiceBase.this.internalRemoveByRefPSDEACMode(pSDEACMode2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByRefPSDEACMode(pSDEACMode2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void internalRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        this.onBeforeRemoveByRefPSDEACMode(pSDEACMode, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByRefPSDEACMode(pSDEACMode, arrayList);
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSDEDATASET_REFPSDEDATASETID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setRefPSDEDataSetId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSDETreeNodeColServiceBase.this.internalRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFUIMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFUIMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSDEFFORMITEM_PSDEFUIMODEID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSDEFUIMode), arrayList.get(0)));
        }
    }

    public void resetPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDEFUIModeId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        final PSDEFUIMode pSDEFUIMode2 = pSDEFUIMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSDEFUIMode(pSDEFUIMode2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSDEFUIMode(pSDEFUIMode2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSDEFUIMode(pSDEFUIMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    protected void internalRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode);
        this.onBeforeRemoveByPSDEFUIMode(pSDEFUIMode, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSDEFUIMode(pSDEFUIMode, arrayList);
    }

    protected void onAfterRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDEFId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDETEIUpdate(pSDETEIUpdate, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETEIUPDATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDETEIUpdate);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSDETEIUPDATE_PSDETEIUPDATEID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSDETEIUpdate), arrayList.get(0)));
        }
    }

    public void resetPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDETEIUpdate(pSDETEIUpdate);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDETEIUpdateId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void resetTempPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectTempByPSDETEIUpdate(pSDETEIUpdate);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDETEIUpdateId(null);
            this.updateTemp(pSDETreeNodeCol2);
        }
    }

    public void removeByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        final PSDETEIUpdate pSDETEIUpdate2 = pSDETEIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSDETEIUpdate(pSDETEIUpdate2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSDETEIUpdate(pSDETEIUpdate2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSDETEIUpdate(pSDETEIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
    }

    protected void internalRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDETEIUpdate(pSDETEIUpdate);
        this.onBeforeRemoveByPSDETEIUpdate(pSDETEIUpdate, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSDETEIUpdate(pSDETEIUpdate, arrayList);
    }

    protected void onAfterRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
    }

    protected void onBeforeRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
    }

    public void resetPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDETreeCol(pSDETreeCol);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDETreeColId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void resetTempPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectTempByPSDETreeCol(pSDETreeCol);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDETreeColId(null);
            this.updateTemp(pSDETreeNodeCol2);
        }
    }

    public void removeByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        final PSDETreeCol pSDETreeCol2 = pSDETreeCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSDETreeCol(pSDETreeCol2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSDETreeCol(pSDETreeCol2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSDETreeCol(pSDETreeCol2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
    }

    protected void internalRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDETreeCol(pSDETreeCol);
        this.onBeforeRemoveByPSDETreeCol(pSDETreeCol, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSDETreeCol(pSDETreeCol, arrayList);
    }

    protected void onAfterRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeCol(PSDETreeCol pSDETreeCol, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    public void resetPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDETreeNode(pSDETreeNode);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDETreeNodeId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void resetTempPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectTempByPSDETreeNode(pSDETreeNode);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDETreeNodeId(null);
            this.updateTemp(pSDETreeNodeCol2);
        }
    }

    public void removeByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveByPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    public void resetPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDETreeView(pSDETreeView);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDETreeViewId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void resetTempPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDETreeViewId(null);
            this.updateTemp(pSDETreeNodeCol2);
        }
    }

    public void removeByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSDETreeView(pSDETreeView2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSDETreeView(pSDETreeView2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDEUAGroupId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSDEUIActionId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByLinkPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSDEVIEWBASE_LINKPSDEVIEWID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setLinkPSDEViewId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByLinkPSDEView(pSDEViewBase2);
                PSDETreeNodeColServiceBase.this.internalRemoveByLinkPSDEView(pSDEViewBase2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByLinkPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        this.onBeforeRemoveByLinkPSDEView(pSDEViewBase, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByLinkPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSDEVIEWBASE_PICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPickupPSDEView(pSDEViewBase);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPickupPSDEViewId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPickupPSDEView(pSDEViewBase2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPickupPSDEView(pSDEViewBase2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByPickupPSDEView(pSDEViewBase, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByCellPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByCellPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSSYSCSS_CELLPSSYSCSSID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetCellPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByCellPSSysCss(pSSysCss);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setCellPSSysCssId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByCellPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByCellPSSysCss(pSSysCss2);
                PSDETreeNodeColServiceBase.this.internalRemoveByCellPSSysCss(pSSysCss2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByCellPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByCellPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByCellPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByCellPSSysCss(pSSysCss);
        this.onBeforeRemoveByCellPSSysCss(pSSysCss, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByCellPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByCellPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByCellPSSysCss(PSSysCss pSSysCss, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCellPSSysCss(PSSysCss pSSysCss, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSSysDictCat(pSSysDictCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDICTCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDictCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSSYSDICTCAT_PSSYSDICTCATID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSSysDictCat), arrayList.get(0)));
        }
    }

    public void resetPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSSysDictCat(pSSysDictCat);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSSysDictCatId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        final PSSysDictCat pSSysDictCat2 = pSSysDictCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSSysDictCat(pSSysDictCat2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSSysDictCat(pSSysDictCat2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSSysDictCat(pSSysDictCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
    }

    protected void internalRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSSysDictCat(pSSysDictCat);
        this.onBeforeRemoveByPSSysDictCat(pSSysDictCat, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSSysDictCat(pSSysDictCat, arrayList);
    }

    protected void onAfterRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSSysDynaModelId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEDITORSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysEditorStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSSysEditorStyle), arrayList.get(0)));
        }
    }

    public void resetPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setPSSysEditorStyleId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        final PSSysEditorStyle pSSysEditorStyle2 = pSSysEditorStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSDETreeNodeColServiceBase.this.internalRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void internalRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void testRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByGCRPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODECOL_PSSYSPFPLUGIN_GCRPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDETREENODECOL", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByGCRPSSysPFPlugin(pSSysPFPlugin);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            PSDETreeNodeCol pSDETreeNodeCol2 = (PSDETreeNodeCol)this.getDEModel().createEntity();
            pSDETreeNodeCol2.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
            pSDETreeNodeCol2.setGCRPSSysPFPluginId(null);
            this.update(pSDETreeNodeCol2);
        }
    }

    public void removeByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveByGCRPSSysPFPlugin(pSSysPFPlugin2);
                PSDETreeNodeColServiceBase.this.internalRemoveByGCRPSSysPFPlugin(pSSysPFPlugin2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveByGCRPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectByGCRPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByGCRPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.remove(pSDETreeNodeCol);
        }
        this.onAfterRemoveByGCRPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDETEIUDetailService.testRemoveByPSDETreeNodeCol(pSDETreeNodeCol);
        super.onBeforeRemove(pSDETreeNodeCol);
    }

    protected void onBeforeRemoveTemp(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDETEIUDetailService.resetTempPSDETreeNodeCol(pSDETreeNodeCol);
        super.onBeforeRemoveTemp(pSDETreeNodeCol);
    }

    public void removeTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        final PSDETEIUpdate pSDETEIUpdate2 = pSDETEIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveTempByPSDETEIUpdate(pSDETEIUpdate2);
                PSDETreeNodeColServiceBase.this.internalRemoveTempByPSDETEIUpdate(pSDETEIUpdate2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveTempByPSDETEIUpdate(pSDETEIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
    }

    protected void internalRemoveTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectTempByPSDETEIUpdate(pSDETEIUpdate);
        this.onBeforeRemoveTempByPSDETEIUpdate(pSDETEIUpdate, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.removeTemp(pSDETreeNodeCol);
        }
        this.onAfterRemoveTempByPSDETEIUpdate(pSDETEIUpdate, arrayList);
    }

    protected void onAfterRemoveTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void removeTempByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        final PSDETreeCol pSDETreeCol2 = pSDETreeCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveTempByPSDETreeCol(pSDETreeCol2);
                PSDETreeNodeColServiceBase.this.internalRemoveTempByPSDETreeCol(pSDETreeCol2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveTempByPSDETreeCol(pSDETreeCol2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectTempByPSDETreeCol(pSDETreeCol);
        this.onBeforeRemoveTempByPSDETreeCol(pSDETreeCol, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.removeTemp(pSDETreeNodeCol);
        }
        this.onAfterRemoveTempByPSDETreeCol(pSDETreeCol, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeCol(PSDETreeCol pSDETreeCol) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeCol(PSDETreeCol pSDETreeCol, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeCol(PSDETreeCol pSDETreeCol, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void removeTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveTempByPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeColServiceBase.this.internalRemoveTempByPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveTempByPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectTempByPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveTempByPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.removeTemp(pSDETreeNodeCol);
        }
        this.onAfterRemoveTempByPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    public void removeTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeColServiceBase.this.onBeforeRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETreeNodeColServiceBase.this.internalRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETreeNodeColServiceBase.this.onAfterRemoveTempByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNodeCol> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveTempByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            this.removeTemp(pSDETreeNodeCol);
        }
        this.onAfterRemoveTempByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        super.getRelatedDataTempMajor(pSDETreeNodeCol);
    }

    protected void updateRelatedDataTempMajor(PSDETreeNodeCol pSDETreeNodeCol, PSDETreeNodeCol pSDETreeNodeCol2) throws Exception {
        super.updateRelatedDataTempMajor(pSDETreeNodeCol, pSDETreeNodeCol2);
    }

    protected void replaceParentInfo(PSDETreeNodeCol pSDETreeNodeCol, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDETreeNodeCol, cloneSession);
        if (pSDETreeNodeCol.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDETreeNodeCol.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSDETreeNodeCol, (PSCodeList)iEntity);
        }
        if (pSDETreeNodeCol.getRefPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDETreeNodeCol.getRefPSDEId())) != null) {
            this.onFillParentInfo_RefPSDE(pSDETreeNodeCol, (PSDataEntity)iEntity);
        }
        if (pSDETreeNodeCol.getRefPSDEACModeId() != null && (iEntity = cloneSession.getEntity("PSDEACMODE", (Object)pSDETreeNodeCol.getRefPSDEACModeId())) != null) {
            this.onFillParentInfo_RefPSDEACMode(pSDETreeNodeCol, (PSDEACMode)iEntity);
        }
        if (pSDETreeNodeCol.getRefPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDETreeNodeCol.getRefPSDEDataSetId())) != null) {
            this.onFillParentInfo_RefPSDEDataSet(pSDETreeNodeCol, (PSDEDataSet)iEntity);
        }
        if (pSDETreeNodeCol.getPSDEFUIModeId() != null && (iEntity = cloneSession.getEntity("PSDEFFORMITEM", (Object)pSDETreeNodeCol.getPSDEFUIModeId())) != null) {
            this.onFillParentInfo_PSDEFUIMode(pSDETreeNodeCol, (PSDEFUIMode)iEntity);
        }
        if (pSDETreeNodeCol.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNodeCol.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDETreeNodeCol, (PSDEField)iEntity);
        }
        if (pSDETreeNodeCol.getPSDETEIUpdateId() != null && (iEntity = cloneSession.getEntity("PSDETEIUPDATE", (Object)pSDETreeNodeCol.getPSDETEIUpdateId())) != null) {
            this.onFillParentInfo_PSDETEIUpdate(pSDETreeNodeCol, (PSDETEIUpdate)iEntity);
        }
        if (pSDETreeNodeCol.getPSDETreeColId() != null && (iEntity = cloneSession.getEntity("PSDETREECOL", (Object)pSDETreeNodeCol.getPSDETreeColId())) != null) {
            this.onFillParentInfo_PSDETreeCol(pSDETreeNodeCol, (PSDETreeCol)iEntity);
        }
        if (pSDETreeNodeCol.getPSDETreeNodeId() != null && (iEntity = cloneSession.getEntity("PSDETREENODE", (Object)pSDETreeNodeCol.getPSDETreeNodeId())) != null) {
            this.onFillParentInfo_PSDETreeNode(pSDETreeNodeCol, (PSDETreeNode)iEntity);
        }
        if (pSDETreeNodeCol.getPSDETreeViewId() != null && (iEntity = cloneSession.getEntity("PSDETREEVIEW", (Object)pSDETreeNodeCol.getPSDETreeViewId())) != null) {
            this.onFillParentInfo_PSDETreeView(pSDETreeNodeCol, (PSDETreeView)iEntity);
        }
        if (pSDETreeNodeCol.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDETreeNodeCol.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDETreeNodeCol, (PSDEUAGroup)iEntity);
        }
        if (pSDETreeNodeCol.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDETreeNodeCol.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSDETreeNodeCol, (PSDEUIAction)iEntity);
        }
        if (pSDETreeNodeCol.getLinkPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDETreeNodeCol.getLinkPSDEViewId())) != null) {
            this.onFillParentInfo_LinkPSDEView(pSDETreeNodeCol, (PSDEViewBase)iEntity);
        }
        if (pSDETreeNodeCol.getPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDETreeNodeCol.getPickupPSDEViewId())) != null) {
            this.onFillParentInfo_PickupPSDEView(pSDETreeNodeCol, (PSDEViewBase)iEntity);
        }
        if (pSDETreeNodeCol.getCellPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDETreeNodeCol.getCellPSSysCssId())) != null) {
            this.onFillParentInfo_CellPSSysCss(pSDETreeNodeCol, (PSSysCss)iEntity);
        }
        if (pSDETreeNodeCol.getPSSysDictCatId() != null && (iEntity = cloneSession.getEntity("PSSYSDICTCAT", (Object)pSDETreeNodeCol.getPSSysDictCatId())) != null) {
            this.onFillParentInfo_PSSysDictCat(pSDETreeNodeCol, (PSSysDictCat)iEntity);
        }
        if (pSDETreeNodeCol.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDETreeNodeCol.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDETreeNodeCol, (PSSysDynaModel)iEntity);
        }
        if (pSDETreeNodeCol.getPSSysEditorStyleId() != null && (iEntity = cloneSession.getEntity("PSSYSEDITORSTYLE", (Object)pSDETreeNodeCol.getPSSysEditorStyleId())) != null) {
            this.onFillParentInfo_PSSysEditorStyle(pSDETreeNodeCol, (PSSysEditorStyle)iEntity);
        }
        if (pSDETreeNodeCol.getGCRPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDETreeNodeCol.getGCRPSSysPFPluginId())) != null) {
            this.onFillParentInfo_GCRPSSysPFPlugin(pSDETreeNodeCol, (PSSysPFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDETreeNodeCol, bl);
    }

    protected void onCheckEntity(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSDETreeNodeCol, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CellPSSysCssId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CLConvertMode(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeListConfigMode(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateDV(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateDVT(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorParams(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorType(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCond(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableItemPriv(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLink(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableRowEdit(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GCRPSSysPFPluginId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColStyle(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupItem(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HiddenDataItem(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreInput(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEViewId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NeedCodeListConfig(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoPrivDM(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PickupPSDEViewId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlaceHolder(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFUIModeId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETEIUpdateId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeColId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeColId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeColName(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDictCatId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelName(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEditorStyleId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEACModeId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEDataSetId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEId(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEName(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResetItemName(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateDV(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateDVT(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFormat(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueItemName(bl, pSDETreeNodeCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDETreeNodeCol, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isAllowEmptyDirty() : !pSDETreeNodeCol.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getAllowEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CellPSSysCssId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isCellPSSysCssIdDirty() : !pSDETreeNodeCol.isCellPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getCellPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CellPSSysCssId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CELLPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CLConvertMode(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isCLConvertModeDirty() : !pSDETreeNodeCol.isCLConvertModeDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getCLConvertMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CLConvertMode_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLCONVERTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeListConfigMode(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isCodeListConfigModeDirty() : !pSDETreeNodeCol.isCodeListConfigModeDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getCodeListConfigMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CodeListConfigMode_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODELISTCONFIGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateDV(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isCreateDVDirty() : !pSDETreeNodeCol.isCreateDVDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getCreateDV();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateDV_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEDV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateDVT(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isCreateDVTDirty() : !pSDETreeNodeCol.isCreateDVTDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getCreateDVT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateDVT_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEDVT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isCustomCodeDirty() : !pSDETreeNodeCol.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDETreeNodeCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isCustomModeDirty() : !pSDETreeNodeCol.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDETreeNodeCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isDefaultValueDirty() : !pSDETreeNodeCol.isDefaultValueDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorParams(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isEditorParamsDirty() : !pSDETreeNodeCol.isEditorParamsDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getEditorParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorParams_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorType(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isEditorTypeDirty() : !pSDETreeNodeCol.isEditorTypeDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorType_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCond(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isEnableCondDirty() : !pSDETreeNodeCol.isEnableCondDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getEnableCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCond_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableItemPriv(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isEnableItemPrivDirty() : !pSDETreeNodeCol.isEnableItemPrivDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getEnableItemPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableItemPriv_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEITEMPRIV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableLink(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isEnableLinkDirty() : !pSDETreeNodeCol.isEnableLinkDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getEnableLink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableLink_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLELINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableRowEdit(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isEnableRowEditDirty() : !pSDETreeNodeCol.isEnableRowEditDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getEnableRowEdit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableRowEdit_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEROWEDIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GCRPSSysPFPluginId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isGCRPSSysPFPluginIdDirty() : !pSDETreeNodeCol.isGCRPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getGCRPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GCRPSSysPFPluginId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GCRPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridColStyle(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isGridColStyleDirty() : !pSDETreeNodeCol.isGridColStyleDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getGridColStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridColStyle_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupItem(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isGroupItemDirty() : !pSDETreeNodeCol.isGroupItemDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getGroupItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupItem_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HiddenDataItem(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isHiddenDataItemDirty() : !pSDETreeNodeCol.isHiddenDataItemDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getHiddenDataItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HiddenDataItem_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HIDDENDATAITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreInput(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isIgnoreInputDirty() : !pSDETreeNodeCol.isIgnoreInputDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getIgnoreInput();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreInput_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREINPUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEViewId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isLinkPSDEViewIdDirty() : !pSDETreeNodeCol.isLinkPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getLinkPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEViewId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isMemoDirty() : !pSDETreeNodeCol.isMemoDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDETreeNodeCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_NeedCodeListConfig(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isNeedCodeListConfigDirty() : !pSDETreeNodeCol.isNeedCodeListConfigDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getNeedCodeListConfig();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NeedCodeListConfig_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEEDCODELISTCONFIG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NoPrivDM(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isNoPrivDMDirty() : !pSDETreeNodeCol.isNoPrivDMDirty()) {
            return null;
        }
        Integer n = pSDETreeNodeCol.getNoPrivDM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoPrivDM_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOPRIVDM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PickupPSDEViewId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPickupPSDEViewIdDirty() : !pSDETreeNodeCol.isPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PickupPSDEViewId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PICKUPPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PlaceHolder(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPlaceHolderDirty() : !pSDETreeNodeCol.isPlaceHolderDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPlaceHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlaceHolder_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLACEHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSCodeListIdDirty() : !pSDETreeNodeCol.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDEFIdDirty() : !pSDETreeNodeCol.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDEFNameDirty() : !pSDETreeNodeCol.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFUIModeId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDEFUIModeIdDirty() : !pSDETreeNodeCol.isPSDEFUIModeIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDEFUIModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFUIModeId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFUIMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETEIUpdateId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDETEIUpdateIdDirty() : !pSDETreeNodeCol.isPSDETEIUpdateIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDETEIUpdateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETEIUpdateId_Default(pSDETreeNodeCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETreeColId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDETreeColIdDirty() : !pSDETreeNodeCol.isPSDETreeColIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDETreeColId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeColId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREECOLID");
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
                String string4 = this.checkFieldDupRule(this.getPSDETreeNodeColDEModel(), "PSDETREECOLID", string3, pSDETreeNodeCol, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDETREECOLID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeColId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDETreeNodeColIdDirty() && !bl2 : !pSDETreeNodeCol.isPSDETreeNodeColIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDETreeNodeColId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODECOLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeColId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODECOLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeColName(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDETreeNodeColNameDirty() && !bl2 : !pSDETreeNodeCol.isPSDETreeNodeColNameDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDETreeNodeColName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODECOLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeColName_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODECOLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDETREENODEID";
                String string4 = this.checkFieldDupRule(this.getPSDETreeNodeColDEModel(), "PSDETREENODECOLNAME", string3, pSDETreeNodeCol, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDETREENODECOLNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDETreeNodeIdDirty() && !bl2 : !pSDETreeNodeCol.isPSDETreeNodeIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDETreeNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeId_Default(pSDETreeNodeCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDETreeViewIdDirty() : !pSDETreeNodeCol.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDETreeViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default(pSDETreeNodeCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDEUAGroupIdDirty() : !pSDETreeNodeCol.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSDEUIActionIdDirty() : !pSDETreeNodeCol.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSDETreeNodeCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDictCatId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSSysDictCatIdDirty() : !pSDETreeNodeCol.isPSSysDictCatIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSSysDictCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDictCatId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDICTCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSSysDynaModelIdDirty() : !pSDETreeNodeCol.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelName(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSSysDynaModelNameDirty() : !pSDETreeNodeCol.isPSSysDynaModelNameDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSSysDynaModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelName_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEditorStyleId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isPSSysEditorStyleIdDirty() : !pSDETreeNodeCol.isPSSysEditorStyleIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getPSSysEditorStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEditorStyleId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEDITORSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEACModeId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isRefPSDEACModeIdDirty() : !pSDETreeNodeCol.isRefPSDEACModeIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getRefPSDEACModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEACModeId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEACMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEDataSetId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isRefPSDEDataSetIdDirty() : !pSDETreeNodeCol.isRefPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getRefPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEDataSetId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEId(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isRefPSDEIdDirty() : !pSDETreeNodeCol.isRefPSDEIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getRefPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEId_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEName(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isRefPSDENameDirty() : !pSDETreeNodeCol.isRefPSDENameDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getRefPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEName_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResetItemName(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isResetItemNameDirty() : !pSDETreeNodeCol.isResetItemNameDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getResetItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResetItemName_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESETITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdateDV(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isUpdateDVDirty() : !pSDETreeNodeCol.isUpdateDVDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getUpdateDV();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdateDV_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEDV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdateDVT(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isUpdateDVTDirty() : !pSDETreeNodeCol.isUpdateDVTDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getUpdateDVT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdateDVT_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEDVT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isUserCatDirty() : !pSDETreeNodeCol.isUserCatDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDETreeNodeCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isUserTagDirty() : !pSDETreeNodeCol.isUserTagDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDETreeNodeCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isUserTag2Dirty() : !pSDETreeNodeCol.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDETreeNodeCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueFormat(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isValueFormatDirty() : !pSDETreeNodeCol.isValueFormatDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFormat_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueItemName(boolean bl, PSDETreeNodeCol pSDETreeNodeCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeCol.isValueItemNameDirty() : !pSDETreeNodeCol.isValueItemNameDirty()) {
            return null;
        }
        String string = pSDETreeNodeCol.getValueItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueItemName_Default(pSDETreeNodeCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
        super.onSyncEntity(pSDETreeNodeCol, bl);
    }

    protected void onSyncIndexEntities(PSDETreeNodeCol pSDETreeNodeCol, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDETreeNodeCol, bl);
    }

    public Object getDataContextValue(PSDETreeNodeCol pSDETreeNodeCol, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACMODE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODENAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDETreeNodeCol, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDETreeNodeCol, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue(pSDETreeNodeCol, string, iDataContextParam)) != null) {
            return object;
        }
        PSDETreeNode pSDETreeNode = pSDETreeNodeCol.getPSDETreeNode();
        if (pSDETreeNode != null && pSDETreeNode.contains(string)) {
            return pSDETreeNode.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDETreeNodeCol pSDETreeNodeCol, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDETreeNodeCol, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CELLPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CellPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CELLPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CellPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLCONVERTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CLConvertMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODELISTCONFIGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeListConfigMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDV_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDVT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDVT_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEITEMPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableItemPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLELINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEROWEDIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableRowEdit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GCRPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GCRPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GCRPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GCRPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HIDDENDATAITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HiddenDataItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREINPUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreInput_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEEDCODELISTCONFIG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NeedCodeListConfig_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOPRIVDM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoPrivDM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PICKUPPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PickupPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PICKUPPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PickupPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLACEHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PlaceHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFUIMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFUIMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETEIUPDATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETEIUpdateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETEIUPDATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETEIUpdateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREECOLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREECOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeColName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODECOLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODECOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeColName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDICTCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDictCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDICTCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDictCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEDITORSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEditorStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEDITORSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEditorStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEACMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEACModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEACMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEACModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESETITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResetItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDV_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDVT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDVT_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueItemName_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CellPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CELLPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CellPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CELLPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CLConvertMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLCONVERTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeListConfigMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateDV_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEDV", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDVT_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEDVT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DefaultValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORPARAMS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableItemPriv_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableLink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableRowEdit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GCRPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GCRPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GCRPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GCRPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridColStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GRIDCOLSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridColType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GRIDCOLTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPITEM", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HiddenDataItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IgnoreInput_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_NeedCodeListConfig_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NoPrivDM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PickupPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PICKUPPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PickupPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PICKUPPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PlaceHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLACEHOLDER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFUIModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFUIMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFUIModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFUIMODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDETreeNodeColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODECOLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeColName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODECOLNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("PSDETREENODECOLNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysDictCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDICTCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDictCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDICTCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEditorStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEDITORSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEditorStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEDITORSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEACModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEACMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEACModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEACMODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResetItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESETITEMNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_UpdateDV_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEDV", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDVT_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEDVT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_ValueFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFORMAT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEITEMNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDETreeNodeCol)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        super.onUpdateParent(pSDETreeNodeCol);
    }

    @Override
    protected void exportCurXmlModel(PSDETreeNodeCol pSDETreeNodeCol, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETREENODECOL");
        if (!bl) {
            pSDETreeNodeCol.setCreateDate(null);
            pSDETreeNodeCol.setCreateMan(null);
            pSDETreeNodeCol.setPSCodeListName(null);
            pSDETreeNodeCol.setPSDETreeNodeColId(null);
            pSDETreeNodeCol.setPSDETreeNodeName(null);
            pSDETreeNodeCol.setPSDETreeViewName(null);
            pSDETreeNodeCol.setUpdateDate(null);
            pSDETreeNodeCol.setUpdateMan(null);
            pSDETreeNodeCol.setPSDETEIUpdateId(null);
            pSDETreeNodeCol.setGridColType(null);
            pSDETreeNodeCol.setPSDETreeColId(null);
            pSDETreeNodeCol.setPSDETreeNodeId(null);
            pSDETreeNodeCol.setPSDETreeViewId(null);
            pSDETreeNodeCol.setPSDETreeViewName(null);
            super.exportCurXmlModel(pSDETreeNodeCol, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDETreeNodeCol pSDETreeNodeCol, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDETreeNodeCol, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDETreeNodeCol pSDETreeNodeCol, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDETreeNodeCol, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDETreeNodeCol pSDETreeNodeCol, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDETreeNodeCol, string);
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
            return "DER1N_PSDETREENODECOL_PSDETREENODE_PSDETREENODEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREEVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETREENODECOL_PSDETREEVIEW_PSDETREEVIEWID";
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
    public String getModelV2Tag(PSDETreeNodeCol pSDETreeNodeCol) {
        if (!StringHelper.isNullOrEmpty((String)pSDETreeNodeCol.getPSDETreeNodeColName())) {
            return pSDETreeNodeCol.getPSDETreeNodeColName();
        }
        return super.getModelV2Tag(pSDETreeNodeCol);
    }

    @Override
    public boolean setModelV2Tag(PSDETreeNodeCol pSDETreeNodeCol, String string) {
        pSDETreeNodeCol.setPSDETreeNodeColName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDETREENODECOLNAME", "");
        map.put("PSDETREENODEID", "");
        map.put("PSDETREEVIEWID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDETreeNodeCol pSDETreeNodeCol, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDETreeNodeCol.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDETreeNodeCol, true);
        pSDETreeNodeCol.set("PSDETREENODECOLNAME", string);
        if (this.select(pSDETreeNodeCol, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDETreeNodeCol, true);
        return super.getModelV2Entity(pSDETreeNodeCol, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDETreeNodeCol pSDETreeNodeCol, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDETreeNodeCol.getPSDETreeNodeId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDETreeNodeCol.getPSDETreeViewId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdetreeviewid")) {
            objectNode.put("psdetreeviewid", "<PSDETREEVIEW>");
        }
        return super.testCompileCurModelV2(pSDETreeNodeCol, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDETreeNodeCol pSDETreeNodeCol, String string, Map<String, String> map) throws Exception {
        if (PSDETreeNodeColServiceBase.isSimpleImportExportMode()) {
            map.put("PSDETREENODEID", "");
            map.put("PSDETREEVIEWID", "");
        }
        return super.onFillModelV2(objectNode, pSDETreeNodeCol, string, map);
    }
}

