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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.bdscheme.service;

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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDTableDAO;
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSet;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSetBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColumn;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColumnBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDModule;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDModuleBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDPart;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDPartBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDSchemeBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDE;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDEBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDER;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDERBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDERService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDERServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDTableServiceBase
extends PSCoreSysServiceBase<PSSysBDTable> {
    private static final Log log = LogFactory.getLog(PSSysBDTableServiceBase.class);
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_SYNCDEFIELDS = "SyncDEFields";
    private PSSysBDTableDEModel pSSysBDTableDEModel;
    private PSSysBDTableDAO pSSysBDTableDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService";
    }

    public PSSysBDTableDEModel getPSSysBDTableDEModel() {
        if (this.pSSysBDTableDEModel == null) {
            try {
                this.pSSysBDTableDEModel = (PSSysBDTableDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDTableDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBDTableDEModel();
    }

    public PSSysBDTableDAO getPSSysBDTableDAO() {
        if (this.pSSysBDTableDAO == null) {
            try {
                this.pSSysBDTableDAO = (PSSysBDTableDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDTableDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDTableDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBDTableDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_SYNCDEFIELDS, (boolean)true) == 0) {
            this.syncDEFields((PSSysBDTable)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void syncDEFields(PSSysBDTable pSSysBDTable) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_SYNCDEFIELDS, 0, (IEntity)pSSysBDTable, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysBDTable, ACTION_SYNCDEFIELDS);
        final PSSysBDTable pSSysBDTable2 = pSSysBDTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysBDTableServiceBase.this.getService(), PSSysBDTableServiceBase.ACTION_SYNCDEFIELDS, 40, (IEntity)pSSysBDTable2, null).getResult() != 1) {
                    PSSysBDTableServiceBase.this.onSyncDEFields(pSSysBDTable2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_SYNCDEFIELDS, 99, (IEntity)pSSysBDTable, null);
        }
    }

    protected void onSyncDEFields(PSSysBDTable pSSysBDTable) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[SyncDEFields]");
    }

    protected void onFillParentInfo(PSSysBDTable pSSysBDTable, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLE_PSDATAENTITY_INHERITPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_InheritPSDE(pSSysBDTable, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLE_PSDATAENTITY_MINORPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_MinorPSDE(pSSysBDTable, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysBDTable, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLE_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_PSDER(pSSysBDTable, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLE_PSSYSBDMODULE_PSSYSBDMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDModuleService", (SessionFactory)this.getSessionFactory());
            PSSysBDModule pSSysBDModule = (PSSysBDModule)iService.getDEModel().createEntity();
            pSSysBDModule.set("PSSYSBDMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBDModule);
            } else {
                iService.get((IEntity)pSSysBDModule);
            }
            this.onFillParentInfo_PSSysBDModule(pSSysBDTable, pSSysBDModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLE_PSSYSBDPART_PSSYSBDPARTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDPartService", (SessionFactory)this.getSessionFactory());
            PSSysBDPart pSSysBDPart = (PSSysBDPart)iService.getDEModel().createEntity();
            pSSysBDPart.set("PSSYSBDPARTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBDPart);
            } else {
                iService.get((IEntity)pSSysBDPart);
            }
            this.onFillParentInfo_PSSysBDPart(pSSysBDTable, pSSysBDPart);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysBDScheme pSSysBDScheme = (PSSysBDScheme)iService.getDEModel().createEntity();
            pSSysBDScheme.set("PSSYSBDSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBDScheme);
            } else {
                iService.get((IEntity)pSSysBDScheme);
            }
            this.onFillParentInfo_PSSysBDScheme(pSSysBDTable, pSSysBDScheme);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysBDTable, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_InheritPSDE(PSSysBDTable pSSysBDTable, PSDataEntity pSDataEntity) throws Exception {
        pSSysBDTable.setInheritPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysBDTable.setInheritPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_MinorPSDE(PSSysBDTable pSSysBDTable, PSDataEntity pSDataEntity) throws Exception {
        pSSysBDTable.setMinorPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysBDTable.setMinorPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDE(PSSysBDTable pSSysBDTable, PSDataEntity pSDataEntity) throws Exception {
        pSSysBDTable.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysBDTable.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDER(PSSysBDTable pSSysBDTable, PSDER pSDER) throws Exception {
        pSSysBDTable.setPSDERId(pSDER.getPSDERId());
        pSSysBDTable.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSSysBDModule(PSSysBDTable pSSysBDTable, PSSysBDModule pSSysBDModule) throws Exception {
        pSSysBDTable.setPSSysBDModuleId(pSSysBDModule.getPSSysBDModuleId());
        pSSysBDTable.setPSSysBDModuleName(pSSysBDModule.getPSSysBDModuleName());
    }

    protected void onFillParentInfo_PSSysBDPart(PSSysBDTable pSSysBDTable, PSSysBDPart pSSysBDPart) throws Exception {
        pSSysBDTable.setPSSysBDPartId(pSSysBDPart.getPSSysBDPartId());
        pSSysBDTable.setPSSysBDPartName(pSSysBDPart.getPSSysBDPartName());
    }

    protected void onFillParentInfo_PSSysBDScheme(PSSysBDTable pSSysBDTable, PSSysBDScheme pSSysBDScheme) throws Exception {
        pSSysBDTable.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
        pSSysBDTable.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
    }

    protected boolean onFillEntityKeyValue(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysBDTable.get("PSSYSBDSCHEMEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysBDTable.get("PSSYSBDTABLENAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSysBDTable.set(this.getPSSysBDTableDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBDTable.getPSSysBDColSetsCnt() == null) {
                pSSysBDTable.setPSSysBDColSetsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysBDTable.getPSSysBDColumnsCnt() == null) {
                pSSysBDTable.setPSSysBDColumnsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysBDTable.getPSSysBDTableDEsCnt() == null) {
                pSSysBDTable.setPSSysBDTableDEsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysBDTable.getValidFlag() == null) {
                pSSysBDTable.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysBDTable, bl);
        this.onFillEntityFullInfo_InheritPSDE(pSSysBDTable, bl);
        this.onFillEntityFullInfo_MinorPSDE(pSSysBDTable, bl);
        this.onFillEntityFullInfo_PSDE(pSSysBDTable, bl);
        this.onFillEntityFullInfo_PSDER(pSSysBDTable, bl);
        this.onFillEntityFullInfo_PSSysBDModule(pSSysBDTable, bl);
        this.onFillEntityFullInfo_PSSysBDPart(pSSysBDTable, bl);
        this.onFillEntityFullInfo_PSSysBDScheme(pSSysBDTable, bl);
    }

    protected void onFillEntityFullInfo_InheritPSDE(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
        if (pSSysBDTable.isInheritPSDEIdDirty()) {
            if (pSSysBDTable.getInheritPSDEId() != null) {
                if (pSSysBDTable.getInheritPSDEId() == null || pSSysBDTable.getInheritPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysBDTable.getInheritPSDE();
                    pSSysBDTable.setInheritPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysBDTable.setInheritPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MinorPSDE(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
        if (pSSysBDTable.isMinorPSDEIdDirty()) {
            if (pSSysBDTable.getMinorPSDEId() != null) {
                if (pSSysBDTable.getMinorPSDEId() == null || pSSysBDTable.getMinorPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysBDTable.getMinorPSDE();
                    pSSysBDTable.setMinorPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysBDTable.setMinorPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
        if (pSSysBDTable.isPSDEIdDirty()) {
            if (pSSysBDTable.getPSDEId() != null) {
                if (pSSysBDTable.getPSDEId() == null || pSSysBDTable.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysBDTable.getPSDE();
                    pSSysBDTable.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysBDTable.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDER(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDModule(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDPart(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDScheme(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysBDTable, bl);
    }

    public ArrayList<PSSysBDTable> selectByInheritPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByInheritPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysBDTable> selectByInheritPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByInheritPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysBDTable> selectByInheritPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INHERITPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInheritPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInheritPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBDTable> selectByMinorPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByMinorPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysBDTable> selectByMinorPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByMinorPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysBDTable> selectByMinorPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBDTable> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysBDTable> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysBDTable> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDTable> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSSysBDTable> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSSysBDTable> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDTable> selectByPSSysBDModule(PSSysBDModuleBase pSSysBDModuleBase) throws Exception {
        return this.selectByPSSysBDModule(pSSysBDModuleBase, "", -1);
    }

    public ArrayList<PSSysBDTable> selectByPSSysBDModule(PSSysBDModuleBase pSSysBDModuleBase, String string) throws Exception {
        return this.selectByPSSysBDModule(pSSysBDModuleBase, string, -1);
    }

    public ArrayList<PSSysBDTable> selectByPSSysBDModule(PSSysBDModuleBase pSSysBDModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDMODULEID", (Object)pSSysBDModuleBase.getPSSysBDModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBDTable> selectByPSSysBDPart(PSSysBDPartBase pSSysBDPartBase) throws Exception {
        return this.selectByPSSysBDPart(pSSysBDPartBase, "", -1);
    }

    public ArrayList<PSSysBDTable> selectByPSSysBDPart(PSSysBDPartBase pSSysBDPartBase, String string) throws Exception {
        return this.selectByPSSysBDPart(pSSysBDPartBase, string, -1);
    }

    public ArrayList<PSSysBDTable> selectByPSSysBDPart(PSSysBDPartBase pSSysBDPartBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDPARTID", (Object)pSSysBDPartBase.getPSSysBDPartId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDPartCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBDTable> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase) throws Exception {
        return this.selectByPSSysBDScheme(pSSysBDSchemeBase, "", -1);
    }

    public ArrayList<PSSysBDTable> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase, String string) throws Exception {
        return this.selectByPSSysBDScheme(pSSysBDSchemeBase, string, -1);
    }

    public ArrayList<PSSysBDTable> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDSCHEMEID", (Object)pSSysBDSchemeBase.getPSSysBDSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDSchemeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByInheritPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByInheritPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLE_PSDATAENTITY_INHERITPSDEID", "", iDataEntityModel.getName(), "PSSYSBDTABLE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetInheritPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByInheritPSDE(pSDataEntity);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            PSSysBDTable pSSysBDTable2 = (PSSysBDTable)this.getDEModel().createEntity();
            pSSysBDTable2.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
            pSSysBDTable2.setInheritPSDEId(null);
            this.update(pSSysBDTable2);
        }
    }

    public void removeByInheritPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableServiceBase.this.onBeforeRemoveByInheritPSDE(pSDataEntity2);
                PSSysBDTableServiceBase.this.internalRemoveByInheritPSDE(pSDataEntity2);
                PSSysBDTableServiceBase.this.onAfterRemoveByInheritPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByInheritPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByInheritPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByInheritPSDE(pSDataEntity);
        this.onBeforeRemoveByInheritPSDE(pSDataEntity, arrayList);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            this.remove((IEntity)pSSysBDTable);
        }
        this.onAfterRemoveByInheritPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByInheritPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByInheritPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInheritPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByMinorPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLE_PSDATAENTITY_MINORPSDEID", "", iDataEntityModel.getName(), "PSSYSBDTABLE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByMinorPSDE(pSDataEntity);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            PSSysBDTable pSSysBDTable2 = (PSSysBDTable)this.getDEModel().createEntity();
            pSSysBDTable2.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
            pSSysBDTable2.setMinorPSDEId(null);
            this.update(pSSysBDTable2);
        }
    }

    public void removeByMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableServiceBase.this.onBeforeRemoveByMinorPSDE(pSDataEntity2);
                PSSysBDTableServiceBase.this.internalRemoveByMinorPSDE(pSDataEntity2);
                PSSysBDTableServiceBase.this.onAfterRemoveByMinorPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByMinorPSDE(pSDataEntity);
        this.onBeforeRemoveByMinorPSDE(pSDataEntity, arrayList);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            this.remove((IEntity)pSSysBDTable);
        }
        this.onAfterRemoveByMinorPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSBDTABLE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            PSSysBDTable pSSysBDTable2 = (PSSysBDTable)this.getDEModel().createEntity();
            pSSysBDTable2.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
            pSSysBDTable2.setPSDEId(null);
            this.update(pSSysBDTable2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysBDTableServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysBDTableServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            this.remove((IEntity)pSSysBDTable);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLE_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSSYSBDTABLE", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSDER(pSDER);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            PSSysBDTable pSSysBDTable2 = (PSSysBDTable)this.getDEModel().createEntity();
            pSSysBDTable2.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
            pSSysBDTable2.setPSDERId(null);
            this.update(pSSysBDTable2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSSysBDTableServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSSysBDTableServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            this.remove((IEntity)pSSysBDTable);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDModule(PSSysBDModule pSSysBDModule) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSSysBDModule(pSSysBDModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBDModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLE_PSSYSBDMODULE_PSSYSBDMODULEID", "", iDataEntityModel.getName(), "PSSYSBDTABLE", iDataEntityModel.getDataInfo((IEntity)pSSysBDModule), arrayList.get(0)));
        }
    }

    public void resetPSSysBDModule(PSSysBDModule pSSysBDModule) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSSysBDModule(pSSysBDModule);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            PSSysBDTable pSSysBDTable2 = (PSSysBDTable)this.getDEModel().createEntity();
            pSSysBDTable2.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
            pSSysBDTable2.setPSSysBDModuleId(null);
            this.update(pSSysBDTable2);
        }
    }

    public void removeByPSSysBDModule(PSSysBDModule pSSysBDModule) throws Exception {
        final PSSysBDModule pSSysBDModule2 = pSSysBDModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableServiceBase.this.onBeforeRemoveByPSSysBDModule(pSSysBDModule2);
                PSSysBDTableServiceBase.this.internalRemoveByPSSysBDModule(pSSysBDModule2);
                PSSysBDTableServiceBase.this.onAfterRemoveByPSSysBDModule(pSSysBDModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDModule(PSSysBDModule pSSysBDModule) throws Exception {
    }

    protected void internalRemoveByPSSysBDModule(PSSysBDModule pSSysBDModule) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSSysBDModule(pSSysBDModule);
        this.onBeforeRemoveByPSSysBDModule(pSSysBDModule, arrayList);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            this.remove((IEntity)pSSysBDTable);
        }
        this.onAfterRemoveByPSSysBDModule(pSSysBDModule, arrayList);
    }

    protected void onAfterRemoveByPSSysBDModule(PSSysBDModule pSSysBDModule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDModule(PSSysBDModule pSSysBDModule, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDModule(PSSysBDModule pSSysBDModule, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDPart(PSSysBDPart pSSysBDPart) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSSysBDPart(pSSysBDPart, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDPART");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBDPart);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLE_PSSYSBDPART_PSSYSBDPARTID", "", iDataEntityModel.getName(), "PSSYSBDTABLE", iDataEntityModel.getDataInfo((IEntity)pSSysBDPart), arrayList.get(0)));
        }
    }

    public void resetPSSysBDPart(PSSysBDPart pSSysBDPart) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSSysBDPart(pSSysBDPart);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            PSSysBDTable pSSysBDTable2 = (PSSysBDTable)this.getDEModel().createEntity();
            pSSysBDTable2.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
            pSSysBDTable2.setPSSysBDPartId(null);
            this.update(pSSysBDTable2);
        }
    }

    public void removeByPSSysBDPart(PSSysBDPart pSSysBDPart) throws Exception {
        final PSSysBDPart pSSysBDPart2 = pSSysBDPart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableServiceBase.this.onBeforeRemoveByPSSysBDPart(pSSysBDPart2);
                PSSysBDTableServiceBase.this.internalRemoveByPSSysBDPart(pSSysBDPart2);
                PSSysBDTableServiceBase.this.onAfterRemoveByPSSysBDPart(pSSysBDPart2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDPart(PSSysBDPart pSSysBDPart) throws Exception {
    }

    protected void internalRemoveByPSSysBDPart(PSSysBDPart pSSysBDPart) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSSysBDPart(pSSysBDPart);
        this.onBeforeRemoveByPSSysBDPart(pSSysBDPart, arrayList);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            this.remove((IEntity)pSSysBDTable);
        }
        this.onAfterRemoveByPSSysBDPart(pSSysBDPart, arrayList);
    }

    protected void onAfterRemoveByPSSysBDPart(PSSysBDPart pSSysBDPart) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDPart(PSSysBDPart pSSysBDPart, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDPart(PSSysBDPart pSSysBDPart, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDSCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBDScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "", iDataEntityModel.getName(), "PSSYSBDTABLE", iDataEntityModel.getDataInfo((IEntity)pSSysBDScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            PSSysBDTable pSSysBDTable2 = (PSSysBDTable)this.getDEModel().createEntity();
            pSSysBDTable2.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
            pSSysBDTable2.setPSSysBDSchemeId(null);
            this.update(pSSysBDTable2);
        }
    }

    public void removeByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        final PSSysBDScheme pSSysBDScheme2 = pSSysBDScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableServiceBase.this.onBeforeRemoveByPSSysBDScheme(pSSysBDScheme2);
                PSSysBDTableServiceBase.this.internalRemoveByPSSysBDScheme(pSSysBDScheme2);
                PSSysBDTableServiceBase.this.onAfterRemoveByPSSysBDScheme(pSSysBDScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    protected void internalRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysBDTable> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme);
        this.onBeforeRemoveByPSSysBDScheme(pSSysBDScheme, arrayList);
        for (PSSysBDTable pSSysBDTable : arrayList) {
            this.remove((IEntity)pSSysBDTable);
        }
        this.onAfterRemoveByPSSysBDScheme(pSSysBDScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme, ArrayList<PSSysBDTable> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBDTable pSSysBDTable) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDTable(pSSysBDTable);
        pSCoreSysServiceBase = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDTableRSServiceBase)pSCoreSysServiceBase).testRemoveByMajorPSSysBDTable(pSSysBDTable);
        pSCoreSysServiceBase = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDTableRSServiceBase)pSCoreSysServiceBase).testRemoveByMinorPSSysBDTable(pSSysBDTable);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDTable(pSSysBDTable);
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).removeByPSSysBDTable(pSSysBDTable);
        pSCoreSysServiceBase = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDColumnServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDTable(pSSysBDTable);
        ((PSSysBDColumnServiceBase)pSCoreSysServiceBase).removeByPSSysBDTable(pSSysBDTable);
        pSCoreSysServiceBase = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDTableDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDTable(pSSysBDTable);
        ((PSSysBDTableDEServiceBase)pSCoreSysServiceBase).removeByPSSysBDTable(pSSysBDTable);
        pSCoreSysServiceBase = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDColSetServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDTable(pSSysBDTable);
        ((PSSysBDColSetServiceBase)pSCoreSysServiceBase).removeByPSSysBDTable(pSSysBDTable);
        pSCoreSysServiceBase = (PSSysBDTableDERService)ServiceGlobal.getService(PSSysBDTableDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDTableDERServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDTable(pSSysBDTable);
        ((PSSysBDTableDERServiceBase)pSCoreSysServiceBase).removeByPSSysBDTable(pSSysBDTable);
        super.onBeforeRemove(pSSysBDTable);
    }

    protected void replaceParentInfo(PSSysBDTable pSSysBDTable, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysBDTable, cloneSession);
        if (pSSysBDTable.getInheritPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysBDTable.getInheritPSDEId())) != null) {
            this.onFillParentInfo_InheritPSDE(pSSysBDTable, (PSDataEntity)iEntity);
        }
        if (pSSysBDTable.getMinorPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysBDTable.getMinorPSDEId())) != null) {
            this.onFillParentInfo_MinorPSDE(pSSysBDTable, (PSDataEntity)iEntity);
        }
        if (pSSysBDTable.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysBDTable.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysBDTable, (PSDataEntity)iEntity);
        }
        if (pSSysBDTable.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSSysBDTable.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSSysBDTable, (PSDER)iEntity);
        }
        if (pSSysBDTable.getPSSysBDModuleId() != null && (iEntity = cloneSession.getEntity("PSSYSBDMODULE", (Object)pSSysBDTable.getPSSysBDModuleId())) != null) {
            this.onFillParentInfo_PSSysBDModule(pSSysBDTable, (PSSysBDModule)iEntity);
        }
        if (pSSysBDTable.getPSSysBDPartId() != null && (iEntity = cloneSession.getEntity("PSSYSBDPART", (Object)pSSysBDTable.getPSSysBDPartId())) != null) {
            this.onFillParentInfo_PSSysBDPart(pSSysBDTable, (PSSysBDPart)iEntity);
        }
        if (pSSysBDTable.getPSSysBDSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSBDSCHEME", (Object)pSSysBDTable.getPSSysBDSchemeId())) != null) {
            this.onFillParentInfo_PSSysBDScheme(pSSysBDTable, (PSSysBDScheme)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysBDTable, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BDTableType(bl, pSSysBDTable, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InheritPSDEId(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InheritPSDEName(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEId(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEName(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelVer(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PickupDEFName(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDColSetsCnt(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDColumnsCnt(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDModuleId(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDPartId(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDSchemeId(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableDERsCnt(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableDEsCnt(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableId(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableName(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeValue(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBDTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysBDTable, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BDTableType(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isBDTableTypeDirty() && !bl2 : !pSSysBDTable.isBDTableTypeDirty()) {
            return null;
        }
        Integer n = pSSysBDTable.getBDTableType();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BDTABLETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BDTableType_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BDTABLETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isCodeNameDirty() && !bl2 : !pSSysBDTable.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBDTable.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSBDSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDTableDEModel(), "CODENAME", string3, pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_InheritPSDEId(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isInheritPSDEIdDirty() : !pSSysBDTable.isInheritPSDEIdDirty()) {
            return null;
        }
        String string = pSSysBDTable.getInheritPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InheritPSDEId_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INHERITPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InheritPSDEName(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isInheritPSDENameDirty() : !pSSysBDTable.isInheritPSDENameDirty()) {
            return null;
        }
        String string = pSSysBDTable.getInheritPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InheritPSDEName_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INHERITPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isLockFlagDirty() : !pSSysBDTable.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysBDTable.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isLogicNameDirty() : !pSSysBDTable.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysBDTable.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isMemoDirty() : !pSSysBDTable.isMemoDirty()) {
            return null;
        }
        String string = pSSysBDTable.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorPSDEId(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isMinorPSDEIdDirty() : !pSSysBDTable.isMinorPSDEIdDirty()) {
            return null;
        }
        String string = pSSysBDTable.getMinorPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEId_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorPSDEName(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isMinorPSDENameDirty() : !pSSysBDTable.isMinorPSDENameDirty()) {
            return null;
        }
        String string = pSSysBDTable.getMinorPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEName_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelVer(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isModelVerDirty() : !pSSysBDTable.isModelVerDirty()) {
            return null;
        }
        Integer n = pSSysBDTable.getModelVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelVer_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PickupDEFName(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPickupDEFNameDirty() : !pSSysBDTable.isPickupDEFNameDirty()) {
            return null;
        }
        String string = pSSysBDTable.getPickupDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PickupDEFName_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PICKUPDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSDEIdDirty() && !bl2 : !pSSysBDTable.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysBDTable.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSDENameDirty() && !bl2 : !pSSysBDTable.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysBDTable.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSDERIdDirty() : !pSSysBDTable.isPSDERIdDirty()) {
            return null;
        }
        String string = pSSysBDTable.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDColSetsCnt(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSSysBDColSetsCntDirty() : !pSSysBDTable.isPSSysBDColSetsCntDirty()) {
            return null;
        }
        Integer n = pSSysBDTable.getPSSysBDColSetsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysBDColSetsCnt_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLSETSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDColumnsCnt(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSSysBDColumnsCntDirty() : !pSSysBDTable.isPSSysBDColumnsCntDirty()) {
            return null;
        }
        Integer n = pSSysBDTable.getPSSysBDColumnsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysBDColumnsCnt_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLUMNSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDModuleId(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSSysBDModuleIdDirty() : !pSSysBDTable.isPSSysBDModuleIdDirty()) {
            return null;
        }
        String string = pSSysBDTable.getPSSysBDModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDModuleId_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDPartId(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSSysBDPartIdDirty() : !pSSysBDTable.isPSSysBDPartIdDirty()) {
            return null;
        }
        String string = pSSysBDTable.getPSSysBDPartId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDPartId_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDSchemeId(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSSysBDSchemeIdDirty() && !bl2 : !pSSysBDTable.isPSSysBDSchemeIdDirty()) {
            return null;
        }
        String string = pSSysBDTable.getPSSysBDSchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDSchemeId_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableDERsCnt(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSSysBDTableDERsCntDirty() : !pSSysBDTable.isPSSysBDTableDERsCntDirty()) {
            return null;
        }
        Integer n = pSSysBDTable.getPSSysBDTableDERsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysBDTableDERsCnt_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDERSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableDEsCnt(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSSysBDTableDEsCntDirty() : !pSSysBDTable.isPSSysBDTableDEsCntDirty()) {
            return null;
        }
        Integer n = pSSysBDTable.getPSSysBDTableDEsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysBDTableDEsCnt_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableId(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSSysBDTableIdDirty() && !bl2 : !pSSysBDTable.isPSSysBDTableIdDirty()) {
            return null;
        }
        String string = pSSysBDTable.getPSSysBDTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableId_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableName(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isPSSysBDTableNameDirty() && !bl2 : !pSSysBDTable.isPSSysBDTableNameDirty()) {
            return null;
        }
        String string = pSSysBDTable.getPSSysBDTableName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableName_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSBDSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDTableDEModel(), "PSSYSBDTABLENAME", string3, pSSysBDTable, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBDTABLENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeValue(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isTypeValueDirty() : !pSSysBDTable.isTypeValueDirty()) {
            return null;
        }
        String string = pSSysBDTable.getTypeValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeValue_Default((IEntity)pSSysBDTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isUserCatDirty() : !pSSysBDTable.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBDTable.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isUserTagDirty() : !pSSysBDTable.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBDTable.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isUserTag2Dirty() : !pSSysBDTable.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBDTable.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isUserTag3Dirty() : !pSSysBDTable.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBDTable.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isUserTag4Dirty() : !pSSysBDTable.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBDTable.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBDTable pSSysBDTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTable.isValidFlagDirty() && !bl2 : !pSSysBDTable.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBDTable.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysBDTable, bl2, bl3);
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

    protected void onSyncEntity(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysBDTable, bl);
    }

    protected void onSyncIndexEntities(PSSysBDTable pSSysBDTable, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysBDTable, bl);
    }

    public Object getDataContextValue(PSSysBDTable pSSysBDTable, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysBDTable, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBDScheme pSSysBDScheme = pSSysBDTable.getPSSysBDScheme();
        if (pSSysBDScheme != null && pSSysBDScheme.contains(string)) {
            return pSSysBDScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBDTable pSSysBDTable, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysBDTable, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BDTABLETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BDTableType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"INHERITPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InheritPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INHERITPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InheritPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PICKUPDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PickupDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSBDCOLSETSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDColSetsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDCOLUMNSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDColumnsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDPARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDPartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDPARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDPartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEDERSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableDERsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEDESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableDEsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeValue_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BDTableType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_InheritPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INHERITPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InheritPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INHERITPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_MinorPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PickupDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PICKUPDEFNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSSysBDColSetsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysBDColumnsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysBDModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDPartId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDPARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDPartName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDPARTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableDERsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysBDTableDEsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysBDTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSSYSBDTABLENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEVALUE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysBDTable pSSysBDTable) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) && this.onMergeChild_PSSysBDColSets(pSSysBDTable)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) && this.onMergeChild_PSSysBDColumns(pSSysBDTable)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLEDER_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) && this.onMergeChild_PSSysBDTableDERs(pSSysBDTable)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) && this.onMergeChild_PSSysBDTableDEs(pSSysBDTable)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSSysBDTable)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSSysBDColSets(PSSysBDTable pSSysBDTable) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSBDCOLSETSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysBDTable.getPSSysBDTableId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSBDTABLEID", (Object)pSSysBDTable.getPSSysBDTableId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysBDTable, false);
        return true;
    }

    protected boolean onMergeChild_PSSysBDColumns(PSSysBDTable pSSysBDTable) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSBDCOLUMNSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysBDTable.getPSSysBDTableId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSBDTABLEID", (Object)pSSysBDTable.getPSSysBDTableId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysBDTable, false);
        return true;
    }

    protected boolean onMergeChild_PSSysBDTableDERs(PSSysBDTable pSSysBDTable) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSBDTABLEDERSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysBDTable.getPSSysBDTableId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDERService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSBDTABLEID", (Object)pSSysBDTable.getPSSysBDTableId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysBDTable, false);
        return true;
    }

    protected boolean onMergeChild_PSSysBDTableDEs(PSSysBDTable pSSysBDTable) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSBDTABLEDESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysBDTable.getPSSysBDTableId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSBDTABLEID", (Object)pSSysBDTable.getPSSysBDTableId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysBDTable, false);
        return true;
    }

    protected void onUpdateParent(PSSysBDTable pSSysBDTable) throws Exception {
        IService iService;
        Object object = pSSysBDTable.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSBDTABLE_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSSysBDTable.get("PSSYSBDSCHEMEID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", object);
        }
        super.onUpdateParent((IEntity)pSSysBDTable);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysBDTable pSSysBDTable, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBDTABLE");
        if (!bl) {
            pSSysBDTable.setCreateDate(null);
            pSSysBDTable.setCreateMan(null);
            pSSysBDTable.setModelVer(null);
            pSSysBDTable.setPSSysBDColSetsCnt(null);
            pSSysBDTable.setPSSysBDColumnsCnt(null);
            pSSysBDTable.setPSSysBDTableDERsCnt(null);
            pSSysBDTable.setPSSysBDTableDEsCnt(null);
            pSSysBDTable.setPSSysBDTableId(null);
            pSSysBDTable.setUpdateDate(null);
            pSSysBDTable.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBDTable, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysBDTable pSSysBDTable, PSSystem pSSystem) throws Exception {
        PSSysBDTable pSSysBDTable2 = new PSSysBDTable();
        pSSysBDTable2.setPSSysBDSchemeId(pSSysBDTable.getPSSysBDSchemeId());
        pSSysBDTable2.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
        if (this.selectOne((IEntity)pSSysBDTable2, true)) {
            return pSSysBDTable2.getPSSysBDTableId();
        }
        return super.getEntityFolderKeyValue(pSSysBDTable, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBDTable pSSysBDTable, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBDTable, string);
        objectNode.remove("pssysbdcolsetscnt");
        objectNode.remove("pssysbdcolumnscnt");
        objectNode.remove("pssysbdtablederscnt");
        objectNode.remove("pssysbdtabledescnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBDSCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSBDSCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBDSCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysBDTable pSSysBDTable) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBDTable.getPSSysBDTableName())) {
            return pSSysBDTable.getPSSysBDTableName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBDTable.getCodeName())) {
            return pSSysBDTable.getCodeName();
        }
        return super.getModelV2Tag(pSSysBDTable);
    }

    @Override
    public boolean setModelV2Tag(PSSysBDTable pSSysBDTable, String string) {
        pSSysBDTable.setPSSysBDTableName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSBDTABLENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBDSCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBDTable pSSysBDTable, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBDTable.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBDTable, true);
        pSSysBDTable.set("PSSYSBDTABLENAME", string);
        if (this.select(pSSysBDTable, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBDTable, true);
        return super.getModelV2Entity(pSSysBDTable, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBDTable pSSysBDTable, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBDTable, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSBDTABLEDER_PSSYSBDTABLE_PSSYSBDTABLEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysBDTable pSSysBDTable, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDTABLE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBDCOLSET", (Object)pSSysBDTable.getPSSysBDTableId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysBDColSet();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBDColSetServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysBDColSet)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBDCOLSET", (Object)entityBase.getPSSysBDColSetId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSBDTABLEDER_PSSYSBDTABLE_PSSYSBDTABLEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDTABLE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBDTABLEDER", (Object)pSSysBDTable.getPSSysBDTableId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBDTableDERService)ServiceGlobal.getService(PSSysBDTableDERService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysBDTableDER();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBDTableDERServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysBDTableDER)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBDTABLEDER", (Object)entityBase.getPSSysBDTableDERId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDTABLE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBDTABLEDE", (Object)pSSysBDTable.getPSSysBDTableId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysBDTableDE();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBDTableDEService)pSCoreSysServiceBase).getModelV2Tag((PSSysBDTableDE)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBDTABLEDE", (Object)entityBase.getPSSysBDTableDEId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDTABLE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBDCOLUMN", (Object)pSSysBDTable.getPSSysBDTableId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysBDColumn();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBDColumnServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysBDColumn)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBDCOLUMN", (Object)entityBase.getPSSysBDColumnId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysBDTable, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysBDTable pSSysBDTable, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSSysBDColSet> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID")) {
            pSCoreSysServiceBase = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDTABLE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBDCOLSET", (Object)pSSysBDTable.getPSSysBDTableId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysBDColSet)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysBDColSet>();
                object4 = ((PSSysBDColSetServiceBase)pSCoreSysServiceBase).selectByPSSysBDTable(pSSysBDTable);
                object3 = StringHelper.format((String)"PSSYSBDTABLE#%1$s", (Object)pSSysBDTable.getPSSysBDTableId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysBDColSet)object2.next();
                    object = ((PSSysBDColSetServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysBDColSet)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("pssysbdcolsetname")) {
                            string = objectNode.get("pssysbdcolsetname").asText();
                        }
                        if (objectNode2.has("pssysbdcolsetname")) {
                            string2 = objectNode2.get("pssysbdcolsetname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysBDColSet();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBDTABLEDER_PSSYSBDTABLE_PSSYSBDTABLEID")) {
            pSCoreSysServiceBase = (PSSysBDTableDERService)ServiceGlobal.getService(PSSysBDTableDERService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDTABLE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBDTABLEDER", (Object)pSSysBDTable.getPSSysBDTableId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysBDColSet)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSSysBDTableDERServiceBase)pSCoreSysServiceBase).selectByPSSysBDTable(pSSysBDTable);
                object3 = StringHelper.format((String)"PSSYSBDTABLE#%1$s", (Object)pSSysBDTable.getPSSysBDTableId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysBDTableDER)object2.next();
                    object = ((PSSysBDTableDERServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysBDColSet)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("pssysbdtabledername")) {
                            string = objectNode.get("pssysbdtabledername").asText();
                        }
                        if (objectNode2.has("pssysbdtabledername")) {
                            string2 = objectNode2.get("pssysbdtabledername").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysBDTableDER();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID")) {
            pSCoreSysServiceBase = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDTABLE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBDTABLEDE", (Object)pSSysBDTable.getPSSysBDTableId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysBDColSet)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSSysBDTableDEServiceBase)pSCoreSysServiceBase).selectByPSSysBDTable(pSSysBDTable);
                object3 = StringHelper.format((String)"PSSYSBDTABLE#%1$s", (Object)pSSysBDTable.getPSSysBDTableId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysBDTableDE)object2.next();
                    object = ((PSSysBDTableDEServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysBDColSet)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("pssysbdtabledename")) {
                            string = objectNode.get("pssysbdtabledename").asText();
                        }
                        if (objectNode2.has("pssysbdtabledename")) {
                            string2 = objectNode2.get("pssysbdtabledename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysBDTableDE();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID")) {
            pSCoreSysServiceBase = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDTABLE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBDCOLUMN", (Object)pSSysBDTable.getPSSysBDTableId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysBDColSet)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSSysBDColumnServiceBase)pSCoreSysServiceBase).selectByPSSysBDTable(pSSysBDTable);
                object3 = StringHelper.format((String)"PSSYSBDTABLE#%1$s", (Object)pSSysBDTable.getPSSysBDTableId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysBDColumn)object2.next();
                    object = ((PSSysBDColumnServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysBDColSet)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("pssysbdcolumnname")) {
                            string = objectNode.get("pssysbdcolumnname").asText();
                        }
                        if (objectNode2.has("pssysbdcolumnname")) {
                            string2 = objectNode2.get("pssysbdcolumnname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysBDColumn();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysBDTable, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysBDTable pSSysBDTable) throws Exception {
        super.onEmptyModelV2(pSSysBDTable);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysBDTableDERService)ServiceGlobal.getService(PSSysBDTableDERService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysBDTable pSSysBDTable, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysBDColSet();
        entityBase.set("PSSYSBDTABLEID", pSSysBDTable.getPSSysBDTableId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysBDTableDER();
        entityBase.set("PSSYSBDTABLEID", pSSysBDTable.getPSSysBDTableId());
        pSCoreSysServiceBase = (PSSysBDTableDERService)ServiceGlobal.getService(PSSysBDTableDERService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysBDTableDE();
        entityBase.set("PSSYSBDTABLEID", pSSysBDTable.getPSSysBDTableId());
        pSCoreSysServiceBase = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysBDColumn();
        entityBase.set("PSSYSBDTABLEID", pSSysBDTable.getPSSysBDTableId());
        pSCoreSysServiceBase = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysBDTable, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysBDTable pSSysBDTable, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSSysBDTableServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysBDColSet();
                    ((PSSysBDColSetBase)object).setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                    ((PSSysBDColSetBase)object).setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysBDColSet();
                        entityBase.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                        entityBase.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysBDTableServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysBDTableDERService)ServiceGlobal.getService(PSSysBDTableDERService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysBDTableDER();
                    ((PSSysBDTableDERBase)object).setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                    ((PSSysBDTableDERBase)object).setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysBDTableDER();
                        entityBase.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                        entityBase.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysBDTableServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSSysBDTableDE();
                    ((PSSysBDTableDEBase)object).setPSSysBDSchemeId(pSSysBDTable.getPSSysBDSchemeId());
                    ((PSSysBDTableDEBase)object).setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                    ((PSSysBDTableDEBase)object).setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string6);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysBDTableDE();
                        entityBase.setPSSysBDSchemeId(pSSysBDTable.getPSSysBDSchemeId());
                        entityBase.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                        entityBase.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysBDTableServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSSysBDColumn();
                    ((PSSysBDColumnBase)object).setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                    ((PSSysBDColumnBase)object).setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string7);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysBDColumn();
                        entityBase.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                        entityBase.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysBDTable, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysBDTable pSSysBDTable, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBDColSets(pSSysBDTable, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBDTABLEDER_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBDTableDERs(pSSysBDTable, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBDTableDEs(pSSysBDTable, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBDColumns(pSSysBDTable, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysBDTable, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysBDColSets(PSSysBDTable pSSysBDTable, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBDCOLSET", true), (boolean)false) == 0) {
            PSSysBDColSetService pSSysBDColSetService = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDColSet pSSysBDColSet = new PSSysBDColSet();
            pSSysBDColSet.setPSSysBDColSetId(pSMOSFile.getPSModelId());
            if (!pSSysBDColSetService.get((IEntity)pSSysBDColSet, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBDColSet.getPSSysBDTableId(), (String)pSSysBDTable.getPSSysBDTableId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBDColSetService.exportModelV2(pSSysBDColSet);
            pSSysBDColSet.reset();
            if (!pSSysBDColSetService.setModelV2ResScope((IEntity)pSSysBDColSet, "PSSYSBDTABLE", pSSysBDTable.getPSSysBDTableId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBDColSetService.importModelV2(pSSysBDColSet, objectNode);
            SessionFactoryManager.commit();
            return pSSysBDColSetService.getFile((IEntity)pSSysBDColSet);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysBDTableDERs(PSSysBDTable pSSysBDTable, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBDTABLEDER", true), (boolean)false) == 0) {
            PSSysBDTableDERService pSSysBDTableDERService = (PSSysBDTableDERService)ServiceGlobal.getService(PSSysBDTableDERService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDTableDER pSSysBDTableDER = new PSSysBDTableDER();
            pSSysBDTableDER.setPSSysBDTableDERId(pSMOSFile.getPSModelId());
            if (!pSSysBDTableDERService.get((IEntity)pSSysBDTableDER, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBDTableDER.getPSSysBDTableId(), (String)pSSysBDTable.getPSSysBDTableId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBDTableDERService.exportModelV2(pSSysBDTableDER);
            pSSysBDTableDER.reset();
            if (!pSSysBDTableDERService.setModelV2ResScope((IEntity)pSSysBDTableDER, "PSSYSBDTABLE", pSSysBDTable.getPSSysBDTableId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBDTableDERService.importModelV2(pSSysBDTableDER, objectNode);
            SessionFactoryManager.commit();
            return pSSysBDTableDERService.getFile((IEntity)pSSysBDTableDER);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysBDTableDEs(PSSysBDTable pSSysBDTable, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBDTABLEDE", true), (boolean)false) == 0) {
            PSSysBDTableDEService pSSysBDTableDEService = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDTableDE pSSysBDTableDE = new PSSysBDTableDE();
            pSSysBDTableDE.setPSSysBDTableDEId(pSMOSFile.getPSModelId());
            if (!pSSysBDTableDEService.get((IEntity)pSSysBDTableDE, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBDTableDE.getPSSysBDTableId(), (String)pSSysBDTable.getPSSysBDTableId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBDTableDEService.exportModelV2(pSSysBDTableDE);
            pSSysBDTableDE.reset();
            if (!pSSysBDTableDEService.setModelV2ResScope((IEntity)pSSysBDTableDE, "PSSYSBDTABLE", pSSysBDTable.getPSSysBDTableId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBDTableDEService.importModelV2(pSSysBDTableDE, objectNode);
            SessionFactoryManager.commit();
            return pSSysBDTableDEService.getFile((IEntity)pSSysBDTableDE);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysBDColumns(PSSysBDTable pSSysBDTable, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBDCOLUMN", true), (boolean)false) == 0) {
            PSSysBDColumnService pSSysBDColumnService = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDColumn pSSysBDColumn = new PSSysBDColumn();
            pSSysBDColumn.setPSSysBDColumnId(pSMOSFile.getPSModelId());
            if (!pSSysBDColumnService.get((IEntity)pSSysBDColumn, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBDColumn.getPSSysBDTableId(), (String)pSSysBDTable.getPSSysBDTableId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBDColumnService.exportModelV2(pSSysBDColumn);
            pSSysBDColumn.reset();
            if (!pSSysBDColumnService.setModelV2ResScope((IEntity)pSSysBDColumn, "PSSYSBDTABLE", pSSysBDTable.getPSSysBDTableId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBDColumnService.importModelV2(pSSysBDColumn, objectNode);
            SessionFactoryManager.commit();
            return pSSysBDColumnService.getFile((IEntity)pSSysBDColumn);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysBDTable pSSysBDTable, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysBDColSets(pSSysBDTable, list);
        this.onFillPasteHelps_PSSysBDTableDERs(pSSysBDTable, list);
        this.onFillPasteHelps_PSSysBDTableDEs(pSSysBDTable, list);
        this.onFillPasteHelps_PSSysBDColumns(pSSysBDTable, list);
        super.onFillPasteHelps(pSSysBDTable, list);
    }

    protected void onFillPasteHelps_PSSysBDColSets(PSSysBDTable pSSysBDTable, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBDCOLSET");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5927\u6570\u636e\u5e93\u8868]\u7684[\u5927\u6570\u636e\u8868\u5217\u65cf]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysBDTableDERs(PSSysBDTable pSSysBDTable, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBDTABLEDER");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBDTABLEDER_PSSYSBDTABLE_PSSYSBDTABLEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5927\u6570\u636e\u5e93\u8868]\u7684[\u5927\u6570\u636e\u8868\u5b9e\u4f53\u5173\u7cfb]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysBDTableDEs(PSSysBDTable pSSysBDTable, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBDTABLEDE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5927\u6570\u636e\u5e93\u8868]\u7684[\u5927\u6570\u636e\u8868\u5b9e\u4f53]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysBDColumns(PSSysBDTable pSSysBDTable, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBDCOLUMN");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5927\u6570\u636e\u5e93\u8868]\u7684[\u5927\u6570\u636e\u8868\u5217]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        ArrayList arrayList;
        SelectField selectField;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        PSMOSFile pSMOSFile2;
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6570\u636e\u8868\u5b9e\u4f53>", "DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysBDTableServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6570\u636e\u8868\u5b9e\u4f53>");
            } else if (PSSysBDTableServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssysbdtabledes");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID|PSSYSBDTABLEID");
            pSMOSFile2.setFileTag3("PSSYSBDTABLEDE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysBDTableServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5217\u65cf>", "DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysBDTableServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5217\u65cf>");
            } else if (PSSysBDTableServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssysbdcolsets");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID|PSSYSBDTABLEID");
            pSMOSFile2.setFileTag3("PSSYSBDCOLSET");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysBDTableServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6570\u636e\u5217>", "DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysBDTableServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6570\u636e\u5217>");
            } else if (PSSysBDTableServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssysbdcolumns");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID|PSSYSBDTABLEID");
            pSMOSFile2.setFileTag3("PSSYSBDCOLUMN");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysBDTableServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        PSMOSFile pSMOSFile2;
        ArrayList arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSSysBDTableServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6570\u636e\u8868\u5b9e\u4f53>", (boolean)false) == 0 || PSSysBDTableServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysBDTableDEs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysBDTableServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5217\u65cf>", (boolean)false) == 0 || PSSysBDTableServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysBDColSets", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysBDTableServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6570\u636e\u5217>", (boolean)false) == 0 || PSSysBDTableServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysBDColumns", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID", "PSSYSBDTABLEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (arrayList2.size() > 0) {
            return PSMOSFileUtil.append(arrayList2.toArray(new PSMOSFile[arrayList2.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)false) == 0) {
            if (PSSysBDTableServiceBase.getMOSVer() == 1) {
                return "<\u6570\u636e\u8868\u5b9e\u4f53>";
            }
            if (PSSysBDTableServiceBase.getMOSVer() == 2) {
                return "pssysbdtabledes";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)false) == 0) {
            if (PSSysBDTableServiceBase.getMOSVer() == 1) {
                return "<\u5217\u65cf>";
            }
            if (PSSysBDTableServiceBase.getMOSVer() == 2) {
                return "pssysbdcolsets";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)false) == 0) {
            if (PSSysBDTableServiceBase.getMOSVer() == 1) {
                return "<\u6570\u636e\u5217>";
            }
            if (PSSysBDTableServiceBase.getMOSVer() == 2) {
                return "pssysbdcolumns";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}

