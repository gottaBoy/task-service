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
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOPBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFVRCondDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFVRCondDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFVRCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFVRCondBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRuleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFVRCondServiceBase
extends PSCoreSysServiceBase<PSDEFVRCond> {
    private static final Log log = LogFactory.getLog(PSDEFVRCondServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFVRCondDEModel pSDEFVRCondDEModel;
    private PSDEFVRCondDAO pSDEFVRCondDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService";
    }

    public PSDEFVRCondDEModel getPSDEFVRCondDEModel() {
        if (this.pSDEFVRCondDEModel == null) {
            try {
                this.pSDEFVRCondDEModel = (PSDEFVRCondDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFVRCondDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFVRCondDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFVRCondDEModel();
    }

    public PSDEFVRCondDAO getPSDEFVRCondDAO() {
        if (this.pSDEFVRCondDAO == null) {
            try {
                this.pSDEFVRCondDAO = (PSDEFVRCondDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFVRCondDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFVRCondDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFVRCondDAO();
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

    protected void onFillParentInfo(PSDEFVRCond pSDEFVRCond, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSDATAENTITY_MAJORPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_MajorPSDE(pSDEFVRCond, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSDBVALUEOP_PSDBVALUEOPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueOPService", (SessionFactory)this.getSessionFactory());
            PSDBValueOP pSDBValueOP = (PSDBValueOP)iService.getDEModel().createEntity();
            pSDBValueOP.set("PSDBVALUEOPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBValueOP);
            } else {
                iService.get((IEntity)pSDBValueOP);
            }
            this.onFillParentInfo_PSDBValueOP(pSDEFVRCond, pSDBValueOP);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataQuery);
            } else {
                iService.get((IEntity)pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDQ(pSDEFVRCond, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSDEDATASET_MAJORPSDEDSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_MajorPSDEDS(pSDEFVRCond, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSDEFIELD_EXTMAJORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ExtMajorPSDEF(pSDEFVRCond, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSDEFIELD_EXTMINORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ExtMinorPSDEF(pSDEFVRCond, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEFVRCond, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSDEFVALUERULE_PSDEFVRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iService.getDEModel().createEntity();
            pSDEFValueRule.set("PSDEFVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFValueRule);
            } else {
                iService.get((IEntity)pSDEFValueRule);
            }
            this.onFillParentInfo_PSDEFVR(pSDEFVRCond, pSDEFValueRule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSDEFVRCOND_PPSDEFVRCONDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService", (SessionFactory)this.getSessionFactory());
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)iService.getDEModel().createEntity();
            pSDEFVRCond2.set("PSDEFVRCONDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFVRCond2);
            } else {
                iService.get((IEntity)pSDEFVRCond2);
            }
            this.onFillParentInfo_PPSDEFVRCond(pSDEFVRCond, pSDEFVRCond2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSLANGUAGERES_RIPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_RIPSLanRes(pSDEFVRCond, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVRCOND_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysValueRule);
            } else {
                iService.get((IEntity)pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSDEFVRCond, pSSysValueRule);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEFVRCond, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_MajorPSDE(PSDEFVRCond pSDEFVRCond, PSDataEntity pSDataEntity) throws Exception {
        pSDEFVRCond.setMajorPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEFVRCond.setMajorPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDBValueOP(PSDEFVRCond pSDEFVRCond, PSDBValueOP pSDBValueOP) throws Exception {
        pSDEFVRCond.setPSDBValueOPId(pSDBValueOP.getPSDBValueOPId());
        pSDEFVRCond.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
    }

    protected void onFillParentInfo_PSDEDQ(PSDEFVRCond pSDEFVRCond, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEFVRCond.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEFVRCond.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_MajorPSDEDS(PSDEFVRCond pSDEFVRCond, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEFVRCond.setMajorPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDEFVRCond.setMajorPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_ExtMajorPSDEF(PSDEFVRCond pSDEFVRCond, PSDEField pSDEField) throws Exception {
        pSDEFVRCond.setExtMajorPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFVRCond.setExtMajorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ExtMinorPSDEF(PSDEFVRCond pSDEFVRCond, PSDEField pSDEField) throws Exception {
        pSDEFVRCond.setExtMinorPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFVRCond.setExtMinorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEF(PSDEFVRCond pSDEFVRCond, PSDEField pSDEField) throws Exception {
        pSDEFVRCond.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFVRCond.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEFVR(PSDEFVRCond pSDEFVRCond, PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDEFVRCond.setPSDEFVRId(pSDEFValueRule.getPSDEFValueRuleId());
        pSDEFVRCond.setPSDEFVRName(pSDEFValueRule.getPSDEFValueRuleName());
    }

    protected void onFillParentInfo_PPSDEFVRCond(PSDEFVRCond pSDEFVRCond, PSDEFVRCond pSDEFVRCond2) throws Exception {
        pSDEFVRCond.setPPSDEFVRCondId(pSDEFVRCond2.getPSDEFVRCondId());
        pSDEFVRCond.setPPSDEFVRCondName(pSDEFVRCond2.getPSDEFVRCondName());
        if (pSDEFVRCond2.getPSDEFVR() != null) {
            this.onFillParentInfo_PSDEFVR(pSDEFVRCond, pSDEFVRCond2.getPSDEFVR());
        }
    }

    protected void onFillParentInfo_RIPSLanRes(PSDEFVRCond pSDEFVRCond, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFVRCond.setRIPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFVRCond.setRIPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSDEFVRCond pSDEFVRCond, PSSysValueRule pSSysValueRule) throws Exception {
        pSDEFVRCond.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSDEFVRCond.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected void onFillEntityFullInfo(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        if (bl && pSDEFVRCond.getPSDEFVRCondName() == null) {
            pSDEFVRCond.setPSDEFVRCondName((String)this.getDefaultValue(this.getWebContext(), "", "\u6761\u4ef6", 25));
        }
        super.onFillEntityFullInfo((IEntity)pSDEFVRCond, bl);
        this.onFillEntityFullInfo_MajorPSDE(pSDEFVRCond, bl);
        this.onFillEntityFullInfo_PSDBValueOP(pSDEFVRCond, bl);
        this.onFillEntityFullInfo_PSDEDQ(pSDEFVRCond, bl);
        this.onFillEntityFullInfo_MajorPSDEDS(pSDEFVRCond, bl);
        this.onFillEntityFullInfo_ExtMajorPSDEF(pSDEFVRCond, bl);
        this.onFillEntityFullInfo_ExtMinorPSDEF(pSDEFVRCond, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEFVRCond, bl);
        this.onFillEntityFullInfo_PSDEFVR(pSDEFVRCond, bl);
        this.onFillEntityFullInfo_PPSDEFVRCond(pSDEFVRCond, bl);
        this.onFillEntityFullInfo_RIPSLanRes(pSDEFVRCond, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSDEFVRCond, bl);
    }

    protected void onFillEntityFullInfo_MajorPSDE(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        if (pSDEFVRCond.isMajorPSDEIdDirty()) {
            if (pSDEFVRCond.getMajorPSDEId() != null) {
                if (pSDEFVRCond.getMajorPSDEId() == null || pSDEFVRCond.getMajorPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEFVRCond.getMajorPSDE();
                    pSDEFVRCond.setMajorPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEFVRCond.setMajorPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDBValueOP(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDQ(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MajorPSDEDS(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ExtMajorPSDEF(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        if (pSDEFVRCond.isExtMajorPSDEFIdDirty()) {
            if (pSDEFVRCond.getExtMajorPSDEFId() != null) {
                if (pSDEFVRCond.getExtMajorPSDEFId() == null || pSDEFVRCond.getExtMajorPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFVRCond.getExtMajorPSDEF();
                    pSDEFVRCond.setExtMajorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEFVRCond.setExtMajorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ExtMinorPSDEF(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        if (pSDEFVRCond.isExtMinorPSDEFIdDirty()) {
            if (pSDEFVRCond.getExtMinorPSDEFId() != null) {
                if (pSDEFVRCond.getExtMinorPSDEFId() == null || pSDEFVRCond.getExtMinorPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFVRCond.getExtMinorPSDEF();
                    pSDEFVRCond.setExtMinorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEFVRCond.setExtMinorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        if (pSDEFVRCond.isPSDEFIdDirty()) {
            if (pSDEFVRCond.getPSDEFId() != null) {
                if (pSDEFVRCond.getPSDEFId() == null || pSDEFVRCond.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFVRCond.getPSDEF();
                    pSDEFVRCond.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEFVRCond.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEFVR(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSDEFVRCond(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RIPSLanRes(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        if (pSDEFVRCond.isRIPSLanResIdDirty()) {
            if (pSDEFVRCond.getRIPSLanResId() != null) {
                if (pSDEFVRCond.getRIPSLanResId() == null || pSDEFVRCond.getRIPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFVRCond.getRIPSLanRes();
                    pSDEFVRCond.setRIPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFVRCond.setRIPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEFVRCond, bl);
    }

    public ArrayList<PSDEFVRCond> selectByMajorPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByMajorPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByMajorPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByMajorPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByMajorPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBVALUEOPID", (Object)pSDBValueOPBase.getPSDBValueOPId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBValueOPCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBValueOPCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDQCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDQCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectByMajorPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByMajorPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByMajorPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByMajorPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByMajorPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEDSTID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectByExtMajorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByExtMajorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByExtMajorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByExtMajorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByExtMajorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EXTMAJORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByExtMajorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByExtMajorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectByExtMinorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByExtMinorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByExtMinorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByExtMinorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByExtMinorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EXTMINORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByExtMinorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByExtMinorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFVRCond> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVRID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFVRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFVRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectTempByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectTempByPSDEFVR(pSDEFValueRuleBase, "");
    }

    public ArrayList<PSDEFVRCond> selectTempByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVRID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFVRCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFVRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectByPPSDEFVRCond(PSDEFVRCondBase pSDEFVRCondBase) throws Exception {
        return this.selectByPPSDEFVRCond(pSDEFVRCondBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByPPSDEFVRCond(PSDEFVRCondBase pSDEFVRCondBase, String string) throws Exception {
        return this.selectByPPSDEFVRCond(pSDEFVRCondBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByPPSDEFVRCond(PSDEFVRCondBase pSDEFVRCondBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEFVRCONDID", (Object)pSDEFVRCondBase.getPSDEFVRCondId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDEFVRCondCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDEFVRCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectTempByPPSDEFVRCond(PSDEFVRCondBase pSDEFVRCondBase) throws Exception {
        return this.selectTempByPPSDEFVRCond(pSDEFVRCondBase, "");
    }

    public ArrayList<PSDEFVRCond> selectTempByPPSDEFVRCond(PSDEFVRCondBase pSDEFVRCondBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEFVRCONDID", (Object)pSDEFVRCondBase.getPSDEFVRCondId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSDEFVRCondCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSDEFVRCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectByRIPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByRIPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByRIPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByRIPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByRIPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RIPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRIPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRIPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFVRCond> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFVRCond> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFVRCond> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVALUERULEID", (Object)pSSysValueRuleBase.getPSSysValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByMajorPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVRCOND_PSDATAENTITY_MAJORPSDEID", "", iDataEntityModel.getName(), "PSDEFVRCOND", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByMajorPSDE(pSDataEntity);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setMajorPSDEId(null);
            this.update(pSDEFVRCond2);
        }
    }

    public void removeByMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByMajorPSDE(pSDataEntity2);
                PSDEFVRCondServiceBase.this.internalRemoveByMajorPSDE(pSDataEntity2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByMajorPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByMajorPSDE(pSDataEntity);
        this.onBeforeRemoveByMajorPSDE(pSDataEntity, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.remove((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveByMajorPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void testRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBVALUEOP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDBValueOP);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVRCOND_PSDBVALUEOP_PSDBVALUEOPID", "", iDataEntityModel.getName(), "PSDEFVRCOND", iDataEntityModel.getDataInfo((IEntity)pSDBValueOP), arrayList.get(0)));
        }
    }

    public void resetPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setPSDBValueOPId(null);
            this.update(pSDEFVRCond2);
        }
    }

    public void removeByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        final PSDBValueOP pSDBValueOP2 = pSDBValueOP;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByPSDBValueOP(pSDBValueOP2);
                PSDEFVRCondServiceBase.this.internalRemoveByPSDBValueOP(pSDBValueOP2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByPSDBValueOP(pSDBValueOP2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void internalRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        this.onBeforeRemoveByPSDBValueOP(pSDBValueOP, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.remove((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveByPSDBValueOP(pSDBValueOP, arrayList);
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDEDQ(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVRCOND_PSDEDATAQUERY_PSDEDQID", "", iDataEntityModel.getName(), "PSDEFVRCOND", iDataEntityModel.getDataInfo((IEntity)pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setPSDEDQId(null);
            this.update(pSDEFVRCond2);
        }
    }

    public void removeByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEFVRCondServiceBase.this.internalRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.remove((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void testRemoveByMajorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByMajorPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVRCOND_PSDEDATASET_MAJORPSDEDSTID", "", iDataEntityModel.getName(), "PSDEFVRCOND", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetMajorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByMajorPSDEDS(pSDEDataSet);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setMajorPSDEDSId(null);
            this.update(pSDEFVRCond2);
        }
    }

    public void removeByMajorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByMajorPSDEDS(pSDEDataSet2);
                PSDEFVRCondServiceBase.this.internalRemoveByMajorPSDEDS(pSDEDataSet2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByMajorPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByMajorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByMajorPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByMajorPSDEDS(pSDEDataSet, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.remove((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveByMajorPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByMajorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void testRemoveByExtMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByExtMajorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVRCOND_PSDEFIELD_EXTMAJORPSDEFID", "", iDataEntityModel.getName(), "PSDEFVRCOND", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetExtMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByExtMajorPSDEF(pSDEField);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setExtMajorPSDEFId(null);
            this.update(pSDEFVRCond2);
        }
    }

    public void removeByExtMajorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByExtMajorPSDEF(pSDEField2);
                PSDEFVRCondServiceBase.this.internalRemoveByExtMajorPSDEF(pSDEField2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByExtMajorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByExtMajorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByExtMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByExtMajorPSDEF(pSDEField);
        this.onBeforeRemoveByExtMajorPSDEF(pSDEField, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.remove((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveByExtMajorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByExtMajorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByExtMajorPSDEF(PSDEField pSDEField, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByExtMajorPSDEF(PSDEField pSDEField, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void testRemoveByExtMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByExtMinorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVRCOND_PSDEFIELD_EXTMINORPSDEFID", "", iDataEntityModel.getName(), "PSDEFVRCOND", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetExtMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByExtMinorPSDEF(pSDEField);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setExtMinorPSDEFId(null);
            this.update(pSDEFVRCond2);
        }
    }

    public void removeByExtMinorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByExtMinorPSDEF(pSDEField2);
                PSDEFVRCondServiceBase.this.internalRemoveByExtMinorPSDEF(pSDEField2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByExtMinorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByExtMinorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByExtMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByExtMinorPSDEF(pSDEField);
        this.onBeforeRemoveByExtMinorPSDEF(pSDEField, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.remove((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveByExtMinorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByExtMinorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByExtMinorPSDEF(PSDEField pSDEField, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByExtMinorPSDEF(PSDEField pSDEField, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVRCOND_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSDEFVRCOND", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setPSDEFId(null);
            this.update(pSDEFVRCond2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEFVRCondServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.remove((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    public void resetPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setPSDEFVRId(null);
            this.update(pSDEFVRCond2);
        }
    }

    public void resetTempPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectTempByPSDEFVR(pSDEFValueRule);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setPSDEFVRId(null);
            this.updateTemp((IEntity)pSDEFVRCond2);
        }
    }

    public void removeByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByPSDEFVR(pSDEFValueRule2);
                PSDEFVRCondServiceBase.this.internalRemoveByPSDEFVR(pSDEFValueRule2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByPSDEFVR(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        this.onBeforeRemoveByPSDEFVR(pSDEFValueRule, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.remove((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveByPSDEFVR(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void testRemoveByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
    }

    public void resetPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPPSDEFVRCond(pSDEFVRCond);
        for (PSDEFVRCond pSDEFVRCond2 : arrayList) {
            PSDEFVRCond pSDEFVRCond3 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond3.setPSDEFVRCondId(pSDEFVRCond2.getPSDEFVRCondId());
            pSDEFVRCond3.setPPSDEFVRCondId(null);
            this.update(pSDEFVRCond3);
        }
    }

    public void resetTempPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectTempByPPSDEFVRCond(pSDEFVRCond);
        for (PSDEFVRCond pSDEFVRCond2 : arrayList) {
            PSDEFVRCond pSDEFVRCond3 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond3.setPSDEFVRCondId(pSDEFVRCond2.getPSDEFVRCondId());
            pSDEFVRCond3.setPPSDEFVRCondId(null);
            this.updateTemp((IEntity)pSDEFVRCond3);
        }
    }

    public void removeByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
        final PSDEFVRCond pSDEFVRCond2 = pSDEFVRCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByPPSDEFVRCond(pSDEFVRCond2);
                PSDEFVRCondServiceBase.this.internalRemoveByPPSDEFVRCond(pSDEFVRCond2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByPPSDEFVRCond(pSDEFVRCond2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
    }

    protected void internalRemoveByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPPSDEFVRCond(pSDEFVRCond);
        this.onBeforeRemoveByPPSDEFVRCond(pSDEFVRCond, arrayList);
        for (PSDEFVRCond pSDEFVRCond2 : arrayList) {
            this.remove((IEntity)pSDEFVRCond2);
        }
        this.onAfterRemoveByPPSDEFVRCond(pSDEFVRCond, arrayList);
    }

    protected void onAfterRemoveByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
    }

    protected void onBeforeRemoveByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void testRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByRIPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVRCOND_PSLANGUAGERES_RIPSLANRESID", "", iDataEntityModel.getName(), "PSDEFVRCOND", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByRIPSLanRes(pSLanguageRes);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setRIPSLanResId(null);
            this.update(pSDEFVRCond2);
        }
    }

    public void removeByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByRIPSLanRes(pSLanguageRes2);
                PSDEFVRCondServiceBase.this.internalRemoveByRIPSLanRes(pSLanguageRes2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByRIPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByRIPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByRIPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.remove((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveByRIPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVRCOND_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSDEFVRCOND", iDataEntityModel.getDataInfo((IEntity)pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            PSDEFVRCond pSDEFVRCond2 = (PSDEFVRCond)this.getDEModel().createEntity();
            pSDEFVRCond2.setPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
            pSDEFVRCond2.setPSSysValueRuleId(null);
            this.update(pSDEFVRCond2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFVRCondServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFVRCondServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.remove((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFVRCond pSDEFVRCond) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        pSDEFVRCondService.testRemoveByPPSDEFVRCond(pSDEFVRCond);
        pSDEFVRCondService.resetPPSDEFVRCond(pSDEFVRCond);
        super.onBeforeRemove(pSDEFVRCond);
    }

    protected void onBeforeRemoveTemp(PSDEFVRCond pSDEFVRCond) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        pSDEFVRCondService.resetTempPPSDEFVRCond(pSDEFVRCond);
        super.onBeforeRemoveTemp((IEntity)pSDEFVRCond);
    }

    public void removeTempByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
        final PSDEFVRCond pSDEFVRCond2 = pSDEFVRCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveTempByPPSDEFVRCond(pSDEFVRCond2);
                PSDEFVRCondServiceBase.this.internalRemoveTempByPPSDEFVRCond(pSDEFVRCond2);
                PSDEFVRCondServiceBase.this.onAfterRemoveTempByPPSDEFVRCond(pSDEFVRCond2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
    }

    protected void internalRemoveTempByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectTempByPPSDEFVRCond(pSDEFVRCond);
        this.onBeforeRemoveTempByPPSDEFVRCond(pSDEFVRCond, arrayList);
        for (PSDEFVRCond pSDEFVRCond2 : arrayList) {
            this.removeTemp((IEntity)pSDEFVRCond2);
        }
        this.onAfterRemoveTempByPPSDEFVRCond(pSDEFVRCond, arrayList);
    }

    protected void onAfterRemoveTempByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSDEFVRCond(PSDEFVRCond pSDEFVRCond, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    public void removeTempByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondServiceBase.this.onBeforeRemoveTempByPSDEFVR(pSDEFValueRule2);
                PSDEFVRCondServiceBase.this.internalRemoveTempByPSDEFVR(pSDEFValueRule2);
                PSDEFVRCondServiceBase.this.onAfterRemoveTempByPSDEFVR(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveTempByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.selectTempByPSDEFVR(pSDEFValueRule);
        this.onBeforeRemoveTempByPSDEFVR(pSDEFValueRule, arrayList);
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            this.removeTemp((IEntity)pSDEFVRCond);
        }
        this.onAfterRemoveTempByPSDEFVR(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveTempByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEFVRCond> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEFVRCond pSDEFVRCond) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSDEFVRCond);
    }

    protected void updateRelatedDataTempMajor(PSDEFVRCond pSDEFVRCond, PSDEFVRCond pSDEFVRCond2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSDEFVRCond, (IEntity)pSDEFVRCond2);
    }

    protected void replaceParentInfo(PSDEFVRCond pSDEFVRCond, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEFVRCond, cloneSession);
        if (pSDEFVRCond.getMajorPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEFVRCond.getMajorPSDEId())) != null) {
            this.onFillParentInfo_MajorPSDE(pSDEFVRCond, (PSDataEntity)iEntity);
        }
        if (pSDEFVRCond.getPSDBValueOPId() != null && (iEntity = cloneSession.getEntity("PSDBVALUEOP", (Object)pSDEFVRCond.getPSDBValueOPId())) != null) {
            this.onFillParentInfo_PSDBValueOP(pSDEFVRCond, (PSDBValueOP)iEntity);
        }
        if (pSDEFVRCond.getPSDEDQId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEFVRCond.getPSDEDQId())) != null) {
            this.onFillParentInfo_PSDEDQ(pSDEFVRCond, (PSDEDataQuery)iEntity);
        }
        if (pSDEFVRCond.getMajorPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEFVRCond.getMajorPSDEDSId())) != null) {
            this.onFillParentInfo_MajorPSDEDS(pSDEFVRCond, (PSDEDataSet)iEntity);
        }
        if (pSDEFVRCond.getExtMajorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFVRCond.getExtMajorPSDEFId())) != null) {
            this.onFillParentInfo_ExtMajorPSDEF(pSDEFVRCond, (PSDEField)iEntity);
        }
        if (pSDEFVRCond.getExtMinorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFVRCond.getExtMinorPSDEFId())) != null) {
            this.onFillParentInfo_ExtMinorPSDEF(pSDEFVRCond, (PSDEField)iEntity);
        }
        if (pSDEFVRCond.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFVRCond.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDEFVRCond, (PSDEField)iEntity);
        }
        if (pSDEFVRCond.getPSDEFVRId() != null && (iEntity = cloneSession.getEntity("PSDEFVALUERULE", (Object)pSDEFVRCond.getPSDEFVRId())) != null) {
            this.onFillParentInfo_PSDEFVR(pSDEFVRCond, (PSDEFValueRule)iEntity);
        }
        if (pSDEFVRCond.getPPSDEFVRCondId() != null && (iEntity = cloneSession.getEntity("PSDEFVRCOND", (Object)pSDEFVRCond.getPPSDEFVRCondId())) != null) {
            this.onFillParentInfo_PPSDEFVRCond(pSDEFVRCond, (PSDEFVRCond)iEntity);
        }
        if (pSDEFVRCond.getRIPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFVRCond.getRIPSLanResId())) != null) {
            this.onFillParentInfo_RIPSLanRes(pSDEFVRCond, (PSLanguageRes)iEntity);
        }
        if (pSDEFVRCond.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSDEFVRCond.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSDEFVRCond, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEFVRCond, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondTag(bl, pSDEFVRCond, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondTag2(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondType(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondValue(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomDEFName(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtMajorPSDEFId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtMajorPSDEFName(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtMinorPSDEFId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtMinorPSDEFName(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupNotFlag(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupOP(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyCondFlag(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelTag(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelValue(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDEDSId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDEId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDEName(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param10(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param3(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param4(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param5(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param6(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param7(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param8(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param9(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDEFVRCondId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRCondId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRCondName(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RIPSLanResId(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RIPSLanResName(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuleInfo(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFVRCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEFVRCond, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondTag(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isCondTagDirty() : !pSDEFVRCond.isCondTagDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getCondTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondTag_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondTag2(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isCondTag2Dirty() : !pSDEFVRCond.isCondTag2Dirty()) {
            return null;
        }
        String string = pSDEFVRCond.getCondTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondTag2_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondType(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isCondTypeDirty() && !bl2 : !pSDEFVRCond.isCondTypeDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getCondType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondType_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondValue(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isCondValueDirty() : !pSDEFVRCond.isCondValueDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getCondValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondValue_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomDEFName(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isCustomDEFNameDirty() : !pSDEFVRCond.isCustomDEFNameDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getCustomDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomDEFName_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isDynaModelFlagDirty() : !pSDEFVRCond.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEFVRCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_ExtMajorPSDEFId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isExtMajorPSDEFIdDirty() : !pSDEFVRCond.isExtMajorPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getExtMajorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtMajorPSDEFId_ExtMajorPSDEF((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTMAJORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_ExtMajorPSDEFId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTMAJORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtMajorPSDEFName(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isExtMajorPSDEFNameDirty() : !pSDEFVRCond.isExtMajorPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getExtMajorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtMajorPSDEFName_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTMAJORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtMinorPSDEFId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isExtMinorPSDEFIdDirty() : !pSDEFVRCond.isExtMinorPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getExtMinorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtMinorPSDEFId_ExtMinorPSDEF((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTMINORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_ExtMinorPSDEFId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTMINORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtMinorPSDEFName(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isExtMinorPSDEFNameDirty() : !pSDEFVRCond.isExtMinorPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getExtMinorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtMinorPSDEFName_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTMINORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupNotFlag(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isGroupNotFlagDirty() : !pSDEFVRCond.isGroupNotFlagDirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getGroupNotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupNotFlag_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPNOTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupOP(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isGroupOPDirty() : !pSDEFVRCond.isGroupOPDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getGroupOP();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupOP_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPOP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyCondFlag(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isKeyCondFlagDirty() : !pSDEFVRCond.isKeyCondFlagDirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getKeyCondFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_KeyCondFlag_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYCONDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelTag(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isLevelTagDirty() : !pSDEFVRCond.isLevelTagDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getLevelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LevelTag_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelValue(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isLevelValueDirty() : !pSDEFVRCond.isLevelValueDirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getLevelValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LevelValue_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDEDSId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isMajorPSDEDSIdDirty() : !pSDEFVRCond.isMajorPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getMajorPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEDSId_MajorPSDEDS((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEDSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_MajorPSDEDSId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEDSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDEId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isMajorPSDEIdDirty() : !pSDEFVRCond.isMajorPSDEIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getMajorPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDEName(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isMajorPSDENameDirty() : !pSDEFVRCond.isMajorPSDENameDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getMajorPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEName_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isMemoDirty() : !pSDEFVRCond.isMemoDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEFVRCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isOrderValueDirty() : !pSDEFVRCond.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEFVRCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParamDirty() : !pSDEFVRCond.isParamDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param10(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParam10Dirty() : !pSDEFVRCond.isParam10Dirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param10_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param2(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParam2Dirty() : !pSDEFVRCond.isParam2Dirty()) {
            return null;
        }
        String string = pSDEFVRCond.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param3(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParam3Dirty() : !pSDEFVRCond.isParam3Dirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param3_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param4(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParam4Dirty() : !pSDEFVRCond.isParam4Dirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param4_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param5(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParam5Dirty() : !pSDEFVRCond.isParam5Dirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param5_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param6(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParam6Dirty() : !pSDEFVRCond.isParam6Dirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param6_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param7(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParam7Dirty() : !pSDEFVRCond.isParam7Dirty()) {
            return null;
        }
        Double d = pSDEFVRCond.getParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param7_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param8(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParam8Dirty() : !pSDEFVRCond.isParam8Dirty()) {
            return null;
        }
        Double d = pSDEFVRCond.getParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param8_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param9(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParam9Dirty() : !pSDEFVRCond.isParam9Dirty()) {
            return null;
        }
        Integer n = pSDEFVRCond.getParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param9_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isParamTypeDirty() : !pSDEFVRCond.isParamTypeDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getParamType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamType_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDEFVRCondId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isPPSDEFVRCondIdDirty() : !pSDEFVRCond.isPPSDEFVRCondIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getPPSDEFVRCondId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDEFVRCondId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEFVRCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBValueOPId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isPSDBValueOPIdDirty() : !pSDEFVRCond.isPSDBValueOPIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getPSDBValueOPId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVALUEOPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isPSDEDQIdDirty() : !pSDEFVRCond.isPSDEDQIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getPSDEDQId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isPSDEFIdDirty() : !pSDEFVRCond.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default((IEntity)pSDEFVRCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isPSDEFNameDirty() : !pSDEFVRCond.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default((IEntity)pSDEFVRCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFVRCondId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isPSDEFVRCondIdDirty() && !bl2 : !pSDEFVRCond.isPSDEFVRCondIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getPSDEFVRCondId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRCONDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRCondId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRCondName(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isPSDEFVRCondNameDirty() : !pSDEFVRCond.isPSDEFVRCondNameDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getPSDEFVRCondName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRCondName_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRCONDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isPSDEFVRIdDirty() && !bl2 : !pSDEFVRCond.isPSDEFVRIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getPSDEFVRId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isPSDynaInstIdDirty() : !pSDEFVRCond.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEFVRCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isPSSysValueRuleIdDirty() : !pSDEFVRCond.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RIPSLanResId(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isRIPSLanResIdDirty() : !pSDEFVRCond.isRIPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getRIPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RIPSLanResId_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RIPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RIPSLanResName(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isRIPSLanResNameDirty() : !pSDEFVRCond.isRIPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getRIPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RIPSLanResName_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RIPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RuleInfo(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isRuleInfoDirty() : !pSDEFVRCond.isRuleInfoDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getRuleInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RuleInfo_Default((IEntity)pSDEFVRCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULEINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isUserTagDirty() : !pSDEFVRCond.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFVRCond.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEFVRCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFVRCond pSDEFVRCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRCond.isUserTag2Dirty() : !pSDEFVRCond.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFVRCond.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEFVRCond, bl2, bl3);
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

    protected void onSyncEntity(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEFVRCond, bl);
    }

    protected void onSyncIndexEntities(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEFVRCond, bl);
    }

    public Object getDataContextValue(PSDEFVRCond pSDEFVRCond, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MAJORPSDEDSTID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MAJORPSDEDSTNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEFVRCond, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EXTMAJORPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EXTMAJORPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEFVRCond, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue((IEntity)pSDEFVRCond, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEFValueRule pSDEFValueRule = pSDEFVRCond.getPSDEFVR();
        if (pSDEFValueRule != null && pSDEFValueRule.contains(string)) {
            return pSDEFValueRule.get(string);
        }
        PSDEFVRCond pSDEFVRCond2 = pSDEFVRCond.getPPSDEFVRCond();
        if (pSDEFVRCond2 != null && pSDEFVRCond2.contains(string)) {
            return pSDEFVRCond2.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFVRCond pSDEFVRCond, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_RIPSLanRes(pSDEFVRCond, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEFVRCond, arrayList, n);
    }

    protected void onExportMajorModel_RIPSLanRes(PSDEFVRCond pSDEFVRCond, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEFVRCond.getRIPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEFVRCond.getRIPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONDTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTMAJORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"EXTMAJORPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_ExtMajorPSDEFId_ExtMajorPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTMAJORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtMajorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTMAJORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtMajorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTMINORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"EXTMINORPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_ExtMinorPSDEFId_ExtMinorPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTMINORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtMinorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTMINORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtMinorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPNOTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupNotFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupOP_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYCONDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyCondFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEDSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"MAJORPSDEDS", (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEDSId_MajorPSDEDS(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEDSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEDSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEFVRCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEFVRCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEFVRCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEFVRCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RIPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RIPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RULEINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuleInfo_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CondTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDVALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_CustomDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMDEFNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtMajorPSDEFId_ExtMajorPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("EXTMAJORPSDEFID", "PSDEFIELD", "CurSys", iEntity, bl2, "PSDEID", "MAJORPSDEID", "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u6570\u636e\u96c6\u5b9e\u4f53\u9644\u52a0\u7ea6\u675f\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExtMajorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTMAJORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExtMajorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTMAJORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExtMinorPSDEFId_ExtMinorPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("EXTMINORPSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5f53\u524d\u5b9e\u4f53\u9644\u52a0\u7ea6\u675f\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExtMinorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTMINORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExtMinorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTMINORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupNotFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupOP_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPOP", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KeyCondFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LevelTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEVELTAG", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LevelValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MajorPSDEDSId_MajorPSDEDS(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("MAJORPSDEDSTID", "PSDEDATASET", DATASET_DEFAULT, iEntity, bl2, "PSDEID", "MAJORPSDEID", "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u6570\u636e\u96c6\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEDSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEDSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_Param_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM2", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDEFVRCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEFVRCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDEFVRCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEFVRCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBValueOPId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVALUEOPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBValueOPName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVALUEOPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEFVRCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RIPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RIPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RuleInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RULEINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected boolean onMergeChild(String string, String string2, PSDEFVRCond pSDEFVRCond) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEFVRCond)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFVRCond pSDEFVRCond) throws Exception {
        super.onUpdateParent((IEntity)pSDEFVRCond);
    }

    @Override
    protected void exportCurXmlModel(PSDEFVRCond pSDEFVRCond, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFVRCOND");
        if (!bl) {
            pSDEFVRCond.setCreateDate(null);
            pSDEFVRCond.setCreateMan(null);
            pSDEFVRCond.setLevelTag(null);
            pSDEFVRCond.setLevelValue(null);
            pSDEFVRCond.setPSDEFVRCondId(null);
            pSDEFVRCond.setUpdateDate(null);
            pSDEFVRCond.setUpdateMan(null);
            pSDEFVRCond.setPPSDEFVRCondId(null);
            pSDEFVRCond.setPSDEFVRId(null);
            pSDEFVRCond.setPSDEFVRName(null);
            super.exportCurXmlModel(pSDEFVRCond, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEFVRCond pSDEFVRCond, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEFVRCond(pSDEFVRCond, xmlNode);
        super.onExportRelatedXmlModel(pSDEFVRCond, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEFVRCond(PSDEFVRCond pSDEFVRCond, XmlNode xmlNode) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFVRCond> arrayList = null;
        String string = pSDEFVRCond.getPSDEFVRCondId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFVRCondService.selectByPPSDEFVRCond(pSDEFVRCond, "ORDER BY ORDERVALUE ASC") : pSDEFVRCondService.selectTempByPPSDEFVRCond(pSDEFVRCond, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEFVRCONDS");
            xmlNode.addNode(xmlNode2);
            for (PSDEFVRCond pSDEFVRCond2 : arrayList) {
                pSDEFVRCond2.set("ORDERVALUE", null);
                pSDEFVRCondService.exportXmlModel(pSDEFVRCond2, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEFVRCond pSDEFVRCond, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEFVRCONDS");
        this.importRelatedXmlModel_PSDEFVRCond(pSDEFVRCond, xmlNode2);
        super.onImportRelatedXmlModel(pSDEFVRCond, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEFVRCond(PSDEFVRCond pSDEFVRCond, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEFVRCond.getPSDEFVRCondId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEFVRCondService.removeByPPSDEFVRCond(pSDEFVRCond);
        } else {
            pSDEFVRCondService.removeTempByPPSDEFVRCond(pSDEFVRCond);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFVRCond pSDEFVRCond2 = new PSDEFVRCond();
                pSDEFVRCond2.setOrderValue(n);
                n += 100;
                pSDEFVRCondService.fillParentInfo((IEntity)pSDEFVRCond2, "DER1N", "DER1N_PSDEFVRCOND_PSDEFVRCOND_PPSDEFVRCONDID", pSDEFVRCond.getPSDEFVRCondId());
                pSDEFVRCondService.importXmlModel(pSDEFVRCond2, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFVRCond pSDEFVRCond, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFVRCond, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFVRCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFVRCOND#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFVRID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFVALUERULE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFVRCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFVRCOND_PSDEFVRCOND_PPSDEFVRCONDID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFVRID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFVRCOND_PSDEFVALUERULE_PSDEFVRID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFVRCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFVRCONDNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFVRID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFVRNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFVRCOND", (boolean)true) == 0) {
            iEntity.set("PPSDEFVRCONDID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVALUERULE", (boolean)true) == 0) {
            iEntity.set("PSDEFVRID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSDEFVRCONDID", "PSDEFVRID"};
    }

    @Override
    public String getModelV2Tag(PSDEFVRCond pSDEFVRCond) {
        return super.getModelV2Tag(pSDEFVRCond);
    }

    @Override
    public boolean setModelV2Tag(PSDEFVRCond pSDEFVRCond, String string) {
        return super.setModelV2Tag(pSDEFVRCond, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PPSDEFVRCONDID", "");
        map.put("PSDEFVRID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFVRCond pSDEFVRCond, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFVRCond.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFVRCond, true);
        return super.getModelV2Entity(pSDEFVRCond, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFVRCond pSDEFVRCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDEFVRCond.getPPSDEFVRCondId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFVRCond.getPSDEFVRId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdefvrid")) {
            objectNode.put("psdefvrid", "<PSDEFVALUERULE>");
        }
        return super.testCompileCurModelV2(pSDEFVRCond, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDEFVRCond pSDEFVRCond, String string, Map<String, String> map) throws Exception {
        if (PSDEFVRCondServiceBase.isSimpleImportExportMode()) {
            map.put("PPSDEFVRCONDID", "");
            map.put("PSDEFVRID", "");
        }
        return super.onFillModelV2(objectNode, pSDEFVRCond, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEFVRCOND_PSDEFVRCOND_PPSDEFVRCONDID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEFVRCond pSDEFVRCond, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEFVRCond, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEFVRCond pSDEFVRCond, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFVRCOND_PSDEFVRCOND_PPSDEFVRCONDID")) {
            Object object;
            PSDEFVRCond pSDEFVRCond22;
            Object object2;
            Object object3;
            Object object4;
            PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEFVRCond> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFVRCOND#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFVRCOND", (Object)pSDEFVRCond.getPSDEFVRCondId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSDEFVRCond22 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSDEFVRCond22);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEFVRCond>();
                object4 = pSDEFVRCondService.selectByPPSDEFVRCond(pSDEFVRCond);
                object3 = StringHelper.format((String)"PSDEFVRCOND#%1$s", (Object)pSDEFVRCond.getPSDEFVRCondId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSDEFVRCond22 = object2.next();
                    object = pSDEFVRCondService.getModelV2ResScope((IEntity)pSDEFVRCond22);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEFVRCond)PSModelV2Helper.toJSONObject((IEntity)pSDEFVRCond22, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSDEFVRCondService.getModelV2Name(false);
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
                        if (objectNode.has("psdefvrcondname")) {
                            string = objectNode.get("psdefvrcondname").asText();
                        }
                        if (objectNode2.has("psdefvrcondname")) {
                            string2 = objectNode2.get("psdefvrcondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSDEFVRCond pSDEFVRCond22 : arrayList) {
                    object = new PSDEFVRCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSDEFVRCond22, false);
                    ((PSDEFVRCondBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSDEFVRCondService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEFVRCond, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEFVRCond pSDEFVRCond) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFVRCond> arrayList = pSDEFVRCondService.selectByPPSDEFVRCond(pSDEFVRCond);
        String string = StringHelper.format((String)"PSDEFVRCOND#%1$s", (Object)pSDEFVRCond.getPSDEFVRCondId());
        for (PSDEFVRCond pSDEFVRCond2 : arrayList) {
            String string2 = pSDEFVRCondService.getModelV2ResScope((IEntity)pSDEFVRCond2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEFVRCondService.emptyModelV2(pSDEFVRCond2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEFVRCond.getPSDEFVRCondId());
        pSDEFVRCondService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEFVRCondService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFVRCOND WHERE PPSDEFVRCONDID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEFVRCond);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEFVRCondService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEFVRCond pSDEFVRCond, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEFVRCond pSDEFVRCond2 = new PSDEFVRCond();
        pSDEFVRCond2.set("PPSDEFVRCONDID", pSDEFVRCond.getPSDEFVRCondId());
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEFVRCondService.getModelV2Entity(pSDEFVRCond2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEFVRCond, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEFVRCond pSDEFVRCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEFVRCondService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEFVRCond pSDEFVRCond2 = new PSDEFVRCond();
                pSDEFVRCond2.setPPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
                pSDEFVRCond2.setPPSDEFVRCondName(pSDEFVRCond.getPSDEFVRCondName());
                pSDEFVRCond2.setOrderValue(n2 += 10);
                pSDEFVRCondService.compileModelV2(pSDEFVRCond2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEFVRCond pSDEFVRCond3 = new PSDEFVRCond();
                    pSDEFVRCond3.setPPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
                    pSDEFVRCond3.setPPSDEFVRCondName(pSDEFVRCond.getPSDEFVRCondName());
                    pSDEFVRCondService.compileModelV2(pSDEFVRCond3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEFVRCond, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEFVRCond pSDEFVRCond, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFVRCOND_PSDEFVRCOND_PPSDEFVRCONDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFVRConds(pSDEFVRCond, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEFVRCond, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEFVRConds(PSDEFVRCond pSDEFVRCond, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFVRCOND", true), (boolean)false) == 0) {
            PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
            PSDEFVRCond pSDEFVRCond2 = new PSDEFVRCond();
            pSDEFVRCond2.setPSDEFVRCondId(pSMOSFile.getPSModelId());
            if (!pSDEFVRCondService.get((IEntity)pSDEFVRCond2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFVRCond2.getPPSDEFVRCondId(), (String)pSDEFVRCond.getPSDEFVRCondId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFVRCondService.exportModelV2(pSDEFVRCond2);
            pSDEFVRCond2.reset();
            if (!pSDEFVRCondService.setModelV2ResScope((IEntity)pSDEFVRCond2, "PSDEFVRCOND", pSDEFVRCond.getPSDEFVRCondId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFVRCondService.importModelV2(pSDEFVRCond2, objectNode);
            SessionFactoryManager.commit();
            return pSDEFVRCondService.getFile((IEntity)pSDEFVRCond2);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEFVRCond pSDEFVRCond, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEFVRConds(pSDEFVRCond, list);
        super.onFillPasteHelps(pSDEFVRCond, list);
    }

    protected void onFillPasteHelps_PSDEFVRConds(PSDEFVRCond pSDEFVRCond, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFVRCOND");
        pSHelpSection.setSectionParam2("DER1N_PSDEFVRCOND_PSDEFVRCOND_PPSDEFVRCONDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5c5e\u6027\u503c\u89c4\u5219\u9879]\u7684[\u5c5e\u6027\u503c\u89c4\u5219\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSDEFVRCond pSDEFVRCond) throws Exception {
        return pSDEFVRCond.getCondType();
    }
}

