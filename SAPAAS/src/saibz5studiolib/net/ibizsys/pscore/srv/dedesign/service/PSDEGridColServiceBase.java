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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEGridColDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEGridColDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridColBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCatBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGridColServiceBase
extends PSCoreSysServiceBase<PSDEGridCol> {
    private static final Log log = LogFactory.getLog(PSDEGridColServiceBase.class);
    public static final String DATASET_CURGRID = "CurGrid";
    public static final String DATASET_CURGRIDEDITABLE = "CurGridEditable";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEGridColDEModel pSDEGridColDEModel;
    private PSDEGridColDAO pSDEGridColDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService";
    }

    public PSDEGridColDEModel getPSDEGridColDEModel() {
        if (this.pSDEGridColDEModel == null) {
            try {
                this.pSDEGridColDEModel = (PSDEGridColDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEGridColDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGridColDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEGridColDEModel();
    }

    public PSDEGridColDAO getPSDEGridColDAO() {
        if (this.pSDEGridColDAO == null) {
            try {
                this.pSDEGridColDAO = (PSDEGridColDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEGridColDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGridColDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEGridColDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURGRID, (boolean)true) == 0) {
            return this.fetchCurGrid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURGRIDEDITABLE, (boolean)true) == 0) {
            return this.fetchCurGridEditable(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURGRID, (boolean)true) == 0) {
            return this.fetchTempCurGrid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURGRIDEDITABLE, (boolean)true) == 0) {
            return this.fetchTempCurGridEditable(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurGrid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURGRID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurGrid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURGRID, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurGridEditable(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURGRIDEDITABLE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurGridEditable(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURGRIDEDITABLE, true);
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

    protected void onFillParentInfo(PSDEGridCol pSDEGridCol, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSDEGridCol, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDATAENTITY_REFPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_RefPSDE(pSDEGridCol, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEACMODE_REFPSDEACMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService", (SessionFactory)this.getSessionFactory());
            PSDEACMode pSDEACMode = (PSDEACMode)iService.getDEModel().createEntity();
            pSDEACMode.set("PSDEACMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEACMode);
            } else {
                iService.get((IEntity)pSDEACMode);
            }
            this.onFillParentInfo_RefPSDEACMode(pSDEGridCol, pSDEACMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEDATASET_REFPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_RefPSDEDataSet(pSDEGridCol, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEFFORMITEM_PSDEFUIMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService", (SessionFactory)this.getSessionFactory());
            PSDEFUIMode pSDEFUIMode = (PSDEFUIMode)iService.getDEModel().createEntity();
            pSDEFUIMode.set("PSDEFFORMITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFUIMode);
            } else {
                iService.get((IEntity)pSDEFUIMode);
            }
            this.onFillParentInfo_PSDEFUIMode(pSDEGridCol, pSDEFUIMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEGridCol, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEFSFITEM_PSDEFSFITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService", (SessionFactory)this.getSessionFactory());
            PSDEFSFItem pSDEFSFItem = (PSDEFSFItem)iService.getDEModel().createEntity();
            pSDEFSFItem.set("PSDEFSFITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFSFItem);
            } else {
                iService.get((IEntity)pSDEFSFItem);
            }
            this.onFillParentInfo_PSDEFSFItem(pSDEGridCol, pSDEFSFItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEGEIUPDATE_PSDEGEIUPDATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService", (SessionFactory)this.getSessionFactory());
            PSDEGEIUpdate pSDEGEIUpdate = (PSDEGEIUpdate)iService.getDEModel().createEntity();
            pSDEGEIUpdate.set("PSDEGEIUPDATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEGEIUpdate);
            } else {
                iService.get((IEntity)pSDEGEIUpdate);
            }
            this.onFillParentInfo_PSDEGEIUpdate(pSDEGridCol, pSDEGEIUpdate);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEGRIDCOL_PPSDEGRIDCOLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService", (SessionFactory)this.getSessionFactory());
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)iService.getDEModel().createEntity();
            pSDEGridCol2.set("PSDEGRIDCOLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEGridCol2);
            } else {
                iService.get((IEntity)pSDEGridCol2);
            }
            this.onFillParentInfo_PPSDEGridCol(pSDEGridCol, pSDEGridCol2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEGrid);
            } else {
                iService.get((IEntity)pSDEGrid);
            }
            this.onFillParentInfo_PSDEGrid(pSDEGridCol, pSDEGrid);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDER_REFPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_RefPSDER(pSDEGridCol, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDEGridCol, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUIAction);
            } else {
                iService.get((IEntity)pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSDEGridCol, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEVIEWBASE_LINKPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_LinkPSDEView(pSDEGridCol, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSDEVIEWBASE_PICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PickupPSDEView(pSDEGridCol, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEGridCol, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSLANGUAGERES_PHPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_PHPSLanRes(pSDEGridCol, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSSYSCSS_CELLPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_CellPSSysCss(pSDEGridCol, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSSYSCSS_HEADERPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_HeaderPSSysCss(pSDEGridCol, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSSYSDICTCAT_PSSYSDICTCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService", (SessionFactory)this.getSessionFactory());
            PSSysDictCat pSSysDictCat = (PSSysDictCat)iService.getDEModel().createEntity();
            pSSysDictCat.set("PSSYSDICTCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDictCat);
            } else {
                iService.get((IEntity)pSSysDictCat);
            }
            this.onFillParentInfo_PSSysDictCat(pSDEGridCol, pSSysDictCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEGridCol, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService", (SessionFactory)this.getSessionFactory());
            PSSysEditorStyle pSSysEditorStyle = (PSSysEditorStyle)iService.getDEModel().createEntity();
            pSSysEditorStyle.set("PSSYSEDITORSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEditorStyle);
            } else {
                iService.get((IEntity)pSSysEditorStyle);
            }
            this.onFillParentInfo_PSSysEditorStyle(pSDEGridCol, pSSysEditorStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEGridCol, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRIDCOL_PSSYSPFPLUGIN_GCRPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_GCRPSSysPFPlugin(pSDEGridCol, pSSysPFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEGridCol, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", string2);
            return this.onSyncDER1NData_PSDEGrid(pSDEGrid, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSDEGridCol pSDEGridCol, PSCodeList pSCodeList) throws Exception {
        pSDEGridCol.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEGridCol.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_RefPSDE(PSDEGridCol pSDEGridCol, PSDataEntity pSDataEntity) throws Exception {
        pSDEGridCol.setRefPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEGridCol.setRefPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_RefPSDEACMode(PSDEGridCol pSDEGridCol, PSDEACMode pSDEACMode) throws Exception {
        pSDEGridCol.setRefPSDEACModeId(pSDEACMode.getPSDEACModeId());
        pSDEGridCol.setRefPSDEACModeName(pSDEACMode.getPSDEACModeName());
    }

    protected void onFillParentInfo_RefPSDEDataSet(PSDEGridCol pSDEGridCol, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEGridCol.setRefPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEGridCol.setRefPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEFUIMode(PSDEGridCol pSDEGridCol, PSDEFUIMode pSDEFUIMode) throws Exception {
        pSDEGridCol.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
        pSDEGridCol.setPSDEFUIModeName(pSDEFUIMode.getPSDEFUIModeName());
    }

    protected void onFillParentInfo_PSDEF(PSDEGridCol pSDEGridCol, PSDEField pSDEField) throws Exception {
        pSDEGridCol.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEGridCol.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEFSFItem(PSDEGridCol pSDEGridCol, PSDEFSFItem pSDEFSFItem) throws Exception {
        pSDEGridCol.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
        pSDEGridCol.setPSDEFSFItemName(pSDEFSFItem.getPSDEFSFItemName());
    }

    protected void onFillParentInfo_PSDEGEIUpdate(PSDEGridCol pSDEGridCol, PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        pSDEGridCol.setPSDEGEIUpdateId(pSDEGEIUpdate.getPSDEGEIUpdateId());
        pSDEGridCol.setPSDEGEIUpdateName(pSDEGEIUpdate.getPSDEGEIUpdateName());
    }

    protected void onFillParentInfo_PPSDEGridCol(PSDEGridCol pSDEGridCol, PSDEGridCol pSDEGridCol2) throws Exception {
        pSDEGridCol.setPPSDEGridColId(pSDEGridCol2.getPSDEGridColId());
        pSDEGridCol.setPPSDEGridColName(pSDEGridCol2.getPSDEGridColName());
        if (pSDEGridCol2.getPSDEGrid() != null) {
            this.onFillParentInfo_PSDEGrid(pSDEGridCol, pSDEGridCol2.getPSDEGrid());
        }
    }

    protected void onFillParentInfo_PSDEGrid(PSDEGridCol pSDEGridCol, PSDEGrid pSDEGrid) throws Exception {
        pSDEGridCol.setPSDEGridId(pSDEGrid.getPSDEGridId());
        pSDEGridCol.setPSDEGridName(pSDEGrid.getPSDEGridName());
        pSDEGridCol.setPSDEId(pSDEGrid.getPSDEId());
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
            ArrayList<PSDEGridCol> arrayList = this.selectByPSDEGrid(pSDEGrid);
            for (PSDEGridCol pSDEGridCol : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEGridCol, (String)"PSDEGRIDCOLID", (String)""))) continue;
                this.remove((IEntity)pSDEGridCol);
            }
        }
        return null;
    }

    protected void onFillParentInfo_RefPSDER(PSDEGridCol pSDEGridCol, PSDER pSDER) throws Exception {
        pSDEGridCol.setRefPSDERId(pSDER.getPSDERId());
        pSDEGridCol.setRefPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDEGridCol pSDEGridCol, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEGridCol.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEGridCol.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSDEGridCol pSDEGridCol, PSDEUIAction pSDEUIAction) throws Exception {
        pSDEGridCol.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDEGridCol.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_LinkPSDEView(PSDEGridCol pSDEGridCol, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEGridCol.setLinkPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEGridCol.setLinkPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PickupPSDEView(PSDEGridCol pSDEGridCol, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEGridCol.setPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEGridCol.setPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEGridCol pSDEGridCol, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEGridCol.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEGridCol.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PHPSLanRes(PSDEGridCol pSDEGridCol, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEGridCol.setPHPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEGridCol.setPHPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_CellPSSysCss(PSDEGridCol pSDEGridCol, PSSysCss pSSysCss) throws Exception {
        pSDEGridCol.setCellPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEGridCol.setCellPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_HeaderPSSysCss(PSDEGridCol pSDEGridCol, PSSysCss pSSysCss) throws Exception {
        pSDEGridCol.setHeaderPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEGridCol.setHeaderPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDictCat(PSDEGridCol pSDEGridCol, PSSysDictCat pSSysDictCat) throws Exception {
        pSDEGridCol.setPSSysDictCatId(pSSysDictCat.getPSSysDictCatId());
        pSDEGridCol.setPSSysDictCatName(pSSysDictCat.getPSSysDictCatName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEGridCol pSDEGridCol, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEGridCol.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEGridCol.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysEditorStyle(PSDEGridCol pSDEGridCol, PSSysEditorStyle pSSysEditorStyle) throws Exception {
        pSDEGridCol.setPSSysEditorStyleId(pSSysEditorStyle.getPSSysEditorStyleId());
        pSDEGridCol.setPSSysEditorStyleName(pSSysEditorStyle.getPSSysEditorStyleName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEGridCol pSDEGridCol, PSSysImage pSSysImage) throws Exception {
        pSDEGridCol.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEGridCol.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_GCRPSSysPFPlugin(PSDEGridCol pSDEGridCol, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEGridCol.setGCRPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEGridCol.setGCRPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillEntityFullInfo(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        if (bl) {
            if (pSDEGridCol.getCustomMode() == null) {
                pSDEGridCol.setCustomMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEGridCol.getModelState() == null) {
                pSDEGridCol.setModelState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEGridCol.getOrderValue() == null) {
                pSDEGridCol.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "100", 9));
            }
            if (pSDEGridCol.getTreeItem() == null) {
                pSDEGridCol.setTreeItem((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSCodeList(pSDEGridCol, bl);
        this.onFillEntityFullInfo_RefPSDE(pSDEGridCol, bl);
        this.onFillEntityFullInfo_RefPSDEACMode(pSDEGridCol, bl);
        this.onFillEntityFullInfo_RefPSDEDataSet(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSDEFUIMode(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSDEFSFItem(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSDEGEIUpdate(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PPSDEGridCol(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSDEGrid(pSDEGridCol, bl);
        this.onFillEntityFullInfo_RefPSDER(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSDEGridCol, bl);
        this.onFillEntityFullInfo_LinkPSDEView(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PickupPSDEView(pSDEGridCol, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PHPSLanRes(pSDEGridCol, bl);
        this.onFillEntityFullInfo_CellPSSysCss(pSDEGridCol, bl);
        this.onFillEntityFullInfo_HeaderPSSysCss(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSSysDictCat(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSSysEditorStyle(pSDEGridCol, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEGridCol, bl);
        this.onFillEntityFullInfo_GCRPSSysPFPlugin(pSDEGridCol, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDE(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        if (pSDEGridCol.isRefPSDEIdDirty()) {
            if (pSDEGridCol.getRefPSDEId() != null) {
                if (pSDEGridCol.getRefPSDEId() == null || pSDEGridCol.getRefPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEGridCol.getRefPSDE();
                    pSDEGridCol.setRefPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEGridCol.setRefPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDEACMode(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDEDataSet(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFUIMode(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        if (pSDEGridCol.isPSDEFIdDirty()) {
            if (pSDEGridCol.getPSDEFId() != null) {
                if (pSDEGridCol.getPSDEFId() == null || pSDEGridCol.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDEGridCol.getPSDEF();
                    pSDEGridCol.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEGridCol.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEFSFItem(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEGEIUpdate(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSDEGridCol(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEGrid(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        if (pSDEGridCol.isPSDEGridIdDirty()) {
            if (pSDEGridCol.getPSDEGridId() != null) {
                if (pSDEGridCol.getPSDEGridId() == null || pSDEGridCol.getPSDEId() == null) {
                    PSDEGrid pSDEGrid = pSDEGridCol.getPSDEGrid();
                    pSDEGridCol.setPSDEGridName(pSDEGrid.getPSDEGridName());
                    pSDEGridCol.setPSDEId(pSDEGrid.getPSDEId());
                }
            } else {
                pSDEGridCol.setPSDEGridName(null);
                pSDEGridCol.setPSDEId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDER(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        if (pSDEGridCol.isRefPSDERIdDirty()) {
            if (pSDEGridCol.getRefPSDERId() != null) {
                if (pSDEGridCol.getRefPSDERId() == null || pSDEGridCol.getRefPSDERName() == null) {
                    PSDER pSDER = pSDEGridCol.getRefPSDER();
                    pSDEGridCol.setRefPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEGridCol.setRefPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LinkPSDEView(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PickupPSDEView(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        if (pSDEGridCol.isCapPSLanResIdDirty()) {
            if (pSDEGridCol.getCapPSLanResId() != null) {
                if (pSDEGridCol.getCapPSLanResId() == null || pSDEGridCol.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEGridCol.getCapPSLanRes();
                    pSDEGridCol.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEGridCol.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PHPSLanRes(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        if (pSDEGridCol.isPHPSLanResIdDirty()) {
            if (pSDEGridCol.getPHPSLanResId() != null) {
                if (pSDEGridCol.getPHPSLanResId() == null || pSDEGridCol.getPHPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEGridCol.getPHPSLanRes();
                    pSDEGridCol.setPHPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEGridCol.setPHPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CellPSSysCss(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_HeaderPSSysCss(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDictCat(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        if (pSDEGridCol.isPSSysDynaModelIdDirty()) {
            if (pSDEGridCol.getPSSysDynaModelId() != null) {
                if (pSDEGridCol.getPSSysDynaModelId() == null || pSDEGridCol.getPSSysDynaModelName() == null) {
                    PSSysDynaModel pSSysDynaModel = pSDEGridCol.getPSSysDynaModel();
                    pSDEGridCol.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                }
            } else {
                pSDEGridCol.setPSSysDynaModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysEditorStyle(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GCRPSSysPFPlugin(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEGridCol, bl);
    }

    public ArrayList<PSDEGridCol> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByRefPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase) throws Exception {
        return this.selectByPSDEFUIMode(pSDEFUIModeBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase, String string) throws Exception {
        return this.selectByPSDEFUIMode(pSDEFUIModeBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByPSDEFSFItem(PSDEFSFItemBase pSDEFSFItemBase) throws Exception {
        return this.selectByPSDEFSFItem(pSDEFSFItemBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEFSFItem(PSDEFSFItemBase pSDEFSFItemBase, String string) throws Exception {
        return this.selectByPSDEFSFItem(pSDEFSFItemBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEFSFItem(PSDEFSFItemBase pSDEFSFItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFSFITEMID", (Object)pSDEFSFItemBase.getPSDEFSFItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFSFItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFSFItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGridCol> selectByPSDEGEIUpdate(PSDEGEIUpdateBase pSDEGEIUpdateBase) throws Exception {
        return this.selectByPSDEGEIUpdate(pSDEGEIUpdateBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEGEIUpdate(PSDEGEIUpdateBase pSDEGEIUpdateBase, String string) throws Exception {
        return this.selectByPSDEGEIUpdate(pSDEGEIUpdateBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEGEIUpdate(PSDEGEIUpdateBase pSDEGEIUpdateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGEIUPDATEID", (Object)pSDEGEIUpdateBase.getPSDEGEIUpdateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEGEIUpdateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEGEIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGridCol> selectTempByPSDEGEIUpdate(PSDEGEIUpdateBase pSDEGEIUpdateBase) throws Exception {
        return this.selectTempByPSDEGEIUpdate(pSDEGEIUpdateBase, "");
    }

    public ArrayList<PSDEGridCol> selectTempByPSDEGEIUpdate(PSDEGEIUpdateBase pSDEGEIUpdateBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGEIUPDATEID", (Object)pSDEGEIUpdateBase.getPSDEGEIUpdateId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEGEIUpdateCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEGEIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGridCol> selectByPPSDEGridCol(PSDEGridColBase pSDEGridColBase) throws Exception {
        return this.selectByPPSDEGridCol(pSDEGridColBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPPSDEGridCol(PSDEGridColBase pSDEGridColBase, String string) throws Exception {
        return this.selectByPPSDEGridCol(pSDEGridColBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPPSDEGridCol(PSDEGridColBase pSDEGridColBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEGRIDCOLID", (Object)pSDEGridColBase.getPSDEGridColId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDEGridColCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDEGridColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGridCol> selectTempByPPSDEGridCol(PSDEGridColBase pSDEGridColBase) throws Exception {
        return this.selectTempByPPSDEGridCol(pSDEGridColBase, "");
    }

    public ArrayList<PSDEGridCol> selectTempByPPSDEGridCol(PSDEGridColBase pSDEGridColBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEGRIDCOLID", (Object)pSDEGridColBase.getPSDEGridColId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSDEGridColCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSDEGridColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGridCol> selectByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectTempByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectTempByPSDEGrid(pSDEGridBase, "");
    }

    public ArrayList<PSDEGridCol> selectTempByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDID", (Object)pSDEGridBase.getPSDEGridId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEGridCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEGridCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGridCol> selectByRefPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByRefPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByRefPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByRefPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByRefPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGridCol> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGridCol> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByPHPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByPHPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PHPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPHPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPHPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGridCol> selectByCellPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByCellPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByCellPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByCellPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByCellPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByHeaderPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByHeaderPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByHeaderPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByHeaderPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByHeaderPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("HEADERPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByHeaderPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByHeaderPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGridCol> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase) throws Exception {
        return this.selectByPSSysDictCat(pSSysDictCatBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase, String string) throws Exception {
        return this.selectByPSSysDictCat(pSSysDictCatBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGridCol> selectByGCRPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByGCRPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEGridCol> selectByGCRPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByGCRPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEGridCol> selectByGCRPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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
        ArrayList<PSDEGridCol> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSCodeListId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSDEGridColServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSDATAENTITY_REFPSDEID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDE(pSDataEntity);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setRefPSDEId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByRefPSDE(pSDataEntity2);
                PSDEGridColServiceBase.this.internalRemoveByRefPSDE(pSDataEntity2);
                PSDEGridColServiceBase.this.onAfterRemoveByRefPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDE(pSDataEntity);
        this.onBeforeRemoveByRefPSDE(pSDataEntity, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByRefPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    public void resetRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setRefPSDEACModeId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        final PSDEACMode pSDEACMode2 = pSDEACMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByRefPSDEACMode(pSDEACMode2);
                PSDEGridColServiceBase.this.internalRemoveByRefPSDEACMode(pSDEACMode2);
                PSDEGridColServiceBase.this.onAfterRemoveByRefPSDEACMode(pSDEACMode2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void internalRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        this.onBeforeRemoveByRefPSDEACMode(pSDEACMode, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByRefPSDEACMode(pSDEACMode, arrayList);
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSDEDATASET_REFPSDEDATASETID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setRefPSDEDataSetId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSDEGridColServiceBase.this.internalRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSDEGridColServiceBase.this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFUIMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFUIMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSDEFFORMITEM_PSDEFUIMODEID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSDEFUIMode), arrayList.get(0)));
        }
    }

    public void resetPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSDEFUIModeId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        final PSDEFUIMode pSDEFUIMode2 = pSDEFUIMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSDEFUIMode(pSDEFUIMode2);
                PSDEGridColServiceBase.this.internalRemoveByPSDEFUIMode(pSDEFUIMode2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSDEFUIMode(pSDEFUIMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    protected void internalRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode);
        this.onBeforeRemoveByPSDEFUIMode(pSDEFUIMode, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSDEFUIMode(pSDEFUIMode, arrayList);
    }

    protected void onAfterRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSDEFId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEGridColServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEFSFItem(pSDEFSFItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFSFITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFSFItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSDEFSFITEM_PSDEFSFITEMID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSDEFSFItem), arrayList.get(0)));
        }
    }

    public void resetPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEFSFItem(pSDEFSFItem);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSDEFSFItemId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        final PSDEFSFItem pSDEFSFItem2 = pSDEFSFItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSDEFSFItem(pSDEFSFItem2);
                PSDEGridColServiceBase.this.internalRemoveByPSDEFSFItem(pSDEFSFItem2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSDEFSFItem(pSDEFSFItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
    }

    protected void internalRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEFSFItem(pSDEFSFItem);
        this.onBeforeRemoveByPSDEFSFItem(pSDEFSFItem, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSDEFSFItem(pSDEFSFItem, arrayList);
    }

    protected void onAfterRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEGEIUpdate(pSDEGEIUpdate, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEGEIUPDATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEGEIUpdate);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSDEGEIUPDATE_PSDEGEIUPDATEID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSDEGEIUpdate), arrayList.get(0)));
        }
    }

    public void resetPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEGEIUpdate(pSDEGEIUpdate);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSDEGEIUpdateId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void resetTempPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectTempByPSDEGEIUpdate(pSDEGEIUpdate);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSDEGEIUpdateId(null);
            this.updateTemp((IEntity)pSDEGridCol2);
        }
    }

    public void removeByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        final PSDEGEIUpdate pSDEGEIUpdate2 = pSDEGEIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSDEGEIUpdate(pSDEGEIUpdate2);
                PSDEGridColServiceBase.this.internalRemoveByPSDEGEIUpdate(pSDEGEIUpdate2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSDEGEIUpdate(pSDEGEIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
    }

    protected void internalRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEGEIUpdate(pSDEGEIUpdate);
        this.onBeforeRemoveByPSDEGEIUpdate(pSDEGEIUpdate, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSDEGEIUpdate(pSDEGEIUpdate, arrayList);
    }

    protected void onAfterRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    public void resetPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPPSDEGridCol(pSDEGridCol);
        for (PSDEGridCol pSDEGridCol2 : arrayList) {
            PSDEGridCol pSDEGridCol3 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol3.setPSDEGridColId(pSDEGridCol2.getPSDEGridColId());
            pSDEGridCol3.setPPSDEGridColId(null);
            this.update(pSDEGridCol3);
        }
    }

    public void resetTempPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectTempByPPSDEGridCol(pSDEGridCol);
        for (PSDEGridCol pSDEGridCol2 : arrayList) {
            PSDEGridCol pSDEGridCol3 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol3.setPSDEGridColId(pSDEGridCol2.getPSDEGridColId());
            pSDEGridCol3.setPPSDEGridColId(null);
            this.updateTemp((IEntity)pSDEGridCol3);
        }
    }

    public void removeByPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        final PSDEGridCol pSDEGridCol2 = pSDEGridCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPPSDEGridCol(pSDEGridCol2);
                PSDEGridColServiceBase.this.internalRemoveByPPSDEGridCol(pSDEGridCol2);
                PSDEGridColServiceBase.this.onAfterRemoveByPPSDEGridCol(pSDEGridCol2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void internalRemoveByPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPPSDEGridCol(pSDEGridCol);
        this.onBeforeRemoveByPPSDEGridCol(pSDEGridCol, arrayList);
        for (PSDEGridCol pSDEGridCol2 : arrayList) {
            this.remove((IEntity)pSDEGridCol2);
        }
        this.onAfterRemoveByPPSDEGridCol(pSDEGridCol, arrayList);
    }

    protected void onAfterRemoveByPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void onBeforeRemoveByPPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    public void resetPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEGrid(pSDEGrid);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSDEGridId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void resetTempPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectTempByPSDEGrid(pSDEGrid);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSDEGridId(null);
            this.updateTemp((IEntity)pSDEGridCol2);
        }
    }

    public void removeByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSDEGrid(pSDEGrid2);
                PSDEGridColServiceBase.this.internalRemoveByPSDEGrid(pSDEGrid2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveByPSDEGrid(pSDEGrid, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSDER_REFPSDERID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDER(pSDER);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setRefPSDERId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByRefPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByRefPSDER(pSDER2);
                PSDEGridColServiceBase.this.internalRemoveByRefPSDER(pSDER2);
                PSDEGridColServiceBase.this.onAfterRemoveByRefPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByRefPSDER(pSDER);
        this.onBeforeRemoveByRefPSDER(pSDER, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByRefPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByRefPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDER(PSDER pSDER, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDER(PSDER pSDER, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSDEUAGroupId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEGridColServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSDEUIActionId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEGridColServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByLinkPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSDEVIEWBASE_LINKPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setLinkPSDEViewId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByLinkPSDEView(pSDEViewBase2);
                PSDEGridColServiceBase.this.internalRemoveByLinkPSDEView(pSDEViewBase2);
                PSDEGridColServiceBase.this.onAfterRemoveByLinkPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        this.onBeforeRemoveByLinkPSDEView(pSDEViewBase, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByLinkPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSDEVIEWBASE_PICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPickupPSDEView(pSDEViewBase);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPickupPSDEViewId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPickupPSDEView(pSDEViewBase2);
                PSDEGridColServiceBase.this.internalRemoveByPickupPSDEView(pSDEViewBase2);
                PSDEGridColServiceBase.this.onAfterRemoveByPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByPickupPSDEView(pSDEViewBase, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setCapPSLanResId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEGridColServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEGridColServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPHPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSLANGUAGERES_PHPSLANRESID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPHPSLanRes(pSLanguageRes);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPHPSLanResId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPHPSLanRes(pSLanguageRes2);
                PSDEGridColServiceBase.this.internalRemoveByPHPSLanRes(pSLanguageRes2);
                PSDEGridColServiceBase.this.onAfterRemoveByPHPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPHPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByPHPSLanRes(pSLanguageRes, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPHPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByCellPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByCellPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSSYSCSS_CELLPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetCellPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByCellPSSysCss(pSSysCss);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setCellPSSysCssId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByCellPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByCellPSSysCss(pSSysCss2);
                PSDEGridColServiceBase.this.internalRemoveByCellPSSysCss(pSSysCss2);
                PSDEGridColServiceBase.this.onAfterRemoveByCellPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByCellPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByCellPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByCellPSSysCss(pSSysCss);
        this.onBeforeRemoveByCellPSSysCss(pSSysCss, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByCellPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByCellPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByCellPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCellPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByHeaderPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByHeaderPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSSYSCSS_HEADERPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetHeaderPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByHeaderPSSysCss(pSSysCss);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setHeaderPSSysCssId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByHeaderPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByHeaderPSSysCss(pSSysCss2);
                PSDEGridColServiceBase.this.internalRemoveByHeaderPSSysCss(pSSysCss2);
                PSDEGridColServiceBase.this.onAfterRemoveByHeaderPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByHeaderPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByHeaderPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByHeaderPSSysCss(pSSysCss);
        this.onBeforeRemoveByHeaderPSSysCss(pSSysCss, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByHeaderPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByHeaderPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByHeaderPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByHeaderPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysDictCat(pSSysDictCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDICTCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDictCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSSYSDICTCAT_PSSYSDICTCATID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSSysDictCat), arrayList.get(0)));
        }
    }

    public void resetPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysDictCat(pSSysDictCat);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSSysDictCatId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        final PSSysDictCat pSSysDictCat2 = pSSysDictCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSSysDictCat(pSSysDictCat2);
                PSDEGridColServiceBase.this.internalRemoveByPSSysDictCat(pSSysDictCat2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSSysDictCat(pSSysDictCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
    }

    protected void internalRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysDictCat(pSSysDictCat);
        this.onBeforeRemoveByPSSysDictCat(pSSysDictCat, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSSysDictCat(pSSysDictCat, arrayList);
    }

    protected void onAfterRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSSysDynaModelId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEGridColServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEDITORSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEditorStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSSysEditorStyle), arrayList.get(0)));
        }
    }

    public void resetPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSSysEditorStyleId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        final PSSysEditorStyle pSSysEditorStyle2 = pSSysEditorStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSDEGridColServiceBase.this.internalRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void internalRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setPSSysImageId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEGridColServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEGridColServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void testRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByGCRPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRIDCOL_PSSYSPFPLUGIN_GCRPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEGRIDCOL", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByGCRPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            PSDEGridCol pSDEGridCol2 = (PSDEGridCol)this.getDEModel().createEntity();
            pSDEGridCol2.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            pSDEGridCol2.setGCRPSSysPFPluginId(null);
            this.update(pSDEGridCol2);
        }
    }

    public void removeByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveByGCRPSSysPFPlugin(pSSysPFPlugin2);
                PSDEGridColServiceBase.this.internalRemoveByGCRPSSysPFPlugin(pSSysPFPlugin2);
                PSDEGridColServiceBase.this.onAfterRemoveByGCRPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectByGCRPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByGCRPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.remove((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveByGCRPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEGridCol pSDEGridCol) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIUDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGridCol(pSDEGridCol);
        pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGridCol(pSDEGridCol);
        ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).removeByPSDEGridCol(pSDEGridCol);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPPSDEGridCol(pSDEGridCol);
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).removeByPPSDEGridCol(pSDEGridCol);
        pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGridCol(pSDEGridCol);
        super.onBeforeRemove(pSDEGridCol);
    }

    protected void onBeforeRemoveTemp(PSDEGridCol pSDEGridCol) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).resetTempPSDEGridCol(pSDEGridCol);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).resetTempPPSDEGridCol(pSDEGridCol);
        pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).resetTempPSDEGridCol(pSDEGridCol);
        pSCoreSysServiceBase = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIUDetailServiceBase)pSCoreSysServiceBase).resetTempPSDEGridCol(pSDEGridCol);
        super.onBeforeRemoveTemp((IEntity)pSDEGridCol);
    }

    public void removeTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        final PSDEGEIUpdate pSDEGEIUpdate2 = pSDEGEIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveTempByPSDEGEIUpdate(pSDEGEIUpdate2);
                PSDEGridColServiceBase.this.internalRemoveTempByPSDEGEIUpdate(pSDEGEIUpdate2);
                PSDEGridColServiceBase.this.onAfterRemoveTempByPSDEGEIUpdate(pSDEGEIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
    }

    protected void internalRemoveTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectTempByPSDEGEIUpdate(pSDEGEIUpdate);
        this.onBeforeRemoveTempByPSDEGEIUpdate(pSDEGEIUpdate, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.removeTemp((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveTempByPSDEGEIUpdate(pSDEGEIUpdate, arrayList);
    }

    protected void onAfterRemoveTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void removeTempByPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        final PSDEGridCol pSDEGridCol2 = pSDEGridCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveTempByPPSDEGridCol(pSDEGridCol2);
                PSDEGridColServiceBase.this.internalRemoveTempByPPSDEGridCol(pSDEGridCol2);
                PSDEGridColServiceBase.this.onAfterRemoveTempByPPSDEGridCol(pSDEGridCol2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void internalRemoveTempByPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectTempByPPSDEGridCol(pSDEGridCol);
        this.onBeforeRemoveTempByPPSDEGridCol(pSDEGridCol, arrayList);
        for (PSDEGridCol pSDEGridCol2 : arrayList) {
            this.removeTemp((IEntity)pSDEGridCol2);
        }
        this.onAfterRemoveTempByPPSDEGridCol(pSDEGridCol, arrayList);
    }

    protected void onAfterRemoveTempByPPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    public void removeTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridColServiceBase.this.onBeforeRemoveTempByPSDEGrid(pSDEGrid2);
                PSDEGridColServiceBase.this.internalRemoveTempByPSDEGrid(pSDEGrid2);
                PSDEGridColServiceBase.this.onAfterRemoveTempByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGridCol> arrayList = this.selectTempByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveTempByPSDEGrid(pSDEGrid, arrayList);
        for (PSDEGridCol pSDEGridCol : arrayList) {
            this.removeTemp((IEntity)pSDEGridCol);
        }
        this.onAfterRemoveTempByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGridCol> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEGridCol pSDEGridCol) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSDEGridCol);
    }

    protected void updateRelatedDataTempMajor(PSDEGridCol pSDEGridCol, PSDEGridCol pSDEGridCol2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSDEGridCol, (IEntity)pSDEGridCol2);
    }

    protected void replaceParentInfo(PSDEGridCol pSDEGridCol, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEGridCol, cloneSession);
        if (pSDEGridCol.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEGridCol.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSDEGridCol, (PSCodeList)iEntity);
        }
        if (pSDEGridCol.getRefPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEGridCol.getRefPSDEId())) != null) {
            this.onFillParentInfo_RefPSDE(pSDEGridCol, (PSDataEntity)iEntity);
        }
        if (pSDEGridCol.getRefPSDEACModeId() != null && (iEntity = cloneSession.getEntity("PSDEACMODE", (Object)pSDEGridCol.getRefPSDEACModeId())) != null) {
            this.onFillParentInfo_RefPSDEACMode(pSDEGridCol, (PSDEACMode)iEntity);
        }
        if (pSDEGridCol.getRefPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEGridCol.getRefPSDEDataSetId())) != null) {
            this.onFillParentInfo_RefPSDEDataSet(pSDEGridCol, (PSDEDataSet)iEntity);
        }
        if (pSDEGridCol.getPSDEFUIModeId() != null && (iEntity = cloneSession.getEntity("PSDEFFORMITEM", (Object)pSDEGridCol.getPSDEFUIModeId())) != null) {
            this.onFillParentInfo_PSDEFUIMode(pSDEGridCol, (PSDEFUIMode)iEntity);
        }
        if (pSDEGridCol.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEGridCol.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDEGridCol, (PSDEField)iEntity);
        }
        if (pSDEGridCol.getPSDEFSFItemId() != null && (iEntity = cloneSession.getEntity("PSDEFSFITEM", (Object)pSDEGridCol.getPSDEFSFItemId())) != null) {
            this.onFillParentInfo_PSDEFSFItem(pSDEGridCol, (PSDEFSFItem)iEntity);
        }
        if (pSDEGridCol.getPSDEGEIUpdateId() != null && (iEntity = cloneSession.getEntity("PSDEGEIUPDATE", (Object)pSDEGridCol.getPSDEGEIUpdateId())) != null) {
            this.onFillParentInfo_PSDEGEIUpdate(pSDEGridCol, (PSDEGEIUpdate)iEntity);
        }
        if (pSDEGridCol.getPPSDEGridColId() != null && (iEntity = cloneSession.getEntity("PSDEGRIDCOL", (Object)pSDEGridCol.getPPSDEGridColId())) != null) {
            this.onFillParentInfo_PPSDEGridCol(pSDEGridCol, (PSDEGridCol)iEntity);
        }
        if (pSDEGridCol.getPSDEGridId() != null && (iEntity = cloneSession.getEntity("PSDEGRID", (Object)pSDEGridCol.getPSDEGridId())) != null) {
            this.onFillParentInfo_PSDEGrid(pSDEGridCol, (PSDEGrid)iEntity);
        }
        if (pSDEGridCol.getRefPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEGridCol.getRefPSDERId())) != null) {
            this.onFillParentInfo_RefPSDER(pSDEGridCol, (PSDER)iEntity);
        }
        if (pSDEGridCol.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEGridCol.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDEGridCol, (PSDEUAGroup)iEntity);
        }
        if (pSDEGridCol.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDEGridCol.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSDEGridCol, (PSDEUIAction)iEntity);
        }
        if (pSDEGridCol.getLinkPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEGridCol.getLinkPSDEViewId())) != null) {
            this.onFillParentInfo_LinkPSDEView(pSDEGridCol, (PSDEViewBase)iEntity);
        }
        if (pSDEGridCol.getPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEGridCol.getPickupPSDEViewId())) != null) {
            this.onFillParentInfo_PickupPSDEView(pSDEGridCol, (PSDEViewBase)iEntity);
        }
        if (pSDEGridCol.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEGridCol.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEGridCol, (PSLanguageRes)iEntity);
        }
        if (pSDEGridCol.getPHPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEGridCol.getPHPSLanResId())) != null) {
            this.onFillParentInfo_PHPSLanRes(pSDEGridCol, (PSLanguageRes)iEntity);
        }
        if (pSDEGridCol.getCellPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEGridCol.getCellPSSysCssId())) != null) {
            this.onFillParentInfo_CellPSSysCss(pSDEGridCol, (PSSysCss)iEntity);
        }
        if (pSDEGridCol.getHeaderPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEGridCol.getHeaderPSSysCssId())) != null) {
            this.onFillParentInfo_HeaderPSSysCss(pSDEGridCol, (PSSysCss)iEntity);
        }
        if (pSDEGridCol.getPSSysDictCatId() != null && (iEntity = cloneSession.getEntity("PSSYSDICTCAT", (Object)pSDEGridCol.getPSSysDictCatId())) != null) {
            this.onFillParentInfo_PSSysDictCat(pSDEGridCol, (PSSysDictCat)iEntity);
        }
        if (pSDEGridCol.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEGridCol.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEGridCol, (PSSysDynaModel)iEntity);
        }
        if (pSDEGridCol.getPSSysEditorStyleId() != null && (iEntity = cloneSession.getEntity("PSSYSEDITORSTYLE", (Object)pSDEGridCol.getPSSysEditorStyleId())) != null) {
            this.onFillParentInfo_PSSysEditorStyle(pSDEGridCol, (PSSysEditorStyle)iEntity);
        }
        if (pSDEGridCol.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEGridCol.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEGridCol, (PSSysImage)iEntity);
        }
        if (pSDEGridCol.getGCRPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEGridCol.getGCRPSSysPFPluginId())) != null) {
            this.onFillParentInfo_GCRPSSysPFPlugin(pSDEGridCol, (PSSysPFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEGridCol, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AggField(bl, pSDEGridCol, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AggMode(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AggValueFormat(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Align(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AllowEmpty(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CellPSSysCssId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CLConvertMode(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeListConfigMode(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColEnableLink(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateDV(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateDVT(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataItems(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorParams(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorType(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorTypeName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCond(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableInputTip(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableItemPriv(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLink(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableRowEdit(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GCRPSSysPFPluginId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColStyle(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColType(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupItem(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderPSSysCssId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HiddenDataItem(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HideDefault(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreInput(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEViewId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelState(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NeedCodeListConfig(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoPrivDM(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoSort(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PHPSLanResId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PHPSLanResName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PickupPSDEViewId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlaceHolder(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDEGridColId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreventXSS(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewHtml(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFSFItemId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFUIModeId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGEIUpdateId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridColId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridColName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDictCatId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEditorStyleId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawServiceMethod(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawServiceUrl(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEACModeId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEDataSetId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDERId(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDERName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RenderMode(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResetItemName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TreeItem(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateDV(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateDVT(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFormat(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueItemName(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WidthUnit(bl, pSDEGridCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEGridCol, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AggField(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isAggFieldDirty() : !pSDEGridCol.isAggFieldDirty()) {
            return null;
        }
        String string = pSDEGridCol.getAggField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggField_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AggMode(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isAggModeDirty() : !pSDEGridCol.isAggModeDirty()) {
            return null;
        }
        String string = pSDEGridCol.getAggMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggMode_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AggValueFormat(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isAggValueFormatDirty() : !pSDEGridCol.isAggValueFormatDirty()) {
            return null;
        }
        String string = pSDEGridCol.getAggValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggValueFormat_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGVALUEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Align(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isAlignDirty() : !pSDEGridCol.isAlignDirty()) {
            return null;
        }
        String string = pSDEGridCol.getAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Align_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isAllowEmptyDirty() : !pSDEGridCol.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getAllowEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isCapPSLanResIdDirty() : !pSDEGridCol.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isCapPSLanResNameDirty() : !pSDEGridCol.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isCaptionDirty() : !pSDEGridCol.isCaptionDirty()) {
            return null;
        }
        String string = pSDEGridCol.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_CellPSSysCssId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isCellPSSysCssIdDirty() : !pSDEGridCol.isCellPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getCellPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CellPSSysCssId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_CLConvertMode(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isCLConvertModeDirty() : !pSDEGridCol.isCLConvertModeDirty()) {
            return null;
        }
        String string = pSDEGridCol.getCLConvertMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CLConvertMode_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeListConfigMode(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isCodeListConfigModeDirty() : !pSDEGridCol.isCodeListConfigModeDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getCodeListConfigMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CodeListConfigMode_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColEnableLink(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isColEnableLinkDirty() : !pSDEGridCol.isColEnableLinkDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getColEnableLink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColEnableLink_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLENABLELINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateDV(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isCreateDVDirty() : !pSDEGridCol.isCreateDVDirty()) {
            return null;
        }
        String string = pSDEGridCol.getCreateDV();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateDV_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreateDVT(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isCreateDVTDirty() : !pSDEGridCol.isCreateDVTDirty()) {
            return null;
        }
        String string = pSDEGridCol.getCreateDVT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateDVT_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isCustomCodeDirty() : !pSDEGridCol.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEGridCol.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isCustomModeDirty() : !pSDEGridCol.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataItems(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isDataItemsDirty() : !pSDEGridCol.isDataItemsDirty()) {
            return null;
        }
        String string = pSDEGridCol.getDataItems();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataItems_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAITEMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isDynaModelFlagDirty() : !pSDEGridCol.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditorParams(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isEditorParamsDirty() : !pSDEGridCol.isEditorParamsDirty()) {
            return null;
        }
        String string = pSDEGridCol.getEditorParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorParams_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditorType(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isEditorTypeDirty() : !pSDEGridCol.isEditorTypeDirty()) {
            return null;
        }
        String string = pSDEGridCol.getEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorType_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditorTypeName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isEditorTypeNameDirty() : !pSDEGridCol.isEditorTypeNameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getEditorTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorTypeName_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCond(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isEnableCondDirty() : !pSDEGridCol.isEnableCondDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getEnableCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCond_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableInputTip(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isEnableInputTipDirty() : !pSDEGridCol.isEnableInputTipDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getEnableInputTip();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableInputTip_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEINPUTTIP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableItemPriv(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isEnableItemPrivDirty() : !pSDEGridCol.isEnableItemPrivDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getEnableItemPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableItemPriv_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableLink(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isEnableLinkDirty() : !pSDEGridCol.isEnableLinkDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getEnableLink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableLink_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableRowEdit(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isEnableRowEditDirty() : !pSDEGridCol.isEnableRowEditDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getEnableRowEdit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableRowEdit_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_GCRPSSysPFPluginId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isGCRPSSysPFPluginIdDirty() : !pSDEGridCol.isGCRPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getGCRPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GCRPSSysPFPluginId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_GridColStyle(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isGridColStyleDirty() : !pSDEGridCol.isGridColStyleDirty()) {
            return null;
        }
        String string = pSDEGridCol.getGridColStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridColStyle_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_GridColType(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isGridColTypeDirty() && !bl2 : !pSDEGridCol.isGridColTypeDirty()) {
            return null;
        }
        String string = pSDEGridCol.getGridColType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridColType_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupItem(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isGroupItemDirty() : !pSDEGridCol.isGroupItemDirty()) {
            return null;
        }
        String string = pSDEGridCol.getGroupItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupItem_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPITEM");
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
                String string4 = this.checkFieldDupRule(this.getPSDEGridColDEModel(), "GROUPITEM", string3, pSDEGridCol, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("GROUPITEM");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderPSSysCssId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isHeaderPSSysCssIdDirty() : !pSDEGridCol.isHeaderPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getHeaderPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderPSSysCssId_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HiddenDataItem(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isHiddenDataItemDirty() : !pSDEGridCol.isHiddenDataItemDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getHiddenDataItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HiddenDataItem_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_HideDefault(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isHideDefaultDirty() : !pSDEGridCol.isHideDefaultDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getHideDefault();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HideDefault_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HIDEDEFAULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreInput(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isIgnoreInputDirty() : !pSDEGridCol.isIgnoreInputDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getIgnoreInput();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreInput_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkPSDEViewId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isLinkPSDEViewIdDirty() : !pSDEGridCol.isLinkPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getLinkPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEViewId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isLogicNameDirty() : !pSDEGridCol.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isMemoDirty() : !pSDEGridCol.isMemoDirty()) {
            return null;
        }
        String string = pSDEGridCol.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelState(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isModelStateDirty() : !pSDEGridCol.isModelStateDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getModelState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelState_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_NeedCodeListConfig(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isNeedCodeListConfigDirty() : !pSDEGridCol.isNeedCodeListConfigDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getNeedCodeListConfig();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NeedCodeListConfig_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_NoPrivDM(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isNoPrivDMDirty() : !pSDEGridCol.isNoPrivDMDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getNoPrivDM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoPrivDM_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_NoSort(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isNoSortDirty() : !pSDEGridCol.isNoSortDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getNoSort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoSort_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOSORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isOrderValueDirty() && !bl2 : !pSDEGridCol.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PHPSLanResId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPHPSLanResIdDirty() : !pSDEGridCol.isPHPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPHPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PHPSLanResId_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PHPSLanResName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPHPSLanResNameDirty() : !pSDEGridCol.isPHPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPHPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PHPSLanResName_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PickupPSDEViewId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPickupPSDEViewIdDirty() : !pSDEGridCol.isPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PickupPSDEViewId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PlaceHolder(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPlaceHolderDirty() : !pSDEGridCol.isPlaceHolderDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPlaceHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlaceHolder_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDEGridColId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPPSDEGridColIdDirty() : !pSDEGridCol.isPPSDEGridColIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPPSDEGridColId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDEGridColId_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEGRIDCOLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPredefinedTypeDirty() : !pSDEGridCol.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreventXSS(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPreventXSSDirty() : !pSDEGridCol.isPreventXSSDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getPreventXSS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PreventXSS_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PreviewHtml(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPreviewHtmlDirty() : !pSDEGridCol.isPreviewHtmlDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPreviewHtml();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewHtml_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWHTML");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSCodeListIdDirty() : !pSDEGridCol.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEFIdDirty() : !pSDEGridCol.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEFNameDirty() : !pSDEGridCol.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFSFItemId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEFSFItemIdDirty() : !pSDEGridCol.isPSDEFSFItemIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEFSFItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFSFItemId_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFSFITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFUIModeId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEFUIModeIdDirty() : !pSDEGridCol.isPSDEFUIModeIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEFUIModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFUIModeId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEGEIUpdateId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEGEIUpdateIdDirty() : !pSDEGridCol.isPSDEGEIUpdateIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEGEIUpdateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGEIUpdateId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEGridColId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEGridColIdDirty() && !bl2 : !pSDEGridCol.isPSDEGridColIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEGridColId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDCOLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridColId_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDCOLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridColName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEGridColNameDirty() && !bl2 : !pSDEGridCol.isPSDEGridColNameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEGridColName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDCOLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridColName_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDCOLNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEGridColDEModel(), "PSDEGRIDCOLNAME", string3, pSDEGridCol, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEGRIDCOLNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEGridIdDirty() && !bl2 : !pSDEGridCol.isPSDEGridIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEGridId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEIdDirty() : !pSDEGridCol.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEUAGroupIdDirty() : !pSDEGridCol.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDEUIActionIdDirty() : !pSDEGridCol.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSDynaInstIdDirty() : !pSDEGridCol.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDictCatId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSSysDictCatIdDirty() : !pSDEGridCol.isPSSysDictCatIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSSysDictCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDictCatId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSSysDynaModelIdDirty() : !pSDEGridCol.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSSysDynaModelNameDirty() : !pSDEGridCol.isPSSysDynaModelNameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSSysDynaModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelName_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEditorStyleId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSSysEditorStyleIdDirty() : !pSDEGridCol.isPSSysEditorStyleIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSSysEditorStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEditorStyleId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isPSSysImageIdDirty() : !pSDEGridCol.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_RawServiceMethod(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isRawServiceMethodDirty() : !pSDEGridCol.isRawServiceMethodDirty()) {
            return null;
        }
        String string = pSDEGridCol.getRawServiceMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawServiceMethod_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWSERVICEMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawServiceUrl(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isRawServiceUrlDirty() : !pSDEGridCol.isRawServiceUrlDirty()) {
            return null;
        }
        String string = pSDEGridCol.getRawServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawServiceUrl_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWSERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEACModeId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isRefPSDEACModeIdDirty() : !pSDEGridCol.isRefPSDEACModeIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getRefPSDEACModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEACModeId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEDataSetId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isRefPSDEDataSetIdDirty() : !pSDEGridCol.isRefPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getRefPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEDataSetId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isRefPSDEIdDirty() : !pSDEGridCol.isRefPSDEIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getRefPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEId_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isRefPSDENameDirty() : !pSDEGridCol.isRefPSDENameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getRefPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEName_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDERId(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isRefPSDERIdDirty() : !pSDEGridCol.isRefPSDERIdDirty()) {
            return null;
        }
        String string = pSDEGridCol.getRefPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDERId_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDERName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isRefPSDERNameDirty() : !pSDEGridCol.isRefPSDERNameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getRefPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDERName_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RenderMode(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isRenderModeDirty() : !pSDEGridCol.isRenderModeDirty()) {
            return null;
        }
        String string = pSDEGridCol.getRenderMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RenderMode_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RENDERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResetItemName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isResetItemNameDirty() : !pSDEGridCol.isResetItemNameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getResetItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResetItemName_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_TreeItem(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isTreeItemDirty() : !pSDEGridCol.isTreeItemDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getTreeItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TreeItem_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TREEITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdateDV(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isUpdateDVDirty() : !pSDEGridCol.isUpdateDVDirty()) {
            return null;
        }
        String string = pSDEGridCol.getUpdateDV();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdateDV_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_UpdateDVT(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isUpdateDVTDirty() : !pSDEGridCol.isUpdateDVTDirty()) {
            return null;
        }
        String string = pSDEGridCol.getUpdateDVT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdateDVT_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isUserParamsDirty() : !pSDEGridCol.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEGridCol.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isUserTagDirty() : !pSDEGridCol.isUserTagDirty()) {
            return null;
        }
        String string = pSDEGridCol.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isUserTag2Dirty() : !pSDEGridCol.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEGridCol.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueFormat(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isValueFormatDirty() : !pSDEGridCol.isValueFormatDirty()) {
            return null;
        }
        String string = pSDEGridCol.getValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFormat_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueItemName(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isValueItemNameDirty() : !pSDEGridCol.isValueItemNameDirty()) {
            return null;
        }
        String string = pSDEGridCol.getValueItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueItemName_Default((IEntity)pSDEGridCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_Width(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isWidthDirty() : !pSDEGridCol.isWidthDirty()) {
            return null;
        }
        Integer n = pSDEGridCol.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WidthUnit(boolean bl, PSDEGridCol pSDEGridCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGridCol.isWidthUnitDirty() : !pSDEGridCol.isWidthUnitDirty()) {
            return null;
        }
        String string = pSDEGridCol.getWidthUnit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WidthUnit_Default((IEntity)pSDEGridCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTHUNIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEGridCol, bl);
    }

    protected void onSyncIndexEntities(PSDEGridCol pSDEGridCol, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEGridCol, bl);
    }

    public Object getDataContextValue(PSDEGridCol pSDEGridCol, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACMODE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODENAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEGridCol, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEGridCol, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSSYSEDITORSTYLE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSEDITORTYPEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSSYSEDITORSTYLEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSSYSEDITORSTYLENAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEGridCol, "editortype", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue((IEntity)pSDEGridCol, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEGridCol pSDEGridCol2 = pSDEGridCol.getPPSDEGridCol();
        if (pSDEGridCol2 != null && pSDEGridCol2.contains(string)) {
            return pSDEGridCol2.get(string);
        }
        PSDEGrid pSDEGrid = pSDEGridCol.getPSDEGrid();
        if (pSDEGrid != null && pSDEGrid.contains(string)) {
            return pSDEGrid.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEGridCol pSDEGridCol, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEGridCol, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEGridCol, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEGridCol pSDEGridCol, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEGridCol.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEGridCol.getCapPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGGFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGVALUEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggValueFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Align_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"COLENABLELINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColEnableLink_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DATAITEMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataItems_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEINPUTTIP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableInputTip_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"HEADERPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HIDDENDATAITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HiddenDataItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HIDEDEFAULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HideDefault_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEEDCODELISTCONFIG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NeedCodeListConfig_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOPRIVDM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoPrivDM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOSORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoSort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PHPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PHPSLanResName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PPSDEGRIDCOLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEGridColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEGRIDCOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEGridColName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVENTXSS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreventXSS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWHTML", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewHtml_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEFSFITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFSFItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFSFITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFSFItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFUIMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFUIMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGEIUPDATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGEIUpdateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGEIUPDATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGEIUpdateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDCOLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDCOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridColName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWSERVICEMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawServiceMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWSERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawServiceUrl_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"REFPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RENDERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RenderMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RENDERMODETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RenderModeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESETITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResetItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TREEITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TreeItem_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTHUNIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WidthUnit_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AggField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggValueFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGVALUEFORMAT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Align_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ALIGN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_ColEnableLink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DataItems_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAITEMS", iEntity, bl2, null, false, 300, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EditorParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_EditorTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORTYPENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableInputTip_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_HeaderPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HeaderPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HiddenDataItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HideDefault_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_ModelState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NeedCodeListConfig_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NoPrivDM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NoSort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PHPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PHPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PHPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PHPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PPSDEGridColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEGRIDCOLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDEGridColName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEGRIDCOLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedTypeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreventXSS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PreviewHtml_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWHTML", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected String onTestValueRule_PSDEFSFItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFSFITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFSFItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFSFITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEGridColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDCOLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridColName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDCOLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDEGRIDCOLNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_RawServiceMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWSERVICEMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWSERVICEURL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_RefPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RenderMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RENDERMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RenderModeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RENDERMODETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_TreeItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WidthUnit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIDTHUNIT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEGridCol pSDEGridCol) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEGridCol)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEGridCol pSDEGridCol) throws Exception {
        super.onUpdateParent((IEntity)pSDEGridCol);
    }

    protected void onCopyDetails(PSDEGridCol pSDEGridCol, Object object) throws Exception {
        PSDEGridCol pSDEGridCol2 = new PSDEGridCol();
        pSDEGridCol2.set("PSDEGRIDCOLID", object);
        String string = DataObject.getStringValue((Object)pSDEGridCol.get("PSDEGRIDCOLID"));
        super.onCopyDetails((IEntity)pSDEGridCol, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEGridCol pSDEGridCol, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEGRIDCOL");
        if (!bl) {
            pSDEGridCol.setCreateDate(null);
            pSDEGridCol.setCreateMan(null);
            pSDEGridCol.setModelState(null);
            pSDEGridCol.setPPSDEGridColName(null);
            pSDEGridCol.setPSDEGridColId(null);
            pSDEGridCol.setPSDEId(null);
            pSDEGridCol.setUpdateDate(null);
            pSDEGridCol.setUpdateMan(null);
            pSDEGridCol.setPSDEGEIUpdateId(null);
            pSDEGridCol.setPPSDEGridColId(null);
            pSDEGridCol.setPSDEGridId(null);
            pSDEGridCol.setPSDEGridName(null);
            pSDEGridCol.setPSDEId(null);
            super.exportCurXmlModel(pSDEGridCol, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEGridCol pSDEGridCol, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEGridCol, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEGridCol pSDEGridCol, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEGridCol, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEGridCol pSDEGridCol, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEGridCol, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEGRIDCOLID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEGRIDCOL#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEGRID#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEGRIDCOLID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEGRIDCOL_PSDEGRIDCOL_PPSDEGRIDCOLID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEGRIDCOLID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEGRIDCOLNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEGRIDCOL", (boolean)true) == 0) {
            iEntity.set("PPSDEGRIDCOLID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRID", (boolean)true) == 0) {
            iEntity.set("PSDEGRIDID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSDEGRIDCOLID", "PSDEGRIDID"};
    }

    @Override
    public String getModelV2Tag(PSDEGridCol pSDEGridCol) {
        if (!StringHelper.isNullOrEmpty((String)pSDEGridCol.getPSDEGridColName())) {
            return pSDEGridCol.getPSDEGridColName();
        }
        return super.getModelV2Tag(pSDEGridCol);
    }

    @Override
    public boolean setModelV2Tag(PSDEGridCol pSDEGridCol, String string) {
        pSDEGridCol.setPSDEGridColName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEGRIDCOLNAME", "");
        map.put("PPSDEGRIDCOLID", "");
        map.put("PSDEGRIDID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEGridCol pSDEGridCol, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEGridCol.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEGridCol, true);
        pSDEGridCol.set("PSDEGRIDCOLNAME", string);
        if (this.select(pSDEGridCol, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEGridCol, true);
        return super.getModelV2Entity(pSDEGridCol, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEGridCol pSDEGridCol, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDEGridCol.getPPSDEGridColId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEGridCol.getPSDEGridId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdegridid")) {
            objectNode.put("psdegridid", "<PSDEGRID>");
        }
        return super.testCompileCurModelV2(pSDEGridCol, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDEGridCol pSDEGridCol, String string, Map<String, String> map) throws Exception {
        if (PSDEGridColServiceBase.isSimpleImportExportMode()) {
            map.put("PPSDEGRIDCOLID", "");
            map.put("PSDEGRIDID", "");
        }
        return super.onFillModelV2(objectNode, pSDEGridCol, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEGRIDCOL_PSDEGRIDCOL_PPSDEGRIDCOLID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEGridCol pSDEGridCol, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEGridCol, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEGridCol pSDEGridCol, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEGRIDCOL_PSDEGRIDCOL_PPSDEGRIDCOLID")) {
            Object object;
            PSDEGridCol pSDEGridCol22;
            Object object2;
            Object object3;
            Object object4;
            PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEGridCol> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEGRIDCOL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEGRIDCOL", (Object)pSDEGridCol.getPSDEGridColId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSDEGridCol22 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSDEGridCol22);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEGridCol>();
                object4 = pSDEGridColService.selectByPPSDEGridCol(pSDEGridCol);
                object3 = StringHelper.format((String)"PSDEGRIDCOL#%1$s", (Object)pSDEGridCol.getPSDEGridColId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSDEGridCol22 = object2.next();
                    object = pSDEGridColService.getModelV2ResScope((IEntity)pSDEGridCol22);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEGridCol)PSModelV2Helper.toJSONObject((IEntity)pSDEGridCol22, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSDEGridColService.getModelV2Name(false);
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
                for (PSDEGridCol pSDEGridCol22 : arrayList) {
                    object = new PSDEGridCol();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSDEGridCol22, false);
                    ((PSDEGridColBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSDEGridColService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEGridCol, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEGridCol pSDEGridCol) throws Exception {
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGridCol> arrayList = pSDEGridColService.selectByPPSDEGridCol(pSDEGridCol);
        String string = StringHelper.format((String)"PSDEGRIDCOL#%1$s", (Object)pSDEGridCol.getPSDEGridColId());
        for (PSDEGridCol pSDEGridCol2 : arrayList) {
            String string2 = pSDEGridColService.getModelV2ResScope((IEntity)pSDEGridCol2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEGridColService.emptyModelV2(pSDEGridCol2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEGridCol.getPSDEGridColId());
        pSDEGridColService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEGridColService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEGRIDCOL WHERE PPSDEGRIDCOLID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEGridCol);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEGridColService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEGridCol pSDEGridCol, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEGridCol pSDEGridCol2 = new PSDEGridCol();
        pSDEGridCol2.set("PPSDEGRIDCOLID", pSDEGridCol.getPSDEGridColId());
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEGridColService.getModelV2Entity(pSDEGridCol2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEGridCol, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEGridCol pSDEGridCol, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEGridColService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEGridCol pSDEGridCol2 = new PSDEGridCol();
                pSDEGridCol2.setPPSDEGridColId(pSDEGridCol.getPSDEGridColId());
                pSDEGridCol2.setPPSDEGridColName(pSDEGridCol.getPSDEGridColName());
                pSDEGridCol2.setOrderValue(n2 += 10);
                pSDEGridColService.compileModelV2(pSDEGridCol2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEGridCol pSDEGridCol3 = new PSDEGridCol();
                    pSDEGridCol3.setPPSDEGridColId(pSDEGridCol.getPSDEGridColId());
                    pSDEGridCol3.setPPSDEGridColName(pSDEGridCol.getPSDEGridColName());
                    pSDEGridColService.compileModelV2(pSDEGridCol3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEGridCol, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEGridCol pSDEGridCol, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSDEGridCol, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSDEGridCol pSDEGridCol, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSDEGridCol, list);
    }
}

