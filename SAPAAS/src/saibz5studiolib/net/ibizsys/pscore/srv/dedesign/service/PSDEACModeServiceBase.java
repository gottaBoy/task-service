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
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIChatAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIChatAgentBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactoryBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEACModeDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEACModeDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEACModeServiceBase
extends PSCoreSysServiceBase<PSDEACMode> {
    private static final Log log = LogFactory.getLog(PSDEACModeServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEACModeDEModel pSDEACModeDEModel;
    private PSDEACModeDAO pSDEACModeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService";
    }

    public PSDEACModeDEModel getPSDEACModeDEModel() {
        if (this.pSDEACModeDEModel == null) {
            try {
                this.pSDEACModeDEModel = (PSDEACModeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEACModeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEACModeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEACModeDEModel();
    }

    public PSDEACModeDAO getPSDEACModeDAO() {
        if (this.pSDEACModeDAO == null) {
            try {
                this.pSDEACModeDAO = (PSDEACModeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEACModeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEACModeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEACModeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
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

    protected void onFillParentInfo(PSDEACMode pSDEACMode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEACMode, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSDEACMode, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDEFIELD_MINORSORTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_MinorSortPSDEF(pSDEACMode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDEFIELD_TEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TextPSDEF(pSDEACMode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDEFIELD_VALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ValuePSDEF(pSDEACMode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDELOGIC_ADPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_ADPSDELogic(pSDEACMode, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDEOPPRIV_CREATEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEOPPriv);
            } else {
                iService.get((IEntity)pSDEOPPriv);
            }
            this.onFillParentInfo_CreatePSDEOPPriv(pSDEACMode, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDEOPPRIV_READPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEOPPriv);
            } else {
                iService.get((IEntity)pSDEOPPriv);
            }
            this.onFillParentInfo_ReadPSDEOPPriv(pSDEACMode, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDEACMode, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDEVIEWBASE_LINKPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_LinkPSDEView(pSDEACMode, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSDEVIEWBASE_PICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PickupPSDEView(pSDEACMode, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSLANGUAGERES_EMPTYTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_EmptyTextPSLanRes(pSDEACMode, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSSYSAICHATAGENT_PSSYSAICHATAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIChatAgentService", (SessionFactory)this.getSessionFactory());
            PSSysAIChatAgent pSSysAIChatAgent = (PSSysAIChatAgent)iService.getDEModel().createEntity();
            pSSysAIChatAgent.set("PSSYSAICHATAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysAIChatAgent);
            } else {
                iService.get((IEntity)pSSysAIChatAgent);
            }
            this.onFillParentInfo_PSSysAIChatAgent(pSDEACMode, pSSysAIChatAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSSYSAIFACTORY_PSSYSAIFACTORYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService", (SessionFactory)this.getSessionFactory());
            PSSysAIFactory pSSysAIFactory = (PSSysAIFactory)iService.getDEModel().createEntity();
            pSSysAIFactory.set("PSSYSAIFACTORYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysAIFactory);
            } else {
                iService.get((IEntity)pSSysAIFactory);
            }
            this.onFillParentInfo_PSSysAIFactory(pSDEACMode, pSSysAIFactory);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSSYSMSGTEMPL_HISTORYPSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysMsgTempl);
            } else {
                iService.get((IEntity)pSSysMsgTempl);
            }
            this.onFillParentInfo_HistoryPSSysMsgTempl(pSDEACMode, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSSYSPFPLUGIN_ACIPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_ACIPSSysPFPlugin(pSDEACMode, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEACMode, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSSYSUTILDE_AIFACTORYPSSYSUTILDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService", (SessionFactory)this.getSessionFactory());
            PSSysUtilDE pSSysUtilDE = (PSSysUtilDE)iService.getDEModel().createEntity();
            pSSysUtilDE.set("PSSYSUTILDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUtilDE);
            } else {
                iService.get((IEntity)pSSysUtilDE);
            }
            this.onFillParentInfo_AIFactoryPSSysUtilDE(pSDEACMode, pSSysUtilDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACMODE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanel);
            } else {
                iService.get((IEntity)pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSDEACMode, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEACMode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEACMode pSDEACMode, PSDataEntity pSDataEntity) throws Exception {
        pSDEACMode.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEACMode.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSDEACMode pSDEACMode, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEACMode.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEACMode.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_MinorSortPSDEF(PSDEACMode pSDEACMode, PSDEField pSDEField) throws Exception {
        pSDEACMode.setMinorSortPSDEFId(pSDEField.getPSDEFieldId());
        pSDEACMode.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TextPSDEF(PSDEACMode pSDEACMode, PSDEField pSDEField) throws Exception {
        pSDEACMode.setTextPSDEFId(pSDEField.getPSDEFieldId());
        pSDEACMode.setTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ValuePSDEF(PSDEACMode pSDEACMode, PSDEField pSDEField) throws Exception {
        pSDEACMode.setValuePSDEFId(pSDEField.getPSDEFieldId());
        pSDEACMode.setValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ADPSDELogic(PSDEACMode pSDEACMode, PSDELogic pSDELogic) throws Exception {
        pSDEACMode.setADPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEACMode.setADPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_CreatePSDEOPPriv(PSDEACMode pSDEACMode, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEACMode.setCreatePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEACMode.setCreatePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_ReadPSDEOPPriv(PSDEACMode pSDEACMode, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEACMode.setReadPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEACMode.setReadPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDEACMode pSDEACMode, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEACMode.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEACMode.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_LinkPSDEView(PSDEACMode pSDEACMode, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEACMode.setLinkPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEACMode.setLinkPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PickupPSDEView(PSDEACMode pSDEACMode, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEACMode.setPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEACMode.setPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_EmptyTextPSLanRes(PSDEACMode pSDEACMode, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEACMode.setEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEACMode.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysAIChatAgent(PSDEACMode pSDEACMode, PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        pSDEACMode.setPSSysAIChatAgentId(pSSysAIChatAgent.getPSSysAIChatAgentId());
        pSDEACMode.setPSSysAIChatAgentName(pSSysAIChatAgent.getPSSysAIChatAgentName());
    }

    protected void onFillParentInfo_PSSysAIFactory(PSDEACMode pSDEACMode, PSSysAIFactory pSSysAIFactory) throws Exception {
        pSDEACMode.setPSSysAIFactoryId(pSSysAIFactory.getPSSysAIFactoryId());
        pSDEACMode.setPSSysAIFactoryName(pSSysAIFactory.getPSSysAIFactoryName());
    }

    protected void onFillParentInfo_HistoryPSSysMsgTempl(PSDEACMode pSDEACMode, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSDEACMode.setHistoryPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSDEACMode.setHistoryPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_ACIPSSysPFPlugin(PSDEACMode pSDEACMode, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEACMode.setACIPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEACMode.setACIPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEACMode pSDEACMode, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEACMode.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEACMode.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_AIFactoryPSSysUtilDE(PSDEACMode pSDEACMode, PSSysUtilDE pSSysUtilDE) throws Exception {
        pSDEACMode.setAIFactoryPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
        pSDEACMode.setAIFactoryPSSysUtilDEName(pSSysUtilDE.getPSSysUtilDEName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSDEACMode pSDEACMode, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDEACMode.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDEACMode.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSDEACMode pSDEACMode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEACMode, bl);
        this.onFillEntityFullInfo_PSDE(pSDEACMode, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSDEACMode, bl);
        this.onFillEntityFullInfo_MinorSortPSDEF(pSDEACMode, bl);
        this.onFillEntityFullInfo_TextPSDEF(pSDEACMode, bl);
        this.onFillEntityFullInfo_ValuePSDEF(pSDEACMode, bl);
        this.onFillEntityFullInfo_ADPSDELogic(pSDEACMode, bl);
        this.onFillEntityFullInfo_CreatePSDEOPPriv(pSDEACMode, bl);
        this.onFillEntityFullInfo_ReadPSDEOPPriv(pSDEACMode, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDEACMode, bl);
        this.onFillEntityFullInfo_LinkPSDEView(pSDEACMode, bl);
        this.onFillEntityFullInfo_PickupPSDEView(pSDEACMode, bl);
        this.onFillEntityFullInfo_EmptyTextPSLanRes(pSDEACMode, bl);
        this.onFillEntityFullInfo_PSSysAIChatAgent(pSDEACMode, bl);
        this.onFillEntityFullInfo_PSSysAIFactory(pSDEACMode, bl);
        this.onFillEntityFullInfo_HistoryPSSysMsgTempl(pSDEACMode, bl);
        this.onFillEntityFullInfo_ACIPSSysPFPlugin(pSDEACMode, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEACMode, bl);
        this.onFillEntityFullInfo_AIFactoryPSSysUtilDE(pSDEACMode, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSDEACMode, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEACMode pSDEACMode, boolean bl) throws Exception {
        if (pSDEACMode.isPSDEIdDirty()) {
            if (pSDEACMode.getPSDEId() != null) {
                if (pSDEACMode.getPSDEId() == null || pSDEACMode.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEACMode.getPSDE();
                    pSDEACMode.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEACMode.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorSortPSDEF(PSDEACMode pSDEACMode, boolean bl) throws Exception {
        if (pSDEACMode.isMinorSortPSDEFIdDirty()) {
            if (pSDEACMode.getMinorSortPSDEFId() != null) {
                if (pSDEACMode.getMinorSortPSDEFId() == null || pSDEACMode.getMinorSortPSDEFName() == null) {
                    PSDEField pSDEField = pSDEACMode.getMinorSortPSDEF();
                    pSDEACMode.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEACMode.setMinorSortPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TextPSDEF(PSDEACMode pSDEACMode, boolean bl) throws Exception {
        if (pSDEACMode.isTextPSDEFIdDirty()) {
            if (pSDEACMode.getTextPSDEFId() != null) {
                if (pSDEACMode.getTextPSDEFId() == null || pSDEACMode.getTextPSDEFName() == null) {
                    PSDEField pSDEField = pSDEACMode.getTextPSDEF();
                    pSDEACMode.setTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEACMode.setTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ValuePSDEF(PSDEACMode pSDEACMode, boolean bl) throws Exception {
        if (pSDEACMode.isValuePSDEFIdDirty()) {
            if (pSDEACMode.getValuePSDEFId() != null) {
                if (pSDEACMode.getValuePSDEFId() == null || pSDEACMode.getValuePSDEFName() == null) {
                    PSDEField pSDEField = pSDEACMode.getValuePSDEF();
                    pSDEACMode.setValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEACMode.setValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ADPSDELogic(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CreatePSDEOPPriv(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ReadPSDEOPPriv(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LinkPSDEView(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PickupPSDEView(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmptyTextPSLanRes(PSDEACMode pSDEACMode, boolean bl) throws Exception {
        if (pSDEACMode.isEmptyTextPSLanResIdDirty()) {
            if (pSDEACMode.getEmptyTextPSLanResId() != null) {
                if (pSDEACMode.getEmptyTextPSLanResId() == null || pSDEACMode.getEmptyTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEACMode.getEmptyTextPSLanRes();
                    pSDEACMode.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEACMode.setEmptyTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysAIChatAgent(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysAIFactory(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_HistoryPSSysMsgTempl(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ACIPSSysPFPlugin(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AIFactoryPSSysUtilDE(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSDEACMode pSDEACMode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEACMode pSDEACMode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEACMode, bl);
    }

    public ArrayList<PSDEACMode> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEACMode> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORSORTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorSortPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorSortPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEACMode> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("VALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByADPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ADPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByADPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByADPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByCreatePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByCreatePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CREATEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCreatePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCreatePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByReadPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByReadPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByReadPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByReadPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByReadPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("READPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByReadPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByReadPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEACMode> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEACMode> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEACMode> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMPTYTEXTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmptyTextPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmptyTextPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByPSSysAIChatAgent(PSSysAIChatAgentBase pSSysAIChatAgentBase) throws Exception {
        return this.selectByPSSysAIChatAgent(pSSysAIChatAgentBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByPSSysAIChatAgent(PSSysAIChatAgentBase pSSysAIChatAgentBase, String string) throws Exception {
        return this.selectByPSSysAIChatAgent(pSSysAIChatAgentBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByPSSysAIChatAgent(PSSysAIChatAgentBase pSSysAIChatAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAICHATAGENTID", (Object)pSSysAIChatAgentBase.getPSSysAIChatAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAIChatAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAIChatAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAIFACTORYID", (Object)pSSysAIFactoryBase.getPSSysAIFactoryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAIFactoryCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAIFactoryCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByHistoryPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByHistoryPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByHistoryPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByHistoryPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByHistoryPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("HISTORYPSSYSMSGTEMPLID", (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByHistoryPSSysMsgTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByHistoryPSSysMsgTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByACIPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByACIPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByACIPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByACIPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByACIPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ACIPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByACIPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByACIPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByAIFactoryPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase) throws Exception {
        return this.selectByAIFactoryPSSysUtilDE(pSSysUtilDEBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByAIFactoryPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase, String string) throws Exception {
        return this.selectByAIFactoryPSSysUtilDE(pSSysUtilDEBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByAIFactoryPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AIFACTORYPSSYSUTILDEID", (Object)pSSysUtilDEBase.getPSSysUtilDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAIFactoryPSSysUtilDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAIFactoryPSSysUtilDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEACMode> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDEACMode> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDEACMode> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setPSDEId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEACModeServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEACModeServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setPSDEDataSetId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEACModeServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEACModeServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByMinorSortPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSDEFIELD_MINORSORTPSDEFID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setMinorSortPSDEFId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByMinorSortPSDEF(pSDEField2);
                PSDEACModeServiceBase.this.internalRemoveByMinorSortPSDEF(pSDEField2);
                PSDEACModeServiceBase.this.onAfterRemoveByMinorSortPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        this.onBeforeRemoveByMinorSortPSDEF(pSDEField, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByMinorSortPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSDEFIELD_TEXTPSDEFID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByTextPSDEF(pSDEField);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setTextPSDEFId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByTextPSDEF(pSDEField2);
                PSDEACModeServiceBase.this.internalRemoveByTextPSDEF(pSDEField2);
                PSDEACModeServiceBase.this.onAfterRemoveByTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByTextPSDEF(pSDEField);
        this.onBeforeRemoveByTextPSDEF(pSDEField, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSDEFIELD_VALUEPSDEFID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByValuePSDEF(pSDEField);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setValuePSDEFId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByValuePSDEF(pSDEField2);
                PSDEACModeServiceBase.this.internalRemoveByValuePSDEF(pSDEField2);
                PSDEACModeServiceBase.this.onAfterRemoveByValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByValuePSDEF(pSDEField);
        this.onBeforeRemoveByValuePSDEF(pSDEField, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByADPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSDELOGIC_ADPSDELOGICID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByADPSDELogic(pSDELogic);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setADPSDELogicId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByADPSDELogic(pSDELogic2);
                PSDEACModeServiceBase.this.internalRemoveByADPSDELogic(pSDELogic2);
                PSDEACModeServiceBase.this.onAfterRemoveByADPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByADPSDELogic(pSDELogic);
        this.onBeforeRemoveByADPSDELogic(pSDELogic, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByADPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSDEOPPRIV_CREATEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setCreatePSDEOPPrivId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
                PSDEACModeServiceBase.this.internalRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
                PSDEACModeServiceBase.this.onAfterRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByCreatePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByCreatePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByReadPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSDEOPPRIV_READPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByReadPSDEOPPriv(pSDEOPPriv);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setReadPSDEOPPrivId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByReadPSDEOPPriv(pSDEOPPriv2);
                PSDEACModeServiceBase.this.internalRemoveByReadPSDEOPPriv(pSDEOPPriv2);
                PSDEACModeServiceBase.this.onAfterRemoveByReadPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByReadPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByReadPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByReadPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setPSDEUAGroupId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEACModeServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEACModeServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByLinkPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSDEVIEWBASE_LINKPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setLinkPSDEViewId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByLinkPSDEView(pSDEViewBase2);
                PSDEACModeServiceBase.this.internalRemoveByLinkPSDEView(pSDEViewBase2);
                PSDEACModeServiceBase.this.onAfterRemoveByLinkPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        this.onBeforeRemoveByLinkPSDEView(pSDEViewBase, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByLinkPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSDEVIEWBASE_PICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPickupPSDEView(pSDEViewBase);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setPickupPSDEViewId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByPickupPSDEView(pSDEViewBase2);
                PSDEACModeServiceBase.this.internalRemoveByPickupPSDEView(pSDEViewBase2);
                PSDEACModeServiceBase.this.onAfterRemoveByPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByPickupPSDEView(pSDEViewBase, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSLANGUAGERES_EMPTYTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setEmptyTextPSLanResId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDEACModeServiceBase.this.internalRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDEACModeServiceBase.this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysAIChatAgent(pSSysAIChatAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAICHATAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysAIChatAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSSYSAICHATAGENT_PSSYSAICHATAGENTID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSSysAIChatAgent), arrayList.get(0)));
        }
    }

    public void resetPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysAIChatAgent(pSSysAIChatAgent);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setPSSysAIChatAgentId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        final PSSysAIChatAgent pSSysAIChatAgent2 = pSSysAIChatAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByPSSysAIChatAgent(pSSysAIChatAgent2);
                PSDEACModeServiceBase.this.internalRemoveByPSSysAIChatAgent(pSSysAIChatAgent2);
                PSDEACModeServiceBase.this.onAfterRemoveByPSSysAIChatAgent(pSSysAIChatAgent2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
    }

    protected void internalRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysAIChatAgent(pSSysAIChatAgent);
        this.onBeforeRemoveByPSSysAIChatAgent(pSSysAIChatAgent, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByPSSysAIChatAgent(pSSysAIChatAgent, arrayList);
    }

    protected void onAfterRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIFACTORY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysAIFactory);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSSYSAIFACTORY_PSSYSAIFACTORYID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSSysAIFactory), arrayList.get(0)));
        }
    }

    public void resetPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setPSSysAIFactoryId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        final PSSysAIFactory pSSysAIFactory2 = pSSysAIFactory;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSDEACModeServiceBase.this.internalRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSDEACModeServiceBase.this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void internalRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByHistoryPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByHistoryPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSSYSMSGTEMPL_HISTORYPSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetHistoryPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByHistoryPSSysMsgTempl(pSSysMsgTempl);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setHistoryPSSysMsgTemplId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByHistoryPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByHistoryPSSysMsgTempl(pSSysMsgTempl2);
                PSDEACModeServiceBase.this.internalRemoveByHistoryPSSysMsgTempl(pSSysMsgTempl2);
                PSDEACModeServiceBase.this.onAfterRemoveByHistoryPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByHistoryPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByHistoryPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByHistoryPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByHistoryPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByHistoryPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByHistoryPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByHistoryPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByHistoryPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByACIPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByACIPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSSYSPFPLUGIN_ACIPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetACIPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByACIPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setACIPSSysPFPluginId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByACIPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByACIPSSysPFPlugin(pSSysPFPlugin2);
                PSDEACModeServiceBase.this.internalRemoveByACIPSSysPFPlugin(pSSysPFPlugin2);
                PSDEACModeServiceBase.this.onAfterRemoveByACIPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByACIPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByACIPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByACIPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByACIPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByACIPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByACIPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByACIPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByACIPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setPSSysSFPluginId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEACModeServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEACModeServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByAIFactoryPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByAIFactoryPSSysUtilDE(pSSysUtilDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUTILDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUtilDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSSYSUTILDE_AIFACTORYPSSYSUTILDEID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSSysUtilDE), arrayList.get(0)));
        }
    }

    public void resetAIFactoryPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByAIFactoryPSSysUtilDE(pSSysUtilDE);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setAIFactoryPSSysUtilDEId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByAIFactoryPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        final PSSysUtilDE pSSysUtilDE2 = pSSysUtilDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByAIFactoryPSSysUtilDE(pSSysUtilDE2);
                PSDEACModeServiceBase.this.internalRemoveByAIFactoryPSSysUtilDE(pSSysUtilDE2);
                PSDEACModeServiceBase.this.onAfterRemoveByAIFactoryPSSysUtilDE(pSSysUtilDE2);
            }
        });
    }

    protected void onBeforeRemoveByAIFactoryPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
    }

    protected void internalRemoveByAIFactoryPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByAIFactoryPSSysUtilDE(pSSysUtilDE);
        this.onBeforeRemoveByAIFactoryPSSysUtilDE(pSSysUtilDE, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByAIFactoryPSSysUtilDE(pSSysUtilDE, arrayList);
    }

    protected void onAfterRemoveByAIFactoryPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
    }

    protected void onBeforeRemoveByAIFactoryPSSysUtilDE(PSSysUtilDE pSSysUtilDE, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAIFactoryPSSysUtilDE(PSSysUtilDE pSSysUtilDE, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACMODE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDEACMODE", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSDEACMode pSDEACMode : arrayList) {
            PSDEACMode pSDEACMode2 = (PSDEACMode)this.getDEModel().createEntity();
            pSDEACMode2.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
            pSDEACMode2.setPSSysViewPanelId(null);
            this.update(pSDEACMode2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEACModeServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEACModeServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEACModeServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEACMode> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDEACMode pSDEACMode : arrayList) {
            this.remove((IEntity)pSDEACMode);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEACMode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEACMode pSDEACMode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDEACMode(pSDEACMode);
        pSCoreSysServiceBase = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEACMode(pSDEACMode);
        ((PSDEACModeItemServiceBase)pSCoreSysServiceBase).removeByPSDEACMode(pSDEACMode);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEACMode(pSDEACMode);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEACMode(pSDEACMode);
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).removeByRefPSDEACMode(pSDEACMode);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEACMode(pSDEACMode);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEACMode(pSDEACMode);
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).removeByRefPSDEACMode(pSDEACMode);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByPSDEACMode(pSDEACMode);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEACMode(pSDEACMode);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEACMode(pSDEACMode);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEACMode(pSDEACMode);
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).removeByRefPSDEACMode(pSDEACMode);
        super.onBeforeRemove(pSDEACMode);
    }

    protected void onBeforeRemoveTemp(PSDEACMode pSDEACMode) throws Exception {
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        pSDEACModeItemService.removeTempByPSDEACMode(pSDEACMode);
        super.onBeforeRemoveTemp((IEntity)pSDEACMode);
    }

    protected void getRelatedDataTempMajor(PSDEACMode pSDEACMode) throws Exception {
        this.getRelatedDataTempMajor_PSDEACModeItem(pSDEACMode);
        super.getRelatedDataTempMajor((IEntity)pSDEACMode);
    }

    protected void getRelatedDataTempMajor_PSDEACModeItem(PSDEACMode pSDEACMode) throws Exception {
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEACModeItem> arrayList = null;
        String string = pSDEACMode.getPSDEACModeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEACModeItemService.selectByPSDEACMode(pSDEACMode) : pSDEACModeItemService.selectTempByPSDEACMode(pSDEACMode);
        for (PSDEACModeItem pSDEACModeItem : arrayList) {
            pSDEACModeItemService.getTempMajor(pSDEACModeItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEACMode pSDEACMode, PSDEACMode pSDEACMode2) throws Exception {
        ArrayList<PSDEACModeItem> arrayList = this.updateRelatedDataTempMajor_removePSDEACModeItem(pSDEACMode, pSDEACMode2);
        this.updateRelatedDataTempMajor_updatePSDEACModeItem(pSDEACMode, pSDEACMode2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEACMode, (IEntity)pSDEACMode2);
    }

    protected ArrayList<PSDEACModeItem> updateRelatedDataTempMajor_removePSDEACModeItem(PSDEACMode pSDEACMode, PSDEACMode pSDEACMode2) throws Exception {
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEACModeItem> arrayList = pSDEACModeItemService.selectTempByPSDEACMode(pSDEACMode);
        ArrayList<PSDEACModeItem> arrayList2 = pSDEACModeItemService.selectByPSDEACMode(pSDEACMode2);
        HashMap<String, PSDEACModeItem> hashMap = new HashMap<String, PSDEACModeItem>();
        for (PSDEACModeItem pSDEACModeItem : arrayList2) {
            hashMap.put(pSDEACModeItem.getPSDEACModeItemId(), pSDEACModeItem);
        }
        for (PSDEACModeItem pSDEACModeItem : arrayList) {
            Object object = pSDEACModeItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEACModeItem pSDEACModeItem : hashMap.values()) {
            pSDEACModeItemService.remove((IEntity)pSDEACModeItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEACModeItem(PSDEACMode pSDEACMode, PSDEACMode pSDEACMode2, ArrayList<PSDEACModeItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEACModeItem pSDEACModeItem : arrayList) {
            pSDEACModeItemService.updateTempMajor(pSDEACModeItem);
        }
    }

    protected void replaceParentInfo(PSDEACMode pSDEACMode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEACMode, cloneSession);
        if (pSDEACMode.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEACMode.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEACMode, (PSDataEntity)iEntity);
        }
        if (pSDEACMode.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEACMode.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSDEACMode, (PSDEDataSet)iEntity);
        }
        if (pSDEACMode.getMinorSortPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEACMode.getMinorSortPSDEFId())) != null) {
            this.onFillParentInfo_MinorSortPSDEF(pSDEACMode, (PSDEField)iEntity);
        }
        if (pSDEACMode.getTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEACMode.getTextPSDEFId())) != null) {
            this.onFillParentInfo_TextPSDEF(pSDEACMode, (PSDEField)iEntity);
        }
        if (pSDEACMode.getValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEACMode.getValuePSDEFId())) != null) {
            this.onFillParentInfo_ValuePSDEF(pSDEACMode, (PSDEField)iEntity);
        }
        if (pSDEACMode.getADPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEACMode.getADPSDELogicId())) != null) {
            this.onFillParentInfo_ADPSDELogic(pSDEACMode, (PSDELogic)iEntity);
        }
        if (pSDEACMode.getCreatePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEACMode.getCreatePSDEOPPrivId())) != null) {
            this.onFillParentInfo_CreatePSDEOPPriv(pSDEACMode, (PSDEOPPriv)iEntity);
        }
        if (pSDEACMode.getReadPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEACMode.getReadPSDEOPPrivId())) != null) {
            this.onFillParentInfo_ReadPSDEOPPriv(pSDEACMode, (PSDEOPPriv)iEntity);
        }
        if (pSDEACMode.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEACMode.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDEACMode, (PSDEUAGroup)iEntity);
        }
        if (pSDEACMode.getLinkPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEACMode.getLinkPSDEViewId())) != null) {
            this.onFillParentInfo_LinkPSDEView(pSDEACMode, (PSDEViewBase)iEntity);
        }
        if (pSDEACMode.getPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEACMode.getPickupPSDEViewId())) != null) {
            this.onFillParentInfo_PickupPSDEView(pSDEACMode, (PSDEViewBase)iEntity);
        }
        if (pSDEACMode.getEmptyTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEACMode.getEmptyTextPSLanResId())) != null) {
            this.onFillParentInfo_EmptyTextPSLanRes(pSDEACMode, (PSLanguageRes)iEntity);
        }
        if (pSDEACMode.getPSSysAIChatAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSAICHATAGENT", (Object)pSDEACMode.getPSSysAIChatAgentId())) != null) {
            this.onFillParentInfo_PSSysAIChatAgent(pSDEACMode, (PSSysAIChatAgent)iEntity);
        }
        if (pSDEACMode.getPSSysAIFactoryId() != null && (iEntity = cloneSession.getEntity("PSSYSAIFACTORY", (Object)pSDEACMode.getPSSysAIFactoryId())) != null) {
            this.onFillParentInfo_PSSysAIFactory(pSDEACMode, (PSSysAIFactory)iEntity);
        }
        if (pSDEACMode.getHistoryPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSDEACMode.getHistoryPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_HistoryPSSysMsgTempl(pSDEACMode, (PSSysMsgTempl)iEntity);
        }
        if (pSDEACMode.getACIPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEACMode.getACIPSSysPFPluginId())) != null) {
            this.onFillParentInfo_ACIPSSysPFPlugin(pSDEACMode, (PSSysPFPlugin)iEntity);
        }
        if (pSDEACMode.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEACMode.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEACMode, (PSSysSFPlugin)iEntity);
        }
        if (pSDEACMode.getAIFactoryPSSysUtilDEId() != null && (iEntity = cloneSession.getEntity("PSSYSUTILDE", (Object)pSDEACMode.getAIFactoryPSSysUtilDEId())) != null) {
            this.onFillParentInfo_AIFactoryPSSysUtilDE(pSDEACMode, (PSSysUtilDE)iEntity);
        }
        if (pSDEACMode.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDEACMode.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSDEACMode, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEACMode pSDEACMode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEACMode, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ACIPSSysPFPluginId(bl, pSDEACMode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ACParams(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ACTag(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ACTag2(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ACTag3(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ACTag4(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionHolder(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ACType(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ADPSDELogicId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIFactoryPSSysUtilDEId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEOPPrivId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultMode(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyText(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResName(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePagingBar(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendMode(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FillerObj(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HistoryPSSysMsgTemplId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEViewId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortDir(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFName(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PagingSize(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PickupPSDEViewId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEACModeId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEACModeName(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIChatAgentId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIFactoryId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadPSDEOPPrivId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFName(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFId(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFName(bl, pSDEACMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEACMode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ACIPSSysPFPluginId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isACIPSSysPFPluginIdDirty() : !pSDEACMode.isACIPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getACIPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ACIPSSysPFPluginId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACIPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ACParams(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isACParamsDirty() : !pSDEACMode.isACParamsDirty()) {
            return null;
        }
        String string = pSDEACMode.getACParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ACParams_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ACTag(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isACTagDirty() : !pSDEACMode.isACTagDirty()) {
            return null;
        }
        String string = pSDEACMode.getACTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ACTag_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ACTag2(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isACTag2Dirty() : !pSDEACMode.isACTag2Dirty()) {
            return null;
        }
        String string = pSDEACMode.getACTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ACTag2_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ACTag3(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isACTag3Dirty() : !pSDEACMode.isACTag3Dirty()) {
            return null;
        }
        String string = pSDEACMode.getACTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ACTag3_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ACTag4(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isACTag4Dirty() : !pSDEACMode.isACTag4Dirty()) {
            return null;
        }
        String string = pSDEACMode.getACTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ACTag4_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionHolder(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isActionHolderDirty() : !pSDEACMode.isActionHolderDirty()) {
            return null;
        }
        Integer n = pSDEACMode.getActionHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActionHolder_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ACType(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isACTypeDirty() : !pSDEACMode.isACTypeDirty()) {
            return null;
        }
        String string = pSDEACMode.getACType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ACType_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ADPSDELogicId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isADPSDELogicIdDirty() : !pSDEACMode.isADPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getADPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ADPSDELogicId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIFactoryPSSysUtilDEId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isAIFactoryPSSysUtilDEIdDirty() : !pSDEACMode.isAIFactoryPSSysUtilDEIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getAIFactoryPSSysUtilDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIFactoryPSSysUtilDEId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIFACTORYPSSYSUTILDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isCodeNameDirty() : !pSDEACMode.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEACMode.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEACMode, bl2, bl3);
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEACModeDEModel(), "CODENAME", string3, pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreatePSDEOPPrivId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isCreatePSDEOPPrivIdDirty() : !pSDEACMode.isCreatePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getCreatePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEOPPrivId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isCustomCodeDirty() : !pSDEACMode.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEACMode.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isCustomModeDirty() : !pSDEACMode.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEACMode.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultMode(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isDefaultModeDirty() && !bl2 : !pSDEACMode.isDefaultModeDirty()) {
            return null;
        }
        Integer n = pSDEACMode.getDefaultMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultMode_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSDEACModeDEModel(), "DEFAULTMODE", string, pSDEACMode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isDynaModelFlagDirty() : !pSDEACMode.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEACMode.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyText(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isEmptyTextDirty() : !pSDEACMode.isEmptyTextDirty()) {
            return null;
        }
        String string = pSDEACMode.getEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyText_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyTextPSLanResId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isEmptyTextPSLanResIdDirty() : !pSDEACMode.isEmptyTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getEmptyTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyTextPSLanResName(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isEmptyTextPSLanResNameDirty() : !pSDEACMode.isEmptyTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEACMode.getEmptyTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResName_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnablePagingBar(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isEnablePagingBarDirty() : !pSDEACMode.isEnablePagingBarDirty()) {
            return null;
        }
        Integer n = pSDEACMode.getEnablePagingBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnablePagingBar_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPAGINGBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtendMode(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isExtendModeDirty() : !pSDEACMode.isExtendModeDirty()) {
            return null;
        }
        Integer n = pSDEACMode.getExtendMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendMode_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FillerObj(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isFillerObjDirty() : !pSDEACMode.isFillerObjDirty()) {
            return null;
        }
        String string = pSDEACMode.getFillerObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FillerObj_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILLEROBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HistoryPSSysMsgTemplId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isHistoryPSSysMsgTemplIdDirty() : !pSDEACMode.isHistoryPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getHistoryPSSysMsgTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HistoryPSSysMsgTemplId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HISTORYPSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEViewId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isLinkPSDEViewIdDirty() : !pSDEACMode.isLinkPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getLinkPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEViewId_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isLockFlagDirty() : !pSDEACMode.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEACMode.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isLogicNameDirty() : !pSDEACMode.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEACMode.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isMemoDirty() : !pSDEACMode.isMemoDirty()) {
            return null;
        }
        String string = pSDEACMode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortDir(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isMinorSortDirDirty() : !pSDEACMode.isMinorSortDirDirty()) {
            return null;
        }
        String string = pSDEACMode.getMinorSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortDir_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorSortPSDEFId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isMinorSortPSDEFIdDirty() : !pSDEACMode.isMinorSortPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getMinorSortPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFId_MinorSortPSDEF((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_MinorSortPSDEFId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorSortPSDEFName(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isMinorSortPSDEFNameDirty() : !pSDEACMode.isMinorSortPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEACMode.getMinorSortPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFName_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PagingSize(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPagingSizeDirty() : !pSDEACMode.isPagingSizeDirty()) {
            return null;
        }
        Integer n = pSDEACMode.getPagingSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PagingSize_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGINGSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PickupPSDEViewId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPickupPSDEViewIdDirty() : !pSDEACMode.isPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PickupPSDEViewId_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEACModeId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSDEACModeIdDirty() && !bl2 : !pSDEACMode.isPSDEACModeIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSDEACModeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACMODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEACModeId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEACModeName(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSDEACModeNameDirty() && !bl2 : !pSDEACMode.isPSDEACModeNameDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSDEACModeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACMODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEACModeName_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACMODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEACModeDEModel(), "PSDEACMODENAME", string3, pSDEACMode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEACMODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSDEDataSetIdDirty() : !pSDEACMode.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSDEIdDirty() && !bl2 : !pSDEACMode.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSDENameDirty() && !bl2 : !pSDEACMode.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSDEUAGroupIdDirty() : !pSDEACMode.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSDynaInstIdDirty() : !pSDEACMode.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAIChatAgentId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSSysAIChatAgentIdDirty() : !pSDEACMode.isPSSysAIChatAgentIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSSysAIChatAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIChatAgentId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAICHATAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIFactoryId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSSysAIFactoryIdDirty() : !pSDEACMode.isPSSysAIFactoryIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSSysAIFactoryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIFactoryId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIFACTORYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSSysSFPluginIdDirty() : !pSDEACMode.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isPSSysViewPanelIdDirty() : !pSDEACMode.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_ReadPSDEOPPrivId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isReadPSDEOPPrivIdDirty() : !pSDEACMode.isReadPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getReadPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ReadPSDEOPPrivId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isTextPSDEFIdDirty() : !pSDEACMode.isTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFId_TextPSDEF((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_TextPSDEFId_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_TextPSDEFName(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isTextPSDEFNameDirty() : !pSDEACMode.isTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEACMode.getTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFName_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isUserCatDirty() : !pSDEACMode.isUserCatDirty()) {
            return null;
        }
        String string = pSDEACMode.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isUserTagDirty() : !pSDEACMode.isUserTagDirty()) {
            return null;
        }
        String string = pSDEACMode.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isUserTag2Dirty() : !pSDEACMode.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEACMode.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isUserTag3Dirty() : !pSDEACMode.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEACMode.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isUserTag4Dirty() : !pSDEACMode.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEACMode.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEACMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValuePSDEFId(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isValuePSDEFIdDirty() : !pSDEACMode.isValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEACMode.getValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFId_ValuePSDEF((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_ValuePSDEFId_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValuePSDEFName(boolean bl, PSDEACMode pSDEACMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEACMode.isValuePSDEFNameDirty() : !pSDEACMode.isValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEACMode.getValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFName_Default((IEntity)pSDEACMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEACMode pSDEACMode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEACMode, bl);
    }

    protected void onSyncIndexEntities(PSDEACMode pSDEACMode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEACMode, bl);
    }

    public Object getDataContextValue(PSDEACMode pSDEACMode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEACMode, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEACMode.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEACMode pSDEACMode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEACModeItem_PSDEACMode(pSDEACMode, arrayList, n);
        super.onExportRelatedModel((IEntity)pSDEACMode, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEACModeItem_PSDEACMode(PSDEACMode pSDEACMode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEACModeItem> arrayList2 = pSDEACModeItemService.selectByPSDEACMode(pSDEACMode);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"154f28d178438ee5c916c381f209bbfa");
            jSONObject.put("srfdename", (Object)"PSDEACMODEITEM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEACMODEITEM_PSDEACMODE_PSDEACMODEID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEACMode, (String)"PSDEACMODEID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEACModeItem pSDEACModeItem : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEACModeItem, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEACModeItemService.exportModel(pSDEACModeItem, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEACMode pSDEACMode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_EmptyTextPSLanRes(pSDEACMode, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEACMode, arrayList, n);
    }

    protected void onExportMajorModel_EmptyTextPSLanRes(PSDEACMode pSDEACMode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEACMode.getEmptyTextPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEACMode.getEmptyTextPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACIPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ACIPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACIPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ACIPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ACParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ACTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ACTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ACTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ACTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ACType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIFACTORYPSSYSUTILDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIFactoryPSSysUtilDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIFACTORYPSSYSUTILDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIFactoryPSSysUtilDEName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CREATEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPAGINGBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePagingBar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILLEROBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FillerObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HISTORYPSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HistoryPSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HISTORYPSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HistoryPSSysMsgTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MINORSORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"MINORSORTPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFId_MinorSortPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGINGSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PagingSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PICKUPPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PickupPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PICKUPPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PickupPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEACModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEACModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAICHATAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIChatAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAICHATAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIChatAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIFACTORYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIFactoryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIFACTORYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIFactoryName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadPSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadPSDEOPPrivName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"VALUEPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFId_ValuePSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFName_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ACIPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACIPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ACIPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACIPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ACParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ACTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ACTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ACTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ACTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ACType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ADPSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ADPSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIFactoryPSSysUtilDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIFACTORYPSSYSUTILDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIFactoryPSSysUtilDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIFACTORYPSSYSUTILDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_CreatePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatePSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_DefaultMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EmptyText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyTextPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyTextPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnablePagingBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtendMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FillerObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILLEROBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HistoryPSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HISTORYPSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HistoryPSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HISTORYPSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_MinorSortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTDIR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFId_MinorSortPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("MINORSORTPSDEFID", "PSDEFIELD", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u9ed8\u8ba4\u6392\u5e8f\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PagingSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDEACModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEACModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACMODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSDEACMODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysAIChatAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAICHATAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIChatAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAICHATAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIFactoryId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIFACTORYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIFactoryName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIFACTORYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ReadPSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("READPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReadPSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("READPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSDEFId_TextPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("TEXTPSDEFID", "PSDEFIELD", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
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

    protected String onTestValueRule_ValuePSDEFId_ValuePSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("VALUEPSDEFID", "PSDEFIELD", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u503c\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEACMode pSDEACMode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEACMode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEACMode pSDEACMode) throws Exception {
        Object object = pSDEACMode.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEACMODE_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEACMode);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEACMode pSDEACMode, Object object) throws Exception {
        PSDEACMode pSDEACMode2 = new PSDEACMode();
        pSDEACMode2.set("PSDEACMODEID", object);
        String string = DataObject.getStringValue((Object)pSDEACMode.get("PSDEACMODEID"));
        super.onCopyDetails((IEntity)pSDEACMode, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEACMode pSDEACMode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEACMODE");
        if (!bl) {
            pSDEACMode.setCreateDate(null);
            pSDEACMode.setCreateMan(null);
            pSDEACMode.setPSDEACModeId(null);
            pSDEACMode.setUpdateDate(null);
            pSDEACMode.setUpdateMan(null);
            super.exportCurXmlModel(pSDEACMode, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEACMode pSDEACMode, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEACModeItem(pSDEACMode, xmlNode);
        super.onExportRelatedXmlModel(pSDEACMode, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEACModeItem(PSDEACMode pSDEACMode, XmlNode xmlNode) throws Exception {
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEACModeItem> arrayList = null;
        String string = pSDEACMode.getPSDEACModeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEACModeItemService.selectByPSDEACMode(pSDEACMode, "ORDER BY ORDERVALUE ASC") : pSDEACModeItemService.selectTempByPSDEACMode(pSDEACMode, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEACMODEITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSDEACModeItem pSDEACModeItem : arrayList) {
                pSDEACModeItem.set("ORDERVALUE", null);
                pSDEACModeItemService.exportXmlModel(pSDEACModeItem, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEACMode pSDEACMode, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEACMODEITEMS");
        this.importRelatedXmlModel_PSDEACModeItem(pSDEACMode, xmlNode2);
        super.onImportRelatedXmlModel(pSDEACMode, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEACModeItem(PSDEACMode pSDEACMode, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEACMode.getPSDEACModeId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEACModeItemService.removeByPSDEACMode(pSDEACMode);
        } else {
            pSDEACModeItemService.removeTempByPSDEACMode(pSDEACMode);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEACModeItem pSDEACModeItem = new PSDEACModeItem();
                pSDEACModeItem.setOrderValue(n);
                n += 100;
                pSDEACModeItemService.fillParentInfo((IEntity)pSDEACModeItem, "DER1N", "DER1N_PSDEACMODEITEM_PSDEACMODE_PSDEACMODEID", pSDEACMode.getPSDEACModeId());
                pSDEACModeItemService.importXmlModel(pSDEACModeItem, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEACMode pSDEACMode, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEACMode, string);
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
            return "DER1N_PSDEACMODE_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEACMode pSDEACMode) {
        if (!StringHelper.isNullOrEmpty((String)pSDEACMode.getPSDEACModeName())) {
            return pSDEACMode.getPSDEACModeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEACMode.getCodeName())) {
            return pSDEACMode.getCodeName();
        }
        return super.getModelV2Tag(pSDEACMode);
    }

    @Override
    public boolean setModelV2Tag(PSDEACMode pSDEACMode, String string) {
        pSDEACMode.setPSDEACModeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEACMODENAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEACMODENAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEACMode pSDEACMode, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEACMode.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEACMode, true);
        pSDEACMode.set("PSDEACMODENAME", string);
        if (this.select(pSDEACMode, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEACMode, true);
        return super.getModelV2Entity(pSDEACMode, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEACMode pSDEACMode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEACMode, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEACMODEITEM_PSDEACMODE_PSDEACMODEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEACMode pSDEACMode, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEACMode, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEACMode pSDEACMode, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEACMODEITEM_PSDEACMODE_PSDEACMODEID")) {
            Object object;
            PSDEACModeItem pSDEACModeItem2;
            Object object2;
            Object object3;
            Object object4;
            PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEACModeItem> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEACMODE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEACMODEITEM", (Object)pSDEACMode.getPSDEACModeId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSDEACModeItem2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSDEACModeItem2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEACModeItem>();
                object4 = pSDEACModeItemService.selectByPSDEACMode(pSDEACMode);
                object3 = StringHelper.format((String)"PSDEACMODE#%1$s", (Object)pSDEACMode.getPSDEACModeId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSDEACModeItem2 = object2.next();
                    object = pSDEACModeItemService.getModelV2ResScope((IEntity)pSDEACModeItem2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEACModeItem)PSModelV2Helper.toJSONObject((IEntity)pSDEACModeItem2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSDEACModeItemService.getModelV2Name(false);
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
                        if (objectNode.has("psdeacmodeitemname")) {
                            string = objectNode.get("psdeacmodeitemname").asText();
                        }
                        if (objectNode2.has("psdeacmodeitemname")) {
                            string2 = objectNode2.get("psdeacmodeitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSDEACModeItem pSDEACModeItem2 : arrayList) {
                    object = new PSDEACModeItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSDEACModeItem2, false);
                    object3.add((JsonNode)pSDEACModeItemService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEACMode, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEACMode pSDEACMode) throws Exception {
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEACModeItem> arrayList = pSDEACModeItemService.selectByPSDEACMode(pSDEACMode);
        String string = StringHelper.format((String)"PSDEACMODE#%1$s", (Object)pSDEACMode.getPSDEACModeId());
        for (PSDEACModeItem pSDEACModeItem : arrayList) {
            String string2 = pSDEACModeItemService.getModelV2ResScope((IEntity)pSDEACModeItem);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEACModeItemService.emptyModelV2(pSDEACModeItem);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEACMode.getPSDEACModeId());
        pSDEACModeItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEACModeItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEACMODEITEM WHERE PSDEACMODEID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEACMode);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEACModeItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEACMode pSDEACMode, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEACModeItem pSDEACModeItem = new PSDEACModeItem();
        pSDEACModeItem.set("PSDEACMODEID", pSDEACMode.getPSDEACModeId());
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEACModeItemService.getModelV2Entity(pSDEACModeItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEACMode, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEACMode pSDEACMode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEACModeItemService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEACModeItem pSDEACModeItem = new PSDEACModeItem();
                pSDEACModeItem.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
                pSDEACModeItem.setPSDEACModeName(pSDEACMode.getPSDEACModeName());
                pSDEACModeItemService.compileModelV2(pSDEACModeItem, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEACModeItem pSDEACModeItem = new PSDEACModeItem();
                    pSDEACModeItem.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
                    pSDEACModeItem.setPSDEACModeName(pSDEACMode.getPSDEACModeName());
                    pSDEACModeItemService.compileModelV2(pSDEACModeItem, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEACMode, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEACMode pSDEACMode, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEACMODEITEM_PSDEACMODE_PSDEACMODEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEACModeItems(pSDEACMode, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEACMode, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEACModeItems(PSDEACMode pSDEACMode, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEACMODEITEM", true), (boolean)false) == 0) {
            PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
            PSDEACModeItem pSDEACModeItem = new PSDEACModeItem();
            pSDEACModeItem.setPSDEACModeItemId(pSMOSFile.getPSModelId());
            if (!pSDEACModeItemService.get((IEntity)pSDEACModeItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEACModeItem.getPSDEACModeId(), (String)pSDEACMode.getPSDEACModeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEACModeItemService.exportModelV2(pSDEACModeItem);
            pSDEACModeItem.reset();
            if (!pSDEACModeItemService.setModelV2ResScope((IEntity)pSDEACModeItem, "PSDEACMODE", pSDEACMode.getPSDEACModeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEACModeItemService.importModelV2(pSDEACModeItem, objectNode);
            SessionFactoryManager.commit();
            return pSDEACModeItemService.getFile((IEntity)pSDEACModeItem);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEACMode pSDEACMode, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEACModeItems(pSDEACMode, list);
        super.onFillPasteHelps(pSDEACMode, list);
    }

    protected void onFillPasteHelps_PSDEACModeItems(PSDEACMode pSDEACMode, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEACMODEITEM");
        pSHelpSection.setSectionParam2("DER1N_PSDEACMODEITEM_PSDEACMODE_PSDEACMODEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f]\u7684[\u5b9e\u4f53\u81ea\u586b\u6570\u636e\u9879]");
        list.add(pSHelpSection);
    }
}

