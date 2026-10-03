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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEListLogicDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEListLogicDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
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

public abstract class PSDEListLogicServiceBase
extends PSCoreSysServiceBase<PSDEListLogic> {
    private static final Log log = LogFactory.getLog(PSDEListLogicServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEListLogicDEModel pSDEListLogicDEModel;
    private PSDEListLogicDAO pSDEListLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicService";
    }

    public PSDEListLogicDEModel getPSDEListLogicDEModel() {
        if (this.pSDEListLogicDEModel == null) {
            try {
                this.pSDEListLogicDEModel = (PSDEListLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEListLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEListLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEListLogicDEModel();
    }

    public PSDEListLogicDAO getPSDEListLogicDAO() {
        if (this.pSDEListLogicDAO == null) {
            try {
                this.pSDEListLogicDAO = (PSDEListLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEListLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEListLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEListLogicDAO();
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

    protected void onFillParentInfo(PSDEListLogic pSDEListLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELISTLOGIC_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEListLogic, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELISTLOGIC_PSDELISTITEM_PSDELISTITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService", (SessionFactory)this.getSessionFactory());
            PSDEListItem pSDEListItem = (PSDEListItem)iService.getDEModel().createEntity();
            pSDEListItem.set("PSDELISTITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEListItem);
            } else {
                iService.get(pSDEListItem);
            }
            this.onFillParentInfo_PSDEListItem(pSDEListLogic, pSDEListItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELISTLOGIC_PSDELIST_PSDELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEListService", (SessionFactory)this.getSessionFactory());
            PSDEList pSDEList = (PSDEList)iService.getDEModel().createEntity();
            pSDEList.set("PSDELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEList);
            } else {
                iService.get(pSDEList);
            }
            this.onFillParentInfo_PSDEList(pSDEListLogic, pSDEList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELISTLOGIC_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDEListLogic, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELISTLOGIC_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSDEListLogic, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELISTLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEListLogic, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELISTLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewLogic pSSysViewLogic = (PSSysViewLogic)iService.getDEModel().createEntity();
            pSSysViewLogic.set("PSSYSVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewLogic);
            } else {
                iService.get(pSSysViewLogic);
            }
            this.onFillParentInfo_PSSysViewLogic(pSDEListLogic, pSSysViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELISTLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSDEListLogic, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSDEListLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDELISTLOGIC_PSDELIST_PSDELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEListService", (SessionFactory)this.getSessionFactory());
            PSDEList pSDEList = (PSDEList)iService.getDEModel().createEntity();
            pSDEList.set("PSDELISTID", string2);
            return this.onSyncDER1NData_PSDEList(pSDEList, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEListLogic pSDEListLogic, PSDataEntity pSDataEntity) throws Exception {
        pSDEListLogic.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEListLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEListItem(PSDEListLogic pSDEListLogic, PSDEListItem pSDEListItem) throws Exception {
        pSDEListLogic.setPSDEListItemId(pSDEListItem.getPSDEListItemId());
        pSDEListLogic.setPSDEListItemName(pSDEListItem.getPSDEListItemName());
    }

    protected void onFillParentInfo_PSDEList(PSDEListLogic pSDEListLogic, PSDEList pSDEList) throws Exception {
        pSDEListLogic.setPSDEListId(pSDEList.getPSDEListId());
        pSDEListLogic.setPSDEListName(pSDEList.getPSDEListName());
    }

    protected String onSyncDER1NData_PSDEList(PSDEList pSDEList, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEList(pSDEList);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEListLogic> arrayList = this.selectByPSDEList(pSDEList);
            for (PSDEListLogic pSDEListLogic : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEListLogic, (String)"PSDELISTLOGICID", (String)""))) continue;
                this.remove(pSDEListLogic);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDELogic(PSDEListLogic pSDEListLogic, PSDELogic pSDELogic) throws Exception {
        pSDEListLogic.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEListLogic.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSDEListLogic pSDEListLogic, PSDEUIAction pSDEUIAction) throws Exception {
        pSDEListLogic.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDEListLogic.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEListLogic pSDEListLogic, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEListLogic.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEListLogic.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysViewLogic(PSDEListLogic pSDEListLogic, PSSysViewLogic pSSysViewLogic) throws Exception {
        pSDEListLogic.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
        pSDEListLogic.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSDEListLogic pSDEListLogic, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDEListLogic.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDEListLogic.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
        if (bl && pSDEListLogic.getValidFlag() == null) {
            pSDEListLogic.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDEListLogic, bl);
        this.onFillEntityFullInfo_PSDE(pSDEListLogic, bl);
        this.onFillEntityFullInfo_PSDEListItem(pSDEListLogic, bl);
        this.onFillEntityFullInfo_PSDEList(pSDEListLogic, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDEListLogic, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSDEListLogic, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEListLogic, bl);
        this.onFillEntityFullInfo_PSSysViewLogic(pSDEListLogic, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSDEListLogic, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
        if (pSDEListLogic.isPSDEIdDirty()) {
            if (pSDEListLogic.getPSDEId() != null) {
                if (pSDEListLogic.getPSDEId() == null || pSDEListLogic.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEListLogic.getPSDE();
                    pSDEListLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEListLogic.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEListItem(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEList(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewLogic(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEListLogic, bl);
    }

    public ArrayList<PSDEListLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEListLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEListLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEListLogic> selectByPSDEListItem(PSDEListItemBase pSDEListItemBase) throws Exception {
        return this.selectByPSDEListItem(pSDEListItemBase, "", -1);
    }

    public ArrayList<PSDEListLogic> selectByPSDEListItem(PSDEListItemBase pSDEListItemBase, String string) throws Exception {
        return this.selectByPSDEListItem(pSDEListItemBase, string, -1);
    }

    public ArrayList<PSDEListLogic> selectByPSDEListItem(PSDEListItemBase pSDEListItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELISTITEMID", (Object)pSDEListItemBase.getPSDEListItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEListItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEListItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEListLogic> selectTempByPSDEListItem(PSDEListItemBase pSDEListItemBase) throws Exception {
        return this.selectTempByPSDEListItem(pSDEListItemBase, "");
    }

    public ArrayList<PSDEListLogic> selectTempByPSDEListItem(PSDEListItemBase pSDEListItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELISTITEMID", (Object)pSDEListItemBase.getPSDEListItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEListItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEListItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEListLogic> selectByPSDEList(PSDEListBase pSDEListBase) throws Exception {
        return this.selectByPSDEList(pSDEListBase, "", -1);
    }

    public ArrayList<PSDEListLogic> selectByPSDEList(PSDEListBase pSDEListBase, String string) throws Exception {
        return this.selectByPSDEList(pSDEListBase, string, -1);
    }

    public ArrayList<PSDEListLogic> selectByPSDEList(PSDEListBase pSDEListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELISTID", (Object)pSDEListBase.getPSDEListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEListLogic> selectTempByPSDEList(PSDEListBase pSDEListBase) throws Exception {
        return this.selectTempByPSDEList(pSDEListBase, "");
    }

    public ArrayList<PSDEListLogic> selectTempByPSDEList(PSDEListBase pSDEListBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELISTID", (Object)pSDEListBase.getPSDEListId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEListCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEListLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEListLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEListLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEListLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDEListLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDEListLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEListLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEListLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEListLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEListLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, "", -1);
    }

    public ArrayList<PSDEListLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, string, -1);
    }

    public ArrayList<PSDEListLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEListLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDEListLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDEListLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELISTLOGIC_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDELISTLOGIC", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            PSDEListLogic pSDEListLogic2 = (PSDEListLogic)this.getDEModel().createEntity();
            pSDEListLogic2.setPSDEListLogicId(pSDEListLogic.getPSDEListLogicId());
            pSDEListLogic2.setPSDEId(null);
            this.update(pSDEListLogic2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListLogicServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEListLogicServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEListLogicServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            this.remove(pSDEListLogic);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDEListItem(pSDEListItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELISTITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEListItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELISTLOGIC_PSDELISTITEM_PSDELISTITEMID", "", iDataEntityModel.getName(), "PSDELISTLOGIC", iDataEntityModel.getDataInfo(pSDEListItem), arrayList.get(0)));
        }
    }

    public void resetPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDEListItem(pSDEListItem);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            PSDEListLogic pSDEListLogic2 = (PSDEListLogic)this.getDEModel().createEntity();
            pSDEListLogic2.setPSDEListLogicId(pSDEListLogic.getPSDEListLogicId());
            pSDEListLogic2.setPSDEListItemId(null);
            this.update(pSDEListLogic2);
        }
    }

    public void resetTempPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectTempByPSDEListItem(pSDEListItem);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            PSDEListLogic pSDEListLogic2 = (PSDEListLogic)this.getDEModel().createEntity();
            pSDEListLogic2.setPSDEListLogicId(pSDEListLogic.getPSDEListLogicId());
            pSDEListLogic2.setPSDEListItemId(null);
            this.updateTemp(pSDEListLogic2);
        }
    }

    public void removeByPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
        final PSDEListItem pSDEListItem2 = pSDEListItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListLogicServiceBase.this.onBeforeRemoveByPSDEListItem(pSDEListItem2);
                PSDEListLogicServiceBase.this.internalRemoveByPSDEListItem(pSDEListItem2);
                PSDEListLogicServiceBase.this.onAfterRemoveByPSDEListItem(pSDEListItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
    }

    protected void internalRemoveByPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDEListItem(pSDEListItem);
        this.onBeforeRemoveByPSDEListItem(pSDEListItem, arrayList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            this.remove(pSDEListLogic);
        }
        this.onAfterRemoveByPSDEListItem(pSDEListItem, arrayList);
    }

    protected void onAfterRemoveByPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
    }

    protected void onBeforeRemoveByPSDEListItem(PSDEListItem pSDEListItem, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEListItem(PSDEListItem pSDEListItem, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEList(PSDEList pSDEList) throws Exception {
    }

    public void resetPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDEList(pSDEList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            PSDEListLogic pSDEListLogic2 = (PSDEListLogic)this.getDEModel().createEntity();
            pSDEListLogic2.setPSDEListLogicId(pSDEListLogic.getPSDEListLogicId());
            pSDEListLogic2.setPSDEListId(null);
            this.update(pSDEListLogic2);
        }
    }

    public void resetTempPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectTempByPSDEList(pSDEList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            PSDEListLogic pSDEListLogic2 = (PSDEListLogic)this.getDEModel().createEntity();
            pSDEListLogic2.setPSDEListLogicId(pSDEListLogic.getPSDEListLogicId());
            pSDEListLogic2.setPSDEListId(null);
            this.updateTemp(pSDEListLogic2);
        }
    }

    public void removeByPSDEList(PSDEList pSDEList) throws Exception {
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListLogicServiceBase.this.onBeforeRemoveByPSDEList(pSDEList2);
                PSDEListLogicServiceBase.this.internalRemoveByPSDEList(pSDEList2);
                PSDEListLogicServiceBase.this.onAfterRemoveByPSDEList(pSDEList2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void internalRemoveByPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDEList(pSDEList);
        this.onBeforeRemoveByPSDEList(pSDEList, arrayList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            this.remove(pSDEListLogic);
        }
        this.onAfterRemoveByPSDEList(pSDEList, arrayList);
    }

    protected void onAfterRemoveByPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void onBeforeRemoveByPSDEList(PSDEList pSDEList, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEList(PSDEList pSDEList, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELISTLOGIC_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDELISTLOGIC", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            PSDEListLogic pSDEListLogic2 = (PSDEListLogic)this.getDEModel().createEntity();
            pSDEListLogic2.setPSDEListLogicId(pSDEListLogic.getPSDEListLogicId());
            pSDEListLogic2.setPSDELogicId(null);
            this.update(pSDEListLogic2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListLogicServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDEListLogicServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDEListLogicServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            this.remove(pSDEListLogic);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELISTLOGIC_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDELISTLOGIC", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            PSDEListLogic pSDEListLogic2 = (PSDEListLogic)this.getDEModel().createEntity();
            pSDEListLogic2.setPSDEListLogicId(pSDEListLogic.getPSDEListLogicId());
            pSDEListLogic2.setPSDEUIActionId(null);
            this.update(pSDEListLogic2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListLogicServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEListLogicServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEListLogicServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            this.remove(pSDEListLogic);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELISTLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDELISTLOGIC", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            PSDEListLogic pSDEListLogic2 = (PSDEListLogic)this.getDEModel().createEntity();
            pSDEListLogic2.setPSDEListLogicId(pSDEListLogic.getPSDEListLogicId());
            pSDEListLogic2.setPSSysPFPluginId(null);
            this.update(pSDEListLogic2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListLogicServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEListLogicServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEListLogicServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            this.remove(pSDEListLogic);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELISTLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", "", iDataEntityModel.getName(), "PSDELISTLOGIC", iDataEntityModel.getDataInfo(pSSysViewLogic), arrayList.get(0)));
        }
    }

    public void resetPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            PSDEListLogic pSDEListLogic2 = (PSDEListLogic)this.getDEModel().createEntity();
            pSDEListLogic2.setPSDEListLogicId(pSDEListLogic.getPSDEListLogicId());
            pSDEListLogic2.setPSSysViewLogicId(null);
            this.update(pSDEListLogic2);
        }
    }

    public void removeByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListLogicServiceBase.this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDEListLogicServiceBase.this.internalRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDEListLogicServiceBase.this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            this.remove(pSDEListLogic);
        }
        this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELISTLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDELISTLOGIC", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            PSDEListLogic pSDEListLogic2 = (PSDEListLogic)this.getDEModel().createEntity();
            pSDEListLogic2.setPSDEListLogicId(pSDEListLogic.getPSDEListLogicId());
            pSDEListLogic2.setPSSysViewPanelId(null);
            this.update(pSDEListLogic2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListLogicServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEListLogicServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEListLogicServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            this.remove(pSDEListLogic);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEListLogic pSDEListLogic) throws Exception {
        super.onBeforeRemove(pSDEListLogic);
    }

    public void removeTempByPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
        final PSDEListItem pSDEListItem2 = pSDEListItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListLogicServiceBase.this.onBeforeRemoveTempByPSDEListItem(pSDEListItem2);
                PSDEListLogicServiceBase.this.internalRemoveTempByPSDEListItem(pSDEListItem2);
                PSDEListLogicServiceBase.this.onAfterRemoveTempByPSDEListItem(pSDEListItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
    }

    protected void internalRemoveTempByPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectTempByPSDEListItem(pSDEListItem);
        this.onBeforeRemoveTempByPSDEListItem(pSDEListItem, arrayList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            this.removeTemp(pSDEListLogic);
        }
        this.onAfterRemoveTempByPSDEListItem(pSDEListItem, arrayList);
    }

    protected void onAfterRemoveTempByPSDEListItem(PSDEListItem pSDEListItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEListItem(PSDEListItem pSDEListItem, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEListItem(PSDEListItem pSDEListItem, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    public void removeTempByPSDEList(PSDEList pSDEList) throws Exception {
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListLogicServiceBase.this.onBeforeRemoveTempByPSDEList(pSDEList2);
                PSDEListLogicServiceBase.this.internalRemoveTempByPSDEList(pSDEList2);
                PSDEListLogicServiceBase.this.onAfterRemoveTempByPSDEList(pSDEList2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void internalRemoveTempByPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.selectTempByPSDEList(pSDEList);
        this.onBeforeRemoveTempByPSDEList(pSDEList, arrayList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            this.removeTemp(pSDEListLogic);
        }
        this.onAfterRemoveTempByPSDEList(pSDEList, arrayList);
    }

    protected void onAfterRemoveTempByPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEList(PSDEList pSDEList, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEList(PSDEList pSDEList, ArrayList<PSDEListLogic> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEListLogic pSDEListLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEListLogic, cloneSession);
        if (pSDEListLogic.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEListLogic.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEListLogic, (PSDataEntity)iEntity);
        }
        if (pSDEListLogic.getPSDEListItemId() != null && (iEntity = cloneSession.getEntity("PSDELISTITEM", (Object)pSDEListLogic.getPSDEListItemId())) != null) {
            this.onFillParentInfo_PSDEListItem(pSDEListLogic, (PSDEListItem)iEntity);
        }
        if (pSDEListLogic.getPSDEListId() != null && (iEntity = cloneSession.getEntity("PSDELIST", (Object)pSDEListLogic.getPSDEListId())) != null) {
            this.onFillParentInfo_PSDEList(pSDEListLogic, (PSDEList)iEntity);
        }
        if (pSDEListLogic.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEListLogic.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDEListLogic, (PSDELogic)iEntity);
        }
        if (pSDEListLogic.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDEListLogic.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSDEListLogic, (PSDEUIAction)iEntity);
        }
        if (pSDEListLogic.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEListLogic.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEListLogic, (PSSysPFPlugin)iEntity);
        }
        if (pSDEListLogic.getPSSysViewLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWLOGIC", (Object)pSDEListLogic.getPSSysViewLogicId())) != null) {
            this.onFillParentInfo_PSSysViewLogic(pSDEListLogic, (PSSysViewLogic)iEntity);
        }
        if (pSDEListLogic.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDEListLogic.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSDEListLogic, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEListLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AttrName(bl, pSDEListLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstLogicType(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg2(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventNames(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam2(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEListId(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEListItemId(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEListLogicId(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEListLogicName(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewLogicId(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timer(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TriggerType(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEListLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEListLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AttrName(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isAttrNameDirty() : !pSDEListLogic.isAttrNameDirty()) {
            return null;
        }
        String string = pSDEListLogic.getAttrName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrName_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isCustomCodeDirty() : !pSDEListLogic.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEListLogic.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstLogicType(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isDstLogicTypeDirty() && !bl2 : !pSDEListLogic.isDstLogicTypeDirty()) {
            return null;
        }
        String string = pSDEListLogic.getDstLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTLOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstLogicType_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventArg(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isEventArgDirty() : !pSDEListLogic.isEventArgDirty()) {
            return null;
        }
        String string = pSDEListLogic.getEventArg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventArg2(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isEventArg2Dirty() : !pSDEListLogic.isEventArg2Dirty()) {
            return null;
        }
        String string = pSDEListLogic.getEventArg2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg2_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventNames(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isEventNamesDirty() : !pSDEListLogic.isEventNamesDirty()) {
            return null;
        }
        String string = pSDEListLogic.getEventNames();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventNames_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicParam(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isLogicParamDirty() : !pSDEListLogic.isLogicParamDirty()) {
            return null;
        }
        String string = pSDEListLogic.getLogicParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicParam2(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isLogicParam2Dirty() : !pSDEListLogic.isLogicParam2Dirty()) {
            return null;
        }
        String string = pSDEListLogic.getLogicParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam2_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isMemoDirty() : !pSDEListLogic.isMemoDirty()) {
            return null;
        }
        String string = pSDEListLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isOrderValueDirty() : !pSDEListLogic.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEListLogic.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSDEIdDirty() : !pSDEListLogic.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEListId(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSDEListIdDirty() && !bl2 : !pSDEListLogic.isPSDEListIdDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSDEListId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEListId_Default(pSDEListLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEListItemId(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSDEListItemIdDirty() : !pSDEListLogic.isPSDEListItemIdDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSDEListItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEListItemId_Default(pSDEListLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEListLogicId(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSDEListLogicIdDirty() && !bl2 : !pSDEListLogic.isPSDEListLogicIdDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSDEListLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEListLogicId_Default(pSDEListLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEListLogicName(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSDEListLogicNameDirty() && !bl2 : !pSDEListLogic.isPSDEListLogicNameDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSDEListLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTLOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEListLogicName_Default(pSDEListLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTLOGICNAME");
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
                string3 = "PSDELISTID";
                String string4 = this.checkFieldDupRule(this.getPSDEListLogicDEModel(), "PSDELISTLOGICNAME", string3, pSDEListLogic, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDELISTLOGICNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSDELogicIdDirty() : !pSDEListLogic.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSDENameDirty() : !pSDEListLogic.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSDEUIActionIdDirty() : !pSDEListLogic.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSSysPFPluginIdDirty() : !pSDEListLogic.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewLogicId(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSSysViewLogicIdDirty() : !pSDEListLogic.isPSSysViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSSysViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewLogicId_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isPSSysViewPanelIdDirty() : !pSDEListLogic.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDEListLogic.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_Timer(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isTimerDirty() : !pSDEListLogic.isTimerDirty()) {
            return null;
        }
        Integer n = pSDEListLogic.getTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timer_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_TriggerType(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isTriggerTypeDirty() && !bl2 : !pSDEListLogic.isTriggerTypeDirty()) {
            return null;
        }
        String string = pSDEListLogic.getTriggerType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRIGGERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TriggerType_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isUserCatDirty() : !pSDEListLogic.isUserCatDirty()) {
            return null;
        }
        String string = pSDEListLogic.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isUserTagDirty() : !pSDEListLogic.isUserTagDirty()) {
            return null;
        }
        String string = pSDEListLogic.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isUserTag2Dirty() : !pSDEListLogic.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEListLogic.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isUserTag3Dirty() : !pSDEListLogic.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEListLogic.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isUserTag4Dirty() : !pSDEListLogic.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEListLogic.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEListLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEListLogic pSDEListLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEListLogic.isValidFlagDirty() && !bl2 : !pSDEListLogic.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEListLogic.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEListLogic, bl2, bl3);
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

    protected void onSyncEntity(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSDEListLogic, bl);
    }

    protected void onSyncIndexEntities(PSDEListLogic pSDEListLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEListLogic, bl);
    }

    public Object getDataContextValue(PSDEListLogic pSDEListLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEListLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEList pSDEList = pSDEListLogic.getPSDEList();
        if (pSDEList != null && pSDEList.contains(string)) {
            return pSDEList.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEListLogic pSDEListLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEListLogic, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELISTITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELISTITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELISTLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELISTLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEListItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELISTITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEListItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELISTITEMNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEListLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELISTLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEListLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELISTLOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSDELISTLOGICNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELISTNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected boolean onMergeChild(String string, String string2, PSDEListLogic pSDEListLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEListLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEListLogic pSDEListLogic) throws Exception {
        super.onUpdateParent(pSDEListLogic);
    }

    @Override
    protected void exportCurXmlModel(PSDEListLogic pSDEListLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDELISTLOGIC");
        if (!bl) {
            pSDEListLogic.setCreateDate(null);
            pSDEListLogic.setCreateMan(null);
            pSDEListLogic.setPSDEListLogicId(null);
            pSDEListLogic.setUpdateDate(null);
            pSDEListLogic.setUpdateMan(null);
            pSDEListLogic.setPSDEListItemId(null);
            pSDEListLogic.setPSDEListId(null);
            pSDEListLogic.setPSDEListName(null);
            super.exportCurXmlModel(pSDEListLogic, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEListLogic pSDEListLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEListLogic, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELISTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDELIST#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELISTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDELISTLOGIC_PSDELIST_PSDELISTID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELISTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELISTNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDELIST", (boolean)true) == 0) {
            iEntity.set("PSDELISTID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDELISTID"};
    }

    @Override
    public String getModelV2Tag(PSDEListLogic pSDEListLogic) {
        if (!StringHelper.isNullOrEmpty((String)pSDEListLogic.getPSDEListLogicName())) {
            return pSDEListLogic.getPSDEListLogicName();
        }
        return super.getModelV2Tag(pSDEListLogic);
    }

    @Override
    public boolean setModelV2Tag(PSDEListLogic pSDEListLogic, String string) {
        pSDEListLogic.setPSDEListLogicName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDELISTLOGICNAME", "");
        map.put("PSDELISTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEListLogic pSDEListLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEListLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEListLogic, true);
        pSDEListLogic.set("PSDELISTLOGICNAME", string);
        if (this.select(pSDEListLogic, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEListLogic, true);
        return super.getModelV2Entity(pSDEListLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEListLogic pSDEListLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEListLogic, objectNode, string, string2, n);
    }
}

