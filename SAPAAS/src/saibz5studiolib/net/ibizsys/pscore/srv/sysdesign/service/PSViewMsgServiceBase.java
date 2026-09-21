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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSViewMsgDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSViewMsgDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGrpDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGrpDetailServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewMsgServiceBase
extends PSCoreSysServiceBase<PSViewMsg> {
    private static final Log log = LogFactory.getLog(PSViewMsgServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSViewMsgDEModel pSViewMsgDEModel;
    private PSViewMsgDAO pSViewMsgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService";
    }

    public PSViewMsgDEModel getPSViewMsgDEModel() {
        if (this.pSViewMsgDEModel == null) {
            try {
                this.pSViewMsgDEModel = (PSViewMsgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSViewMsgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewMsgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSViewMsgDEModel();
    }

    public PSViewMsgDAO getPSViewMsgDAO() {
        if (this.pSViewMsgDAO == null) {
            try {
                this.pSViewMsgDAO = (PSViewMsgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSViewMsgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewMsgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSViewMsgDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSViewMsg pSViewMsg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSViewMsg, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSViewMsg, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_CACHETAG2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_CacheTag2PSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_CACHETAGPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_CacheTagPSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_CLSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ClsPSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_CONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ContentPSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_CONTENTTYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ContentTypePDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_GROUPPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_GroupPSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_ICONPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_IconPSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_MSGPOSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_MsgPosPSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_MSGTYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_MsgTypePSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_ORDERVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_OrderValuePSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_REMOVEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_RemovePSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_TITLELANRESTAGPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TltleLanResTagPSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEFIELD_TITLEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TitlePSDEF(pSViewMsg, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSViewMsg, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDELOGIC_TESTPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_TestPSDELogic(pSViewMsg, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSDEOPPRIV_PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEOPPriv);
            } else {
                iService.get((IEntity)pSDEOPPriv);
            }
            this.onFillParentInfo_PSDEOPPriv(pSViewMsg, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSLANGUAGERES_CONTENTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_ContentPSLanRes(pSViewMsg, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSLANGUAGERES_TITLEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TitlePSLanRes(pSViewMsg, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSViewMsg, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSViewMsg, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSViewMsg, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSViewMsg, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysMsgTempl);
            } else {
                iService.get((IEntity)pSSysMsgTempl);
            }
            this.onFillParentInfo_PSSysMsgTempl(pSViewMsg, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSViewMsg, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSViewMsg, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSG_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanel);
            } else {
                iService.get((IEntity)pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSViewMsg, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo((IEntity)pSViewMsg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSViewMsg pSViewMsg, PSDataEntity pSDataEntity) throws Exception {
        pSViewMsg.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSViewMsg.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDS(PSViewMsg pSViewMsg, PSDEDataSet pSDEDataSet) throws Exception {
        pSViewMsg.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSViewMsg.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_CacheTag2PSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setCacheTag2PSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setCacheTag2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_CacheTagPSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setCacheTagPSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setCacheTagPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ClsPSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setClsPSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setClsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ContentPSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setContentPSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ContentTypePDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setContentTypePSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setContentTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_GroupPSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setGroupPSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setGroupPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IconPSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setIconPSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setIconPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MsgPosPSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setMsgPosPSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setMsgPosPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MsgTypePSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setMsgTypePSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setMsgTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_OrderValuePSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setOrderValuePSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_RemovePSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setRemovePSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setRemovePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TltleLanResTagPSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setTitleLanResTagPSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setTitleLanResTagPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TitlePSDEF(PSViewMsg pSViewMsg, PSDEField pSDEField) throws Exception {
        pSViewMsg.setTitlePSDEFId(pSDEField.getPSDEFieldId());
        pSViewMsg.setTitlePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDELogic(PSViewMsg pSViewMsg, PSDELogic pSDELogic) throws Exception {
        pSViewMsg.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSViewMsg.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_TestPSDELogic(PSViewMsg pSViewMsg, PSDELogic pSDELogic) throws Exception {
        pSViewMsg.setTestPSDELogicId(pSDELogic.getPSDELogicId());
        pSViewMsg.setTestPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEOPPriv(PSViewMsg pSViewMsg, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSViewMsg.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSViewMsg.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_ContentPSLanRes(PSViewMsg pSViewMsg, PSLanguageRes pSLanguageRes) throws Exception {
        pSViewMsg.setContentPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSViewMsg.setContentPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TitlePSLanRes(PSViewMsg pSViewMsg, PSLanguageRes pSLanguageRes) throws Exception {
        pSViewMsg.setTitlePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSViewMsg.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSModule(PSViewMsg pSViewMsg, PSModule pSModule) throws Exception {
        pSViewMsg.setPSModuleId(pSModule.getPSModuleId());
        pSViewMsg.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysCss(PSViewMsg pSViewMsg, PSSysCss pSSysCss) throws Exception {
        pSViewMsg.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSViewMsg.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSViewMsg pSViewMsg, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSViewMsg.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSViewMsg.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysImage(PSViewMsg pSViewMsg, PSSysImage pSSysImage) throws Exception {
        pSViewMsg.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSViewMsg.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysMsgTempl(PSViewMsg pSViewMsg, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSViewMsg.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSViewMsg.setPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSViewMsg pSViewMsg, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSViewMsg.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSViewMsg.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSViewMsg pSViewMsg, PSSystem pSSystem) throws Exception {
        pSViewMsg.setPSSystemId(pSSystem.getPSSystemId());
        pSViewMsg.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSViewMsg pSViewMsg, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSViewMsg.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSViewMsg.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (bl) {
            if (pSViewMsg.getCodeName() == null) {
                pSViewMsg.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "ViewMsg", 25));
            }
            if (pSViewMsg.getPSViewMsgName() == null) {
                pSViewMsg.setPSViewMsgName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u89c6\u56fe\u6d88\u606f", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSViewMsg, bl);
        this.onFillEntityFullInfo_PSDE(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSDEDS(pSViewMsg, bl);
        this.onFillEntityFullInfo_CacheTag2PSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_CacheTagPSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_ClsPSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_ContentPSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_ContentTypePDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_GroupPSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_IconPSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_MsgPosPSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_MsgTypePSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_OrderValuePSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_RemovePSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_TltleLanResTagPSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_TitlePSDEF(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSDELogic(pSViewMsg, bl);
        this.onFillEntityFullInfo_TestPSDELogic(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSDEOPPriv(pSViewMsg, bl);
        this.onFillEntityFullInfo_ContentPSLanRes(pSViewMsg, bl);
        this.onFillEntityFullInfo_TitlePSLanRes(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSModule(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSSysCss(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSSysImage(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSSysMsgTempl(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSSystem(pSViewMsg, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSViewMsg, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isPSDEIdDirty()) {
            if (pSViewMsg.getPSDEId() != null) {
                if (pSViewMsg.getPSDEId() == null || pSViewMsg.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSViewMsg.getPSDE();
                    pSViewMsg.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSViewMsg.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDS(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CacheTag2PSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isCacheTag2PSDEFIdDirty()) {
            if (pSViewMsg.getCacheTag2PSDEFId() != null) {
                if (pSViewMsg.getCacheTag2PSDEFId() == null || pSViewMsg.getCacheTag2PSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getCacheTag2PSDEF();
                    pSViewMsg.setCacheTag2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setCacheTag2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CacheTagPSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isCacheTagPSDEFIdDirty()) {
            if (pSViewMsg.getCacheTagPSDEFId() != null) {
                if (pSViewMsg.getCacheTagPSDEFId() == null || pSViewMsg.getCacheTagPSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getCacheTagPSDEF();
                    pSViewMsg.setCacheTagPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setCacheTagPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ClsPSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isClsPSDEFIdDirty()) {
            if (pSViewMsg.getClsPSDEFId() != null) {
                if (pSViewMsg.getClsPSDEFId() == null || pSViewMsg.getClsPSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getClsPSDEF();
                    pSViewMsg.setClsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setClsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ContentPSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isContentPSDEFIdDirty()) {
            if (pSViewMsg.getContentPSDEFId() != null) {
                if (pSViewMsg.getContentPSDEFId() == null || pSViewMsg.getContentPSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getContentPSDEF();
                    pSViewMsg.setContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ContentTypePDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isContentTypePSDEFIdDirty()) {
            if (pSViewMsg.getContentTypePSDEFId() != null) {
                if (pSViewMsg.getContentTypePSDEFId() == null || pSViewMsg.getContentTypePSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getContentTypePDEF();
                    pSViewMsg.setContentTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setContentTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupPSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isGroupPSDEFIdDirty()) {
            if (pSViewMsg.getGroupPSDEFId() != null) {
                if (pSViewMsg.getGroupPSDEFId() == null || pSViewMsg.getGroupPSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getGroupPSDEF();
                    pSViewMsg.setGroupPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setGroupPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IconPSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isIconPSDEFIdDirty()) {
            if (pSViewMsg.getIconPSDEFId() != null) {
                if (pSViewMsg.getIconPSDEFId() == null || pSViewMsg.getIconPSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getIconPSDEF();
                    pSViewMsg.setIconPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setIconPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MsgPosPSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isMsgPosPSDEFIdDirty()) {
            if (pSViewMsg.getMsgPosPSDEFId() != null) {
                if (pSViewMsg.getMsgPosPSDEFId() == null || pSViewMsg.getMsgPosPSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getMsgPosPSDEF();
                    pSViewMsg.setMsgPosPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setMsgPosPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MsgTypePSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isMsgTypePSDEFIdDirty()) {
            if (pSViewMsg.getMsgTypePSDEFId() != null) {
                if (pSViewMsg.getMsgTypePSDEFId() == null || pSViewMsg.getMsgTypePSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getMsgTypePSDEF();
                    pSViewMsg.setMsgTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setMsgTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OrderValuePSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isOrderValuePSDEFIdDirty()) {
            if (pSViewMsg.getOrderValuePSDEFId() != null) {
                if (pSViewMsg.getOrderValuePSDEFId() == null || pSViewMsg.getOrderValuePSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getOrderValuePSDEF();
                    pSViewMsg.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setOrderValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RemovePSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isRemovePSDEFIdDirty()) {
            if (pSViewMsg.getRemovePSDEFId() != null) {
                if (pSViewMsg.getRemovePSDEFId() == null || pSViewMsg.getRemovePSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getRemovePSDEF();
                    pSViewMsg.setRemovePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setRemovePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TltleLanResTagPSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isTitleLanResTagPSDEFIdDirty()) {
            if (pSViewMsg.getTitleLanResTagPSDEFId() != null) {
                if (pSViewMsg.getTitleLanResTagPSDEFId() == null || pSViewMsg.getTitleLanResTagPSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getTltleLanResTagPSDEF();
                    pSViewMsg.setTitleLanResTagPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setTitleLanResTagPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TitlePSDEF(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isTitlePSDEFIdDirty()) {
            if (pSViewMsg.getTitlePSDEFId() != null) {
                if (pSViewMsg.getTitlePSDEFId() == null || pSViewMsg.getTitlePSDEFName() == null) {
                    PSDEField pSDEField = pSViewMsg.getTitlePSDEF();
                    pSViewMsg.setTitlePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSViewMsg.setTitlePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TestPSDELogic(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEOPPriv(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ContentPSLanRes(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isContentPSLanResIdDirty()) {
            if (pSViewMsg.getContentPSLanResId() != null) {
                if (pSViewMsg.getContentPSLanResId() == null || pSViewMsg.getContentPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSViewMsg.getContentPSLanRes();
                    pSViewMsg.setContentPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSViewMsg.setContentPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TitlePSLanRes(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isTitlePSLanResIdDirty()) {
            if (pSViewMsg.getTitlePSLanResId() != null) {
                if (pSViewMsg.getTitlePSLanResId() == null || pSViewMsg.getTitlePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSViewMsg.getTitlePSLanRes();
                    pSViewMsg.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSViewMsg.setTitlePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysMsgTempl(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        if (pSViewMsg.isPSSystemIdDirty()) {
            if (pSViewMsg.getPSSystemId() != null) {
                if (pSViewMsg.getPSSystemId() == null || pSViewMsg.getPSSystemName() == null) {
                    PSSystem pSSystem = pSViewMsg.getPSSystem();
                    pSViewMsg.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSViewMsg.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSViewMsg pSViewMsg, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSViewMsg, bl);
    }

    public ArrayList<PSViewMsg> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsg> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsg> selectByCacheTag2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByCacheTag2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByCacheTag2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByCacheTag2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByCacheTag2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CACHETAG2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCacheTag2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCacheTag2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByCacheTagPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByCacheTagPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByCacheTagPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByCacheTagPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByCacheTagPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CACHETAGPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCacheTagPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCacheTagPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByClsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByClsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsg> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CONTENTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByContentPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByContentPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByContentTypePDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByContentTypePDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByContentTypePDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByContentTypePDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByContentTypePDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CONTENTTYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByContentTypePDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByContentTypePDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIconPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIconPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsg> selectByMsgPosPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMsgPosPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByMsgPosPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMsgPosPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByMsgPosPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MSGPOSPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMsgPosPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMsgPosPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByMsgTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMsgTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByMsgTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMsgTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByMsgTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MSGTYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMsgTypePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMsgTypePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ORDERVALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOrderValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOrderValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByRemovePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByRemovePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByRemovePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByRemovePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByRemovePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMOVEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemovePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemovePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByTltleLanResTagPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTltleLanResTagPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByTltleLanResTagPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTltleLanResTagPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByTltleLanResTagPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLELANRESTAGPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTltleLanResTagPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTltleLanResTagPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByTitlePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTitlePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByTitlePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTitlePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByTitlePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTitlePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTitlePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsg> selectByTestPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByTestPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByTestPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByTestPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByTestPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TESTPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTestPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTestPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByContentPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByContentPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByContentPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByContentPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByContentPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CONTENTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByContentPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByContentPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTitlePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTitlePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsg> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsg> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsg> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMSGTEMPLID", (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMsgTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMsgTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsg> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsg> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsg> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSViewMsg> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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
        ArrayList<PSViewMsg> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSDEId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSViewMsgServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSDEDSId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSViewMsgServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByCacheTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByCacheTag2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_CACHETAG2PSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetCacheTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByCacheTag2PSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setCacheTag2PSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByCacheTag2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByCacheTag2PSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByCacheTag2PSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByCacheTag2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByCacheTag2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByCacheTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByCacheTag2PSDEF(pSDEField);
        this.onBeforeRemoveByCacheTag2PSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByCacheTag2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByCacheTag2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByCacheTag2PSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCacheTag2PSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByCacheTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByCacheTagPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_CACHETAGPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetCacheTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByCacheTagPSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setCacheTagPSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByCacheTagPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByCacheTagPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByCacheTagPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByCacheTagPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByCacheTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByCacheTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByCacheTagPSDEF(pSDEField);
        this.onBeforeRemoveByCacheTagPSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByCacheTagPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByCacheTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByCacheTagPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCacheTagPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByClsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_CLSPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByClsPSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setClsPSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByClsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByClsPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByClsPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByClsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByClsPSDEF(pSDEField);
        this.onBeforeRemoveByClsPSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByClsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByClsPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByClsPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_CONTENTPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByContentPSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setContentPSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByContentPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByContentPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByContentPSDEF(pSDEField);
        this.onBeforeRemoveByContentPSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByContentTypePDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByContentTypePDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_CONTENTTYPEPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetContentTypePDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByContentTypePDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setContentTypePSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByContentTypePDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByContentTypePDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByContentTypePDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByContentTypePDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByContentTypePDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByContentTypePDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByContentTypePDEF(pSDEField);
        this.onBeforeRemoveByContentTypePDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByContentTypePDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByContentTypePDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByContentTypePDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentTypePDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByGroupPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_GROUPPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByGroupPSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setGroupPSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByGroupPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByGroupPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByGroupPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByGroupPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByGroupPSDEF(pSDEField);
        this.onBeforeRemoveByGroupPSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByGroupPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByIconPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_ICONPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByIconPSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setIconPSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByIconPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByIconPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByIconPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByIconPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByIconPSDEF(pSDEField);
        this.onBeforeRemoveByIconPSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByIconPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIconPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIconPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByMsgPosPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByMsgPosPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_MSGPOSPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMsgPosPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByMsgPosPSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setMsgPosPSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByMsgPosPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByMsgPosPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByMsgPosPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByMsgPosPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMsgPosPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMsgPosPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByMsgPosPSDEF(pSDEField);
        this.onBeforeRemoveByMsgPosPSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByMsgPosPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMsgPosPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMsgPosPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMsgPosPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByMsgTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByMsgTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_MSGTYPEPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMsgTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByMsgTypePSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setMsgTypePSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByMsgTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByMsgTypePSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByMsgTypePSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByMsgTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMsgTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMsgTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByMsgTypePSDEF(pSDEField);
        this.onBeforeRemoveByMsgTypePSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByMsgTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMsgTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMsgTypePSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMsgTypePSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByOrderValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_ORDERVALUEPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setOrderValuePSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByOrderValuePSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByOrderValuePSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByOrderValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        this.onBeforeRemoveByOrderValuePSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByOrderValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByRemovePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_REMOVEPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByRemovePSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setRemovePSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByRemovePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByRemovePSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByRemovePSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByRemovePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByRemovePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByRemovePSDEF(pSDEField);
        this.onBeforeRemoveByRemovePSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByRemovePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByTltleLanResTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTltleLanResTagPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_TITLELANRESTAGPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTltleLanResTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTltleLanResTagPSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setTitleLanResTagPSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByTltleLanResTagPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByTltleLanResTagPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByTltleLanResTagPSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByTltleLanResTagPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTltleLanResTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTltleLanResTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTltleLanResTagPSDEF(pSDEField);
        this.onBeforeRemoveByTltleLanResTagPSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByTltleLanResTagPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTltleLanResTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTltleLanResTagPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTltleLanResTagPSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByTitlePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTitlePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEFIELD_TITLEPSDEFID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTitlePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTitlePSDEF(pSDEField);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setTitlePSDEFId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByTitlePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByTitlePSDEF(pSDEField2);
                PSViewMsgServiceBase.this.internalRemoveByTitlePSDEF(pSDEField2);
                PSViewMsgServiceBase.this.onAfterRemoveByTitlePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTitlePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTitlePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTitlePSDEF(pSDEField);
        this.onBeforeRemoveByTitlePSDEF(pSDEField, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByTitlePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTitlePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTitlePSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTitlePSDEF(PSDEField pSDEField, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSDELogicId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSViewMsgServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTestPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDELOGIC_TESTPSDELOGICID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTestPSDELogic(pSDELogic);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setTestPSDELogicId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByTestPSDELogic(pSDELogic2);
                PSViewMsgServiceBase.this.internalRemoveByTestPSDELogic(pSDELogic2);
                PSViewMsgServiceBase.this.onAfterRemoveByTestPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTestPSDELogic(pSDELogic);
        this.onBeforeRemoveByTestPSDELogic(pSDELogic, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByTestPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByTestPSDELogic(PSDELogic pSDELogic, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTestPSDELogic(PSDELogic pSDELogic, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSDEOPPRIV_PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSDEOPPrivId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSViewMsgServiceBase.this.internalRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByContentPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSLANGUAGERES_CONTENTPSLANRESID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByContentPSLanRes(pSLanguageRes);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setContentPSLanResId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByContentPSLanRes(pSLanguageRes2);
                PSViewMsgServiceBase.this.internalRemoveByContentPSLanRes(pSLanguageRes2);
                PSViewMsgServiceBase.this.onAfterRemoveByContentPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByContentPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByContentPSLanRes(pSLanguageRes, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByContentPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTitlePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSLANGUAGERES_TITLEPSLANRESID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setTitlePSLanResId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes2);
                PSViewMsgServiceBase.this.internalRemoveByTitlePSLanRes(pSLanguageRes2);
                PSViewMsgServiceBase.this.onAfterRemoveByTitlePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSModule(pSModule);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSModuleId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSViewMsgServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSSysCssId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSViewMsgServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSSysDynaModelId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSViewMsgServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSSysImageId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSViewMsgServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSSysMsgTemplId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSViewMsgServiceBase.this.internalRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSSysSFPluginId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSViewMsgServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSystem(pSSystem);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSSystemId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSViewMsgServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSG_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSVIEWMSG", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSViewMsg pSViewMsg : arrayList) {
            PSViewMsg pSViewMsg2 = (PSViewMsg)this.getDEModel().createEntity();
            pSViewMsg2.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            pSViewMsg2.setPSSysViewPanelId(null);
            this.update(pSViewMsg2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSViewMsgServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSViewMsgServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSViewMsg> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSViewMsg pSViewMsg : arrayList) {
            this.remove((IEntity)pSViewMsg);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSViewMsg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSViewMsg pSViewMsg) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsg(pSViewMsg);
        pSCoreSysServiceBase = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsg(pSViewMsg);
        super.onBeforeRemove(pSViewMsg);
    }

    protected void replaceParentInfo(PSViewMsg pSViewMsg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSViewMsg, cloneSession);
        if (pSViewMsg.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSViewMsg.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSViewMsg, (PSDataEntity)iEntity);
        }
        if (pSViewMsg.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSViewMsg.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSViewMsg, (PSDEDataSet)iEntity);
        }
        if (pSViewMsg.getCacheTag2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getCacheTag2PSDEFId())) != null) {
            this.onFillParentInfo_CacheTag2PSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getCacheTagPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getCacheTagPSDEFId())) != null) {
            this.onFillParentInfo_CacheTagPSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getClsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getClsPSDEFId())) != null) {
            this.onFillParentInfo_ClsPSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getContentPSDEFId())) != null) {
            this.onFillParentInfo_ContentPSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getContentTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getContentTypePSDEFId())) != null) {
            this.onFillParentInfo_ContentTypePDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getGroupPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getGroupPSDEFId())) != null) {
            this.onFillParentInfo_GroupPSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getIconPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getIconPSDEFId())) != null) {
            this.onFillParentInfo_IconPSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getMsgPosPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getMsgPosPSDEFId())) != null) {
            this.onFillParentInfo_MsgPosPSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getMsgTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getMsgTypePSDEFId())) != null) {
            this.onFillParentInfo_MsgTypePSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getOrderValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getOrderValuePSDEFId())) != null) {
            this.onFillParentInfo_OrderValuePSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getRemovePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getRemovePSDEFId())) != null) {
            this.onFillParentInfo_RemovePSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getTitleLanResTagPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getTitleLanResTagPSDEFId())) != null) {
            this.onFillParentInfo_TltleLanResTagPSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getTitlePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSViewMsg.getTitlePSDEFId())) != null) {
            this.onFillParentInfo_TitlePSDEF(pSViewMsg, (PSDEField)iEntity);
        }
        if (pSViewMsg.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSViewMsg.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSViewMsg, (PSDELogic)iEntity);
        }
        if (pSViewMsg.getTestPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSViewMsg.getTestPSDELogicId())) != null) {
            this.onFillParentInfo_TestPSDELogic(pSViewMsg, (PSDELogic)iEntity);
        }
        if (pSViewMsg.getPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSViewMsg.getPSDEOPPrivId())) != null) {
            this.onFillParentInfo_PSDEOPPriv(pSViewMsg, (PSDEOPPriv)iEntity);
        }
        if (pSViewMsg.getContentPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSViewMsg.getContentPSLanResId())) != null) {
            this.onFillParentInfo_ContentPSLanRes(pSViewMsg, (PSLanguageRes)iEntity);
        }
        if (pSViewMsg.getTitlePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSViewMsg.getTitlePSLanResId())) != null) {
            this.onFillParentInfo_TitlePSLanRes(pSViewMsg, (PSLanguageRes)iEntity);
        }
        if (pSViewMsg.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSViewMsg.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSViewMsg, (PSModule)iEntity);
        }
        if (pSViewMsg.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSViewMsg.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSViewMsg, (PSSysCss)iEntity);
        }
        if (pSViewMsg.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSViewMsg.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSViewMsg, (PSSysDynaModel)iEntity);
        }
        if (pSViewMsg.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSViewMsg.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSViewMsg, (PSSysImage)iEntity);
        }
        if (pSViewMsg.getPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSViewMsg.getPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_PSSysMsgTempl(pSViewMsg, (PSSysMsgTempl)iEntity);
        }
        if (pSViewMsg.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSViewMsg.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSViewMsg, (PSSysSFPlugin)iEntity);
        }
        if (pSViewMsg.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSViewMsg.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSViewMsg, (PSSystem)iEntity);
        }
        if (pSViewMsg.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSViewMsg.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSViewMsg, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSViewMsg, bl);
    }

    protected void onCheckEntity(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CacheScope(bl, pSViewMsg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTag2PSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTag2PSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTagPSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTagPSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTimeout(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSLanResId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSLanResName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentTypePSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentTypePSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSLink(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynamicMode(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCache(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableMode(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableRemove(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgGroup(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgPos(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgPosPSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgPosPSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgType(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTypePSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTypePSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestCustomCode(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestPSDELogicId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timeout(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitleLanResTagPSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitleLanResTagPSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSDEFId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSDEFName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResId(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResName(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewMsgParams(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VewMsgTag(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VewMsgTag2(bl, pSViewMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSViewMsg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CacheScope(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isCacheScopeDirty() : !pSViewMsg.isCacheScopeDirty()) {
            return null;
        }
        String string = pSViewMsg.getCacheScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheScope_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHESCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTag2PSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isCacheTag2PSDEFIdDirty() : !pSViewMsg.isCacheTag2PSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getCacheTag2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheTag2PSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETAG2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTag2PSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isCacheTag2PSDEFNameDirty() : !pSViewMsg.isCacheTag2PSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getCacheTag2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheTag2PSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETAG2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTagPSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isCacheTagPSDEFIdDirty() : !pSViewMsg.isCacheTagPSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getCacheTagPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheTagPSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETAGPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTagPSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isCacheTagPSDEFNameDirty() : !pSViewMsg.isCacheTagPSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getCacheTagPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheTagPSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETAGPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTimeout(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isCacheTimeoutDirty() : !pSViewMsg.isCacheTimeoutDirty()) {
            return null;
        }
        Integer n = pSViewMsg.getCacheTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CacheTimeout_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClsPSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isClsPSDEFIdDirty() : !pSViewMsg.isClsPSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getClsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_ClsPSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isClsPSDEFNameDirty() : !pSViewMsg.isClsPSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getClsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isCodeNameDirty() : !pSViewMsg.isCodeNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSViewMsg, bl2, bl3);
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSViewMsgDEModel(), "CODENAME", string3, pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_Content(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isContentDirty() : !pSViewMsg.isContentDirty()) {
            return null;
        }
        String string = pSViewMsg.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isContentPSDEFIdDirty() : !pSViewMsg.isContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isContentPSDEFNameDirty() : !pSViewMsg.isContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSLanResId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isContentPSLanResIdDirty() : !pSViewMsg.isContentPSLanResIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getContentPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSLanResId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSLanResName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isContentPSLanResNameDirty() : !pSViewMsg.isContentPSLanResNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getContentPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSLanResName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isContentTypeDirty() : !pSViewMsg.isContentTypeDirty()) {
            return null;
        }
        String string = pSViewMsg.getContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentTypePSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isContentTypePSDEFIdDirty() : !pSViewMsg.isContentTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getContentTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentTypePSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentTypePSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isContentTypePSDEFNameDirty() : !pSViewMsg.isContentTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getContentTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentTypePSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isDefaultFlagDirty() : !pSViewMsg.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSViewMsg.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSLink(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isDSLinkDirty() : !pSViewMsg.isDSLinkDirty()) {
            return null;
        }
        String string = pSViewMsg.getDSLink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSLink_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSLINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynamicMode(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isDynamicModeDirty() && !bl2 : !pSViewMsg.isDynamicModeDirty()) {
            return null;
        }
        Integer n = pSViewMsg.getDynamicMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMICMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DynamicMode_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMICMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCache(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isEnableCacheDirty() : !pSViewMsg.isEnableCacheDirty()) {
            return null;
        }
        Integer n = pSViewMsg.getEnableCache();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCache_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECACHE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableMode(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isEnableModeDirty() : !pSViewMsg.isEnableModeDirty()) {
            return null;
        }
        String string = pSViewMsg.getEnableMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnableMode_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableRemove(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isEnableRemoveDirty() : !pSViewMsg.isEnableRemoveDirty()) {
            return null;
        }
        Integer n = pSViewMsg.getEnableRemove();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableRemove_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEREMOVE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isGroupPSDEFIdDirty() : !pSViewMsg.isGroupPSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getGroupPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isGroupPSDEFNameDirty() : !pSViewMsg.isGroupPSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getGroupPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isIconPSDEFIdDirty() : !pSViewMsg.isIconPSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getIconPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_IconPSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isIconPSDEFNameDirty() : !pSViewMsg.isIconPSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getIconPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isLockFlagDirty() : !pSViewMsg.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSViewMsg.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isMemoDirty() : !pSViewMsg.isMemoDirty()) {
            return null;
        }
        String string = pSViewMsg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_MsgGroup(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isMsgGroupDirty() : !pSViewMsg.isMsgGroupDirty()) {
            return null;
        }
        String string = pSViewMsg.getMsgGroup();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgGroup_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGGROUP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgPos(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isMsgPosDirty() && !bl2 : !pSViewMsg.isMsgPosDirty()) {
            return null;
        }
        String string = pSViewMsg.getMsgPos();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGPOS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgPos_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgPosPSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isMsgPosPSDEFIdDirty() : !pSViewMsg.isMsgPosPSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getMsgPosPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgPosPSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGPOSPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgPosPSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isMsgPosPSDEFNameDirty() : !pSViewMsg.isMsgPosPSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getMsgPosPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgPosPSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGPOSPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgType(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isMsgTypeDirty() : !pSViewMsg.isMsgTypeDirty()) {
            return null;
        }
        String string = pSViewMsg.getMsgType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgType_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgTypePSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isMsgTypePSDEFIdDirty() : !pSViewMsg.isMsgTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getMsgTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTypePSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgTypePSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isMsgTypePSDEFNameDirty() : !pSViewMsg.isMsgTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getMsgTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTypePSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValuePSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isOrderValuePSDEFIdDirty() : !pSViewMsg.isOrderValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getOrderValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValuePSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isOrderValuePSDEFNameDirty() : !pSViewMsg.isOrderValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getOrderValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPredefinedTypeDirty() : !pSViewMsg.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSViewMsg.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSDEDSIdDirty() : !pSViewMsg.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSDEIdDirty() : !pSViewMsg.isPSDEIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSDELogicIdDirty() : !pSViewMsg.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSDENameDirty() : !pSViewMsg.isPSDENameDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSDEOPPrivIdDirty() : !pSViewMsg.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSModuleIdDirty() : !pSViewMsg.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSSysCssIdDirty() : !pSViewMsg.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSSysDynaModelIdDirty() : !pSViewMsg.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSSysImageIdDirty() : !pSViewMsg.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMsgTemplId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSSysMsgTemplIdDirty() : !pSViewMsg.isPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSSysMsgTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSSysSFPluginIdDirty() : !pSViewMsg.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSSystemIdDirty() : !pSViewMsg.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSSystemNameDirty() : !pSViewMsg.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSSysViewPanelIdDirty() : !pSViewMsg.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSViewMsgIdDirty() && !bl2 : !pSViewMsg.isPSViewMsgIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSViewMsgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isPSViewMsgNameDirty() && !bl2 : !pSViewMsg.isPSViewMsgNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getPSViewMsgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGNAME");
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSViewMsgDEModel(), "PSVIEWMSGNAME", string3, pSViewMsg, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSVIEWMSGNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemovePSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isRemovePSDEFIdDirty() : !pSViewMsg.isRemovePSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getRemovePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemovePSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isRemovePSDEFNameDirty() : !pSViewMsg.isRemovePSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getRemovePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestCustomCode(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isTestCustomCodeDirty() : !pSViewMsg.isTestCustomCodeDirty()) {
            return null;
        }
        String string = pSViewMsg.getTestCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestCustomCode_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTCUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestPSDELogicId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isTestPSDELogicIdDirty() : !pSViewMsg.isTestPSDELogicIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getTestPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestPSDELogicId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Timeout(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isTimeoutDirty() : !pSViewMsg.isTimeoutDirty()) {
            return null;
        }
        Integer n = pSViewMsg.getTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timeout_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Title(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isTitleDirty() : !pSViewMsg.isTitleDirty()) {
            return null;
        }
        String string = pSViewMsg.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitleLanResTagPSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isTitleLanResTagPSDEFIdDirty() : !pSViewMsg.isTitleLanResTagPSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getTitleLanResTagPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitleLanResTagPSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLELANRESTAGPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitleLanResTagPSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isTitleLanResTagPSDEFNameDirty() : !pSViewMsg.isTitleLanResTagPSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getTitleLanResTagPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitleLanResTagPSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLELANRESTAGPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSDEFId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isTitlePSDEFIdDirty() : !pSViewMsg.isTitlePSDEFIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getTitlePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSDEFId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSDEFName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isTitlePSDEFNameDirty() : !pSViewMsg.isTitlePSDEFNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getTitlePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSDEFName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResId(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isTitlePSLanResIdDirty() : !pSViewMsg.isTitlePSLanResIdDirty()) {
            return null;
        }
        String string = pSViewMsg.getTitlePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResId_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResName(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isTitlePSLanResNameDirty() : !pSViewMsg.isTitlePSLanResNameDirty()) {
            return null;
        }
        String string = pSViewMsg.getTitlePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResName_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isUserCatDirty() : !pSViewMsg.isUserCatDirty()) {
            return null;
        }
        String string = pSViewMsg.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isUserTagDirty() : !pSViewMsg.isUserTagDirty()) {
            return null;
        }
        String string = pSViewMsg.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isUserTag2Dirty() : !pSViewMsg.isUserTag2Dirty()) {
            return null;
        }
        String string = pSViewMsg.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isUserTag3Dirty() : !pSViewMsg.isUserTag3Dirty()) {
            return null;
        }
        String string = pSViewMsg.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isUserTag4Dirty() : !pSViewMsg.isUserTag4Dirty()) {
            return null;
        }
        String string = pSViewMsg.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSViewMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewMsgParams(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isViewMsgParamsDirty() : !pSViewMsg.isViewMsgParamsDirty()) {
            return null;
        }
        String string = pSViewMsg.getViewMsgParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewMsgParams_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWMSGPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VewMsgTag(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isVewMsgTagDirty() : !pSViewMsg.isVewMsgTagDirty()) {
            return null;
        }
        String string = pSViewMsg.getVewMsgTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VewMsgTag_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWMSGTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VewMsgTag2(boolean bl, PSViewMsg pSViewMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsg.isVewMsgTag2Dirty() : !pSViewMsg.isVewMsgTag2Dirty()) {
            return null;
        }
        String string = pSViewMsg.getVewMsgTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VewMsgTag2_Default((IEntity)pSViewMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWMSGTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSViewMsg, bl);
    }

    protected void onSyncIndexEntities(PSViewMsg pSViewMsg, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSViewMsg, bl);
    }

    public Object getDataContextValue(PSViewMsg pSViewMsg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSViewMsg, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSViewMsg pSViewMsg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_TitlePSLanRes(pSViewMsg, arrayList, n);
        super.onExportMajorModel((IEntity)pSViewMsg, arrayList, n);
    }

    protected void onExportMajorModel_TitlePSLanRes(PSViewMsg pSViewMsg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSViewMsg.getTitlePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSViewMsg.getTitlePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CACHESCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETAG2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTag2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETAG2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTag2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETAGPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTagPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETAGPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTagPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentTypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentTypePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSLINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSLink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMICMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynamicMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECACHE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCache_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEREMOVE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableRemove_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGGROUP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgGroup_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGPOSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgPosPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGPOSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgPosPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTypePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTCUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestCustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Timeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLELANRESTAGPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitleLanResTagPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLELANRESTAGPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitleLanResTagPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWMSGPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewMsgParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWMSGTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VewMsgTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWMSGTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VewMsgTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CacheScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHESCOPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTag2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHETAG2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTag2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHETAG2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTagPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHETAGPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTagPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHETAGPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentTypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentTypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DSLink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSLINK", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynamicMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCache_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENABLEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableRemove_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_MsgGroup_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGGROUP", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGPOS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgPosPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGPOSPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgPosPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGPOSPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgTypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgTypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORDERVALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORDERVALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSViewMsgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestCustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTCUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestPSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestPSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Timeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitleLanResTagPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLELANRESTAGPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitleLanResTagPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLELANRESTAGPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ViewMsgParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWMSGPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VewMsgTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWMSGTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VewMsgTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWMSGTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSViewMsg pSViewMsg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSViewMsg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSViewMsg pSViewMsg) throws Exception {
        super.onUpdateParent((IEntity)pSViewMsg);
    }

    @Override
    protected void exportCurXmlModel(PSViewMsg pSViewMsg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVIEWMSG");
        if (!bl) {
            pSViewMsg.setCreateDate(null);
            pSViewMsg.setCreateMan(null);
            pSViewMsg.setPSDEDSName(null);
            pSViewMsg.setPSViewMsgId(null);
            pSViewMsg.setUpdateDate(null);
            pSViewMsg.setUpdateMan(null);
            super.exportCurXmlModel(pSViewMsg, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSViewMsg pSViewMsg, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSViewMsg, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSVIEWMSG_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSVIEWMSG_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSMODULE", (boolean)true) == 0) {
            iEntity.set("PSMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSViewMsg pSViewMsg) {
        if (!StringHelper.isNullOrEmpty((String)pSViewMsg.getCodeName())) {
            return pSViewMsg.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSViewMsg.getPSViewMsgName())) {
            return pSViewMsg.getPSViewMsgName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSViewMsg.getCodeName())) {
            return pSViewMsg.getCodeName();
        }
        return super.getModelV2Tag(pSViewMsg);
    }

    @Override
    public boolean setModelV2Tag(PSViewMsg pSViewMsg, String string) {
        pSViewMsg.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSVIEWMSGNAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSViewMsg pSViewMsg, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSViewMsg.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSViewMsg, true);
        pSViewMsg.set("CODENAME", string);
        if (this.select(pSViewMsg, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSViewMsg, true);
        return super.getModelV2Entity(pSViewMsg, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSViewMsg pSViewMsg, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSViewMsg, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSViewMsg pSViewMsg, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "ViewMsg");
        defaultValueMap.put("PSVIEWMSGNAME", "\u89c6\u56fe\u6d88\u606f");
    }
}

