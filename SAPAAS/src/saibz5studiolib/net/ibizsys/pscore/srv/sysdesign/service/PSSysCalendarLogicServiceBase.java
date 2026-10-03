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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarLogicDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarLogicDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCalendarLogicServiceBase
extends PSCoreSysServiceBase<PSSysCalendarLogic> {
    private static final Log log = LogFactory.getLog(PSSysCalendarLogicServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysCalendarLogicDEModel pSSysCalendarLogicDEModel;
    private PSSysCalendarLogicDAO pSSysCalendarLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicService";
    }

    public PSSysCalendarLogicDEModel getPSSysCalendarLogicDEModel() {
        if (this.pSSysCalendarLogicDEModel == null) {
            try {
                this.pSSysCalendarLogicDEModel = (PSSysCalendarLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysCalendarLogicDEModel();
    }

    public PSSysCalendarLogicDAO getPSSysCalendarLogicDAO() {
        if (this.pSSysCalendarLogicDAO == null) {
            try {
                this.pSSysCalendarLogicDAO = (PSSysCalendarLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysCalendarLogicDAO();
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

    protected void onFillParentInfo(PSSysCalendarLogic pSSysCalendarLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARLOGIC_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysCalendarLogic, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARLOGIC_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSSysCalendarLogic, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARLOGIC_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSSysCalendarLogic, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDARITEM_PSSYSCALENDARITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService", (SessionFactory)this.getSessionFactory());
            PSSysCalendarItem pSSysCalendarItem = (PSSysCalendarItem)iService.getDEModel().createEntity();
            pSSysCalendarItem.set("PSSYSCALENDARITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCalendarItem);
            } else {
                iService.get(pSSysCalendarItem);
            }
            this.onFillParentInfo_PSSysCalendarItem(pSSysCalendarLogic, pSSysCalendarItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDAR_PSSYSCALENDARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService", (SessionFactory)this.getSessionFactory());
            PSSysCalendar pSSysCalendar = (PSSysCalendar)iService.getDEModel().createEntity();
            pSSysCalendar.set("PSSYSCALENDARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCalendar);
            } else {
                iService.get(pSSysCalendar);
            }
            this.onFillParentInfo_PSSysCalendar(pSSysCalendarLogic, pSSysCalendar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysCalendarLogic, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewLogic pSSysViewLogic = (PSSysViewLogic)iService.getDEModel().createEntity();
            pSSysViewLogic.set("PSSYSVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewLogic);
            } else {
                iService.get(pSSysViewLogic);
            }
            this.onFillParentInfo_PSSysViewLogic(pSSysCalendarLogic, pSSysViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSSysCalendarLogic, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSSysCalendarLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDAR_PSSYSCALENDARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService", (SessionFactory)this.getSessionFactory());
            PSSysCalendar pSSysCalendar = (PSSysCalendar)iService.getDEModel().createEntity();
            pSSysCalendar.set("PSSYSCALENDARID", string2);
            return this.onSyncDER1NData_PSSysCalendar(pSSysCalendar, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysCalendarLogic pSSysCalendarLogic, PSDataEntity pSDataEntity) throws Exception {
        pSSysCalendarLogic.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysCalendarLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDELogic(PSSysCalendarLogic pSSysCalendarLogic, PSDELogic pSDELogic) throws Exception {
        pSSysCalendarLogic.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSSysCalendarLogic.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSSysCalendarLogic pSSysCalendarLogic, PSDEUIAction pSDEUIAction) throws Exception {
        pSSysCalendarLogic.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSSysCalendarLogic.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSSysCalendarItem(PSSysCalendarLogic pSSysCalendarLogic, PSSysCalendarItem pSSysCalendarItem) throws Exception {
        pSSysCalendarLogic.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
        pSSysCalendarLogic.setPSSysCalendarItemName(pSSysCalendarItem.getPSSysCalendarItemName());
    }

    protected void onFillParentInfo_PSSysCalendar(PSSysCalendarLogic pSSysCalendarLogic, PSSysCalendar pSSysCalendar) throws Exception {
        pSSysCalendarLogic.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
        pSSysCalendarLogic.setPSSysCalendarName(pSSysCalendar.getPSSysCalendarName());
    }

    protected String onSyncDER1NData_PSSysCalendar(PSSysCalendar pSSysCalendar, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSSysCalendar(pSSysCalendar);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
            for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSSysCalendarLogic, (String)"PSSYSCALENDARLOGICID", (String)""))) continue;
                this.remove(pSSysCalendarLogic);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysCalendarLogic pSSysCalendarLogic, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysCalendarLogic.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysCalendarLogic.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysViewLogic(PSSysCalendarLogic pSSysCalendarLogic, PSSysViewLogic pSSysViewLogic) throws Exception {
        pSSysCalendarLogic.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
        pSSysCalendarLogic.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSSysCalendarLogic pSSysCalendarLogic, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysCalendarLogic.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSSysCalendarLogic.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
        if (bl && pSSysCalendarLogic.getValidFlag() == null) {
            pSSysCalendarLogic.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysCalendarLogic, bl);
        this.onFillEntityFullInfo_PSDE(pSSysCalendarLogic, bl);
        this.onFillEntityFullInfo_PSDELogic(pSSysCalendarLogic, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSSysCalendarLogic, bl);
        this.onFillEntityFullInfo_PSSysCalendarItem(pSSysCalendarLogic, bl);
        this.onFillEntityFullInfo_PSSysCalendar(pSSysCalendarLogic, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysCalendarLogic, bl);
        this.onFillEntityFullInfo_PSSysViewLogic(pSSysCalendarLogic, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSSysCalendarLogic, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
        if (pSSysCalendarLogic.isPSDEIdDirty()) {
            if (pSSysCalendarLogic.getPSDEId() != null) {
                if (pSSysCalendarLogic.getPSDEId() == null || pSSysCalendarLogic.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysCalendarLogic.getPSDE();
                    pSSysCalendarLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysCalendarLogic.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCalendarItem(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCalendar(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewLogic(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysCalendarLogic, bl);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarLogic> selectByPSSysCalendarItem(PSSysCalendarItemBase pSSysCalendarItemBase) throws Exception {
        return this.selectByPSSysCalendarItem(pSSysCalendarItemBase, "", -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysCalendarItem(PSSysCalendarItemBase pSSysCalendarItemBase, String string) throws Exception {
        return this.selectByPSSysCalendarItem(pSSysCalendarItemBase, string, -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysCalendarItem(PSSysCalendarItemBase pSSysCalendarItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCALENDARITEMID", (Object)pSSysCalendarItemBase.getPSSysCalendarItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCalendarItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCalendarItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarLogic> selectTempByPSSysCalendarItem(PSSysCalendarItemBase pSSysCalendarItemBase) throws Exception {
        return this.selectTempByPSSysCalendarItem(pSSysCalendarItemBase, "");
    }

    public ArrayList<PSSysCalendarLogic> selectTempByPSSysCalendarItem(PSSysCalendarItemBase pSSysCalendarItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCALENDARITEMID", (Object)pSSysCalendarItemBase.getPSSysCalendarItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysCalendarItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysCalendarItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase) throws Exception {
        return this.selectByPSSysCalendar(pSSysCalendarBase, "", -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string) throws Exception {
        return this.selectByPSSysCalendar(pSSysCalendarBase, string, -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarLogic> selectTempByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase) throws Exception {
        return this.selectTempByPSSysCalendar(pSSysCalendarBase, "");
    }

    public ArrayList<PSSysCalendarLogic> selectTempByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCALENDARID", (Object)pSSysCalendarBase.getPSSysCalendarId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysCalendarCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysCalendarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCalendarLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, "", -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, string, -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWLOGICID", (Object)pSSysViewLogicBase.getPSSysViewLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSSysCalendarLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARLOGIC_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSCALENDARLOGIC", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            PSSysCalendarLogic pSSysCalendarLogic2 = (PSSysCalendarLogic)this.getDEModel().createEntity();
            pSSysCalendarLogic2.setPSSysCalendarLogicId(pSSysCalendarLogic.getPSSysCalendarLogicId());
            pSSysCalendarLogic2.setPSDEId(null);
            this.update(pSSysCalendarLogic2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarLogicServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysCalendarLogicServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysCalendarLogicServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            this.remove(pSSysCalendarLogic);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARLOGIC_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSSYSCALENDARLOGIC", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            PSSysCalendarLogic pSSysCalendarLogic2 = (PSSysCalendarLogic)this.getDEModel().createEntity();
            pSSysCalendarLogic2.setPSSysCalendarLogicId(pSSysCalendarLogic.getPSSysCalendarLogicId());
            pSSysCalendarLogic2.setPSDELogicId(null);
            this.update(pSSysCalendarLogic2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarLogicServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSSysCalendarLogicServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSSysCalendarLogicServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            this.remove(pSSysCalendarLogic);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARLOGIC_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSSYSCALENDARLOGIC", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            PSSysCalendarLogic pSSysCalendarLogic2 = (PSSysCalendarLogic)this.getDEModel().createEntity();
            pSSysCalendarLogic2.setPSSysCalendarLogicId(pSSysCalendarLogic.getPSSysCalendarLogicId());
            pSSysCalendarLogic2.setPSDEUIActionId(null);
            this.update(pSSysCalendarLogic2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarLogicServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSSysCalendarLogicServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSSysCalendarLogicServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            this.remove(pSSysCalendarLogic);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysCalendarItem(pSSysCalendarItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCALENDARITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCalendarItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDARITEM_PSSYSCALENDARITEMID", "", iDataEntityModel.getName(), "PSSYSCALENDARLOGIC", iDataEntityModel.getDataInfo(pSSysCalendarItem), arrayList.get(0)));
        }
    }

    public void resetPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysCalendarItem(pSSysCalendarItem);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            PSSysCalendarLogic pSSysCalendarLogic2 = (PSSysCalendarLogic)this.getDEModel().createEntity();
            pSSysCalendarLogic2.setPSSysCalendarLogicId(pSSysCalendarLogic.getPSSysCalendarLogicId());
            pSSysCalendarLogic2.setPSSysCalendarItemId(null);
            this.update(pSSysCalendarLogic2);
        }
    }

    public void resetTempPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectTempByPSSysCalendarItem(pSSysCalendarItem);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            PSSysCalendarLogic pSSysCalendarLogic2 = (PSSysCalendarLogic)this.getDEModel().createEntity();
            pSSysCalendarLogic2.setPSSysCalendarLogicId(pSSysCalendarLogic.getPSSysCalendarLogicId());
            pSSysCalendarLogic2.setPSSysCalendarItemId(null);
            this.updateTemp(pSSysCalendarLogic2);
        }
    }

    public void removeByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        final PSSysCalendarItem pSSysCalendarItem2 = pSSysCalendarItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarLogicServiceBase.this.onBeforeRemoveByPSSysCalendarItem(pSSysCalendarItem2);
                PSSysCalendarLogicServiceBase.this.internalRemoveByPSSysCalendarItem(pSSysCalendarItem2);
                PSSysCalendarLogicServiceBase.this.onAfterRemoveByPSSysCalendarItem(pSSysCalendarItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
    }

    protected void internalRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysCalendarItem(pSSysCalendarItem);
        this.onBeforeRemoveByPSSysCalendarItem(pSSysCalendarItem, arrayList);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            this.remove(pSSysCalendarLogic);
        }
        this.onAfterRemoveByPSSysCalendarItem(pSSysCalendarItem, arrayList);
    }

    protected void onAfterRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    public void resetPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            PSSysCalendarLogic pSSysCalendarLogic2 = (PSSysCalendarLogic)this.getDEModel().createEntity();
            pSSysCalendarLogic2.setPSSysCalendarLogicId(pSSysCalendarLogic.getPSSysCalendarLogicId());
            pSSysCalendarLogic2.setPSSysCalendarId(null);
            this.update(pSSysCalendarLogic2);
        }
    }

    public void resetTempPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectTempByPSSysCalendar(pSSysCalendar);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            PSSysCalendarLogic pSSysCalendarLogic2 = (PSSysCalendarLogic)this.getDEModel().createEntity();
            pSSysCalendarLogic2.setPSSysCalendarLogicId(pSSysCalendarLogic.getPSSysCalendarLogicId());
            pSSysCalendarLogic2.setPSSysCalendarId(null);
            this.updateTemp(pSSysCalendarLogic2);
        }
    }

    public void removeByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        final PSSysCalendar pSSysCalendar2 = pSSysCalendar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarLogicServiceBase.this.onBeforeRemoveByPSSysCalendar(pSSysCalendar2);
                PSSysCalendarLogicServiceBase.this.internalRemoveByPSSysCalendar(pSSysCalendar2);
                PSSysCalendarLogicServiceBase.this.onAfterRemoveByPSSysCalendar(pSSysCalendar2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void internalRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
        this.onBeforeRemoveByPSSysCalendar(pSSysCalendar, arrayList);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            this.remove(pSSysCalendarLogic);
        }
        this.onAfterRemoveByPSSysCalendar(pSSysCalendar, arrayList);
    }

    protected void onAfterRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSCALENDARLOGIC", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            PSSysCalendarLogic pSSysCalendarLogic2 = (PSSysCalendarLogic)this.getDEModel().createEntity();
            pSSysCalendarLogic2.setPSSysCalendarLogicId(pSSysCalendarLogic.getPSSysCalendarLogicId());
            pSSysCalendarLogic2.setPSSysPFPluginId(null);
            this.update(pSSysCalendarLogic2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarLogicServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysCalendarLogicServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysCalendarLogicServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            this.remove(pSSysCalendarLogic);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", "", iDataEntityModel.getName(), "PSSYSCALENDARLOGIC", iDataEntityModel.getDataInfo(pSSysViewLogic), arrayList.get(0)));
        }
    }

    public void resetPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            PSSysCalendarLogic pSSysCalendarLogic2 = (PSSysCalendarLogic)this.getDEModel().createEntity();
            pSSysCalendarLogic2.setPSSysCalendarLogicId(pSSysCalendarLogic.getPSSysCalendarLogicId());
            pSSysCalendarLogic2.setPSSysViewLogicId(null);
            this.update(pSSysCalendarLogic2);
        }
    }

    public void removeByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarLogicServiceBase.this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSSysCalendarLogicServiceBase.this.internalRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSSysCalendarLogicServiceBase.this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            this.remove(pSSysCalendarLogic);
        }
        this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSSYSCALENDARLOGIC", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            PSSysCalendarLogic pSSysCalendarLogic2 = (PSSysCalendarLogic)this.getDEModel().createEntity();
            pSSysCalendarLogic2.setPSSysCalendarLogicId(pSSysCalendarLogic.getPSSysCalendarLogicId());
            pSSysCalendarLogic2.setPSSysViewPanelId(null);
            this.update(pSSysCalendarLogic2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarLogicServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysCalendarLogicServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysCalendarLogicServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            this.remove(pSSysCalendarLogic);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysCalendarLogic pSSysCalendarLogic) throws Exception {
        super.onBeforeRemove(pSSysCalendarLogic);
    }

    public void removeTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        final PSSysCalendarItem pSSysCalendarItem2 = pSSysCalendarItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarLogicServiceBase.this.onBeforeRemoveTempByPSSysCalendarItem(pSSysCalendarItem2);
                PSSysCalendarLogicServiceBase.this.internalRemoveTempByPSSysCalendarItem(pSSysCalendarItem2);
                PSSysCalendarLogicServiceBase.this.onAfterRemoveTempByPSSysCalendarItem(pSSysCalendarItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
    }

    protected void internalRemoveTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectTempByPSSysCalendarItem(pSSysCalendarItem);
        this.onBeforeRemoveTempByPSSysCalendarItem(pSSysCalendarItem, arrayList);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            this.removeTemp(pSSysCalendarLogic);
        }
        this.onAfterRemoveTempByPSSysCalendarItem(pSSysCalendarItem, arrayList);
    }

    protected void onAfterRemoveTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    public void removeTempByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        final PSSysCalendar pSSysCalendar2 = pSSysCalendar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarLogicServiceBase.this.onBeforeRemoveTempByPSSysCalendar(pSSysCalendar2);
                PSSysCalendarLogicServiceBase.this.internalRemoveTempByPSSysCalendar(pSSysCalendar2);
                PSSysCalendarLogicServiceBase.this.onAfterRemoveTempByPSSysCalendar(pSSysCalendar2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void internalRemoveTempByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysCalendarLogic> arrayList = this.selectTempByPSSysCalendar(pSSysCalendar);
        this.onBeforeRemoveTempByPSSysCalendar(pSSysCalendar, arrayList);
        for (PSSysCalendarLogic pSSysCalendarLogic : arrayList) {
            this.removeTemp(pSSysCalendarLogic);
        }
        this.onAfterRemoveTempByPSSysCalendar(pSSysCalendar, arrayList);
    }

    protected void onAfterRemoveTempByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysCalendarLogic> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysCalendarLogic pSSysCalendarLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysCalendarLogic, cloneSession);
        if (pSSysCalendarLogic.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysCalendarLogic.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysCalendarLogic, (PSDataEntity)iEntity);
        }
        if (pSSysCalendarLogic.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysCalendarLogic.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSSysCalendarLogic, (PSDELogic)iEntity);
        }
        if (pSSysCalendarLogic.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSSysCalendarLogic.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSSysCalendarLogic, (PSDEUIAction)iEntity);
        }
        if (pSSysCalendarLogic.getPSSysCalendarItemId() != null && (iEntity = cloneSession.getEntity("PSSYSCALENDARITEM", (Object)pSSysCalendarLogic.getPSSysCalendarItemId())) != null) {
            this.onFillParentInfo_PSSysCalendarItem(pSSysCalendarLogic, (PSSysCalendarItem)iEntity);
        }
        if (pSSysCalendarLogic.getPSSysCalendarId() != null && (iEntity = cloneSession.getEntity("PSSYSCALENDAR", (Object)pSSysCalendarLogic.getPSSysCalendarId())) != null) {
            this.onFillParentInfo_PSSysCalendar(pSSysCalendarLogic, (PSSysCalendar)iEntity);
        }
        if (pSSysCalendarLogic.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysCalendarLogic.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysCalendarLogic, (PSSysPFPlugin)iEntity);
        }
        if (pSSysCalendarLogic.getPSSysViewLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWLOGIC", (Object)pSSysCalendarLogic.getPSSysViewLogicId())) != null) {
            this.onFillParentInfo_PSSysViewLogic(pSSysCalendarLogic, (PSSysViewLogic)iEntity);
        }
        if (pSSysCalendarLogic.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSSysCalendarLogic.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSSysCalendarLogic, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysCalendarLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AttrName(bl, pSSysCalendarLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstLogicType(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg2(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventNames(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam2(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarId(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarItemId(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarLogicId(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarLogicName(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewLogicId(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timer(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TriggerType(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysCalendarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysCalendarLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AttrName(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isAttrNameDirty() : !pSSysCalendarLogic.isAttrNameDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getAttrName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrName_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isCustomCodeDirty() : !pSSysCalendarLogic.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstLogicType(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isDstLogicTypeDirty() && !bl2 : !pSSysCalendarLogic.isDstLogicTypeDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getDstLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTLOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstLogicType_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTLOGICTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EventArg(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isEventArgDirty() : !pSSysCalendarLogic.isEventArgDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getEventArg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTARG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EventArg2(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isEventArg2Dirty() : !pSSysCalendarLogic.isEventArg2Dirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getEventArg2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg2_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTARG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EventNames(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isEventNamesDirty() : !pSSysCalendarLogic.isEventNamesDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getEventNames();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventNames_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTNAMES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicParam(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isLogicParamDirty() : !pSSysCalendarLogic.isLogicParamDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getLogicParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicParam2(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isLogicParam2Dirty() : !pSSysCalendarLogic.isLogicParam2Dirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getLogicParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam2_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isMemoDirty() : !pSSysCalendarLogic.isMemoDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isOrderValueDirty() : !pSSysCalendarLogic.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysCalendarLogic.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSDEIdDirty() : !pSSysCalendarLogic.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSDELogicIdDirty() : !pSSysCalendarLogic.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSDENameDirty() : !pSSysCalendarLogic.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSDEUIActionIdDirty() : !pSSysCalendarLogic.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCalendarId(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSSysCalendarIdDirty() && !bl2 : !pSSysCalendarLogic.isPSSysCalendarIdDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSSysCalendarId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarId_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCalendarItemId(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSSysCalendarItemIdDirty() : !pSSysCalendarLogic.isPSSysCalendarItemIdDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSSysCalendarItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarItemId_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCalendarLogicId(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSSysCalendarLogicIdDirty() && !bl2 : !pSSysCalendarLogic.isPSSysCalendarLogicIdDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSSysCalendarLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarLogicId_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCalendarLogicName(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSSysCalendarLogicNameDirty() && !bl2 : !pSSysCalendarLogic.isPSSysCalendarLogicNameDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSSysCalendarLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARLOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarLogicName_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARLOGICNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysCalendarLogicDEModel(), "PSSYSCALENDARLOGICNAME", string3, pSSysCalendarLogic, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSCALENDARLOGICNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSSysPFPluginIdDirty() : !pSSysCalendarLogic.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewLogicId(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSSysViewLogicIdDirty() : !pSSysCalendarLogic.isPSSysViewLogicIdDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSSysViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewLogicId_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isPSSysViewPanelIdDirty() : !pSSysCalendarLogic.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_Timer(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isTimerDirty() : !pSSysCalendarLogic.isTimerDirty()) {
            return null;
        }
        Integer n = pSSysCalendarLogic.getTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timer_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TriggerType(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isTriggerTypeDirty() && !bl2 : !pSSysCalendarLogic.isTriggerTypeDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getTriggerType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRIGGERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TriggerType_Default(pSSysCalendarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRIGGERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isUserCatDirty() : !pSSysCalendarLogic.isUserCatDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isUserTagDirty() : !pSSysCalendarLogic.isUserTagDirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isUserTag2Dirty() : !pSSysCalendarLogic.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isUserTag3Dirty() : !pSSysCalendarLogic.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isUserTag4Dirty() : !pSSysCalendarLogic.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysCalendarLogic.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysCalendarLogic pSSysCalendarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarLogic.isValidFlagDirty() && !bl2 : !pSSysCalendarLogic.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysCalendarLogic.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysCalendarLogic, bl2, bl3);
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

    protected void onSyncEntity(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSSysCalendarLogic, bl);
    }

    protected void onSyncIndexEntities(PSSysCalendarLogic pSSysCalendarLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysCalendarLogic, bl);
    }

    public Object getDataContextValue(PSSysCalendarLogic pSSysCalendarLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysCalendarLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysCalendar pSSysCalendar = pSSysCalendarLogic.getPSSysCalendar();
        if (pSSysCalendar != null && pSSysCalendar.contains(string)) {
            return pSSysCalendar.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysCalendarLogic pSSysCalendarLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysCalendarLogic, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ATTRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DSTLOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstLogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTARG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventArg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTARG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventArg2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTNAMES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventNames_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Timer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TRIGGERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TriggerType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AttrName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_DstLogicType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTLOGICTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EventArg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTARG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EventArg2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTARG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EventNames_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTNAMES", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSysCalendarLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARLOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSSYSCALENDARLOGICNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSSysViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_Timer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TriggerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TRIGGERTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysCalendarLogic pSSysCalendarLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysCalendarLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysCalendarLogic pSSysCalendarLogic) throws Exception {
        super.onUpdateParent(pSSysCalendarLogic);
    }

    @Override
    protected void exportCurXmlModel(PSSysCalendarLogic pSSysCalendarLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSCALENDARLOGIC");
        if (!bl) {
            pSSysCalendarLogic.setCreateDate(null);
            pSSysCalendarLogic.setCreateMan(null);
            pSSysCalendarLogic.setPSSysCalendarLogicId(null);
            pSSysCalendarLogic.setUpdateDate(null);
            pSSysCalendarLogic.setUpdateMan(null);
            pSSysCalendarLogic.setPSSysCalendarItemId(null);
            pSSysCalendarLogic.setPSSysCalendarId(null);
            pSSysCalendarLogic.setPSSysCalendarName(null);
            super.exportCurXmlModel(pSSysCalendarLogic, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysCalendarLogic pSSysCalendarLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysCalendarLogic, string);
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
            return "DER1N_PSSYSCALENDARLOGIC_PSSYSCALENDAR_PSSYSCALENDARID";
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
    public String getModelV2Tag(PSSysCalendarLogic pSSysCalendarLogic) {
        if (!StringHelper.isNullOrEmpty((String)pSSysCalendarLogic.getPSSysCalendarLogicName())) {
            return pSSysCalendarLogic.getPSSysCalendarLogicName();
        }
        return super.getModelV2Tag(pSSysCalendarLogic);
    }

    @Override
    public boolean setModelV2Tag(PSSysCalendarLogic pSSysCalendarLogic, String string) {
        pSSysCalendarLogic.setPSSysCalendarLogicName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSCALENDARLOGICNAME", "");
        map.put("PSSYSCALENDARID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysCalendarLogic pSSysCalendarLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysCalendarLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysCalendarLogic, true);
        pSSysCalendarLogic.set("PSSYSCALENDARLOGICNAME", string);
        if (this.select(pSSysCalendarLogic, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysCalendarLogic, true);
        return super.getModelV2Entity(pSSysCalendarLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysCalendarLogic pSSysCalendarLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysCalendarLogic, objectNode, string, string2, n);
    }
}

