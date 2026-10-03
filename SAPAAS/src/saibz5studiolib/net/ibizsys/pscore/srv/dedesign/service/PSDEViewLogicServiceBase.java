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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEViewLogicDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewLogicDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrlBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogicBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
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

public abstract class PSDEViewLogicServiceBase
extends PSCoreSysServiceBase<PSDEViewLogic> {
    private static final Log log = LogFactory.getLog(PSDEViewLogicServiceBase.class);
    public static final String DATASET_CURVIEW = "CurView";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEViewLogicDEModel pSDEViewLogicDEModel;
    private PSDEViewLogicDAO pSDEViewLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService";
    }

    public PSDEViewLogicDEModel getPSDEViewLogicDEModel() {
        if (this.pSDEViewLogicDEModel == null) {
            try {
                this.pSDEViewLogicDEModel = (PSDEViewLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEViewLogicDEModel();
    }

    public PSDEViewLogicDAO getPSDEViewLogicDAO() {
        if (this.pSDEViewLogicDAO == null) {
            try {
                this.pSDEViewLogicDAO = (PSDEViewLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEViewLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEViewLogicDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURVIEW, (boolean)true) == 0) {
            return this.fetchCurView(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURVIEW, (boolean)true) == 0) {
            return this.fetchTempCurView(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVIEW, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVIEW, true);
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

    protected void onFillParentInfo(PSDEViewLogic pSDEViewLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWLOGIC_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDEViewLogic, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWLOGIC_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSDEViewLogic, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWLOGIC_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSDEViewLogic, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWLOGIC_PSDEVIEWCTRL_PARAMPSDEVIEWCTRLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService", (SessionFactory)this.getSessionFactory());
            PSDEViewCtrl pSDEViewCtrl = (PSDEViewCtrl)iService.getDEModel().createEntity();
            pSDEViewCtrl.set("PSDEVIEWCTRLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewCtrl);
            } else {
                iService.get(pSDEViewCtrl);
            }
            this.onFillParentInfo_ParamPSDEViewCtrl(pSDEViewLogic, pSDEViewCtrl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWLOGIC_PSDEVIEWCTRL_PSDEVIEWCTRLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService", (SessionFactory)this.getSessionFactory());
            PSDEViewCtrl pSDEViewCtrl = (PSDEViewCtrl)iService.getDEModel().createEntity();
            pSDEViewCtrl.set("PSDEVIEWCTRLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewCtrl);
            } else {
                iService.get(pSDEViewCtrl);
            }
            this.onFillParentInfo_PSDEViewCtrl(pSDEViewLogic, pSDEViewCtrl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWLOGIC_PSDEVIEWLOGIC_REFPSDEVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService", (SessionFactory)this.getSessionFactory());
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)iService.getDEModel().createEntity();
            pSDEViewLogic2.set("PSDEVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewLogic2);
            } else {
                iService.get(pSDEViewLogic2);
            }
            this.onFillParentInfo_RefPSDEViewLogic(pSDEViewLogic, pSDEViewLogic2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEViewLogic, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewLogic pSSysViewLogic = (PSSysViewLogic)iService.getDEModel().createEntity();
            pSSysViewLogic.set("PSSYSVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewLogic);
            } else {
                iService.get(pSSysViewLogic);
            }
            this.onFillParentInfo_PSSysViewLogic(pSDEViewLogic, pSSysViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSDEViewLogic, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSDEViewLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDELogic(PSDEViewLogic pSDEViewLogic, PSDELogic pSDELogic) throws Exception {
        pSDEViewLogic.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEViewLogic.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSDEViewLogic pSDEViewLogic, PSDEUIAction pSDEUIAction) throws Exception {
        pSDEViewLogic.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDEViewLogic.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSDEViewBase(PSDEViewLogic pSDEViewLogic, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEViewLogic.setPSDEId(pSDEViewBase.getPSDEId());
        pSDEViewLogic.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewLogic.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_ParamPSDEViewCtrl(PSDEViewLogic pSDEViewLogic, PSDEViewCtrl pSDEViewCtrl) throws Exception {
        pSDEViewLogic.setParamPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
        pSDEViewLogic.setParamPSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
    }

    protected void onFillParentInfo_PSDEViewCtrl(PSDEViewLogic pSDEViewLogic, PSDEViewCtrl pSDEViewCtrl) throws Exception {
        pSDEViewLogic.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
        pSDEViewLogic.setPSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
    }

    protected void onFillParentInfo_RefPSDEViewLogic(PSDEViewLogic pSDEViewLogic, PSDEViewLogic pSDEViewLogic2) throws Exception {
        pSDEViewLogic.setRefPSDEViewLogicId(pSDEViewLogic2.getPSDEViewLogicId());
        pSDEViewLogic.setRefPSDEViewLogicName(pSDEViewLogic2.getPSDEViewLogicName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEViewLogic pSDEViewLogic, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEViewLogic.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEViewLogic.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysViewLogic(PSDEViewLogic pSDEViewLogic, PSSysViewLogic pSSysViewLogic) throws Exception {
        pSDEViewLogic.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
        pSDEViewLogic.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSDEViewLogic pSDEViewLogic, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDEViewLogic.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDEViewLogic.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
        if (bl && pSDEViewLogic.getValidFlag() == null) {
            pSDEViewLogic.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDEViewLogic, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDEViewLogic, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSDEViewLogic, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSDEViewLogic, bl);
        this.onFillEntityFullInfo_ParamPSDEViewCtrl(pSDEViewLogic, bl);
        this.onFillEntityFullInfo_PSDEViewCtrl(pSDEViewLogic, bl);
        this.onFillEntityFullInfo_RefPSDEViewLogic(pSDEViewLogic, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEViewLogic, bl);
        this.onFillEntityFullInfo_PSSysViewLogic(pSDEViewLogic, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSDEViewLogic, bl);
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ParamPSDEViewCtrl(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewCtrl(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDEViewLogic(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewLogic(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEViewLogic, bl);
    }

    public ArrayList<PSDEViewLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewLogic> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewLogic> selectTempByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectTempByPSDEViewBase(pSDEViewBaseBase, "");
    }

    public ArrayList<PSDEViewLogic> selectTempByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEViewBaseCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewLogic> selectByParamPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectByParamPSDEViewCtrl(pSDEViewCtrlBase, "", -1);
    }

    public ArrayList<PSDEViewLogic> selectByParamPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        return this.selectByParamPSDEViewCtrl(pSDEViewCtrlBase, string, -1);
    }

    public ArrayList<PSDEViewLogic> selectByParamPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PARAMPSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByParamPSDEViewCtrlCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByParamPSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewLogic> selectTempByParamPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectTempByParamPSDEViewCtrl(pSDEViewCtrlBase, "");
    }

    public ArrayList<PSDEViewLogic> selectTempByParamPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PARAMPSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByParamPSDEViewCtrlCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByParamPSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewLogic> selectByPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectByPSDEViewCtrl(pSDEViewCtrlBase, "", -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        return this.selectByPSDEViewCtrl(pSDEViewCtrlBase, string, -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewCtrlCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewLogic> selectTempByPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectTempByPSDEViewCtrl(pSDEViewCtrlBase, "");
    }

    public ArrayList<PSDEViewLogic> selectTempByPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEViewCtrlCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewLogic> selectByRefPSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase) throws Exception {
        return this.selectByRefPSDEViewLogic(pSDEViewLogicBase, "", -1);
    }

    public ArrayList<PSDEViewLogic> selectByRefPSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string) throws Exception {
        return this.selectByRefPSDEViewLogic(pSDEViewLogicBase, string, -1);
    }

    public ArrayList<PSDEViewLogic> selectByRefPSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEVIEWLOGICID", (Object)pSDEViewLogicBase.getPSDEViewLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEViewLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, "", -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, string, -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDEViewLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWLOGIC_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDEVIEWLOGIC", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setPSDELogicId(null);
            this.update(pSDEViewLogic2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDEViewLogicServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDEViewLogicServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.remove(pSDEViewLogic);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWLOGIC_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDEVIEWLOGIC", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setPSDEUIActionId(null);
            this.update(pSDEViewLogic2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEViewLogicServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEViewLogicServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.remove(pSDEViewLogic);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setPSDEViewBaseId(null);
            this.update(pSDEViewLogic2);
        }
    }

    public void resetTempPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectTempByPSDEViewBase(pSDEViewBase);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setPSDEViewBaseId(null);
            this.updateTemp(pSDEViewLogic2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEViewLogicServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEViewLogicServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.remove(pSDEViewLogic);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByParamPSDEViewCtrl(pSDEViewCtrl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWCTRL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewCtrl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWLOGIC_PSDEVIEWCTRL_PARAMPSDEVIEWCTRLID", "", iDataEntityModel.getName(), "PSDEVIEWLOGIC", iDataEntityModel.getDataInfo(pSDEViewCtrl), arrayList.get(0)));
        }
    }

    public void resetParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByParamPSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setParamPSDEViewCtrlId(null);
            this.update(pSDEViewLogic2);
        }
    }

    public void resetTempParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectTempByParamPSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setParamPSDEViewCtrlId(null);
            this.updateTemp(pSDEViewLogic2);
        }
    }

    public void removeByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveByParamPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewLogicServiceBase.this.internalRemoveByParamPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewLogicServiceBase.this.onAfterRemoveByParamPSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByParamPSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveByParamPSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.remove(pSDEViewLogic);
        }
        this.onAfterRemoveByParamPSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDEViewCtrl(pSDEViewCtrl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWCTRL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewCtrl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWLOGIC_PSDEVIEWCTRL_PSDEVIEWCTRLID", "", iDataEntityModel.getName(), "PSDEVIEWLOGIC", iDataEntityModel.getDataInfo(pSDEViewCtrl), arrayList.get(0)));
        }
    }

    public void resetPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setPSDEViewCtrlId(null);
            this.update(pSDEViewLogic2);
        }
    }

    public void resetTempPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectTempByPSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setPSDEViewCtrlId(null);
            this.updateTemp(pSDEViewLogic2);
        }
    }

    public void removeByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveByPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewLogicServiceBase.this.internalRemoveByPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewLogicServiceBase.this.onAfterRemoveByPSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveByPSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.remove(pSDEViewLogic);
        }
        this.onAfterRemoveByPSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByRefPSDEViewLogic(pSDEViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWLOGIC_PSDEVIEWLOGIC_REFPSDEVIEWLOGICID", "", iDataEntityModel.getName(), "PSDEVIEWLOGIC", iDataEntityModel.getDataInfo(pSDEViewLogic), arrayList.get(0)));
        }
    }

    public void resetRefPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByRefPSDEViewLogic(pSDEViewLogic);
        for (PSDEViewLogic pSDEViewLogic2 : arrayList) {
            PSDEViewLogic pSDEViewLogic3 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic3.setPSDEViewLogicId(pSDEViewLogic2.getPSDEViewLogicId());
            pSDEViewLogic3.setRefPSDEViewLogicId(null);
            this.update(pSDEViewLogic3);
        }
    }

    public void removeByRefPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        final PSDEViewLogic pSDEViewLogic2 = pSDEViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveByRefPSDEViewLogic(pSDEViewLogic2);
                PSDEViewLogicServiceBase.this.internalRemoveByRefPSDEViewLogic(pSDEViewLogic2);
                PSDEViewLogicServiceBase.this.onAfterRemoveByRefPSDEViewLogic(pSDEViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void internalRemoveByRefPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByRefPSDEViewLogic(pSDEViewLogic);
        this.onBeforeRemoveByRefPSDEViewLogic(pSDEViewLogic, arrayList);
        for (PSDEViewLogic pSDEViewLogic2 : arrayList) {
            this.remove(pSDEViewLogic2);
        }
        this.onAfterRemoveByRefPSDEViewLogic(pSDEViewLogic, arrayList);
    }

    protected void onAfterRemoveByRefPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEVIEWLOGIC", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setPSSysPFPluginId(null);
            this.update(pSDEViewLogic2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEViewLogicServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEViewLogicServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.remove(pSDEViewLogic);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", "", iDataEntityModel.getName(), "PSDEVIEWLOGIC", iDataEntityModel.getDataInfo(pSSysViewLogic), arrayList.get(0)));
        }
    }

    public void resetPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setPSSysViewLogicId(null);
            this.update(pSDEViewLogic2);
        }
    }

    public void removeByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDEViewLogicServiceBase.this.internalRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDEViewLogicServiceBase.this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.remove(pSDEViewLogic);
        }
        this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDEVIEWLOGIC", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            PSDEViewLogic pSDEViewLogic2 = (PSDEViewLogic)this.getDEModel().createEntity();
            pSDEViewLogic2.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
            pSDEViewLogic2.setPSSysViewPanelId(null);
            this.update(pSDEViewLogic2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEViewLogicServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEViewLogicServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.remove(pSDEViewLogic);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEViewLogic pSDEViewLogic) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSDEViewLogic(pSDEViewLogic);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo3PSDEViewLogic(pSDEViewLogic);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo4PSDEViewLogic(pSDEViewLogic);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewLogic(pSDEViewLogic);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEViewLogic(pSDEViewLogic);
        super.onBeforeRemove(pSDEViewLogic);
    }

    protected void onBeforeRemoveTemp(PSDEViewLogic pSDEViewLogic) throws Exception {
        PSDEViewEngineService pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        pSDEViewEngineService.resetTempPSDEViewLogic(pSDEViewLogic);
        pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        pSDEViewEngineService.resetTempNo4PSDEViewLogic(pSDEViewLogic);
        pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        pSDEViewEngineService.resetTempNo3PSDEViewLogic(pSDEViewLogic);
        pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        pSDEViewEngineService.resetTempNo2PSDEViewLogic(pSDEViewLogic);
        super.onBeforeRemoveTemp(pSDEViewLogic);
    }

    public void removeTempByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveTempByParamPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewLogicServiceBase.this.internalRemoveTempByParamPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewLogicServiceBase.this.onAfterRemoveTempByParamPSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveTempByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveTempByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectTempByParamPSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveTempByParamPSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.removeTemp(pSDEViewLogic);
        }
        this.onAfterRemoveTempByParamPSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveTempByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveTempByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByParamPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    public void removeTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveTempByPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewLogicServiceBase.this.internalRemoveTempByPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewLogicServiceBase.this.onAfterRemoveTempByPSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectTempByPSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveTempByPSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.removeTemp(pSDEViewLogic);
        }
        this.onAfterRemoveTempByPSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    public void removeTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewLogicServiceBase.this.onBeforeRemoveTempByPSDEViewBase(pSDEViewBase2);
                PSDEViewLogicServiceBase.this.internalRemoveTempByPSDEViewBase(pSDEViewBase2);
                PSDEViewLogicServiceBase.this.onAfterRemoveTempByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewLogic> arrayList = this.selectTempByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveTempByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            this.removeTemp(pSDEViewLogic);
        }
        this.onAfterRemoveTempByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewLogic> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEViewLogic pSDEViewLogic) throws Exception {
        super.getRelatedDataTempMajor(pSDEViewLogic);
    }

    protected void updateRelatedDataTempMajor(PSDEViewLogic pSDEViewLogic, PSDEViewLogic pSDEViewLogic2) throws Exception {
        super.updateRelatedDataTempMajor(pSDEViewLogic, pSDEViewLogic2);
    }

    protected void replaceParentInfo(PSDEViewLogic pSDEViewLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEViewLogic, cloneSession);
        if (pSDEViewLogic.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEViewLogic.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDEViewLogic, (PSDELogic)iEntity);
        }
        if (pSDEViewLogic.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDEViewLogic.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSDEViewLogic, (PSDEUIAction)iEntity);
        }
        if (pSDEViewLogic.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEViewLogic.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSDEViewLogic, (PSDEViewBase)iEntity);
        }
        if (pSDEViewLogic.getParamPSDEViewCtrlId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWCTRL", (Object)pSDEViewLogic.getParamPSDEViewCtrlId())) != null) {
            this.onFillParentInfo_ParamPSDEViewCtrl(pSDEViewLogic, (PSDEViewCtrl)iEntity);
        }
        if (pSDEViewLogic.getPSDEViewCtrlId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWCTRL", (Object)pSDEViewLogic.getPSDEViewCtrlId())) != null) {
            this.onFillParentInfo_PSDEViewCtrl(pSDEViewLogic, (PSDEViewCtrl)iEntity);
        }
        if (pSDEViewLogic.getRefPSDEViewLogicId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWLOGIC", (Object)pSDEViewLogic.getRefPSDEViewLogicId())) != null) {
            this.onFillParentInfo_RefPSDEViewLogic(pSDEViewLogic, (PSDEViewLogic)iEntity);
        }
        if (pSDEViewLogic.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEViewLogic.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEViewLogic, (PSSysPFPlugin)iEntity);
        }
        if (pSDEViewLogic.getPSSysViewLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWLOGIC", (Object)pSDEViewLogic.getPSSysViewLogicId())) != null) {
            this.onFillParentInfo_PSSysViewLogic(pSDEViewLogic, (PSSysViewLogic)iEntity);
        }
        if (pSDEViewLogic.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDEViewLogic.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSDEViewLogic, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEViewLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AttrName(bl, pSDEViewLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstLogicType(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg2(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventNames(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam2(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamPSDEViewCtrlId(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlId(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewLogicId(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewLogicName(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewLogicType(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewLogicId(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEViewLogicId(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timer(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEViewLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AttrName(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isAttrNameDirty() : !pSDEViewLogic.isAttrNameDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getAttrName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrName_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isCustomCodeDirty() : !pSDEViewLogic.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstLogicType(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isDstLogicTypeDirty() && !bl2 : !pSDEViewLogic.isDstLogicTypeDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getDstLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTLOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstLogicType_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventArg(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isEventArgDirty() : !pSDEViewLogic.isEventArgDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getEventArg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventArg2(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isEventArg2Dirty() : !pSDEViewLogic.isEventArg2Dirty()) {
            return null;
        }
        String string = pSDEViewLogic.getEventArg2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg2_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_EventNames(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isEventNamesDirty() : !pSDEViewLogic.isEventNamesDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getEventNames();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventNames_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicParam(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isLogicParamDirty() : !pSDEViewLogic.isLogicParamDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getLogicParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicParam2(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isLogicParam2Dirty() : !pSDEViewLogic.isLogicParam2Dirty()) {
            return null;
        }
        String string = pSDEViewLogic.getLogicParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam2_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isMemoDirty() : !pSDEViewLogic.isMemoDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isOrderValueDirty() : !pSDEViewLogic.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEViewLogic.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamPSDEViewCtrlId(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isParamPSDEViewCtrlIdDirty() : !pSDEViewLogic.isParamPSDEViewCtrlIdDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getParamPSDEViewCtrlId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamPSDEViewCtrlId_Default(pSDEViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMPSDEVIEWCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isPSDELogicIdDirty() : !pSDEViewLogic.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isPSDEUIActionIdDirty() : !pSDEViewLogic.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isPSDEViewBaseIdDirty() && !bl2 : !pSDEViewLogic.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getPSDEViewBaseId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewCtrlId(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isPSDEViewCtrlIdDirty() : !pSDEViewLogic.isPSDEViewCtrlIdDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getPSDEViewCtrlId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlId_Default(pSDEViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewLogicId(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isPSDEViewLogicIdDirty() && !bl2 : !pSDEViewLogic.isPSDEViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getPSDEViewLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewLogicId_Default(pSDEViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewLogicName(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isPSDEViewLogicNameDirty() && !bl2 : !pSDEViewLogic.isPSDEViewLogicNameDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getPSDEViewLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWLOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewLogicName_Default(pSDEViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVIEWBASEID";
                String string4 = this.checkFieldDupRule(this.getPSDEViewLogicDEModel(), "PSDEVIEWLOGICNAME", string3, pSDEViewLogic, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVIEWLOGICNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewLogicType(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isPSDEViewLogicTypeDirty() && !bl2 : !pSDEViewLogic.isPSDEViewLogicTypeDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getPSDEViewLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWLOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewLogicType_Default(pSDEViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWLOGICTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isPSSysPFPluginIdDirty() : !pSDEViewLogic.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewLogicId(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isPSSysViewLogicIdDirty() : !pSDEViewLogic.isPSSysViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getPSSysViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewLogicId_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isPSSysViewPanelIdDirty() : !pSDEViewLogic.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEViewLogicId(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isRefPSDEViewLogicIdDirty() : !pSDEViewLogic.isRefPSDEViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getRefPSDEViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEViewLogicId_Default(pSDEViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Timer(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isTimerDirty() : !pSDEViewLogic.isTimerDirty()) {
            return null;
        }
        Integer n = pSDEViewLogic.getTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timer_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isUserCatDirty() : !pSDEViewLogic.isUserCatDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isUserTagDirty() : !pSDEViewLogic.isUserTagDirty()) {
            return null;
        }
        String string = pSDEViewLogic.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isUserTag2Dirty() : !pSDEViewLogic.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEViewLogic.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isUserTag3Dirty() : !pSDEViewLogic.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEViewLogic.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isUserTag4Dirty() : !pSDEViewLogic.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEViewLogic.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEViewLogic pSDEViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewLogic.isValidFlagDirty() : !pSDEViewLogic.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewLogic.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEViewLogic, bl2, bl3);
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

    protected void onSyncEntity(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSDEViewLogic, bl);
    }

    protected void onSyncIndexEntities(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEViewLogic, bl);
    }

    public Object getDataContextValue(PSDEViewLogic pSDEViewLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEViewLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEViewBase pSDEViewBase = pSDEViewLogic.getPSDEViewBase();
        if (pSDEViewBase != null && pSDEViewBase.contains(string)) {
            return pSDEViewBase.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEViewLogic pSDEViewLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEViewLogic, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PARAMPSDEVIEWCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamPSDEViewCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMPSDEVIEWCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamPSDEViewCtrlName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWLOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewLogicType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"REFPSDEVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Timer_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("DSTLOGICTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_ParamPSDEViewCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMPSDEVIEWCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamPSDEViewCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMPSDEVIEWCTRLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PSDEViewCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWLOGICNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("PSDEVIEWLOGICNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewLogicType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWLOGICTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_RefPSDEViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVIEWLOGICNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Timer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEViewLogic pSDEViewLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEViewLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEViewLogic pSDEViewLogic) throws Exception {
        super.onUpdateParent(pSDEViewLogic);
    }

    @Override
    protected void exportCurXmlModel(PSDEViewLogic pSDEViewLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVIEWLOGIC");
        if (!bl) {
            pSDEViewLogic.setCreateDate(null);
            pSDEViewLogic.setCreateMan(null);
            pSDEViewLogic.setParamPSDEViewCtrlName(null);
            pSDEViewLogic.setPSDEViewLogicId(null);
            pSDEViewLogic.setRefPSDEViewLogicName(null);
            pSDEViewLogic.setUpdateDate(null);
            pSDEViewLogic.setUpdateMan(null);
            pSDEViewLogic.setParamPSDEViewCtrlId(null);
            pSDEViewLogic.setPSDEViewCtrlId(null);
            pSDEViewLogic.setPSDEId(null);
            pSDEViewLogic.setPSDEViewBaseId(null);
            pSDEViewLogic.setPSDEViewBaseName(null);
            super.exportCurXmlModel(pSDEViewLogic, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEViewLogic pSDEViewLogic, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEViewLogic, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEViewLogic pSDEViewLogic, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEViewLogic, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEViewLogic pSDEViewLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEViewLogic, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEVIEWLOGIC_PSDEVIEWBASE_PSDEVIEWBASEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASE", (boolean)true) == 0) {
            iEntity.set("PSDEVIEWBASEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEVIEWBASEID"};
    }

    @Override
    public String getModelV2Tag(PSDEViewLogic pSDEViewLogic) {
        if (!StringHelper.isNullOrEmpty((String)pSDEViewLogic.getPSDEViewLogicName())) {
            return pSDEViewLogic.getPSDEViewLogicName();
        }
        return super.getModelV2Tag(pSDEViewLogic);
    }

    @Override
    public boolean setModelV2Tag(PSDEViewLogic pSDEViewLogic, String string) {
        pSDEViewLogic.setPSDEViewLogicName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEVIEWLOGICNAME", "");
        map.put("PSDEVIEWBASEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEViewLogic pSDEViewLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEViewLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEViewLogic, true);
        pSDEViewLogic.set("PSDEVIEWLOGICNAME", string);
        if (this.select(pSDEViewLogic, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEViewLogic, true);
        return super.getModelV2Entity(pSDEViewLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEViewLogic pSDEViewLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEViewLogic, objectNode, string, string2, n);
    }
}

