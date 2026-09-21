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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
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

public abstract class PSSysCalendarServiceBase
extends PSCoreSysServiceBase<PSSysCalendar> {
    private static final Log log = LogFactory.getLog(PSSysCalendarServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURAPPGANTT = "CurAppGantt";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDEGANTT = "CurDEGantt";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSGANTT = "CurSysGantt";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysCalendarDEModel pSSysCalendarDEModel;
    private PSSysCalendarDAO pSSysCalendarDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService";
    }

    public PSSysCalendarDEModel getPSSysCalendarDEModel() {
        if (this.pSSysCalendarDEModel == null) {
            try {
                this.pSSysCalendarDEModel = (PSSysCalendarDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysCalendarDEModel();
    }

    public PSSysCalendarDAO getPSSysCalendarDAO() {
        if (this.pSSysCalendarDAO == null) {
            try {
                this.pSSysCalendarDAO = (PSSysCalendarDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysCalendarDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPGANTT, (boolean)true) == 0) {
            return this.fetchCurAppGantt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEGANTT, (boolean)true) == 0) {
            return this.fetchCurDEGantt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSGANTT, (boolean)true) == 0) {
            return this.fetchCurSysGantt(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPGANTT, (boolean)true) == 0) {
            return this.fetchTempCurAppGantt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEGANTT, (boolean)true) == 0) {
            return this.fetchTempCurDEGantt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSGANTT, (boolean)true) == 0) {
            return this.fetchTempCurSysGantt(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurAppGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPGANTT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAppGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPGANTT, true);
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

    public DBFetchResult fetchCurDEGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEGANTT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEGANTT, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, true);
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

    public DBFetchResult fetchCurSysGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSGANTT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSGANTT, true);
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

    protected void onFillParentInfo(PSSysCalendar pSSysCalendar, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSCODELIST_GROUPPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_GroupPSCodeList(pSSysCalendar, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlLogicGroup);
            } else {
                iService.get((IEntity)pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSSysCalendar, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlMsg);
            } else {
                iService.get((IEntity)pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSSysCalendar, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysCalendar, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSDEFIELD_GROUPPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_GroupPSDEF(pSSysCalendar, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSDEFIELD_GROUPTEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_GroupTextPSDEF(pSSysCalendar, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSDETOOLBAR_BATPSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEToolbar);
            } else {
                iService.get((IEntity)pSDEToolbar);
            }
            this.onFillParentInfo_BatPSDEToolbar(pSSysCalendar, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSDETOOLBAR_QUICKPSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEToolbar);
            } else {
                iService.get((IEntity)pSDEToolbar);
            }
            this.onFillParentInfo_QuickPSDEToolbar(pSSysCalendar, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSLANGUAGERES_EMPTYTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_EmptyTextPSLanRes(pSSysCalendar, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysCalendar, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSSysCalendar, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSSYSCSS_GROUPPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_GroupPSSysCss(pSSysCalendar, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSSysCalendar, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSSYSPFPLUGIN_GANTTPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_GanttPSSysPFPlugin(pSSysCalendar, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSSYSPFPLUGIN_GROUPPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_GroupPSSysPFPlugin(pSSysCalendar, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysCalendar, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysCalendar, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDAR_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewMsgGroup);
            } else {
                iService.get((IEntity)pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSSysCalendar, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysCalendar, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_GroupPSCodeList(PSSysCalendar pSSysCalendar, PSCodeList pSCodeList) throws Exception {
        pSSysCalendar.setGroupPSCodeListId(pSCodeList.getPSCodeListId());
        pSSysCalendar.setGroupPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSSysCalendar pSSysCalendar, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSSysCalendar.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSSysCalendar.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSCtrlMsg(PSSysCalendar pSSysCalendar, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSSysCalendar.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSSysCalendar.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_PSDE(PSSysCalendar pSSysCalendar, PSDataEntity pSDataEntity) throws Exception {
        pSSysCalendar.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysCalendar.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSModule() != null) {
            this.onFillParentInfo_PSModule(pSSysCalendar, pSDataEntity.getPSModule());
        }
    }

    protected void onFillParentInfo_GroupPSDEF(PSSysCalendar pSSysCalendar, PSDEField pSDEField) throws Exception {
        pSSysCalendar.setGroupPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendar.setGroupPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_GroupTextPSDEF(PSSysCalendar pSSysCalendar, PSDEField pSDEField) throws Exception {
        pSSysCalendar.setGroupTextPSDEFId(pSDEField.getPSDEFieldId());
        pSSysCalendar.setGroupTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_BatPSDEToolbar(PSSysCalendar pSSysCalendar, PSDEToolbar pSDEToolbar) throws Exception {
        pSSysCalendar.setBatPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSSysCalendar.setBatPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_QuickPSDEToolbar(PSSysCalendar pSSysCalendar, PSDEToolbar pSDEToolbar) throws Exception {
        pSSysCalendar.setQuickPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSSysCalendar.setQuickPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_EmptyTextPSLanRes(PSSysCalendar pSSysCalendar, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysCalendar.setEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysCalendar.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSModule(PSSysCalendar pSSysCalendar, PSModule pSModule) throws Exception {
        pSSysCalendar.setPSModuleId(pSModule.getPSModuleId());
        pSSysCalendar.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysApp(PSSysCalendar pSSysCalendar, PSSysApp pSSysApp) throws Exception {
        pSSysCalendar.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSSysCalendar.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_GroupPSSysCss(PSSysCalendar pSSysCalendar, PSSysCss pSSysCss) throws Exception {
        pSSysCalendar.setGroupPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysCalendar.setGroupPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysCss(PSSysCalendar pSSysCalendar, PSSysCss pSSysCss) throws Exception {
        pSSysCalendar.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysCalendar.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_GanttPSSysPFPlugin(PSSysCalendar pSSysCalendar, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysCalendar.setGanttPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysCalendar.setGanttPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_GroupPSSysPFPlugin(PSSysCalendar pSSysCalendar, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysCalendar.setGroupPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysCalendar.setGroupPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysCalendar pSSysCalendar, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysCalendar.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysCalendar.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysCalendar pSSysCalendar, PSSystem pSSystem) throws Exception {
        pSSysCalendar.setPSSystemId(pSSystem.getPSSystemId());
        pSSysCalendar.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSSysCalendar pSSysCalendar, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSSysCalendar.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSSysCalendar.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
        if (bl) {
            if (pSSysCalendar.getCalendarStyle() == null) {
                pSSysCalendar.setCalendarStyle((String)this.getDefaultValue(this.getWebContext(), "", "MONTH", 25));
            }
            if (pSSysCalendar.getGanttFlag() == null) {
                pSSysCalendar.setGanttFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysCalendar, bl);
        this.onFillEntityFullInfo_GroupPSCodeList(pSSysCalendar, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSSysCalendar, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSSysCalendar, bl);
        this.onFillEntityFullInfo_PSDE(pSSysCalendar, bl);
        this.onFillEntityFullInfo_GroupPSDEF(pSSysCalendar, bl);
        this.onFillEntityFullInfo_GroupTextPSDEF(pSSysCalendar, bl);
        this.onFillEntityFullInfo_BatPSDEToolbar(pSSysCalendar, bl);
        this.onFillEntityFullInfo_QuickPSDEToolbar(pSSysCalendar, bl);
        this.onFillEntityFullInfo_EmptyTextPSLanRes(pSSysCalendar, bl);
        this.onFillEntityFullInfo_PSModule(pSSysCalendar, bl);
        this.onFillEntityFullInfo_PSSysApp(pSSysCalendar, bl);
        this.onFillEntityFullInfo_GroupPSSysCss(pSSysCalendar, bl);
        this.onFillEntityFullInfo_PSSysCss(pSSysCalendar, bl);
        this.onFillEntityFullInfo_GanttPSSysPFPlugin(pSSysCalendar, bl);
        this.onFillEntityFullInfo_GroupPSSysPFPlugin(pSSysCalendar, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysCalendar, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysCalendar, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSSysCalendar, bl);
    }

    protected void onFillEntityFullInfo_GroupPSCodeList(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
        if (pSSysCalendar.isPSDEIdDirty()) {
            if (pSSysCalendar.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSSysCalendar.getPSDEId() == null || pSSysCalendar.getPSDEName() == null) {
                    pSDataEntity = pSSysCalendar.getPSDE();
                    pSSysCalendar.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSSysCalendar.getPSDE()).getPSModuleId(), (Object)pSSysCalendar.getPSModuleId()) != 0L) {
                    pSSysCalendar.setPSModuleId(pSDataEntity.getPSModuleId());
                    this.onFillEntityFullInfo_PSModule(pSSysCalendar, bl);
                }
            } else {
                pSSysCalendar.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupPSDEF(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
        if (pSSysCalendar.isGroupPSDEFIdDirty()) {
            if (pSSysCalendar.getGroupPSDEFId() != null) {
                if (pSSysCalendar.getGroupPSDEFId() == null || pSSysCalendar.getGroupPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendar.getGroupPSDEF();
                    pSSysCalendar.setGroupPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendar.setGroupPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupTextPSDEF(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
        if (pSSysCalendar.isGroupTextPSDEFIdDirty()) {
            if (pSSysCalendar.getGroupTextPSDEFId() != null) {
                if (pSSysCalendar.getGroupTextPSDEFId() == null || pSSysCalendar.getGroupTextPSDEFName() == null) {
                    PSDEField pSDEField = pSSysCalendar.getGroupTextPSDEF();
                    pSSysCalendar.setGroupTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysCalendar.setGroupTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_BatPSDEToolbar(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_QuickPSDEToolbar(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmptyTextPSLanRes(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
        if (pSSysCalendar.isEmptyTextPSLanResIdDirty()) {
            if (pSSysCalendar.getEmptyTextPSLanResId() != null) {
                if (pSSysCalendar.getEmptyTextPSLanResId() == null || pSSysCalendar.getEmptyTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysCalendar.getEmptyTextPSLanRes();
                    pSSysCalendar.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysCalendar.setEmptyTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSSysCss(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GanttPSSysPFPlugin(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSSysPFPlugin(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
        if (pSSysCalendar.isPSSystemIdDirty()) {
            if (pSSysCalendar.getPSSystemId() != null) {
                if (pSSysCalendar.getPSSystemId() == null || pSSysCalendar.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysCalendar.getPSSystem();
                    pSSysCalendar.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysCalendar.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysCalendar, bl);
    }

    public ArrayList<PSSysCalendar> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByGroupPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByGroupPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendar> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLMSGID", (Object)pSCtrlMsgBase.getPSCtrlMsgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlMsgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlMsgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendar> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendar> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendar> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByGroupTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByGroupTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPTEXTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupTextPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupTextPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendar> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByBatPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByBatPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BATPSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBatPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBatPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendar> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByQuickPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByQuickPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("QUICKPSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByQuickPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByQuickPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendar> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendar> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendar> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendar> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByGroupPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByGroupPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendar> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendar> selectByGanttPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByGanttPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByGanttPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByGanttPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByGanttPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GANTTPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGanttPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGanttPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendar> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByGroupPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByGroupPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendar> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSSysCalendar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSSysCalendar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWMSGGROUPID", (Object)pSViewMsgGroupBase.getPSViewMsgGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewMsgGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewMsgGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSCODELIST_GROUPPSCODELISTID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSCodeList(pSCodeList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setGroupPSCodeListId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByGroupPSCodeList(pSCodeList2);
                PSSysCalendarServiceBase.this.internalRemoveByGroupPSCodeList(pSCodeList2);
                PSSysCalendarServiceBase.this.onAfterRemoveByGroupPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSCodeList(pSCodeList);
        this.onBeforeRemoveByGroupPSCodeList(pSCodeList, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByGroupPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setPSCtrlLogicGroupId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSSysCalendarServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSSysCalendarServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setPSCtrlMsgId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSSysCalendarServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSSysCalendarServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setPSDEId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysCalendarServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysCalendarServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSDEFIELD_GROUPPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSDEF(pSDEField);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setGroupPSDEFId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByGroupPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByGroupPSDEF(pSDEField2);
                PSSysCalendarServiceBase.this.internalRemoveByGroupPSDEF(pSDEField2);
                PSSysCalendarServiceBase.this.onAfterRemoveByGroupPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSDEF(pSDEField);
        this.onBeforeRemoveByGroupPSDEF(pSDEField, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByGroupPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSDEFIELD_GROUPTEXTPSDEFID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupTextPSDEF(pSDEField);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setGroupTextPSDEFId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByGroupTextPSDEF(pSDEField2);
                PSSysCalendarServiceBase.this.internalRemoveByGroupTextPSDEF(pSDEField2);
                PSSysCalendarServiceBase.this.onAfterRemoveByGroupTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupTextPSDEF(pSDEField);
        this.onBeforeRemoveByGroupTextPSDEF(pSDEField, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByGroupTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByGroupTextPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupTextPSDEF(PSDEField pSDEField, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSDETOOLBAR_BATPSDETOOLBARID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setBatPSDEToolbarId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByBatPSDEToolbar(pSDEToolbar2);
                PSSysCalendarServiceBase.this.internalRemoveByBatPSDEToolbar(pSDEToolbar2);
                PSSysCalendarServiceBase.this.onAfterRemoveByBatPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByBatPSDEToolbar(pSDEToolbar, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByBatPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSDETOOLBAR_QUICKPSDETOOLBARID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setQuickPSDEToolbarId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByQuickPSDEToolbar(pSDEToolbar2);
                PSSysCalendarServiceBase.this.internalRemoveByQuickPSDEToolbar(pSDEToolbar2);
                PSSysCalendarServiceBase.this.onAfterRemoveByQuickPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByQuickPSDEToolbar(pSDEToolbar, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByQuickPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSLANGUAGERES_EMPTYTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setEmptyTextPSLanResId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSSysCalendarServiceBase.this.internalRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSSysCalendarServiceBase.this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSModule(pSModule);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setPSModuleId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysCalendarServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysCalendarServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setPSSysAppId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSSysCalendarServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSSysCalendarServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSSYSCSS_GROUPPSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSSysCss(pSSysCss);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setGroupPSSysCssId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByGroupPSSysCss(pSSysCss2);
                PSSysCalendarServiceBase.this.internalRemoveByGroupPSSysCss(pSSysCss2);
                PSSysCalendarServiceBase.this.onAfterRemoveByGroupPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSSysCss(pSSysCss);
        this.onBeforeRemoveByGroupPSSysCss(pSSysCss, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByGroupPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setPSSysCssId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSSysCalendarServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSSysCalendarServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByGanttPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGanttPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSSYSPFPLUGIN_GANTTPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetGanttPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGanttPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setGanttPSSysPFPluginId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByGanttPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByGanttPSSysPFPlugin(pSSysPFPlugin2);
                PSSysCalendarServiceBase.this.internalRemoveByGanttPSSysPFPlugin(pSSysPFPlugin2);
                PSSysCalendarServiceBase.this.onAfterRemoveByGanttPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByGanttPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByGanttPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGanttPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByGanttPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByGanttPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByGanttPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByGanttPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGanttPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSSYSPFPLUGIN_GROUPPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setGroupPSSysPFPluginId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
                PSSysCalendarServiceBase.this.internalRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
                PSSysCalendarServiceBase.this.onAfterRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByGroupPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByGroupPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setPSSysPFPluginId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysCalendarServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysCalendarServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setPSSystemId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysCalendarServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysCalendarServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDAR_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSSYSCALENDAR", iDataEntityModel.getDataInfo((IEntity)pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            PSSysCalendar pSSysCalendar2 = (PSSysCalendar)this.getDEModel().createEntity();
            pSSysCalendar2.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
            pSSysCalendar2.setPSViewMsgGroupId(null);
            this.update(pSSysCalendar2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSSysCalendarServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSSysCalendarServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysCalendar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSSysCalendar pSSysCalendar : arrayList) {
            this.remove((IEntity)pSSysCalendar);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSSysCalendar> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysCalendar pSSysCalendar) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCalendar(pSSysCalendar);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCalendar(pSSysCalendar);
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).removeByPSSysCalendar(pSSysCalendar);
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCalendar(pSSysCalendar);
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).removeByPSSysCalendar(pSSysCalendar);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCalendar(pSSysCalendar);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCalendar(pSSysCalendar);
        super.onBeforeRemove(pSSysCalendar);
    }

    protected void onBeforeRemoveTemp(PSSysCalendar pSSysCalendar) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).removeTempByPSSysCalendar(pSSysCalendar);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).removeTempByPSSysCalendar(pSSysCalendar);
        super.onBeforeRemoveTemp((IEntity)pSSysCalendar);
    }

    protected void getRelatedDataTempMajor(PSSysCalendar pSSysCalendar) throws Exception {
        this.getRelatedDataTempMajor_PSSysCalendarItem(pSSysCalendar);
        this.getRelatedDataTempMajor_PSSysCalendarLogic(pSSysCalendar);
        super.getRelatedDataTempMajor((IEntity)pSSysCalendar);
    }

    protected void getRelatedDataTempMajor_PSSysCalendarItem(PSSysCalendar pSSysCalendar) throws Exception {
        PSSysCalendarItemService pSSysCalendarItemService = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarItem> arrayList = null;
        String string = pSSysCalendar.getPSSysCalendarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysCalendarItemService.selectByPSSysCalendar(pSSysCalendar) : pSSysCalendarItemService.selectTempByPSSysCalendar(pSSysCalendar);
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            pSSysCalendarItemService.getTempMajor(pSSysCalendarItem);
        }
    }

    protected void getRelatedDataTempMajor_PSSysCalendarLogic(PSSysCalendar pSSysCalendar) throws Exception {
        PSSysCalendarLogicService pSSysCalendarLogicService = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarLogic> arrayList = null;
        String string = pSSysCalendar.getPSSysCalendarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysCalendarLogicService.selectByPSSysCalendar(pSSysCalendar) : pSSysCalendarLogicService.selectTempByPSSysCalendar(pSSysCalendar);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            pSSysCalendarLogicService.getTempMajor(pSSysCalendarLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysCalendar pSSysCalendar, PSSysCalendar pSSysCalendar2) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.updateRelatedDataTempMajor_removePSSysCalendarLogic(pSSysCalendar, pSSysCalendar2);
        ArrayList<PSSysCalendarItem> arrayList2 = this.updateRelatedDataTempMajor_removePSSysCalendarItem(pSSysCalendar, pSSysCalendar2);
        this.updateRelatedDataTempMajor_updatePSSysCalendarItem(pSSysCalendar, pSSysCalendar2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSSysCalendarLogic(pSSysCalendar, pSSysCalendar2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSysCalendar, (IEntity)pSSysCalendar2);
    }

    protected ArrayList<PSSysCalendarItem> updateRelatedDataTempMajor_removePSSysCalendarItem(PSSysCalendar pSSysCalendar, PSSysCalendar pSSysCalendar2) throws Exception {
        PSSysCalendarItemService pSSysCalendarItemService = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarItem> arrayList = pSSysCalendarItemService.selectTempByPSSysCalendar(pSSysCalendar);
        ArrayList<PSSysCalendarItem> arrayList2 = pSSysCalendarItemService.selectByPSSysCalendar(pSSysCalendar2);
        HashMap<String, PSSysCalendarItem> hashMap = new HashMap<String, PSSysCalendarItem>();
        for (PSSysCalendarItem pSSysCalendarItem : arrayList2) {
            hashMap.put(pSSysCalendarItem.getPSSysCalendarItemId(), pSSysCalendarItem);
        }
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            Object object = pSSysCalendarItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysCalendarItem pSSysCalendarItem : hashMap.values()) {
            pSSysCalendarItemService.remove((IEntity)pSSysCalendarItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysCalendarItem(PSSysCalendar pSSysCalendar, PSSysCalendar pSSysCalendar2, ArrayList<PSSysCalendarItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysCalendarItemService pSSysCalendarItemService = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
            pSSysCalendarItemService.updateTempMajor(pSSysCalendarItem);
        }
    }

    protected ArrayList<PSSysCalendarLogic> updateRelatedDataTempMajor_removePSSysCalendarLogic(PSSysCalendar pSSysCalendar, PSSysCalendar pSSysCalendar2) throws Exception {
        PSSysCalendarLogicService pSSysCalendarLogicService = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarLogic> arrayList = pSSysCalendarLogicService.selectTempByPSSysCalendar(pSSysCalendar);
        ArrayList<PSSysCalendarLogic> arrayList2 = pSSysCalendarLogicService.selectByPSSysCalendar(pSSysCalendar2);
        HashMap<String, PSSysCalendarLogic> hashMap = new HashMap<String, PSSysCalendarLogic>();
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList2) {
            hashMap.put(pSSysCalendarLogic.getPSSysCalendarLogicId(), pSSysCalendarLogic);
        }
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            Object object = pSSysCalendarLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysCalendarLogic pSSysCalendarLogic : hashMap.values()) {
            pSSysCalendarLogicService.remove((IEntity)pSSysCalendarLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysCalendarLogic(PSSysCalendar pSSysCalendar, PSSysCalendar pSSysCalendar2, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysCalendarLogicService pSSysCalendarLogicService = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            pSSysCalendarLogicService.updateTempMajor(pSSysCalendarLogic);
        }
    }

    protected void replaceParentInfo(PSSysCalendar pSSysCalendar, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysCalendar, cloneSession);
        if (pSSysCalendar.getGroupPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSysCalendar.getGroupPSCodeListId())) != null) {
            this.onFillParentInfo_GroupPSCodeList(pSSysCalendar, (PSCodeList)iEntity);
        }
        if (pSSysCalendar.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSSysCalendar.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSSysCalendar, (PSCtrlLogicGroup)iEntity);
        }
        if (pSSysCalendar.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSSysCalendar.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSSysCalendar, (PSCtrlMsg)iEntity);
        }
        if (pSSysCalendar.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysCalendar.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysCalendar, (PSDataEntity)iEntity);
        }
        if (pSSysCalendar.getGroupPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendar.getGroupPSDEFId())) != null) {
            this.onFillParentInfo_GroupPSDEF(pSSysCalendar, (PSDEField)iEntity);
        }
        if (pSSysCalendar.getGroupTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysCalendar.getGroupTextPSDEFId())) != null) {
            this.onFillParentInfo_GroupTextPSDEF(pSSysCalendar, (PSDEField)iEntity);
        }
        if (pSSysCalendar.getBatPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSSysCalendar.getBatPSDEToolbarId())) != null) {
            this.onFillParentInfo_BatPSDEToolbar(pSSysCalendar, (PSDEToolbar)iEntity);
        }
        if (pSSysCalendar.getQuickPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSSysCalendar.getQuickPSDEToolbarId())) != null) {
            this.onFillParentInfo_QuickPSDEToolbar(pSSysCalendar, (PSDEToolbar)iEntity);
        }
        if (pSSysCalendar.getEmptyTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysCalendar.getEmptyTextPSLanResId())) != null) {
            this.onFillParentInfo_EmptyTextPSLanRes(pSSysCalendar, (PSLanguageRes)iEntity);
        }
        if (pSSysCalendar.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysCalendar.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysCalendar, (PSModule)iEntity);
        }
        if (pSSysCalendar.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSysCalendar.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSSysCalendar, (PSSysApp)iEntity);
        }
        if (pSSysCalendar.getGroupPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysCalendar.getGroupPSSysCssId())) != null) {
            this.onFillParentInfo_GroupPSSysCss(pSSysCalendar, (PSSysCss)iEntity);
        }
        if (pSSysCalendar.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysCalendar.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSSysCalendar, (PSSysCss)iEntity);
        }
        if (pSSysCalendar.getGanttPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysCalendar.getGanttPSSysPFPluginId())) != null) {
            this.onFillParentInfo_GanttPSSysPFPlugin(pSSysCalendar, (PSSysPFPlugin)iEntity);
        }
        if (pSSysCalendar.getGroupPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysCalendar.getGroupPSSysPFPluginId())) != null) {
            this.onFillParentInfo_GroupPSSysPFPlugin(pSSysCalendar, (PSSysPFPlugin)iEntity);
        }
        if (pSSysCalendar.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysCalendar.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysCalendar, (PSSysPFPlugin)iEntity);
        }
        if (pSSysCalendar.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysCalendar.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysCalendar, (PSSystem)iEntity);
        }
        if (pSSysCalendar.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSSysCalendar.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSSysCalendar, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysCalendar, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BatPSDEToolbarId(bl, pSSysCalendar, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BusyIndicator(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CalendarStyle(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CalendarTag(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CalendarTag2(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyText(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResName(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableEdit(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GanttFlag(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GanttPSSysPFPluginId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GanttStyle(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupHeight(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupLayout(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMode(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSCodeListId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFName(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSSysCssId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSSysPFPluginId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupStyle(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTextPSDEFId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTextPSDEFName(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupWidth(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewHeight(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxHeight(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxWidth(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinHeight(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinWidth(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewPos(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewShowMode(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewWidth(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarName(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QuickPSDEToolbarId(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysAppFlag(bl, pSSysCalendar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysCalendar, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BatPSDEToolbarId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isBatPSDEToolbarIdDirty() : !pSSysCalendar.isBatPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getBatPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BatPSDEToolbarId_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BATPSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isBusyIndicatorDirty() : !pSSysCalendar.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSSysCalendar.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BUSYINDICATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CalendarStyle(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isCalendarStyleDirty() && !bl2 : !pSSysCalendar.isCalendarStyleDirty()) {
            return null;
        }
        String string = pSSysCalendar.getCalendarStyle();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALENDARSTYLE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CalendarStyle_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALENDARSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CalendarTag(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isCalendarTagDirty() : !pSSysCalendar.isCalendarTagDirty()) {
            return null;
        }
        String string = pSSysCalendar.getCalendarTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CalendarTag_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALENDARTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CalendarTag2(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isCalendarTag2Dirty() : !pSSysCalendar.isCalendarTag2Dirty()) {
            return null;
        }
        String string = pSSysCalendar.getCalendarTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CalendarTag2_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALENDARTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isCodeNameDirty() && !bl2 : !pSSysCalendar.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysCalendar.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysCalendar, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysCalendarDEModel(), "CODENAME", string3, pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyText(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isEmptyTextDirty() : !pSSysCalendar.isEmptyTextDirty()) {
            return null;
        }
        String string = pSSysCalendar.getEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyText_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyTextPSLanResId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isEmptyTextPSLanResIdDirty() : !pSSysCalendar.isEmptyTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getEmptyTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResId_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyTextPSLanResName(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isEmptyTextPSLanResNameDirty() : !pSSysCalendar.isEmptyTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysCalendar.getEmptyTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResName_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableEdit(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isEnableEditDirty() : !pSSysCalendar.isEnableEditDirty()) {
            return null;
        }
        Integer n = pSSysCalendar.getEnableEdit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableEdit_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEEDIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GanttFlag(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGanttFlagDirty() : !pSSysCalendar.isGanttFlagDirty()) {
            return null;
        }
        Integer n = pSSysCalendar.getGanttFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GanttFlag_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GANTTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GanttPSSysPFPluginId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGanttPSSysPFPluginIdDirty() : !pSSysCalendar.isGanttPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGanttPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GanttPSSysPFPluginId_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_GanttStyle(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGanttStyleDirty() : !pSSysCalendar.isGanttStyleDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGanttStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GanttStyle_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GANTTSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupHeight(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupHeightDirty() : !pSSysCalendar.isGroupHeightDirty()) {
            return null;
        }
        Integer n = pSSysCalendar.getGroupHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupHeight_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupLayout(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupLayoutDirty() : !pSSysCalendar.isGroupLayoutDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGroupLayout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupLayout_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPLAYOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMode(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupModeDirty() : !pSSysCalendar.isGroupModeDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGroupMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMode_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSCodeListId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupPSCodeListIdDirty() : !pSSysCalendar.isGroupPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGroupPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSCodeListId_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEFId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupPSDEFIdDirty() : !pSSysCalendar.isGroupPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGroupPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFId_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupPSDEFName(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupPSDEFNameDirty() : !pSSysCalendar.isGroupPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGroupPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFName_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupPSSysCssId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupPSSysCssIdDirty() : !pSSysCalendar.isGroupPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGroupPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSSysCssId_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSSysPFPluginId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupPSSysPFPluginIdDirty() : !pSSysCalendar.isGroupPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGroupPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSSysPFPluginId_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupStyle(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupStyleDirty() : !pSSysCalendar.isGroupStyleDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGroupStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupStyle_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTextPSDEFId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupTextPSDEFIdDirty() : !pSSysCalendar.isGroupTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGroupTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTextPSDEFId_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTEXTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTextPSDEFName(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupTextPSDEFNameDirty() : !pSSysCalendar.isGroupTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysCalendar.getGroupTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTextPSDEFName_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTEXTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupWidth(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isGroupWidthDirty() : !pSSysCalendar.isGroupWidthDirty()) {
            return null;
        }
        Integer n = pSSysCalendar.getGroupWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupWidth_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isLockFlagDirty() : !pSSysCalendar.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysCalendar.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isLogicNameDirty() : !pSSysCalendar.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysCalendar.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isMemoDirty() : !pSSysCalendar.isMemoDirty()) {
            return null;
        }
        String string = pSSysCalendar.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewHeight(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isNavViewHeightDirty() : !pSSysCalendar.isNavViewHeightDirty()) {
            return null;
        }
        Double d = pSSysCalendar.getNavViewHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewHeight_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMaxHeight(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isNavViewMaxHeightDirty() : !pSSysCalendar.isNavViewMaxHeightDirty()) {
            return null;
        }
        Double d = pSSysCalendar.getNavViewMaxHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxHeight_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMAXHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMaxWidth(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isNavViewMaxWidthDirty() : !pSSysCalendar.isNavViewMaxWidthDirty()) {
            return null;
        }
        Double d = pSSysCalendar.getNavViewMaxWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxWidth_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMAXWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMinHeight(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isNavViewMinHeightDirty() : !pSSysCalendar.isNavViewMinHeightDirty()) {
            return null;
        }
        Double d = pSSysCalendar.getNavViewMinHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinHeight_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMINHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMinWidth(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isNavViewMinWidthDirty() : !pSSysCalendar.isNavViewMinWidthDirty()) {
            return null;
        }
        Double d = pSSysCalendar.getNavViewMinWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinWidth_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMINWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewPos(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isNavViewPosDirty() : !pSSysCalendar.isNavViewPosDirty()) {
            return null;
        }
        String string = pSSysCalendar.getNavViewPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewPos_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewShowMode(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isNavViewShowModeDirty() : !pSSysCalendar.isNavViewShowModeDirty()) {
            return null;
        }
        Integer n = pSSysCalendar.getNavViewShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewShowMode_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWSHOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewWidth(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isNavViewWidthDirty() : !pSSysCalendar.isNavViewWidthDirty()) {
            return null;
        }
        Double d = pSSysCalendar.getNavViewWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewWidth_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSCtrlLogicGroupIdDirty() : !pSSysCalendar.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSCtrlMsgIdDirty() : !pSSysCalendar.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSDEIdDirty() && !bl2 : !pSSysCalendar.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSDENameDirty() && !bl2 : !pSSysCalendar.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSModuleIdDirty() : !pSSysCalendar.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSSysAppIdDirty() : !pSSysCalendar.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCalendarId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSSysCalendarIdDirty() && !bl2 : !pSSysCalendar.isPSSysCalendarIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSSysCalendarId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarId_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCalendarName(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSSysCalendarNameDirty() && !bl2 : !pSSysCalendar.isPSSysCalendarNameDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSSysCalendarName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarName_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSSysCssIdDirty() : !pSSysCalendar.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSSysPFPluginIdDirty() : !pSSysCalendar.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSSystemIdDirty() && !bl2 : !pSSysCalendar.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSSystemNameDirty() : !pSSysCalendar.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysCalendar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isPSViewMsgGroupIdDirty() : !pSSysCalendar.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QuickPSDEToolbarId(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isQuickPSDEToolbarIdDirty() : !pSSysCalendar.isQuickPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSSysCalendar.getQuickPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QuickPSDEToolbarId_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUICKPSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysAppFlag(boolean bl, PSSysCalendar pSSysCalendar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendar.isSysAppFlagDirty() : !pSSysCalendar.isSysAppFlagDirty()) {
            return null;
        }
        Integer n = pSSysCalendar.getSysAppFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysAppFlag_Default((IEntity)pSSysCalendar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSAPPFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysCalendar, bl);
    }

    protected void onSyncIndexEntities(PSSysCalendar pSSysCalendar, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysCalendar, bl);
    }

    public Object getDataContextValue(PSSysCalendar pSSysCalendar, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysCalendar, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportRelatedModel(PSSysCalendar pSSysCalendar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSSysCalendarLogic_PSSysCalendar(pSSysCalendar, arrayList, n);
        super.onExportRelatedModel((IEntity)pSSysCalendar, arrayList, n);
    }

    protected void onExportRelatedModel_PSSysCalendarLogic_PSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSSysCalendarLogicService pSSysCalendarLogicService = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarLogic> arrayList2 = pSSysCalendarLogicService.selectByPSSysCalendar(pSSysCalendar);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"2ad63b4d51cf886ec497d46c562375cc");
            jSONObject.put("srfdename", (Object)"PSSYSCALENDARLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDAR_PSSYSCALENDARID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSSysCalendar, (String)"PSSYSCALENDARID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSSysCalendarLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSSysCalendarLogicService.exportModel(pSSysCalendarLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSSysCalendar pSSysCalendar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysCalendar, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BATPSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BatPSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BATPSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BatPSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CALENDARSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CalendarStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CALENDARTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CalendarTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CALENDARTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CalendarTag2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"EMPTYTEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEEDIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableEdit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GANTTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GanttFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GANTTPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GanttPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GANTTPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GanttPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GANTTSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GanttStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPLAYOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupLayout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTextPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTEXTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTextPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupWidth_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"NAVVIEWHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMAXHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMaxHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMAXWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMaxWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMINHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMinHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMINWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMinWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWSHOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewShowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKPSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickPSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKPSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickPSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSAPPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysAppFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BatPSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BATPSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BatPSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BATPSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CalendarStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CALENDARSTYLE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CalendarTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CALENDARTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CalendarTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CALENDARTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_EnableEdit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GanttFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_GanttStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GANTTSTYLE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupLayout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPLAYOUT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_GroupPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTextPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTEXTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTextPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTEXTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_NavViewHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMaxHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMaxWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMinHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMinWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWPOS", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewShowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSCtrlMsgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSViewMsgGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QuickPSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUICKPSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QuickPSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUICKPSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysAppFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysCalendar pSSysCalendar) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysCalendar)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysCalendar pSSysCalendar) throws Exception {
        super.onUpdateParent((IEntity)pSSysCalendar);
    }

    protected void onCopyDetails(PSSysCalendar pSSysCalendar, Object object) throws Exception {
        PSSysCalendar pSSysCalendar2 = new PSSysCalendar();
        pSSysCalendar2.set("PSSYSCALENDARID", object);
        String string = DataObject.getStringValue((Object)pSSysCalendar.get("PSSYSCALENDARID"));
        super.onCopyDetails((IEntity)pSSysCalendar, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysCalendar pSSysCalendar, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSCALENDAR");
        if (!bl) {
            pSSysCalendar.setCreateDate(null);
            pSSysCalendar.setCreateMan(null);
            pSSysCalendar.setPSSysCalendarId(null);
            pSSysCalendar.setUpdateDate(null);
            pSSysCalendar.setUpdateMan(null);
            super.exportCurXmlModel(pSSysCalendar, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysCalendar pSSysCalendar, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysCalendarItem(pSSysCalendar, xmlNode);
        this.exportRelatedXmlModel_PSSysCalendarLogic(pSSysCalendar, xmlNode);
        super.onExportRelatedXmlModel(pSSysCalendar, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysCalendarItem(PSSysCalendar pSSysCalendar, XmlNode xmlNode) throws Exception {
        PSSysCalendarItemService pSSysCalendarItemService = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarItem> arrayList = null;
        String string = pSSysCalendar.getPSSysCalendarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysCalendarItemService.selectByPSSysCalendar(pSSysCalendar, "ORDER BY ORDERVALUE ASC") : pSSysCalendarItemService.selectTempByPSSysCalendar(pSSysCalendar, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSCALENDARITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSSysCalendarItem pSSysCalendarItem : arrayList) {
                pSSysCalendarItem.set("ORDERVALUE", null);
                pSSysCalendarItemService.exportXmlModel(pSSysCalendarItem, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSSysCalendarLogic(PSSysCalendar pSSysCalendar, XmlNode xmlNode) throws Exception {
        PSSysCalendarLogicService pSSysCalendarLogicService = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysCalendarLogic> arrayList = null;
        String string = pSSysCalendar.getPSSysCalendarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysCalendarLogicService.selectByPSSysCalendar(pSSysCalendar, "ORDER BY ORDERVALUE ASC") : pSSysCalendarLogicService.selectTempByPSSysCalendar(pSSysCalendar, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSCALENDARLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
                pSSysCalendarLogic.set("ORDERVALUE", null);
                pSSysCalendarLogicService.exportXmlModel(pSSysCalendarLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysCalendar pSSysCalendar, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSCALENDARITEMS");
        this.importRelatedXmlModel_PSSysCalendarItem(pSSysCalendar, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSSYSCALENDARLOGICS");
        this.importRelatedXmlModel_PSSysCalendarLogic(pSSysCalendar, xmlNode3);
        super.onImportRelatedXmlModel(pSSysCalendar, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysCalendarItem(PSSysCalendar pSSysCalendar, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysCalendarItemService pSSysCalendarItemService = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysCalendar.getPSSysCalendarId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysCalendarItemService.removeByPSSysCalendar(pSSysCalendar);
        } else {
            pSSysCalendarItemService.removeTempByPSSysCalendar(pSSysCalendar);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysCalendarItem pSSysCalendarItem = new PSSysCalendarItem();
                pSSysCalendarItem.setOrderValue(n);
                n += 100;
                pSSysCalendarItemService.fillParentInfo((IEntity)pSSysCalendarItem, "DER1N", "DER1N_PSSYSCALENDARITEM_PSSYSCALENDAR_PSSYSCALENDARID", pSSysCalendar.getPSSysCalendarId());
                pSSysCalendarItemService.importXmlModel(pSSysCalendarItem, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSSysCalendarLogic(PSSysCalendar pSSysCalendar, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysCalendarLogicService pSSysCalendarLogicService = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysCalendar.getPSSysCalendarId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysCalendarLogicService.removeByPSSysCalendar(pSSysCalendar);
        } else {
            pSSysCalendarLogicService.removeTempByPSSysCalendar(pSSysCalendar);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysCalendarLogic pSSysCalendarLogic = new PSSysCalendarLogic();
                pSSysCalendarLogic.setOrderValue(n);
                n += 100;
                pSSysCalendarLogicService.fillParentInfo((IEntity)pSSysCalendarLogic, "DER1N", "DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDAR_PSSYSCALENDARID", pSSysCalendar.getPSSysCalendarId());
                pSSysCalendarLogicService.importXmlModel(pSSysCalendarLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysCalendar pSSysCalendar, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysCalendar, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCALENDAR_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCALENDAR_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCALENDAR_PSSYSTEM_PSSYSTEMID";
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
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
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
        return new String[]{"PSDEID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysCalendar pSSysCalendar) {
        if (!StringHelper.isNullOrEmpty((String)pSSysCalendar.getCodeName())) {
            return pSSysCalendar.getCodeName();
        }
        return super.getModelV2Tag(pSSysCalendar);
    }

    @Override
    public boolean setModelV2Tag(PSSysCalendar pSSysCalendar, String string) {
        pSSysCalendar.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysCalendar pSSysCalendar, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysCalendar.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysCalendar, true);
        pSSysCalendar.set("CODENAME", string);
        if (this.select(pSSysCalendar, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysCalendar, true);
        return super.getModelV2Entity(pSSysCalendar, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysCalendar pSSysCalendar, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysCalendar, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSCALENDARITEM_PSSYSCALENDAR_PSSYSCALENDARID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDAR_PSSYSCALENDARID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysCalendar pSSysCalendar, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysCalendar, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysCalendar pSSysCalendar, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSSysCalendarItem> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSCALENDARITEM_PSSYSCALENDAR_PSSYSCALENDARID")) {
            pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSCALENDAR#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSCALENDARITEM", (Object)pSSysCalendar.getPSSysCalendarId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSSysCalendarItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysCalendarItem>();
                object3 = ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).selectByPSSysCalendar(pSSysCalendar);
                arrayNode = StringHelper.format((String)"PSSYSCALENDAR#%1$s", (Object)pSSysCalendar.getPSSysCalendarId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysCalendarItem)object2.next();
                    object = ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysCalendarItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssyscalendaritemname")) {
                            string = objectNode.get("pssyscalendaritemname").asText();
                        }
                        if (objectNode2.has("pssyscalendaritemname")) {
                            string2 = objectNode2.get("pssyscalendaritemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysCalendarItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDAR_PSSYSCALENDARID")) {
            pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSCALENDAR#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSCALENDARLOGIC", (Object)pSSysCalendar.getPSSysCalendarId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysCalendarItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).selectByPSSysCalendar(pSSysCalendar);
                arrayNode = StringHelper.format((String)"PSSYSCALENDAR#%1$s", (Object)pSSysCalendar.getPSSysCalendarId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysCalendarLogic)object2.next();
                    object = ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysCalendarItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssyscalendarlogicname")) {
                            string = objectNode.get("pssyscalendarlogicname").asText();
                        }
                        if (objectNode2.has("pssyscalendarlogicname")) {
                            string2 = objectNode2.get("pssyscalendarlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysCalendarLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysCalendar, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysCalendar pSSysCalendar) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).selectByPSSysCalendar(pSSysCalendar);
        String string2 = StringHelper.format((String)"PSSYSCALENDAR#%1$s", (Object)pSSysCalendar.getPSSysCalendarId());
        for (PSSysCalendarItem entityBase : arrayList) {
            string = ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSSysCalendar.getPSSysCalendarId());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSCALENDARITEM WHERE PSSYSCALENDARID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).selectByPSSysCalendar(pSSysCalendar);
        string2 = StringHelper.format((String)"PSSYSCALENDAR#%1$s", (Object)pSSysCalendar.getPSSysCalendarId());
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            string = ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSSysCalendarLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSSysCalendarLogic);
        }
        object = new SqlParamList();
        object.addString(pSSysCalendar.getPSSysCalendarId());
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSCALENDARLOGIC WHERE PSSYSCALENDARID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSSysCalendar);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysCalendar pSSysCalendar, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysCalendarItem();
        entityBase.set("PSSYSCALENDARID", pSSysCalendar.getPSSysCalendarId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysCalendarLogic();
        entityBase.set("PSSYSCALENDARID", pSSysCalendar.getPSSysCalendarId());
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysCalendar, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysCalendar pSSysCalendar, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSSysCalendarItem();
                ((PSSysCalendarItemBase)object).setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
                ((PSSysCalendarItemBase)object).setPSSysCalendarName(pSSysCalendar.getPSSysCalendarName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSSysCalendarItem();
                    entityBase.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
                    entityBase.setPSSysCalendarName(pSSysCalendar.getPSSysCalendarName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSSysCalendarLogic();
                ((PSSysCalendarLogicBase)object).setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
                ((PSSysCalendarLogicBase)object).setPSSysCalendarName(pSSysCalendar.getPSSysCalendarName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string5);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSSysCalendarLogic();
                    entityBase.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
                    entityBase.setPSSysCalendarName(pSSysCalendar.getPSSysCalendarName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysCalendar, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysCalendar pSSysCalendar, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSCALENDARITEM_PSSYSCALENDAR_PSSYSCALENDARID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysCalendarItems(pSSysCalendar, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDAR_PSSYSCALENDARID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysCalendarLogics(pSSysCalendar, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysCalendar, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysCalendarItems(PSSysCalendar pSSysCalendar, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSCALENDARITEM", true), (boolean)false) == 0) {
            PSSysCalendarItemService pSSysCalendarItemService = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysCalendarItem pSSysCalendarItem = new PSSysCalendarItem();
            pSSysCalendarItem.setPSSysCalendarItemId(pSMOSFile.getPSModelId());
            if (!pSSysCalendarItemService.get((IEntity)pSSysCalendarItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysCalendarItem.getPSSysCalendarId(), (String)pSSysCalendar.getPSSysCalendarId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysCalendarItemService.exportModelV2(pSSysCalendarItem);
            pSSysCalendarItem.reset();
            if (!pSSysCalendarItemService.setModelV2ResScope((IEntity)pSSysCalendarItem, "PSSYSCALENDAR", pSSysCalendar.getPSSysCalendarId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysCalendarItemService.importModelV2(pSSysCalendarItem, objectNode);
            SessionFactoryManager.commit();
            return pSSysCalendarItemService.getFile((IEntity)pSSysCalendarItem);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysCalendarLogics(PSSysCalendar pSSysCalendar, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSCALENDARLOGIC", true), (boolean)false) == 0) {
            PSSysCalendarLogicService pSSysCalendarLogicService = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
            PSSysCalendarLogic pSSysCalendarLogic = new PSSysCalendarLogic();
            pSSysCalendarLogic.setPSSysCalendarLogicId(pSMOSFile.getPSModelId());
            if (!pSSysCalendarLogicService.get((IEntity)pSSysCalendarLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysCalendarLogic.getPSSysCalendarId(), (String)pSSysCalendar.getPSSysCalendarId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysCalendarLogicService.exportModelV2(pSSysCalendarLogic);
            pSSysCalendarLogic.reset();
            if (!pSSysCalendarLogicService.setModelV2ResScope((IEntity)pSSysCalendarLogic, "PSSYSCALENDAR", pSSysCalendar.getPSSysCalendarId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysCalendarLogicService.importModelV2(pSSysCalendarLogic, objectNode);
            SessionFactoryManager.commit();
            return pSSysCalendarLogicService.getFile((IEntity)pSSysCalendarLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysCalendar pSSysCalendar, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysCalendarItems(pSSysCalendar, list);
        this.onFillPasteHelps_PSSysCalendarLogics(pSSysCalendar, list);
        super.onFillPasteHelps(pSSysCalendar, list);
    }

    protected void onFillPasteHelps_PSSysCalendarItems(PSSysCalendar pSSysCalendar, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSCALENDARITEM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSCALENDARITEM_PSSYSCALENDAR_PSSYSCALENDARID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u65e5\u5386\u90e8\u4ef6]\u7684[\u65e5\u5386\u90e8\u4ef6\u9879]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysCalendarLogics(PSSysCalendar pSSysCalendar, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSCALENDARLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDAR_PSSYSCALENDARID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u65e5\u5386\u90e8\u4ef6]\u7684[\u65e5\u5386\u90e8\u4ef6\u903b\u8f91]");
        list.add(pSHelpSection);
    }
}

