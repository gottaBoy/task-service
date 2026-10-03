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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItemRV;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemRVService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemRVServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCalendarItemServiceBase
extends PSCoreSysServiceBase<PSSysCalendarItem> {
    private static final Log log = LogFactory.getLog(PSSysCalendarItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysCalendarItemDEModel pSSysCalendarItemDEModel;
    private PSSysCalendarItemDAO pSSysCalendarItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService";
    }

    public PSSysCalendarItemDEModel getPSSysCalendarItemDEModel() {
        if (this.pSSysCalendarItemDEModel == null) {
            try {
                this.pSSysCalendarItemDEModel = (PSSysCalendarItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysCalendarItemDEModel();
    }

    public PSSysCalendarItemDAO getPSSysCalendarItemDAO() {
        if (this.pSSysCalendarItemDAO == null) {
            try {
                this.pSSysCalendarItemDAO = (PSSysCalendarItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysCalendarItemDAO();
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

    protected void onFillParentInfo(PSSysCalendarItem pSSysCalendarItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysCalendarItem, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEACTION_CREATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_CreatePSDEAction(pSSysCalendarItem, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEACTION_MOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_MovePSDEAction(pSSysCalendarItem, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEACTION_REMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_RemovePSDEAction(pSSysCalendarItem, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEACTION_UPDATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_UpdatePSDEAction(pSSysCalendarItem, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEDATASET_ASYNCPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_AsyncPSDEDS(pSSysCalendarItem, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSSysCalendarItem, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_BEGINPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_BeginPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_BKCOLORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_BKColorPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_CLSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ClsPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_COLORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ColorPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_CONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ContentPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_DATA2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_Data2PSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_DATAPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_DataPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_ENDPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_EndPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_FINISHPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_FinishPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_ICONPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_IconPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_KEYPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_KeyPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_LEVELPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_LevelPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_LINKPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_LinkPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_ORDERVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_OrderValuePSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_PKEYPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PKeyPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_TAG2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_Tag2PSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_TAGPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TagPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_TEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TextPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_TIPSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TipsPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEFIELD_TOTALPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TotalPSDEF(pSSysCalendarItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSSysCalendarItem, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEOPPRIV_CREATEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_CreatePSDEOPPriv(pSSysCalendarItem, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEOPPRIV_MOVEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_MovePSDEOPPriv(pSSysCalendarItem, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEOPPRIV_REMOVEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_RemovePSDEOPPriv(pSSysCalendarItem, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEOPPRIV_UPDATEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_UpdatePSDEOPPriv(pSSysCalendarItem, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSSysCalendarItem, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEToolbar);
            } else {
                iService.get(pSDEToolbar);
            }
            this.onFillParentInfo_PSDEToolbar(pSSysCalendarItem, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSSysCalendarItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSLANGUAGERES_NAMEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_NamePSLanRes(pSSysCalendarItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSSYSCALENDAR_PSSYSCALENDARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService", (SessionFactory)this.getSessionFactory());
            PSSysCalendar pSSysCalendar = (PSSysCalendar)iService.getDEModel().createEntity();
            pSSysCalendar.set("PSSYSCALENDARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCalendar);
            } else {
                iService.get(pSSysCalendar);
            }
            this.onFillParentInfo_PSSysCalendar(pSSysCalendarItem, pSSysCalendar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSSysCalendarItem, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSSysCalendarItem, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSSYSPFPLUGIN_GANTTPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_GanttPSSysPFPluin(pSSysCalendarItem, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysCalendarItem, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEM_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSSysCalendarItem, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSSysCalendarItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysCalendarItem pSSysCalendarItem, PSDataEntity pSDataEntity) throws Exception {
        pSSysCalendarItem.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysCalendarItem.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_CreatePSDEAction(PSSysCalendarItem pSSysCalendarItem, PSDEAction pSDEAction) throws Exception {
        pSSysCalendarItem.setCreatePSDEActionId(pSDEAction.getPSDEActionId());
        pSSysCalendarItem.setCreatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_MovePSDEAction(PSSysCalendarItem pSSysCalendarItem, PSDEAction pSDEAction) throws Exception {
        pSSysCalendarItem.setMovePSDEActionId(pSDEAction.getPSDEActionId());
        pSSysCalendarItem.setMovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_RemovePSDEAction(PSSysCalendarItem pSSysCalendarItem, PSDEAction pSDEAction) throws Exception {
        pSSysCalendarItem.setRemovePSDEActionId(pSDEAction.getPSDEActionId());
        pSSysCalendarItem.setRemovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UpdatePSDEAction(PSSysCalendarItem pSSysCalendarItem, PSDEAction pSDEAction) throws Exception {
        pSSysCalendarItem.setUpdatePSDEActionId(pSDEAction.getPSDEActionId());
        pSSysCalendarItem.setUpdatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_AsyncPSDEDS(PSSysCalendarItem pSSysCalendarItem, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysCalendarItem.setAsyncPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSSysCalendarItem.setAsyncPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDS(PSSysCalendarItem pSSysCalendarItem, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysCalendarItem.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSSysCalendarItem.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_BeginPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setBeginPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setBeginPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_BKColorPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setBKColorPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setBKColorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ClsPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setClsPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setClsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ColorPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setColorPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setColorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ContentPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Data2PSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setData2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setData2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_DataPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setDataPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setDataPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_EndPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setEndPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setEndPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_FinishPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setFinishPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setFinishPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IconPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setIconPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setIconPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_KeyPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setKeyPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setKeyPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_LevelPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setLevelPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setLevelPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_LinkPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setLinkPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setLinkPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_OrderValuePSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setOrderValuePSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PKeyPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setPKeyPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setPKeyPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Tag2PSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setTag2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setTag2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TagPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setTagPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setTagPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TextPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setTextPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TipsPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setTipsPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setTipsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TotalPSDEF(PSSysCalendarItem pSSysCalendarItem, PSDEField pSDEField) throws Exception {
        pSSysCalendarItem.setTotalPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendarItem.setTotalPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDELogic(PSSysCalendarItem pSSysCalendarItem, PSDELogic pSDELogic) throws Exception {
        pSSysCalendarItem.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSSysCalendarItem.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_CreatePSDEOPPriv(PSSysCalendarItem pSSysCalendarItem, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSSysCalendarItem.setCreatePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSSysCalendarItem.setCreatePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_MovePSDEOPPriv(PSSysCalendarItem pSSysCalendarItem, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSSysCalendarItem.setMovePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSSysCalendarItem.setMovePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_RemovePSDEOPPriv(PSSysCalendarItem pSSysCalendarItem, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSSysCalendarItem.setRemovePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSSysCalendarItem.setRemovePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_UpdatePSDEOPPriv(PSSysCalendarItem pSSysCalendarItem, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSSysCalendarItem.setUpdatePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSSysCalendarItem.setUpdatePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSDER(PSSysCalendarItem pSSysCalendarItem, PSDER pSDER) throws Exception {
        pSSysCalendarItem.setPSDERId(pSDER.getPSDERId());
        pSSysCalendarItem.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSDEToolbar(PSSysCalendarItem pSSysCalendarItem, PSDEToolbar pSDEToolbar) throws Exception {
        pSSysCalendarItem.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSSysCalendarItem.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_PSDEViewBase(PSSysCalendarItem pSSysCalendarItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysCalendarItem.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSSysCalendarItem.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_NamePSLanRes(PSSysCalendarItem pSSysCalendarItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysCalendarItem.setNamePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysCalendarItem.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCalendar(PSSysCalendarItem pSSysCalendarItem, PSSysCalendar pSSysCalendar) throws Exception {
        pSSysCalendarItem.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
        pSSysCalendarItem.setPSSysCalendarName(pSSysCalendar.getPSSysCalendarName());
    }

    protected void onFillParentInfo_PSSysCss(PSSysCalendarItem pSSysCalendarItem, PSSysCss pSSysCss) throws Exception {
        pSSysCalendarItem.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysCalendarItem.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSSysCalendarItem pSSysCalendarItem, PSSysImage pSSysImage) throws Exception {
        pSSysCalendarItem.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSSysCalendarItem.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_GanttPSSysPFPluin(PSSysCalendarItem pSSysCalendarItem, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysCalendarItem.setGanttPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysCalendarItem.setGanttPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysCalendarItem pSSysCalendarItem, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysCalendarItem.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysCalendarItem.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSSysCalendarItem pSSysCalendarItem, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysCalendarItem.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSSysCalendarItem.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (bl && pSSysCalendarItem.getValidFlag() == null) {
            pSSysCalendarItem.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSDE(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_CreatePSDEAction(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_MovePSDEAction(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_RemovePSDEAction(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_UpdatePSDEAction(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_AsyncPSDEDS(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSDEDS(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_BeginPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_BKColorPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_ClsPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_ColorPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_ContentPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_Data2PSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_DataPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_EndPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_FinishPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_IconPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_KeyPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_LevelPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_LinkPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_OrderValuePSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PKeyPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_Tag2PSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_TagPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_TextPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_TipsPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_TotalPSDEF(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSDELogic(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_CreatePSDEOPPriv(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_MovePSDEOPPriv(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_RemovePSDEOPPriv(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_UpdatePSDEOPPriv(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSDER(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSDEToolbar(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_NamePSLanRes(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSSysCalendar(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSSysCss(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSSysImage(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_GanttPSSysPFPluin(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysCalendarItem, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSSysCalendarItem, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isPSDEIdDirty()) {
            if (pSSysCalendarItem.getPSDEId() != null) {
                if (pSSysCalendarItem.getPSDEId() == null || pSSysCalendarItem.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysCalendarItem.getPSDE();
                    pSSysCalendarItem.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysCalendarItem.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CreatePSDEAction(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MovePSDEAction(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEAction(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UpdatePSDEAction(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AsyncPSDEDS(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDS(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_BeginPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isBeginPSDEFIdDirty()) {
            if (pSSysCalendarItem.getBeginPSDEFId() != null) {
                if (pSSysCalendarItem.getBeginPSDEFId() == null || pSSysCalendarItem.getBeginPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getBeginPSDEF();
                    pSSysCalendarItem.setBeginPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setBeginPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_BKColorPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isBKColorPSDEFIdDirty()) {
            if (pSSysCalendarItem.getBKColorPSDEFId() != null) {
                if (pSSysCalendarItem.getBKColorPSDEFId() == null || pSSysCalendarItem.getBKColorPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getBKColorPSDEF();
                    pSSysCalendarItem.setBKColorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setBKColorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ClsPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isClsPSDEFIdDirty()) {
            if (pSSysCalendarItem.getClsPSDEFId() != null) {
                if (pSSysCalendarItem.getClsPSDEFId() == null || pSSysCalendarItem.getClsPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getClsPSDEF();
                    pSSysCalendarItem.setClsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setClsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ColorPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isColorPSDEFIdDirty()) {
            if (pSSysCalendarItem.getColorPSDEFId() != null) {
                if (pSSysCalendarItem.getColorPSDEFId() == null || pSSysCalendarItem.getColorPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getColorPSDEF();
                    pSSysCalendarItem.setColorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setColorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ContentPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isContentPSDEFIdDirty()) {
            if (pSSysCalendarItem.getContentPSDEFId() != null) {
                if (pSSysCalendarItem.getContentPSDEFId() == null || pSSysCalendarItem.getContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getContentPSDEF();
                    pSSysCalendarItem.setContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Data2PSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isData2PSDEFIdDirty()) {
            if (pSSysCalendarItem.getData2PSDEFId() != null) {
                if (pSSysCalendarItem.getData2PSDEFId() == null || pSSysCalendarItem.getData2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getData2PSDEF();
                    pSSysCalendarItem.setData2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setData2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DataPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isDataPSDEFIdDirty()) {
            if (pSSysCalendarItem.getDataPSDEFId() != null) {
                if (pSSysCalendarItem.getDataPSDEFId() == null || pSSysCalendarItem.getDataPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getDataPSDEF();
                    pSSysCalendarItem.setDataPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setDataPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_EndPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isEndPSDEFIdDirty()) {
            if (pSSysCalendarItem.getEndPSDEFId() != null) {
                if (pSSysCalendarItem.getEndPSDEFId() == null || pSSysCalendarItem.getEndPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getEndPSDEF();
                    pSSysCalendarItem.setEndPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setEndPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_FinishPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isFinishPSDEFIdDirty()) {
            if (pSSysCalendarItem.getFinishPSDEFId() != null) {
                if (pSSysCalendarItem.getFinishPSDEFId() == null || pSSysCalendarItem.getFinishPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getFinishPSDEF();
                    pSSysCalendarItem.setFinishPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setFinishPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IconPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isIconPSDEFIdDirty()) {
            if (pSSysCalendarItem.getIconPSDEFId() != null) {
                if (pSSysCalendarItem.getIconPSDEFId() == null || pSSysCalendarItem.getIconPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getIconPSDEF();
                    pSSysCalendarItem.setIconPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setIconPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_KeyPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isKeyPSDEFIdDirty()) {
            if (pSSysCalendarItem.getKeyPSDEFId() != null) {
                if (pSSysCalendarItem.getKeyPSDEFId() == null || pSSysCalendarItem.getKeyPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getKeyPSDEF();
                    pSSysCalendarItem.setKeyPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setKeyPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LevelPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isLevelPSDEFIdDirty()) {
            if (pSSysCalendarItem.getLevelPSDEFId() != null) {
                if (pSSysCalendarItem.getLevelPSDEFId() == null || pSSysCalendarItem.getLevelPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getLevelPSDEF();
                    pSSysCalendarItem.setLevelPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setLevelPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LinkPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isLinkPSDEFIdDirty()) {
            if (pSSysCalendarItem.getLinkPSDEFId() != null) {
                if (pSSysCalendarItem.getLinkPSDEFId() == null || pSSysCalendarItem.getLinkPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getLinkPSDEF();
                    pSSysCalendarItem.setLinkPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setLinkPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OrderValuePSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isOrderValuePSDEFIdDirty()) {
            if (pSSysCalendarItem.getOrderValuePSDEFId() != null) {
                if (pSSysCalendarItem.getOrderValuePSDEFId() == null || pSSysCalendarItem.getOrderValuePSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getOrderValuePSDEF();
                    pSSysCalendarItem.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setOrderValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PKeyPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isPKeyPSDEFIdDirty()) {
            if (pSSysCalendarItem.getPKeyPSDEFId() != null) {
                if (pSSysCalendarItem.getPKeyPSDEFId() == null || pSSysCalendarItem.getPKeyPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getPKeyPSDEF();
                    pSSysCalendarItem.setPKeyPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setPKeyPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Tag2PSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isTag2PSDEFIdDirty()) {
            if (pSSysCalendarItem.getTag2PSDEFId() != null) {
                if (pSSysCalendarItem.getTag2PSDEFId() == null || pSSysCalendarItem.getTag2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getTag2PSDEF();
                    pSSysCalendarItem.setTag2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setTag2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TagPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isTagPSDEFIdDirty()) {
            if (pSSysCalendarItem.getTagPSDEFId() != null) {
                if (pSSysCalendarItem.getTagPSDEFId() == null || pSSysCalendarItem.getTagPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getTagPSDEF();
                    pSSysCalendarItem.setTagPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setTagPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TextPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isTextPSDEFIdDirty()) {
            if (pSSysCalendarItem.getTextPSDEFId() != null) {
                if (pSSysCalendarItem.getTextPSDEFId() == null || pSSysCalendarItem.getTextPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getTextPSDEF();
                    pSSysCalendarItem.setTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipsPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isTipsPSDEFIdDirty()) {
            if (pSSysCalendarItem.getTipsPSDEFId() != null) {
                if (pSSysCalendarItem.getTipsPSDEFId() == null || pSSysCalendarItem.getTipsPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getTipsPSDEF();
                    pSSysCalendarItem.setTipsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setTipsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TotalPSDEF(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isTotalPSDEFIdDirty()) {
            if (pSSysCalendarItem.getTotalPSDEFId() != null) {
                if (pSSysCalendarItem.getTotalPSDEFId() == null || pSSysCalendarItem.getTotalPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendarItem.getTotalPSDEF();
                    pSSysCalendarItem.setTotalPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendarItem.setTotalPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CreatePSDEOPPriv(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isCreatePSDEOPPrivIdDirty()) {
            if (pSSysCalendarItem.getCreatePSDEOPPrivId() != null) {
                if (pSSysCalendarItem.getCreatePSDEOPPrivId() == null || pSSysCalendarItem.getCreatePSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSSysCalendarItem.getCreatePSDEOPPriv();
                    pSSysCalendarItem.setCreatePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSSysCalendarItem.setCreatePSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MovePSDEOPPriv(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEOPPriv(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isRemovePSDEOPPrivIdDirty()) {
            if (pSSysCalendarItem.getRemovePSDEOPPrivId() != null) {
                if (pSSysCalendarItem.getRemovePSDEOPPrivId() == null || pSSysCalendarItem.getRemovePSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSSysCalendarItem.getRemovePSDEOPPriv();
                    pSSysCalendarItem.setRemovePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSSysCalendarItem.setRemovePSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UpdatePSDEOPPriv(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isUpdatePSDEOPPrivIdDirty()) {
            if (pSSysCalendarItem.getUpdatePSDEOPPrivId() != null) {
                if (pSSysCalendarItem.getUpdatePSDEOPPrivId() == null || pSSysCalendarItem.getUpdatePSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSSysCalendarItem.getUpdatePSDEOPPriv();
                    pSSysCalendarItem.setUpdatePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSSysCalendarItem.setUpdatePSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDER(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isPSDERIdDirty()) {
            if (pSSysCalendarItem.getPSDERId() != null) {
                if (pSSysCalendarItem.getPSDERId() == null || pSSysCalendarItem.getPSDERName() == null) {
                    PSDER pSDER = pSSysCalendarItem.getPSDER();
                    pSSysCalendarItem.setPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSSysCalendarItem.setPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEToolbar(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NamePSLanRes(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isNamePSLanResIdDirty()) {
            if (pSSysCalendarItem.getNamePSLanResId() != null) {
                if (pSSysCalendarItem.getNamePSLanResId() == null || pSSysCalendarItem.getNamePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysCalendarItem.getNamePSLanRes();
                    pSSysCalendarItem.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysCalendarItem.setNamePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCalendar(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        if (pSSysCalendarItem.isPSSysCalendarIdDirty()) {
            if (pSSysCalendarItem.getPSSysCalendarId() != null) {
                if (pSSysCalendarItem.getPSSysCalendarId() == null || pSSysCalendarItem.getPSSysCalendarName() == null) {
                    PSSysCalendar pSSysCalendar = pSSysCalendarItem.getPSSysCalendar();
                    pSSysCalendarItem.setPSSysCalendarName(pSSysCalendar.getPSSysCalendarName());
                }
            } else {
                pSSysCalendarItem.setPSSysCalendarName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GanttPSSysPFPluin(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysCalendarItem, bl);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CREATEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCreatePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCreatePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByMovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByAsyncPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByAsyncPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ASYNCPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAsyncPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAsyncPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByBeginPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByBeginPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByBeginPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByBeginPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByBeginPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BEGINPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBeginPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBeginPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByBKColorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByBKColorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BKCOLORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBKColorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBKColorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByClsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByClsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByColorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByColorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("COLORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByColorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByColorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByData2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByData2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByData2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByData2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByData2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDataPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDataPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByEndPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByEndPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByEndPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByEndPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByEndPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ENDPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEndPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEndPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByFinishPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByFinishPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByFinishPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByFinishPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByFinishPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FINISHPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFinishPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFinishPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIconPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIconPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByLevelPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByLevelPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByLevelPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByLevelPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByLevelPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LEVELPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLevelPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLevelPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByLinkPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByLinkPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByPKeyPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPKeyPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPKeyPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PKEYPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPKeyPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPKeyPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByTag2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTag2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByTag2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTag2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByTag2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TAG2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTag2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTag2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByTagPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTagPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByTagPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTagPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByTagPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TAGPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTagPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTagPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByTipsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTipsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByTipsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTipsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByTipsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByTotalPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTotalPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByTotalPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTotalPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByTotalPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TOTALPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTotalPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTotalPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByCreatePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByCreatePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByMovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByMovePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByMovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByMovePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByMovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByRemovePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByRemovePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByUpdatePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByUpdatePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase) throws Exception {
        return this.selectByPSSysCalendar(pSSysCalendarBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string) throws Exception {
        return this.selectByPSSysCalendar(pSSysCalendarBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCALENDARID", (Object)pSSysCalendarBase.getPSSysCalendarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCalendarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCalendarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectTempByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase) throws Exception {
        return this.selectTempByPSSysCalendar(pSSysCalendarBase, "");
    }

    public ArrayList<PSSysCalendarItem> selectTempByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCALENDARID", (Object)pSSysCalendarBase.getPSSysCalendarId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysCalendarCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysCalendarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByGanttPSSysPFPluin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByGanttPSSysPFPluin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByGanttPSSysPFPluin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByGanttPSSysPFPluin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByGanttPSSysPFPluin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GANTTPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGanttPSSysPFPluinCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGanttPSSysPFPluinCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarItem> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSSysCalendarItem> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSDEId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByCreatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEACTION_CREATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setCreatePSDEActionId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByCreatePSDEAction(pSDEAction2);
                PSSysCalendarItemServiceBase.this.internalRemoveByCreatePSDEAction(pSDEAction2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByCreatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        this.onBeforeRemoveByCreatePSDEAction(pSDEAction, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByCreatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByMovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEACTION_MOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByMovePSDEAction(pSDEAction);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setMovePSDEActionId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByMovePSDEAction(pSDEAction2);
                PSSysCalendarItemServiceBase.this.internalRemoveByMovePSDEAction(pSDEAction2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByMovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByMovePSDEAction(pSDEAction);
        this.onBeforeRemoveByMovePSDEAction(pSDEAction, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByMovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByRemovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEACTION_REMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setRemovePSDEActionId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByRemovePSDEAction(pSDEAction2);
                PSSysCalendarItemServiceBase.this.internalRemoveByRemovePSDEAction(pSDEAction2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByRemovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        this.onBeforeRemoveByRemovePSDEAction(pSDEAction, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByRemovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByUpdatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEACTION_UPDATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setUpdatePSDEActionId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByUpdatePSDEAction(pSDEAction2);
                PSSysCalendarItemServiceBase.this.internalRemoveByUpdatePSDEAction(pSDEAction2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByUpdatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        this.onBeforeRemoveByUpdatePSDEAction(pSDEAction, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByUpdatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEDATASET_ASYNCPSDEDSID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setAsyncPSDEDSId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByAsyncPSDEDS(pSDEDataSet2);
                PSSysCalendarItemServiceBase.this.internalRemoveByAsyncPSDEDS(pSDEDataSet2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByAsyncPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByAsyncPSDEDS(pSDEDataSet, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByAsyncPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSDEDSId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByBeginPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByBeginPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_BEGINPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetBeginPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByBeginPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setBeginPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByBeginPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByBeginPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByBeginPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByBeginPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByBeginPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByBeginPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByBeginPSDEF(pSDEField);
        this.onBeforeRemoveByBeginPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByBeginPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByBeginPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByBeginPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBeginPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByBKColorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_BKCOLORPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByBKColorPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setBKColorPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByBKColorPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByBKColorPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByBKColorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByBKColorPSDEF(pSDEField);
        this.onBeforeRemoveByBKColorPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByBKColorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByBKColorPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBKColorPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByClsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_CLSPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByClsPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setClsPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByClsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByClsPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByClsPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByClsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByClsPSDEF(pSDEField);
        this.onBeforeRemoveByClsPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByClsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByClsPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByClsPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByColorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_COLORPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByColorPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setColorPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByColorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByColorPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByColorPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByColorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByColorPSDEF(pSDEField);
        this.onBeforeRemoveByColorPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByColorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByColorPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByColorPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_CONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByContentPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setContentPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByContentPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByContentPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByContentPSDEF(pSDEField);
        this.onBeforeRemoveByContentPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByData2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_DATA2PSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetData2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByData2PSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setData2PSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByData2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByData2PSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByData2PSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByData2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByData2PSDEF(pSDEField);
        this.onBeforeRemoveByData2PSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByData2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByData2PSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByData2PSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByDataPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_DATAPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByDataPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setDataPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByDataPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByDataPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByDataPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByDataPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByDataPSDEF(pSDEField);
        this.onBeforeRemoveByDataPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByDataPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDataPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDataPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByEndPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByEndPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_ENDPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetEndPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByEndPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setEndPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByEndPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByEndPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByEndPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByEndPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByEndPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByEndPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByEndPSDEF(pSDEField);
        this.onBeforeRemoveByEndPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByEndPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByEndPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByEndPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEndPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByFinishPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByFinishPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_FINISHPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetFinishPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByFinishPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setFinishPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByFinishPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByFinishPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByFinishPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByFinishPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByFinishPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByFinishPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByFinishPSDEF(pSDEField);
        this.onBeforeRemoveByFinishPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByFinishPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByFinishPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByFinishPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFinishPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByIconPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_ICONPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByIconPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setIconPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByIconPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByIconPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByIconPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByIconPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByIconPSDEF(pSDEField);
        this.onBeforeRemoveByIconPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByIconPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIconPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIconPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByKeyPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_KEYPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByKeyPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setKeyPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByKeyPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByKeyPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByKeyPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByKeyPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByKeyPSDEF(pSDEField);
        this.onBeforeRemoveByKeyPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByKeyPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByLevelPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByLevelPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_LEVELPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetLevelPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByLevelPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setLevelPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByLevelPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByLevelPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByLevelPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByLevelPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByLevelPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByLevelPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByLevelPSDEF(pSDEField);
        this.onBeforeRemoveByLevelPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByLevelPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByLevelPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByLevelPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLevelPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByLinkPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_LINKPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByLinkPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setLinkPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByLinkPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByLinkPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByLinkPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByLinkPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByLinkPSDEF(pSDEField);
        this.onBeforeRemoveByLinkPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByLinkPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByOrderValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_ORDERVALUEPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setOrderValuePSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByOrderValuePSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByOrderValuePSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByOrderValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        this.onBeforeRemoveByOrderValuePSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByOrderValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPKeyPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_PKEYPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPKeyPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPKeyPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPKeyPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPKeyPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPKeyPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPKeyPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPKeyPSDEF(pSDEField);
        this.onBeforeRemoveByPKeyPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPKeyPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTag2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_TAG2PSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTag2PSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setTag2PSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByTag2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByTag2PSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByTag2PSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByTag2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTag2PSDEF(pSDEField);
        this.onBeforeRemoveByTag2PSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByTag2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTag2PSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTag2PSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTagPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_TAGPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTagPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setTagPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByTagPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByTagPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByTagPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByTagPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTagPSDEF(pSDEField);
        this.onBeforeRemoveByTagPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByTagPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTagPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTagPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_TEXTPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTextPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setTextPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByTextPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByTextPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTextPSDEF(pSDEField);
        this.onBeforeRemoveByTextPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTipsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_TIPSPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTipsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTipsPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setTipsPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByTipsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByTipsPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByTipsPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByTipsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTipsPSDEF(pSDEField);
        this.onBeforeRemoveByTipsPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByTipsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTipsPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipsPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByTotalPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTotalPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEFIELD_TOTALPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTotalPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTotalPSDEF(pSDEField);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setTotalPSDEFId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByTotalPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByTotalPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.internalRemoveByTotalPSDEF(pSDEField2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByTotalPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTotalPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTotalPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByTotalPSDEF(pSDEField);
        this.onBeforeRemoveByTotalPSDEF(pSDEField, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByTotalPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTotalPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTotalPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTotalPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSDELogicId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEOPPRIV_CREATEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setCreatePSDEOPPrivId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
                PSSysCalendarItemServiceBase.this.internalRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByCreatePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByCreatePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByMovePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEOPPRIV_MOVEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByMovePSDEOPPriv(pSDEOPPriv);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setMovePSDEOPPrivId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByMovePSDEOPPriv(pSDEOPPriv2);
                PSSysCalendarItemServiceBase.this.internalRemoveByMovePSDEOPPriv(pSDEOPPriv2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByMovePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByMovePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByMovePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByMovePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEOPPRIV_REMOVEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setRemovePSDEOPPrivId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
                PSSysCalendarItemServiceBase.this.internalRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByRemovePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByRemovePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEOPPRIV_UPDATEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setUpdatePSDEOPPrivId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
                PSSysCalendarItemServiceBase.this.internalRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByUpdatePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByUpdatePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDER(pSDER);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSDERId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDETOOLBAR_PSDETOOLBARID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSDEToolbarId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSDEToolbar(pSDEToolbar2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSDEToolbar(pSDEToolbar2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByPSDEToolbar(pSDEToolbar, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSDEViewBaseId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByNamePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSLANGUAGERES_NAMEPSLANRESID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setNamePSLanResId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByNamePSLanRes(pSLanguageRes2);
                PSSysCalendarItemServiceBase.this.internalRemoveByNamePSLanRes(pSLanguageRes2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByNamePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByNamePSLanRes(pSLanguageRes, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByNamePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    public void resetPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSSysCalendarId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void resetTempPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectTempByPSSysCalendar(pSSysCalendar);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSSysCalendarId(null);
            this.updateTemp(pSSysCalendarItem2);
        }
    }

    public void removeByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        final PSSysCalendar pSSysCalendar2 = pSSysCalendar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSSysCalendar(pSSysCalendar2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSSysCalendar(pSSysCalendar2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSSysCalendar(pSSysCalendar2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void internalRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
        this.onBeforeRemoveByPSSysCalendar(pSSysCalendar, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSSysCalendar(pSSysCalendar, arrayList);
    }

    protected void onAfterRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSSysCssId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSSysImageId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByGanttPSSysPFPluin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByGanttPSSysPFPluin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSSYSPFPLUGIN_GANTTPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetGanttPSSysPFPluin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByGanttPSSysPFPluin(pSSysPFPlugin);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setGanttPSSysPFPluginId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByGanttPSSysPFPluin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByGanttPSSysPFPluin(pSSysPFPlugin2);
                PSSysCalendarItemServiceBase.this.internalRemoveByGanttPSSysPFPluin(pSSysPFPlugin2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByGanttPSSysPFPluin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByGanttPSSysPFPluin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByGanttPSSysPFPluin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByGanttPSSysPFPluin(pSSysPFPlugin);
        this.onBeforeRemoveByGanttPSSysPFPluin(pSSysPFPlugin, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByGanttPSSysPFPluin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByGanttPSSysPFPluin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByGanttPSSysPFPluin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGanttPSSysPFPluin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSSysPFPluginId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEM_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEM", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            PSSysCalendarItem pSSysCalendarItem2 = (PSSysCalendarItem)this.getDEModel().createEntity();
            pSSysCalendarItem2.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
            pSSysCalendarItem2.setPSSysViewPanelId(null);
            this.update(pSSysCalendarItem2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysCalendarItemServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.remove(pSSysCalendarItem);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemRVServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCalendarItem(pSSysCalendarItem);
        ((PSSysCalendarItemRVServiceBase)pSCoreSysServiceBase).removeByPSSysCalendarItem(pSSysCalendarItem);
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCalendarItem(pSSysCalendarItem);
        super.onBeforeRemove(pSSysCalendarItem);
    }

    protected void onBeforeRemoveTemp(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemRVServiceBase)pSCoreSysServiceBase).removeTempByPSSysCalendarItem(pSSysCalendarItem);
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).resetTempPSSysCalendarItem(pSSysCalendarItem);
        super.onBeforeRemoveTemp(pSSysCalendarItem);
    }

    public void removeTempByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        final PSSysCalendar pSSysCalendar2 = pSSysCalendar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemServiceBase.this.onBeforeRemoveTempByPSSysCalendar(pSSysCalendar2);
                PSSysCalendarItemServiceBase.this.internalRemoveTempByPSSysCalendar(pSSysCalendar2);
                PSSysCalendarItemServiceBase.this.onAfterRemoveTempByPSSysCalendar(pSSysCalendar2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void internalRemoveTempByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysCalendarItem> arrayList = this.selectTempByPSSysCalendar(pSSysCalendar);
        this.onBeforeRemoveTempByPSSysCalendar(pSSysCalendar, arrayList);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            this.removeTemp(pSSysCalendarItem);
        }
        this.onAfterRemoveTempByPSSysCalendar(pSSysCalendar, arrayList);
    }

    protected void onAfterRemoveTempByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        this.getRelatedDataTempMajor_PSSysCalendarItemRV(pSSysCalendarItem);
        super.getRelatedDataTempMajor(pSSysCalendarItem);
    }

    protected void getRelatedDataTempMajor_PSSysCalendarItemRV(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarItemRV> arrayList = null;
        String string = pSSysCalendarItem.getPSSysCalendarItemId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysCalendarItemRVService.selectByPSSysCalendarItem(pSSysCalendarItem) : pSSysCalendarItemRVService.selectTempByPSSysCalendarItem(pSSysCalendarItem);
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
            pSSysCalendarItemRVService.getTempMajor(pSSysCalendarItemRV);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysCalendarItem pSSysCalendarItem, PSSysCalendarItem pSSysCalendarItem2) throws Exception {
        ArrayList<PSSysCalendarItemRV> arrayList = this.updateRelatedDataTempMajor_removePSSysCalendarItemRV(pSSysCalendarItem, pSSysCalendarItem2);
        this.updateRelatedDataTempMajor_updatePSSysCalendarItemRV(pSSysCalendarItem, pSSysCalendarItem2, arrayList);
        super.updateRelatedDataTempMajor(pSSysCalendarItem, pSSysCalendarItem2);
    }

    protected ArrayList<PSSysCalendarItemRV> updateRelatedDataTempMajor_removePSSysCalendarItemRV(PSSysCalendarItem pSSysCalendarItem, PSSysCalendarItem pSSysCalendarItem2) throws Exception {
        PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarItemRV> arrayList = pSSysCalendarItemRVService.selectTempByPSSysCalendarItem(pSSysCalendarItem);
        ArrayList<PSSysCalendarItemRV> arrayList2 = pSSysCalendarItemRVService.selectByPSSysCalendarItem(pSSysCalendarItem2);
        HashMap<String, PSSysCalendarItemRV> hashMap = new HashMap<String, PSSysCalendarItemRV>();
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList2) {
            hashMap.put(pSSysCalendarItemRV.getPSSysCalendarItemRVId(), pSSysCalendarItemRV);
        }
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
            Object object = pSSysCalendarItemRV.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysCalendarItemRV pSSysCalendarItemRV : hashMap.values()) {
            pSSysCalendarItemRVService.remove(pSSysCalendarItemRV);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysCalendarItemRV(PSSysCalendarItem pSSysCalendarItem, PSSysCalendarItem pSSysCalendarItem2, ArrayList<PSSysCalendarItemRV> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
            pSSysCalendarItemRVService.updateTempMajor(pSSysCalendarItemRV);
        }
    }

    protected void replaceParentInfo(PSSysCalendarItem pSSysCalendarItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysCalendarItem, cloneSession);
        if (pSSysCalendarItem.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysCalendarItem.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysCalendarItem, (PSDataEntity)iEntity);
        }
        if (pSSysCalendarItem.getCreatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSSysCalendarItem.getCreatePSDEActionId())) != null) {
            this.onFillParentInfo_CreatePSDEAction(pSSysCalendarItem, (PSDEAction)iEntity);
        }
        if (pSSysCalendarItem.getMovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSSysCalendarItem.getMovePSDEActionId())) != null) {
            this.onFillParentInfo_MovePSDEAction(pSSysCalendarItem, (PSDEAction)iEntity);
        }
        if (pSSysCalendarItem.getRemovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSSysCalendarItem.getRemovePSDEActionId())) != null) {
            this.onFillParentInfo_RemovePSDEAction(pSSysCalendarItem, (PSDEAction)iEntity);
        }
        if (pSSysCalendarItem.getUpdatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSSysCalendarItem.getUpdatePSDEActionId())) != null) {
            this.onFillParentInfo_UpdatePSDEAction(pSSysCalendarItem, (PSDEAction)iEntity);
        }
        if (pSSysCalendarItem.getAsyncPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysCalendarItem.getAsyncPSDEDSId())) != null) {
            this.onFillParentInfo_AsyncPSDEDS(pSSysCalendarItem, (PSDEDataSet)iEntity);
        }
        if (pSSysCalendarItem.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysCalendarItem.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSSysCalendarItem, (PSDEDataSet)iEntity);
        }
        if (pSSysCalendarItem.getBeginPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getBeginPSDEFId())) != null) {
            this.onFillParentInfo_BeginPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getBKColorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getBKColorPSDEFId())) != null) {
            this.onFillParentInfo_BKColorPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getClsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getClsPSDEFId())) != null) {
            this.onFillParentInfo_ClsPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getColorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getColorPSDEFId())) != null) {
            this.onFillParentInfo_ColorPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getContentPSDEFId())) != null) {
            this.onFillParentInfo_ContentPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getData2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getData2PSDEFId())) != null) {
            this.onFillParentInfo_Data2PSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getDataPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getDataPSDEFId())) != null) {
            this.onFillParentInfo_DataPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getEndPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getEndPSDEFId())) != null) {
            this.onFillParentInfo_EndPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getFinishPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getFinishPSDEFId())) != null) {
            this.onFillParentInfo_FinishPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getIconPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getIconPSDEFId())) != null) {
            this.onFillParentInfo_IconPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getKeyPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getKeyPSDEFId())) != null) {
            this.onFillParentInfo_KeyPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getLevelPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getLevelPSDEFId())) != null) {
            this.onFillParentInfo_LevelPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getLinkPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getLinkPSDEFId())) != null) {
            this.onFillParentInfo_LinkPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getOrderValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getOrderValuePSDEFId())) != null) {
            this.onFillParentInfo_OrderValuePSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getPKeyPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getPKeyPSDEFId())) != null) {
            this.onFillParentInfo_PKeyPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getTag2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getTag2PSDEFId())) != null) {
            this.onFillParentInfo_Tag2PSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getTagPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getTagPSDEFId())) != null) {
            this.onFillParentInfo_TagPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getTextPSDEFId())) != null) {
            this.onFillParentInfo_TextPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getTipsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getTipsPSDEFId())) != null) {
            this.onFillParentInfo_TipsPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getTotalPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendarItem.getTotalPSDEFId())) != null) {
            this.onFillParentInfo_TotalPSDEF(pSSysCalendarItem, (PSDEField)iEntity);
        }
        if (pSSysCalendarItem.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysCalendarItem.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSSysCalendarItem, (PSDELogic)iEntity);
        }
        if (pSSysCalendarItem.getCreatePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSSysCalendarItem.getCreatePSDEOPPrivId())) != null) {
            this.onFillParentInfo_CreatePSDEOPPriv(pSSysCalendarItem, (PSDEOPPriv)iEntity);
        }
        if (pSSysCalendarItem.getMovePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSSysCalendarItem.getMovePSDEOPPrivId())) != null) {
            this.onFillParentInfo_MovePSDEOPPriv(pSSysCalendarItem, (PSDEOPPriv)iEntity);
        }
        if (pSSysCalendarItem.getRemovePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSSysCalendarItem.getRemovePSDEOPPrivId())) != null) {
            this.onFillParentInfo_RemovePSDEOPPriv(pSSysCalendarItem, (PSDEOPPriv)iEntity);
        }
        if (pSSysCalendarItem.getUpdatePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSSysCalendarItem.getUpdatePSDEOPPrivId())) != null) {
            this.onFillParentInfo_UpdatePSDEOPPriv(pSSysCalendarItem, (PSDEOPPriv)iEntity);
        }
        if (pSSysCalendarItem.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSSysCalendarItem.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSSysCalendarItem, (PSDER)iEntity);
        }
        if (pSSysCalendarItem.getPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSSysCalendarItem.getPSDEToolbarId())) != null) {
            this.onFillParentInfo_PSDEToolbar(pSSysCalendarItem, (PSDEToolbar)iEntity);
        }
        if (pSSysCalendarItem.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysCalendarItem.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSSysCalendarItem, (PSDEViewBase)iEntity);
        }
        if (pSSysCalendarItem.getNamePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysCalendarItem.getNamePSLanResId())) != null) {
            this.onFillParentInfo_NamePSLanRes(pSSysCalendarItem, (PSLanguageRes)iEntity);
        }
        if (pSSysCalendarItem.getPSSysCalendarId() != null && (iEntity = cloneSession.getEntity("PSSYSCALENDAR", (Object)pSSysCalendarItem.getPSSysCalendarId())) != null) {
            this.onFillParentInfo_PSSysCalendar(pSSysCalendarItem, (PSSysCalendar)iEntity);
        }
        if (pSSysCalendarItem.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysCalendarItem.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSSysCalendarItem, (PSSysCss)iEntity);
        }
        if (pSSysCalendarItem.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSSysCalendarItem.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSSysCalendarItem, (PSSysImage)iEntity);
        }
        if (pSSysCalendarItem.getGanttPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysCalendarItem.getGanttPSSysPFPluginId())) != null) {
            this.onFillParentInfo_GanttPSSysPFPluin(pSSysCalendarItem, (PSSysPFPlugin)iEntity);
        }
        if (pSSysCalendarItem.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysCalendarItem.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysCalendarItem, (PSSysPFPlugin)iEntity);
        }
        if (pSSysCalendarItem.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSSysCalendarItem.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSSysCalendarItem, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysCalendarItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AsyncPSDEDSId(bl, pSSysCalendarItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColor(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColorPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColorPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Color(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColorPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColorPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEActionId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEOPPrivId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEOPPrivName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data2PSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data2PSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditMode(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableViewActions(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GanttPSSysPFPluginId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemStyle(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemType(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxSize(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelObj(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MovePSDEActionId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MovePSDEOPPrivId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilter(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewParam(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PKeyPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PKeyPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarItemId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarItemName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEActionId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEOPPrivId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEOPPrivName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tag2PSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tag2PSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipsPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipsPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TotalPSDEFId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TotalPSDEFName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEActionId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEOPPrivId(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEOPPrivName(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewActions(bl, pSSysCalendarItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysCalendarItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AsyncPSDEDSId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isAsyncPSDEDSIdDirty() : !pSSysCalendarItem.isAsyncPSDEDSIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getAsyncPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AsyncPSDEDSId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASYNCPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isBeginPSDEFIdDirty() && !bl2 : !pSSysCalendarItem.isBeginPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getBeginPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINPSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeginPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isBeginPSDEFNameDirty() && !bl2 : !pSSysCalendarItem.isBeginPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getBeginPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINPSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeginPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKColor(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isBKColorDirty() : !pSSysCalendarItem.isBKColorDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getBKColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColor_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKCOLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKColorPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isBKColorPSDEFIdDirty() : !pSSysCalendarItem.isBKColorPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getBKColorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColorPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKCOLORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKColorPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isBKColorPSDEFNameDirty() : !pSSysCalendarItem.isBKColorPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getBKColorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColorPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKCOLORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClsPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isClsPSDEFIdDirty() : !pSSysCalendarItem.isClsPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getClsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ClsPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isClsPSDEFNameDirty() : !pSSysCalendarItem.isClsPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getClsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Color(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isColorDirty() : !pSSysCalendarItem.isColorDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Color_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColorPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isColorPSDEFIdDirty() : !pSSysCalendarItem.isColorPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getColorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColorPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColorPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isColorPSDEFNameDirty() : !pSSysCalendarItem.isColorPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getColorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColorPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isContentPSDEFIdDirty() : !pSSysCalendarItem.isContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isContentPSDEFNameDirty() : !pSSysCalendarItem.isContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreatePSDEActionId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isCreatePSDEActionIdDirty() : !pSSysCalendarItem.isCreatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getCreatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEActionId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreatePSDEOPPrivId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isCreatePSDEOPPrivIdDirty() : !pSSysCalendarItem.isCreatePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getCreatePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEOPPrivId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreatePSDEOPPrivName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isCreatePSDEOPPrivNameDirty() : !pSSysCalendarItem.isCreatePSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getCreatePSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEOPPrivName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEOPPRIVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isCustomCondDirty() : !pSSysCalendarItem.isCustomCondDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isCustomTypeDirty() : !pSSysCalendarItem.isCustomTypeDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Data2PSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isData2PSDEFIdDirty() : !pSSysCalendarItem.isData2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getData2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data2PSDEFId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Data2PSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isData2PSDEFNameDirty() : !pSSysCalendarItem.isData2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getData2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data2PSDEFName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isDataPSDEFIdDirty() : !pSSysCalendarItem.isDataPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getDataPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isDataPSDEFNameDirty() : !pSSysCalendarItem.isDataPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getDataPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isDynaClassDirty() : !pSSysCalendarItem.isDynaClassDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditMode(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isEditModeDirty() : !pSSysCalendarItem.isEditModeDirty()) {
            return null;
        }
        Integer n = pSSysCalendarItem.getEditMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EditMode_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableViewActions(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isEnableViewActionsDirty() : !pSSysCalendarItem.isEnableViewActionsDirty()) {
            return null;
        }
        Integer n = pSSysCalendarItem.getEnableViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableViewActions_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isEndPSDEFIdDirty() && !bl2 : !pSSysCalendarItem.isEndPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getEndPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDPSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_EndPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isEndPSDEFNameDirty() && !bl2 : !pSSysCalendarItem.isEndPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getEndPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDPSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_EndPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isFinishPSDEFIdDirty() : !pSSysCalendarItem.isFinishPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getFinishPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isFinishPSDEFNameDirty() : !pSSysCalendarItem.isFinishPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getFinishPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GanttPSSysPFPluginId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isGanttPSSysPFPluginIdDirty() : !pSSysCalendarItem.isGanttPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getGanttPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GanttPSSysPFPluginId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GANTTPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isIconPSDEFIdDirty() : !pSSysCalendarItem.isIconPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getIconPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_IconPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isIconPSDEFNameDirty() : !pSSysCalendarItem.isIconPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getIconPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ItemStyle(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isItemStyleDirty() : !pSSysCalendarItem.isItemStyleDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getItemStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemStyle_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemType(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isItemTypeDirty() && !bl2 : !pSSysCalendarItem.isItemTypeDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemType_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSCALENDARID";
                String string4 = this.checkFieldDupRule(this.getPSSysCalendarItemDEModel(), "ITEMTYPE", string3, pSSysCalendarItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("ITEMTYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isKeyPSDEFIdDirty() : !pSSysCalendarItem.isKeyPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getKeyPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_KeyPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isKeyPSDEFNameDirty() : !pSSysCalendarItem.isKeyPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getKeyPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_LevelPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isLevelPSDEFIdDirty() : !pSSysCalendarItem.isLevelPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getLevelPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LevelPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isLevelPSDEFNameDirty() : !pSSysCalendarItem.isLevelPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getLevelPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LevelPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isLinkPSDEFIdDirty() : !pSSysCalendarItem.isLinkPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getLinkPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isLinkPSDEFNameDirty() : !pSSysCalendarItem.isLinkPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getLinkPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_MaxSize(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isMaxSizeDirty() : !pSSysCalendarItem.isMaxSizeDirty()) {
            return null;
        }
        Integer n = pSSysCalendarItem.getMaxSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxSize_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isMemoDirty() : !pSSysCalendarItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelObj(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isModelObjDirty() : !pSSysCalendarItem.isModelObjDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getModelObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelObj_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_MovePSDEActionId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isMovePSDEActionIdDirty() : !pSSysCalendarItem.isMovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getMovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MovePSDEActionId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_MovePSDEOPPrivId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isMovePSDEOPPrivIdDirty() : !pSSysCalendarItem.isMovePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getMovePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MovePSDEOPPrivId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_NamePSLanResId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isNamePSLanResIdDirty() : !pSSysCalendarItem.isNamePSLanResIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getNamePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_NamePSLanResName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isNamePSLanResNameDirty() : !pSSysCalendarItem.isNamePSLanResNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getNamePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewFilter(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isNavViewFilterDirty() : !pSSysCalendarItem.isNavViewFilterDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getNavViewFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilter_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewParam(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isNavViewParamDirty() : !pSSysCalendarItem.isNavViewParamDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getNavViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewParam_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isOrderValueDirty() : !pSSysCalendarItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysCalendarItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValuePSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isOrderValuePSDEFIdDirty() : !pSSysCalendarItem.isOrderValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getOrderValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValuePSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isOrderValuePSDEFNameDirty() : !pSSysCalendarItem.isOrderValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getOrderValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PKeyPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPKeyPSDEFIdDirty() : !pSSysCalendarItem.isPKeyPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPKeyPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PKeyPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKEYPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PKeyPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPKeyPSDEFNameDirty() : !pSSysCalendarItem.isPKeyPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPKeyPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PKeyPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKEYPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSDEDSIdDirty() && !bl2 : !pSSysCalendarItem.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSDEDSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSDEIdDirty() && !bl2 : !pSSysCalendarItem.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSDELogicIdDirty() : !pSSysCalendarItem.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSDENameDirty() && !bl2 : !pSSysCalendarItem.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSDERIdDirty() : !pSSysCalendarItem.isPSDERIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSDERNameDirty() : !pSSysCalendarItem.isPSDERNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEToolbarId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSDEToolbarIdDirty() : !pSSysCalendarItem.isPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSDEViewBaseIdDirty() : !pSSysCalendarItem.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCalendarId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSSysCalendarIdDirty() : !pSSysCalendarItem.isPSSysCalendarIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSSysCalendarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCalendarItemId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSSysCalendarItemIdDirty() && !bl2 : !pSSysCalendarItem.isPSSysCalendarItemIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSSysCalendarItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarItemId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCalendarItemName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSSysCalendarItemNameDirty() && !bl2 : !pSSysCalendarItem.isPSSysCalendarItemNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSSysCalendarItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarItemName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARITEMNAME");
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
                string3 = "PSSYSCALENDARID";
                String string4 = this.checkFieldDupRule(this.getPSSysCalendarItemDEModel(), "PSSYSCALENDARITEMNAME", string3, pSSysCalendarItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSCALENDARITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCalendarName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSSysCalendarNameDirty() : !pSSysCalendarItem.isPSSysCalendarNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSSysCalendarName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSSysCssIdDirty() : !pSSysCalendarItem.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSSysImageIdDirty() : !pSSysCalendarItem.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSSysPFPluginIdDirty() : !pSSysCalendarItem.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isPSSysViewPanelIdDirty() : !pSSysCalendarItem.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemovePSDEActionId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isRemovePSDEActionIdDirty() : !pSSysCalendarItem.isRemovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getRemovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEActionId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemovePSDEOPPrivId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isRemovePSDEOPPrivIdDirty() : !pSSysCalendarItem.isRemovePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getRemovePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEOPPrivId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemovePSDEOPPrivName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isRemovePSDEOPPrivNameDirty() : !pSSysCalendarItem.isRemovePSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getRemovePSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEOPPrivName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEOPPRIVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tag2PSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isTag2PSDEFIdDirty() : !pSSysCalendarItem.isTag2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getTag2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tag2PSDEFId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAG2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tag2PSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isTag2PSDEFNameDirty() : !pSSysCalendarItem.isTag2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getTag2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tag2PSDEFName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAG2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isTagPSDEFIdDirty() : !pSSysCalendarItem.isTagPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getTagPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isTagPSDEFNameDirty() : !pSSysCalendarItem.isTagPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getTagPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isTextPSDEFIdDirty() : !pSSysCalendarItem.isTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TextPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isTextPSDEFNameDirty() : !pSSysCalendarItem.isTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipsPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isTipsPSDEFIdDirty() : !pSSysCalendarItem.isTipsPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getTipsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipsPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipsPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isTipsPSDEFNameDirty() : !pSSysCalendarItem.isTipsPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getTipsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipsPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TotalPSDEFId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isTotalPSDEFIdDirty() : !pSSysCalendarItem.isTotalPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getTotalPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TotalPSDEFId_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOTALPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TotalPSDEFName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isTotalPSDEFNameDirty() : !pSSysCalendarItem.isTotalPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getTotalPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TotalPSDEFName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOTALPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePSDEActionId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isUpdatePSDEActionIdDirty() : !pSSysCalendarItem.isUpdatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getUpdatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEActionId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UpdatePSDEOPPrivId(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isUpdatePSDEOPPrivIdDirty() : !pSSysCalendarItem.isUpdatePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getUpdatePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEOPPrivId_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UpdatePSDEOPPrivName(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isUpdatePSDEOPPrivNameDirty() : !pSSysCalendarItem.isUpdatePSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getUpdatePSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEOPPrivName_Default(pSSysCalendarItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEOPPRIVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isUserCatDirty() : !pSSysCalendarItem.isUserCatDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isUserTagDirty() : !pSSysCalendarItem.isUserTagDirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isUserTag2Dirty() : !pSSysCalendarItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isUserTag3Dirty() : !pSSysCalendarItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isUserTag4Dirty() : !pSSysCalendarItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysCalendarItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isValidFlagDirty() && !bl2 : !pSSysCalendarItem.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysCalendarItem.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysCalendarItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewActions(boolean bl, PSSysCalendarItem pSSysCalendarItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItem.isViewActionsDirty() : !pSSysCalendarItem.isViewActionsDirty()) {
            return null;
        }
        Integer n = pSSysCalendarItem.getViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewActions_Default(pSSysCalendarItem, bl2, bl3);
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

    protected void onSyncEntity(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        super.onSyncEntity(pSSysCalendarItem, bl);
    }

    protected void onSyncIndexEntities(PSSysCalendarItem pSSysCalendarItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysCalendarItem, bl);
    }

    public Object getDataContextValue(PSSysCalendarItem pSSysCalendarItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysCalendarItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysCalendar pSSysCalendar = pSSysCalendarItem.getPSSysCalendar();
        if (pSSysCalendar != null && pSSysCalendar.contains(string)) {
            return pSSysCalendar.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysCalendarItem pSSysCalendarItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysCalendarItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ASYNCPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AsyncPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASYNCPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AsyncPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKCOLORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKColorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKCOLORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKColorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Color_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEOPPrivName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GANTTPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GanttPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GANTTPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GanttPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMSTYLETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemStyleText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelPSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"NAVVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PKeyPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKEYPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PKeyPSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"TAG2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tag2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAG2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tag2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOTALPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TotalPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOTALPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TotalPSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewActions_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AsyncPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASYNCPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AsyncPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASYNCPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeginPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEGINPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeginPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEGINPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BKColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKCOLOR", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BKColorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKCOLORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BKColorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKCOLORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_Color_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLOR", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_CreatePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_EditMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EndPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENDPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EndPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENDPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GanttPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GANTTPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GanttPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GANTTPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ItemStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMSTYLE", iEntity, bl2, null, false, 16, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemStyleText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMSTYLETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("ITEMTYPE", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_LevelPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEVELPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LevelPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEVELPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PKeyPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKEYPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PKeyPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKEYPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysCalendarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_Tag2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAG2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Tag2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAG2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_TotalPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOTALPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TotalPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOTALPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysCalendarItem pSSysCalendarItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysCalendarItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        super.onUpdateParent(pSSysCalendarItem);
    }

    protected void onCopyDetails(PSSysCalendarItem pSSysCalendarItem, Object object) throws Exception {
        PSSysCalendarItem pSSysCalendarItem2 = new PSSysCalendarItem();
        pSSysCalendarItem2.set("PSSYSCALENDARITEMID", object);
        String string = DataObject.getStringValue((Object)pSSysCalendarItem.get("PSSYSCALENDARITEMID"));
        super.onCopyDetails(pSSysCalendarItem, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysCalendarItem pSSysCalendarItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSCALENDARITEM");
        if (!bl) {
            pSSysCalendarItem.setCreateDate(null);
            pSSysCalendarItem.setCreateMan(null);
            pSSysCalendarItem.setPSDEDSName(null);
            pSSysCalendarItem.setPSSysCalendarItemId(null);
            pSSysCalendarItem.setPSSysCssName(null);
            pSSysCalendarItem.setUpdateDate(null);
            pSSysCalendarItem.setUpdateMan(null);
            pSSysCalendarItem.setPSSysCalendarId(null);
            pSSysCalendarItem.setPSSysCalendarName(null);
            super.exportCurXmlModel(pSSysCalendarItem, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysCalendarItem pSSysCalendarItem, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysCalendarItemRV(pSSysCalendarItem, xmlNode);
        super.onExportRelatedXmlModel(pSSysCalendarItem, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysCalendarItemRV(PSSysCalendarItem pSSysCalendarItem, XmlNode xmlNode) throws Exception {
        PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarItemRV> arrayList = null;
        String string = pSSysCalendarItem.getPSSysCalendarItemId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysCalendarItemRVService.selectByPSSysCalendarItem(pSSysCalendarItem) : pSSysCalendarItemRVService.selectTempByPSSysCalendarItem(pSSysCalendarItem);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSCALENDARITEMRVS");
            xmlNode.addNode(xmlNode2);
            for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
                pSSysCalendarItemRVService.exportXmlModel(pSSysCalendarItemRV, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysCalendarItem pSSysCalendarItem, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSCALENDARITEMRVS");
        this.importRelatedXmlModel_PSSysCalendarItemRV(pSSysCalendarItem, xmlNode2);
        super.onImportRelatedXmlModel(pSSysCalendarItem, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysCalendarItemRV(PSSysCalendarItem pSSysCalendarItem, XmlNode xmlNode) throws Exception {
        PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysCalendarItem.getPSSysCalendarItemId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysCalendarItemRVService.removeByPSSysCalendarItem(pSSysCalendarItem);
        } else {
            pSSysCalendarItemRVService.removeTempByPSSysCalendarItem(pSSysCalendarItem);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysCalendarItemRV pSSysCalendarItemRV = new PSSysCalendarItemRV();
                pSSysCalendarItemRVService.fillParentInfo(pSSysCalendarItemRV, "DER1N", "DER1N_PSSYSCALENDARITEMRV_PSSYSCALENDARITEM_PSSYSCALENDARITEMID", pSSysCalendarItem.getPSSysCalendarItemId());
                pSSysCalendarItemRVService.importXmlModel(pSSysCalendarItemRV, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysCalendarItem pSSysCalendarItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysCalendarItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCALENDARID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSCALENDAR#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCALENDARID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCALENDARITEM_PSSYSCALENDAR_PSSYSCALENDARID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCALENDARID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCALENDARNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDAR", (boolean)true) == 0) {
            iEntity.set("PSSYSCALENDARID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSCALENDARID"};
    }

    @Override
    public String getModelV2Tag(PSSysCalendarItem pSSysCalendarItem) {
        if (!StringHelper.isNullOrEmpty((String)pSSysCalendarItem.getPSSysCalendarItemName())) {
            return pSSysCalendarItem.getPSSysCalendarItemName();
        }
        return super.getModelV2Tag(pSSysCalendarItem);
    }

    @Override
    public boolean setModelV2Tag(PSSysCalendarItem pSSysCalendarItem, String string) {
        pSSysCalendarItem.setPSSysCalendarItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSCALENDARITEMNAME", "");
        map.put("PSSYSCALENDARID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysCalendarItem pSSysCalendarItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysCalendarItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysCalendarItem, true);
        pSSysCalendarItem.set("PSSYSCALENDARITEMNAME", string);
        if (this.select(pSSysCalendarItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysCalendarItem, true);
        return super.getModelV2Entity(pSSysCalendarItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysCalendarItem pSSysCalendarItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysCalendarItem, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSYSCALENDARITEMRV_PSSYSCALENDARITEM_PSSYSCALENDARITEMID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysCalendarItem pSSysCalendarItem, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysCalendarItem, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysCalendarItem pSSysCalendarItem, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSCALENDARITEMRV_PSSYSCALENDARITEM_PSSYSCALENDARITEMID")) {
            PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSCALENDARITEM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSCALENDARITEMRV", (Object)pSSysCalendarItem.getPSSysCalendarItemId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSCALENDARITEM#%1$s", (Object)pSSysCalendarItem.getPSSysCalendarItemId());
                for (PSSysCalendarItemRV value : pSSysCalendarItemRVService.selectByPSSysCalendarItem(pSSysCalendarItem)) {
                    String valueScope = pSSysCalendarItemRVService.getModelV2ResScope(value);
                    if (StringHelper.compare((String)scope, (String)valueScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(value, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSSysCalendarItemRVService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssyscalendaritemrvname")) {
                            string = objectNode.get("pssyscalendaritemrvname").asText();
                        }
                        if (objectNode2.has("pssyscalendaritemrvname")) {
                            string2 = objectNode2.get("pssyscalendaritemrvname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode valueNode : arrayList) {
                    PSSysCalendarItemRV value = new PSSysCalendarItemRV();
                    PSModelV2Helper.fromJSONObject((IDataObject)value, valueNode, false);
                    output.add((JsonNode)pSSysCalendarItemRVService.exportModelV2(value, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysCalendarItem, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarItemRV> arrayList = pSSysCalendarItemRVService.selectByPSSysCalendarItem(pSSysCalendarItem);
        String string = StringHelper.format((String)"PSSYSCALENDARITEM#%1$s", (Object)pSSysCalendarItem.getPSSysCalendarItemId());
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
            String string2 = pSSysCalendarItemRVService.getModelV2ResScope(pSSysCalendarItemRV);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSysCalendarItemRVService.emptyModelV2(pSSysCalendarItemRV);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysCalendarItem.getPSSysCalendarItemId());
        pSSysCalendarItemRVService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSysCalendarItemRVService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSCALENDARITEMRV WHERE PSSYSCALENDARITEMID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysCalendarItem);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysCalendarItemRVService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysCalendarItem pSSysCalendarItem, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysCalendarItemRV pSSysCalendarItemRV = new PSSysCalendarItemRV();
        pSSysCalendarItemRV.set("PSSYSCALENDARITEMID", pSSysCalendarItem.getPSSysCalendarItemId());
        PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysCalendarItemRVService.getModelV2Entity(pSSysCalendarItemRV, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysCalendarItem, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysCalendarItem pSSysCalendarItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSysCalendarItemRVService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSysCalendarItemRV pSSysCalendarItemRV = new PSSysCalendarItemRV();
                pSSysCalendarItemRV.setPSSysCalendarId(pSSysCalendarItem.getPSSysCalendarId());
                pSSysCalendarItemRV.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
                pSSysCalendarItemRV.setPSSysCalendarItemName(pSSysCalendarItem.getPSSysCalendarItemName());
                pSSysCalendarItemRVService.compileModelV2(pSSysCalendarItemRV, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSysCalendarItemRV pSSysCalendarItemRV = new PSSysCalendarItemRV();
                    pSSysCalendarItemRV.setPSSysCalendarId(pSSysCalendarItem.getPSSysCalendarId());
                    pSSysCalendarItemRV.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
                    pSSysCalendarItemRV.setPSSysCalendarItemName(pSSysCalendarItem.getPSSysCalendarItemName());
                    pSSysCalendarItemRVService.compileModelV2(pSSysCalendarItemRV, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysCalendarItem, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysCalendarItem pSSysCalendarItem, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSCALENDARITEMRV_PSSYSCALENDARITEM_PSSYSCALENDARITEMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysCalendarItemRVs(pSSysCalendarItem, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysCalendarItem, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysCalendarItemRVs(PSSysCalendarItem pSSysCalendarItem, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSCALENDARITEMRV", true), (boolean)false) == 0) {
            PSSysCalendarItemRVService pSSysCalendarItemRVService = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
            PSSysCalendarItemRV pSSysCalendarItemRV = new PSSysCalendarItemRV();
            pSSysCalendarItemRV.setPSSysCalendarItemRVId(pSMOSFile.getPSModelId());
            if (!pSSysCalendarItemRVService.get(pSSysCalendarItemRV, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysCalendarItemRV.getPSSysCalendarItemId(), (String)pSSysCalendarItem.getPSSysCalendarItemId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysCalendarItemRVService.exportModelV2(pSSysCalendarItemRV);
            pSSysCalendarItemRV.reset();
            if (!pSSysCalendarItemRVService.setModelV2ResScope(pSSysCalendarItemRV, "PSSYSCALENDARITEM", pSSysCalendarItem.getPSSysCalendarItemId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysCalendarItemRVService.importModelV2(pSSysCalendarItemRV, objectNode);
            SessionFactoryManager.commit();
            return pSSysCalendarItemRVService.getFile(pSSysCalendarItemRV);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysCalendarItem pSSysCalendarItem, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysCalendarItemRVs(pSSysCalendarItem, list);
        super.onFillPasteHelps(pSSysCalendarItem, list);
    }

    protected void onFillPasteHelps_PSSysCalendarItemRVs(PSSysCalendarItem pSSysCalendarItem, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSCALENDARITEMRV");
        pSHelpSection.setSectionParam2("DER1N_PSSYSCALENDARITEMRV_PSSYSCALENDARITEM_PSSYSCALENDARITEMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u65e5\u5386\u90e8\u4ef6\u9879]\u7684[\u65e5\u5386\u9879\u5f15\u7528\u89c6\u56fe]");
        list.add(pSHelpSection);
    }
}
