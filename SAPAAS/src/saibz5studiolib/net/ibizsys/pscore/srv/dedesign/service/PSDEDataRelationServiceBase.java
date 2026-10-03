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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDataRelationDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataRelationDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDEBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataRelationServiceBase
extends PSCoreSysServiceBase<PSDEDataRelation> {
    private static final Log log = LogFactory.getLog(PSDEDataRelationServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEDataRelationDEModel pSDEDataRelationDEModel;
    private PSDEDataRelationDAO pSDEDataRelationDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService";
    }

    public PSDEDataRelationDEModel getPSDEDataRelationDEModel() {
        if (this.pSDEDataRelationDEModel == null) {
            try {
                this.pSDEDataRelationDEModel = (PSDEDataRelationDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataRelationDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataRelationDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDataRelationDEModel();
    }

    public PSDEDataRelationDAO getPSDEDataRelationDAO() {
        if (this.pSDEDataRelationDAO == null) {
            try {
                this.pSDEDataRelationDAO = (PSDEDataRelationDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDataRelationDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataRelationDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDataRelationDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchTempCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
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

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
        return dBFetchResult;
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

    protected void onFillParentInfo(PSDEDataRelation pSDEDataRelation, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATARELATION_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlLogicGroup);
            } else {
                iService.get(pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEDataRelation, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATARELATION_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEDataRelation, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATARELATION_PSDEVIEWBASE_FORMPSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_FormPSDEviewBase(pSDEDataRelation, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATARELATION_PSLANGUAGERES_FORMCAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_FormCapPSLanRes(pSDEDataRelation, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATARELATION_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCounter);
            } else {
                iService.get(pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSDEDataRelation, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATARELATION_PSSYSIMAGE_FORMPSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_FormPSSysImage(pSDEDataRelation, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATARELATION_PSWFDE_PSWFDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory());
            PSWFDE pSWFDE = (PSWFDE)iService.getDEModel().createEntity();
            pSWFDE.set("PSWFDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFDE);
            } else {
                iService.get(pSWFDE);
            }
            this.onFillParentInfo_PSWFDE(pSDEDataRelation, pSWFDE);
            return;
        }
        super.onFillParentInfo(pSDEDataRelation, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDEDataRelation pSDEDataRelation, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDEDataRelation.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDEDataRelation.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSDE(PSDEDataRelation pSDEDataRelation, PSDataEntity pSDataEntity) throws Exception {
        pSDEDataRelation.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDataRelation.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_FormPSDEviewBase(PSDEDataRelation pSDEDataRelation, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEDataRelation.setFormPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEDataRelation.setFormPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_FormCapPSLanRes(PSDEDataRelation pSDEDataRelation, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEDataRelation.setFormCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEDataRelation.setFormCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCounter(PSDEDataRelation pSDEDataRelation, PSSysCounter pSSysCounter) throws Exception {
        pSDEDataRelation.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSDEDataRelation.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_FormPSSysImage(PSDEDataRelation pSDEDataRelation, PSSysImage pSSysImage) throws Exception {
        pSDEDataRelation.setFormPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEDataRelation.setFormPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSWFDE(PSDEDataRelation pSDEDataRelation, PSWFDE pSWFDE) throws Exception {
        pSDEDataRelation.setPSWFDEId(pSWFDE.getPSWFDEId());
    }

    protected void onFillEntityFullInfo(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
        if (bl) {
            if (pSDEDataRelation.getCodeName() == null) {
                pSDEDataRelation.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DataRelation", 25));
            }
            if (pSDEDataRelation.getPSDEDataRelationName() == null) {
                pSDEDataRelation.setPSDEDataRelationName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5173\u7cfb\u754c\u9762\u7ec4", 25));
            }
        }
        super.onFillEntityFullInfo(pSDEDataRelation, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDEDataRelation, bl);
        this.onFillEntityFullInfo_PSDE(pSDEDataRelation, bl);
        this.onFillEntityFullInfo_FormPSDEviewBase(pSDEDataRelation, bl);
        this.onFillEntityFullInfo_FormCapPSLanRes(pSDEDataRelation, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSDEDataRelation, bl);
        this.onFillEntityFullInfo_FormPSSysImage(pSDEDataRelation, bl);
        this.onFillEntityFullInfo_PSWFDE(pSDEDataRelation, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
        if (pSDEDataRelation.isPSDEIdDirty()) {
            if (pSDEDataRelation.getPSDEId() != null) {
                if (pSDEDataRelation.getPSDEId() == null || pSDEDataRelation.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEDataRelation.getPSDE();
                    pSDEDataRelation.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEDataRelation.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_FormPSDEviewBase(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_FormCapPSLanRes(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
        if (pSDEDataRelation.isFormCapPSLanResIdDirty()) {
            if (pSDEDataRelation.getFormCapPSLanResId() != null) {
                if (pSDEDataRelation.getFormCapPSLanResId() == null || pSDEDataRelation.getFormCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEDataRelation.getFormCapPSLanRes();
                    pSDEDataRelation.setFormCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEDataRelation.setFormCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_FormPSSysImage(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFDE(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEDataRelation, bl);
    }

    public ArrayList<PSDEDataRelation> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDEDataRelation> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDEDataRelation> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLLOGICGROUPID", (Object)pSCtrlLogicGroupBase.getPSCtrlLogicGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlLogicGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlLogicGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataRelation> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDataRelation> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDataRelation> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataRelation> selectByFormPSDEviewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByFormPSDEviewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEDataRelation> selectByFormPSDEviewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByFormPSDEviewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEDataRelation> selectByFormPSDEviewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FORMPSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFormPSDEviewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFormPSDEviewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataRelation> selectByFormCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByFormCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEDataRelation> selectByFormCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByFormCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEDataRelation> selectByFormCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FORMCAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFormCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFormCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataRelation> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSDEDataRelation> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSDEDataRelation> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCOUNTERID", (Object)pSSysCounterBase.getPSSysCounterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCounterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCounterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataRelation> selectByFormPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByFormPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEDataRelation> selectByFormPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByFormPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEDataRelation> selectByFormPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FORMPSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFormPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFormPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataRelation> selectByPSWFDE(PSWFDEBase pSWFDEBase) throws Exception {
        return this.selectByPSWFDE(pSWFDEBase, "", -1);
    }

    public ArrayList<PSDEDataRelation> selectByPSWFDE(PSWFDEBase pSWFDEBase, String string) throws Exception {
        return this.selectByPSWFDE(pSWFDEBase, string, -1);
    }

    public ArrayList<PSDEDataRelation> selectByPSWFDE(PSWFDEBase pSWFDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFDEID", (Object)pSWFDEBase.getPSWFDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFDECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATARELATION_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDEDATARELATION", iDataEntityModel.getDataInfo(pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            PSDEDataRelation pSDEDataRelation2 = (PSDEDataRelation)this.getDEModel().createEntity();
            pSDEDataRelation2.setPSDEDataRelationId(pSDEDataRelation.getPSDEDataRelationId());
            pSDEDataRelation2.setPSCtrlLogicGroupId(null);
            this.update(pSDEDataRelation2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataRelationServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEDataRelationServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEDataRelationServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            this.remove(pSDEDataRelation);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            PSDEDataRelation pSDEDataRelation2 = (PSDEDataRelation)this.getDEModel().createEntity();
            pSDEDataRelation2.setPSDEDataRelationId(pSDEDataRelation.getPSDEDataRelationId());
            pSDEDataRelation2.setPSDEId(null);
            this.update(pSDEDataRelation2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataRelationServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEDataRelationServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEDataRelationServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            this.remove(pSDEDataRelation);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    public void testRemoveByFormPSDEviewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByFormPSDEviewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATARELATION_PSDEVIEWBASE_FORMPSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDEDATARELATION", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetFormPSDEviewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByFormPSDEviewBase(pSDEViewBase);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            PSDEDataRelation pSDEDataRelation2 = (PSDEDataRelation)this.getDEModel().createEntity();
            pSDEDataRelation2.setPSDEDataRelationId(pSDEDataRelation.getPSDEDataRelationId());
            pSDEDataRelation2.setFormPSDEViewBaseId(null);
            this.update(pSDEDataRelation2);
        }
    }

    public void removeByFormPSDEviewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataRelationServiceBase.this.onBeforeRemoveByFormPSDEviewBase(pSDEViewBase2);
                PSDEDataRelationServiceBase.this.internalRemoveByFormPSDEviewBase(pSDEViewBase2);
                PSDEDataRelationServiceBase.this.onAfterRemoveByFormPSDEviewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByFormPSDEviewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByFormPSDEviewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByFormPSDEviewBase(pSDEViewBase);
        this.onBeforeRemoveByFormPSDEviewBase(pSDEViewBase, arrayList);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            this.remove(pSDEDataRelation);
        }
        this.onAfterRemoveByFormPSDEviewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByFormPSDEviewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByFormPSDEviewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFormPSDEviewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    public void testRemoveByFormCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByFormCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATARELATION_PSLANGUAGERES_FORMCAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEDATARELATION", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetFormCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByFormCapPSLanRes(pSLanguageRes);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            PSDEDataRelation pSDEDataRelation2 = (PSDEDataRelation)this.getDEModel().createEntity();
            pSDEDataRelation2.setPSDEDataRelationId(pSDEDataRelation.getPSDEDataRelationId());
            pSDEDataRelation2.setFormCapPSLanResId(null);
            this.update(pSDEDataRelation2);
        }
    }

    public void removeByFormCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataRelationServiceBase.this.onBeforeRemoveByFormCapPSLanRes(pSLanguageRes2);
                PSDEDataRelationServiceBase.this.internalRemoveByFormCapPSLanRes(pSLanguageRes2);
                PSDEDataRelationServiceBase.this.onAfterRemoveByFormCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByFormCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByFormCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByFormCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByFormCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            this.remove(pSDEDataRelation);
        }
        this.onAfterRemoveByFormCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByFormCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByFormCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFormCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATARELATION_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSDEDATARELATION", iDataEntityModel.getDataInfo(pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            PSDEDataRelation pSDEDataRelation2 = (PSDEDataRelation)this.getDEModel().createEntity();
            pSDEDataRelation2.setPSDEDataRelationId(pSDEDataRelation.getPSDEDataRelationId());
            pSDEDataRelation2.setPSSysCounterId(null);
            this.update(pSDEDataRelation2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataRelationServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSDEDataRelationServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSDEDataRelationServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            this.remove(pSDEDataRelation);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    public void testRemoveByFormPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByFormPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATARELATION_PSSYSIMAGE_FORMPSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEDATARELATION", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetFormPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByFormPSSysImage(pSSysImage);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            PSDEDataRelation pSDEDataRelation2 = (PSDEDataRelation)this.getDEModel().createEntity();
            pSDEDataRelation2.setPSDEDataRelationId(pSDEDataRelation.getPSDEDataRelationId());
            pSDEDataRelation2.setFormPSSysImageId(null);
            this.update(pSDEDataRelation2);
        }
    }

    public void removeByFormPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataRelationServiceBase.this.onBeforeRemoveByFormPSSysImage(pSSysImage2);
                PSDEDataRelationServiceBase.this.internalRemoveByFormPSSysImage(pSSysImage2);
                PSDEDataRelationServiceBase.this.onAfterRemoveByFormPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByFormPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByFormPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByFormPSSysImage(pSSysImage);
        this.onBeforeRemoveByFormPSSysImage(pSSysImage, arrayList);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            this.remove(pSDEDataRelation);
        }
        this.onAfterRemoveByFormPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByFormPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByFormPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFormPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    public void testRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSWFDE(pSWFDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATARELATION_PSWFDE_PSWFDEID", "", iDataEntityModel.getName(), "PSDEDATARELATION", iDataEntityModel.getDataInfo(pSWFDE), arrayList.get(0)));
        }
    }

    public void resetPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSWFDE(pSWFDE);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            PSDEDataRelation pSDEDataRelation2 = (PSDEDataRelation)this.getDEModel().createEntity();
            pSDEDataRelation2.setPSDEDataRelationId(pSDEDataRelation.getPSDEDataRelationId());
            pSDEDataRelation2.setPSWFDEId(null);
            this.update(pSDEDataRelation2);
        }
    }

    public void removeByPSWFDE(PSWFDE pSWFDE) throws Exception {
        final PSWFDE pSWFDE2 = pSWFDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataRelationServiceBase.this.onBeforeRemoveByPSWFDE(pSWFDE2);
                PSDEDataRelationServiceBase.this.internalRemoveByPSWFDE(pSWFDE2);
                PSDEDataRelationServiceBase.this.onAfterRemoveByPSWFDE(pSWFDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void internalRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDEDataRelation> arrayList = this.selectByPSWFDE(pSWFDE);
        this.onBeforeRemoveByPSWFDE(pSWFDE, arrayList);
        for (PSDEDataRelation pSDEDataRelation : arrayList) {
            this.remove(pSDEDataRelation);
        }
        this.onAfterRemoveByPSWFDE(pSWFDE, arrayList);
    }

    protected void onAfterRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void onBeforeRemoveByPSWFDE(PSWFDE pSWFDE, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFDE(PSWFDE pSWFDE, ArrayList<PSDEDataRelation> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDataRelation pSDEDataRelation) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDR(pSDEDataRelation);
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).removeByPSDEDR(pSDEDataRelation);
        pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDR(pSDEDataRelation);
        ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).removeByPSDEDR(pSDEDataRelation);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDR(pSDEDataRelation);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDR(pSDEDataRelation);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDR(pSDEDataRelation);
        super.onBeforeRemove(pSDEDataRelation);
    }

    protected void onBeforeRemoveTemp(PSDEDataRelation pSDEDataRelation) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEDR(pSDEDataRelation);
        pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).removeTempByPSDEDR(pSDEDataRelation);
        super.onBeforeRemoveTemp(pSDEDataRelation);
    }

    protected void getRelatedDataTempMajor(PSDEDataRelation pSDEDataRelation) throws Exception {
        this.getRelatedDataTempMajor_PSDEDRDetail(pSDEDataRelation);
        this.getRelatedDataTempMajor_PSDEDRLogic(pSDEDataRelation);
        super.getRelatedDataTempMajor(pSDEDataRelation);
    }

    protected void getRelatedDataTempMajor_PSDEDRDetail(PSDEDataRelation pSDEDataRelation) throws Exception {
        PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDRDetail> arrayList = null;
        String string = pSDEDataRelation.getPSDEDataRelationId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDRDetailService.selectByPSDEDR(pSDEDataRelation) : pSDEDRDetailService.selectTempByPSDEDR(pSDEDataRelation);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            pSDEDRDetailService.getTempMajor(pSDEDRDetail);
        }
    }

    protected void getRelatedDataTempMajor_PSDEDRLogic(PSDEDataRelation pSDEDataRelation) throws Exception {
        PSDEDRLogicService pSDEDRLogicService = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDRLogic> arrayList = null;
        String string = pSDEDataRelation.getPSDEDataRelationId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDRLogicService.selectByPSDEDR(pSDEDataRelation) : pSDEDRLogicService.selectTempByPSDEDR(pSDEDataRelation);
        for (PSDEDRLogic pSDEDRLogic : arrayList) {
            pSDEDRLogicService.getTempMajor(pSDEDRLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEDataRelation pSDEDataRelation, PSDEDataRelation pSDEDataRelation2) throws Exception {
        ArrayList<PSDEDRLogic> arrayList = this.updateRelatedDataTempMajor_removePSDEDRLogic(pSDEDataRelation, pSDEDataRelation2);
        ArrayList<PSDEDRDetail> arrayList2 = this.updateRelatedDataTempMajor_removePSDEDRDetail(pSDEDataRelation, pSDEDataRelation2);
        this.updateRelatedDataTempMajor_updatePSDEDRDetail(pSDEDataRelation, pSDEDataRelation2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEDRLogic(pSDEDataRelation, pSDEDataRelation2, arrayList);
        super.updateRelatedDataTempMajor(pSDEDataRelation, pSDEDataRelation2);
    }

    protected ArrayList<PSDEDRDetail> updateRelatedDataTempMajor_removePSDEDRDetail(PSDEDataRelation pSDEDataRelation, PSDEDataRelation pSDEDataRelation2) throws Exception {
        PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDRDetail> arrayList = pSDEDRDetailService.selectTempByPSDEDR(pSDEDataRelation);
        ArrayList<PSDEDRDetail> arrayList2 = pSDEDRDetailService.selectByPSDEDR(pSDEDataRelation2);
        HashMap<String, PSDEDRDetail> hashMap = new HashMap<String, PSDEDRDetail>();
        for (PSDEDRDetail pSDEDRDetail : arrayList2) {
            hashMap.put(pSDEDRDetail.getPSDEDRDetailId(), pSDEDRDetail);
        }
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            Object object = pSDEDRDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDRDetail pSDEDRDetail : hashMap.values()) {
            pSDEDRDetailService.remove(pSDEDRDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDRDetail(PSDEDataRelation pSDEDataRelation, PSDEDataRelation pSDEDataRelation2, ArrayList<PSDEDRDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            pSDEDRDetailService.updateTempMajor(pSDEDRDetail);
        }
    }

    protected ArrayList<PSDEDRLogic> updateRelatedDataTempMajor_removePSDEDRLogic(PSDEDataRelation pSDEDataRelation, PSDEDataRelation pSDEDataRelation2) throws Exception {
        PSDEDRLogicService pSDEDRLogicService = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDRLogic> arrayList = pSDEDRLogicService.selectTempByPSDEDR(pSDEDataRelation);
        ArrayList<PSDEDRLogic> arrayList2 = pSDEDRLogicService.selectByPSDEDR(pSDEDataRelation2);
        HashMap<String, PSDEDRLogic> hashMap = new HashMap<String, PSDEDRLogic>();
        for (PSDEDRLogic pSDEDRLogic : arrayList2) {
            hashMap.put(pSDEDRLogic.getPSDEDRLogicId(), pSDEDRLogic);
        }
        for (PSDEDRLogic pSDEDRLogic : arrayList) {
            Object object = pSDEDRLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDRLogic pSDEDRLogic : hashMap.values()) {
            pSDEDRLogicService.remove(pSDEDRLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDRLogic(PSDEDataRelation pSDEDataRelation, PSDEDataRelation pSDEDataRelation2, ArrayList<PSDEDRLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDRLogicService pSDEDRLogicService = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDRLogic pSDEDRLogic : arrayList) {
            pSDEDRLogicService.updateTempMajor(pSDEDRLogic);
        }
    }

    protected void replaceParentInfo(PSDEDataRelation pSDEDataRelation, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEDataRelation, cloneSession);
        if (pSDEDataRelation.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDEDataRelation.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEDataRelation, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDEDataRelation.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDataRelation.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEDataRelation, (PSDataEntity)iEntity);
        }
        if (pSDEDataRelation.getFormPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEDataRelation.getFormPSDEViewBaseId())) != null) {
            this.onFillParentInfo_FormPSDEviewBase(pSDEDataRelation, (PSDEViewBase)iEntity);
        }
        if (pSDEDataRelation.getFormCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEDataRelation.getFormCapPSLanResId())) != null) {
            this.onFillParentInfo_FormCapPSLanRes(pSDEDataRelation, (PSLanguageRes)iEntity);
        }
        if (pSDEDataRelation.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSDEDataRelation.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSDEDataRelation, (PSSysCounter)iEntity);
        }
        if (pSDEDataRelation.getFormPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEDataRelation.getFormPSSysImageId())) != null) {
            this.onFillParentInfo_FormPSSysImage(pSDEDataRelation, (PSSysImage)iEntity);
        }
        if (pSDEDataRelation.getPSWFDEId() != null && (iEntity = cloneSession.getEntity("PSWFDE", (Object)pSDEDataRelation.getPSWFDEId())) != null) {
            this.onFillParentInfo_PSWFDE(pSDEDataRelation, (PSWFDE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEDataRelation, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEDataRelation, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DRTag(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DRTag2(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DRTag3(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DRTag4(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomized(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormCapPSLanResId(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormCapPSLanResName(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormCaption(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormPSDEViewBaseId(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormPSSysImageId(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HideEditItem(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataRelationId(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataRelationName(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFDEId(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDataRelation, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEDataRelation, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isCodeNameDirty() && !bl2 : !pSDEDataRelation.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEDataRelation, bl2, bl3);
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEDataRelationDEModel(), "CODENAME", string3, pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_DRTag(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isDRTagDirty() : !pSDEDataRelation.isDRTagDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getDRTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DRTag_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DRTag2(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isDRTag2Dirty() : !pSDEDataRelation.isDRTag2Dirty()) {
            return null;
        }
        String string = pSDEDataRelation.getDRTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DRTag2_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DRTag3(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isDRTag3Dirty() : !pSDEDataRelation.isDRTag3Dirty()) {
            return null;
        }
        String string = pSDEDataRelation.getDRTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DRTag3_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DRTag4(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isDRTag4Dirty() : !pSDEDataRelation.isDRTag4Dirty()) {
            return null;
        }
        String string = pSDEDataRelation.getDRTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DRTag4_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isDynaModelFlagDirty() : !pSDEDataRelation.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataRelation.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableCustomized(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isEnableCustomizedDirty() : !pSDEDataRelation.isEnableCustomizedDirty()) {
            return null;
        }
        Integer n = pSDEDataRelation.getEnableCustomized();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomized_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECUSTOMIZED");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormCapPSLanResId(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isFormCapPSLanResIdDirty() : !pSDEDataRelation.isFormCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getFormCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormCapPSLanResId_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMCAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormCapPSLanResName(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isFormCapPSLanResNameDirty() : !pSDEDataRelation.isFormCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getFormCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormCapPSLanResName_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMCAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormCaption(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isFormCaptionDirty() : !pSDEDataRelation.isFormCaptionDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getFormCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormCaption_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormPSDEViewBaseId(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isFormPSDEViewBaseIdDirty() : !pSDEDataRelation.isFormPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getFormPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormPSDEViewBaseId_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMPSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormPSSysImageId(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isFormPSSysImageIdDirty() : !pSDEDataRelation.isFormPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getFormPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormPSSysImageId_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMPSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HideEditItem(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isHideEditItemDirty() : !pSDEDataRelation.isHideEditItemDirty()) {
            return null;
        }
        Integer n = pSDEDataRelation.getHideEditItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HideEditItem_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HIDEEDITITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isLockFlagDirty() : !pSDEDataRelation.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataRelation.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isMemoDirty() : !pSDEDataRelation.isMemoDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isPSCtrlLogicGroupIdDirty() : !pSDEDataRelation.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLLOGICGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataRelationId(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isPSDEDataRelationIdDirty() && !bl2 : !pSDEDataRelation.isPSDEDataRelationIdDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getPSDEDataRelationId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATARELATIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataRelationId_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATARELATIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataRelationName(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isPSDEDataRelationNameDirty() && !bl2 : !pSDEDataRelation.isPSDEDataRelationNameDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getPSDEDataRelationName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATARELATIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataRelationName_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATARELATIONNAME");
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEDataRelationDEModel(), "PSDEDATARELATIONNAME", string3, pSDEDataRelation, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDATARELATIONNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isPSDEIdDirty() && !bl2 : !pSDEDataRelation.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isPSDENameDirty() && !bl2 : !pSDEDataRelation.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isPSDynaInstIdDirty() : !pSDEDataRelation.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isPSSysCounterIdDirty() : !pSDEDataRelation.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCOUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFDEId(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isPSWFDEIdDirty() : !pSDEDataRelation.isPSWFDEIdDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getPSWFDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFDEId_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isSRFSysPubDirty() : !pSDEDataRelation.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSDEDataRelation.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default(pSDEDataRelation, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFSYSPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isUserCatDirty() : !pSDEDataRelation.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isUserTagDirty() : !pSDEDataRelation.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDataRelation.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isUserTag2Dirty() : !pSDEDataRelation.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDataRelation.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isUserTag3Dirty() : !pSDEDataRelation.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDataRelation.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEDataRelation, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDataRelation pSDEDataRelation, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataRelation.isUserTag4Dirty() : !pSDEDataRelation.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDataRelation.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEDataRelation, bl2, bl3);
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

    protected void onSyncEntity(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
        super.onSyncEntity(pSDEDataRelation, bl);
    }

    protected void onSyncIndexEntities(PSDEDataRelation pSDEDataRelation, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEDataRelation, bl);
    }

    public Object getDataContextValue(PSDEDataRelation pSDEDataRelation, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEDataRelation, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEDataRelation pSDEDataRelation, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEDRDetail_PSDEDR(pSDEDataRelation, arrayList, n);
        this.onExportRelatedModel_PSDEDRLogic_PSDEDR(pSDEDataRelation, arrayList, n);
        super.onExportRelatedModel(pSDEDataRelation, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEDRDetail_PSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDRDetail> arrayList2 = pSDEDRDetailService.selectByPSDEDR(pSDEDataRelation);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"decf978a021705ac3b4563855c0d6a2c");
            jSONObject.put("srfdename", (Object)"PSDEDRDETAIL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDataRelation, (String)"PSDEDATARELATIONID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEDRDetail pSDEDRDetail : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDRDetail, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDRDetailService.exportModel(pSDEDRDetail, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEDRLogic_PSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDRLogicService pSDEDRLogicService = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDRLogic> arrayList2 = pSDEDRLogicService.selectByPSDEDR(pSDEDataRelation);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"50b809c833bacc367056e63b6a74df2e");
            jSONObject.put("srfdename", (Object)"PSDEDRLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDRLOGIC_PSDEDATARELATION_PSDEDRID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDataRelation, (String)"PSDEDATARELATIONID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEDRLogic pSDEDRLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDRLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDRLogicService.exportModel(pSDEDRLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEDataRelation pSDEDataRelation, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_FormCapPSLanRes(pSDEDataRelation, arrayList, n);
        super.onExportMajorModel(pSDEDataRelation, arrayList, n);
    }

    protected void onExportMajorModel_FormCapPSLanRes(PSDEDataRelation pSDEDataRelation, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEDataRelation.getFormCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEDataRelation.getFormCapPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DRTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DRTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DRTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DRTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMIZED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomized_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMCAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormCapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMCAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormCapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMPSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormPSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMPSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormPSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMPSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormPSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMPSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormPSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HIDEEDITITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HideEditItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATARELATIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataRelationId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATARELATIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataRelationName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DRTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DRTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DRTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DRTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCustomized_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FormCapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMCAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormCapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMCAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMCAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormPSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMPSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormPSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMPSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormPSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMPSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormPSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMPSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HideEditItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSCtrlLogicGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlLogicGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataRelationId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATARELATIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataRelationName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATARELATIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysCounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCounterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFDEID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SRFSysPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDEDataRelation pSDEDataRelation) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEDataRelation)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDataRelation pSDEDataRelation) throws Exception {
        Object object = pSDEDataRelation.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDATARELATION_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEDataRelation);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEDataRelation pSDEDataRelation, Object object) throws Exception {
        PSDEDataRelation pSDEDataRelation2 = new PSDEDataRelation();
        pSDEDataRelation2.set("PSDEDATARELATIONID", object);
        String string = DataObject.getStringValue((Object)pSDEDataRelation.get("PSDEDATARELATIONID"));
        super.onCopyDetails(pSDEDataRelation, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEDataRelation pSDEDataRelation, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDATARELATION");
        if (!bl) {
            pSDEDataRelation.setCreateDate(null);
            pSDEDataRelation.setCreateMan(null);
            pSDEDataRelation.setPSDEDataRelationId(null);
            pSDEDataRelation.setUpdateDate(null);
            pSDEDataRelation.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDataRelation, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEDataRelation pSDEDataRelation, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEDRDetail(pSDEDataRelation, xmlNode);
        super.onExportRelatedXmlModel(pSDEDataRelation, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEDRDetail(PSDEDataRelation pSDEDataRelation, XmlNode xmlNode) throws Exception {
        PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDRDetail> arrayList = null;
        String string = pSDEDataRelation.getPSDEDataRelationId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDRDetailService.selectByPSDEDR(pSDEDataRelation, "ORDER BY ORDERVALUE ASC") : pSDEDRDetailService.selectTempByPSDEDR(pSDEDataRelation, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEDRDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEDRDetail pSDEDRDetail : arrayList) {
                pSDEDRDetail.set("ORDERVALUE", null);
                pSDEDRDetailService.exportXmlModel(pSDEDRDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEDataRelation pSDEDataRelation, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEDRDETAILS");
        this.importRelatedXmlModel_PSDEDRDetail(pSDEDataRelation, xmlNode2);
        super.onImportRelatedXmlModel(pSDEDataRelation, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEDRDetail(PSDEDataRelation pSDEDataRelation, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEDataRelation.getPSDEDataRelationId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEDRDetailService.removeByPSDEDR(pSDEDataRelation);
        } else {
            pSDEDRDetailService.removeTempByPSDEDR(pSDEDataRelation);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEDRDetail pSDEDRDetail = new PSDEDRDetail();
                pSDEDRDetail.setOrderValue(n);
                n += 100;
                pSDEDRDetailService.fillParentInfo(pSDEDRDetail, "DER1N", "DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID", pSDEDataRelation.getPSDEDataRelationId());
                pSDEDRDetailService.importXmlModel(pSDEDRDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDataRelation pSDEDataRelation, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDataRelation, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDATARELATION_PSDATAENTITY_PSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEDataRelation pSDEDataRelation) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDataRelation.getCodeName())) {
            return pSDEDataRelation.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDataRelation.getPSDEDataRelationName())) {
            return pSDEDataRelation.getPSDEDataRelationName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDataRelation.getCodeName())) {
            return pSDEDataRelation.getCodeName();
        }
        return super.getModelV2Tag(pSDEDataRelation);
    }

    @Override
    public boolean setModelV2Tag(PSDEDataRelation pSDEDataRelation, String string) {
        pSDEDataRelation.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEDATARELATIONNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEDATARELATIONNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDataRelation pSDEDataRelation, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDataRelation.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDataRelation, true);
        pSDEDataRelation.set("CODENAME", string);
        if (this.select(pSDEDataRelation, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDataRelation, true);
        return super.getModelV2Entity(pSDEDataRelation, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDataRelation pSDEDataRelation, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDataRelation, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEDRLOGIC_PSDEDATARELATION_PSDEDRID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEDataRelation pSDEDataRelation, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEDataRelation, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEDataRelation pSDEDataRelation, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayNode arrayNode;
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID")) {
            pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATARELATION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDRDETAIL", (Object)pSDEDataRelation.getPSDEDataRelationId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEDATARELATION#%1$s", (Object)pSDEDataRelation.getPSDEDataRelationId());
                for (PSDEDRDetail model : ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).selectByPSDEDR(pSDEDataRelation)) {
                    if (StringHelper.compare(scope, ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdedrdetailname")) {
                            string = objectNode.get("psdedrdetailname").asText();
                        }
                        if (objectNode2.has("psdedrdetailname")) {
                            string2 = objectNode2.get("psdedrdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEDRDetail model = new PSDEDRDetail();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDRLOGIC_PSDEDATARELATION_PSDEDRID")) {
            pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATARELATION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDRLOGIC", (Object)pSDEDataRelation.getPSDEDataRelationId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList();
                String scope = StringHelper.format((String)"PSDEDATARELATION#%1$s", (Object)pSDEDataRelation.getPSDEDataRelationId());
                for (PSDEDRLogic model : ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).selectByPSDEDR(pSDEDataRelation)) {
                    if (StringHelper.compare(scope, ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdedrlogicname")) {
                            string = objectNode.get("psdedrlogicname").asText();
                        }
                        if (objectNode2.has("psdedrlogicname")) {
                            string2 = objectNode2.get("psdedrlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEDRLogic model = new PSDEDRLogic();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEDataRelation, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEDataRelation pSDEDataRelation) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDRDetail> details = ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).selectByPSDEDR(pSDEDataRelation);
        String string2 = StringHelper.format((String)"PSDEDATARELATION#%1$s", (Object)pSDEDataRelation.getPSDEDataRelationId());
        for (PSDEDRDetail entityBase : details) {
            string = ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        SqlParamList params = new SqlParamList();
        params.addString(pSDEDataRelation.getPSDEDataRelationId());
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDRDETAIL WHERE PSDEDRID = ?", params);
        pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDRLogic> logics = ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).selectByPSDEDR(pSDEDataRelation);
        string2 = StringHelper.format((String)"PSDEDATARELATION#%1$s", (Object)pSDEDataRelation.getPSDEDataRelationId());
        for (PSDEDRLogic pSDEDRLogic : logics) {
            string = ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEDRLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEDRLogic);
        }
        params = new SqlParamList();
        params.addString(pSDEDataRelation.getPSDEDataRelationId());
        ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDRLOGIC WHERE PSDEDRID = ?", params);
        super.onEmptyModelV2(pSDEDataRelation);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEDataRelation pSDEDataRelation, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEDRDetail();
        entityBase.set("PSDEDRID", pSDEDataRelation.getPSDEDataRelationId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEDRLogic();
        entityBase.set("PSDEDRID", pSDEDataRelation.getPSDEDataRelationId());
        pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEDataRelation, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEDataRelation pSDEDataRelation, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        File directory;
        File[] files;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                PSDEDRDetail model = new PSDEDRDetail();
                model.setPSDEDRId(pSDEDataRelation.getPSDEDataRelationId());
                model.setPSDEDRName(pSDEDataRelation.getPSDEDataRelationName());
                model.setPSDEId(pSDEDataRelation.getPSDEId());
                pSCoreSysServiceBase.compileModelV2(model, (ObjectNode)arrayNode.get(n2), string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            directory = new File(string4);
            if (directory.exists() && (files = directory.listFiles()) != null) {
                for (File child : files) {
                    if (!child.isDirectory()) continue;
                    PSDEDRDetail model = new PSDEDRDetail();
                    model.setPSDEDRId(pSDEDataRelation.getPSDEDataRelationId());
                    model.setPSDEDRName(pSDEDataRelation.getPSDEDataRelationName());
                    model.setPSDEId(pSDEDataRelation.getPSDEId());
                    pSCoreSysServiceBase.compileModelV2(model, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                PSDEDRLogic model = new PSDEDRLogic();
                model.setPSDEDRId(pSDEDataRelation.getPSDEDataRelationId());
                model.setPSDEDRName(pSDEDataRelation.getPSDEDataRelationName());
                pSCoreSysServiceBase.compileModelV2(model, (ObjectNode)arrayNode.get(n2), string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            directory = new File(string5);
            if (directory.exists() && (files = directory.listFiles()) != null) {
                for (File child : files) {
                    if (!child.isDirectory()) continue;
                    PSDEDRLogic model = new PSDEDRLogic();
                    model.setPSDEDRId(pSDEDataRelation.getPSDEDataRelationId());
                    model.setPSDEDRName(pSDEDataRelation.getPSDEDataRelationName());
                    pSCoreSysServiceBase.compileModelV2(model, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEDataRelation, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEDataRelation pSDEDataRelation, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEDRDetails(pSDEDataRelation, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEDataRelation, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEDRDetails(PSDEDataRelation pSDEDataRelation, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDRDETAIL", true), (boolean)false) == 0) {
            PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEDRDetail pSDEDRDetail = new PSDEDRDetail();
            pSDEDRDetail.setPSDEDRDetailId(pSMOSFile.getPSModelId());
            if (!pSDEDRDetailService.get(pSDEDRDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEDRDetail.getPSDEDRId(), (String)pSDEDataRelation.getPSDEDataRelationId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEDRDetailService.exportModelV2(pSDEDRDetail);
            pSDEDRDetail.reset();
            if (!pSDEDRDetailService.setModelV2ResScope(pSDEDRDetail, "PSDEDATARELATION", pSDEDataRelation.getPSDEDataRelationId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEDRDetailService.importModelV2(pSDEDRDetail, objectNode);
            SessionFactoryManager.commit();
            return pSDEDRDetailService.getFile(pSDEDRDetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDRITEM", true), (boolean)false) == 0) {
            PSDEDRItemService pSDEDRItemService = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
            PSDEDRItem pSDEDRItem = new PSDEDRItem();
            pSDEDRItem.setPSDEDRItemId(pSMOSFile.getPSModelId());
            if (!pSDEDRItemService.get(pSDEDRItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEDRDetail pSDEDRDetail = new PSDEDRDetail();
            pSDEDRDetail.setPSDEDRId(pSDEDataRelation.getPSDEDataRelationId());
            pSDEDRDetail.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            this.fillPasteEntity(pSDEDRDetail, "PASTETAG|DETAILTYPE:DRITEM");
            pSDEDRDetailService.create(pSDEDRDetail);
            if (StringHelper.compare((String)pSDEDRItem.getPSDEId(), (String)pSDEDRDetail.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5b9e\u4f53\u7f16\u53f7]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEDRDetailService.getFile(pSDEDRDetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSPDTVIEW", true), (boolean)false) == 0) {
            PSSysPDTViewService pSSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
            PSSysPDTView pSSysPDTView = new PSSysPDTView();
            pSSysPDTView.setPSSysPDTViewId(pSMOSFile.getPSModelId());
            if (!pSSysPDTViewService.get(pSSysPDTView, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEDRDetail pSDEDRDetail = new PSDEDRDetail();
            pSDEDRDetail.setPSDEDRId(pSDEDataRelation.getPSDEDataRelationId());
            pSDEDRDetail.setPSSysPDTViewId(pSSysPDTView.getPSSysPDTViewId());
            this.fillPasteEntity(pSDEDRDetail, "PASTETAG|DETAILTYPE:PDTVIEW");
            pSDEDRDetailService.create(pSDEDRDetail);
            SessionFactoryManager.commit();
            return pSDEDRDetailService.getFile(pSDEDRDetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEDataRelation pSDEDataRelation, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEDRDetails(pSDEDataRelation, list);
        super.onFillPasteHelps(pSDEDataRelation, list);
    }

    protected void onFillPasteHelps_PSDEDRDetails(PSDEDataRelation pSDEDataRelation, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEDRDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u7ec4]\u7684[\u5b9e\u4f53\u754c\u9762\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEDRDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID");
        pSHelpSection.setUserTag("DER1N_PSDEDRDETAIL_PSDEDRITEM_PSDEDRITEMID");
        pSHelpSection.setContent("\u7c98\u8d34[\u5b9e\u4f53\u5173\u7cfb\u754c\u9762]\u6784\u5efa[\u5b9e\u4f53\u754c\u9762\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEDRDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID");
        pSHelpSection.setUserTag("DER1N_PSDEDRDETAIL_PSSYSPDTVIEW_PSSYSPDTVIEWID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u7cfb\u7edf\u7684[\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe]\u6784\u5efa[\u5b9e\u4f53\u754c\u9762\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5173\u7cfb\u6210\u5458>", "DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID", "PSDEDRID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSDEDataRelationServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5173\u7cfb\u6210\u5458>");
            } else if (PSDEDataRelationServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdedrdetails");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID|PSDEDRID");
            pSMOSFile2.setFileTag3("PSDEDRDETAIL");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID", "PSDEDRID", pSMOSFile.getPSModelId(), "", "")) {
                PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEDRDetailService, "DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID", "PSDEDRID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSDEDRDetailService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEDataRelationServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSDEDataRelationServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5173\u7cfb\u6210\u5458>", (boolean)false) == 0 || PSDEDataRelationServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEDRDetails", (boolean)true) == 0) {
            PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEDRDetailService, "DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID", "PSDEDRID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSDEDRDetail> arrayList2 = pSDEDRDetailService.selectEx((ISelectContext)selectContext);
            for (PSDEDRDetail pSDEDRDetail : arrayList2) {
                PSMOSFile pSMOSFile2 = pSDEDRDetailService.getFile(pSMOSFile, pSDEDRDetail, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID", (boolean)false) == 0) {
            if (PSDEDataRelationServiceBase.getMOSVer() == 1) {
                return "<\u5173\u7cfb\u6210\u5458>";
            }
            if (PSDEDataRelationServiceBase.getMOSVer() == 2) {
                return "psdedrdetails";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEDataRelation pSDEDataRelation, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DataRelation");
        defaultValueMap.put("PSDEDATARELATIONNAME", "\u5173\u7cfb\u754c\u9762\u7ec4");
    }
}
