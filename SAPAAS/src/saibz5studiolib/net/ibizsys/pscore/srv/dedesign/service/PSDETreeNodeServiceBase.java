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
 *  net.ibizsys.paas.entity.EntityBase
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
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDETreeNodeDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeNodeDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeColBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeRV;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeRVBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRVService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRVServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeNodeServiceBase
extends PSCoreSysServiceBase<PSDETreeNode> {
    private static final Log log = LogFactory.getLog(PSDETreeNodeServiceBase.class);
    public static final String DATASET_CURTREE = "CurTree";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDETreeNodeDEModel pSDETreeNodeDEModel;
    private PSDETreeNodeDAO pSDETreeNodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService";
    }

    public PSDETreeNodeDEModel getPSDETreeNodeDEModel() {
        if (this.pSDETreeNodeDEModel == null) {
            try {
                this.pSDETreeNodeDEModel = (PSDETreeNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeNodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDETreeNodeDEModel();
    }

    public PSDETreeNodeDAO getPSDETreeNodeDAO() {
        if (this.pSDETreeNodeDAO == null) {
            try {
                this.pSDETreeNodeDAO = (PSDETreeNodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDETreeNodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeNodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDETreeNodeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURTREE, (boolean)true) == 0) {
            return this.fetchCurTree(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURTREE, (boolean)true) == 0) {
            return this.fetchTempCurTree(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurTree(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURTREE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurTree(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURTREE, true);
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

    protected void onFillParentInfo(PSDETreeNode pSDETreeNode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSDETreeNode, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDETreeNode, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEACTION_MOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_MovePSDEAction(pSDETreeNode, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDETreeNode, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEACTION_REMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_RemovePSDEAction(pSDETreeNode, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEACTION_UPDATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_UpdatePSDEAction(pSDETreeNode, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEDATASET_FILTERPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_FilterPSDEDS(pSDETreeNode, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSDETreeNode, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_CHILDCNTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ChildCntPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_CLSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ClsPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_DATA2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_Data2PSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_DATAPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_DataPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_DATATYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_DataTypePSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_ICONPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_IconPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_KEYPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_KeyPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_LEAFFLAGPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_LeafFlagPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_LINKPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_LinkPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_NODEID2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_NodeId2PSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_NODEID3PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_NodeId3PSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_NODEID4PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_NodeId4PSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_NODEIDPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_NodeIdPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_SHAPECLSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ShapeClsPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_SORTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_SortPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_TEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TextPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEFIELD_TIPSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TipsPSDEF(pSDETreeNode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEGrid);
            } else {
                iService.get(pSDEGrid);
            }
            this.onFillParentInfo_PSDEGrid(pSDETreeNode, pSDEGrid);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDETreeNode, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEOPPRIV_MOVEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_MovePSDEOPPriv(pSDETreeNode, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEOPPRIV_REMOVEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_RemovePSDEOPPriv(pSDETreeNode, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEOPPRIV_UPDATEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_UpdatePSDEOPPriv(pSDETreeNode, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSDETreeNode, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEToolbar);
            } else {
                iService.get(pSDEToolbar);
            }
            this.onFillParentInfo_PSDEToolbar(pSDETreeNode, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeView);
            } else {
                iService.get(pSDETreeView);
            }
            this.onFillParentInfo_PSDETreeView(pSDETreeNode, pSDETreeView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEUAGROUP_NO2PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_No2PSDEUAGroup(pSDETreeNode, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDETreeNode, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSDETreeNode, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSLANGUAGERES_NAMEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_NamePSLanRes(pSDETreeNode, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSDETreeNode, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDETreeNode, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSSYSCSS_SHAPEPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_ShapePSSysCss(pSDETreeNode, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDETreeNode, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDETreeNode, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniRes);
            } else {
                iService.get(pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSDETreeNode, pSSysUniRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSDETreeNode, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSDETreeNode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDETREENODE_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", string2);
            return this.onSyncDER1NData_PSDETreeView(pSDETreeView, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSDETreeNode pSDETreeNode, PSCodeList pSCodeList) throws Exception {
        pSDETreeNode.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSDETreeNode.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDE(PSDETreeNode pSDETreeNode, PSDataEntity pSDataEntity) throws Exception {
        pSDETreeNode.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDETreeNode.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_MovePSDEAction(PSDETreeNode pSDETreeNode, PSDEAction pSDEAction) throws Exception {
        pSDETreeNode.setMovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDETreeNode.setMovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEAction(PSDETreeNode pSDETreeNode, PSDEAction pSDEAction) throws Exception {
        pSDETreeNode.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDETreeNode.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_RemovePSDEAction(PSDETreeNode pSDETreeNode, PSDEAction pSDEAction) throws Exception {
        pSDETreeNode.setRemovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDETreeNode.setRemovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UpdatePSDEAction(PSDETreeNode pSDETreeNode, PSDEAction pSDEAction) throws Exception {
        pSDETreeNode.setUpdatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDETreeNode.setUpdatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_FilterPSDEDS(PSDETreeNode pSDETreeNode, PSDEDataSet pSDEDataSet) throws Exception {
        pSDETreeNode.setFilterPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDETreeNode.setFilterPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDS(PSDETreeNode pSDETreeNode, PSDEDataSet pSDEDataSet) throws Exception {
        pSDETreeNode.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDETreeNode.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_ChildCntPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setChildCntPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setChildCntPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ClsPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setClsPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setClsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Data2PSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setData2PSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setData2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_DataPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setDataPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setDataPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_DataTypePSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setDataTypePSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setDataTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IconPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setIconPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setIconPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_KeyPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setKeyPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setKeyPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_LeafFlagPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setLeafFlagPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setLeafFlagPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_LinkPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setLinkPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setLinkPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_NodeId2PSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setNodeId2PSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setNodeId2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_NodeId3PSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setNodeId3PSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setNodeId3PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_NodeId4PSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setNodeId4PSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setNodeId4PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_NodeIdPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setNodeIdPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setNodeIdPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ShapeClsPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setShapeClsPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setShapeClsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_SortPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setSortPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setSortPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TextPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setTextPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TipsPSDEF(PSDETreeNode pSDETreeNode, PSDEField pSDEField) throws Exception {
        pSDETreeNode.setTipsPSDEFId(pSDEField.getPSDEFieldId());
        pSDETreeNode.setTipsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEGrid(PSDETreeNode pSDETreeNode, PSDEGrid pSDEGrid) throws Exception {
        pSDETreeNode.setPSDEGridId(pSDEGrid.getPSDEGridId());
        pSDETreeNode.setPSDEGridName(pSDEGrid.getPSDEGridName());
    }

    protected void onFillParentInfo_PSDELogic(PSDETreeNode pSDETreeNode, PSDELogic pSDELogic) throws Exception {
        pSDETreeNode.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDETreeNode.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_MovePSDEOPPriv(PSDETreeNode pSDETreeNode, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDETreeNode.setMovePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDETreeNode.setMovePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_RemovePSDEOPPriv(PSDETreeNode pSDETreeNode, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDETreeNode.setRemovePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDETreeNode.setRemovePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_UpdatePSDEOPPriv(PSDETreeNode pSDETreeNode, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDETreeNode.setUpdatePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDETreeNode.setUpdatePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSDER(PSDETreeNode pSDETreeNode, PSDER pSDER) throws Exception {
        pSDETreeNode.setPSDERId(pSDER.getPSDERId());
        pSDETreeNode.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSDEToolbar(PSDETreeNode pSDETreeNode, PSDEToolbar pSDEToolbar) throws Exception {
        pSDETreeNode.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSDETreeNode.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_PSDETreeView(PSDETreeNode pSDETreeNode, PSDETreeView pSDETreeView) throws Exception {
        pSDETreeNode.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
        pSDETreeNode.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
        pSDETreeNode.setPSSystemId(pSDETreeView.getPSSystemId());
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
            ArrayList<PSDETreeNode> arrayList = this.selectByPSDETreeView(pSDETreeView);
            for (PSDETreeNode pSDETreeNode : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDETreeNode, (String)"PSDETREENODEID", (String)""))) continue;
                this.remove(pSDETreeNode);
            }
        }
        return null;
    }

    protected void onFillParentInfo_No2PSDEUAGroup(PSDETreeNode pSDETreeNode, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDETreeNode.setNo2PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDETreeNode.setNo2PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDETreeNode pSDETreeNode, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDETreeNode.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDETreeNode.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEViewBase(PSDETreeNode pSDETreeNode, PSDEViewBase pSDEViewBase) throws Exception {
        pSDETreeNode.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDETreeNode.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_NamePSLanRes(PSDETreeNode pSDETreeNode, PSLanguageRes pSLanguageRes) throws Exception {
        pSDETreeNode.setNamePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDETreeNode.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSDETreeNode pSDETreeNode, PSLanguageRes pSLanguageRes) throws Exception {
        pSDETreeNode.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDETreeNode.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSDETreeNode pSDETreeNode, PSSysCss pSSysCss) throws Exception {
        pSDETreeNode.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDETreeNode.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_ShapePSSysCss(PSDETreeNode pSDETreeNode, PSSysCss pSSysCss) throws Exception {
        pSDETreeNode.setShapePSSysCssId(pSSysCss.getPSSysCssId());
        pSDETreeNode.setShapePSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSDETreeNode pSDETreeNode, PSSysImage pSSysImage) throws Exception {
        pSDETreeNode.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDETreeNode.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDETreeNode pSDETreeNode, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDETreeNode.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDETreeNode.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSDETreeNode pSDETreeNode, PSSysUniRes pSSysUniRes) throws Exception {
        pSDETreeNode.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSDETreeNode.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSDETreeNode pSDETreeNode, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDETreeNode.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDETreeNode.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSCodeList(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSDE(pSDETreeNode, bl);
        this.onFillEntityFullInfo_MovePSDEAction(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDETreeNode, bl);
        this.onFillEntityFullInfo_RemovePSDEAction(pSDETreeNode, bl);
        this.onFillEntityFullInfo_UpdatePSDEAction(pSDETreeNode, bl);
        this.onFillEntityFullInfo_FilterPSDEDS(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSDEDS(pSDETreeNode, bl);
        this.onFillEntityFullInfo_ChildCntPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_ClsPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_Data2PSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_DataPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_DataTypePSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_IconPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_KeyPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_LeafFlagPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_LinkPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_NodeId2PSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_NodeId3PSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_NodeId4PSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_NodeIdPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_ShapeClsPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_SortPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_TextPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_TipsPSDEF(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSDEGrid(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDETreeNode, bl);
        this.onFillEntityFullInfo_MovePSDEOPPriv(pSDETreeNode, bl);
        this.onFillEntityFullInfo_RemovePSDEOPPriv(pSDETreeNode, bl);
        this.onFillEntityFullInfo_UpdatePSDEOPPriv(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSDER(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSDEToolbar(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSDETreeView(pSDETreeNode, bl);
        this.onFillEntityFullInfo_No2PSDEUAGroup(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSDETreeNode, bl);
        this.onFillEntityFullInfo_NamePSLanRes(pSDETreeNode, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDETreeNode, bl);
        this.onFillEntityFullInfo_ShapePSSysCss(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSDETreeNode, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSDETreeNode, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isPSDEIdDirty()) {
            if (pSDETreeNode.getPSDEId() != null) {
                if (pSDETreeNode.getPSDEId() == null || pSDETreeNode.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDETreeNode.getPSDE();
                    pSDETreeNode.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDETreeNode.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MovePSDEAction(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEAction(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UpdatePSDEAction(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_FilterPSDEDS(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDS(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ChildCntPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isChildCntPSDEFIdDirty()) {
            if (pSDETreeNode.getChildCntPSDEFId() != null) {
                if (pSDETreeNode.getChildCntPSDEFId() == null || pSDETreeNode.getChildCntPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getChildCntPSDEF();
                    pSDETreeNode.setChildCntPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setChildCntPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ClsPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isClsPSDEFIdDirty()) {
            if (pSDETreeNode.getClsPSDEFId() != null) {
                if (pSDETreeNode.getClsPSDEFId() == null || pSDETreeNode.getClsPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getClsPSDEF();
                    pSDETreeNode.setClsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setClsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Data2PSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isData2PSDEFIdDirty()) {
            if (pSDETreeNode.getData2PSDEFId() != null) {
                if (pSDETreeNode.getData2PSDEFId() == null || pSDETreeNode.getData2PSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getData2PSDEF();
                    pSDETreeNode.setData2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setData2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DataPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isDataPSDEFIdDirty()) {
            if (pSDETreeNode.getDataPSDEFId() != null) {
                if (pSDETreeNode.getDataPSDEFId() == null || pSDETreeNode.getDataPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getDataPSDEF();
                    pSDETreeNode.setDataPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setDataPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DataTypePSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isDataTypePSDEFIdDirty()) {
            if (pSDETreeNode.getDataTypePSDEFId() != null) {
                if (pSDETreeNode.getDataTypePSDEFId() == null || pSDETreeNode.getDataTypePSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getDataTypePSDEF();
                    pSDETreeNode.setDataTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setDataTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IconPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isIconPSDEFIdDirty()) {
            if (pSDETreeNode.getIconPSDEFId() != null) {
                if (pSDETreeNode.getIconPSDEFId() == null || pSDETreeNode.getIconPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getIconPSDEF();
                    pSDETreeNode.setIconPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setIconPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_KeyPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isKeyPSDEFIdDirty()) {
            if (pSDETreeNode.getKeyPSDEFId() != null) {
                if (pSDETreeNode.getKeyPSDEFId() == null || pSDETreeNode.getKeyPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getKeyPSDEF();
                    pSDETreeNode.setKeyPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setKeyPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LeafFlagPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isLeafFlagPSDEFIdDirty()) {
            if (pSDETreeNode.getLeafFlagPSDEFId() != null) {
                if (pSDETreeNode.getLeafFlagPSDEFId() == null || pSDETreeNode.getLeafFlagPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getLeafFlagPSDEF();
                    pSDETreeNode.setLeafFlagPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setLeafFlagPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LinkPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isLinkPSDEFIdDirty()) {
            if (pSDETreeNode.getLinkPSDEFId() != null) {
                if (pSDETreeNode.getLinkPSDEFId() == null || pSDETreeNode.getLinkPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getLinkPSDEF();
                    pSDETreeNode.setLinkPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setLinkPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_NodeId2PSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isNodeId2PSDEFIdDirty()) {
            if (pSDETreeNode.getNodeId2PSDEFId() != null) {
                if (pSDETreeNode.getNodeId2PSDEFId() == null || pSDETreeNode.getNodeId2PSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getNodeId2PSDEF();
                    pSDETreeNode.setNodeId2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setNodeId2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_NodeId3PSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isNodeId3PSDEFIdDirty()) {
            if (pSDETreeNode.getNodeId3PSDEFId() != null) {
                if (pSDETreeNode.getNodeId3PSDEFId() == null || pSDETreeNode.getNodeId3PSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getNodeId3PSDEF();
                    pSDETreeNode.setNodeId3PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setNodeId3PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_NodeId4PSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isNodeId4PSDEFIdDirty()) {
            if (pSDETreeNode.getNodeId4PSDEFId() != null) {
                if (pSDETreeNode.getNodeId4PSDEFId() == null || pSDETreeNode.getNodeId4PSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getNodeId4PSDEF();
                    pSDETreeNode.setNodeId4PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setNodeId4PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_NodeIdPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isNodeIdPSDEFIdDirty()) {
            if (pSDETreeNode.getNodeIdPSDEFId() != null) {
                if (pSDETreeNode.getNodeIdPSDEFId() == null || pSDETreeNode.getNodeIdPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getNodeIdPSDEF();
                    pSDETreeNode.setNodeIdPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setNodeIdPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ShapeClsPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isShapeClsPSDEFIdDirty()) {
            if (pSDETreeNode.getShapeClsPSDEFId() != null) {
                if (pSDETreeNode.getShapeClsPSDEFId() == null || pSDETreeNode.getShapeClsPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getShapeClsPSDEF();
                    pSDETreeNode.setShapeClsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setShapeClsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SortPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isSortPSDEFIdDirty()) {
            if (pSDETreeNode.getSortPSDEFId() != null) {
                if (pSDETreeNode.getSortPSDEFId() == null || pSDETreeNode.getSortPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getSortPSDEF();
                    pSDETreeNode.setSortPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setSortPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TextPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isTextPSDEFIdDirty()) {
            if (pSDETreeNode.getTextPSDEFId() != null) {
                if (pSDETreeNode.getTextPSDEFId() == null || pSDETreeNode.getTextPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getTextPSDEF();
                    pSDETreeNode.setTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipsPSDEF(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isTipsPSDEFIdDirty()) {
            if (pSDETreeNode.getTipsPSDEFId() != null) {
                if (pSDETreeNode.getTipsPSDEFId() == null || pSDETreeNode.getTipsPSDEFName() == null) {
                    PSDEField pSDEField = pSDETreeNode.getTipsPSDEF();
                    pSDETreeNode.setTipsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDETreeNode.setTipsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEGrid(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MovePSDEOPPriv(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEOPPriv(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UpdatePSDEOPPriv(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDER(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isPSDERIdDirty()) {
            if (pSDETreeNode.getPSDERId() != null) {
                if (pSDETreeNode.getPSDERId() == null || pSDETreeNode.getPSDERName() == null) {
                    PSDER pSDER = pSDETreeNode.getPSDER();
                    pSDETreeNode.setPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDETreeNode.setPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEToolbar(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeView(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_No2PSDEUAGroup(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isNo2PSDEUAGroupIdDirty()) {
            if (pSDETreeNode.getNo2PSDEUAGroupId() != null) {
                if (pSDETreeNode.getNo2PSDEUAGroupId() == null || pSDETreeNode.getNo2PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDETreeNode.getNo2PSDEUAGroup();
                    pSDETreeNode.setNo2PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDETreeNode.setNo2PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isPSDEUAGroupIdDirty()) {
            if (pSDETreeNode.getPSDEUAGroupId() != null) {
                if (pSDETreeNode.getPSDEUAGroupId() == null || pSDETreeNode.getPSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDETreeNode.getPSDEUAGroup();
                    pSDETreeNode.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDETreeNode.setPSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NamePSLanRes(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isNamePSLanResIdDirty()) {
            if (pSDETreeNode.getNamePSLanResId() != null) {
                if (pSDETreeNode.getNamePSLanResId() == null || pSDETreeNode.getNamePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDETreeNode.getNamePSLanRes();
                    pSDETreeNode.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDETreeNode.setNamePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        if (pSDETreeNode.isTipPSLanResIdDirty()) {
            if (pSDETreeNode.getTipPSLanResId() != null) {
                if (pSDETreeNode.getTipPSLanResId() == null || pSDETreeNode.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDETreeNode.getTipPSLanRes();
                    pSDETreeNode.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDETreeNode.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ShapePSSysCss(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        super.onWriteBackParent(pSDETreeNode, bl);
    }

    public ArrayList<PSDETreeNode> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNode> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNode> selectByMovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNode> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPDATEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUpdatePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUpdatePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByFilterPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByFilterPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByFilterPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByFilterPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByFilterPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FILTERPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFilterPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFilterPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByChildCntPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByChildCntPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByChildCntPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByChildCntPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByChildCntPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CHILDCNTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByChildCntPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByChildCntPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByClsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByClsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CLSPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByClsPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByClsPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByData2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByData2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByData2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByData2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByData2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DATA2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByData2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByData2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDataPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDataPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DATAPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDataPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDataPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByDataTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDataTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByDataTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDataTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByDataTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DATATYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDataTypePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDataTypePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIconPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIconPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ICONPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByIconPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByIconPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEYPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKeyPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKeyPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByLeafFlagPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByLeafFlagPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByLeafFlagPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByLeafFlagPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByLeafFlagPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LEAFFLAGPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLeafFlagPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLeafFlagPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByLinkPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByLinkPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByNodeId2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByNodeId2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByNodeId2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByNodeId2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByNodeId2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NODEID2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNodeId2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNodeId2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByNodeId3PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByNodeId3PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByNodeId3PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByNodeId3PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByNodeId3PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NODEID3PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNodeId3PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNodeId3PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByNodeId4PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByNodeId4PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByNodeId4PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByNodeId4PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByNodeId4PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NODEID4PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNodeId4PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNodeId4PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByNodeIdPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByNodeIdPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByNodeIdPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByNodeIdPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByNodeIdPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NODEIDPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNodeIdPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNodeIdPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByShapeClsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByShapeClsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByShapeClsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByShapeClsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByShapeClsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SHAPECLSPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByShapeClsPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByShapeClsPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectBySortPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectBySortPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectBySortPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectBySortPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectBySortPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SORTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySortPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySortPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEXTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTextPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTextPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByTipsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTipsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByTipsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTipsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByTipsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIPSPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTipsPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTipsPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNode> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNode> selectByMovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByMovePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByMovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByMovePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByMovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOVEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMovePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMovePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByRemovePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByRemovePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMOVEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemovePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemovePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByUpdatePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByUpdatePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPDATEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUpdatePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUpdatePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNode> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNode> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectTempByPSDETreeView(pSDETreeViewBase, "");
    }

    public ArrayList<PSDETreeNode> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREEVIEWID", (Object)pSDETreeViewBase.getPSDETreeViewId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeViewCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo2PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo2PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNode> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAMEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNamePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNamePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTipPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTipPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByShapePSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByShapePSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByShapePSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByShapePSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByShapePSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SHAPEPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByShapePSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByShapePSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeNode> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNIRESID", (Object)pSSysUniResBase.getPSSysUniResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNode> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDETreeNode> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDETreeNode> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSCodeListId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDEId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByMovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEACTION_MOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByMovePSDEAction(pSDEAction);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setMovePSDEActionId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByMovePSDEAction(pSDEAction2);
                PSDETreeNodeServiceBase.this.internalRemoveByMovePSDEAction(pSDEAction2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByMovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByMovePSDEAction(pSDEAction);
        this.onBeforeRemoveByMovePSDEAction(pSDEAction, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByMovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDEActionId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByRemovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEACTION_REMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setRemovePSDEActionId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByRemovePSDEAction(pSDEAction2);
                PSDETreeNodeServiceBase.this.internalRemoveByRemovePSDEAction(pSDEAction2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByRemovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        this.onBeforeRemoveByRemovePSDEAction(pSDEAction, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByRemovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByUpdatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEACTION_UPDATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setUpdatePSDEActionId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByUpdatePSDEAction(pSDEAction2);
                PSDETreeNodeServiceBase.this.internalRemoveByUpdatePSDEAction(pSDEAction2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByUpdatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        this.onBeforeRemoveByUpdatePSDEAction(pSDEAction, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByUpdatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByFilterPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEDATASET_FILTERPSDEDSID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByFilterPSDEDS(pSDEDataSet);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setFilterPSDEDSId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByFilterPSDEDS(pSDEDataSet2);
                PSDETreeNodeServiceBase.this.internalRemoveByFilterPSDEDS(pSDEDataSet2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByFilterPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByFilterPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByFilterPSDEDS(pSDEDataSet, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByFilterPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDEDSId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByChildCntPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByChildCntPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_CHILDCNTPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetChildCntPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByChildCntPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setChildCntPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByChildCntPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByChildCntPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByChildCntPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByChildCntPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByChildCntPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByChildCntPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByChildCntPSDEF(pSDEField);
        this.onBeforeRemoveByChildCntPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByChildCntPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByChildCntPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByChildCntPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByChildCntPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByClsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_CLSPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByClsPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setClsPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByClsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByClsPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByClsPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByClsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByClsPSDEF(pSDEField);
        this.onBeforeRemoveByClsPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByClsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByClsPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByClsPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByData2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_DATA2PSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetData2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByData2PSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setData2PSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByData2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByData2PSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByData2PSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByData2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByData2PSDEF(pSDEField);
        this.onBeforeRemoveByData2PSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByData2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByData2PSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByData2PSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByDataPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_DATAPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByDataPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setDataPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByDataPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByDataPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByDataPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByDataPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByDataPSDEF(pSDEField);
        this.onBeforeRemoveByDataPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByDataPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDataPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDataPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByDataTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByDataTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_DATATYPEPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetDataTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByDataTypePSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setDataTypePSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByDataTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByDataTypePSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByDataTypePSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByDataTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDataTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDataTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByDataTypePSDEF(pSDEField);
        this.onBeforeRemoveByDataTypePSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByDataTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDataTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDataTypePSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDataTypePSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByIconPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_ICONPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByIconPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setIconPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByIconPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByIconPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByIconPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByIconPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByIconPSDEF(pSDEField);
        this.onBeforeRemoveByIconPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByIconPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIconPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIconPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByKeyPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_KEYPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByKeyPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setKeyPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByKeyPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByKeyPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByKeyPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByKeyPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByKeyPSDEF(pSDEField);
        this.onBeforeRemoveByKeyPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByKeyPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByLeafFlagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByLeafFlagPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_LEAFFLAGPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetLeafFlagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByLeafFlagPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setLeafFlagPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByLeafFlagPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByLeafFlagPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByLeafFlagPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByLeafFlagPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByLeafFlagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByLeafFlagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByLeafFlagPSDEF(pSDEField);
        this.onBeforeRemoveByLeafFlagPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByLeafFlagPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByLeafFlagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByLeafFlagPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLeafFlagPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByLinkPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_LINKPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByLinkPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setLinkPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByLinkPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByLinkPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByLinkPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByLinkPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByLinkPSDEF(pSDEField);
        this.onBeforeRemoveByLinkPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByLinkPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByNodeId2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeId2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_NODEID2PSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetNodeId2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeId2PSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setNodeId2PSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByNodeId2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByNodeId2PSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByNodeId2PSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByNodeId2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByNodeId2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByNodeId2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeId2PSDEF(pSDEField);
        this.onBeforeRemoveByNodeId2PSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByNodeId2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByNodeId2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByNodeId2PSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNodeId2PSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByNodeId3PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeId3PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_NODEID3PSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetNodeId3PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeId3PSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setNodeId3PSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByNodeId3PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByNodeId3PSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByNodeId3PSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByNodeId3PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByNodeId3PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByNodeId3PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeId3PSDEF(pSDEField);
        this.onBeforeRemoveByNodeId3PSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByNodeId3PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByNodeId3PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByNodeId3PSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNodeId3PSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByNodeId4PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeId4PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_NODEID4PSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetNodeId4PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeId4PSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setNodeId4PSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByNodeId4PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByNodeId4PSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByNodeId4PSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByNodeId4PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByNodeId4PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByNodeId4PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeId4PSDEF(pSDEField);
        this.onBeforeRemoveByNodeId4PSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByNodeId4PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByNodeId4PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByNodeId4PSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNodeId4PSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByNodeIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeIdPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_NODEIDPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetNodeIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeIdPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setNodeIdPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByNodeIdPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByNodeIdPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByNodeIdPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByNodeIdPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByNodeIdPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByNodeIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNodeIdPSDEF(pSDEField);
        this.onBeforeRemoveByNodeIdPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByNodeIdPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByNodeIdPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByNodeIdPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNodeIdPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByShapeClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByShapeClsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_SHAPECLSPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetShapeClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByShapeClsPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setShapeClsPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByShapeClsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByShapeClsPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByShapeClsPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByShapeClsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByShapeClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByShapeClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByShapeClsPSDEF(pSDEField);
        this.onBeforeRemoveByShapeClsPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByShapeClsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByShapeClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByShapeClsPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByShapeClsPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveBySortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectBySortPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_SORTPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectBySortPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setSortPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeBySortPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveBySortPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveBySortPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveBySortPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveBySortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveBySortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectBySortPSDEF(pSDEField);
        this.onBeforeRemoveBySortPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveBySortPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveBySortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveBySortPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySortPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_TEXTPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByTextPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setTextPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByTextPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByTextPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByTextPSDEF(pSDEField);
        this.onBeforeRemoveByTextPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByTipsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEFIELD_TIPSPSDEFID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTipsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByTipsPSDEF(pSDEField);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setTipsPSDEFId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByTipsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByTipsPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.internalRemoveByTipsPSDEF(pSDEField2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByTipsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByTipsPSDEF(pSDEField);
        this.onBeforeRemoveByTipsPSDEF(pSDEField, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByTipsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTipsPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipsPSDEF(PSDEField pSDEField, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEGrid(pSDEGrid, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEGRID");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEGrid);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEGRID_PSDEGRIDID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEGrid), arrayList.get(0)));
        }
    }

    public void resetPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEGrid(pSDEGrid);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDEGridId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSDEGrid(pSDEGrid2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSDEGrid(pSDEGrid2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveByPSDEGrid(pSDEGrid, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDELogicId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByMovePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEOPPRIV_MOVEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByMovePSDEOPPriv(pSDEOPPriv);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setMovePSDEOPPrivId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByMovePSDEOPPriv(pSDEOPPriv2);
                PSDETreeNodeServiceBase.this.internalRemoveByMovePSDEOPPriv(pSDEOPPriv2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByMovePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByMovePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByMovePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByMovePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEOPPRIV_REMOVEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setRemovePSDEOPPrivId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
                PSDETreeNodeServiceBase.this.internalRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByRemovePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByRemovePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEOPPRIV_UPDATEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setUpdatePSDEOPPrivId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
                PSDETreeNodeServiceBase.this.internalRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByUpdatePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByUpdatePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDER(pSDER);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDERId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDETOOLBAR_PSDETOOLBARID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDEToolbarId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSDEToolbar(pSDEToolbar2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSDEToolbar(pSDEToolbar2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    public void resetPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDETreeView(pSDETreeView);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDETreeViewId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void resetTempPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDETreeViewId(null);
            this.updateTemp(pSDETreeNode2);
        }
    }

    public void removeByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSDETreeView(pSDETreeView2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSDETreeView(pSDETreeView2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEUAGROUP_NO2PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setNo2PSDEUAGroupId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
                PSDETreeNodeServiceBase.this.internalRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo2PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByNo2PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDEUAGroupId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSDEViewBaseId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNamePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSLANGUAGERES_NAMEPSLANRESID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setNamePSLanResId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByNamePSLanRes(pSLanguageRes2);
                PSDETreeNodeServiceBase.this.internalRemoveByNamePSLanRes(pSLanguageRes2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByNamePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByNamePSLanRes(pSLanguageRes, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByNamePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setTipPSLanResId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSDETreeNodeServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSSysCssId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByShapePSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByShapePSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSSYSCSS_SHAPEPSSYSCSSID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetShapePSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByShapePSSysCss(pSSysCss);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setShapePSSysCssId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByShapePSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByShapePSSysCss(pSSysCss2);
                PSDETreeNodeServiceBase.this.internalRemoveByShapePSSysCss(pSSysCss2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByShapePSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByShapePSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByShapePSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByShapePSSysCss(pSSysCss);
        this.onBeforeRemoveByShapePSSysCss(pSSysCss, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByShapePSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByShapePSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByShapePSSysCss(PSSysCss pSSysCss, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByShapePSSysCss(PSSysCss pSSysCss, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSSysImageId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSSysPFPluginId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSSysUniResId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDETREENODE", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            PSDETreeNode pSDETreeNode2 = (PSDETreeNode)this.getDEModel().createEntity();
            pSDETreeNode2.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
            pSDETreeNode2.setPSSysViewPanelId(null);
            this.update(pSDETreeNode2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDETreeNodeServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDETreeNodeServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.remove(pSDETreeNode);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDETreeNode pSDETreeNode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeNode(pSDETreeNode);
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).removeByPSDETreeNode(pSDETreeNode);
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeNode(pSDETreeNode);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeNode(pSDETreeNode);
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).removeByPSDETreeNode(pSDETreeNode);
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).testRemoveByCPSDETreeNode(pSDETreeNode);
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).testRemoveByPPSDETreeNode(pSDETreeNode);
        pSCoreSysServiceBase = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRVServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeNode(pSDETreeNode);
        ((PSDETreeNodeRVServiceBase)pSCoreSysServiceBase).removeByPSDETreeNode(pSDETreeNode);
        super.onBeforeRemove(pSDETreeNode);
    }

    protected void onBeforeRemoveTemp(PSDETreeNode pSDETreeNode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRVServiceBase)pSCoreSysServiceBase).removeTempByPSDETreeNode(pSDETreeNode);
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).resetTempPPSDETreeNode(pSDETreeNode);
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).resetTempCPSDETreeNode(pSDETreeNode);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).resetTempPSDETreeNode(pSDETreeNode);
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).resetTempPSDETreeNode(pSDETreeNode);
        pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).resetTempPSDETreeNode(pSDETreeNode);
        super.onBeforeRemoveTemp(pSDETreeNode);
    }

    public void removeTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeServiceBase.this.onBeforeRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETreeNodeServiceBase.this.internalRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETreeNodeServiceBase.this.onAfterRemoveTempByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETreeNode> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveTempByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            this.removeTemp(pSDETreeNode);
        }
        this.onAfterRemoveTempByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETreeNode> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDETreeNode pSDETreeNode) throws Exception {
        this.getRelatedDataTempMajor_PSDETreeNodeRV(pSDETreeNode);
        super.getRelatedDataTempMajor(pSDETreeNode);
    }

    protected void getRelatedDataTempMajor_PSDETreeNodeRV(PSDETreeNode pSDETreeNode) throws Exception {
        PSDETreeNodeRVService pSDETreeNodeRVService = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeRV> arrayList = null;
        String string = pSDETreeNode.getPSDETreeNodeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETreeNodeRVService.selectByPSDETreeNode(pSDETreeNode) : pSDETreeNodeRVService.selectTempByPSDETreeNode(pSDETreeNode);
        for (PSDETreeNodeRV pSDETreeNodeRV : arrayList) {
            pSDETreeNodeRVService.getTempMajor(pSDETreeNodeRV);
        }
    }

    protected void updateRelatedDataTempMajor(PSDETreeNode pSDETreeNode, PSDETreeNode pSDETreeNode2) throws Exception {
        ArrayList<PSDETreeNodeRV> arrayList = this.updateRelatedDataTempMajor_removePSDETreeNodeRV(pSDETreeNode, pSDETreeNode2);
        this.updateRelatedDataTempMajor_updatePSDETreeNodeRV(pSDETreeNode, pSDETreeNode2, arrayList);
        super.updateRelatedDataTempMajor(pSDETreeNode, pSDETreeNode2);
    }

    protected ArrayList<PSDETreeNodeRV> updateRelatedDataTempMajor_removePSDETreeNodeRV(PSDETreeNode pSDETreeNode, PSDETreeNode pSDETreeNode2) throws Exception {
        PSDETreeNodeRVService pSDETreeNodeRVService = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeRV> arrayList = pSDETreeNodeRVService.selectTempByPSDETreeNode(pSDETreeNode);
        ArrayList<PSDETreeNodeRV> arrayList2 = pSDETreeNodeRVService.selectByPSDETreeNode(pSDETreeNode2);
        HashMap<String, PSDETreeNodeRV> hashMap = new HashMap<String, PSDETreeNodeRV>();
        for (PSDETreeNodeRV pSDETreeNodeRV : arrayList2) {
            hashMap.put(pSDETreeNodeRV.getPSDETreeNodeRVId(), pSDETreeNodeRV);
        }
        for (PSDETreeNodeRV pSDETreeNodeRV : arrayList) {
            Object object = pSDETreeNodeRV.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDETreeNodeRV pSDETreeNodeRV : hashMap.values()) {
            pSDETreeNodeRVService.remove(pSDETreeNodeRV);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDETreeNodeRV(PSDETreeNode pSDETreeNode, PSDETreeNode pSDETreeNode2, ArrayList<PSDETreeNodeRV> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDETreeNodeRVService pSDETreeNodeRVService = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
        for (PSDETreeNodeRV pSDETreeNodeRV : arrayList) {
            pSDETreeNodeRVService.updateTempMajor(pSDETreeNodeRV);
        }
    }

    protected void replaceParentInfo(PSDETreeNode pSDETreeNode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDETreeNode, cloneSession);
        if (pSDETreeNode.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDETreeNode.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSDETreeNode, (PSCodeList)iEntity);
        }
        if (pSDETreeNode.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDETreeNode.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDETreeNode, (PSDataEntity)iEntity);
        }
        if (pSDETreeNode.getMovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDETreeNode.getMovePSDEActionId())) != null) {
            this.onFillParentInfo_MovePSDEAction(pSDETreeNode, (PSDEAction)iEntity);
        }
        if (pSDETreeNode.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDETreeNode.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDETreeNode, (PSDEAction)iEntity);
        }
        if (pSDETreeNode.getRemovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDETreeNode.getRemovePSDEActionId())) != null) {
            this.onFillParentInfo_RemovePSDEAction(pSDETreeNode, (PSDEAction)iEntity);
        }
        if (pSDETreeNode.getUpdatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDETreeNode.getUpdatePSDEActionId())) != null) {
            this.onFillParentInfo_UpdatePSDEAction(pSDETreeNode, (PSDEAction)iEntity);
        }
        if (pSDETreeNode.getFilterPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDETreeNode.getFilterPSDEDSId())) != null) {
            this.onFillParentInfo_FilterPSDEDS(pSDETreeNode, (PSDEDataSet)iEntity);
        }
        if (pSDETreeNode.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDETreeNode.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSDETreeNode, (PSDEDataSet)iEntity);
        }
        if (pSDETreeNode.getChildCntPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getChildCntPSDEFId())) != null) {
            this.onFillParentInfo_ChildCntPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getClsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getClsPSDEFId())) != null) {
            this.onFillParentInfo_ClsPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getData2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getData2PSDEFId())) != null) {
            this.onFillParentInfo_Data2PSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getDataPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getDataPSDEFId())) != null) {
            this.onFillParentInfo_DataPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getDataTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getDataTypePSDEFId())) != null) {
            this.onFillParentInfo_DataTypePSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getIconPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getIconPSDEFId())) != null) {
            this.onFillParentInfo_IconPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getKeyPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getKeyPSDEFId())) != null) {
            this.onFillParentInfo_KeyPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getLeafFlagPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getLeafFlagPSDEFId())) != null) {
            this.onFillParentInfo_LeafFlagPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getLinkPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getLinkPSDEFId())) != null) {
            this.onFillParentInfo_LinkPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getNodeId2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getNodeId2PSDEFId())) != null) {
            this.onFillParentInfo_NodeId2PSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getNodeId3PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getNodeId3PSDEFId())) != null) {
            this.onFillParentInfo_NodeId3PSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getNodeId4PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getNodeId4PSDEFId())) != null) {
            this.onFillParentInfo_NodeId4PSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getNodeIdPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getNodeIdPSDEFId())) != null) {
            this.onFillParentInfo_NodeIdPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getShapeClsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getShapeClsPSDEFId())) != null) {
            this.onFillParentInfo_ShapeClsPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getSortPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getSortPSDEFId())) != null) {
            this.onFillParentInfo_SortPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getTextPSDEFId())) != null) {
            this.onFillParentInfo_TextPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getTipsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDETreeNode.getTipsPSDEFId())) != null) {
            this.onFillParentInfo_TipsPSDEF(pSDETreeNode, (PSDEField)iEntity);
        }
        if (pSDETreeNode.getPSDEGridId() != null && (iEntity = cloneSession.getEntity("PSDEGRID", (Object)pSDETreeNode.getPSDEGridId())) != null) {
            this.onFillParentInfo_PSDEGrid(pSDETreeNode, (PSDEGrid)iEntity);
        }
        if (pSDETreeNode.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDETreeNode.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDETreeNode, (PSDELogic)iEntity);
        }
        if (pSDETreeNode.getMovePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDETreeNode.getMovePSDEOPPrivId())) != null) {
            this.onFillParentInfo_MovePSDEOPPriv(pSDETreeNode, (PSDEOPPriv)iEntity);
        }
        if (pSDETreeNode.getRemovePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDETreeNode.getRemovePSDEOPPrivId())) != null) {
            this.onFillParentInfo_RemovePSDEOPPriv(pSDETreeNode, (PSDEOPPriv)iEntity);
        }
        if (pSDETreeNode.getUpdatePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDETreeNode.getUpdatePSDEOPPrivId())) != null) {
            this.onFillParentInfo_UpdatePSDEOPPriv(pSDETreeNode, (PSDEOPPriv)iEntity);
        }
        if (pSDETreeNode.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDETreeNode.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDETreeNode, (PSDER)iEntity);
        }
        if (pSDETreeNode.getPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDETreeNode.getPSDEToolbarId())) != null) {
            this.onFillParentInfo_PSDEToolbar(pSDETreeNode, (PSDEToolbar)iEntity);
        }
        if (pSDETreeNode.getPSDETreeViewId() != null && (iEntity = cloneSession.getEntity("PSDETREEVIEW", (Object)pSDETreeNode.getPSDETreeViewId())) != null) {
            this.onFillParentInfo_PSDETreeView(pSDETreeNode, (PSDETreeView)iEntity);
        }
        if (pSDETreeNode.getNo2PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDETreeNode.getNo2PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No2PSDEUAGroup(pSDETreeNode, (PSDEUAGroup)iEntity);
        }
        if (pSDETreeNode.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDETreeNode.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDETreeNode, (PSDEUAGroup)iEntity);
        }
        if (pSDETreeNode.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDETreeNode.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSDETreeNode, (PSDEViewBase)iEntity);
        }
        if (pSDETreeNode.getNamePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDETreeNode.getNamePSLanResId())) != null) {
            this.onFillParentInfo_NamePSLanRes(pSDETreeNode, (PSLanguageRes)iEntity);
        }
        if (pSDETreeNode.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDETreeNode.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSDETreeNode, (PSLanguageRes)iEntity);
        }
        if (pSDETreeNode.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDETreeNode.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDETreeNode, (PSSysCss)iEntity);
        }
        if (pSDETreeNode.getShapePSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDETreeNode.getShapePSSysCssId())) != null) {
            this.onFillParentInfo_ShapePSSysCss(pSDETreeNode, (PSSysCss)iEntity);
        }
        if (pSDETreeNode.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDETreeNode.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDETreeNode, (PSSysImage)iEntity);
        }
        if (pSDETreeNode.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDETreeNode.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDETreeNode, (PSSysPFPlugin)iEntity);
        }
        if (pSDETreeNode.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSDETreeNode.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSDETreeNode, (PSSysUniRes)iEntity);
        }
        if (pSDETreeNode.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDETreeNode.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSDETreeNode, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDETreeNode, bl);
    }

    protected void onCheckEntity(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionParam(bl, pSDETreeNode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppendCapFlag(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppendPNodeId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Checked(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ChildCntPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ChildCntPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CMRefresh(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CMRemove(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterMode(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data2PSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data2PSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataSource(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataTypePSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataTypePSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DisableSelect(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DistinctMode(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditDataMode(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditMode(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCheck(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePaging(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableQuickSearch(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableUP(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableViewActions(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Expand(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FilterPSDEDSId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeafFlagPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeafFlagPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxSize(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelObj(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MovePSDEActionId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MovePSDEOPPrivId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilter(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilterDesc(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewParam(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewDataMode(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEUAGroupId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEUAGroupName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeAction(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeDataType(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeId2PSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeId2PSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeId3PSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeId3PSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeId4PSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeId4PSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeIdPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeIdPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeType(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeValue(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageSize(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreventXSS(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEActionId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEOPPrivId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RootNode(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Selected(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeClsPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeClsPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeDynaClass(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapePSSysCssId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SortDir(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SortPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SortPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipsPSDEFId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipsPSDEFName(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TreeNodeType(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEActionId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEOPPrivId(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewActions(bl, pSDETreeNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDETreeNode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionParam(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isActionParamDirty() : !pSDETreeNode.isActionParamDirty()) {
            return null;
        }
        String string = pSDETreeNode.getActionParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionParam_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppendCapFlag(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isAppendCapFlagDirty() : !pSDETreeNode.isAppendCapFlagDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getAppendCapFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AppendCapFlag_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPENDCAPFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppendPNodeId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isAppendPNodeIdDirty() && !bl2 : !pSDETreeNode.isAppendPNodeIdDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getAppendPNodeId();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPENDPNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AppendPNodeId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPENDPNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isCaptionDirty() : !pSDETreeNode.isCaptionDirty()) {
            return null;
        }
        String string = pSDETreeNode.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Checked(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isCheckedDirty() : !pSDETreeNode.isCheckedDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getChecked();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Checked_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHECKED");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ChildCntPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isChildCntPSDEFIdDirty() : !pSDETreeNode.isChildCntPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getChildCntPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChildCntPSDEFId_ChildCntPSDEF(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILDCNTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_ChildCntPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILDCNTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ChildCntPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isChildCntPSDEFNameDirty() : !pSDETreeNode.isChildCntPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getChildCntPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChildCntPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILDCNTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClsPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isClsPSDEFIdDirty() : !pSDETreeNode.isClsPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getClsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLSPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClsPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isClsPSDEFNameDirty() : !pSDETreeNode.isClsPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getClsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLSPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CMRefresh(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isCMRefreshDirty() : !pSDETreeNode.isCMRefreshDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getCMRefresh();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CMRefresh_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CMREFRESH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CMRemove(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isCMRemoveDirty() : !pSDETreeNode.isCMRemoveDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getCMRemove();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CMRemove_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CMREMOVE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CounterId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isCounterIdDirty() : !pSDETreeNode.isCounterIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CounterId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CounterMode(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isCounterModeDirty() : !pSDETreeNode.isCounterModeDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getCounterMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CounterMode_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isCustomCodeDirty() : !pSDETreeNode.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDETreeNode.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isCustomCondDirty() : !pSDETreeNode.isCustomCondDirty()) {
            return null;
        }
        String string = pSDETreeNode.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isCustomTypeDirty() : !pSDETreeNode.isCustomTypeDirty()) {
            return null;
        }
        String string = pSDETreeNode.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data2PSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isData2PSDEFIdDirty() : !pSDETreeNode.isData2PSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getData2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data2PSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data2PSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isData2PSDEFNameDirty() : !pSDETreeNode.isData2PSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getData2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data2PSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isDataPSDEFIdDirty() : !pSDETreeNode.isDataPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getDataPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isDataPSDEFNameDirty() : !pSDETreeNode.isDataPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getDataPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataSource(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isDataSourceDirty() : !pSDETreeNode.isDataSourceDirty()) {
            return null;
        }
        String string = pSDETreeNode.getDataSource();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataSource_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATASOURCE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataTypePSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isDataTypePSDEFIdDirty() : !pSDETreeNode.isDataTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getDataTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataTypePSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATATYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataTypePSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isDataTypePSDEFNameDirty() : !pSDETreeNode.isDataTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getDataTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataTypePSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATATYPEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DisableSelect(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isDisableSelectDirty() : !pSDETreeNode.isDisableSelectDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getDisableSelect();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DisableSelect_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DISABLESELECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DistinctMode(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isDistinctModeDirty() : !pSDETreeNode.isDistinctModeDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getDistinctMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DistinctMode_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DISTINCTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isDynaClassDirty() : !pSDETreeNode.isDynaClassDirty()) {
            return null;
        }
        String string = pSDETreeNode.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditDataMode(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isEditDataModeDirty() : !pSDETreeNode.isEditDataModeDirty()) {
            return null;
        }
        String string = pSDETreeNode.getEditDataMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditDataMode_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITDATAMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditMode(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isEditModeDirty() : !pSDETreeNode.isEditModeDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getEditMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EditMode_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCheck(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isEnableCheckDirty() : !pSDETreeNode.isEnableCheckDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getEnableCheck();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCheck_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECHECK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnablePaging(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isEnablePagingDirty() : !pSDETreeNode.isEnablePagingDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getEnablePaging();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnablePaging_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPAGING");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableQuickSearch(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isEnableQuickSearchDirty() : !pSDETreeNode.isEnableQuickSearchDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getEnableQuickSearch();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableQuickSearch_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEQUICKSEARCH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableUP(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isEnableUPDirty() : !pSDETreeNode.isEnableUPDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getEnableUP();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableUP_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEUP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableViewActions(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isEnableViewActionsDirty() : !pSDETreeNode.isEnableViewActionsDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getEnableViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableViewActions_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEVIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Expand(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isExpandDirty() : !pSDETreeNode.isExpandDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getExpand();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Expand_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPAND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isFieldNameDirty() : !pSDETreeNode.isFieldNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FilterPSDEDSId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isFilterPSDEDSIdDirty() : !pSDETreeNode.isFilterPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getFilterPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FilterPSDEDSId_FilterPSDEDS(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILTERPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_FilterPSDEDSId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILTERPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isIconPSDEFIdDirty() : !pSDETreeNode.isIconPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getIconPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPSDEFId_IconPSDEF(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_IconPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isIconPSDEFNameDirty() : !pSDETreeNode.isIconPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getIconPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isKeyPSDEFIdDirty() : !pSDETreeNode.isKeyPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getKeyPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFId_KeyPSDEF(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_KeyPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isKeyPSDEFNameDirty() : !pSDETreeNode.isKeyPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getKeyPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeafFlagPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isLeafFlagPSDEFIdDirty() : !pSDETreeNode.isLeafFlagPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getLeafFlagPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LeafFlagPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEAFFLAGPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeafFlagPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isLeafFlagPSDEFNameDirty() : !pSDETreeNode.isLeafFlagPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getLeafFlagPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LeafFlagPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEAFFLAGPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isLinkPSDEFIdDirty() : !pSDETreeNode.isLinkPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getLinkPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isLinkPSDEFNameDirty() : !pSDETreeNode.isLinkPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getLinkPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxSize(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isMaxSizeDirty() : !pSDETreeNode.isMaxSizeDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getMaxSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxSize_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isMemoDirty() : !pSDETreeNode.isMemoDirty()) {
            return null;
        }
        String string = pSDETreeNode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelObj(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isModelObjDirty() : !pSDETreeNode.isModelObjDirty()) {
            return null;
        }
        String string = pSDETreeNode.getModelObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelObj_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MovePSDEActionId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isMovePSDEActionIdDirty() : !pSDETreeNode.isMovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getMovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MovePSDEActionId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MovePSDEOPPrivId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isMovePSDEOPPrivIdDirty() : !pSDETreeNode.isMovePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getMovePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MovePSDEOPPrivId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOVEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NamePSLanResId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNamePSLanResIdDirty() : !pSDETreeNode.isNamePSLanResIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNamePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NamePSLanResName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNamePSLanResNameDirty() : !pSDETreeNode.isNamePSLanResNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNamePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewFilter(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNavViewFilterDirty() : !pSDETreeNode.isNavViewFilterDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNavViewFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilter_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewFilterDesc(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNavViewFilterDescDirty() : !pSDETreeNode.isNavViewFilterDescDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNavViewFilterDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilterDesc_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWFILTERDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewParam(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNavViewParamDirty() : !pSDETreeNode.isNavViewParamDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNavViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewParam_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewDataMode(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNewDataModeDirty() : !pSDETreeNode.isNewDataModeDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNewDataMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewDataMode_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWDATAMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDEUAGroupId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNo2PSDEUAGroupIdDirty() : !pSDETreeNode.isNo2PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNo2PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEUAGroupId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDEUAGroupName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNo2PSDEUAGroupNameDirty() : !pSDETreeNode.isNo2PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNo2PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEUAGroupName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeAction(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeActionDirty() : !pSDETreeNode.isNodeActionDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeAction_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeDataType(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeDataTypeDirty() : !pSDETreeNode.isNodeDataTypeDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeDataType_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeId2PSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeId2PSDEFIdDirty() : !pSDETreeNode.isNodeId2PSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeId2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeId2PSDEFId_NodeId2PSDEF(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEID2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_NodeId2PSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEID2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeId2PSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeId2PSDEFNameDirty() : !pSDETreeNode.isNodeId2PSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeId2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeId2PSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEID2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeId3PSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeId3PSDEFIdDirty() : !pSDETreeNode.isNodeId3PSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeId3PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeId3PSDEFId_NodeId3PSDEF(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEID3PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_NodeId3PSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEID3PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeId3PSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeId3PSDEFNameDirty() : !pSDETreeNode.isNodeId3PSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeId3PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeId3PSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEID3PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeId4PSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeId4PSDEFIdDirty() : !pSDETreeNode.isNodeId4PSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeId4PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeId4PSDEFId_NodeId4PSDEF(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEID4PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_NodeId4PSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEID4PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeId4PSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeId4PSDEFNameDirty() : !pSDETreeNode.isNodeId4PSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeId4PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeId4PSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEID4PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeIdPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeIdPSDEFIdDirty() : !pSDETreeNode.isNodeIdPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeIdPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeIdPSDEFId_NodeIdPSDEF(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEIDPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_NodeIdPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEIDPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeIdPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeIdPSDEFNameDirty() : !pSDETreeNode.isNodeIdPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeIdPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeIdPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEIDPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeType(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeTypeDirty() : !pSDETreeNode.isNodeTypeDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeType_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODETYPE");
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
                String string4 = this.checkFieldDupRule(this.getPSDETreeNodeDEModel(), "NODETYPE", string3, pSDETreeNode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("NODETYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeValue(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isNodeValueDirty() : !pSDETreeNode.isNodeValueDirty()) {
            return null;
        }
        String string = pSDETreeNode.getNodeValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeValue_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageSize(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPageSizeDirty() : !pSDETreeNode.isPageSizeDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getPageSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PageSize_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGESIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreventXSS(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPreventXSSDirty() : !pSDETreeNode.isPreventXSSDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getPreventXSS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PreventXSS_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVENTXSS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSCodeListIdDirty() : !pSDETreeNode.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDEActionIdDirty() : !pSDETreeNode.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDEDSIdDirty() : !pSDETreeNode.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_PSDEDS(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEDSId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDEGridIdDirty() : !pSDETreeNode.isPSDEGridIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDEGridId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDEIdDirty() : !pSDETreeNode.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDELogicIdDirty() : !pSDETreeNode.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDENameDirty() : !pSDETreeNode.isPSDENameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDERIdDirty() : !pSDETreeNode.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDERNameDirty() : !pSDETreeNode.isPSDERNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERName_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEToolbarId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDEToolbarIdDirty() : !pSDETreeNode.isPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDETreeNodeIdDirty() && !bl2 : !pSDETreeNode.isPSDETreeNodeIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDETreeNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETreeNodeName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDETreeNodeNameDirty() && !bl2 : !pSDETreeNode.isPSDETreeNodeNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDETreeNodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDETreeViewIdDirty() && !bl2 : !pSDETreeNode.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDETreeViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREEVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDEUAGroupIdDirty() : !pSDETreeNode.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDEUAGroupNameDirty() : !pSDETreeNode.isPSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSDEViewBaseIdDirty() : !pSDETreeNode.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSSysCssIdDirty() : !pSDETreeNode.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSSysImageIdDirty() : !pSDETreeNode.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSSysPFPluginIdDirty() : !pSDETreeNode.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSSysUniResIdDirty() : !pSDETreeNode.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNIRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isPSSysViewPanelIdDirty() : !pSDETreeNode.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemovePSDEActionId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isRemovePSDEActionIdDirty() : !pSDETreeNode.isRemovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getRemovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEActionId_RemovePSDEAction(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_RemovePSDEActionId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemovePSDEOPPrivId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isRemovePSDEOPPrivIdDirty() : !pSDETreeNode.isRemovePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getRemovePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEOPPrivId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RootNode(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isRootNodeDirty() && !bl2 : !pSDETreeNode.isRootNodeDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getRootNode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROOTNODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_RootNode_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROOTNODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDETREEVIEWID";
                String string2 = this.checkFieldDupRule(this.getPSDETreeNodeDEModel(), "ROOTNODE", string, pSDETreeNode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("ROOTNODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Selected(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isSelectedDirty() : !pSDETreeNode.isSelectedDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getSelected();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Selected_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SELECTED");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapeClsPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isShapeClsPSDEFIdDirty() : !pSDETreeNode.isShapeClsPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getShapeClsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeClsPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPECLSPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapeClsPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isShapeClsPSDEFNameDirty() : !pSDETreeNode.isShapeClsPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getShapeClsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeClsPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPECLSPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapeDynaClass(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isShapeDynaClassDirty() : !pSDETreeNode.isShapeDynaClassDirty()) {
            return null;
        }
        String string = pSDETreeNode.getShapeDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeDynaClass_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPEDYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapePSSysCssId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isShapePSSysCssIdDirty() : !pSDETreeNode.isShapePSSysCssIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getShapePSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapePSSysCssId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPEPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SortDir(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isSortDirDirty() : !pSDETreeNode.isSortDirDirty()) {
            return null;
        }
        String string = pSDETreeNode.getSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SortDir_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SortPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isSortPSDEFIdDirty() : !pSDETreeNode.isSortPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getSortPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SortPSDEFId_SortPSDEF(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_SortPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SortPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isSortPSDEFNameDirty() : !pSDETreeNode.isSortPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getSortPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SortPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SORTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isTextPSDEFIdDirty() : !pSDETreeNode.isTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFId_TextPSDEF(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_TextPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isTextPSDEFNameDirty() : !pSDETreeNode.isTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isTipPSLanResIdDirty() : !pSDETreeNode.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isTipPSLanResNameDirty() : !pSDETreeNode.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipsPSDEFId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isTipsPSDEFIdDirty() : !pSDETreeNode.isTipsPSDEFIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getTipsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipsPSDEFId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPSPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipsPSDEFName(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isTipsPSDEFNameDirty() : !pSDETreeNode.isTipsPSDEFNameDirty()) {
            return null;
        }
        String string = pSDETreeNode.getTipsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipsPSDEFName_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPSPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isTooltipInfoDirty() : !pSDETreeNode.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSDETreeNode.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLTIPINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TreeNodeType(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isTreeNodeTypeDirty() && !bl2 : !pSDETreeNode.isTreeNodeTypeDirty()) {
            return null;
        }
        String string = pSDETreeNode.getTreeNodeType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TREENODETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TreeNodeType_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TREENODETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePSDEActionId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isUpdatePSDEActionIdDirty() : !pSDETreeNode.isUpdatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getUpdatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEActionId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePSDEOPPrivId(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isUpdatePSDEOPPrivIdDirty() : !pSDETreeNode.isUpdatePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDETreeNode.getUpdatePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEOPPrivId_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isUserCatDirty() : !pSDETreeNode.isUserCatDirty()) {
            return null;
        }
        String string = pSDETreeNode.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isUserTagDirty() : !pSDETreeNode.isUserTagDirty()) {
            return null;
        }
        String string = pSDETreeNode.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isUserTag2Dirty() : !pSDETreeNode.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDETreeNode.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isUserTag3Dirty() : !pSDETreeNode.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDETreeNode.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isUserTag4Dirty() : !pSDETreeNode.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDETreeNode.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDETreeNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewActions(boolean bl, PSDETreeNode pSDETreeNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNode.isViewActionsDirty() : !pSDETreeNode.isViewActionsDirty()) {
            return null;
        }
        Integer n = pSDETreeNode.getViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewActions_Default(pSDETreeNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        super.onSyncEntity(pSDETreeNode, bl);
    }

    protected void onSyncIndexEntities(PSDETreeNode pSDETreeNode, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDETreeNode, bl);
    }

    public Object getDataContextValue(PSDETreeNode pSDETreeNode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDETreeNode, string, iDataContextParam)) != null) {
            return object;
        }
        PSDETreeView pSDETreeView = pSDETreeNode.getPSDETreeView();
        if (pSDETreeView != null && pSDETreeView.contains(string)) {
            return pSDETreeView.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDETreeNode pSDETreeNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_NamePSLanRes(pSDETreeNode, arrayList, n);
        super.onExportMajorModel(pSDETreeNode, arrayList, n);
    }

    protected void onExportMajorModel_NamePSLanRes(PSDETreeNode pSDETreeNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDETreeNode.getNamePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDETreeNode.getNamePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPENDCAPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppendCapFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPENDPNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppendPNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHECKED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Checked_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILDCNTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"CHILDCNTPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_ChildCntPSDEFId_ChildCntPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILDCNTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ChildCntPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILDCNTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ChildCntPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CMREFRESH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CMRefresh_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CMREMOVE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CMRemove_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATASOURCE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataSource_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATATYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataTypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATATYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataTypePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DISABLESELECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DisableSelect_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DISTINCTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DistinctMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITDATAMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditDataMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECHECK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCheck_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPAGING", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePaging_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEQUICKSEARCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableQuickSearch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEUP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableUP_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPAND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Expand_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILTERPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"FILTERPSDEDS", (boolean)true) == 0) {
            return this.onTestValueRule_FilterPSDEDSId_FilterPSDEDS(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILTERPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilterPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILTERPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilterPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"ICONPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_IconPSDEFId_IconPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"KEYPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFId_KeyPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEAFFLAGPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeafFlagPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEAFFLAGPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeafFlagPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamePSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWFILTERDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewFilterDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWDATAMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewDataMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEID2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"NODEID2PSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_NodeId2PSDEFId_NodeId2PSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEID2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeId2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEID2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeId2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEID3PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"NODEID3PSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_NodeId3PSDEFId_NodeId3PSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEID3PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeId3PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEID3PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeId3PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEID4PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"NODEID4PSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_NodeId4PSDEFId_NodeId4PSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEID4PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeId4PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEID4PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeId4PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEIDPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"NODEIDPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_NodeIdPSDEFId_NodeIdPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEIDPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeIdPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEIDPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeIdPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGESIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVENTXSS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreventXSS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEDS", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_PSDEDS(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"REMOVEPSDEACTION", (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionId_RemovePSDEAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROOTNODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RootNode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SELECTED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Selected_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPECLSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeClsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPECLSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeClsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEDYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeDynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapePSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapePSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"SORTPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_SortPSDEFId_SortPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SortPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SORTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SortPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"TEXTPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFId_TextPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TooltipInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TREENODETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TreeNodeType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEOPPrivName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewActions_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONPARAM", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppendCapFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AppendPNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Checked_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ChildCntPSDEFId_ChildCntPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("CHILDCNTPSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b50\u8282\u70b9\u8ba1\u6570\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ChildCntPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CHILDCNTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ChildCntPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CHILDCNTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ClsPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLSPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ClsPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLSPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CMRefresh_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CMRemove_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COUNTERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CounterMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_CustomCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCOND", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Data2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Data2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataSource_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATASOURCE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataTypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATATYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataTypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATATYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DisableSelect_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DistinctMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditDataMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITDATAMODE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCheck_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnablePaging_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableQuickSearch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableUP_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Expand_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FilterPSDEDSId_FilterPSDEDS(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("FILTERPSDEDSID", "PSDEDATASET", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u8fc7\u6ee4\u6570\u636e\u96c6\u5408\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FilterPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILTERPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FilterPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILTERPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPSDEFId_IconPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("ICONPSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u56fe\u6807\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KeyPSDEFId_KeyPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("KEYPSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u6807\u8bc6\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KeyPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KeyPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LeafFlagPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEAFFLAGPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LeafFlagPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEAFFLAGPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ModelObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NamePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NamePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWFILTER", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewFilterDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWFILTERDESC", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWPARAM", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NewDataMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWDATAMODE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEACTION", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEDATATYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeId2PSDEFId_NodeId2PSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("NODEID2PSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u7236\u6807\u8bc62\u7ed1\u5b9a\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeId2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEID2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeId2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEID2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeId3PSDEFId_NodeId3PSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("NODEID3PSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u7236\u6807\u8bc63\u7ed1\u5b9a\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeId3PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEID3PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeId3PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEID3PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeId4PSDEFId_NodeId4PSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("NODEID4PSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u7236\u6807\u8bc64\u7ed1\u5b9a\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeId4PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEID4PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeId4PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEID4PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeIdPSDEFId_NodeIdPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("NODEIDPSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u7236\u6807\u8bc6\u7ed1\u5b9a\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeIdPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEIDPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeIdPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEIDPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("NODETYPE", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEVALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PageSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PreventXSS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEDSId_PSDEDS(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEDSID", "PSDEDATASET", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUniResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RemovePSDEActionId_RemovePSDEAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("REMOVEPSDEACTIONID", "PSDEACTION", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5220\u9664\u5b9e\u4f53\u884c\u4e3a\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RootNode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldSimpleRule("ROOTNODE", iEntity, bl2, "NOTEQ", null, "1", "", true) || this.checkFieldQueryCountRule2("ROOTNODE", "DQ0001", iEntity, bl2, 0, true, 0, true, "\u6811\u89c6\u56fe\u53ea\u80fd\u6709\u4e00\u4e2a\u6839\u8282\u70b9", false, true)) {
                return null;
            }
            return "\u6811\u89c6\u56fe\u53ea\u80fd\u6709\u4e00\u4e2a\u6839\u8282\u70b9";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Selected_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShapeClsPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPECLSPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapeClsPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPECLSPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapeDynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEDYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapePSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapePSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SORTDIR", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SortPSDEFId_SortPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("SORTPSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u6392\u5e8f\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SortPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SORTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SortPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SORTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSDEFId_TextPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("TEXTPSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u6587\u672c\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipsPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPSPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipsPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPSPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TooltipInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLTIPINFO", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TreeNodeType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TREENODETYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_UpdatePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDETreeNode pSDETreeNode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDETreeNode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDETreeNode pSDETreeNode) throws Exception {
        super.onUpdateParent(pSDETreeNode);
    }

    protected void onCopyDetails(PSDETreeNode pSDETreeNode, Object object) throws Exception {
        PSDETreeNode pSDETreeNode2 = new PSDETreeNode();
        pSDETreeNode2.set("PSDETREENODEID", object);
        String string = DataObject.getStringValue((Object)pSDETreeNode.get("PSDETREENODEID"));
        super.onCopyDetails(pSDETreeNode, object);
    }

    @Override
    protected void exportCurXmlModel(PSDETreeNode pSDETreeNode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETREENODE");
        if (!bl) {
            pSDETreeNode.setPSDETreeViewId(null);
            pSDETreeNode.setPSDETreeViewName(null);
            pSDETreeNode.setPSSystemId(null);
            super.exportCurXmlModel(pSDETreeNode, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDETreeNode pSDETreeNode, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDETEIUpdate(pSDETreeNode, xmlNode);
        this.exportRelatedXmlModel_PSDETreeNodeCol(pSDETreeNode, xmlNode);
        super.onExportRelatedXmlModel(pSDETreeNode, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDETEIUpdate(PSDETreeNode pSDETreeNode, XmlNode xmlNode) throws Exception {
        PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUpdate> arrayList = null;
        String string = pSDETreeNode.getPSDETreeNodeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETEIUpdateService.selectByPSDETreeNode(pSDETreeNode) : pSDETEIUpdateService.selectTempByPSDETreeNode(pSDETreeNode);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDETEIUPDATES");
            xmlNode.addNode(xmlNode2);
            for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
                pSDETEIUpdateService.exportXmlModel(pSDETEIUpdate, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDETreeNodeCol(PSDETreeNode pSDETreeNode, XmlNode xmlNode) throws Exception {
        PSDETreeNodeColService pSDETreeNodeColService = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeCol> arrayList = null;
        String string = pSDETreeNode.getPSDETreeNodeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETreeNodeColService.selectByPSDETreeNode(pSDETreeNode) : pSDETreeNodeColService.selectTempByPSDETreeNode(pSDETreeNode);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDETREENODECOLS");
            xmlNode.addNode(xmlNode2);
            for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
                pSDETreeNodeColService.exportXmlModel(pSDETreeNodeCol, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDETreeNode pSDETreeNode, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDETEIUPDATES");
        this.importRelatedXmlModel_PSDETEIUpdate(pSDETreeNode, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDETREENODECOLS");
        this.importRelatedXmlModel_PSDETreeNodeCol(pSDETreeNode, xmlNode3);
        super.onImportRelatedXmlModel(pSDETreeNode, xmlNode);
    }

    protected void importRelatedXmlModel_PSDETEIUpdate(PSDETreeNode pSDETreeNode, XmlNode xmlNode) throws Exception {
        PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDETreeNode.getPSDETreeNodeId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDETEIUpdateService.removeByPSDETreeNode(pSDETreeNode);
        } else {
            pSDETEIUpdateService.removeTempByPSDETreeNode(pSDETreeNode);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDETEIUpdate pSDETEIUpdate = new PSDETEIUpdate();
                pSDETEIUpdateService.fillParentInfo(pSDETEIUpdate, "DER1N", "DER1N_PSDETEIUPDATE_PSDETREENODE_PSDETREENODEID", pSDETreeNode.getPSDETreeNodeId());
                pSDETEIUpdateService.importXmlModel(pSDETEIUpdate, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDETreeNodeCol(PSDETreeNode pSDETreeNode, XmlNode xmlNode) throws Exception {
        PSDETreeNodeColService pSDETreeNodeColService = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDETreeNode.getPSDETreeNodeId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDETreeNodeColService.removeByPSDETreeNode(pSDETreeNode);
        } else {
            pSDETreeNodeColService.removeTempByPSDETreeNode(pSDETreeNode);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDETreeNodeCol pSDETreeNodeCol = new PSDETreeNodeCol();
                pSDETreeNodeColService.fillParentInfo(pSDETreeNodeCol, "DER1N", "DER1N_PSDETREENODECOL_PSDETREENODE_PSDETREENODEID", pSDETreeNode.getPSDETreeNodeId());
                pSDETreeNodeColService.importXmlModel(pSDETreeNodeCol, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDETreeNode pSDETreeNode, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDETreeNode, string);
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
            return "DER1N_PSDETREENODE_PSDETREEVIEW_PSDETREEVIEWID";
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
    public String getModelV2Tag(PSDETreeNode pSDETreeNode) {
        if (!StringHelper.isNullOrEmpty((String)pSDETreeNode.getNodeType())) {
            return pSDETreeNode.getNodeType();
        }
        return super.getModelV2Tag(pSDETreeNode);
    }

    @Override
    public boolean setModelV2Tag(PSDETreeNode pSDETreeNode, String string) {
        return super.setModelV2Tag(pSDETreeNode, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("NODETYPE", "");
        map.put("PSDETREEVIEWID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDETreeNode pSDETreeNode, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDETreeNode.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDETreeNode, true);
        pSDETreeNode.set("NODETYPE", string);
        if (this.select(pSDETreeNode, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDETreeNode, true);
        return super.getModelV2Entity(pSDETreeNode, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDETreeNode pSDETreeNode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDETreeNode, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDETEIUPDATE_PSDETREENODE_PSDETREENODEID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDETREENODECOL_PSDETREENODE_PSDETREENODEID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDETREENODERV_PSDETREENODE_PSDETREENODEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDETreeNode pSDETreeNode, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDETreeNode, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDETreeNode pSDETreeNode, ObjectNode objectNode, String string, boolean bl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETEIUPDATE_PSDETREENODE_PSDETREENODEID")) {
            pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETREENODE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETEIUPDATE", (Object)pSDETreeNode.getPSDETreeNodeId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETREENODE#%1$s", (Object)pSDETreeNode.getPSDETreeNodeId());
                for (PSDETEIUpdate child : ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).selectByPSDETreeNode(pSDETreeNode)) {
                    if (StringHelper.compare(scope, ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).getModelV2ResScope(child), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeteiupdatename")) {
                            string = objectNode.get("psdeteiupdatename").asText();
                        }
                        if (objectNode2.has("psdeteiupdatename")) {
                            string2 = objectNode2.get("psdeteiupdatename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSDETEIUpdate child = new PSDETEIUpdate();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(child, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETREENODECOL_PSDETREENODE_PSDETREENODEID")) {
            pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETREENODE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETREENODECOL", (Object)pSDETreeNode.getPSDETreeNodeId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETREENODE#%1$s", (Object)pSDETreeNode.getPSDETreeNodeId());
                for (PSDETreeNodeCol child : ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).selectByPSDETreeNode(pSDETreeNode)) {
                    if (StringHelper.compare(scope, ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).getModelV2ResScope(child), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                for (ObjectNode childNode : arrayList) {
                    PSDETreeNodeCol child = new PSDETreeNodeCol();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(child, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETREENODERV_PSDETREENODE_PSDETREENODEID")) {
            pSCoreSysServiceBase = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETREENODE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETREENODERV", (Object)pSDETreeNode.getPSDETreeNodeId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETREENODE#%1$s", (Object)pSDETreeNode.getPSDETreeNodeId());
                for (PSDETreeNodeRV child : ((PSDETreeNodeRVServiceBase)pSCoreSysServiceBase).selectByPSDETreeNode(pSDETreeNode)) {
                    if (StringHelper.compare(scope, ((PSDETreeNodeRVServiceBase)pSCoreSysServiceBase).getModelV2ResScope(child), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdetreenodervname")) {
                            string = objectNode.get("psdetreenodervname").asText();
                        }
                        if (objectNode2.has("psdetreenodervname")) {
                            string2 = objectNode2.get("psdetreenodervname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSDETreeNodeRV child = new PSDETreeNodeRV();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(child, string));
                }
            }
        }
        super.onExportCurModelV2(pSDETreeNode, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDETreeNode pSDETreeNode) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUpdate> updates = ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).selectByPSDETreeNode(pSDETreeNode);
        String string2 = StringHelper.format((String)"PSDETREENODE#%1$s", (Object)pSDETreeNode.getPSDETreeNodeId());
        for (PSDETEIUpdate entityBase : updates) {
            string = ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        SqlParamList params = new SqlParamList();
        params.addString(pSDETreeNode.getPSDETreeNodeId());
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETEIUPDATE WHERE PSDETREENODEID = ?", params);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeCol> cols = ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).selectByPSDETreeNode(pSDETreeNode);
        string2 = StringHelper.format((String)"PSDETREENODE#%1$s", (Object)pSDETreeNode.getPSDETreeNodeId());
        for (PSDETreeNodeCol pSDETreeNodeCol : cols) {
            string = ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDETreeNodeCol);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDETreeNodeCol);
        }
        params = new SqlParamList();
        params.addString(pSDETreeNode.getPSDETreeNodeId());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETREENODECOL WHERE PSDETREENODEID = ?", params);
        pSCoreSysServiceBase = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeRV> rvs = ((PSDETreeNodeRVServiceBase)pSCoreSysServiceBase).selectByPSDETreeNode(pSDETreeNode);
        string2 = StringHelper.format((String)"PSDETREENODE#%1$s", (Object)pSDETreeNode.getPSDETreeNodeId());
        for (PSDETreeNodeRV pSDETreeNodeRV : rvs) {
            string = ((PSDETreeNodeRVServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDETreeNodeRV);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDETreeNodeRV);
        }
        params = new SqlParamList();
        params.addString(pSDETreeNode.getPSDETreeNodeId());
        ((PSDETreeNodeRVServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDETreeNodeRVServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETREENODERV WHERE PSDETREENODEID = ?", params);
        super.onEmptyModelV2(pSDETreeNode);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDETreeNode pSDETreeNode, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDETEIUpdate();
        entityBase.set("PSDETREENODEID", pSDETreeNode.getPSDETreeNodeId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDETreeNodeCol();
        entityBase.set("PSDETREENODEID", pSDETreeNode.getPSDETreeNodeId());
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDETreeNodeRV();
        entityBase.set("PSDETREENODEID", pSDETreeNode.getPSDETreeNodeId());
        pSCoreSysServiceBase = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDETreeNode, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDETreeNode pSDETreeNode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode childNode = (ObjectNode)arrayNode.get(i);
                PSDETEIUpdate child = new PSDETEIUpdate();
                child.setPSDEId(pSDETreeNode.getPSDEId());
                child.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
                child.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
                pSCoreSysServiceBase.compileModelV2(child, childNode, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string4);
            if (directory.exists()) {
                for (File childDirectory : directory.listFiles()) {
                    if (!childDirectory.isDirectory()) continue;
                    PSDETEIUpdate child = new PSDETEIUpdate();
                    child.setPSDEId(pSDETreeNode.getPSDEId());
                    child.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
                    child.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
                    pSCoreSysServiceBase.compileModelV2(child, null, string, childDirectory.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode childNode = (ObjectNode)arrayNode.get(i);
                PSDETreeNodeCol child = new PSDETreeNodeCol();
                child.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
                child.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
                pSCoreSysServiceBase.compileModelV2(child, childNode, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string5);
            if (directory.exists()) {
                for (File childDirectory : directory.listFiles()) {
                    if (!childDirectory.isDirectory()) continue;
                    PSDETreeNodeCol child = new PSDETreeNodeCol();
                    child.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
                    child.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
                    pSCoreSysServiceBase.compileModelV2(child, null, string, childDirectory.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode childNode = (ObjectNode)arrayNode.get(i);
                PSDETreeNodeRV child = new PSDETreeNodeRV();
                child.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
                child.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
                child.setPSDETreeViewId(pSDETreeNode.getPSDETreeViewId());
                pSCoreSysServiceBase.compileModelV2(child, childNode, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string6);
            if (directory.exists()) {
                for (File childDirectory : directory.listFiles()) {
                    if (!childDirectory.isDirectory()) continue;
                    PSDETreeNodeRV child = new PSDETreeNodeRV();
                    child.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
                    child.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
                    child.setPSDETreeViewId(pSDETreeNode.getPSDETreeViewId());
                    pSCoreSysServiceBase.compileModelV2(child, null, string, childDirectory.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDETreeNode, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDETreeNode pSDETreeNode, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDETEIUPDATE_PSDETREENODE_PSDETREENODEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDETEIUpdates(pSDETreeNode, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDETREENODECOL_PSDETREENODE_PSDETREENODEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDETreeNodeCols(pSDETreeNode, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDETreeNode, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDETEIUpdates(PSDETreeNode pSDETreeNode, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDETEIUPDATE", true), (boolean)false) == 0) {
            PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
            PSDETEIUpdate pSDETEIUpdate = new PSDETEIUpdate();
            pSDETEIUpdate.setPSDETEIUpdateId(pSMOSFile.getPSModelId());
            if (!pSDETEIUpdateService.get(pSDETEIUpdate, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDETEIUpdate.getPSDETreeNodeId(), (String)pSDETreeNode.getPSDETreeNodeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDETEIUpdateService.exportModelV2(pSDETEIUpdate);
            pSDETEIUpdate.reset();
            if (!pSDETEIUpdateService.setModelV2ResScope(pSDETEIUpdate, "PSDETREENODE", pSDETreeNode.getPSDETreeNodeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDETEIUpdateService.importModelV2(pSDETEIUpdate, objectNode);
            SessionFactoryManager.commit();
            return pSDETEIUpdateService.getFile(pSDETEIUpdate);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDETreeNodeCols(PSDETreeNode pSDETreeNode, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDETREENODECOL", true), (boolean)false) == 0) {
            PSDETreeNodeColService pSDETreeNodeColService = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
            PSDETreeNodeCol pSDETreeNodeCol = new PSDETreeNodeCol();
            pSDETreeNodeCol.setPSDETreeNodeColId(pSMOSFile.getPSModelId());
            if (!pSDETreeNodeColService.get(pSDETreeNodeCol, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDETreeNodeCol.getPSDETreeNodeId(), (String)pSDETreeNode.getPSDETreeNodeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDETreeNodeColService.exportModelV2(pSDETreeNodeCol);
            pSDETreeNodeCol.reset();
            if (!pSDETreeNodeColService.setModelV2ResScope(pSDETreeNodeCol, "PSDETREENODE", pSDETreeNode.getPSDETreeNodeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDETreeNodeColService.importModelV2(pSDETreeNodeCol, objectNode);
            SessionFactoryManager.commit();
            return pSDETreeNodeColService.getFile(pSDETreeNodeCol);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDETreeNode pSDETreeNode, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDETEIUpdates(pSDETreeNode, list);
        this.onFillPasteHelps_PSDETreeNodeCols(pSDETreeNode, list);
        super.onFillPasteHelps(pSDETreeNode, list);
    }

    protected void onFillPasteHelps_PSDETEIUpdates(PSDETreeNode pSDETreeNode, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDETEIUPDATE");
        pSHelpSection.setSectionParam2("DER1N_PSDETEIUPDATE_PSDETREENODE_PSDETREENODEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6811\u8282\u70b9]\u7684[\u6811\u8868\u7f16\u8f91\u9879\u66f4\u65b0\u6a21\u5f0f]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDETreeNodeCols(PSDETreeNode pSDETreeNode, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDETREENODECOL");
        pSHelpSection.setSectionParam2("DER1N_PSDETREENODECOL_PSDETREENODE_PSDETREENODEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6811\u8282\u70b9]\u7684[\u6811\u8282\u70b9\u6570\u636e\u9879]");
        list.add(pSHelpSection);
    }
}
