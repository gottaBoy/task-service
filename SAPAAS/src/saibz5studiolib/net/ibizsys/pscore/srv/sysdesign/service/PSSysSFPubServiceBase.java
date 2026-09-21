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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleParam;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleParamBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVerBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFPubDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPubDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFCode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFCodeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubPkg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubPkgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubPkgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubPkgServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubRefServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFPubServiceBase
extends PSCoreSysServiceBase<PSSysSFPub> {
    private static final Log log = LogFactory.getLog(PSSysSFPubServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYS2 = "CurSys2";
    public static final String DATASET_CURSYSDOC = "CurSysDoc";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysSFPubDEModel pSSysSFPubDEModel;
    private PSSysSFPubDAO pSSysSFPubDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService";
    }

    public PSSysSFPubDEModel getPSSysSFPubDEModel() {
        if (this.pSSysSFPubDEModel == null) {
            try {
                this.pSSysSFPubDEModel = (PSSysSFPubDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPubDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFPubDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSFPubDEModel();
    }

    public PSSysSFPubDAO getPSSysSFPubDAO() {
        if (this.pSSysSFPubDAO == null) {
            try {
                this.pSSysSFPubDAO = (PSSysSFPubDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFPubDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFPubDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSFPubDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS2, (boolean)true) == 0) {
            return this.fetchCurSys2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDOC, (boolean)true) == 0) {
            return this.fetchCurSysDoc(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDoc(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDOC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysSFPub pSSysSFPub, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUB_PSSFSTYLEPARAM_PSSFSTYLEPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleParamService", (SessionFactory)this.getSessionFactory());
            PSSFStyleParam pSSFStyleParam = (PSSFStyleParam)iService.getDEModel().createEntity();
            pSSFStyleParam.set("PSSFSTYLEPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyleParam);
            } else {
                iService.get((IEntity)pSSFStyleParam);
            }
            this.onFillParentInfo_PSSFStyleParam(pSSysSFPub, pSSFStyleParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUB_PSSFSTYLEVER_PSSFSTYLEVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleVerService", (SessionFactory)this.getSessionFactory());
            PSSFStyleVer pSSFStyleVer = (PSSFStyleVer)iService.getDEModel().createEntity();
            pSSFStyleVer.set("PSSFSTYLEVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyleVer);
            } else {
                iService.get((IEntity)pSSFStyleVer);
            }
            this.onFillParentInfo_PSSFStyleVer(pSSysSFPub, pSSFStyleVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUB_PSSFSTYLE_DOCPSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyle);
            } else {
                iService.get((IEntity)pSSFStyle);
            }
            this.onFillParentInfo_DocPSSFStyle(pSSysSFPub, pSSFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUB_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyle);
            } else {
                iService.get((IEntity)pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSSysSFPub, pSSFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUB_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysSFPub, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUB_PSSYSSFPUB_PPSSYSSFPUBID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            PSSysSFPub pSSysSFPub2 = (PSSysSFPub)iService.getDEModel().createEntity();
            pSSysSFPub2.set("PSSYSSFPUBID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPub2);
            } else {
                iService.get((IEntity)pSSysSFPub2);
            }
            this.onFillParentInfo_PPSSysSFPub(pSSysSFPub, pSSysSFPub2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUB_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysSFPub, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysSFPub, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFStyleParam(PSSysSFPub pSSysSFPub, PSSFStyleParam pSSFStyleParam) throws Exception {
        pSSysSFPub.setPSSFStyleParamId(pSSFStyleParam.getPSSFStyleParamId());
        pSSysSFPub.setPSSFStyleParamName(pSSFStyleParam.getPSSFStyleParamName());
    }

    protected void onFillParentInfo_PSSFStyleVer(PSSysSFPub pSSysSFPub, PSSFStyleVer pSSFStyleVer) throws Exception {
        pSSysSFPub.setPSSFStyleVerId(pSSFStyleVer.getPSSFStyleVerId());
        pSSysSFPub.setPSSFStyleVerName(pSSFStyleVer.getPSSFStyleVerName());
    }

    protected void onFillParentInfo_DocPSSFStyle(PSSysSFPub pSSysSFPub, PSSFStyle pSSFStyle) throws Exception {
        pSSysSFPub.setDocPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSSysSFPub.setDocPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillParentInfo_PSSFStyle(PSSysSFPub pSSysSFPub, PSSFStyle pSSFStyle) throws Exception {
        pSSysSFPub.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSSysSFPub.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysSFPub pSSysSFPub, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysSFPub.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysSFPub.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PPSSysSFPub(PSSysSFPub pSSysSFPub, PSSysSFPub pSSysSFPub2) throws Exception {
        pSSysSFPub.setPPSSysSFPubId(pSSysSFPub2.getPSSysSFPubId());
        pSSysSFPub.setPPSSysSFPubName(pSSysSFPub2.getPSSysSFPubName());
    }

    protected void onFillParentInfo_PSSystem(PSSysSFPub pSSysSFPub, PSSystem pSSystem) throws Exception {
        pSSysSFPub.setPSSystemId(pSSystem.getPSSystemId());
        pSSysSFPub.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
        if (bl && pSSysSFPub.getPSSysSFCodesCnt() == null) {
            pSSysSFPub.setPSSysSFCodesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysSFPub, bl);
        this.onFillEntityFullInfo_PSSFStyleParam(pSSysSFPub, bl);
        this.onFillEntityFullInfo_PSSFStyleVer(pSSysSFPub, bl);
        this.onFillEntityFullInfo_DocPSSFStyle(pSSysSFPub, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSSysSFPub, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysSFPub, bl);
        this.onFillEntityFullInfo_PPSSysSFPub(pSSysSFPub, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysSFPub, bl);
    }

    protected void onFillEntityFullInfo_PSSFStyleParam(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
        if (pSSysSFPub.isPSSFStyleParamIdDirty()) {
            if (pSSysSFPub.getPSSFStyleParamId() != null) {
                if (pSSysSFPub.getPSSFStyleParamId() == null || pSSysSFPub.getPSSFStyleParamName() == null) {
                    PSSFStyleParam pSSFStyleParam = pSSysSFPub.getPSSFStyleParam();
                    pSSysSFPub.setPSSFStyleParamName(pSSFStyleParam.getPSSFStyleParamName());
                }
            } else {
                pSSysSFPub.setPSSFStyleParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFStyleVer(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DocPSSFStyle(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
        if (pSSysSFPub.isDocPSSFStyleIdDirty()) {
            if (pSSysSFPub.getDocPSSFStyleId() != null) {
                if (pSSysSFPub.getDocPSSFStyleId() == null || pSSysSFPub.getDocPSSFStyleName() == null) {
                    PSSFStyle pSSFStyle = pSSysSFPub.getDocPSSFStyle();
                    pSSysSFPub.setDocPSSFStyleName(pSSFStyle.getPSSFStyleName());
                }
            } else {
                pSSysSFPub.setDocPSSFStyleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSysSFPub(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysSFPub, bl);
    }

    public ArrayList<PSSysSFPub> selectByPSSFStyleParam(PSSFStyleParamBase pSSFStyleParamBase) throws Exception {
        return this.selectByPSSFStyleParam(pSSFStyleParamBase, "", -1);
    }

    public ArrayList<PSSysSFPub> selectByPSSFStyleParam(PSSFStyleParamBase pSSFStyleParamBase, String string) throws Exception {
        return this.selectByPSSFStyleParam(pSSFStyleParamBase, string, -1);
    }

    public ArrayList<PSSysSFPub> selectByPSSFStyleParam(PSSFStyleParamBase pSSFStyleParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEPARAMID", (Object)pSSFStyleParamBase.getPSSFStyleParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSFPub> selectByPSSFStyleVer(PSSFStyleVerBase pSSFStyleVerBase) throws Exception {
        return this.selectByPSSFStyleVer(pSSFStyleVerBase, "", -1);
    }

    public ArrayList<PSSysSFPub> selectByPSSFStyleVer(PSSFStyleVerBase pSSFStyleVerBase, String string) throws Exception {
        return this.selectByPSSFStyleVer(pSSFStyleVerBase, string, -1);
    }

    public ArrayList<PSSysSFPub> selectByPSSFStyleVer(PSSFStyleVerBase pSSFStyleVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEVERID", (Object)pSSFStyleVerBase.getPSSFStyleVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSFPub> selectByDocPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByDocPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSysSFPub> selectByDocPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByDocPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSysSFPub> selectByDocPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DOCPSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDocPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDocPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSFPub> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSysSFPub> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSysSFPub> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSFPub> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysSFPub> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysSFPub> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSFPub> selectByPPSSysSFPub(PSSysSFPubBase pSSysSFPubBase) throws Exception {
        return this.selectByPPSSysSFPub(pSSysSFPubBase, "", -1);
    }

    public ArrayList<PSSysSFPub> selectByPPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string) throws Exception {
        return this.selectByPPSSysSFPub(pSSysSFPubBase, string, -1);
    }

    public ArrayList<PSSysSFPub> selectByPPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSSFPUBID", (Object)pSSysSFPubBase.getPSSysSFPubId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysSFPubCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysSFPubCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSFPub> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysSFPub> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysSFPub> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFStyleParam(PSSFStyleParam pSSFStyleParam) throws Exception {
    }

    public void resetPSSFStyleParam(PSSFStyleParam pSSFStyleParam) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSFStyleParam(pSSFStyleParam);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            PSSysSFPub pSSysSFPub2 = (PSSysSFPub)this.getDEModel().createEntity();
            pSSysSFPub2.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
            pSSysSFPub2.setPSSFStyleParamId(null);
            this.update(pSSysSFPub2);
        }
    }

    public void removeByPSSFStyleParam(PSSFStyleParam pSSFStyleParam) throws Exception {
        final PSSFStyleParam pSSFStyleParam2 = pSSFStyleParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubServiceBase.this.onBeforeRemoveByPSSFStyleParam(pSSFStyleParam2);
                PSSysSFPubServiceBase.this.internalRemoveByPSSFStyleParam(pSSFStyleParam2);
                PSSysSFPubServiceBase.this.onAfterRemoveByPSSFStyleParam(pSSFStyleParam2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyleParam(PSSFStyleParam pSSFStyleParam) throws Exception {
    }

    protected void internalRemoveByPSSFStyleParam(PSSFStyleParam pSSFStyleParam) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSFStyleParam(pSSFStyleParam);
        this.onBeforeRemoveByPSSFStyleParam(pSSFStyleParam, arrayList);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            this.remove((IEntity)pSSysSFPub);
        }
        this.onAfterRemoveByPSSFStyleParam(pSSFStyleParam, arrayList);
    }

    protected void onAfterRemoveByPSSFStyleParam(PSSFStyleParam pSSFStyleParam) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyleParam(PSSFStyleParam pSSFStyleParam, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyleParam(PSSFStyleParam pSSFStyleParam, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSFStyleVer(pSSFStyleVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFSTYLEVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFStyleVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSFPUB_PSSFSTYLEVER_PSSFSTYLEVERID", "", iDataEntityModel.getName(), "PSSYSSFPUB", iDataEntityModel.getDataInfo((IEntity)pSSFStyleVer), arrayList.get(0)));
        }
    }

    public void resetPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSFStyleVer(pSSFStyleVer);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            PSSysSFPub pSSysSFPub2 = (PSSysSFPub)this.getDEModel().createEntity();
            pSSysSFPub2.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
            pSSysSFPub2.setPSSFStyleVerId(null);
            this.update(pSSysSFPub2);
        }
    }

    public void removeByPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        final PSSFStyleVer pSSFStyleVer2 = pSSFStyleVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubServiceBase.this.onBeforeRemoveByPSSFStyleVer(pSSFStyleVer2);
                PSSysSFPubServiceBase.this.internalRemoveByPSSFStyleVer(pSSFStyleVer2);
                PSSysSFPubServiceBase.this.onAfterRemoveByPSSFStyleVer(pSSFStyleVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
    }

    protected void internalRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSFStyleVer(pSSFStyleVer);
        this.onBeforeRemoveByPSSFStyleVer(pSSFStyleVer, arrayList);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            this.remove((IEntity)pSSysSFPub);
        }
        this.onAfterRemoveByPSSFStyleVer(pSSFStyleVer, arrayList);
    }

    protected void onAfterRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    public void testRemoveByDocPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    public void resetDocPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByDocPSSFStyle(pSSFStyle);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            PSSysSFPub pSSysSFPub2 = (PSSysSFPub)this.getDEModel().createEntity();
            pSSysSFPub2.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
            pSSysSFPub2.setDocPSSFStyleId(null);
            this.update(pSSysSFPub2);
        }
    }

    public void removeByDocPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubServiceBase.this.onBeforeRemoveByDocPSSFStyle(pSSFStyle2);
                PSSysSFPubServiceBase.this.internalRemoveByDocPSSFStyle(pSSFStyle2);
                PSSysSFPubServiceBase.this.onAfterRemoveByDocPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByDocPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByDocPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByDocPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByDocPSSFStyle(pSSFStyle, arrayList);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            this.remove((IEntity)pSSysSFPub);
        }
        this.onAfterRemoveByDocPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByDocPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByDocPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDocPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSFStyle(pSSFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSFPUB_PSSFSTYLE_PSSFSTYLEID", "", iDataEntityModel.getName(), "PSSYSSFPUB", iDataEntityModel.getDataInfo((IEntity)pSSFStyle), arrayList.get(0)));
        }
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            PSSysSFPub pSSysSFPub2 = (PSSysSFPub)this.getDEModel().createEntity();
            pSSysSFPub2.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
            pSSysSFPub2.setPSSFStyleId(null);
            this.update(pSSysSFPub2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSSysSFPubServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSSysSFPubServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            this.remove((IEntity)pSSysSFPub);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSFPUB_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSSFPUB", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            PSSysSFPub pSSysSFPub2 = (PSSysSFPub)this.getDEModel().createEntity();
            pSSysSFPub2.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
            pSSysSFPub2.setPSSysDynaModelId(null);
            this.update(pSSysSFPub2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysSFPubServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysSFPubServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            this.remove((IEntity)pSSysSFPub);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPPSSysSFPub(pSSysSFPub, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPUB");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPub);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSFPUB_PSSYSSFPUB_PPSSYSSFPUBID", "", iDataEntityModel.getName(), "PSSYSSFPUB", iDataEntityModel.getDataInfo((IEntity)pSSysSFPub), arrayList.get(0)));
        }
    }

    public void resetPPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPPSSysSFPub(pSSysSFPub);
        for (PSSysSFPub pSSysSFPub2 : arrayList) {
            PSSysSFPub pSSysSFPub3 = (PSSysSFPub)this.getDEModel().createEntity();
            pSSysSFPub3.setPSSysSFPubId(pSSysSFPub2.getPSSysSFPubId());
            pSSysSFPub3.setPPSSysSFPubId(null);
            this.update(pSSysSFPub3);
        }
    }

    public void removeByPPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        final PSSysSFPub pSSysSFPub2 = pSSysSFPub;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubServiceBase.this.onBeforeRemoveByPPSSysSFPub(pSSysSFPub2);
                PSSysSFPubServiceBase.this.internalRemoveByPPSSysSFPub(pSSysSFPub2);
                PSSysSFPubServiceBase.this.onAfterRemoveByPPSSysSFPub(pSSysSFPub2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void internalRemoveByPPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPPSSysSFPub(pSSysSFPub);
        this.onBeforeRemoveByPPSSysSFPub(pSSysSFPub, arrayList);
        for (PSSysSFPub pSSysSFPub2 : arrayList) {
            this.remove((IEntity)pSSysSFPub2);
        }
        this.onAfterRemoveByPPSSysSFPub(pSSysSFPub, arrayList);
    }

    protected void onAfterRemoveByPPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            PSSysSFPub pSSysSFPub2 = (PSSysSFPub)this.getDEModel().createEntity();
            pSSysSFPub2.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
            pSSysSFPub2.setPSSystemId(null);
            this.update(pSSysSFPub2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysSFPubServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysSFPubServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSFPub> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysSFPub pSSysSFPub : arrayList) {
            this.remove((IEntity)pSSysSFPub);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSFPub> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSFPub pSSysSFPub) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSModuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPub(pSSysSFPub);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPub(pSSysSFPub);
        pSCoreSysServiceBase = (PSSysDeployService)ServiceGlobal.getService(PSSysDeployService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDeployServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPub(pSSysSFPub);
        ((PSSysDeployServiceBase)pSCoreSysServiceBase).resetPSSysSFPub(pSSysSFPub);
        pSCoreSysServiceBase = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysProjectServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPub(pSSysSFPub);
        ((PSSysProjectServiceBase)pSCoreSysServiceBase).removeByPSSysSFPub(pSSysSFPub);
        pSCoreSysServiceBase = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPub(pSSysSFPub);
        ((PSSysSFCodeServiceBase)pSCoreSysServiceBase).removeByPSSysSFPub(pSSysSFPub);
        pSCoreSysServiceBase = (PSSysSFPubPkgService)ServiceGlobal.getService(PSSysSFPubPkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFPubPkgServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPub(pSSysSFPub);
        ((PSSysSFPubPkgServiceBase)pSCoreSysServiceBase).removeByPSSysSFPub(pSSysSFPub);
        pSCoreSysServiceBase = (PSSysSFPubRefService)ServiceGlobal.getService(PSSysSFPubRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFPubRefServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPub(pSSysSFPub);
        ((PSSysSFPubRefServiceBase)pSCoreSysServiceBase).removeByPSSysSFPub(pSSysSFPub);
        pSCoreSysServiceBase = (PSSysSFPubRefService)ServiceGlobal.getService(PSSysSFPubRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFPubRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysSFPub(pSSysSFPub);
        pSCoreSysServiceBase = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFPubServiceBase)pSCoreSysServiceBase).testRemoveByPPSSysSFPub(pSSysSFPub);
        pSCoreSysServiceBase = (PSSystemRunService)ServiceGlobal.getService(PSSystemRunService.class, (SessionFactory)this.getSessionFactory());
        ((PSSystemRunServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPub(pSSysSFPub);
        super.onBeforeRemove(pSSysSFPub);
    }

    protected void replaceParentInfo(PSSysSFPub pSSysSFPub, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysSFPub, cloneSession);
        if (pSSysSFPub.getPSSFStyleParamId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLEPARAM", (Object)pSSysSFPub.getPSSFStyleParamId())) != null) {
            this.onFillParentInfo_PSSFStyleParam(pSSysSFPub, (PSSFStyleParam)iEntity);
        }
        if (pSSysSFPub.getPSSFStyleVerId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLEVER", (Object)pSSysSFPub.getPSSFStyleVerId())) != null) {
            this.onFillParentInfo_PSSFStyleVer(pSSysSFPub, (PSSFStyleVer)iEntity);
        }
        if (pSSysSFPub.getDocPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSysSFPub.getDocPSSFStyleId())) != null) {
            this.onFillParentInfo_DocPSSFStyle(pSSysSFPub, (PSSFStyle)iEntity);
        }
        if (pSSysSFPub.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSysSFPub.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSSysSFPub, (PSSFStyle)iEntity);
        }
        if (pSSysSFPub.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysSFPub.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysSFPub, (PSSysDynaModel)iEntity);
        }
        if (pSSysSFPub.getPPSSysSFPubId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPUB", (Object)pSSysSFPub.getPPSSysSFPubId())) != null) {
            this.onFillParentInfo_PPSSysSFPub(pSSysSFPub, (PSSysSFPub)iEntity);
        }
        if (pSSysSFPub.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysSFPub.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysSFPub, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysSFPub, bl);
        pSSysSFPub.resetPubTag();
        pSSysSFPub.resetPubTag2();
        pSSysSFPub.resetPubTag3();
        pSSysSFPub.resetPubTag4();
    }

    protected void onCheckEntity(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BaseClsParams(bl, pSSysSFPub, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BaseCLSPKGCodeName(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultPub(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DocPSSFStyleId(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DocPSSFStyleName(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelMode(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GlobalTSFlag(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PKGCodeName(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysSFPubId(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleParamId(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleParamName(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleVerId(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFCodesCnt(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubId(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubName(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubPkgsCnt(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubFolder(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubTag(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubTag2(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubTag3(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubTag4(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoveFlag(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StyleParams(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubSysPkgFlag(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerStr(bl, pSSysSFPub, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysSFPub, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BaseClsParams(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isBaseClsParamsDirty() : !pSSysSFPub.isBaseClsParamsDirty()) {
            return null;
        }
        String string = pSSysSFPub.getBaseClsParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BaseClsParams_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BASECLSPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BaseCLSPKGCodeName(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isBaseCLSPKGCodeNameDirty() : !pSSysSFPub.isBaseCLSPKGCodeNameDirty()) {
            return null;
        }
        String string = pSSysSFPub.getBaseCLSPKGCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BaseCLSPKGCodeName_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BASECLSPKGCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isCodeNameDirty() : !pSSysSFPub.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysSFPub.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysSFPub, bl2, bl3);
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
                string3 = "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysSFPubDEModel(), "CODENAME", string3, pSSysSFPub, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isContentTypeDirty() : !pSSysSFPub.isContentTypeDirty()) {
            return null;
        }
        String string = pSSysSFPub.getContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultPub(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isDefaultPubDirty() : !pSSysSFPub.isDefaultPubDirty()) {
            return null;
        }
        Integer n = pSSysSFPub.getDefaultPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultPub_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSYSTEMID";
                String string2 = this.checkFieldDupRule(this.getPSSysSFPubDEModel(), "DEFAULTPUB", string, pSSysSFPub, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTPUB");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DocPSSFStyleId(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isDocPSSFStyleIdDirty() : !pSSysSFPub.isDocPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSysSFPub.getDocPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DocPSSFStyleId_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCPSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DocPSSFStyleName(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isDocPSSFStyleNameDirty() : !pSSysSFPub.isDocPSSFStyleNameDirty()) {
            return null;
        }
        String string = pSSysSFPub.getDocPSSFStyleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DocPSSFStyleName_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCPSSFSTYLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelMode(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isDynaModelModeDirty() : !pSSysSFPub.isDynaModelModeDirty()) {
            return null;
        }
        String string = pSSysSFPub.getDynaModelMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaModelMode_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GlobalTSFlag(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isGlobalTSFlagDirty() : !pSSysSFPub.isGlobalTSFlagDirty()) {
            return null;
        }
        Integer n = pSSysSFPub.getGlobalTSFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GlobalTSFlag_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GLOBALTSFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isMemoDirty() : !pSSysSFPub.isMemoDirty()) {
            return null;
        }
        String string = pSSysSFPub.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysSFPub, bl2, bl3);
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

    protected EntityFieldError onCheckField_PKGCodeName(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPKGCodeNameDirty() : !pSSysSFPub.isPKGCodeNameDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPKGCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PKGCodeName_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSysSFPubId(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPPSSysSFPubIdDirty() : !pSSysSFPub.isPPSSysSFPubIdDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPPSSysSFPubId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysSFPubId_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSSFPUBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPSSFStyleIdDirty() : !pSSysSFPub.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleParamId(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPSSFStyleParamIdDirty() : !pSSysSFPub.isPSSFStyleParamIdDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPSSFStyleParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleParamId_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleParamName(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPSSFStyleParamNameDirty() : !pSSysSFPub.isPSSFStyleParamNameDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPSSFStyleParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleParamName_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleVerId(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPSSFStyleVerIdDirty() : !pSSysSFPub.isPSSFStyleVerIdDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPSSFStyleVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleVerId_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPSSysDynaModelIdDirty() : !pSSysSFPub.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSSysSFPub, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFCodesCnt(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPSSysSFCodesCntDirty() : !pSSysSFPub.isPSSysSFCodesCntDirty()) {
            return null;
        }
        Integer n = pSSysSFPub.getPSSysSFCodesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysSFCodesCnt_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFCODESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubId(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPSSysSFPubIdDirty() && !bl2 : !pSSysSFPub.isPSSysSFPubIdDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPSSysSFPubId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubId_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubName(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPSSysSFPubNameDirty() && !bl2 : !pSSysSFPub.isPSSysSFPubNameDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPSSysSFPubName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubName_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubPkgsCnt(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPSSysSFPubPkgsCntDirty() : !pSSysSFPub.isPSSysSFPubPkgsCntDirty()) {
            return null;
        }
        Integer n = pSSysSFPub.getPSSysSFPubPkgsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysSFPubPkgsCnt_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBPKGSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPSSystemIdDirty() && !bl2 : !pSSysSFPub.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubFolder(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPubFolderDirty() : !pSSysSFPub.isPubFolderDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPubFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubFolder_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubTag(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPubTagDirty() : !pSSysSFPub.isPubTagDirty()) {
            return null;
        }
        String string = pSSysSFPub.getPubTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubTag_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubTag2(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPubTag2Dirty() : !pSSysSFPub.isPubTag2Dirty()) {
            return null;
        }
        String string = pSSysSFPub.getPubTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubTag2_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubTag3(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPubTag3Dirty() : !pSSysSFPub.isPubTag3Dirty()) {
            return null;
        }
        String string = pSSysSFPub.getPubTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubTag3_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubTag4(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isPubTag4Dirty() : !pSSysSFPub.isPubTag4Dirty()) {
            return null;
        }
        String string = pSSysSFPub.getPubTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubTag4_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemoveFlag(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isRemoveFlagDirty() : !pSSysSFPub.isRemoveFlagDirty()) {
            return null;
        }
        Integer n = pSSysSFPub.getRemoveFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RemoveFlag_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StyleParams(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isStyleParamsDirty() : !pSSysSFPub.isStyleParamsDirty()) {
            return null;
        }
        String string = pSSysSFPub.getStyleParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StyleParams_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STYLEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubSysPkgFlag(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isSubSysPkgFlagDirty() : !pSSysSFPub.isSubSysPkgFlagDirty()) {
            return null;
        }
        Integer n = pSSysSFPub.getSubSysPkgFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SubSysPkgFlag_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBSYSPKGFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isUserCatDirty() : !pSSysSFPub.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSFPub.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysSFPub, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isUserTagDirty() : !pSSysSFPub.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSFPub.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysSFPub, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isUserTag2Dirty() : !pSSysSFPub.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSFPub.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysSFPub, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isUserTag3Dirty() : !pSSysSFPub.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSFPub.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysSFPub, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isUserTag4Dirty() : !pSSysSFPub.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSFPub.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysSFPub, bl2, bl3);
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

    protected EntityFieldError onCheckField_VerStr(boolean bl, PSSysSFPub pSSysSFPub, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPub.isVerStrDirty() : !pSSysSFPub.isVerStrDirty()) {
            return null;
        }
        String string = pSSysSFPub.getVerStr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerStr_Default((IEntity)pSSysSFPub, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysSFPub, bl);
    }

    protected void onSyncIndexEntities(PSSysSFPub pSSysSFPub, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysSFPub, bl);
    }

    public Object getDataContextValue(PSSysSFPub pSSysSFPub, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysSFPub, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysSFPub pSSysSFPub2 = pSSysSFPub.getPPSSysSFPub();
        if (pSSysSFPub2 != null && pSSysSFPub2.contains(string)) {
            return pSSysSFPub2.get(string);
        }
        PSSystem pSSystem = pSSysSFPub.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSFPub pSSysSFPub, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysSFPub, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BASECLSPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BaseClsParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BASECLSPKGCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BaseCLSPKGCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCPSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocPSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCPSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocPSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GLOBALTSFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GlobalTSFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PKGCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSSFPUBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysSFPubId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSSFPUBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysSFPubName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFCODESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFCodesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBPKGSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubPkgsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoveFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STYLEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StyleParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBSYSPKGFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubSysPkgFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VERSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerStr_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BaseClsParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BASECLSPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BaseCLSPKGCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BASECLSPKGCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_ContentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_DefaultPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DocPSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCPSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DocPSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCPSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAMODELMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GlobalTSFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PKGCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PKGCODENAME", iEntity, bl2, "[A-Za-z]+[\\w.]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysSFPubId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSSFPUBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysSFPubName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSSFPUBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysSFCodesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysSFPubId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubPkgsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBFOLDER", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("PUBFOLDER", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBTAG", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBTAG3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBTAG4", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemoveFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StyleParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STYLEPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubSysPkgFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_VerStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERSTR", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysSFPub pSSysSFPub) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFCODE_PSSYSSFPUB_PSSYSSFPUBID", (boolean)true) == 0) && this.onMergeChild_PSSysSFCodes(pSSysSFPub)) {
            bl = true;
        }
        log.error((Object)"\u5b50\u5173\u7cfb  DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID \u6ca1\u6709\u5b9a\u4e49\u5173\u7cfb\u4ee3\u7801\u540d\u79f0\uff0c\u65e0\u6cd5\u8f93\u51fa\u6267\u884c\u4ee3\u7801");
        if (super.onMergeChild(string, string2, (IEntity)pSSysSFPub)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSSysSFCodes(PSSysSFPub pSSysSFPub) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSSFCODESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysSFPub.getPSSysSFPubId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSSFPUBID", (Object)pSSysSFPub.getPSSysSFPubId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysSFPub, false);
        return true;
    }

    protected void onUpdateParent(PSSysSFPub pSSysSFPub) throws Exception {
        Object object = pSSysSFPub.get("PSSYSTEMID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSSFPUB_PSSYSTEM_PSSYSTEMID", object);
        }
        super.onUpdateParent((IEntity)pSSysSFPub);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysSFPub pSSysSFPub, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSFPUB");
        if (!bl) {
            pSSysSFPub.setCreateDate(null);
            pSSysSFPub.setCreateMan(null);
            pSSysSFPub.setPSSysSFCodesCnt(null);
            pSSysSFPub.setPSSysSFPubId(null);
            pSSysSFPub.setUpdateDate(null);
            pSSysSFPub.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSFPub, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSFPub pSSysSFPub, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSFPub, string);
        objectNode.remove("pssyssfcodescnt");
        objectNode.remove("pssyssfpubpkgscnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSFPUB_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysSFPub pSSysSFPub) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSFPub.getCodeName())) {
            return pSSysSFPub.getCodeName();
        }
        return super.getModelV2Tag(pSSysSFPub);
    }

    @Override
    public boolean setModelV2Tag(PSSysSFPub pSSysSFPub, String string) {
        pSSysSFPub.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSFPub pSSysSFPub, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSFPub.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSFPub, true);
        pSSysSFPub.set("CODENAME", string);
        if (this.select(pSSysSFPub, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSFPub, true);
        return super.getModelV2Entity(pSSysSFPub, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSFPub pSSysSFPub, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysSFPub, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSSFCODE_PSSYSSFPUB_PSSYSSFPUBID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysSFPub pSSysSFPub, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSSFCODE_PSSYSSFPUB_PSSYSSFPUBID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSFPUB#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSSFCODE", (Object)pSSysSFPub.getPSSysSFPubId()))).exists()) {
            pSCoreSysServiceBase = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysSFCode();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysSFCodeServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysSFCode)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSSFCODE", (Object)entityBase.getPSSysSFCodeId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSFPUB#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSSFPUBPKG", (Object)pSSysSFPub.getPSSysSFPubId()))).exists()) {
            pSCoreSysServiceBase = (PSSysSFPubPkgService)ServiceGlobal.getService(PSSysSFPubPkgService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysSFPubPkg();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysSFPubPkgServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysSFPubPkg)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSSFPUBPKG", (Object)entityBase.getPSSysSFPubPkgId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysSFPub, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysSFPub pSSysSFPub, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSSysSFCode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSSFCODE_PSSYSSFPUB_PSSYSSFPUBID")) {
            pSCoreSysServiceBase = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSFPUB#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSSFCODE", (Object)pSSysSFPub.getPSSysSFPubId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSSysSFCode)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysSFCode>();
                object3 = ((PSSysSFCodeServiceBase)pSCoreSysServiceBase).selectByPSSysSFPub(pSSysSFPub);
                arrayNode = StringHelper.format((String)"PSSYSSFPUB#%1$s", (Object)pSSysSFPub.getPSSysSFPubId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysSFCode)object2.next();
                    object = ((PSSysSFCodeServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysSFCode)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
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
                        if (objectNode.has("pssyssfcodename")) {
                            string = objectNode.get("pssyssfcodename").asText();
                        }
                        if (objectNode2.has("pssyssfcodename")) {
                            string2 = objectNode2.get("pssyssfcodename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysSFCode();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID")) {
            pSCoreSysServiceBase = (PSSysSFPubPkgService)ServiceGlobal.getService(PSSysSFPubPkgService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSFPUB#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSSFPUBPKG", (Object)pSSysSFPub.getPSSysSFPubId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysSFCode)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSSysSFPubPkgServiceBase)pSCoreSysServiceBase).selectByPSSysSFPub(pSSysSFPub);
                arrayNode = StringHelper.format((String)"PSSYSSFPUB#%1$s", (Object)pSSysSFPub.getPSSysSFPubId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysSFPubPkg)object2.next();
                    object = ((PSSysSFPubPkgServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysSFCode)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
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
                        if (objectNode.has("pssyssfpubpkgname")) {
                            string = objectNode.get("pssyssfpubpkgname").asText();
                        }
                        if (objectNode2.has("pssyssfpubpkgname")) {
                            string2 = objectNode2.get("pssyssfpubpkgname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysSFPubPkg();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysSFPub, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysSFPub pSSysSFPub) throws Exception {
        super.onEmptyModelV2(pSSysSFPub);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysSFPubPkgService)ServiceGlobal.getService(PSSysSFPubPkgService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysSFPub pSSysSFPub, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysSFCode();
        entityBase.set("PSSYSSFPUBID", pSSysSFPub.getPSSysSFPubId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysSFPubPkg();
        entityBase.set("PSSYSSFPUBID", pSSysSFPub.getPSSysSFPubId());
        pSCoreSysServiceBase = (PSSysSFPubPkgService)ServiceGlobal.getService(PSSysSFPubPkgService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysSFPub, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysSFPub pSSysSFPub, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSSysSFPubServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysSFCode();
                    ((PSSysSFCodeBase)object).setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
                    ((PSSysSFCodeBase)object).setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysSFCode();
                        entityBase.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
                        entityBase.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysSFPubServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysSFPubPkgService)ServiceGlobal.getService(PSSysSFPubPkgService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysSFPubPkg();
                    ((PSSysSFPubPkgBase)object).setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
                    ((PSSysSFPubPkgBase)object).setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysSFPubPkg();
                        entityBase.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
                        entityBase.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysSFPub, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysSFPub pSSysSFPub, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSSFCODE_PSSYSSFPUB_PSSYSSFPUBID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysSFCodes(pSSysSFPub, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysSFPub, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysSFCodes(PSSysSFPub pSSysSFPub, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSSFCODE", true), (boolean)false) == 0) {
            PSSysSFCodeService pSSysSFCodeService = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
            PSSysSFCode pSSysSFCode = new PSSysSFCode();
            pSSysSFCode.setPSSysSFCodeId(pSMOSFile.getPSModelId());
            if (!pSSysSFCodeService.get((IEntity)pSSysSFCode, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysSFCode.getPSSysSFPubId(), (String)pSSysSFPub.getPSSysSFPubId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysSFCodeService.exportModelV2(pSSysSFCode);
            pSSysSFCode.reset();
            if (!pSSysSFCodeService.setModelV2ResScope((IEntity)pSSysSFCode, "PSSYSSFPUB", pSSysSFPub.getPSSysSFPubId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysSFCodeService.importModelV2(pSSysSFCode, objectNode);
            SessionFactoryManager.commit();
            return pSSysSFCodeService.getFile((IEntity)pSSysSFCode);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysSFPub pSSysSFPub, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysSFCodes(pSSysSFPub, list);
        super.onFillPasteHelps(pSSysSFPub, list);
    }

    protected void onFillPasteHelps_PSSysSFCodes(PSSysSFPub pSSysSFPub, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSSFCODE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSSFCODE_PSSYSSFPUB_PSSYSSFPUBID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u540e\u53f0\u4f53\u7cfb]\u7684[\u540e\u53f0\u81ea\u5b9a\u4e49\u4ee3\u7801]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5b50\u4f53\u7cfb>", "DER1N_PSSYSSFPUB_PSSYSSFPUB_PPSSYSSFPUBID", "PPSSYSSFPUBID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysSFPubServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5b50\u4f53\u7cfb>");
            } else if (PSSysSFPubServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyssfpubs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSSFPUB_PSSYSSFPUB_PPSSYSSFPUBID|PPSSYSSFPUBID");
            pSMOSFile2.setFileTag3("PSSYSSFPUB");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSSFPUB_PSSYSSFPUB_PPSSYSSFPUBID", "PPSSYSSFPUBID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSFPUB_PSSYSSFPUB_PPSSYSSFPUBID", "PPSSYSSFPUBID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysSFPubServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (PSSysSFPubServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u7ec4\u4ef6\u5305>", "DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID", "PSSYSSFPUBID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysSFPubServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u7ec4\u4ef6\u5305>");
            } else if (PSSysSFPubServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyssfpubpkgs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID|PSSYSSFPUBID");
            pSMOSFile2.setFileTag3("PSSYSSFPUBPKG");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID", "PSSYSSFPUBID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysSFPubPkgService)ServiceGlobal.getService(PSSysSFPubPkgService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID", "PSSYSSFPUBID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysSFPubServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSSysSFPubServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5b50\u4f53\u7cfb>", (boolean)false) == 0 || PSSysSFPubServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysSFPubs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSFPUB_PSSYSSFPUB_PPSSYSSFPUBID", "PPSSYSSFPUBID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysSFPubServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u7ec4\u4ef6\u5305>", (boolean)false) == 0 || PSSysSFPubServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"pssyssfpubpkgs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysSFPubPkgService)ServiceGlobal.getService(PSSysSFPubPkgService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID", "PSSYSSFPUBID", pSMOSFile.getPSModelId(), "", "");
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSSFPUB_PSSYSSFPUB_PPSSYSSFPUBID", (boolean)false) == 0) {
            if (PSSysSFPubServiceBase.getMOSVer() == 1) {
                return "<\u5b50\u4f53\u7cfb>";
            }
            if (PSSysSFPubServiceBase.getMOSVer() == 2) {
                return "pssyssfpubs";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID", (boolean)false) == 0) {
            if (PSSysSFPubServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u7ec4\u4ef6\u5305>";
            }
            if (PSSysSFPubServiceBase.getMOSVer() == 2) {
                return "pssyssfpubpkgs";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}

