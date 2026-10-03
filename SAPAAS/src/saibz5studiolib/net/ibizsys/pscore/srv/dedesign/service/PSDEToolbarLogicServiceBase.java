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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEToolbarLogicDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEToolbarLogicDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarLogic;
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

public abstract class PSDEToolbarLogicServiceBase
extends PSCoreSysServiceBase<PSDEToolbarLogic> {
    private static final Log log = LogFactory.getLog(PSDEToolbarLogicServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEToolbarLogicDEModel pSDEToolbarLogicDEModel;
    private PSDEToolbarLogicDAO pSDEToolbarLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicService";
    }

    public PSDEToolbarLogicDEModel getPSDEToolbarLogicDEModel() {
        if (this.pSDEToolbarLogicDEModel == null) {
            try {
                this.pSDEToolbarLogicDEModel = (PSDEToolbarLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEToolbarLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEToolbarLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEToolbarLogicDEModel();
    }

    public PSDEToolbarLogicDAO getPSDEToolbarLogicDAO() {
        if (this.pSDEToolbarLogicDAO == null) {
            try {
                this.pSDEToolbarLogicDAO = (PSDEToolbarLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEToolbarLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEToolbarLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEToolbarLogicDAO();
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

    protected void onFillParentInfo(PSDEToolbarLogic pSDEToolbarLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBARLOGIC_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEToolbarLogic, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBARLOGIC_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDEToolbarLogic, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBARLOGIC_PSDETBITEM_PSDETBITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService", (SessionFactory)this.getSessionFactory());
            PSDETBItem pSDETBItem = (PSDETBItem)iService.getDEModel().createEntity();
            pSDETBItem.set("PSDETBITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETBItem);
            } else {
                iService.get(pSDETBItem);
            }
            this.onFillParentInfo_PSDETBItem(pSDEToolbarLogic, pSDETBItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBARLOGIC_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEToolbar);
            } else {
                iService.get(pSDEToolbar);
            }
            this.onFillParentInfo_PSDEToolbar(pSDEToolbarLogic, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBARLOGIC_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSDEToolbarLogic, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBARLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEToolbarLogic, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBARLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewLogic pSSysViewLogic = (PSSysViewLogic)iService.getDEModel().createEntity();
            pSSysViewLogic.set("PSSYSVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewLogic);
            } else {
                iService.get(pSSysViewLogic);
            }
            this.onFillParentInfo_PSSysViewLogic(pSDEToolbarLogic, pSSysViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBARLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSDEToolbarLogic, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSDEToolbarLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDETOOLBARLOGIC_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", string2);
            return this.onSyncDER1NData_PSDEToolbar(pSDEToolbar, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEToolbarLogic pSDEToolbarLogic, PSDataEntity pSDataEntity) throws Exception {
        pSDEToolbarLogic.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEToolbarLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDELogic(PSDEToolbarLogic pSDEToolbarLogic, PSDELogic pSDELogic) throws Exception {
        pSDEToolbarLogic.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEToolbarLogic.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDETBItem(PSDEToolbarLogic pSDEToolbarLogic, PSDETBItem pSDETBItem) throws Exception {
        pSDEToolbarLogic.setPSDETBItemId(pSDETBItem.getPSDETBItemId());
        pSDEToolbarLogic.setPSDETBItemName(pSDETBItem.getPSDETBItemName());
    }

    protected void onFillParentInfo_PSDEToolbar(PSDEToolbarLogic pSDEToolbarLogic, PSDEToolbar pSDEToolbar) throws Exception {
        pSDEToolbarLogic.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSDEToolbarLogic.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected String onSyncDER1NData_PSDEToolbar(PSDEToolbar pSDEToolbar, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEToolbar(pSDEToolbar);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
            for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEToolbarLogic, (String)"PSDETOOLBARLOGICID", (String)""))) continue;
                this.remove(pSDEToolbarLogic);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEUIAction(PSDEToolbarLogic pSDEToolbarLogic, PSDEUIAction pSDEUIAction) throws Exception {
        pSDEToolbarLogic.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDEToolbarLogic.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEToolbarLogic pSDEToolbarLogic, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEToolbarLogic.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEToolbarLogic.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysViewLogic(PSDEToolbarLogic pSDEToolbarLogic, PSSysViewLogic pSSysViewLogic) throws Exception {
        pSDEToolbarLogic.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
        pSDEToolbarLogic.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSDEToolbarLogic pSDEToolbarLogic, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDEToolbarLogic.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDEToolbarLogic.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
        if (bl && pSDEToolbarLogic.getValidFlag() == null) {
            pSDEToolbarLogic.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDEToolbarLogic, bl);
        this.onFillEntityFullInfo_PSDE(pSDEToolbarLogic, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDEToolbarLogic, bl);
        this.onFillEntityFullInfo_PSDETBItem(pSDEToolbarLogic, bl);
        this.onFillEntityFullInfo_PSDEToolbar(pSDEToolbarLogic, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSDEToolbarLogic, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEToolbarLogic, bl);
        this.onFillEntityFullInfo_PSSysViewLogic(pSDEToolbarLogic, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSDEToolbarLogic, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
        if (pSDEToolbarLogic.isPSDEIdDirty()) {
            if (pSDEToolbarLogic.getPSDEId() != null) {
                if (pSDEToolbarLogic.getPSDEId() == null || pSDEToolbarLogic.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEToolbarLogic.getPSDE();
                    pSDEToolbarLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEToolbarLogic.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETBItem(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEToolbar(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewLogic(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEToolbarLogic, bl);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbarLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbarLogic> selectByPSDETBItem(PSDETBItemBase pSDETBItemBase) throws Exception {
        return this.selectByPSDETBItem(pSDETBItemBase, "", -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDETBItem(PSDETBItemBase pSDETBItemBase, String string) throws Exception {
        return this.selectByPSDETBItem(pSDETBItemBase, string, -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDETBItem(PSDETBItemBase pSDETBItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETBITEMID", (Object)pSDETBItemBase.getPSDETBItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETBItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETBItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEToolbarLogic> selectTempByPSDETBItem(PSDETBItemBase pSDETBItemBase) throws Exception {
        return this.selectTempByPSDETBItem(pSDETBItemBase, "");
    }

    public ArrayList<PSDEToolbarLogic> selectTempByPSDETBItem(PSDETBItemBase pSDETBItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETBITEMID", (Object)pSDETBItemBase.getPSDETBItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETBItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETBItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbarLogic> selectTempByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectTempByPSDEToolbar(pSDEToolbarBase, "");
    }

    public ArrayList<PSDEToolbarLogic> selectTempByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEToolbarCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbarLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbarLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, "", -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, string, -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbarLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDEToolbarLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBARLOGIC_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDETOOLBARLOGIC", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            PSDEToolbarLogic pSDEToolbarLogic2 = (PSDEToolbarLogic)this.getDEModel().createEntity();
            pSDEToolbarLogic2.setPSDEToolbarLogicId(pSDEToolbarLogic.getPSDEToolbarLogicId());
            pSDEToolbarLogic2.setPSDEId(null);
            this.update(pSDEToolbarLogic2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarLogicServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEToolbarLogicServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEToolbarLogicServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            this.remove(pSDEToolbarLogic);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBARLOGIC_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDETOOLBARLOGIC", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            PSDEToolbarLogic pSDEToolbarLogic2 = (PSDEToolbarLogic)this.getDEModel().createEntity();
            pSDEToolbarLogic2.setPSDEToolbarLogicId(pSDEToolbarLogic.getPSDEToolbarLogicId());
            pSDEToolbarLogic2.setPSDELogicId(null);
            this.update(pSDEToolbarLogic2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarLogicServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDEToolbarLogicServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDEToolbarLogicServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            this.remove(pSDEToolbarLogic);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDETBItem(pSDETBItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETBITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDETBItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBARLOGIC_PSDETBITEM_PSDETBITEMID", "", iDataEntityModel.getName(), "PSDETOOLBARLOGIC", iDataEntityModel.getDataInfo(pSDETBItem), arrayList.get(0)));
        }
    }

    public void resetPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDETBItem(pSDETBItem);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            PSDEToolbarLogic pSDEToolbarLogic2 = (PSDEToolbarLogic)this.getDEModel().createEntity();
            pSDEToolbarLogic2.setPSDEToolbarLogicId(pSDEToolbarLogic.getPSDEToolbarLogicId());
            pSDEToolbarLogic2.setPSDETBItemId(null);
            this.update(pSDEToolbarLogic2);
        }
    }

    public void resetTempPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectTempByPSDETBItem(pSDETBItem);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            PSDEToolbarLogic pSDEToolbarLogic2 = (PSDEToolbarLogic)this.getDEModel().createEntity();
            pSDEToolbarLogic2.setPSDEToolbarLogicId(pSDEToolbarLogic.getPSDEToolbarLogicId());
            pSDEToolbarLogic2.setPSDETBItemId(null);
            this.updateTemp(pSDEToolbarLogic2);
        }
    }

    public void removeByPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        final PSDETBItem pSDETBItem2 = pSDETBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarLogicServiceBase.this.onBeforeRemoveByPSDETBItem(pSDETBItem2);
                PSDEToolbarLogicServiceBase.this.internalRemoveByPSDETBItem(pSDETBItem2);
                PSDEToolbarLogicServiceBase.this.onAfterRemoveByPSDETBItem(pSDETBItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
    }

    protected void internalRemoveByPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDETBItem(pSDETBItem);
        this.onBeforeRemoveByPSDETBItem(pSDETBItem, arrayList);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            this.remove(pSDEToolbarLogic);
        }
        this.onAfterRemoveByPSDETBItem(pSDETBItem, arrayList);
    }

    protected void onAfterRemoveByPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
    }

    protected void onBeforeRemoveByPSDETBItem(PSDETBItem pSDETBItem, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETBItem(PSDETBItem pSDETBItem, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    public void resetPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            PSDEToolbarLogic pSDEToolbarLogic2 = (PSDEToolbarLogic)this.getDEModel().createEntity();
            pSDEToolbarLogic2.setPSDEToolbarLogicId(pSDEToolbarLogic.getPSDEToolbarLogicId());
            pSDEToolbarLogic2.setPSDEToolbarId(null);
            this.update(pSDEToolbarLogic2);
        }
    }

    public void resetTempPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectTempByPSDEToolbar(pSDEToolbar);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            PSDEToolbarLogic pSDEToolbarLogic2 = (PSDEToolbarLogic)this.getDEModel().createEntity();
            pSDEToolbarLogic2.setPSDEToolbarLogicId(pSDEToolbarLogic.getPSDEToolbarLogicId());
            pSDEToolbarLogic2.setPSDEToolbarId(null);
            this.updateTemp(pSDEToolbarLogic2);
        }
    }

    public void removeByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarLogicServiceBase.this.onBeforeRemoveByPSDEToolbar(pSDEToolbar2);
                PSDEToolbarLogicServiceBase.this.internalRemoveByPSDEToolbar(pSDEToolbar2);
                PSDEToolbarLogicServiceBase.this.onAfterRemoveByPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            this.remove(pSDEToolbarLogic);
        }
        this.onAfterRemoveByPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBARLOGIC_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDETOOLBARLOGIC", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            PSDEToolbarLogic pSDEToolbarLogic2 = (PSDEToolbarLogic)this.getDEModel().createEntity();
            pSDEToolbarLogic2.setPSDEToolbarLogicId(pSDEToolbarLogic.getPSDEToolbarLogicId());
            pSDEToolbarLogic2.setPSDEUIActionId(null);
            this.update(pSDEToolbarLogic2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarLogicServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEToolbarLogicServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEToolbarLogicServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            this.remove(pSDEToolbarLogic);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBARLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDETOOLBARLOGIC", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            PSDEToolbarLogic pSDEToolbarLogic2 = (PSDEToolbarLogic)this.getDEModel().createEntity();
            pSDEToolbarLogic2.setPSDEToolbarLogicId(pSDEToolbarLogic.getPSDEToolbarLogicId());
            pSDEToolbarLogic2.setPSSysPFPluginId(null);
            this.update(pSDEToolbarLogic2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarLogicServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEToolbarLogicServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEToolbarLogicServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            this.remove(pSDEToolbarLogic);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBARLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", "", iDataEntityModel.getName(), "PSDETOOLBARLOGIC", iDataEntityModel.getDataInfo(pSSysViewLogic), arrayList.get(0)));
        }
    }

    public void resetPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            PSDEToolbarLogic pSDEToolbarLogic2 = (PSDEToolbarLogic)this.getDEModel().createEntity();
            pSDEToolbarLogic2.setPSDEToolbarLogicId(pSDEToolbarLogic.getPSDEToolbarLogicId());
            pSDEToolbarLogic2.setPSSysViewLogicId(null);
            this.update(pSDEToolbarLogic2);
        }
    }

    public void removeByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarLogicServiceBase.this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDEToolbarLogicServiceBase.this.internalRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDEToolbarLogicServiceBase.this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            this.remove(pSDEToolbarLogic);
        }
        this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBARLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDETOOLBARLOGIC", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            PSDEToolbarLogic pSDEToolbarLogic2 = (PSDEToolbarLogic)this.getDEModel().createEntity();
            pSDEToolbarLogic2.setPSDEToolbarLogicId(pSDEToolbarLogic.getPSDEToolbarLogicId());
            pSDEToolbarLogic2.setPSSysViewPanelId(null);
            this.update(pSDEToolbarLogic2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarLogicServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEToolbarLogicServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEToolbarLogicServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            this.remove(pSDEToolbarLogic);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEToolbarLogic pSDEToolbarLogic) throws Exception {
        super.onBeforeRemove(pSDEToolbarLogic);
    }

    public void removeTempByPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        final PSDETBItem pSDETBItem2 = pSDETBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarLogicServiceBase.this.onBeforeRemoveTempByPSDETBItem(pSDETBItem2);
                PSDEToolbarLogicServiceBase.this.internalRemoveTempByPSDETBItem(pSDETBItem2);
                PSDEToolbarLogicServiceBase.this.onAfterRemoveTempByPSDETBItem(pSDETBItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
    }

    protected void internalRemoveTempByPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectTempByPSDETBItem(pSDETBItem);
        this.onBeforeRemoveTempByPSDETBItem(pSDETBItem, arrayList);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            this.removeTemp(pSDEToolbarLogic);
        }
        this.onAfterRemoveTempByPSDETBItem(pSDETBItem, arrayList);
    }

    protected void onAfterRemoveTempByPSDETBItem(PSDETBItem pSDETBItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETBItem(PSDETBItem pSDETBItem, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETBItem(PSDETBItem pSDETBItem, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    public void removeTempByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarLogicServiceBase.this.onBeforeRemoveTempByPSDEToolbar(pSDEToolbar2);
                PSDEToolbarLogicServiceBase.this.internalRemoveTempByPSDEToolbar(pSDEToolbar2);
                PSDEToolbarLogicServiceBase.this.onAfterRemoveTempByPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveTempByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.selectTempByPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveTempByPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            this.removeTemp(pSDEToolbarLogic);
        }
        this.onAfterRemoveTempByPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveTempByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEToolbarLogic pSDEToolbarLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEToolbarLogic, cloneSession);
        if (pSDEToolbarLogic.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEToolbarLogic.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEToolbarLogic, (PSDataEntity)iEntity);
        }
        if (pSDEToolbarLogic.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEToolbarLogic.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDEToolbarLogic, (PSDELogic)iEntity);
        }
        if (pSDEToolbarLogic.getPSDETBItemId() != null && (iEntity = cloneSession.getEntity("PSDETBITEM", (Object)pSDEToolbarLogic.getPSDETBItemId())) != null) {
            this.onFillParentInfo_PSDETBItem(pSDEToolbarLogic, (PSDETBItem)iEntity);
        }
        if (pSDEToolbarLogic.getPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDEToolbarLogic.getPSDEToolbarId())) != null) {
            this.onFillParentInfo_PSDEToolbar(pSDEToolbarLogic, (PSDEToolbar)iEntity);
        }
        if (pSDEToolbarLogic.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDEToolbarLogic.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSDEToolbarLogic, (PSDEUIAction)iEntity);
        }
        if (pSDEToolbarLogic.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEToolbarLogic.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEToolbarLogic, (PSSysPFPlugin)iEntity);
        }
        if (pSDEToolbarLogic.getPSSysViewLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWLOGIC", (Object)pSDEToolbarLogic.getPSSysViewLogicId())) != null) {
            this.onFillParentInfo_PSSysViewLogic(pSDEToolbarLogic, (PSSysViewLogic)iEntity);
        }
        if (pSDEToolbarLogic.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDEToolbarLogic.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSDEToolbarLogic, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEToolbarLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AttrName(bl, pSDEToolbarLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstLogicType(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg2(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventNames(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam2(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETBItemId(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarId(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarLogicId(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarLogicName(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewLogicId(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timer(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TriggerType(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEToolbarLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEToolbarLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AttrName(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isAttrNameDirty() : !pSDEToolbarLogic.isAttrNameDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getAttrName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrName_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isCustomCodeDirty() : !pSDEToolbarLogic.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstLogicType(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isDstLogicTypeDirty() && !bl2 : !pSDEToolbarLogic.isDstLogicTypeDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getDstLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTLOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstLogicType_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventArg(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isEventArgDirty() : !pSDEToolbarLogic.isEventArgDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getEventArg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventArg2(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isEventArg2Dirty() : !pSDEToolbarLogic.isEventArg2Dirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getEventArg2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg2_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventNames(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isEventNamesDirty() : !pSDEToolbarLogic.isEventNamesDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getEventNames();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventNames_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicParam(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isLogicParamDirty() : !pSDEToolbarLogic.isLogicParamDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getLogicParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicParam2(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isLogicParam2Dirty() : !pSDEToolbarLogic.isLogicParam2Dirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getLogicParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam2_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isMemoDirty() : !pSDEToolbarLogic.isMemoDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isOrderValueDirty() : !pSDEToolbarLogic.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEToolbarLogic.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSDEIdDirty() : !pSDEToolbarLogic.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSDELogicIdDirty() : !pSDEToolbarLogic.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSDENameDirty() : !pSDEToolbarLogic.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETBItemId(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSDETBItemIdDirty() : !pSDEToolbarLogic.isPSDETBItemIdDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSDETBItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETBItemId_Default(pSDEToolbarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETBITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEToolbarId(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSDEToolbarIdDirty() && !bl2 : !pSDEToolbarLogic.isPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSDEToolbarId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarId_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEToolbarLogicId(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSDEToolbarLogicIdDirty() && !bl2 : !pSDEToolbarLogic.isPSDEToolbarLogicIdDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSDEToolbarLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarLogicId_Default(pSDEToolbarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEToolbarLogicName(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSDEToolbarLogicNameDirty() && !bl2 : !pSDEToolbarLogic.isPSDEToolbarLogicNameDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSDEToolbarLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARLOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarLogicName_Default(pSDEToolbarLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARLOGICNAME");
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
                string3 = "PSDETOOLBARID";
                String string4 = this.checkFieldDupRule(this.getPSDEToolbarLogicDEModel(), "PSDETOOLBARLOGICNAME", string3, pSDEToolbarLogic, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDETOOLBARLOGICNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSDEUIActionIdDirty() : !pSDEToolbarLogic.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSSysPFPluginIdDirty() : !pSDEToolbarLogic.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewLogicId(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSSysViewLogicIdDirty() : !pSDEToolbarLogic.isPSSysViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSSysViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewLogicId_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isPSSysViewPanelIdDirty() : !pSDEToolbarLogic.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_Timer(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isTimerDirty() : !pSDEToolbarLogic.isTimerDirty()) {
            return null;
        }
        Integer n = pSDEToolbarLogic.getTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timer_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_TriggerType(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isTriggerTypeDirty() && !bl2 : !pSDEToolbarLogic.isTriggerTypeDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getTriggerType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRIGGERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TriggerType_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isUserCatDirty() : !pSDEToolbarLogic.isUserCatDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isUserTagDirty() : !pSDEToolbarLogic.isUserTagDirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isUserTag2Dirty() : !pSDEToolbarLogic.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isUserTag3Dirty() : !pSDEToolbarLogic.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isUserTag4Dirty() : !pSDEToolbarLogic.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEToolbarLogic.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEToolbarLogic pSDEToolbarLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbarLogic.isValidFlagDirty() && !bl2 : !pSDEToolbarLogic.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEToolbarLogic.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEToolbarLogic, bl2, bl3);
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

    protected void onSyncEntity(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSDEToolbarLogic, bl);
    }

    protected void onSyncIndexEntities(PSDEToolbarLogic pSDEToolbarLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEToolbarLogic, bl);
    }

    public Object getDataContextValue(PSDEToolbarLogic pSDEToolbarLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEToolbarLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEToolbar pSDEToolbar = pSDEToolbarLogic.getPSDEToolbar();
        if (pSDEToolbar != null && pSDEToolbar.contains(string)) {
            return pSDEToolbar.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEToolbarLogic pSDEToolbarLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEToolbarLogic, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDETBITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETBItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETBITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETBItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDETBItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETBITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETBItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETBITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEToolbarLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETOOLBARLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEToolbarLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETOOLBARLOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSDETOOLBARLOGICNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected boolean onMergeChild(String string, String string2, PSDEToolbarLogic pSDEToolbarLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEToolbarLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEToolbarLogic pSDEToolbarLogic) throws Exception {
        super.onUpdateParent(pSDEToolbarLogic);
    }

    @Override
    protected void exportCurXmlModel(PSDEToolbarLogic pSDEToolbarLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETOOLBARLOGIC");
        if (!bl) {
            pSDEToolbarLogic.setCreateDate(null);
            pSDEToolbarLogic.setCreateMan(null);
            pSDEToolbarLogic.setPSDEToolbarLogicId(null);
            pSDEToolbarLogic.setUpdateDate(null);
            pSDEToolbarLogic.setUpdateMan(null);
            pSDEToolbarLogic.setPSDETBItemId(null);
            pSDEToolbarLogic.setPSDEToolbarId(null);
            pSDEToolbarLogic.setPSDEToolbarName(null);
            super.exportCurXmlModel(pSDEToolbarLogic, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEToolbarLogic pSDEToolbarLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEToolbarLogic, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETOOLBARID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDETOOLBAR#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETOOLBARID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETOOLBARLOGIC_PSDETOOLBAR_PSDETOOLBARID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETOOLBARID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETOOLBARNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDETOOLBAR", (boolean)true) == 0) {
            iEntity.set("PSDETOOLBARID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDETOOLBARID"};
    }

    @Override
    public String getModelV2Tag(PSDEToolbarLogic pSDEToolbarLogic) {
        if (!StringHelper.isNullOrEmpty((String)pSDEToolbarLogic.getPSDEToolbarLogicName())) {
            return pSDEToolbarLogic.getPSDEToolbarLogicName();
        }
        return super.getModelV2Tag(pSDEToolbarLogic);
    }

    @Override
    public boolean setModelV2Tag(PSDEToolbarLogic pSDEToolbarLogic, String string) {
        pSDEToolbarLogic.setPSDEToolbarLogicName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDETOOLBARLOGICNAME", "");
        map.put("PSDETOOLBARID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEToolbarLogic pSDEToolbarLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEToolbarLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEToolbarLogic, true);
        pSDEToolbarLogic.set("PSDETOOLBARLOGICNAME", string);
        if (this.select(pSDEToolbarLogic, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEToolbarLogic, true);
        return super.getModelV2Entity(pSDEToolbarLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEToolbarLogic pSDEToolbarLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEToolbarLogic, objectNode, string, string2, n);
    }
}

